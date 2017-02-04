package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzpz
  implements SessionsApi
{
  private PendingResult<SessionStopResult> zza(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.zzb(new zzoy.zza(paramGoogleApiClient)
    {
      protected SessionStopResult zzP(Status paramAnonymousStatus)
      {
        return SessionStopResult.zzW(paramAnonymousStatus);
      }
      
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        zzpz.zzb localzzb = new zzpz.zzb(this, null);
        ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionStopRequest(paramString1, paramString2, localzzb));
      }
    });
  }
  
  public PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, final SessionInsertRequest paramSessionInsertRequest)
  {
    paramGoogleApiClient.zza(new zzoy.zzc(paramGoogleApiClient)
    {
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionInsertRequest(paramSessionInsertRequest, localzzqa));
      }
    });
  }
  
  public PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, final SessionReadRequest paramSessionReadRequest)
  {
    paramGoogleApiClient.zza(new zzoy.zza(paramGoogleApiClient)
    {
      protected SessionReadResult zzQ(Status paramAnonymousStatus)
      {
        return SessionReadResult.zzV(paramAnonymousStatus);
      }
      
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        zzpz.zza localzza = new zzpz.zza(this, null);
        ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionReadRequest(paramSessionReadRequest, localzza));
      }
    });
  }
  
  public PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, paramPendingIntent, 0);
  }
  
  public PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, final Session paramSession)
  {
    zzx.zzb(paramSession, "Session cannot be null");
    if (paramSession.getEndTime(TimeUnit.MILLISECONDS) == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Cannot start a session which has already ended");
      paramGoogleApiClient.zzb(new zzoy.zzc(paramGoogleApiClient)
      {
        protected void zza(zzoy paramAnonymouszzoy)
          throws RemoteException
        {
          zzqa localzzqa = new zzqa(this);
          ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionStartRequest(paramSession, localzzqa));
        }
      });
    }
  }
  
  public PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return zza(paramGoogleApiClient, null, paramString);
  }
  
  public PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zzoy.zzc(paramGoogleApiClient)
    {
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionUnregistrationRequest(paramPendingIntent, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent, final int paramInt)
  {
    paramGoogleApiClient.zzb(new zzoy.zzc(paramGoogleApiClient)
    {
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzpj)paramAnonymouszzoy.zzqs()).zza(new SessionRegistrationRequest(paramPendingIntent, localzzqa, paramInt));
      }
    });
  }
  
  private static class zza
    extends zzpn.zza
  {
    private final zzlx.zzb<SessionReadResult> zzakL;
    
    private zza(zzlx.zzb<SessionReadResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(SessionReadResult paramSessionReadResult)
      throws RemoteException
    {
      this.zzakL.zzr(paramSessionReadResult);
    }
  }
  
  private static class zzb
    extends zzpo.zza
  {
    private final zzlx.zzb<SessionStopResult> zzakL;
    
    private zzb(zzlx.zzb<SessionStopResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(SessionStopResult paramSessionStopResult)
    {
      this.zzakL.zzr(paramSessionStopResult);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */