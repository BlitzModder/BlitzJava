package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zzmo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class zzc
  implements GoogleSignInApi
{
  private GoogleSignInOptions zza(GoogleApiClient paramGoogleApiClient)
  {
    return ((zzd)paramGoogleApiClient.zza(Auth.zzUa)).zzmL();
  }
  
  private OptionalPendingResult<GoogleSignInResult> zza(final GoogleApiClient paramGoogleApiClient, final GoogleSignInOptions paramGoogleSignInOptions)
  {
    Log.d("GoogleSignInApiImpl", "trySilentSignIn");
    new zzmo(paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramGoogleApiClient)
    {
      protected void zza(zzd paramAnonymouszzd)
        throws RemoteException
      {
        ((zzg)paramAnonymouszzd.zzqs()).zza(new zza()
        {
          public void zza(GoogleSignInAccount paramAnonymous2GoogleSignInAccount, Status paramAnonymous2Status)
            throws RemoteException
          {
            if (paramAnonymous2GoogleSignInAccount != null) {
              zzn.zzae(zzc.1.this.zzVT.getContext()).zzb(paramAnonymous2GoogleSignInAccount, zzc.1.this.zzVU);
            }
            zzc.1.this.zzb(new GoogleSignInResult(paramAnonymous2GoogleSignInAccount, paramAnonymous2Status));
          }
        }, paramGoogleSignInOptions);
      }
      
      protected GoogleSignInResult zzn(Status paramAnonymousStatus)
      {
        return new GoogleSignInResult(null, paramAnonymousStatus);
      }
    }));
  }
  
  private boolean zza(Account paramAccount1, Account paramAccount2)
  {
    if (paramAccount1 == null) {
      return paramAccount2 == null;
    }
    return paramAccount1.equals(paramAccount2);
  }
  
  public Intent getSignInIntent(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzy(paramGoogleApiClient);
    return ((zzd)paramGoogleApiClient.zza(Auth.zzUa)).zzmK();
  }
  
  public GoogleSignInResult getSignInResultFromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || ((!paramIntent.hasExtra("googleSignInStatus")) && (!paramIntent.hasExtra("googleSignInAccount")))) {
      return null;
    }
    GoogleSignInAccount localGoogleSignInAccount = (GoogleSignInAccount)paramIntent.getParcelableExtra("googleSignInAccount");
    paramIntent = (Status)paramIntent.getParcelableExtra("googleSignInStatus");
    if (localGoogleSignInAccount != null) {
      paramIntent = Status.zzaeX;
    }
    return new GoogleSignInResult(localGoogleSignInAccount, paramIntent);
  }
  
  public PendingResult<Status> revokeAccess(final GoogleApiClient paramGoogleApiClient)
  {
    zzn.zzae(paramGoogleApiClient.getContext()).zzmZ();
    Iterator localIterator = GoogleApiClient.zzoE().iterator();
    while (localIterator.hasNext()) {
      ((GoogleApiClient)localIterator.next()).zzoF();
    }
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient, paramGoogleApiClient)
    {
      protected void zza(zzd paramAnonymouszzd)
        throws RemoteException
      {
        ((zzg)paramAnonymouszzd.zzqs()).zzc(new zza()
        {
          public void zzm(Status paramAnonymous2Status)
            throws RemoteException
          {
            zzc.3.this.zzb(paramAnonymous2Status);
          }
        }, zzc.zza(zzc.this, paramGoogleApiClient));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> signOut(final GoogleApiClient paramGoogleApiClient)
  {
    zzn.zzae(paramGoogleApiClient.getContext()).zzmZ();
    Iterator localIterator = GoogleApiClient.zzoE().iterator();
    while (localIterator.hasNext()) {
      ((GoogleApiClient)localIterator.next()).zzoF();
    }
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient, paramGoogleApiClient)
    {
      protected void zza(zzd paramAnonymouszzd)
        throws RemoteException
      {
        ((zzg)paramAnonymouszzd.zzqs()).zzb(new zza()
        {
          public void zzl(Status paramAnonymous2Status)
            throws RemoteException
          {
            zzc.2.this.zzb(paramAnonymous2Status);
          }
        }, zzc.zza(zzc.this, paramGoogleApiClient));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient)
  {
    GoogleSignInOptions localGoogleSignInOptions = zza(paramGoogleApiClient);
    GoogleSignInResult localGoogleSignInResult = zza(paramGoogleApiClient.getContext(), localGoogleSignInOptions);
    if (localGoogleSignInResult != null) {
      return PendingResults.zzb(localGoogleSignInResult, paramGoogleApiClient);
    }
    return zza(paramGoogleApiClient, localGoogleSignInOptions);
  }
  
  public GoogleSignInResult zza(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
    zzx.zzy(paramGoogleSignInOptions);
    paramContext = zzn.zzae(paramContext);
    GoogleSignInOptions localGoogleSignInOptions = paramContext.zzmX();
    if (localGoogleSignInOptions == null) {}
    do
    {
      do
      {
        return null;
      } while ((!zza(localGoogleSignInOptions.getAccount(), paramGoogleSignInOptions.getAccount())) || (paramGoogleSignInOptions.zzmz()) || ((paramGoogleSignInOptions.zzmy()) && ((!localGoogleSignInOptions.zzmy()) || (!paramGoogleSignInOptions.zzmB().equals(localGoogleSignInOptions.zzmB())))) || (!new HashSet(localGoogleSignInOptions.zzmu()).containsAll(new HashSet(paramGoogleSignInOptions.zzmu()))));
      paramContext = paramContext.zzmW();
    } while ((paramContext == null) || (paramContext.zzb()));
    return new GoogleSignInResult(paramContext, Status.zzaeX);
  }
  
  private abstract class zza<R extends Result>
    extends zzlx.zza<R, zzd>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */