package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlx.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze
  extends zzj<zzi>
{
  private static final zzl zzYy = new zzl("CastClientImpl");
  private static final Object zzaci = new Object();
  private static final Object zzacj = new Object();
  private final Cast.Listener zzYj;
  private double zzZL;
  private boolean zzZM;
  private ApplicationMetadata zzabQ;
  private final CastDevice zzabR;
  private final Map<String, Cast.MessageReceivedCallback> zzabS;
  private final long zzabT;
  private zzb zzabU;
  private String zzabV;
  private boolean zzabW;
  private boolean zzabX;
  private boolean zzabY;
  private int zzabZ;
  private int zzaca;
  private final AtomicLong zzacb;
  private String zzacc;
  private String zzacd;
  private Bundle zzace;
  private final Map<Long, zzlx.zzb<Status>> zzacf;
  private zzlx.zzb<Cast.ApplicationConnectionResult> zzacg;
  private zzlx.zzb<Status> zzach;
  
  public zze(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 10, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzabR = paramCastDevice;
    this.zzYj = paramListener;
    this.zzabT = paramLong;
    this.zzabS = new HashMap();
    this.zzacb = new AtomicLong(0L);
    this.zzacf = new HashMap();
    zznP();
  }
  
  private void zza(ApplicationStatus paramApplicationStatus)
  {
    paramApplicationStatus = paramApplicationStatus.zznM();
    if (!zzf.zza(paramApplicationStatus, this.zzabV)) {
      this.zzabV = paramApplicationStatus;
    }
    for (boolean bool = true;; bool = false)
    {
      zzYy.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.zzabW) });
      if ((this.zzYj != null) && ((bool) || (this.zzabW))) {
        this.zzYj.onApplicationStatusChanged();
      }
      this.zzabW = false;
      return;
    }
  }
  
  private void zza(DeviceStatus paramDeviceStatus)
  {
    ApplicationMetadata localApplicationMetadata = paramDeviceStatus.getApplicationMetadata();
    if (!zzf.zza(localApplicationMetadata, this.zzabQ))
    {
      this.zzabQ = localApplicationMetadata;
      this.zzYj.onApplicationMetadataChanged(this.zzabQ);
    }
    double d = paramDeviceStatus.zznS();
    if ((d != NaN.0D) && (Math.abs(d - this.zzZL) > 1.0E-7D)) {
      this.zzZL = d;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramDeviceStatus.zzob();
      if (bool2 != this.zzZM)
      {
        this.zzZM = bool2;
        bool1 = true;
      }
      zzYy.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzabX) });
      if ((this.zzYj != null) && ((bool1) || (this.zzabX))) {
        this.zzYj.onVolumeChanged();
      }
      int i = paramDeviceStatus.zznT();
      if (i != this.zzabZ) {
        this.zzabZ = i;
      }
      for (bool1 = true;; bool1 = false)
      {
        zzYy.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzabX) });
        if ((this.zzYj != null) && ((bool1) || (this.zzabX))) {
          this.zzYj.onActiveInputStateChanged(this.zzabZ);
        }
        i = paramDeviceStatus.zznU();
        if (i != this.zzaca) {
          this.zzaca = i;
        }
        for (bool1 = true;; bool1 = false)
        {
          zzYy.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzabX) });
          if ((this.zzYj != null) && ((bool1) || (this.zzabX))) {
            this.zzYj.onStandbyStateChanged(this.zzaca);
          }
          this.zzabX = false;
          return;
        }
      }
    }
  }
  
  private void zza(zzlx.zzb<Cast.ApplicationConnectionResult> paramzzb)
  {
    synchronized (zzaci)
    {
      if (this.zzacg != null) {
        this.zzacg.zzr(new zza(new Status(2002)));
      }
      this.zzacg = paramzzb;
      return;
    }
  }
  
  private void zzc(zzlx.zzb<Status> paramzzb)
  {
    synchronized (zzacj)
    {
      if (this.zzach != null)
      {
        paramzzb.zzr(new Status(2001));
        return;
      }
      this.zzach = paramzzb;
      return;
    }
  }
  
  private void zznP()
  {
    this.zzabY = false;
    this.zzabZ = -1;
    this.zzaca = -1;
    this.zzabQ = null;
    this.zzabV = null;
    this.zzZL = 0.0D;
    this.zzZM = false;
  }
  
  private void zznV()
  {
    zzYy.zzb("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.zzabS)
    {
      this.zzabS.clear();
      return;
    }
  }
  
  private void zznW()
    throws IllegalStateException
  {
    if ((!this.zzabY) || (this.zzabU == null) || (this.zzabU.isDisposed())) {
      throw new IllegalStateException("Not connected to a device");
    }
  }
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: getstatic 74	com/google/android/gms/cast/internal/zze:zzYy	Lcom/google/android/gms/cast/internal/zzl;
    //   3: ldc_w 283
    //   6: iconst_2
    //   7: anewarray 76	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 266	com/google/android/gms/cast/internal/zze:zzabU	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_0
    //   20: invokevirtual 286	com/google/android/gms/cast/internal/zze:isConnected	()Z
    //   23: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokevirtual 146	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 266	com/google/android/gms/cast/internal/zze:zzabU	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   34: astore_1
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 266	com/google/android/gms/cast/internal/zze:zzabU	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_1
    //   45: invokevirtual 290	com/google/android/gms/cast/internal/zze$zzb:zzoa	()Lcom/google/android/gms/cast/internal/zze;
    //   48: ifnonnull +17 -> 65
    //   51: getstatic 74	com/google/android/gms/cast/internal/zze:zzYy	Lcom/google/android/gms/cast/internal/zzl;
    //   54: ldc_w 292
    //   57: iconst_0
    //   58: anewarray 76	java/lang/Object
    //   61: invokevirtual 146	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: return
    //   65: aload_0
    //   66: invokespecial 294	com/google/android/gms/cast/internal/zze:zznV	()V
    //   69: aload_0
    //   70: invokevirtual 298	com/google/android/gms/cast/internal/zze:zzqs	()Landroid/os/IInterface;
    //   73: checkcast 300	com/google/android/gms/cast/internal/zzi
    //   76: invokeinterface 302 1 0
    //   81: aload_0
    //   82: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   85: return
    //   86: astore_1
    //   87: getstatic 74	com/google/android/gms/cast/internal/zze:zzYy	Lcom/google/android/gms/cast/internal/zzl;
    //   90: aload_1
    //   91: ldc_w 305
    //   94: iconst_1
    //   95: anewarray 76	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_1
    //   101: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   104: aastore
    //   105: invokevirtual 313	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -34 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	zze
    //   34	11	1	localzzb	zzb
    //   86	15	1	localIllegalStateException	IllegalStateException
    //   113	6	1	localObject	Object
    //   120	1	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   69	81	86	java/lang/IllegalStateException
    //   69	81	113	finally
    //   87	108	113	finally
    //   69	81	120	android/os/RemoteException
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    zznW();
    return this.zzabQ;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    zznW();
    return this.zzabV;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    zznW();
    return this.zzZM;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    zznV();
  }
  
  public void zzX(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((zzi)zzqs()).zza(paramBoolean, this.zzZL, this.zzZM);
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    zzYy.zzb("in onPostInitHandler; statusCode=%d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 0) || (paramInt1 == 1001))
    {
      this.zzabY = true;
      this.zzabW = true;
      this.zzabX = true;
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 1001)
      {
        this.zzace = new Bundle();
        this.zzace.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        i = 0;
      }
      super.zza(i, paramIBinder, paramBundle, paramInt2);
      return;
      this.zzabY = false;
    }
  }
  
  public void zza(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    zzf.zzcb(paramString);
    zzca(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.zzabS)
    {
      this.zzabS.put(paramString, paramMessageReceivedCallback);
      ((zzi)zzqs()).zzcf(paramString);
      return;
    }
  }
  
  public void zza(String paramString, LaunchOptions paramLaunchOptions, zzlx.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    ((zzi)zzqs()).zza(paramString, paramLaunchOptions);
  }
  
  public void zza(String paramString, zzlx.zzb<Status> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zzc(paramzzb);
    ((zzi)zzqs()).zzce(paramString);
  }
  
  public void zza(String paramString1, String paramString2, JoinOptions paramJoinOptions, zzlx.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    paramzzb = paramJoinOptions;
    if (paramJoinOptions == null) {
      paramzzb = new JoinOptions();
    }
    ((zzi)zzqs()).zza(paramString1, paramString2, paramzzb);
  }
  
  public void zza(String paramString1, String paramString2, zzlx.zzb<Status> paramzzb)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    zzf.zzcb(paramString1);
    zznW();
    long l = this.zzacb.incrementAndGet();
    try
    {
      this.zzacf.put(Long.valueOf(l), paramzzb);
      ((zzi)zzqs()).zzb(paramString1, paramString2, l);
      return;
    }
    catch (Throwable paramString1)
    {
      this.zzacf.remove(Long.valueOf(l));
      throw paramString1;
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, zzlx.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    ((zzi)zzqs()).zzf(paramString, paramBoolean);
  }
  
  protected zzi zzaE(IBinder paramIBinder)
  {
    return zzi.zza.zzaF(paramIBinder);
  }
  
  public void zzb(zzlx.zzb<Status> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zzc(paramzzb);
    ((zzi)zzqs()).zzoc();
  }
  
  public void zzca(String paramString)
    throws IllegalArgumentException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.zzabS)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.zzabS.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
  }
  
  public void zzf(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((zzi)zzqs()).zza(paramDouble, this.zzZL, this.zzZM);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  protected Bundle zzlU()
  {
    Bundle localBundle = new Bundle();
    zzYy.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] { this.zzacc, this.zzacd });
    this.zzabR.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzabT);
    this.zzabU = new zzb(this);
    localBundle.putParcelable("listener", new BinderWrapper(this.zzabU.asBinder()));
    if (this.zzacc != null)
    {
      localBundle.putString("last_application_id", this.zzacc);
      if (this.zzacd != null) {
        localBundle.putString("last_session_id", this.zzacd);
      }
    }
    return localBundle;
  }
  
  public Bundle zznQ()
  {
    if (this.zzace != null)
    {
      Bundle localBundle = this.zzace;
      this.zzace = null;
      return localBundle;
    }
    return super.zznQ();
  }
  
  public void zznR()
    throws IllegalStateException, RemoteException
  {
    ((zzi)zzqs()).zznR();
  }
  
  public double zznS()
    throws IllegalStateException
  {
    zznW();
    return this.zzZL;
  }
  
  public int zznT()
    throws IllegalStateException
  {
    zznW();
    return this.zzabZ;
  }
  
  public int zznU()
    throws IllegalStateException
  {
    zznW();
    return this.zzaca;
  }
  
  private static final class zza
    implements Cast.ApplicationConnectionResult
  {
    private final String zzJX;
    private final Status zzTA;
    private final ApplicationMetadata zzack;
    private final String zzacl;
    private final boolean zzacm;
    
    public zza(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public zza(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.zzTA = paramStatus;
      this.zzack = paramApplicationMetadata;
      this.zzacl = paramString1;
      this.zzJX = paramString2;
      this.zzacm = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.zzack;
    }
    
    public String getApplicationStatus()
    {
      return this.zzacl;
    }
    
    public String getSessionId()
    {
      return this.zzJX;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public boolean getWasLaunched()
    {
      return this.zzacm;
    }
  }
  
  private static class zzb
    extends zzj.zza
  {
    private final Handler mHandler;
    private final AtomicReference<zze> zzacn;
    
    public zzb(zze paramzze)
    {
      this.zzacn = new AtomicReference(paramzze);
      this.mHandler = new Handler(paramzze.getLooper());
    }
    
    private void zza(zze paramzze, long paramLong, int paramInt)
    {
      synchronized (zze.zzg(paramzze))
      {
        paramzze = (zzlx.zzb)zze.zzg(paramzze).remove(Long.valueOf(paramLong));
        if (paramzze != null) {
          paramzze.zzr(new Status(paramInt));
        }
        return;
      }
    }
    
    private boolean zza(zze paramzze, int paramInt)
    {
      synchronized ()
      {
        if (zze.zzh(paramzze) != null)
        {
          zze.zzh(paramzze).zzr(new Status(paramInt));
          zze.zzb(paramzze, null);
          return true;
        }
        return false;
      }
    }
    
    public boolean isDisposed()
    {
      return this.zzacn.get() == null;
    }
    
    public void onApplicationDisconnected(final int paramInt)
    {
      final zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {}
      do
      {
        return;
        zze.zza(localzze, null);
        zze.zzb(localzze, null);
        zza(localzze, paramInt);
      } while (zze.zzd(localzze) == null);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (zze.zzd(localzze) != null) {
            zze.zzd(localzze).onApplicationDisconnected(paramInt);
          }
        }
      });
    }
    
    public void zza(ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zze.zza(localzze, paramApplicationMetadata);
      zze.zza(localzze, paramApplicationMetadata.getApplicationId());
      zze.zzb(localzze, paramString2);
      synchronized (zze.zznY())
      {
        if (zze.zzc(localzze) != null)
        {
          zze.zzc(localzze).zzr(new zze.zza(new Status(0), paramApplicationMetadata, paramString1, paramString2, paramBoolean));
          zze.zza(localzze, null);
        }
        return;
      }
    }
    
    public void zza(String paramString, double paramDouble, boolean paramBoolean)
    {
      zze.zznX().zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }
    
    public void zza(String paramString, long paramLong, int paramInt)
    {
      paramString = (zze)this.zzacn.get();
      if (paramString == null) {
        return;
      }
      zza(paramString, paramLong, paramInt);
    }
    
    public void zzb(final ApplicationStatus paramApplicationStatus)
    {
      final zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zze.zznX().zzb("onApplicationStatusChanged", new Object[0]);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          zze.zza(localzze, paramApplicationStatus);
        }
      });
    }
    
    public void zzb(final DeviceStatus paramDeviceStatus)
    {
      final zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zze.zznX().zzb("onDeviceStatusChanged", new Object[0]);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          zze.zza(localzze, paramDeviceStatus);
        }
      });
    }
    
    public void zzb(String paramString, byte[] paramArrayOfByte)
    {
      if ((zze)this.zzacn.get() == null) {
        return;
      }
      zze.zznX().zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.length) });
    }
    
    public void zzbk(int paramInt)
    {
      zze localzze = zzoa();
      if (localzze == null) {}
      do
      {
        return;
        zze.zznX().zzb("ICastDeviceControllerListener.onDisconnected: %d", new Object[] { Integer.valueOf(paramInt) });
      } while (paramInt == 0);
      localzze.zzbT(2);
    }
    
    public void zzbl(int paramInt)
    {
      zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      synchronized (zze.zznY())
      {
        if (zze.zzc(localzze) != null)
        {
          zze.zzc(localzze).zzr(new zze.zza(new Status(paramInt)));
          zze.zza(localzze, null);
        }
        return;
      }
    }
    
    public void zzbm(int paramInt)
    {
      zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zza(localzze, paramInt);
    }
    
    public void zzbn(int paramInt)
    {
      zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zza(localzze, paramInt);
    }
    
    public void zzc(String paramString, long paramLong)
    {
      paramString = (zze)this.zzacn.get();
      if (paramString == null) {
        return;
      }
      zza(paramString, paramLong, 0);
    }
    
    public zze zzoa()
    {
      zze localzze = (zze)this.zzacn.getAndSet(null);
      if (localzze == null) {
        return null;
      }
      zze.zzb(localzze);
      return localzze;
    }
    
    public void zzu(final String paramString1, final String paramString2)
    {
      final zze localzze = (zze)this.zzacn.get();
      if (localzze == null) {
        return;
      }
      zze.zznX().zzb("Receive (type=text, ns=%s) %s", new Object[] { paramString1, paramString2 });
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          synchronized (zze.zze(localzze))
          {
            Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)zze.zze(localzze).get(paramString1);
            if (localMessageReceivedCallback != null)
            {
              localMessageReceivedCallback.onMessageReceived(zze.zzf(localzze), paramString1, paramString2);
              return;
            }
          }
          zze.zznX().zzb("Discarded message for unknown namespace '%s'", new Object[] { paramString1 });
        }
      });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */