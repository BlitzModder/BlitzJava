package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

public final class AdColonyV4VCAd
  extends AdColonyAd
{
  boolean D = false;
  boolean E = false;
  boolean F;
  
  public AdColonyV4VCAd()
  {
    a.D = false;
    a.e();
    this.k = "v4vc";
    this.F = false;
    this.l = "fullscreen";
    this.m = aa.b();
  }
  
  public AdColonyV4VCAd(String paramString)
  {
    a.e();
    this.h = paramString;
    this.k = "v4vc";
    this.F = false;
    this.l = "fullscreen";
    this.m = aa.b();
  }
  
  void a()
  {
    if ((this.f == 4) && (this.E)) {
      a("Result");
    }
    if ((this.z != null) && (!this.w))
    {
      this.z.onAdColonyAdAttemptFinished(this);
      this.z = null;
    }
    if (((!a.D) && (!AdColonyBrowser.B)) || (this.x))
    {
      int i = 0;
      while (i < a.an.size())
      {
        ((Bitmap)a.an.get(i)).recycle();
        i += 1;
      }
      a.an.clear();
    }
    a.U = null;
    this.w = true;
    if ((!this.E) || (this.x)) {
      a.E = true;
    }
    System.gc();
  }
  
  void a(String paramString)
  {
    String str1 = getRewardName();
    String str2 = "" + getRewardAmount();
    str1 = str2 + " " + str1;
    if (paramString.equals("Confirmation"))
    {
      a.S = new ab(str1, this);
      return;
    }
    a.S = new ac(str1, this);
  }
  
  boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  boolean b()
  {
    return true;
  }
  
  void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (a.l.b(this))
      {
        a.o = false;
        if (this.z != null) {
          this.z.onAdColonyAdStarted(this);
        }
        this.f = 4;
      }
    }
    for (;;)
    {
      if (this.f != 4)
      {
        a.E = true;
        if (this.z != null) {
          this.z.onAdColonyAdAttemptFinished(this);
        }
        this.z = null;
      }
      return;
      this.f = 3;
      continue;
      this.f = 1;
    }
  }
  
  public int getRemainingViewsUntilReward()
  {
    if (!c()) {
      return 0;
    }
    return this.i.n.f - this.i.s;
  }
  
  public int getRewardAmount()
  {
    if (!c()) {
      return 0;
    }
    return this.i.n.c;
  }
  
  public String getRewardName()
  {
    if (!c()) {
      return "";
    }
    return this.i.n.d;
  }
  
  public int getViewsPerReward()
  {
    if (!c()) {
      return 0;
    }
    return this.i.n.f;
  }
  
  public boolean isReady()
  {
    if (this.h == null)
    {
      this.h = a.l.f();
      if (this.h == null) {
        return false;
      }
    }
    return a.l.f(this.h);
  }
  
  public void show()
  {
    if (this.F) {
      l.d.b("Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
    }
    do
    {
      return;
      a.am = 0;
      if (!isReady())
      {
        this.g = a.am;
        new j(a.l)
        {
          void a()
          {
            if (AdColonyV4VCAd.this.h != null) {
              this.q.d.a(AdColonyV4VCAd.this.h, AdColonyV4VCAd.this);
            }
          }
        };
        this.f = 2;
        if (this.z != null) {
          this.z.onAdColonyAdAttemptFinished(this);
        }
        this.z = null;
        this.F = true;
        return;
      }
      this.g = a.am;
    } while (!a.E);
    new j(a.l)
    {
      void a()
      {
        this.q.d.a(AdColonyV4VCAd.this.h, AdColonyV4VCAd.this);
      }
    };
    a.E = false;
    c();
    a.T = this;
    a.l.a(this);
    if (this.D)
    {
      a("Confirmation");
      return;
    }
    this.F = true;
    c(true);
  }
  
  public AdColonyV4VCAd withConfirmationDialog()
  {
    return withConfirmationDialog(true);
  }
  
  public AdColonyV4VCAd withConfirmationDialog(boolean paramBoolean)
  {
    this.D = paramBoolean;
    return this;
  }
  
  public AdColonyV4VCAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.z = paramAdColonyAdListener;
    return this;
  }
  
  public AdColonyV4VCAd withResultsDialog()
  {
    return withResultsDialog(true);
  }
  
  public AdColonyV4VCAd withResultsDialog(boolean paramBoolean)
  {
    this.E = paramBoolean;
    a.D = this.E;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyV4VCAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */