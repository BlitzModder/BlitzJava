package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzgr
  extends zzgm
  implements zzjo.zza
{
  zzgr(Context paramContext, zzie.zza paramzza, zzjn paramzzjn, zzgq.zza paramzza1)
  {
    super(paramContext, paramzza, paramzzjn, paramzza1);
  }
  
  protected void zzfP()
  {
    if (this.zzFd.errorCode != -2) {
      return;
    }
    this.zzps.zzhC().zza(this);
    zzfW();
    zzb.v("Loading HTML in WebView.");
    this.zzps.loadDataWithBaseURL(zzp.zzbx().zzaz(this.zzFd.zzDE), this.zzFd.body, "text/html", "UTF-8", null);
  }
  
  protected void zzfW() {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */