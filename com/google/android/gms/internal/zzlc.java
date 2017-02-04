package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzlc
  implements ProxyApi.ProxyResult
{
  private Status zzTA;
  private ProxyResponse zzVn;
  
  public zzlc(ProxyResponse paramProxyResponse)
  {
    this.zzVn = paramProxyResponse;
    this.zzTA = Status.zzaeX;
  }
  
  public zzlc(Status paramStatus)
  {
    this.zzTA = paramStatus;
  }
  
  public ProxyResponse getResponse()
  {
    return this.zzVn;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */