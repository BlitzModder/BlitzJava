package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListEntriesResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new zzbd();
  final int mVersionCode;
  final boolean zzaoG;
  final DataHolder zzaqp;
  
  OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaqp = paramDataHolder;
    this.zzaoG = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void zzJ(Parcel paramParcel, int paramInt)
  {
    zzbd.zza(this, paramParcel, paramInt);
  }
  
  public DataHolder zzsU()
  {
    return this.zzaqp;
  }
  
  public boolean zzsV()
  {
    return this.zzaoG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnListEntriesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */