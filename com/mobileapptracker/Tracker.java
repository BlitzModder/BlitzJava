package com.mobileapptracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.net.URLDecoder;

public class Tracker
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent arg2)
  {
    if (??? != null) {
      try
      {
        if (???.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
          ??? = ???.getStringExtra("referrer");
          if (??? != null)
          {
            ??? = URLDecoder.decode(???, "UTF-8");
            Log.d("MobileAppTracker", "TUNE received referrer " + ???);
            paramContext.getSharedPreferences("com.mobileapptracking", 0).edit().putString("mat_referrer", ???).commit();
            paramContext = MobileAppTracker.getInstance();
            if (paramContext != null)
            {
              paramContext.setInstallReferrer(???);
              if ((paramContext.gotGaid) && (!paramContext.notifiedPool)) {
                synchronized (paramContext.pool)
                {
                  paramContext.pool.notifyAll();
                  paramContext.notifiedPool = true;
                  return;
                }
              }
            }
          }
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */