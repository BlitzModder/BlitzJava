package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent
  implements DriveEvent
{
  public static final Parcelable.Creator<ProgressEvent> CREATOR = new zzh();
  final int mVersionCode;
  final int zzAk;
  final int zzZU;
  final DriveId zzamF;
  final long zzanU;
  final long zzanV;
  
  ProgressEvent(int paramInt1, DriveId paramDriveId, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzamF = paramDriveId;
    this.zzAk = paramInt2;
    this.zzanU = paramLong1;
    this.zzanV = paramLong2;
    this.zzZU = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ProgressEvent)paramObject;
      if ((!zzw.equal(this.zzamF, ((ProgressEvent)paramObject).zzamF)) || (this.zzAk != ((ProgressEvent)paramObject).zzAk) || (this.zzanU != ((ProgressEvent)paramObject).zzanU)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzanV == ((ProgressEvent)paramObject).zzanV);
    return false;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzamF, Integer.valueOf(this.zzAk), Long.valueOf(this.zzanU), Long.valueOf(this.zzanV) });
  }
  
  public String toString()
  {
    return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[] { this.zzamF, Integer.valueOf(this.zzAk), Long.valueOf(this.zzanU), Long.valueOf(this.zzanV) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/ProgressEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */