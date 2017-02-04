package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztp.zzd;
import java.util.ArrayList;

public class zzb
{
  private final ArrayList<zza> zzaYr = new ArrayList();
  private int zzaYs;
  
  public zzb()
  {
    this(100);
  }
  
  public zzb(int paramInt)
  {
    this.zzaYs = paramInt;
  }
  
  private void zzDa()
  {
    while (getSize() > getCapacity()) {
      this.zzaYr.remove(0);
    }
  }
  
  public void clear()
  {
    this.zzaYr.clear();
  }
  
  public int getCapacity()
  {
    return this.zzaYs;
  }
  
  public int getSize()
  {
    return this.zzaYr.size();
  }
  
  public boolean isEmpty()
  {
    return this.zzaYr.isEmpty();
  }
  
  public ArrayList<zza> zzCZ()
  {
    return this.zzaYr;
  }
  
  public void zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    this.zzaYr.add(new zza(paramPlayLoggerContext, paramLogEvent, null));
    zzDa();
  }
  
  public static class zza
  {
    public final PlayLoggerContext zzaYt;
    public final LogEvent zzaYu;
    public final zztp.zzd zzaYv;
    
    private zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
    {
      this.zzaYt = ((PlayLoggerContext)zzx.zzy(paramPlayLoggerContext));
      this.zzaYu = ((LogEvent)zzx.zzy(paramLogEvent));
      this.zzaYv = null;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/playlog/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */