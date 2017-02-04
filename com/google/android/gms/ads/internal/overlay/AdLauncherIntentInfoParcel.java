package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public final class AdLauncherIntentInfoParcel
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String intentAction;
  public final String mimeType;
  public final String packageName;
  public final String url;
  public final int versionCode;
  public final String zzCK;
  public final String zzCL;
  public final String zzCM;
  
  public AdLauncherIntentInfoParcel(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.versionCode = paramInt;
    this.intentAction = paramString1;
    this.url = paramString2;
    this.mimeType = paramString3;
    this.packageName = paramString4;
    this.zzCK = paramString5;
    this.zzCL = paramString6;
    this.zzCM = paramString7;
  }
  
  public AdLauncherIntentInfoParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/AdLauncherIntentInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */