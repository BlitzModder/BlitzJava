package com.dava.framework;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class JNIDateTime
{
  static final String TAG = "JNIDateTime";
  
  public static int GetLocalTimeZoneOffset()
  {
    return TimeZone.getDefault().getOffset(new Date().getTime()) / 1000;
  }
  
  public static String GetTimeAsString(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    TimeZone localTimeZone = TimeZone.getTimeZone("UTC");
    localTimeZone.setRawOffset(paramInt * 1000);
    paramString2 = paramString2.split("_");
    Locale localLocale = new Locale(paramString2[0], paramString2[1]);
    paramString2 = new Date();
    paramString2.setTime(1000L * paramLong);
    if (paramString1.equals("%x"))
    {
      paramString1 = DateFormat.getDateInstance(3, localLocale);
      paramString1.setTimeZone(localTimeZone);
      return paramString1.format(paramString2);
    }
    if (paramString1.equals("%X"))
    {
      paramString1 = DateFormat.getTimeInstance(2, localLocale);
      paramString1.setTimeZone(localTimeZone);
      return paramString1.format(paramString2);
    }
    paramString1 = new Strftime(paramString1, localLocale);
    paramString1.setTimeZone(localTimeZone);
    return paramString1.format(paramString2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIDateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */