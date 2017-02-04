package com.dava.framework;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

public class ScheduledNotificationReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("Local Notifications", "ScheduledNotificationReceiver onReceive");
    Object localObject = JNIActivity.GetActivity();
    if (localObject != null) {
      localObject = new Intent(paramContext, localObject.getClass());
    }
    for (;;)
    {
      PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
      localObject = null;
      if (paramIntent.getBooleanExtra("useSound", false)) {
        localObject = RingtoneManager.getDefaultUri(2);
      }
      String str = paramIntent.getStringExtra("uid");
      localBuilder.setContentTitle(paramIntent.getStringExtra("title")).setContentText(paramIntent.getStringExtra("text")).setSmallIcon(paramIntent.getIntExtra("icon", 0)).setContentIntent(localPendingIntent).setAutoCancel(true).setSound((Uri)localObject);
      ((NotificationManager)paramContext.getSystemService("notification")).notify(str, 0, localBuilder.build());
      return;
      localObject = paramIntent.getStringExtra("activityClassName");
      try
      {
        localObject = new Intent(paramContext, Class.forName((String)localObject));
      }
      catch (ClassNotFoundException paramContext)
      {
        Log.d("Local Notifications", "Incorrect activityClassName");
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/ScheduledNotificationReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */