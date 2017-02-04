package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzmw
  extends ImageView
{
  private Uri zzaiJ;
  private int zzaiK;
  private int zzaiL;
  private zza zzaiM;
  private int zzaiN;
  private float zzaiO;
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.zzaiM != null) {
      paramCanvas.clipPath(this.zzaiM.zzl(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.zzaiL != 0) {
      paramCanvas.drawColor(this.zzaiL);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    switch (this.zzaiN)
    {
    default: 
      return;
    case 1: 
      paramInt1 = getMeasuredHeight();
      paramInt2 = (int)(paramInt1 * this.zzaiO);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = (int)(paramInt2 / this.zzaiO);
    }
  }
  
  public void zzbP(int paramInt)
  {
    this.zzaiK = paramInt;
  }
  
  public void zzm(Uri paramUri)
  {
    this.zzaiJ = paramUri;
  }
  
  public int zzpX()
  {
    return this.zzaiK;
  }
  
  public static abstract interface zza
  {
    public abstract Path zzl(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */