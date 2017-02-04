package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzqu
  extends IInterface
{
  public abstract void onError(int paramInt)
    throws RemoteException;
  
  public abstract void zzr(byte[] paramArrayOfByte)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzqu
  {
    public static zzqu zzdm(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzqu))) {
        return (zzqu)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
        zzr(paramParcel1.createByteArray());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
      onError(paramParcel1.readInt());
      return true;
    }
    
    private static class zza
      implements zzqu
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
      
      public void onError(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
          localParcel.writeInt(paramInt);
          this.zzoo.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void zzr(byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
          localParcel.writeByteArray(paramArrayOfByte);
          this.zzoo.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */