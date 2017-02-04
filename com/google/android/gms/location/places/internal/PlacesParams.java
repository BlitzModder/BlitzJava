package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Locale;

public class PlacesParams
  implements SafeParcelable
{
  public static final zzt CREATOR = new zzt();
  public static final PlacesParams zzaOl = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
  public final int versionCode;
  public final String zzaNb;
  public final String zzaOm;
  public final String zzaOn;
  public final String zzaOo;
  public final int zzaOp;
  public final int zzaOq;
  
  public PlacesParams(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.versionCode = paramInt1;
    this.zzaOm = paramString1;
    this.zzaOn = paramString2;
    this.zzaOo = paramString3;
    this.zzaNb = paramString4;
    this.zzaOp = paramInt2;
    this.zzaOq = paramInt3;
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2)
  {
    this(3, paramString1, paramLocale.toString(), paramString2, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
  }
  
  public PlacesParams(String paramString1, Locale paramLocale, String paramString2, String paramString3, int paramInt)
  {
    this(3, paramString1, paramLocale.toString(), paramString2, paramString3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, paramInt);
  }
  
  public int describeContents()
  {
    zzt localzzt = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof PlacesParams))) {
        return false;
      }
      paramObject = (PlacesParams)paramObject;
    } while ((this.zzaOp == ((PlacesParams)paramObject).zzaOp) && (this.zzaOq == ((PlacesParams)paramObject).zzaOq) && (this.zzaOn.equals(((PlacesParams)paramObject).zzaOn)) && (this.zzaOm.equals(((PlacesParams)paramObject).zzaOm)) && (zzw.equal(this.zzaOo, ((PlacesParams)paramObject).zzaOo)) && (zzw.equal(this.zzaNb, ((PlacesParams)paramObject).zzaNb)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaOm, this.zzaOn, this.zzaOo, this.zzaNb, Integer.valueOf(this.zzaOp), Integer.valueOf(this.zzaOq) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("clientPackageName", this.zzaOm).zzg("locale", this.zzaOn).zzg("accountName", this.zzaOo).zzg("gCoreClientName", this.zzaNb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt localzzt = CREATOR;
    zzt.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/PlacesParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */