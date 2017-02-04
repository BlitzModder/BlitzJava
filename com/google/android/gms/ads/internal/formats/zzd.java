package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcr.zza;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public class zzd
  extends zzcr.zza
  implements zzh.zza
{
  private Bundle mExtras;
  private Object zzpK = new Object();
  private String zzxA;
  private zzcn zzxB;
  private String zzxC;
  private double zzxD;
  private String zzxE;
  private String zzxF;
  private zza zzxG;
  private zzh zzxH;
  private String zzxy;
  private List<zzc> zzxz;
  
  public zzd(String paramString1, List paramList, String paramString2, zzcn paramzzcn, String paramString3, double paramDouble, String paramString4, String paramString5, zza paramzza, Bundle paramBundle)
  {
    this.zzxy = paramString1;
    this.zzxz = paramList;
    this.zzxA = paramString2;
    this.zzxB = paramzzcn;
    this.zzxC = paramString3;
    this.zzxD = paramDouble;
    this.zzxE = paramString4;
    this.zzxF = paramString5;
    this.zzxG = paramzza;
    this.mExtras = paramBundle;
  }
  
  public void destroy()
  {
    this.zzxy = null;
    this.zzxz = null;
    this.zzxA = null;
    this.zzxB = null;
    this.zzxC = null;
    this.zzxD = 0.0D;
    this.zzxE = null;
    this.zzxF = null;
    this.zzxG = null;
    this.mExtras = null;
    this.zzpK = null;
    this.zzxH = null;
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
  
  public String getPrice()
  {
    return this.zzxF;
  }
  
  public double getStarRating()
  {
    return this.zzxD;
  }
  
  public String getStore()
  {
    return this.zzxE;
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (this.zzpK)
    {
      this.zzxH = paramzzh;
      return;
    }
  }
  
  public zzcn zzdD()
  {
    return this.zzxB;
  }
  
  public com.google.android.gms.dynamic.zzd zzdE()
  {
    return zze.zzB(this.zzxH);
  }
  
  public String zzdF()
  {
    return "2";
  }
  
  public zza zzdG()
  {
    return this.zzxG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */