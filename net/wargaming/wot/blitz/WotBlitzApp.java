package net.wargaming.wot.blitz;

import com.dava.framework.JNIApplication;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.parse.Parse;
import com.parse.ParseInstallation;

public class WotBlitzApp
  extends JNIApplication
{
  private GoogleAnalytics googleAnalytics;
  
  static
  {
    System.loadLibrary("gnustl_shared");
    System.loadLibrary("wotblitz");
    InitCrashlyticsOutput();
    try
    {
      Thread.sleep(0L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  private static native void InitCrashlyticsOutput();
  
  public GoogleAnalytics getGoogleAnalytics()
  {
    return this.googleAnalytics;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Parse.initialize(this, "lScOfCFsESRTRDZ7TFuDAi52iAo210imoEs4fh90", "3OcqRXlpYqRmKTbSIYRxaLvBA20WA2NYEmeiR011");
    ParseInstallation.getCurrentInstallation().saveInBackground();
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == 0)
    {
      this.googleAnalytics = GoogleAnalytics.getInstance(getApplicationContext());
      return;
    }
    this.googleAnalytics = null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/WotBlitzApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */