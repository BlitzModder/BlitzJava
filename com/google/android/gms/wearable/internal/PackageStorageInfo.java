package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PackageStorageInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new zzbr();
  public final String label;
  public final String packageName;
  public final int versionCode;
  public final long zzboB;
  
  PackageStorageInfo(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.versionCode = paramInt;
    this.packageName = paramString1;
    this.label = paramString2;
    this.zzboB = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbr.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/PackageStorageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */