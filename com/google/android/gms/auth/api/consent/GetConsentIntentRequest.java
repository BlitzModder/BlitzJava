package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final Account zzSo;
  private final String zzUr;
  private final int zzUs;
  private final String zzUt;
  final ScopeDetail[] zzUu;
  private final boolean zzUv;
  private final int zzUw;
  private final String zzUx;
  
  GetConsentIntentRequest(int paramInt1, String paramString1, int paramInt2, String paramString2, Account paramAccount, ScopeDetail[] paramArrayOfScopeDetail, boolean paramBoolean, int paramInt3, String paramString3)
  {
    this.mVersionCode = paramInt1;
    this.zzUr = paramString1;
    this.zzUs = paramInt2;
    this.zzUt = paramString2;
    this.zzSo = ((Account)zzx.zzy(paramAccount));
    this.zzUu = paramArrayOfScopeDetail;
    this.zzUv = paramBoolean;
    this.zzUw = paramInt3;
    this.zzUx = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return this.zzSo;
  }
  
  public String getCallingPackage()
  {
    return this.zzUr;
  }
  
  public int getCallingUid()
  {
    return this.zzUs;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzmc()
  {
    return this.zzUt;
  }
  
  public boolean zzmd()
  {
    return this.zzUv;
  }
  
  public int zzme()
  {
    return this.zzUw;
  }
  
  public String zzmf()
  {
    return this.zzUx;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/consent/GetConsentIntentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */