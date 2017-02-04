package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class LargeAssetSyncRequestPayload
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeAssetSyncRequestPayload> CREATOR = new zzbk();
  final int versionCode;
  public final String zzbnK;
  public final long zzbom;
  
  public LargeAssetSyncRequestPayload(int paramInt, String paramString, long paramLong)
  {
    this.versionCode = paramInt;
    this.zzbnK = ((String)zzx.zzb(paramString, "path"));
    this.zzbom = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LargeAssetSyncRequestPayload{path='" + this.zzbnK + "'" + ", offset=" + this.zzbom + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/LargeAssetSyncRequestPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */