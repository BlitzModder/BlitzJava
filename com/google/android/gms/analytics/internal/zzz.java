package com.google.android.gms.analytics.internal;

public class zzz
  extends zzq<zzaa>
{
  public zzz(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    implements zzq.zza<zzaa>
  {
    private final zzf zzOP;
    private final zzaa zzRj;
    
    public zza(zzf paramzzf)
    {
      this.zzOP = paramzzf;
      this.zzRj = new zzaa();
    }
    
    public void zzc(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString))
      {
        this.zzRj.zzRn = paramInt;
        return;
      }
      this.zzOP.zziU().zzd("Int xml configuration name not recognized", paramString);
    }
    
    public void zzc(String paramString, boolean paramBoolean)
    {
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.zzRj;
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          paramString.zzRo = i;
          return;
        }
      }
      this.zzOP.zziU().zzd("Bool xml configuration name not recognized", paramString);
    }
    
    public void zzk(String paramString1, String paramString2) {}
    
    public zzaa zzkN()
    {
      return this.zzRj;
    }
    
    public void zzl(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1))
      {
        this.zzRj.zzRk = paramString2;
        return;
      }
      if ("ga_appVersion".equals(paramString1))
      {
        this.zzRj.zzRl = paramString2;
        return;
      }
      if ("ga_logLevel".equals(paramString1))
      {
        this.zzRj.zzRm = paramString2;
        return;
      }
      this.zzOP.zziU().zzd("String xml configuration name not recognized", paramString1);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */