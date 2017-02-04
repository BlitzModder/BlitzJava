package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zzmu
  extends Drawable
  implements Drawable.Callback
{
  private int mFrom;
  private long zzQj;
  private Drawable zzaiA;
  private boolean zzaiB;
  private boolean zzaiC;
  private boolean zzaiD;
  private int zzaiE;
  private boolean zzail = true;
  private int zzais = 0;
  private int zzait;
  private int zzaiu = 255;
  private int zzaiv;
  private int zzaiw = 0;
  private boolean zzaix;
  private zzb zzaiy;
  private Drawable zzaiz;
  
  public zzmu(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zza.zzpW();
    }
    this.zzaiz = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zzaiy;
    paramDrawable1.zzaiI |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zza.zzpW();
    }
    this.zzaiA = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zzaiy;
    paramDrawable2.zzaiI |= paramDrawable1.getChangingConfigurations();
  }
  
  zzmu(zzb paramzzb)
  {
    this.zzaiy = new zzb(paramzzb);
  }
  
  public boolean canConstantState()
  {
    if (!this.zzaiB) {
      if ((this.zzaiz.getConstantState() == null) || (this.zzaiA.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.zzaiC = bool;
      this.zzaiB = true;
      return this.zzaiC;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.zzais)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.zzaiw;
        bool = this.zzail;
        localDrawable1 = this.zzaiz;
        localDrawable2 = this.zzaiA;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.zzaiu)
        {
          localDrawable2.setAlpha(this.zzaiu);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.zzQj = SystemClock.uptimeMillis();
        this.zzais = 2;
        i = k;
      }
    } while (this.zzQj < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.zzQj) / this.zzaiv;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.zzais = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = this.mFrom;
      this.zzaiw = ((int)(f1 * (this.zzait - this.mFrom) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.zzaiu - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.zzaiu);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zzaiu);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.zzaiy.zzaiH | this.zzaiy.zzaiI;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.zzaiy.zzaiH = getChangingConfigurations();
      return this.zzaiy;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.zzaiz.getIntrinsicHeight(), this.zzaiA.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.zzaiz.getIntrinsicWidth(), this.zzaiA.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.zzaiD)
    {
      this.zzaiE = Drawable.resolveOpacity(this.zzaiz.getOpacity(), this.zzaiA.getOpacity());
      this.zzaiD = true;
    }
    return this.zzaiE;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (zznx.zzrN())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.zzaix) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.zzaiz.mutate();
      this.zzaiA.mutate();
      this.zzaix = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.zzaiz.setBounds(paramRect);
    this.zzaiA.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (zznx.zzrN())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.zzaiw == this.zzaiu) {
      this.zzaiw = paramInt;
    }
    this.zzaiu = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.zzaiz.setColorFilter(paramColorFilter);
    this.zzaiA.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.zzait = this.zzaiu;
    this.zzaiw = 0;
    this.zzaiv = paramInt;
    this.zzais = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (zznx.zzrN())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  public Drawable zzpV()
  {
    return this.zzaiA;
  }
  
  private static final class zza
    extends Drawable
  {
    private static final zza zzaiF = new zza();
    private static final zza zzaiG = new zza(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return zzaiG;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class zza
      extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return zzmu.zza.zzpW();
      }
    }
  }
  
  static final class zzb
    extends Drawable.ConstantState
  {
    int zzaiH;
    int zzaiI;
    
    zzb(zzb paramzzb)
    {
      if (paramzzb != null)
      {
        this.zzaiH = paramzzb.zzaiH;
        this.zzaiI = paramzzb.zzaiI;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.zzaiH;
    }
    
    public Drawable newDrawable()
    {
      return new zzmu(this);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */