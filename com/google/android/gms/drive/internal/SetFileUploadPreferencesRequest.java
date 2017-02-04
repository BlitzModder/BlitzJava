package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbr();
  final int mVersionCode;
  final FileUploadPreferencesImpl zzaqd;
  
  SetFileUploadPreferencesRequest(int paramInt, FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this.mVersionCode = paramInt;
    this.zzaqd = paramFileUploadPreferencesImpl;
  }
  
  public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this(1, paramFileUploadPreferencesImpl);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbr.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/SetFileUploadPreferencesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */