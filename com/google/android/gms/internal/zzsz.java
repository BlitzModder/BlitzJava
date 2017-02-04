package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzsz
  extends zzte<zzsz>
{
  public zza[] zzbph;
  
  public zzsz()
  {
    zzHb();
  }
  
  public static zzsz zzz(byte[] paramArrayOfByte)
    throws zztj
  {
    return (zzsz)zztk.mergeFrom(new zzsz(), paramArrayOfByte);
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
        } while (!(paramObject instanceof zzsz));
        paramObject = (zzsz)paramObject;
        bool1 = bool2;
      } while (!zzti.equals(this.zzbph, ((zzsz)paramObject).zzbph));
      if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
        break label79;
      }
      if (((zzsz)paramObject).zzbpQ == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzsz)paramObject).zzbpQ.isEmpty());
    return true;
    label79:
    return this.zzbpQ.equals(((zzsz)paramObject).zzbpQ);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzti.hashCode(this.zzbph);
    if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
    for (int i = 0;; i = this.zzbpQ.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public void writeTo(zztd paramzztd)
    throws IOException
  {
    if ((this.zzbph != null) && (this.zzbph.length > 0))
    {
      int i = 0;
      while (i < this.zzbph.length)
      {
        zza localzza = this.zzbph[i];
        if (localzza != null) {
          paramzztd.zza(1, localzza);
        }
        i += 1;
      }
    }
    super.writeTo(paramzztd);
  }
  
  public zzsz zzHb()
  {
    this.zzbph = zza.zzHc();
    this.zzbpQ = null;
    this.zzbqb = -1;
    return this;
  }
  
  protected int zzz()
  {
    int i = super.zzz();
    int k = i;
    if (this.zzbph != null)
    {
      k = i;
      if (this.zzbph.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.zzbph.length) {
            break;
          }
          zza localzza = this.zzbph[j];
          k = i;
          if (localzza != null) {
            k = i + zztd.zzc(1, localzza);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public zzsz zzz(zztc paramzztc)
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
      case 10: 
        int j = zztn.zzc(paramzztc, 10);
        if (this.zzbph == null) {}
        zza[] arrayOfzza;
        for (i = 0;; i = this.zzbph.length)
        {
          arrayOfzza = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbph, 0, arrayOfzza, 0, i);
            j = i;
          }
          while (j < arrayOfzza.length - 1)
          {
            arrayOfzza[j] = new zza();
            paramzztc.zza(arrayOfzza[j]);
            paramzztc.zzHi();
            j += 1;
          }
        }
        arrayOfzza[j] = new zza();
        paramzztc.zza(arrayOfzza[j]);
        this.zzbph = arrayOfzza;
      }
    }
  }
  
  public static final class zza
    extends zzte<zza>
  {
    private static volatile zza[] zzbpi;
    public String name;
    public zza zzbpj;
    
    public zza()
    {
      zzHd();
    }
    
    public static zza[] zzHc()
    {
      if (zzbpi == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzbpi == null) {
          zzbpi = new zza[0];
        }
        return zzbpi;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label41:
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
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).name != null);
        if (this.zzbpj != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzbpj != null);
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
          if (this.name.equals(((zza)paramObject).name)) {
            break label41;
          }
          return false;
          label111:
          if (!this.zzbpj.equals(((zza)paramObject).zzbpj)) {
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
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.zzbpj != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = this.zzbpQ.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.name.hashCode();
        break;
        j = this.zzbpj.hashCode();
        break label33;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      paramzztd.zzb(1, this.name);
      if (this.zzbpj != null) {
        paramzztd.zza(2, this.zzbpj);
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzA(zztc paramzztc)
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
        case 10: 
          this.name = paramzztc.readString();
          break;
        case 18: 
          if (this.zzbpj == null) {
            this.zzbpj = new zza();
          }
          paramzztc.zza(this.zzbpj);
        }
      }
    }
    
    public zza zzHd()
    {
      this.name = "";
      this.zzbpj = null;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz() + zztd.zzp(1, this.name);
      int i = j;
      if (this.zzbpj != null) {
        i = j + zztd.zzc(2, this.zzbpj);
      }
      return i;
    }
    
    public static final class zza
      extends zzte<zza>
    {
      private static volatile zza[] zzbpk;
      public int type;
      public zza zzbpl;
      
      public zza()
      {
        zzHf();
      }
      
      public static zza[] zzHe()
      {
        if (zzbpk == null) {}
        synchronized (zzti.zzbqa)
        {
          if (zzbpk == null) {
            zzbpk = new zza[0];
          }
          return zzbpk;
        }
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
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (this.type != ((zza)paramObject).type);
          if (this.zzbpl != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzbpl != null);
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
            if (!this.zzbpl.equals(((zza)paramObject).zzbpl)) {
              return false;
            }
          }
        }
        return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
      }
      
      public int hashCode()
      {
        int k = 0;
        int m = getClass().getName().hashCode();
        int n = this.type;
        int i;
        if (this.zzbpl == null)
        {
          i = 0;
          j = k;
          if (this.zzbpQ != null) {
            if (!this.zzbpQ.isEmpty()) {
              break label84;
            }
          }
        }
        label84:
        for (int j = k;; j = this.zzbpQ.hashCode())
        {
          return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
          i = this.zzbpl.hashCode();
          break;
        }
      }
      
      public void writeTo(zztd paramzztd)
        throws IOException
      {
        paramzztd.zzG(1, this.type);
        if (this.zzbpl != null) {
          paramzztd.zza(2, this.zzbpl);
        }
        super.writeTo(paramzztd);
      }
      
      public zza zzB(zztc paramzztc)
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
              this.type = i;
            }
            break;
          case 18: 
            if (this.zzbpl == null) {
              this.zzbpl = new zza();
            }
            paramzztc.zza(this.zzbpl);
          }
        }
      }
      
      public zza zzHf()
      {
        this.type = 1;
        this.zzbpl = null;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
      }
      
      protected int zzz()
      {
        int j = super.zzz() + zztd.zzI(1, this.type);
        int i = j;
        if (this.zzbpl != null) {
          i = j + zztd.zzc(2, this.zzbpl);
        }
        return i;
      }
      
      public static final class zza
        extends zzte<zza>
      {
        public byte[] zzbpm;
        public String zzbpn;
        public double zzbpo;
        public float zzbpp;
        public long zzbpq;
        public int zzbpr;
        public int zzbps;
        public boolean zzbpt;
        public zzsz.zza[] zzbpu;
        public zzsz.zza.zza[] zzbpv;
        public String[] zzbpw;
        public long[] zzbpx;
        public float[] zzbpy;
        public long zzbpz;
        
        public zza()
        {
          zzHg();
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
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.zzbpm, ((zza)paramObject).zzbpm));
            if (this.zzbpn != null) {
              break;
            }
            bool1 = bool2;
          } while (((zza)paramObject).zzbpn != null);
          while (this.zzbpn.equals(((zza)paramObject).zzbpn))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.zzbpo) != Double.doubleToLongBits(((zza)paramObject).zzbpo)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(this.zzbpp) != Float.floatToIntBits(((zza)paramObject).zzbpp)) {
              break;
            }
            bool1 = bool2;
            if (this.zzbpq != ((zza)paramObject).zzbpq) {
              break;
            }
            bool1 = bool2;
            if (this.zzbpr != ((zza)paramObject).zzbpr) {
              break;
            }
            bool1 = bool2;
            if (this.zzbps != ((zza)paramObject).zzbps) {
              break;
            }
            bool1 = bool2;
            if (this.zzbpt != ((zza)paramObject).zzbpt) {
              break;
            }
            bool1 = bool2;
            if (!zzti.equals(this.zzbpu, ((zza)paramObject).zzbpu)) {
              break;
            }
            bool1 = bool2;
            if (!zzti.equals(this.zzbpv, ((zza)paramObject).zzbpv)) {
              break;
            }
            bool1 = bool2;
            if (!zzti.equals(this.zzbpw, ((zza)paramObject).zzbpw)) {
              break;
            }
            bool1 = bool2;
            if (!zzti.equals(this.zzbpx, ((zza)paramObject).zzbpx)) {
              break;
            }
            bool1 = bool2;
            if (!zzti.equals(this.zzbpy, ((zza)paramObject).zzbpy)) {
              break;
            }
            bool1 = bool2;
            if (this.zzbpz != ((zza)paramObject).zzbpz) {
              break;
            }
            if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
              break label297;
            }
            if (((zza)paramObject).zzbpQ != null)
            {
              bool1 = bool2;
              if (!((zza)paramObject).zzbpQ.isEmpty()) {
                break;
              }
            }
            return true;
          }
          return false;
          label297:
          return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
        }
        
        public int hashCode()
        {
          int m = 0;
          int n = getClass().getName().hashCode();
          int i1 = Arrays.hashCode(this.zzbpm);
          int i;
          int i2;
          int i3;
          int i4;
          int i5;
          int i6;
          int j;
          label100:
          int i7;
          int i8;
          int i9;
          int i10;
          int i11;
          int i12;
          if (this.zzbpn == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(this.zzbpo);
            i2 = (int)(l ^ l >>> 32);
            i3 = Float.floatToIntBits(this.zzbpp);
            i4 = (int)(this.zzbpq ^ this.zzbpq >>> 32);
            i5 = this.zzbpr;
            i6 = this.zzbps;
            if (!this.zzbpt) {
              break label288;
            }
            j = 1231;
            i7 = zzti.hashCode(this.zzbpu);
            i8 = zzti.hashCode(this.zzbpv);
            i9 = zzti.hashCode(this.zzbpw);
            i10 = zzti.hashCode(this.zzbpx);
            i11 = zzti.hashCode(this.zzbpy);
            i12 = (int)(this.zzbpz ^ this.zzbpz >>> 32);
            k = m;
            if (this.zzbpQ != null) {
              if (!this.zzbpQ.isEmpty()) {
                break label295;
              }
            }
          }
          label288:
          label295:
          for (int k = m;; k = this.zzbpQ.hashCode())
          {
            return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
            i = this.zzbpn.hashCode();
            break;
            j = 1237;
            break label100;
          }
        }
        
        public void writeTo(zztd paramzztd)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(this.zzbpm, zztn.zzbqi)) {
            paramzztd.zza(1, this.zzbpm);
          }
          if (!this.zzbpn.equals("")) {
            paramzztd.zzb(2, this.zzbpn);
          }
          if (Double.doubleToLongBits(this.zzbpo) != Double.doubleToLongBits(0.0D)) {
            paramzztd.zza(3, this.zzbpo);
          }
          if (Float.floatToIntBits(this.zzbpp) != Float.floatToIntBits(0.0F)) {
            paramzztd.zzb(4, this.zzbpp);
          }
          if (this.zzbpq != 0L) {
            paramzztd.zzb(5, this.zzbpq);
          }
          if (this.zzbpr != 0) {
            paramzztd.zzG(6, this.zzbpr);
          }
          if (this.zzbps != 0) {
            paramzztd.zzH(7, this.zzbps);
          }
          if (this.zzbpt) {
            paramzztd.zzb(8, this.zzbpt);
          }
          int i;
          Object localObject;
          if ((this.zzbpu != null) && (this.zzbpu.length > 0))
          {
            i = 0;
            while (i < this.zzbpu.length)
            {
              localObject = this.zzbpu[i];
              if (localObject != null) {
                paramzztd.zza(9, (zztk)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbpv != null) && (this.zzbpv.length > 0))
          {
            i = 0;
            while (i < this.zzbpv.length)
            {
              localObject = this.zzbpv[i];
              if (localObject != null) {
                paramzztd.zza(10, (zztk)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbpw != null) && (this.zzbpw.length > 0))
          {
            i = 0;
            while (i < this.zzbpw.length)
            {
              localObject = this.zzbpw[i];
              if (localObject != null) {
                paramzztd.zzb(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbpx != null) && (this.zzbpx.length > 0))
          {
            i = 0;
            while (i < this.zzbpx.length)
            {
              paramzztd.zzb(12, this.zzbpx[i]);
              i += 1;
            }
          }
          if (this.zzbpz != 0L) {
            paramzztd.zzb(13, this.zzbpz);
          }
          if ((this.zzbpy != null) && (this.zzbpy.length > 0))
          {
            i = j;
            while (i < this.zzbpy.length)
            {
              paramzztd.zzb(14, this.zzbpy[i]);
              i += 1;
            }
          }
          super.writeTo(paramzztd);
        }
        
        public zza zzC(zztc paramzztc)
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
            case 10: 
              this.zzbpm = paramzztc.readBytes();
              break;
            case 18: 
              this.zzbpn = paramzztc.readString();
              break;
            case 25: 
              this.zzbpo = paramzztc.readDouble();
              break;
            case 37: 
              this.zzbpp = paramzztc.readFloat();
              break;
            case 40: 
              this.zzbpq = paramzztc.zzHk();
              break;
            case 48: 
              this.zzbpr = paramzztc.zzHl();
              break;
            case 56: 
              this.zzbps = paramzztc.zzHn();
              break;
            case 64: 
              this.zzbpt = paramzztc.zzHm();
              break;
            case 74: 
              j = zztn.zzc(paramzztc, 74);
              if (this.zzbpu == null) {}
              for (i = 0;; i = this.zzbpu.length)
              {
                localObject = new zzsz.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpu, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzsz.zza();
                  paramzztc.zza(localObject[j]);
                  paramzztc.zzHi();
                  j += 1;
                }
              }
              localObject[j] = new zzsz.zza();
              paramzztc.zza(localObject[j]);
              this.zzbpu = ((zzsz.zza[])localObject);
              break;
            case 82: 
              j = zztn.zzc(paramzztc, 82);
              if (this.zzbpv == null) {}
              for (i = 0;; i = this.zzbpv.length)
              {
                localObject = new zzsz.zza.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpv, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzsz.zza.zza();
                  paramzztc.zza(localObject[j]);
                  paramzztc.zzHi();
                  j += 1;
                }
              }
              localObject[j] = new zzsz.zza.zza();
              paramzztc.zza(localObject[j]);
              this.zzbpv = ((zzsz.zza.zza[])localObject);
              break;
            case 90: 
              j = zztn.zzc(paramzztc, 90);
              if (this.zzbpw == null) {}
              for (i = 0;; i = this.zzbpw.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpw, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzztc.readString();
                  paramzztc.zzHi();
                  j += 1;
                }
              }
              localObject[j] = paramzztc.readString();
              this.zzbpw = ((String[])localObject);
              break;
            case 96: 
              j = zztn.zzc(paramzztc, 96);
              if (this.zzbpx == null) {}
              for (i = 0;; i = this.zzbpx.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpx, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzztc.zzHk();
                  paramzztc.zzHi();
                  j += 1;
                }
              }
              localObject[j] = paramzztc.zzHk();
              this.zzbpx = ((long[])localObject);
              break;
            case 98: 
              k = paramzztc.zzmn(paramzztc.zzHp());
              i = paramzztc.getPosition();
              j = 0;
              while (paramzztc.zzHu() > 0)
              {
                paramzztc.zzHk();
                j += 1;
              }
              paramzztc.zzmp(i);
              if (this.zzbpx == null) {}
              for (i = 0;; i = this.zzbpx.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpx, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzztc.zzHk();
                  j += 1;
                }
              }
              this.zzbpx = ((long[])localObject);
              paramzztc.zzmo(k);
              break;
            case 104: 
              this.zzbpz = paramzztc.zzHk();
              break;
            case 117: 
              j = zztn.zzc(paramzztc, 117);
              if (this.zzbpy == null) {}
              for (i = 0;; i = this.zzbpy.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpy, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzztc.readFloat();
                  paramzztc.zzHi();
                  j += 1;
                }
              }
              localObject[j] = paramzztc.readFloat();
              this.zzbpy = ((float[])localObject);
              break;
            case 114: 
              i = paramzztc.zzHp();
              k = paramzztc.zzmn(i);
              j = i / 4;
              if (this.zzbpy == null) {}
              for (i = 0;; i = this.zzbpy.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbpy, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzztc.readFloat();
                  j += 1;
                }
              }
              this.zzbpy = ((float[])localObject);
              paramzztc.zzmo(k);
            }
          }
        }
        
        public zza zzHg()
        {
          this.zzbpm = zztn.zzbqi;
          this.zzbpn = "";
          this.zzbpo = 0.0D;
          this.zzbpp = 0.0F;
          this.zzbpq = 0L;
          this.zzbpr = 0;
          this.zzbps = 0;
          this.zzbpt = false;
          this.zzbpu = zzsz.zza.zzHc();
          this.zzbpv = zzsz.zza.zza.zzHe();
          this.zzbpw = zztn.zzbqg;
          this.zzbpx = zztn.zzboC;
          this.zzbpy = zztn.zzbqd;
          this.zzbpz = 0L;
          this.zzbpQ = null;
          this.zzbqb = -1;
          return this;
        }
        
        protected int zzz()
        {
          int i2 = 0;
          int j = super.zzz();
          int i = j;
          if (!Arrays.equals(this.zzbpm, zztn.zzbqi)) {
            i = j + zztd.zzb(1, this.zzbpm);
          }
          j = i;
          if (!this.zzbpn.equals("")) {
            j = i + zztd.zzp(2, this.zzbpn);
          }
          i = j;
          if (Double.doubleToLongBits(this.zzbpo) != Double.doubleToLongBits(0.0D)) {
            i = j + zztd.zzb(3, this.zzbpo);
          }
          j = i;
          if (Float.floatToIntBits(this.zzbpp) != Float.floatToIntBits(0.0F)) {
            j = i + zztd.zzc(4, this.zzbpp);
          }
          i = j;
          if (this.zzbpq != 0L) {
            i = j + zztd.zzd(5, this.zzbpq);
          }
          j = i;
          if (this.zzbpr != 0) {
            j = i + zztd.zzI(6, this.zzbpr);
          }
          int k = j;
          if (this.zzbps != 0) {
            k = j + zztd.zzJ(7, this.zzbps);
          }
          i = k;
          if (this.zzbpt) {
            i = k + zztd.zzc(8, this.zzbpt);
          }
          j = i;
          Object localObject;
          if (this.zzbpu != null)
          {
            j = i;
            if (this.zzbpu.length > 0)
            {
              j = 0;
              while (j < this.zzbpu.length)
              {
                localObject = this.zzbpu[j];
                k = i;
                if (localObject != null) {
                  k = i + zztd.zzc(9, (zztk)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (this.zzbpv != null)
          {
            i = j;
            if (this.zzbpv.length > 0)
            {
              i = j;
              j = 0;
              while (j < this.zzbpv.length)
              {
                localObject = this.zzbpv[j];
                k = i;
                if (localObject != null) {
                  k = i + zztd.zzc(10, (zztk)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (this.zzbpw != null)
          {
            j = i;
            if (this.zzbpw.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < this.zzbpw.length; m = n)
              {
                localObject = this.zzbpw[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + zztd.zzga((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (this.zzbpx != null)
          {
            i = j;
            if (this.zzbpx.length > 0)
            {
              k = 0;
              i = i2;
              while (i < this.zzbpx.length)
              {
                k += zztd.zzad(this.zzbpx[i]);
                i += 1;
              }
              i = j + k + this.zzbpx.length * 1;
            }
          }
          j = i;
          if (this.zzbpz != 0L) {
            j = i + zztd.zzd(13, this.zzbpz);
          }
          i = j;
          if (this.zzbpy != null)
          {
            i = j;
            if (this.zzbpy.length > 0) {
              i = j + this.zzbpy.length * 4 + this.zzbpy.length * 1;
            }
          }
          return i;
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */