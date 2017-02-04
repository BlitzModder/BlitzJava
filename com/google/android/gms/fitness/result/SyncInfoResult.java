package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class SyncInfoResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SyncInfoResult> CREATOR = new zzl();
  private final int mVersionCode;
  private final Status zzTA;
  private final long zzacS;
  
  SyncInfoResult(int paramInt, Status paramStatus, long paramLong)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzacS = paramLong;
  }
  
  private boolean zzb(SyncInfoResult paramSyncInfoResult)
  {
    return (this.zzTA.equals(paramSyncInfoResult.zzTA)) && (zzw.equal(Long.valueOf(this.zzacS), Long.valueOf(paramSyncInfoResult.zzacS)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SyncInfoResult)) && (zzb((SyncInfoResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, Long.valueOf(this.zzacS) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("timestamp", Long.valueOf(this.zzacS)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public long zzuO()
  {
    return this.zzacS;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/SyncInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */