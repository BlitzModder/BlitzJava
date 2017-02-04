package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.j;

public class bi
  extends ImageView
{
  protected TextView a = null;
  private j b = null;
  
  public bi(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.layout(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
      this.a.setEnabled(isEnabled());
      this.a.setSelected(isSelected());
      if (!isFocused()) {
        break label81;
      }
      this.a.requestFocus();
    }
    for (;;)
    {
      this.a.setPressed(isPressed());
      this.a.draw(paramCanvas);
      return;
      label81:
      this.a.clearFocus();
    }
  }
  
  public void a(j paramj)
  {
    if (this.b == paramj) {
      return;
    }
    this.b = paramj;
    setImageDrawable(new BitmapDrawable(paramj.f()));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.b = null;
    setImageDrawable(new BitmapDrawable(paramBitmap));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */