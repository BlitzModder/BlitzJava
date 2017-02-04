package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zznl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzha
public class zzc
  extends zzi
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map<Integer, String> zzCN = new HashMap();
  private final zzp zzCO;
  private int zzCP = 0;
  private int zzCQ = 0;
  private MediaPlayer zzCR;
  private Uri zzCS;
  private int zzCT;
  private int zzCU;
  private int zzCV;
  private int zzCW;
  private int zzCX;
  private float zzCY = 1.0F;
  private boolean zzCZ;
  private boolean zzDa;
  private int zzDb;
  private zzh zzDc;
  
  static
  {
    zzCN.put(Integer.valueOf(64532), "MEDIA_ERROR_IO");
    zzCN.put(Integer.valueOf(64529), "MEDIA_ERROR_MALFORMED");
    zzCN.put(Integer.valueOf(64526), "MEDIA_ERROR_UNSUPPORTED");
    zzCN.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
    zzCN.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    zzCN.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
    zzCN.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
    zzCN.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    zzCN.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    zzCN.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    zzCN.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    zzCN.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    zzCN.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    zzCN.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    zzCN.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
    zzCN.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
  }
  
  public zzc(Context paramContext, zzp paramzzp)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.zzCO = paramzzp;
    this.zzCO.zza(this);
  }
  
  private void zzb(float paramFloat)
  {
    if (this.zzCR != null) {}
    try
    {
      this.zzCR.setVolume(paramFloat, paramFloat);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
    zzb.zzaH("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    return;
  }
  
  private void zzeP()
  {
    zzb.v("AdMediaPlayerView init MediaPlayer");
    SurfaceTexture localSurfaceTexture = getSurfaceTexture();
    if ((this.zzCS == null) || (localSurfaceTexture == null)) {
      return;
    }
    zzv(false);
    try
    {
      this.zzCR = new MediaPlayer();
      this.zzCR.setOnBufferingUpdateListener(this);
      this.zzCR.setOnCompletionListener(this);
      this.zzCR.setOnErrorListener(this);
      this.zzCR.setOnInfoListener(this);
      this.zzCR.setOnPreparedListener(this);
      this.zzCR.setOnVideoSizeChangedListener(this);
      this.zzCV = 0;
      this.zzCR.setDataSource(getContext(), this.zzCS);
      this.zzCR.setSurface(new Surface(localSurfaceTexture));
      this.zzCR.setAudioStreamType(3);
      this.zzCR.setScreenOnWhilePlaying(true);
      this.zzCR.prepareAsync();
      zzw(1);
      return;
    }
    catch (IOException localIOException)
    {
      zzb.zzd("Failed to initialize MediaPlayer at " + this.zzCS, localIOException);
      onError(this.zzCR, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  private void zzeQ()
  {
    if ((zzeT()) && (this.zzCR.getCurrentPosition() > 0) && (this.zzCQ != 3))
    {
      zzb.v("AdMediaPlayerView nudging MediaPlayer");
      zzb(0.0F);
      this.zzCR.start();
      int i = this.zzCR.getCurrentPosition();
      long l = com.google.android.gms.ads.internal.zzp.zzbB().currentTimeMillis();
      while ((zzeT()) && (this.zzCR.getCurrentPosition() == i) && (com.google.android.gms.ads.internal.zzp.zzbB().currentTimeMillis() - l <= 250L)) {}
      this.zzCR.pause();
      zzeY();
    }
  }
  
  private void zzeR()
  {
    AudioManager localAudioManager = zzeZ();
    if ((localAudioManager != null) && (!this.zzDa))
    {
      if (localAudioManager.requestAudioFocus(this, 3, 2) == 1) {
        zzeW();
      }
    }
    else {
      return;
    }
    zzb.zzaH("AdMediaPlayerView audio focus request failed");
  }
  
  private void zzeS()
  {
    zzb.v("AdMediaPlayerView abandon audio focus");
    AudioManager localAudioManager = zzeZ();
    if ((localAudioManager != null) && (this.zzDa))
    {
      if (localAudioManager.abandonAudioFocus(this) == 1) {
        this.zzDa = false;
      }
    }
    else {
      return;
    }
    zzb.zzaH("AdMediaPlayerView abandon audio focus failed");
  }
  
  private boolean zzeT()
  {
    return (this.zzCR != null) && (this.zzCP != -1) && (this.zzCP != 0) && (this.zzCP != 1);
  }
  
  private void zzeW()
  {
    zzb.v("AdMediaPlayerView audio focus gained");
    this.zzDa = true;
    zzeY();
  }
  
  private void zzeX()
  {
    zzb.v("AdMediaPlayerView audio focus lost");
    this.zzDa = false;
    zzeY();
  }
  
  private void zzeY()
  {
    if ((!this.zzCZ) && (this.zzDa))
    {
      zzb(this.zzCY);
      return;
    }
    zzb(0.0F);
  }
  
  private AudioManager zzeZ()
  {
    return (AudioManager)getContext().getSystemService("audio");
  }
  
  private void zzv(boolean paramBoolean)
  {
    zzb.v("AdMediaPlayerView release");
    if (this.zzCR != null)
    {
      this.zzCR.reset();
      this.zzCR.release();
      this.zzCR = null;
      zzw(0);
      if (paramBoolean)
      {
        this.zzCQ = 0;
        zzx(0);
      }
      zzeS();
    }
  }
  
  private void zzw(int paramInt)
  {
    if (paramInt == 3) {
      this.zzCO.zzfB();
    }
    for (;;)
    {
      this.zzCP = paramInt;
      return;
      if ((this.zzCP == 3) && (paramInt != 3)) {
        this.zzCO.zzfC();
      }
    }
  }
  
  private void zzx(int paramInt)
  {
    this.zzCQ = paramInt;
  }
  
  public int getCurrentPosition()
  {
    if (zzeT()) {
      return this.zzCR.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (zzeT()) {
      return this.zzCR.getDuration();
    }
    return -1;
  }
  
  public int getVideoHeight()
  {
    if (this.zzCR != null) {
      return this.zzCR.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.zzCR != null) {
      return this.zzCR.getVideoWidth();
    }
    return 0;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0) {
      zzeW();
    }
    while (paramInt >= 0) {
      return;
    }
    zzeX();
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.zzCV = paramInt;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    zzb.v("AdMediaPlayerView completion");
    zzw(5);
    zzx(5);
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzfq();
        }
      }
    });
  }
  
  public boolean onError(final MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzCN.get(Integer.valueOf(paramInt1));
    final String str = (String)zzCN.get(Integer.valueOf(paramInt2));
    zzb.zzaH("AdMediaPlayerView MediaPlayer error: " + paramMediaPlayer + ":" + str);
    zzw(-1);
    zzx(-1);
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzg(paramMediaPlayer, str);
        }
      }
    });
    return true;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzCN.get(Integer.valueOf(paramInt1));
    String str = (String)zzCN.get(Integer.valueOf(paramInt2));
    zzb.v("AdMediaPlayerView MediaPlayer info: " + paramMediaPlayer + ":" + str);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(this.zzCT, paramInt1);
    int m = getDefaultSize(this.zzCU, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (this.zzCT > 0)
    {
      j = m;
      i = k;
      if (this.zzCU > 0)
      {
        m = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        n = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((m != 1073741824) || (n != 1073741824)) {
          break label211;
        }
        if (this.zzCT * paramInt2 >= this.zzCU * paramInt1) {
          break label178;
        }
        i = this.zzCT * paramInt2 / this.zzCU;
        j = paramInt2;
      }
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((this.zzCW > 0) && (this.zzCW != i)) || ((this.zzCX > 0) && (this.zzCX != j))) {
          zzeQ();
        }
        this.zzCW = i;
        this.zzCX = j;
      }
      return;
      label178:
      if (this.zzCT * paramInt2 > this.zzCU * paramInt1)
      {
        j = this.zzCU * paramInt1 / this.zzCT;
        i = paramInt1;
        continue;
        label211:
        if (m == 1073741824)
        {
          j = this.zzCU * paramInt1 / this.zzCT;
          if ((n == Integer.MIN_VALUE) && (j > paramInt2))
          {
            j = paramInt2;
            i = paramInt1;
          }
        }
        else
        {
          if (n == 1073741824)
          {
            k = this.zzCT * paramInt2 / this.zzCU;
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              continue;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              continue;
            }
            j = paramInt2;
            i = paramInt1;
            continue;
          }
          k = this.zzCT;
          i = this.zzCU;
          if ((n == Integer.MIN_VALUE) && (i > paramInt2)) {
            k = this.zzCT * paramInt2 / this.zzCU;
          }
          for (;;)
          {
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              break;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              break;
            }
            j = this.zzCU * paramInt1 / this.zzCT;
            i = paramInt1;
            break;
            paramInt2 = i;
          }
        }
        i = paramInt1;
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    zzb.v("AdMediaPlayerView prepared");
    zzw(2);
    this.zzCO.zzfo();
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzfo();
        }
      }
    });
    this.zzCT = paramMediaPlayer.getVideoWidth();
    this.zzCU = paramMediaPlayer.getVideoHeight();
    if (this.zzDb != 0) {
      seekTo(this.zzDb);
    }
    zzeQ();
    zzb.zzaG("AdMediaPlayerView stream dimensions: " + this.zzCT + " x " + this.zzCU);
    if (this.zzCQ == 3) {
      play();
    }
    zzeR();
    zzeY();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    zzb.v("AdMediaPlayerView surface created");
    zzeP();
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null) {
          zzc.zza(zzc.this).zzfn();
        }
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    zzb.v("AdMediaPlayerView surface destroyed");
    if ((this.zzCR != null) && (this.zzDb == 0)) {
      this.zzDb = this.zzCR.getCurrentPosition();
    }
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if (zzc.zza(zzc.this) != null)
        {
          zzc.zza(zzc.this).onPaused();
          zzc.zza(zzc.this).zzfr();
        }
      }
    });
    zzv(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int j = 1;
    zzb.v("AdMediaPlayerView surface changed");
    int i;
    if (this.zzCQ == 3)
    {
      i = 1;
      if ((this.zzCT != paramInt1) || (this.zzCU != paramInt2)) {
        break label81;
      }
    }
    label81:
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if ((this.zzCR != null) && (i != 0) && (paramInt1 != 0))
      {
        if (this.zzDb != 0) {
          seekTo(this.zzDb);
        }
        play();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.zzCO.zzb(this);
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    zzb.v("AdMediaPlayerView size changed: " + paramInt1 + " x " + paramInt2);
    this.zzCT = paramMediaPlayer.getVideoWidth();
    this.zzCU = paramMediaPlayer.getVideoHeight();
    if ((this.zzCT != 0) && (this.zzCU != 0)) {
      requestLayout();
    }
  }
  
  public void pause()
  {
    zzb.v("AdMediaPlayerView pause");
    if ((zzeT()) && (this.zzCR.isPlaying()))
    {
      this.zzCR.pause();
      zzw(4);
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          if (zzc.zza(zzc.this) != null) {
            zzc.zza(zzc.this).onPaused();
          }
        }
      });
    }
    zzx(4);
  }
  
  public void play()
  {
    zzb.v("AdMediaPlayerView play");
    if (zzeT())
    {
      this.zzCR.start();
      zzw(3);
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          if (zzc.zza(zzc.this) != null) {
            zzc.zza(zzc.this).zzfp();
          }
        }
      });
    }
    zzx(3);
  }
  
  public void seekTo(int paramInt)
  {
    zzb.v("AdMediaPlayerView seek " + paramInt);
    if (zzeT())
    {
      this.zzCR.seekTo(paramInt);
      this.zzDb = 0;
      return;
    }
    this.zzDb = paramInt;
  }
  
  public void setMimeType(String paramString) {}
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    this.zzCS = paramUri;
    this.zzDb = 0;
    zzeP();
    requestLayout();
    invalidate();
  }
  
  public void stop()
  {
    zzb.v("AdMediaPlayerView stop");
    if (this.zzCR != null)
    {
      this.zzCR.stop();
      this.zzCR.release();
      this.zzCR = null;
      zzw(0);
      zzx(0);
      zzeS();
    }
    this.zzCO.onStop();
  }
  
  public String toString()
  {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
  
  public void zza(float paramFloat)
  {
    this.zzCY = paramFloat;
    zzeY();
  }
  
  public void zza(zzh paramzzh)
  {
    this.zzDc = paramzzh;
  }
  
  public String zzeO()
  {
    return "MediaPlayer";
  }
  
  public void zzeU()
  {
    this.zzCZ = true;
    zzeY();
  }
  
  public void zzeV()
  {
    this.zzCZ = false;
    zzeY();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */