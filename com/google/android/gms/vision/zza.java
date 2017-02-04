package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza
{
  private static int zzbif = 0;
  private static final Object zzqf = new Object();
  private SparseArray<Integer> zzbig = new SparseArray();
  private SparseArray<Integer> zzbih = new SparseArray();
  
  public int zzka(int paramInt)
  {
    synchronized (zzqf)
    {
      Integer localInteger = (Integer)this.zzbig.get(paramInt);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        return paramInt;
      }
      int i = zzbif;
      zzbif += 1;
      this.zzbig.append(paramInt, Integer.valueOf(i));
      this.zzbih.append(i, Integer.valueOf(paramInt));
      return i;
    }
  }
  
  public int zzkb(int paramInt)
  {
    synchronized (zzqf)
    {
      paramInt = ((Integer)this.zzbih.get(paramInt)).intValue();
      return paramInt;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */