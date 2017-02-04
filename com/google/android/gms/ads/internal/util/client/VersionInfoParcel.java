package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public final class VersionInfoParcel
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public String afmaVersion;
  public final int versionCode;
  public int zzLF;
  public int zzLG;
  public boolean zzLH;
  
  public VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  VersionInfoParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.afmaVersion = paramString;
    this.zzLF = paramInt2;
    this.zzLG = paramInt3;
    this.zzLH = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/util/client/VersionInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */