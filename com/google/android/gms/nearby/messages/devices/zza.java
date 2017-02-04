package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

abstract class zza
{
  private static final char[] zzaXa = "0123456789abcdef".toCharArray();
  private final byte[] zzaXb;
  
  protected zza(byte[] paramArrayOfByte)
  {
    this.zzaXb = paramArrayOfByte;
  }
  
  static String zzs(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(zzaXa[(k >> 4 & 0xF)]).append(zzaXa[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!paramObject.getClass().isAssignableFrom(getClass())) {
      return false;
    }
    paramObject = (zza)paramObject;
    return Arrays.equals(this.zzaXb, ((zza)paramObject).zzaXb);
  }
  
  byte[] getBytes()
  {
    return this.zzaXb;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.zzaXb);
  }
  
  public String toString()
  {
    return zzs(this.zzaXb);
  }
  
  String zzCC()
  {
    return zzs(this.zzaXb);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/devices/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */