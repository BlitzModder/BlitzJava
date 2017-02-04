package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zze();
  final int mVersionCode;
  final String zzatd;
  final String zzate;
  final int zzatf;
  final int zzatg;
  
  ReferenceShiftedDetails(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzatd = paramString1;
    this.zzate = paramString2;
    this.zzatf = paramInt2;
    this.zzatg = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ReferenceShiftedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */