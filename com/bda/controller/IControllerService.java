package com.bda.controller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IControllerService
  extends IInterface
{
  public abstract void allowNewConnections()
    throws RemoteException;
  
  public abstract void disallowNewConnections()
    throws RemoteException;
  
  public abstract float getAxisValue(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int getInfo(int paramInt)
    throws RemoteException;
  
  public abstract int getKeyCode(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int getKeyCode2(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract int getState(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract boolean isAllowingNewConnections()
    throws RemoteException;
  
  public abstract void registerListener(IControllerListener paramIControllerListener, int paramInt)
    throws RemoteException;
  
  public abstract void registerListener2(IControllerListener paramIControllerListener, int paramInt)
    throws RemoteException;
  
  public abstract void registerMonitor(IControllerMonitor paramIControllerMonitor, int paramInt)
    throws RemoteException;
  
  public abstract void sendMessage(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void unregisterListener(IControllerListener paramIControllerListener, int paramInt)
    throws RemoteException;
  
  public abstract void unregisterMonitor(IControllerMonitor paramIControllerMonitor, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IControllerService
  {
    private static final String DESCRIPTOR = "com.bda.controller.IControllerService";
    static final int TRANSACTION_allowNewConnections = 12;
    static final int TRANSACTION_disallowNewConnections = 13;
    static final int TRANSACTION_getAxisValue = 7;
    static final int TRANSACTION_getInfo = 5;
    static final int TRANSACTION_getKeyCode = 6;
    static final int TRANSACTION_getKeyCode2 = 11;
    static final int TRANSACTION_getState = 8;
    static final int TRANSACTION_isAllowingNewConnections = 14;
    static final int TRANSACTION_registerListener = 1;
    static final int TRANSACTION_registerListener2 = 10;
    static final int TRANSACTION_registerMonitor = 3;
    static final int TRANSACTION_sendMessage = 9;
    static final int TRANSACTION_unregisterListener = 2;
    static final int TRANSACTION_unregisterMonitor = 4;
    
    public Stub()
    {
      attachInterface(this, "com.bda.controller.IControllerService");
    }
    
    public static IControllerService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.bda.controller.IControllerService");
      if ((localIInterface != null) && ((localIInterface instanceof IControllerService))) {
        return (IControllerService)localIInterface;
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
        paramParcel2.writeString("com.bda.controller.IControllerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        registerListener(IControllerListener.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        unregisterListener(IControllerListener.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        registerMonitor(IControllerMonitor.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        unregisterMonitor(IControllerMonitor.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        paramInt1 = getInfo(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        paramInt1 = getKeyCode(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        float f = getAxisValue(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        paramInt1 = getState(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        sendMessage(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        registerListener2(IControllerListener.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        paramInt1 = getKeyCode2(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        allowNewConnections();
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.bda.controller.IControllerService");
        disallowNewConnections();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.bda.controller.IControllerService");
      boolean bool = isAllowingNewConnections();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    
    private static class Proxy
      implements IControllerService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void allowNewConnections()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void disallowNewConnections()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getAxisValue(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getInfo(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.bda.controller.IControllerService";
      }
      
      public int getKeyCode(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getKeyCode2(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public int getState(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isAllowingNewConnections()
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void registerListener(IControllerListener paramIControllerListener, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 81 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 19	com/bda/controller/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: iconst_1
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 41 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 44	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 47	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramIControllerListener	IControllerListener
        //   0	83	2	paramInt	int
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
      
      /* Error */
      public void registerListener2(IControllerListener paramIControllerListener, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +51 -> 67
        //   19: aload_1
        //   20: invokeinterface 81 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 19	com/bda/controller/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: bipush 10
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 41 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 44	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 47	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 47	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -43 -> 26
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 47	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 47	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	Proxy
        //   0	84	1	paramIControllerListener	IControllerListener
        //   0	84	2	paramInt	int
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	72	finally
        //   19	26	72	finally
        //   26	57	72	finally
      }
      
      /* Error */
      public void registerMonitor(IControllerMonitor paramIControllerMonitor, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 90 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 19	com/bda/controller/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: iconst_3
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 41 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 44	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 47	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramIControllerMonitor	IControllerMonitor
        //   0	83	2	paramInt	int
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
      
      public void sendMessage(int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.bda.controller.IControllerService");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void unregisterListener(IControllerListener paramIControllerListener, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 81 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 19	com/bda/controller/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: iconst_2
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 41 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 44	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 47	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramIControllerListener	IControllerListener
        //   0	83	2	paramInt	int
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
      
      /* Error */
      public void unregisterMonitor(IControllerMonitor paramIControllerMonitor, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 90 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: iload_2
        //   33: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   36: aload_0
        //   37: getfield 19	com/bda/controller/IControllerService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   40: iconst_4
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 41 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 44	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 47	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	Proxy
        //   0	83	1	paramIControllerMonitor	IControllerMonitor
        //   0	83	2	paramInt	int
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/IControllerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */