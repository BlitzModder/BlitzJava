package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;

public class z
  extends l<Bitmap>
{
  private static final Object f = new Object();
  private final n.b<Bitmap> a;
  private final Bitmap.Config b;
  private final int c;
  private final int d;
  private ImageView.ScaleType e;
  
  @Deprecated
  public z(String paramString, n.b<Bitmap> paramb, int paramInt1, int paramInt2, Bitmap.Config paramConfig, n.a parama)
  {
    this(paramString, paramb, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE, paramConfig, parama);
  }
  
  public z(String paramString, n.b<Bitmap> paramb, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, n.a parama)
  {
    super(0, paramString, parama);
    a(new d(1000, 2, 2.0F));
    this.a = paramb;
    this.b = paramConfig;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramScaleType;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f1 = 1.0F; f1 * 2.0F <= d1; f1 *= 2.0F) {}
    return (int)f1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = paramInt3;
    }
    double d1;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (paramScaleType != ImageView.ScaleType.FIT_XY) {
              break;
            }
            i = paramInt1;
          } while (paramInt1 != 0);
          return paramInt3;
          if (paramInt1 == 0) {
            return (int)(paramInt2 / paramInt4 * paramInt3);
          }
          i = paramInt1;
        } while (paramInt2 == 0);
        d1 = paramInt4 / paramInt3;
        if (paramScaleType != ImageView.ScaleType.CENTER_CROP) {
          break;
        }
        i = paramInt1;
      } while (paramInt1 * d1 >= paramInt2);
      return (int)(paramInt2 / d1);
      i = paramInt1;
    } while (paramInt1 * d1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }
  
  private n<Bitmap> b(i parami)
  {
    Object localObject1 = parami.b;
    Object localObject2 = new BitmapFactory.Options();
    if ((this.c == 0) && (this.d == 0))
    {
      ((BitmapFactory.Options)localObject2).inPreferredConfig = this.b;
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
    }
    while (localObject1 == null)
    {
      return n.a(new k(parami));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      int i = ((BitmapFactory.Options)localObject2).outWidth;
      int j = ((BitmapFactory.Options)localObject2).outHeight;
      int k = a(this.c, this.d, i, j, this.e);
      int m = a(this.d, this.c, j, i, this.e);
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject2).inSampleSize = a(i, j, k, m);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if ((localObject1 != null) && ((((Bitmap)localObject1).getWidth() > k) || (((Bitmap)localObject1).getHeight() > m)))
      {
        localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, k, m, true);
        ((Bitmap)localObject1).recycle();
        localObject1 = localObject2;
      }
    }
    return n.a(localObject1, w.a(parami));
  }
  
  protected n<Bitmap> a(i parami)
  {
    synchronized (f)
    {
      try
      {
        n localn = b(parami);
        return localn;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        t.c("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(parami.b.length), d() });
        parami = n.a(new k(localOutOfMemoryError));
        return parami;
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
  
  public l.a s()
  {
    return l.a.a;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */