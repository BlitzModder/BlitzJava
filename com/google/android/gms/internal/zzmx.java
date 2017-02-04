package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.google.android.gms.common.internal.zzw;

public final class zzmx
  extends LruCache<zza, Drawable>
{
  public zzmx()
  {
    super(10);
  }
  
  public static final class zza
  {
    public final int zzaiP;
    public final int zzaiQ;
    
    public zza(int paramInt1, int paramInt2)
    {
      this.zzaiP = paramInt1;
      this.zzaiQ = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof zza)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this == paramObject);
        paramObject = (zza)paramObject;
        if (((zza)paramObject).zzaiP != this.zzaiP) {
          break;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzaiQ == this.zzaiQ);
      return false;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaiP), Integer.valueOf(this.zzaiQ) });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */