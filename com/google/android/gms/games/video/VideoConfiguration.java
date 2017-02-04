package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class VideoConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<VideoConfiguration> CREATOR = new VideoConfigurationCreator();
  private final int mVersionCode;
  private final int zzaIB;
  private final int zzaIC;
  private final String zzaID;
  private final String zzaIE;
  
  public VideoConfiguration(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt1;
    zzx.zzab(zzgQ(paramInt2));
    zzx.zzab(zzgR(paramInt3));
    this.zzaIB = paramInt2;
    this.zzaIC = paramInt3;
    if (paramInt3 == 1)
    {
      this.zzaIE = paramString2;
      this.zzaID = paramString1;
      return;
    }
    if (paramString2 == null)
    {
      bool1 = true;
      zzx.zzb(bool1, "Stream key should be null when not streaming");
      if (paramString1 != null) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Stream url should be null when not streaming");
      this.zzaIE = null;
      this.zzaID = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean zzgQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzgR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getStreamUrl()
  {
    return this.zzaID;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VideoConfigurationCreator.zza(this, paramParcel, paramInt);
  }
  
  public int zzxr()
  {
    return this.zzaIB;
  }
  
  public int zzxs()
  {
    return this.zzaIC;
  }
  
  public String zzxt()
  {
    return this.zzaIE;
  }
  
  public static final class Builder {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/video/VideoConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */