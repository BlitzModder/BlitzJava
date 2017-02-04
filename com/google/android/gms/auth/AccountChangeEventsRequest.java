package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
  final int mVersion;
  Account zzSo;
  @Deprecated
  String zzTD;
  int zzTF;
  
  public AccountChangeEventsRequest()
  {
    this.mVersion = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    this.mVersion = paramInt1;
    this.zzTF = paramInt2;
    this.zzTD = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      this.zzSo = new Account(paramString, "com.google");
      return;
    }
    this.zzSo = paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return this.zzSo;
  }
  
  public String getAccountName()
  {
    return this.zzTD;
  }
  
  public int getEventIndex()
  {
    return this.zzTF;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    this.zzSo = paramAccount;
    return this;
  }
  
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    this.zzTD = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    this.zzTF = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/AccountChangeEventsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */