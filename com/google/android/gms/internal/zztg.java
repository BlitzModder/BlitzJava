package com.google.android.gms.internal;

public final class zztg
  implements Cloneable
{
  private static final zzth zzbpT = new zzth();
  private int mSize;
  private boolean zzbpU = false;
  private int[] zzbpV;
  private zzth[] zzbpW;
  
  zztg()
  {
    this(10);
  }
  
  zztg(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.zzbpV = new int[paramInt];
    this.zzbpW = new zzth[paramInt];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.zzbpV;
    zzth[] arrayOfzzth = this.zzbpW;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      zzth localzzth = arrayOfzzth[i];
      k = j;
      if (localzzth != zzbpT)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfzzth[j] = localzzth;
          arrayOfzzth[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.zzbpU = false;
    this.mSize = j;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzth[] paramArrayOfzzth1, zzth[] paramArrayOfzzth2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzth1[i].equals(paramArrayOfzzth2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzmE(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.zzbpV[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zztg)) {
        return false;
      }
      paramObject = (zztg)paramObject;
      if (size() != ((zztg)paramObject).size()) {
        return false;
      }
    } while ((zza(this.zzbpV, ((zztg)paramObject).zzbpV, this.mSize)) && (zza(this.zzbpW, ((zztg)paramObject).zzbpW, this.mSize)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.zzbpU) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.zzbpV[i]) * 31 + this.zzbpW[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    if (this.zzbpU) {
      gc();
    }
    return this.mSize;
  }
  
  public final zztg zzHA()
  {
    int i = 0;
    int j = size();
    zztg localzztg = new zztg(j);
    System.arraycopy(this.zzbpV, 0, localzztg.zzbpV, 0, j);
    while (i < j)
    {
      if (this.zzbpW[i] != null) {
        localzztg.zzbpW[i] = this.zzbpW[i].zzHB();
      }
      i += 1;
    }
    localzztg.mSize = j;
    return localzztg;
  }
  
  void zza(int paramInt, zzth paramzzth)
  {
    int i = zzmE(paramInt);
    if (i >= 0)
    {
      this.zzbpW[i] = paramzzth;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zzbpW[j] == zzbpT))
    {
      this.zzbpV[j] = paramInt;
      this.zzbpW[j] = paramzzth;
      return;
    }
    i = j;
    if (this.zzbpU)
    {
      i = j;
      if (this.mSize >= this.zzbpV.length)
      {
        gc();
        i = zzmE(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.zzbpV.length)
    {
      j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      zzth[] arrayOfzzth = new zzth[j];
      System.arraycopy(this.zzbpV, 0, arrayOfInt, 0, this.zzbpV.length);
      System.arraycopy(this.zzbpW, 0, arrayOfzzth, 0, this.zzbpW.length);
      this.zzbpV = arrayOfInt;
      this.zzbpW = arrayOfzzth;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.zzbpV, i, this.zzbpV, i + 1, this.mSize - i);
      System.arraycopy(this.zzbpW, i, this.zzbpW, i + 1, this.mSize - i);
    }
    this.zzbpV[i] = paramInt;
    this.zzbpW[i] = paramzzth;
    this.mSize += 1;
  }
  
  zzth zzmC(int paramInt)
  {
    paramInt = zzmE(paramInt);
    if ((paramInt < 0) || (this.zzbpW[paramInt] == zzbpT)) {
      return null;
    }
    return this.zzbpW[paramInt];
  }
  
  zzth zzmD(int paramInt)
  {
    if (this.zzbpU) {
      gc();
    }
    return this.zzbpW[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */