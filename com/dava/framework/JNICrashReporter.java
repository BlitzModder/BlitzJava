package com.dava.framework;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Vector;

public class JNICrashReporter
{
  private static final int JAVA_STACK_OFFSET;
  
  static
  {
    int j = 0;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int k = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      if ((i >= k) || (arrayOfStackTraceElement[i].getClassName().equals(JNICrashReporter.class.getName())))
      {
        JAVA_STACK_OFFSET = j;
        return;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static String GetReport()
  {
    String str1 = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(new Date());
    String str2 = new String();
    str1 = str2 + "\nTime: " + str1 + "\n";
    str1 = str1 + "DeveiceInfo:\n";
    str1 = str1 + "MANUFACTURER: " + Build.MANUFACTURER + "\n";
    str1 = str1 + "MODEL: " + Build.MODEL + "\n";
    str1 = str1 + "OS: " + Build.VERSION.RELEASE + "\n";
    str1 = str1 + "Locale: " + Locale.getDefault().getDisplayLanguage(Locale.US) + "\n";
    str1 = str1 + "Country: " + JNIActivity.GetActivity().getResources().getConfiguration().locale.getCountry() + "\n";
    str1 = str1 + "TimeZone: " + TimeZone.getDefault().getDisplayName(Locale.US) + "\n";
    return str1 + "\n";
  }
  
  public static void ThrowJavaExpetion(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    throws Exception
  {
    Object localObject = Thread.currentThread();
    Vector localVector = new Vector();
    localObject = ((Thread)localObject).getStackTrace();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      localVector.add(new StackTraceElement(paramArrayOfString1[i], paramArrayOfString2[i] + String.format(" ps:%s", new Object[] { Integer.toHexString(paramArrayOfInt[i]) }), paramArrayOfString2[i], paramArrayOfInt[i]));
      i += 1;
    }
    i = JAVA_STACK_OFFSET;
    while (i < localObject.length)
    {
      localVector.add(localObject[i]);
      i += 1;
    }
    paramArrayOfString1 = new Exception(GetReport());
    paramArrayOfString1.setStackTrace((StackTraceElement[])localVector.toArray(new StackTraceElement[localVector.size()]));
    Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramArrayOfString1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNICrashReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */