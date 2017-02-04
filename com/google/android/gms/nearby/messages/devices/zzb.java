package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class zzb
{
  private final zzc zzaXc;
  
  public zzb(byte[] paramArrayOfByte)
  {
    this.zzaXc = new zzc(zzt(paramArrayOfByte));
  }
  
  private static byte[] zzt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Bytes must be a namespace plus instance ID (16 bytes).");
      return paramArrayOfByte;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzb)) {
      return false;
    }
    paramObject = (zzb)paramObject;
    return zzw.equal(this.zzaXc, ((zzb)paramObject).zzaXc);
  }
  
  public String getId()
  {
    return this.zzaXc.zzCC();
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXc });
  }
  
  public String toString()
  {
    return "EddystoneUid{id=" + getId() + '}';
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */