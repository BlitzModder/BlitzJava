package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final int id;
  final int mVersionCode;
  final Bundle zzSy;
  
  Feature(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.id = paramInt2;
    this.zzSy = paramBundle;
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */