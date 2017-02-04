package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzgo
  extends zzgm
{
  private zzgn zzFr;
  
  zzgo(Context paramContext, zzie.zza paramzza, zzjn paramzzjn, zzgq.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzjn, paramzza1);
  }
  
  protected void zzfP()
  {
    Object localObject = this.zzps.zzaP();
    int j;
    if (((AdSizeParcel)localObject).zztW)
    {
      localObject = this.mContext.getResources().getDisplayMetrics();
      j = ((DisplayMetrics)localObject).widthPixels;
    }
    for (int i = ((DisplayMetrics)localObject).heightPixels;; i = ((AdSizeParcel)localObject).heightPixels)
    {
      this.zzFr = new zzgn(this, this.zzps, j, i);
      this.zzps.zzhC().zza(this);
      this.zzFr.zza(this.zzFd);
      return;
      j = ((AdSizeParcel)localObject).widthPixels;
    }
  }
  
  protected int zzfQ()
  {
    if (this.zzFr.zzfU())
    {
      zzb.zzaF("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!this.zzFr.zzfV()) {
      return 2;
    }
    return -2;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */