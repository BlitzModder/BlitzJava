package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import java.util.ArrayList;

public final class LabelValueRow
  implements SafeParcelable
{
  public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();
  private final int mVersionCode;
  String zzblw;
  String zzblx;
  ArrayList<LabelValue> zzbly;
  
  LabelValueRow()
  {
    this.mVersionCode = 1;
    this.zzbly = zznh.zzrK();
  }
  
  LabelValueRow(int paramInt, String paramString1, String paramString2, ArrayList<LabelValue> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzblw = paramString1;
    this.zzblx = paramString2;
    this.zzbly = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/wobs/LabelValueRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */