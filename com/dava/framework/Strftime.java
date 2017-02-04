package com.dava.framework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class Strftime
{
  protected static Properties translate = new Properties();
  protected SimpleDateFormat simpleDateFormat;
  
  static
  {
    translate.put("a", "EEE");
    translate.put("A", "EEEE");
    translate.put("b", "MMM");
    translate.put("B", "MMMM");
    translate.put("c", "EEE MMM d HH:mm:ss yyyy");
    translate.put("d", "dd");
    translate.put("D", "MM/dd/yy");
    translate.put("e", "dd");
    translate.put("F", "yyyy-MM-dd");
    translate.put("g", "yy");
    translate.put("G", "yyyy");
    translate.put("H", "HH");
    translate.put("h", "MMM");
    translate.put("I", "hh");
    translate.put("j", "DDD");
    translate.put("k", "HH");
    translate.put("l", "hh");
    translate.put("m", "MM");
    translate.put("M", "mm");
    translate.put("n", "\n");
    translate.put("p", "a");
    translate.put("P", "a");
    translate.put("r", "hh:mm:ss a");
    translate.put("R", "HH:mm");
    translate.put("S", "ss");
    translate.put("t", "\t");
    translate.put("T", "HH:mm:ss");
    translate.put("V", "ww");
    translate.put("X", "HH:mm:ss");
    translate.put("x", "MM/dd/yy");
    translate.put("y", "yy");
    translate.put("Y", "yyyy");
    translate.put("Z", "z");
    translate.put("z", "Z");
    translate.put("%", "%");
  }
  
  public Strftime(String paramString)
  {
    this.simpleDateFormat = new SimpleDateFormat(convertDateFormat(paramString));
  }
  
  public Strftime(String paramString, Locale paramLocale)
  {
    this.simpleDateFormat = new SimpleDateFormat(convertDateFormat(paramString), paramLocale);
  }
  
  protected String convertDateFormat(String paramString)
  {
    boolean bool1 = false;
    int i = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int k = 0;
    if (k < paramString.length())
    {
      char c = paramString.charAt(k);
      if ((c == '%') && (i == 0)) {
        i = 1;
      }
      for (;;)
      {
        k += 1;
        break;
        if (i != 0)
        {
          if (j != 0)
          {
            j = 0;
            i = 0;
          }
          else
          {
            bool1 = translateCommand(localStringBuffer, paramString, k, bool1);
            if ((c == 'O') || (c == 'E')) {
              j = 1;
            } else {
              i = 0;
            }
          }
        }
        else
        {
          boolean bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (c != ' ')
            {
              localStringBuffer.append("'");
              bool2 = true;
            }
          }
          localStringBuffer.append(c);
          bool1 = bool2;
        }
      }
    }
    if ((localStringBuffer.length() > 0) && (localStringBuffer.charAt(localStringBuffer.length() - 1) != '\'') && (bool1)) {
      localStringBuffer.append('\'');
    }
    return localStringBuffer.toString();
  }
  
  public String format(Date paramDate)
  {
    return this.simpleDateFormat.format(paramDate);
  }
  
  public TimeZone getTimeZone()
  {
    return this.simpleDateFormat.getTimeZone();
  }
  
  protected String quote(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (!paramBoolean) {
      str = '\'' + paramString + '\'';
    }
    return str;
  }
  
  public void setTimeZone(TimeZone paramTimeZone)
  {
    this.simpleDateFormat.setTimeZone(paramTimeZone);
  }
  
  protected boolean translateCommand(StringBuffer paramStringBuffer, String paramString, int paramInt, boolean paramBoolean)
  {
    char c = paramString.charAt(paramInt);
    if ((c == 'O') || (c == 'E'))
    {
      if (paramInt + 1 < paramString.length()) {
        return translateCommand(paramStringBuffer, paramString, paramInt + 1, paramBoolean);
      }
      paramStringBuffer.append(quote("%" + c, paramBoolean));
      return paramBoolean;
    }
    paramString = translate.getProperty(String.valueOf(c));
    if (paramString == null)
    {
      paramStringBuffer.append(quote("%" + c, paramBoolean));
      return paramBoolean;
    }
    if (paramBoolean) {
      paramStringBuffer.append('\'');
    }
    paramStringBuffer.append(paramString);
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/Strftime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */