package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@zzha
public class zzhz
  extends zzil
  implements zzhy
{
  private final Context mContext;
  private final zzie.zza zzFc;
  private final zzhs zzJA;
  private final String zzJg;
  private final ArrayList<Future> zzJx = new ArrayList();
  private final ArrayList<String> zzJy = new ArrayList();
  private final HashSet<String> zzJz = new HashSet();
  private final Object zzpK = new Object();
  
  public zzhz(Context paramContext, String paramString, zzie.zza paramzza, zzhs paramzzhs)
  {
    this.mContext = paramContext;
    this.zzJg = paramString;
    this.zzFc = paramzza;
    this.zzJA = paramzzhs;
  }
  
  private void zzj(String paramString1, String paramString2)
  {
    synchronized (this.zzpK)
    {
      zzht localzzht = this.zzJA.zzav(paramString1);
      if ((localzzht == null) || (localzzht.zzgB() == null) || (localzzht.zzgA() == null)) {
        return;
      }
      paramString2 = new zzhu(this.mContext, paramString1, this.zzJg, paramString2, this.zzFc, localzzht, this);
      this.zzJx.add(paramString2.zzgX());
      this.zzJy.add(paramString1);
      return;
    }
  }
  
  public void onStop() {}
  
  public void zza(String paramString, int paramInt) {}
  
  public void zzaw(String paramString)
  {
    synchronized (this.zzpK)
    {
      this.zzJz.add(paramString);
      return;
    }
  }
  
  public void zzbp()
  {
    ??? = this.zzFc.zzJF.zzAO.iterator();
    final Object localObject2;
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (zzem)((Iterator)???).next();
      localObject2 = ((zzem)localObject4).zzAL;
      localObject4 = ((zzem)localObject4).zzAG.iterator();
      while (((Iterator)localObject4).hasNext()) {
        zzj((String)((Iterator)localObject4).next(), (String)localObject2);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < this.zzJx.size()) {}
      try
      {
        ((Future)this.zzJx.get(i)).get();
        synchronized (this.zzpK)
        {
          if (this.zzJz.contains(this.zzJy.get(i)))
          {
            localObject2 = (String)this.zzJy.get(i);
            localObject2 = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, -2, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, (zzem)this.zzFc.zzJF.zzAO.get(i), null, (String)localObject2, this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
            zza.zzLE.post(new Runnable()
            {
              public void run()
              {
                zzhz.zza(zzhz.this).zzb(localObject2);
              }
            });
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        final zzie localzzie = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, 3, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, null, null, null, this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
        zza.zzLE.post(new Runnable()
        {
          public void run()
          {
            zzhz.zza(zzhz.this).zzb(localzzie);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */