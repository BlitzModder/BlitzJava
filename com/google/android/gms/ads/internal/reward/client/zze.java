package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zzha;

@zzha
public class zze
  implements RewardItem
{
  private final zza zzJk;
  
  public zze(zza paramzza)
  {
    this.zzJk = paramzza;
  }
  
  public int getAmount()
  {
    if (this.zzJk == null) {
      return 0;
    }
    try
    {
      int i = this.zzJk.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
  
  public String getType()
  {
    if (this.zzJk == null) {
      return null;
    }
    try
    {
      String str = this.zzJk.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/reward/client/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */