package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface>
  implements Api.zzb, zzk.zza
{
  public static final String[] zzajS = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final Account zzSo;
  private final Set<Scope> zzVH;
  private final Looper zzaeK;
  private final GoogleApiAvailability zzaeL;
  private final zzf zzafT;
  private final zzl zzajH;
  private zzs zzajI;
  private GoogleApiClient.zza zzajJ;
  private T zzajK;
  private final ArrayList<zzj<T>.zzc<?>> zzajL = new ArrayList();
  private zzj<T>.zze zzajM;
  private int zzajN = 1;
  private final GoogleApiClient.ConnectionCallbacks zzajO;
  private final GoogleApiClient.OnConnectionFailedListener zzajP;
  private final int zzajQ;
  protected AtomicInteger zzajR = new AtomicInteger(0);
  private final Object zzpK = new Object();
  
  protected zzj(Context paramContext, Looper paramLooper, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzl.zzat(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzf, (GoogleApiClient.ConnectionCallbacks)zzx.zzy(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzx.zzy(paramOnConnectionFailedListener));
  }
  
  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.mContext = ((Context)zzx.zzb(paramContext, "Context must not be null"));
    this.zzaeK = ((Looper)zzx.zzb(paramLooper, "Looper must not be null"));
    this.zzajH = ((zzl)zzx.zzb(paramzzl, "Supervisor must not be null"));
    this.zzaeL = ((GoogleApiAvailability)zzx.zzb(paramGoogleApiAvailability, "API availability must not be null"));
    this.mHandler = new zzb(paramLooper);
    this.zzajQ = paramInt;
    this.zzafT = ((zzf)zzx.zzy(paramzzf));
    this.zzSo = paramzzf.getAccount();
    this.zzVH = zza(paramzzf.zzqb());
    this.zzajO = paramConnectionCallbacks;
    this.zzajP = paramOnConnectionFailedListener;
  }
  
  private Set<Scope> zza(Set<Scope> paramSet)
  {
    Set localSet = zzb(paramSet);
    if (localSet == null) {
      return localSet;
    }
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.zzpK)
    {
      if (this.zzajN != paramInt1) {
        return false;
      }
      zzb(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label119;
      }
      j = 1;
      label17:
      if (i != j) {
        break label125;
      }
    }
    for (;;)
    {
      zzx.zzab(bool);
      for (;;)
      {
        synchronized (this.zzpK)
        {
          this.zzajN = paramInt;
          this.zzajK = paramT;
          zzc(paramInt, paramT);
          switch (paramInt)
          {
          case 2: 
            return;
            zzqn();
          }
        }
        zzqm();
        continue;
        zzqo();
      }
      i = 0;
      break;
      label119:
      j = 0;
      break label17;
      label125:
      bool = false;
    }
  }
  
  private void zzqn()
  {
    if (this.zzajM != null)
    {
      Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgh());
      this.zzajH.zzb(zzgh(), this.zzajM, zzql());
      this.zzajR.incrementAndGet();
    }
    this.zzajM = new zze(this.zzajR.get());
    if (!this.zzajH.zza(zzgh(), this.zzajM, zzql()))
    {
      Log.e("GmsClient", "unable to connect to service: " + zzgh());
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzajR.get(), 9));
    }
  }
  
  private void zzqo()
  {
    if (this.zzajM != null)
    {
      this.zzajH.zzb(zzgh(), this.zzajM, zzql());
      this.zzajM = null;
    }
  }
  
  public void disconnect()
  {
    this.zzajR.incrementAndGet();
    synchronized (this.zzajL)
    {
      int j = this.zzajL.size();
      int i = 0;
      while (i < j)
      {
        ((zzc)this.zzajL.get(i)).zzqy();
        i += 1;
      }
      this.zzajL.clear();
      zzb(1, null);
      return;
    }
  }
  
  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        int i = this.zzajN;
        paramArrayOfString = this.zzajK;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null) {
            break label137;
          }
          paramPrintWriter.println("null");
          return;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
    }
    label137:
    paramPrintWriter.append(zzgi()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zzaeK;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzajN == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzajN == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  protected void onConnectionSuspended(int paramInt) {}
  
  protected abstract T zzW(IBinder paramIBinder);
  
  protected void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new zzi(paramInt1, paramBundle)));
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzg(paramInt1, paramIBinder, paramBundle)));
  }
  
  public void zza(GoogleApiClient.zza paramzza)
  {
    this.zzajJ = ((GoogleApiClient.zza)zzx.zzb(paramzza, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }
  
  public void zza(zzp paramzzp)
  {
    Bundle localBundle = zzqt();
    paramzzp = new ValidateAccountRequest(paramzzp, (Scope[])this.zzVH.toArray(new Scope[this.zzVH.size()]), this.mContext.getPackageName(), localBundle);
    try
    {
      this.zzajI.zza(new zzd(this, this.zzajR.get()), paramzzp);
      return;
    }
    catch (DeadObjectException paramzzp)
    {
      Log.w("GmsClient", "service died");
      zzbT(1);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("GmsClient", "Remote exception occurred", paramzzp);
    }
  }
  
  public void zza(zzp paramzzp, Set<Scope> paramSet)
  {
    try
    {
      Object localObject = zzlU();
      localObject = new GetServiceRequest(this.zzajQ).zzcA(this.mContext.getPackageName()).zzj((Bundle)localObject);
      if (paramSet != null) {
        ((GetServiceRequest)localObject).zzd(paramSet);
      }
      if (zzmn()) {
        ((GetServiceRequest)localObject).zzc(zzpY()).zzc(paramzzp);
      }
      for (;;)
      {
        this.zzajI.zza(new zzd(this, this.zzajR.get()), (GetServiceRequest)localObject);
        return;
        if (zzqu()) {
          ((GetServiceRequest)localObject).zzc(this.zzSo);
        }
      }
      return;
    }
    catch (DeadObjectException paramzzp)
    {
      Log.w("GmsClient", "service died");
      zzbT(1);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("GmsClient", "Remote exception occurred", paramzzp);
    }
  }
  
  protected Set<Scope> zzb(Set<Scope> paramSet)
  {
    return paramSet;
  }
  
  public void zzbT(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzajR.get(), paramInt));
  }
  
  protected void zzbU(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6, paramInt, -1, new zzh()));
  }
  
  protected void zzc(int paramInt, T paramT) {}
  
  protected abstract String zzgh();
  
  protected abstract String zzgi();
  
  protected Bundle zzlU()
  {
    return new Bundle();
  }
  
  public boolean zzmJ()
  {
    return false;
  }
  
  public Intent zzmK()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public boolean zzmn()
  {
    return false;
  }
  
  public Bundle zznQ()
  {
    return null;
  }
  
  public IBinder zzoC()
  {
    if (this.zzajI == null) {
      return null;
    }
    return this.zzajI.asBinder();
  }
  
  public final Account zzpY()
  {
    if (this.zzSo != null) {
      return this.zzSo;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  protected final String zzql()
  {
    return this.zzafT.zzqe();
  }
  
  protected void zzqm() {}
  
  public void zzqp()
  {
    int i = this.zzaeL.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      zzb(1, null);
      this.zzajJ = new zzf();
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzajR.get(), i));
      return;
    }
    zza(new zzf());
  }
  
  protected final zzf zzqq()
  {
    return this.zzafT;
  }
  
  protected final void zzqr()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzqs()
    throws DeadObjectException
  {
    synchronized (this.zzpK)
    {
      if (this.zzajN == 4) {
        throw new DeadObjectException();
      }
    }
    zzqr();
    if (this.zzajK != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = this.zzajK;
      return localIInterface;
    }
  }
  
  protected Bundle zzqt()
  {
    return null;
  }
  
  public boolean zzqu()
  {
    return false;
  }
  
  private abstract class zza
    extends zzj<T>.zzc<Boolean>
  {
    public final int statusCode;
    public final Bundle zzajT;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.zzajT = paramBundle;
    }
    
    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        zzj.zza(zzj.this, 1, null);
      }
      do
      {
        return;
        switch (this.statusCode)
        {
        default: 
          zzj.zza(zzj.this, 1, null);
          paramBoolean = (Boolean)localObject;
          if (this.zzajT != null) {
            paramBoolean = (PendingIntent)this.zzajT.getParcelable("pendingIntent");
          }
          zzk(new ConnectionResult(this.statusCode, paramBoolean));
          return;
        }
      } while (zzqv());
      zzj.zza(zzj.this, 1, null);
      zzk(new ConnectionResult(8, null));
      return;
      zzj.zza(zzj.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void zzk(ConnectionResult paramConnectionResult);
    
    protected abstract boolean zzqv();
    
    protected void zzqw() {}
  }
  
  final class zzb
    extends Handler
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private void zza(Message paramMessage)
    {
      paramMessage = (zzj.zzc)paramMessage.obj;
      paramMessage.zzqw();
      paramMessage.unregister();
    }
    
    private boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (zzj.this.zzajR.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6)) && (!zzj.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        paramMessage = new ConnectionResult(paramMessage.arg2, null);
        zzj.zza(zzj.this).zza(paramMessage);
        zzj.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 4)
      {
        zzj.zza(zzj.this, 4, null);
        if (zzj.zzb(zzj.this) != null) {
          zzj.zzb(zzj.this).onConnectionSuspended(paramMessage.arg2);
        }
        zzj.this.onConnectionSuspended(paramMessage.arg2);
        zzj.zza(zzj.this, 4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!zzj.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzj.zzc)paramMessage.obj).zzqx();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle message: " + paramMessage.what, new Exception());
    }
  }
  
  protected abstract class zzc<TListener>
  {
    private TListener mListener;
    private boolean zzajV;
    
    public zzc()
    {
      Object localObject;
      this.mListener = localObject;
      this.zzajV = false;
    }
    
    public void unregister()
    {
      zzqy();
      synchronized (zzj.zzc(zzj.this))
      {
        zzj.zzc(zzj.this).remove(this);
        return;
      }
    }
    
    protected abstract void zzqw();
    
    /* Error */
    public void zzqx()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/zzj$zzc:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/zzj$zzc:zzajV	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 48
      //   16: new 50	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   23: ldc 53
      //   25: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 62
      //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 76	com/google/android/gms/common/internal/zzj$zzc:zzv	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/common/internal/zzj$zzc:zzajV	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 78	com/google/android/gms/common/internal/zzj$zzc:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzqw	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzqw	()V
      //   85: goto -30 -> 55
      //   88: astore_1
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_1
      //   92: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	zzc
      //   6	46	1	localObject1	Object
      //   69	4	1	localObject2	Object
      //   74	6	1	localRuntimeException	RuntimeException
      //   88	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	88	finally
      //   89	91	88	finally
    }
    
    public void zzqy()
    {
      try
      {
        this.mListener = null;
        return;
      }
      finally {}
    }
    
    protected abstract void zzv(TListener paramTListener);
  }
  
  public static final class zzd
    extends zzr.zza
  {
    private zzj zzajW;
    private final int zzajX;
    
    public zzd(zzj paramzzj, int paramInt)
    {
      this.zzajW = paramzzj;
      this.zzajX = paramInt;
    }
    
    private void zzqz()
    {
      this.zzajW = null;
    }
    
    public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      zzx.zzb(this.zzajW, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzajW.zza(paramInt, paramIBinder, paramBundle, this.zzajX);
      zzqz();
    }
    
    public void zzb(int paramInt, Bundle paramBundle)
    {
      zzx.zzb(this.zzajW, "onAccountValidationComplete can be called only once per call to validateAccount");
      this.zzajW.zza(paramInt, paramBundle, this.zzajX);
      zzqz();
    }
  }
  
  public final class zze
    implements ServiceConnection
  {
    private final int zzajX;
    
    public zze(int paramInt)
    {
      this.zzajX = paramInt;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      zzx.zzb(paramIBinder, "Expecting a valid IBinder");
      zzj.zza(zzj.this, zzs.zza.zzaS(paramIBinder));
      zzj.this.zzbU(this.zzajX);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.zzajX, 1));
    }
  }
  
  protected class zzf
    implements GoogleApiClient.zza
  {
    public zzf() {}
    
    public void zza(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zzj.this.zza(null, zzj.zzd(zzj.this));
      }
      while (zzj.zze(zzj.this) == null) {
        return;
      }
      zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
    }
    
    public void zzb(ConnectionResult paramConnectionResult)
    {
      throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
  }
  
  protected final class zzg
    extends zzj<T>.zza
  {
    public final IBinder zzajY;
    
    public zzg(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.zzajY = paramIBinder;
    }
    
    protected void zzk(ConnectionResult paramConnectionResult)
    {
      if (zzj.zze(zzj.this) != null) {
        zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
      }
      zzj.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzqv()
    {
      do
      {
        try
        {
          String str = this.zzajY.getInterfaceDescriptor();
          if (!zzj.this.zzgi().equals(str))
          {
            Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzgi() + " vs. " + str);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zzj.this.zzW(this.zzajY);
      } while ((localObject == null) || (!zzj.zza(zzj.this, 2, 3, (IInterface)localObject)));
      Object localObject = zzj.this.zznQ();
      if (zzj.zzb(zzj.this) != null) {
        zzj.zzb(zzj.this).onConnected((Bundle)localObject);
      }
      return true;
    }
  }
  
  protected final class zzh
    extends zzj<T>.zza
  {
    public zzh()
    {
      super(0, null);
    }
    
    protected void zzk(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).zza(paramConnectionResult);
      zzj.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzqv()
    {
      zzj.zza(zzj.this).zza(ConnectionResult.zzadR);
      return true;
    }
  }
  
  protected final class zzi
    extends zzj<T>.zza
  {
    public zzi(int paramInt, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected void zzk(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).zzb(paramConnectionResult);
      zzj.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzqv()
    {
      zzj.zza(zzj.this).zzb(ConnectionResult.zzadR);
      return true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */