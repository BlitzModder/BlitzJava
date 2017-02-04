package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzct.zza;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public class zze
  extends zzct.zza
  implements zzh.zza
{
  private Bundle mExtras;
  private Object zzpK = new Object();
  private String zzxA;
  private String zzxC;
  private zza zzxG;
  private zzh zzxH;
  private zzcn zzxI;
  private String zzxJ;
  private String zzxy;
  private List<zzc> zzxz;
  
  public zze(String paramString1, List paramList, String paramString2, zzcn paramzzcn, String paramString3, String paramString4, zza paramzza, Bundle paramBundle)
  {
    this.zzxy = paramString1;
    this.zzxz = paramList;
    this.zzxA = paramString2;
    this.zzxI = paramzzcn;
    this.zzxC = paramString3;
    this.zzxJ = paramString4;
    this.zzxG = paramzza;
    this.mExtras = paramBundle;
  }
  
  public void destroy()
  {
    this.zzxy = null;
    this.zzxz = null;
    this.zzxA = null;
    this.zzxI = null;
    this.zzxC = null;
    this.zzxJ = null;
    this.zzxG = null;
    this.mExtras = null;
    this.zzpK = null;
    this.zzxH = null;
  }
  
  public String getAdvertiser()
  {
    return this.zzxJ;
  }
  
  public String getBody()
  {
    return this.zzxA;
  }
  
  public String getCallToAction()
  {
    return this.zzxC;
  }
  
  public String getCustomTemplateId()
  {
    return "";
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getHeadline()
  {
    return this.zzxy;
  }
  
  public List getImages()
  {
    return this.zzxz;
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (this.zzpK)
    {
      this.zzxH = paramzzh;
      return;
    }
  }
  
  public zzd zzdE()
  {
    return com.google.android.gms.dynamic.zze.zzB(this.zzxH);
  }
  
  public String zzdF()
  {
    return "1";
  }
  
  public zza zzdG()
  {
    return this.zzxG;
  }
  
  public zzcn zzdH()
  {
    return this.zzxI;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */