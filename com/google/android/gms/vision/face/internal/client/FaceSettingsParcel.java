package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceSettingsParcel
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public int mode;
  public final int versionCode;
  public int zzbiO;
  public int zzbiP;
  public boolean zzbiQ;
  public boolean zzbiR;
  
  public FaceSettingsParcel()
  {
    this.versionCode = 1;
  }
  
  public FaceSettingsParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt1;
    this.mode = paramInt2;
    this.zzbiO = paramInt3;
    this.zzbiP = paramInt4;
    this.zzbiQ = paramBoolean1;
    this.zzbiR = paramBoolean2;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/internal/client/FaceSettingsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */