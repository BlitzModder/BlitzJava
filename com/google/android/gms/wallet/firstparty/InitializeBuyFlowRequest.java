package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class InitializeBuyFlowRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<InitializeBuyFlowRequest> CREATOR = new zzf();
  private final int mVersionCode;
  byte[][] zzbkM;
  
  InitializeBuyFlowRequest(int paramInt, byte[][] paramArrayOfByte)
  {
    this.mVersionCode = paramInt;
    this.zzbkM = paramArrayOfByte;
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
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/firstparty/InitializeBuyFlowRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */