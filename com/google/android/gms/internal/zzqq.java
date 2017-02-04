package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzqq
{
  public static final class zza
    extends zztk
  {
    private static volatile zza[] zzaVj;
    public Integer count;
    public String name;
    public zzqq.zzb[] zzaVk;
    public Long zzaVl;
    public Long zzaVm;
    
    public zza()
    {
      zzCc();
    }
    
    public static zza[] zzCb()
    {
      if (zzaVj == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaVj == null) {
          zzaVj = new zza[0];
        }
        return zzaVj;
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
          if (!(paramObject instanceof zza)) {
            return false;
          }
          paramObject = (zza)paramObject;
          if (!zzti.equals(this.zzaVk, ((zza)paramObject).zzaVk)) {
            return false;
          }
          if (this.name == null)
          {
            if (((zza)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zza)paramObject).name)) {
            return false;
          }
          if (this.zzaVl == null)
          {
            if (((zza)paramObject).zzaVl != null) {
              return false;
            }
          }
          else if (!this.zzaVl.equals(((zza)paramObject).zzaVl)) {
            return false;
          }
          if (this.zzaVm == null)
          {
            if (((zza)paramObject).zzaVm != null) {
              return false;
            }
          }
          else if (!this.zzaVm.equals(((zza)paramObject).zzaVm)) {
            return false;
          }
          if (this.count != null) {
            break;
          }
        } while (((zza)paramObject).count == null);
        return false;
      } while (this.count.equals(((zza)paramObject).count));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzti.hashCode(this.zzaVk);
      int i;
      int j;
      label42:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzaVl != null) {
          break label103;
        }
        j = 0;
        if (this.zzaVm != null) {
          break label114;
        }
        k = 0;
        label51:
        if (this.count != null) {
          break label125;
        }
      }
      for (;;)
      {
        return (k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        label103:
        j = this.zzaVl.hashCode();
        break label42;
        label114:
        k = this.zzaVm.hashCode();
        break label51;
        label125:
        m = this.count.hashCode();
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if ((this.zzaVk != null) && (this.zzaVk.length > 0))
      {
        int i = 0;
        while (i < this.zzaVk.length)
        {
          zzqq.zzb localzzb = this.zzaVk[i];
          if (localzzb != null) {
            paramzztd.zza(1, localzzb);
          }
          i += 1;
        }
      }
      if (this.name != null) {
        paramzztd.zzb(2, this.name);
      }
      if (this.zzaVl != null) {
        paramzztd.zzb(3, this.zzaVl.longValue());
      }
      if (this.zzaVm != null) {
        paramzztd.zzb(4, this.zzaVm.longValue());
      }
      if (this.count != null) {
        paramzztd.zzG(5, this.count.intValue());
      }
      super.writeTo(paramzztd);
    }
    
    public zza zzCc()
    {
      this.zzaVk = zzqq.zzb.zzCd();
      this.name = null;
      this.zzaVl = null;
      this.zzaVm = null;
      this.count = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zza zzt(zztc paramzztc)
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
          int j = zztn.zzc(paramzztc, 10);
          if (this.zzaVk == null) {}
          zzqq.zzb[] arrayOfzzb;
          for (i = 0;; i = this.zzaVk.length)
          {
            arrayOfzzb = new zzqq.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaVk, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzqq.zzb();
              paramzztc.zza(arrayOfzzb[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzqq.zzb();
          paramzztc.zza(arrayOfzzb[j]);
          this.zzaVk = arrayOfzzb;
          break;
        case 18: 
          this.name = paramzztc.readString();
          break;
        case 24: 
          this.zzaVl = Long.valueOf(paramzztc.zzHk());
          break;
        case 32: 
          this.zzaVm = Long.valueOf(paramzztc.zzHk());
          break;
        case 40: 
          this.count = Integer.valueOf(paramzztc.zzHl());
        }
      }
    }
    
    protected int zzz()
    {
      int i = super.zzz();
      int j = i;
      if (this.zzaVk != null)
      {
        j = i;
        if (this.zzaVk.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.zzaVk.length) {
              break;
            }
            zzqq.zzb localzzb = this.zzaVk[k];
            j = i;
            if (localzzb != null) {
              j = i + zztd.zzc(1, localzzb);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.name != null) {
        i = j + zztd.zzp(2, this.name);
      }
      j = i;
      if (this.zzaVl != null) {
        j = i + zztd.zzd(3, this.zzaVl.longValue());
      }
      i = j;
      if (this.zzaVm != null) {
        i = j + zztd.zzd(4, this.zzaVm.longValue());
      }
      j = i;
      if (this.count != null) {
        j = i + zztd.zzI(5, this.count.intValue());
      }
      return j;
    }
  }
  
  public static final class zzb
    extends zztk
  {
    private static volatile zzb[] zzaVn;
    public String name;
    public Float zzaVi;
    public Long zzaVo;
    public String zzakS;
    
    public zzb()
    {
      zzCe();
    }
    
    public static zzb[] zzCd()
    {
      if (zzaVn == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaVn == null) {
          zzaVn = new zzb[0];
        }
        return zzaVn;
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
          if (this.zzakS == null)
          {
            if (((zzb)paramObject).zzakS != null) {
              return false;
            }
          }
          else if (!this.zzakS.equals(((zzb)paramObject).zzakS)) {
            return false;
          }
          if (this.zzaVo == null)
          {
            if (((zzb)paramObject).zzaVo != null) {
              return false;
            }
          }
          else if (!this.zzaVo.equals(((zzb)paramObject).zzaVo)) {
            return false;
          }
          if (this.zzaVi != null) {
            break;
          }
        } while (((zzb)paramObject).zzaVi == null);
        return false;
      } while (this.zzaVi.equals(((zzb)paramObject).zzaVi));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzakS != null) {
          break label88;
        }
        j = 0;
        if (this.zzaVo != null) {
          break label99;
        }
        k = 0;
        label42:
        if (this.zzaVi != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        label88:
        j = this.zzakS.hashCode();
        break label33;
        label99:
        k = this.zzaVo.hashCode();
        break label42;
        label110:
        m = this.zzaVi.hashCode();
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.name != null) {
        paramzztd.zzb(1, this.name);
      }
      if (this.zzakS != null) {
        paramzztd.zzb(2, this.zzakS);
      }
      if (this.zzaVo != null) {
        paramzztd.zzb(3, this.zzaVo.longValue());
      }
      if (this.zzaVi != null) {
        paramzztd.zzb(4, this.zzaVi.floatValue());
      }
      super.writeTo(paramzztd);
    }
    
    public zzb zzCe()
    {
      this.name = null;
      this.zzakS = null;
      this.zzaVo = null;
      this.zzaVi = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzb zzu(zztc paramzztc)
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
          this.zzakS = paramzztc.readString();
          break;
        case 24: 
          this.zzaVo = Long.valueOf(paramzztc.zzHk());
          break;
        case 37: 
          this.zzaVi = Float.valueOf(paramzztc.readFloat());
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.name != null) {
        i = j + zztd.zzp(1, this.name);
      }
      j = i;
      if (this.zzakS != null) {
        j = i + zztd.zzp(2, this.zzakS);
      }
      i = j;
      if (this.zzaVo != null) {
        i = j + zztd.zzd(3, this.zzaVo.longValue());
      }
      j = i;
      if (this.zzaVi != null) {
        j = i + zztd.zzc(4, this.zzaVi.floatValue());
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zztk
  {
    public zzqq.zzd[] zzaVp;
    
    public zzc()
    {
      zzCf();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzc)) {
          return false;
        }
        paramObject = (zzc)paramObject;
      } while (zzti.equals(this.zzaVp, ((zzc)paramObject).zzaVp));
      return false;
    }
    
    public int hashCode()
    {
      return (getClass().getName().hashCode() + 527) * 31 + zzti.hashCode(this.zzaVp);
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if ((this.zzaVp != null) && (this.zzaVp.length > 0))
      {
        int i = 0;
        while (i < this.zzaVp.length)
        {
          zzqq.zzd localzzd = this.zzaVp[i];
          if (localzzd != null) {
            paramzztd.zza(1, localzzd);
          }
          i += 1;
        }
      }
      super.writeTo(paramzztd);
    }
    
    public zzc zzCf()
    {
      this.zzaVp = zzqq.zzd.zzCg();
      this.zzbqb = -1;
      return this;
    }
    
    public zzc zzv(zztc paramzztc)
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
          int j = zztn.zzc(paramzztc, 10);
          if (this.zzaVp == null) {}
          zzqq.zzd[] arrayOfzzd;
          for (i = 0;; i = this.zzaVp.length)
          {
            arrayOfzzd = new zzqq.zzd[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaVp, 0, arrayOfzzd, 0, i);
              j = i;
            }
            while (j < arrayOfzzd.length - 1)
            {
              arrayOfzzd[j] = new zzqq.zzd();
              paramzztc.zza(arrayOfzzd[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          arrayOfzzd[j] = new zzqq.zzd();
          paramzztc.zza(arrayOfzzd[j]);
          this.zzaVp = arrayOfzzd;
        }
      }
    }
    
    protected int zzz()
    {
      int i = super.zzz();
      int k = i;
      if (this.zzaVp != null)
      {
        k = i;
        if (this.zzaVp.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.zzaVp.length) {
              break;
            }
            zzqq.zzd localzzd = this.zzaVp[j];
            k = i;
            if (localzzd != null) {
              k = i + zztd.zzc(1, localzzd);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zzd
    extends zztk
  {
    private static volatile zzd[] zzaVq;
    public String appId;
    public String osVersion;
    public String zzaKi;
    public String zzaSn;
    public String zzaSo;
    public String zzaSr;
    public String zzaVA;
    public String zzaVB;
    public Integer zzaVC;
    public Long zzaVD;
    public Long zzaVE;
    public String zzaVF;
    public Boolean zzaVG;
    public String zzaVH;
    public Long zzaVI;
    public Integer zzaVJ;
    public Boolean zzaVK;
    public Integer zzaVr;
    public zzqq.zza[] zzaVs;
    public zzqq.zze[] zzaVt;
    public Long zzaVu;
    public Long zzaVv;
    public Long zzaVw;
    public Long zzaVx;
    public Long zzaVy;
    public String zzaVz;
    
    public zzd()
    {
      zzCh();
    }
    
    public static zzd[] zzCg()
    {
      if (zzaVq == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaVq == null) {
          zzaVq = new zzd[0];
        }
        return zzaVq;
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
          if (!(paramObject instanceof zzd)) {
            return false;
          }
          paramObject = (zzd)paramObject;
          if (this.zzaVr == null)
          {
            if (((zzd)paramObject).zzaVr != null) {
              return false;
            }
          }
          else if (!this.zzaVr.equals(((zzd)paramObject).zzaVr)) {
            return false;
          }
          if (!zzti.equals(this.zzaVs, ((zzd)paramObject).zzaVs)) {
            return false;
          }
          if (!zzti.equals(this.zzaVt, ((zzd)paramObject).zzaVt)) {
            return false;
          }
          if (this.zzaVu == null)
          {
            if (((zzd)paramObject).zzaVu != null) {
              return false;
            }
          }
          else if (!this.zzaVu.equals(((zzd)paramObject).zzaVu)) {
            return false;
          }
          if (this.zzaVv == null)
          {
            if (((zzd)paramObject).zzaVv != null) {
              return false;
            }
          }
          else if (!this.zzaVv.equals(((zzd)paramObject).zzaVv)) {
            return false;
          }
          if (this.zzaVw == null)
          {
            if (((zzd)paramObject).zzaVw != null) {
              return false;
            }
          }
          else if (!this.zzaVw.equals(((zzd)paramObject).zzaVw)) {
            return false;
          }
          if (this.zzaVx == null)
          {
            if (((zzd)paramObject).zzaVx != null) {
              return false;
            }
          }
          else if (!this.zzaVx.equals(((zzd)paramObject).zzaVx)) {
            return false;
          }
          if (this.zzaVy == null)
          {
            if (((zzd)paramObject).zzaVy != null) {
              return false;
            }
          }
          else if (!this.zzaVy.equals(((zzd)paramObject).zzaVy)) {
            return false;
          }
          if (this.zzaVz == null)
          {
            if (((zzd)paramObject).zzaVz != null) {
              return false;
            }
          }
          else if (!this.zzaVz.equals(((zzd)paramObject).zzaVz)) {
            return false;
          }
          if (this.osVersion == null)
          {
            if (((zzd)paramObject).osVersion != null) {
              return false;
            }
          }
          else if (!this.osVersion.equals(((zzd)paramObject).osVersion)) {
            return false;
          }
          if (this.zzaVA == null)
          {
            if (((zzd)paramObject).zzaVA != null) {
              return false;
            }
          }
          else if (!this.zzaVA.equals(((zzd)paramObject).zzaVA)) {
            return false;
          }
          if (this.zzaVB == null)
          {
            if (((zzd)paramObject).zzaVB != null) {
              return false;
            }
          }
          else if (!this.zzaVB.equals(((zzd)paramObject).zzaVB)) {
            return false;
          }
          if (this.zzaVC == null)
          {
            if (((zzd)paramObject).zzaVC != null) {
              return false;
            }
          }
          else if (!this.zzaVC.equals(((zzd)paramObject).zzaVC)) {
            return false;
          }
          if (this.zzaSo == null)
          {
            if (((zzd)paramObject).zzaSo != null) {
              return false;
            }
          }
          else if (!this.zzaSo.equals(((zzd)paramObject).zzaSo)) {
            return false;
          }
          if (this.appId == null)
          {
            if (((zzd)paramObject).appId != null) {
              return false;
            }
          }
          else if (!this.appId.equals(((zzd)paramObject).appId)) {
            return false;
          }
          if (this.zzaKi == null)
          {
            if (((zzd)paramObject).zzaKi != null) {
              return false;
            }
          }
          else if (!this.zzaKi.equals(((zzd)paramObject).zzaKi)) {
            return false;
          }
          if (this.zzaVD == null)
          {
            if (((zzd)paramObject).zzaVD != null) {
              return false;
            }
          }
          else if (!this.zzaVD.equals(((zzd)paramObject).zzaVD)) {
            return false;
          }
          if (this.zzaVE == null)
          {
            if (((zzd)paramObject).zzaVE != null) {
              return false;
            }
          }
          else if (!this.zzaVE.equals(((zzd)paramObject).zzaVE)) {
            return false;
          }
          if (this.zzaVF == null)
          {
            if (((zzd)paramObject).zzaVF != null) {
              return false;
            }
          }
          else if (!this.zzaVF.equals(((zzd)paramObject).zzaVF)) {
            return false;
          }
          if (this.zzaVG == null)
          {
            if (((zzd)paramObject).zzaVG != null) {
              return false;
            }
          }
          else if (!this.zzaVG.equals(((zzd)paramObject).zzaVG)) {
            return false;
          }
          if (this.zzaVH == null)
          {
            if (((zzd)paramObject).zzaVH != null) {
              return false;
            }
          }
          else if (!this.zzaVH.equals(((zzd)paramObject).zzaVH)) {
            return false;
          }
          if (this.zzaVI == null)
          {
            if (((zzd)paramObject).zzaVI != null) {
              return false;
            }
          }
          else if (!this.zzaVI.equals(((zzd)paramObject).zzaVI)) {
            return false;
          }
          if (this.zzaVJ == null)
          {
            if (((zzd)paramObject).zzaVJ != null) {
              return false;
            }
          }
          else if (!this.zzaVJ.equals(((zzd)paramObject).zzaVJ)) {
            return false;
          }
          if (this.zzaSr == null)
          {
            if (((zzd)paramObject).zzaSr != null) {
              return false;
            }
          }
          else if (!this.zzaSr.equals(((zzd)paramObject).zzaSr)) {
            return false;
          }
          if (this.zzaSn == null)
          {
            if (((zzd)paramObject).zzaSn != null) {
              return false;
            }
          }
          else if (!this.zzaSn.equals(((zzd)paramObject).zzaSn)) {
            return false;
          }
          if (this.zzaVK != null) {
            break;
          }
        } while (((zzd)paramObject).zzaVK == null);
        return false;
      } while (this.zzaVK.equals(((zzd)paramObject).zzaVK));
      return false;
    }
    
    public int hashCode()
    {
      int i19 = 0;
      int i20 = getClass().getName().hashCode();
      int i;
      int i21;
      int i22;
      int j;
      label51:
      int k;
      label60:
      int m;
      label70:
      int n;
      label80:
      int i1;
      label90:
      int i2;
      label100:
      int i3;
      label110:
      int i4;
      label120:
      int i5;
      label130:
      int i6;
      label140:
      int i7;
      label150:
      int i8;
      label160:
      int i9;
      label170:
      int i10;
      label180:
      int i11;
      label190:
      int i12;
      label200:
      int i13;
      label210:
      int i14;
      label220:
      int i15;
      label230:
      int i16;
      label240:
      int i17;
      label250:
      int i18;
      if (this.zzaVr == null)
      {
        i = 0;
        i21 = zzti.hashCode(this.zzaVs);
        i22 = zzti.hashCode(this.zzaVt);
        if (this.zzaVu != null) {
          break label438;
        }
        j = 0;
        if (this.zzaVv != null) {
          break label449;
        }
        k = 0;
        if (this.zzaVw != null) {
          break label460;
        }
        m = 0;
        if (this.zzaVx != null) {
          break label472;
        }
        n = 0;
        if (this.zzaVy != null) {
          break label484;
        }
        i1 = 0;
        if (this.zzaVz != null) {
          break label496;
        }
        i2 = 0;
        if (this.osVersion != null) {
          break label508;
        }
        i3 = 0;
        if (this.zzaVA != null) {
          break label520;
        }
        i4 = 0;
        if (this.zzaVB != null) {
          break label532;
        }
        i5 = 0;
        if (this.zzaVC != null) {
          break label544;
        }
        i6 = 0;
        if (this.zzaSo != null) {
          break label556;
        }
        i7 = 0;
        if (this.appId != null) {
          break label568;
        }
        i8 = 0;
        if (this.zzaKi != null) {
          break label580;
        }
        i9 = 0;
        if (this.zzaVD != null) {
          break label592;
        }
        i10 = 0;
        if (this.zzaVE != null) {
          break label604;
        }
        i11 = 0;
        if (this.zzaVF != null) {
          break label616;
        }
        i12 = 0;
        if (this.zzaVG != null) {
          break label628;
        }
        i13 = 0;
        if (this.zzaVH != null) {
          break label640;
        }
        i14 = 0;
        if (this.zzaVI != null) {
          break label652;
        }
        i15 = 0;
        if (this.zzaVJ != null) {
          break label664;
        }
        i16 = 0;
        if (this.zzaSr != null) {
          break label676;
        }
        i17 = 0;
        if (this.zzaSn != null) {
          break label688;
        }
        i18 = 0;
        label260:
        if (this.zzaVK != null) {
          break label700;
        }
      }
      for (;;)
      {
        return (i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (((i + (i20 + 527) * 31) * 31 + i21) * 31 + i22) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i19;
        i = this.zzaVr.hashCode();
        break;
        label438:
        j = this.zzaVu.hashCode();
        break label51;
        label449:
        k = this.zzaVv.hashCode();
        break label60;
        label460:
        m = this.zzaVw.hashCode();
        break label70;
        label472:
        n = this.zzaVx.hashCode();
        break label80;
        label484:
        i1 = this.zzaVy.hashCode();
        break label90;
        label496:
        i2 = this.zzaVz.hashCode();
        break label100;
        label508:
        i3 = this.osVersion.hashCode();
        break label110;
        label520:
        i4 = this.zzaVA.hashCode();
        break label120;
        label532:
        i5 = this.zzaVB.hashCode();
        break label130;
        label544:
        i6 = this.zzaVC.hashCode();
        break label140;
        label556:
        i7 = this.zzaSo.hashCode();
        break label150;
        label568:
        i8 = this.appId.hashCode();
        break label160;
        label580:
        i9 = this.zzaKi.hashCode();
        break label170;
        label592:
        i10 = this.zzaVD.hashCode();
        break label180;
        label604:
        i11 = this.zzaVE.hashCode();
        break label190;
        label616:
        i12 = this.zzaVF.hashCode();
        break label200;
        label628:
        i13 = this.zzaVG.hashCode();
        break label210;
        label640:
        i14 = this.zzaVH.hashCode();
        break label220;
        label652:
        i15 = this.zzaVI.hashCode();
        break label230;
        label664:
        i16 = this.zzaVJ.hashCode();
        break label240;
        label676:
        i17 = this.zzaSr.hashCode();
        break label250;
        label688:
        i18 = this.zzaSn.hashCode();
        break label260;
        label700:
        i19 = this.zzaVK.hashCode();
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      int j = 0;
      if (this.zzaVr != null) {
        paramzztd.zzG(1, this.zzaVr.intValue());
      }
      int i;
      Object localObject;
      if ((this.zzaVs != null) && (this.zzaVs.length > 0))
      {
        i = 0;
        while (i < this.zzaVs.length)
        {
          localObject = this.zzaVs[i];
          if (localObject != null) {
            paramzztd.zza(2, (zztk)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzaVt != null) && (this.zzaVt.length > 0))
      {
        i = j;
        while (i < this.zzaVt.length)
        {
          localObject = this.zzaVt[i];
          if (localObject != null) {
            paramzztd.zza(3, (zztk)localObject);
          }
          i += 1;
        }
      }
      if (this.zzaVu != null) {
        paramzztd.zzb(4, this.zzaVu.longValue());
      }
      if (this.zzaVv != null) {
        paramzztd.zzb(5, this.zzaVv.longValue());
      }
      if (this.zzaVw != null) {
        paramzztd.zzb(6, this.zzaVw.longValue());
      }
      if (this.zzaVy != null) {
        paramzztd.zzb(7, this.zzaVy.longValue());
      }
      if (this.zzaVz != null) {
        paramzztd.zzb(8, this.zzaVz);
      }
      if (this.osVersion != null) {
        paramzztd.zzb(9, this.osVersion);
      }
      if (this.zzaVA != null) {
        paramzztd.zzb(10, this.zzaVA);
      }
      if (this.zzaVB != null) {
        paramzztd.zzb(11, this.zzaVB);
      }
      if (this.zzaVC != null) {
        paramzztd.zzG(12, this.zzaVC.intValue());
      }
      if (this.zzaSo != null) {
        paramzztd.zzb(13, this.zzaSo);
      }
      if (this.appId != null) {
        paramzztd.zzb(14, this.appId);
      }
      if (this.zzaKi != null) {
        paramzztd.zzb(16, this.zzaKi);
      }
      if (this.zzaVD != null) {
        paramzztd.zzb(17, this.zzaVD.longValue());
      }
      if (this.zzaVE != null) {
        paramzztd.zzb(18, this.zzaVE.longValue());
      }
      if (this.zzaVF != null) {
        paramzztd.zzb(19, this.zzaVF);
      }
      if (this.zzaVG != null) {
        paramzztd.zzb(20, this.zzaVG.booleanValue());
      }
      if (this.zzaVH != null) {
        paramzztd.zzb(21, this.zzaVH);
      }
      if (this.zzaVI != null) {
        paramzztd.zzb(22, this.zzaVI.longValue());
      }
      if (this.zzaVJ != null) {
        paramzztd.zzG(23, this.zzaVJ.intValue());
      }
      if (this.zzaSr != null) {
        paramzztd.zzb(24, this.zzaSr);
      }
      if (this.zzaSn != null) {
        paramzztd.zzb(25, this.zzaSn);
      }
      if (this.zzaVx != null) {
        paramzztd.zzb(26, this.zzaVx.longValue());
      }
      if (this.zzaVK != null) {
        paramzztd.zzb(28, this.zzaVK.booleanValue());
      }
      super.writeTo(paramzztd);
    }
    
    public zzd zzCh()
    {
      this.zzaVr = null;
      this.zzaVs = zzqq.zza.zzCb();
      this.zzaVt = zzqq.zze.zzCi();
      this.zzaVu = null;
      this.zzaVv = null;
      this.zzaVw = null;
      this.zzaVx = null;
      this.zzaVy = null;
      this.zzaVz = null;
      this.osVersion = null;
      this.zzaVA = null;
      this.zzaVB = null;
      this.zzaVC = null;
      this.zzaSo = null;
      this.appId = null;
      this.zzaKi = null;
      this.zzaVD = null;
      this.zzaVE = null;
      this.zzaVF = null;
      this.zzaVG = null;
      this.zzaVH = null;
      this.zzaVI = null;
      this.zzaVJ = null;
      this.zzaSr = null;
      this.zzaSn = null;
      this.zzaVK = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zzd zzw(zztc paramzztc)
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
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzaVr = Integer.valueOf(paramzztc.zzHl());
          break;
        case 18: 
          j = zztn.zzc(paramzztc, 18);
          if (this.zzaVs == null) {}
          for (i = 0;; i = this.zzaVs.length)
          {
            localObject = new zzqq.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaVs, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzqq.zza();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzqq.zza();
          paramzztc.zza(localObject[j]);
          this.zzaVs = ((zzqq.zza[])localObject);
          break;
        case 26: 
          j = zztn.zzc(paramzztc, 26);
          if (this.zzaVt == null) {}
          for (i = 0;; i = this.zzaVt.length)
          {
            localObject = new zzqq.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaVt, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzqq.zze();
              paramzztc.zza(localObject[j]);
              paramzztc.zzHi();
              j += 1;
            }
          }
          localObject[j] = new zzqq.zze();
          paramzztc.zza(localObject[j]);
          this.zzaVt = ((zzqq.zze[])localObject);
          break;
        case 32: 
          this.zzaVu = Long.valueOf(paramzztc.zzHk());
          break;
        case 40: 
          this.zzaVv = Long.valueOf(paramzztc.zzHk());
          break;
        case 48: 
          this.zzaVw = Long.valueOf(paramzztc.zzHk());
          break;
        case 56: 
          this.zzaVy = Long.valueOf(paramzztc.zzHk());
          break;
        case 66: 
          this.zzaVz = paramzztc.readString();
          break;
        case 74: 
          this.osVersion = paramzztc.readString();
          break;
        case 82: 
          this.zzaVA = paramzztc.readString();
          break;
        case 90: 
          this.zzaVB = paramzztc.readString();
          break;
        case 96: 
          this.zzaVC = Integer.valueOf(paramzztc.zzHl());
          break;
        case 106: 
          this.zzaSo = paramzztc.readString();
          break;
        case 114: 
          this.appId = paramzztc.readString();
          break;
        case 130: 
          this.zzaKi = paramzztc.readString();
          break;
        case 136: 
          this.zzaVD = Long.valueOf(paramzztc.zzHk());
          break;
        case 144: 
          this.zzaVE = Long.valueOf(paramzztc.zzHk());
          break;
        case 154: 
          this.zzaVF = paramzztc.readString();
          break;
        case 160: 
          this.zzaVG = Boolean.valueOf(paramzztc.zzHm());
          break;
        case 170: 
          this.zzaVH = paramzztc.readString();
          break;
        case 176: 
          this.zzaVI = Long.valueOf(paramzztc.zzHk());
          break;
        case 184: 
          this.zzaVJ = Integer.valueOf(paramzztc.zzHl());
          break;
        case 194: 
          this.zzaSr = paramzztc.readString();
          break;
        case 202: 
          this.zzaSn = paramzztc.readString();
          break;
        case 208: 
          this.zzaVx = Long.valueOf(paramzztc.zzHk());
          break;
        case 224: 
          this.zzaVK = Boolean.valueOf(paramzztc.zzHm());
        }
      }
    }
    
    protected int zzz()
    {
      int m = 0;
      int i = super.zzz();
      int j = i;
      if (this.zzaVr != null) {
        j = i + zztd.zzI(1, this.zzaVr.intValue());
      }
      i = j;
      Object localObject;
      int k;
      if (this.zzaVs != null)
      {
        i = j;
        if (this.zzaVs.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzaVs.length)
          {
            localObject = this.zzaVs[j];
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
      if (this.zzaVt != null)
      {
        j = i;
        if (this.zzaVt.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzaVt.length) {
              break;
            }
            localObject = this.zzaVt[k];
            j = i;
            if (localObject != null) {
              j = i + zztd.zzc(3, (zztk)localObject);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzaVu != null) {
        i = j + zztd.zzd(4, this.zzaVu.longValue());
      }
      j = i;
      if (this.zzaVv != null) {
        j = i + zztd.zzd(5, this.zzaVv.longValue());
      }
      i = j;
      if (this.zzaVw != null) {
        i = j + zztd.zzd(6, this.zzaVw.longValue());
      }
      j = i;
      if (this.zzaVy != null) {
        j = i + zztd.zzd(7, this.zzaVy.longValue());
      }
      i = j;
      if (this.zzaVz != null) {
        i = j + zztd.zzp(8, this.zzaVz);
      }
      j = i;
      if (this.osVersion != null) {
        j = i + zztd.zzp(9, this.osVersion);
      }
      i = j;
      if (this.zzaVA != null) {
        i = j + zztd.zzp(10, this.zzaVA);
      }
      j = i;
      if (this.zzaVB != null) {
        j = i + zztd.zzp(11, this.zzaVB);
      }
      i = j;
      if (this.zzaVC != null) {
        i = j + zztd.zzI(12, this.zzaVC.intValue());
      }
      j = i;
      if (this.zzaSo != null) {
        j = i + zztd.zzp(13, this.zzaSo);
      }
      i = j;
      if (this.appId != null) {
        i = j + zztd.zzp(14, this.appId);
      }
      j = i;
      if (this.zzaKi != null) {
        j = i + zztd.zzp(16, this.zzaKi);
      }
      i = j;
      if (this.zzaVD != null) {
        i = j + zztd.zzd(17, this.zzaVD.longValue());
      }
      j = i;
      if (this.zzaVE != null) {
        j = i + zztd.zzd(18, this.zzaVE.longValue());
      }
      i = j;
      if (this.zzaVF != null) {
        i = j + zztd.zzp(19, this.zzaVF);
      }
      j = i;
      if (this.zzaVG != null) {
        j = i + zztd.zzc(20, this.zzaVG.booleanValue());
      }
      i = j;
      if (this.zzaVH != null) {
        i = j + zztd.zzp(21, this.zzaVH);
      }
      j = i;
      if (this.zzaVI != null) {
        j = i + zztd.zzd(22, this.zzaVI.longValue());
      }
      i = j;
      if (this.zzaVJ != null) {
        i = j + zztd.zzI(23, this.zzaVJ.intValue());
      }
      j = i;
      if (this.zzaSr != null) {
        j = i + zztd.zzp(24, this.zzaSr);
      }
      i = j;
      if (this.zzaSn != null) {
        i = j + zztd.zzp(25, this.zzaSn);
      }
      j = i;
      if (this.zzaVx != null) {
        j = i + zztd.zzd(26, this.zzaVx.longValue());
      }
      i = j;
      if (this.zzaVK != null) {
        i = j + zztd.zzc(28, this.zzaVK.booleanValue());
      }
      return i;
    }
  }
  
  public static final class zze
    extends zztk
  {
    private static volatile zze[] zzaVL;
    public String name;
    public Long zzaVM;
    public Float zzaVi;
    public Long zzaVo;
    public String zzakS;
    
    public zze()
    {
      zzCj();
    }
    
    public static zze[] zzCi()
    {
      if (zzaVL == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaVL == null) {
          zzaVL = new zze[0];
        }
        return zzaVL;
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
          if (!(paramObject instanceof zze)) {
            return false;
          }
          paramObject = (zze)paramObject;
          if (this.zzaVM == null)
          {
            if (((zze)paramObject).zzaVM != null) {
              return false;
            }
          }
          else if (!this.zzaVM.equals(((zze)paramObject).zzaVM)) {
            return false;
          }
          if (this.name == null)
          {
            if (((zze)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zze)paramObject).name)) {
            return false;
          }
          if (this.zzakS == null)
          {
            if (((zze)paramObject).zzakS != null) {
              return false;
            }
          }
          else if (!this.zzakS.equals(((zze)paramObject).zzakS)) {
            return false;
          }
          if (this.zzaVo == null)
          {
            if (((zze)paramObject).zzaVo != null) {
              return false;
            }
          }
          else if (!this.zzaVo.equals(((zze)paramObject).zzaVo)) {
            return false;
          }
          if (this.zzaVi != null) {
            break;
          }
        } while (((zze)paramObject).zzaVi == null);
        return false;
      } while (this.zzaVi.equals(((zze)paramObject).zzaVi));
      return false;
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      label42:
      int m;
      if (this.zzaVM == null)
      {
        i = 0;
        if (this.name != null) {
          break label104;
        }
        j = 0;
        if (this.zzakS != null) {
          break label115;
        }
        k = 0;
        if (this.zzaVo != null) {
          break label126;
        }
        m = 0;
        label52:
        if (this.zzaVi != null) {
          break label138;
        }
      }
      for (;;)
      {
        return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
        i = this.zzaVM.hashCode();
        break;
        label104:
        j = this.name.hashCode();
        break label33;
        label115:
        k = this.zzakS.hashCode();
        break label42;
        label126:
        m = this.zzaVo.hashCode();
        break label52;
        label138:
        n = this.zzaVi.hashCode();
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.zzaVM != null) {
        paramzztd.zzb(1, this.zzaVM.longValue());
      }
      if (this.name != null) {
        paramzztd.zzb(2, this.name);
      }
      if (this.zzakS != null) {
        paramzztd.zzb(3, this.zzakS);
      }
      if (this.zzaVo != null) {
        paramzztd.zzb(4, this.zzaVo.longValue());
      }
      if (this.zzaVi != null) {
        paramzztd.zzb(5, this.zzaVi.floatValue());
      }
      super.writeTo(paramzztd);
    }
    
    public zze zzCj()
    {
      this.zzaVM = null;
      this.name = null;
      this.zzakS = null;
      this.zzaVo = null;
      this.zzaVi = null;
      this.zzbqb = -1;
      return this;
    }
    
    public zze zzx(zztc paramzztc)
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
        case 8: 
          this.zzaVM = Long.valueOf(paramzztc.zzHk());
          break;
        case 18: 
          this.name = paramzztc.readString();
          break;
        case 26: 
          this.zzakS = paramzztc.readString();
          break;
        case 32: 
          this.zzaVo = Long.valueOf(paramzztc.zzHk());
          break;
        case 45: 
          this.zzaVi = Float.valueOf(paramzztc.readFloat());
        }
      }
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.zzaVM != null) {
        i = j + zztd.zzd(1, this.zzaVM.longValue());
      }
      j = i;
      if (this.name != null) {
        j = i + zztd.zzp(2, this.name);
      }
      i = j;
      if (this.zzakS != null) {
        i = j + zztd.zzp(3, this.zzakS);
      }
      j = i;
      if (this.zzaVo != null) {
        j = i + zztd.zzd(4, this.zzaVo.longValue());
      }
      i = j;
      if (this.zzaVi != null) {
        i = j + zztd.zzc(5, this.zzaVi.floatValue());
      }
      return i;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */