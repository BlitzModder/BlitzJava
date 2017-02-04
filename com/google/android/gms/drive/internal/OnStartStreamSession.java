package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnStartStreamSession
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnStartStreamSession> CREATOR = new zzbi();
  final int mVersionCode;
  final ParcelFileDescriptor zzaqr;
  final IBinder zzaqs;
  final String zzsL;
  
  OnStartStreamSession(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, IBinder paramIBinder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaqr = paramParcelFileDescriptor;
    this.zzaqs = paramIBinder;
    this.zzsL = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbi.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnStartStreamSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */