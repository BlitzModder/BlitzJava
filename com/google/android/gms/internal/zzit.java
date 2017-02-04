package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzit
{
  private final String[] zzKZ;
  private final double[] zzLa;
  private final double[] zzLb;
  private final int[] zzLc;
  private int zzLd;
  
  private zzit(zzb paramzzb)
  {
    int i = zzb.zza(paramzzb).size();
    this.zzKZ = ((String[])zzb.zzb(paramzzb).toArray(new String[i]));
    this.zzLa = zzi(zzb.zza(paramzzb));
    this.zzLb = zzi(zzb.zzc(paramzzb));
    this.zzLc = new int[i];
    this.zzLd = 0;
  }
  
  private double[] zzi(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(this.zzKZ.length);
    int i = 0;
    while (i < this.zzKZ.length)
    {
      localArrayList.add(new zza(this.zzKZ[i], this.zzLb[i], this.zzLa[i], this.zzLc[i] / this.zzLd, this.zzLc[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    this.zzLd += 1;
    int i = 0;
    for (;;)
    {
      if (i < this.zzLb.length)
      {
        if ((this.zzLb[i] <= paramDouble) && (paramDouble < this.zzLa[i]))
        {
          int[] arrayOfInt = this.zzLc;
          arrayOfInt[i] += 1;
        }
        if (paramDouble >= this.zzLb[i]) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzLe;
    public final double zzLf;
    public final double zzLg;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
    {
      this.name = paramString;
      this.zzLf = paramDouble1;
      this.zzLe = paramDouble2;
      this.zzLg = paramDouble3;
      this.count = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      do
      {
        return false;
        paramObject = (zza)paramObject;
      } while ((!zzw.equal(this.name, ((zza)paramObject).name)) || (this.zzLe != ((zza)paramObject).zzLe) || (this.zzLf != ((zza)paramObject).zzLf) || (this.count != ((zza)paramObject).count) || (Double.compare(this.zzLg, ((zza)paramObject).zzLg) != 0));
      return true;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.name, Double.valueOf(this.zzLe), Double.valueOf(this.zzLf), Double.valueOf(this.zzLg), Integer.valueOf(this.count) });
    }
    
    public String toString()
    {
      return zzw.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzLf)).zzg("maxBound", Double.valueOf(this.zzLe)).zzg("percent", Double.valueOf(this.zzLg)).zzg("count", Integer.valueOf(this.count)).toString();
    }
  }
  
  public static class zzb
  {
    private final List<String> zzLh = new ArrayList();
    private final List<Double> zzLi = new ArrayList();
    private final List<Double> zzLj = new ArrayList();
    
    public zzb zza(String paramString, double paramDouble1, double paramDouble2)
    {
      int i = 0;
      for (;;)
      {
        double d1;
        double d2;
        if (i < this.zzLh.size())
        {
          d1 = ((Double)this.zzLj.get(i)).doubleValue();
          d2 = ((Double)this.zzLi.get(i)).doubleValue();
          if (paramDouble1 >= d1) {
            break label107;
          }
        }
        label107:
        while ((d1 == paramDouble1) && (paramDouble2 < d2))
        {
          this.zzLh.add(i, paramString);
          this.zzLj.add(i, Double.valueOf(paramDouble1));
          this.zzLi.add(i, Double.valueOf(paramDouble2));
          return this;
        }
        i += 1;
      }
    }
    
    public zzit zzhi()
    {
      return new zzit(this, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */