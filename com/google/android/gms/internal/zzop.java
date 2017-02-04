package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzop
{
  private static final Set<String> zzaxk = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { zzom.zzavz.name, zzom.zzavL.name })));
  
  public static String zzd(DataPoint paramDataPoint)
  {
    DataType localDataType = paramDataPoint.getDataType();
    if (!zzon.zzdp(localDataType.getName())) {
      return null;
    }
    Iterator localIterator = localDataType.getFields().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Field)localIterator.next();
      Object localObject2 = paramDataPoint.getValue((Field)localObject1);
      if (!((Value)localObject2).isSet())
      {
        if (!zzaxk.contains(((Field)localObject1).getName())) {
          return ((Field)localObject1).getName() + " not set";
        }
      }
      else
      {
        if (((Field)localObject1).getFormat() == 1) {}
        for (double d = ((Value)localObject2).asInt();; d = ((Value)localObject2).asFloat())
        {
          localObject2 = zzoq.zzud().zzdq(((Field)localObject1).getName());
          if ((localObject2 == null) || (((zzoq.zza)localObject2).zzh(d))) {
            break label174;
          }
          return "Field out of range";
          if (((Field)localObject1).getFormat() != 2) {
            break;
          }
        }
        label174:
        localObject1 = zzoq.zzud().zzD(localDataType.getName(), ((Field)localObject1).getName());
        if (localObject1 != null)
        {
          long l = paramDataPoint.getTimestampNanos() - paramDataPoint.zztH();
          if (l == 0L)
          {
            if (d == 0.0D) {
              return null;
            }
            return "DataPoint out of range";
          }
          if (!((zzoq.zza)localObject1).zzh(d / l)) {
            return "DataPoint out of range";
          }
        }
      }
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */