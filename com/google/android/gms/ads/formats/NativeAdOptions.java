package com.google.android.gms.ads.formats;

public final class NativeAdOptions
{
  public static final int ORIENTATION_ANY = 0;
  public static final int ORIENTATION_LANDSCAPE = 2;
  public static final int ORIENTATION_PORTRAIT = 1;
  private final boolean zzoC;
  private final int zzoD;
  private final boolean zzoE;
  
  private NativeAdOptions(Builder paramBuilder)
  {
    this.zzoC = Builder.zza(paramBuilder);
    this.zzoD = Builder.zzb(paramBuilder);
    this.zzoE = Builder.zzc(paramBuilder);
  }
  
  public int getImageOrientation()
  {
    return this.zzoD;
  }
  
  public boolean shouldRequestMultipleImages()
  {
    return this.zzoE;
  }
  
  public boolean shouldReturnUrlsForImageAssets()
  {
    return this.zzoC;
  }
  
  public static final class Builder
  {
    private boolean zzoC = false;
    private int zzoD = 0;
    private boolean zzoE = false;
    
    public NativeAdOptions build()
    {
      return new NativeAdOptions(this, null);
    }
    
    public Builder setImageOrientation(int paramInt)
    {
      this.zzoD = paramInt;
      return this;
    }
    
    public Builder setRequestMultipleImages(boolean paramBoolean)
    {
      this.zzoE = paramBoolean;
      return this;
    }
    
    public Builder setReturnUrlsForImageAssets(boolean paramBoolean)
    {
      this.zzoC = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/formats/NativeAdOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */