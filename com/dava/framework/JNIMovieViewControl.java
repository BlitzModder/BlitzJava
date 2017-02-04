package com.dava.framework;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JNIMovieViewControl
{
  private static Map<Integer, MovieControl> controls = new HashMap();
  private static final int playerStateErrorData = 4;
  private static final int playerStateInprogress = 1;
  private static final int playerStateNoReady = 0;
  private static final int playerStatePlaying = 3;
  private static final int playerStateReady = 2;
  private static final int scalingModeAspectFill = 2;
  private static final int scalingModeAspectFit = 1;
  private static final int scalingModeFill = 3;
  private static final int scalingModeNone = 0;
  
  public static void Initialize(int paramInt, final float paramFloat1, final float paramFloat2, float paramFloat3, final float paramFloat4)
  {
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize in");
    final JNIActivity localJNIActivity = JNIActivity.GetActivity();
    if (controls.containsKey(Integer.valueOf(paramInt))) {
      localJNIActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::run(update) in");
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(Math.round(this.val$dx), Math.round(paramFloat4));
          localLayoutParams.leftMargin = ((int)paramFloat1);
          localLayoutParams.topMargin = ((int)paramFloat2);
          this.val$control.layout.setLayoutParams(localLayoutParams);
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::run(update) out");
        }
      });
    }
    for (;;)
    {
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize out");
      return;
      final MovieControl localMovieControl = new MovieControl();
      controls.put(Integer.valueOf(paramInt), localMovieControl);
      localJNIActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::run(create) in");
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(Math.round(this.val$dx), Math.round(paramFloat4));
          localLayoutParams.leftMargin = ((int)paramFloat1);
          localLayoutParams.topMargin = ((int)paramFloat2);
          RelativeLayout localRelativeLayout = new RelativeLayout(localJNIActivity);
          VideoView localVideoView = new VideoView(localRelativeLayout.getContext());
          localVideoView.setBackgroundColor(-16777216);
          localRelativeLayout.addView(localVideoView, new RelativeLayout.LayoutParams(-1, -1));
          localMovieControl.layout = localRelativeLayout;
          localMovieControl.view = localVideoView;
          localMovieControl.player = new MediaPlayer();
          localVideoView.clearAnimation();
          localRelativeLayout.clearAnimation();
          localVideoView.setZOrderOnTop(true);
          localVideoView.getHolder().addCallback(new JNIMovieViewControl.MovieHolder(localMovieControl));
          localJNIActivity.addContentView(localRelativeLayout, localLayoutParams);
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::run(create) out");
        }
      });
    }
  }
  
  public static boolean IsPlaying(int paramInt)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {}
    MovieControl localMovieControl;
    do
    {
      return false;
      localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    } while (localMovieControl.getPlayerState() == 4);
    if ((localMovieControl.getPlayerState() == 1) || (localMovieControl.getPlayerState() == 2)) {
      return true;
    }
    return localMovieControl.player.isPlaying();
  }
  
  public static void OpenMovie(int paramInt1, String paramString, int paramInt2)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt1))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::OpenMovie in");
    final MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt1));
    localMovieControl.scalingMode = paramInt2;
    localMovieControl.path = paramString;
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::OpenMovie::run in");
        try
        {
          LocalFileDescriptor localLocalFileDescriptor = new LocalFileDescriptor(this.val$path);
          localMovieControl.player.setDataSource(localLocalFileDescriptor.GetDescriptor(), localLocalFileDescriptor.GetStartOffset(), localLocalFileDescriptor.GetLength());
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::OpenMovie::run out");
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localMovieControl.setPlayerState(4);
          }
        }
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::OpenMovie out");
  }
  
  public static void Pause(int paramInt)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Pause in");
    MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Pause::run in");
        this.val$control.player.pause();
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Pause::run out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Pause out");
  }
  
  public static void Play(int paramInt)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Play in");
    MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    if (localMovieControl.getPlayerState() == 0) {
      PrepareVideo(localMovieControl);
    }
    for (;;)
    {
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Play out");
      return;
      if ((localMovieControl.getPlayerState() == 2) || (localMovieControl.getPlayerState() == 3)) {
        JNIActivity.GetActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Play::run in");
            this.val$control.setPlayerState(3);
            this.val$control.player.start();
            Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Play::run out");
          }
        });
      }
    }
  }
  
  private static void PrepareVideo(MovieControl paramMovieControl)
  {
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo in");
    paramMovieControl.setPlayerState(1);
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo::run in");
        this.val$control.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
          public void onPrepared(MediaPlayer paramAnonymous2MediaPlayer)
          {
            Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo::onPrepared in");
            int i = JNIMovieViewControl.6.this.val$control.layout.getWidth();
            int j = JNIMovieViewControl.6.this.val$control.layout.getHeight();
            int k = JNIMovieViewControl.6.this.val$control.player.getVideoWidth();
            int m = JNIMovieViewControl.6.this.val$control.player.getVideoHeight();
            if ((m == 0) || (k == 0))
            {
              JNIMovieViewControl.6.this.val$control.setPlayerState(4);
              return;
            }
            paramAnonymous2MediaPlayer = new RelativeLayout.LayoutParams(0, 0);
            switch (JNIMovieViewControl.6.this.val$control.scalingMode)
            {
            }
            for (;;)
            {
              JNIMovieViewControl.6.this.val$control.view.setLayoutParams(paramAnonymous2MediaPlayer);
              JNIMovieViewControl.6.this.val$control.player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
              {
                public void onSeekComplete(MediaPlayer paramAnonymous3MediaPlayer)
                {
                  JNIMovieViewControl.6.this.val$control.setPlayerState(3);
                  JNIMovieViewControl.6.this.val$control.player.start();
                  JNIMovieViewControl.6.this.val$control.player.setOnSeekCompleteListener(null);
                }
              });
              JNIMovieViewControl.6.this.val$control.player.seekTo(0);
              Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo::onPrepared out");
              return;
              paramAnonymous2MediaPlayer.width = Math.min(i, k);
              paramAnonymous2MediaPlayer.height = Math.min(j, m);
              paramAnonymous2MediaPlayer.leftMargin = ((i - paramAnonymous2MediaPlayer.width) / 2);
              paramAnonymous2MediaPlayer.topMargin = ((j - paramAnonymous2MediaPlayer.height) / 2);
              continue;
              if (k / i > m / j)
              {
                paramAnonymous2MediaPlayer.width = i;
                paramAnonymous2MediaPlayer.height = (m * i / k);
                paramAnonymous2MediaPlayer.topMargin = ((j - paramAnonymous2MediaPlayer.height) / 2);
              }
              else
              {
                paramAnonymous2MediaPlayer.height = j;
                paramAnonymous2MediaPlayer.width = (k * j / m);
                paramAnonymous2MediaPlayer.leftMargin = ((i - paramAnonymous2MediaPlayer.width) / 2);
                continue;
                if (k / i > m / j)
                {
                  paramAnonymous2MediaPlayer.height = j;
                  paramAnonymous2MediaPlayer.width = (k * j / m);
                  i = (i - paramAnonymous2MediaPlayer.width) / 2;
                  paramAnonymous2MediaPlayer.rightMargin = i;
                  paramAnonymous2MediaPlayer.leftMargin = i;
                  paramAnonymous2MediaPlayer.bottomMargin = 1;
                  paramAnonymous2MediaPlayer.topMargin = 1;
                }
                else
                {
                  paramAnonymous2MediaPlayer.width = i;
                  paramAnonymous2MediaPlayer.height = (m * i / k);
                  paramAnonymous2MediaPlayer.rightMargin = 1;
                  paramAnonymous2MediaPlayer.leftMargin = 1;
                  i = (j - paramAnonymous2MediaPlayer.height) / 2;
                  paramAnonymous2MediaPlayer.bottomMargin = i;
                  paramAnonymous2MediaPlayer.topMargin = i;
                  continue;
                  paramAnonymous2MediaPlayer.bottomMargin = 0;
                  paramAnonymous2MediaPlayer.rightMargin = 0;
                  paramAnonymous2MediaPlayer.width = i;
                  paramAnonymous2MediaPlayer.height = j;
                }
              }
            }
          }
        });
        this.val$control.player.prepareAsync();
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo::run out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::PrepareVideo out");
  }
  
  public static void Resume(int paramInt)
  {
    Play(paramInt);
  }
  
  public static void SetRect(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetRect in");
    MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetRect::run in");
        RelativeLayout localRelativeLayout = this.val$control.layout;
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
        localLayoutParams.leftMargin = ((int)paramFloat1);
        localLayoutParams.topMargin = ((int)paramFloat2);
        localLayoutParams.width = Math.round(paramFloat3);
        localLayoutParams.height = Math.round(paramFloat4);
        localRelativeLayout.setLayoutParams(localLayoutParams);
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetRect::run out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetRect out");
  }
  
  public static void SetVisible(int paramInt, final boolean paramBoolean)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetVisible in");
    MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetVisible::run in");
        VideoView localVideoView = this.val$control.view;
        if (paramBoolean) {}
        for (int i = 0;; i = 8)
        {
          localVideoView.setVisibility(i);
          Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetVisible::run out");
          return;
        }
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::SetVisible out");
  }
  
  public static void Stop(int paramInt)
  {
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Stop in");
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    MovieControl localMovieControl = (MovieControl)controls.get(Integer.valueOf(paramInt));
    localMovieControl.setPlayerState(0);
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Stop::run in");
        this.val$control.player.stop();
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Stop::run out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Stop out");
  }
  
  public static void Uninitialize(int paramInt)
  {
    if (!controls.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Uninitialize in");
    MovieControl localMovieControl = (MovieControl)controls.remove(Integer.valueOf(paramInt));
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Uninitialize::run in");
        ((ViewGroup)this.val$control.view.getParent()).removeView(this.val$control.view);
        this.val$control.player.release();
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Uninitialize::run out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Uninitialize out");
  }
  
  private static class MovieControl
  {
    private int _playerState = 0;
    public boolean isResetedBeforeHide = false;
    public RelativeLayout layout = null;
    public String path = null;
    public MediaPlayer player = null;
    public int scalingMode = 0;
    public VideoView view = null;
    
    int getPlayerState()
    {
      return this._playerState;
    }
    
    void setPlayerState(int paramInt)
    {
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::MovieControl::setPlayerState " + paramInt);
      if (this._playerState != 4) {
        this._playerState = paramInt;
      }
    }
  }
  
  private static class MovieHolder
    implements SurfaceHolder.Callback
  {
    private JNIMovieViewControl.MovieControl control = null;
    
    public MovieHolder(JNIMovieViewControl.MovieControl paramMovieControl)
    {
      this.control = paramMovieControl;
    }
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::MovieHolder::surfaceCreated in");
      this.control.player.setDisplay(paramSurfaceHolder);
      if (this.control.isResetedBeforeHide) {
        this.control.setPlayerState(0);
      }
      try
      {
        this.control.player.setDataSource(this.control.path);
        this.control.isResetedBeforeHide = false;
        Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::MovieHolder::surfaceCreated out");
        return;
      }
      catch (IllegalArgumentException paramSurfaceHolder)
      {
        for (;;)
        {
          paramSurfaceHolder.printStackTrace();
        }
      }
      catch (SecurityException paramSurfaceHolder)
      {
        for (;;)
        {
          paramSurfaceHolder.printStackTrace();
        }
      }
      catch (IllegalStateException paramSurfaceHolder)
      {
        for (;;)
        {
          paramSurfaceHolder.printStackTrace();
        }
      }
      catch (IOException paramSurfaceHolder)
      {
        for (;;)
        {
          paramSurfaceHolder.printStackTrace();
        }
      }
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::MovieHolder::surfaceDestroyed in");
      this.control.player.reset();
      this.control.isResetedBeforeHide = true;
      Log.d(JNIConst.LOG_TAG, "JNIMovieViewControl::Initialize::MovieHolder::surfaceDestroyed out");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIMovieViewControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */