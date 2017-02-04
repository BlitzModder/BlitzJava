package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class AppContentReceivedResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();
  private int statusCode;
  private final int versionCode;
  private Uri zzaXR;
  
  private AppContentReceivedResult()
  {
    this.versionCode = 1;
  }
  
  AppContentReceivedResult(int paramInt1, Uri paramUri, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzaXR = paramUri;
    this.statusCode = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AppContentReceivedResult)) {
        return false;
      }
      paramObject = (AppContentReceivedResult)paramObject;
    } while ((zzw.equal(this.zzaXR, ((AppContentReceivedResult)paramObject).zzaXR)) && (zzw.equal(Integer.valueOf(this.statusCode), Integer.valueOf(((AppContentReceivedResult)paramObject).statusCode))));
    return false;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  int getVersionCode()
  {
    return this.versionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaXR, Integer.valueOf(this.statusCode) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzCO()
  {
    return this.zzaXR;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/sharing/AppContentReceivedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */