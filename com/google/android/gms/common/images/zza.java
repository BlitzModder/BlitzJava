package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zzmx.zza;
import java.lang.ref.WeakReference;

public abstract class zza
{
  final zza zzaig;
  protected int zzaih = 0;
  protected int zzaii = 0;
  protected boolean zzaij = false;
  protected ImageManager.OnImageLoadedListener zzaik;
  private boolean zzail = true;
  private boolean zzaim = false;
  private boolean zzain = true;
  protected int zzaio;
  
  public zza(Uri paramUri, int paramInt)
  {
    this.zzaig = new zza(paramUri);
    this.zzaii = paramInt;
  }
  
  private Drawable zza(Context paramContext, zzmx paramzzmx, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.zzaio > 0)
    {
      zzmx.zza localzza = new zzmx.zza(paramInt, this.zzaio);
      Drawable localDrawable = (Drawable)paramzzmx.get(localzza);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.zzaio & 0x1) != 0) {
          paramContext = zza(localResources, localDrawable);
        }
        paramzzmx.put(localzza, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable zza(Resources paramResources, Drawable paramDrawable)
  {
    return zzmv.zza(paramResources, paramDrawable);
  }
  
  protected zzmu zza(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof zzmu)) {}
    }
    for (Drawable localDrawable = ((zzmu)paramDrawable1).zzpV();; localDrawable = null) {
      return new zzmu(localDrawable, paramDrawable2);
    }
  }
  
  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzb.zzu(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.zzaio & 0x1) != 0) {
      localBitmap = zzmv.zza(paramBitmap);
    }
    paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.zzaik != null) {
      this.zzaik.onImageLoaded(this.zzaig.uri, paramContext, true);
    }
    zza(paramContext, paramBoolean, false, true);
  }
  
  void zza(Context paramContext, zzmx paramzzmx)
  {
    if (this.zzain)
    {
      Drawable localDrawable = null;
      if (this.zzaih != 0) {
        localDrawable = zza(paramContext, paramzzmx, this.zzaih);
      }
      zza(localDrawable, false, true, false);
    }
  }
  
  void zza(Context paramContext, zzmx paramzzmx, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.zzaii != 0) {
      localDrawable = zza(paramContext, paramzzmx, this.zzaii);
    }
    if (this.zzaik != null) {
      this.zzaik.onImageLoaded(this.zzaig.uri, localDrawable, false);
    }
    zza(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected boolean zzb(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zzail) && (!paramBoolean2) && ((!paramBoolean1) || (this.zzaim));
  }
  
  public void zzbN(int paramInt)
  {
    this.zzaii = paramInt;
  }
  
  static final class zza
  {
    public final Uri uri;
    
    public zza(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return zzw.equal(((zza)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class zzb
    extends zza
  {
    private WeakReference<ImageView> zzaip;
    
    public zzb(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      zzb.zzu(paramImageView);
      this.zzaip = new WeakReference(paramImageView);
    }
    
    public zzb(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      zzb.zzu(paramImageView);
      this.zzaip = new WeakReference(paramImageView);
    }
    
    private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof zzmw)); i = 0)
      {
        int j = ((zzmw)paramImageView).zzpX();
        if ((this.zzaii == 0) || (j != this.zzaii)) {
          break;
        }
        return;
      }
      paramBoolean1 = zzb(paramBoolean1, paramBoolean2);
      if ((this.zzaij) && (paramDrawable != null)) {
        paramDrawable = paramDrawable.getConstantState().newDrawable();
      }
      for (;;)
      {
        Object localObject = paramDrawable;
        if (paramBoolean1) {
          localObject = zza(paramImageView.getDrawable(), paramDrawable);
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        if ((paramImageView instanceof zzmw))
        {
          paramDrawable = (zzmw)paramImageView;
          if (!paramBoolean3) {
            break label171;
          }
          paramImageView = this.zzaig.uri;
          label133:
          paramDrawable.zzm(paramImageView);
          if (i == 0) {
            break label176;
          }
        }
        label171:
        label176:
        for (i = this.zzaii;; i = 0)
        {
          paramDrawable.zzbP(i);
          if (!paramBoolean1) {
            break;
          }
          ((zzmu)localObject).startTransition(250);
          return;
          paramImageView = null;
          break label133;
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      Object localObject = (zzb)paramObject;
      paramObject = (ImageView)this.zzaip.get();
      localObject = (ImageView)((zzb)localObject).zzaip.get();
      if ((localObject != null) && (paramObject != null) && (zzw.equal(localObject, paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.zzaip.get();
      if (localImageView != null) {
        zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public static final class zzc
    extends zza
  {
    private WeakReference<ImageManager.OnImageLoadedListener> zzaiq;
    
    public zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      zzb.zzu(paramOnImageLoadedListener);
      this.zzaiq = new WeakReference(paramOnImageLoadedListener);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzc)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzaiq.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((zzc)paramObject).zzaiq.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzw.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzw.equal(((zzc)paramObject).zzaig, this.zzaig))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.zzaig });
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzaiq.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.zzaig.uri, paramDrawable, paramBoolean3);
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/images/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */