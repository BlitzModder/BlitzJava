package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.chartboost.sdk.Libraries.CBLogging;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class be
  extends TextureView
  implements TextureView.SurfaceTextureListener, bf.a
{
  MediaPlayer.OnVideoSizeChangedListener a = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      be.a(be.this, paramAnonymousMediaPlayer.getVideoWidth());
      be.b(be.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((be.a(be.this) != 0) && (be.b(be.this) != 0)) {
        be.this.a(be.this.getWidth(), be.this.getHeight());
      }
    }
  };
  MediaPlayer.OnPreparedListener b = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      be.c(be.this, 2);
      be.a(be.this, paramAnonymousMediaPlayer.getVideoWidth());
      be.b(be.this, paramAnonymousMediaPlayer.getVideoHeight());
      if (be.c(be.this) != null) {
        be.c(be.this).onPrepared(be.d(be.this));
      }
      int i = be.e(be.this);
      if (i != 0) {
        be.this.a(i);
      }
      if (be.f(be.this) == 3) {
        be.this.a();
      }
    }
  };
  private String c = "VideoTextureView";
  private Uri d;
  private Map<String, String> e;
  private int f;
  private int g = 0;
  private int h = 0;
  private Surface i = null;
  private MediaPlayer j = null;
  private int k;
  private int l;
  private MediaPlayer.OnCompletionListener m;
  private MediaPlayer.OnPreparedListener n;
  private int o;
  private MediaPlayer.OnErrorListener p;
  private int q;
  private MediaPlayer.OnCompletionListener r = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      be.d(be.this, 5);
      if (be.g(be.this) != 5)
      {
        be.c(be.this, 5);
        if (be.h(be.this) != null) {
          be.h(be.this).onCompletion(be.d(be.this));
        }
      }
    }
  };
  private MediaPlayer.OnErrorListener s = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      CBLogging.a(be.i(be.this), "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      if (paramAnonymousInt1 == 100) {
        be.j(be.this);
      }
      do
      {
        return true;
        be.c(be.this, -1);
        be.d(be.this, -1);
      } while ((be.k(be.this) == null) || (!be.k(be.this).onError(be.d(be.this), paramAnonymousInt1, paramAnonymousInt2)));
      return true;
    }
  };
  private MediaPlayer.OnBufferingUpdateListener t = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      be.e(be.this, paramAnonymousInt);
    }
  };
  
  public be(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j != null)
    {
      this.j.reset();
      this.j.release();
      this.j = null;
      this.g = 0;
      if (paramBoolean) {
        this.h = 0;
      }
    }
  }
  
  private void f()
  {
    this.k = 0;
    this.l = 0;
    setSurfaceTextureListener(this);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.g = 0;
    this.h = 0;
  }
  
  private void g()
  {
    if ((this.d == null) || (this.i == null)) {
      return;
    }
    Object localObject1 = new Intent("com.android.music.musicservicecommand");
    ((Intent)localObject1).putExtra("command", "pause");
    getContext().sendBroadcast((Intent)localObject1);
    a(false);
    try
    {
      Object localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(this.d.toString());
      localObject1 = ((MediaMetadataRetriever)localObject2).extractMetadata(19);
      localObject2 = ((MediaMetadataRetriever)localObject2).extractMetadata(18);
      this.l = ((int)Float.parseFloat((String)localObject1));
      this.k = ((int)Float.parseFloat((String)localObject2));
    }
    catch (Exception localException)
    {
      try
      {
        this.j = new MediaPlayer();
        this.j.setOnPreparedListener(this.b);
        this.j.setOnVideoSizeChangedListener(this.a);
        this.f = -1;
        this.j.setOnCompletionListener(this.r);
        this.j.setOnErrorListener(this.s);
        this.j.setOnBufferingUpdateListener(this.t);
        this.o = 0;
        localObject1 = new FileInputStream(new File(this.d.toString()));
        this.j.setDataSource(((FileInputStream)localObject1).getFD());
        ((FileInputStream)localObject1).close();
        this.j.setSurface(this.i);
        this.j.setAudioStreamType(3);
        this.j.setScreenOnWhilePlaying(true);
        this.j.prepareAsync();
        this.g = 1;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          CBLogging.d(this.c, "Unable to open content: " + this.d, localIOException);
          this.g = -1;
          this.h = -1;
          this.s.onError(this.j, 1, 0);
          return;
          localException = localException;
          CBLogging.d("play video", "read size error", localException);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        CBLogging.d(this.c, "Unable to open content: " + this.d, localIllegalArgumentException);
        this.g = -1;
        this.h = -1;
        this.s.onError(this.j, 1, 0);
      }
    }
  }
  
  private boolean h()
  {
    return (this.j != null) && (this.g != -1) && (this.g != 0) && (this.g != 1);
  }
  
  public void a()
  {
    if (h())
    {
      this.j.start();
      this.g = 3;
    }
    this.h = 3;
  }
  
  public void a(int paramInt)
  {
    if (h())
    {
      this.j.seekTo(paramInt);
      this.q = 0;
      return;
    }
    this.q = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.k == 0) || (this.l == 0) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    float f1 = Math.min(paramInt1 / this.k, paramInt2 / this.l);
    float f2 = this.k;
    float f3 = this.l;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f2 * f1 / paramInt1, f1 * f3 / paramInt2, paramInt1 / 2.0F, paramInt2 / 2.0F);
    setTransform(localMatrix);
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.m = paramOnCompletionListener;
  }
  
  public void a(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.p = paramOnErrorListener;
  }
  
  public void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.n = paramOnPreparedListener;
  }
  
  public void a(Uri paramUri)
  {
    a(paramUri, null);
  }
  
  public void a(Uri paramUri, Map<String, String> paramMap)
  {
    this.d = paramUri;
    this.e = paramMap;
    this.q = 0;
    g();
    requestLayout();
    invalidate();
  }
  
  public void b()
  {
    if ((h()) && (this.j.isPlaying()))
    {
      this.j.pause();
      this.g = 4;
    }
    this.h = 4;
  }
  
  public int c()
  {
    if (h())
    {
      if (this.f > 0) {
        return this.f;
      }
      this.f = this.j.getDuration();
      return this.f;
    }
    this.f = -1;
    return this.f;
  }
  
  public int d()
  {
    if (h()) {
      return this.j.getCurrentPosition();
    }
    return 0;
  }
  
  public boolean e()
  {
    return (h()) && (this.j.isPlaying());
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.i = new Surface(paramSurfaceTexture);
    g();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.i = null;
    a(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.h == 3) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((this.j != null) && (paramInt1 != 0))
      {
        if (this.q != 0) {
          a(this.q);
        }
        a();
      }
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */