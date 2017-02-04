package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap
  extends zzak
{
  private static final String ID = zzad.zzbS.toString();
  private static final String zzbdJ = zzae.zzdM.toString();
  private static final String zzbdL = zzae.zzfH.toString();
  private static final String zzbdP = zzae.zzdC.toString();
  
  public zzap()
  {
    super(ID, new String[] { zzbdJ });
  }
  
  private byte[] zzd(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public boolean zzEa()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzbdJ);
    if ((localObject == null) || (localObject == zzdf.zzFJ())) {
      return zzdf.zzFJ();
    }
    String str = zzdf.zzg((zzag.zza)localObject);
    localObject = (zzag.zza)paramMap.get(zzbdP);
    if (localObject == null)
    {
      localObject = "MD5";
      paramMap = (zzag.zza)paramMap.get(zzbdL);
      if (paramMap != null) {
        break label110;
      }
      paramMap = "text";
      label73:
      if (!"text".equals(paramMap)) {
        break label118;
      }
      paramMap = str.getBytes();
    }
    for (;;)
    {
      try
      {
        paramMap = zzdf.zzR(zzk.zzj(zzd((String)localObject, paramMap)));
        return paramMap;
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label110:
        label118:
        zzbg.e("Hash: unknown algorithm: " + (String)localObject);
      }
      localObject = zzdf.zzg((zzag.zza)localObject);
      break;
      paramMap = zzdf.zzg(paramMap);
      break label73;
      if ("base16".equals(paramMap))
      {
        paramMap = zzk.zzfa(str);
      }
      else
      {
        zzbg.e("Hash: unknown input format: " + paramMap);
        return zzdf.zzFJ();
      }
    }
    return zzdf.zzFJ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */