package com.dava.framework;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import java.util.Calendar;

public class JNINotificationProvider
{
  private static AssetManager assetsManager = null;
  private static NotificationCompat.Builder builder = null;
  private static int icon;
  private static boolean isInited = false;
  private static NotificationManager notificationManager = null;
  
  public static void AttachToActivity(JNIActivity paramJNIActivity)
  {
    if (isInited)
    {
      icon = paramJNIActivity.GetNotificationIcon();
      builder.setSmallIcon(icon);
    }
  }
  
  static void CleanBuilder()
  {
    if (builder != null) {
      builder.setContentTitle("").setContentText("").setProgress(0, 0, false);
    }
  }
  
  static void EnableTapAction(String paramString)
  {
    if (isInited)
    {
      CleanBuilder();
      Object localObject = JNIActivity.GetActivity();
      Intent localIntent = new Intent((Context)localObject, localObject.getClass());
      localIntent.putExtra("uid", paramString);
      localObject = PendingIntent.getActivity((Context)localObject, 0, localIntent, 134217728);
      builder.setContentIntent((PendingIntent)localObject);
      notificationManager.notify(paramString, 0, builder.build());
    }
  }
  
  static void HideNotification(String paramString)
  {
    if (isInited)
    {
      CleanBuilder();
      notificationManager.cancel(paramString, 0);
    }
  }
  
  static void Init()
  {
    JNIApplication localJNIApplication = JNIApplication.GetApplication();
    assetsManager = localJNIApplication.getAssets();
    notificationManager = (NotificationManager)localJNIApplication.getSystemService("notification");
    builder = new NotificationCompat.Builder(localJNIApplication);
    if ((builder != null) && (notificationManager != null) && (assetsManager != null)) {}
    for (boolean bool = true;; bool = false)
    {
      isInited = bool;
      return;
    }
  }
  
  static void NotificationPressed(String paramString)
  {
    if (isInited) {
      onNotificationPressed(paramString);
    }
  }
  
  static void NotifyDelayed(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    JNIApplication localJNIApplication = JNIApplication.GetApplication();
    AlarmManager localAlarmManager = (AlarmManager)localJNIApplication.getSystemService("alarm");
    Intent localIntent = new Intent(localJNIApplication, ScheduledNotificationReceiver.class);
    localIntent.putExtra("uid", paramString1);
    localIntent.putExtra("icon", icon);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("text", paramString3);
    localIntent.putExtra("useSound", paramBoolean);
    if (JNIActivity.GetActivity() != null) {
      localIntent.putExtra("activityClassName", JNIActivity.GetActivity().getClass().getName());
    }
    paramString1 = PendingIntent.getBroadcast(localJNIApplication, 0, localIntent, 134217728);
    localAlarmManager.set(0, Calendar.getInstance().getTimeInMillis() + paramInt * 1000, paramString1);
  }
  
  static void NotifyProgress(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (isInited)
    {
      CleanBuilder();
      Uri localUri = null;
      if (paramBoolean) {
        localUri = RingtoneManager.getDefaultUri(2);
      }
      builder.setContentTitle(paramString2).setContentText(paramString3).setProgress(paramInt1, paramInt2, false).setSound(localUri);
      notificationManager.notify(paramString1, 0, builder.build());
    }
  }
  
  static void NotifyText(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (isInited)
    {
      CleanBuilder();
      Uri localUri = null;
      if (paramBoolean) {
        localUri = RingtoneManager.getDefaultUri(2);
      }
      builder.setContentTitle(paramString2).setContentText(paramString3).setSound(localUri);
      notificationManager.notify(paramString1, 0, builder.build());
    }
  }
  
  static void RemoveAllDelayedNotifications()
  {
    JNIApplication localJNIApplication = JNIApplication.GetApplication();
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(localJNIApplication, 0, new Intent(localJNIApplication, ScheduledNotificationReceiver.class), 268435456);
    ((AlarmManager)localJNIApplication.getSystemService("alarm")).cancel(localPendingIntent);
    notificationManager.cancelAll();
  }
  
  public static void SetNotificationIcon(int paramInt)
  {
    icon = paramInt;
  }
  
  private static native void onNotificationPressed(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNINotificationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */