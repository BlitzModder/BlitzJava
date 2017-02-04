package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzdu
  extends zzil
{
  final zzjn zzps;
  final zzdw zzzj;
  private final String zzzk;
  
  zzdu(zzjn paramzzjn, zzdw paramzzdw, String paramString)
  {
    this.zzps = paramzzjn;
    this.zzzj = paramzzdw;
    this.zzzk = paramString;
    zzp.zzbL().zza(this);
  }
  
  public void onStop()
  {
    this.zzzj.abort();
  }
  
  public void zzbp()
  {
    try
    {
      this.zzzj.zzZ(this.zzzk);
      return;
    }
    finally
    {
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzp.zzbL().zzb(zzdu.this);
        }
      });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */