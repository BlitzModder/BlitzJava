package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzre
  extends IInterface
{
  public abstract void zza(zzrd paramzzrd, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzre
  {
    public static zzre zzdG(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
      if ((localIInterface != null) && ((localIInterface instanceof zzre))) {
        return (zzre)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
      zzrd localzzrd = zzrd.zza.zzdF(paramParcel1.readStrongBinder());
      Bundle localBundle;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label130;
        }
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        label102:
        if (paramParcel1.readInt() == 0) {
          break label136;
        }
      }
      label130:
      label136:
      for (boolean bool = true;; bool = false)
      {
        zza(localzzrd, paramParcel2, localBundle, bool);
        return true;
        paramParcel2 = null;
        break;
        localBundle = null;
        break label102;
      }
    }
    
    private static class zza
      implements zzre
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
      
      public void zza(zzrd paramzzrd, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
        throws RemoteException
      {
        IBinder localIBinder = null;
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
            if (paramzzrd != null) {
              localIBinder = paramzzrd.asBinder();
            }
            localParcel.writeStrongBinder(localIBinder);
            if (paramUri != null)
            {
              localParcel.writeInt(1);
              paramUri.writeToParcel(localParcel, 0);
              if (paramBundle != null)
              {
                localParcel.writeInt(1);
                paramBundle.writeToParcel(localParcel, 0);
                break label134;
                localParcel.writeInt(i);
                this.zzoo.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
          label134:
          while (!paramBoolean)
          {
            i = 0;
            break;
          }
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */