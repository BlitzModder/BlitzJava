package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

public class AdColonyInterstitialAd
  extends AdColonyAd
{
  AdColonyNativeAdListener D;
  boolean E;
  
  public AdColonyInterstitialAd()
  {
    a.D = false;
    a.e();
    this.k = "interstitial";
    this.l = "fullscreen";
    this.E = false;
    this.m = aa.b();
  }
  
  public AdColonyInterstitialAd(String paramString)
  {
    this.k = "interstitial";
    this.l = "fullscreen";
    a.e();
    this.h = paramString;
    this.E = false;
    this.m = aa.b();
  }
  
  void a()
  {
    this.k = "interstitial";
    this.l = "fullscreen";
    if ((this.z != null) && (!this.w))
    {
      this.z.onAdColonyAdAttemptFinished(this);
      this.z = null;
    }
    while (this.D == null)
    {
      System.gc();
      if ((a.D) || (AdColonyBrowser.B)) {
        break label144;
      }
      int i = 0;
      while (i < a.an.size())
      {
        ((Bitmap)a.an.get(i)).recycle();
        i += 1;
      }
    }
    if (canceled()) {}
    for (this.y.I = true;; this.y.I = false)
    {
      this.D.onAdColonyNativeAdFinished(true, this.y);
      break;
    }
    a.an.clear();
    label144:
    this.w = true;
    a.U = null;
    a.E = true;
  }
  
  boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.h == null)
    {
      this.h = a.l.e();
      if (this.h == null) {
        return false;
      }
    }
    d locald = a.l;
    String str = this.h;
    if (!paramBoolean) {
      bool = true;
    }
    return locald.a(str, paramBoolean, bool);
  }
  
  boolean b()
  {
    return false;
  }
  
  public boolean isReady()
  {
    if (this.h == null)
    {
      this.h = a.l.e();
      if (this.h == null) {
        return false;
      }
    }
    if (AdColony.isZoneNative(this.h))
    {
      a.am = 12;
      return false;
    }
    return a.l.e(this.h);
  }
  
  public void show()
  {
    if (this.E)
    {
      l.d.b("Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
      return;
    }
    a.am = 0;
    this.k = "interstitial";
    this.l = "fullscreen";
    if (!isReady())
    {
      this.g = a.am;
      new j(a.l)
      {
        void a()
        {
          if (AdColonyInterstitialAd.this.h != null) {
            this.q.d.a(AdColonyInterstitialAd.this.h, AdColonyInterstitialAd.this);
          }
        }
      };
      this.f = 2;
      if (this.z != null) {
        this.z.onAdColonyAdAttemptFinished(this);
      }
      this.z = null;
      this.E = true;
      return;
    }
    this.g = a.am;
    this.E = true;
    if (a.E)
    {
      new j(a.l)
      {
        void a()
        {
          this.q.d.a(AdColonyInterstitialAd.this.h, AdColonyInterstitialAd.this);
        }
      };
      a.E = false;
      c();
      a.T = this;
      if (!a.l.b(this))
      {
        if (this.z != null) {
          this.z.onAdColonyAdAttemptFinished(this);
        }
        a.E = true;
        this.z = null;
        return;
      }
      if (this.z != null) {
        this.z.onAdColonyAdStarted(this);
      }
    }
    this.f = 4;
  }
  
  public AdColonyInterstitialAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.z = paramAdColonyAdListener;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */