package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzahO = false;
  private ArrayList<Integer> zzahP;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzpP()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.zzahO) {
          break label193;
        }
        int j = this.zzafC.getCount();
        this.zzahP = new ArrayList();
        if (j <= 0) {
          break label188;
        }
        this.zzahP.add(Integer.valueOf(0));
        String str3 = zzpO();
        i = this.zzafC.zzbI(0);
        String str1 = this.zzafC.zzd(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label188;
        }
        int k = this.zzafC.zzbI(i);
        str2 = this.zzafC.zzd(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException("Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.zzahP.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label196;
        label188:
        this.zzahO = true;
        label193:
        return;
      }
      label196:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzpP();
    return (T)zzk(zzbL(paramInt), zzbM(paramInt));
  }
  
  public int getCount()
  {
    zzpP();
    return this.zzahP.size();
  }
  
  int zzbL(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zzahP.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.zzahP.get(paramInt)).intValue();
  }
  
  protected int zzbM(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.zzahP.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.zzahP.size() - 1) {}
    for (int i = this.zzafC.getCount() - ((Integer)this.zzahP.get(paramInt)).intValue();; i = ((Integer)this.zzahP.get(paramInt + 1)).intValue() - ((Integer)this.zzahP.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzbL(paramInt);
      int k = this.zzafC.zzbI(paramInt);
      String str = zzpQ();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.zzafC.zzd(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T zzk(int paramInt1, int paramInt2);
  
  protected abstract String zzpO();
  
  protected String zzpQ()
  {
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */