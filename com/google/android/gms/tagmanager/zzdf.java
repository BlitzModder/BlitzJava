package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdf
{
  private static Double zzbgA = new Double(0.0D);
  private static zzde zzbgB = zzde.zzX(0L);
  private static String zzbgC = new String("");
  private static Boolean zzbgD = new Boolean(false);
  private static List<Object> zzbgE = new ArrayList(0);
  private static Map<Object, Object> zzbgF = new HashMap();
  private static zzag.zza zzbgG = zzR(zzbgC);
  private static final Object zzbgy = null;
  private static Long zzbgz = new Long(0L);
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    zzbg.e("getDouble received non-Number");
    return 0.0D;
  }
  
  public static Object zzFD()
  {
    return zzbgy;
  }
  
  public static Long zzFE()
  {
    return zzbgz;
  }
  
  public static Double zzFF()
  {
    return zzbgA;
  }
  
  public static Boolean zzFG()
  {
    return zzbgD;
  }
  
  public static zzde zzFH()
  {
    return zzbgB;
  }
  
  public static String zzFI()
  {
    return zzbgC;
  }
  
  public static zzag.zza zzFJ()
  {
    return zzbgG;
  }
  
  public static String zzM(Object paramObject)
  {
    if (paramObject == null) {
      return zzbgC;
    }
    return paramObject.toString();
  }
  
  public static zzde zzN(Object paramObject)
  {
    if ((paramObject instanceof zzde)) {
      return (zzde)paramObject;
    }
    if (zzT(paramObject)) {
      return zzde.zzX(zzU(paramObject));
    }
    if (zzS(paramObject)) {
      return zzde.zza(Double.valueOf(getDouble(paramObject)));
    }
    return zzfG(zzM(paramObject));
  }
  
  public static Long zzO(Object paramObject)
  {
    if (zzT(paramObject)) {
      return Long.valueOf(zzU(paramObject));
    }
    return zzfH(zzM(paramObject));
  }
  
  public static Double zzP(Object paramObject)
  {
    if (zzS(paramObject)) {
      return Double.valueOf(getDouble(paramObject));
    }
    return zzfI(zzM(paramObject));
  }
  
  public static Boolean zzQ(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return zzfJ(zzM(paramObject));
  }
  
  public static zzag.zza zzR(Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new zzag.zza();
    if ((paramObject instanceof zzag.zza)) {
      return (zzag.zza)paramObject;
    }
    if ((paramObject instanceof String))
    {
      ((zzag.zza)localObject1).type = 1;
      ((zzag.zza)localObject1).zzjo = ((String)paramObject);
    }
    for (;;)
    {
      ((zzag.zza)localObject1).zzjy = bool;
      return (zzag.zza)localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramObject instanceof List))
      {
        ((zzag.zza)localObject1).type = 2;
        localObject2 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = zzR(((Iterator)localObject2).next());
          if (localObject3 == zzbgG) {
            return zzbgG;
          }
          if ((bool) || (((zzag.zza)localObject3).zzjy)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        ((zzag.zza)localObject1).zzjp = ((zzag.zza[])((List)paramObject).toArray(new zzag.zza[0]));
      }
      else if ((paramObject instanceof Map))
      {
        ((zzag.zza)localObject1).type = 3;
        localObject3 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject3).size());
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        bool = false;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
          zzag.zza localzza = zzR(((Map.Entry)localObject4).getKey());
          localObject4 = zzR(((Map.Entry)localObject4).getValue());
          if ((localzza == zzbgG) || (localObject4 == zzbgG)) {
            return zzbgG;
          }
          if ((bool) || (localzza.zzjy) || (((zzag.zza)localObject4).zzjy)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localzza);
            ((List)localObject2).add(localObject4);
            break;
          }
        }
        ((zzag.zza)localObject1).zzjq = ((zzag.zza[])((List)paramObject).toArray(new zzag.zza[0]));
        ((zzag.zza)localObject1).zzjr = ((zzag.zza[])((List)localObject2).toArray(new zzag.zza[0]));
      }
      else if (zzS(paramObject))
      {
        ((zzag.zza)localObject1).type = 1;
        ((zzag.zza)localObject1).zzjo = paramObject.toString();
      }
      else if (zzT(paramObject))
      {
        ((zzag.zza)localObject1).type = 6;
        ((zzag.zza)localObject1).zzju = zzU(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((zzag.zza)localObject1).type = 8;
        ((zzag.zza)localObject1).zzjv = ((Boolean)paramObject).booleanValue();
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      zzbg.e((String)paramObject);
      return zzbgG;
    }
  }
  
  private static boolean zzS(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzde)) && (((zzde)paramObject).zzFy()));
  }
  
  private static boolean zzT(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzde)) && (((zzde)paramObject).zzFz()));
  }
  
  private static long zzU(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    zzbg.e("getInt64 received non-Number");
    return 0L;
  }
  
  public static zzag.zza zzfF(String paramString)
  {
    zzag.zza localzza = new zzag.zza();
    localzza.type = 5;
    localzza.zzjt = paramString;
    return localzza;
  }
  
  private static zzde zzfG(String paramString)
  {
    try
    {
      zzde localzzde = zzde.zzfE(paramString);
      return localzzde;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzbg.e("Failed to convert '" + paramString + "' to a number.");
    }
    return zzbgB;
  }
  
  private static Long zzfH(String paramString)
  {
    paramString = zzfG(paramString);
    if (paramString == zzbgB) {
      return zzbgz;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  private static Double zzfI(String paramString)
  {
    paramString = zzfG(paramString);
    if (paramString == zzbgB) {
      return zzbgA;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  private static Boolean zzfJ(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return zzbgD;
  }
  
  public static String zzg(zzag.zza paramzza)
  {
    return zzM(zzl(paramzza));
  }
  
  public static zzde zzh(zzag.zza paramzza)
  {
    return zzN(zzl(paramzza));
  }
  
  public static Long zzi(zzag.zza paramzza)
  {
    return zzO(zzl(paramzza));
  }
  
  public static Double zzj(zzag.zza paramzza)
  {
    return zzP(zzl(paramzza));
  }
  
  public static Boolean zzk(zzag.zza paramzza)
  {
    return zzQ(zzl(paramzza));
  }
  
  public static Object zzl(zzag.zza paramzza)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramzza == null) {
      return zzbgy;
    }
    Object localObject1;
    Object localObject2;
    switch (paramzza.type)
    {
    default: 
      zzbg.e("Failed to convert a value of type: " + paramzza.type);
      return zzbgy;
    case 1: 
      return paramzza.zzjo;
    case 2: 
      localObject1 = new ArrayList(paramzza.zzjp.length);
      paramzza = paramzza.zzjp;
      j = paramzza.length;
      while (i < j)
      {
        localObject2 = zzl(paramzza[i]);
        if (localObject2 == zzbgy) {
          return zzbgy;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 3: 
      if (paramzza.zzjq.length != paramzza.zzjr.length)
      {
        zzbg.e("Converting an invalid value to object: " + paramzza.toString());
        return zzbgy;
      }
      localObject1 = new HashMap(paramzza.zzjr.length);
      i = k;
      while (i < paramzza.zzjq.length)
      {
        localObject2 = zzl(paramzza.zzjq[i]);
        Object localObject3 = zzl(paramzza.zzjr[i]);
        if ((localObject2 == zzbgy) || (localObject3 == zzbgy)) {
          return zzbgy;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      zzbg.e("Trying to convert a macro reference to object");
      return zzbgy;
    case 5: 
      zzbg.e("Trying to convert a function id to object");
      return zzbgy;
    case 6: 
      return Long.valueOf(paramzza.zzju);
    case 7: 
      localObject1 = new StringBuffer();
      paramzza = paramzza.zzjw;
      k = paramzza.length;
      i = j;
      while (i < k)
      {
        localObject2 = zzg(paramzza[i]);
        if (localObject2 == zzbgC) {
          return zzbgy;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramzza.zzjv);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */