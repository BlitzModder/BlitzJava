package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.internal.zzx;

public class zzh
  implements Api.ApiOptions.HasOptions
{
  private final SignInConfiguration zzVQ;
  
  private zzh(SignInConfiguration paramSignInConfiguration)
  {
    this.zzVQ = paramSignInConfiguration;
  }
  
  public SignInConfiguration zzmF()
  {
    return this.zzVQ;
  }
  
  public static class zza
  {
    private final SignInConfiguration zzVQ;
    
    public zza(String paramString)
    {
      zzx.zzcG(paramString);
      this.zzVQ = new SignInConfiguration(paramString);
    }
    
    public zza zzh(GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzx.zzy(paramGoogleSignInOptions);
      this.zzVQ.zzi(paramGoogleSignInOptions);
      return this;
    }
    
    public zzh zzmG()
    {
      if ((this.zzVQ.zzmQ() != null) || (this.zzVQ.zzmS() != null) || (this.zzVQ.zzmR() != null)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Must support either Facebook, Google or Email sign-in.");
        return new zzh(this.zzVQ, null);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */