package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjn;

@zzha
public class zze
{
  private zza zzpo;
  private boolean zzpp;
  private boolean zzpq;
  
  public zze()
  {
    this.zzpq = ((Boolean)zzbz.zzvn.get()).booleanValue();
  }
  
  public zze(boolean paramBoolean)
  {
    this.zzpq = paramBoolean;
  }
  
  public void recordClick()
  {
    this.zzpp = true;
  }
  
  public void zza(zza paramzza)
  {
    this.zzpo = paramzza;
  }
  
  public boolean zzbg()
  {
    return (!this.zzpq) || (this.zzpp);
  }
  
  public void zzp(String paramString)
  {
    zzb.zzaF("Action was blocked because no click was detected.");
    if (this.zzpo != null) {
      this.zzpo.zzq(paramString);
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzq(String paramString);
  }
  
  @zzha
  public static class zzb
    implements zze.zza
  {
    private final zzie.zza zzpr;
    private final zzjn zzps;
    
    public zzb(zzie.zza paramzza, zzjn paramzzjn)
    {
      this.zzpr = paramzza;
      this.zzps = paramzzjn;
    }
    
    public void zzq(String paramString)
    {
      zzb.zzaF("An auto-clicking creative is blocked");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https");
      localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
      localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(paramString)) {
        localBuilder.appendQueryParameter("navigationURL", paramString);
      }
      if ((this.zzpr != null) && (this.zzpr.zzJL != null) && (!TextUtils.isEmpty(this.zzpr.zzJL.zzGS))) {
        localBuilder.appendQueryParameter("debugDialog", this.zzpr.zzJL.zzGS);
      }
      zzp.zzbx().zzc(this.zzps.getContext(), this.zzps.zzhF().afmaVersion, localBuilder.toString());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */