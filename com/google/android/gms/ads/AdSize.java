package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER;
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int zzov;
  private final int zzow;
  private final String zzox;
  
  static
  {
    SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  }
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1) && (paramInt1 != -3)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2) && (paramInt2 != -4)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.zzov = paramInt1;
    this.zzow = paramInt2;
    this.zzox = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      paramObject = (AdSize)paramObject;
    } while ((this.zzov == ((AdSize)paramObject).zzov) && (this.zzow == ((AdSize)paramObject).zzow) && (this.zzox.equals(((AdSize)paramObject).zzox)));
    return false;
  }
  
  public int getHeight()
  {
    return this.zzow;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    switch (this.zzow)
    {
    default: 
      return zzl.zzcN().zzb(paramContext, this.zzow);
    case -2: 
      return AdSizeParcel.zzb(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int getWidth()
  {
    return this.zzov;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    switch (this.zzov)
    {
    case -2: 
    default: 
      return zzl.zzcN().zzb(paramContext, this.zzov);
    case -1: 
      return AdSizeParcel.zza(paramContext.getResources().getDisplayMetrics());
    }
    return -1;
  }
  
  public int hashCode()
  {
    return this.zzox.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.zzow == -2;
  }
  
  public boolean isFluid()
  {
    return (this.zzov == -3) && (this.zzow == -4);
  }
  
  public boolean isFullWidth()
  {
    return this.zzov == -1;
  }
  
  public String toString()
  {
    return this.zzox;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */