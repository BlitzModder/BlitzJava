package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
  private final String mTag;
  final int mVersionCode;
  private final String zzaMO;
  private final String zzaMP;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzaMO = paramString1;
    this.mTag = paramString2;
    this.zzaMP = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzi(paramString1, paramString2, "unknown");
  }
  
  private static boolean zzdV(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static PlaceReport zzi(String paramString1, String paramString2, String paramString3)
  {
    zzx.zzy(paramString1);
    zzx.zzcG(paramString2);
    zzx.zzcG(paramString3);
    zzx.zzb(zzdV(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzw.equal(this.zzaMO, ((PlaceReport)paramObject).zzaMO)) || (!zzw.equal(this.mTag, ((PlaceReport)paramObject).mTag)) || (!zzw.equal(this.zzaMP, ((PlaceReport)paramObject).zzaMP)));
    return true;
  }
  
  public String getPlaceId()
  {
    return this.zzaMO;
  }
  
  public String getSource()
  {
    return this.zzaMP;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaMO, this.mTag, this.zzaMP });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this);
    localzza.zzg("placeId", this.zzaMO);
    localzza.zzg("tag", this.mTag);
    if (!"unknown".equals(this.zzaMP)) {
      localzza.zzg("source", this.zzaMP);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/PlaceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */