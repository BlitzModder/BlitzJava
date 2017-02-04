package com.bda.controller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IControllerMonitor
  extends IInterface
{
  public abstract void onLog(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IControllerMonitor
  {
    private static final String DESCRIPTOR = "com.bda.controller.IControllerMonitor";
    static final int TRANSACTION_onLog = 1;
    
    public Stub()
    {
      attachInterface(this, "com.bda.controller.IControllerMonitor");
    }
    
    public static IControllerMonitor asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.bda.controller.IControllerMonitor");
      if ((localIInterface != null) && ((localIInterface instanceof IControllerMonitor))) {
        return (IControllerMonitor)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.bda.controller.IControllerMonitor");
        return true;
      }
      paramParcel1.enforceInterface("com.bda.controller.IControllerMonitor");
      onLog(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IControllerMonitor
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.bda.controller.IControllerMonitor";
      }
      
      public void onLog(int paramInt1, int paramInt2, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerMonitor");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/IControllerMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */