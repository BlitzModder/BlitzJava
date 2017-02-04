package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzto
{
  public static final class zza
    extends zztk
  {
    public String name;
    public zzto.zzb[] zzbqj;
    
    public zza()
    {
      zzHJ();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
        if (this.name == null)
        {
          if (((zza)paramObject).name != null) {
            return false;
          }
        }
        else if (!this.name.equals(((zza)paramObject).name)) {
          return false;
        }
      } while (zzti.equals(this.zzbqj, ((zza)paramObject).zzbqj));
      return false;
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      if (this.name == null) {}
      for (int i = 0;; i = this.name.hashCode()) {
        return (i + (j + 527) * 31) * 31 + zzti.hashCode(this.zzbqj);
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.name != null) {
        paramzztd.zzb(1, this.name);
      }
      if ((this.zzbqj != null) && (this.zzbqj.length > 0))
      {
        int i = 0;
        while (i < this.zzbqj.length)
        {
          zzto.zzb localzzb = this.zzbqj[i];
          if (localzzb != null) {
            paramzztd.zza(2, localzzb);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzF(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        switch (i)
        {
        default: 
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.name = paramzztc.readString();
          break;
        case 18: 
          int j = zztn.zzc(paramzztc, 18);
          if (this.zzbqj == null) {}
          zzto.zzb[] arrayOfzzb;
          for (i = 0;; i = this.zzbqj.length)
          {
            arrayOfzzb = new zzto.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqj, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzto.zzb();
              paramzztc.zza(arrayOfzzb[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzto.zzb();
          paramzztc.zza(arrayOfzzb[j]);
          this.zzbqj = arrayOfzzb;
        }
      }
    }
    
    public zza zzHJ()
    {
      this.name = null;
      this.zzbqj = zzto.zzb.zzHK();
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.name != null) {
        i = j + zztd.zzp(1, this.name);
      }
      j = i;
      if (this.zzbqj != null)
      {
        j = i;
        if (this.zzbqj.length > 0)
        {
          j = 0;
          while (j < this.zzbqj.length)
          {
            zzto.zzb localzzb = this.zzbqj[j];
            int k = i;
            if (localzzb != null) {
              k = i + zztd.zzc(2, localzzb);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
  }
  
  public static final class zzb
    extends zztk
  {
    private static volatile zzb[] zzbqk;
    public String name;
    public Integer zzbql;
    public Boolean zzbqm;
    
    public zzb()
    {
      zzHL();
    }
    
    public static zzb[] zzHK()
    {
      if (zzbqk == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzbqk == null) {
          zzbqk = new zzb[0];
        }
        return zzbqk;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zzb)) {
            return false;
          }
          paramObject = (zzb)paramObject;
          if (this.name == null)
          {
            if (((zzb)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zzb)paramObject).name)) {
            return false;
          }
          if (this.zzbql == null)
          {
            if (((zzb)paramObject).zzbql != null) {
              return false;
            }
          }
          else if (!this.zzbql.equals(((zzb)paramObject).zzbql)) {
            return false;
          }
          if (this.zzbqm != null) {
            break;
          }
        } while (((zzb)paramObject).zzbqm == null);
        return false;
      } while (this.zzbqm.equals(((zzb)paramObject).zzbqm));
      return false;
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.zzbql != null) {
          break label72;
        }
        j = 0;
        label32:
        if (this.zzbqm != null) {
          break label83;
        }
      }
      for (;;)
      {
        return (j + (i + (m + 527) * 31) * 31) * 31 + k;
        i = this.name.hashCode();
        break;
        label72:
        j = this.zzbql.intValue();
        break label32;
        label83:
        k = this.zzbqm.hashCode();
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.name != null) {
        paramzztd.zzb(1, this.name);
      }
      if (this.zzbql != null) {
        paramzztd.zzG(3, this.zzbql.intValue());
      }
      if (this.zzbqm != null) {
        paramzztd.zzb(4, this.zzbqm.booleanValue());
      }
      super.writeTo(paramzztd);
    }
    
    public zzb zzG(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        switch (i)
        {
        default: 
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.name = paramzztc.readString();
          break;
        case 24: 
          i = paramzztc.zzHl();
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
            this.zzbql = Integer.valueOf(i);
          }
          break;
        case 32: 
          this.zzbqm = Boolean.valueOf(paramzztc.zzHm());
        }
      }
    }
    
    public zzb zzHL()
    {
      this.name = null;
      this.zzbql = null;
      this.zzbqm = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.name != null) {
        i = j + zztd.zzp(1, this.name);
      }
      j = i;
      if (this.zzbql != null) {
        j = i + zztd.zzI(3, this.zzbql.intValue());
      }
      i = j;
      if (this.zzbqm != null) {
        i = j + zztd.zzc(4, this.zzbqm.booleanValue());
      }
      return i;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */