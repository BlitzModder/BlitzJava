package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AttestationData
  implements SafeParcelable
{
  public static final Parcelable.Creator<AttestationData> CREATOR = new zza();
  public final int mVersionCode;
  private String zzbbh;
  
  AttestationData(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzbbh = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getJwsResult()
  {
    return this.zzbbh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/safetynet/AttestationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */