package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzqz
  extends zzj<zzrc>
{
  private final long zzaBC = hashCode();
  
  public zzqz(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 54, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void disconnect()
  {
    if (isConnected()) {}
    try
    {
      ((zzrc)zzqs()).zzF(this.zzaBC);
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", localRemoteException);
      }
    }
  }
  
  public String zzCs()
  {
    try
    {
      String str = ((zzrc)zzqs()).zzU(this.zzaBC);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public String zzCt()
  {
    try
    {
      String str = ((zzrc)zzqs()).zzCt();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void zzCu()
  {
    try
    {
      ((zzrc)zzqs()).zzR(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop advertising", localRemoteException);
    }
  }
  
  public void zzCv()
  {
    try
    {
      ((zzrc)zzqs()).zzT(this.zzaBC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", localRemoteException);
    }
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, String paramString, long paramLong, zzmn<Connections.EndpointDiscoveryListener> paramzzmn)
    throws RemoteException
  {
    ((zzrc)zzqs()).zza(new zzg(paramzzb, paramzzmn), paramString, paramLong, this.zzaBC);
  }
  
  public void zza(zzlx.zzb<Connections.StartAdvertisingResult> paramzzb, String paramString, AppMetadata paramAppMetadata, long paramLong, zzmn<Connections.ConnectionRequestListener> paramzzmn)
    throws RemoteException
  {
    ((zzrc)zzqs()).zza(new zze(paramzzb, paramzzmn), paramString, paramAppMetadata, paramLong, this.zzaBC);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, String paramString1, String paramString2, byte[] paramArrayOfByte, zzmn<Connections.ConnectionResponseCallback> paramzzmn, zzmn<Connections.MessageListener> paramzzmn1)
    throws RemoteException
  {
    ((zzrc)zzqs()).zza(new zzd(paramzzb, paramzzmn, paramzzmn1), paramString1, paramString2, paramArrayOfByte, this.zzaBC);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, String paramString, byte[] paramArrayOfByte, zzmn<Connections.MessageListener> paramzzmn)
    throws RemoteException
  {
    ((zzrc)zzqs()).zza(new zza(paramzzb, paramzzmn), paramString, paramArrayOfByte, this.zzaBC);
  }
  
  public void zza(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    try
    {
      ((zzrc)zzqs()).zza(paramArrayOfString, paramArrayOfByte, this.zzaBC);
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't send reliable message", paramArrayOfString);
    }
  }
  
  public void zzb(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    try
    {
      ((zzrc)zzqs()).zzb(paramArrayOfString, paramArrayOfByte, this.zzaBC);
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", paramArrayOfString);
    }
  }
  
  protected zzrc zzdq(IBinder paramIBinder)
  {
    return zzrc.zza.zzds(paramIBinder);
  }
  
  public void zzeL(String paramString)
  {
    try
    {
      ((zzrc)zzqs()).zzh(paramString, this.zzaBC);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop discovery", paramString);
    }
  }
  
  public void zzeM(String paramString)
  {
    try
    {
      ((zzrc)zzqs()).zzi(paramString, this.zzaBC);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", paramString);
    }
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.nearby.connection.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
  }
  
  public void zzp(zzlx.zzb<Status> paramzzb, String paramString)
    throws RemoteException
  {
    ((zzrc)zzqs()).zza(new zzc(paramzzb), paramString, this.zzaBC);
  }
  
  private static final class zza
    extends zzqz.zzb
  {
    private final zzlx.zzb<Status> zzakL;
    
    public zza(zzlx.zzb<Status> paramzzb, zzmn<Connections.MessageListener> paramzzmn)
    {
      super();
      this.zzakL = ((zzlx.zzb)zzx.zzy(paramzzb));
    }
    
    public void zziN(int paramInt)
      throws RemoteException
    {
      this.zzakL.zzr(new Status(paramInt));
    }
  }
  
  private static class zzb
    extends zzqy
  {
    private final zzmn<Connections.MessageListener> zzaWe;
    
    zzb(zzmn<Connections.MessageListener> paramzzmn)
    {
      this.zzaWe = paramzzmn;
    }
    
    public void onDisconnected(final String paramString)
      throws RemoteException
    {
      this.zzaWe.zza(new zzmn.zzb()
      {
        public void zza(Connections.MessageListener paramAnonymousMessageListener)
        {
          paramAnonymousMessageListener.onDisconnected(paramString);
        }
        
        public void zzpb() {}
      });
    }
    
    public void onMessageReceived(final String paramString, final byte[] paramArrayOfByte, final boolean paramBoolean)
      throws RemoteException
    {
      this.zzaWe.zza(new zzmn.zzb()
      {
        public void zza(Connections.MessageListener paramAnonymousMessageListener)
        {
          paramAnonymousMessageListener.onMessageReceived(paramString, paramArrayOfByte, paramBoolean);
        }
        
        public void zzpb() {}
      });
    }
  }
  
  private static class zzc
    extends zzqy
  {
    private final zzlx.zzb<Status> zzaWi;
    
    zzc(zzlx.zzb<Status> paramzzb)
    {
      this.zzaWi = paramzzb;
    }
    
    public void zziO(int paramInt)
      throws RemoteException
    {
      this.zzaWi.zzr(new Status(paramInt));
    }
  }
  
  private static final class zzd
    extends zzqz.zzb
  {
    private final zzmn<Connections.ConnectionResponseCallback> zzaWj;
    private final zzlx.zzb<Status> zzakL;
    
    public zzd(zzlx.zzb<Status> paramzzb, zzmn<Connections.ConnectionResponseCallback> paramzzmn, zzmn<Connections.MessageListener> paramzzmn1)
    {
      super();
      this.zzakL = ((zzlx.zzb)zzx.zzy(paramzzb));
      this.zzaWj = ((zzmn)zzx.zzy(paramzzmn));
    }
    
    public void zza(final String paramString, final int paramInt, final byte[] paramArrayOfByte)
      throws RemoteException
    {
      this.zzaWj.zza(new zzmn.zzb()
      {
        public void zza(Connections.ConnectionResponseCallback paramAnonymousConnectionResponseCallback)
        {
          paramAnonymousConnectionResponseCallback.onConnectionResponse(paramString, new Status(paramInt), paramArrayOfByte);
        }
        
        public void zzpb() {}
      });
    }
    
    public void zziM(int paramInt)
      throws RemoteException
    {
      this.zzakL.zzr(new Status(paramInt));
    }
  }
  
  private static final class zze
    extends zzqy
  {
    private final zzmn<Connections.ConnectionRequestListener> zzaWl;
    private final zzlx.zzb<Connections.StartAdvertisingResult> zzakL;
    
    zze(zzlx.zzb<Connections.StartAdvertisingResult> paramzzb, zzmn<Connections.ConnectionRequestListener> paramzzmn)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzy(paramzzb));
      this.zzaWl = ((zzmn)zzx.zzy(paramzzmn));
    }
    
    public void onConnectionRequest(final String paramString1, final String paramString2, final String paramString3, final byte[] paramArrayOfByte)
      throws RemoteException
    {
      this.zzaWl.zza(new zzmn.zzb()
      {
        public void zza(Connections.ConnectionRequestListener paramAnonymousConnectionRequestListener)
        {
          paramAnonymousConnectionRequestListener.onConnectionRequest(paramString1, paramString2, paramString3, paramArrayOfByte);
        }
        
        public void zzpb() {}
      });
    }
    
    public void zzo(int paramInt, String paramString)
      throws RemoteException
    {
      this.zzakL.zzr(new zzqz.zzf(new Status(paramInt), paramString));
    }
  }
  
  private static final class zzf
    implements Connections.StartAdvertisingResult
  {
    private final Status zzTA;
    private final String zzaWp;
    
    zzf(Status paramStatus, String paramString)
    {
      this.zzTA = paramStatus;
      this.zzaWp = paramString;
    }
    
    public String getLocalEndpointName()
    {
      return this.zzaWp;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class zzg
    extends zzqy
  {
    private final zzmn<Connections.EndpointDiscoveryListener> zzaWl;
    private final zzlx.zzb<Status> zzakL;
    
    zzg(zzlx.zzb<Status> paramzzb, zzmn<Connections.EndpointDiscoveryListener> paramzzmn)
    {
      this.zzakL = ((zzlx.zzb)zzx.zzy(paramzzb));
      this.zzaWl = ((zzmn)zzx.zzy(paramzzmn));
    }
    
    public void onEndpointFound(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
      throws RemoteException
    {
      this.zzaWl.zza(new zzmn.zzb()
      {
        public void zza(Connections.EndpointDiscoveryListener paramAnonymousEndpointDiscoveryListener)
        {
          paramAnonymousEndpointDiscoveryListener.onEndpointFound(paramString1, paramString2, paramString3, paramString4);
        }
        
        public void zzpb() {}
      });
    }
    
    public void onEndpointLost(final String paramString)
      throws RemoteException
    {
      this.zzaWl.zza(new zzmn.zzb()
      {
        public void zza(Connections.EndpointDiscoveryListener paramAnonymousEndpointDiscoveryListener)
        {
          paramAnonymousEndpointDiscoveryListener.onEndpointLost(paramString);
        }
        
        public void zzpb() {}
      });
    }
    
    public void zziK(int paramInt)
      throws RemoteException
    {
      this.zzakL.zzr(new Status(paramInt));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */