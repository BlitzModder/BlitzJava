package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzl();
  private final int mVersionCode;
  String zzbja;
  String zzbjh;
  Cart zzbjr;
  boolean zzbkc;
  boolean zzbkd;
  boolean zzbke;
  String zzbkf;
  String zzbkg;
  boolean zzbkh;
  boolean zzbki;
  CountrySpecification[] zzbkj;
  boolean zzbkk;
  boolean zzbkl;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> zzbkm;
  PaymentMethodTokenizationParameters zzbkn;
  ArrayList<Integer> zzbko;
  
  MaskedWalletRequest()
  {
    this.mVersionCode = 3;
    this.zzbkk = true;
    this.zzbkl = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList, PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, ArrayList<Integer> paramArrayList1)
  {
    this.mVersionCode = paramInt;
    this.zzbjh = paramString1;
    this.zzbkc = paramBoolean1;
    this.zzbkd = paramBoolean2;
    this.zzbke = paramBoolean3;
    this.zzbkf = paramString2;
    this.zzbja = paramString3;
    this.zzbkg = paramString4;
    this.zzbjr = paramCart;
    this.zzbkh = paramBoolean4;
    this.zzbki = paramBoolean5;
    this.zzbkj = paramArrayOfCountrySpecification;
    this.zzbkk = paramBoolean6;
    this.zzbkl = paramBoolean7;
    this.zzbkm = paramArrayList;
    this.zzbkn = paramPaymentMethodTokenizationParameters;
    this.zzbko = paramArrayList1;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.zzbkl;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.zzbkk;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<Integer> getAllowedCardNetworks()
  {
    return this.zzbko;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.zzbkm;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.zzbkj;
  }
  
  public Cart getCart()
  {
    return this.zzbjr;
  }
  
  public String getCurrencyCode()
  {
    return this.zzbja;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.zzbkf;
  }
  
  public String getMerchantName()
  {
    return this.zzbkg;
  }
  
  public String getMerchantTransactionId()
  {
    return this.zzbjh;
  }
  
  public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters()
  {
    return this.zzbkn;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  @Deprecated
  public boolean isBillingAgreement()
  {
    return this.zzbki;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.zzbkc;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.zzbkd;
  }
  
  @Deprecated
  public boolean useMinimalBillingAddress()
  {
    return this.zzbke;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCardNetwork(int paramInt)
    {
      if (MaskedWalletRequest.this.zzbko == null) {
        MaskedWalletRequest.this.zzbko = new ArrayList();
      }
      MaskedWalletRequest.this.zzbko.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public Builder addAllowedCardNetworks(Collection<Integer> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.zzbko == null) {
          MaskedWalletRequest.this.zzbko = new ArrayList();
        }
        MaskedWalletRequest.this.zzbko.addAll(paramCollection);
      }
      return this;
    }
    
    public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification paramCountrySpecification)
    {
      if (MaskedWalletRequest.this.zzbkm == null) {
        MaskedWalletRequest.this.zzbkm = new ArrayList();
      }
      MaskedWalletRequest.this.zzbkm.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.zzbkm == null) {
          MaskedWalletRequest.this.zzbkm = new ArrayList();
        }
        MaskedWalletRequest.this.zzbkm.addAll(paramCollection);
      }
      return this;
    }
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbkl = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbkk = paramBoolean;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.zzbjr = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.zzbja = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.zzbkf = paramString;
      return this;
    }
    
    @Deprecated
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbki = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.zzbkg = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.zzbjh = paramString;
      return this;
    }
    
    public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters)
    {
      MaskedWalletRequest.this.zzbkn = paramPaymentMethodTokenizationParameters;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbkc = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbkd = paramBoolean;
      return this;
    }
    
    @Deprecated
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbke = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */