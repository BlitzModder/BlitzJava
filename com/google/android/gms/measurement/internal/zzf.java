package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzf
  extends zzw
{
  private long zzaSA;
  private String zzaSB;
  
  zzf(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  public String zzBe()
  {
    zzje();
    return Build.VERSION.RELEASE;
  }
  
  public long zzBf()
  {
    zzje();
    return this.zzaSA;
  }
  
  public String zzBg()
  {
    zzje();
    return this.zzaSB;
  }
  
  public String zzhb()
  {
    zzje();
    return Build.MODEL;
  }
  
  protected void zzir()
  {
    Object localObject = Calendar.getInstance();
    TimeUnit localTimeUnit = TimeUnit.MINUTES;
    int i = ((Calendar)localObject).get(15);
    this.zzaSA = localTimeUnit.convert(((Calendar)localObject).get(16) + i, TimeUnit.MILLISECONDS);
    localObject = Locale.getDefault();
    this.zzaSB = (((Locale)localObject).getLanguage().toLowerCase(Locale.ENGLISH) + "-" + ((Locale)localObject).getCountry().toLowerCase(Locale.ENGLISH));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */