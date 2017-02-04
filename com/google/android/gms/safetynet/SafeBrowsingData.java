package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SafeBrowsingData
  implements SafeParcelable
{
  public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzb();
  public final int mVersionCode;
  private String zzbbi;
  
  SafeBrowsingData(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzbbi = paramString;
  }
  
  public SafeBrowsingData(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMetadata()
  {
    return this.zzbbi;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/safetynet/SafeBrowsingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */