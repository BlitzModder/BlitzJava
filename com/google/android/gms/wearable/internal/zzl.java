package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzl
  implements ChannelApi
{
  private static zzb.zza<ChannelApi.ChannelListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzce paramAnonymouszzce, zzlx.zzb<Status> paramAnonymouszzb, ChannelApi.ChannelListener paramAnonymousChannelListener, zzmn<ChannelApi.ChannelListener> paramAnonymouszzmn)
        throws RemoteException
      {
        paramAnonymouszzce.zza(paramAnonymouszzb, paramAnonymousChannelListener, paramAnonymouszzmn, null, this.zzbmK);
      }
    };
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return zzb.zza(paramGoogleApiClient, zza(new IntentFilter[] { zzcc.zzfY("com.google.android.gms.wearable.CHANNEL_EVENT") }), paramChannelListener);
  }
  
  public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramString1, "nodeId is null");
    zzx.zzb(paramString2, "path is null");
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zze(this, paramString1, paramString2);
      }
      
      public ChannelApi.OpenChannelResult zzbo(Status paramAnonymousStatus)
      {
        return new zzl.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramChannelListener, null));
  }
  
  static final class zza
    implements ChannelApi.OpenChannelResult
  {
    private final Status zzTA;
    private final Channel zzbmT;
    
    zza(Status paramStatus, Channel paramChannel)
    {
      this.zzTA = ((Status)zzx.zzy(paramStatus));
      this.zzbmT = paramChannel;
    }
    
    public Channel getChannel()
    {
      return this.zzbmT;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  static final class zzb
    extends zzi<Status>
  {
    private final String zzTR;
    private ChannelApi.ChannelListener zzbmU;
    
    zzb(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener, String paramString)
    {
      super();
      this.zzbmU = ((ChannelApi.ChannelListener)zzx.zzy(paramChannelListener));
      this.zzTR = paramString;
    }
    
    protected void zza(zzce paramzzce)
      throws RemoteException
    {
      paramzzce.zza(this, this.zzbmU, this.zzTR);
      this.zzbmU = null;
    }
    
    public Status zzb(Status paramStatus)
    {
      this.zzbmU = null;
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */