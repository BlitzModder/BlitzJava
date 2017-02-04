package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzv
  extends IInterface
{
  public abstract long getValue()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzv
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }
    
    public static zzv zzn(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
      if ((localIInterface != null) && ((localIInterface instanceof zzv))) {
        return (zzv)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
      long l = getValue();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    
    private static class zza
      implements zzv
    {
      private IBinder zzoo;
      
      zza(IBinder paramIBinder)
      {
        this.zzoo = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzoo;
      }
      
      public long getValue()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
          this.zzoo.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */