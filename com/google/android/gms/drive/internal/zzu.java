package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzu
  extends zzj<zzam>
{
  private final String zzTz;
  final GoogleApiClient.ConnectionCallbacks zzajO;
  private final Bundle zzaoH;
  private final boolean zzaoI;
  private volatile DriveId zzaoJ;
  private volatile DriveId zzaoK;
  private volatile boolean zzaoL = false;
  final Map<DriveId, Map<ChangeListener, zzae>> zzaoM = new HashMap();
  final Map<zzc, zzae> zzaoN = new HashMap();
  final Map<DriveId, Map<zzi, zzae>> zzaoO = new HashMap();
  final Map<DriveId, Map<zzi, zzae>> zzaoP = new HashMap();
  
  public zzu(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, Bundle paramBundle)
  {
    super(paramContext, paramLooper, 11, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzTz = paramzzf.zzqd();
    this.zzajO = paramConnectionCallbacks;
    this.zzaoH = paramBundle;
    paramLooper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    paramLooper.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryIntentServices(paramLooper, 0);
    switch (paramContext.size())
    {
    default: 
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + paramLooper.getAction() + " action");
    case 0: 
      this.zzaoI = false;
      return;
    }
    paramContext = ((ResolveInfo)paramContext.get(0)).serviceInfo;
    if (!paramContext.exported) {
      throw new IllegalStateException("Drive event service " + paramContext.name + " must be exported in AndroidManifest.xml");
    }
    this.zzaoI = true;
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId)
  {
    zzx.zzb(zzg.zza(paramInt, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new RemoveEventListenerRequest(paramDriveId, paramInt), null, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final ChangesAvailableOptions paramChangesAvailableOptions)
  {
    zzx.zzb(zzg.zza(paramInt, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    if (!this.zzaoI) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new AddEventListenerRequest(paramDriveId, paramInt, paramChangesAvailableOptions), null, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final zzae paramzzae)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new RemoveEventListenerRequest(paramDriveId, paramInt), paramzzae, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final zzae paramzzae, final ChangesAvailableOptions paramChangesAvailableOptions)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new AddEventListenerRequest(paramDriveId, paramInt, paramChangesAvailableOptions), paramzzae, null, new zzbt(this));
      }
    });
  }
  
  PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    boolean bool2 = true;
    if (paramList != null)
    {
      bool1 = true;
      zzx.zzab(bool1);
      if (paramList.isEmpty()) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzab(bool1);
      zzx.zza(isConnected(), "Client must be connected");
      paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
      {
        protected void zza(zzu paramAnonymouszzu)
          throws RemoteException
        {
          paramAnonymouszzu.zzsF().zza(new CancelPendingActionsRequest(paramList), new zzbt(this));
        }
      });
      bool1 = false;
      break;
    }
  }
  
  public void disconnect()
  {
    if (isConnected()) {}
    try
    {
      ((zzam)zzqs()).zza(new DisconnectRequest());
      super.disconnect();
      synchronized (this.zzaoM)
      {
        this.zzaoM.clear();
        synchronized (this.zzaoN)
        {
          this.zzaoN.clear();
          synchronized (this.zzaoO)
          {
            this.zzaoO.clear();
          }
        }
      }
      synchronized (this.zzaoP)
      {
        this.zzaoP.clear();
        return;
        localObject1 = finally;
        throw ((Throwable)localObject1);
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    return zza(paramGoogleApiClient, 1, paramDriveId, null);
  }
  
  PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId, ChangeListener paramChangeListener)
  {
    zzx.zzb(zzg.zza(1, paramDriveId), "id");
    zzx.zzb(paramChangeListener, "listener");
    zzx.zza(isConnected(), "Client must be connected");
    label186:
    for (;;)
    {
      zzae localzzae;
      synchronized (this.zzaoM)
      {
        Object localObject = (Map)this.zzaoM.get(paramDriveId);
        if (localObject != null) {
          break label186;
        }
        localObject = new HashMap();
        this.zzaoM.put(paramDriveId, localObject);
        localzzae = (zzae)((Map)localObject).get(paramChangeListener);
        if (localzzae == null)
        {
          localzzae = new zzae(getLooper(), getContext(), 1, paramChangeListener);
          ((Map)localObject).put(paramChangeListener, localzzae);
          paramChangeListener = localzzae;
          paramChangeListener.zzdd(1);
          paramGoogleApiClient = zza(paramGoogleApiClient, 1, paramDriveId, paramChangeListener, null);
          return paramGoogleApiClient;
        }
        if (localzzae.zzde(1))
        {
          paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzaeX);
          return paramGoogleApiClient;
        }
      }
      paramChangeListener = localzzae;
    }
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.zzaoJ = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.zzaoK = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
      this.zzaoL = true;
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  protected zzam zzaZ(IBinder paramIBinder)
  {
    return zzam.zza.zzba(paramIBinder);
  }
  
  PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    return zza(paramGoogleApiClient, 1, paramDriveId);
  }
  
  PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId, ChangeListener paramChangeListener)
  {
    zzx.zzb(zzg.zza(1, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    zzx.zzb(paramChangeListener, "listener");
    Map localMap2;
    synchronized (this.zzaoM)
    {
      localMap2 = (Map)this.zzaoM.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzaeX);
        return paramGoogleApiClient;
      }
      paramChangeListener = (zzae)localMap2.remove(paramChangeListener);
      if (paramChangeListener == null)
      {
        paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzaeX);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.zzaoM.remove(paramDriveId);
    }
    paramGoogleApiClient = zza(paramGoogleApiClient, 1, paramDriveId, paramChangeListener);
    return paramGoogleApiClient;
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  protected Bundle zzlU()
  {
    String str = getContext().getPackageName();
    zzx.zzy(str);
    if (!zzqq().zzqb().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      Bundle localBundle = new Bundle();
      if (!str.equals(this.zzTz)) {
        localBundle.putString("proxy_package_name", this.zzTz);
      }
      localBundle.putAll(this.zzaoH);
      return localBundle;
    }
  }
  
  public boolean zzmn()
  {
    return (!getContext().getPackageName().equals(this.zzTz)) || (!zzsE());
  }
  
  public boolean zzqu()
  {
    return true;
  }
  
  boolean zzsE()
  {
    return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
  }
  
  public zzam zzsF()
    throws DeadObjectException
  {
    return (zzam)zzqs();
  }
  
  public DriveId zzsG()
  {
    return this.zzaoJ;
  }
  
  public DriveId zzsH()
  {
    return this.zzaoK;
  }
  
  public boolean zzsI()
  {
    return this.zzaoL;
  }
  
  public boolean zzsJ()
  {
    return this.zzaoI;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */