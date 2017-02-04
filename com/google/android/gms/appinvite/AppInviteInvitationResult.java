package com.google.android.gms.appinvite;

import android.content.Intent;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract interface AppInviteInvitationResult
  extends Result
{
  public abstract Intent getInvitationIntent();
  
  public abstract Status getStatus();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appinvite/AppInviteInvitationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */