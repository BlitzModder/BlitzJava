package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.chartboost.sdk.Libraries.CBUtility;

public final class at
  extends bi
{
  private RectF b;
  private Paint c;
  private Paint d;
  private BitmapShader e;
  private float f = 0.0F;
  
  public at(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.b = new RectF();
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(Math.max(1.0F, f1 * 1.0F));
    this.c.setAntiAlias(true);
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = CBUtility.a(1.0F, getContext());
    Object localObject = getDrawable();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      if (this.e == null)
      {
        if (localObject != null)
        {
          this.e = new BitmapShader((Bitmap)localObject, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
          this.d = new Paint();
          this.d.setAntiAlias(true);
          this.d.setShader(this.e);
        }
      }
      else
      {
        float f2 = Math.max(getWidth() / ((Bitmap)localObject).getWidth(), getHeight() / ((Bitmap)localObject).getHeight());
        paramCanvas.save();
        paramCanvas.scale(f2, f2);
        this.b.set(0.0F, 0.0F, getWidth() / f2, getHeight() / f2);
        this.b.inset(f1 / (f2 * 2.0F), f1 / (f2 * 2.0F));
        paramCanvas.drawRoundRect(this.b, this.b.width() * this.f, this.b.height() * this.f, this.d);
        paramCanvas.restore();
      }
    }
    for (;;)
    {
      this.b.set(0.0F, 0.0F, getWidth(), getHeight());
      this.b.inset(f1 / 2.0F, f1 / 2.0F);
      paramCanvas.drawRoundRect(this.b, this.b.width() * this.f, this.b.height() * this.f, this.c);
      return;
      postInvalidate();
      return;
      super.onDraw(paramCanvas);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */