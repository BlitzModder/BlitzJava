package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

@Deprecated
public final class PlaceLocalization
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final String address;
  public final String name;
  public final int versionCode;
  public final String zzaNX;
  public final String zzaNY;
  public final List<String> zzaNZ;
  
  public PlaceLocalization(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.address = paramString2;
    this.zzaNX = paramString3;
    this.zzaNY = paramString4;
    this.zzaNZ = paramList;
  }
  
  public static PlaceLocalization zza(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    return new PlaceLocalization(0, paramString1, paramString2, paramString3, paramString4, paramList);
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLocalization)) {
        return false;
      }
      paramObject = (PlaceLocalization)paramObject;
    } while ((zzw.equal(this.name, ((PlaceLocalization)paramObject).name)) && (zzw.equal(this.address, ((PlaceLocalization)paramObject).address)) && (zzw.equal(this.zzaNX, ((PlaceLocalization)paramObject).zzaNX)) && (zzw.equal(this.zzaNY, ((PlaceLocalization)paramObject).zzaNY)) && (zzw.equal(this.zzaNZ, ((PlaceLocalization)paramObject).zzaNZ)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.name, this.address, this.zzaNX, this.zzaNY });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaNX).zzg("regularOpenHours", this.zzaNY).zzg("attributions", this.zzaNZ).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/PlaceLocalization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */