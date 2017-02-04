package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new zzbg();
  final int mVersionCode;
  final boolean zzqh;
  
  OnLoadRealtimeResponse(int paramInt, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzqh = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnLoadRealtimeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */