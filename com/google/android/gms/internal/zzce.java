package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzha
public abstract class zzce
{
  @zzha
  public static final zzce zzwU = new zzce()
  {
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2;
    }
  };
  @zzha
  public static final zzce zzwV = new zzce()
  {
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 != null) {
        return paramAnonymousString1;
      }
      return paramAnonymousString2;
    }
  };
  @zzha
  public static final zzce zzwW = new zzce()
  {
    private String zzQ(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {}
      int i;
      int j;
      do
      {
        return paramAnonymousString;
        i = 0;
        int k = paramAnonymousString.length();
        for (;;)
        {
          j = k;
          if (i >= paramAnonymousString.length()) {
            break;
          }
          j = k;
          if (paramAnonymousString.charAt(i) != ',') {
            break;
          }
          i += 1;
        }
        while ((j > 0) && (paramAnonymousString.charAt(j - 1) == ',')) {
          j -= 1;
        }
      } while ((i == 0) && (j == paramAnonymousString.length()));
      return paramAnonymousString.substring(i, j);
    }
    
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousString1 = zzQ(paramAnonymousString1);
      paramAnonymousString2 = zzQ(paramAnonymousString2);
      if (TextUtils.isEmpty(paramAnonymousString1)) {
        return paramAnonymousString2;
      }
      if (TextUtils.isEmpty(paramAnonymousString2)) {
        return paramAnonymousString1;
      }
      return paramAnonymousString1 + "," + paramAnonymousString2;
    }
  };
  
  public final void zza(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap.put(paramString1, zzc((String)paramMap.get(paramString1), paramString2));
  }
  
  public abstract String zzc(String paramString1, String paramString2);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */