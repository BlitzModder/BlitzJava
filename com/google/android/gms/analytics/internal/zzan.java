package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzan
  extends zzd
{
  protected boolean zzNO;
  protected int zzQh;
  protected String zzRk;
  protected String zzRl;
  protected int zzRn;
  protected boolean zzSb;
  protected boolean zzSc;
  protected boolean zzSd;
  
  public zzan(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private static int zzbv(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ("verbose".equals(paramString)) {
      return 0;
    }
    if ("info".equals(paramString)) {
      return 1;
    }
    if ("warning".equals(paramString)) {
      return 2;
    }
    if ("error".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  public int getLogLevel()
  {
    zzje();
    return this.zzQh;
  }
  
  void zza(zzaa paramzzaa)
  {
    zzba("Loading global XML config values");
    String str;
    if (paramzzaa.zzkO())
    {
      str = paramzzaa.zzkP();
      this.zzRk = str;
      zzb("XML config - app name", str);
    }
    if (paramzzaa.zzkQ())
    {
      str = paramzzaa.zzkR();
      this.zzRl = str;
      zzb("XML config - app version", str);
    }
    int i;
    if (paramzzaa.zzkS())
    {
      i = zzbv(paramzzaa.zzkT());
      if (i >= 0)
      {
        this.zzQh = i;
        zza("XML config - log level", Integer.valueOf(i));
      }
    }
    if (paramzzaa.zzkU())
    {
      i = paramzzaa.zzkV();
      this.zzRn = i;
      this.zzSc = true;
      zzb("XML config - dispatch period (sec)", Integer.valueOf(i));
    }
    if (paramzzaa.zzkW())
    {
      boolean bool = paramzzaa.zzkX();
      this.zzNO = bool;
      this.zzSd = true;
      zzb("XML config - dry run", Boolean.valueOf(bool));
    }
  }
  
  protected void zzir()
  {
    zzlM();
  }
  
  public String zzkP()
  {
    zzje();
    return this.zzRk;
  }
  
  public String zzkR()
  {
    zzje();
    return this.zzRl;
  }
  
  public boolean zzkS()
  {
    zzje();
    return this.zzSb;
  }
  
  public boolean zzkU()
  {
    zzje();
    return this.zzSc;
  }
  
  public boolean zzkW()
  {
    zzje();
    return this.zzSd;
  }
  
  public boolean zzkX()
  {
    zzje();
    return this.zzNO;
  }
  
  public int zzlL()
  {
    zzje();
    return this.zzRn;
  }
  
  protected void zzlM()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
      if (localObject1 == null)
      {
        zzbd("Couldn't get ApplicationInfo to load global config");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject2;
      do
      {
        int i;
        do
        {
          do
          {
            for (;;)
            {
              zzd("PackageManager doesn't know about the app package", localNameNotFoundException);
              localObject2 = null;
            }
            localObject2 = ((ApplicationInfo)localObject2).metaData;
          } while (localObject2 == null);
          i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
        } while (i <= 0);
        localObject2 = (zzaa)new zzz(zziQ()).zzah(i);
      } while (localObject2 == null);
      zza((zzaa)localObject2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */