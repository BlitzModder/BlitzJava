package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public abstract class zzgm
  implements zzir<Void>, zzjo.zza
{
  protected final Context mContext;
  protected final zzgq.zza zzFb;
  protected final zzie.zza zzFc;
  protected AdResponseParcel zzFd;
  private Runnable zzFe;
  protected final Object zzFf = new Object();
  private AtomicBoolean zzFg = new AtomicBoolean(true);
  protected final zzjn zzps;
  
  protected zzgm(Context paramContext, zzie.zza paramzza, zzjn paramzzjn, zzgq.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zzFc = paramzza;
    this.zzFd = this.zzFc.zzJL;
    this.zzps = paramzzjn;
    this.zzFb = paramzza1;
  }
  
  private zzie zzD(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = this.zzFc.zzJK;
    return new zzie(localAdRequestInfoParcel.zzGq, this.zzps, this.zzFd.zzAQ, paramInt, this.zzFd.zzAR, this.zzFd.zzGP, this.zzFd.orientation, this.zzFd.zzAU, localAdRequestInfoParcel.zzGt, this.zzFd.zzGN, null, null, null, null, null, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
  }
  
  public void cancel()
  {
    if (!this.zzFg.getAndSet(false)) {
      return;
    }
    this.zzps.stopLoading();
    zzp.zzbz().zzf(this.zzps);
    zzC(-1);
    zzip.zzKO.removeCallbacks(this.zzFe);
  }
  
  protected void zzC(int paramInt)
  {
    if (paramInt != -2) {
      this.zzFd = new AdResponseParcel(paramInt, this.zzFd.zzAU);
    }
    this.zzFb.zzb(zzD(paramInt));
  }
  
  public void zza(zzjn paramzzjn, boolean paramBoolean)
  {
    zzb.zzaF("WebView finished loading.");
    if (!this.zzFg.getAndSet(false)) {
      return;
    }
    if (paramBoolean) {}
    for (int i = zzfQ();; i = -1)
    {
      zzC(i);
      zzip.zzKO.removeCallbacks(this.zzFe);
      return;
    }
  }
  
  public final Void zzfO()
  {
    zzx.zzcx("Webview render task needs to be called on UI thread.");
    this.zzFe = new Runnable()
    {
      public void run()
      {
        if (!zzgm.zza(zzgm.this).get()) {
          return;
        }
        zzb.e("Timed out waiting for WebView to finish loading.");
        zzgm.this.cancel();
      }
    };
    zzip.zzKO.postDelayed(this.zzFe, ((Long)zzbz.zzwC.get()).longValue());
    zzfP();
    return null;
  }
  
  protected abstract void zzfP();
  
  protected int zzfQ()
  {
    return -2;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */