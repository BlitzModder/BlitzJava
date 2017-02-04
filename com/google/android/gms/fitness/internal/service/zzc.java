package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpb.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public abstract interface zzc
  extends IInterface
{
  public abstract void zza(FitnessDataSourcesRequest paramFitnessDataSourcesRequest, zzpb paramzzpb)
    throws RemoteException;
  
  public abstract void zza(FitnessUnregistrationRequest paramFitnessUnregistrationRequest, zzpp paramzzpp)
    throws RemoteException;
  
  public abstract void zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzpp paramzzpp)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzc
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
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
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (FitnessDataSourcesRequest)FitnessDataSourcesRequest.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2, zzpb.zza.zzbD(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        zza(paramParcel2, zzpp.zza.zzbR(paramParcel1.readStrongBinder()));
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (FitnessUnregistrationRequest)FitnessUnregistrationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2, zzpp.zza.zzbR(paramParcel1.readStrongBinder()));
      return true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/internal/service/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */