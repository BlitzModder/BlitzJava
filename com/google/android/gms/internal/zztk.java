package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract class zztk
{
  protected volatile int zzbqb = -1;
  
  public static final <T extends zztk> T mergeFrom(T paramT, byte[] paramArrayOfByte)
    throws zztj
  {
    return mergeFrom(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final <T extends zztk> T mergeFrom(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zztj
  {
    try
    {
      paramArrayOfByte = zztc.zza(paramArrayOfByte, paramInt1, paramInt2);
      paramT.mergeFrom(paramArrayOfByte);
      paramArrayOfByte.zzmk(0);
      return paramT;
    }
    catch (zztj paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final boolean messageNanoEquals(zztk paramzztk1, zztk paramzztk2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramzztk1 == paramzztk2) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramzztk1 == null);
          bool1 = bool2;
        } while (paramzztk2 == null);
        bool1 = bool2;
      } while (paramzztk1.getClass() != paramzztk2.getClass());
      i = paramzztk1.getSerializedSize();
      bool1 = bool2;
    } while (paramzztk2.getSerializedSize() != i);
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    toByteArray(paramzztk1, arrayOfByte1, 0, i);
    toByteArray(paramzztk2, arrayOfByte2, 0, i);
    return Arrays.equals(arrayOfByte1, arrayOfByte2);
  }
  
  public static final void toByteArray(zztk paramzztk, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zztd.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramzztk.writeTo(paramArrayOfByte);
      paramArrayOfByte.zzHy();
      return;
    }
    catch (IOException paramzztk)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzztk);
    }
  }
  
  public static final byte[] toByteArray(zztk paramzztk)
  {
    byte[] arrayOfByte = new byte[paramzztk.getSerializedSize()];
    toByteArray(paramzztk, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public zztk clone()
    throws CloneNotSupportedException
  {
    return (zztk)super.clone();
  }
  
  public int getCachedSize()
  {
    if (this.zzbqb < 0) {
      getSerializedSize();
    }
    return this.zzbqb;
  }
  
  public int getSerializedSize()
  {
    int i = zzz();
    this.zzbqb = i;
    return i;
  }
  
  public abstract zztk mergeFrom(zztc paramzztc)
    throws IOException;
  
  public String toString()
  {
    return zztl.zzf(this);
  }
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {}
  
  protected int zzz()
  {
    return 0;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */