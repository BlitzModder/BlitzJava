package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.g;
import java.util.Map;

public abstract class al
  extends RelativeLayout
{
  private static final String b = al.class.getSimpleName();
  protected ah a;
  private am c;
  private a d;
  
  public al(Context paramContext, ah paramah)
  {
    super(paramContext);
    this.a = paramah;
    this.d = a.b;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = getContext();
    setGravity(17);
    this.c = new am(paramContext);
    this.c.a(-1);
    this.c.setBackgroundColor(-855638017);
    addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    addView(a(), new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void a(final boolean paramBoolean, long paramLong)
  {
    this.a.A = paramBoolean;
    if (((paramBoolean) && (getVisibility() == 0)) || ((!paramBoolean) && (getVisibility() == 8))) {
      return;
    }
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (!paramBoolean)
        {
          al.this.setVisibility(8);
          al.this.clearAnimation();
        }
        al.this.a.i.remove(Integer.valueOf(hashCode()));
      }
    };
    if (paramBoolean) {
      setVisibility(0);
    }
    float f1 = CBUtility.a(b(), getContext());
    Object localObject;
    switch (2.a[this.d.ordinal()])
    {
    default: 
      localObject = null;
      ((Animation)localObject).setDuration(paramLong);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      ((Animation)localObject).setFillAfter(paramBoolean);
      startAnimation((Animation)localObject);
      this.a.i.put(Integer.valueOf(hashCode()), local1);
      g.a.postDelayed(local1, paramLong);
      return;
      if (paramBoolean)
      {
        f2 = -f1;
        label177:
        if (!paramBoolean) {
          break label208;
        }
      }
      label208:
      for (f1 = 0.0F;; f1 = -f1)
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, f2, f1);
        break;
        f2 = 0.0F;
        break label177;
      }
      if (paramBoolean) {}
      for (float f2 = f1;; f2 = 0.0F)
      {
        if (paramBoolean) {
          f1 = 0.0F;
        }
        localObject = new TranslateAnimation(0.0F, 0.0F, f2, f1);
        break;
      }
      if (paramBoolean)
      {
        f2 = -f1;
        label264:
        if (!paramBoolean) {
          break label295;
        }
      }
      label295:
      for (f1 = 0.0F;; f1 = -f1)
      {
        localObject = new TranslateAnimation(f2, f1, 0.0F, 0.0F);
        break;
        f2 = 0.0F;
        break label264;
      }
      if (paramBoolean) {}
      for (f2 = f1;; f2 = 0.0F)
      {
        if (paramBoolean) {
          f1 = 0.0F;
        }
        localObject = new TranslateAnimation(f2, f1, 0.0F, 0.0F);
        break;
      }
    }
  }
  
  protected abstract View a();
  
  public void a(a parama)
  {
    if (parama == null)
    {
      CBLogging.b(b, "Side object cannot be null");
      return;
    }
    this.d = parama;
    parama = null;
    setClickable(false);
    int i = b();
    switch (2.a[this.d.ordinal()])
    {
    }
    for (;;)
    {
      setLayoutParams(parama);
      return;
      parama = new RelativeLayout.LayoutParams(-1, CBUtility.a(i, getContext()));
      parama.addRule(10);
      this.c.b(1);
      continue;
      parama = new RelativeLayout.LayoutParams(-1, CBUtility.a(i, getContext()));
      parama.addRule(12);
      this.c.b(4);
      continue;
      parama = new RelativeLayout.LayoutParams(CBUtility.a(i, getContext()), -1);
      parama.addRule(9);
      this.c.b(8);
      continue;
      parama = new RelativeLayout.LayoutParams(CBUtility.a(i, getContext()), -1);
      parama.addRule(11);
      this.c.b(2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 500L);
  }
  
  protected abstract int b();
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */