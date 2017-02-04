package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldChangedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<FieldChangedDetails> CREATOR = new zza();
  final int mVersionCode;
  final int zzasI;
  
  FieldChangedDetails(int paramInt1, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzasI = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/FieldChangedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */