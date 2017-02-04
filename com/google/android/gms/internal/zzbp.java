package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzha
public class zzbp
  extends zzbm
{
  private MessageDigest zztl;
  
  byte[] zza(String[] paramArrayOfString)
  {
    byte[] arrayOfByte = new byte[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfByte[i] = zzk(zzbo.zzC(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  byte zzk(int paramInt)
  {
    return (byte)(paramInt & 0xFF ^ (0xFF00 & paramInt) >> 8 ^ (0xFF0000 & paramInt) >> 16 ^ (0xFF000000 & paramInt) >> 24);
  }
  
  public byte[] zzz(String arg1)
  {
    byte[] arrayOfByte1 = zza(???.split(" "));
    this.zztl = zzcG();
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zztl == null) {
          return new byte[0];
        }
        this.zztl.reset();
        this.zztl.update(arrayOfByte1);
        arrayOfByte1 = this.zztl.digest();
        i = 4;
        if (arrayOfByte1.length > 4)
        {
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          return arrayOfByte2;
        }
      }
      int i = localObject.length;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */