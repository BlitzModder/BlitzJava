package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public class NativeAdOptionsParcel
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int versionCode;
  public final boolean zzyc;
  public final int zzyd;
  public final boolean zzye;
  
  public NativeAdOptionsParcel(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    this.versionCode = paramInt1;
    this.zzyc = paramBoolean1;
    this.zzyd = paramInt2;
    this.zzye = paramBoolean2;
  }
  
  public NativeAdOptionsParcel(NativeAdOptions paramNativeAdOptions)
  {
    this(1, paramNativeAdOptions.shouldReturnUrlsForImageAssets(), paramNativeAdOptions.getImageOrientation(), paramNativeAdOptions.shouldRequestMultipleImages());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/NativeAdOptionsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */