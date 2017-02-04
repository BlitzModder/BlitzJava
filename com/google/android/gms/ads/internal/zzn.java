package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzip;
import java.util.List;

@zzha
public class zzn
  extends zzb
{
  public zzn(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzew, paramVersionInfoParcel, null);
  }
  
  private static zzd zza(zzfa paramzzfa)
    throws RemoteException
  {
    String str1 = paramzzfa.getHeadline();
    List localList = paramzzfa.getImages();
    String str2 = paramzzfa.getBody();
    if (paramzzfa.zzdD() != null) {}
    for (zzcn localzzcn = paramzzfa.zzdD();; localzzcn = null) {
      return new zzd(str1, localList, str2, localzzcn, paramzzfa.getCallToAction(), paramzzfa.getStarRating(), paramzzfa.getStore(), paramzzfa.getPrice(), null, paramzzfa.getExtras());
    }
  }
  
  private static zze zza(zzfb paramzzfb)
    throws RemoteException
  {
    String str1 = paramzzfb.getHeadline();
    List localList = paramzzfb.getImages();
    String str2 = paramzzfb.getBody();
    if (paramzzfb.zzdH() != null) {}
    for (zzcn localzzcn = paramzzfb.zzdH();; localzzcn = null) {
      return new zze(str1, localList, str2, localzzcn, paramzzfb.getCallToAction(), paramzzfb.getAdvertiser(), null, paramzzfb.getExtras());
    }
  }
  
  private void zza(final zzd paramzzd)
  {
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        try
        {
          zzn.this.zzoZ.zzrf.zza(paramzzd);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zze paramzze)
  {
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        try
        {
          zzn.this.zzoZ.zzrg.zza(paramzze);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zzie paramzzie, final String paramString)
  {
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ((zzda)zzn.this.zzoZ.zzri.get(paramString)).zza((zzf)paramzzie.zzJJ);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  public void pause()
  {
    throw new IllegalStateException("Native Ad DOES NOT support pause().");
  }
  
  public void recordImpression()
  {
    zza(this.zzoZ.zzqW, false);
  }
  
  public void resume()
  {
    throw new IllegalStateException("Native Ad DOES NOT support resume().");
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
  }
  
  public void zza(SimpleArrayMap<String, zzda> paramSimpleArrayMap)
  {
    zzx.zzcx("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    this.zzoZ.zzri = paramSimpleArrayMap;
  }
  
  public void zza(zzh paramzzh)
  {
    if (this.zzoZ.zzqW.zzJE != null) {
      zzp.zzbA().zzgR().zza(this.zzoZ.zzqV, this.zzoZ.zzqW, paramzzh);
    }
  }
  
  public void zza(zzcl paramzzcl)
  {
    throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
  }
  
  public void zza(zzgc paramzzgc)
  {
    throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
  }
  
  public void zza(final zzie.zza paramzza, zzch paramzzch)
  {
    if (paramzza.zzqV != null) {
      this.zzoZ.zzqV = paramzza.zzqV;
    }
    if (paramzza.errorCode != -2)
    {
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzn.this.zzb(new zzie(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    this.zzoZ.zzrp = 0;
    this.zzoZ.zzqU = zzp.zzbw().zza(this.zzoZ.context, this, paramzza, this.zzoZ.zzqQ, null, this.zzpd, this, paramzzch);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzoZ.zzqU.getClass().getName());
  }
  
  public void zza(List<String> paramList)
  {
    zzx.zzcx("setNativeTemplates must be called on the main UI thread.");
    this.zzoZ.zzrl = paramList;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzie paramzzie, boolean paramBoolean)
  {
    return this.zzoY.zzbr();
  }
  
  protected boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    zza(null);
    if (!this.zzoZ.zzbQ()) {
      throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }
    if (paramzzie2.zzGN) {}
    for (;;)
    {
      try
      {
        localObject1 = paramzzie2.zzBq.zzeu();
        localObject2 = paramzzie2.zzBq.zzev();
        if (localObject1 == null) {
          continue;
        }
        localObject2 = zza((zzfa)localObject1);
        ((zzd)localObject2).zzb(new zzg(this.zzoZ.context, this, this.zzoZ.zzqQ, (zzfa)localObject1));
        zza((zzd)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject1;
        Object localObject2;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get native ad mapper", localRemoteException);
        continue;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching mapper for retrieved native ad template.");
        zzf(0);
        return false;
      }
      return super.zza(paramzzie1, paramzzie2);
      if (localObject2 != null)
      {
        localObject1 = zza((zzfb)localObject2);
        ((zze)localObject1).zzb(new zzg(this.zzoZ.context, this, this.zzoZ.zzqQ, (zzfb)localObject2));
        zza((zze)localObject1);
      }
      else
      {
        zzh.zza localzza = paramzzie2.zzJJ;
        if (((localzza instanceof zze)) && (this.zzoZ.zzrg != null))
        {
          zza((zze)paramzzie2.zzJJ);
        }
        else if (((localzza instanceof zzd)) && (this.zzoZ.zzrf != null))
        {
          zza((zzd)paramzzie2.zzJJ);
        }
        else
        {
          if ((!(localzza instanceof zzf)) || (this.zzoZ.zzri == null) || (this.zzoZ.zzri.get(((zzf)localzza).getCustomTemplateId()) == null)) {
            break;
          }
          zza(paramzzie2, ((zzf)localzza).getCustomTemplateId());
        }
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching listener for retrieved native ad template.");
    zzf(0);
    return false;
  }
  
  public void zzb(SimpleArrayMap<String, zzcz> paramSimpleArrayMap)
  {
    zzx.zzcx("setOnCustomClickListener must be called on the main UI thread.");
    this.zzoZ.zzrh = paramSimpleArrayMap;
  }
  
  public void zzb(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    zzx.zzcx("setNativeAdOptions must be called on the main UI thread.");
    this.zzoZ.zzrj = paramNativeAdOptionsParcel;
  }
  
  public void zzb(zzcx paramzzcx)
  {
    zzx.zzcx("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
    this.zzoZ.zzrf = paramzzcx;
  }
  
  public void zzb(zzcy paramzzcy)
  {
    zzx.zzcx("setOnContentAdLoadedListener must be called on the main UI thread.");
    this.zzoZ.zzrg = paramzzcy;
  }
  
  public SimpleArrayMap<String, zzda> zzbq()
  {
    zzx.zzcx("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    return this.zzoZ.zzri;
  }
  
  public zzcz zzr(String paramString)
  {
    zzx.zzcx("getOnCustomClickListener must be called on the main UI thread.");
    return (zzcz)this.zzoZ.zzrh.get(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */