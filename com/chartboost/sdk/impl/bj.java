package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.j;

public abstract class bj
  extends RelativeLayout
{
  private static Rect b = new Rect();
  private a a;
  protected boolean c = false;
  protected Button d = null;
  private boolean e = true;
  
  public bj(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    this.a = new a(getContext());
    this.a.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool = bj.a(paramAnonymousView, paramAnonymousMotionEvent);
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        for (;;)
        {
          return true;
          bj.a(bj.this).a(bool);
          return bool;
          bj.a(bj.this).a(bool);
          continue;
          if ((bj.this.getVisibility() == 0) && (bj.this.isEnabled()) && (bool)) {
            bj.this.a(paramAnonymousMotionEvent);
          }
          bj.a(bj.this).a(false);
          continue;
          bj.a(bj.this).a(false);
        }
      }
    });
    addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private static boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.getLocalVisibleRect(b);
    Rect localRect = b;
    localRect.left += paramView.getPaddingLeft();
    localRect = b;
    localRect.top += paramView.getPaddingTop();
    localRect = b;
    localRect.right -= paramView.getPaddingRight();
    localRect = b;
    localRect.bottom -= paramView.getPaddingBottom();
    return b.contains(Math.round(paramMotionEvent.getX()), Math.round(paramMotionEvent.getY()));
  }
  
  public TextView a()
  {
    if (this.d == null)
    {
      this.d = new Button(getContext());
      this.d.setGravity(17);
    }
    this.d.postInvalidate();
    return this.d;
  }
  
  protected abstract void a(MotionEvent paramMotionEvent);
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    this.a.setScaleType(paramScaleType);
  }
  
  public void a(j paramj)
  {
    this.a.a(paramj);
    a(null);
  }
  
  public void a(j paramj, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.a.a(paramj, paramLayoutParams);
    a(null);
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      a().setText(paramString);
      addView(a(), new RelativeLayout.LayoutParams(-1, -1));
      this.a.setVisibility(8);
      a(false);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          bj.this.a(null);
        }
      });
    }
    while (this.d == null) {
      return;
    }
    removeView(a());
    this.d = null;
    this.a.setVisibility(0);
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public class a
    extends bi
  {
    public a(Context paramContext)
    {
      super();
      bj.this.c = false;
    }
    
    public void a(j paramj, ViewGroup.LayoutParams paramLayoutParams)
    {
      a(paramj);
      paramLayoutParams.width = paramj.h();
      paramLayoutParams.height = paramj.i();
    }
    
    protected void a(boolean paramBoolean)
    {
      if ((bj.b(bj.this)) && (paramBoolean)) {
        if (!bj.this.c)
        {
          if (getDrawable() == null) {
            break label56;
          }
          getDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
      }
      label56:
      while (!bj.this.c) {
        for (;;)
        {
          invalidate();
          bj.this.c = true;
          return;
          if (getBackground() != null) {
            getBackground().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
        }
      }
      if (getDrawable() != null) {
        getDrawable().clearColorFilter();
      }
      for (;;)
      {
        invalidate();
        bj.this.c = false;
        return;
        if (getBackground() != null) {
          getBackground().clearColorFilter();
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */