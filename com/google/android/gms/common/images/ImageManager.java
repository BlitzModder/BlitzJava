package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zznx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zzahR = new Object();
  private static HashSet<Uri> zzahS = new HashSet();
  private static ImageManager zzahT;
  private static ImageManager zzahU;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzahV;
  private final zzb zzahW;
  private final zzmx zzahX;
  private final Map<zza, ImageReceiver> zzahY;
  private final Map<Uri, ImageReceiver> zzahZ;
  private final Map<Uri, Long> zzaia;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.zzahV = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.zzahW = new zzb(this.mContext);
      if (zznx.zzrQ()) {
        zzpR();
      }
    }
    for (;;)
    {
      this.zzahX = new zzmx();
      this.zzahY = new HashMap();
      this.zzahZ = new HashMap();
      this.zzaia = new HashMap();
      return;
      this.zzahW = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return zzc(paramContext, false);
  }
  
  private Bitmap zza(zza.zza paramzza)
  {
    if (this.zzahW == null) {
      return null;
    }
    return (Bitmap)this.zzahW.get(paramzza);
  }
  
  public static ImageManager zzc(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzahU == null) {
        zzahU = new ImageManager(paramContext, true);
      }
      return zzahU;
    }
    if (zzahT == null) {
      zzahT = new ImageManager(paramContext, false);
    }
    return zzahT;
  }
  
  private void zzpR()
  {
    this.mContext.registerComponentCallbacks(new zze(this.zzahW));
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzbN(paramInt);
    zza(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzbN(paramInt);
    zza(paramOnImageLoadedListener);
  }
  
  public void zza(zza paramzza)
  {
    zzb.zzcx("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramzza).run();
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zza> zzaib;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.zzaib = new ArrayList();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, this.mUri, paramBundle));
    }
    
    public void zzb(zza paramzza)
    {
      zzb.zzcx("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zzaib.add(paramzza);
    }
    
    public void zzc(zza paramzza)
    {
      zzb.zzcx("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zzaib.remove(paramzza);
    }
    
    public void zzpU()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class zzb
    extends LruCache<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }
    
    private static int zzar(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!zznx.zzrN())) {
          break label55;
        }
      }
      label55:
      for (int i = ImageManager.zza.zza(localActivityManager);; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class zzc
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzaid;
    
    public zzc(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.zzaid = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      zzb.zzcy("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (this.zzaid != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(this.zzaid.getFileDescriptor());
        bool1 = bool2;
        Object localObject;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          for (;;)
          {
            this.zzaid.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, this.mUri, localBitmap, bool1, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
            bool1 = true;
            localObject = localCountDownLatch;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("ImageManager", "closed failed", localIOException);
          }
        }
      }
    }
  }
  
  private final class zzd
    implements Runnable
  {
    private final zza zzaie;
    
    public zzd(zza paramzza)
    {
      this.zzaie = paramzza;
    }
    
    public void run()
    {
      zzb.zzcx("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(this.zzaie);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(this.zzaie);
        ((ImageManager.ImageReceiver)localObject1).zzc(this.zzaie);
      }
      zza.zza localzza = this.zzaie.zzaig;
      if (localzza.uri == null)
      {
        this.zzaie.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.zza(ImageManager.this, localzza);
      if (localObject1 != null)
      {
        this.zzaie.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(localzza.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.zzaie.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(localzza.uri);
      }
      this.zzaie.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(localzza.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, localzza.uri);
        ImageManager.zze(ImageManager.this).put(localzza.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zzb(this.zzaie);
      if (!(this.zzaie instanceof zza.zzc)) {
        ImageManager.zza(ImageManager.this).put(this.zzaie, localObject1);
      }
      synchronized (ImageManager.zzpS())
      {
        if (!ImageManager.zzpT().contains(localzza.uri))
        {
          ImageManager.zzpT().add(localzza.uri);
          ((ImageManager.ImageReceiver)localObject1).zzpU();
        }
        return;
      }
    }
  }
  
  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb zzahW;
    
    public zze(ImageManager.zzb paramzzb)
    {
      this.zzahW = paramzzb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.zzahW.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.zzahW.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      this.zzahW.trimToSize(this.zzahW.size() / 2);
    }
  }
  
  private final class zzf
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private boolean zzaif;
    private final CountDownLatch zzpy;
    
    public zzf(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.zzaif = paramBoolean;
      this.zzpy = paramCountDownLatch;
    }
    
    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = paramImageReceiver.size();
      int i = 0;
      if (i < j)
      {
        zza localzza = (zza)paramImageReceiver.get(i);
        if (paramBoolean) {
          localzza.zza(ImageManager.zzb(ImageManager.this), this.mBitmap, false);
        }
        for (;;)
        {
          if (!(localzza instanceof zza.zzc)) {
            ImageManager.zza(ImageManager.this).remove(localzza);
          }
          i += 1;
          break;
          ImageManager.zzd(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localzza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      zzb.zzcx("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null) {
        bool = true;
      }
      while (ImageManager.zzh(ImageManager.this) != null) {
        if (this.zzaif)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          this.zzaif = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(this.mUri), this.mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(this.mUri);
      if (??? != null) {
        zza((ImageManager.ImageReceiver)???, bool);
      }
      this.zzpy.countDown();
      synchronized (ImageManager.zzpS())
      {
        ImageManager.zzpT().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */