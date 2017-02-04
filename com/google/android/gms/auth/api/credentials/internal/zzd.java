package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;

public final class zzd
  implements CredentialsApi
{
  public PendingResult<Status> delete(GoogleApiClient paramGoogleApiClient, final Credential paramCredential)
  {
    paramGoogleApiClient.zzb(new zze(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzi paramAnonymouszzi)
        throws RemoteException
      {
        paramAnonymouszzi.zza(new zzd.zza(this), new DeleteRequest(paramCredential));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zze(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzi paramAnonymouszzi)
        throws RemoteException
      {
        paramAnonymouszzi.zza(new zzd.zza(this));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest)
  {
    zzx.zzb(paramGoogleApiClient, "client must not be null");
    zzx.zzb(paramHintRequest, "request must not be null");
    zzx.zzb(paramGoogleApiClient.zza(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
    Object localObject = ((zzf)paramGoogleApiClient.zza(Auth.zzTX)).zzmm();
    if ((localObject != null) && (((Auth.AuthCredentialsOptions)localObject).zzma() != null)) {}
    for (localObject = ((Auth.AuthCredentialsOptions)localObject).zzma();; localObject = PasswordSpecification.zzUO)
    {
      paramHintRequest = zzb.zza(paramGoogleApiClient.getContext(), paramHintRequest, (PasswordSpecification)localObject);
      return PendingIntent.getActivity(paramGoogleApiClient.getContext(), 2000, paramHintRequest, 268435456);
    }
  }
  
  public PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, final CredentialRequest paramCredentialRequest)
  {
    paramGoogleApiClient.zza(new zze(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzi paramAnonymouszzi)
        throws RemoteException
      {
        paramAnonymouszzi.zza(new zza()
        {
          public void zza(Status paramAnonymous2Status, Credential paramAnonymous2Credential)
          {
            zzd.1.this.zzb(new zzc(paramAnonymous2Status, paramAnonymous2Credential));
          }
          
          public void zzg(Status paramAnonymous2Status)
          {
            zzd.1.this.zzb(zzc.zzh(paramAnonymous2Status));
          }
        }, paramCredentialRequest);
      }
      
      protected CredentialRequestResult zzi(Status paramAnonymousStatus)
      {
        return zzc.zzh(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, final Credential paramCredential)
  {
    paramGoogleApiClient.zzb(new zze(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzi paramAnonymouszzi)
        throws RemoteException
      {
        paramAnonymouszzi.zza(new zzd.zza(this), new SaveRequest(paramCredential));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  private static class zza
    extends zza
  {
    private zzlx.zzb<Status> zzVc;
    
    zza(zzlx.zzb<Status> paramzzb)
    {
      this.zzVc = paramzzb;
    }
    
    public void zzg(Status paramStatus)
    {
      this.zzVc.zzr(paramStatus);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */