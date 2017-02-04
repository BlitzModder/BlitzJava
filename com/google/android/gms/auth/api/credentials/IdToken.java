package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zze();
  final int mVersionCode;
  private final String zzUB;
  private final String zzUN;
  
  IdToken(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzUB = paramString1;
    this.zzUN = paramString2;
  }
  
  public IdToken(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountType()
  {
    return this.zzUB;
  }
  
  public String getIdToken()
  {
    return this.zzUN;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/IdToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */