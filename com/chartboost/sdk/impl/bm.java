package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.reflect.Method;

public abstract class bm
  extends View
{
  private Bitmap a = null;
  private Canvas b = null;
  
  public bm(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(this, new Object[] { Integer.valueOf(1), null });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private boolean b(Canvas paramCanvas)
  {
    try
    {
      boolean bool = ((Boolean)Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(paramCanvas, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramCanvas) {}
    return false;
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.a != null) && (!this.a.isRecycled())) {
      this.a.recycle();
    }
    this.a = null;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    boolean bool = b(paramCanvas);
    if (bool) {
      if ((this.a == null) || (this.a.getWidth() != paramCanvas.getWidth()) || (this.a.getHeight() != paramCanvas.getHeight())) {
        if ((this.a != null) && (!this.a.isRecycled())) {
          this.a.recycle();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.a = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.b = new Canvas(this.a);
        this.a.eraseColor(0);
        localCanvas2 = this.b;
        localCanvas1 = paramCanvas;
        a(localCanvas2);
        if ((bool) && (localCanvas1 != null)) {
          localCanvas1.drawBitmap(this.a, 0.0F, 0.0F, null);
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        return;
      }
      Canvas localCanvas1 = null;
      Canvas localCanvas2 = paramCanvas;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */