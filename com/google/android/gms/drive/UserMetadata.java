package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserMetadata> CREATOR = new zzk();
  final int mVersionCode;
  final String zzVu;
  final String zzanw;
  final String zzanx;
  final boolean zzany;
  final String zzanz;
  
  UserMetadata(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.mVersionCode = paramInt;
    this.zzanw = paramString1;
    this.zzVu = paramString2;
    this.zzanx = paramString3;
    this.zzany = paramBoolean;
    this.zzanz = paramString4;
  }
  
  public UserMetadata(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramBoolean, paramString4);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[] { this.zzanw, this.zzVu, this.zzanx, Boolean.valueOf(this.zzany), this.zzanz });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/UserMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */