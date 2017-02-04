package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface GoogleSignInApi
{
  public abstract Intent getSignInIntent(GoogleApiClient paramGoogleApiClient);
  
  public abstract GoogleSignInResult getSignInResultFromIntent(Intent paramIntent);
  
  public abstract PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> signOut(GoogleApiClient paramGoogleApiClient);
  
  public abstract OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/GoogleSignInApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */