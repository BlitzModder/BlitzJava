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
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final String description;
  private final String name;
  private final long timeoutMillis;
  final int versionCode;
  private final byte zzaVU;
  private final Device zzaVV;
  private final zzqt zzaVW;
  private final zzqu zzaVX;
  private final zzqv zzaVY;
  private final String zzaVZ;
  private final byte zzaWa;
  
  ConnectRequest(int paramInt, Device paramDevice, String paramString1, String paramString2, byte paramByte1, long paramLong, String paramString3, byte paramByte2, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.zzaVV = ((Device)zzx.zzy(paramDevice));
    this.name = zzx.zzcG(paramString1);
    this.description = ((String)zzx.zzy(paramString2));
    this.zzaVU = paramByte1;
    this.timeoutMillis = paramLong;
    this.zzaWa = paramByte2;
    this.zzaVZ = paramString3;
    zzx.zzy(paramIBinder1);
    this.zzaVW = zzqt.zza.zzdl(paramIBinder1);
    zzx.zzy(paramIBinder2);
    this.zzaVX = zzqu.zza.zzdm(paramIBinder2);
    zzx.zzy(paramIBinder3);
    this.zzaVY = zzqv.zza.zzdn(paramIBinder3);
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
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
  
  public String getToken()
  {
    return this.zzaVZ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public byte zzCk()
  {
    return this.zzaVU;
  }
  
  public Device zzCm()
  {
    return this.zzaVV;
  }
  
  public long zzCn()
  {
    return this.timeoutMillis;
  }
  
  public byte zzCo()
  {
    return this.zzaWa;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/bootstrap/request/ConnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */