package net.wargaming.wot.blitz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SleepReceiver
  extends BroadcastReceiver
{
  native void onActionScreenOff();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      Log.d("DAVA", "ACTION_SCREEN_OFF");
      onActionScreenOff();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/SleepReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */