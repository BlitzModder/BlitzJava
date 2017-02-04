package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new zza();
  final int mVersionCode;
  final int zzalo;
  final DriveId zzamF;
  final ChangesAvailableOptions zzanC;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this.mVersionCode = paramInt1;
    this.zzamF = paramDriveId;
    this.zzalo = paramInt2;
    this.zzanC = paramChangesAvailableOptions;
  }
  
  public AddEventListenerRequest(DriveId paramDriveId, int paramInt, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this(1, paramDriveId, paramInt, paramChangesAvailableOptions);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */