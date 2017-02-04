package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzio;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzha
class zzh
  implements zzaj, Runnable
{
  private zzq zzoZ;
  private final List<Object[]> zzpw = new Vector();
  private final AtomicReference<zzaj> zzpx = new AtomicReference();
  CountDownLatch zzpy = new CountDownLatch(1);
  
  public zzh(zzq paramzzq)
  {
    this.zzoZ = paramzzq;
    if (zzl.zzcN().zzhr())
    {
      zzio.zza(this);
      return;
    }
    run();
  }
  
  private void zzbj()
  {
    if (this.zzpw.isEmpty()) {
      return;
    }
    Iterator localIterator = this.zzpw.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1) {
        ((zzaj)this.zzpx.get()).zza((MotionEvent)arrayOfObject[0]);
      } else if (arrayOfObject.length == 3) {
        ((zzaj)this.zzpx.get()).zza(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      }
    }
    this.zzpw.clear();
  }
  
  private Context zzq(Context paramContext)
  {
    if (!((Boolean)zzbz.zzvr.get()).booleanValue()) {}
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    } while (localContext == null);
    return localContext;
  }
  
  public void run()
  {
    label94:
    for (;;)
    {
      try
      {
        if (((Boolean)zzbz.zzvD.get()).booleanValue()) {
          if (this.zzoZ.zzqR.zzLH)
          {
            break label94;
            zza(zzb(this.zzoZ.zzqR.afmaVersion, zzq(this.zzoZ.context), bool));
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally
      {
        this.zzpy.countDown();
        this.zzoZ = null;
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    zzaj localzzaj = (zzaj)this.zzpx.get();
    if (localzzaj != null)
    {
      zzbj();
      localzzaj.zza(paramInt1, paramInt2, paramInt3);
      return;
    }
    this.zzpw.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzaj localzzaj = (zzaj)this.zzpx.get();
    if (localzzaj != null)
    {
      zzbj();
      localzzaj.zza(paramMotionEvent);
      return;
    }
    this.zzpw.add(new Object[] { paramMotionEvent });
  }
  
  protected void zza(zzaj paramzzaj)
  {
    this.zzpx.set(paramzzaj);
  }
  
  protected zzaj zzb(String paramString, Context paramContext, boolean paramBoolean)
  {
    return zzam.zza(paramString, paramContext, paramBoolean);
  }
  
  public String zzb(Context paramContext)
  {
    if (zzbi())
    {
      zzaj localzzaj = (zzaj)this.zzpx.get();
      if (localzzaj != null)
      {
        zzbj();
        return localzzaj.zzb(zzq(paramContext));
      }
    }
    return "";
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    if (zzbi())
    {
      zzaj localzzaj = (zzaj)this.zzpx.get();
      if (localzzaj != null)
      {
        zzbj();
        return localzzaj.zzb(zzq(paramContext), paramString);
      }
    }
    return "";
  }
  
  protected boolean zzbi()
  {
    try
    {
      this.zzpy.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzb.zzd("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */