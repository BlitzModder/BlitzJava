package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class GiftCardWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
  final int mVersionCode;
  String pin;
  CommonWalletObject zzbjt = CommonWalletObject.zzGu().zzGv();
  String zzbju;
  String zzbjv;
  long zzbjw;
  String zzbjx;
  long zzbjy;
  String zzbjz;
  
  GiftCardWalletObject()
  {
    this.mVersionCode = 1;
  }
  
  GiftCardWalletObject(int paramInt, CommonWalletObject paramCommonWalletObject, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5)
  {
    this.mVersionCode = paramInt;
    this.zzbjt = paramCommonWalletObject;
    this.zzbju = paramString1;
    this.pin = paramString2;
    this.zzbjw = paramLong1;
    this.zzbjx = paramString4;
    this.zzbjy = paramLong2;
    this.zzbjz = paramString5;
    this.zzbjv = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzbjt.getId();
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/GiftCardWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */