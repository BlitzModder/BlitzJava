package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper
  extends NativeAdMapper
{
  private NativeAd.Image zzMU;
  private String zzxA;
  private String zzxC;
  private double zzxD;
  private String zzxE;
  private String zzxF;
  private String zzxy;
  private List<NativeAd.Image> zzxz;
  
  public final String getBody()
  {
    return this.zzxA;
  }
  
  public final String getCallToAction()
  {
    return this.zzxC;
  }
  
  public final String getHeadline()
  {
    return this.zzxy;
  }
  
  public final NativeAd.Image getIcon()
  {
    return this.zzMU;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return this.zzxz;
  }
  
  public final String getPrice()
  {
    return this.zzxF;
  }
  
  public final double getStarRating()
  {
    return this.zzxD;
  }
  
  public final String getStore()
  {
    return this.zzxE;
  }
  
  public final void setBody(String paramString)
  {
    this.zzxA = paramString;
  }
  
  public final void setCallToAction(String paramString)
  {
    this.zzxC = paramString;
  }
  
  public final void setHeadline(String paramString)
  {
    this.zzxy = paramString;
  }
  
  public final void setIcon(NativeAd.Image paramImage)
  {
    this.zzMU = paramImage;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzxz = paramList;
  }
  
  public final void setPrice(String paramString)
  {
    this.zzxF = paramString;
  }
  
  public final void setStarRating(double paramDouble)
  {
    this.zzxD = paramDouble;
  }
  
  public final void setStore(String paramString)
  {
    this.zzxE = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/mediation/NativeAppInstallAdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */