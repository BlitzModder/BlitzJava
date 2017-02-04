package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzaf
{
  public static final class zza
    extends zzte<zza>
  {
    public int level;
    public int zzih;
    public int zzii;
    
    public zza()
    {
      zzB();
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
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (this.level != ((zza)paramObject).level);
            bool1 = bool2;
          } while (this.zzih != ((zza)paramObject).zzih);
          bool1 = bool2;
        } while (this.zzii != ((zza)paramObject).zzii);
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label102;
        }
        if (((zza)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbpQ.isEmpty());
      return true;
      label102:
      return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.level;
      int m = this.zzih;
      int n = this.zzii;
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.level != 1) {
        paramzztd.zzG(1, this.level);
      }
      if (this.zzih != 0) {
        paramzztd.zzG(2, this.zzih);
      }
      if (this.zzii != 0) {
        paramzztd.zzG(3, this.zzii);
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzB()
    {
      this.level = 1;
      this.zzih = 0;
      this.zzii = 0;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zza zza(zztc paramzztc)
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
            this.level = i;
          }
          break;
        case 16: 
          this.zzih = paramzztc.zzHl();
          break;
        case 24: 
          this.zzii = paramzztc.zzHl();
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.level != 1) {
        i = j + zztd.zzI(1, this.level);
      }
      j = i;
      if (this.zzih != 0) {
        j = i + zztd.zzI(2, this.zzih);
      }
      i = j;
      if (this.zzii != 0) {
        i = j + zztd.zzI(3, this.zzii);
      }
      return i;
    }
  }
  
  public static final class zzb
    extends zzte<zzb>
  {
    private static volatile zzb[] zzij;
    public int name;
    public int[] zzik;
    public int zzil;
    public boolean zzim;
    public boolean zzin;
    
    public zzb()
    {
      zzD();
    }
    
    public static zzb[] zzC()
    {
      if (zzij == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzij == null) {
          zzij = new zzb[0];
        }
        return zzij;
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
                  } while (!(paramObject instanceof zzb));
                  paramObject = (zzb)paramObject;
                  bool1 = bool2;
                } while (!zzti.equals(this.zzik, ((zzb)paramObject).zzik));
                bool1 = bool2;
              } while (this.zzil != ((zzb)paramObject).zzil);
              bool1 = bool2;
            } while (this.name != ((zzb)paramObject).name);
            bool1 = bool2;
          } while (this.zzim != ((zzb)paramObject).zzim);
          bool1 = bool2;
        } while (this.zzin != ((zzb)paramObject).zzin);
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label131;
        }
        if (((zzb)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzb)paramObject).zzbpQ.isEmpty());
      return true;
      label131:
      return this.zzbpQ.equals(((zzb)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = 1231;
      int m = getClass().getName().hashCode();
      int n = zzti.hashCode(this.zzik);
      int i1 = this.zzil;
      int i2 = this.name;
      int i;
      if (this.zzim)
      {
        i = 1231;
        if (!this.zzin) {
          break label121;
        }
        label55:
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label128;
        }
      }
      label121:
      label128:
      for (int k = 0;; k = this.zzbpQ.hashCode())
      {
        return k + ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j) * 31;
        i = 1237;
        break;
        j = 1237;
        break label55;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.zzin) {
        paramzztd.zzb(1, this.zzin);
      }
      paramzztd.zzG(2, this.zzil);
      if ((this.zzik != null) && (this.zzik.length > 0))
      {
        int i = 0;
        while (i < this.zzik.length)
        {
          paramzztd.zzG(3, this.zzik[i]);
          i += 1;
        }
      }
      if (this.name != 0) {
        paramzztd.zzG(4, this.name);
      }
      if (this.zzim) {
        paramzztd.zzb(6, this.zzim);
      }
      super.writeTo(paramzztd);
    }
    
    public zzb zzD()
    {
      this.zzik = zztn.zzboD;
      this.zzil = 0;
      this.name = 0;
      this.zzim = false;
      this.zzin = false;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzb zzb(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzin = paramzztc.zzHm();
          break;
        case 16: 
          this.zzil = paramzztc.zzHl();
          break;
        case 24: 
          j = zztn.zzc(paramzztc, 24);
          if (this.zzik == null) {}
          for (i = 0;; i = this.zzik.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzik, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zzik = arrayOfInt;
          break;
        case 26: 
          int k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzik == null) {}
          for (i = 0;; i = this.zzik.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzik, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzik = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 32: 
          this.name = paramzztc.zzHl();
          break;
        case 48: 
          this.zzim = paramzztc.zzHm();
        }
      }
    }
    
    protected int zzz()
    {
      int j = 0;
      int k = super.zzz();
      int i = k;
      if (this.zzin) {
        i = k + zztd.zzc(1, this.zzin);
      }
      k = zztd.zzI(2, this.zzil) + i;
      if ((this.zzik != null) && (this.zzik.length > 0))
      {
        i = 0;
        while (i < this.zzik.length)
        {
          j += zztd.zzmu(this.zzik[i]);
          i += 1;
        }
      }
      for (j = k + j + this.zzik.length * 1;; j = k)
      {
        i = j;
        if (this.name != 0) {
          i = j + zztd.zzI(4, this.name);
        }
        j = i;
        if (this.zzim) {
          j = i + zztd.zzc(6, this.zzim);
        }
        return j;
      }
    }
  }
  
  public static final class zzc
    extends zzte<zzc>
  {
    private static volatile zzc[] zzio;
    public String key;
    public long zzip;
    public long zziq;
    public boolean zzir;
    public long zzis;
    
    public zzc()
    {
      zzF();
    }
    
    public static zzc[] zzE()
    {
      if (zzio == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzio == null) {
          zzio = new zzc[0];
        }
        return zzio;
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        if (this.key != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).key != null);
      while (this.key.equals(((zzc)paramObject).key))
      {
        bool1 = bool2;
        if (this.zzip != ((zzc)paramObject).zzip) {
          break;
        }
        bool1 = bool2;
        if (this.zziq != ((zzc)paramObject).zziq) {
          break;
        }
        bool1 = bool2;
        if (this.zzir != ((zzc)paramObject).zzir) {
          break;
        }
        bool1 = bool2;
        if (this.zzis != ((zzc)paramObject).zzis) {
          break;
        }
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label150;
        }
        if (((zzc)paramObject).zzbpQ != null)
        {
          bool1 = bool2;
          if (!((zzc)paramObject).zzbpQ.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label150:
      return this.zzbpQ.equals(((zzc)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int i1;
      int i2;
      int j;
      label65:
      int i3;
      if (this.key == null)
      {
        i = 0;
        i1 = (int)(this.zzip ^ this.zzip >>> 32);
        i2 = (int)(this.zziq ^ this.zziq >>> 32);
        if (!this.zzir) {
          break label154;
        }
        j = 1231;
        i3 = (int)(this.zzis ^ this.zzis >>> 32);
        k = m;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label161;
          }
        }
      }
      label154:
      label161:
      for (int k = m;; k = this.zzbpQ.hashCode())
      {
        return ((j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + k;
        i = this.key.hashCode();
        break;
        j = 1237;
        break label65;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramzztd.zzb(1, this.key);
      }
      if (this.zzip != 0L) {
        paramzztd.zzb(2, this.zzip);
      }
      if (this.zziq != 2147483647L) {
        paramzztd.zzb(3, this.zziq);
      }
      if (this.zzir) {
        paramzztd.zzb(4, this.zzir);
      }
      if (this.zzis != 0L) {
        paramzztd.zzb(5, this.zzis);
      }
      super.writeTo(paramzztd);
    }
    
    public zzc zzF()
    {
      this.key = "";
      this.zzip = 0L;
      this.zziq = 2147483647L;
      this.zzir = false;
      this.zzis = 0L;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzc zzc(zztc paramzztc)
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
          this.key = paramzztc.readString();
          break;
        case 16: 
          this.zzip = paramzztc.zzHk();
          break;
        case 24: 
          this.zziq = paramzztc.zzHk();
          break;
        case 32: 
          this.zzir = paramzztc.zzHm();
          break;
        case 40: 
          this.zzis = paramzztc.zzHk();
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (!this.key.equals("")) {
        i = j + zztd.zzp(1, this.key);
      }
      j = i;
      if (this.zzip != 0L) {
        j = i + zztd.zzd(2, this.zzip);
      }
      i = j;
      if (this.zziq != 2147483647L) {
        i = j + zztd.zzd(3, this.zziq);
      }
      j = i;
      if (this.zzir) {
        j = i + zztd.zzc(4, this.zzir);
      }
      i = j;
      if (this.zzis != 0L) {
        i = j + zztd.zzd(5, this.zzis);
      }
      return i;
    }
  }
  
  public static final class zzd
    extends zzte<zzd>
  {
    public zzag.zza[] zzit;
    public zzag.zza[] zziu;
    public zzaf.zzc[] zziv;
    
    public zzd()
    {
      zzG();
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
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zzd));
              paramObject = (zzd)paramObject;
              bool1 = bool2;
            } while (!zzti.equals(this.zzit, ((zzd)paramObject).zzit));
            bool1 = bool2;
          } while (!zzti.equals(this.zziu, ((zzd)paramObject).zziu));
          bool1 = bool2;
        } while (!zzti.equals(this.zziv, ((zzd)paramObject).zziv));
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label111;
        }
        if (((zzd)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzd)paramObject).zzbpQ.isEmpty());
      return true;
      label111:
      return this.zzbpQ.equals(((zzd)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzti.hashCode(this.zzit);
      int m = zzti.hashCode(this.zziu);
      int n = zzti.hashCode(this.zziv);
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzit != null) && (this.zzit.length > 0))
      {
        i = 0;
        while (i < this.zzit.length)
        {
          localObject = this.zzit[i];
          if (localObject != null) {
            paramzztd.zza(1, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziu != null) && (this.zziu.length > 0))
      {
        i = 0;
        while (i < this.zziu.length)
        {
          localObject = this.zziu[i];
          if (localObject != null) {
            paramzztd.zza(2, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziv != null) && (this.zziv.length > 0))
      {
        i = j;
        while (i < this.zziv.length)
        {
          localObject = this.zziv[i];
          if (localObject != null) {
            paramzztd.zza(3, (zztk)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zzd zzG()
    {
      this.zzit = zzag.zza.zzQ();
      this.zziu = zzag.zza.zzQ();
      this.zziv = zzaf.zzc.zzE();
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzd zzd(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zztn.zzc(paramzztc, 10);
          if (this.zzit == null) {}
          for (i = 0;; i = this.zzit.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzit, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzztc.zza(localObject[j]);
          this.zzit = ((zzag.zza[])localObject);
          break;
        case 18: 
          j = zztn.zzc(paramzztc, 18);
          if (this.zziu == null) {}
          for (i = 0;; i = this.zziu.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziu, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzztc.zza(localObject[j]);
          this.zziu = ((zzag.zza[])localObject);
          break;
        case 26: 
          j = zztn.zzc(paramzztc, 26);
          if (this.zziv == null) {}
          for (i = 0;; i = this.zziv.length)
          {
            localObject = new zzaf.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziv, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzc();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzc();
          paramzztc.zza(localObject[j]);
          this.zziv = ((zzaf.zzc[])localObject);
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int i = super.zzz();
      int j = i;
      Object localObject;
      if (this.zzit != null)
      {
        j = i;
        if (this.zzit.length > 0)
        {
          j = 0;
          while (j < this.zzit.length)
          {
            localObject = this.zzit[j];
            k = i;
            if (localObject != null) {
              k = i + zztd.zzc(1, (zztk)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zziu != null)
      {
        i = j;
        if (this.zziu.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zziu.length)
          {
            localObject = this.zziu[j];
            k = i;
            if (localObject != null) {
              k = i + zztd.zzc(2, (zztk)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (this.zziv != null)
      {
        k = i;
        if (this.zziv.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.zziv.length) {
              break;
            }
            localObject = this.zziv[j];
            k = i;
            if (localObject != null) {
              k = i + zztd.zzc(3, (zztk)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zze
    extends zzte<zze>
  {
    private static volatile zze[] zziw;
    public int key;
    public int value;
    
    public zze()
    {
      zzI();
    }
    
    public static zze[] zzH()
    {
      if (zziw == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zziw == null) {
          zziw = new zze[0];
        }
        return zziw;
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
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zze));
            paramObject = (zze)paramObject;
            bool1 = bool2;
          } while (this.key != ((zze)paramObject).key);
          bool1 = bool2;
        } while (this.value != ((zze)paramObject).value);
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label89;
        }
        if (((zze)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zze)paramObject).zzbpQ.isEmpty());
      return true;
      label89:
      return this.zzbpQ.equals(((zze)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.key;
      int m = this.value;
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      paramzztd.zzG(1, this.key);
      paramzztd.zzG(2, this.value);
      super.writeTo(paramzztd);
    }
    
    public zze zzI()
    {
      this.key = 0;
      this.value = 0;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zze zze(zztc paramzztc)
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
          this.key = paramzztc.zzHl();
          break;
        case 16: 
          this.value = paramzztc.zzHl();
        }
      }
    }
    
    protected int zzz()
    {
      return super.zzz() + zztd.zzI(1, this.key) + zztd.zzI(2, this.value);
    }
  }
  
  public static final class zzf
    extends zzte<zzf>
  {
    public String version;
    public zzaf.zze[] zziA;
    public zzaf.zzb[] zziB;
    public zzaf.zzb[] zziC;
    public zzaf.zzb[] zziD;
    public zzaf.zzg[] zziE;
    public String zziF;
    public String zziG;
    public String zziH;
    public zzaf.zza zziI;
    public float zziJ;
    public boolean zziK;
    public String[] zziL;
    public int zziM;
    public String[] zzix;
    public String[] zziy;
    public zzag.zza[] zziz;
    
    public zzf()
    {
      zzJ();
    }
    
    public static zzf zzc(byte[] paramArrayOfByte)
      throws zztj
    {
      return (zzf)zztk.mergeFrom(new zzf(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label169:
      label185:
      label201:
      label217:
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
                                } while (!(paramObject instanceof zzf));
                                paramObject = (zzf)paramObject;
                                bool1 = bool2;
                              } while (!zzti.equals(this.zzix, ((zzf)paramObject).zzix));
                              bool1 = bool2;
                            } while (!zzti.equals(this.zziy, ((zzf)paramObject).zziy));
                            bool1 = bool2;
                          } while (!zzti.equals(this.zziz, ((zzf)paramObject).zziz));
                          bool1 = bool2;
                        } while (!zzti.equals(this.zziA, ((zzf)paramObject).zziA));
                        bool1 = bool2;
                      } while (!zzti.equals(this.zziB, ((zzf)paramObject).zziB));
                      bool1 = bool2;
                    } while (!zzti.equals(this.zziC, ((zzf)paramObject).zziC));
                    bool1 = bool2;
                  } while (!zzti.equals(this.zziD, ((zzf)paramObject).zziD));
                  bool1 = bool2;
                } while (!zzti.equals(this.zziE, ((zzf)paramObject).zziE));
                if (this.zziF != null) {
                  break;
                }
                bool1 = bool2;
              } while (((zzf)paramObject).zziF != null);
              if (this.zziG != null) {
                break label348;
              }
              bool1 = bool2;
            } while (((zzf)paramObject).zziG != null);
            if (this.zziH != null) {
              break label364;
            }
            bool1 = bool2;
          } while (((zzf)paramObject).zziH != null);
          if (this.version != null) {
            break label380;
          }
          bool1 = bool2;
        } while (((zzf)paramObject).version != null);
        if (this.zziI != null) {
          break label396;
        }
        bool1 = bool2;
      } while (((zzf)paramObject).zziI != null);
      label348:
      label364:
      label380:
      label396:
      while (this.zziI.equals(((zzf)paramObject).zziI))
      {
        bool1 = bool2;
        if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(((zzf)paramObject).zziJ)) {
          break;
        }
        bool1 = bool2;
        if (this.zziK != ((zzf)paramObject).zziK) {
          break;
        }
        bool1 = bool2;
        if (!zzti.equals(this.zziL, ((zzf)paramObject).zziL)) {
          break;
        }
        bool1 = bool2;
        if (this.zziM != ((zzf)paramObject).zziM) {
          break;
        }
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label412;
        }
        if (((zzf)paramObject).zzbpQ != null)
        {
          bool1 = bool2;
          if (!((zzf)paramObject).zzbpQ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.zziF.equals(((zzf)paramObject).zziF)) {
          break label169;
        }
        return false;
        if (this.zziG.equals(((zzf)paramObject).zziG)) {
          break label185;
        }
        return false;
        if (this.zziH.equals(((zzf)paramObject).zziH)) {
          break label201;
        }
        return false;
        if (this.version.equals(((zzf)paramObject).version)) {
          break label217;
        }
        return false;
      }
      return false;
      label412:
      return this.zzbpQ.equals(((zzf)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i5 = zzti.hashCode(this.zzix);
      int i6 = zzti.hashCode(this.zziy);
      int i7 = zzti.hashCode(this.zziz);
      int i8 = zzti.hashCode(this.zziA);
      int i9 = zzti.hashCode(this.zziB);
      int i10 = zzti.hashCode(this.zziC);
      int i11 = zzti.hashCode(this.zziD);
      int i12 = zzti.hashCode(this.zziE);
      int i;
      int j;
      label105:
      int k;
      label114:
      int m;
      label124:
      int n;
      label134:
      int i13;
      int i1;
      label155:
      int i14;
      int i15;
      if (this.zziF == null)
      {
        i = 0;
        if (this.zziG != null) {
          break label318;
        }
        j = 0;
        if (this.zziH != null) {
          break label329;
        }
        k = 0;
        if (this.version != null) {
          break label340;
        }
        m = 0;
        if (this.zziI != null) {
          break label352;
        }
        n = 0;
        i13 = Float.floatToIntBits(this.zziJ);
        if (!this.zziK) {
          break label364;
        }
        i1 = 1231;
        i14 = zzti.hashCode(this.zziL);
        i15 = this.zziM;
        i2 = i3;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label372;
          }
        }
      }
      label318:
      label329:
      label340:
      label352:
      label364:
      label372:
      for (int i2 = i3;; i2 = this.zzbpQ.hashCode())
      {
        return (((i1 + ((n + (m + (k + (j + (i + (((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i2;
        i = this.zziF.hashCode();
        break;
        j = this.zziG.hashCode();
        break label105;
        k = this.zziH.hashCode();
        break label114;
        m = this.version.hashCode();
        break label124;
        n = this.zziI.hashCode();
        break label134;
        i1 = 1237;
        break label155;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zziy != null) && (this.zziy.length > 0))
      {
        i = 0;
        while (i < this.zziy.length)
        {
          localObject = this.zziy[i];
          if (localObject != null) {
            paramzztd.zzb(1, (String)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziz != null) && (this.zziz.length > 0))
      {
        i = 0;
        while (i < this.zziz.length)
        {
          localObject = this.zziz[i];
          if (localObject != null) {
            paramzztd.zza(2, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziA != null) && (this.zziA.length > 0))
      {
        i = 0;
        while (i < this.zziA.length)
        {
          localObject = this.zziA[i];
          if (localObject != null) {
            paramzztd.zza(3, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziB != null) && (this.zziB.length > 0))
      {
        i = 0;
        while (i < this.zziB.length)
        {
          localObject = this.zziB[i];
          if (localObject != null) {
            paramzztd.zza(4, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziC != null) && (this.zziC.length > 0))
      {
        i = 0;
        while (i < this.zziC.length)
        {
          localObject = this.zziC[i];
          if (localObject != null) {
            paramzztd.zza(5, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziD != null) && (this.zziD.length > 0))
      {
        i = 0;
        while (i < this.zziD.length)
        {
          localObject = this.zziD[i];
          if (localObject != null) {
            paramzztd.zza(6, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zziE != null) && (this.zziE.length > 0))
      {
        i = 0;
        while (i < this.zziE.length)
        {
          localObject = this.zziE[i];
          if (localObject != null) {
            paramzztd.zza(7, (zztk)localObject);
          }
          i += 1;
        }
      }
      if (!this.zziF.equals("")) {
        paramzztd.zzb(9, this.zziF);
      }
      if (!this.zziG.equals("")) {
        paramzztd.zzb(10, this.zziG);
      }
      if (!this.zziH.equals("0")) {
        paramzztd.zzb(12, this.zziH);
      }
      if (!this.version.equals("")) {
        paramzztd.zzb(13, this.version);
      }
      if (this.zziI != null) {
        paramzztd.zza(14, this.zziI);
      }
      if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(0.0F)) {
        paramzztd.zzb(15, this.zziJ);
      }
      if ((this.zziL != null) && (this.zziL.length > 0))
      {
        i = 0;
        while (i < this.zziL.length)
        {
          localObject = this.zziL[i];
          if (localObject != null) {
            paramzztd.zzb(16, (String)localObject);
          }
          i += 1;
        }
      }
      if (this.zziM != 0) {
        paramzztd.zzG(17, this.zziM);
      }
      if (this.zziK) {
        paramzztd.zzb(18, this.zziK);
      }
      if ((this.zzix != null) && (this.zzix.length > 0))
      {
        i = j;
        while (i < this.zzix.length)
        {
          localObject = this.zzix[i];
          if (localObject != null) {
            paramzztd.zzb(19, (String)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zzf zzJ()
    {
      this.zzix = zztn.zzbqg;
      this.zziy = zztn.zzbqg;
      this.zziz = zzag.zza.zzQ();
      this.zziA = zzaf.zze.zzH();
      this.zziB = zzaf.zzb.zzC();
      this.zziC = zzaf.zzb.zzC();
      this.zziD = zzaf.zzb.zzC();
      this.zziE = zzaf.zzg.zzK();
      this.zziF = "";
      this.zziG = "";
      this.zziH = "0";
      this.version = "";
      this.zziI = null;
      this.zziJ = 0.0F;
      this.zziK = false;
      this.zziL = zztn.zzbqg;
      this.zziM = 0;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzf zzf(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zztn.zzc(paramzztc, 10);
          if (this.zziy == null) {}
          for (i = 0;; i = this.zziy.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziy, 0, localObject, 0, i);
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
          this.zziy = ((String[])localObject);
          break;
        case 18: 
          j = zztn.zzc(paramzztc, 18);
          if (this.zziz == null) {}
          for (i = 0;; i = this.zziz.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziz, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzztc.zza(localObject[j]);
          this.zziz = ((zzag.zza[])localObject);
          break;
        case 26: 
          j = zztn.zzc(paramzztc, 26);
          if (this.zziA == null) {}
          for (i = 0;; i = this.zziA.length)
          {
            localObject = new zzaf.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziA, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zze();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zze();
          paramzztc.zza(localObject[j]);
          this.zziA = ((zzaf.zze[])localObject);
          break;
        case 34: 
          j = zztn.zzc(paramzztc, 34);
          if (this.zziB == null) {}
          for (i = 0;; i = this.zziB.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziB, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzztc.zza(localObject[j]);
          this.zziB = ((zzaf.zzb[])localObject);
          break;
        case 42: 
          j = zztn.zzc(paramzztc, 42);
          if (this.zziC == null) {}
          for (i = 0;; i = this.zziC.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziC, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzztc.zza(localObject[j]);
          this.zziC = ((zzaf.zzb[])localObject);
          break;
        case 50: 
          j = zztn.zzc(paramzztc, 50);
          if (this.zziD == null) {}
          for (i = 0;; i = this.zziD.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziD, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzztc.zza(localObject[j]);
          this.zziD = ((zzaf.zzb[])localObject);
          break;
        case 58: 
          j = zztn.zzc(paramzztc, 58);
          if (this.zziE == null) {}
          for (i = 0;; i = this.zziE.length)
          {
            localObject = new zzaf.zzg[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziE, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzg();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzg();
          paramzztc.zza(localObject[j]);
          this.zziE = ((zzaf.zzg[])localObject);
          break;
        case 74: 
          this.zziF = paramzztc.readString();
          break;
        case 82: 
          this.zziG = paramzztc.readString();
          break;
        case 98: 
          this.zziH = paramzztc.readString();
          break;
        case 106: 
          this.version = paramzztc.readString();
          break;
        case 114: 
          if (this.zziI == null) {
            this.zziI = new zzaf.zza();
          }
          paramzztc.zza(this.zziI);
          break;
        case 125: 
          this.zziJ = paramzztc.readFloat();
          break;
        case 130: 
          j = zztn.zzc(paramzztc, 130);
          if (this.zziL == null) {}
          for (i = 0;; i = this.zziL.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziL, 0, localObject, 0, i);
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
          this.zziL = ((String[])localObject);
          break;
        case 136: 
          this.zziM = paramzztc.zzHl();
          break;
        case 144: 
          this.zziK = paramzztc.zzHm();
          break;
        case 154: 
          j = zztn.zzc(paramzztc, 154);
          if (this.zzix == null) {}
          for (i = 0;; i = this.zzix.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzix, 0, localObject, 0, i);
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
          this.zzix = ((String[])localObject);
        }
      }
    }
    
    protected int zzz()
    {
      int i2 = 0;
      int i1 = super.zzz();
      int i;
      int k;
      Object localObject;
      int n;
      int m;
      if ((this.zziy != null) && (this.zziy.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.zziy.length; k = m)
        {
          localObject = this.zziy[i];
          n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + zztd.zzga((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      for (int j = i1 + j + k * 1;; j = i1)
      {
        i = j;
        if (this.zziz != null)
        {
          i = j;
          if (this.zziz.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zziz.length)
            {
              localObject = this.zziz[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(2, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zziA != null)
        {
          j = i;
          if (this.zziA.length > 0)
          {
            j = 0;
            while (j < this.zziA.length)
            {
              localObject = this.zziA[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(3, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zziB != null)
        {
          i = j;
          if (this.zziB.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zziB.length)
            {
              localObject = this.zziB[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(4, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zziC != null)
        {
          j = i;
          if (this.zziC.length > 0)
          {
            j = 0;
            while (j < this.zziC.length)
            {
              localObject = this.zziC[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(5, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zziD != null)
        {
          i = j;
          if (this.zziD.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zziD.length)
            {
              localObject = this.zziD[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(6, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zziE != null)
        {
          j = i;
          if (this.zziE.length > 0)
          {
            j = 0;
            while (j < this.zziE.length)
            {
              localObject = this.zziE[j];
              k = i;
              if (localObject != null) {
                k = i + zztd.zzc(7, (zztk)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (!this.zziF.equals("")) {
          i = j + zztd.zzp(9, this.zziF);
        }
        j = i;
        if (!this.zziG.equals("")) {
          j = i + zztd.zzp(10, this.zziG);
        }
        i = j;
        if (!this.zziH.equals("0")) {
          i = j + zztd.zzp(12, this.zziH);
        }
        j = i;
        if (!this.version.equals("")) {
          j = i + zztd.zzp(13, this.version);
        }
        k = j;
        if (this.zziI != null) {
          k = j + zztd.zzc(14, this.zziI);
        }
        i = k;
        if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(0.0F)) {
          i = k + zztd.zzc(15, this.zziJ);
        }
        j = i;
        if (this.zziL != null)
        {
          j = i;
          if (this.zziL.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.zziL.length; m = n)
            {
              localObject = this.zziL[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zztd.zzga((String)localObject);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 2;
          }
        }
        k = j;
        if (this.zziM != 0) {
          k = j + zztd.zzI(17, this.zziM);
        }
        i = k;
        if (this.zziK) {
          i = k + zztd.zzc(18, this.zziK);
        }
        j = i;
        if (this.zzix != null)
        {
          j = i;
          if (this.zzix.length > 0)
          {
            k = 0;
            m = 0;
            j = i2;
            while (j < this.zzix.length)
            {
              localObject = this.zzix[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zztd.zzga((String)localObject);
              }
              j += 1;
              k = i1;
              m = n;
            }
            j = i + k + m * 2;
          }
        }
        return j;
      }
    }
  }
  
  public static final class zzg
    extends zzte<zzg>
  {
    private static volatile zzg[] zziN;
    public int[] zziO;
    public int[] zziP;
    public int[] zziQ;
    public int[] zziR;
    public int[] zziS;
    public int[] zziT;
    public int[] zziU;
    public int[] zziV;
    public int[] zziW;
    public int[] zziX;
    
    public zzg()
    {
      zzL();
    }
    
    public static zzg[] zzK()
    {
      if (zziN == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zziN == null) {
          zziN = new zzg[0];
        }
        return zziN;
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
                            do
                            {
                              return bool1;
                              bool1 = bool2;
                            } while (!(paramObject instanceof zzg));
                            paramObject = (zzg)paramObject;
                            bool1 = bool2;
                          } while (!zzti.equals(this.zziO, ((zzg)paramObject).zziO));
                          bool1 = bool2;
                        } while (!zzti.equals(this.zziP, ((zzg)paramObject).zziP));
                        bool1 = bool2;
                      } while (!zzti.equals(this.zziQ, ((zzg)paramObject).zziQ));
                      bool1 = bool2;
                    } while (!zzti.equals(this.zziR, ((zzg)paramObject).zziR));
                    bool1 = bool2;
                  } while (!zzti.equals(this.zziS, ((zzg)paramObject).zziS));
                  bool1 = bool2;
                } while (!zzti.equals(this.zziT, ((zzg)paramObject).zziT));
                bool1 = bool2;
              } while (!zzti.equals(this.zziU, ((zzg)paramObject).zziU));
              bool1 = bool2;
            } while (!zzti.equals(this.zziV, ((zzg)paramObject).zziV));
            bool1 = bool2;
          } while (!zzti.equals(this.zziW, ((zzg)paramObject).zziW));
          bool1 = bool2;
        } while (!zzti.equals(this.zziX, ((zzg)paramObject).zziX));
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label223;
        }
        if (((zzg)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzg)paramObject).zzbpQ.isEmpty());
      return true;
      label223:
      return this.zzbpQ.equals(((zzg)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzti.hashCode(this.zziO);
      int m = zzti.hashCode(this.zziP);
      int n = zzti.hashCode(this.zziQ);
      int i1 = zzti.hashCode(this.zziR);
      int i2 = zzti.hashCode(this.zziS);
      int i3 = zzti.hashCode(this.zziT);
      int i4 = zzti.hashCode(this.zziU);
      int i5 = zzti.hashCode(this.zziV);
      int i6 = zzti.hashCode(this.zziW);
      int i7 = zzti.hashCode(this.zziX);
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + (((((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zziO != null) && (this.zziO.length > 0))
      {
        i = 0;
        while (i < this.zziO.length)
        {
          paramzztd.zzG(1, this.zziO[i]);
          i += 1;
        }
      }
      if ((this.zziP != null) && (this.zziP.length > 0))
      {
        i = 0;
        while (i < this.zziP.length)
        {
          paramzztd.zzG(2, this.zziP[i]);
          i += 1;
        }
      }
      if ((this.zziQ != null) && (this.zziQ.length > 0))
      {
        i = 0;
        while (i < this.zziQ.length)
        {
          paramzztd.zzG(3, this.zziQ[i]);
          i += 1;
        }
      }
      if ((this.zziR != null) && (this.zziR.length > 0))
      {
        i = 0;
        while (i < this.zziR.length)
        {
          paramzztd.zzG(4, this.zziR[i]);
          i += 1;
        }
      }
      if ((this.zziS != null) && (this.zziS.length > 0))
      {
        i = 0;
        while (i < this.zziS.length)
        {
          paramzztd.zzG(5, this.zziS[i]);
          i += 1;
        }
      }
      if ((this.zziT != null) && (this.zziT.length > 0))
      {
        i = 0;
        while (i < this.zziT.length)
        {
          paramzztd.zzG(6, this.zziT[i]);
          i += 1;
        }
      }
      if ((this.zziU != null) && (this.zziU.length > 0))
      {
        i = 0;
        while (i < this.zziU.length)
        {
          paramzztd.zzG(7, this.zziU[i]);
          i += 1;
        }
      }
      if ((this.zziV != null) && (this.zziV.length > 0))
      {
        i = 0;
        while (i < this.zziV.length)
        {
          paramzztd.zzG(8, this.zziV[i]);
          i += 1;
        }
      }
      if ((this.zziW != null) && (this.zziW.length > 0))
      {
        i = 0;
        while (i < this.zziW.length)
        {
          paramzztd.zzG(9, this.zziW[i]);
          i += 1;
        }
      }
      if ((this.zziX != null) && (this.zziX.length > 0))
      {
        i = j;
        while (i < this.zziX.length)
        {
          paramzztd.zzG(10, this.zziX[i]);
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zzg zzL()
    {
      this.zziO = zztn.zzboD;
      this.zziP = zztn.zzboD;
      this.zziQ = zztn.zzboD;
      this.zziR = zztn.zzboD;
      this.zziS = zztn.zzboD;
      this.zziT = zztn.zzboD;
      this.zziU = zztn.zzboD;
      this.zziV = zztn.zzboD;
      this.zziW = zztn.zzboD;
      this.zziX = zztn.zzboD;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzg zzg(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zztn.zzc(paramzztc, 8);
          if (this.zziO == null) {}
          for (i = 0;; i = this.zziO.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziO, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziO = arrayOfInt;
          break;
        case 10: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziO == null) {}
          for (i = 0;; i = this.zziO.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziO, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziO = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 16: 
          j = zztn.zzc(paramzztc, 16);
          if (this.zziP == null) {}
          for (i = 0;; i = this.zziP.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziP, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziP = arrayOfInt;
          break;
        case 18: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziP == null) {}
          for (i = 0;; i = this.zziP.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziP, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziP = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 24: 
          j = zztn.zzc(paramzztc, 24);
          if (this.zziQ == null) {}
          for (i = 0;; i = this.zziQ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziQ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziQ = arrayOfInt;
          break;
        case 26: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziQ == null) {}
          for (i = 0;; i = this.zziQ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziQ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziQ = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 32: 
          j = zztn.zzc(paramzztc, 32);
          if (this.zziR == null) {}
          for (i = 0;; i = this.zziR.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziR, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziR = arrayOfInt;
          break;
        case 34: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziR == null) {}
          for (i = 0;; i = this.zziR.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziR, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziR = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 40: 
          j = zztn.zzc(paramzztc, 40);
          if (this.zziS == null) {}
          for (i = 0;; i = this.zziS.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziS, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziS = arrayOfInt;
          break;
        case 42: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziS == null) {}
          for (i = 0;; i = this.zziS.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziS, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziS = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 48: 
          j = zztn.zzc(paramzztc, 48);
          if (this.zziT == null) {}
          for (i = 0;; i = this.zziT.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziT, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziT = arrayOfInt;
          break;
        case 50: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziT == null) {}
          for (i = 0;; i = this.zziT.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziT, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziT = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 56: 
          j = zztn.zzc(paramzztc, 56);
          if (this.zziU == null) {}
          for (i = 0;; i = this.zziU.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziU, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziU = arrayOfInt;
          break;
        case 58: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziU == null) {}
          for (i = 0;; i = this.zziU.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziU, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziU = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 64: 
          j = zztn.zzc(paramzztc, 64);
          if (this.zziV == null) {}
          for (i = 0;; i = this.zziV.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziV, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziV = arrayOfInt;
          break;
        case 66: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziV == null) {}
          for (i = 0;; i = this.zziV.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziV, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziV = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 72: 
          j = zztn.zzc(paramzztc, 72);
          if (this.zziW == null) {}
          for (i = 0;; i = this.zziW.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziW, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziW = arrayOfInt;
          break;
        case 74: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziW == null) {}
          for (i = 0;; i = this.zziW.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziW, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziW = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 80: 
          j = zztn.zzc(paramzztc, 80);
          if (this.zziX == null) {}
          for (i = 0;; i = this.zziX.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziX, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zziX = arrayOfInt;
          break;
        case 82: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zziX == null) {}
          for (i = 0;; i = this.zziX.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziX, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zziX = arrayOfInt;
          paramzztc.zzmo(k);
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int k = super.zzz();
      int i;
      if ((this.zziO != null) && (this.zziO.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zziO.length)
        {
          j += zztd.zzmu(this.zziO[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zziO.length * 1;; j = k)
      {
        i = j;
        if (this.zziP != null)
        {
          i = j;
          if (this.zziP.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziP.length)
            {
              k += zztd.zzmu(this.zziP[i]);
              i += 1;
            }
            i = j + k + this.zziP.length * 1;
          }
        }
        j = i;
        if (this.zziQ != null)
        {
          j = i;
          if (this.zziQ.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziQ.length)
            {
              k += zztd.zzmu(this.zziQ[j]);
              j += 1;
            }
            j = i + k + this.zziQ.length * 1;
          }
        }
        i = j;
        if (this.zziR != null)
        {
          i = j;
          if (this.zziR.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziR.length)
            {
              k += zztd.zzmu(this.zziR[i]);
              i += 1;
            }
            i = j + k + this.zziR.length * 1;
          }
        }
        j = i;
        if (this.zziS != null)
        {
          j = i;
          if (this.zziS.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziS.length)
            {
              k += zztd.zzmu(this.zziS[j]);
              j += 1;
            }
            j = i + k + this.zziS.length * 1;
          }
        }
        i = j;
        if (this.zziT != null)
        {
          i = j;
          if (this.zziT.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziT.length)
            {
              k += zztd.zzmu(this.zziT[i]);
              i += 1;
            }
            i = j + k + this.zziT.length * 1;
          }
        }
        j = i;
        if (this.zziU != null)
        {
          j = i;
          if (this.zziU.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziU.length)
            {
              k += zztd.zzmu(this.zziU[j]);
              j += 1;
            }
            j = i + k + this.zziU.length * 1;
          }
        }
        i = j;
        if (this.zziV != null)
        {
          i = j;
          if (this.zziV.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziV.length)
            {
              k += zztd.zzmu(this.zziV[i]);
              i += 1;
            }
            i = j + k + this.zziV.length * 1;
          }
        }
        j = i;
        if (this.zziW != null)
        {
          j = i;
          if (this.zziW.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziW.length)
            {
              k += zztd.zzmu(this.zziW[j]);
              j += 1;
            }
            j = i + k + this.zziW.length * 1;
          }
        }
        i = j;
        if (this.zziX != null)
        {
          i = j;
          if (this.zziX.length > 0)
          {
            k = 0;
            i = m;
            while (i < this.zziX.length)
            {
              k += zztd.zzmu(this.zziX[i]);
              i += 1;
            }
            i = j + k + this.zziX.length * 1;
          }
        }
        return i;
      }
    }
  }
  
  public static final class zzh
    extends zzte<zzh>
  {
    public static final zztf<zzag.zza, zzh> zziY = zztf.zza(11, zzh.class, 810L);
    private static final zzh[] zziZ = new zzh[0];
    public int[] zzja;
    public int[] zzjb;
    public int[] zzjc;
    public int zzjd;
    public int[] zzje;
    public int zzjf;
    public int zzjg;
    
    public zzh()
    {
      zzM();
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
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool2;
                      } while (!(paramObject instanceof zzh));
                      paramObject = (zzh)paramObject;
                      bool1 = bool2;
                    } while (!zzti.equals(this.zzja, ((zzh)paramObject).zzja));
                    bool1 = bool2;
                  } while (!zzti.equals(this.zzjb, ((zzh)paramObject).zzjb));
                  bool1 = bool2;
                } while (!zzti.equals(this.zzjc, ((zzh)paramObject).zzjc));
                bool1 = bool2;
              } while (this.zzjd != ((zzh)paramObject).zzjd);
              bool1 = bool2;
            } while (!zzti.equals(this.zzje, ((zzh)paramObject).zzje));
            bool1 = bool2;
          } while (this.zzjf != ((zzh)paramObject).zzjf);
          bool1 = bool2;
        } while (this.zzjg != ((zzh)paramObject).zzjg);
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label166;
        }
        if (((zzh)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzh)paramObject).zzbpQ.isEmpty());
      return true;
      label166:
      return this.zzbpQ.equals(((zzh)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzti.hashCode(this.zzja);
      int m = zzti.hashCode(this.zzjb);
      int n = zzti.hashCode(this.zzjc);
      int i1 = this.zzjd;
      int i2 = zzti.hashCode(this.zzje);
      int i3 = this.zzjf;
      int i4 = this.zzjg;
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + ((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zzja != null) && (this.zzja.length > 0))
      {
        i = 0;
        while (i < this.zzja.length)
        {
          paramzztd.zzG(1, this.zzja[i]);
          i += 1;
        }
      }
      if ((this.zzjb != null) && (this.zzjb.length > 0))
      {
        i = 0;
        while (i < this.zzjb.length)
        {
          paramzztd.zzG(2, this.zzjb[i]);
          i += 1;
        }
      }
      if ((this.zzjc != null) && (this.zzjc.length > 0))
      {
        i = 0;
        while (i < this.zzjc.length)
        {
          paramzztd.zzG(3, this.zzjc[i]);
          i += 1;
        }
      }
      if (this.zzjd != 0) {
        paramzztd.zzG(4, this.zzjd);
      }
      if ((this.zzje != null) && (this.zzje.length > 0))
      {
        i = j;
        while (i < this.zzje.length)
        {
          paramzztd.zzG(5, this.zzje[i]);
          i += 1;
        }
      }
      if (this.zzjf != 0) {
        paramzztd.zzG(6, this.zzjf);
      }
      if (this.zzjg != 0) {
        paramzztd.zzG(7, this.zzjg);
      }
      super.writeTo(paramzztd);
    }
    
    public zzh zzM()
    {
      this.zzja = zztn.zzboD;
      this.zzjb = zztn.zzboD;
      this.zzjc = zztn.zzboD;
      this.zzjd = 0;
      this.zzje = zztn.zzboD;
      this.zzjf = 0;
      this.zzjg = 0;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzh zzh(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zztn.zzc(paramzztc, 8);
          if (this.zzja == null) {}
          for (i = 0;; i = this.zzja.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzja, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zzja = arrayOfInt;
          break;
        case 10: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzja == null) {}
          for (i = 0;; i = this.zzja.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzja, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzja = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 16: 
          j = zztn.zzc(paramzztc, 16);
          if (this.zzjb == null) {}
          for (i = 0;; i = this.zzjb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjb, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zzjb = arrayOfInt;
          break;
        case 18: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzjb == null) {}
          for (i = 0;; i = this.zzjb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjb, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzjb = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 24: 
          j = zztn.zzc(paramzztc, 24);
          if (this.zzjc == null) {}
          for (i = 0;; i = this.zzjc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjc, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zzjc = arrayOfInt;
          break;
        case 26: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzjc == null) {}
          for (i = 0;; i = this.zzjc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjc, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzjc = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 32: 
          this.zzjd = paramzztc.zzHl();
          break;
        case 40: 
          j = zztn.zzc(paramzztc, 40);
          if (this.zzje == null) {}
          for (i = 0;; i = this.zzje.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzje, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzztc.zzHl();
          this.zzje = arrayOfInt;
          break;
        case 42: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzje == null) {}
          for (i = 0;; i = this.zzje.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzje, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzje = arrayOfInt;
          paramzztc.zzmo(k);
          break;
        case 48: 
          this.zzjf = paramzztc.zzHl();
          break;
        case 56: 
          this.zzjg = paramzztc.zzHl();
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int k = super.zzz();
      int i;
      if ((this.zzja != null) && (this.zzja.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zzja.length)
        {
          j += zztd.zzmu(this.zzja[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zzja.length * 1;; j = k)
      {
        i = j;
        if (this.zzjb != null)
        {
          i = j;
          if (this.zzjb.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzjb.length)
            {
              k += zztd.zzmu(this.zzjb[i]);
              i += 1;
            }
            i = j + k + this.zzjb.length * 1;
          }
        }
        j = i;
        if (this.zzjc != null)
        {
          j = i;
          if (this.zzjc.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzjc.length)
            {
              k += zztd.zzmu(this.zzjc[j]);
              j += 1;
            }
            j = i + k + this.zzjc.length * 1;
          }
        }
        i = j;
        if (this.zzjd != 0) {
          i = j + zztd.zzI(4, this.zzjd);
        }
        j = i;
        if (this.zzje != null)
        {
          j = i;
          if (this.zzje.length > 0)
          {
            k = 0;
            j = m;
            while (j < this.zzje.length)
            {
              k += zztd.zzmu(this.zzje[j]);
              j += 1;
            }
            j = i + k + this.zzje.length * 1;
          }
        }
        i = j;
        if (this.zzjf != 0) {
          i = j + zztd.zzI(6, this.zzjf);
        }
        j = i;
        if (this.zzjg != 0) {
          j = i + zztd.zzI(7, this.zzjg);
        }
        return j;
      }
    }
  }
  
  public static final class zzi
    extends zzte<zzi>
  {
    private static volatile zzi[] zzjh;
    public String name;
    public zzag.zza zzji;
    public zzaf.zzd zzjj;
    
    public zzi()
    {
      zzO();
    }
    
    public static zzi[] zzN()
    {
      if (zzjh == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzjh == null) {
          zzjh = new zzi[0];
        }
        return zzjh;
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
      label57:
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
            } while (!(paramObject instanceof zzi));
            paramObject = (zzi)paramObject;
            if (this.name != null) {
              break;
            }
            bool1 = bool2;
          } while (((zzi)paramObject).name != null);
          if (this.zzji != null) {
            break label127;
          }
          bool1 = bool2;
        } while (((zzi)paramObject).zzji != null);
        if (this.zzjj != null) {
          break label143;
        }
        bool1 = bool2;
      } while (((zzi)paramObject).zzjj != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zzi)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zzi)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.name.equals(((zzi)paramObject).name)) {
            break label41;
          }
          return false;
          label127:
          if (this.zzji.equals(((zzi)paramObject).zzji)) {
            break label57;
          }
          return false;
          label143:
          if (!this.zzjj.equals(((zzi)paramObject).zzjj)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zzi)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzji != null) {
          break label106;
        }
        j = 0;
        if (this.zzjj != null) {
          break label117;
        }
        k = 0;
        label42:
        m = n;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label128;
          }
        }
      }
      label106:
      label117:
      label128:
      for (int m = n;; m = this.zzbpQ.hashCode())
      {
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        j = this.zzji.hashCode();
        break label33;
        k = this.zzjj.hashCode();
        break label42;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramzztd.zzb(1, this.name);
      }
      if (this.zzji != null) {
        paramzztd.zza(2, this.zzji);
      }
      if (this.zzjj != null) {
        paramzztd.zza(3, this.zzjj);
      }
      super.writeTo(paramzztd);
    }
    
    public zzi zzO()
    {
      this.name = "";
      this.zzji = null;
      this.zzjj = null;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzi zzi(zztc paramzztc)
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
          if (this.zzji == null) {
            this.zzji = new zzag.zza();
          }
          paramzztc.zza(this.zzji);
          break;
        case 26: 
          if (this.zzjj == null) {
            this.zzjj = new zzaf.zzd();
          }
          paramzztc.zza(this.zzjj);
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (!this.name.equals("")) {
        i = j + zztd.zzp(1, this.name);
      }
      j = i;
      if (this.zzji != null) {
        j = i + zztd.zzc(2, this.zzji);
      }
      i = j;
      if (this.zzjj != null) {
        i = j + zztd.zzc(3, this.zzjj);
      }
      return i;
    }
  }
  
  public static final class zzj
    extends zzte<zzj>
  {
    public zzaf.zzi[] zzjk;
    public zzaf.zzf zzjl;
    public String zzjm;
    
    public zzj()
    {
      zzP();
    }
    
    public static zzj zzd(byte[] paramArrayOfByte)
      throws zztj
    {
      return (zzj)zztk.mergeFrom(new zzj(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label57:
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
            } while (!(paramObject instanceof zzj));
            paramObject = (zzj)paramObject;
            bool1 = bool2;
          } while (!zzti.equals(this.zzjk, ((zzj)paramObject).zzjk));
          if (this.zzjl != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzj)paramObject).zzjl != null);
        if (this.zzjm != null) {
          break label127;
        }
        bool1 = bool2;
      } while (((zzj)paramObject).zzjm != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zzj)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zzj)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzjl.equals(((zzj)paramObject).zzjl)) {
            break label57;
          }
          return false;
          label127:
          if (!this.zzjm.equals(((zzj)paramObject).zzjm)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zzj)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzti.hashCode(this.zzjk);
      int i;
      int j;
      if (this.zzjl == null)
      {
        i = 0;
        if (this.zzjm != null) {
          break label104;
        }
        j = 0;
        label42:
        k = m;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label115;
          }
        }
      }
      label104:
      label115:
      for (int k = m;; k = this.zzbpQ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzjl.hashCode();
        break;
        j = this.zzjm.hashCode();
        break label42;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if ((this.zzjk != null) && (this.zzjk.length > 0))
      {
        int i = 0;
        while (i < this.zzjk.length)
        {
          zzaf.zzi localzzi = this.zzjk[i];
          if (localzzi != null) {
            paramzztd.zza(1, localzzi);
          }
          i += 1;
        }
      }
      if (this.zzjl != null) {
        paramzztd.zza(2, this.zzjl);
      }
      if (!this.zzjm.equals("")) {
        paramzztd.zzb(3, this.zzjm);
      }
      super.writeTo(paramzztd);
    }
    
    public zzj zzP()
    {
      this.zzjk = zzaf.zzi.zzN();
      this.zzjl = null;
      this.zzjm = "";
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzj zzj(zztc paramzztc)
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
          if (this.zzjk == null) {}
          zzaf.zzi[] arrayOfzzi;
          for (i = 0;; i = this.zzjk.length)
          {
            arrayOfzzi = new zzaf.zzi[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjk, 0, arrayOfzzi, 0, i);
              j = i;
            }
            while (j < arrayOfzzi.length - 1)
            {
              arrayOfzzi[j] = new zzaf.zzi();
              paramzztc.zza(arrayOfzzi[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfzzi[j] = new zzaf.zzi();
          paramzztc.zza(arrayOfzzi[j]);
          this.zzjk = arrayOfzzi;
          break;
        case 18: 
          if (this.zzjl == null) {
            this.zzjl = new zzaf.zzf();
          }
          paramzztc.zza(this.zzjl);
          break;
        case 26: 
          this.zzjm = paramzztc.readString();
        }
      }
    }
    
    protected int zzz()
    {
      int i = super.zzz();
      int j = i;
      if (this.zzjk != null)
      {
        j = i;
        if (this.zzjk.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.zzjk.length) {
              break;
            }
            zzaf.zzi localzzi = this.zzjk[k];
            j = i;
            if (localzzi != null) {
              j = i + zztd.zzc(1, localzzi);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzjl != null) {
        i = j + zztd.zzc(2, this.zzjl);
      }
      j = i;
      if (!this.zzjm.equals("")) {
        j = i + zztd.zzp(3, this.zzjm);
      }
      return j;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */