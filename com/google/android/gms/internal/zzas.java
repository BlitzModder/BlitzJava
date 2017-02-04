package com.google.android.gms.internal;

import java.io.IOException;

class zzas
  implements zzaq
{
  private zztd zzol;
  private byte[] zzom;
  private final int zzon;
  
  public zzas(int paramInt)
  {
    this.zzon = paramInt;
    reset();
  }
  
  public void reset()
  {
    this.zzom = new byte[this.zzon];
    this.zzol = zztd.zzD(this.zzom);
  }
  
  public byte[] zzad()
    throws IOException
  {
    int i = this.zzol.zzHx();
    if (i < 0) {
      throw new IOException();
    }
    if (i == 0) {
      return this.zzom;
    }
    byte[] arrayOfByte = new byte[this.zzom.length - i];
    System.arraycopy(this.zzom, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zzol.zzb(paramInt, paramLong);
  }
  
  public void zzb(int paramInt, String paramString)
    throws IOException
  {
    this.zzol.zzb(paramInt, paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */