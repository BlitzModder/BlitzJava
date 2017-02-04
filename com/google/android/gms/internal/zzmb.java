package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzmb<L>
  implements zzmn.zzb<L>
{
  private final DataHolder zzafC;
  
  protected zzmb(DataHolder paramDataHolder)
  {
    this.zzafC = paramDataHolder;
  }
  
  protected abstract void zza(L paramL, DataHolder paramDataHolder);
  
  public void zzpb()
  {
    if (this.zzafC != null) {
      this.zzafC.close();
    }
  }
  
  public final void zzs(L paramL)
  {
    zza(paramL, this.zzafC);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */