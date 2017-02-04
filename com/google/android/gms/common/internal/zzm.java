package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm
  extends zzl
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> zzaki = new HashMap();
  private final zzb zzakj;
  private final long zzakk;
  private final Context zzrI;
  
  zzm(Context paramContext)
  {
    this.zzrI = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.zzakj = zzb.zzrz();
    this.zzakk = 5000L;
  }
  
  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localzzb;
      synchronized (this.zzaki)
      {
        localzzb = (zzb)this.zzaki.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new zzb(paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzcB(paramString);
          this.zzaki.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = paramzza.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, localzzb);
        if (localzzb.zza(paramServiceConnection)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2: 
        localzzb.zzcB(paramString);
        paramzza = localzzb;
        break;
      default: 
        paramzza = localzzb;
      }
    }
  }
  
  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (this.zzaki)
    {
      localzzb = (zzb)this.zzaki.get(paramzza);
      if (localzzb == null) {
        throw new IllegalStateException("Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzzb.zza(paramServiceConnection)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzqD())
    {
      paramzza = this.mHandler.obtainMessage(0, localzzb);
      this.mHandler.sendMessageDelayed(paramzza, this.zzakk);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    zzb localzzb = (zzb)???.obj;
    synchronized (this.zzaki)
    {
      if (localzzb.zzqD())
      {
        if (localzzb.isBound()) {
          localzzb.zzcC("GmsClientSupervisor");
        }
        this.zzaki.remove(zzb.zza(localzzb));
      }
      return true;
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return zza(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    zzb(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  private static final class zza
  {
    private final String zzRA;
    private final ComponentName zzakl;
    
    public zza(ComponentName paramComponentName)
    {
      this.zzRA = null;
      this.zzakl = ((ComponentName)zzx.zzy(paramComponentName));
    }
    
    public zza(String paramString)
    {
      this.zzRA = zzx.zzcG(paramString);
      this.zzakl = null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzw.equal(this.zzRA, ((zza)paramObject).zzRA)) && (zzw.equal(this.zzakl, ((zza)paramObject).zzakl)));
      return false;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.zzRA, this.zzakl });
    }
    
    public String toString()
    {
      if (this.zzRA == null) {
        return this.zzakl.flattenToString();
      }
      return this.zzRA;
    }
    
    public Intent zzqC()
    {
      if (this.zzRA != null) {
        return new Intent(this.zzRA).setPackage("com.google.android.gms");
      }
      return new Intent().setComponent(this.zzakl);
    }
  }
  
  private final class zzb
  {
    private int mState;
    private IBinder zzaiT;
    private ComponentName zzakl;
    private final zza zzakm;
    private final Set<ServiceConnection> zzakn;
    private boolean zzako;
    private final zzm.zza zzakp;
    
    public zzb(zzm.zza paramzza)
    {
      this.zzakp = paramzza;
      this.zzakm = new zza();
      this.zzakn = new HashSet();
      this.mState = 2;
    }
    
    public IBinder getBinder()
    {
      return this.zzaiT;
    }
    
    public ComponentName getComponentName()
    {
      return this.zzakl;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.zzako;
    }
    
    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramServiceConnection, paramString, this.zzakp.zzqC());
      this.zzakn.add(paramServiceConnection);
    }
    
    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return this.zzakn.contains(paramServiceConnection);
    }
    
    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zzb(zzm.zzb(zzm.this), paramServiceConnection);
      this.zzakn.remove(paramServiceConnection);
    }
    
    public void zzcB(String paramString)
    {
      this.mState = 3;
      this.zzako = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, this.zzakp.zzqC(), this.zzakm, 129);
      if (!this.zzako) {
        this.mState = 2;
      }
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.zzakm);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public void zzcC(String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.zzakm);
      this.zzako = false;
      this.mState = 2;
    }
    
    public boolean zzqD()
    {
      return this.zzakn.isEmpty();
    }
    
    public class zza
      implements ServiceConnection
    {
      public zza() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, paramIBinder);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, null);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 2);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */