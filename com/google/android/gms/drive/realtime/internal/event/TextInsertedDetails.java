package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<TextInsertedDetails> CREATOR = new zzg();
  final int mIndex;
  final int mVersionCode;
  final int zzath;
  
  TextInsertedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.mIndex = paramInt2;
    this.zzath = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/TextInsertedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */