package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new zzq();
  private final int mVersionCode;
  String zzbkw;
  String zzbkx;
  int zzbky;
  int zzbkz;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzbkw = paramString1;
    this.zzbkx = paramString2;
    this.zzbky = paramInt2;
    this.zzbkz = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCvn()
  {
    return this.zzbkx;
  }
  
  public int getExpirationMonth()
  {
    return this.zzbky;
  }
  
  public int getExpirationYear()
  {
    return this.zzbkz;
  }
  
  public String getPan()
  {
    return this.zzbkw;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */