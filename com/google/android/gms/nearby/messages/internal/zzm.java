package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;

final class zzm
  extends zzc.zza
{
  private final zzlx.zzb<Status> zzaXE;
  
  private zzm(zzlx.zzb<Status> paramzzb)
  {
    this.zzaXE = paramzzb;
  }
  
  static zzm zzk(zzlx.zzb<Status> paramzzb)
  {
    return new zzm(paramzzb);
  }
  
  public void zzaX(Status paramStatus)
    throws RemoteException
  {
    this.zzaXE.zzr(paramStatus);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */