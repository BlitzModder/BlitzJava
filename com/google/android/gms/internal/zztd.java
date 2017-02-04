package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zztd
{
  private final ByteBuffer zzbpP;
  
  private zztd(ByteBuffer paramByteBuffer)
  {
    this.zzbpP = paramByteBuffer;
    this.zzbpP.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zztd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static zztd zzD(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzF(byte[] paramArrayOfByte)
  {
    return zzmz(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int zzI(int paramInt1, int paramInt2)
  {
    return zzmx(paramInt1) + zzmu(paramInt2);
  }
  
  public static int zzJ(int paramInt1, int paramInt2)
  {
    return zzmx(paramInt1) + zzmv(paramInt2);
  }
  
  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label442;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException("Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label442:
      if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
        throw new IllegalArgumentException("Unpaired surrogate at index " + paramInt2);
      }
      throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  public static int zzad(long paramLong)
  {
    return zzag(paramLong);
  }
  
  public static int zzae(long paramLong)
  {
    return zzag(zzai(paramLong));
  }
  
  public static int zzag(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static long zzai(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int zzay(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzmx(paramInt) + zzl(paramDouble);
  }
  
  public static int zzb(int paramInt, zztk paramzztk)
  {
    return zzmx(paramInt) * 2 + zzd(paramzztk);
  }
  
  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzmx(paramInt) + zzF(paramArrayOfByte);
  }
  
  public static zztd zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zztd(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException("Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int zzc(int paramInt, float paramFloat)
  {
    return zzmx(paramInt) + zzj(paramFloat);
  }
  
  public static int zzc(int paramInt, zztk paramzztk)
  {
    return zzmx(paramInt) + zze(paramzztk);
  }
  
  public static int zzc(int paramInt, boolean paramBoolean)
  {
    return zzmx(paramInt) + zzay(paramBoolean);
  }
  
  private static int zzc(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m) {
          throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (k + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzmx(paramInt) + zzad(paramLong);
  }
  
  public static int zzd(zztk paramzztk)
  {
    return paramzztk.getSerializedSize();
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzmx(paramInt) + zzae(paramLong);
  }
  
  public static int zze(zztk paramzztk)
  {
    int i = paramzztk.getSerializedSize();
    return i + zzmz(i);
  }
  
  public static int zzga(String paramString)
  {
    int i = zzc(paramString);
    return i + zzmz(i);
  }
  
  public static int zzj(float paramFloat)
  {
    return 4;
  }
  
  public static int zzl(double paramDouble)
  {
    return 8;
  }
  
  public static int zzmB(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int zzmu(int paramInt)
  {
    if (paramInt >= 0) {
      return zzmz(paramInt);
    }
    return 10;
  }
  
  public static int zzmv(int paramInt)
  {
    return zzmz(zzmB(paramInt));
  }
  
  public static int zzmx(int paramInt)
  {
    return zzmz(zztn.zzL(paramInt, 0));
  }
  
  public static int zzmz(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzp(int paramInt, String paramString)
  {
    return zzmx(paramInt) + zzga(paramString);
  }
  
  public void zzE(byte[] paramArrayOfByte)
    throws IOException
  {
    zzmy(paramArrayOfByte.length);
    zzG(paramArrayOfByte);
  }
  
  public void zzG(int paramInt1, int paramInt2)
    throws IOException
  {
    zzK(paramInt1, 0);
    zzms(paramInt2);
  }
  
  public void zzG(byte[] paramArrayOfByte)
    throws IOException
  {
    zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void zzH(int paramInt1, int paramInt2)
    throws IOException
  {
    zzK(paramInt1, 0);
    zzmt(paramInt2);
  }
  
  public int zzHx()
  {
    return this.zzbpP.remaining();
  }
  
  public void zzHy()
  {
    if (zzHx() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void zzK(int paramInt1, int paramInt2)
    throws IOException
  {
    zzmy(zztn.zzL(paramInt1, paramInt2));
  }
  
  public void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzK(paramInt, 1);
    zzk(paramDouble);
  }
  
  public void zza(int paramInt, zztk paramzztk)
    throws IOException
  {
    zzK(paramInt, 2);
    zzc(paramzztk);
  }
  
  public void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzK(paramInt, 2);
    zzE(paramArrayOfByte);
  }
  
  public void zzab(long paramLong)
    throws IOException
  {
    zzaf(paramLong);
  }
  
  public void zzac(long paramLong)
    throws IOException
  {
    zzaf(zzai(paramLong));
  }
  
  public void zzaf(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzmw((int)paramLong);
        return;
      }
      zzmw((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void zzah(long paramLong)
    throws IOException
  {
    if (this.zzbpP.remaining() < 8) {
      throw new zza(this.zzbpP.position(), this.zzbpP.limit());
    }
    this.zzbpP.putLong(paramLong);
  }
  
  public void zzax(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzmw(i);
      return;
    }
  }
  
  public void zzb(byte paramByte)
    throws IOException
  {
    if (!this.zzbpP.hasRemaining()) {
      throw new zza(this.zzbpP.position(), this.zzbpP.limit());
    }
    this.zzbpP.put(paramByte);
  }
  
  public void zzb(int paramInt, float paramFloat)
    throws IOException
  {
    zzK(paramInt, 5);
    zzi(paramFloat);
  }
  
  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zzK(paramInt, 0);
    zzab(paramLong);
  }
  
  public void zzb(int paramInt, String paramString)
    throws IOException
  {
    zzK(paramInt, 2);
    zzfZ(paramString);
  }
  
  public void zzb(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzK(paramInt, 0);
    zzax(paramBoolean);
  }
  
  public void zzb(zztk paramzztk)
    throws IOException
  {
    paramzztk.writeTo(this);
  }
  
  public void zzc(int paramInt, long paramLong)
    throws IOException
  {
    zzK(paramInt, 0);
    zzac(paramLong);
  }
  
  public void zzc(zztk paramzztk)
    throws IOException
  {
    zzmy(paramzztk.getCachedSize());
    paramzztk.writeTo(this);
  }
  
  public void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.zzbpP.remaining() >= paramInt2)
    {
      this.zzbpP.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zza(this.zzbpP.position(), this.zzbpP.limit());
  }
  
  public void zzfZ(String paramString)
    throws IOException
  {
    int i;
    int j;
    try
    {
      i = zzmz(paramString.length());
      if (i != zzmz(paramString.length() * 3)) {
        break label150;
      }
      j = this.zzbpP.position();
      if (this.zzbpP.remaining() < i) {
        throw new zza(i + j, this.zzbpP.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zza localzza = new zza(this.zzbpP.position(), this.zzbpP.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    this.zzbpP.position(j + i);
    zza(paramString, this.zzbpP);
    int k = this.zzbpP.position();
    this.zzbpP.position(j);
    zzmy(k - j - i);
    this.zzbpP.position(k);
    return;
    label150:
    zzmy(zzc(paramString));
    zza(paramString, this.zzbpP);
  }
  
  public void zzi(float paramFloat)
    throws IOException
  {
    zzmA(Float.floatToIntBits(paramFloat));
  }
  
  public void zzk(double paramDouble)
    throws IOException
  {
    zzah(Double.doubleToLongBits(paramDouble));
  }
  
  public void zzmA(int paramInt)
    throws IOException
  {
    if (this.zzbpP.remaining() < 4) {
      throw new zza(this.zzbpP.position(), this.zzbpP.limit());
    }
    this.zzbpP.putInt(paramInt);
  }
  
  public void zzms(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzmy(paramInt);
      return;
    }
    zzaf(paramInt);
  }
  
  public void zzmt(int paramInt)
    throws IOException
  {
    zzmy(zzmB(paramInt));
  }
  
  public void zzmw(int paramInt)
    throws IOException
  {
    zzb((byte)paramInt);
  }
  
  public void zzmy(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzmw(paramInt);
        return;
      }
      zzmw(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public static class zza
    extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */