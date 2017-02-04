package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzar();
  final int mVersionCode;
  final DriveId zzamF;
  final boolean zzapN;
  final List<String> zzapO;
  final boolean zzapP;
  final DataHolder zzapQ;
  final String zzapR;
  
  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, DataHolder paramDataHolder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzamF = paramDriveId;
    this.zzapN = paramBoolean1;
    this.zzapO = paramList;
    this.zzapP = paramBoolean2;
    this.zzapQ = paramDataHolder;
    this.zzapR = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzar.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/LoadRealtimeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */