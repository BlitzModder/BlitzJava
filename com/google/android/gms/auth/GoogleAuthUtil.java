package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.firstparty.shared.zzd;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzau.zza;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final ComponentName zzTH;
  private static final ComponentName zzTI;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      KEY_CALLER_UID = "callerUid";
      if (Build.VERSION.SDK_INT < 14) {
        break label58;
      }
    }
    label58:
    for (;;)
    {
      KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
      zzTH = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      zzTI = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      return;
      break;
    }
  }
  
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    final Bundle localBundle = new Bundle();
    String str = paramContext.getApplicationInfo().packageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    }
    paramString = new zza()
    {
      public Void zzao(IBinder paramAnonymousIBinder)
        throws RemoteException, IOException, GoogleAuthException
      {
        paramAnonymousIBinder = (Bundle)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(this.zzTM, localBundle));
        String str = paramAnonymousIBinder.getString("Error");
        if (!paramAnonymousIBinder.getBoolean("booleanResult")) {
          throw new GoogleAuthException(str);
        }
        return null;
      }
    };
    zza(paramContext, zzTH, paramString);
  }
  
  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, final int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    zzx.zzh(paramString, "accountName must be provided");
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    paramString = new zza()
    {
      public List<AccountChangeEvent> zzap(IBinder paramAnonymousIBinder)
        throws RemoteException, IOException, GoogleAuthException
      {
        return ((AccountChangeEventsResponse)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(new AccountChangeEventsRequest().setAccountName(this.zzTO).setEventIndex(paramInt)))).getEvents();
      }
    };
    return (List)zza(paramContext, zzTH, paramString);
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    zzx.zzh(paramString, "accountName must be provided");
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return zza(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return zzb(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzi(paramIntent);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("callback_intent", paramIntent);
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, localBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzx.zzh(paramString2, "Authority cannot be empty or null.");
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString2);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString1, localBundle).getToken();
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  public static TokenData zza(Context paramContext, Account paramAccount, final String paramString, final Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    zzx.zzcy("Calling this from your main thread can lead to deadlock");
    zzac(paramContext);
    if (paramBundle == null) {}
    for (paramBundle = new Bundle();; paramBundle = new Bundle(paramBundle))
    {
      String str = paramContext.getApplicationInfo().packageName;
      paramBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(paramBundle.getString(KEY_ANDROID_PACKAGE_NAME))) {
        paramBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
      }
      paramBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      paramAccount = new zza()
      {
        public TokenData zzam(IBinder paramAnonymousIBinder)
          throws RemoteException, IOException, GoogleAuthException
        {
          Object localObject = (Bundle)GoogleAuthUtil.zzm(zzau.zza.zza(paramAnonymousIBinder).zza(this.zzTJ, paramString, paramBundle));
          paramAnonymousIBinder = TokenData.zza((Bundle)localObject, "tokenDetails");
          if (paramAnonymousIBinder != null) {
            return paramAnonymousIBinder;
          }
          paramAnonymousIBinder = ((Bundle)localObject).getString("Error");
          localObject = (Intent)((Bundle)localObject).getParcelable("userRecoveryIntent");
          zzd localzzd = zzd.zzbT(paramAnonymousIBinder);
          if (zzd.zza(localzzd)) {
            throw new UserRecoverableAuthException(paramAnonymousIBinder, (Intent)localObject);
          }
          if (zzd.zzc(localzzd)) {
            throw new IOException(paramAnonymousIBinder);
          }
          throw new GoogleAuthException(paramAnonymousIBinder);
        }
      };
      return (TokenData)zza(paramContext, zzTH, paramAccount);
    }
  }
  
  /* Error */
  private static <T> T zza(Context paramContext, ComponentName paramComponentName, zza<T> paramzza)
    throws IOException, GoogleAuthException
  {
    // Byte code:
    //   0: new 260	com/google/android/gms/common/zza
    //   3: dup
    //   4: invokespecial 261	com/google/android/gms/common/zza:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 267	com/google/android/gms/common/internal/zzl:zzat	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: aload_3
    //   18: ldc_w 269
    //   21: invokevirtual 272	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   24: ifeq +63 -> 87
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual 276	com/google/android/gms/common/zza:zzor	()Landroid/os/IBinder;
    //   32: invokeinterface 280 2 0
    //   37: astore_0
    //   38: aload 4
    //   40: aload_1
    //   41: aload_3
    //   42: ldc_w 269
    //   45: invokevirtual 283	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc_w 269
    //   54: ldc_w 285
    //   57: aload_0
    //   58: invokestatic 291	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: new 81	java/io/IOException
    //   65: dup
    //   66: ldc_w 285
    //   69: aload_0
    //   70: invokespecial 294	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: athrow
    //   74: astore_0
    //   75: aload 4
    //   77: aload_1
    //   78: aload_3
    //   79: ldc_w 269
    //   82: invokevirtual 283	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   85: aload_0
    //   86: athrow
    //   87: new 81	java/io/IOException
    //   90: dup
    //   91: ldc_w 296
    //   94: invokespecial 298	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    //   98: astore_0
    //   99: goto -48 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	Context
    //   0	102	1	paramComponentName	ComponentName
    //   0	102	2	paramzza	zza<T>
    //   7	72	3	localzza	com.google.android.gms.common.zza
    //   12	64	4	localzzl	com.google.android.gms.common.internal.zzl
    // Exception table:
    //   from	to	target	type
    //   27	38	50	java/lang/InterruptedException
    //   27	38	74	finally
    //   51	74	74	finally
    //   27	38	98	android/os/RemoteException
  }
  
  private static void zzac(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.zzac(paramContext.getApplicationContext());
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
  
  public static TokenData zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, localBundle);
  }
  
  private static TokenData zzc(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramAccount = zza(paramContext, paramAccount, paramString, localBundle);
      GooglePlayServicesUtil.zzaj(paramContext);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      GooglePlayServicesUtil.zzaj(paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static void zzi(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    paramIntent = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(paramIntent, 1);
      return;
    }
    catch (URISyntaxException paramIntent)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  private static <T> T zzl(T paramT)
    throws IOException
  {
    if (paramT == null)
    {
      Log.w("GoogleAuthUtil", "Binder call returned null.");
      throw new IOException("Service unavailable.");
    }
    return paramT;
  }
  
  private static abstract interface zza<T>
  {
    public abstract T zzan(IBinder paramIBinder)
      throws RemoteException, IOException, GoogleAuthException;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/GoogleAuthUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */