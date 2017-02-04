package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzp;

@zzha
public final class zzja
{
  private boolean zzLA;
  private boolean zzLB;
  private ViewTreeObserver.OnGlobalLayoutListener zzLC;
  private ViewTreeObserver.OnScrollChangedListener zzLD;
  private Activity zzLy;
  private boolean zzLz;
  
  public zzja(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.zzLy = paramActivity;
    this.zzLC = paramOnGlobalLayoutListener;
    this.zzLD = paramOnScrollChangedListener;
  }
  
  private void zzho()
  {
    if (this.zzLy == null) {}
    while (this.zzLz) {
      return;
    }
    if (this.zzLC != null) {
      zzp.zzbx().zza(this.zzLy, this.zzLC);
    }
    if (this.zzLD != null) {
      zzp.zzbx().zza(this.zzLy, this.zzLD);
    }
    this.zzLz = true;
  }
  
  private void zzhp()
  {
    if (this.zzLy == null) {}
    while (!this.zzLz) {
      return;
    }
    if (this.zzLC != null) {
      zzp.zzbz().zzb(this.zzLy, this.zzLC);
    }
    if (this.zzLD != null) {
      zzp.zzbx().zzb(this.zzLy, this.zzLD);
    }
    this.zzLz = false;
  }
  
  public void onAttachedToWindow()
  {
    this.zzLA = true;
    if (this.zzLB) {
      zzho();
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.zzLA = false;
    zzhp();
  }
  
  public void zzhm()
  {
    this.zzLB = true;
    if (this.zzLA) {
      zzho();
    }
  }
  
  public void zzhn()
  {
    this.zzLB = false;
    zzhp();
  }
  
  public void zzk(Activity paramActivity)
  {
    this.zzLy = paramActivity;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */