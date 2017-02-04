package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public final class ProvideContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();
  final int versionCode;
  public IBinder zzaXX;
  public zzb zzaXY;
  @Deprecated
  public List<SharedContent> zzaXZ;
  public long zzaYa;
  public zzc zzaYb;
  
  ProvideContentRequest()
  {
    this.versionCode = 1;
  }
  
  ProvideContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, List<SharedContent> paramList, long paramLong, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.zzaXX = paramIBinder1;
    this.zzaXY = zzb.zza.zzdB(paramIBinder2);
    this.zzaXZ = paramList;
    this.zzaYa = paramLong;
    this.zzaYb = zzc.zza.zzdC(paramIBinder3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzCJ()
  {
    return this.zzaYb.asBinder();
  }
  
  IBinder zzCU()
  {
    if (this.zzaXY == null) {
      return null;
    }
    return this.zzaXY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/internal/ProvideContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */