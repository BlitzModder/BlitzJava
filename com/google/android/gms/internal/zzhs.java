package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@zzha
public class zzhs
  extends com.google.android.gms.ads.internal.zzb
  implements zzhw
{
  private zzd zzJf;
  private String zzJg;
  private boolean zzJh;
  private HashMap<String, zzht> zzJi = new HashMap();
  
  public zzhs(Context paramContext, AdSizeParcel paramAdSizeParcel, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramzzew, paramVersionInfoParcel, null);
  }
  
  public void destroy()
  {
    zzx.zzcx("destroy must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().destroy();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to destroy adapter: " + str);
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzx.zzcx("isLoaded must be called on the main UI thread.");
    return (this.zzoZ.zzqT == null) && (this.zzoZ.zzqU == null) && (this.zzoZ.zzqW != null) && (!this.zzJh);
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(this.zzoZ.zzqW, false);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", localRemoteException);
    }
  }
  
  public void onRewardedVideoStarted()
  {
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAM);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      this.zzJf.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  public void pause()
  {
    zzx.zzcx("pause must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().pause();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to pause adapter: " + str);
      }
    }
  }
  
  public void resume()
  {
    zzx.zzcx("resume must be called on the main UI thread.");
    Iterator localIterator = this.zzJi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzht localzzht = (zzht)this.zzJi.get(str);
        if ((localzzht != null) && (localzzht.zzgA() != null)) {
          localzzht.zzgA().resume();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to resume adapter: " + str);
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    zzx.zzcx("setUserId must be called on the main UI thread.");
    this.zzJg = paramString;
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    zzx.zzcx("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(paramRewardedVideoAdRequestParcel.zzqP))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
      return;
    }
    this.zzJh = false;
    this.zzoZ.zzqP = paramRewardedVideoAdRequestParcel.zzqP;
    super.zzb(paramRewardedVideoAdRequestParcel.zzGq);
  }
  
  public void zza(zzd paramzzd)
  {
    zzx.zzcx("setRewardedVideoAdListener must be called on the main UI thread.");
    this.zzJf = paramzzd;
  }
  
  public void zza(RewardItemParcel paramRewardItemParcel)
  {
    zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAN);
    if (this.zzJf == null) {
      return;
    }
    try
    {
      if ((this.zzoZ.zzqW != null) && (this.zzoZ.zzqW.zzJF != null) && (!TextUtils.isEmpty(this.zzoZ.zzqW.zzJF.zzAV)))
      {
        this.zzJf.zza(new zzhq(this.zzoZ.zzqW.zzJF.zzAV, this.zzoZ.zzqW.zzJF.zzAW));
        return;
      }
    }
    catch (RemoteException paramRewardItemParcel)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", paramRewardItemParcel);
      return;
    }
    this.zzJf.zza(new zzhq(paramRewardItemParcel.type, paramRewardItemParcel.zzJD));
  }
  
  public void zza(final zzie.zza paramzza, zzch paramzzch)
  {
    if (paramzza.errorCode != -2)
    {
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzhs.this.zzb(new zzie(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    this.zzoZ.zzrp = 0;
    this.zzoZ.zzqU = new zzhz(this.zzoZ.context, this.zzJg, paramzza, this);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzoZ.zzqU.getClass().getName());
    this.zzoZ.zzqU.zzfR();
  }
  
  public boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    if (this.zzJf != null) {}
    try
    {
      this.zzJf.onRewardedVideoAdLoaded();
      return true;
    }
    catch (RemoteException paramzzie1)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", paramzzie1);
      }
    }
  }
  
  public zzht zzav(String paramString)
  {
    localObject1 = (zzht)this.zzJi.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = new zzht(this.zzpd.zzaf(paramString), this);
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + paramString, localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        this.zzJi.put(paramString, localObject2);
        return (zzht)localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject3 = localException2;
        }
      }
      localException1 = localException1;
    }
    return (zzht)localObject1;
  }
  
  protected boolean zzf(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load ad: " + paramInt);
    this.zzoX = false;
    if (this.zzJf == null) {
      return false;
    }
    try
    {
      this.zzJf.onRewardedVideoAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  public void zzgy()
  {
    zzx.zzcx("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
    }
    zzht localzzht;
    do
    {
      return;
      this.zzJh = true;
      localzzht = zzav(this.zzoZ.zzqW.zzBr);
    } while ((localzzht == null) || (localzzht.zzgA() == null));
    try
    {
      localzzht.zzgA().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzgz()
  {
    onAdClicked();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */