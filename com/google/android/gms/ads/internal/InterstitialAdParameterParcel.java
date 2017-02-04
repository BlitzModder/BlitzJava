package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public final class InterstitialAdParameterParcel
  implements SafeParcelable
{
  public static final zzl CREATOR = new zzl();
  public final int versionCode;
  public final boolean zzqa;
  public final boolean zzqb;
  public final String zzqc;
  public final boolean zzqd;
  public final float zzqe;
  
  InterstitialAdParameterParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this.versionCode = paramInt;
    this.zzqa = paramBoolean1;
    this.zzqb = paramBoolean2;
    this.zzqc = paramString;
    this.zzqd = paramBoolean3;
    this.zzqe = paramFloat;
  }
  
  public InterstitialAdParameterParcel(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, float paramFloat)
  {
    this(2, paramBoolean1, paramBoolean2, paramString, paramBoolean3, paramFloat);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/InterstitialAdParameterParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */