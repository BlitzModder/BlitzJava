package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zze;

public final class IndoorLevel
{
  private final zze zzaQv;
  
  public IndoorLevel(zze paramzze)
  {
    this.zzaQv = ((zze)zzx.zzy(paramzze));
  }
  
  public void activate()
  {
    try
    {
      this.zzaQv.activate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorLevel)) {
      return false;
    }
    try
    {
      boolean bool = this.zzaQv.zza(((IndoorLevel)paramObject).zzaQv);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public String getName()
  {
    try
    {
      String str = this.zzaQv.getName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getShortName()
  {
    try
    {
      String str = this.zzaQv.getShortName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.zzaQv.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/IndoorLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */