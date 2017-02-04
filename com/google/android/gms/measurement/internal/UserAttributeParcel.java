package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class UserAttributeParcel
  implements SafeParcelable
{
  public static final zzad CREATOR = new zzad();
  public final String name;
  public final int versionCode;
  public final String zzaSM;
  public final long zzaVg;
  public final Long zzaVh;
  public final Float zzaVi;
  public final String zzakS;
  
  UserAttributeParcel(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaVg = paramLong;
    this.zzaVh = paramLong1;
    this.zzaVi = paramFloat;
    this.zzakS = paramString2;
    this.zzaSM = paramString3;
  }
  
  UserAttributeParcel(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    zzx.zzcG(paramString1);
    this.versionCode = 1;
    this.name = paramString1;
    this.zzaVg = paramLong;
    this.zzaSM = paramString2;
    if (paramObject == null)
    {
      this.zzaVh = null;
      this.zzaVi = null;
      this.zzakS = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzaVh = ((Long)paramObject);
      this.zzaVi = null;
      this.zzakS = null;
      return;
    }
    if ((paramObject instanceof Float))
    {
      this.zzaVh = null;
      this.zzaVi = ((Float)paramObject);
      this.zzakS = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzaVh = null;
      this.zzaVi = null;
      this.zzakS = ((String)paramObject);
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object getValue()
  {
    if (this.zzaVh != null) {
      return this.zzaVh;
    }
    if (this.zzaVi != null) {
      return this.zzaVi;
    }
    if (this.zzakS != null) {
      return this.zzakS;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/UserAttributeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */