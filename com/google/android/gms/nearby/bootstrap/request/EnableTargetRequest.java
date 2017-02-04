package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzqu.zza;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class EnableTargetRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final String description;
  private final String name;
  final int versionCode;
  private final byte zzaVU;
  private final zzqt zzaVW;
  private final zzqu zzaVX;
  private final zzqv zzaVY;
  
  EnableTargetRequest(int paramInt, String paramString1, String paramString2, byte paramByte, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.name = zzx.zzcG(paramString1);
    this.description = ((String)zzx.zzy(paramString2));
    this.zzaVU = paramByte;
    zzx.zzy(paramIBinder1);
    this.zzaVW = zzqt.zza.zzdl(paramIBinder1);
    zzx.zzy(paramIBinder2);
    this.zzaVX = zzqu.zza.zzdm(paramIBinder2);
    zzx.zzy(paramIBinder3);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder3);
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public byte zzCk()
  {
    return this.zzaVU;
  }
  
  public IBinder zzCp()
  {
    if (this.zzaVW == null) {
      return null;
    }
    return this.zzaVW.asBinder();
  }
  
  public IBinder zzCq()
  {
    if (this.zzaVX == null) {
      return null;
    }
    return this.zzaVX.asBinder();
  }
  
  public IBinder zzui()
  {
    if (this.zzaVY == null) {
      return null;
    }
    return this.zzaVY.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/EnableTargetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */