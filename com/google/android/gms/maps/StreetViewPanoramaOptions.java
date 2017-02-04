package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private Boolean zzaOS;
  private Boolean zzaOY = Boolean.valueOf(true);
  private StreetViewPanoramaCamera zzaPF;
  private String zzaPG;
  private LatLng zzaPH;
  private Integer zzaPI;
  private Boolean zzaPJ = Boolean.valueOf(true);
  private Boolean zzaPK = Boolean.valueOf(true);
  private Boolean zzaPL = Boolean.valueOf(true);
  
  public StreetViewPanoramaOptions()
  {
    this.mVersionCode = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.mVersionCode = paramInt;
    this.zzaPF = paramStreetViewPanoramaCamera;
    this.zzaPH = paramLatLng;
    this.zzaPI = paramInteger;
    this.zzaPG = paramString;
    this.zzaPJ = zza.zza(paramByte1);
    this.zzaOY = zza.zza(paramByte2);
    this.zzaPK = zza.zza(paramByte3);
    this.zzaPL = zza.zza(paramByte4);
    this.zzaOS = zza.zza(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.zzaPK;
  }
  
  public String getPanoramaId()
  {
    return this.zzaPG;
  }
  
  public LatLng getPosition()
  {
    return this.zzaPH;
  }
  
  public Integer getRadius()
  {
    return this.zzaPI;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.zzaPL;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.zzaPF;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.zzaOS;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.zzaPJ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.zzaOY;
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.zzaPK = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.zzaPF = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.zzaPG = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.zzaPH = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.zzaPH = paramLatLng;
    this.zzaPI = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.zzaPL = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzaOS = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.zzaPJ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzaOY = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  byte zzyW()
  {
    return zza.zze(this.zzaOS);
  }
  
  byte zzza()
  {
    return zza.zze(this.zzaOY);
  }
  
  byte zzzl()
  {
    return zza.zze(this.zzaPJ);
  }
  
  byte zzzm()
  {
    return zza.zze(this.zzaPK);
  }
  
  byte zzzn()
  {
    return zza.zze(this.zzaPL);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */