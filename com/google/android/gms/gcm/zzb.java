package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class zzb
{
  static zzb zzaIN;
  private final Context mContext;
  private final Class<? extends GcmListenerService> zzaIO;
  
  private zzb(Context paramContext, Class<? extends GcmListenerService> paramClass)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzaIO = paramClass;
  }
  
  private Notification zzA(Bundle paramBundle)
  {
    PendingIntent localPendingIntent2 = null;
    String str2 = zzd(paramBundle, "gcm.n.title");
    if (TextUtils.isEmpty(str2)) {
      throw new zza("Missing title", null);
    }
    String str3 = zzd(paramBundle, "gcm.n.body");
    int i = zzdH(zzc(paramBundle, "gcm.n.icon"));
    String str1 = zzc(paramBundle, "gcm.n.color");
    Uri localUri = zzdI(zzc(paramBundle, "gcm.n.sound"));
    PendingIntent localPendingIntent3 = zzB(paramBundle);
    PendingIntent localPendingIntent1 = localPendingIntent3;
    if (GcmListenerService.zzw(paramBundle))
    {
      localPendingIntent1 = zza(paramBundle, localPendingIntent3);
      localPendingIntent2 = zzC(paramBundle);
    }
    paramBundle = new NotificationCompat.Builder(this.mContext).setAutoCancel(true).setSmallIcon(i).setContentTitle(str2).setContentText(str3);
    if (!TextUtils.isEmpty(str1)) {
      paramBundle.setColor(Color.parseColor(str1));
    }
    if (localUri != null) {
      paramBundle.setSound(localUri);
    }
    if (localPendingIntent1 != null) {
      paramBundle.setContentIntent(localPendingIntent1);
    }
    if (localPendingIntent2 != null) {
      paramBundle.setDeleteIntent(localPendingIntent2);
    }
    return paramBundle.build();
  }
  
  private PendingIntent zzB(Bundle paramBundle)
  {
    Object localObject = zzc(paramBundle, "gcm.n.click_action");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new Intent((String)localObject);
    ((Intent)localObject).setPackage(this.mContext.getPackageName());
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtras(paramBundle);
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str.startsWith("gcm.n.")) || (str.startsWith("gcm.notification."))) {
        ((Intent)localObject).removeExtra(str);
      }
    }
    return PendingIntent.getActivity(this.mContext, zzxx(), (Intent)localObject, 1073741824);
  }
  
  private PendingIntent zzC(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
    zza(localIntent, paramBundle);
    return PendingIntent.getService(this.mContext, zzxx(), localIntent, 1073741824);
  }
  
  private PendingIntent zza(Bundle paramBundle, PendingIntent paramPendingIntent)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
    zza(localIntent, paramBundle);
    localIntent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", paramPendingIntent);
    return PendingIntent.getService(this.mContext, zzxx(), localIntent, 1073741824);
  }
  
  private void zza(Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.setClass(this.mContext, this.zzaIO);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.startsWith("gcm.a.")) || (str.equals("from"))) {
        paramIntent.putExtra(str, paramBundle.getString(str));
      }
    }
  }
  
  private void zza(String paramString, Notification paramNotification)
  {
    if (Log.isLoggable("GcmNotification", 3)) {
      Log.d("GcmNotification", "Showing notification");
    }
    NotificationManager localNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "GCM-Notification:" + SystemClock.uptimeMillis();
    }
    localNotificationManager.notify(str, 0, paramNotification);
  }
  
  static boolean zzaH(Context paramContext)
  {
    if (((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {}
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          i = Process.myPid();
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (localRunningAppProcessInfo.pid != i);
    if (localRunningAppProcessInfo.importance == 100) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static zzb zzc(Context paramContext, Class<? extends GcmListenerService> paramClass)
  {
    try
    {
      if (zzaIN == null) {
        zzaIN = new zzb(paramContext, paramClass);
      }
      paramContext = zzaIN;
      return paramContext;
    }
    finally {}
  }
  
  static String zzc(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    return str1;
  }
  
  private String zzd(Bundle paramBundle, String paramString)
  {
    String str = zzc(paramBundle, paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = zzc(paramBundle, paramString + "_loc_key");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    localResources = this.mContext.getResources();
    j = localResources.getIdentifier(str, "string", this.mContext.getPackageName());
    if (j == 0) {
      throw new zza(zzdG(new StringBuilder().append(paramString).append("_loc_key").toString()) + " resource not found: " + str, null);
    }
    paramBundle = zzc(paramBundle, paramString + "_loc_args");
    if (TextUtils.isEmpty(paramBundle)) {
      return localResources.getString(j);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramBundle);
      paramBundle = new String[localJSONArray.length()];
      int i = 0;
      while (i < paramBundle.length)
      {
        paramBundle[i] = localJSONArray.opt(i);
        i += 1;
      }
      try
      {
        paramBundle = localResources.getString(j, paramBundle);
        return paramBundle;
      }
      catch (MissingFormatArgumentException paramBundle)
      {
        throw new zza("Missing format argument for " + localJSONException + ": " + paramBundle, null);
      }
    }
    catch (JSONException localJSONException)
    {
      throw new zza("Malformed " + zzdG(new StringBuilder().append(paramString).append("_loc_args").toString()) + ": " + paramBundle, null);
    }
  }
  
  private String zzdG(String paramString)
  {
    return paramString.substring("gcm.n.".length());
  }
  
  private int zzdH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new zza("Missing icon", null);
    }
    Resources localResources = this.mContext.getResources();
    int i = localResources.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = localResources.getIdentifier(paramString, "mipmap", this.mContext.getPackageName());
      i = j;
    } while (j != 0);
    throw new zza("Icon resource not found: " + paramString, null);
  }
  
  private Uri zzdI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("default".equals(paramString)) {
      return RingtoneManager.getDefaultUri(2);
    }
    throw new zza("Invalid sound: " + paramString, null);
  }
  
  static boolean zzx(Bundle paramBundle)
  {
    return zzc(paramBundle, "gcm.n.icon") != null;
  }
  
  private int zzxx()
  {
    return (int)SystemClock.uptimeMillis();
  }
  
  static void zzy(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("gcm.n."))
      {
        localBundle.putString(str.substring("gcm.n.".length()), paramBundle.getString(str));
        localIterator.remove();
      }
      else if (str.startsWith("gcm.notification."))
      {
        localBundle.putString(str.substring("gcm.notification.".length()), paramBundle.getString(str));
        localIterator.remove();
      }
    }
    if (!localBundle.isEmpty()) {
      paramBundle.putBundle("notification", localBundle);
    }
  }
  
  boolean zzz(Bundle paramBundle)
  {
    try
    {
      Notification localNotification = zzA(paramBundle);
      zza(zzc(paramBundle, "gcm.n.tag"), localNotification);
      return true;
    }
    catch (zza paramBundle)
    {
      Log.w("GcmNotification", "Failed to show notification: " + paramBundle.getMessage());
    }
    return false;
  }
  
  private class zza
    extends IllegalArgumentException
  {
    private zza(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */