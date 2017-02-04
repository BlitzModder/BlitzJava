package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztg;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import java.io.IOException;

public final class zzat
  extends zzte<zzat>
{
  public int versionCode;
  public long zzapT;
  public String zzapV;
  public long zzapW;
  public int zzapX;
  
  public zzat()
  {
    zzsM();
  }
  
  public static zzat zzm(byte[] paramArrayOfByte)
    throws zztj
  {
    return (zzat)zztk.mergeFrom(new zzat(), paramArrayOfByte);
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzat));
        paramObject = (zzat)paramObject;
        bool1 = bool2;
      } while (this.versionCode != ((zzat)paramObject).versionCode);
      if (this.zzapV != null) {
        break;
      }
      bool1 = bool2;
    } while (((zzat)paramObject).zzapV != null);
    while (this.zzapV.equals(((zzat)paramObject).zzapV))
    {
      bool1 = bool2;
      if (this.zzapW != ((zzat)paramObject).zzapW) {
        break;
      }
      bool1 = bool2;
      if (this.zzapT != ((zzat)paramObject).zzapT) {
        break;
      }
      bool1 = bool2;
      if (this.zzapX != ((zzat)paramObject).zzapX) {
        break;
      }
      if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
        break label149;
      }
      if (((zzat)paramObject).zzbpQ != null)
      {
        bool1 = bool2;
        if (!((zzat)paramObject).zzbpQ.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label149:
    return this.zzbpQ.equals(((zzat)paramObject).zzbpQ);
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.versionCode;
    int i;
    int i1;
    int i2;
    int i3;
    if (this.zzapV == null)
    {
      i = 0;
      i1 = (int)(this.zzapW ^ this.zzapW >>> 32);
      i2 = (int)(this.zzapT ^ this.zzapT >>> 32);
      i3 = this.zzapX;
      j = k;
      if (this.zzbpQ != null) {
        if (!this.zzbpQ.isEmpty()) {
          break label138;
        }
      }
    }
    label138:
    for (int j = k;; j = this.zzbpQ.hashCode())
    {
      return ((((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j;
      i = this.zzapV.hashCode();
      break;
    }
  }
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {
    paramzztd.zzG(1, this.versionCode);
    paramzztd.zzb(2, this.zzapV);
    paramzztd.zzc(3, this.zzapW);
    paramzztd.zzc(4, this.zzapT);
    if (this.zzapX != -1) {
      paramzztd.zzG(5, this.zzapX);
    }
    super.writeTo(paramzztd);
  }
  
  public zzat zzm(zztc paramzztc)
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
      case 18: 
        this.zzapV = paramzztc.readString();
        break;
      case 24: 
        this.zzapW = paramzztc.zzHo();
        break;
      case 32: 
        this.zzapT = paramzztc.zzHo();
        break;
      case 40: 
        this.zzapX = paramzztc.zzHl();
      }
    }
  }
  
  public zzat zzsM()
  {
    this.versionCode = 1;
    this.zzapV = "";
    this.zzapW = -1L;
    this.zzapT = -1L;
    this.zzapX = -1;
    this.zzbpQ = null;
    this.zzbqb = -1;
    return this;
  }
  
  protected int zzz()
  {
    int j = super.zzz() + zztd.zzI(1, this.versionCode) + zztd.zzp(2, this.zzapV) + zztd.zze(3, this.zzapW) + zztd.zze(4, this.zzapT);
    int i = j;
    if (this.zzapX != -1) {
      i = j + zztd.zzI(5, this.zzapX);
    }
    return i;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */