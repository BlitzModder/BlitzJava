package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@zzha
class zzjk
  extends zzjl
  implements ViewTreeObserver.OnScrollChangedListener
{
  private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zzMb;
  
  public zzjk(View paramView, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    super(paramView);
    this.zzMb = new WeakReference(paramOnScrollChangedListener);
  }
  
  public void onScrollChanged()
  {
    ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener)this.zzMb.get();
    if (localOnScrollChangedListener != null)
    {
      localOnScrollChangedListener.onScrollChanged();
      return;
    }
    detach();
  }
  
  protected void zza(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnScrollChangedListener(this);
  }
  
  protected void zzb(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.removeOnScrollChangedListener(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */