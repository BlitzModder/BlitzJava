package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzag
{
  public static final class zza
    extends zzte<zza>
  {
    private static volatile zza[] zzjn;
    public int type;
    public String zzjo;
    public zza[] zzjp;
    public zza[] zzjq;
    public zza[] zzjr;
    public String zzjs;
    public String zzjt;
    public long zzju;
    public boolean zzjv;
    public zza[] zzjw;
    public int[] zzjx;
    public boolean zzjy;
    
    public zza()
    {
      zzR();
    }
    
    public static zza[] zzQ()
    {
      if (zzjn == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzjn == null) {
          zzjn = new zza[0];
        }
        return zzjn;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
      label118:
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
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = bool2;
                    } while (!(paramObject instanceof zza));
                    paramObject = (zza)paramObject;
                    bool1 = bool2;
                  } while (this.type != ((zza)paramObject).type);
                  if (this.zzjo != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((zza)paramObject).zzjo != null);
                bool1 = bool2;
              } while (!zzti.equals(this.zzjp, ((zza)paramObject).zzjp));
              bool1 = bool2;
            } while (!zzti.equals(this.zzjq, ((zza)paramObject).zzjq));
            bool1 = bool2;
          } while (!zzti.equals(this.zzjr, ((zza)paramObject).zzjr));
          if (this.zzjs != null) {
            break label260;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzjs != null);
        if (this.zzjt != null) {
          break label276;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzjt != null);
      label260:
      label276:
      while (this.zzjt.equals(((zza)paramObject).zzjt))
      {
        bool1 = bool2;
        if (this.zzju != ((zza)paramObject).zzju) {
          break;
        }
        bool1 = bool2;
        if (this.zzjv != ((zza)paramObject).zzjv) {
          break;
        }
        bool1 = bool2;
        if (!zzti.equals(this.zzjw, ((zza)paramObject).zzjw)) {
          break;
        }
        bool1 = bool2;
        if (!zzti.equals(this.zzjx, ((zza)paramObject).zzjx)) {
          break;
        }
        bool1 = bool2;
        if (this.zzjy != ((zza)paramObject).zzjy) {
          break;
        }
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label292;
        }
        if (((zza)paramObject).zzbpQ != null)
        {
          bool1 = bool2;
          if (!((zza)paramObject).zzbpQ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.zzjo.equals(((zza)paramObject).zzjo)) {
          break label54;
        }
        return false;
        if (this.zzjs.equals(((zza)paramObject).zzjs)) {
          break label118;
        }
        return false;
      }
      return false;
      label292:
      return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int n = 1231;
      int i2 = 0;
      int i3 = getClass().getName().hashCode();
      int i4 = this.type;
      int i;
      int i5;
      int i6;
      int i7;
      int j;
      label71:
      int k;
      label80:
      int i8;
      int m;
      label107:
      int i9;
      int i10;
      if (this.zzjo == null)
      {
        i = 0;
        i5 = zzti.hashCode(this.zzjp);
        i6 = zzti.hashCode(this.zzjq);
        i7 = zzti.hashCode(this.zzjr);
        if (this.zzjs != null) {
          break label250;
        }
        j = 0;
        if (this.zzjt != null) {
          break label261;
        }
        k = 0;
        i8 = (int)(this.zzju ^ this.zzju >>> 32);
        if (!this.zzjv) {
          break label272;
        }
        m = 1231;
        i9 = zzti.hashCode(this.zzjw);
        i10 = zzti.hashCode(this.zzjx);
        if (!this.zzjy) {
          break label280;
        }
        label132:
        i1 = i2;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label288;
          }
        }
      }
      label250:
      label261:
      label272:
      label280:
      label288:
      for (int i1 = i2;; i1 = this.zzbpQ.hashCode())
      {
        return ((((m + ((k + (j + ((((i + ((i3 + 527) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31 + n) * 31 + i1;
        i = this.zzjo.hashCode();
        break;
        j = this.zzjs.hashCode();
        break label71;
        k = this.zzjt.hashCode();
        break label80;
        m = 1237;
        break label107;
        n = 1237;
        break label132;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      paramzztd.zzG(1, this.type);
      if (!this.zzjo.equals("")) {
        paramzztd.zzb(2, this.zzjo);
      }
      int i;
      zza localzza;
      if ((this.zzjp != null) && (this.zzjp.length > 0))
      {
        i = 0;
        while (i < this.zzjp.length)
        {
          localzza = this.zzjp[i];
          if (localzza != null) {
            paramzztd.zza(3, localzza);
          }
          i += 1;
        }
      }
      if ((this.zzjq != null) && (this.zzjq.length > 0))
      {
        i = 0;
        while (i < this.zzjq.length)
        {
          localzza = this.zzjq[i];
          if (localzza != null) {
            paramzztd.zza(4, localzza);
          }
          i += 1;
        }
      }
      if ((this.zzjr != null) && (this.zzjr.length > 0))
      {
        i = 0;
        while (i < this.zzjr.length)
        {
          localzza = this.zzjr[i];
          if (localzza != null) {
            paramzztd.zza(5, localzza);
          }
          i += 1;
        }
      }
      if (!this.zzjs.equals("")) {
        paramzztd.zzb(6, this.zzjs);
      }
      if (!this.zzjt.equals("")) {
        paramzztd.zzb(7, this.zzjt);
      }
      if (this.zzju != 0L) {
        paramzztd.zzb(8, this.zzju);
      }
      if (this.zzjy) {
        paramzztd.zzb(9, this.zzjy);
      }
      if ((this.zzjx != null) && (this.zzjx.length > 0))
      {
        i = 0;
        while (i < this.zzjx.length)
        {
          paramzztd.zzG(10, this.zzjx[i]);
          i += 1;
        }
      }
      if ((this.zzjw != null) && (this.zzjw.length > 0))
      {
        i = j;
        while (i < this.zzjw.length)
        {
          localzza = this.zzjw[i];
          if (localzza != null) {
            paramzztd.zza(11, localzza);
          }
          i += 1;
        }
      }
      if (this.zzjv) {
        paramzztd.zzb(12, this.zzjv);
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzR()
    {
      this.type = 1;
      this.zzjo = "";
      this.zzjp = zzQ();
      this.zzjq = zzQ();
      this.zzjr = zzQ();
      this.zzjs = "";
      this.zzjt = "";
      this.zzju = 0L;
      this.zzjv = false;
      this.zzjw = zzQ();
      this.zzjx = zztn.zzboD;
      this.zzjy = false;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zza zzk(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        Object localObject;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
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
          case 8: 
            this.type = i;
          }
          break;
        case 18: 
          this.zzjo = paramzztc.readString();
          break;
        case 26: 
          j = zztn.zzc(paramzztc, 26);
          if (this.zzjp == null) {}
          for (i = 0;; i = this.zzjp.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjp, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzztc.zza(localObject[j]);
          this.zzjp = ((zza[])localObject);
          break;
        case 34: 
          j = zztn.zzc(paramzztc, 34);
          if (this.zzjq == null) {}
          for (i = 0;; i = this.zzjq.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjq, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzztc.zza(localObject[j]);
          this.zzjq = ((zza[])localObject);
          break;
        case 42: 
          j = zztn.zzc(paramzztc, 42);
          if (this.zzjr == null) {}
          for (i = 0;; i = this.zzjr.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjr, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzztc.zza(localObject[j]);
          this.zzjr = ((zza[])localObject);
          break;
        case 50: 
          this.zzjs = paramzztc.readString();
          break;
        case 58: 
          this.zzjt = paramzztc.readString();
          break;
        case 64: 
          this.zzju = paramzztc.zzHk();
          break;
        case 72: 
          this.zzjy = paramzztc.zzHm();
          break;
        case 80: 
          int m = zztn.zzc(paramzztc, 80);
          localObject = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              paramzztc.zzHi();
            }
            int n = paramzztc.zzHl();
            switch (n)
            {
            }
            for (;;)
            {
              j += 1;
              break;
              k = i + 1;
              localObject[i] = n;
              i = k;
            }
          }
          if (i != 0)
          {
            if (this.zzjx == null) {}
            for (j = 0;; j = this.zzjx.length)
            {
              if ((j != 0) || (i != localObject.length)) {
                break label810;
              }
              this.zzjx = ((int[])localObject);
              break;
            }
            int[] arrayOfInt = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.zzjx, 0, arrayOfInt, 0, j);
            }
            System.arraycopy(localObject, 0, arrayOfInt, j, i);
            this.zzjx = arrayOfInt;
          }
          break;
        case 82: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0) {
            switch (paramzztc.zzHl())
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
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              j += 1;
            }
          }
          if (j != 0)
          {
            paramzztc.zzmp(i);
            if (this.zzjx == null) {}
            for (i = 0;; i = this.zzjx.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.zzjx, 0, localObject, 0, i);
                j = i;
              }
              while (paramzztc.zzHu() > 0)
              {
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
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                  localObject[j] = i;
                  j += 1;
                }
              }
            }
            this.zzjx = ((int[])localObject);
          }
          paramzztc.zzmo(k);
          break;
        case 90: 
          j = zztn.zzc(paramzztc, 90);
          if (this.zzjw == null) {}
          for (i = 0;; i = this.zzjw.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjw, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzztc.zza(localObject[j]);
          this.zzjw = ((zza[])localObject);
          break;
        case 96: 
          label810:
          this.zzjv = paramzztc.zzHm();
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int j = super.zzz() + zztd.zzI(1, this.type);
      int i = j;
      if (!this.zzjo.equals("")) {
        i = j + zztd.zzp(2, this.zzjo);
      }
      j = i;
      zza localzza;
      int k;
      if (this.zzjp != null)
      {
        j = i;
        if (this.zzjp.length > 0)
        {
          j = 0;
          while (j < this.zzjp.length)
          {
            localzza = this.zzjp[j];
            k = i;
            if (localzza != null) {
              k = i + zztd.zzc(3, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzjq != null)
      {
        i = j;
        if (this.zzjq.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzjq.length)
          {
            localzza = this.zzjq[j];
            k = i;
            if (localzza != null) {
              k = i + zztd.zzc(4, localzza);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zzjr != null)
      {
        j = i;
        if (this.zzjr.length > 0)
        {
          j = 0;
          while (j < this.zzjr.length)
          {
            localzza = this.zzjr[j];
            k = i;
            if (localzza != null) {
              k = i + zztd.zzc(5, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.zzjs.equals("")) {
        i = j + zztd.zzp(6, this.zzjs);
      }
      j = i;
      if (!this.zzjt.equals("")) {
        j = i + zztd.zzp(7, this.zzjt);
      }
      i = j;
      if (this.zzju != 0L) {
        i = j + zztd.zzd(8, this.zzju);
      }
      j = i;
      if (this.zzjy) {
        j = i + zztd.zzc(9, this.zzjy);
      }
      i = j;
      if (this.zzjx != null)
      {
        i = j;
        if (this.zzjx.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzjx.length)
          {
            k += zztd.zzmu(this.zzjx[i]);
            i += 1;
          }
          i = j + k + this.zzjx.length * 1;
        }
      }
      j = i;
      if (this.zzjw != null)
      {
        j = i;
        if (this.zzjw.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzjw.length) {
              break;
            }
            localzza = this.zzjw[k];
            j = i;
            if (localzza != null) {
              j = i + zztd.zzc(11, localzza);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzjv) {
        i = j + zztd.zzc(12, this.zzjv);
      }
      return i;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */