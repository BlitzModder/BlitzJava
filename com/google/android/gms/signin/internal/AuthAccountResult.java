package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();
  final int mVersionCode;
  private int zzbbS;
  private Intent zzbbT;
  
  public AuthAccountResult()
  {
    this(0, null);
  }
  
  AuthAccountResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mVersionCode = paramInt1;
    this.zzbbS = paramInt2;
    this.zzbbT = paramIntent;
  }
  
  public AuthAccountResult(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    if (this.zzbbS == 0) {
      return Status.zzaeX;
    }
    return Status.zzafb;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public int zzDR()
  {
    return this.zzbbS;
  }
  
  public Intent zzDS()
  {
    return this.zzbbT;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/signin/internal/AuthAccountResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */