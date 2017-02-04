package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;

class zzc
  extends zza
{
  public zzc(byte[] paramArrayOfByte)
  {
    super(zzt(paramArrayOfByte));
  }
  
  private static byte[] zzt(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length == 10) || (paramArrayOfByte.length == 16)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Bytes must be a namespace (10 bytes), or a namespace plus instance ID (16 bytes).");
      return paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    return "EddystoneUidPrefix{bytes=" + zzCC() + '}';
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */