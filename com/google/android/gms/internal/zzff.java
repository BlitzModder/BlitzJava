package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzff
  extends zzfa.zza
{
  private final NativeAppInstallAdMapper zzBM;
  
  public zzff(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    this.zzBM = paramNativeAppInstallAdMapper;
  }
  
  public String getBody()
  {
    return this.zzBM.getBody();
  }
  
  public String getCallToAction()
  {
    return this.zzBM.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return this.zzBM.getExtras();
  }
  
  public String getHeadline()
  {
    return this.zzBM.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = this.zzBM.getImages();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)((Iterator)localObject).next();
        localArrayList.add(new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return this.zzBM.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return this.zzBM.getOverrideImpressionRecording();
  }
  
  public String getPrice()
  {
    return this.zzBM.getPrice();
  }
  
  public double getStarRating()
  {
    return this.zzBM.getStarRating();
  }
  
  public String getStore()
  {
    return this.zzBM.getStore();
  }
  
  public void recordImpression()
  {
    this.zzBM.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    this.zzBM.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    this.zzBM.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcn zzdD()
  {
    NativeAd.Image localImage = this.zzBM.getIcon();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */