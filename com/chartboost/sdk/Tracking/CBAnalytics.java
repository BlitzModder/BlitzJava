package com.chartboost.sdk.Tracking;

import android.text.TextUtils;
import android.util.Base64;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.a;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.e.b;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Libraries.g.k;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.c;
import com.chartboost.sdk.impl.ay;
import com.chartboost.sdk.impl.ay.c;
import com.chartboost.sdk.impl.az;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class CBAnalytics
{
  private static void a(e.a parama, String paramString, final CBIAPType paramCBIAPType)
  {
    try
    {
      ay localay = new ay(String.format(Locale.US, "%s%s", new Object[] { "/post-install-event/", paramString }));
      localay.a(paramString, parama);
      localay.a(g.a(new g.k[] { g.a("status", a.a) }));
      localay.b(paramString);
      localay.a(true);
      localay.a(new ay.c()
      {
        public void a(e.a paramAnonymousa, ay paramAnonymousay) {}
        
        public void a(e.a paramAnonymousa, ay paramAnonymousay, CBError paramAnonymousCBError)
        {
          try
          {
            if ((this.a.equals("iap")) && (paramAnonymousa.c()) && (paramAnonymousa.f("status") == 400) && (paramCBIAPType == CBAnalytics.CBIAPType.GOOGLE_PLAY))
            {
              CBLogging.a("CBPostInstallTracker", this.a + " 400 response from server!!");
              paramAnonymousCBError = az.a(c.y());
              paramAnonymousa = paramAnonymousCBError.h();
              paramAnonymousCBError = paramAnonymousCBError.g();
              if ((paramAnonymousa != null) && (paramAnonymousCBError != null))
              {
                paramAnonymousa.e((File)paramAnonymousCBError.get(paramAnonymousay));
                paramAnonymousCBError.remove(paramAnonymousay);
              }
            }
            return;
          }
          catch (Exception paramAnonymousa)
          {
            paramAnonymousa.printStackTrace();
          }
        }
      });
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, CBIAPType paramCBIAPType)
  {
    for (;;)
    {
      try
      {
        if (c.y() == null)
        {
          CBLogging.b("CBPostInstallTracker", "You need call Chartboost.init() before calling any public API's");
          return;
        }
        if (!c.q())
        {
          CBLogging.b("CBPostInstallTracker", "You need call Chartboost.OnStart() before tracking in-app purchases");
          continue;
        }
        if (TextUtils.isEmpty(paramString1)) {
          break label78;
        }
      }
      finally {}
      if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5)))
      {
        label78:
        CBLogging.b("CBPostInstallTracker", "Null object is passed. Please pass a valid value object");
      }
      else
      {
        try
        {
          paramString4 = Pattern.compile("(\\d+\\.\\d+)|(\\d+)").matcher(paramString4);
          paramString4.find();
          paramString4 = paramString4.group();
          if (!TextUtils.isEmpty(paramString4)) {
            break label136;
          }
          CBLogging.b("CBPostInstallTracker", "Invalid price object");
        }
        catch (IllegalStateException paramString1)
        {
          CBLogging.b("CBPostInstallTracker", "Invalid price object");
        }
        continue;
        label136:
        float f = Float.parseFloat(paramString4);
        paramString4 = null;
        if (paramCBIAPType == CBIAPType.GOOGLE_PLAY)
        {
          if ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString7))) {
            CBLogging.b("CBPostInstallTracker", "Null object is passed for for purchase data or purchase signature");
          } else {
            paramString4 = e.a(new e.b[] { e.a("purchaseData", paramString6), e.a("purchaseSignature", paramString7), e.a("type", Integer.valueOf(CBIAPType.GOOGLE_PLAY.ordinal())) });
          }
        }
        else
        {
          for (;;)
          {
            if (paramString4 != null) {
              break label319;
            }
            CBLogging.b("CBPostInstallTracker", "Error while parsing the receipt to a JSON Object, ");
            break;
            if (paramCBIAPType == CBIAPType.AMAZON)
            {
              if ((TextUtils.isEmpty(paramString8)) || (TextUtils.isEmpty(paramString9)))
              {
                CBLogging.b("CBPostInstallTracker", "Null object is passed for for amazon user id or amazon purchase token");
                break;
              }
              paramString4 = e.a(new e.b[] { e.a("userID", paramString8), e.a("purchaseToken", paramString9), e.a("type", Integer.valueOf(CBIAPType.AMAZON.ordinal())) });
            }
          }
          label319:
          paramString4 = Base64.encodeToString(paramString4.toString().getBytes(), 2);
          a(e.a(new e.b[] { e.a("localized-title", paramString2), e.a("localized-description", paramString3), e.a("price", Float.valueOf(f)), e.a("currency", paramString5), e.a("productID", paramString1), e.a("receipt", paramString4) }), "iap", paramCBIAPType);
        }
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      ay localay = new ay("/post-install-event/".concat("tracking"));
      localay.a("track_info", paramJSONArray);
      localay.a(g.a(new g.k[] { g.a("status", a.a) }));
      localay.b(paramString);
      localay.a(true);
      localay.t();
      return;
    }
    finally
    {
      paramJSONArray = finally;
      throw paramJSONArray;
    }
  }
  
  public static void trackInAppAmazonStorePurchaseEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      a(paramString5, paramString1, paramString2, paramString3, paramString4, null, null, paramString6, paramString7, CBIAPType.AMAZON);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void trackInAppGooglePlayPurchaseEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      a(paramString5, paramString1, paramString2, paramString3, paramString4, paramString6, paramString7, null, null, CBIAPType.GOOGLE_PLAY);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void trackLevelInfo(String paramString1, CBLevelType paramCBLevelType, int paramInt1, int paramInt2, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          CBLogging.b("CBPostInstallTracker", "Invalid value: event label cannot be empty or null");
          return;
        }
        if ((paramCBLevelType == null) || (!(paramCBLevelType instanceof CBLevelType)))
        {
          CBLogging.b("CBPostInstallTracker", "Invalid value: level type cannot be empty or null, please choose from one of the CBLevelType enum values");
          continue;
        }
        if (paramInt1 < 0) {
          break label56;
        }
      }
      finally {}
      if (paramInt2 < 0)
      {
        label56:
        CBLogging.b("CBPostInstallTracker", "Invalid value: Level number should be > 0");
      }
      else if (paramString2.isEmpty())
      {
        CBLogging.b("CBPostInstallTracker", "Invalid value: description cannot be empty or null");
      }
      else
      {
        paramString1 = e.a(new e.b[] { e.a("event_label", paramString1), e.a("event_field", Integer.valueOf(paramCBLevelType.getLevelType())), e.a("main_level", Integer.valueOf(paramInt1)), e.a("sub_level", Integer.valueOf(paramInt2)), e.a("description", paramString2), e.a("timestamp", Long.valueOf(System.currentTimeMillis())), e.a("data_type", "level_info") });
        paramCBLevelType = new JSONArray();
        paramCBLevelType.put(paramString1.e());
        a(paramCBLevelType, "tracking");
      }
    }
  }
  
  public static void trackLevelInfo(String paramString1, CBLevelType paramCBLevelType, int paramInt, String paramString2)
  {
    try
    {
      trackLevelInfo(paramString1, paramCBLevelType, paramInt, 0, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void trackInAppPurchaseEvent(java.util.EnumMap<CBIAPPurchaseInfo, String> paramEnumMap, CBIAPType paramCBIAPType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +87 -> 90
    //   6: aload_2
    //   7: ifnull +83 -> 90
    //   10: aload_1
    //   11: getstatic 297	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_ID	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   14: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 305	java/lang/CharSequence
    //   20: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +67 -> 90
    //   26: aload_1
    //   27: getstatic 308	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_TITLE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   30: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 305	java/lang/CharSequence
    //   36: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +51 -> 90
    //   42: aload_1
    //   43: getstatic 311	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_DESCRIPTION	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   46: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 305	java/lang/CharSequence
    //   52: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +35 -> 90
    //   58: aload_1
    //   59: getstatic 314	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_PRICE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   62: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 305	java/lang/CharSequence
    //   68: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +19 -> 90
    //   74: aload_1
    //   75: getstatic 317	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_CURRENCY_CODE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   78: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 305	java/lang/CharSequence
    //   84: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +13 -> 100
    //   90: ldc 89
    //   92: ldc 110
    //   94: invokestatic 96	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_1
    //   101: getstatic 320	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:GOOGLE_PURCHASE_DATA	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   104: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 36	java/lang/String
    //   110: astore_3
    //   111: aload_1
    //   112: getstatic 323	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:GOOGLE_PURCHASE_SIGNATURE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   115: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 36	java/lang/String
    //   121: astore 4
    //   123: aload_1
    //   124: getstatic 326	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:AMAZON_USER_ID	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   127: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 36	java/lang/String
    //   133: astore 5
    //   135: aload_1
    //   136: getstatic 329	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:AMAZON_PURCHASE_TOKEN	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   139: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 36	java/lang/String
    //   145: astore 6
    //   147: aload_1
    //   148: getstatic 297	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_ID	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   151: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: checkcast 36	java/lang/String
    //   157: aload_1
    //   158: getstatic 308	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_TITLE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   161: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   164: checkcast 36	java/lang/String
    //   167: aload_1
    //   168: getstatic 311	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_DESCRIPTION	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   171: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: checkcast 36	java/lang/String
    //   177: aload_1
    //   178: getstatic 314	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_PRICE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   181: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 36	java/lang/String
    //   187: aload_1
    //   188: getstatic 317	com/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo:PRODUCT_CURRENCY_CODE	Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPPurchaseInfo;
    //   191: invokevirtual 303	java/util/EnumMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: checkcast 36	java/lang/String
    //   197: aload_3
    //   198: aload 4
    //   200: aload 5
    //   202: aload 6
    //   204: aload_2
    //   205: invokestatic 232	com/chartboost/sdk/Tracking/CBAnalytics:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/Tracking/CBAnalytics$CBIAPType;)V
    //   208: goto -111 -> 97
    //   211: astore_1
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	CBAnalytics
    //   0	216	1	paramEnumMap	java.util.EnumMap<CBIAPPurchaseInfo, String>
    //   0	216	2	paramCBIAPType	CBIAPType
    //   110	88	3	str1	String
    //   121	78	4	str2	String
    //   133	68	5	str3	String
    //   145	58	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   10	90	211	finally
    //   90	97	211	finally
    //   100	208	211	finally
  }
  
  public static enum CBIAPPurchaseInfo
  {
    static
    {
      PRODUCT_DESCRIPTION = new CBIAPPurchaseInfo("PRODUCT_DESCRIPTION", 2);
      PRODUCT_PRICE = new CBIAPPurchaseInfo("PRODUCT_PRICE", 3);
      PRODUCT_CURRENCY_CODE = new CBIAPPurchaseInfo("PRODUCT_CURRENCY_CODE", 4);
      GOOGLE_PURCHASE_DATA = new CBIAPPurchaseInfo("GOOGLE_PURCHASE_DATA", 5);
      GOOGLE_PURCHASE_SIGNATURE = new CBIAPPurchaseInfo("GOOGLE_PURCHASE_SIGNATURE", 6);
    }
    
    private CBIAPPurchaseInfo() {}
  }
  
  public static enum CBIAPType
  {
    private CBIAPType() {}
  }
  
  public static enum CBLevelType
  {
    private int a;
    
    static
    {
      CURRENT_AREA = new CBLevelType("CURRENT_AREA", 1, 2);
      CHARACTER_LEVEL = new CBLevelType("CHARACTER_LEVEL", 2, 3);
      OTHER_SEQUENTIAL = new CBLevelType("OTHER_SEQUENTIAL", 3, 4);
    }
    
    private CBLevelType(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int getLevelType()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Tracking/CBAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */