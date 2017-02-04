package com.google.android.gms.search;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract interface SearchAuthApi
{
  public abstract PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public static abstract interface GoogleNowAuthResult
    extends Result
  {
    public abstract GoogleNowAuthState getGoogleNowAuthState();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/search/SearchAuthApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */