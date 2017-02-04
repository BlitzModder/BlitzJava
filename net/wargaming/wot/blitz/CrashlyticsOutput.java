package net.wargaming.wot.blitz;

import com.crashlytics.android.Crashlytics;
import net.wargaming.wot.util.UtfHelper;

public class CrashlyticsOutput
{
  public static void CrashlyticsLog(byte[] paramArrayOfByte)
  {
    Crashlytics.log(UtfHelper.fromUtf8(paramArrayOfByte));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/CrashlyticsOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */