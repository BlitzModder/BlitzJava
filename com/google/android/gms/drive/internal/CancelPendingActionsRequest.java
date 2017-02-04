package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CancelPendingActionsRequest> CREATOR = new zze();
  final int mVersionCode;
  final List<String> zzanK;
  
  CancelPendingActionsRequest(int paramInt, List<String> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzanK = paramList;
  }
  
  public CancelPendingActionsRequest(List<String> paramList)
  {
    this(1, paramList);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/CancelPendingActionsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */