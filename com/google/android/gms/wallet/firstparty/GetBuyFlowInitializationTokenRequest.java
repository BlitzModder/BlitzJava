package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class GetBuyFlowInitializationTokenRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
  private final int mVersionCode;
  byte[] zzbkG;
  byte[] zzbkH;
  
  GetBuyFlowInitializationTokenRequest()
  {
    this(1, null, null);
  }
  
  GetBuyFlowInitializationTokenRequest(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.mVersionCode = paramInt;
    this.zzbkG = paramArrayOfByte1;
    this.zzbkH = paramArrayOfByte2;
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
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/firstparty/GetBuyFlowInitializationTokenRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */