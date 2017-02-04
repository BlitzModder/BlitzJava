package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzg();
  final int mVersionCode;
  private final Account zzSo;
  private final String zzVG;
  private final Scope[] zzbbW;
  
  RecordConsentRequest(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzSo = paramAccount;
    this.zzbbW = paramArrayOfScope;
    this.zzVG = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return this.zzSo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzDT()
  {
    return this.zzbbW;
  }
  
  public String zzmB()
  {
    return this.zzVG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/signin/internal/RecordConsentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */