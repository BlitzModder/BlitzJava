package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new zze();
  private final int mVersionCode;
  String zzbjg;
  String zzbjh;
  ProxyCard zzbji;
  String zzbjj;
  Address zzbjk;
  Address zzbjl;
  String[] zzbjm;
  UserAddress zzbjn;
  UserAddress zzbjo;
  InstrumentInfo[] zzbjp;
  PaymentMethodToken zzbjq;
  
  private FullWallet()
  {
    this.mVersionCode = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo, PaymentMethodToken paramPaymentMethodToken)
  {
    this.mVersionCode = paramInt;
    this.zzbjg = paramString1;
    this.zzbjh = paramString2;
    this.zzbji = paramProxyCard;
    this.zzbjj = paramString3;
    this.zzbjk = paramAddress1;
    this.zzbjl = paramAddress2;
    this.zzbjm = paramArrayOfString;
    this.zzbjn = paramUserAddress1;
    this.zzbjo = paramUserAddress2;
    this.zzbjp = paramArrayOfInstrumentInfo;
    this.zzbjq = paramPaymentMethodToken;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.zzbjk;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.zzbjn;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.zzbjo;
  }
  
  public String getEmail()
  {
    return this.zzbjj;
  }
  
  public String getGoogleTransactionId()
  {
    return this.zzbjg;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.zzbjp;
  }
  
  public String getMerchantTransactionId()
  {
    return this.zzbjh;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.zzbjm;
  }
  
  public PaymentMethodToken getPaymentMethodToken()
  {
    return this.zzbjq;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.zzbji;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.zzbjl;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */