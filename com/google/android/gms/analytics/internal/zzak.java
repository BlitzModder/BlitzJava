package com.google.android.gms.analytics.internal;

import java.util.Map;

public class zzak
  extends zzq<zzal>
{
  public zzak(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    extends zzc
    implements zzq.zza<zzal>
  {
    private final zzal zzRT = new zzal();
    
    public zza(zzf paramzzf)
    {
      super();
    }
    
    public void zzc(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString))
      {
        this.zzRT.zzRV = paramInt;
        return;
      }
      zzd("int configuration name not recognized", paramString);
    }
    
    public void zzc(String paramString, boolean paramBoolean)
    {
      int j = 1;
      int k = 1;
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        paramString = this.zzRT;
        if (paramBoolean) {}
        for (;;)
        {
          paramString.zzRW = i;
          return;
          i = 0;
        }
      }
      if ("ga_anonymizeIp".equals(paramString))
      {
        paramString = this.zzRT;
        if (paramBoolean) {}
        for (i = j;; i = 0)
        {
          paramString.zzRX = i;
          return;
        }
      }
      if ("ga_reportUncaughtExceptions".equals(paramString))
      {
        paramString = this.zzRT;
        if (paramBoolean) {}
        for (i = k;; i = 0)
        {
          paramString.zzRY = i;
          return;
        }
      }
      zzd("bool configuration name not recognized", paramString);
    }
    
    public void zzk(String paramString1, String paramString2)
    {
      this.zzRT.zzRZ.put(paramString1, paramString2);
    }
    
    public void zzl(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1))
      {
        this.zzRT.zzNB = paramString2;
        return;
      }
      if ("ga_sampleFrequency".equals(paramString1)) {
        try
        {
          this.zzRT.zzRU = Double.parseDouble(paramString2);
          return;
        }
        catch (NumberFormatException paramString1)
        {
          zzc("Error parsing ga_sampleFrequency value", paramString2, paramString1);
          return;
        }
      }
      zzd("string configuration name not recognized", paramString1);
    }
    
    public zzal zzlB()
    {
      return this.zzRT;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */