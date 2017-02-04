package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class LargeAssetEnqueueRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeAssetEnqueueRequest> CREATOR = new zzbd();
  final int mVersionCode;
  public final Uri zzaXR;
  public final String zzbnJ;
  public final String zzbnK;
  public final String zzbnL;
  public final boolean zzbnM;
  public final boolean zzbnN;
  public final boolean zzbnO;
  
  LargeAssetEnqueueRequest(int paramInt, String paramString1, String paramString2, Uri paramUri, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mVersionCode = paramInt;
    this.zzbnJ = ((String)zzx.zzy(paramString1));
    this.zzbnK = ((String)zzx.zzy(paramString2));
    this.zzaXR = ((Uri)zzx.zzy(paramUri));
    this.zzbnL = ((String)zzx.zzy(paramString3));
    this.zzbnM = paramBoolean1;
    this.zzbnN = paramBoolean2;
    this.zzbnO = paramBoolean3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LargeAssetEnqueueRequest)) {
        return false;
      }
      paramObject = (LargeAssetEnqueueRequest)paramObject;
    } while ((this.mVersionCode == ((LargeAssetEnqueueRequest)paramObject).mVersionCode) && (this.zzbnJ.equals(((LargeAssetEnqueueRequest)paramObject).zzbnJ)) && (this.zzbnK.equals(((LargeAssetEnqueueRequest)paramObject).zzbnK)) && (this.zzaXR.equals(((LargeAssetEnqueueRequest)paramObject).zzaXR)) && (this.zzbnL.equals(((LargeAssetEnqueueRequest)paramObject).zzbnL)) && (this.zzbnM == ((LargeAssetEnqueueRequest)paramObject).zzbnM) && (this.zzbnN == ((LargeAssetEnqueueRequest)paramObject).zzbnN) && (this.zzbnO == ((LargeAssetEnqueueRequest)paramObject).zzbnO));
    return false;
  }
  
  public int hashCode()
  {
    int k = 1;
    int m = this.mVersionCode;
    int n = this.zzbnJ.hashCode();
    int i1 = this.zzbnK.hashCode();
    int i2 = this.zzaXR.hashCode();
    int i3 = this.zzbnL.hashCode();
    int i;
    int j;
    if (this.zzbnM)
    {
      i = 1;
      if (!this.zzbnN) {
        break label116;
      }
      j = 1;
      label62:
      if (!this.zzbnO) {
        break label121;
      }
    }
    for (;;)
    {
      return (j + (i + ((((m * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31) * 31 + k;
      i = 0;
      break;
      label116:
      j = 0;
      break label62;
      label121:
      k = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("LargeAssetEnqueueRequest{, nodeId='").append(this.zzbnJ).append("'").append(", path='").append(this.zzbnK).append("'").append(", destinationUri='").append(this.zzaXR).append("'").append(", destinationCanonicalPath='").append(this.zzbnL).append("'").append(", append=").append(this.zzbnM);
    if (this.zzbnN)
    {
      str = ", allowedOverMetered=true";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.zzbnO) {
        break label134;
      }
    }
    label134:
    for (String str = ", allowedWithLowBattery=true";; str = "")
    {
      return str + "}";
      str = "";
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetEnqueueRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */