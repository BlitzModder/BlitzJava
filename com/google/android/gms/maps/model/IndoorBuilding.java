package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zze.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding
{
  private final zzd zzaQu;
  
  public IndoorBuilding(zzd paramzzd)
  {
    this.zzaQu = ((zzd)zzx.zzy(paramzzd));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IndoorBuilding)) {
      return false;
    }
    try
    {
      boolean bool = this.zzaQu.zzb(((IndoorBuilding)paramObject).zzaQu);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public int getActiveLevelIndex()
  {
    try
    {
      int i = this.zzaQu.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int getDefaultLevelIndex()
  {
    try
    {
      int i = this.zzaQu.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public List<IndoorLevel> getLevels()
  {
    try
    {
      Object localObject = this.zzaQu.getLevels();
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new IndoorLevel(zze.zza.zzdc((IBinder)((Iterator)localObject).next())));
      }
      return localRemoteException;
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
      int i = this.zzaQu.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isUnderground()
  {
    try
    {
      boolean bool = this.zzaQu.isUnderground();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/IndoorBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */