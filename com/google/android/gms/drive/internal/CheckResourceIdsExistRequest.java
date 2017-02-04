package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CheckResourceIdsExistRequest> CREATOR = new zzg();
  private final int mVersionCode;
  private final List<String> zzaog;
  
  CheckResourceIdsExistRequest(int paramInt, List<String> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzaog = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzsD()
  {
    return this.zzaog;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/CheckResourceIdsExistRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */