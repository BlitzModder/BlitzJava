package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  String description;
  final int version;
  String zzWR;
  String zzWS;
  String zzWT;
  String zzWU;
  List<String> zzWV;
  public FACLData zzWW;
  
  ScopeDetail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, FACLData paramFACLData)
  {
    this.version = paramInt;
    this.description = paramString1;
    this.zzWR = paramString2;
    this.zzWS = paramString3;
    this.zzWT = paramString4;
    this.zzWU = paramString5;
    this.zzWV = paramList;
    this.zzWW = paramFACLData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/firstparty/shared/ScopeDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */