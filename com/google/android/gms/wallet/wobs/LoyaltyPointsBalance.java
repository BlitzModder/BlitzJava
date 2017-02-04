package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
  private final int mVersionCode;
  String zzbjx;
  int zzblA;
  String zzblB;
  double zzblC;
  long zzblD;
  int zzblE;
  
  LoyaltyPointsBalance()
  {
    this.mVersionCode = 1;
    this.zzblE = -1;
    this.zzblA = -1;
    this.zzblC = -1.0D;
  }
  
  LoyaltyPointsBalance(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzblA = paramInt2;
    this.zzblB = paramString1;
    this.zzblC = paramDouble;
    this.zzbjx = paramString2;
    this.zzblD = paramLong;
    this.zzblE = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/wobs/LoyaltyPointsBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */