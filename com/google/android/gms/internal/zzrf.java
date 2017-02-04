package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzrf
  implements PanoramaApi
{
  private static void zza(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void zza(Context paramContext, zzre paramzzre, final zzrd paramzzrd, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    paramzzrd = new zzrd.zza()
    {
      public void zza(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        zzrf.zzb(this.zzsm, paramUri);
        paramzzrd.zza(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramzzre.zza(paramzzrd, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException paramzzre)
    {
      zza(paramContext, paramUri);
      throw paramzzre;
    }
    catch (RuntimeException paramzzre)
    {
      zza(paramContext, paramUri);
      throw paramzzre;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzre paramAnonymouszzre)
        throws RemoteException
      {
        paramAnonymouszzre.zza(new zzrf.zzb(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzre paramAnonymouszzre)
        throws RemoteException
      {
        zzrf.zzb(paramAnonymousContext, paramAnonymouszzre, new zzrf.zzb(this), paramUri, null);
      }
    });
  }
  
  private static abstract class zza
    extends zzrf.zzc<PanoramaApi.PanoramaResult>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected PanoramaApi.PanoramaResult zzaZ(Status paramStatus)
    {
      return new zzrh(paramStatus, null);
    }
  }
  
  private static final class zzb
    extends zzrd.zza
  {
    private final zzlx.zzb<PanoramaApi.PanoramaResult> zzakL;
    
    public zzb(zzlx.zzb<PanoramaApi.PanoramaResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.zzakL.zzr(new zzrh(paramBundle, paramIntent));
        return;
      }
    }
  }
  
  private static abstract class zzc<R extends Result>
    extends zzlx.zza<R, zzrg>
  {
    protected zzc(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected abstract void zza(Context paramContext, zzre paramzzre)
      throws RemoteException;
    
    protected final void zza(zzrg paramzzrg)
      throws RemoteException
    {
      zza(paramzzrg.getContext(), (zzre)paramzzrg.zzqs());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */