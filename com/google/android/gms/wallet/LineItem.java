package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<LineItem> CREATOR = new zzi();
  String description;
  private final int mVersionCode;
  String zzbiZ;
  String zzbjC;
  String zzbjD;
  int zzbjE;
  String zzbja;
  
  LineItem()
  {
    this.mVersionCode = 1;
    this.zzbjE = 0;
  }
  
  LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.description = paramString1;
    this.zzbjC = paramString2;
    this.zzbjD = paramString3;
    this.zzbiZ = paramString4;
    this.zzbjE = paramInt2;
    this.zzbja = paramString5;
  }
  
  public static Builder newBuilder()
  {
    LineItem localLineItem = new LineItem();
    localLineItem.getClass();
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
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getQuantity()
  {
    return this.zzbjC;
  }
  
  public int getRole()
  {
    return this.zzbjE;
  }
  
  public String getTotalPrice()
  {
    return this.zzbiZ;
  }
  
  public String getUnitPrice()
  {
    return this.zzbjD;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public LineItem build()
    {
      return LineItem.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      LineItem.this.zzbja = paramString;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      LineItem.this.description = paramString;
      return this;
    }
    
    public Builder setQuantity(String paramString)
    {
      LineItem.this.zzbjC = paramString;
      return this;
    }
    
    public Builder setRole(int paramInt)
    {
      LineItem.this.zzbjE = paramInt;
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      LineItem.this.zzbiZ = paramString;
      return this;
    }
    
    public Builder setUnitPrice(String paramString)
    {
      LineItem.this.zzbjD = paramString;
      return this;
    }
  }
  
  public static abstract interface Role
  {
    public static final int REGULAR = 0;
    public static final int SHIPPING = 2;
    public static final int TAX = 1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */