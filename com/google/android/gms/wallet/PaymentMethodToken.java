package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzo();
  private final int mVersionCode;
  String zzaVZ;
  int zzbkt;
  
  private PaymentMethodToken()
  {
    this.mVersionCode = 1;
  }
  
  PaymentMethodToken(int paramInt1, int paramInt2, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.zzbkt = paramInt2;
    this.zzaVZ = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getPaymentMethodTokenizationType()
  {
    return this.zzbkt;
  }
  
  public String getToken()
  {
    return this.zzaVZ;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/PaymentMethodToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */