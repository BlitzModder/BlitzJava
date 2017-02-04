package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.c;
import com.chartboost.sdk.f;

public final class bg
{
  public static void a(b paramb, a parama, a parama1)
  {
    b(paramb, parama, parama1, true);
  }
  
  public static void a(boolean paramBoolean, View paramView)
  {
    if (c.H().booleanValue()) {}
    a(paramBoolean, paramView, 500L);
  }
  
  public static void a(boolean paramBoolean, View paramView, long paramLong)
  {
    float f2 = 1.0F;
    paramView.clearAnimation();
    if (paramBoolean) {
      paramView.setVisibility(0);
    }
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label65;
      }
    }
    for (;;)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(f1, f2);
      localAlphaAnimation.setDuration(paramLong);
      localAlphaAnimation.setFillBefore(true);
      paramView.startAnimation(localAlphaAnimation);
      return;
      f1 = 1.0F;
      break;
      label65:
      f2 = 0.0F;
    }
  }
  
  public static void b(b paramb, a parama, a parama1)
  {
    c(paramb, parama, parama1, false);
  }
  
  private static void b(final b paramb, final a parama, final a parama1, final boolean paramBoolean)
  {
    if (paramb == b.g) {
      if (parama1 != null) {
        parama1.a(parama);
      }
    }
    View localView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      if ((parama == null) || (parama.l == null))
      {
        CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of container");
        return;
      }
      localView = parama.l.f();
      if (localView == null)
      {
        f.a().d(parama);
        CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of view");
        return;
      }
      localViewTreeObserver = localView.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        bg.a(paramb, parama, parama1, paramBoolean);
      }
    });
  }
  
  private static void c(b paramb, final a parama, a parama1, boolean paramBoolean)
  {
    Object localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).addAnimation(new AlphaAnimation(1.0F, 1.0F));
    if ((parama == null) || (parama.l == null))
    {
      CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of container");
      if (parama1 != null) {
        parama1.a(parama);
      }
      return;
    }
    Object localObject2 = parama.l.f();
    if (localObject2 == null)
    {
      if (parama1 != null) {
        parama1.a(parama);
      }
      CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of view");
      return;
    }
    if ((parama.f == a.c.c) || (parama.f == a.c.b)) {
      localObject2 = parama.l;
    }
    for (;;)
    {
      float f1 = ((View)localObject2).getWidth();
      float f2 = ((View)localObject2).getHeight();
      float f3 = (1.0F - 0.4F) / 2.0F;
      if (parama.a == a.b.b) {}
      for (;;)
      {
        switch (3.a[paramb.ordinal()])
        {
        }
        for (;;)
        {
          if (paramb != b.g) {
            break label1196;
          }
          if (parama1 == null) {
            break;
          }
          parama1.a(parama);
          return;
          if (paramBoolean) {}
          for (localObject1 = new AlphaAnimation(0.0F, 1.0F);; localObject1 = new AlphaAnimation(1.0F, 0.0F))
          {
            ((Animation)localObject1).setDuration(500L);
            ((Animation)localObject1).setFillAfter(true);
            localObject3 = new AnimationSet(true);
            ((AnimationSet)localObject3).addAnimation((Animation)localObject1);
            localObject1 = localObject3;
            break;
          }
          if (paramBoolean)
          {
            localObject3 = new bl(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, false);
            label312:
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            if (!paramBoolean) {
              break label447;
            }
            localObject3 = new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F);
            label352:
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            if (!paramBoolean) {
              break label465;
            }
          }
          label447:
          label465:
          for (Object localObject3 = new TranslateAnimation(f1 * f3, 0.0F, -f2 * 0.4F, 0.0F);; localObject3 = new TranslateAnimation(0.0F, f1 * f3, 0.0F, f2))
          {
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            localObject3 = new bl(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, false);
            break label312;
            localObject3 = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
            break label352;
          }
          if (paramBoolean)
          {
            localObject3 = new bl(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, true);
            label512:
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            if (!paramBoolean) {
              break label647;
            }
            localObject3 = new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F);
            label552:
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            if (!paramBoolean) {
              break label665;
            }
          }
          label647:
          label665:
          for (localObject3 = new TranslateAnimation(-f1 * 0.4F, 0.0F, f2 * f3, 0.0F);; localObject3 = new TranslateAnimation(0.0F, f1, 0.0F, f2 * f3))
          {
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            localObject3 = new bl(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, true);
            break label512;
            localObject3 = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
            break label552;
          }
          if (paramBoolean)
          {
            f1 = f2;
            label694:
            if (!paramBoolean) {
              break label746;
            }
            f2 = 0.0F;
          }
          label746:
          for (;;)
          {
            localObject3 = new TranslateAnimation(0.0F, 0.0F, f1, f2);
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            f1 = 0.0F;
            break label694;
          }
          if (paramBoolean)
          {
            f1 = -f2;
            label758:
            if (!paramBoolean) {
              break label810;
            }
          }
          label810:
          for (f2 = 0.0F;; f2 = -f2)
          {
            localObject3 = new TranslateAnimation(0.0F, 0.0F, f1, f2);
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            f1 = 0.0F;
            break label758;
          }
          if (paramBoolean)
          {
            f2 = f1;
            label826:
            if (!paramBoolean) {
              break label878;
            }
            f1 = 0.0F;
          }
          label878:
          for (;;)
          {
            localObject3 = new TranslateAnimation(f2, f1, 0.0F, 0.0F);
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            f2 = 0.0F;
            break label826;
          }
          if (paramBoolean)
          {
            f2 = -f1;
            label890:
            if (!paramBoolean) {
              break label942;
            }
          }
          label942:
          for (f1 = 0.0F;; f1 = -f1)
          {
            localObject3 = new TranslateAnimation(f2, f1, 0.0F, 0.0F);
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            break;
            f2 = 0.0F;
            break label890;
          }
          if (paramBoolean)
          {
            localObject3 = new ScaleAnimation(0.6F, 1.1F, 0.6F, 1.1F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject3).setDuration(Math.round((float)500L * 0.6F));
            ((Animation)localObject3).setStartOffset(0L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            localObject3 = new ScaleAnimation(1.0F, 0.81818175F, 1.0F, 0.81818175F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject3).setDuration(Math.round((float)500L * 0.19999999F));
            ((Animation)localObject3).setStartOffset(Math.round((float)500L * 0.6F));
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
            localObject3 = new ScaleAnimation(1.0F, 1.1111112F, 1.0F, 1.1111112F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject3).setDuration(Math.round((float)500L * 0.099999964F));
            ((Animation)localObject3).setStartOffset(Math.round((float)500L * 0.8F));
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
          }
          else
          {
            localObject3 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject3).setDuration(500L);
            ((Animation)localObject3).setStartOffset(0L);
            ((Animation)localObject3).setFillAfter(true);
            ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
          }
        }
        label1196:
        if (parama1 != null) {
          CBUtility.e().postDelayed(new Runnable()
          {
            public void run()
            {
              this.a.a(parama);
            }
          }, 500L);
        }
        ((View)localObject2).startAnimation((Animation)localObject1);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
  }
  
  public static enum b
  {
    private b() {}
    
    public static b a(int paramInt)
    {
      if (paramInt == 0) {}
      while ((paramInt <= 0) || (paramInt > values().length)) {
        return null;
      }
      return values()[(paramInt - 1)];
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */