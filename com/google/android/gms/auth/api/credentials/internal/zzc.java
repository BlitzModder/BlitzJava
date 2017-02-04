package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzc
  implements CredentialRequestResult
{
  private final Status zzTA;
  private final Credential zzUX;
  
  public zzc(Status paramStatus, Credential paramCredential)
  {
    this.zzTA = paramStatus;
    this.zzUX = paramCredential;
  }
  
  public static zzc zzh(Status paramStatus)
  {
    return new zzc(paramStatus, null);
  }
  
  public Credential getCredential()
  {
    return this.zzUX;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */