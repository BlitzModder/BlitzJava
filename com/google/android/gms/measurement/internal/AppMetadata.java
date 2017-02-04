package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class AppMetadata
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String packageName;
  public final int versionCode;
  public final String zzaKi;
  public final String zzaSn;
  public final String zzaSo;
  public final long zzaSp;
  public final long zzaSq;
  public final String zzaSr;
  public final boolean zzaSs;
  
  AppMetadata(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean)
  {
    this.versionCode = paramInt;
    this.packageName = paramString1;
    this.zzaSn = paramString2;
    this.zzaKi = paramString3;
    this.zzaSo = paramString4;
    this.zzaSp = paramLong1;
    this.zzaSq = paramLong2;
    this.zzaSr = paramString5;
    if (paramInt >= 3)
    {
      this.zzaSs = paramBoolean;
      return;
    }
    this.zzaSs = true;
  }
  
  AppMetadata(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, boolean paramBoolean)
  {
    zzx.zzcG(paramString1);
    this.versionCode = 3;
    this.packageName = paramString1;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    this.zzaSn = paramString1;
    this.zzaKi = paramString3;
    this.zzaSo = paramString4;
    this.zzaSp = paramLong1;
    this.zzaSq = paramLong2;
    this.zzaSr = paramString5;
    this.zzaSs = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/AppMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */