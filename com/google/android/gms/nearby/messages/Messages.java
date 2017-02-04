package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface Messages
{
  public abstract PendingResult<Status> getPermissionStatus(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, Message paramMessage);
  
  public abstract PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, Message paramMessage, PublishOptions paramPublishOptions);
  
  @Deprecated
  public abstract PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, Message paramMessage, Strategy paramStrategy);
  
  public abstract PendingResult<Status> registerStatusCallback(GoogleApiClient paramGoogleApiClient, StatusCallback paramStatusCallback);
  
  public abstract PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener);
  
  @Deprecated
  public abstract PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, Strategy paramStrategy);
  
  @Deprecated
  public abstract PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, Strategy paramStrategy, MessageFilter paramMessageFilter);
  
  public abstract PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, SubscribeOptions paramSubscribeOptions);
  
  public abstract PendingResult<Status> unpublish(GoogleApiClient paramGoogleApiClient, Message paramMessage);
  
  public abstract PendingResult<Status> unregisterStatusCallback(GoogleApiClient paramGoogleApiClient, StatusCallback paramStatusCallback);
  
  public abstract PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/Messages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */