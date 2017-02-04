package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztg;
import java.io.IOException;

public final class zzau
  extends zzte<zzau>
{
  public long zzapT;
  public long zzapW;
  
  public zzau()
  {
    zzsN();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzau));
          paramObject = (zzau)paramObject;
          bool1 = bool2;
        } while (this.zzapW != ((zzau)paramObject).zzapW);
        bool1 = bool2;
      } while (this.zzapT != ((zzau)paramObject).zzapT);
      if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
        break label91;
      }
      if (((zzau)paramObject).zzbpQ == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzau)paramObject).zzbpQ.isEmpty());
    return true;
    label91:
    return this.zzbpQ.equals(((zzau)paramObject).zzbpQ);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = (int)(this.zzapW ^ this.zzapW >>> 32);
    int m = (int)(this.zzapT ^ this.zzapT >>> 32);
    if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
    for (int i = 0;; i = this.zzbpQ.hashCode()) {
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {
    paramzztd.zzc(1, this.zzapW);
    paramzztd.zzc(2, this.zzapT);
    super.writeTo(paramzztd);
  }
  
  public zzau zzn(zztc paramzztc)
    throws IOException
  {
    for (;;)
    {
      int i = paramzztc.zzHi();
      switch (i)
      {
      default: 
        if (zza(paramzztc, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.zzapW = paramzztc.zzHo();
        break;
      case 16: 
        this.zzapT = paramzztc.zzHo();
      }
    }
  }
  
  public zzau zzsN()
  {
    this.zzapW = -1L;
    this.zzapT = -1L;
    this.zzbpQ = null;
    this.zzbqb = -1;
    return this;
  }
  
  protected int zzz()
  {
    return super.zzz() + zztd.zze(1, this.zzapW) + zztd.zze(2, this.zzapT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */