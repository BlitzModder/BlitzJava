package com.google.android.gms.internal;

public class zztb
{
  private final byte[] zzbpD = new byte['Ā'];
  private int zzbpE;
  private int zzbpF;
  
  public zztb(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.zzbpD[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.zzbpD[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.zzbpD[j];
      this.zzbpD[j] = this.zzbpD[k];
      this.zzbpD[k] = i;
      j += 1;
    }
    this.zzbpE = 0;
    this.zzbpF = 0;
  }
  
  public void zzB(byte[] paramArrayOfByte)
  {
    int m = this.zzbpE;
    int k = this.zzbpF;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.zzbpD[m] & 0xFF;
      int i = this.zzbpD[m];
      this.zzbpD[m] = this.zzbpD[k];
      this.zzbpD[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.zzbpD[(this.zzbpD[m] + this.zzbpD[k] & 0xFF)]));
      j += 1;
    }
    this.zzbpE = m;
    this.zzbpF = k;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */