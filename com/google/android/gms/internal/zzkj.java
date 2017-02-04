package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzkj
  implements AppInviteApi
{
  public PendingResult<Status> convertInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzd(paramGoogleApiClient, paramString));
  }
  
  public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient paramGoogleApiClient, Activity paramActivity, boolean paramBoolean)
  {
    return paramGoogleApiClient.zza(new zze(paramGoogleApiClient, paramActivity, paramBoolean));
  }
  
  public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramString));
  }
  
  static class zza
    extends zzkm.zza
  {
    public void zza(Status paramStatus, Intent paramIntent)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzd(Status paramStatus)
      throws RemoteException
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static abstract class zzb<R extends Result>
    extends zzlx.zza<R, zzkk>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  final class zzc
    extends zzkj.zzb<Status>
  {
    private final String zzTr;
    
    public zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super();
      this.zzTr = paramString;
    }
    
    protected void zza(zzkk paramzzkk)
      throws RemoteException
    {
      paramzzkk.zzb(new zzkj.zza()
      {
        public void zzd(Status paramAnonymousStatus)
          throws RemoteException
        {
          zzkj.zzc.this.zzb(paramAnonymousStatus);
        }
      }, this.zzTr);
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  final class zzd
    extends zzkj.zzb<Status>
  {
    private final String zzTr;
    
    public zzd(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super();
      this.zzTr = paramString;
    }
    
    protected void zza(zzkk paramzzkk)
      throws RemoteException
    {
      paramzzkk.zza(new zzkj.zza()
      {
        public void zzd(Status paramAnonymousStatus)
          throws RemoteException
        {
          zzkj.zzd.this.zzb(paramAnonymousStatus);
        }
      }, this.zzTr);
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  final class zze
    extends zzkj.zzb<AppInviteInvitationResult>
  {
    private final Activity zzTv;
    private final boolean zzTw;
    private final Intent zzTx;
    
    public zze(GoogleApiClient paramGoogleApiClient, Activity paramActivity, boolean paramBoolean)
    {
      super();
      this.zzTv = paramActivity;
      this.zzTw = paramBoolean;
      if (this.zzTv != null) {}
      for (this$1 = this.zzTv.getIntent();; this$1 = null)
      {
        this.zzTx = zzkj.this;
        return;
      }
    }
    
    protected void zza(zzkk paramzzkk)
      throws RemoteException
    {
      if (AppInviteReferral.hasReferral(this.zzTx))
      {
        zzb(new zzkl(Status.zzaeX, this.zzTx));
        return;
      }
      paramzzkk.zza(new zzkj.zza()
      {
        public void zza(Status paramAnonymousStatus, Intent paramAnonymousIntent)
        {
          zzkj.zze.this.zzb(new zzkl(paramAnonymousStatus, paramAnonymousIntent));
          if ((AppInviteReferral.hasReferral(paramAnonymousIntent)) && (zzkj.zze.zza(zzkj.zze.this)) && (zzkj.zze.zzb(zzkj.zze.this) != null)) {
            zzkj.zze.zzb(zzkj.zze.this).startActivity(paramAnonymousIntent);
          }
        }
      });
    }
    
    protected AppInviteInvitationResult zze(Status paramStatus)
    {
      return new zzkl(paramStatus, new Intent());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */