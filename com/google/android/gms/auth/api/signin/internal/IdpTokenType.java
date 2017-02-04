package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class IdpTokenType
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdpTokenType> CREATOR = new zzi();
  public static final IdpTokenType zzWc = new IdpTokenType("accessToken");
  public static final IdpTokenType zzWd = new IdpTokenType("idToken");
  final int versionCode;
  private final String zzWe;
  
  IdpTokenType(int paramInt, String paramString)
  {
    this.versionCode = paramInt;
    this.zzWe = zzx.zzcG(paramString);
  }
  
  private IdpTokenType(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {}
    try
    {
      boolean bool3 = this.zzWe.equals(((IdpTokenType)paramObject).zzmN());
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return this.zzWe.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public String zzmN()
  {
    return this.zzWe;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/IdpTokenType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */