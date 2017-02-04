package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzbm
  implements MessageApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramMessageListener, paramGoogleApiClient.zzq(paramMessageListener), paramArrayOfIntentFilter, null));
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzcc.zzfY("com.google.android.gms.wearable.MESSAGE_RECEIVED") });
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      bool = true;
      zzx.zzb(bool, "uri must not be null");
      if ((paramInt != 0) && (paramInt != 1)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramMessageListener, new IntentFilter[] { zzcc.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramMessageListener);
      }
      
      public Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramString1, paramString2, paramArrayOfByte);
      }
      
      protected MessageApi.SendMessageResult zzbv(Status paramAnonymousStatus)
      {
        return new zzbm.zzb(paramAnonymousStatus, -1);
      }
    });
  }
  
  private static final class zza
    extends zzi<Status>
  {
    private zzmn<MessageApi.MessageListener> zzaWl;
    private MessageApi.MessageListener zzbot;
    private IntentFilter[] zzbou;
    
    private zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, zzmn<MessageApi.MessageListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
    {
      super();
      this.zzbot = ((MessageApi.MessageListener)zzx.zzy(paramMessageListener));
      this.zzaWl = ((zzmn)zzx.zzy(paramzzmn));
      this.zzbou = ((IntentFilter[])zzx.zzy(paramArrayOfIntentFilter));
    }
    
    protected void zza(zzce paramzzce)
      throws RemoteException
    {
      paramzzce.zza(this, this.zzbot, this.zzaWl, this.zzbou);
      this.zzbot = null;
      this.zzaWl = null;
      this.zzbou = null;
    }
    
    public Status zzb(Status paramStatus)
    {
      this.zzbot = null;
      this.zzaWl = null;
      this.zzbou = null;
      return paramStatus;
    }
  }
  
  public static class zzb
    implements MessageApi.SendMessageResult
  {
    private final Status zzTA;
    private final int zzamD;
    
    public zzb(Status paramStatus, int paramInt)
    {
      this.zzTA = paramStatus;
      this.zzamD = paramInt;
    }
    
    public int getRequestId()
    {
      return this.zzamD;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */