package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zztp
{
  public static final class zza
    extends zzte<zza>
  {
    public String[] zzbqn;
    public String[] zzbqo;
    public int[] zzbqp;
    public long[] zzbqq;
    
    public zza()
    {
      zzHM();
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
                } while (!(paramObject instanceof zza));
                paramObject = (zza)paramObject;
                bool1 = bool2;
              } while (!zzti.equals(this.zzbqn, ((zza)paramObject).zzbqn));
              bool1 = bool2;
            } while (!zzti.equals(this.zzbqo, ((zza)paramObject).zzbqo));
            bool1 = bool2;
          } while (!zzti.equals(this.zzbqp, ((zza)paramObject).zzbqp));
          bool1 = bool2;
        } while (!zzti.equals(this.zzbqq, ((zza)paramObject).zzbqq));
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label127;
        }
        if (((zza)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbpQ.isEmpty());
      return true;
      label127:
      return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzti.hashCode(this.zzbqn);
      int m = zzti.hashCode(this.zzbqo);
      int n = zzti.hashCode(this.zzbqp);
      int i1 = zzti.hashCode(this.zzbqq);
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + (((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      int i;
      String str;
      if ((this.zzbqn != null) && (this.zzbqn.length > 0))
      {
        i = 0;
        while (i < this.zzbqn.length)
        {
          str = this.zzbqn[i];
          if (str != null) {
            paramzztd.zzb(1, str);
          }
          i += 1;
        }
      }
      if ((this.zzbqo != null) && (this.zzbqo.length > 0))
      {
        i = 0;
        while (i < this.zzbqo.length)
        {
          str = this.zzbqo[i];
          if (str != null) {
            paramzztd.zzb(2, str);
          }
          i += 1;
        }
      }
      if ((this.zzbqp != null) && (this.zzbqp.length > 0))
      {
        i = 0;
        while (i < this.zzbqp.length)
        {
          paramzztd.zzG(3, this.zzbqp[i]);
          i += 1;
        }
      }
      if ((this.zzbqq != null) && (this.zzbqq.length > 0))
      {
        i = j;
        while (i < this.zzbqq.length)
        {
          paramzztd.zzb(4, this.zzbqq[i]);
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzH(zztc paramzztc)
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
          j = zztn.zzc(paramzztc, 10);
          if (this.zzbqn == null) {}
          for (i = 0;; i = this.zzbqn.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqn, 0, localObject, 0, i);
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
          this.zzbqn = ((String[])localObject);
          break;
        case 18: 
          j = zztn.zzc(paramzztc, 18);
          if (this.zzbqo == null) {}
          for (i = 0;; i = this.zzbqo.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqo, 0, localObject, 0, i);
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
          this.zzbqo = ((String[])localObject);
          break;
        case 24: 
          j = zztn.zzc(paramzztc, 24);
          if (this.zzbqp == null) {}
          for (i = 0;; i = this.zzbqp.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqp, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = paramzztc.zzHl();
          this.zzbqp = ((int[])localObject);
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
          if (this.zzbqp == null) {}
          for (i = 0;; i = this.zzbqp.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqp, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzbqp = ((int[])localObject);
          paramzztc.zzmo(k);
          break;
        case 32: 
          j = zztn.zzc(paramzztc, 32);
          if (this.zzbqq == null) {}
          for (i = 0;; i = this.zzbqq.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqq, 0, localObject, 0, i);
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
          this.zzbqq = ((long[])localObject);
          break;
        case 34: 
          k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHk();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzbqq == null) {}
          for (i = 0;; i = this.zzbqq.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqq, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzztc.zzHk();
              j += 1;
            }
          }
          this.zzbqq = ((long[])localObject);
          paramzztc.zzmo(k);
        }
      }
    }
    
    public zza zzHM()
    {
      this.zzbqn = zztn.zzbqg;
      this.zzbqo = zztn.zzbqg;
      this.zzbqp = zztn.zzboD;
      this.zzbqq = zztn.zzboC;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int i2 = 0;
      int i1 = super.zzz();
      int j;
      int k;
      String str;
      int n;
      int m;
      if ((this.zzbqn != null) && (this.zzbqn.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.zzbqn.length; k = m)
        {
          str = this.zzbqn[i];
          n = j;
          m = k;
          if (str != null)
          {
            m = k + 1;
            n = j + zztd.zzga(str);
          }
          i += 1;
          j = n;
        }
      }
      for (int i = i1 + j + k * 1;; i = i1)
      {
        j = i;
        if (this.zzbqo != null)
        {
          j = i;
          if (this.zzbqo.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.zzbqo.length; m = n)
            {
              str = this.zzbqo[j];
              i1 = k;
              n = m;
              if (str != null)
              {
                n = m + 1;
                i1 = k + zztd.zzga(str);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 1;
          }
        }
        i = j;
        if (this.zzbqp != null)
        {
          i = j;
          if (this.zzbqp.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzbqp.length)
            {
              k += zztd.zzmu(this.zzbqp[i]);
              i += 1;
            }
            i = j + k + this.zzbqp.length * 1;
          }
        }
        j = i;
        if (this.zzbqq != null)
        {
          j = i;
          if (this.zzbqq.length > 0)
          {
            k = 0;
            j = i2;
            while (j < this.zzbqq.length)
            {
              k += zztd.zzad(this.zzbqq[j]);
              j += 1;
            }
            j = i + k + this.zzbqq.length * 1;
          }
        }
        return j;
      }
    }
  }
  
  public static final class zzb
    extends zzte<zzb>
  {
    public String version;
    public int zzbqr;
    public String zzbqs;
    
    public zzb()
    {
      zzHN();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
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
          } while (this.zzbqr != ((zzb)paramObject).zzbqr);
          if (this.zzbqs != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzb)paramObject).zzbqs != null);
        if (this.version != null) {
          break label124;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).version != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zzb)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zzb)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzbqs.equals(((zzb)paramObject).zzbqs)) {
            break label54;
          }
          return false;
          label124:
          if (!this.version.equals(((zzb)paramObject).version)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zzb)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = this.zzbqr;
      int i;
      int j;
      if (this.zzbqs == null)
      {
        i = 0;
        if (this.version != null) {
          break label101;
        }
        j = 0;
        label39:
        k = m;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label112;
          }
        }
      }
      label101:
      label112:
      for (int k = m;; k = this.zzbpQ.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzbqs.hashCode();
        break;
        j = this.version.hashCode();
        break label39;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.zzbqr != 0) {
        paramzztd.zzG(1, this.zzbqr);
      }
      if (!this.zzbqs.equals("")) {
        paramzztd.zzb(2, this.zzbqs);
      }
      if (!this.version.equals("")) {
        paramzztd.zzb(3, this.version);
      }
      super.writeTo(paramzztd);
    }
    
    public zzb zzHN()
    {
      this.zzbqr = 0;
      this.zzbqs = "";
      this.version = "";
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzb zzI(zztc paramzztc)
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
          case 0: 
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
          case 18: 
          case 19: 
          case 20: 
          case 21: 
          case 22: 
          case 23: 
          case 24: 
          case 25: 
          case 26: 
            this.zzbqr = i;
          }
          break;
        case 18: 
          this.zzbqs = paramzztc.readString();
          break;
        case 26: 
          this.version = paramzztc.readString();
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.zzbqr != 0) {
        i = j + zztd.zzI(1, this.zzbqr);
      }
      j = i;
      if (!this.zzbqs.equals("")) {
        j = i + zztd.zzp(2, this.zzbqs);
      }
      i = j;
      if (!this.version.equals("")) {
        i = j + zztd.zzp(3, this.version);
      }
      return i;
    }
  }
  
  public static final class zzc
    extends zzte<zzc>
  {
    public byte[] zzbqt;
    public byte[][] zzbqu;
    public boolean zzbqv;
    
    public zzc()
    {
      zzHO();
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
              } while (!(paramObject instanceof zzc));
              paramObject = (zzc)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.zzbqt, ((zzc)paramObject).zzbqt));
            bool1 = bool2;
          } while (!zzti.zza(this.zzbqu, ((zzc)paramObject).zzbqu));
          bool1 = bool2;
        } while (this.zzbqv != ((zzc)paramObject).zzbqv);
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label108;
        }
        if (((zzc)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzc)paramObject).zzbpQ.isEmpty());
      return true;
      label108:
      return this.zzbpQ.equals(((zzc)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int k = getClass().getName().hashCode();
      int m = Arrays.hashCode(this.zzbqt);
      int n = zzti.zza(this.zzbqu);
      int i;
      if (this.zzbqv)
      {
        i = 1231;
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label94;
        }
      }
      label94:
      for (int j = 0;; j = this.zzbpQ.hashCode())
      {
        return j + (i + (((k + 527) * 31 + m) * 31 + n) * 31) * 31;
        i = 1237;
        break;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!Arrays.equals(this.zzbqt, zztn.zzbqi)) {
        paramzztd.zza(1, this.zzbqt);
      }
      if ((this.zzbqu != null) && (this.zzbqu.length > 0))
      {
        int i = 0;
        while (i < this.zzbqu.length)
        {
          byte[] arrayOfByte = this.zzbqu[i];
          if (arrayOfByte != null) {
            paramzztd.zza(2, arrayOfByte);
          }
          i += 1;
        }
      }
      if (this.zzbqv) {
        paramzztd.zzb(3, this.zzbqv);
      }
      super.writeTo(paramzztd);
    }
    
    public zzc zzHO()
    {
      this.zzbqt = zztn.zzbqi;
      this.zzbqu = zztn.zzbqh;
      this.zzbqv = false;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzc zzJ(zztc paramzztc)
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
          this.zzbqt = paramzztc.readBytes();
          break;
        case 18: 
          int j = zztn.zzc(paramzztc, 18);
          if (this.zzbqu == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = this.zzbqu.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqu, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramzztc.readBytes();
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfByte[j] = paramzztc.readBytes();
          this.zzbqu = arrayOfByte;
          break;
        case 24: 
          this.zzbqv = paramzztc.zzHm();
        }
      }
    }
    
    protected int zzz()
    {
      int n = 0;
      int j = super.zzz();
      int i = j;
      if (!Arrays.equals(this.zzbqt, zztn.zzbqi)) {
        i = j + zztd.zzb(1, this.zzbqt);
      }
      j = i;
      if (this.zzbqu != null)
      {
        j = i;
        if (this.zzbqu.length > 0)
        {
          int k = 0;
          int m = 0;
          j = n;
          while (j < this.zzbqu.length)
          {
            byte[] arrayOfByte = this.zzbqu[j];
            int i1 = k;
            n = m;
            if (arrayOfByte != null)
            {
              n = m + 1;
              i1 = k + zztd.zzF(arrayOfByte);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (this.zzbqv) {
        i = j + zztd.zzc(3, this.zzbqv);
      }
      return i;
    }
  }
  
  public static final class zzd
    extends zzte<zzd>
  {
    public String tag;
    public boolean zzbqA;
    public zztp.zze[] zzbqB;
    public zztp.zzb zzbqC;
    public byte[] zzbqD;
    public byte[] zzbqE;
    public byte[] zzbqF;
    public zztp.zza zzbqG;
    public String zzbqH;
    public long zzbqI;
    public zztp.zzc zzbqJ;
    public byte[] zzbqK;
    public int zzbqL;
    public int[] zzbqM;
    public long zzbqw;
    public long zzbqx;
    public long zzbqy;
    public int zzbqz;
    public int zznN;
    
    public zzd()
    {
      zzHP();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label83:
      label154:
      label218:
      label234:
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
                                    } while (this.zzbqw != ((zzd)paramObject).zzbqw);
                                    bool1 = bool2;
                                  } while (this.zzbqx != ((zzd)paramObject).zzbqx);
                                  bool1 = bool2;
                                } while (this.zzbqy != ((zzd)paramObject).zzbqy);
                                if (this.tag != null) {
                                  break;
                                }
                                bool1 = bool2;
                              } while (((zzd)paramObject).tag != null);
                              bool1 = bool2;
                            } while (this.zzbqz != ((zzd)paramObject).zzbqz);
                            bool1 = bool2;
                          } while (this.zznN != ((zzd)paramObject).zznN);
                          bool1 = bool2;
                        } while (this.zzbqA != ((zzd)paramObject).zzbqA);
                        bool1 = bool2;
                      } while (!zzti.equals(this.zzbqB, ((zzd)paramObject).zzbqB));
                      if (this.zzbqC != null) {
                        break label363;
                      }
                      bool1 = bool2;
                    } while (((zzd)paramObject).zzbqC != null);
                    bool1 = bool2;
                  } while (!Arrays.equals(this.zzbqD, ((zzd)paramObject).zzbqD));
                  bool1 = bool2;
                } while (!Arrays.equals(this.zzbqE, ((zzd)paramObject).zzbqE));
                bool1 = bool2;
              } while (!Arrays.equals(this.zzbqF, ((zzd)paramObject).zzbqF));
              if (this.zzbqG != null) {
                break label379;
              }
              bool1 = bool2;
            } while (((zzd)paramObject).zzbqG != null);
            if (this.zzbqH != null) {
              break label395;
            }
            bool1 = bool2;
          } while (((zzd)paramObject).zzbqH != null);
          bool1 = bool2;
        } while (this.zzbqI != ((zzd)paramObject).zzbqI);
        if (this.zzbqJ != null) {
          break label411;
        }
        bool1 = bool2;
      } while (((zzd)paramObject).zzbqJ != null);
      label363:
      label379:
      label395:
      label411:
      while (this.zzbqJ.equals(((zzd)paramObject).zzbqJ))
      {
        bool1 = bool2;
        if (!Arrays.equals(this.zzbqK, ((zzd)paramObject).zzbqK)) {
          break;
        }
        bool1 = bool2;
        if (this.zzbqL != ((zzd)paramObject).zzbqL) {
          break;
        }
        bool1 = bool2;
        if (!zzti.equals(this.zzbqM, ((zzd)paramObject).zzbqM)) {
          break;
        }
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label427;
        }
        if (((zzd)paramObject).zzbpQ != null)
        {
          bool1 = bool2;
          if (!((zzd)paramObject).zzbpQ.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.tag.equals(((zzd)paramObject).tag)) {
          break label83;
        }
        return false;
        if (this.zzbqC.equals(((zzd)paramObject).zzbqC)) {
          break label154;
        }
        return false;
        if (this.zzbqG.equals(((zzd)paramObject).zzbqG)) {
          break label218;
        }
        return false;
        if (this.zzbqH.equals(((zzd)paramObject).zzbqH)) {
          break label234;
        }
        return false;
      }
      return false;
      label427:
      return this.zzbpQ.equals(((zzd)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i5 = (int)(this.zzbqw ^ this.zzbqw >>> 32);
      int i6 = (int)(this.zzbqx ^ this.zzbqx >>> 32);
      int i7 = (int)(this.zzbqy ^ this.zzbqy >>> 32);
      int i;
      int i8;
      int i9;
      int j;
      label92:
      int i10;
      int k;
      label110:
      int i11;
      int i12;
      int i13;
      int m;
      label147:
      int n;
      label157:
      int i14;
      int i1;
      label182:
      int i15;
      int i16;
      int i17;
      if (this.tag == null)
      {
        i = 0;
        i8 = this.zzbqz;
        i9 = this.zznN;
        if (!this.zzbqA) {
          break label366;
        }
        j = 1231;
        i10 = zzti.hashCode(this.zzbqB);
        if (this.zzbqC != null) {
          break label373;
        }
        k = 0;
        i11 = Arrays.hashCode(this.zzbqD);
        i12 = Arrays.hashCode(this.zzbqE);
        i13 = Arrays.hashCode(this.zzbqF);
        if (this.zzbqG != null) {
          break label384;
        }
        m = 0;
        if (this.zzbqH != null) {
          break label396;
        }
        n = 0;
        i14 = (int)(this.zzbqI ^ this.zzbqI >>> 32);
        if (this.zzbqJ != null) {
          break label408;
        }
        i1 = 0;
        i15 = Arrays.hashCode(this.zzbqK);
        i16 = this.zzbqL;
        i17 = zzti.hashCode(this.zzbqM);
        i2 = i3;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label420;
          }
        }
      }
      label366:
      label373:
      label384:
      label396:
      label408:
      label420:
      for (int i2 = i3;; i2 = this.zzbpQ.hashCode())
      {
        return ((((i1 + ((n + (m + ((((k + ((j + (((i + ((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31 + i9) * 31) * 31 + i10) * 31) * 31 + i11) * 31 + i12) * 31 + i13) * 31) * 31) * 31 + i14) * 31) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i2;
        i = this.tag.hashCode();
        break;
        j = 1237;
        break label92;
        k = this.zzbqC.hashCode();
        break label110;
        m = this.zzbqG.hashCode();
        break label147;
        n = this.zzbqH.hashCode();
        break label157;
        i1 = this.zzbqJ.hashCode();
        break label182;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      if (this.zzbqw != 0L) {
        paramzztd.zzb(1, this.zzbqw);
      }
      if (!this.tag.equals("")) {
        paramzztd.zzb(2, this.tag);
      }
      int i;
      if ((this.zzbqB != null) && (this.zzbqB.length > 0))
      {
        i = 0;
        while (i < this.zzbqB.length)
        {
          zztp.zze localzze = this.zzbqB[i];
          if (localzze != null) {
            paramzztd.zza(3, localzze);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(this.zzbqD, zztn.zzbqi)) {
        paramzztd.zza(6, this.zzbqD);
      }
      if (this.zzbqG != null) {
        paramzztd.zza(7, this.zzbqG);
      }
      if (!Arrays.equals(this.zzbqE, zztn.zzbqi)) {
        paramzztd.zza(8, this.zzbqE);
      }
      if (this.zzbqC != null) {
        paramzztd.zza(9, this.zzbqC);
      }
      if (this.zzbqA) {
        paramzztd.zzb(10, this.zzbqA);
      }
      if (this.zzbqz != 0) {
        paramzztd.zzG(11, this.zzbqz);
      }
      if (this.zznN != 0) {
        paramzztd.zzG(12, this.zznN);
      }
      if (!Arrays.equals(this.zzbqF, zztn.zzbqi)) {
        paramzztd.zza(13, this.zzbqF);
      }
      if (!this.zzbqH.equals("")) {
        paramzztd.zzb(14, this.zzbqH);
      }
      if (this.zzbqI != 180000L) {
        paramzztd.zzc(15, this.zzbqI);
      }
      if (this.zzbqJ != null) {
        paramzztd.zza(16, this.zzbqJ);
      }
      if (this.zzbqx != 0L) {
        paramzztd.zzb(17, this.zzbqx);
      }
      if (!Arrays.equals(this.zzbqK, zztn.zzbqi)) {
        paramzztd.zza(18, this.zzbqK);
      }
      if (this.zzbqL != 0) {
        paramzztd.zzG(19, this.zzbqL);
      }
      if ((this.zzbqM != null) && (this.zzbqM.length > 0))
      {
        i = j;
        while (i < this.zzbqM.length)
        {
          paramzztd.zzG(20, this.zzbqM[i]);
          i += 1;
        }
      }
      if (this.zzbqy != 0L) {
        paramzztd.zzb(21, this.zzbqy);
      }
      super.writeTo(paramzztd);
    }
    
    public zzd zzHP()
    {
      this.zzbqw = 0L;
      this.zzbqx = 0L;
      this.zzbqy = 0L;
      this.tag = "";
      this.zzbqz = 0;
      this.zznN = 0;
      this.zzbqA = false;
      this.zzbqB = zztp.zze.zzHQ();
      this.zzbqC = null;
      this.zzbqD = zztn.zzbqi;
      this.zzbqE = zztn.zzbqi;
      this.zzbqF = zztn.zzbqi;
      this.zzbqG = null;
      this.zzbqH = "";
      this.zzbqI = 180000L;
      this.zzbqJ = null;
      this.zzbqK = zztn.zzbqi;
      this.zzbqL = 0;
      this.zzbqM = zztn.zzboD;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzd zzK(zztc paramzztc)
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
        case 8: 
          this.zzbqw = paramzztc.zzHk();
          break;
        case 18: 
          this.tag = paramzztc.readString();
          break;
        case 26: 
          j = zztn.zzc(paramzztc, 26);
          if (this.zzbqB == null) {}
          for (i = 0;; i = this.zzbqB.length)
          {
            localObject = new zztp.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqB, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zztp.zze();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zztp.zze();
          paramzztc.zza(localObject[j]);
          this.zzbqB = ((zztp.zze[])localObject);
          break;
        case 50: 
          this.zzbqD = paramzztc.readBytes();
          break;
        case 58: 
          if (this.zzbqG == null) {
            this.zzbqG = new zztp.zza();
          }
          paramzztc.zza(this.zzbqG);
          break;
        case 66: 
          this.zzbqE = paramzztc.readBytes();
          break;
        case 74: 
          if (this.zzbqC == null) {
            this.zzbqC = new zztp.zzb();
          }
          paramzztc.zza(this.zzbqC);
          break;
        case 80: 
          this.zzbqA = paramzztc.zzHm();
          break;
        case 88: 
          this.zzbqz = paramzztc.zzHl();
          break;
        case 96: 
          this.zznN = paramzztc.zzHl();
          break;
        case 106: 
          this.zzbqF = paramzztc.readBytes();
          break;
        case 114: 
          this.zzbqH = paramzztc.readString();
          break;
        case 120: 
          this.zzbqI = paramzztc.zzHo();
          break;
        case 130: 
          if (this.zzbqJ == null) {
            this.zzbqJ = new zztp.zzc();
          }
          paramzztc.zza(this.zzbqJ);
          break;
        case 136: 
          this.zzbqx = paramzztc.zzHk();
          break;
        case 146: 
          this.zzbqK = paramzztc.readBytes();
          break;
        case 152: 
          i = paramzztc.zzHl();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            this.zzbqL = i;
          }
          break;
        case 160: 
          j = zztn.zzc(paramzztc, 160);
          if (this.zzbqM == null) {}
          for (i = 0;; i = this.zzbqM.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqM, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzztc.zzHl();
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = paramzztc.zzHl();
          this.zzbqM = ((int[])localObject);
          break;
        case 162: 
          int k = paramzztc.zzmn(paramzztc.zzHp());
          i = paramzztc.getPosition();
          j = 0;
          while (paramzztc.zzHu() > 0)
          {
            paramzztc.zzHl();
            j += 1;
          }
          paramzztc.zzmp(i);
          if (this.zzbqM == null) {}
          for (i = 0;; i = this.zzbqM.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbqM, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzztc.zzHl();
              j += 1;
            }
          }
          this.zzbqM = ((int[])localObject);
          paramzztc.zzmo(k);
          break;
        case 168: 
          this.zzbqy = paramzztc.zzHk();
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int i = super.zzz();
      int j = i;
      if (this.zzbqw != 0L) {
        j = i + zztd.zzd(1, this.zzbqw);
      }
      i = j;
      if (!this.tag.equals("")) {
        i = j + zztd.zzp(2, this.tag);
      }
      j = i;
      if (this.zzbqB != null)
      {
        j = i;
        if (this.zzbqB.length > 0)
        {
          j = 0;
          while (j < this.zzbqB.length)
          {
            zztp.zze localzze = this.zzbqB[j];
            k = i;
            if (localzze != null) {
              k = i + zztd.zzc(3, localzze);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(this.zzbqD, zztn.zzbqi)) {
        i = j + zztd.zzb(6, this.zzbqD);
      }
      j = i;
      if (this.zzbqG != null) {
        j = i + zztd.zzc(7, this.zzbqG);
      }
      i = j;
      if (!Arrays.equals(this.zzbqE, zztn.zzbqi)) {
        i = j + zztd.zzb(8, this.zzbqE);
      }
      j = i;
      if (this.zzbqC != null) {
        j = i + zztd.zzc(9, this.zzbqC);
      }
      i = j;
      if (this.zzbqA) {
        i = j + zztd.zzc(10, this.zzbqA);
      }
      j = i;
      if (this.zzbqz != 0) {
        j = i + zztd.zzI(11, this.zzbqz);
      }
      i = j;
      if (this.zznN != 0) {
        i = j + zztd.zzI(12, this.zznN);
      }
      j = i;
      if (!Arrays.equals(this.zzbqF, zztn.zzbqi)) {
        j = i + zztd.zzb(13, this.zzbqF);
      }
      i = j;
      if (!this.zzbqH.equals("")) {
        i = j + zztd.zzp(14, this.zzbqH);
      }
      j = i;
      if (this.zzbqI != 180000L) {
        j = i + zztd.zze(15, this.zzbqI);
      }
      i = j;
      if (this.zzbqJ != null) {
        i = j + zztd.zzc(16, this.zzbqJ);
      }
      j = i;
      if (this.zzbqx != 0L) {
        j = i + zztd.zzd(17, this.zzbqx);
      }
      int k = j;
      if (!Arrays.equals(this.zzbqK, zztn.zzbqi)) {
        k = j + zztd.zzb(18, this.zzbqK);
      }
      i = k;
      if (this.zzbqL != 0) {
        i = k + zztd.zzI(19, this.zzbqL);
      }
      j = i;
      if (this.zzbqM != null)
      {
        j = i;
        if (this.zzbqM.length > 0)
        {
          k = 0;
          j = m;
          while (j < this.zzbqM.length)
          {
            k += zztd.zzmu(this.zzbqM[j]);
            j += 1;
          }
          j = i + k + this.zzbqM.length * 2;
        }
      }
      i = j;
      if (this.zzbqy != 0L) {
        i = j + zztd.zzd(21, this.zzbqy);
      }
      return i;
    }
  }
  
  public static final class zze
    extends zzte<zze>
  {
    private static volatile zze[] zzbqN;
    public String key;
    public String value;
    
    public zze()
    {
      zzHR();
    }
    
    public static zze[] zzHQ()
    {
      if (zzbqN == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzbqN == null) {
          zzbqN = new zze[0];
        }
        return zzbqN;
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
          } while (!(paramObject instanceof zze));
          paramObject = (zze)paramObject;
          if (this.key != null) {
            break;
          }
          bool1 = bool2;
        } while (((zze)paramObject).key != null);
        if (this.value != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zze)paramObject).value != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zze)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zze)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.key.equals(((zze)paramObject).key)) {
            break label41;
          }
          return false;
          label111:
          if (!this.value.equals(((zze)paramObject).value)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zze)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (this.key == null)
      {
        i = 0;
        if (this.value != null) {
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
        i = this.key.hashCode();
        break;
        j = this.value.hashCode();
        break label33;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramzztd.zzb(1, this.key);
      }
      if (!this.value.equals("")) {
        paramzztd.zzb(2, this.value);
      }
      super.writeTo(paramzztd);
    }
    
    public zze zzHR()
    {
      this.key = "";
      this.value = "";
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zze zzL(zztc paramzztc)
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
        case 18: 
          this.value = paramzztc.readString();
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
      if (!this.value.equals("")) {
        j = i + zztd.zzp(2, this.value);
      }
      return j;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */