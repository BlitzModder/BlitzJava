package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BarcodeDetectorOptions
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int versionCode;
  public int zzbiq;
  
  public BarcodeDetectorOptions()
  {
    this.versionCode = 1;
  }
  
  public BarcodeDetectorOptions(int paramInt1, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzbiq = paramInt2;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/barcode/internal/client/BarcodeDetectorOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */