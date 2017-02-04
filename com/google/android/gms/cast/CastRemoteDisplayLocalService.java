package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.id;
import com.google.android.gms.R.string;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService
  extends Service
{
  private static final Object zzYA = new Object();
  private static AtomicBoolean zzYB = new AtomicBoolean(false);
  private static CastRemoteDisplayLocalService zzYQ;
  private static final zzl zzYy = new zzl("CastRemoteDisplayLocalService");
  private static final int zzYz = R.id.cast_notification_id;
  private Handler mHandler;
  private Notification mNotification;
  private String zzXW;
  private GoogleApiClient zzYC;
  private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzYD;
  private Callbacks zzYE;
  private zzb zzYF;
  private NotificationSettings zzYG;
  private boolean zzYH;
  private PendingIntent zzYI;
  private CastDevice zzYJ;
  private Display zzYK;
  private Context zzYL;
  private ServiceConnection zzYM;
  private MediaRouter zzYN;
  private boolean zzYO = false;
  private final MediaRouter.Callback zzYP = new MediaRouter.Callback()
  {
    public void onRouteUnselected(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
    {
      CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected");
      if (CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this) == null)
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected, no device was selected");
        return;
      }
      if (!CastDevice.getFromBundle(paramAnonymousRouteInfo.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this).getDeviceId()))
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected, device does not match");
        return;
      }
      CastRemoteDisplayLocalService.stopService();
    }
  };
  private final IBinder zzYR = new zza(null);
  
  public static CastRemoteDisplayLocalService getInstance()
  {
    synchronized (zzYA)
    {
      CastRemoteDisplayLocalService localCastRemoteDisplayLocalService = zzYQ;
      return localCastRemoteDisplayLocalService;
    }
  }
  
  protected static void setDebugEnabled()
  {
    zzYy.zzY(true);
  }
  
  public static void startService(final Context paramContext, Class<? extends CastRemoteDisplayLocalService> paramClass, String paramString, final CastDevice paramCastDevice, final NotificationSettings paramNotificationSettings, final Callbacks paramCallbacks)
  {
    zzYy.zzb("Starting Service", new Object[0]);
    synchronized (zzYA)
    {
      if (zzYQ != null)
      {
        zzYy.zzf("An existing service had not been stopped before starting one", new Object[0]);
        zzS(true);
      }
      zzb(paramContext, paramClass);
      zzx.zzb(paramContext, "activityContext is required.");
      zzx.zzb(paramClass, "serviceClass is required.");
      zzx.zzb(paramString, "applicationId is required.");
      zzx.zzb(paramCastDevice, "device is required.");
      zzx.zzb(paramNotificationSettings, "notificationSettings is required.");
      zzx.zzb(paramCallbacks, "callbacks is required.");
      if ((NotificationSettings.zzb(paramNotificationSettings) == null) && (NotificationSettings.zze(paramNotificationSettings) == null)) {
        throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
      }
    }
    if (zzYB.getAndSet(true))
    {
      zzYy.zzc("Service is already being started, startService has been called twice", new Object[0]);
      return;
    }
    paramClass = new Intent(paramContext, paramClass);
    paramContext.startService(paramClass);
    paramContext.bindService(paramClass, new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        paramAnonymousComponentName = ((CastRemoteDisplayLocalService.zza)paramAnonymousIBinder).zznu();
        if ((paramAnonymousComponentName == null) || (!CastRemoteDisplayLocalService.zza(paramAnonymousComponentName, this.zzYc, paramCastDevice, paramNotificationSettings, paramContext, this, paramCallbacks)))
        {
          CastRemoteDisplayLocalService.zznq().zzc("Connected but unable to get the service instance", new Object[0]);
          paramCallbacks.onRemoteDisplaySessionError(new Status(2200));
          CastRemoteDisplayLocalService.zznr().set(false);
        }
        try
        {
          paramContext.unbindService(this);
          return;
        }
        catch (IllegalArgumentException paramAnonymousComponentName)
        {
          CastRemoteDisplayLocalService.zznq().zzb("No need to unbind service, already unbound", new Object[0]);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        CastRemoteDisplayLocalService.zznq().zzb("onServiceDisconnected", new Object[0]);
        paramCallbacks.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
        CastRemoteDisplayLocalService.zznr().set(false);
        try
        {
          paramContext.unbindService(this);
          return;
        }
        catch (IllegalArgumentException paramAnonymousComponentName)
        {
          CastRemoteDisplayLocalService.zznq().zzb("No need to unbind service, already unbound", new Object[0]);
        }
      }
    }, 64);
  }
  
  public static void stopService()
  {
    zzS(false);
  }
  
  private void zzQ(final boolean paramBoolean)
  {
    if (this.mHandler != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, paramBoolean);
          }
        });
      }
    }
    else {
      return;
    }
    zzR(paramBoolean);
  }
  
  private void zzR(boolean paramBoolean)
  {
    zzbb("Stopping Service");
    zzx.zzcx("stopServiceInstanceInternal must be called on the main thread");
    if ((!paramBoolean) && (this.zzYN != null))
    {
      zzbb("Setting default route");
      this.zzYN.selectRoute(this.zzYN.getDefaultRoute());
    }
    if (this.zzYF != null)
    {
      zzbb("Unregistering notification receiver");
      unregisterReceiver(this.zzYF);
    }
    zznn();
    zzno();
    zznj();
    if (this.zzYC != null)
    {
      this.zzYC.disconnect();
      this.zzYC = null;
    }
    if ((this.zzYL != null) && (this.zzYM != null)) {}
    try
    {
      this.zzYL.unbindService(this.zzYM);
      this.zzYM = null;
      this.zzYL = null;
      this.zzXW = null;
      this.zzYC = null;
      this.mNotification = null;
      this.zzYK = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        zzbb("No need to unbind service, already unbound");
      }
    }
  }
  
  private static void zzS(boolean paramBoolean)
  {
    zzYy.zzb("Stopping Service", new Object[0]);
    zzYB.set(false);
    synchronized (zzYA)
    {
      if (zzYQ == null)
      {
        zzYy.zzc("Service is already being stopped", new Object[0]);
        return;
      }
      CastRemoteDisplayLocalService localCastRemoteDisplayLocalService = zzYQ;
      zzYQ = null;
      localCastRemoteDisplayLocalService.zzQ(paramBoolean);
      return;
    }
  }
  
  private Notification zzT(boolean paramBoolean)
  {
    zzbb("createDefaultNotification");
    int k = getApplicationInfo().labelRes;
    String str3 = NotificationSettings.zzc(this.zzYG);
    String str2 = NotificationSettings.zzd(this.zzYG);
    int j;
    int i;
    String str1;
    if (paramBoolean)
    {
      j = R.string.cast_notification_connected_message;
      i = R.drawable.cast_ic_notification_on;
      str1 = str3;
      if (TextUtils.isEmpty(str3)) {
        str1 = getString(k);
      }
      if (!TextUtils.isEmpty(str2)) {
        break label163;
      }
      str2 = getString(j, new Object[] { this.zzYJ.getFriendlyName() });
    }
    label163:
    for (;;)
    {
      return new NotificationCompat.Builder(this).setContentTitle(str1).setContentText(str2).setContentIntent(NotificationSettings.zze(this.zzYG)).setSmallIcon(i).setOngoing(true).addAction(17301560, getString(R.string.cast_notification_disconnect), zznp()).build();
      j = R.string.cast_notification_connecting_message;
      i = R.drawable.cast_ic_notification_connecting;
      break;
    }
  }
  
  private GoogleApiClient zza(CastDevice paramCastDevice)
  {
    paramCastDevice = new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(paramCastDevice, this.zzYD);
    new GoogleApiClient.Builder(this, new GoogleApiClient.ConnectionCallbacks()new GoogleApiClient.OnConnectionFailedListener
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onConnected");
        CastRemoteDisplayLocalService.zzf(CastRemoteDisplayLocalService.this);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        CastRemoteDisplayLocalService.zznq().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] { this, Integer.valueOf(paramAnonymousInt) }), new Object[0]);
      }
    }, new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this, "Connection failed: " + paramAnonymousConnectionResult);
        CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
      }
    }).addApi(CastRemoteDisplay.API, paramCastDevice.build()).build();
  }
  
  private void zza(Display paramDisplay)
  {
    this.zzYK = paramDisplay;
    if (this.zzYH)
    {
      this.mNotification = zzT(true);
      startForeground(zzYz, this.mNotification);
    }
    if (this.zzYE != null)
    {
      this.zzYE.onRemoteDisplaySessionStarted(this);
      this.zzYE = null;
    }
    onCreatePresentation(this.zzYK);
  }
  
  private void zza(NotificationSettings paramNotificationSettings)
  {
    zzx.zzcx("updateNotificationSettingsInternal must be called on the main thread");
    if (this.zzYG == null) {
      throw new IllegalStateException("No current notification settings to update");
    }
    if (this.zzYH)
    {
      if (NotificationSettings.zzb(paramNotificationSettings) != null) {
        throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
      }
      if (NotificationSettings.zze(paramNotificationSettings) != null) {
        NotificationSettings.zza(this.zzYG, NotificationSettings.zze(paramNotificationSettings));
      }
      if (!TextUtils.isEmpty(NotificationSettings.zzc(paramNotificationSettings))) {
        NotificationSettings.zza(this.zzYG, NotificationSettings.zzc(paramNotificationSettings));
      }
      if (!TextUtils.isEmpty(NotificationSettings.zzd(paramNotificationSettings))) {
        NotificationSettings.zzb(this.zzYG, NotificationSettings.zzd(paramNotificationSettings));
      }
      this.mNotification = zzT(true);
    }
    for (;;)
    {
      startForeground(zzYz, this.mNotification);
      return;
      zzx.zzb(NotificationSettings.zzb(paramNotificationSettings), "notification is required.");
      this.mNotification = NotificationSettings.zzb(paramNotificationSettings);
      NotificationSettings.zza(this.zzYG, this.mNotification);
    }
  }
  
  private boolean zza(String paramString, CastDevice paramCastDevice, NotificationSettings paramNotificationSettings, Context paramContext, ServiceConnection paramServiceConnection, Callbacks paramCallbacks)
  {
    zzbb("startRemoteDisplaySession");
    zzx.zzcx("Starting the Cast Remote Display must be done on the main thread");
    for (;;)
    {
      synchronized (zzYA)
      {
        if (zzYQ != null)
        {
          zzYy.zzf("An existing service had not been stopped before starting one", new Object[0]);
          return false;
        }
        zzYQ = this;
        this.zzYE = paramCallbacks;
        this.zzXW = paramString;
        this.zzYJ = paramCastDevice;
        this.zzYL = paramContext;
        this.zzYM = paramServiceConnection;
        this.zzYN = MediaRouter.getInstance(getApplicationContext());
        paramString = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzXW)).build();
        zzbb("addMediaRouterCallback");
        this.zzYN.addCallback(paramString, this.zzYP, 4);
        this.zzYD = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks()
        {
          public void onRemoteDisplayEnded(Status paramAnonymousStatus)
          {
            CastRemoteDisplayLocalService.zznq().zzb(String.format("Cast screen has ended: %d", new Object[] { Integer.valueOf(paramAnonymousStatus.getStatusCode()) }), new Object[0]);
            CastRemoteDisplayLocalService.zzU(false);
          }
        };
        this.mNotification = NotificationSettings.zzb(paramNotificationSettings);
        this.zzYF = new zzb(null);
        registerReceiver(this.zzYF, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        this.zzYG = new NotificationSettings(paramNotificationSettings, null);
        if (NotificationSettings.zzb(this.zzYG) == null)
        {
          this.zzYH = true;
          this.mNotification = zzT(false);
          startForeground(zzYz, this.mNotification);
          this.zzYC = zza(paramCastDevice);
          this.zzYC.connect();
          if (this.zzYE != null) {
            this.zzYE.onServiceCreated(this);
          }
          return true;
        }
      }
      this.zzYH = false;
      this.mNotification = NotificationSettings.zzb(this.zzYG);
    }
  }
  
  private static void zzb(Context paramContext, Class paramClass)
  {
    try
    {
      paramClass = new ComponentName(paramContext, paramClass);
      paramContext = paramContext.getPackageManager().getServiceInfo(paramClass, 128);
      if ((paramContext != null) && (paramContext.exported)) {
        throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
    }
  }
  
  private void zzbb(String paramString)
  {
    zzYy.zzb("[Instance: %s] %s", new Object[] { this, paramString });
  }
  
  private void zzbe(String paramString)
  {
    zzYy.zzc("[Instance: %s] %s", new Object[] { this, paramString });
  }
  
  private void zznj()
  {
    if (this.zzYN != null)
    {
      zzx.zzcx("CastRemoteDisplayLocalService calls must be done on the main thread");
      zzbb("removeMediaRouterCallback");
      this.zzYN.removeCallback(this.zzYP);
    }
  }
  
  private void zznk()
  {
    zzbb("startRemoteDisplay");
    if ((this.zzYC == null) || (!this.zzYC.isConnected()))
    {
      zzYy.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
      return;
    }
    CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzYC, this.zzXW).setResultCallback(new ResultCallback()
    {
      public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult paramAnonymousCastRemoteDisplaySessionResult)
      {
        if (!paramAnonymousCastRemoteDisplaySessionResult.getStatus().isSuccess())
        {
          CastRemoteDisplayLocalService.zznq().zzc("Connection was not successful", new Object[0]);
          CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
          return;
        }
        CastRemoteDisplayLocalService.zznq().zzb("startRemoteDisplay successful", new Object[0]);
        synchronized (CastRemoteDisplayLocalService.zzns())
        {
          if (CastRemoteDisplayLocalService.zznt() == null)
          {
            CastRemoteDisplayLocalService.zznq().zzb("Remote Display started but session already cancelled", new Object[0]);
            CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
            return;
          }
        }
        paramAnonymousCastRemoteDisplaySessionResult = paramAnonymousCastRemoteDisplaySessionResult.getPresentationDisplay();
        if (paramAnonymousCastRemoteDisplaySessionResult != null) {
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, paramAnonymousCastRemoteDisplaySessionResult);
        }
        for (;;)
        {
          CastRemoteDisplayLocalService.zznr().set(false);
          if ((CastRemoteDisplayLocalService.zzd(CastRemoteDisplayLocalService.this) == null) || (CastRemoteDisplayLocalService.zze(CastRemoteDisplayLocalService.this) == null)) {
            break;
          }
          try
          {
            CastRemoteDisplayLocalService.zzd(CastRemoteDisplayLocalService.this).unbindService(CastRemoteDisplayLocalService.zze(CastRemoteDisplayLocalService.this));
            CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, null);
            CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, null);
            return;
            CastRemoteDisplayLocalService.zznq().zzc("Cast Remote Display session created without display", new Object[0]);
          }
          catch (IllegalArgumentException paramAnonymousCastRemoteDisplaySessionResult)
          {
            for (;;)
            {
              CastRemoteDisplayLocalService.zznq().zzb("No need to unbind service, already unbound", new Object[0]);
            }
          }
        }
      }
    });
  }
  
  private void zznl()
  {
    zzbb("stopRemoteDisplay");
    if ((this.zzYC == null) || (!this.zzYC.isConnected()))
    {
      zzYy.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
      return;
    }
    CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzYC).setResultCallback(new ResultCallback()
    {
      public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult paramAnonymousCastRemoteDisplaySessionResult)
      {
        if (!paramAnonymousCastRemoteDisplaySessionResult.getStatus().isSuccess()) {
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "Unable to stop the remote display, result unsuccessful");
        }
        for (;;)
        {
          CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this, null);
          return;
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "remote display stopped");
        }
      }
    });
  }
  
  private void zznm()
  {
    if (this.zzYE != null)
    {
      this.zzYE.onRemoteDisplaySessionError(new Status(2200));
      this.zzYE = null;
    }
    stopService();
  }
  
  private void zznn()
  {
    zzbb("stopRemoteDisplaySession");
    zznl();
    onDismissPresentation();
  }
  
  private void zzno()
  {
    zzbb("Stopping the remote display Service");
    stopForeground(true);
    stopSelf();
  }
  
  private PendingIntent zznp()
  {
    if (this.zzYI == null) {
      this.zzYI = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), 268435456);
    }
    return this.zzYI;
  }
  
  protected Display getDisplay()
  {
    return this.zzYK;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    zzbb("onBind");
    return this.zzYR;
  }
  
  public void onCreate()
  {
    zzbb("onCreate");
    super.onCreate();
    this.mHandler = new Handler(getMainLooper());
    this.mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onCreate after delay. The local service been started: " + CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this));
        if (!CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this))
        {
          CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this, "The local service has not been been started, stopping it");
          CastRemoteDisplayLocalService.this.stopSelf();
        }
      }
    }, 100L);
  }
  
  public abstract void onCreatePresentation(Display paramDisplay);
  
  public abstract void onDismissPresentation();
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzbb("onStartCommand");
    this.zzYO = true;
    return 2;
  }
  
  public void updateNotificationSettings(final NotificationSettings paramNotificationSettings)
  {
    zzx.zzb(paramNotificationSettings, "notificationSettings is required.");
    zzx.zzb(this.mHandler, "Service is not ready yet.");
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, paramNotificationSettings);
      }
    });
  }
  
  public static abstract interface Callbacks
  {
    public abstract void onRemoteDisplaySessionError(Status paramStatus);
    
    public abstract void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService paramCastRemoteDisplayLocalService);
    
    public abstract void onServiceCreated(CastRemoteDisplayLocalService paramCastRemoteDisplayLocalService);
  }
  
  public static final class NotificationSettings
  {
    private Notification mNotification;
    private PendingIntent zzYY;
    private String zzYZ;
    private String zzZa;
    
    private NotificationSettings() {}
    
    private NotificationSettings(NotificationSettings paramNotificationSettings)
    {
      this.mNotification = paramNotificationSettings.mNotification;
      this.zzYY = paramNotificationSettings.zzYY;
      this.zzYZ = paramNotificationSettings.zzYZ;
      this.zzZa = paramNotificationSettings.zzZa;
    }
    
    public static final class Builder
    {
      private CastRemoteDisplayLocalService.NotificationSettings zzZb = new CastRemoteDisplayLocalService.NotificationSettings(null);
      
      public CastRemoteDisplayLocalService.NotificationSettings build()
      {
        if (CastRemoteDisplayLocalService.NotificationSettings.zzb(this.zzZb) != null)
        {
          if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(this.zzZb))) {
            throw new IllegalArgumentException("notificationTitle requires using the default notification");
          }
          if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzd(this.zzZb))) {
            throw new IllegalArgumentException("notificationText requires using the default notification");
          }
          if (CastRemoteDisplayLocalService.NotificationSettings.zze(this.zzZb) != null) {
            throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
          }
        }
        else if ((TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(this.zzZb))) && (TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzd(this.zzZb))) && (CastRemoteDisplayLocalService.NotificationSettings.zze(this.zzZb) == null))
        {
          throw new IllegalArgumentException("At least an argument must be provided");
        }
        return this.zzZb;
      }
      
      public Builder setNotification(Notification paramNotification)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzZb, paramNotification);
        return this;
      }
      
      public Builder setNotificationPendingIntent(PendingIntent paramPendingIntent)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzZb, paramPendingIntent);
        return this;
      }
      
      public Builder setNotificationText(String paramString)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zzb(this.zzZb, paramString);
        return this;
      }
      
      public Builder setNotificationTitle(String paramString)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzZb, paramString);
        return this;
      }
    }
  }
  
  private class zza
    extends Binder
  {
    private zza() {}
    
    CastRemoteDisplayLocalService zznu()
    {
      return CastRemoteDisplayLocalService.this;
    }
  }
  
  private static final class zzb
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"))
      {
        CastRemoteDisplayLocalService.zznq().zzb("disconnecting", new Object[0]);
        CastRemoteDisplayLocalService.stopService();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/CastRemoteDisplayLocalService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */