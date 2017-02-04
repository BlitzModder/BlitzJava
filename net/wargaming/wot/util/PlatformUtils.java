package net.wargaming.wot.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.dava.framework.JNIApplication;
import java.text.NumberFormat;
import java.util.Currency;
import net.wargaming.wot.blitz.AndroidHelpers;

public class PlatformUtils
{
  public static String formatPrice(double paramDouble, String paramString)
  {
    paramString = Currency.getInstance(paramString);
    NumberFormat localNumberFormat = NumberFormat.getCurrencyInstance();
    localNumberFormat.setCurrency(paramString);
    localNumberFormat.setMaximumFractionDigits(paramString.getDefaultFractionDigits());
    return localNumberFormat.format(paramDouble);
  }
  
  public static String getAdvertisingId()
  {
    return AndroidHelpers.getAdvertisingId();
  }
  
  public static boolean isAdvertisingIdAvailable()
  {
    return !AndroidHelpers.isLimitAdTrackingEnabled();
  }
  
  public static void openUrlInNativeAppOrBrowser(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
    }
    catch (Exception paramString1)
    {
      try
      {
        paramString1.addFlags(268435456);
        JNIApplication.GetApplication().getApplicationContext().startActivity(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
      paramString1 = paramString1;
    }
    paramString1.addFlags(268435456);
    JNIApplication.GetApplication().getApplicationContext().startActivity(paramString1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/PlatformUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */