package com.google.android.gms.appinvite;

import android.app.Activity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface AppInviteApi
{
  public abstract PendingResult<Status> convertInvitation(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient paramGoogleApiClient, Activity paramActivity, boolean paramBoolean);
  
  @Deprecated
  public abstract PendingResult<Status> updateInvitationOnInstall(GoogleApiClient paramGoogleApiClient, String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appinvite/AppInviteApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */