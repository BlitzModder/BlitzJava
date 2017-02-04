package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper
  extends NativeAdMapper
{
  private NativeAd.Image zzMV;
  private String zzxA;
  private String zzxC;
  private String zzxJ;
  private String zzxy;
  private List<NativeAd.Image> zzxz;
  
  public final String getAdvertiser()
  {
    return this.zzxJ;
  }
  
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
  
  public final List<NativeAd.Image> getImages()
  {
    return this.zzxz;
  }
  
  public final NativeAd.Image getLogo()
  {
    return this.zzMV;
  }
  
  public final void setAdvertiser(String paramString)
  {
    this.zzxJ = paramString;
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
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzxz = paramList;
  }
  
  public final void setLogo(NativeAd.Image paramImage)
  {
    this.zzMV = paramImage;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/mediation/NativeContentAdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */