package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class OwnedByMeFilter
  extends AbstractFilter
{
  public static final zzo CREATOR = new zzo();
  final int mVersionCode;
  
  public OwnedByMeFilter()
  {
    this(1);
  }
  
  OwnedByMeFilter(int paramInt)
  {
    this.mVersionCode = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zztn();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/OwnedByMeFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */