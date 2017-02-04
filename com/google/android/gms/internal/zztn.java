package com.google.android.gms.internal;

import java.io.IOException;

public final class zztn
{
  public static final long[] zzboC = new long[0];
  public static final int[] zzboD = new int[0];
  public static final float[] zzbqd = new float[0];
  public static final double[] zzbqe = new double[0];
  public static final boolean[] zzbqf = new boolean[0];
  public static final String[] zzbqg = new String[0];
  public static final byte[][] zzbqh = new byte[0][];
  public static final byte[] zzbqi = new byte[0];
  
  static int zzL(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static boolean zzb(zztc paramzztc, int paramInt)
    throws IOException
  {
    return paramzztc.zzml(paramInt);
  }
  
  public static final int zzc(zztc paramzztc, int paramInt)
    throws IOException
  {
    int i = 1;
    int j = paramzztc.getPosition();
    paramzztc.zzml(paramInt);
    while (paramzztc.zzHi() == paramInt)
    {
      paramzztc.zzml(paramInt);
      i += 1;
    }
    paramzztc.zzmp(j);
    return i;
  }
  
  static int zzmF(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int zzmG(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */