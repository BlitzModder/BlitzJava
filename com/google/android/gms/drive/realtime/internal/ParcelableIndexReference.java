package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzr();
  final int mIndex;
  final int mVersionCode;
  final String zzasF;
  final boolean zzasG;
  final int zzasH;
  
  ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzasF = paramString;
    this.mIndex = paramInt2;
    this.zzasG = paramBoolean;
    this.zzasH = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableIndexReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */