package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback
  implements Parcelable
{
  public static final Parcelable.Creator<PendingCallback> CREATOR = new Parcelable.Creator()
  {
    public PendingCallback zzeA(Parcel paramAnonymousParcel)
    {
      return new PendingCallback(paramAnonymousParcel);
    }
    
    public PendingCallback[] zzgX(int paramAnonymousInt)
    {
      return new PendingCallback[paramAnonymousInt];
    }
  };
  final IBinder zzaiT;
  
  public PendingCallback(Parcel paramParcel)
  {
    this.zzaiT = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBinder getIBinder()
  {
    return this.zzaiT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.zzaiT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/PendingCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */