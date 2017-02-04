package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zztf<M extends zzte<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzbpR;
  protected final boolean zzbpS;
  
  private zztf(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.zzbpR = paramClass;
    this.tag = paramInt2;
    this.zzbpS = paramBoolean;
  }
  
  private T zzH(List<zztm> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (zztm)paramList.get(i);
      if (((zztm)localObject).zzbqc.length != 0) {
        zza((zztm)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.zzbpR.cast(Array.newInstance(this.zzbpR.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<zztm>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T zzI(List<zztm> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zztm)paramList.get(paramList.size() - 1);
    return (T)this.zzbpR.cast(zzE(zztc.zzC(paramList.zzbqc)));
  }
  
  public static <M extends zzte<M>, T extends zztk> zztf<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zztf(paramInt, paramClass, (int)paramLong, false);
  }
  
  protected Object zzE(zztc paramzztc)
  {
    Class localClass;
    if (this.zzbpS) {
      localClass = this.zzbpR.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (InstantiationException paramzztc)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramzztc);
        localClass = this.zzbpR;
        continue;
        zztk localzztk = (zztk)localClass.newInstance();
        paramzztc.zza(localzztk, zztn.zzmG(this.tag));
        return localzztk;
        localzztk = (zztk)localClass.newInstance();
        paramzztc.zza(localzztk);
        return localzztk;
      }
      catch (IllegalAccessException paramzztc)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramzztc);
      }
      catch (IOException paramzztc)
      {
        throw new IllegalArgumentException("Error reading extension field", paramzztc);
      }
    }
  }
  
  final T zzG(List<zztm> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.zzbpS) {
      return (T)zzH(paramList);
    }
    return (T)zzI(paramList);
  }
  
  int zzY(Object paramObject)
  {
    if (this.zzbpS) {
      return zzZ(paramObject);
    }
    return zzaa(paramObject);
  }
  
  protected int zzZ(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzaa(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected void zza(zztm paramzztm, List<Object> paramList)
  {
    paramList.add(zzE(zztc.zzC(paramzztm.zzbqc)));
  }
  
  void zza(Object paramObject, zztd paramzztd)
    throws IOException
  {
    if (this.zzbpS)
    {
      zzc(paramObject, paramzztd);
      return;
    }
    zzb(paramObject, paramzztd);
  }
  
  protected int zzaa(Object paramObject)
  {
    int i = zztn.zzmG(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      return zztd.zzb(i, (zztk)paramObject);
    }
    return zztd.zzc(i, (zztk)paramObject);
  }
  
  protected void zzb(Object paramObject, zztd paramzztd)
  {
    for (;;)
    {
      try
      {
        paramzztd.zzmy(this.tag);
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (zztk)paramObject;
      int i = zztn.zzmG(this.tag);
      paramzztd.zzb((zztk)paramObject);
      paramzztd.zzK(i, 4);
      return;
      paramzztd.zzc((zztk)paramObject);
      return;
    }
  }
  
  protected void zzc(Object paramObject, zztd paramzztd)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzztd);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */