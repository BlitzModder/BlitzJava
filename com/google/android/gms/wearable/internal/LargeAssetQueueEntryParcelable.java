package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;

public final class LargeAssetQueueEntryParcelable
  implements SafeParcelable, LargeAssetApi.zzb
{
  public static final Parcelable.Creator<LargeAssetQueueEntryParcelable> CREATOR = new zzbf();
  private final String mPath;
  private final int mState;
  final int mVersionCode;
  private final String zzblS;
  private final long zzbnQ;
  private final Uri zzbnR;
  private final int zzbnS;
  private final boolean zzbnT;
  private final boolean zzbnU;
  private final boolean zzbnV;
  
  LargeAssetQueueEntryParcelable(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, Uri paramUri, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mVersionCode = paramInt1;
    this.zzbnQ = paramLong;
    this.mState = paramInt2;
    this.mPath = ((String)zzx.zzb(paramString1, "path"));
    this.zzblS = ((String)zzx.zzb(paramString2, "nodeId"));
    this.zzbnR = ((Uri)zzx.zzb(paramUri, "destinationUri"));
    this.zzbnS = paramInt3;
    this.zzbnT = paramBoolean1;
    this.zzbnU = paramBoolean2;
    this.zzbnV = paramBoolean3;
  }
  
  public LargeAssetQueueEntryParcelable(long paramLong, int paramInt1, String paramString1, String paramString2, Uri paramUri, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(1, paramLong, paramInt1, paramString1, paramString2, paramUri, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LargeAssetQueueEntryParcelable)) {
        return false;
      }
      paramObject = (LargeAssetQueueEntryParcelable)paramObject;
    } while ((this.mVersionCode == ((LargeAssetQueueEntryParcelable)paramObject).mVersionCode) && (this.zzbnQ == ((LargeAssetQueueEntryParcelable)paramObject).zzbnQ) && (this.mState == ((LargeAssetQueueEntryParcelable)paramObject).mState) && (this.mPath.equals(((LargeAssetQueueEntryParcelable)paramObject).mPath)) && (this.zzblS.equals(((LargeAssetQueueEntryParcelable)paramObject).zzblS)) && (this.zzbnR.equals(((LargeAssetQueueEntryParcelable)paramObject).zzbnR)) && (this.zzbnT == ((LargeAssetQueueEntryParcelable)paramObject).zzbnT) && (this.zzbnU == ((LargeAssetQueueEntryParcelable)paramObject).zzbnU) && (this.zzbnV == ((LargeAssetQueueEntryParcelable)paramObject).zzbnV) && (this.zzbnS == ((LargeAssetQueueEntryParcelable)paramObject).zzbnS));
    return false;
  }
  
  public String getNodeId()
  {
    return this.zzblS;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public final int hashCode()
  {
    int k = 1;
    int m = this.mVersionCode;
    int n = (int)(this.zzbnQ ^ this.zzbnQ >>> 32);
    int i1 = this.mState;
    int i2 = this.mPath.hashCode();
    int i3 = this.zzblS.hashCode();
    int i4 = this.zzbnR.hashCode();
    int i;
    int j;
    if (this.zzbnT)
    {
      i = 1;
      if (!this.zzbnU) {
        break label142;
      }
      j = 1;
      label74:
      if (!this.zzbnV) {
        break label147;
      }
    }
    for (;;)
    {
      return ((j + (i + (((((m * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31) * 31 + k) * 31 + this.zzbnS;
      i = 0;
      break;
      label142:
      j = 0;
      break label74;
      label147:
      k = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("QueueEntry{versionCode=").append(this.mVersionCode).append(", transferId=").append(this.zzbnQ).append(", state=").append(this.mState).append(", path='").append(this.mPath).append("'").append(", nodeId='").append(this.zzblS).append("'").append(", destinationUri='").append(this.zzbnR).append("'");
    if (this.zzbnT)
    {
      str = ", append=true";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.zzbnU) {
        break label169;
      }
      str = ", allowedOverMetered=true";
      label121:
      localStringBuilder = localStringBuilder.append(str);
      if (!this.zzbnV) {
        break label175;
      }
    }
    label169:
    label175:
    for (String str = ", allowedWithLowBattery=true";; str = "")
    {
      return str + ", refuseErrorCode=" + this.zzbnS + "}";
      str = "";
      break;
      str = "";
      break label121;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbf.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzCO()
  {
    return this.zzbnR;
  }
  
  public long zzGQ()
  {
    return this.zzbnQ;
  }
  
  public boolean zzGR()
  {
    return this.zzbnT;
  }
  
  public boolean zzGS()
  {
    return this.zzbnU;
  }
  
  public boolean zzGT()
  {
    return this.zzbnV;
  }
  
  public int zzGU()
  {
    return this.zzbnS;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetQueueEntryParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */