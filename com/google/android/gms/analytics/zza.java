package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzi;
import java.util.List;
import java.util.ListIterator;

public class zza
  extends com.google.android.gms.measurement.zzf<zza>
{
  private final com.google.android.gms.analytics.internal.zzf zzNq;
  private boolean zzNr;
  
  public zza(com.google.android.gms.analytics.internal.zzf paramzzf)
  {
    super(paramzzf.zziW(), paramzzf.zziT());
    this.zzNq = paramzzf;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzNr = paramBoolean;
  }
  
  protected void zza(zzc paramzzc)
  {
    paramzzc = (zzkc)paramzzc.zze(zzkc.class);
    if (TextUtils.isEmpty(paramzzc.getClientId())) {
      paramzzc.setClientId(this.zzNq.zzjl().zzjT());
    }
    if ((this.zzNr) && (TextUtils.isEmpty(paramzzc.zziB())))
    {
      com.google.android.gms.analytics.internal.zza localzza = this.zzNq.zzjk();
      paramzzc.zzaV(localzza.zziG());
      paramzzc.zzH(localzza.zziC());
    }
  }
  
  public void zzaP(String paramString)
  {
    zzx.zzcG(paramString);
    zzaQ(paramString);
    zzzQ().add(new zzb(this.zzNq, paramString));
  }
  
  public void zzaQ(String paramString)
  {
    paramString = zzb.zzaR(paramString);
    ListIterator localListIterator = zzzQ().listIterator();
    while (localListIterator.hasNext()) {
      if (paramString.equals(((zzi)localListIterator.next()).zzii())) {
        localListIterator.remove();
      }
    }
  }
  
  com.google.android.gms.analytics.internal.zzf zzif()
  {
    return this.zzNq;
  }
  
  public zzc zzig()
  {
    zzc localzzc = zzzP().zzzE();
    localzzc.zzb(this.zzNq.zzjb().zzjB());
    localzzc.zzb(this.zzNq.zzjc().zzkI());
    zzd(localzzc);
    return localzzc;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */