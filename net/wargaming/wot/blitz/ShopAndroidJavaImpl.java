package net.wargaming.wot.blitz;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import net.wargaming.wot.util.IabException;
import net.wargaming.wot.util.IabResult;
import net.wargaming.wot.util.Inventory;
import net.wargaming.wot.util.Purchase;
import net.wargaming.wot.util.Security;
import net.wargaming.wot.util.SkuDetails;
import org.json.JSONException;

public class ShopAndroidJavaImpl
{
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
  public static final int IABHELPER_BAD_RESPONSE = -1002;
  public static final int IABHELPER_ERROR_BASE = -1000;
  public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
  public static final int IABHELPER_MISSING_TOKEN = -1007;
  public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
  public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
  public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
  public static final int IABHELPER_UNKNOWN_ERROR = -1008;
  public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
  public static final int IABHELPER_USER_CANCELLED = -1005;
  public static final int IABHELPER_VERIFICATION_FAILED = -1003;
  public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  public static final String ITEM_TYPE_INAPP = "inapp";
  public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
  public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  private Activity activity;
  private boolean disposed = false;
  private boolean initialized = false;
  private ActivityResultHandler mActivityResultHandler = null;
  private Context mContext;
  private boolean mDebugLog = true;
  private String mDebugTag = "DAVA";
  private IInAppBillingService mService;
  private ServiceConnection mServiceConn;
  private String mSignatureBase64 = null;
  private ExecutorService mTaskQueue = null;
  
  static
  {
    if (!ShopAndroidJavaImpl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ShopAndroidJavaImpl(Activity paramActivity, String paramString)
  {
    this.activity = paramActivity;
    this.mContext = paramActivity.getApplicationContext();
    this.mSignatureBase64 = paramString;
    this.mTaskQueue = Executors.newSingleThreadExecutor();
    logDebug("Starting in-app billing setup.");
    this.mServiceConn = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (ShopAndroidJavaImpl.this.disposed) {
          return;
        }
        ShopAndroidJavaImpl.this.logDebug("Billing service connected.");
        ShopAndroidJavaImpl.access$202(ShopAndroidJavaImpl.this, IInAppBillingService.Stub.asInterface(paramAnonymousIBinder));
        paramAnonymousComponentName = ShopAndroidJavaImpl.this.mContext.getPackageName();
        try
        {
          ShopAndroidJavaImpl.this.logDebug("Checking for in-app billing 3 support.");
          if (ShopAndroidJavaImpl.this.mService.isBillingSupported(3, paramAnonymousComponentName, "inapp") != 0)
          {
            ShopAndroidJavaImpl.this.logError("Error checking for billing v3 support.");
            return;
          }
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          ShopAndroidJavaImpl.this.logError("RemoteException while setting up in-app billing.");
          paramAnonymousComponentName.printStackTrace();
          return;
        }
        ShopAndroidJavaImpl.this.logDebug("In-app billing version 3 supported for " + paramAnonymousComponentName);
        ShopAndroidJavaImpl.access$502(ShopAndroidJavaImpl.this, true);
        ShopAndroidJavaImpl.this.onShopInitialized();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        ShopAndroidJavaImpl.this.logDebug("Billing service disconnected.");
        ShopAndroidJavaImpl.this.dispose();
      }
    };
    paramActivity = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    paramActivity.setPackage("com.android.vending");
    paramString = this.mContext.getPackageManager().queryIntentServices(paramActivity, 0);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.mContext.bindService(paramActivity, this.mServiceConn, 1);
      return;
    }
    this.mServiceConn = null;
    logError("Billing service unavailable on device.");
  }
  
  private void checkNotDisposed()
  {
    if (this.disposed) {
      throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
    }
  }
  
  public static String getResponseDesc(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= 64536)
    {
      int i = 64536 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length)) {
        return arrayOfString2[i];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  private void logDebug(String paramString)
  {
    if (this.mDebugLog) {
      Log.d(this.mDebugTag, paramString);
    }
  }
  
  private void logError(String paramString)
  {
    Log.e(this.mDebugTag, "In-app billing error: " + paramString);
  }
  
  private void logWarn(String paramString)
  {
    Log.w(this.mDebugTag, "In-app billing warning: " + paramString);
  }
  
  private Inventory queryInventory(boolean paramBoolean, String[] paramArrayOfString)
    throws IabException
  {
    checkNotDisposed();
    checkSetupDone("queryInventory");
    Inventory localInventory;
    try
    {
      localInventory = new Inventory();
      if (paramBoolean)
      {
        i = queryPurchases(localInventory);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying owned items).");
        }
      }
    }
    catch (RemoteException paramArrayOfString)
    {
      int i;
      throw new IabException(64535, "Remote exception while refreshing inventory.", paramArrayOfString);
      if (paramArrayOfString != null)
      {
        i = querySkuDetails(localInventory, paramArrayOfString);
        if (i != 0) {
          throw new IabException(i, "Error refreshing inventory (querying prices of items).");
        }
      }
    }
    catch (JSONException paramArrayOfString)
    {
      throw new IabException(64534, "Error parsing JSON response while refreshing inventory.", paramArrayOfString);
    }
    return localInventory;
  }
  
  private int queryPurchases(Inventory paramInventory)
    throws JSONException, RemoteException
  {
    logDebug("Querying owned items");
    logDebug("Package name: " + this.mContext.getPackageName());
    int i = 0;
    Object localObject1 = null;
    int j;
    Object localObject2;
    do
    {
      logDebug("Calling getPurchases with continuation token: " + (String)localObject1);
      localObject1 = this.mService.getPurchases(3, this.mContext.getPackageName(), "inapp", (String)localObject1);
      logDebug("Bundle: " + ((Bundle)localObject1).toString());
      j = getResponseCodeFromBundle((Bundle)localObject1);
      logDebug("Owned items response: " + String.valueOf(j));
      if (j != 0)
      {
        logDebug("getPurchases() failed: " + getResponseDesc(j));
        return j;
      }
      if ((!((Bundle)localObject1).containsKey("INAPP_PURCHASE_ITEM_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_PURCHASE_DATA_LIST")) || (!((Bundle)localObject1).containsKey("INAPP_DATA_SIGNATURE_LIST")))
      {
        logError("Bundle returned from getPurchases() doesn't contain required fields.");
        return 64534;
      }
      localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      int k = 0;
      j = i;
      i = k;
      if (i < localArrayList1.size())
      {
        String str1 = (String)localArrayList1.get(i);
        Object localObject3 = (String)localArrayList2.get(i);
        String str2 = (String)((ArrayList)localObject2).get(i);
        if (Security.verifyPurchase(this.mSignatureBase64, str1, (String)localObject3))
        {
          logDebug("Sku is owned: " + str2);
          localObject3 = new Purchase("inapp", str1, (String)localObject3);
          if (TextUtils.isEmpty(((Purchase)localObject3).getToken()))
          {
            logWarn("BUG: empty/null token!");
            logDebug("Purchase data: " + str1);
          }
          paramInventory.addPurchase((Purchase)localObject3);
        }
        for (;;)
        {
          i += 1;
          break;
          logWarn("Purchase signature verification **FAILED**. Not adding item.");
          logDebug("   Purchase data: " + str1);
          logDebug("   Signature: " + (String)localObject3);
          j = 1;
        }
      }
      localObject2 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
      logDebug("Continuation token: " + (String)localObject2);
      localObject1 = localObject2;
      i = j;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    if (j != 0) {}
    for (i = 64533;; i = 0) {
      return i;
    }
  }
  
  private int querySkuDetails(Inventory paramInventory, String[] paramArrayOfString)
    throws RemoteException, JSONException
  {
    logDebug("Querying SKU details.");
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll(paramInventory.getAllOwnedSkus("inapp"));
    Object localObject2;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        localObject2 = paramArrayOfString[i];
        if (!((ArrayList)localObject1).contains(localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        i += 1;
      }
    }
    if (((ArrayList)localObject1).size() == 0)
    {
      logDebug("queryPrices: nothing to do because there are no SKUs.");
      return 0;
    }
    paramArrayOfString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      paramArrayOfString.add(new ArrayList(((ArrayList)localObject1).subList(i, Math.min(i + 15, ((ArrayList)localObject1).size()))));
      i += 15;
    }
    paramArrayOfString = paramArrayOfString.iterator();
    while (paramArrayOfString.hasNext())
    {
      localObject1 = (ArrayList)paramArrayOfString.next();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject1);
      localObject1 = this.mService.getSkuDetails(3, this.mContext.getPackageName(), "inapp", (Bundle)localObject2);
      if (!((Bundle)localObject1).containsKey("DETAILS_LIST"))
      {
        i = getResponseCodeFromBundle((Bundle)localObject1);
        if (i != 0)
        {
          logDebug("getSkuDetails() failed: " + getResponseDesc(i));
          return i;
        }
        logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
        return 64534;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("DETAILS_LIST").iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new SkuDetails((String)((Iterator)localObject1).next());
        logDebug("Got sku details: " + localObject2);
        paramInventory.addSkuDetails((SkuDetails)localObject2);
      }
    }
    return 0;
  }
  
  void checkSetupDone(String paramString)
  {
    if (!this.initialized)
    {
      logError("Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("!!!! IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  public void consumeItem(final String paramString1, final String paramString2, final String paramString3)
  {
    try
    {
      this.mTaskQueue.submit(new Runnable()
      {
        public void run()
        {
          if (!ShopAndroidJavaImpl.this.initialized) {
            return;
          }
          ShopAndroidJavaImpl.this.logDebug("Consuming sku: " + paramString1 + ", token: " + paramString2);
          if ((paramString2 == null) || (paramString2.equals("")))
          {
            ShopAndroidJavaImpl.this.logError("Can't consume " + paramString1 + ". No token.");
            return;
          }
          ShopAndroidJavaImpl.this.checkNotDisposed();
          ShopAndroidJavaImpl.this.checkSetupDone("consume");
          for (;;)
          {
            int i;
            try
            {
              i = ShopAndroidJavaImpl.this.mService.consumePurchase(3, ShopAndroidJavaImpl.this.mContext.getPackageName(), paramString2);
              if (i == 0)
              {
                ShopAndroidJavaImpl.this.logDebug("Successfully consumed sku: " + paramString1);
                ShopAndroidJavaImpl.this.onConsumeFinished(paramString1, paramString3, i);
                return;
              }
            }
            catch (RemoteException localRemoteException)
            {
              ShopAndroidJavaImpl.this.logError("Remote exception while consuming. sku: " + paramString1);
              ShopAndroidJavaImpl.this.onConsumeFinished(paramString1, paramString3, -1);
              return;
            }
            ShopAndroidJavaImpl.this.logError("Error consuming consuming sku " + paramString1 + ". " + ShopAndroidJavaImpl.getResponseDesc(i));
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException paramString1)
    {
      logError("consumeItem failed because mTaskQueue is shut down");
    }
  }
  
  public void dispose()
  {
    if (!this.disposed)
    {
      logDebug("Disposing.");
      this.mTaskQueue.shutdownNow();
      this.mActivityResultHandler = null;
      this.activity = null;
      this.initialized = false;
      this.disposed = true;
      if (this.mServiceConn != null)
      {
        logDebug("Unbinding from service.");
        if (this.mContext != null) {
          this.mContext.unbindService(this.mServiceConn);
        }
        this.mServiceConn = null;
      }
      this.mContext = null;
      this.mService = null;
    }
  }
  
  public void fetchItems(final String[] paramArrayOfString)
  {
    try
    {
      this.mTaskQueue.submit(new Runnable()
      {
        public void run()
        {
          if ((ShopAndroidJavaImpl.this.disposed) || (!ShopAndroidJavaImpl.this.initialized))
          {
            ShopAndroidJavaImpl.this.onItemsFetchedWithError();
            return;
          }
          ShopAndroidJavaImpl.this.checkNotDisposed();
          ShopAndroidJavaImpl.this.checkSetupDone("queryInventory");
          Object localObject2 = new IabResult(0, "Inventory refresh successful.");
          Object localObject1 = null;
          try
          {
            Inventory localInventory = ShopAndroidJavaImpl.this.queryInventory(false, paramArrayOfString);
            localObject1 = localInventory;
          }
          catch (IabException localIabException)
          {
            for (;;)
            {
              int i;
              IabResult localIabResult = localIabException.getResult();
            }
            ShopAndroidJavaImpl.this.onItemsFetched((String[])localObject1);
            return;
          }
          if ((!ShopAndroidJavaImpl.this.disposed) && (((IabResult)localObject2).isSuccess()))
          {
            localObject2 = ((Inventory)localObject1).getAllSkus();
            localObject1 = new String[((List)localObject2).size()];
            i = 0;
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject1[i] = ((SkuDetails)((Iterator)localObject2).next()).getJson();
              i += 1;
            }
          }
          ShopAndroidJavaImpl.this.logDebug("fetchItems failed (!disposed && result.isSuccess())");
          ShopAndroidJavaImpl.this.onItemsFetchedWithError();
        }
      });
      return;
    }
    catch (RejectedExecutionException paramArrayOfString)
    {
      logError("fetchItems failed because mTaskQueue is shut down");
      onItemsFetchedWithError();
    }
  }
  
  int getResponseCodeFromBundle(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      logDebug("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    logError("Unexpected type for bundle response code.");
    logError(paramBundle.getClass().getName());
    throw new RuntimeException("!!!! Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  int getResponseCodeFromIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("RESPONSE_CODE");
    if (paramIntent == null)
    {
      logError("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof Long)) {
      return (int)((Long)paramIntent).longValue();
    }
    logError("Unexpected type for intent response code.");
    logError(paramIntent.getClass().getName());
    throw new RuntimeException("!!!! Unexpected type for intent response code: " + paramIntent.getClass().getName());
  }
  
  /* Error */
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	net/wargaming/wot/blitz/ShopAndroidJavaImpl:mActivityResultHandler	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 144	net/wargaming/wot/blitz/ShopAndroidJavaImpl:mActivityResultHandler	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;
    //   13: iload_1
    //   14: iload_2
    //   15: aload_3
    //   16: invokeinterface 580 4 0
    //   21: istore 4
    //   23: aload_0
    //   24: monitorexit
    //   25: iload 4
    //   27: ireturn
    //   28: iconst_0
    //   29: istore 4
    //   31: goto -8 -> 23
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	ShopAndroidJavaImpl
    //   0	39	1	paramInt1	int
    //   0	39	2	paramInt2	int
    //   0	39	3	paramIntent	Intent
    //   21	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	34	finally
  }
  
  public boolean isInitialized()
  {
    return this.initialized;
  }
  
  native void onConsumeFinished(String paramString1, String paramString2, int paramInt);
  
  native void onItemsFetched(String[] paramArrayOfString);
  
  native void onItemsFetchedWithError();
  
  native void onPurchasingFinished(String paramString1, String paramString2, int paramInt, String paramString3);
  
  native void onShopInitialized();
  
  public void purchaseItem(final String paramString1, final String paramString2)
  {
    try
    {
      this.mTaskQueue.submit(new RunnableWithActivityResultHandler(paramString1, paramString2)
      {
        private Intent data;
        private int requestCode = 0;
        private int resultCode;
        
        static
        {
          if (!ShopAndroidJavaImpl.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            return;
          }
        }
        
        private void processResponse()
        {
          assert (this.requestCode == 2000);
          if (!ShopAndroidJavaImpl.this.initialized) {
            return;
          }
          ShopAndroidJavaImpl.this.checkNotDisposed();
          ShopAndroidJavaImpl.this.checkSetupDone("handleActivityResult");
          if (this.data == null)
          {
            ShopAndroidJavaImpl.this.logError("Null data in IAB activity result.");
            ShopAndroidJavaImpl.this.onPurchasingFinished(null, null, 64534, "Null data in IAB result");
            return;
          }
          int i = ShopAndroidJavaImpl.this.getResponseCodeFromIntent(this.data);
          String str1 = this.data.getStringExtra("INAPP_PURCHASE_DATA");
          String str2 = this.data.getStringExtra("INAPP_DATA_SIGNATURE");
          if ((this.resultCode == -1) && (i == 0))
          {
            ShopAndroidJavaImpl.this.logDebug("Successful resultcode from purchase activity.");
            ShopAndroidJavaImpl.this.logDebug("Purchase data: " + str1);
            ShopAndroidJavaImpl.this.logDebug("Data signature: " + str2);
            ShopAndroidJavaImpl.this.logDebug("Extras: " + this.data.getExtras());
            if ((str1 == null) || (str2 == null))
            {
              ShopAndroidJavaImpl.this.logError("BUG: either purchaseData or dataSignature is null.");
              ShopAndroidJavaImpl.this.logDebug("Extras: " + this.data.getExtras().toString());
              ShopAndroidJavaImpl.this.onPurchasingFinished(null, null, 64528, "IAB returned null purchaseData or dataSignature");
              return;
            }
            ShopAndroidJavaImpl.this.onPurchasingFinished(str1, str2, 0, "Success");
            return;
          }
          if (this.resultCode == -1)
          {
            ShopAndroidJavaImpl.this.logDebug("Result code was OK but in-app billing response was not OK: " + ShopAndroidJavaImpl.getResponseDesc(i));
            ShopAndroidJavaImpl.this.onPurchasingFinished(null, null, i, "Problem purchashing item.");
            return;
          }
          if (this.resultCode == 0)
          {
            ShopAndroidJavaImpl.this.logDebug("Purchase canceled - Response: " + ShopAndroidJavaImpl.getResponseDesc(i));
            ShopAndroidJavaImpl.this.onPurchasingFinished(null, null, 64531, "User canceled.");
            return;
          }
          ShopAndroidJavaImpl.this.logError("Purchase failed. Result code: " + Integer.toString(this.resultCode) + ". Response: " + ShopAndroidJavaImpl.getResponseDesc(i));
          ShopAndroidJavaImpl.this.onPurchasingFinished(null, null, 64530, "Unknown purchase response.");
        }
        
        /* Error */
        public boolean handleActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: aload_0
          //   3: aload_3
          //   4: putfield 66	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:data	Landroid/content/Intent;
          //   7: aload_0
          //   8: iload_1
          //   9: putfield 45	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:requestCode	I
          //   12: aload_0
          //   13: iload_2
          //   14: putfield 94	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:resultCode	I
          //   17: aload_0
          //   18: getfield 45	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:requestCode	I
          //   21: sipush 2000
          //   24: if_icmpne +15 -> 39
          //   27: aload_0
          //   28: invokevirtual 160	java/lang/Object:notify	()V
          //   31: iconst_1
          //   32: istore 4
          //   34: aload_0
          //   35: monitorexit
          //   36: iload 4
          //   38: ireturn
          //   39: iconst_0
          //   40: istore 4
          //   42: goto -8 -> 34
          //   45: astore_3
          //   46: aload_0
          //   47: monitorexit
          //   48: aload_3
          //   49: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	50	0	this	4
          //   0	50	1	paramAnonymousInt1	int
          //   0	50	2	paramAnonymousInt2	int
          //   0	50	3	paramAnonymousIntent	Intent
          //   32	9	4	bool	boolean
          // Exception table:
          //   from	to	target	type
          //   2	31	45	finally
        }
        
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: aload_0
          //   3: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   6: invokestatic 54	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$500	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;)Z
          //   9: istore_2
          //   10: iload_2
          //   11: ifne +6 -> 17
          //   14: aload_0
          //   15: monitorexit
          //   16: return
          //   17: aload_0
          //   18: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   21: invokestatic 58	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$700	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;)V
          //   24: aload_0
          //   25: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   28: ldc -85
          //   30: invokevirtual 64	net/wargaming/wot/blitz/ShopAndroidJavaImpl:checkSetupDone	(Ljava/lang/String;)V
          //   33: aload_0
          //   34: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   37: new 101	java/lang/StringBuilder
          //   40: dup
          //   41: invokespecial 102	java/lang/StringBuilder:<init>	()V
          //   44: ldc -83
          //   46: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   49: aload_0
          //   50: getfield 38	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$sku	Ljava/lang/String;
          //   53: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   56: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   59: invokestatic 99	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$000	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;Ljava/lang/String;)V
          //   62: aload_0
          //   63: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   66: invokestatic 177	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$200	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;)Lcom/android/vending/billing/IInAppBillingService;
          //   69: iconst_3
          //   70: aload_0
          //   71: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   74: invokestatic 181	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$300	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;)Landroid/content/Context;
          //   77: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
          //   80: aload_0
          //   81: getfield 38	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$sku	Ljava/lang/String;
          //   84: ldc -68
          //   86: aload_0
          //   87: getfield 40	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$transactionPayload	Ljava/lang/String;
          //   90: invokeinterface 194 6 0
          //   95: astore_3
          //   96: aload_0
          //   97: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   100: aload_3
          //   101: invokevirtual 198	net/wargaming/wot/blitz/ShopAndroidJavaImpl:getResponseCodeFromBundle	(Landroid/os/Bundle;)I
          //   104: istore_1
          //   105: iload_1
          //   106: ifeq +60 -> 166
          //   109: aload_0
          //   110: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   113: new 101	java/lang/StringBuilder
          //   116: dup
          //   117: invokespecial 102	java/lang/StringBuilder:<init>	()V
          //   120: ldc -56
          //   122: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   125: iload_1
          //   126: invokestatic 138	net/wargaming/wot/blitz/ShopAndroidJavaImpl:getResponseDesc	(I)Ljava/lang/String;
          //   129: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   132: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   135: invokestatic 72	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$400	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;Ljava/lang/String;)V
          //   138: aload_0
          //   139: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   142: aconst_null
          //   143: aconst_null
          //   144: iload_1
          //   145: ldc -54
          //   147: invokevirtual 78	net/wargaming/wot/blitz/ShopAndroidJavaImpl:onPurchasingFinished	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
          //   150: aload_0
          //   151: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   154: aconst_null
          //   155: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   158: goto -144 -> 14
          //   161: astore_3
          //   162: aload_0
          //   163: monitorexit
          //   164: aload_3
          //   165: athrow
          //   166: aload_0
          //   167: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   170: aload_0
          //   171: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   174: aload_3
          //   175: ldc -48
          //   177: invokevirtual 212	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
          //   180: checkcast 214	android/app/PendingIntent
          //   183: astore_3
          //   184: aload_0
          //   185: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   188: new 101	java/lang/StringBuilder
          //   191: dup
          //   192: invokespecial 102	java/lang/StringBuilder:<init>	()V
          //   195: ldc -40
          //   197: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   200: aload_0
          //   201: getfield 38	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$sku	Ljava/lang/String;
          //   204: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   207: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   210: invokestatic 99	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$000	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;Ljava/lang/String;)V
          //   213: aload_0
          //   214: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   217: invokestatic 220	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$900	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;)Landroid/app/Activity;
          //   220: aload_3
          //   221: invokevirtual 224	android/app/PendingIntent:getIntentSender	()Landroid/content/IntentSender;
          //   224: sipush 2000
          //   227: new 86	android/content/Intent
          //   230: dup
          //   231: invokespecial 225	android/content/Intent:<init>	()V
          //   234: iconst_0
          //   235: iconst_0
          //   236: iconst_0
          //   237: invokevirtual 231	android/app/Activity:startIntentSenderForResult	(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
          //   240: aload_0
          //   241: getfield 45	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:requestCode	I
          //   244: istore_1
          //   245: iload_1
          //   246: sipush 2000
          //   249: if_icmpeq +77 -> 326
          //   252: aload_0
          //   253: invokevirtual 234	java/lang/Object:wait	()V
          //   256: goto -16 -> 240
          //   259: astore_3
          //   260: aload_3
          //   261: invokevirtual 237	java/lang/InterruptedException:printStackTrace	()V
          //   264: goto -24 -> 240
          //   267: astore_3
          //   268: aload_0
          //   269: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   272: new 101	java/lang/StringBuilder
          //   275: dup
          //   276: invokespecial 102	java/lang/StringBuilder:<init>	()V
          //   279: ldc -17
          //   281: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   284: aload_0
          //   285: getfield 38	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$sku	Ljava/lang/String;
          //   288: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   291: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   294: invokestatic 72	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$400	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;Ljava/lang/String;)V
          //   297: aload_3
          //   298: invokevirtual 240	android/content/IntentSender$SendIntentException:printStackTrace	()V
          //   301: aload_0
          //   302: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   305: aconst_null
          //   306: aconst_null
          //   307: sipush 64532
          //   310: ldc -14
          //   312: invokevirtual 78	net/wargaming/wot/blitz/ShopAndroidJavaImpl:onPurchasingFinished	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
          //   315: aload_0
          //   316: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   319: aconst_null
          //   320: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   323: goto -309 -> 14
          //   326: aload_0
          //   327: invokespecial 244	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:processResponse	()V
          //   330: aload_0
          //   331: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   334: aconst_null
          //   335: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   338: goto -324 -> 14
          //   341: astore_3
          //   342: aload_0
          //   343: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   346: new 101	java/lang/StringBuilder
          //   349: dup
          //   350: invokespecial 102	java/lang/StringBuilder:<init>	()V
          //   353: ldc -10
          //   355: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   358: aload_0
          //   359: getfield 38	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:val$sku	Ljava/lang/String;
          //   362: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   365: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   368: invokestatic 72	net/wargaming/wot/blitz/ShopAndroidJavaImpl:access$400	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;Ljava/lang/String;)V
          //   371: aload_3
          //   372: invokevirtual 247	android/os/RemoteException:printStackTrace	()V
          //   375: aload_0
          //   376: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   379: aconst_null
          //   380: aconst_null
          //   381: sipush 64535
          //   384: ldc -7
          //   386: invokevirtual 78	net/wargaming/wot/blitz/ShopAndroidJavaImpl:onPurchasingFinished	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
          //   389: aload_0
          //   390: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   393: aconst_null
          //   394: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   397: goto -383 -> 14
          //   400: astore_3
          //   401: aload_0
          //   402: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   405: aconst_null
          //   406: aconst_null
          //   407: sipush 64528
          //   410: ldc -5
          //   412: invokevirtual 78	net/wargaming/wot/blitz/ShopAndroidJavaImpl:onPurchasingFinished	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
          //   415: aload_0
          //   416: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   419: aconst_null
          //   420: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   423: goto -409 -> 14
          //   426: astore_3
          //   427: aload_0
          //   428: getfield 36	net/wargaming/wot/blitz/ShopAndroidJavaImpl$4:this$0	Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl;
          //   431: aconst_null
          //   432: invokevirtual 206	net/wargaming/wot/blitz/ShopAndroidJavaImpl:setActivityResultHandler	(Lnet/wargaming/wot/blitz/ShopAndroidJavaImpl$ActivityResultHandler;)V
          //   435: aload_3
          //   436: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	437	0	this	4
          //   104	146	1	i	int
          //   9	2	2	bool	boolean
          //   95	6	3	localBundle	Bundle
          //   161	14	3	localObject1	Object
          //   183	38	3	localPendingIntent	android.app.PendingIntent
          //   259	2	3	localInterruptedException	InterruptedException
          //   267	31	3	localSendIntentException	android.content.IntentSender.SendIntentException
          //   341	31	3	localRemoteException	RemoteException
          //   400	1	3	localException	Exception
          //   426	10	3	localObject2	Object
          // Exception table:
          //   from	to	target	type
          //   2	10	161	finally
          //   150	158	161	finally
          //   315	323	161	finally
          //   330	338	161	finally
          //   389	397	161	finally
          //   415	423	161	finally
          //   427	437	161	finally
          //   252	256	259	java/lang/InterruptedException
          //   17	105	267	android/content/IntentSender$SendIntentException
          //   109	150	267	android/content/IntentSender$SendIntentException
          //   166	240	267	android/content/IntentSender$SendIntentException
          //   240	245	267	android/content/IntentSender$SendIntentException
          //   252	256	267	android/content/IntentSender$SendIntentException
          //   260	264	267	android/content/IntentSender$SendIntentException
          //   326	330	267	android/content/IntentSender$SendIntentException
          //   17	105	341	android/os/RemoteException
          //   109	150	341	android/os/RemoteException
          //   166	240	341	android/os/RemoteException
          //   240	245	341	android/os/RemoteException
          //   252	256	341	android/os/RemoteException
          //   260	264	341	android/os/RemoteException
          //   326	330	341	android/os/RemoteException
          //   17	105	400	java/lang/Exception
          //   109	150	400	java/lang/Exception
          //   166	240	400	java/lang/Exception
          //   240	245	400	java/lang/Exception
          //   252	256	400	java/lang/Exception
          //   260	264	400	java/lang/Exception
          //   326	330	400	java/lang/Exception
          //   17	105	426	finally
          //   109	150	426	finally
          //   166	240	426	finally
          //   240	245	426	finally
          //   252	256	426	finally
          //   260	264	426	finally
          //   268	315	426	finally
          //   326	330	426	finally
          //   342	389	426	finally
          //   401	415	426	finally
        }
      });
      return;
    }
    catch (RejectedExecutionException paramString1)
    {
      logError("purchaseItem failed because mTaskQueue is shut down");
      onPurchasingFinished(null, null, 64528, "Unable to buy item");
    }
  }
  
  public void replayUnfinishedTransactions()
  {
    try
    {
      this.mTaskQueue.submit(new Runnable()
      {
        public void run()
        {
          if ((ShopAndroidJavaImpl.this.disposed) || (!ShopAndroidJavaImpl.this.initialized)) {}
          for (;;)
          {
            return;
            IabResult localIabResult1 = new IabResult(0, "Inventory refresh successful.");
            localObject1 = null;
            try
            {
              localObject2 = ShopAndroidJavaImpl.this.queryInventory(true, null);
              localObject1 = localObject2;
            }
            catch (IabException localIabException)
            {
              for (;;)
              {
                Iterator localIterator;
                IabResult localIabResult2 = localIabException.getResult();
                continue;
                localObject1 = null;
                continue;
                Object localObject2 = null;
              }
            }
            if ((!ShopAndroidJavaImpl.this.disposed) && (localIabResult1.isSuccess()))
            {
              localIterator = ((Inventory)localObject1).getAllPurchases().iterator();
              while (localIterator.hasNext())
              {
                localObject2 = (Purchase)localIterator.next();
                ShopAndroidJavaImpl.this.logDebug("Purchase when inventory finished: " + localObject2);
                ShopAndroidJavaImpl localShopAndroidJavaImpl = ShopAndroidJavaImpl.this;
                if (localObject2 == null) {
                  break label172;
                }
                localObject1 = ((Purchase)localObject2).getOriginalJson();
                if (localObject2 == null) {
                  break label177;
                }
                localObject2 = ((Purchase)localObject2).getSignature();
                localShopAndroidJavaImpl.onPurchasingFinished((String)localObject1, (String)localObject2, localIabResult1.getResponse(), localIabResult1.getMessage());
              }
            }
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      logError("replayUnfinishedTransactions failed because mTaskQueue is shut down");
    }
  }
  
  public void setActivityResultHandler(ActivityResultHandler paramActivityResultHandler)
  {
    try
    {
      if ((!$assertionsDisabled) && (this.mActivityResultHandler != null)) {
        throw new AssertionError();
      }
    }
    finally {}
    this.mActivityResultHandler = paramActivityResultHandler;
  }
  
  private static abstract interface ActivityResultHandler
  {
    public abstract boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  private abstract class RunnableWithActivityResultHandler
    implements Runnable, ShopAndroidJavaImpl.ActivityResultHandler
  {
    private RunnableWithActivityResultHandler() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/ShopAndroidJavaImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */