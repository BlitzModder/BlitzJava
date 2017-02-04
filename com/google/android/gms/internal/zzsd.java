package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.internal.zzx;

public final class zzsd
  implements Api.ApiOptions.Optional
{
  public static final zzsd zzbbH = new zza().zzDQ();
  private final boolean zzVD;
  private final boolean zzVF;
  private final String zzVG;
  private final boolean zzbbI;
  private final GoogleApiClient.ServerAuthCodeCallbacks zzbbJ;
  private final boolean zzbbK;
  private final boolean zzbbL;
  
  private zzsd(boolean paramBoolean1, boolean paramBoolean2, String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.zzbbI = paramBoolean1;
    this.zzVD = paramBoolean2;
    this.zzVG = paramString;
    this.zzbbJ = paramServerAuthCodeCallbacks;
    this.zzbbK = paramBoolean3;
    this.zzVF = paramBoolean4;
    this.zzbbL = paramBoolean5;
  }
  
  public boolean zzDM()
  {
    return this.zzbbI;
  }
  
  public GoogleApiClient.ServerAuthCodeCallbacks zzDN()
  {
    return this.zzbbJ;
  }
  
  public boolean zzDO()
  {
    return this.zzbbK;
  }
  
  public boolean zzDP()
  {
    return this.zzbbL;
  }
  
  public boolean zzmA()
  {
    return this.zzVF;
  }
  
  public String zzmB()
  {
    return this.zzVG;
  }
  
  public boolean zzmy()
  {
    return this.zzVD;
  }
  
  public static final class zza
  {
    private String zzaYL;
    private boolean zzbbM;
    private boolean zzbbN;
    private GoogleApiClient.ServerAuthCodeCallbacks zzbbO;
    private boolean zzbbP;
    private boolean zzbbQ;
    private boolean zzbbR;
    
    private String zzbH(String paramString)
    {
      zzx.zzy(paramString);
      if ((this.zzaYL == null) || (this.zzaYL.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public zzsd zzDQ()
    {
      return new zzsd(this.zzbbM, this.zzbbN, this.zzaYL, this.zzbbO, this.zzbbP, this.zzbbQ, this.zzbbR, null);
    }
    
    public zza zza(String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks)
    {
      this.zzbbM = true;
      this.zzbbN = true;
      this.zzaYL = zzbH(paramString);
      this.zzbbO = ((GoogleApiClient.ServerAuthCodeCallbacks)zzx.zzy(paramServerAuthCodeCallbacks));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */