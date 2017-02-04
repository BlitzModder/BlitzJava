package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.util.ArrayList;

public class AdColonyNativeAdView
  extends FrameLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  boolean A;
  boolean B = true;
  boolean C;
  boolean D = true;
  boolean E;
  boolean F;
  boolean G;
  boolean H;
  boolean I;
  boolean J;
  boolean K;
  String L;
  AdColonyInterstitialAd M;
  AdColonyNativeAdListener N;
  AdColonyNativeAdMutedListener O;
  ADCImage P;
  ADCImage Q;
  ADCImage R;
  ImageView S;
  b T;
  View U;
  Bitmap V;
  ADCImage W;
  TextView a;
  n.ad aA;
  n.a aB;
  float aC = 0.25F;
  float aD = 0.25F;
  float aE;
  boolean aF;
  boolean aG;
  boolean aH;
  FrameLayout.LayoutParams aI;
  FrameLayout.LayoutParams aJ;
  FileInputStream aK;
  ImageView aa;
  boolean ab = false;
  Button ac;
  String ad = "";
  String ae = "";
  String af = "";
  MediaPlayer ag;
  Surface ah;
  String ai;
  String aj;
  String ak;
  String al;
  String am;
  String an;
  String ao;
  String ap = "";
  String aq = "";
  AdColonyIAPEngagement ar = AdColonyIAPEngagement.NONE;
  int as;
  int at;
  int au;
  int av = -1;
  int aw;
  int ax = -3355444;
  int ay = -16777216;
  int az;
  TextView b;
  TextView c;
  Activity d;
  String e;
  String f;
  ViewGroup g;
  SurfaceTexture h;
  int i;
  int j;
  int k;
  int l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  boolean s;
  boolean t;
  boolean u;
  boolean v;
  boolean w;
  boolean x;
  boolean y;
  boolean z;
  
  public AdColonyNativeAdView(Activity paramActivity, String paramString, int paramInt)
  {
    super(paramActivity);
    a(paramActivity, paramString, paramInt);
    a();
  }
  
  public AdColonyNativeAdView(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    a(paramActivity, paramString, paramInt1, paramInt2);
    a(false);
  }
  
  AdColonyNativeAdView(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramActivity);
    this.G = paramBoolean;
    a(paramActivity, paramString, paramInt);
    a();
  }
  
  void a()
  {
    a(true);
  }
  
  void a(float paramFloat, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      do
      {
        do
        {
          return;
          this.aD = paramFloat;
          if ((this.ag == null) || (paramFloat < 0.0D) || (paramFloat > 1.0D)) {
            break;
          }
          if (!this.x) {
            this.ag.setVolume(paramFloat, paramFloat);
          }
        } while (!this.z);
        if ((this.V == this.R.a) && (paramFloat > 0.0D) && (!this.x))
        {
          localg = new ADCData.g();
          localg.b("user_action", paramBoolean);
          this.S.setImageBitmap(this.Q.a);
          this.V = this.Q.a;
          a.l.d.a("sound_unmute", localg, this.M);
          this.r = true;
          return;
        }
      } while ((this.V != this.Q.a) || (paramFloat != 0.0D));
      ADCData.g localg = new ADCData.g();
      localg.b("user_action", paramBoolean);
      this.S.setImageBitmap(this.R.a);
      this.V = this.R.a;
      a.l.d.a("sound_mute", localg, this.M);
      this.r = false;
      return;
    } while ((paramFloat < 0.0D) || (paramFloat > 1.0D));
    this.aC = paramFloat;
  }
  
  void a(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, paramString, paramInt, 0);
  }
  
  void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    a.e();
    a.am = 0;
    this.d = paramActivity;
    this.e = paramString;
    this.au = paramInt1;
    this.k = paramInt1;
    if (paramInt2 != 0)
    {
      this.l = paramInt2;
      this.av = paramInt2;
      this.o = true;
    }
    this.r = true;
    if (a.b() == null) {}
    label125:
    label274:
    label280:
    do
    {
      return;
      this.aE = a.b().getResources().getDisplayMetrics().density;
      paramActivity = a.b().getWindowManager().getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 14)
      {
        Point localPoint = new Point();
        paramActivity.getSize(localPoint);
        paramInt1 = localPoint.x;
        paramInt2 = localPoint.y;
        if (paramInt1 >= paramInt2) {
          break label274;
        }
      }
      for (;;)
      {
        this.az = paramInt1;
        this.M = new AdColonyInterstitialAd(paramString);
        this.M.k = "native";
        this.M.l = "native";
        setBackgroundColor(-16777216);
        if (!this.B) {
          break;
        }
        if ((this.M.b(true)) && (this.M.j != null) && (this.M.j.A != null)) {
          break label280;
        }
        if (!this.G)
        {
          l.d.b("AdColonyNativeAdView created while no ads are available, returning blank view.");
          this.M.g = 5;
          a.l.d.a(paramString, this.M);
        }
        this.aH = true;
        return;
        paramInt1 = paramActivity.getWidth();
        paramInt2 = paramActivity.getHeight();
        break label125;
        paramInt1 = paramInt2;
      }
      this.aA = this.M.i;
    } while (this.G);
    if (!this.G) {
      a.aq.add(this);
    }
    this.M.i.c();
    if (!this.M.a(true)) {
      this.aH = true;
    }
    this.M.j.A.i = true;
    a.l.d.a(paramString, this.M);
  }
  
  void a(boolean paramBoolean)
  {
    this.z = false;
    this.q = false;
    setWillNotDraw(false);
    this.M.y = this;
    label321:
    label398:
    label406:
    float f1;
    float f3;
    if (this.B)
    {
      if ((a.l != null) && (a.l.a != null) && (this.M != null) && (this.M.h != null) && ((a.l.a(this.M.h, true, false)) || (!this.aH)))
      {
        a.l.a.b(this.e);
        this.f = a.j("video_filepath");
        this.ai = a.j("advertiser_name");
        this.aj = a.j("description");
        this.ak = a.j("title");
        this.al = a.j("poster_image");
        this.am = a.j("unmute");
        this.an = a.j("mute");
        this.ao = a.j("thumb_image");
        this.ab = a.i("native_engagement_enabled");
        this.ad = a.j("native_engagement_label");
        this.ae = a.j("native_engagement_command");
        this.af = a.j("native_engagement_type");
        this.J = a.i("v4iap_enabled");
        this.K = a.i("click_to_install");
        this.L = a.j("store_url");
        this.aq = a.ad;
        if (this.J) {
          this.ar = AdColonyIAPEngagement.AUTOMATIC;
        }
        this.ap = a.j("product_id");
        if ((this.M.j == null) || (this.M.j.A == null)) {
          break label398;
        }
        this.y = this.M.j.A.b;
        if (this.aA != null) {
          this.aA.m();
        }
        if ((this.M.j != null) && (this.M.j.A != null) && (this.M.j.A.a) && (this.M.i != null)) {
          break label406;
        }
        a.am = 13;
      }
      label588:
      label726:
      label796:
      label930:
      label1139:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.u = true;
              break;
              this.y = true;
              break label321;
              this.s = true;
            } while (this.G);
            if (this.B)
            {
              this.as = this.M.j.z.b;
              this.at = this.M.j.z.c;
              a.h();
              if (this.av == -1)
              {
                this.av = ((int)(this.at * (this.au / this.as)));
                this.l = this.av;
              }
              if ((!paramBoolean) && (this.ab)) {
                this.av -= this.av / 6;
              }
              f1 = this.au / this.as;
              float f2 = this.av / this.at;
              f3 = this.as / this.at;
              if (f1 <= f2) {
                break label1403;
              }
              this.aG = true;
              this.au = ((int)(this.av * f3));
              this.aJ = new FrameLayout.LayoutParams(this.au, this.av, 48);
              this.aI = new FrameLayout.LayoutParams(this.k, this.l, 48);
              if ((!this.ab) || (paramBoolean) || (!this.aF)) {
                break label1424;
              }
              this.aJ.setMargins(0, (this.l - this.av) / 2 - this.av / 10, 0, 0);
              this.aI.setMargins(0, (this.l - this.av) / 2 - this.av / 10, 0, ((this.l - this.av) / 2 - this.av / 10) * -1);
              this.P = new ADCImage(this.al, true, false);
              if (1.0F / (this.P.f / this.au) <= 1.0F / (this.P.g / this.av)) {
                break label1635;
              }
              f1 = 1.0F / (this.P.g / this.av);
              this.P.a(f1, true);
              this.B = false;
            }
            if (!this.ab) {
              break label930;
            }
          } while (a.b() == null);
          this.ac = new Button(a.b());
          this.ac.setText(this.ad);
          this.ac.setGravity(17);
          this.ac.setTextSize((int)(18.0D * (this.au / this.az)));
          this.ac.setPadding(0, 0, 0, 0);
          this.ac.setBackgroundColor(this.ax);
          this.ac.setTextColor(this.ay);
          this.ac.setOnTouchListener(new View.OnTouchListener()
          {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              int i = paramAnonymousMotionEvent.getAction();
              if (i == 0)
              {
                paramAnonymousView = new float[3];
                Color.colorToHSV(AdColonyNativeAdView.this.ax, paramAnonymousView);
                paramAnonymousView[2] *= 0.8F;
                AdColonyNativeAdView.this.ac.setBackgroundColor(Color.HSVToColor(paramAnonymousView));
              }
              do
              {
                return true;
                if (i == 3)
                {
                  AdColonyNativeAdView.this.ac.setBackgroundColor(AdColonyNativeAdView.this.ax);
                  return true;
                }
              } while (i != 1);
              if (AdColonyNativeAdView.this.J)
              {
                AdColonyNativeAdView.this.ar = AdColonyIAPEngagement.OVERLAY;
                AdColonyNativeAdView.this.u = true;
                return true;
              }
              if ((AdColonyNativeAdView.this.af.equals("install")) || (AdColonyNativeAdView.this.af.equals("url"))) {
                a.l.d.b("native_overlay_click", AdColonyNativeAdView.this.M);
              }
              try
              {
                paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse(AdColonyNativeAdView.this.ae));
                if (a.b() != null) {
                  a.b().startActivity(paramAnonymousView);
                }
                AdColonyNativeAdView.this.ac.setBackgroundColor(AdColonyNativeAdView.this.ax);
                return true;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  if (a.b() != null) {
                    Toast.makeText(a.b(), "Unable to open store.", 0).show();
                  }
                }
              }
            }
          });
          this.R = new ADCImage(this.am, true, false);
          this.Q = new ADCImage(this.an, true, false);
          this.W = new ADCImage(this.ao, true, false);
          this.W.a(1.0F / (float)(this.W.f / this.au / (this.au / 5.5D / this.au)), true);
          this.Q.a(this.aE / 2.0F, true);
          this.R.a(this.aE / 2.0F, true);
        } while (a.b() == null);
        this.T = new b(a.b());
        this.aa = new ImageView(a.b());
        this.S = new ImageView(a.b());
        this.aa.setImageBitmap(this.W.a);
        if (!this.r) {
          break label1655;
        }
        this.S.setImageBitmap(this.Q.a);
        localLayoutParams = new FrameLayout.LayoutParams(this.Q.f, this.Q.g, 48);
        localLayoutParams.setMargins(this.k - this.Q.f, 0, 0, 0);
        this.S.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (AdColonyNativeAdView.this.r)
            {
              if (AdColonyNativeAdView.this.O != null) {
                AdColonyNativeAdView.this.O.onAdColonyNativeAdMuted(AdColonyNativeAdView.this, true);
              }
              AdColonyNativeAdView.this.a(true, true);
              AdColonyNativeAdView.this.x = true;
            }
            while (AdColonyNativeAdView.this.V != AdColonyNativeAdView.this.R.a) {
              return;
            }
            if (AdColonyNativeAdView.this.O != null) {
              AdColonyNativeAdView.this.O.onAdColonyNativeAdMuted(AdColonyNativeAdView.this, false);
            }
            AdColonyNativeAdView.this.x = false;
            AdColonyNativeAdView.this.a(false, true);
          }
        });
        this.V = this.Q.a;
        if (this.u) {
          this.S.setVisibility(8);
        }
        if (this.v) {
          this.S.setVisibility(4);
        }
        if ((Build.VERSION.SDK_INT >= 14) && (a.b() != null)) {
          this.U = new a(a.b(), this.u);
        }
        if (Build.VERSION.SDK_INT >= 14) {
          addView(this.U, this.aJ);
        }
        if (Build.VERSION.SDK_INT < 14) {
          this.u = true;
        }
        addView(this.T, this.aI);
        if ((this.y) && (Build.VERSION.SDK_INT >= 14) && (this.D)) {
          addView(this.S, localLayoutParams);
        }
      } while (!this.ab);
      if (!paramBoolean) {
        break label1672;
      }
    }
    label1403:
    label1424:
    label1635:
    label1655:
    label1672:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.k, this.l / 5, 80);; localLayoutParams = new FrameLayout.LayoutParams(this.k, this.av / 5, 80))
    {
      addView(this.ac, localLayoutParams);
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        break;
      }
      return;
      this.aF = true;
      this.av = ((int)(this.au / f3));
      break label588;
      if ((!paramBoolean) && (this.aF))
      {
        this.aJ.setMargins(0, (this.l - this.av) / 2, 0, 0);
        this.aI.setMargins(0, (this.l - this.av) / 2, 0, (this.l - this.av) / 2 * -1);
        break label726;
      }
      if ((this.ab) && (!paramBoolean) && (this.aG))
      {
        this.aJ.setMargins((this.k - this.au) / 2, 0, 0, 0);
        this.aI.setMargins((this.k - this.au) / 2, 0, (this.k - this.au) / 2 * -1, 0);
        break label726;
      }
      if ((paramBoolean) || (!this.aG)) {
        break label726;
      }
      this.aJ.setMargins((this.k - this.au) / 2, 0, 0, 0);
      this.aI.setMargins((this.k - this.au) / 2, 0, (this.k - this.au) / 2 * -1, 0);
      break label726;
      f1 = 1.0F / (this.P.f / this.au);
      break label796;
      this.S.setImageBitmap(this.R.a);
      break label1139;
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.S.setImageBitmap(this.R.a);
      this.r = false;
      a(0.0F, paramBoolean2);
      this.V = this.R.a;
    }
    while ((this.x) || (this.V != this.R.a)) {
      return;
    }
    this.S.setImageBitmap(this.Q.a);
    this.r = true;
    if (this.ag != null)
    {
      if (this.aD == 0.0D) {
        break label119;
      }
      a(this.aD, paramBoolean2);
    }
    for (;;)
    {
      this.V = this.Q.a;
      return;
      label119:
      a(0.25F, paramBoolean2);
    }
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 484	com/jirbo/adcolony/AdColonyNativeAdView:u	Z
    //   6: ifne +20 -> 26
    //   9: aload_0
    //   10: getfield 194	com/jirbo/adcolony/AdColonyNativeAdView:ag	Landroid/media/MediaPlayer;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 194	com/jirbo/adcolony/AdColonyNativeAdView:ag	Landroid/media/MediaPlayer;
    //   20: invokevirtual 598	android/media/MediaPlayer:isPlaying	()Z
    //   23: ifne +12 -> 35
    //   26: aload_0
    //   27: getfield 194	com/jirbo/adcolony/AdColonyNativeAdView:ag	Landroid/media/MediaPlayer;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 171	com/jirbo/adcolony/AdColonyNativeAdView:aD	F
    //   43: invokevirtual 600	com/jirbo/adcolony/AdColonyNativeAdView:setVolume	(F)V
    //   46: aload_0
    //   47: getfield 194	com/jirbo/adcolony/AdColonyNativeAdView:ag	Landroid/media/MediaPlayer;
    //   50: invokevirtual 603	android/media/MediaPlayer:start	()V
    //   53: getstatic 236	com/jirbo/adcolony/a:l	Lcom/jirbo/adcolony/d;
    //   56: aload_0
    //   57: getfield 245	com/jirbo/adcolony/AdColonyNativeAdView:M	Lcom/jirbo/adcolony/AdColonyInterstitialAd;
    //   60: invokevirtual 606	com/jirbo/adcolony/d:a	(Lcom/jirbo/adcolony/AdColonyAd;)V
    //   63: aload_0
    //   64: getfield 245	com/jirbo/adcolony/AdColonyNativeAdView:M	Lcom/jirbo/adcolony/AdColonyInterstitialAd;
    //   67: iconst_1
    //   68: putfield 607	com/jirbo/adcolony/AdColonyInterstitialAd:s	Z
    //   71: aload_0
    //   72: getfield 609	com/jirbo/adcolony/AdColonyNativeAdView:N	Lcom/jirbo/adcolony/AdColonyNativeAdListener;
    //   75: ifnull -40 -> 35
    //   78: aload_0
    //   79: getfield 609	com/jirbo/adcolony/AdColonyNativeAdView:N	Lcom/jirbo/adcolony/AdColonyNativeAdListener;
    //   82: iconst_0
    //   83: aload_0
    //   84: invokeinterface 615 3 0
    //   89: goto -54 -> 35
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	AdColonyNativeAdView
    //   30	2	1	localMediaPlayer	MediaPlayer
    //   92	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	92	finally
    //   26	31	92	finally
    //   38	89	92	finally
  }
  
  boolean b(boolean paramBoolean)
  {
    return ((this.M.a(true)) || (!this.aH)) && (AdColony.isZoneNative(this.e));
  }
  
  void c()
  {
    if ((!this.u) && (this.ag != null) && (this.ag.isPlaying()) && (!this.v))
    {
      a.l.d.b("video_paused", this.M);
      this.ag.pause();
    }
  }
  
  void c(boolean paramBoolean)
  {
    if ((this.ag != null) && (this.S != null))
    {
      if (paramBoolean)
      {
        this.ag.setVolume(0.0F, 0.0F);
        this.S.setImageBitmap(this.R.a);
        this.V = this.R.a;
      }
    }
    else {
      return;
    }
    this.ag.setVolume(this.aD, this.aD);
    this.S.setImageBitmap(this.Q.a);
    this.V = this.Q.a;
  }
  
  public boolean canceled()
  {
    return this.I;
  }
  
  public void destroy()
  {
    l.c.b("[ADC] Native Ad Destroy called.");
    if (this.ah != null) {
      this.ah.release();
    }
    if (this.ag != null) {
      this.ag.release();
    }
    this.ag = null;
    this.M.j.A.i = false;
    a.aq.remove(this);
  }
  
  public ImageView getAdvertiserImage()
  {
    if (this.W == null)
    {
      this.W = new ADCImage(this.ao, true, false);
      this.W.a(this.aE / 2.0F, true);
    }
    if ((this.aa == null) && (a.b() != null))
    {
      this.aa = new ImageView(a.b());
      this.aa.setImageBitmap(this.W.a);
    }
    return this.aa;
  }
  
  public String getAdvertiserName()
  {
    return this.ai;
  }
  
  public String getDescription()
  {
    return this.aj;
  }
  
  public String getEngagementCommand()
  {
    if (this.ae == null) {
      return "";
    }
    return this.ae;
  }
  
  public String getEngagementLabel()
  {
    if (this.ad == null) {
      return "";
    }
    return this.ad;
  }
  
  public String getEngagementType()
  {
    if (this.af == null) {
      return "";
    }
    return this.af;
  }
  
  public int getNativeAdHeight()
  {
    if ((!this.o) && (this.ab)) {
      return this.l + this.l / 5;
    }
    return this.l;
  }
  
  public int getNativeAdWidth()
  {
    return this.k;
  }
  
  public String getTitle()
  {
    return this.ak;
  }
  
  public boolean iapEnabled()
  {
    return this.J;
  }
  
  public AdColonyIAPEngagement iapEngagementType()
  {
    if ((this.M != null) && (this.M.A == AdColonyIAPEngagement.END_CARD)) {
      return AdColonyIAPEngagement.END_CARD;
    }
    return this.ar;
  }
  
  public String iapProductID()
  {
    return this.ap;
  }
  
  public boolean isEngagementEnabled()
  {
    return this.ab;
  }
  
  public boolean isReady()
  {
    return ((this.M.a(true)) || (!this.aH)) && (this.s) && (!this.F);
  }
  
  public void notifyAddedToListView()
  {
    if (!this.m)
    {
      this.m = true;
      return;
    }
    ((a)this.U).onSurfaceTextureAvailable(this.h, this.i, this.j);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.aK.close();
      this.T.setVisibility(0);
      this.S.setVisibility(8);
      this.M.k = "native";
      this.M.l = "native";
      this.M.s = true;
      this.u = true;
      if (this.ag != null) {
        this.ag.release();
      }
      this.ag = null;
      this.M.r = 0;
      paramMediaPlayer = new ADCData.g();
      paramMediaPlayer.b("ad_slot", a.l.e.j);
      paramMediaPlayer.b("replay", false);
      a.l.d.a("native_complete", paramMediaPlayer, this.M);
      this.M.j.r = false;
      if (this.N != null) {
        this.N.onAdColonyNativeAdFinished(false, this);
      }
      this.C = true;
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;) {}
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.g == null) {}
    label262:
    label517:
    for (;;)
    {
      return;
      Rect localRect = new Rect();
      if (!this.g.hasFocus()) {
        this.g.requestFocus();
      }
      if ((!this.u) && (this.ag != null)) {
        this.aw = this.ag.getCurrentPosition();
      }
      if (this.aw != 0) {
        this.M.r = this.aw;
      }
      getLocalVisibleRect(localRect);
      int i1;
      if ((localRect.bottom - localRect.top > getNativeAdHeight() / 2) && (localRect.right - localRect.left > getNativeAdWidth() / 2))
      {
        i1 = 1;
        if (((i1 != 0) || (this.n)) && ((!this.n) || ((i1 != 0) && ((localRect.bottom - localRect.top >= getNativeAdHeight()) || (localRect.top == 0))))) {
          break label262;
        }
        if ((!this.u) && (this.ag != null) && (this.ag.isPlaying()) && (!this.v))
        {
          l.c.b("[ADC] Scroll Pause");
          a.l.d.b("video_paused", this.M);
          this.ag.pause();
          this.T.setVisibility(0);
        }
      }
      for (;;)
      {
        if ((this.A) || (this.u)) {
          break label517;
        }
        invalidate();
        return;
        i1 = 0;
        break;
        if ((!this.u) && (this.ag != null) && (this.ag.isPlaying()))
        {
          if (!this.z)
          {
            paramCanvas.drawARGB(255, 0, 0, 0);
          }
          else
          {
            this.M.k = "native";
            this.M.l = "native";
            a.l.a(this.ag.getCurrentPosition() / this.ag.getDuration(), this.M);
            if (!this.H)
            {
              this.H = true;
              a.l.a("native_start", "{\"ad_slot\":" + (a.l.e.j + 1) + ", \"replay\":false}", this.M);
              this.M.j.r = true;
              this.M.j.q = true;
              a.h();
              if (this.M.i.j == null) {
                this.M.i.j = new ADCData.c();
              }
              this.M.i.j.a(this.M.j.a);
            }
          }
        }
        else if (!this.T.a) {
          paramCanvas.drawARGB(255, 0, 0, 0);
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.T.setVisibility(0);
    this.S.setVisibility(8);
    this.u = true;
    this.z = true;
    this.ag = null;
    this.M.r = 0;
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    l.c.b("[ADC] Native Ad onPrepared called.");
    this.z = true;
    if ((this.V == null) || (this.Q.a == null))
    {
      this.T.setVisibility(0);
      this.S.setVisibility(8);
      this.u = true;
      this.ag = null;
      this.M.r = 0;
      return;
    }
    if ((!this.r) && (this.V.equals(this.Q.a)))
    {
      c(true);
      return;
    }
    setVolume(this.aD);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 1) && (a.E) && (q.c()))
    {
      if (this.K) {
        break label282;
      }
      a.T = this.M;
      a.l.a.a(this.e, this.M.j);
      ADCVideo.a();
      this.M.u = this.C;
      this.M.t = true;
      this.M.k = "native";
      this.M.l = "fullscreen";
      a.E = false;
      a.l.d.b("video_expanded", this.M);
      if (this.N != null) {
        this.N.onAdColonyNativeAdStarted(true, this);
      }
      if (!a.m) {
        break label244;
      }
      l.a.b("Launching AdColonyOverlay");
      if (a.b() != null) {
        a.b().startActivity(new Intent(a.b(), AdColonyOverlay.class));
      }
      if (this.u)
      {
        this.M.f = -1;
        paramMotionEvent = this.M.i.r;
        paramMotionEvent.d += 1;
        this.M.j.r = true;
      }
      this.u = true;
      this.C = true;
    }
    for (;;)
    {
      return true;
      label244:
      l.a.b("Launching AdColonyFullscreen");
      if (a.b() == null) {
        break;
      }
      a.b().startActivity(new Intent(a.b(), AdColonyFullscreen.class));
      break;
      label282:
      paramMotionEvent = new ADCData.g();
      paramMotionEvent.b("click_type", "video_click");
      a.l.d.a("click", paramMotionEvent, this.M);
      try
      {
        paramMotionEvent = new Intent("android.intent.action.VIEW", Uri.parse(this.L));
        if (a.b() == null) {
          continue;
        }
        a.b().startActivity(paramMotionEvent);
      }
      catch (Exception paramMotionEvent) {}
      if (a.b() != null) {
        Toast.makeText(a.b(), "Unable to open store.", 0).show();
      }
    }
  }
  
  public void pause()
  {
    l.c.b("[ADC] Native Ad Pause called.");
    if ((this.ag != null) && (!this.u) && (this.ag.isPlaying()) && (Build.VERSION.SDK_INT >= 14))
    {
      a.l.d.b("video_paused", this.M);
      this.v = true;
      this.ag.pause();
      this.T.setVisibility(0);
      this.S.setVisibility(4);
    }
  }
  
  public void prepareForListView()
  {
    this.n = true;
  }
  
  public void resume()
  {
    l.c.b("[ADC] Native Ad Resume called.");
    if ((this.ag != null) && (this.v) && (!this.u) && (Build.VERSION.SDK_INT >= 14))
    {
      a.l.d.b("video_resumed", this.M);
      this.v = false;
      this.ag.seekTo(this.M.r);
      this.ag.start();
      this.T.setVisibility(4);
      this.S.setVisibility(0);
    }
  }
  
  public void setMuted(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void setOverlayButtonColor(int paramInt)
  {
    if (this.ab) {
      this.ac.setBackgroundColor(paramInt);
    }
    this.ax = paramInt;
  }
  
  public void setOverlayButtonTextColor(int paramInt)
  {
    if (this.ab) {
      this.ac.setTextColor(paramInt);
    }
    this.ay = paramInt;
  }
  
  public void setOverlayButtonTypeface(Typeface paramTypeface, int paramInt)
  {
    if (this.ab) {
      this.ac.setTypeface(paramTypeface, paramInt);
    }
  }
  
  public void setVolume(float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public AdColonyNativeAdView withListener(AdColonyNativeAdListener paramAdColonyNativeAdListener)
  {
    this.N = paramAdColonyNativeAdListener;
    this.M.D = paramAdColonyNativeAdListener;
    return this;
  }
  
  public AdColonyNativeAdView withMutedListener(AdColonyNativeAdMutedListener paramAdColonyNativeAdMutedListener)
  {
    this.O = paramAdColonyNativeAdMutedListener;
    return this;
  }
  
  class a
    extends TextureView
    implements TextureView.SurfaceTextureListener
  {
    boolean a = false;
    boolean b = false;
    
    a(Context paramContext)
    {
      this(paramContext, false);
    }
    
    a(Context paramContext, boolean paramBoolean)
    {
      super();
      setSurfaceTextureListener(this);
      setWillNotDraw(false);
      setBackgroundColor(-16777216);
      this.a = paramBoolean;
    }
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      if (paramSurfaceTexture == null)
      {
        AdColonyNativeAdView.this.u = true;
        AdColonyNativeAdView.this.S.setVisibility(8);
      }
      for (;;)
      {
        return;
        AdColonyNativeAdView.this.T.setVisibility(0);
        AdColonyNativeAdView.this.h = paramSurfaceTexture;
        if ((!AdColonyNativeAdView.this.u) && (!this.a))
        {
          AdColonyNativeAdView.this.ah = new Surface(paramSurfaceTexture);
          if (AdColonyNativeAdView.this.ag != null) {
            AdColonyNativeAdView.this.ag.release();
          }
          AdColonyNativeAdView.this.i = paramInt1;
          AdColonyNativeAdView.this.j = paramInt2;
          AdColonyNativeAdView.this.ag = new MediaPlayer();
          try
          {
            AdColonyNativeAdView.this.aK = new FileInputStream(AdColonyNativeAdView.this.f);
            AdColonyNativeAdView.this.ag.setDataSource(AdColonyNativeAdView.this.aK.getFD());
            AdColonyNativeAdView.this.ag.setSurface(AdColonyNativeAdView.this.ah);
            AdColonyNativeAdView.this.ag.setOnCompletionListener(AdColonyNativeAdView.this);
            AdColonyNativeAdView.this.ag.setOnPreparedListener(AdColonyNativeAdView.this);
            AdColonyNativeAdView.this.ag.setOnErrorListener(AdColonyNativeAdView.this);
            AdColonyNativeAdView.this.ag.prepareAsync();
            l.c.b("[ADC] Native Ad Prepare called.");
            this.b = true;
            paramSurfaceTexture = new Handler();
            Runnable local1 = new Runnable()
            {
              public void run()
              {
                if ((!AdColonyNativeAdView.this.z) && (!AdColonyNativeAdView.this.A))
                {
                  AdColonyNativeAdView.a.this.b = false;
                  AdColonyNativeAdView.this.u = true;
                  AdColonyNativeAdView.this.S.setVisibility(8);
                }
              }
            };
            if (!this.b)
            {
              paramSurfaceTexture.postDelayed(local1, 1800L);
              return;
            }
          }
          catch (Exception paramSurfaceTexture)
          {
            AdColonyNativeAdView.this.u = true;
            AdColonyNativeAdView.this.S.setVisibility(8);
          }
        }
      }
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      l.c.b("[ADC] Native surface destroyed");
      AdColonyNativeAdView.this.z = false;
      AdColonyNativeAdView.this.S.setVisibility(4);
      AdColonyNativeAdView.this.T.setVisibility(0);
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      l.c.b("[ADC] onSurfaceTextureSizeChanged");
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((i != 1) || (!a.E) || (!q.c()) || ((f1 > AdColonyNativeAdView.this.au - AdColonyNativeAdView.this.Q.f + 8) && (f2 < AdColonyNativeAdView.this.Q.g + 8) && (!AdColonyNativeAdView.this.u) && (AdColonyNativeAdView.this.ag != null) && (AdColonyNativeAdView.this.ag.isPlaying()))) {}
      label470:
      do
      {
        for (;;)
        {
          return true;
          a.T = AdColonyNativeAdView.this.M;
          a.l.a.a(AdColonyNativeAdView.this.e, AdColonyNativeAdView.this.M.j);
          ADCVideo.a();
          if (!AdColonyNativeAdView.this.K)
          {
            AdColonyNativeAdView.this.M.k = "native";
            AdColonyNativeAdView.this.M.l = "fullscreen";
            AdColonyNativeAdView.this.M.t = true;
            AdColonyNativeAdView.this.M.u = AdColonyNativeAdView.this.C;
            if (((AdColonyNativeAdView.this.z) || (AdColonyNativeAdView.this.u)) && (q.c()))
            {
              if (AdColonyNativeAdView.this.N != null) {
                AdColonyNativeAdView.this.N.onAdColonyNativeAdStarted(true, AdColonyNativeAdView.this);
              }
              if ((AdColonyNativeAdView.this.ag != null) && (AdColonyNativeAdView.this.ag.isPlaying()))
              {
                ADCVideo.c = AdColonyNativeAdView.this.ag.getCurrentPosition();
                AdColonyNativeAdView.this.M.q = AdColonyNativeAdView.this.M.p;
                AdColonyNativeAdView.this.ag.pause();
                a.E = false;
                a.l.d.b("video_expanded", AdColonyNativeAdView.this.M);
                if (!a.m) {
                  break label470;
                }
                l.a.b("Launching AdColonyOverlay");
                if (a.b() != null) {
                  a.b().startActivity(new Intent(a.b(), AdColonyOverlay.class));
                }
              }
              for (;;)
              {
                if (AdColonyNativeAdView.this.u)
                {
                  paramMotionEvent = AdColonyNativeAdView.this.M.i.r;
                  paramMotionEvent.d += 1;
                }
                AdColonyNativeAdView.this.u = true;
                AdColonyNativeAdView.this.C = true;
                return true;
                AdColonyNativeAdView.this.M.q = 0.0D;
                ADCVideo.c = 0;
                break;
                l.a.b("Launching AdColonyFullscreen");
                if (a.b() != null) {
                  a.b().startActivity(new Intent(a.b(), AdColonyFullscreen.class));
                }
              }
            }
          }
          else
          {
            paramMotionEvent = new ADCData.g();
            paramMotionEvent.b("click_type", "video_click");
            a.l.d.a("click", paramMotionEvent, AdColonyNativeAdView.this.M);
            try
            {
              paramMotionEvent = new Intent("android.intent.action.VIEW", Uri.parse(AdColonyNativeAdView.this.L));
              if (a.b() != null)
              {
                a.b().startActivity(paramMotionEvent);
                return true;
              }
            }
            catch (Exception paramMotionEvent) {}
          }
        }
      } while (a.b() == null);
      Toast.makeText(a.b(), "Unable to open store.", 0).show();
      return true;
    }
  }
  
  class b
    extends View
  {
    boolean a;
    
    public b(Context paramContext)
    {
      super();
      setBackgroundColor(-16777216);
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      AdColonyNativeAdView.this.g = ((ViewGroup)getParent().getParent());
      Rect localRect = new Rect();
      if ((AdColonyNativeAdView.this.ag != null) && (!AdColonyNativeAdView.this.ag.isPlaying()) && (AdColonyNativeAdView.this.n)) {
        this.a = false;
      }
      if ((getLocalVisibleRect(localRect)) && (Build.VERSION.SDK_INT >= 14) && (AdColonyNativeAdView.this.z)) {
        if (((!AdColonyNativeAdView.this.n) || ((AdColonyNativeAdView.this.n) && ((localRect.top == 0) || (localRect.bottom - localRect.top > AdColonyNativeAdView.this.getNativeAdHeight())))) && (localRect.bottom - localRect.top > AdColonyNativeAdView.this.getNativeAdHeight() / 2) && (localRect.right - localRect.left > AdColonyNativeAdView.this.getNativeAdWidth() / 2))
        {
          if (((this.a) || (AdColonyNativeAdView.this.u) || (AdColonyNativeAdView.this.ag == null) || (AdColonyNativeAdView.this.ag.isPlaying()) || (AdColonyNativeAdView.this.A) || (AdColonyNativeAdView.this.M.a(true)) || (!AdColonyNativeAdView.this.t)) || (!AdColonyNativeAdView.this.t))
          {
            l.c.b("[ADC] Native Ad Starting");
            AdColonyNativeAdView.this.b();
            AdColonyNativeAdView.this.t = true;
            AdColonyNativeAdView.this.M.k = "native";
            AdColonyNativeAdView.this.M.l = "native";
          }
        }
        else
        {
          this.a = true;
          label316:
          if ((!AdColonyNativeAdView.this.u) && (!q.c()) && (AdColonyNativeAdView.this.ag != null) && (!AdColonyNativeAdView.this.ag.isPlaying()))
          {
            setVisibility(0);
            AdColonyNativeAdView.this.S.setVisibility(8);
            AdColonyNativeAdView.this.u = true;
          }
          if ((AdColonyNativeAdView.this.u) || (AdColonyNativeAdView.this.ag == null) || (!AdColonyNativeAdView.this.ag.isPlaying())) {
            break label678;
          }
          setVisibility(4);
          AdColonyNativeAdView.this.S.setVisibility(0);
        }
      }
      for (;;)
      {
        if ((!AdColonyNativeAdView.this.A) && (!AdColonyNativeAdView.this.u)) {
          invalidate();
        }
        return;
        if ((!AdColonyNativeAdView.this.v) && (AdColonyNativeAdView.this.ag != null) && (q.c()) && (!AdColonyNativeAdView.this.ag.isPlaying()) && (!a.B))
        {
          l.c.b("[ADC] Native Ad Resuming");
          a.l.d.b("video_resumed", AdColonyNativeAdView.this.M);
          if (!AdColonyNativeAdView.this.r) {
            AdColonyNativeAdView.this.c(true);
          }
          AdColonyNativeAdView.this.setVolume(AdColonyNativeAdView.this.aD);
          AdColonyNativeAdView.this.ag.seekTo(AdColonyNativeAdView.this.M.r);
          AdColonyNativeAdView.this.ag.start();
          break;
        }
        if ((AdColonyNativeAdView.this.u) || (AdColonyNativeAdView.this.t) || ((a.l.a(AdColonyNativeAdView.this.M.h, true, false)) && (AdColonyNativeAdView.this.aH))) {
          break;
        }
        AdColonyNativeAdView.this.u = true;
        setVisibility(0);
        AdColonyNativeAdView.this.S.setVisibility(8);
        break;
        this.a = false;
        break label316;
        label678:
        if ((AdColonyNativeAdView.this.u) || (AdColonyNativeAdView.this.v))
        {
          paramCanvas.drawARGB(255, 0, 0, 0);
          AdColonyNativeAdView.this.S.setVisibility(8);
          AdColonyNativeAdView.this.P.a(paramCanvas, (AdColonyNativeAdView.this.au - AdColonyNativeAdView.this.P.f) / 2, (AdColonyNativeAdView.this.av - AdColonyNativeAdView.this.P.g) / 2);
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyNativeAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */