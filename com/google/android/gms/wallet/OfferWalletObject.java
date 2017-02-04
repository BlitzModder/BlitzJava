package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzn();
  private final int mVersionCode;
  CommonWalletObject zzbjt;
  String zzbks;
  String zzif;
  
  OfferWalletObject()
  {
    this.mVersionCode = 3;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject)
  {
    this.mVersionCode = paramInt;
    this.zzbks = paramString2;
    if (paramInt < 3)
    {
      this.zzbjt = CommonWalletObject.zzGu().zzfW(paramString1).zzGv();
      return;
    }
    this.zzbjt = paramCommonWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzbjt.getId();
  }
  
  public String getRedemptionCode()
  {
    return this.zzbks;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */