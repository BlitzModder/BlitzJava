package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzjp
{
  public zzjn zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel)
  {
    return zza(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, null, null);
  }
  
  public zzjn zza(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzch paramzzch, zzd paramzzd)
  {
    paramContext = new zzjq(zzjr.zzb(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzch, paramzzd));
    paramContext.setWebViewClient(zzp.zzbz().zzb(paramContext, paramBoolean2));
    paramContext.setWebChromeClient(zzp.zzbz().zzh(paramContext));
    return paramContext;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */