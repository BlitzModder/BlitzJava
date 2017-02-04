package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzw.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;

@zzha
public class zzm
  extends zzw.zza
{
  private static final Object zzqf = new Object();
  private static zzm zzqg;
  private final Context mContext;
  private boolean zzqh;
  
  zzm(Context paramContext)
  {
    this.mContext = paramContext;
    this.zzqh = false;
  }
  
  public static zzm zzr(Context paramContext)
  {
    synchronized (zzqf)
    {
      if (zzqg == null) {
        zzqg = new zzm(paramContext.getApplicationContext());
      }
      paramContext = zzqg;
      return paramContext;
    }
  }
  
  public void zza()
  {
    synchronized (zzqf)
    {
      if (this.zzqh)
      {
        zzb.zzaH("Mobile ads is initialized already.");
        return;
      }
      this.zzqh = true;
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */