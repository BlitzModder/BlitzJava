package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zza();
  private final int mVersionCode;
  String name;
  int state;
  String zzbjH;
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
  String zzif;
  
  CommonWalletObject()
  {
    this.mVersionCode = 1;
    this.zzbjO = zznh.zzrK();
    this.zzbjQ = zznh.zzrK();
    this.zzbjT = zznh.zzrK();
    this.zzbjV = zznh.zzrK();
    this.zzbjW = zznh.zzrK();
    this.zzbjX = zznh.zzrK();
  }
  
  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList<WalletObjectMessage> paramArrayList, TimeInterval paramTimeInterval, ArrayList<LatLng> paramArrayList1, String paramString9, String paramString10, ArrayList<LabelValueRow> paramArrayList2, boolean paramBoolean, ArrayList<UriData> paramArrayList3, ArrayList<TextModuleData> paramArrayList4, ArrayList<UriData> paramArrayList5)
  {
    this.mVersionCode = paramInt1;
    this.zzif = paramString1;
    this.zzbjN = paramString2;
    this.name = paramString3;
    this.zzbjH = paramString4;
    this.zzbjJ = paramString5;
    this.zzbjK = paramString6;
    this.zzbjL = paramString7;
    this.zzbjM = paramString8;
    this.state = paramInt2;
    this.zzbjO = paramArrayList;
    this.zzbjP = paramTimeInterval;
    this.zzbjQ = paramArrayList1;
    this.zzbjR = paramString9;
    this.zzbjS = paramString10;
    this.zzbjT = paramArrayList2;
    this.zzbjU = paramBoolean;
    this.zzbjV = paramArrayList3;
    this.zzbjW = paramArrayList4;
    this.zzbjX = paramArrayList5;
  }
  
  public static zza zzGu()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new zza(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzif;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final class zza
  {
    private zza() {}
    
    public CommonWalletObject zzGv()
    {
      return CommonWalletObject.this;
    }
    
    public zza zzfW(String paramString)
    {
      CommonWalletObject.this.zzif = paramString;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/wobs/CommonWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */