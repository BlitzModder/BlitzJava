package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.chartboost.sdk.Libraries.CBUtility;

public final class bp
  extends bm
{
  private static Handler a = ;
  private float b;
  private long c;
  private Paint d;
  private Paint e;
  private Path f;
  private Path g;
  private RectF h;
  private RectF i;
  private Runnable j = new Runnable()
  {
    public void run()
    {
      float f = bp.this.getContext().getResources().getDisplayMetrics().density;
      bp.a(bp.this, 60.0F * f * 0.016666668F);
      f = bp.this.getHeight() - f * 9.0F;
      if (bp.a(bp.this) > f) {
        bp.b(bp.this, f * 2.0F);
      }
      if (bp.this.getWindowVisibility() == 0) {
        bp.this.invalidate();
      }
    }
  };
  
  public bp(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.b = 0.0F;
    this.c = ((System.nanoTime() / 1000000.0D));
    this.d = new Paint();
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeWidth(f1 * 3.0F);
    this.d.setAntiAlias(true);
    this.e = new Paint();
    this.e.setColor(-1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setAntiAlias(true);
    this.f = new Path();
    this.g = new Path();
    this.i = new RectF();
    this.h = new RectF();
  }
  
  protected void a(Canvas paramCanvas)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.h.set(0.0F, 0.0F, getWidth(), getHeight());
    this.h.inset(1.5F * f1, 1.5F * f1);
    float f2 = getHeight() / 2.0F;
    paramCanvas.drawRoundRect(this.h, f2, f2, this.d);
    this.i.set(this.h);
    this.i.inset(3.0F * f1, f1 * 3.0F);
    f1 = this.i.height() / 2.0F;
    this.f.reset();
    this.f.addRoundRect(this.i, f1, f1, Path.Direction.CW);
    f2 = this.i.height();
    this.g.reset();
    this.g.moveTo(0.0F, f2);
    this.g.lineTo(f2, f2);
    this.g.lineTo(f2 * 2.0F, 0.0F);
    this.g.lineTo(f2, 0.0F);
    this.g.close();
    paramCanvas.save();
    int k = 1;
    try
    {
      paramCanvas.clipPath(this.f);
      if (k != 0) {
        for (f1 = -f2 + this.b; f1 < this.i.width() + f2; f1 += 2.0F * f2)
        {
          float f3 = this.i.left;
          paramCanvas.save();
          paramCanvas.translate(f3 + f1, this.i.top);
          paramCanvas.drawPath(this.g, this.e);
          paramCanvas.restore();
        }
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        k = 0;
      }
      paramCanvas.restore();
      long l = Math.max(0L, 16L - ((System.nanoTime() / 1000000.0D) - this.c));
      a.removeCallbacks(this.j);
      a.postDelayed(this.j, l);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a.removeCallbacks(this.j);
    a.post(this.j);
  }
  
  protected void onDetachedFromWindow()
  {
    a.removeCallbacks(this.j);
    super.onDetachedFromWindow();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    a.removeCallbacks(this.j);
    if (paramInt == 0) {
      a.post(this.j);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */