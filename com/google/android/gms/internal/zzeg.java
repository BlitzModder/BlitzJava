package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzeg
  extends zzs.zza
{
  private zzec zzAd;
  private zzgg zzAe;
  private String zzAf;
  private String zzpH;
  private zzea zzzU;
  private zzk zzzX;
  
  public zzeg(Context paramContext, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    this(paramString, new zzea(paramContext.getApplicationContext(), paramzzew, paramVersionInfoParcel, paramzzd));
  }
  
  public zzeg(String paramString, zzea paramzzea)
  {
    this.zzpH = paramString;
    this.zzzU = paramzzea;
    this.zzAd = new zzec();
    zzp.zzbI().zza(paramzzea);
  }
  
  private void zzee()
  {
    if ((this.zzzX != null) && (this.zzAe != null)) {
      this.zzzX.zza(this.zzAe, this.zzAf);
    }
  }
  
  void abort()
  {
    if (this.zzzX != null) {
      return;
    }
    this.zzzX = this.zzzU.zzac(this.zzpH);
    this.zzAd.zzc(this.zzzX);
    zzee();
  }
  
  public void destroy()
    throws RemoteException
  {
    if (this.zzzX != null) {
      this.zzzX.destroy();
    }
  }
  
  public String getMediationAdapterClassName()
    throws RemoteException
  {
    if (this.zzzX != null) {
      return this.zzzX.getMediationAdapterClassName();
    }
    return null;
  }
  
  public boolean isLoading()
    throws RemoteException
  {
    return (this.zzzX != null) && (this.zzzX.isLoading());
  }
  
  public boolean isReady()
    throws RemoteException
  {
    return (this.zzzX != null) && (this.zzzX.isReady());
  }
  
  public void pause()
    throws RemoteException
  {
    if (this.zzzX != null) {
      this.zzzX.pause();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    if (this.zzzX != null) {
      this.zzzX.resume();
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException
  {
    abort();
    if (this.zzzX != null) {
      this.zzzX.setManualImpressionsEnabled(paramBoolean);
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (this.zzzX != null)
    {
      this.zzzX.showInterstitial();
      return;
    }
    zzb.zzaH("Interstitial ad must be loaded before showInterstitial().");
  }
  
  public void stopLoading()
    throws RemoteException
  {
    if (this.zzzX != null) {
      this.zzzX.stopLoading();
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
    throws RemoteException
  {
    if (this.zzzX != null) {
      this.zzzX.zza(paramAdSizeParcel);
    }
  }
  
  public void zza(zzn paramzzn)
    throws RemoteException
  {
    this.zzAd.zzzP = paramzzn;
    if (this.zzzX != null) {
      this.zzAd.zzc(this.zzzX);
    }
  }
  
  public void zza(zzo paramzzo)
    throws RemoteException
  {
    this.zzAd.zzpz = paramzzo;
    if (this.zzzX != null) {
      this.zzAd.zzc(this.zzzX);
    }
  }
  
  public void zza(zzu paramzzu)
    throws RemoteException
  {
    this.zzAd.zzzM = paramzzu;
    if (this.zzzX != null) {
      this.zzAd.zzc(this.zzzX);
    }
  }
  
  public void zza(zzv paramzzv)
    throws RemoteException
  {
    abort();
    if (this.zzzX != null) {
      this.zzzX.zza(paramzzv);
    }
  }
  
  public void zza(zzcl paramzzcl)
    throws RemoteException
  {
    this.zzAd.zzzO = paramzzcl;
    if (this.zzzX != null) {
      this.zzAd.zzc(this.zzzX);
    }
  }
  
  public void zza(zzgc paramzzgc)
    throws RemoteException
  {
    this.zzAd.zzzN = paramzzgc;
    if (this.zzzX != null) {
      this.zzAd.zzc(this.zzzX);
    }
  }
  
  public void zza(zzgg paramzzgg, String paramString)
    throws RemoteException
  {
    this.zzAe = paramzzgg;
    this.zzAf = paramString;
    zzee();
  }
  
  public com.google.android.gms.dynamic.zzd zzaO()
    throws RemoteException
  {
    if (this.zzzX != null) {
      return this.zzzX.zzaO();
    }
    return null;
  }
  
  public AdSizeParcel zzaP()
    throws RemoteException
  {
    if (this.zzzX != null) {
      return this.zzzX.zzaP();
    }
    return null;
  }
  
  public void zzaR()
    throws RemoteException
  {
    if (this.zzzX != null)
    {
      this.zzzX.zzaR();
      return;
    }
    zzb.zzaH("Interstitial ad must be loaded before pingManualTrackingUrl().");
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
    throws RemoteException
  {
    if (paramAdRequestParcel.zztx != null) {
      abort();
    }
    if (this.zzzX != null) {
      return this.zzzX.zzb(paramAdRequestParcel);
    }
    zzef.zza localzza = zzp.zzbI().zza(paramAdRequestParcel, this.zzpH);
    if (localzza != null)
    {
      if (!localzza.zzAa) {
        localzza.zzh(paramAdRequestParcel);
      }
      this.zzzX = localzza.zzzX;
      localzza.zzc(this.zzzU);
      localzza.zzzY.zza(this.zzAd);
      this.zzAd.zzc(this.zzzX);
      zzee();
      return localzza.zzAb;
    }
    this.zzzX = this.zzzU.zzac(this.zzpH);
    this.zzAd.zzc(this.zzzX);
    zzee();
    return this.zzzX.zzb(paramAdRequestParcel);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */