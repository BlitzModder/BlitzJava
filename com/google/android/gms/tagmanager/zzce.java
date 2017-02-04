package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzce
  extends zzak
{
  private static final String ID = zzad.zzbW.toString();
  private static final String zzbeT = zzae.zzdM.toString();
  private static final String zzbeU = zzae.zzdN.toString();
  private static final String zzbeV = zzae.zzfF.toString();
  private static final String zzbeW = zzae.zzfz.toString();
  
  public zzce()
  {
    super(ID, new String[] { zzbeT, zzbeU });
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzbeT);
    zzag.zza localzza = (zzag.zza)paramMap.get(zzbeU);
    if ((localObject == null) || (localObject == zzdf.zzFJ()) || (localzza == null) || (localzza == zzdf.zzFJ())) {
      return zzdf.zzFJ();
    }
    int i = 64;
    if (zzdf.zzk((zzag.zza)paramMap.get(zzbeV)).booleanValue()) {
      i = 66;
    }
    paramMap = (zzag.zza)paramMap.get(zzbeW);
    int j;
    if (paramMap != null)
    {
      paramMap = zzdf.zzi(paramMap);
      if (paramMap == zzdf.zzFE()) {
        return zzdf.zzFJ();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return zzdf.zzFJ();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = zzdf.zzg((zzag.zza)localObject);
      localObject = zzdf.zzg(localzza);
      localzza = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = localzza;
      if (((Matcher)localObject).find())
      {
        paramMap = localzza;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return zzdf.zzFJ();
      }
      paramMap = zzdf.zzR(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return zzdf.zzFJ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */