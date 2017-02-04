package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.DisplayMetrics;

public class aj
  extends bm
{
  private Paint a;
  private Paint b;
  private Path c;
  private RectF d;
  private RectF e;
  private int f = 0;
  private float g;
  private float h;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.g = (4.5F * f1);
    this.a = new Paint();
    this.a.setColor(-1);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(f1 * 1.0F);
    this.a.setAntiAlias(true);
    this.b = new Paint();
    this.b.setColor(-855638017);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.c = new Path();
    this.e = new RectF();
    this.d = new RectF();
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
    if (getVisibility() != 8) {
      invalidate();
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  protected void a(Canvas paramCanvas)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.d.set(0.0F, 0.0F, getWidth(), getHeight());
    int i = Math.min(1, Math.round(f1 * 0.5F));
    this.d.inset(i, i);
    this.c.reset();
    this.c.addRoundRect(this.d, this.g, this.g, Path.Direction.CW);
    paramCanvas.save();
    paramCanvas.clipPath(this.c);
    paramCanvas.drawColor(this.f);
    this.e.set(this.d);
    this.e.right = ((this.e.right - this.e.left) * this.h + this.e.left);
    paramCanvas.drawRect(this.e, this.b);
    paramCanvas.restore();
    paramCanvas.drawRoundRect(this.d, this.g, this.g, this.a);
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.a.setColor(paramInt);
    invalidate();
  }
  
  public void c(int paramInt)
  {
    this.b.setColor(paramInt);
    invalidate();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */