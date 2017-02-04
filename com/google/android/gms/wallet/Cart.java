package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart
  implements SafeParcelable
{
  public static final Parcelable.Creator<Cart> CREATOR = new zzb();
  private final int mVersionCode;
  String zzbiZ;
  String zzbja;
  ArrayList<LineItem> zzbjb;
  
  Cart()
  {
    this.mVersionCode = 1;
    this.zzbjb = new ArrayList();
  }
  
  Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzbiZ = paramString1;
    this.zzbja = paramString2;
    this.zzbjb = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    Cart localCart = new Cart();
    localCart.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.zzbja;
  }
  
  public ArrayList<LineItem> getLineItems()
  {
    return this.zzbjb;
  }
  
  public String getTotalPrice()
  {
    return this.zzbiZ;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addLineItem(LineItem paramLineItem)
    {
      Cart.this.zzbjb.add(paramLineItem);
      return this;
    }
    
    public Cart build()
    {
      return Cart.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      Cart.this.zzbja = paramString;
      return this;
    }
    
    public Builder setLineItems(List<LineItem> paramList)
    {
      Cart.this.zzbjb.clear();
      Cart.this.zzbjb.addAll(paramList);
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      Cart.this.zzbiZ = paramString;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/Cart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */