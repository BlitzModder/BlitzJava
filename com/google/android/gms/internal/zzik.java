package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.math.BigInteger;
import java.util.Locale;

@zzha
public final class zzik
{
  private static String zzKs;
  private static final Object zzqf = new Object();
  
  public static String zza(Context paramContext, String paramString1, String paramString2)
  {
    synchronized (zzqf)
    {
      if ((zzKs == null) && (!TextUtils.isEmpty(paramString1))) {
        zzb(paramContext, paramString1, paramString2);
      }
      paramContext = zzKs;
      return paramContext;
    }
  }
  
  private static void zzb(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramContext.createPackageContext(paramString2, 3).getClassLoader();
      Class localClass = Class.forName("com.google.ads.mediation.MediationAdapter", false, paramString2);
      paramContext = new BigInteger(new byte[1]);
      String[] arrayOfString = paramString1.split(",");
      int i = 0;
      while (i < arrayOfString.length)
      {
        paramString1 = paramContext;
        if (zzp.zzbx().zza(paramString2, localClass, arrayOfString[i])) {
          paramString1 = paramContext.setBit(i);
        }
        i += 1;
        paramContext = paramString1;
      }
    }
    catch (Throwable paramContext)
    {
      zzKs = "err";
      return;
    }
    tmp96_93[0] = paramContext;
    zzKs = String.format(Locale.US, "%X", tmp96_93);
  }
  
  public static String zzgW()
  {
    synchronized (zzqf)
    {
      String str = zzKs;
      return str;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */