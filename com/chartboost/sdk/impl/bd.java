package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.chartboost.sdk.Libraries.CBLogging;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class bd
  extends SurfaceView
  implements bf.a
{
  MediaPlayer.OnVideoSizeChangedListener a = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      bd.a(bd.this, paramAnonymousMediaPlayer.getVideoWidth());
      bd.b(bd.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((bd.a(bd.this) != 0) && (bd.b(bd.this) != 0)) {
        bd.this.getHolder().setFixedSize(bd.a(bd.this), bd.b(bd.this));
      }
    }
  };
  MediaPlayer.OnPreparedListener b = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      bd.c(bd.this, 2);
      bd.a(bd.this, paramAnonymousMediaPlayer.getVideoWidth());
      bd.b(bd.this, paramAnonymousMediaPlayer.getVideoHeight());
      if (bd.c(bd.this) != null) {
        bd.c(bd.this).onPrepared(bd.d(bd.this));
      }
      int i = bd.e(bd.this);
      if (i != 0) {
        bd.this.a(i);
      }
      if ((bd.a(bd.this) != 0) && (bd.b(bd.this) != 0))
      {
        bd.this.getHolder().setFixedSize(bd.a(bd.this), bd.b(bd.this));
        if ((bd.f(bd.this) == bd.a(bd.this)) && (bd.g(bd.this) == bd.b(bd.this)) && (bd.h(bd.this) == 3)) {
          bd.this.a();
        }
      }
      while (bd.h(bd.this) != 3) {
        return;
      }
      bd.this.a();
    }
  };
  SurfaceHolder.Callback c = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      int i = 1;
      bd.f(bd.this, paramAnonymousInt2);
      bd.g(bd.this, paramAnonymousInt3);
      if (bd.h(bd.this) == 3)
      {
        paramAnonymousInt1 = 1;
        if ((bd.a(bd.this) != paramAnonymousInt2) || (bd.b(bd.this) != paramAnonymousInt3)) {
          break label116;
        }
      }
      label116:
      for (paramAnonymousInt2 = i;; paramAnonymousInt2 = 0)
      {
        if ((bd.d(bd.this) != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          if (bd.e(bd.this) != 0) {
            bd.this.a(bd.e(bd.this));
          }
          bd.this.a();
        }
        return;
        paramAnonymousInt1 = 0;
        break;
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      bd.a(bd.this, paramAnonymousSurfaceHolder);
      bd.m(bd.this);
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      bd.a(bd.this, null);
      bd.a(bd.this, true);
    }
  };
  private String d = "VideoSurfaceView";
  private Uri e;
  private Map<String, String> f;
  private int g;
  private int h = 0;
  private int i = 0;
  private SurfaceHolder j = null;
  private MediaPlayer k = null;
  private int l;
  private int m;
  private int n;
  private int o;
  private MediaPlayer.OnCompletionListener p;
  private MediaPlayer.OnPreparedListener q;
  private int r;
  private MediaPlayer.OnErrorListener s;
  private int t;
  private MediaPlayer.OnCompletionListener u = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      bd.d(bd.this, 5);
      if (bd.i(bd.this) != 5)
      {
        bd.c(bd.this, 5);
        if (bd.j(bd.this) != null) {
          bd.j(bd.this).onCompletion(bd.d(bd.this));
        }
      }
    }
  };
  private MediaPlayer.OnErrorListener v = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      CBLogging.a(bd.k(bd.this), "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      bd.c(bd.this, -1);
      bd.d(bd.this, -1);
      if ((bd.l(bd.this) != null) && (bd.l(bd.this).onError(bd.d(bd.this), paramAnonymousInt1, paramAnonymousInt2))) {}
      return true;
    }
  };
  private MediaPlayer.OnBufferingUpdateListener w = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      bd.e(bd.this, paramAnonymousInt);
    }
  };
  
  public bd(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k != null)
    {
      this.k.reset();
      this.k.release();
      this.k = null;
      this.h = 0;
      if (paramBoolean) {
        this.i = 0;
      }
    }
  }
  
  private void f()
  {
    this.l = 0;
    this.m = 0;
    getHolder().addCallback(this.c);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.h = 0;
    this.i = 0;
  }
  
  private void g()
  {
    if ((this.e == null) || (this.j == null)) {
      return;
    }
    Object localObject = new Intent("com.android.music.musicservicecommand");
    ((Intent)localObject).putExtra("command", "pause");
    getContext().sendBroadcast((Intent)localObject);
    a(false);
    try
    {
      this.k = new MediaPlayer();
      this.k.setOnPreparedListener(this.b);
      this.k.setOnVideoSizeChangedListener(this.a);
      this.g = -1;
      this.k.setOnCompletionListener(this.u);
      this.k.setOnErrorListener(this.v);
      this.k.setOnBufferingUpdateListener(this.w);
      this.r = 0;
      this.k.setDisplay(this.j);
      this.k.setAudioStreamType(3);
      this.k.setScreenOnWhilePlaying(true);
      localObject = new FileInputStream(new File(this.e.toString()));
      this.k.setDataSource(((FileInputStream)localObject).getFD());
      ((FileInputStream)localObject).close();
      this.k.prepareAsync();
      this.h = 1;
      return;
    }
    catch (IOException localIOException)
    {
      CBLogging.d(this.d, "Unable to open content: " + this.e, localIOException);
      this.h = -1;
      this.i = -1;
      this.v.onError(this.k, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      CBLogging.d(this.d, "Unable to open content: " + this.e, localIllegalArgumentException);
      this.h = -1;
      this.i = -1;
      this.v.onError(this.k, 1, 0);
    }
  }
  
  private boolean h()
  {
    return (this.k != null) && (this.h != -1) && (this.h != 0) && (this.h != 1);
  }
  
  public void a()
  {
    if (h())
    {
      this.k.start();
      this.h = 3;
    }
    this.i = 3;
  }
  
  public void a(int paramInt)
  {
    if (h())
    {
      this.k.seekTo(paramInt);
      this.t = 0;
      return;
    }
    this.t = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.p = paramOnCompletionListener;
  }
  
  public void a(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.s = paramOnErrorListener;
  }
  
  public void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.q = paramOnPreparedListener;
  }
  
  public void a(Uri paramUri)
  {
    a(paramUri, null);
  }
  
  public void a(Uri paramUri, Map<String, String> paramMap)
  {
    this.e = paramUri;
    this.f = paramMap;
    this.t = 0;
    g();
    requestLayout();
    invalidate();
  }
  
  public void b()
  {
    if ((h()) && (this.k.isPlaying()))
    {
      this.k.pause();
      this.h = 4;
    }
    this.i = 4;
  }
  
  public int c()
  {
    if (h())
    {
      if (this.g > 0) {
        return this.g;
      }
      this.g = this.k.getDuration();
      return this.g;
    }
    this.g = -1;
    return this.g;
  }
  
  public int d()
  {
    if (h()) {
      return this.k.getCurrentPosition();
    }
    return 0;
  }
  
  public boolean e()
  {
    return (h()) && (this.k.isPlaying());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(0, paramInt1);
    paramInt2 = getDefaultSize(0, paramInt2);
    float f1;
    if ((this.l > 0) && (this.m > 0))
    {
      paramInt1 = Math.min(paramInt2, Math.round(this.m / this.l * i1));
      f1 = this.l / this.m;
    }
    for (paramInt2 = Math.min(i1, Math.round(paramInt2 * f1));; paramInt2 = i1)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */