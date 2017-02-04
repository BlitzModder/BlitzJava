package com.dava.framework;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Window;
import java.util.UUID;

public class JNIUtils
{
  private static boolean isEnabledSleepTimer = true;
  
  public static void DisableSleepTimer()
  {
    isEnabledSleepTimer = false;
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        JNIActivity.GetActivity().getWindow().addFlags(128);
      }
    });
  }
  
  public static void EnableSleepTimer()
  {
    isEnabledSleepTimer = true;
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        JNIActivity.GetActivity().getWindow().clearFlags(128);
      }
    });
  }
  
  public static String GenerateGUID()
  {
    return UUID.randomUUID().toString();
  }
  
  public static void OpenURL(String paramString)
  {
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        try
        {
          JNIActivity localJNIActivity = JNIActivity.GetActivity();
          if (localJNIActivity != null)
          {
            if (localJNIActivity.GetIsPausing()) {
              return;
            }
            Log.i(JNIConst.LOG_TAG, "[OpenURL] " + this.val$url);
            localJNIActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.val$url)));
            return;
          }
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.i(JNIConst.LOG_TAG, "[OpenURL] failed with exeption: " + localActivityNotFoundException.toString());
        }
      }
    });
  }
  
  protected static void keepScreenOnOnResume()
  {
    if (!isEnabledSleepTimer) {
      JNIActivity.GetActivity().getWindow().addFlags(128);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */