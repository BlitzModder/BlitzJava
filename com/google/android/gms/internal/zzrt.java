package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzrt
  implements SafetyNetApi
{
  public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient paramGoogleApiClient, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.zza(new zzb(paramGoogleApiClient)
    {
      protected void zza(zzru paramAnonymouszzru)
        throws RemoteException
      {
        paramAnonymouszzru.zza(this.zzbbp, paramArrayOfByte);
      }
    });
  }
  
  public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient paramGoogleApiClient, final List<Integer> paramList, final String paramString)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("Null threatTypes in lookupUri");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Null or empty uri in lookupUri");
    }
    paramGoogleApiClient.zza(new zzc(paramGoogleApiClient)
    {
      protected void zza(zzru paramAnonymouszzru)
        throws RemoteException
      {
        paramAnonymouszzru.zza(this.zzbbp, paramList, 1, paramString);
      }
    });
  }
  
  static class zza
    implements SafetyNetApi.AttestationResult
  {
    private final Status zzTA;
    private final AttestationData zzbbo;
    
    public zza(Status paramStatus, AttestationData paramAttestationData)
    {
      this.zzTA = paramStatus;
      this.zzbbo = paramAttestationData;
    }
    
    public String getJwsResult()
    {
      if (this.zzbbo == null) {
        return null;
      }
      return this.zzbbo.getJwsResult();
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  static abstract class zzb
    extends zzrq<SafetyNetApi.AttestationResult>
  {
    protected zzrr zzbbp = new zzrp()
    {
      public void zza(Status paramAnonymousStatus, AttestationData paramAnonymousAttestationData)
      {
        zzrt.zzb.this.zzb(new zzrt.zza(paramAnonymousStatus, paramAnonymousAttestationData));
      }
    };
    
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected SafetyNetApi.AttestationResult zzbd(Status paramStatus)
    {
      return new zzrt.zza(paramStatus, null);
    }
  }
  
  static abstract class zzc
    extends zzrq<SafetyNetApi.SafeBrowsingResult>
  {
    protected zzrr zzbbp = new zzrp()
    {
      public void zza(Status paramAnonymousStatus, SafeBrowsingData paramAnonymousSafeBrowsingData)
      {
        zzrt.zzc.this.zzb(new zzrt.zzd(paramAnonymousStatus, paramAnonymousSafeBrowsingData));
      }
    };
    
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected SafetyNetApi.SafeBrowsingResult zzbe(Status paramStatus)
    {
      return new zzrt.zzd(paramStatus, null);
    }
  }
  
  static class zzd
    implements SafetyNetApi.SafeBrowsingResult
  {
    private Status zzTA;
    private String zzbbi;
    private final SafeBrowsingData zzbbs;
    
    public zzd(Status paramStatus, SafeBrowsingData paramSafeBrowsingData)
    {
      this.zzTA = paramStatus;
      this.zzbbs = paramSafeBrowsingData;
      this.zzbbi = null;
      if (this.zzbbs != null) {
        this.zzbbi = this.zzbbs.getMetadata();
      }
      while (!this.zzTA.isSuccess()) {
        return;
      }
      this.zzTA = new Status(8);
    }
    
    public String getMetadata()
    {
      return this.zzbbi;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */