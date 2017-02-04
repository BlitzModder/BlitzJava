package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zznx;

public abstract class zzj
{
  public abstract zzi zza(Context paramContext, zzjn paramzzjn, int paramInt, zzch paramzzch, zzcf paramzzcf);
  
  protected boolean zzx(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    return (zznx.zzrQ()) && ((paramContext == null) || (paramContext.targetSdkVersion >= 11));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */