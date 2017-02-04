package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.zza;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzpx
  implements RecordingApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final Subscription paramSubscription)
  {
    paramGoogleApiClient.zza(new zzow.zzc(paramGoogleApiClient)
    {
      protected void zza(zzow paramAnonymouszzow)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzph)paramAnonymouszzow.zzqs()).zza(new SubscribeRequest(paramSubscription, false, localzzqa));
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzow.zza(paramGoogleApiClient)
    {
      protected ListSubscriptionsResult zzN(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.zzU(paramAnonymousStatus);
      }
      
      protected void zza(zzow paramAnonymouszzow)
        throws RemoteException
      {
        zzpx.zza localzza = new zzpx.zza(this, null);
        ((zzph)paramAnonymouszzow.zzqs()).zza(new ListSubscriptionsRequest(null, localzza));
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zza(new zzow.zza(paramGoogleApiClient)
    {
      protected ListSubscriptionsResult zzN(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.zzU(paramAnonymousStatus);
      }
      
      protected void zza(zzow paramAnonymouszzow)
        throws RemoteException
      {
        zzpx.zza localzza = new zzpx.zza(this, null);
        ((zzph)paramAnonymouszzow.zzqs()).zza(new ListSubscriptionsRequest(paramDataType, localzza));
      }
    });
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zzb(paramDataSource).zztW());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zzb(paramDataType).zztW());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, final DataSource paramDataSource)
  {
    paramGoogleApiClient.zzb(new zzow.zzc(paramGoogleApiClient)
    {
      protected void zza(zzow paramAnonymouszzow)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzph)paramAnonymouszzow.zzqs()).zza(new UnsubscribeRequest(null, paramDataSource, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zzb(new zzow.zzc(paramGoogleApiClient)
    {
      protected void zza(zzow paramAnonymouszzow)
        throws RemoteException
      {
        zzqa localzzqa = new zzqa(this);
        ((zzph)paramAnonymouszzow.zzqs()).zza(new UnsubscribeRequest(paramDataType, null, localzzqa));
      }
    });
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, paramSubscription.getDataSource());
    }
    return unsubscribe(paramGoogleApiClient, paramSubscription.getDataType());
  }
  
  private static class zza
    extends zzpk.zza
  {
    private final zzlx.zzb<ListSubscriptionsResult> zzakL;
    
    private zza(zzlx.zzb<ListSubscriptionsResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zza(ListSubscriptionsResult paramListSubscriptionsResult)
    {
      this.zzakL.zzr(paramListSubscriptionsResult);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzpx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */