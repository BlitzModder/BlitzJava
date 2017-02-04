package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;

@zzha
public class zzj
  extends zzq.zza
{
  private final Context mContext;
  private NativeAdOptionsParcel zzpE;
  private zzv zzpG;
  private final String zzpH;
  private final VersionInfoParcel zzpI;
  private zzcx zzpN;
  private zzcy zzpO;
  private SimpleArrayMap<String, zzcz> zzpP;
  private SimpleArrayMap<String, zzda> zzpQ;
  private final zzew zzpd;
  private zzo zzpz;
  
  public zzj(Context paramContext, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpH = paramString;
    this.zzpd = paramzzew;
    this.zzpI = paramVersionInfoParcel;
    this.zzpQ = new SimpleArrayMap();
    this.zzpP = new SimpleArrayMap();
  }
  
  public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    this.zzpE = paramNativeAdOptionsParcel;
  }
  
  public void zza(zzcx paramzzcx)
  {
    this.zzpN = paramzzcx;
  }
  
  public void zza(zzcy paramzzcy)
  {
    this.zzpO = paramzzcy;
  }
  
  public void zza(String paramString, zzda paramzzda, zzcz paramzzcz)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    this.zzpQ.put(paramString, paramzzda);
    this.zzpP.put(paramString, paramzzcz);
  }
  
  public void zzb(zzo paramzzo)
  {
    this.zzpz = paramzzo;
  }
  
  public void zzb(zzv paramzzv)
  {
    this.zzpG = paramzzv;
  }
  
  public zzp zzbm()
  {
    return new zzi(this.mContext, this.zzpH, this.zzpd, this.zzpI, this.zzpz, this.zzpN, this.zzpO, this.zzpQ, this.zzpP, this.zzpE, this.zzpG);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */