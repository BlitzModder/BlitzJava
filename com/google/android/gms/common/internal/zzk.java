package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza zzajZ;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaka = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzakb = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzakc = new ArrayList();
  private volatile boolean zzakd = false;
  private final AtomicInteger zzake = new AtomicInteger(0);
  private boolean zzakf = false;
  private final Object zzpK = new Object();
  
  public zzk(Looper paramLooper, zza paramzza)
  {
    this.zzajZ = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.zzpK)
      {
        if ((this.zzakd) && (this.zzajZ.isConnected()) && (this.zzaka.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zzajZ.zznQ());
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle message: " + ???.what, new Exception());
    return false;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      boolean bool = this.zzaka.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      boolean bool = this.zzakc.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      if (this.zzaka.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.zzajZ.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.zzaka.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      if (this.zzakc.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.zzakc.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      if (!this.zzaka.remove(paramConnectionCallbacks)) {
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      while (!this.zzakf) {
        return;
      }
      this.zzakb.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      if (!this.zzakc.remove(paramOnConnectionFailedListener)) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzbV(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    zzx.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzpK)
    {
      this.zzakf = true;
      Object localObject2 = new ArrayList(this.zzaka);
      int i = this.zzake.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzakd) && (this.zzake.get() == i)) {}
        }
        else
        {
          this.zzakb.clear();
          this.zzakf = false;
          return;
        }
      } while (!this.zzaka.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzk(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      zzx.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzakf) {
          break label206;
        }
        bool1 = true;
        zzx.zzaa(bool1);
        this.mHandler.removeMessages(1);
        this.zzakf = true;
        if (this.zzakb.size() != 0) {
          break label211;
        }
        bool1 = bool2;
        zzx.zzaa(bool1);
        Object localObject2 = new ArrayList(this.zzaka);
        int i = this.zzake.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzakd) && (this.zzajZ.isConnected()) && (this.zzake.get() == i)) {}
        }
        else
        {
          this.zzakb.clear();
          this.zzakf = false;
          return;
        }
        if (this.zzakb.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206:
      bool1 = false;
      continue;
      label211:
      bool1 = false;
    }
  }
  
  public void zzl(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzpK)
      {
        Object localObject2 = new ArrayList(this.zzakc);
        int i = this.zzake.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!this.zzakd) || (this.zzake.get() != i)) {
            return;
          }
          if (this.zzakc.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzqA()
  {
    this.zzakd = false;
    this.zzake.incrementAndGet();
  }
  
  public void zzqB()
  {
    this.zzakd = true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zznQ();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */