package com.google.android.gms.internal;

import java.io.IOException;

public final class zztc
{
  private final byte[] buffer;
  private int zzbpG;
  private int zzbpH;
  private int zzbpI;
  private int zzbpJ;
  private int zzbpK;
  private int zzbpL = Integer.MAX_VALUE;
  private int zzbpM;
  private int zzbpN = 64;
  private int zzbpO = 67108864;
  
  private zztc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.zzbpG = paramInt1;
    this.zzbpH = (paramInt1 + paramInt2);
    this.zzbpJ = paramInt1;
  }
  
  public static zztc zzC(byte[] paramArrayOfByte)
  {
    return zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void zzHt()
  {
    this.zzbpH += this.zzbpI;
    int i = this.zzbpH;
    if (i > this.zzbpL)
    {
      this.zzbpI = (i - this.zzbpL);
      this.zzbpH -= this.zzbpI;
      return;
    }
    this.zzbpI = 0;
  }
  
  public static zztc zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zztc(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static long zzaa(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static int zzmm(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public int getPosition()
  {
    return this.zzbpJ - this.zzbpG;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = zzHp();
    if ((i <= this.zzbpH - this.zzbpJ) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.zzbpJ, arrayOfByte, 0, i);
      this.zzbpJ = (i + this.zzbpJ);
      return arrayOfByte;
    }
    if (i == 0) {
      return zztn.zzbqi;
    }
    return zzmq(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzHs());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzHr());
  }
  
  public String readString()
    throws IOException
  {
    int i = zzHp();
    if ((i <= this.zzbpH - this.zzbpJ) && (i > 0))
    {
      String str = new String(this.buffer, this.zzbpJ, i, "UTF-8");
      this.zzbpJ = (i + this.zzbpJ);
      return str;
    }
    return new String(zzmq(i), "UTF-8");
  }
  
  public byte[] zzF(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zztn.zzbqi;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzbpG;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public int zzHi()
    throws IOException
  {
    if (zzHv())
    {
      this.zzbpK = 0;
      return 0;
    }
    this.zzbpK = zzHp();
    if (this.zzbpK == 0) {
      throw zztj.zzHF();
    }
    return this.zzbpK;
  }
  
  public void zzHj()
    throws IOException
  {
    int i;
    do
    {
      i = zzHi();
    } while ((i != 0) && (zzml(i)));
  }
  
  public long zzHk()
    throws IOException
  {
    return zzHq();
  }
  
  public int zzHl()
    throws IOException
  {
    return zzHp();
  }
  
  public boolean zzHm()
    throws IOException
  {
    return zzHp() != 0;
  }
  
  public int zzHn()
    throws IOException
  {
    return zzmm(zzHp());
  }
  
  public long zzHo()
    throws IOException
  {
    return zzaa(zzHq());
  }
  
  public int zzHp()
    throws IOException
  {
    int i = zzHw();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzHw();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzHw();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzHw();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzHw();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzHw() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zztj.zzHE();
  }
  
  public long zzHq()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzHw();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zztj.zzHE();
  }
  
  public int zzHr()
    throws IOException
  {
    return zzHw() & 0xFF | (zzHw() & 0xFF) << 8 | (zzHw() & 0xFF) << 16 | (zzHw() & 0xFF) << 24;
  }
  
  public long zzHs()
    throws IOException
  {
    int i = zzHw();
    int j = zzHw();
    int k = zzHw();
    int m = zzHw();
    int n = zzHw();
    int i1 = zzHw();
    int i2 = zzHw();
    int i3 = zzHw();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int zzHu()
  {
    if (this.zzbpL == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.zzbpJ;
    return this.zzbpL - i;
  }
  
  public boolean zzHv()
  {
    return this.zzbpJ == this.zzbpH;
  }
  
  public byte zzHw()
    throws IOException
  {
    if (this.zzbpJ == this.zzbpH) {
      throw zztj.zzHC();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.zzbpJ;
    this.zzbpJ = (i + 1);
    return arrayOfByte[i];
  }
  
  public void zza(zztk paramzztk)
    throws IOException
  {
    int i = zzHp();
    if (this.zzbpM >= this.zzbpN) {
      throw zztj.zzHI();
    }
    i = zzmn(i);
    this.zzbpM += 1;
    paramzztk.mergeFrom(this);
    zzmk(0);
    this.zzbpM -= 1;
    zzmo(i);
  }
  
  public void zza(zztk paramzztk, int paramInt)
    throws IOException
  {
    if (this.zzbpM >= this.zzbpN) {
      throw zztj.zzHI();
    }
    this.zzbpM += 1;
    paramzztk.mergeFrom(this);
    zzmk(zztn.zzL(paramInt, 4));
    this.zzbpM -= 1;
  }
  
  public void zzmk(int paramInt)
    throws zztj
  {
    if (this.zzbpK != paramInt) {
      throw zztj.zzHG();
    }
  }
  
  public boolean zzml(int paramInt)
    throws IOException
  {
    switch (zztn.zzmF(paramInt))
    {
    default: 
      throw zztj.zzHH();
    case 0: 
      zzHl();
      return true;
    case 1: 
      zzHs();
      return true;
    case 2: 
      zzmr(zzHp());
      return true;
    case 3: 
      zzHj();
      zzmk(zztn.zzL(zztn.zzmG(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzHr();
    return true;
  }
  
  public int zzmn(int paramInt)
    throws zztj
  {
    if (paramInt < 0) {
      throw zztj.zzHD();
    }
    paramInt = this.zzbpJ + paramInt;
    int i = this.zzbpL;
    if (paramInt > i) {
      throw zztj.zzHC();
    }
    this.zzbpL = paramInt;
    zzHt();
    return i;
  }
  
  public void zzmo(int paramInt)
  {
    this.zzbpL = paramInt;
    zzHt();
  }
  
  public void zzmp(int paramInt)
  {
    if (paramInt > this.zzbpJ - this.zzbpG) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.zzbpJ - this.zzbpG));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.zzbpJ = (this.zzbpG + paramInt);
  }
  
  public byte[] zzmq(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zztj.zzHD();
    }
    if (this.zzbpJ + paramInt > this.zzbpL)
    {
      zzmr(this.zzbpL - this.zzbpJ);
      throw zztj.zzHC();
    }
    if (paramInt <= this.zzbpH - this.zzbpJ)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.zzbpJ, arrayOfByte, 0, paramInt);
      this.zzbpJ += paramInt;
      return arrayOfByte;
    }
    throw zztj.zzHC();
  }
  
  public void zzmr(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zztj.zzHD();
    }
    if (this.zzbpJ + paramInt > this.zzbpL)
    {
      zzmr(this.zzbpL - this.zzbpJ);
      throw zztj.zzHC();
    }
    if (paramInt <= this.zzbpH - this.zzbpJ)
    {
      this.zzbpJ += paramInt;
      return;
    }
    throw zztj.zzHC();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */