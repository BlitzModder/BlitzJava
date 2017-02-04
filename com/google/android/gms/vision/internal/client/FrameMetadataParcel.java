package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Metadata;

public class FrameMetadataParcel
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public int height;
  public int id;
  public int rotation;
  final int versionCode;
  public int width;
  public long zzbiW;
  
  public FrameMetadataParcel()
  {
    this.versionCode = 1;
  }
  
  public FrameMetadataParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5)
  {
    this.versionCode = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.id = paramInt4;
    this.zzbiW = paramLong;
    this.rotation = paramInt5;
  }
  
  public static FrameMetadataParcel zzc(Frame paramFrame)
  {
    FrameMetadataParcel localFrameMetadataParcel = new FrameMetadataParcel();
    localFrameMetadataParcel.width = paramFrame.getMetadata().getWidth();
    localFrameMetadataParcel.height = paramFrame.getMetadata().getHeight();
    localFrameMetadataParcel.rotation = paramFrame.getMetadata().getRotation();
    localFrameMetadataParcel.id = paramFrame.getMetadata().getId();
    localFrameMetadataParcel.zzbiW = paramFrame.getMetadata().getTimestampMillis();
    return localFrameMetadataParcel;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/internal/client/FrameMetadataParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */