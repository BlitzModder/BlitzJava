package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import java.util.List;

public abstract interface zzba
  extends IInterface
{
  public abstract void onConnectedNodes(List<NodeParcelable> paramList)
    throws RemoteException;
  
  public abstract void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
    throws RemoteException;
  
  public abstract void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
    throws RemoteException;
  
  public abstract void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
    throws RemoteException;
  
  public abstract void zza(ChannelEventParcelable paramChannelEventParcelable)
    throws RemoteException;
  
  public abstract void zza(LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable)
    throws RemoteException;
  
  public abstract void zza(LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, zzay paramzzay)
    throws RemoteException;
  
  public abstract void zza(MessageEventParcelable paramMessageEventParcelable)
    throws RemoteException;
  
  public abstract void zza(NodeParcelable paramNodeParcelable)
    throws RemoteException;
  
  public abstract void zza(zzax paramzzax, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void zzag(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void zzb(NodeParcelable paramNodeParcelable)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzba
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }
    
    public static zzba zzeq(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if ((localIInterface != null) && ((localIInterface instanceof zzba))) {
        return (zzba)localIInterface;
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
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = DataHolder.CREATOR.zzak(paramParcel1);
        }
        zzag(paramParcel2);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (MessageEventParcelable)MessageEventParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject3;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject4;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zzb(paramParcel2);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        onConnectedNodes(paramParcel1.createTypedArrayList(NodeParcelable.CREATOR));
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject5;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject6;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ChannelEventParcelable)ChannelEventParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject7;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (CapabilityInfoParcelable)CapabilityInfoParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject8;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (AmsEntityUpdateParcelable)AmsEntityUpdateParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject9;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (LargeAssetQueueStateChangeParcelable)LargeAssetQueueStateChangeParcelable.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        zza(zzax.zza.zzen(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject10;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (LargeAssetSyncRequestPayload)LargeAssetSyncRequestPayload.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2, zzay.zza.zzeo(paramParcel1.readStrongBinder()));
      return true;
    }
    
    private static class zza
      implements zzba
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
      
      public void onConnectedNodes(List<NodeParcelable> paramList)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          localParcel.writeTypedList(paramList);
          this.zzoo.transact(5, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 63	com/google/android/gms/wearable/internal/AmsEntityUpdateParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: bipush 9
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 46 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 49	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	zza
        //   0	60	1	paramAmsEntityUpdateParcelable	AmsEntityUpdateParcelable
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      /* Error */
      public void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 67	com/google/android/gms/wearable/internal/AncsNotificationParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: bipush 6
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 46 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 49	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	zza
        //   0	60	1	paramAncsNotificationParcelable	AncsNotificationParcelable
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      /* Error */
      public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 71	com/google/android/gms/wearable/internal/CapabilityInfoParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: bipush 8
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 46 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 49	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	zza
        //   0	60	1	paramCapabilityInfoParcelable	CapabilityInfoParcelable
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      /* Error */
      public void zza(ChannelEventParcelable paramChannelEventParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 75	com/google/android/gms/wearable/internal/ChannelEventParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: bipush 7
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 46 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 49	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	zza
        //   0	60	1	paramChannelEventParcelable	ChannelEventParcelable
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      /* Error */
      public void zza(LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +34 -> 45
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 79	com/google/android/gms/wearable/internal/LargeAssetQueueStateChangeParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: bipush 10
        //   31: aload_2
        //   32: aconst_null
        //   33: iconst_1
        //   34: invokeinterface 46 5 0
        //   39: pop
        //   40: aload_2
        //   41: invokevirtual 49	android/os/Parcel:recycle	()V
        //   44: return
        //   45: aload_2
        //   46: iconst_0
        //   47: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   50: goto -25 -> 25
        //   53: astore_1
        //   54: aload_2
        //   55: invokevirtual 49	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	60	0	this	zza
        //   0	60	1	paramLargeAssetQueueStateChangeParcelable	LargeAssetQueueStateChangeParcelable
        //   3	52	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	53	finally
        //   14	25	53	finally
        //   25	40	53	finally
        //   45	50	53	finally
      }
      
      /* Error */
      public void zza(LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, zzay paramzzay)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: aload 4
        //   9: ldc 33
        //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +57 -> 72
        //   18: aload 4
        //   20: iconst_1
        //   21: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload 4
        //   27: iconst_0
        //   28: invokevirtual 83	com/google/android/gms/wearable/internal/LargeAssetSyncRequestPayload:writeToParcel	(Landroid/os/Parcel;I)V
        //   31: aload_3
        //   32: astore_1
        //   33: aload_2
        //   34: ifnull +10 -> 44
        //   37: aload_2
        //   38: invokeinterface 87 1 0
        //   43: astore_1
        //   44: aload 4
        //   46: aload_1
        //   47: invokevirtual 90	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   50: aload_0
        //   51: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   54: bipush 12
        //   56: aload 4
        //   58: aconst_null
        //   59: iconst_1
        //   60: invokeinterface 46 5 0
        //   65: pop
        //   66: aload 4
        //   68: invokevirtual 49	android/os/Parcel:recycle	()V
        //   71: return
        //   72: aload 4
        //   74: iconst_0
        //   75: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   78: goto -47 -> 31
        //   81: astore_1
        //   82: aload 4
        //   84: invokevirtual 49	android/os/Parcel:recycle	()V
        //   87: aload_1
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	zza
        //   0	89	1	paramLargeAssetSyncRequestPayload	LargeAssetSyncRequestPayload
        //   0	89	2	paramzzay	zzay
        //   1	31	3	localObject	Object
        //   5	78	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   7	14	81	finally
        //   18	31	81	finally
        //   37	44	81	finally
        //   44	66	81	finally
        //   72	78	81	finally
      }
      
      /* Error */
      public void zza(MessageEventParcelable paramMessageEventParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 94	com/google/android/gms/wearable/internal/MessageEventParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 46 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	zza
        //   0	59	1	paramMessageEventParcelable	MessageEventParcelable
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      /* Error */
      public void zza(NodeParcelable paramNodeParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 98	com/google/android/gms/wearable/internal/NodeParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: iconst_3
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 46 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	zza
        //   0	59	1	paramNodeParcelable	NodeParcelable
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      public void zza(zzax paramzzax, String paramString, int paramInt)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
          if (paramzzax != null) {
            localIBinder = paramzzax.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.zzoo.transact(11, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void zzag(DataHolder paramDataHolder)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 110	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 46 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	zza
        //   0	59	1	paramDataHolder	DataHolder
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
      
      /* Error */
      public void zzb(NodeParcelable paramNodeParcelable)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 33
        //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 98	com/google/android/gms/wearable/internal/NodeParcelable:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/wearable/internal/zzba$zza$zza:zzoo	Landroid/os/IBinder;
        //   29: iconst_4
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 46 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 49	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 57	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 49	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	zza
        //   0	59	1	paramNodeParcelable	NodeParcelable
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */