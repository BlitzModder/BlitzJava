package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzha;

@zzha
public class zzi
  implements RewardedVideoAd
{
  private final Context mContext;
  private String zzJg;
  private RewardedVideoAdListener zzJl;
  private final zzb zzJm;
  private final Object zzpK = new Object();
  
  public zzi(Context paramContext, zzb paramzzb)
  {
    this.zzJm = paramzzb;
    this.mContext = paramContext;
  }
  
  public void destroy()
  {
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return;
      }
    }
    try
    {
      this.zzJm.destroy();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward destroy to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public RewardedVideoAdListener getRewardedVideoAdListener()
  {
    synchronized (this.zzpK)
    {
      RewardedVideoAdListener localRewardedVideoAdListener = this.zzJl;
      return localRewardedVideoAdListener;
    }
  }
  
  public String getUserId()
  {
    synchronized (this.zzpK)
    {
      String str = this.zzJg;
      return str;
    }
  }
  
  public boolean isLoaded()
  {
    boolean bool;
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return false;
      }
    }
    return false;
  }
  
  public void loadAd(String paramString, AdRequest paramAdRequest)
  {
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return;
      }
    }
    try
    {
      this.zzJm.zza(zzh.zzcJ().zza(this.mContext, paramAdRequest.zzaG(), paramString));
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward loadAd to RewardedVideoAd", paramString);
      }
    }
  }
  
  public void pause()
  {
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return;
      }
    }
    try
    {
      this.zzJm.pause();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward pause to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return;
      }
    }
    try
    {
      this.zzJm.resume();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward resume to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    synchronized (this.zzpK)
    {
      this.zzJl = paramRewardedVideoAdListener;
      zzb localzzb = this.zzJm;
      if (localzzb != null) {}
      try
      {
        this.zzJm.zza(new zzg(paramRewardedVideoAdListener));
        return;
      }
      catch (RemoteException paramRewardedVideoAdListener)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", paramRewardedVideoAdListener);
        }
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (this.zzpK)
    {
      if (!TextUtils.isEmpty(this.zzJg))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("A user id has already been set, ignoring.");
        return;
      }
      this.zzJg = paramString;
      zzb localzzb = this.zzJm;
      if (localzzb == null) {}
    }
    try
    {
      this.zzJm.setUserId(paramString);
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setUserId to RewardedVideoAd", paramString);
      }
    }
  }
  
  public void show()
  {
    synchronized (this.zzpK)
    {
      if (this.zzJm == null) {
        return;
      }
    }
    try
    {
      this.zzJm.show();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward show to RewardedVideoAd", localRemoteException);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/reward/client/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */