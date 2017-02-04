package com.chartboost.sdk.impl;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.b;
import com.chartboost.sdk.Libraries.h;
import com.chartboost.sdk.Libraries.j.a;
import com.chartboost.sdk.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class bb
{
  private static volatile bb c = null;
  private h a = new h(true);
  private Map<String, j.a> b = new HashMap();
  
  private j.a a(String paramString)
  {
    if (b(paramString))
    {
      if (this.b.containsKey(paramString)) {
        return (j.a)this.b.get(paramString);
      }
      j.a locala = new j.a(paramString, this.a.c(this.a.i(), String.format("%s%s", new Object[] { paramString, ".png" })), this.a);
      this.b.put(paramString, locala);
      return locala;
    }
    if (this.b.containsKey(paramString)) {
      this.b.remove(paramString);
    }
    return null;
  }
  
  public static bb a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new bb();
      }
      return c;
    }
    finally {}
  }
  
  private static a b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof c)) {
        return ((c)paramImageView).a();
      }
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    return this.a.b(String.format("%s%s", new Object[] { paramString, ".png" }));
  }
  
  public void a(String paramString1, String paramString2, b paramb, ImageView paramImageView, Bundle paramBundle)
  {
    j.a locala = a(paramString2);
    if (locala != null)
    {
      if (paramImageView != null) {
        paramImageView.setImageBitmap(locala.a());
      }
      if (paramb != null) {
        paramb.a(locala, paramBundle);
      }
      return;
    }
    if ((paramString1 == null) && (paramb != null)) {
      paramb.a(null, paramBundle);
    }
    paramString1 = new a(paramImageView, paramb, paramString2, paramBundle, paramString1);
    aw.a().execute(paramString1);
  }
  
  public void b()
  {
    this.a.d();
    this.b.clear();
  }
  
  private class a
    implements Runnable
  {
    private String b;
    private final WeakReference<ImageView> c;
    private bb.b d;
    private String e;
    private Bundle f;
    
    public a(ImageView paramImageView, bb.b paramb, String paramString1, Bundle paramBundle, String paramString2)
    {
      this.c = new WeakReference(paramImageView);
      this$1 = new bb.c(this);
      if (paramImageView != null) {
        paramImageView.setImageDrawable(bb.this);
      }
      this.e = paramString1;
      this.d = paramb;
      this.f = paramBundle;
      this.b = paramString2;
    }
    
    private j.a b()
    {
      return (j.a)bb.b(bb.this).get(this.e);
    }
    
    public void a()
    {
      final j.a locala = b();
      if ((locala != null) && (this.c != null) && (this.c.get() != null) && (this == bb.a((ImageView)this.c.get()))) {
        locala.b();
      }
      CBUtility.e().post(new Runnable()
      {
        public void run()
        {
          if (bb.a.c(bb.a.this) != null)
          {
            ImageView localImageView = (ImageView)bb.a.c(bb.a.this).get();
            bb.a locala = bb.a(localImageView);
            if ((locala != null) && (bb.a.this == locala)) {
              localImageView.setImageBitmap(locala.a());
            }
          }
          if (bb.a.d(bb.a.this) != null) {
            bb.a.d(bb.a.this).a(locala, bb.a.e(bb.a.this));
          }
        }
      });
    }
    
    public void run()
    {
      if (bb.a(bb.this, this.e))
      {
        a();
        return;
      }
      n.a local1 = new n.a()
      {
        public void a(s paramAnonymouss)
        {
          CBLogging.b("CBWebImageCache", "Error downloading the bitmap image from the server");
          if ((paramAnonymouss != null) && (!TextUtils.isEmpty(paramAnonymouss.getMessage()))) {
            CBLogging.b("CBWebImageCache", paramAnonymouss.getMessage());
          }
          if ((paramAnonymouss != null) && (paramAnonymouss.a != null)) {
            CBLogging.b("CBWebImageCache", "Error status Code: " + paramAnonymouss.a.a);
          }
        }
      };
      CBLogging.a("CBWebImageCache", "downloading image to cache... " + this.b);
      d locald = new d(10000, 1, 1.0F);
      az.a(c.y()).a().a(new l(0, this.b, local1)
      {
        protected n<String> a(i paramAnonymousi)
        {
          try
          {
            byte[] arrayOfByte = paramAnonymousi.b;
            String str = b.b(b.a(arrayOfByte));
            paramAnonymousi = str;
            if (TextUtils.isEmpty(str)) {
              paramAnonymousi = "";
            }
            if (!paramAnonymousi.equals(bb.a.a(bb.a.this)))
            {
              bb.a.a(bb.a.this, paramAnonymousi);
              CBLogging.b("CBWebImageCache:ImageDownloader", "Error: checksum did not match while downloading from " + bb.a.b(bb.a.this));
            }
            bb.a(bb.this).a(bb.a(bb.this).i(), String.format("%s%s", new Object[] { bb.a.a(bb.a.this), ".png" }), arrayOfByte);
            bb.b(bb.this, bb.a.a(bb.a.this));
            return n.a(null, null);
          }
          catch (Exception paramAnonymousi) {}
          return n.a(new s("Bitmap response data is empty, unable to download the bitmap"));
        }
        
        protected void c(String paramAnonymousString)
        {
          bb.a.this.a();
        }
        
        public Map<String, String> i()
          throws a
        {
          HashMap localHashMap = new HashMap();
          Iterator localIterator = ay.b().entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject1 = (Map.Entry)localIterator.next();
            Object localObject2 = ((Map.Entry)localObject1).getKey();
            if (((Map.Entry)localObject1).getValue() != null) {}
            for (localObject1 = ((Map.Entry)localObject1).getValue().toString();; localObject1 = null)
            {
              localHashMap.put(localObject2, localObject1);
              break;
            }
          }
          return localHashMap;
        }
      }).a(locald).a(false);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(j.a parama, Bundle paramBundle);
  }
  
  static class c
    extends BitmapDrawable
  {
    private final WeakReference<bb.a> a;
    
    public c(bb.a parama)
    {
      this.a = new WeakReference(parama);
    }
    
    public bb.a a()
    {
      return (bb.a)this.a.get();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */