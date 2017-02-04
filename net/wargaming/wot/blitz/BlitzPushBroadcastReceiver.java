package net.wargaming.wot.blitz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.dava.framework.JNIActivity;
import com.dava.framework.JNIApplication;
import com.parse.ParsePushBroadcastReceiver;
import org.json.JSONException;
import org.json.JSONObject;

public class BlitzPushBroadcastReceiver
  extends ParsePushBroadcastReceiver
{
  protected Class getActivity(Context paramContext, Intent paramIntent)
  {
    return WotBlitz.class;
  }
  
  protected int getSmallIconId(Context paramContext, Intent paramIntent)
  {
    return WotBlitz.GetNotificationIconId();
  }
  
  public void onPushOpen(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    localIntent.putExtras(paramIntent.getExtras());
    paramContext.startActivity(localIntent);
  }
  
  protected void onPushReceive(Context paramContext, Intent paramIntent)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("pushNotificationsData", 0);
    String str1 = localSharedPreferences.getString("lastParsePushHash", "");
    long l1 = localSharedPreferences.getLong("lastParsePushTimestamp", 0L);
    Object localObject2 = "";
    long l2 = System.currentTimeMillis() / 1000L;
    Log.d("DAVA", "onPushReceive lastParsePushHash: " + str1 + " lastParsePushTimestamp: " + l1 + " ts: " + l2);
    JNIActivity localJNIActivity = null;
    if (JNIApplication.GetApplication() != null) {
      localJNIActivity = JNIActivity.GetActivity();
    }
    Object localObject1 = localObject2;
    String str2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null)
      {
        str2 = paramIntent.getExtras().getString("com.parse.Data");
        localObject1 = localObject2;
      }
    }
    try
    {
      localObject2 = new JSONObject(str2).getString("push_hash");
      localObject1 = localObject2;
      Log.d("DAVA", "push_hash: " + (String)localObject2);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int j;
        int i;
        Log.d("DAVA", "Error parsing push_hash");
      }
    }
    localObject2 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject2).putString("lastParsePushHash", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).putLong("lastParsePushTimestamp", l2);
    ((SharedPreferences.Editor)localObject2).apply();
    j = 0;
    i = j;
    if (localJNIActivity != null)
    {
      i = j;
      if ((localJNIActivity instanceof WotBlitz))
      {
        i = j;
        if (((WotBlitz)localJNIActivity).isRunning())
        {
          i = 1;
          Log.d("DAVA", "Suppressing notification because application is in foreground");
        }
      }
    }
    j = i;
    if (str1.equals(localObject1))
    {
      j = i;
      if (Math.abs(l2 - l1) < 60L)
      {
        j = 1;
        Log.d("DAVA", "Suppressing duplicate notification");
      }
    }
    if (j == 0) {
      super.onPushReceive(paramContext, paramIntent);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/BlitzPushBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */