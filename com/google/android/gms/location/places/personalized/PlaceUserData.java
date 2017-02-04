package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

public class PlaceUserData
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  final int mVersionCode;
  private final String zzTD;
  private final String zzaMO;
  private final List<PlaceAlias> zzaOv;
  
  PlaceUserData(int paramInt, String paramString1, String paramString2, List<PlaceAlias> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzTD = paramString1;
    this.zzaMO = paramString2;
    this.zzaOv = paramList;
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceUserData)) {
        return false;
      }
      paramObject = (PlaceUserData)paramObject;
    } while ((this.zzTD.equals(((PlaceUserData)paramObject).zzTD)) && (this.zzaMO.equals(((PlaceUserData)paramObject).zzaMO)) && (this.zzaOv.equals(((PlaceUserData)paramObject).zzaOv)));
    return false;
  }
  
  public String getPlaceId()
  {
    return this.zzaMO;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTD, this.zzaMO, this.zzaOv });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("accountName", this.zzTD).zzg("placeId", this.zzaMO).zzg("placeAliases", this.zzaOv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public String zzyQ()
  {
    return this.zzTD;
  }
  
  public List<PlaceAlias> zzyR()
  {
    return this.zzaOv;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/personalized/PlaceUserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */