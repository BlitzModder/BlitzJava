package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzte<M extends zzte<M>>
  extends zztk
{
  protected zztg zzbpQ;
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {
    if (this.zzbpQ == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.zzbpQ.size())
      {
        this.zzbpQ.zzmD(i).writeTo(paramzztd);
        i += 1;
      }
    }
  }
  
  public M zzHz()
    throws CloneNotSupportedException
  {
    zzte localzzte = (zzte)super.clone();
    zzti.zza(this, localzzte);
    return localzzte;
  }
  
  public final <T> T zza(zztf<M, T> paramzztf)
  {
    if (this.zzbpQ == null) {}
    zzth localzzth;
    do
    {
      return null;
      localzzth = this.zzbpQ.zzmC(zztn.zzmG(paramzztf.tag));
    } while (localzzth == null);
    return (T)localzzth.zzb(paramzztf);
  }
  
  protected final boolean zza(zztc paramzztc, int paramInt)
    throws IOException
  {
    int i = paramzztc.getPosition();
    if (!paramzztc.zzml(paramInt)) {
      return false;
    }
    int j = zztn.zzmG(paramInt);
    zztm localzztm = new zztm(paramInt, paramzztc.zzF(i, paramzztc.getPosition() - i));
    paramzztc = null;
    if (this.zzbpQ == null) {
      this.zzbpQ = new zztg();
    }
    for (;;)
    {
      Object localObject = paramzztc;
      if (paramzztc == null)
      {
        localObject = new zzth();
        this.zzbpQ.zza(j, (zzth)localObject);
      }
      ((zzth)localObject).zza(localzztm);
      return true;
      paramzztc = this.zzbpQ.zzmC(j);
    }
  }
  
  protected int zzz()
  {
    int j = 0;
    if (this.zzbpQ != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.zzbpQ.size()) {
          break;
        }
        i += this.zzbpQ.zzmD(j).zzz();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */