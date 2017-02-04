package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzay
  extends zzak
{
  private static final String ID = zzad.zzbU.toString();
  private static final String zzbdJ = zzae.zzdM.toString();
  private static final String zzbeb = zzae.zzfL.toString();
  private static final String zzbec = zzae.zzfP.toString();
  private static final String zzbed = zzae.zzfi.toString();
  
  public zzay()
  {
    super(ID, new String[] { zzbdJ });
  }
  
  private String zza(String paramString, zza paramzza, Set<Character> paramSet)
  {
    switch (1.zzbee[paramzza.ordinal()])
    {
    default: 
      return paramString;
    case 1: 
      try
      {
        paramzza = zzdj.zzfM(paramString);
        return paramzza;
      }
      catch (UnsupportedEncodingException paramzza)
      {
        zzbg.zzb("Joiner: unsupported encoding", paramzza);
        return paramString;
      }
    }
    paramString = paramString.replace("\\", "\\\\");
    paramzza = paramSet.iterator();
    while (paramzza.hasNext())
    {
      paramSet = ((Character)paramzza.next()).toString();
      paramString = paramString.replace(paramSet, "\\" + paramSet);
    }
    return paramString;
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zza paramzza, Set<Character> paramSet)
  {
    paramStringBuilder.append(zza(paramString, paramzza, paramSet));
  }
  
  private void zza(Set<Character> paramSet, String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    zzag.zza localzza = (zzag.zza)paramMap.get(zzbdJ);
    if (localzza == null) {
      return zzdf.zzFJ();
    }
    Object localObject1 = (zzag.zza)paramMap.get(zzbeb);
    String str1;
    Object localObject2;
    if (localObject1 != null)
    {
      str1 = zzdf.zzg((zzag.zza)localObject1);
      localObject1 = (zzag.zza)paramMap.get(zzbec);
      if (localObject1 == null) {
        break label186;
      }
      localObject2 = zzdf.zzg((zzag.zza)localObject1);
      label75:
      localObject1 = zza.zzbef;
      paramMap = (zzag.zza)paramMap.get(zzbed);
      if (paramMap == null) {
        break label418;
      }
      paramMap = zzdf.zzg(paramMap);
      if (!"url".equals(paramMap)) {
        break label193;
      }
      localObject1 = zza.zzbeg;
      paramMap = null;
    }
    for (;;)
    {
      label118:
      StringBuilder localStringBuilder = new StringBuilder();
      switch (localzza.type)
      {
      default: 
        zza(localStringBuilder, zzdf.zzg(localzza), (zza)localObject1, paramMap);
      }
      for (;;)
      {
        return zzdf.zzR(localStringBuilder.toString());
        str1 = "";
        break;
        label186:
        localObject2 = "=";
        break label75;
        label193:
        if ("backslash".equals(paramMap))
        {
          localObject1 = zza.zzbeh;
          paramMap = new HashSet();
          zza(paramMap, str1);
          zza(paramMap, (String)localObject2);
          paramMap.remove(Character.valueOf('\\'));
          break label118;
        }
        zzbg.e("Joiner: unsupported escape type: " + paramMap);
        return zzdf.zzFJ();
        int j = 1;
        localObject2 = localzza.zzjp;
        int k = localObject2.length;
        int i = 0;
        while (i < k)
        {
          localzza = localObject2[i];
          if (j == 0) {
            localStringBuilder.append(str1);
          }
          zza(localStringBuilder, zzdf.zzg(localzza), (zza)localObject1, paramMap);
          i += 1;
          j = 0;
        }
        i = 0;
        while (i < localzza.zzjq.length)
        {
          if (i > 0) {
            localStringBuilder.append(str1);
          }
          String str2 = zzdf.zzg(localzza.zzjq[i]);
          String str3 = zzdf.zzg(localzza.zzjr[i]);
          zza(localStringBuilder, str2, (zza)localObject1, paramMap);
          localStringBuilder.append((String)localObject2);
          zza(localStringBuilder, str3, (zza)localObject1, paramMap);
          i += 1;
        }
      }
      label418:
      paramMap = null;
    }
  }
  
  private static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */