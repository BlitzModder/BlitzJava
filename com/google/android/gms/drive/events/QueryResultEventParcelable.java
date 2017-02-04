package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable
  extends WriteAwareParcelable
  implements DriveEvent
{
  public static final zzk CREATOR = new zzk();
  final int mVersionCode;
  final DataHolder zzafC;
  final boolean zzanW;
  final int zzanX;
  
  QueryResultEventParcelable(int paramInt1, DataHolder paramDataHolder, boolean paramBoolean, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzafC = paramDataHolder;
    this.zzanW = paramBoolean;
    this.zzanX = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void zzJ(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public DataHolder zzsA()
  {
    return this.zzafC;
  }
  
  public boolean zzsB()
  {
    return this.zzanW;
  }
  
  public int zzsC()
  {
    return this.zzanX;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/QueryResultEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */