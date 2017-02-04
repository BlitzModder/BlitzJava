package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzha;

@zzha
public class ThinAdSizeParcel
  extends AdSizeParcel
{
  public ThinAdSizeParcel(AdSizeParcel paramAdSizeParcel)
  {
    super(paramAdSizeParcel.versionCode, paramAdSizeParcel.zztV, paramAdSizeParcel.height, paramAdSizeParcel.heightPixels, paramAdSizeParcel.zztW, paramAdSizeParcel.width, paramAdSizeParcel.widthPixels, paramAdSizeParcel.zztX, paramAdSizeParcel.zztY, paramAdSizeParcel.zztZ, paramAdSizeParcel.zzua);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, this.versionCode);
    zzb.zza(paramParcel, 2, this.zztV, false);
    zzb.zzc(paramParcel, 3, this.height);
    zzb.zzc(paramParcel, 6, this.width);
    zzb.zzI(paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/ThinAdSizeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */