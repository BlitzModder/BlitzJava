package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzha
public class zzeu
  implements zzel
{
  private final Context mContext;
  private zzeq zzBD;
  private final zzen zzBf;
  private final AdRequestInfoParcel zzBu;
  private final long zzBv;
  private final long zzBw;
  private boolean zzBy = false;
  private final zzch zzoU;
  private final Object zzpK = new Object();
  private final zzew zzpd;
  private final boolean zzrF;
  
  public zzeu(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzew paramzzew, zzen paramzzen, boolean paramBoolean, long paramLong1, long paramLong2, zzch paramzzch)
  {
    this.mContext = paramContext;
    this.zzBu = paramAdRequestInfoParcel;
    this.zzpd = paramzzew;
    this.zzBf = paramzzen;
    this.zzrF = paramBoolean;
    this.zzBv = paramLong1;
    this.zzBw = paramLong2;
    this.zzoU = paramzzch;
  }
  
  public void cancel()
  {
    synchronized (this.zzpK)
    {
      this.zzBy = true;
      if (this.zzBD != null) {
        this.zzBD.cancel();
      }
      return;
    }
  }
  
  public zzer zzc(List<zzem> arg1)
  {
    zzb.zzaF("Starting mediation.");
    Object localObject = new ArrayList();
    zzcf localzzcf1 = this.zzoU.zzdu();
    Iterator localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      zzem localzzem = (zzem)localIterator1.next();
      zzb.zzaG("Trying mediation network: " + localzzem.zzAF);
      Iterator localIterator2 = localzzem.zzAG.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        zzcf localzzcf2 = this.zzoU.zzdu();
        synchronized (this.zzpK)
        {
          if (this.zzBy)
          {
            localObject = new zzer(-1);
            return (zzer)localObject;
          }
          this.zzBD = new zzeq(this.mContext, str, this.zzpd, this.zzBf, localzzem, this.zzBu.zzGq, this.zzBu.zzqV, this.zzBu.zzqR, this.zzrF, this.zzBu.zzrj, this.zzBu.zzrl);
          ??? = this.zzBD.zza(this.zzBv, this.zzBw);
          if (???.zzBo == 0)
          {
            zzb.zzaF("Adapter succeeded.");
            this.zzoU.zzd("mediation_network_succeed", str);
            if (!((List)localObject).isEmpty()) {
              this.zzoU.zzd("mediation_networks_fail", TextUtils.join(",", (Iterable)localObject));
            }
            this.zzoU.zza(localzzcf2, new String[] { "mls" });
            this.zzoU.zza(localzzcf1, new String[] { "ttm" });
            return (zzer)???;
          }
        }
        localIterable.add(str);
        this.zzoU.zza(localzzcf2, new String[] { "mlf" });
        if (???.zzBq != null) {
          zzip.zzKO.post(new Runnable()
          {
            public void run()
            {
              try
              {
                paramList.zzBq.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    if (!localIterable.isEmpty()) {
      this.zzoU.zzd("mediation_networks_fail", TextUtils.join(",", localIterable));
    }
    return new zzer(1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */