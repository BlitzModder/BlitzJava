package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  private final int zzTQ;
  
  GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.zzTQ = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.zzTQ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/GooglePlayServicesRepairableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */