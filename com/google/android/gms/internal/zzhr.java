package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzha
public class zzhr
  extends zzb.zza
{
  private final Context mContext;
  private final zzhs zzJe;
  private final VersionInfoParcel zzpI;
  private final Object zzpK;
  
  public zzhr(Context paramContext, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpI = paramVersionInfoParcel;
    this.zzJe = new zzhs(paramContext, AdSizeParcel.zzcK(), paramzzew, paramVersionInfoParcel);
    this.zzpK = new Object();
  }
  
  public void destroy()
  {
    synchronized (this.zzpK)
    {
      this.zzJe.destroy();
      return;
    }
  }
  
  public boolean isLoaded()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzJe.isLoaded();
      return bool;
    }
  }
  
  public void pause()
  {
    synchronized (this.zzpK)
    {
      this.zzJe.pause();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.zzpK)
    {
      this.zzJe.resume();
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (this.zzpK)
    {
      this.zzJe.setUserId(paramString);
      return;
    }
  }
  
  public void show()
  {
    synchronized (this.zzpK)
    {
      this.zzJe.zzgy();
      return;
    }
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    synchronized (this.zzpK)
    {
      this.zzJe.zza(paramRewardedVideoAdRequestParcel);
      return;
    }
  }
  
  public void zza(zzd paramzzd)
  {
    synchronized (this.zzpK)
    {
      this.zzJe.zza(paramzzd);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */