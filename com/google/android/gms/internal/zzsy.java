package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzsy
{
  private static int zza(String paramString, zzsz.zza.zza[] paramArrayOfzza)
  {
    int m = paramArrayOfzza.length;
    int i = 0;
    int j = 14;
    if (i < m)
    {
      zzsz.zza.zza localzza = paramArrayOfzza[i];
      int k;
      if (j == 14) {
        if ((localzza.type == 9) || (localzza.type == 2) || (localzza.type == 6)) {
          k = localzza.type;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          k = j;
        } while (localzza.type == 14);
        throw new IllegalArgumentException("Unexpected TypedValue type: " + localzza.type + " for key " + paramString);
        k = j;
      } while (localzza.type == j);
      throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + j + " and " + localzza.type);
    }
    return j;
  }
  
  static int zza(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return paramList.size() - 1;
  }
  
  public static zza zza(DataMap paramDataMap)
  {
    zzsz localzzsz = new zzsz();
    ArrayList localArrayList = new ArrayList();
    localzzsz.zzbph = zza(paramDataMap, localArrayList);
    return new zza(localzzsz, localArrayList);
  }
  
  private static zzsz.zza.zza zza(List<Asset> paramList, Object paramObject)
  {
    zzsz.zza.zza localzza1 = new zzsz.zza.zza();
    if (paramObject == null)
    {
      localzza1.type = 14;
      return localzza1;
    }
    localzza1.zzbpl = new zzsz.zza.zza.zza();
    if ((paramObject instanceof String))
    {
      localzza1.type = 2;
      localzza1.zzbpl.zzbpn = ((String)paramObject);
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    for (;;)
    {
      return localzza1;
      if ((paramObject instanceof Integer))
      {
        localzza1.type = 6;
        localzza1.zzbpl.zzbpr = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localzza1.type = 5;
        localzza1.zzbpl.zzbpq = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localzza1.type = 3;
        localzza1.zzbpl.zzbpo = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localzza1.type = 4;
        localzza1.zzbpl.zzbpp = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localzza1.type = 8;
        localzza1.zzbpl.zzbpt = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localzza1.type = 7;
        localzza1.zzbpl.zzbps = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localzza1.type = 1;
        localzza1.zzbpl.zzbpm = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localzza1.type = 11;
        localzza1.zzbpl.zzbpw = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localzza1.type = 12;
        localzza1.zzbpl.zzbpx = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localzza1.type = 15;
        localzza1.zzbpl.zzbpy = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localzza1.type = 13;
        localzza1.zzbpl.zzbpz = zza(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        localzza1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = new TreeSet(((DataMap)paramObject).keySet());
        localObject1 = new zzsz.zza[((TreeSet)localObject2).size()];
        localObject2 = ((TreeSet)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new zzsz.zza();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].zzbpj = zza(paramList, ((DataMap)paramObject).get((String)localObject3));
          i += 1;
        }
        localzza1.zzbpl.zzbpu = ((zzsz.zza[])localObject1);
      }
    }
    int j;
    label587:
    zzsz.zza.zza localzza2;
    if ((paramObject instanceof ArrayList))
    {
      localzza1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new zzsz.zza.zza[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      j = 0;
      i = 14;
      if (j < k)
      {
        localObject1 = ((ArrayList)localObject2).get(j);
        localzza2 = zza(paramList, localObject1);
        if ((localzza2.type != 14) && (localzza2.type != 2) && (localzza2.type != 6) && (localzza2.type != 9)) {
          throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + localObject1.getClass());
        }
        if ((i == 14) && (localzza2.type != 14))
        {
          i = localzza2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[j] = localzza2;
      j += 1;
      break label587;
      if (localzza2.type != i)
      {
        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + paramObject.getClass() + " and a " + localObject1.getClass());
        localzza1.zzbpl.zzbpv = ((zzsz.zza.zza[])localObject3);
        break;
        throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
      }
    }
  }
  
  public static DataMap zza(zza paramzza)
  {
    DataMap localDataMap = new DataMap();
    zzsz.zza[] arrayOfzza = paramzza.zzbpf.zzbph;
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      zzsz.zza localzza = arrayOfzza[i];
      zza(paramzza.zzbpg, localDataMap, localzza.name, localzza.zzbpj);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList zza(List<Asset> paramList, zzsz.zza.zza.zza paramzza, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramzza.zzbpv.length);
    paramzza = paramzza.zzbpv;
    int k = paramzza.length;
    int i = 0;
    if (i < k)
    {
      zzsz.zza[] arrayOfzza = paramzza[i];
      if (arrayOfzza.type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfzza = arrayOfzza.zzbpl.zzbpu;
          int m = arrayOfzza.length;
          int j = 0;
          while (j < m)
          {
            zzsz.zza localzza = arrayOfzza[j];
            zza(paramList, localDataMap, localzza.name, localzza.zzbpj);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfzza.zzbpl.zzbpn);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfzza.zzbpl.zzbpr));
        }
      }
      label191:
      throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzsz.zza.zza paramzza)
  {
    int i = paramzza.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = paramzza.zzbpl;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpm);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpw);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpx);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpy);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpn);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpo);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpp);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpq);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpr);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((zzsz.zza.zza.zza)localObject1).zzbps);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpt);
      return;
    }
    if (i == 13)
    {
      if (paramList == null) {
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((zzsz.zza.zza.zza)localObject1).zzbpz));
      return;
    }
    if (i == 9)
    {
      paramzza = new DataMap();
      localObject1 = ((zzsz.zza.zza.zza)localObject1).zzbpu;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        zza(paramList, paramzza, ((zzsz.zza)localObject2).name, ((zzsz.zza)localObject2).zzbpj);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzza);
      return;
    }
    if (i == 10)
    {
      i = zza(paramString, ((zzsz.zza.zza.zza)localObject1).zzbpv);
      paramList = zza(paramList, (zzsz.zza.zza.zza)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException("populateBundle: unexpected type " + i);
  }
  
  private static zzsz.zza[] zza(DataMap paramDataMap, List<Asset> paramList)
  {
    Object localObject1 = new TreeSet(paramDataMap.keySet());
    zzsz.zza[] arrayOfzza = new zzsz.zza[((TreeSet)localObject1).size()];
    localObject1 = ((TreeSet)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfzza[i] = new zzsz.zza();
      arrayOfzza[i].name = str;
      arrayOfzza[i].zzbpj = zza(paramList, localObject2);
      i += 1;
    }
    return arrayOfzza;
  }
  
  public static class zza
  {
    public final zzsz zzbpf;
    public final List<Asset> zzbpg;
    
    public zza(zzsz paramzzsz, List<Asset> paramList)
    {
      this.zzbpf = paramzzsz;
      this.zzbpg = paramList;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */