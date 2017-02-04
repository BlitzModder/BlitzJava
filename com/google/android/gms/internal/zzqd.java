package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzqd
{
  public static final class zza
    extends zzte<zza>
  {
    public zza[] zzaJA;
    
    public zza()
    {
      zzxD();
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
        } while (!zzti.equals(this.zzaJA, ((zza)paramObject).zzaJA));
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label79;
        }
        if (((zza)paramObject).zzbpQ == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbpQ.isEmpty());
      return true;
      label79:
      return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzti.hashCode(this.zzaJA);
      if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty())) {}
      for (int i = 0;; i = this.zzbpQ.hashCode()) {
        return i + ((j + 527) * 31 + k) * 31;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if ((this.zzaJA != null) && (this.zzaJA.length > 0))
      {
        int i = 0;
        while (i < this.zzaJA.length)
        {
          zza localzza = this.zzaJA[i];
          if (localzza != null) {
            paramzztd.zza(1, localzza);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzo(zztc paramzztc)
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
          if (this.zzaJA == null) {}
          zza[] arrayOfzza;
          for (i = 0;; i = this.zzaJA.length)
          {
            arrayOfzza = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaJA, 0, arrayOfzza, 0, i);
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
          this.zzaJA = arrayOfzza;
        }
      }
    }
    
    public zza zzxD()
    {
      this.zzaJA = zza.zzxE();
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int i = super.zzz();
      int k = i;
      if (this.zzaJA != null)
      {
        k = i;
        if (this.zzaJA.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.zzaJA.length) {
              break;
            }
            zza localzza = this.zzaJA[j];
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
    
    public static final class zza
      extends zzte<zza>
    {
      private static volatile zza[] zzaJB;
      public int viewId;
      public String zzaJC;
      public String zzaJD;
      
      public zza()
      {
        zzxF();
      }
      
      public static zza[] zzxE()
      {
        if (zzaJB == null) {}
        synchronized (zzti.zzbqa)
        {
          if (zzaJB == null) {
            zzaJB = new zza[0];
          }
          return zzaJB;
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
            if (this.zzaJC != null) {
              break;
            }
            bool1 = bool2;
          } while (((zza)paramObject).zzaJC != null);
          if (this.zzaJD != null) {
            break label124;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzaJD != null);
        label124:
        while (this.zzaJD.equals(((zza)paramObject).zzaJD))
        {
          bool1 = bool2;
          if (this.viewId != ((zza)paramObject).viewId) {
            break;
          }
          if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
            break label140;
          }
          if (((zza)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zza)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzaJC.equals(((zza)paramObject).zzaJC)) {
            break label41;
          }
          return false;
        }
        return false;
        label140:
        return this.zzbpQ.equals(((zza)paramObject).zzbpQ);
      }
      
      public int hashCode()
      {
        int m = 0;
        int n = getClass().getName().hashCode();
        int i;
        int j;
        label33:
        int i1;
        if (this.zzaJC == null)
        {
          i = 0;
          if (this.zzaJD != null) {
            break label101;
          }
          j = 0;
          i1 = this.viewId;
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
          return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
          i = this.zzaJC.hashCode();
          break;
          j = this.zzaJD.hashCode();
          break label33;
        }
      }
      
      public void writeTo(zztd paramzztd)
        throws IOException
      {
        if (!this.zzaJC.equals("")) {
          paramzztd.zzb(1, this.zzaJC);
        }
        if (!this.zzaJD.equals("")) {
          paramzztd.zzb(2, this.zzaJD);
        }
        if (this.viewId != 0) {
          paramzztd.zzG(3, this.viewId);
        }
        super.writeTo(paramzztd);
      }
      
      public zza zzp(zztc paramzztc)
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
            this.zzaJC = paramzztc.readString();
            break;
          case 18: 
            this.zzaJD = paramzztc.readString();
            break;
          case 24: 
            this.viewId = paramzztc.zzHl();
          }
        }
      }
      
      public zza zzxF()
      {
        this.zzaJC = "";
        this.zzaJD = "";
        this.viewId = 0;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
      }
      
      protected int zzz()
      {
        int j = super.zzz();
        int i = j;
        if (!this.zzaJC.equals("")) {
          i = j + zztd.zzp(1, this.zzaJC);
        }
        j = i;
        if (!this.zzaJD.equals("")) {
          j = i + zztd.zzp(2, this.zzaJD);
        }
        i = j;
        if (this.viewId != 0) {
          i = j + zztd.zzI(3, this.viewId);
        }
        return i;
      }
    }
  }
  
  public static final class zzb
    extends zzte<zzb>
  {
    private static volatile zzb[] zzaJE;
    public String name;
    public zzqd.zzd zzaJF;
    
    public zzb()
    {
      zzxH();
    }
    
    public static zzb[] zzxG()
    {
      if (zzaJE == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaJE == null) {
          zzaJE = new zzb[0];
        }
        return zzaJE;
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
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzb)paramObject).name != null);
        if (this.zzaJF != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).zzaJF != null);
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
          if (this.name.equals(((zzb)paramObject).name)) {
            break label41;
          }
          return false;
          label111:
          if (!this.zzaJF.equals(((zzb)paramObject).zzaJF)) {
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
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.zzaJF != null) {
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
        j = this.zzaJF.hashCode();
        break label33;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramzztd.zzb(1, this.name);
      }
      if (this.zzaJF != null) {
        paramzztd.zza(2, this.zzaJF);
      }
      super.writeTo(paramzztd);
    }
    
    public zzb zzq(zztc paramzztc)
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
          if (this.zzaJF == null) {
            this.zzaJF = new zzqd.zzd();
          }
          paramzztc.zza(this.zzaJF);
        }
      }
    }
    
    public zzb zzxH()
    {
      this.name = "";
      this.zzaJF = null;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (!this.name.equals("")) {
        i = j + zztd.zzp(1, this.name);
      }
      j = i;
      if (this.zzaJF != null) {
        j = i + zztd.zzc(2, this.zzaJF);
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzte<zzc>
  {
    public String type;
    public zzqd.zzb[] zzaJG;
    
    public zzc()
    {
      zzxI();
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
        if (this.type != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).type != null);
      while (this.type.equals(((zzc)paramObject).type))
      {
        bool1 = bool2;
        if (!zzti.equals(this.zzaJG, ((zzc)paramObject).zzaJG)) {
          break;
        }
        if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
          break label111;
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
      label111:
      return this.zzbpQ.equals(((zzc)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int n;
      if (this.type == null)
      {
        i = 0;
        n = zzti.hashCode(this.zzaJG);
        j = k;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label87;
          }
        }
      }
      label87:
      for (int j = k;; j = this.zzbpQ.hashCode())
      {
        return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
        i = this.type.hashCode();
        break;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.type.equals("")) {
        paramzztd.zzb(1, this.type);
      }
      if ((this.zzaJG != null) && (this.zzaJG.length > 0))
      {
        int i = 0;
        while (i < this.zzaJG.length)
        {
          zzqd.zzb localzzb = this.zzaJG[i];
          if (localzzb != null) {
            paramzztd.zza(2, localzzb);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zzc zzr(zztc paramzztc)
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
          this.type = paramzztc.readString();
          break;
        case 18: 
          int j = zztn.zzc(paramzztc, 18);
          if (this.zzaJG == null) {}
          zzqd.zzb[] arrayOfzzb;
          for (i = 0;; i = this.zzaJG.length)
          {
            arrayOfzzb = new zzqd.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaJG, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzqd.zzb();
              paramzztc.zza(arrayOfzzb[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzqd.zzb();
          paramzztc.zza(arrayOfzzb[j]);
          this.zzaJG = arrayOfzzb;
        }
      }
    }
    
    public zzc zzxI()
    {
      this.type = "";
      this.zzaJG = zzqd.zzb.zzxG();
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (!this.type.equals("")) {
        i = j + zztd.zzp(1, this.type);
      }
      j = i;
      if (this.zzaJG != null)
      {
        j = i;
        if (this.zzaJG.length > 0)
        {
          j = 0;
          while (j < this.zzaJG.length)
          {
            zzqd.zzb localzzb = this.zzaJG[j];
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
  
  public static final class zzd
    extends zzte<zzd>
  {
    public boolean zzaJH;
    public long zzaJI;
    public double zzaJJ;
    public zzqd.zzc zzaJK;
    public String zzakS;
    
    public zzd()
    {
      zzxJ();
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
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                } while (!(paramObject instanceof zzd));
                paramObject = (zzd)paramObject;
                bool1 = bool2;
              } while (this.zzaJH != ((zzd)paramObject).zzaJH);
              if (this.zzakS != null) {
                break;
              }
              bool1 = bool2;
            } while (((zzd)paramObject).zzakS != null);
            bool1 = bool2;
          } while (this.zzaJI != ((zzd)paramObject).zzaJI);
          bool1 = bool2;
        } while (Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(((zzd)paramObject).zzaJJ));
        if (this.zzaJK != null) {
          break label158;
        }
        bool1 = bool2;
      } while (((zzd)paramObject).zzaJK != null);
      for (;;)
      {
        if ((this.zzbpQ == null) || (this.zzbpQ.isEmpty()))
        {
          if (((zzd)paramObject).zzbpQ != null)
          {
            bool1 = bool2;
            if (!((zzd)paramObject).zzbpQ.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzakS.equals(((zzd)paramObject).zzakS)) {
            break label54;
          }
          return false;
          label158:
          if (!this.zzaJK.equals(((zzd)paramObject).zzaJK)) {
            return false;
          }
        }
      }
      return this.zzbpQ.equals(((zzd)paramObject).zzbpQ);
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label35:
      int i2;
      int i3;
      int k;
      if (this.zzaJH)
      {
        i = 1231;
        if (this.zzakS != null) {
          break label151;
        }
        j = 0;
        i2 = (int)(this.zzaJI ^ this.zzaJI >>> 32);
        long l = Double.doubleToLongBits(this.zzaJJ);
        i3 = (int)(l ^ l >>> 32);
        if (this.zzaJK != null) {
          break label162;
        }
        k = 0;
        label79:
        m = n;
        if (this.zzbpQ != null) {
          if (!this.zzbpQ.isEmpty()) {
            break label173;
          }
        }
      }
      label151:
      label162:
      label173:
      for (int m = n;; m = this.zzbpQ.hashCode())
      {
        return (k + (((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + m;
        i = 1237;
        break;
        j = this.zzakS.hashCode();
        break label35;
        k = this.zzaJK.hashCode();
        break label79;
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.zzaJH) {
        paramzztd.zzb(1, this.zzaJH);
      }
      if (!this.zzakS.equals("")) {
        paramzztd.zzb(2, this.zzakS);
      }
      if (this.zzaJI != 0L) {
        paramzztd.zzb(3, this.zzaJI);
      }
      if (Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(0.0D)) {
        paramzztd.zza(4, this.zzaJJ);
      }
      if (this.zzaJK != null) {
        paramzztd.zza(5, this.zzaJK);
      }
      super.writeTo(paramzztd);
    }
    
    public zzd zzs(zztc paramzztc)
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
          this.zzaJH = paramzztc.zzHm();
          break;
        case 18: 
          this.zzakS = paramzztc.readString();
          break;
        case 24: 
          this.zzaJI = paramzztc.zzHk();
          break;
        case 33: 
          this.zzaJJ = paramzztc.readDouble();
          break;
        case 42: 
          if (this.zzaJK == null) {
            this.zzaJK = new zzqd.zzc();
          }
          paramzztc.zza(this.zzaJK);
        }
      }
    }
    
    public zzd zzxJ()
    {
      this.zzaJH = false;
      this.zzakS = "";
      this.zzaJI = 0L;
      this.zzaJJ = 0.0D;
      this.zzaJK = null;
      this.zzbpQ = null;
      this.zzbqb = -1;
      return this;
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.zzaJH) {
        i = j + zztd.zzc(1, this.zzaJH);
      }
      j = i;
      if (!this.zzakS.equals("")) {
        j = i + zztd.zzp(2, this.zzakS);
      }
      i = j;
      if (this.zzaJI != 0L) {
        i = j + zztd.zzd(3, this.zzaJI);
      }
      j = i;
      if (Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(0.0D)) {
        j = i + zztd.zzb(4, this.zzaJJ);
      }
      i = j;
      if (this.zzaJK != null) {
        i = j + zztd.zzc(5, this.zzaJK);
      }
      return i;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */