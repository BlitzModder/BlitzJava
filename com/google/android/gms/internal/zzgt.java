package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.List;

@zzha
public class zzgt
  extends zzgp
{
  private zzen zzBf;
  private zzel zzFx;
  protected zzer zzFy;
  private final zzch zzoU;
  private zzew zzpd;
  
  zzgt(Context paramContext, zzie.zza paramzza, zzew paramzzew, zzgq.zza paramzza1, zzch paramzzch)
  {
    super(paramContext, paramzza, paramzza1);
    this.zzpd = paramzzew;
    this.zzBf = paramzza.zzJF;
    this.zzoU = paramzzch;
  }
  
  public void onStop()
  {
    synchronized (this.zzFf)
    {
      super.onStop();
      if (this.zzFx != null) {
        this.zzFx.cancel();
      }
      return;
    }
  }
  
  protected zzie zzD(int paramInt)
  {
    Object localObject = this.zzFc.zzJK;
    AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject).zzGq;
    List localList1 = this.zzFd.zzAQ;
    List localList2 = this.zzFd.zzAR;
    List localList3 = this.zzFd.zzGP;
    int i = this.zzFd.orientation;
    long l = this.zzFd.zzAU;
    String str2 = ((AdRequestInfoParcel)localObject).zzGt;
    boolean bool = this.zzFd.zzGN;
    zzex localzzex;
    label107:
    String str1;
    label123:
    zzen localzzen;
    if (this.zzFy != null)
    {
      localObject = this.zzFy.zzBp;
      if (this.zzFy == null) {
        break label235;
      }
      localzzex = this.zzFy.zzBq;
      if (this.zzFy == null) {
        break label241;
      }
      str1 = this.zzFy.zzBr;
      localzzen = this.zzBf;
      if (this.zzFy == null) {
        break label251;
      }
    }
    label235:
    label241:
    label251:
    for (zzep localzzep = this.zzFy.zzBs;; localzzep = null)
    {
      return new zzie(localAdRequestParcel, null, localList1, paramInt, localList2, localList3, i, l, str2, bool, (zzem)localObject, localzzex, str1, localzzen, localzzep, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
      localObject = null;
      break;
      localzzex = null;
      break label107;
      str1 = AdMobAdapter.class.getName();
      break label123;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzgp.zza
  {
    synchronized (this.zzFf)
    {
      this.zzFx = zzi(paramLong);
      this.zzFy = this.zzFx.zzc(this.zzBf.zzAO);
      switch (this.zzFy.zzBo)
      {
      default: 
        throw new zzgp.zza("Unexpected mediation result: " + this.zzFy.zzBo, 0);
      }
    }
    throw new zzgp.zza("No fill from any mediation ad networks.", 3);
  }
  
  zzel zzi(long paramLong)
  {
    if (this.zzBf.zzAX != -1) {
      return new zzet(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, paramLong, ((Long)zzbz.zzwC.get()).longValue(), 2);
    }
    return new zzeu(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, paramLong, ((Long)zzbz.zzwC.get()).longValue(), this.zzoU);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */