package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int zzTQ;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.zzTQ = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.zzTQ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/GooglePlayServicesAvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */