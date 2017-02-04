package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzav();
  final int mVersionCode;
  final DataHolder zzapY;
  final List<DriveId> zzapZ;
  final ChangeSequenceNumber zzaqa;
  final boolean zzaqb;
  
  OnChangesResponse(int paramInt, DataHolder paramDataHolder, List<DriveId> paramList, ChangeSequenceNumber paramChangeSequenceNumber, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzapY = paramDataHolder;
    this.zzapZ = paramList;
    this.zzaqa = paramChangeSequenceNumber;
    this.zzaqb = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void zzJ(Parcel paramParcel, int paramInt)
  {
    zzav.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnChangesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */