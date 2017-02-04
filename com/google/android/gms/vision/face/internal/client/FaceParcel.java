package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final float centerX;
  public final float centerY;
  public final float height;
  public final int id;
  public final int versionCode;
  public final float width;
  public final float zzbiI;
  public final float zzbiJ;
  public final LandmarkParcel[] zzbiK;
  public final float zzbiL;
  public final float zzbiM;
  public final float zzbiN;
  
  public FaceParcel(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, LandmarkParcel[] paramArrayOfLandmarkParcel, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.versionCode = paramInt1;
    this.id = paramInt2;
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    this.zzbiI = paramFloat5;
    this.zzbiJ = paramFloat6;
    this.zzbiK = paramArrayOfLandmarkParcel;
    this.zzbiL = paramFloat7;
    this.zzbiM = paramFloat8;
    this.zzbiN = paramFloat9;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/internal/client/FaceParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */