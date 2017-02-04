package com.google.android.gms.internal;

import java.io.IOException;

public final class zzta
  extends zzte<zzta>
{
  public String[] zzbpA;
  public int[] zzbpB;
  public byte[][] zzbpC;
  
  public zzta()
  {
    zzHh();
  }
  
  public static zzta zzA(byte[] paramArrayOfByte)
    throws zztj
  {
    return (zzta)zztk.mergeFrom(new zzta(), paramArrayOfByte);
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
            } while (!(paramObject instanceof zzta));
            paramObject = (zzta)paramObject;
            bool1 = bool2;
          } while (!zzti.equals(this.zzbpA, ((zzta)paramObject).zzbpA));
          bool1 = bool2;
        } while (!zzti.equals(this.zzbpB, ((zzta)paramObject).zzbpB));
        bool1 = bool2;
      } while (!zzti.zza(this.zzbpC, ((zzta)paramObject).zzbpC));
      if ((this.zzbpQ != null) && (!this.zzbpQ.isEmpty())) {
        break label111;
      }
      if (((zzta)paramObject).zzbpQ == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzta)paramObject).zzbpQ.isEmpty());
    return true;
    label111:
    return this.zzbpQ.equals(((zzta)paramObject).zzbpQ);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzti.hashCode(this.zzbpA);
    int m = zzti.hashCode(this.zzbpB);
    int n = zzti.zza(this.zzbpC);
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
    if ((this.zzbpA != null) && (this.zzbpA.length > 0))
    {
      i = 0;
      while (i < this.zzbpA.length)
      {
        localObject = this.zzbpA[i];
        if (localObject != null) {
          paramzztd.zzb(1, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.zzbpB != null) && (this.zzbpB.length > 0))
    {
      i = 0;
      while (i < this.zzbpB.length)
      {
        paramzztd.zzG(2, this.zzbpB[i]);
        i += 1;
      }
    }
    if ((this.zzbpC != null) && (this.zzbpC.length > 0))
    {
      i = j;
      while (i < this.zzbpC.length)
      {
        localObject = this.zzbpC[i];
        if (localObject != null) {
          paramzztd.zza(3, (byte[])localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramzztd);
  }
  
  public zzta zzD(zztc paramzztc)
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
        if (this.zzbpA == null) {}
        for (i = 0;; i = this.zzbpA.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbpA, 0, localObject, 0, i);
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
        this.zzbpA = ((String[])localObject);
        break;
      case 16: 
        j = zztn.zzc(paramzztc, 16);
        if (this.zzbpB == null) {}
        for (i = 0;; i = this.zzbpB.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbpB, 0, localObject, 0, i);
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
        this.zzbpB = ((int[])localObject);
        break;
      case 18: 
        int k = paramzztc.zzmn(paramzztc.zzHp());
        i = paramzztc.getPosition();
        j = 0;
        while (paramzztc.zzHu() > 0)
        {
          paramzztc.zzHl();
          j += 1;
        }
        paramzztc.zzmp(i);
        if (this.zzbpB == null) {}
        for (i = 0;; i = this.zzbpB.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbpB, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzztc.zzHl();
            j += 1;
          }
        }
        this.zzbpB = ((int[])localObject);
        paramzztc.zzmo(k);
        break;
      case 26: 
        j = zztn.zzc(paramzztc, 26);
        if (this.zzbpC == null) {}
        for (i = 0;; i = this.zzbpC.length)
        {
          localObject = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbpC, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzztc.readBytes();
            paramzztc.zzHi();
            j += 1;
          }
        }
        localObject[j] = paramzztc.readBytes();
        this.zzbpC = ((byte[][])localObject);
      }
    }
  }
  
  public zzta zzHh()
  {
    this.zzbpA = zztn.zzbqg;
    this.zzbpB = zztn.zzboD;
    this.zzbpC = zztn.zzbqh;
    this.zzbpQ = null;
    this.zzbqb = -1;
    return this;
  }
  
  protected int zzz()
  {
    int i1 = 0;
    int i2 = super.zzz();
    int i;
    int k;
    Object localObject;
    int n;
    int m;
    if ((this.zzbpA != null) && (this.zzbpA.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < this.zzbpA.length; k = m)
      {
        localObject = this.zzbpA[i];
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
    for (int j = i2 + j + k * 1;; j = i2)
    {
      i = j;
      if (this.zzbpB != null)
      {
        i = j;
        if (this.zzbpB.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzbpB.length)
          {
            k += zztd.zzmu(this.zzbpB[i]);
            i += 1;
          }
          i = j + k + this.zzbpB.length * 1;
        }
      }
      j = i;
      if (this.zzbpC != null)
      {
        j = i;
        if (this.zzbpC.length > 0)
        {
          k = 0;
          m = 0;
          j = i1;
          while (j < this.zzbpC.length)
          {
            localObject = this.zzbpC[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zztd.zzF((byte[])localObject);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      return j;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */