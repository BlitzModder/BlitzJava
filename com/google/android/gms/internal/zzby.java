package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.concurrent.Callable;

@zzha
public class zzby
{
  private final Object zzpK = new Object();
  private boolean zzqh = false;
  private SharedPreferences zzvc = null;
  
  public void initialize(Context paramContext)
  {
    synchronized (this.zzpK)
    {
      if (this.zzqh) {
        return;
      }
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        return;
      }
    }
    this.zzvc = zzp.zzbE().zzw(paramContext);
    this.zzqh = true;
  }
  
  public <T> T zzd(final zzbv<T> paramzzbv)
  {
    synchronized (this.zzpK)
    {
      if (!this.zzqh)
      {
        paramzzbv = paramzzbv.zzdk();
        return paramzzbv;
      }
      (T)zziz.zzb(new Callable()
      {
        public T call()
        {
          return (T)paramzzbv.zza(zzby.zza(zzby.this));
        }
      });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */