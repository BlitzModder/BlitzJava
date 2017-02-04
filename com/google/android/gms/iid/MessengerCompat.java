package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator()
  {
    public MessengerCompat zzeF(Parcel paramAnonymousParcel)
    {
      paramAnonymousParcel = paramAnonymousParcel.readStrongBinder();
      if (paramAnonymousParcel != null) {
        return new MessengerCompat(paramAnonymousParcel);
      }
      return null;
    }
    
    public MessengerCompat[] zzhd(int paramAnonymousInt)
    {
      return new MessengerCompat[paramAnonymousInt];
    }
  };
  Messenger zzaKq;
  zzb zzaKr;
  
  public MessengerCompat(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzaKq = new Messenger(paramHandler);
      return;
    }
    this.zzaKr = new zza(paramHandler);
  }
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzaKq = new Messenger(paramIBinder);
      return;
    }
    this.zzaKr = zzb.zza.zzcd(paramIBinder);
  }
  
  public static int zzc(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return zzd(paramMessage);
    }
    return paramMessage.arg2;
  }
  
  private static int zzd(Message paramMessage)
  {
    return paramMessage.sendingUid;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public IBinder getBinder()
  {
    if (this.zzaKq != null) {
      return this.zzaKq.getBinder();
    }
    return this.zzaKr.asBinder();
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public void send(Message paramMessage)
    throws RemoteException
  {
    if (this.zzaKq != null)
    {
      this.zzaKq.send(paramMessage);
      return;
    }
    this.zzaKr.send(paramMessage);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.zzaKq != null)
    {
      paramParcel.writeStrongBinder(this.zzaKq.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzaKr.asBinder());
  }
  
  private final class zza
    extends zzb.zza
  {
    Handler handler;
    
    zza(Handler paramHandler)
    {
      this.handler = paramHandler;
    }
    
    public void send(Message paramMessage)
      throws RemoteException
    {
      paramMessage.arg2 = Binder.getCallingUid();
      this.handler.dispatchMessage(paramMessage);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/iid/MessengerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */