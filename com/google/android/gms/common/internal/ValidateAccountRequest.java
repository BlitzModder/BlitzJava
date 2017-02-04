package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzae();
  final int mVersionCode;
  private final String zzUr;
  private final Scope[] zzaem;
  final IBinder zzaiS;
  private final int zzakH;
  private final Bundle zzakI;
  
  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.zzakH = paramInt2;
    this.zzaiS = paramIBinder;
    this.zzaem = paramArrayOfScope;
    this.zzakI = paramBundle;
    this.zzUr = paramString;
  }
  
  public ValidateAccountRequest(zzp paramzzp, Scope[] paramArrayOfScope, String paramString, Bundle paramBundle) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCallingPackage()
  {
    return this.zzUr;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzqN()
  {
    return this.zzaem;
  }
  
  public int zzqO()
  {
    return this.zzakH;
  }
  
  public Bundle zzqP()
  {
    return this.zzakI;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/ValidateAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */