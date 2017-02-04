package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
  final int mVersionCode;
  String zzbbt;
  String zzbbu;
  long zzbbv;
  
  GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.mVersionCode = paramInt;
    this.zzbbt = paramString1;
    this.zzbbu = paramString2;
    this.zzbbv = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccessToken()
  {
    return this.zzbbu;
  }
  
  public String getAuthCode()
  {
    return this.zzbbt;
  }
  
  public long getNextAllowedTimeMillis()
  {
    return this.zzbbv;
  }
  
  public String toString()
  {
    return "mAuthCode = " + this.zzbbt + "\nmAccessToken = " + this.zzbbu + "\nmNextAllowedTimeMillis = " + this.zzbbv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/search/GoogleNowAuthState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */