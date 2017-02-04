package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface zzmm
{
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract <A extends Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T zza(T paramT);
  
  public abstract boolean zza(zzmp paramzzmp);
  
  public abstract <A extends Api.zzb, T extends zzlx.zza<? extends Result, A>> T zzb(T paramT);
  
  public abstract void zzoF();
  
  public static abstract interface zza
  {
    public abstract void zzbz(int paramInt);
    
    public abstract void zze(ConnectionResult paramConnectionResult);
    
    public abstract void zzi(Bundle paramBundle);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */