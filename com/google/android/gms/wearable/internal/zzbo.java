package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzbo
  implements NodeApi
{
  private static zzb.zza<NodeApi.NodeListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzce paramAnonymouszzce, zzlx.zzb<Status> paramAnonymouszzb, NodeApi.NodeListener paramAnonymousNodeListener, zzmn<NodeApi.NodeListener> paramAnonymouszzmn)
        throws RemoteException
      {
        paramAnonymouszzce.zza(paramAnonymouszzb, paramAnonymousNodeListener, paramAnonymouszzmn, this.zzbmK);
      }
    };
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, NodeApi.NodeListener paramNodeListener)
  {
    return zzb.zza(paramGoogleApiClient, zza(new IntentFilter[] { zzcc.zzfY("com.google.android.gms.wearable.NODE_CHANGED") }), paramNodeListener);
  }
  
  public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzq(this);
      }
      
      protected NodeApi.GetConnectedNodesResult zzbx(Status paramAnonymousStatus)
      {
        return new zzbo.zza(paramAnonymousStatus, new ArrayList());
      }
    });
  }
  
  public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzp(this);
      }
      
      protected NodeApi.GetLocalNodeResult zzbw(Status paramAnonymousStatus)
      {
        return new zzbo.zzb(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final NodeApi.NodeListener paramNodeListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramNodeListener);
      }
      
      public Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public static class zza
    implements NodeApi.GetConnectedNodesResult
  {
    private final Status zzTA;
    private final List<Node> zzbox;
    
    public zza(Status paramStatus, List<Node> paramList)
    {
      this.zzTA = paramStatus;
      this.zzbox = paramList;
    }
    
    public List<Node> getNodes()
    {
      return this.zzbox;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  public static class zzb
    implements NodeApi.GetLocalNodeResult
  {
    private final Status zzTA;
    private final Node zzboy;
    
    public zzb(Status paramStatus, Node paramNode)
    {
      this.zzTA = paramStatus;
      this.zzboy = paramNode;
    }
    
    public Node getNode()
    {
      return this.zzboy;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */