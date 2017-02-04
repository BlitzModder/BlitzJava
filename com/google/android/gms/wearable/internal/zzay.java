package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzay
  extends IInterface
{
  public abstract void zza(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong)
    throws RemoteException;
  
  public abstract void zzli(int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzay
  {
    public static zzay zzeo(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
      if ((localIInterface != null) && ((localIInterface instanceof zzay))) {
        return (zzay)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
        zzli(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
      if (paramParcel1.readInt() != 0) {}
      for (ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);; localParcelFileDescriptor = null)
      {
        zza(localParcelFileDescriptor, paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class zza
      implements zzay
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
      
      /* Error */
      public void zza(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +54 -> 72
        //   21: aload 4
        //   23: iconst_1
        //   24: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   27: aload_1
        //   28: aload 4
        //   30: iconst_0
        //   31: invokevirtual 46	android/os/ParcelFileDescriptor:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload 4
        //   36: lload_2
        //   37: invokevirtual 50	android/os/Parcel:writeLong	(J)V
        //   40: aload_0
        //   41: getfield 18	com/google/android/gms/wearable/internal/zzay$zza$zza:zzoo	Landroid/os/IBinder;
        //   44: iconst_3
        //   45: aload 4
        //   47: aload 5
        //   49: iconst_0
        //   50: invokeinterface 56 5 0
        //   55: pop
        //   56: aload 5
        //   58: invokevirtual 59	android/os/Parcel:readException	()V
        //   61: aload 5
        //   63: invokevirtual 62	android/os/Parcel:recycle	()V
        //   66: aload 4
        //   68: invokevirtual 62	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aload 4
        //   74: iconst_0
        //   75: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   78: goto -44 -> 34
        //   81: astore_1
        //   82: aload 5
        //   84: invokevirtual 62	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: invokevirtual 62	android/os/Parcel:recycle	()V
        //   92: aload_1
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	this	zza
        //   0	94	1	paramParcelFileDescriptor	ParcelFileDescriptor
        //   0	94	2	paramLong	long
        //   3	85	4	localParcel1	Parcel
        //   8	75	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	81	finally
        //   21	34	81	finally
        //   34	61	81	finally
        //   72	78	81	finally
      }
      
      public void zzli(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.ILargeAssetSyncRequestResponder");
          localParcel1.writeInt(paramInt);
          this.zzoo.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */