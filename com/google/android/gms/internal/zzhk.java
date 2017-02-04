package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzha
public abstract class zzhk
{
  public abstract void zza(Context paramContext, zzhe paramzzhe, VersionInfoParcel paramVersionInfoParcel);
  
  protected void zze(zzhe paramzzhe)
  {
    paramzzhe.zzgq();
    if (paramzzhe.zzgo() != null) {
      paramzzhe.zzgo().release();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */