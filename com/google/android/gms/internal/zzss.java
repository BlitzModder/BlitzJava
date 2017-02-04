package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;

public abstract interface zzss
  extends IInterface
{
  public abstract void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(int paramInt, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, GetBuyFlowInitializationTokenResponse paramGetBuyFlowInitializationTokenResponse, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zza(Status paramStatus, GetInstrumentsResponse paramGetInstrumentsResponse, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void zzj(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzss
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    }
    
    public static zzss zzej(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzss))) {
        return (zzss)localIInterface;
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
      Object localObject1;
      label174:
      label251:
      boolean bool;
      label317:
      Object localObject2;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (MaskedWallet)MaskedWallet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label174;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramInt1, (MaskedWallet)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (FullWallet)FullWallet.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label251;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramInt1, (FullWallet)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label317;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramInt1, bool, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          bool = false;
          break;
        }
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zzj(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label459;
          }
          localObject2 = (GetInstrumentsResponse)GetInstrumentsResponse.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label465;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza((Status)localObject1, (GetInstrumentsResponse)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label418;
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label531;
          }
        }
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zzb(paramInt1, bool, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          bool = false;
          break;
        }
      case 7: 
        label418:
        label459:
        label465:
        label531:
        paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label625;
          }
          localObject2 = (GetBuyFlowInitializationTokenResponse)GetBuyFlowInitializationTokenResponse.CREATOR.createFromParcel(paramParcel1);
          label584:
          if (paramParcel1.readInt() == 0) {
            break label631;
          }
        }
        label625:
        label631:
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza((Status)localObject1, (GetBuyFlowInitializationTokenResponse)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label584;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label702;
        }
      }
      label702:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza((Status)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    }
    
    private static class zza
      implements zzss
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
      
      public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramFullWallet != null)
            {
              localParcel1.writeInt(1);
              paramFullWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.zzoo.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            localParcel1.writeInt(paramInt);
            if (paramMaskedWallet != null)
            {
              localParcel1.writeInt(1);
              paramMaskedWallet.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.zzoo.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: iload_1
        //   23: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   26: iload_2
        //   27: ifeq +61 -> 88
        //   30: iload 4
        //   32: istore_1
        //   33: aload 5
        //   35: iload_1
        //   36: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: ifnull +53 -> 93
        //   43: aload 5
        //   45: iconst_1
        //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   49: aload_3
        //   50: aload 5
        //   52: iconst_0
        //   53: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload_0
        //   57: getfield 18	com/google/android/gms/internal/zzss$zza$zza:zzoo	Landroid/os/IBinder;
        //   60: iconst_3
        //   61: aload 5
        //   63: aload 6
        //   65: iconst_0
        //   66: invokeinterface 55 5 0
        //   71: pop
        //   72: aload 6
        //   74: invokevirtual 58	android/os/Parcel:readException	()V
        //   77: aload 6
        //   79: invokevirtual 61	android/os/Parcel:recycle	()V
        //   82: aload 5
        //   84: invokevirtual 61	android/os/Parcel:recycle	()V
        //   87: return
        //   88: iconst_0
        //   89: istore_1
        //   90: goto -57 -> 33
        //   93: aload 5
        //   95: iconst_0
        //   96: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   99: goto -43 -> 56
        //   102: astore_3
        //   103: aload 6
        //   105: invokevirtual 61	android/os/Parcel:recycle	()V
        //   108: aload 5
        //   110: invokevirtual 61	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	115	0	this	zza
        //   0	115	1	paramInt	int
        //   0	115	2	paramBoolean	boolean
        //   0	115	3	paramBundle	Bundle
        //   1	30	4	i	int
        //   6	103	5	localParcel1	Parcel
        //   11	93	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	102	finally
        //   33	39	102	finally
        //   43	56	102	finally
        //   56	77	102	finally
        //   93	99	102	finally
      }
      
      public void zza(Status paramStatus, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (paramStatus != null)
            {
              localParcel1.writeInt(1);
              paramStatus.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.zzoo.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void zza(Status paramStatus, GetBuyFlowInitializationTokenResponse paramGetBuyFlowInitializationTokenResponse, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (paramStatus != null)
            {
              localParcel1.writeInt(1);
              paramStatus.writeToParcel(localParcel1, 0);
              if (paramGetBuyFlowInitializationTokenResponse != null)
              {
                localParcel1.writeInt(1);
                paramGetBuyFlowInitializationTokenResponse.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.zzoo.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label132:
          localParcel1.writeInt(0);
        }
      }
      
      public void zza(Status paramStatus, GetInstrumentsResponse paramGetInstrumentsResponse, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
            if (paramStatus != null)
            {
              localParcel1.writeInt(1);
              paramStatus.writeToParcel(localParcel1, 0);
              if (paramGetInstrumentsResponse != null)
              {
                localParcel1.writeInt(1);
                paramGetInstrumentsResponse.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label131;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.zzoo.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label131:
          localParcel1.writeInt(0);
        }
      }
      
      /* Error */
      public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 32
        //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: iload_1
        //   23: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   26: iload_2
        //   27: ifeq +62 -> 89
        //   30: iload 4
        //   32: istore_1
        //   33: aload 5
        //   35: iload_1
        //   36: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: ifnull +54 -> 94
        //   43: aload 5
        //   45: iconst_1
        //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   49: aload_3
        //   50: aload 5
        //   52: iconst_0
        //   53: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload_0
        //   57: getfield 18	com/google/android/gms/internal/zzss$zza$zza:zzoo	Landroid/os/IBinder;
        //   60: bipush 6
        //   62: aload 5
        //   64: aload 6
        //   66: iconst_0
        //   67: invokeinterface 55 5 0
        //   72: pop
        //   73: aload 6
        //   75: invokevirtual 58	android/os/Parcel:readException	()V
        //   78: aload 6
        //   80: invokevirtual 61	android/os/Parcel:recycle	()V
        //   83: aload 5
        //   85: invokevirtual 61	android/os/Parcel:recycle	()V
        //   88: return
        //   89: iconst_0
        //   90: istore_1
        //   91: goto -58 -> 33
        //   94: aload 5
        //   96: iconst_0
        //   97: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   100: goto -44 -> 56
        //   103: astore_3
        //   104: aload 6
        //   106: invokevirtual 61	android/os/Parcel:recycle	()V
        //   109: aload 5
        //   111: invokevirtual 61	android/os/Parcel:recycle	()V
        //   114: aload_3
        //   115: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	zza
        //   0	116	1	paramInt	int
        //   0	116	2	paramBoolean	boolean
        //   0	116	3	paramBundle	Bundle
        //   1	30	4	i	int
        //   6	104	5	localParcel1	Parcel
        //   11	94	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	103	finally
        //   33	39	103	finally
        //   43	56	103	finally
        //   56	78	103	finally
        //   94	100	103	finally
      }
      
      /* Error */
      public void zzj(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +44 -> 65
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/internal/zzss$zza$zza:zzoo	Landroid/os/IBinder;
        //   39: iconst_4
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 55 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 58	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 61	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 61	android/os/Parcel:recycle	()V
        //   64: return
        //   65: aload_3
        //   66: iconst_0
        //   67: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   70: goto -35 -> 35
        //   73: astore_2
        //   74: aload 4
        //   76: invokevirtual 61	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: invokevirtual 61	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	zza
        //   0	85	1	paramInt	int
        //   0	85	2	paramBundle	Bundle
        //   3	77	3	localParcel1	Parcel
        //   7	68	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	73	finally
        //   24	35	73	finally
        //   35	55	73	finally
        //   65	70	73	finally
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */