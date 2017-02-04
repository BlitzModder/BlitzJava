package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class GoogleSignInStatusCodes
  extends CommonStatusCodes
{
  public static final int SIGN_IN_CANCELLED = 12501;
  public static final int SIGN_IN_FAILED = 12500;
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    }
    return "A non-recoverable sign in failure occurred";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/GoogleSignInStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */