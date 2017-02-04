package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWalletRequest> CREATOR = new zzf();
  private final int mVersionCode;
  String zzbjg;
  String zzbjh;
  Cart zzbjr;
  
  FullWalletRequest()
  {
    this.mVersionCode = 1;
  }
  
  FullWalletRequest(int paramInt, String paramString1, String paramString2, Cart paramCart)
  {
    this.mVersionCode = paramInt;
    this.zzbjg = paramString1;
    this.zzbjh = paramString2;
    this.zzbjr = paramCart;
  }
  
  public static Builder newBuilder()
  {
    FullWalletRequest localFullWalletRequest = new FullWalletRequest();
    localFullWalletRequest.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Cart getCart()
  {
    return this.zzbjr;
  }
  
  public String getGoogleTransactionId()
  {
    return this.zzbjg;
  }
  
  public String getMerchantTransactionId()
  {
    return this.zzbjh;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public FullWalletRequest build()
    {
      return FullWalletRequest.this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      FullWalletRequest.this.zzbjr = paramCart;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      FullWalletRequest.this.zzbjg = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      FullWalletRequest.this.zzbjh = paramString;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/FullWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */