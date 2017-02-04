package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzrh
  implements PanoramaApi.PanoramaResult
{
  private final Status zzTA;
  private final Intent zzaYi;
  
  public zzrh(Status paramStatus, Intent paramIntent)
  {
    this.zzTA = ((Status)zzx.zzy(paramStatus));
    this.zzaYi = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public Intent getViewerIntent()
  {
    return this.zzaYi;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */