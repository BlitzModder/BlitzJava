package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public final class RewardItemParcel
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String type;
  public final int versionCode;
  public final int zzJD;
  
  public RewardItemParcel(int paramInt1, String paramString, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.type = paramString;
    this.zzJD = paramInt2;
  }
  
  public RewardItemParcel(RewardItem paramRewardItem)
  {
    this(1, paramRewardItem.getType(), paramRewardItem.getAmount());
  }
  
  public RewardItemParcel(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */