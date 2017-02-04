package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzsf
{
  public static final class zza
    extends zzte<zza>
  {
    public long zzbgX;
    public zzaf.zzj zzbgY;
    public zzaf.zzf zzjl;
    
    public zza()
    {
      zzFK();
    }
    
    public static zza zzx(byte[] paramArrayOfByte)
      throws zztj
    {
      return (zza)zztk.mergeFrom(new zza(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label55:
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
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (this.zzbgX != ((zza)paramObject).zzbgX);
          if (this.zzjl != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzjl != null);
        if (this.zzbgY != null) {
          break label125;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzbgY != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zza)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zza)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzjl.equals(((zza)paramObject).zzjl)) {
            break label55;
          }
          return false;
          label125:
          if (!this.zzbgY.equals(((zza)paramObject).zzbgY)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = (int)(this.zzbgX ^ this.zzbgX >>> 32);
      int i;
      int j;
      if (this.zzjl == null)
      {
        i = 0;
        if (this.zzbgY != null) {
          break label110;
        }
        j = 0;
        label48:
        k = m;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label121;
          }
        }
      }
      label110:
      label121:
      for (int k = m;; k = this.zzbpQ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzjl.hashCode();
        break;
        j = this.zzbgY.hashCode();
        break label48;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      paramzztd.zzb(1, this.zzbgX);
      if (this.zzjl != null) {
        paramzztd.zza(2, this.zzjl);
      }
      if (this.zzbgY != null) {
        paramzztd.zza(3, this.zzbgY);
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzFK()
    {
      this.zzbgX = 0L;
      this.zzjl = null;
      this.zzbgY = null;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zza zzy(zztc paramzztc)
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
          this.zzbgX = paramzztc.zzHk();
          break;
        case 18: 
          if (this.zzjl == null) {
            this.zzjl = new zzaf.zzf();
          }
          paramzztc.zza(this.zzjl);
          break;
        case 26: 
          if (this.zzbgY == null) {
            this.zzbgY = new zzaf.zzj();
          }
          paramzztc.zza(this.zzbgY);
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz() + zztd.zzd(1, this.zzbgX);
      int i = j;
      if (this.zzjl != null) {
        i = j + zztd.zzc(2, this.zzjl);
      }
      j = i;
      if (this.zzbgY != null) {
        j = i + zztd.zzc(3, this.zzbgY);
      }
      return j;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */