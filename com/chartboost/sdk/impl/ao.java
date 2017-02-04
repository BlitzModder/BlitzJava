package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.widget.LinearLayout;
import com.chartboost.sdk.Libraries.e.a;

public abstract class ao
  extends LinearLayout
{
  private Rect a = new Rect();
  private Paint b = null;
  private Paint c = null;
  
  public ao(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setStyle(Paint.Style.FILL);
      this.c.setColor(-1);
    }
    paramCanvas.drawRect(paramRect, this.c);
  }
  
  private void b(Canvas paramCanvas, Rect paramRect)
  {
    if (this.b == null)
    {
      this.b = new Paint();
      this.b.setStyle(Paint.Style.FILL);
      this.b.setAntiAlias(true);
    }
    this.b.setColor(-2631721);
    paramCanvas.drawRect(paramRect.left, paramRect.bottom - 1, paramRect.right, paramRect.bottom, this.b);
  }
  
  public abstract int a();
  
  public abstract void a(e.a parama, int paramInt);
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    a(paramCanvas, this.a);
    b(paramCanvas, this.a);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */