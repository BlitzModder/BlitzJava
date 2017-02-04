package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;

public final class zzt
  extends zzaw.zza
{
  private zzm zzbnf;
  private zzu zzbnj;
  private final Object zzpK = new Object();
  
  public void zza(zzu paramzzu)
  {
    synchronized (this.zzpK)
    {
      this.zzbnj = ((zzu)zzx.zzy(paramzzu));
      zzm localzzm = this.zzbnf;
      if (localzzm != null) {
        paramzzu.zzb(localzzm);
      }
      return;
    }
  }
  
  public void zzx(int paramInt1, int paramInt2)
  {
    synchronized (this.zzpK)
    {
      zzu localzzu = this.zzbnj;
      zzm localzzm = new zzm(paramInt1, paramInt2);
      this.zzbnf = localzzm;
      if (localzzu != null) {
        localzzu.zzb(localzzm);
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */