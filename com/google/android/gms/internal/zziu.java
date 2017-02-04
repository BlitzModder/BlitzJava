package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzha
public class zziu
{
  private static zzl zzLk;
  public static final zza<Void> zzLl = new zza()
  {
    public Void zzhj()
    {
      return null;
    }
    
    public Void zzi(InputStream paramAnonymousInputStream)
    {
      return null;
    }
  };
  private static final Object zzqf = new Object();
  
  public zziu(Context paramContext)
  {
    zzLk = zzR(paramContext);
  }
  
  private static zzl zzR(Context paramContext)
  {
    synchronized (zzqf)
    {
      if (zzLk == null) {
        zzLk = zzac.zza(paramContext.getApplicationContext());
      }
      paramContext = zzLk;
      return paramContext;
    }
  }
  
  public <T> zzje<T> zza(String paramString, zza<T> paramzza)
  {
    zzc localzzc = new zzc(null);
    zzLk.zze(new zzb(paramString, paramzza, localzzc));
    return localzzc;
  }
  
  public zzje<String> zza(final String paramString, final Map<String, String> paramMap)
  {
    final zzc localzzc = new zzc(null);
    paramString = new zzab(paramString, localzzc, new zzm.zza()
    {
      public void zze(zzr paramAnonymouszzr)
      {
        zzb.zzaH("Failed to load URL: " + paramString + "\n" + paramAnonymouszzr.toString());
        localzzc.zzb(null);
      }
    })
    {
      public Map<String, String> getHeaders()
        throws zza
      {
        if (paramMap == null) {
          return super.getHeaders();
        }
        return paramMap;
      }
    };
    zzLk.zze(paramString);
    return localzzc;
  }
  
  public static abstract interface zza<T>
  {
    public abstract T zzgc();
    
    public abstract T zzh(InputStream paramInputStream);
  }
  
  private static class zzb<T>
    extends zzk<InputStream>
  {
    private final zziu.zza<T> zzLp;
    private final zzm.zzb<T> zzaG;
    
    public zzb(String paramString, final zziu.zza<T> paramzza, zzm.zzb<T> paramzzb)
    {
      super(paramString, new zzm.zza()
      {
        public void zze(zzr paramAnonymouszzr)
        {
          zziu.zzb.this.zzb(paramzza.zzgc());
        }
      });
      this.zzLp = paramzza;
      this.zzaG = paramzzb;
    }
    
    protected zzm<InputStream> zza(zzi paramzzi)
    {
      return zzm.zza(new ByteArrayInputStream(paramzzi.data), zzx.zzb(paramzzi));
    }
    
    protected void zzj(InputStream paramInputStream)
    {
      this.zzaG.zzb(this.zzLp.zzh(paramInputStream));
    }
  }
  
  private class zzc<T>
    extends zzjb<T>
    implements zzm.zzb<T>
  {
    private zzc() {}
    
    public void zzb(T paramT)
    {
      super.zzf(paramT);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */