package com.google.android.gms.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;

@zzha
public class zzea
{
  private final VersionInfoParcel zzpI;
  private final zzd zzpc;
  private final zzew zzpd;
  private MutableContextWrapper zzzz;
  
  zzea(Context paramContext, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this.zzzz = new MutableContextWrapper(paramContext.getApplicationContext());
    this.zzpd = paramzzew;
    this.zzpI = paramVersionInfoParcel;
    this.zzpc = paramzzd;
  }
  
  public zzk zzac(String paramString)
  {
    return new zzk(this.zzzz, new AdSizeParcel(), paramString, this.zzpd, this.zzpI, this.zzpc);
  }
  
  public zzea zzdV()
  {
    return new zzea(this.zzzz.getBaseContext(), this.zzpd, this.zzpI, this.zzpc);
  }
  
  MutableContextWrapper zzdW()
  {
    return this.zzzz;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */