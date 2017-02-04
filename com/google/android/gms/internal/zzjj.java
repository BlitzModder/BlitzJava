package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

@zzha
class zzjj
  extends zzjl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zzMb;
  
  public zzjj(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    super(paramView);
    this.zzMb = new WeakReference(paramOnGlobalLayoutListener);
  }
  
  public void onGlobalLayout()
  {
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)this.zzMb.get();
    if (localOnGlobalLayoutListener != null)
    {
      localOnGlobalLayoutListener.onGlobalLayout();
      return;
    }
    detach();
  }
  
  protected void zza(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  protected void zzb(ViewTreeObserver paramViewTreeObserver)
  {
    zzp.zzbz().zza(paramViewTreeObserver, this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */