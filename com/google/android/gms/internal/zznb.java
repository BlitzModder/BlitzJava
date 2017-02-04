package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zznb
  implements zzna
{
  public PendingResult<Status> zze(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zznc.zza(paramGoogleApiClient)
    {
      protected void zza(zznd paramAnonymouszznd)
        throws RemoteException
      {
        ((zznf)paramAnonymouszznd.zzqs()).zza(new zznb.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzmy
  {
    private final zzlx.zzb<Status> zzakL;
    
    public zza(zzlx.zzb<Status> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzcd(int paramInt)
      throws RemoteException
    {
      this.zzakL.zzr(new Status(paramInt));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zznb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */