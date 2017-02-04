package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

public class zzd
{
  private final zze zzaXd;
  
  public zzd(byte[] paramArrayOfByte)
  {
    this.zzaXd = new zze(zzt(paramArrayOfByte));
  }
  
  private static byte[] zzt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 20) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
      return paramArrayOfByte;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzd)) {
      return false;
    }
    paramObject = (zzd)paramObject;
    return zzw.equal(this.zzaXd, ((zzd)paramObject).zzaXd);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXd });
  }
  
  public String toString()
  {
    return "IBeaconId{proximityUuid=" + zzCD() + ", major=" + zzCE() + ", minor=" + zzCF() + '}';
  }
  
  public UUID zzCD()
  {
    return this.zzaXd.zzCD();
  }
  
  public short zzCE()
  {
    return this.zzaXd.zzCG().shortValue();
  }
  
  public short zzCF()
  {
    return this.zzaXd.zzCH().shortValue();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */