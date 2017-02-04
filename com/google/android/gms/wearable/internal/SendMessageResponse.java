package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SendMessageResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<SendMessageResponse> CREATOR = new zzbx();
  public final int statusCode;
  public final int versionCode;
  public final int zzaKw;
  
  SendMessageResponse(int paramInt1, int paramInt2, int paramInt3)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.zzaKw = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbx.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/SendMessageResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */