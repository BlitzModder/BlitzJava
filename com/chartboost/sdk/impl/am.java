package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class am
  extends LinearLayout
{
  private Paint a;
  private float b = 1.0F;
  private int c = 0;
  
  public am(Context paramContext)
  {
    super(paramContext);
    int i = Math.round(paramContext.getResources().getDisplayMetrics().density * 5.0F);
    setPadding(i, i, i, i);
    setBaselineAligned(false);
    this.a = new Paint();
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public void a(int paramInt)
  {
    this.a.setColor(paramInt);
    invalidate();
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f = getContext().getResources().getDisplayMetrics().density;
    if ((this.c & 0x1) > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), this.b * f, this.a);
    }
    if ((this.c & 0x2) > 0) {
      paramCanvas.drawRect(paramCanvas.getWidth() - this.b * f, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.a);
    }
    if ((this.c & 0x4) > 0) {
      paramCanvas.drawRect(0.0F, paramCanvas.getHeight() - this.b * f, paramCanvas.getWidth(), paramCanvas.getHeight(), this.a);
    }
    if ((this.c & 0x8) > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, this.b * f, paramCanvas.getHeight(), this.a);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */