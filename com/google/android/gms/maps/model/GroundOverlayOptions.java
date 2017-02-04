package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public static final float NO_DIMENSION = -1.0F;
  private final int mVersionCode;
  private float zzaQc;
  private float zzaQj;
  private boolean zzaQk = true;
  private BitmapDescriptor zzaQm;
  private LatLng zzaQn;
  private float zzaQo;
  private float zzaQp;
  private LatLngBounds zzaQq;
  private float zzaQr = 0.0F;
  private float zzaQs = 0.5F;
  private float zzaQt = 0.5F;
  
  public GroundOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.mVersionCode = paramInt;
    this.zzaQm = new BitmapDescriptor(zzd.zza.zzbs(paramIBinder));
    this.zzaQn = paramLatLng;
    this.zzaQo = paramFloat1;
    this.zzaQp = paramFloat2;
    this.zzaQq = paramLatLngBounds;
    this.zzaQc = paramFloat3;
    this.zzaQj = paramFloat4;
    this.zzaQk = paramBoolean;
    this.zzaQr = paramFloat5;
    this.zzaQs = paramFloat6;
    this.zzaQt = paramFloat7;
  }
  
  private GroundOverlayOptions zza(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.zzaQn = paramLatLng;
    this.zzaQo = paramFloat1;
    this.zzaQp = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzaQs = paramFloat1;
    this.zzaQt = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.zzaQc = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.zzaQs;
  }
  
  public float getAnchorV()
  {
    return this.zzaQt;
  }
  
  public float getBearing()
  {
    return this.zzaQc;
  }
  
  public LatLngBounds getBounds()
  {
    return this.zzaQq;
  }
  
  public float getHeight()
  {
    return this.zzaQp;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.zzaQm;
  }
  
  public LatLng getLocation()
  {
    return this.zzaQn;
  }
  
  public float getTransparency()
  {
    return this.zzaQr;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getWidth()
  {
    return this.zzaQo;
  }
  
  public float getZIndex()
  {
    return this.zzaQj;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.zzaQm = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.zzaQq == null)
    {
      bool1 = true;
      zzx.zza(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      zzx.zzb(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Width must be non-negative");
      return zza(paramLatLng, paramFloat, -1.0F);
      bool1 = false;
      break;
      bool1 = false;
      break label24;
    }
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    if (this.zzaQq == null)
    {
      bool1 = true;
      zzx.zza(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      zzx.zzb(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      zzx.zzb(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Height must be non-negative");
      return zza(paramLatLng, paramFloat1, paramFloat2);
      bool1 = false;
      break;
      bool1 = false;
      break label27;
      bool1 = false;
      break label43;
    }
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.zzaQn == null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Position has already been set using position: " + this.zzaQn);
      this.zzaQq = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Transparency must be in the range [0..1]");
      this.zzaQr = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.zzaQj = paramFloat;
    return this;
  }
  
  IBinder zzzu()
  {
    return this.zzaQm.zzyS().asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */