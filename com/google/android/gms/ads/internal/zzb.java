package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzha
public abstract class zzb
  extends zza
  implements com.google.android.gms.ads.internal.overlay.zzg, zzj, zzdn, zzeo
{
  private final Messenger mMessenger;
  protected final zzew zzpd;
  protected transient boolean zzpe;
  
  public zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this(new zzq(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramzzew, null, paramzzd);
  }
  
  zzb(zzq paramzzq, zzew paramzzew, zzo paramzzo, zzd paramzzd)
  {
    super(paramzzq, paramzzo, paramzzd);
    this.zzpd = paramzzew;
    this.mMessenger = new Messenger(new zzfz(this.zzoZ.context));
    this.zzpe = false;
  }
  
  private AdRequestInfoParcel.zza zza(AdRequestParcel paramAdRequestParcel, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.zzoZ.context.getApplicationInfo();
    DisplayMetrics localDisplayMetrics;
    String str1;
    Object localObject;
    String str2;
    long l1;
    Bundle localBundle;
    ArrayList localArrayList;
    PackageInfo localPackageInfo2;
    try
    {
      PackageInfo localPackageInfo1 = this.zzoZ.context.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localDisplayMetrics = this.zzoZ.context.getResources().getDisplayMetrics();
      str1 = null;
      localObject = str1;
      if (this.zzoZ.zzqS != null)
      {
        localObject = str1;
        if (this.zzoZ.zzqS.getParent() != null)
        {
          localObject = new int[2];
          this.zzoZ.zzqS.getLocationOnScreen((int[])localObject);
          int k = localObject[0];
          int m = localObject[1];
          int n = this.zzoZ.zzqS.getWidth();
          int i1 = this.zzoZ.zzqS.getHeight();
          int j = 0;
          i = j;
          if (this.zzoZ.zzqS.isShown())
          {
            i = j;
            if (k + n > 0)
            {
              i = j;
              if (m + i1 > 0)
              {
                i = j;
                if (k <= localDisplayMetrics.widthPixels)
                {
                  i = j;
                  if (m <= localDisplayMetrics.heightPixels) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject = new Bundle(5);
          ((Bundle)localObject).putInt("x", k);
          ((Bundle)localObject).putInt("y", m);
          ((Bundle)localObject).putInt("width", n);
          ((Bundle)localObject).putInt("height", i1);
          ((Bundle)localObject).putInt("visible", i);
        }
      }
      str1 = zzp.zzbA().zzgK();
      this.zzoZ.zzqY = new zzif(str1, this.zzoZ.zzqP);
      this.zzoZ.zzqY.zzj(paramAdRequestParcel);
      str2 = zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqS, this.zzoZ.zzqV);
      l2 = 0L;
      l1 = l2;
      if (this.zzoZ.zzrc == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        l1 = this.zzoZ.zzrc.getValue();
        String str3 = UUID.randomUUID().toString();
        localBundle = zzp.zzbA().zza(this.zzoZ.context, this, str1);
        localArrayList = new ArrayList();
        int i = 0;
        while (i < this.zzoZ.zzri.size())
        {
          localArrayList.add(this.zzoZ.zzri.keyAt(i));
          i += 1;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo2 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          long l2;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if (this.zzoZ.zzrd != null)
    {
      bool1 = true;
      if ((this.zzoZ.zzre == null) || (!zzp.zzbA().zzgT())) {
        break label622;
      }
    }
    label622:
    for (boolean bool2 = true;; bool2 = false)
    {
      return new AdRequestInfoParcel.zza((Bundle)localObject, paramAdRequestParcel, this.zzoZ.zzqV, this.zzoZ.zzqP, localApplicationInfo, localPackageInfo2, str1, zzp.zzbA().getSessionId(), this.zzoZ.zzqR, localBundle, this.zzoZ.zzrl, localArrayList, paramBundle, zzp.zzbA().zzgO(), this.mMessenger, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.density, str2, l1, localRemoteException, zzbz.zzdl(), this.zzoZ.zzqO, this.zzoZ.zzrj, new CapabilityParcel(bool1, bool2), this.zzoZ.zzbU());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (this.zzoZ.zzqW == null) {
      return null;
    }
    return this.zzoZ.zzqW.zzBr;
  }
  
  public void onAdClicked()
  {
    if (this.zzoZ.zzqW == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((this.zzoZ.zzqW.zzJF != null) && (this.zzoZ.zzqW.zzJF.zzAQ != null)) {
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzJF.zzAQ);
    }
    if ((this.zzoZ.zzqW.zzBp != null) && (this.zzoZ.zzqW.zzBp.zzAJ != null)) {
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAJ);
    }
    super.onAdClicked();
  }
  
  public void pause()
  {
    zzx.zzcx("pause must be called on the main UI thread.");
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzbQ())) {
      zzp.zzbz().zzf(this.zzoZ.zzqW.zzDC);
    }
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzBq != null)) {}
    try
    {
      this.zzoZ.zzqW.zzBq.pause();
      this.zzpb.zzg(this.zzoZ.zzqW);
      this.zzoY.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    zzx.zzcx("resume must be called on the main UI thread.");
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzDC != null) && (this.zzoZ.zzbQ())) {
      zzp.zzbz().zzg(this.zzoZ.zzqW.zzDC);
    }
    if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzBq != null)) {}
    try
    {
      this.zzoZ.zzqW.zzBq.resume();
      this.zzoY.resume();
      this.zzpb.zzh(this.zzoZ.zzqW);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzgc paramzzgc)
  {
    zzx.zzcx("setInAppPurchaseListener must be called on the main UI thread.");
    this.zzoZ.zzrd = paramzzgc;
  }
  
  public void zza(zzgg paramzzgg, String paramString)
  {
    zzx.zzcx("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.zzoZ.zzrm = new zzk(paramString);
    this.zzoZ.zzre = paramzzgg;
    if ((!zzp.zzbA().zzgN()) && (paramzzgg != null)) {
      new zzc(this.zzoZ.context, this.zzoZ.zzre, this.zzoZ.zzrm).zzgX();
    }
  }
  
  protected void zza(zzie paramzzie, boolean paramBoolean)
  {
    if (paramzzie == null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramzzie);
      if ((paramzzie.zzJF != null) && (paramzzie.zzJF.zzAR != null)) {
        zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, paramBoolean, paramzzie.zzJF.zzAR);
      }
    } while ((paramzzie.zzBp == null) || (paramzzie.zzBp.zzAK == null));
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, paramBoolean, paramzzie.zzBp.zzAK);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, this.zzoZ.context, this.zzoZ.zzqR.afmaVersion);
    if (this.zzoZ.zzrd == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!zzl.zzcN().zzT(this.zzoZ.context))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (this.zzoZ.zzre == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
        return;
      }
      if (this.zzoZ.zzrm == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (this.zzoZ.zzrq)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
        return;
      }
      this.zzoZ.zzrq = true;
      try
      {
        if (!this.zzoZ.zzre.isValidPurchase(paramString))
        {
          this.zzoZ.zzrq = false;
          return;
        }
      }
      catch (RemoteException paramString)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        this.zzoZ.zzrq = false;
        return;
      }
      zzp.zzbH().zza(this.zzoZ.context, this.zzoZ.zzqR.zzLH, new GInAppPurchaseManagerInfoParcel(this.zzoZ.context, this.zzoZ.zzrm, paramArrayList, this));
      return;
    }
    try
    {
      this.zzoZ.zzrd.zza(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramzzf)
  {
    try
    {
      if (this.zzoZ.zzre != null) {
        this.zzoZ.zzre.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzoZ.context, paramString, paramBoolean, paramInt, paramIntent, paramzzf));
      }
      zzip.zzKO.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzp.zzbH().zzd(paramIntent);
          zzp.zzbH();
          if ((i == 0) && (zzb.this.zzoZ.zzqW != null) && (zzb.this.zzoZ.zzqW.zzDC != null) && (zzb.this.zzoZ.zzqW.zzDC.zzhA() != null)) {
            zzb.this.zzoZ.zzqW.zzDC.zzhA().close();
          }
          zzb.this.zzoZ.zzrq = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzch paramzzch)
  {
    if (!zzaW()) {
      return false;
    }
    Bundle localBundle = zza(zzp.zzbA().zzG(this.zzoZ.context));
    this.zzoY.cancel();
    this.zzoZ.zzrp = 0;
    paramAdRequestParcel = zza(paramAdRequestParcel, localBundle);
    paramzzch.zzd("seq_num", paramAdRequestParcel.zzGt);
    paramzzch.zzd("request_id", paramAdRequestParcel.zzGF);
    paramzzch.zzd("session_id", paramAdRequestParcel.zzGu);
    if (paramAdRequestParcel.zzGr != null) {
      paramzzch.zzd("app_version", String.valueOf(paramAdRequestParcel.zzGr.versionCode));
    }
    this.zzoZ.zzqT = zzp.zzbt().zza(this.zzoZ.context, paramAdRequestParcel, this.zzoZ.zzqQ, this);
    return true;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzie paramzzie, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.zzoZ.zzbQ()))
    {
      if (paramzzie.zzAU <= 0L) {
        break label43;
      }
      this.zzoY.zza(paramAdRequestParcel, paramzzie.zzAU);
    }
    for (;;)
    {
      return this.zzoY.zzbr();
      label43:
      if ((paramzzie.zzJF != null) && (paramzzie.zzJF.zzAU > 0L)) {
        this.zzoY.zza(paramAdRequestParcel, paramzzie.zzJF.zzAU);
      } else if ((!paramzzie.zzGN) && (paramzzie.errorCode == 2)) {
        this.zzoY.zzg(paramAdRequestParcel);
      }
    }
  }
  
  boolean zza(zzie paramzzie)
  {
    boolean bool = false;
    Object localObject;
    if (this.zzpa != null)
    {
      localObject = this.zzpa;
      this.zzpa = null;
    }
    for (;;)
    {
      return zza((AdRequestParcel)localObject, paramzzie, bool);
      AdRequestParcel localAdRequestParcel = paramzzie.zzGq;
      localObject = localAdRequestParcel;
      if (localAdRequestParcel.extras != null)
      {
        bool = localAdRequestParcel.extras.getBoolean("_noRefresh", false);
        localObject = localAdRequestParcel;
      }
    }
  }
  
  protected boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    int i = 0;
    if ((paramzzie1 != null) && (paramzzie1.zzBs != null)) {
      paramzzie1.zzBs.zza(null);
    }
    if (paramzzie2.zzBs != null) {
      paramzzie2.zzBs.zza(this);
    }
    int j;
    if (paramzzie2.zzJF != null)
    {
      j = paramzzie2.zzJF.zzAZ;
      i = paramzzie2.zzJF.zzBa;
    }
    for (;;)
    {
      this.zzoZ.zzrn.zzg(j, i);
      return true;
      j = 0;
    }
  }
  
  protected boolean zzaW()
  {
    boolean bool = true;
    if ((!zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET")) || (!zzp.zzbx().zzJ(this.zzoZ.context))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzaX()
  {
    this.zzpb.zze(this.zzoZ.zzqW);
    this.zzpe = false;
    zzaS();
    this.zzoZ.zzqY.zzgF();
  }
  
  public void zzaY()
  {
    this.zzpe = true;
    zzaU();
  }
  
  public void zzaZ()
  {
    onAdClicked();
  }
  
  public void zzb(zzie paramzzie)
  {
    super.zzb(paramzzie);
    if ((paramzzie.errorCode == 3) && (paramzzie.zzJF != null) && (paramzzie.zzJF.zzAS != null))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
      zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, paramzzie, this.zzoZ.zzqP, false, paramzzie.zzJF.zzAS);
    }
  }
  
  public void zzba()
  {
    zzaX();
  }
  
  public void zzbb()
  {
    zzaQ();
  }
  
  public void zzbc()
  {
    zzaY();
  }
  
  public void zzbd()
  {
    if (this.zzoZ.zzqW != null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Mediation adapter " + this.zzoZ.zzqW.zzBr + " refreshed, but mediation adapters should never refresh.");
    }
    zza(this.zzoZ.zzqW, true);
    zzaV();
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    return (super.zzc(paramAdRequestParcel)) && (!this.zzpe);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */