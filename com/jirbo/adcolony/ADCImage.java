package com.jirbo.adcolony;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;

public class ADCImage
{
  static int k;
  static int l;
  Bitmap a;
  Bitmap b;
  Paint c = new Paint();
  Rect d = new Rect();
  Rect e = new Rect();
  int f;
  int g;
  boolean h;
  int i;
  int j;
  boolean m;
  ArrayList<Bitmap> n = new ArrayList();
  
  ADCImage(String paramString)
  {
    this(paramString, 1.0D);
  }
  
  ADCImage(String paramString, double paramDouble)
  {
    this(paramString, paramDouble, false);
  }
  
  ADCImage(String paramString, double paramDouble, boolean paramBoolean)
  {
    this(paramString, paramDouble, paramBoolean, false);
  }
  
  ADCImage(String paramString, double paramDouble, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new FileInputStream(paramString);
        this.a = BitmapFactory.decodeStream((InputStream)localObject);
        ((InputStream)localObject).close();
        this.b = this.a;
        this.f = this.a.getWidth();
        this.g = this.a.getHeight();
        this.i = this.a.getWidth();
        this.j = this.a.getHeight();
        k = this.i;
        l = this.j;
        a(paramDouble);
        this.h = true;
        if (paramBoolean1)
        {
          this.a = convertToMutable(this.a);
          localObject = new int[this.a.getWidth() * this.a.getHeight()];
          this.a.getPixels((int[])localObject, 0, this.a.getWidth(), 0, 0, this.a.getWidth(), this.a.getHeight());
          i1 = 0;
          if (i1 < localObject.length)
          {
            if ((localObject[i1] < 255) && (localObject[i1] != 0)) {
              localObject[i1] = (localObject[i1] >> 1 & 0x7F7F7F | 0xFF000000);
            }
          }
          else
          {
            this.a.setPixels((int[])localObject, 0, this.a.getWidth(), 0, 0, this.a.getWidth(), this.a.getHeight());
            this.b = this.a;
          }
        }
        else
        {
          if (!paramBoolean2)
          {
            a.an.add(this.a);
            this.n.add(this.a);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.e("Failed to load image " + paramString);
        this.m = true;
        return;
      }
      i1 += 1;
    }
  }
  
  ADCImage(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, 1.0D);
    b(paramInt1, paramInt2);
  }
  
  ADCImage(String paramString, boolean paramBoolean)
  {
    this(paramString, 1.0D, paramBoolean);
  }
  
  ADCImage(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, 1.0D, paramBoolean2, paramBoolean1);
  }
  
  public static Bitmap convertToMutable(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    try
    {
      File localFile = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");
      localBitmap = paramBitmap;
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localBitmap = paramBitmap;
      int i1 = k;
      localBitmap = paramBitmap;
      int i2 = l;
      localBitmap = paramBitmap;
      Bitmap.Config localConfig = paramBitmap.getConfig();
      localBitmap = paramBitmap;
      FileChannel localFileChannel = localRandomAccessFile.getChannel();
      localBitmap = paramBitmap;
      MappedByteBuffer localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, paramBitmap.getRowBytes() * i2);
      localBitmap = paramBitmap;
      paramBitmap.copyPixelsToBuffer(localMappedByteBuffer);
      localBitmap = paramBitmap;
      paramBitmap = Bitmap.createBitmap(i1, i2, localConfig);
      localBitmap = paramBitmap;
      localMappedByteBuffer.position(0);
      localBitmap = paramBitmap;
      paramBitmap.copyPixelsFromBuffer(localMappedByteBuffer);
      localBitmap = paramBitmap;
      localFileChannel.close();
      localBitmap = paramBitmap;
      localRandomAccessFile.close();
      localBitmap = paramBitmap;
      localFile.delete();
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return localBitmap;
  }
  
  void a()
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      ((Bitmap)localIterator.next()).recycle();
    }
    this.n.clear();
  }
  
  void a(double paramDouble)
  {
    a(paramDouble, false);
  }
  
  void a(double paramDouble, boolean paramBoolean)
  {
    if (this.a == null) {}
    while (this.a.isRecycled()) {
      return;
    }
    if (paramDouble != 1.0D)
    {
      int i1 = (int)(this.b.getWidth() * paramDouble);
      int i2 = (int)(this.b.getHeight() * paramDouble);
      if ((i1 != this.f) || (i2 != this.g))
      {
        this.f = i1;
        this.g = i2;
        this.a = Bitmap.createScaledBitmap(this.b, this.f, this.g, true);
        if (!paramBoolean)
        {
          a.an.add(this.a);
          this.n.add(this.a);
        }
      }
      if (paramBoolean)
      {
        this.b.recycle();
        this.b = null;
      }
    }
    this.d.right = this.f;
    this.d.bottom = this.g;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    Bitmap localBitmap1 = Bitmap.createBitmap(this.b, 0, 0, this.i / 3, this.j);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.b, this.i * 2 / 3, 0, this.i / 3, this.j);
    Bitmap localBitmap3 = Bitmap.createScaledBitmap(Bitmap.createBitmap(this.b, this.i / 3, 0, this.i / 3, this.j), paramInt1, this.j, false);
    int[] arrayOfInt1 = new int[this.i / 3 * this.j];
    int[] arrayOfInt2 = new int[this.i / 3 * this.j];
    localBitmap1.getPixels(arrayOfInt1, 0, this.i / 3, 0, 0, this.i / 3, this.j);
    localBitmap2.getPixels(arrayOfInt2, 0, this.i / 3, 0, 0, this.i / 3, this.j);
    localBitmap3.getPixels(new int[localBitmap3.getWidth() * localBitmap3.getHeight()], 0, localBitmap3.getWidth(), 0, 0, localBitmap3.getWidth(), localBitmap3.getHeight());
    int i2 = 0;
    int i1 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt2 < localBitmap3.getHeight())
    {
      int i4;
      int i3;
      if (paramInt1 < this.i / 3)
      {
        if (i1 < arrayOfInt1.length) {
          localBitmap3.setPixel(paramInt1, paramInt2, arrayOfInt1[i1]);
        }
        i4 = i1 + 1;
        i3 = i2;
      }
      for (;;)
      {
        int i5 = paramInt1 + 1;
        i2 = i3;
        i1 = i4;
        paramInt1 = i5;
        if (i5 != localBitmap3.getWidth()) {
          break;
        }
        paramInt2 += 1;
        paramInt1 = 0;
        i2 = i3;
        i1 = i4;
        break;
        i3 = i2;
        i4 = i1;
        if (paramInt1 >= localBitmap3.getWidth() - this.i / 3)
        {
          if (i2 < arrayOfInt2.length) {
            localBitmap3.setPixel(paramInt1, paramInt2, arrayOfInt2[i2]);
          }
          i3 = i2 + 1;
          i4 = i1;
        }
      }
    }
    this.a = localBitmap3;
    this.b = this.a;
    this.f = this.a.getWidth();
    this.g = this.a.getHeight();
    this.i = this.f;
    this.j = this.g;
    this.d.right = this.f;
    this.d.bottom = this.g;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.a == null) {}
    while (this.a.isRecycled()) {
      return;
    }
    paramCanvas.drawBitmap(this.a, this.d, this.e, this.c);
  }
  
  void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    a(paramCanvas);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while ((this.a.isRecycled()) || ((paramInt1 == this.f) && (paramInt2 == this.g))) {
      return;
    }
    this.a = Bitmap.createScaledBitmap(this.b, paramInt1, paramInt2, true);
    this.f = paramInt1;
    this.g = paramInt2;
    this.d.right = paramInt1;
    this.d.bottom = paramInt2;
    a.an.add(this.a);
    this.n.add(this.a);
  }
  
  int[] b()
  {
    return new int[] { this.e.left, this.e.top };
  }
  
  int c()
  {
    return this.e.left;
  }
  
  void c(int paramInt1, int paramInt2)
  {
    this.e.left = paramInt1;
    this.e.top = paramInt2;
    this.e.right = (this.f + paramInt1);
    this.e.bottom = (this.g + paramInt2);
  }
  
  int d()
  {
    return this.e.top;
  }
  
  void d(int paramInt1, int paramInt2)
  {
    c((paramInt1 - this.f) / 2, (paramInt2 - this.g) / 2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ADCImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */