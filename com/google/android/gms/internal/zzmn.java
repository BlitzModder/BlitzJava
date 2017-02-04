package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzmn<L>
{
  private volatile L mListener;
  private final zzmn<L>.zza zzagR;
  
  zzmn(Looper paramLooper, L paramL)
  {
    this.zzagR = new zza(paramLooper);
    this.mListener = zzx.zzb(paramL, "Listener must not be null");
  }
  
  public void clear()
  {
    this.mListener = null;
  }
  
  public void zza(zzb<? super L> paramzzb)
  {
    zzx.zzb(paramzzb, "Notifier must not be null");
    paramzzb = this.zzagR.obtainMessage(1, paramzzb);
    this.zzagR.sendMessage(paramzzb);
  }
  
  void zzb(zzb<? super L> paramzzb)
  {
    Object localObject = this.mListener;
    if (localObject == null)
    {
      paramzzb.zzpb();
      return;
    }
    try
    {
      paramzzb.zzs(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzb.zzpb();
      throw localRuntimeException;
    }
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (paramMessage.what == 1) {}
      for (;;)
      {
        zzx.zzab(bool);
        zzmn.this.zzb((zzmn.zzb)paramMessage.obj);
        return;
        bool = false;
      }
    }
  }
  
  public static abstract interface zzb<L>
  {
    public abstract void zzpb();
    
    public abstract void zzs(L paramL);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */