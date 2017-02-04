package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzrz
  implements SearchAuthApi
{
  public PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramString));
  }
  
  public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramString));
  }
  
  static abstract class zza
    extends zzrw.zza
  {
    public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzbf(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static class zzb
    extends zzlx.zza<Status, zzry>
  {
    private final GoogleApiClient zzYC;
    private final String zzbbu;
    private final boolean zzbbx = Log.isLoggable("SearchAuth", 3);
    
    protected zzb(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.zzYC = paramGoogleApiClient;
      this.zzbbu = paramString;
    }
    
    protected void zza(zzry paramzzry)
      throws RemoteException
    {
      if (this.zzbbx) {
        Log.d("SearchAuth", "ClearTokenImpl started");
      }
      String str = this.zzYC.getContext().getPackageName();
      zzrz.zza local1 = new zzrz.zza()
      {
        public void zzbf(Status paramAnonymousStatus)
        {
          if (zzrz.zzb.zza(zzrz.zzb.this)) {
            Log.d("SearchAuth", "ClearTokenImpl success");
          }
          zzrz.zzb.this.zzb(paramAnonymousStatus);
        }
      };
      ((zzrx)paramzzry.zzqs()).zzb(local1, str, this.zzbbu);
    }
    
    protected Status zzb(Status paramStatus)
    {
      if (this.zzbbx) {
        Log.d("SearchAuth", "ClearTokenImpl received failure: " + paramStatus.getStatusMessage());
      }
      return paramStatus;
    }
  }
  
  static class zzc
    extends zzlx.zza<SearchAuthApi.GoogleNowAuthResult, zzry>
  {
    private final GoogleApiClient zzYC;
    private final boolean zzbbx = Log.isLoggable("SearchAuth", 3);
    private final String zzbbz;
    
    protected zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.zzYC = paramGoogleApiClient;
      this.zzbbz = paramString;
    }
    
    protected void zza(zzry paramzzry)
      throws RemoteException
    {
      if (this.zzbbx) {
        Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
      }
      String str = this.zzYC.getContext().getPackageName();
      zzrz.zza local1 = new zzrz.zza()
      {
        public void zza(Status paramAnonymousStatus, GoogleNowAuthState paramAnonymousGoogleNowAuthState)
        {
          if (zzrz.zzc.zza(zzrz.zzc.this)) {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
          }
          zzrz.zzc.this.zzb(new zzrz.zzd(paramAnonymousStatus, paramAnonymousGoogleNowAuthState));
        }
      };
      ((zzrx)paramzzry.zzqs()).zza(local1, str, this.zzbbz);
    }
    
    protected SearchAuthApi.GoogleNowAuthResult zzbg(Status paramStatus)
    {
      if (this.zzbbx) {
        Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + paramStatus.getStatusMessage());
      }
      return new zzrz.zzd(paramStatus, null);
    }
  }
  
  static class zzd
    implements SearchAuthApi.GoogleNowAuthResult
  {
    private final Status zzTA;
    private final GoogleNowAuthState zzbbB;
    
    zzd(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      this.zzTA = paramStatus;
      this.zzbbB = paramGoogleNowAuthState;
    }
    
    public GoogleNowAuthState getGoogleNowAuthState()
    {
      return this.zzbbB;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */