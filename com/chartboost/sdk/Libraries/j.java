package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.b;
import com.chartboost.sdk.impl.bb;
import com.chartboost.sdk.impl.bb.b;
import java.io.File;

public final class j
  implements g.b
{
  private a a;
  private g b;
  private String c;
  private float d = 1.0F;
  private bb.b e = new bb.b()
  {
    public void a(j.a paramAnonymousa, Bundle paramAnonymousBundle)
    {
      j.a(j.this, paramAnonymousa);
      j.a(j.this).a(j.this);
    }
  };
  
  public j(g paramg)
  {
    this.b = paramg;
  }
  
  public void a(final e.a parama, final String paramString, final Bundle paramBundle)
  {
    parama = parama.a(paramString);
    this.c = paramString;
    if (parama.b()) {}
    do
    {
      return;
      paramString = parama.e("url");
      this.d = parama.a("scale").a(1.0F);
    } while (TextUtils.isEmpty(paramString));
    this.b.b(this);
    CBUtility.e().post(new Runnable()
    {
      public void run()
      {
        Object localObject2 = "";
        Object localObject1 = localObject2;
        if (parama.e("checksum") != null)
        {
          localObject1 = localObject2;
          if (!parama.e("checksum").isEmpty()) {
            localObject1 = parama.e("checksum");
          }
        }
        bb localbb = bb.a();
        String str = paramString;
        bb.b localb = j.b(j.this);
        if (paramBundle == null) {}
        for (localObject2 = new Bundle();; localObject2 = paramBundle)
        {
          localbb.a(str, (String)localObject1, localb, null, (Bundle)localObject2);
          return;
        }
      }
    });
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    a(this.b.g(), paramString, localBundle);
  }
  
  public boolean a()
  {
    return e();
  }
  
  public int b()
  {
    return this.a.d() * a.a(this.a);
  }
  
  public int c()
  {
    return this.a.e() * a.a(this.a);
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public Bitmap f()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public float g()
  {
    return this.d;
  }
  
  public int h()
  {
    return Math.round(b() / this.d);
  }
  
  public int i()
  {
    return Math.round(c() / this.d);
  }
  
  public static class a
  {
    private int a;
    private String b;
    private File c;
    private Bitmap d;
    private h e;
    private int f = -1;
    private int g = -1;
    
    public a(String paramString, File paramFile, h paramh)
    {
      this.c = paramFile;
      this.b = paramString;
      this.d = null;
      this.a = 1;
      this.e = paramh;
    }
    
    private void f()
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.c.getAbsolutePath(), localOptions);
        this.f = localOptions.outWidth;
        this.g = localOptions.outHeight;
        return;
      }
      catch (Exception localException)
      {
        CBLogging.b("MemoryBitmap", "Error decoding file size", localException);
      }
    }
    
    public Bitmap a()
    {
      if (this.d == null) {
        b();
      }
      return this.d;
    }
    
    public void b()
    {
      if (this.d != null) {
        return;
      }
      CBLogging.a("MemoryBitmap", "Loading image '" + this.b + "' from cache");
      byte[] arrayOfByte = this.e.b(this.c);
      if (arrayOfByte == null)
      {
        CBLogging.b("MemoryBitmap", "decode() - bitmap not found");
        return;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inDither = false;
      localOptions.inPurgeable = true;
      localOptions.inInputShareable = true;
      localOptions.inTempStorage = new byte[32768];
      localOptions.inSampleSize = 1;
      for (;;)
      {
        if (localOptions.inSampleSize < 32) {}
        try
        {
          this.d = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          this.a = localOptions.inSampleSize;
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          CBLogging.b("MemoryBitmap", "OutOfMemoryError suppressed - trying larger sample size", localOutOfMemoryError);
          localOptions.inSampleSize *= 2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            CBLogging.b("MemoryBitmap", "Exception raised decoding bitmap", localException);
          }
        }
      }
    }
    
    public void c()
    {
      try
      {
        if ((this.d != null) && (!this.d.isRecycled())) {
          this.d.recycle();
        }
        this.d = null;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    
    public int d()
    {
      if (this.d != null) {
        return this.d.getWidth();
      }
      if (this.f >= 0) {
        return this.f;
      }
      f();
      return this.f;
    }
    
    public int e()
    {
      if (this.d != null) {
        return this.d.getHeight();
      }
      if (this.g >= 0) {
        return this.g;
      }
      f();
      return this.g;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */