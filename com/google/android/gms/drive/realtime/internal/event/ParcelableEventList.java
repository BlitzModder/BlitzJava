package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zzd();
  final int mVersionCode;
  final DataHolder zzasZ;
  final boolean zzata;
  final List<String> zzatb;
  final ParcelableChangeInfo zzatc;
  final List<ParcelableEvent> zzpw;
  
  ParcelableEventList(int paramInt, List<ParcelableEvent> paramList, DataHolder paramDataHolder, boolean paramBoolean, List<String> paramList1, ParcelableChangeInfo paramParcelableChangeInfo)
  {
    this.mVersionCode = paramInt;
    this.zzpw = paramList;
    this.zzasZ = paramDataHolder;
    this.zzata = paramBoolean;
    this.zzatb = paramList1;
    this.zzatc = paramParcelableChangeInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEventList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */