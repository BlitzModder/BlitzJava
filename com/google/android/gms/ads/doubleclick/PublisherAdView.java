package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzz;

public final class PublisherAdView
  extends ViewGroup
{
  private final zzz zzoy;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.zzoy = new zzz(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzoy = new zzz(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzoy = new zzz(this, paramAttributeSet, true);
  }
  
  public void destroy()
  {
    this.zzoy.destroy();
  }
  
  public AdListener getAdListener()
  {
    return this.zzoy.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return this.zzoy.getAdSize();
  }
  
  public AdSize[] getAdSizes()
  {
    return this.zzoy.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return this.zzoy.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zzoy.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zzoy.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zzoy.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoading()
  {
    return this.zzoy.isLoading();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.zzoy.zza(paramPublisherAdRequest.zzaG());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = getChildAt(0);
    int j;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      measureChild((View)localObject, paramInt1, paramInt2);
      j = ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      localObject = getAdSize();
      if (localObject != null)
      {
        Context localContext = getContext();
        j = ((AdSize)localObject).getWidthInPixels(localContext);
        i = ((AdSize)localObject).getHeightInPixels(localContext);
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    this.zzoy.pause();
  }
  
  public void recordManualImpression()
  {
    this.zzoy.recordManualImpression();
  }
  
  public void resume()
  {
    this.zzoy.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zzoy.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    this.zzoy.zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zzoy.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.zzoy.setAppEventListener(paramAppEventListener);
  }
  
  public void setCorrelator(Correlator paramCorrelator)
  {
    this.zzoy.setCorrelator(paramCorrelator);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzoy.setManualImpressionsEnabled(paramBoolean);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zzoy.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */