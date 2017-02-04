package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzlb
  implements ProxyApi
{
  public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, final ProxyRequest paramProxyRequest)
  {
    zzx.zzy(paramGoogleApiClient);
    zzx.zzy(paramProxyRequest);
    paramGoogleApiClient.zzb(new zzla(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzkz paramAnonymouszzkz)
        throws RemoteException
      {
        paramAnonymouszzkz.zza(new zzkw()
        {
          public void zza(ProxyResponse paramAnonymous2ProxyResponse)
          {
            zzlb.1.this.zzb(new zzlc(paramAnonymous2ProxyResponse));
          }
        }, paramProxyRequest);
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */