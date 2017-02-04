package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztg;
import java.io.IOException;

public final class zzas
  extends zzte<zzas>
{
  public int versionCode;
  public long zzapS;
  public long zzapT;
  public long zzapU;
  
  public zzas()
  {
    zzsL();
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
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zzas));
              paramObject = (zzas)paramObject;
              bool1 = bool2;
            } while (this.versionCode != ((zzas)paramObject).versionCode);
            bool1 = bool2;
          } while (this.zzapS != ((zzas)paramObject).zzapS);
          bool1 = bool2;
        } while (this.zzapT != ((zzas)paramObject).zzapT);
        bool1 = bool2;
      } while (this.zzapU != ((zzas)paramObject).zzapU);
      if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
        break label118;
      }
      if (((zzas)paramObject).zzbpQ == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzas)paramObject).zzbpQ.isEmpty());
    return true;
    label118:
    return this.zzbpQ.equals(((zzas)paramObject).zzbpQ);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = this.versionCode;
    int m = (int)(this.zzapS ^ this.zzapS >>> 32);
    int n = (int)(this.zzapT ^ this.zzapT >>> 32);
    int i1 = (int)(this.zzapU ^ this.zzapU >>> 32);
    if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
    for (int i = 0;; i = this.zzbpQ.hashCode()) {
      return i + (((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {
    paramzztd.zzG(1, this.versionCode);
    paramzztd.zzc(2, this.zzapS);
    paramzztd.zzc(3, this.zzapT);
    paramzztd.zzc(4, this.zzapU);
    super.writeTo(paramzztd);
  }
  
  public zzas zzl(zztc paramzztc)
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
        this.versionCode = paramzztc.zzHl();
        break;
      case 16: 
        this.zzapS = paramzztc.zzHo();
        break;
      case 24: 
        this.zzapT = paramzztc.zzHo();
        break;
      case 32: 
        this.zzapU = paramzztc.zzHo();
      }
    }
  }
  
  public zzas zzsL()
  {
    this.versionCode = 1;
    this.zzapS = -1L;
    this.zzapT = -1L;
    this.zzapU = -1L;
    this.zzbpQ = null;
    this.zzbqb = -1;
    return this;
  }
  
  protected int zzz()
  {
    return super.zzz() + zztd.zzI(1, this.versionCode) + zztd.zze(2, this.zzapS) + zztd.zze(3, this.zzapT) + zztd.zze(4, this.zzapU);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */