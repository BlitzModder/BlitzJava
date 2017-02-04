package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;

public class zzbt
  extends zzd
{
  private final zzlx.zzb<Status> zzakL;
  
  public zzbt(zzlx.zzb<Status> paramzzb)
  {
    this.zzakL = paramzzb;
  }
  
  public void onSuccess()
    throws RemoteException
  {
    this.zzakL.zzr(Status.zzaeX);
  }
  
  public void zzA(Status paramStatus)
    throws RemoteException
  {
    this.zzakL.zzr(paramStatus);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */