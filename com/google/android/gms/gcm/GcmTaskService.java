package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public abstract class GcmTaskService
  extends Service
{
  public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
  public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  private final Set<String> zzaIU = new HashSet();
  private int zzaIV;
  
  private void zzdJ(String paramString)
  {
    synchronized (this.zzaIU)
    {
      this.zzaIU.remove(paramString);
      if (this.zzaIU.size() == 0) {
        stopSelf(this.zzaIV);
      }
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onInitializeTasks() {}
  
  public abstract int onRunTask(TaskParams paramTaskParams);
  
  public int onStartCommand(Intent arg1, int paramInt1, int paramInt2)
  {
    ???.setExtrasClassLoader(PendingCallback.class.getClassLoader());
    if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(???.getAction()))
    {
      str = ???.getStringExtra("tag");
      localParcelable = ???.getParcelableExtra("callback");
      localBundle = (Bundle)???.getParcelableExtra("extras");
      if ((localParcelable == null) || (!(localParcelable instanceof PendingCallback))) {
        Log.e("GcmTaskService", getPackageName() + " " + str + ": Could not process request, invalid callback.");
      }
    }
    while (!"com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(???.getAction()))
    {
      String str;
      Parcelable localParcelable;
      Bundle localBundle;
      return 2;
      synchronized (this.zzaIU)
      {
        this.zzaIU.add(str);
        stopSelf(this.zzaIV);
        this.zzaIV = paramInt2;
        new zza(str, ((PendingCallback)localParcelable).getIBinder(), localBundle).start();
        return 2;
      }
    }
    onInitializeTasks();
    synchronized (this.zzaIU)
    {
      this.zzaIV = paramInt2;
      if (this.zzaIU.size() == 0) {
        stopSelf(this.zzaIV);
      }
      return 2;
    }
  }
  
  private class zza
    extends Thread
  {
    private final Bundle mExtras;
    private final String mTag;
    private final zzc zzaIW;
    
    zza(String paramString, IBinder paramIBinder, Bundle paramBundle)
    {
      this.mTag = paramString;
      this.zzaIW = zzc.zza.zzbZ(paramIBinder);
      this.mExtras = paramBundle;
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      int i = GcmTaskService.this.onRunTask(new TaskParams(this.mTag, this.mExtras));
      try
      {
        this.zzaIW.zzgV(i);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + this.mTag);
        return;
      }
      finally
      {
        GcmTaskService.zza(GcmTaskService.this, this.mTag);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/GcmTaskService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */