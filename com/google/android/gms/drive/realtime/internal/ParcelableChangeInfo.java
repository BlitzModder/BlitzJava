package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

public class ParcelableChangeInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableChangeInfo> CREATOR = new zzp();
  final int mVersionCode;
  final long zzacS;
  final List<ParcelableEvent> zzpw;
  
  ParcelableChangeInfo(int paramInt, long paramLong, List<ParcelableEvent> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzacS = paramLong;
    this.zzpw = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableChangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */