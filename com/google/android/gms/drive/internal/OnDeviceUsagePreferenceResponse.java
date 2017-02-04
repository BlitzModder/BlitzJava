package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
  final int mVersionCode;
  final FileUploadPreferencesImpl zzaqd;
  
  OnDeviceUsagePreferenceResponse(int paramInt, FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this.mVersionCode = paramInt;
    this.zzaqd = paramFileUploadPreferencesImpl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzax.zza(this, paramParcel, paramInt);
  }
  
  public FileUploadPreferencesImpl zzsQ()
  {
    return this.zzaqd;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnDeviceUsagePreferenceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */