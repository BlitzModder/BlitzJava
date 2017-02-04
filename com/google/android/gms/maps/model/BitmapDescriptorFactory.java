package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zza;

public final class BitmapDescriptorFactory
{
  public static final float HUE_AZURE = 210.0F;
  public static final float HUE_BLUE = 240.0F;
  public static final float HUE_CYAN = 180.0F;
  public static final float HUE_GREEN = 120.0F;
  public static final float HUE_MAGENTA = 300.0F;
  public static final float HUE_ORANGE = 30.0F;
  public static final float HUE_RED = 0.0F;
  public static final float HUE_ROSE = 330.0F;
  public static final float HUE_VIOLET = 270.0F;
  public static final float HUE_YELLOW = 60.0F;
  private static zza zzaPY;
  
  public static BitmapDescriptor defaultMarker()
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(zzzt().zzzy());
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(zzzt().zzh(paramFloat));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    try
    {
      paramString = new BitmapDescriptor(zzzt().zzeb(paramString));
      return paramString;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = new BitmapDescriptor(zzzt().zzb(paramBitmap));
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      throw new RuntimeRemoteException(paramBitmap);
    }
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    try
    {
      paramString = new BitmapDescriptor(zzzt().zzec(paramString));
      return paramString;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    try
    {
      paramString = new BitmapDescriptor(zzzt().zzed(paramString));
      return paramString;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    try
    {
      BitmapDescriptor localBitmapDescriptor = new BitmapDescriptor(zzzt().zzin(paramInt));
      return localBitmapDescriptor;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public static void zza(zza paramzza)
  {
    if (zzaPY != null) {
      return;
    }
    zzaPY = (zza)zzx.zzy(paramzza);
  }
  
  private static zza zzzt()
  {
    return (zza)zzx.zzb(zzaPY, "IBitmapDescriptorFactory is not initialized");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/BitmapDescriptorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */