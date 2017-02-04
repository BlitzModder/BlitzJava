package com.google.android.gms.common.images;

public final class Size
{
  private final int zzov;
  private final int zzow;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zzov = paramInt1;
    this.zzow = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string must not be null");
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0) {
      throw zzcw(paramString);
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw zzcw(paramString);
    }
  }
  
  private static NumberFormatException zzcw(String paramString)
  {
    throw new NumberFormatException("Invalid Size: \"" + paramString + "\"");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof Size));
    paramObject = (Size)paramObject;
    if ((this.zzov == ((Size)paramObject).zzov) && (this.zzow == ((Size)paramObject).zzow)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getHeight()
  {
    return this.zzow;
  }
  
  public int getWidth()
  {
    return this.zzov;
  }
  
  public int hashCode()
  {
    return this.zzow ^ (this.zzov << 16 | this.zzov >>> 16);
  }
  
  public String toString()
  {
    return this.zzov + "x" + this.zzow;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/images/Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */