package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public abstract interface zzqt
  extends IInterface
{
  public abstract void onDisconnected()
    throws RemoteException;
  
  public abstract void onError(int paramInt)
    throws RemoteException;
  
  public abstract void zzCl()
    throws RemoteException;
  
  public abstract void zza(Device paramDevice, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public abstract void zzeI(String paramString)
    throws RemoteException;
  
  public abstract void zzeJ(String paramString)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzqt
  {
    public static zzqt zzdl(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzqt))) {
        return (zzqt)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel2 = (Device)Device.CREATOR.createFromParcel(paramParcel1);; paramParcel2 = null)
        {
          zza(paramParcel2, paramParcel1.createByteArray());
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        onDisconnected();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        onError(paramParcel1.readInt());
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        zzeI(paramParcel1.readString());
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
        zzCl();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
      zzeJ(paramParcel1.readString());
      return true;
    }
    
    private static class zza
      implements zzqt
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
      
      public void onDisconnected()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          this.zzoo.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void onError(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          localParcel.writeInt(paramInt);
          this.zzoo.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void zzCl()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          this.zzoo.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void zza(Device paramDevice, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 32
        //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +38 -> 49
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 59	com/google/android/gms/nearby/bootstrap/Device:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 63	android/os/Parcel:writeByteArray	([B)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/zzqt$zza$zza:zzoo	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload_3
        //   36: aconst_null
        //   37: iconst_1
        //   38: invokeinterface 42 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 45	android/os/Parcel:recycle	()V
        //   48: return
        //   49: aload_3
        //   50: iconst_0
        //   51: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   54: goto -29 -> 25
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 45	android/os/Parcel:recycle	()V
        //   62: aload_1
        //   63: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	64	0	this	zza
        //   0	64	1	paramDevice	Device
        //   0	64	2	paramArrayOfByte	byte[]
        //   3	56	3	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	57	finally
        //   14	25	57	finally
        //   25	44	57	finally
        //   49	54	57	finally
      }
      
      public void zzeI(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          localParcel.writeString(paramString);
          this.zzoo.transact(4, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void zzeJ(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
          localParcel.writeString(paramString);
          this.zzoo.transact(6, localParcel, null, 1);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */