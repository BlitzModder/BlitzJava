package net.wargaming.wot.blitz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.mobileapptracker.Tracker;

public class BlitzInstallReferrerReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new Tracker().onReceive(paramContext, paramIntent);
    new CampaignTrackingReceiver().onReceive(paramContext, paramIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/BlitzInstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */