package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;

@zzha
public class zzl
  extends zzj
{
  public zzi zza(Context paramContext, zzjn paramzzjn, int paramInt, zzch paramzzch, zzcf paramzzcf)
  {
    if (!zzx(paramContext)) {
      return null;
    }
    return new zzc(paramContext, new zzp(paramContext, paramzzjn.zzhF(), paramzzjn.getRequestId(), paramzzch, paramzzcf));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */