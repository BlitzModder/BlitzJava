package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzk();
  private final int mVersionCode;
  LoyaltyWalletObject[] zzbjZ;
  String zzbjg;
  String zzbjh;
  String zzbjj;
  Address zzbjk;
  Address zzbjl;
  String[] zzbjm;
  UserAddress zzbjn;
  UserAddress zzbjo;
  InstrumentInfo[] zzbjp;
  OfferWalletObject[] zzbka;
  
  private MaskedWallet()
  {
    this.mVersionCode = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.mVersionCode = paramInt;
    this.zzbjg = paramString1;
    this.zzbjh = paramString2;
    this.zzbjm = paramArrayOfString;
    this.zzbjj = paramString3;
    this.zzbjk = paramAddress1;
    this.zzbjl = paramAddress2;
    this.zzbjZ = paramArrayOfLoyaltyWalletObject;
    this.zzbka = paramArrayOfOfferWalletObject;
    this.zzbjn = paramUserAddress1;
    this.zzbjo = paramUserAddress2;
    this.zzbjp = paramArrayOfInstrumentInfo;
  }
  
  public static Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    zzx.zzy(paramMaskedWallet);
    return zzGo().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).zza(paramMaskedWallet.zzGp()).zza(paramMaskedWallet.zzGq()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public static Builder zzGo()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new Builder(null);
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
    zzk.zza(this, paramParcel, paramInt);
  }
  
  @Deprecated
  public LoyaltyWalletObject[] zzGp()
  {
    return this.zzbjZ;
  }
  
  @Deprecated
  public OfferWalletObject[] zzGq()
  {
    return this.zzbka;
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWallet build()
    {
      return MaskedWallet.this;
    }
    
    public Builder setBillingAddress(Address paramAddress)
    {
      MaskedWallet.this.zzbjk = paramAddress;
      return this;
    }
    
    public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.zzbjn = paramUserAddress;
      return this;
    }
    
    public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.zzbjo = paramUserAddress;
      return this;
    }
    
    public Builder setEmail(String paramString)
    {
      MaskedWallet.this.zzbjj = paramString;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      MaskedWallet.this.zzbjg = paramString;
      return this;
    }
    
    public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
    {
      MaskedWallet.this.zzbjp = paramArrayOfInstrumentInfo;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWallet.this.zzbjh = paramString;
      return this;
    }
    
    public Builder setPaymentDescriptions(String[] paramArrayOfString)
    {
      MaskedWallet.this.zzbjm = paramArrayOfString;
      return this;
    }
    
    public Builder setShippingAddress(Address paramAddress)
    {
      MaskedWallet.this.zzbjl = paramAddress;
      return this;
    }
    
    @Deprecated
    public Builder zza(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
    {
      MaskedWallet.this.zzbjZ = paramArrayOfLoyaltyWalletObject;
      return this;
    }
    
    @Deprecated
    public Builder zza(OfferWalletObject[] paramArrayOfOfferWalletObject)
    {
      MaskedWallet.this.zzbka = paramArrayOfOfferWalletObject;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */