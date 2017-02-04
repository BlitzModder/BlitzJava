package net.wargaming.wot.blitz;

import com.parse.ParseInstallation;
import com.parse.ParsePush;

public class ParseBridge
{
  public static String dequeueLaunchOptions()
  {
    return ((WotBlitz)WotBlitz.GetActivity()).dequeueLaunchOptions();
  }
  
  public static void setTargetingCriteria(String paramString1, String paramString2)
  {
    ParseInstallation.getCurrentInstallation().put(paramString1, paramString2);
    ParseInstallation.getCurrentInstallation().saveInBackground();
  }
  
  public static void subscribeInBackground(String paramString)
  {
    ParsePush.subscribeInBackground(paramString);
  }
  
  public static void unsubscribeInBackground(String paramString)
  {
    ParsePush.unsubscribeInBackground(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/ParseBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */