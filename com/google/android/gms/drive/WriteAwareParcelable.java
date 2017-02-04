package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable
  implements Parcelable
{
  private volatile transient boolean zzanA = false;
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!zzsw()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      this.zzanA = true;
      zzJ(paramParcel, paramInt);
      return;
    }
  }
  
  protected abstract void zzJ(Parcel paramParcel, int paramInt);
  
  public final boolean zzsw()
  {
    return this.zzanA;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/WriteAwareParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */