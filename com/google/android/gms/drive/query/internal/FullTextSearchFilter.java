package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter
  extends AbstractFilter
{
  public static final zzh CREATOR = new zzh();
  final String mValue;
  final int mVersionCode;
  
  FullTextSearchFilter(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.mValue = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzda(this.mValue);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/FullTextSearchFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */