package com.jirbo.adcolony;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.immersion.hapticmediasdk.HapticContentSDK;
import com.immersion.hapticmediasdk.HapticContentSDKFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;

public abstract class ADCVideo
  extends Activity
  implements MediaPlayer.OnPreparedListener, ADCDownload.Listener
{
  static int a;
  static int b;
  static int c;
  static boolean d;
  static boolean e;
  static boolean f;
  static boolean g;
  static boolean h;
  static boolean i;
  double A;
  String B = "";
  String C = "";
  boolean D = true;
  boolean E = true;
  boolean F;
  e G;
  ad H;
  AdColonyAd I;
  HapticContentSDK J;
  String K;
  boolean L;
  boolean M = true;
  String N = "Your purchase will begin shortly!";
  VideoView O;
  FrameLayout P;
  FrameLayout Q;
  FrameLayout R;
  Rect S = new Rect();
  ADCImage T;
  a U;
  FileInputStream V;
  PhoneStateListener W;
  boolean X = false;
  boolean Y = false;
  boolean j = true;
  boolean k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  double p;
  double q;
  long r;
  long s;
  int t;
  int u;
  int v;
  int w;
  int x;
  int y;
  int z;
  
  static void a()
  {
    a = 0;
    d = false;
    e = false;
    g = false;
  }
  
  void a(String paramString)
  {
    this.B = paramString;
    g = true;
    this.O = new VideoView(this);
    paramString = Uri.parse(paramString);
    this.O.setVideoURI(paramString);
    new MediaController(this).setMediaPlayer(this.O);
    this.O.setLayoutParams(new FrameLayout.LayoutParams(this.t, this.u, 17));
    this.R.addView(this.O);
    this.R.addView(this.U);
    setContentView(this.R);
    this.O.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.setContentView(ADCVideo.this.P);
        ADCVideo.this.R.removeAllViews();
        ADCVideo.g = false;
      }
    });
    this.O.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        ADCVideo.this.R.removeViewAt(1);
      }
    });
    this.O.start();
  }
  
  boolean b()
  {
    boolean bool = false;
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.t = localDisplayMetrics.widthPixels;
    this.u = localDisplayMetrics.heightPixels;
    this.t = localDisplayMetrics.widthPixels;
    this.u = localDisplayMetrics.heightPixels;
    this.z = -16777216;
    getWindow().setBackgroundDrawable(new ColorDrawable(this.z));
    int i1 = this.t;
    int i2 = this.u;
    this.x = i1;
    this.y = i2;
    if ((!a.m) && (this.x < this.y))
    {
      this.t = i2;
      this.u = i1;
      this.x = i2;
      this.y = i1;
    }
    if (a.K)
    {
      a.K = false;
      bool = true;
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i2 = 1;
    a.ak = false;
    super.onCreate(paramBundle);
    this.I = a.T;
    if (this.I == null)
    {
      finish();
      return;
    }
    this.L = a.i("haptics_enabled");
    this.K = a.j("haptics_filepath");
    this.N = a.j("in_progress");
    if (this.I.y == null) {
      paramBundle = a.j("video_filepath");
    }
    for (;;)
    {
      this.C = paramBundle;
      this.A = a.h("video_duration");
      if (this.L) {}
      try
      {
        this.J = HapticContentSDKFactory.GetNewSDKInstance(0, this);
        this.J.openHaptics(this.K);
        if (this.J == null) {
          this.L = false;
        }
        if (!a.i("video_enabled"))
        {
          bool = true;
          a.aa = bool;
          if (a.i("end_card_enabled")) {
            break label287;
          }
          bool = true;
          a.Z = bool;
          a.ab = a.i("load_timeout_enabled");
          a.ac = a.h("load_timeout");
          i1 = 0;
          while (i1 < a.aq.size())
          {
            if (a.aq.get(i1) != null)
            {
              paramBundle = (AdColonyNativeAdView)a.aq.get(i1);
              if (paramBundle.ag != null) {
                paramBundle.U.setVisibility(4);
              }
              if (paramBundle.S != null) {
                paramBundle.S.setVisibility(4);
              }
            }
            i1 += 1;
            continue;
            paramBundle = this.I.y.f;
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          this.L = false;
          continue;
          boolean bool = false;
          continue;
          label287:
          bool = false;
        }
        if (a.i("v4iap_enabled"))
        {
          this.I.A = AdColonyIAPEngagement.AUTOMATIC;
          this.I.v = true;
          this.I.n = a.j("product_id");
        }
        e = this.I.u;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (a.m) {
          break label494;
        }
      }
    }
    if (Build.VERSION.SDK_INT >= 10) {
      setRequestedOrientation(6);
    }
    for (;;)
    {
      setVolumeControlStream(3);
      this.G = new e(this);
      this.G.a(this);
      this.P = new FrameLayout(this);
      this.H = new ad(this);
      this.R = new FrameLayout(this);
      this.U = new a(this);
      this.T = new ADCImage(a.j("browser_icon"));
      AdColonyBrowser.A = false;
      a.U = this;
      a.V = this;
      return;
      setRequestedOrientation(0);
    }
    label494:
    int i3 = getResources().getConfiguration().orientation;
    if ((i3 == 0) || (i3 == 6) || (i3 == 2)) {}
    for (int i1 = 6;; i1 = 7)
    {
      a.F = i1;
      if ((Build.VERSION.SDK_INT < 10) || (Build.MODEL.equals("Kindle Fire"))) {
        break label567;
      }
      setRequestedOrientation(a.F);
      break;
    }
    label567:
    if (Build.MODEL.equals("Kindle Fire"))
    {
      getRequestedOrientation();
      i1 = i2;
      switch (((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        i1 = 8;
      }
    }
    for (;;)
    {
      a.F = i1;
      setRequestedOrientation(i1);
      break;
      i1 = 0;
      continue;
      i1 = 9;
      continue;
      i1 = i3;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!a.ak) {}
    v.H = false;
    v.I = null;
    if ((this.I != null) && (!this.I.w) && (this.H != null) && (!this.H.aa))
    {
      this.I.f = 1;
      this.I.x = true;
      this.I.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((v.I != null) && (v.I.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    if (paramInt == 4)
    {
      if (d) {
        if (g)
        {
          this.O.stopPlayback();
          g = false;
          this.R.removeAllViews();
          setContentView(this.P);
        }
      }
      for (;;)
      {
        return true;
        if ((this.H != null) && (this.H.t == 0))
        {
          a.ak = true;
          this.H.g();
          continue;
          if ((this.H != null) && (v.I != null))
          {
            paramKeyEvent = v.I.o.iterator();
            while (paramKeyEvent.hasNext()) {
              ((ADCImage)paramKeyEvent.next()).a();
            }
            v.I = null;
            v.H = false;
            this.G.start();
            this.F = true;
          }
          else if ((this.H != null) && (this.H.M) && (this.H.O))
          {
            a.ak = true;
            this.H.h();
          }
        }
      }
    }
    if (paramInt == 82) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    h = false;
    if (g)
    {
      if (this.O != null)
      {
        b = this.O.getCurrentPosition();
        this.O.stopPlayback();
      }
      if (d)
      {
        View localView = new View(this);
        localView.setBackgroundColor(-16777216);
        setContentView(localView);
        this.s = System.currentTimeMillis();
        if (!isFinishing()) {
          this.q += (this.s - this.r) / 1000.0D;
        }
      }
      if ((this.G == null) || (this.Y)) {
        break label244;
      }
      if (this.G.getCurrentPosition() != 0) {
        a = this.G.getCurrentPosition();
      }
      this.G.a();
      this.F = false;
      this.G.setBackgroundColor(-16777216);
      if (this.L) {
        this.J.pause();
      }
    }
    for (;;)
    {
      if (this.H != null)
      {
        this.H.A = true;
        this.H.I = false;
        this.H.H = false;
        this.H.J = false;
        this.H.u = 0;
        this.H.t = 0;
        this.H.invalidate();
      }
      super.onPause();
      AdColony.pause();
      return;
      b = 0;
      break;
      label244:
      a = 0;
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.j)
    {
      i1 = this.G.getDuration() / 1000;
      l.a.a("duration, actual_duration = ").a(this.A).a(", ").b(i1);
      if ((this.A / i1 <= 0.9D) || (this.A / i1 >= 1.1D)) {
        break label85;
      }
    }
    label85:
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      finish();
      return;
    }
    a.l.a(this.I);
    this.j = false;
  }
  
  public void onResume()
  {
    h = true;
    super.onResume();
    AdColony.resume(this);
    if (a.a()) {
      finish();
    }
    b();
    if (this.D)
    {
      this.D = false;
      if (!d)
      {
        if (this.H.Q) {
          this.Q.addView(this.H.a);
        }
        if (this.H.Q) {
          this.Q.setVisibility(4);
        }
        if (Build.MODEL.equals("Kindle Fire")) {
          this.H.m = 20;
        }
        if (Build.MODEL.equals("SCH-I800")) {
          this.H.m = 25;
        }
        this.P.addView(this.G, new FrameLayout.LayoutParams(this.x, this.y, 17));
        if (this.H.Q) {
          this.P.addView(this.Q, new FrameLayout.LayoutParams(this.t, this.u - this.H.m, 17));
        }
        this.P.addView(this.H, new FrameLayout.LayoutParams(this.t, this.u, 17));
      }
    }
    if (g)
    {
      this.R.removeView(this.U);
      this.R.addView(this.U);
      setContentView(this.R);
    }
    for (;;)
    {
      this.G.a(this.H);
      this.G.a(this.H);
      try
      {
        this.V = new FileInputStream(this.C);
        this.G.a(this.V.getFD());
        if (!i) {
          onWindowFocusChanged(true);
        }
        if (a.aa)
        {
          this.H.a();
          this.H.d();
        }
        return;
      }
      catch (IOException localIOException)
      {
        a.e("Unable to play video: " + a.j("video_filepath"));
        this.H.c(true);
      }
      setContentView(this.P);
      if (d) {
        this.r = System.currentTimeMillis();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i = false;
      Object localObject1;
      Object localObject2;
      if ((this.G != null) && (!d) && (h)) {
        if (this.G != null)
        {
          if (c != 0) {
            a = c;
          }
          c = 0;
          if (this.G != null) {
            this.G.seekTo(a);
          }
          if (!a.m) {
            break label267;
          }
          localObject1 = new Handler();
          localObject2 = new Runnable()
          {
            public void run()
            {
              if (ADCVideo.this.G != null) {
                ADCVideo.this.G.setBackgroundColor(0);
              }
            }
          };
          if (this.G != null) {
            this.G.setBackgroundColor(-16777216);
          }
        }
      }
      label234:
      label266:
      label267:
      label285:
      label299:
      do
      {
        ((Handler)localObject1).postDelayed((Runnable)localObject2, 900L);
        break label266;
        if ((!v.H) && (!this.Y) && (this.H != null))
        {
          this.H.S = false;
          if (this.G != null) {
            this.G.start();
          }
          this.F = true;
          if (!this.M) {
            break label299;
          }
          if (this.L) {
            this.J.play();
          }
          if ((this.I != null) && (this.H != null) && (this.H.a != null))
          {
            localObject2 = this.H.a;
            if (this.I.y != null) {
              break label285;
            }
            localObject1 = this.I.o;
            ((WebView)localObject2).loadUrl((String)localObject1);
          }
          this.M = false;
        }
        for (;;)
        {
          if (this.H != null)
          {
            this.H.requestFocus();
            this.H.invalidate();
          }
          return;
          if (this.G == null) {
            break;
          }
          this.G.setBackgroundColor(0);
          break;
          localObject1 = this.I.y.aq;
          break label234;
          if (this.L) {
            this.J.resume();
          }
        }
        if (g)
        {
          if (this.O != null)
          {
            this.O.seekTo(b);
            this.O.start();
            return;
          }
          if (this.R != null) {
            this.R.removeAllViews();
          }
          setContentView(this.P);
          return;
        }
      } while ((!d) || (this.H == null));
      this.H.invalidate();
      return;
    }
    if ((h) && (!this.Y) && (this.G != null))
    {
      if (this.L) {
        this.J.pause();
      }
      a = this.G.getCurrentPosition();
      this.G.pause();
      this.F = false;
    }
    i = true;
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.H == null) {
        return;
      }
      if (!this.H.Q) {
        return;
      }
      String str = aa.a(a.ae, "");
      localStringBuilder = new StringBuilder(str.length());
      localStringBuilder.append("<script type=\"text/javascript\">");
      localStringBuilder.append(str);
      localStringBuilder.append("</script>");
      if ((paramADCDownload.p == null) && (this.H != null))
      {
        this.H.ah = null;
        return;
      }
    }
    catch (OutOfMemoryError paramADCDownload)
    {
      l.d.b("OutOfMemoryError - disabling AdColony.");
      if (this.H != null) {
        this.H.c(true);
      }
      AdColony.disable();
      return;
    }
    paramADCDownload.p = paramADCDownload.p.replaceFirst("<script (type=\"text/javascript\")?((\\s)*src=\"mraid.js\"){1}></script>", Matcher.quoteReplacement(localStringBuilder.toString()));
    if (this.H != null) {
      this.H.ah = paramADCDownload;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (ADCVideo.this.H != null) {
          ADCVideo.this.H.c();
        }
      }
    });
  }
  
  class a
    extends View
  {
    Rect a = new Rect();
    
    public a(Activity paramActivity)
    {
      super();
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      paramCanvas.drawARGB(255, 0, 0, 0);
      getDrawingRect(this.a);
      ADCVideo.this.T.a(paramCanvas, (this.a.width() - ADCVideo.this.T.f) / 2, (this.a.height() - ADCVideo.this.T.g) / 2);
      invalidate();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ADCVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */