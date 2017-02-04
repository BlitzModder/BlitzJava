package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator()
  {
    public BinderWrapper zzan(Parcel paramAnonymousParcel)
    {
      return new BinderWrapper(paramAnonymousParcel, null);
    }
    
    public BinderWrapper[] zzbR(int paramAnonymousInt)
    {
      return new BinderWrapper[paramAnonymousInt];
    }
  };
  private IBinder zzaiT = null;
  
  public BinderWrapper() {}
  
  public BinderWrapper(IBinder paramIBinder)
  {
    this.zzaiT = paramIBinder;
  }
  
  private BinderWrapper(Parcel paramParcel)
  {
    this.zzaiT = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.zzaiT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/BinderWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */