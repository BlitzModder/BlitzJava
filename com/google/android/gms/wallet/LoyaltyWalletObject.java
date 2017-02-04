package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzj();
  private final int mVersionCode;
  int state;
  String zzaOo;
  String zzbjG;
  String zzbjH;
  String zzbjI;
  String zzbjJ;
  String zzbjK;
  String zzbjL;
  String zzbjM;
  String zzbjN;
  ArrayList<WalletObjectMessage> zzbjO;
  TimeInterval zzbjP;
  ArrayList<LatLng> zzbjQ;
  String zzbjR;
  String zzbjS;
  ArrayList<LabelValueRow> zzbjT;
  boolean zzbjU;
  ArrayList<UriData> zzbjV;
  ArrayList<TextModuleData> zzbjW;
  ArrayList<UriData> zzbjX;
  LoyaltyPoints zzbjY;
  String zzif;
  
  LoyaltyWalletObject()
  {
    this.mVersionCode = 4;
    this.zzbjO = zznh.zzrK();
    this.zzbjQ = zznh.zzrK();
    this.zzbjT = zznh.zzrK();
    this.zzbjV = zznh.zzrK();
    this.zzbjW = zznh.zzrK();
    this.zzbjX = zznh.zzrK();
  }
  
  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5, LoyaltyPoints paramLoyaltyPoints)
  {
    this.mVersionCode = paramInt1;
    this.zzif = paramString1;
    this.zzbjG = paramString2;
    this.zzbjH = paramString3;
    this.zzbjI = paramString4;
    this.zzaOo = paramString5;
    this.zzbjJ = paramString6;
    this.zzbjK = paramString7;
    this.zzbjL = paramString8;
    this.zzbjM = paramString9;
    this.zzbjN = paramString10;
    this.state = paramInt2;
    this.zzbjO = paramArrayList;
    this.zzbjP = paramTimeInterval;
    this.zzbjQ = paramArrayList1;
    this.zzbjR = paramString11;
    this.zzbjS = paramString12;
    this.zzbjT = paramArrayList2;
    this.zzbjU = paramBoolean;
    this.zzbjV = paramArrayList3;
    this.zzbjW = paramArrayList4;
    this.zzbjX = paramArrayList5;
    this.zzbjY = paramLoyaltyPoints;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountId()
  {
    return this.zzbjG;
  }
  
  public String getAccountName()
  {
    return this.zzaOo;
  }
  
  public String getBarcodeAlternateText()
  {
    return this.zzbjJ;
  }
  
  public String getBarcodeType()
  {
    return this.zzbjK;
  }
  
  public String getBarcodeValue()
  {
    return this.zzbjL;
  }
  
  public String getId()
  {
    return this.zzif;
  }
  
  public String getIssuerName()
  {
    return this.zzbjH;
  }
  
  public String getProgramName()
  {
    return this.zzbjI;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */