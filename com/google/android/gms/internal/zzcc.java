package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzcc
{
  public zzcb zza(zzca paramzzca)
  {
    if (paramzzca == null) {
      throw new IllegalArgumentException("CSI configuration can't be null. ");
    }
    if (!paramzzca.zzdn())
    {
      zzb.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
      return null;
    }
    if (paramzzca.getContext() == null) {
      throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
    if (TextUtils.isEmpty(paramzzca.zzbY())) {
      throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
    }
    return new zzcb(paramzzca.getContext(), paramzzca.zzbY(), paramzzca.zzdo(), paramzzca.zzdp());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */