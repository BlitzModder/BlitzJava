package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new zzj();
  final int mVersionCode;
  final List<String> zzanu;
  final List<String> zzanv;
  
  RealtimeDocumentSyncRequest(int paramInt, List<String> paramList1, List<String> paramList2)
  {
    this.mVersionCode = paramInt;
    this.zzanu = ((List)zzx.zzy(paramList1));
    this.zzanv = ((List)zzx.zzy(paramList2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/RealtimeDocumentSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */