package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zznx;

@zzha
public class zze
{
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    zza(paramContext, paramAdOverlayInfoParcel, true);
  }
  
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((paramAdOverlayInfoParcel.zzDI == 4) && (paramAdOverlayInfoParcel.zzDB == null))
    {
      if (paramAdOverlayInfoParcel.zzDA != null) {
        paramAdOverlayInfoParcel.zzDA.onAdClicked();
      }
      zzp.zzbu().zza(paramContext, paramAdOverlayInfoParcel.zzDz, paramAdOverlayInfoParcel.zzDH);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramAdOverlayInfoParcel.zzqR.zzLH);
    localIntent.putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.zza(localIntent, paramAdOverlayInfoParcel);
    if (!zznx.isAtLeastL()) {
      localIntent.addFlags(524288);
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    zzp.zzbx().zzb(paramContext, localIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */