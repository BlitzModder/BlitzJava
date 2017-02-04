package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;

public class bf
  extends FrameLayout
{
  private View a;
  private boolean b;
  
  public bf(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (b())
    {
      if (Chartboost.getImpressionsUseActivities()) {
        return true;
      }
      try
      {
        boolean bool = paramActivity.getWindow().getDecorView().isHardwareAccelerated();
        return bool;
      }
      catch (Exception paramActivity) {}
    }
    return false;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  private void c()
  {
    this.b = b();
    if ((!Chartboost.getImpressionsUseActivities()) && ((getContext() instanceof Activity))) {
      this.b = a((Activity)getContext());
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Choosing ");
    String str;
    if (this.b)
    {
      str = "texture";
      CBLogging.e("VideoInit", str + " solution for video playback");
      if (!this.b) {
        break label142;
      }
    }
    label142:
    for (this.a = new be(getContext());; this.a = new bd(getContext()))
    {
      addView(this.a, new FrameLayout.LayoutParams(-1, -1));
      if (!this.b) {
        ((SurfaceView)this.a).setZOrderMediaOverlay(true);
      }
      return;
      str = "surface";
      break;
    }
  }
  
  public a a()
  {
    return (a)this.a;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a().a(paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(MediaPlayer.OnCompletionListener paramOnCompletionListener);
    
    public abstract void a(MediaPlayer.OnErrorListener paramOnErrorListener);
    
    public abstract void a(MediaPlayer.OnPreparedListener paramOnPreparedListener);
    
    public abstract void a(Uri paramUri);
    
    public abstract void b();
    
    public abstract int c();
    
    public abstract int d();
    
    public abstract boolean e();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */