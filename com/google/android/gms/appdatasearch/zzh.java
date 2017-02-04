package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private static final String[] zzSH;
  private static final Map<String, Integer> zzSI;
  
  static
  {
    int i = 0;
    zzSH = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    zzSI = new HashMap(zzSH.length);
    while (i < zzSH.length)
    {
      zzSI.put(zzSH[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static String zzao(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= zzSH.length)) {
      return null;
    }
    return zzSH[paramInt];
  }
  
  public static int zzbx(String paramString)
  {
    Integer localInteger = (Integer)zzSI.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    }
    return localInteger.intValue();
  }
  
  public static int zzlP()
  {
    return zzSH.length;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */