package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzdb;

public abstract class NativeAdView
  extends FrameLayout
{
  private final FrameLayout zzoF = zzn(paramContext);
  private final zzcp zzoG = zzaK();
  
  public NativeAdView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private zzcp zzaK()
  {
    zzx.zzb(this.zzoF, "createDelegate must be called after mOverlayFrame has been created");
    return zzl.zzcQ().zza(this.zzoF.getContext(), this, this.zzoF);
  }
  
  private FrameLayout zzn(Context paramContext)
  {
    paramContext = zzo(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext);
    return paramContext;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(this.zzoF);
  }
  
  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (this.zzoF != paramView) {
      super.bringChildToFront(this.zzoF);
    }
  }
  
  public void destroy()
  {
    try
    {
      this.zzoG.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Unable to destroy native ad view", localRemoteException);
    }
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(this.zzoF);
  }
  
  public void removeView(View paramView)
  {
    if (this.zzoF == paramView) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setNativeAd(NativeAd paramNativeAd)
  {
    try
    {
      this.zzoG.zzb((zzd)paramNativeAd.zzaJ());
      return;
    }
    catch (RemoteException paramNativeAd)
    {
      zzb.zzb("Unable to call setNativeAd on delegate", paramNativeAd);
    }
  }
  
  protected void zza(String paramString, View paramView)
  {
    try
    {
      this.zzoG.zza(paramString, zze.zzB(paramView));
      return;
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Unable to call setAssetView on delegate", paramString);
    }
  }
  
  protected View zzm(String paramString)
  {
    try
    {
      paramString = this.zzoG.zzU(paramString);
      if (paramString != null)
      {
        paramString = (View)zze.zzp(paramString);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Unable to call getAssetView on delegate", paramString);
    }
    return null;
  }
  
  FrameLayout zzo(Context paramContext)
  {
    return new FrameLayout(paramContext);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/formats/NativeAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */