package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.Map;

@zzha
public class zzdr
  implements zzdl
{
  static final Map<String, Integer> zzzd = zznm.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
  private final zze zzzb;
  private final zzfm zzzc;
  
  public zzdr(zze paramzze, zzfm paramzzfm)
  {
    this.zzzb = paramzze;
    this.zzzc = paramzzfm;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    int i = ((Integer)zzzd.get(str)).intValue();
    if ((i != 5) && (this.zzzb != null) && (!this.zzzb.zzbg()))
    {
      this.zzzb.zzp(null);
      return;
    }
    switch (i)
    {
    case 2: 
    default: 
      zzb.zzaG("Unknown MRAID command called.");
      return;
    case 1: 
      this.zzzc.zzg(paramMap);
      return;
    case 4: 
      new zzfl(paramzzjn, paramMap).execute();
      return;
    case 3: 
      new zzfo(paramzzjn, paramMap).execute();
      return;
    case 5: 
      new zzfn(paramzzjn, paramMap).execute();
      return;
    }
    this.zzzc.zzp(true);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */