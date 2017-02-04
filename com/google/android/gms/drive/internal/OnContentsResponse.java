package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnContentsResponse> CREATOR = new zzaw();
  final int mVersionCode;
  final Contents zzaoW;
  final boolean zzaqc;
  
  OnContentsResponse(int paramInt, Contents paramContents, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaoW = paramContents;
    this.zzaqc = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaw.zza(this, paramParcel, paramInt);
  }
  
  public Contents zzsO()
  {
    return this.zzaoW;
  }
  
  public boolean zzsP()
  {
    return this.zzaqc;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnContentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */