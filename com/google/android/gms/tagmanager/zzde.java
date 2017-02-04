package com.google.android.gms.tagmanager;

class zzde
  extends Number
  implements Comparable<zzde>
{
  private double zzbgv;
  private long zzbgw;
  private boolean zzbgx;
  
  private zzde(double paramDouble)
  {
    this.zzbgv = paramDouble;
    this.zzbgx = false;
  }
  
  private zzde(long paramLong)
  {
    this.zzbgw = paramLong;
    this.zzbgx = true;
  }
  
  public static zzde zzX(long paramLong)
  {
    return new zzde(paramLong);
  }
  
  public static zzde zza(Double paramDouble)
  {
    return new zzde(paramDouble.doubleValue());
  }
  
  public static zzde zzfE(String paramString)
    throws NumberFormatException
  {
    try
    {
      zzde localzzde1 = new zzde(Long.parseLong(paramString));
      return localzzde1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        zzde localzzde2 = new zzde(Double.parseDouble(paramString));
        return localzzde2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (zzFz()) {
      return this.zzbgw;
    }
    return this.zzbgv;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzde)) && (zza((zzde)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return zzFB();
  }
  
  public long longValue()
  {
    return zzFA();
  }
  
  public short shortValue()
  {
    return zzFC();
  }
  
  public String toString()
  {
    if (zzFz()) {
      return Long.toString(this.zzbgw);
    }
    return Double.toString(this.zzbgv);
  }
  
  public long zzFA()
  {
    if (zzFz()) {
      return this.zzbgw;
    }
    return this.zzbgv;
  }
  
  public int zzFB()
  {
    return (int)longValue();
  }
  
  public short zzFC()
  {
    return (short)(int)longValue();
  }
  
  public boolean zzFy()
  {
    return !zzFz();
  }
  
  public boolean zzFz()
  {
    return this.zzbgx;
  }
  
  public int zza(zzde paramzzde)
  {
    if ((zzFz()) && (paramzzde.zzFz())) {
      return new Long(this.zzbgw).compareTo(Long.valueOf(paramzzde.zzbgw));
    }
    return Double.compare(doubleValue(), paramzzde.doubleValue());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */