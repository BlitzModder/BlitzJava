package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory
{
  private static ICameraUpdateFactoryDelegate zzaOx;
  
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new CameraUpdate(zzyT().newCameraPosition(paramCameraPosition));
      return paramCameraPosition;
    }
    catch (RemoteException paramCameraPosition)
    {
      throw new RuntimeRemoteException(paramCameraPosition);
    }
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    try
    {
      paramLatLng = new CameraUpdate(zzyT().newLatLng(paramLatLng));
      return paramLatLng;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    try
    {
      paramLatLngBounds = new CameraUpdate(zzyT().newLatLngBounds(paramLatLngBounds, paramInt));
      return paramLatLngBounds;
    }
    catch (RemoteException paramLatLngBounds)
    {
      throw new RuntimeRemoteException(paramLatLngBounds);
    }
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramLatLngBounds = new CameraUpdate(zzyT().newLatLngBoundsWithSize(paramLatLngBounds, paramInt1, paramInt2, paramInt3));
      return paramLatLngBounds;
    }
    catch (RemoteException paramLatLngBounds)
    {
      throw new RuntimeRemoteException(paramLatLngBounds);
    }
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    try
    {
      paramLatLng = new CameraUpdate(zzyT().newLatLngZoom(paramLatLng, paramFloat));
      return paramLatLng;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(zzyT().scrollBy(paramFloat1, paramFloat2));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(zzyT().zoomBy(paramFloat));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    try
    {
      paramPoint = new CameraUpdate(zzyT().zoomByWithFocus(paramFloat, paramPoint.x, paramPoint.y));
      return paramPoint;
    }
    catch (RemoteException paramPoint)
    {
      throw new RuntimeRemoteException(paramPoint);
    }
  }
  
  public static CameraUpdate zoomIn()
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(zzyT().zoomIn());
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomOut()
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(zzyT().zoomOut());
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    try
    {
      CameraUpdate localCameraUpdate = new CameraUpdate(zzyT().zoomTo(paramFloat));
      return localCameraUpdate;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static void zza(ICameraUpdateFactoryDelegate paramICameraUpdateFactoryDelegate)
  {
    zzaOx = (ICameraUpdateFactoryDelegate)zzx.zzy(paramICameraUpdateFactoryDelegate);
  }
  
  private static ICameraUpdateFactoryDelegate zzyT()
  {
    return (ICameraUpdateFactoryDelegate)zzx.zzb(zzaOx, "CameraUpdateFactory is not initialized");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/CameraUpdateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */