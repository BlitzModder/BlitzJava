package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  private Boolean zzaOR;
  private Boolean zzaOS;
  private int zzaOT = -1;
  private CameraPosition zzaOU;
  private Boolean zzaOV;
  private Boolean zzaOW;
  private Boolean zzaOX;
  private Boolean zzaOY;
  private Boolean zzaOZ;
  private Boolean zzaPa;
  private Boolean zzaPb;
  private Boolean zzaPc;
  private Boolean zzaPd;
  
  public GoogleMapOptions()
  {
    this.mVersionCode = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10, byte paramByte11)
  {
    this.mVersionCode = paramInt1;
    this.zzaOR = com.google.android.gms.maps.internal.zza.zza(paramByte1);
    this.zzaOS = com.google.android.gms.maps.internal.zza.zza(paramByte2);
    this.zzaOT = paramInt2;
    this.zzaOU = paramCameraPosition;
    this.zzaOV = com.google.android.gms.maps.internal.zza.zza(paramByte3);
    this.zzaOW = com.google.android.gms.maps.internal.zza.zza(paramByte4);
    this.zzaOX = com.google.android.gms.maps.internal.zza.zza(paramByte5);
    this.zzaOY = com.google.android.gms.maps.internal.zza.zza(paramByte6);
    this.zzaOZ = com.google.android.gms.maps.internal.zza.zza(paramByte7);
    this.zzaPa = com.google.android.gms.maps.internal.zza.zza(paramByte8);
    this.zzaPb = com.google.android.gms.maps.internal.zza.zza(paramByte9);
    this.zzaPc = com.google.android.gms.maps.internal.zza.zza(paramByte10);
    this.zzaPd = com.google.android.gms.maps.internal.zza.zza(paramByte11);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_liteMode)) {
      localGoogleMapOptions.liteMode(localTypedArray.getBoolean(R.styleable.MapAttrs_liteMode, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
      localGoogleMapOptions.mapToolbarEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
      localGoogleMapOptions.ambientEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions ambientEnabled(boolean paramBoolean)
  {
    this.zzaPd = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.zzaOU = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.zzaOW = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getAmbientEnabled()
  {
    return this.zzaPd;
  }
  
  public CameraPosition getCamera()
  {
    return this.zzaOU;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.zzaOW;
  }
  
  public Boolean getLiteMode()
  {
    return this.zzaPb;
  }
  
  public Boolean getMapToolbarEnabled()
  {
    return this.zzaPc;
  }
  
  public int getMapType()
  {
    return this.zzaOT;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.zzaPa;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.zzaOX;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.zzaOZ;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.zzaOS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.zzaOR;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.zzaOV;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.zzaOY;
  }
  
  public GoogleMapOptions liteMode(boolean paramBoolean)
  {
    this.zzaPb = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapToolbarEnabled(boolean paramBoolean)
  {
    this.zzaPc = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.zzaOT = paramInt;
    return this;
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.zzaPa = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.zzaOX = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.zzaOZ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzaOS = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.zzaOR = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.zzaOV = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzaOY = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  byte zzyV()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOR);
  }
  
  byte zzyW()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOS);
  }
  
  byte zzyX()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOV);
  }
  
  byte zzyY()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOW);
  }
  
  byte zzyZ()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOX);
  }
  
  byte zzza()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOY);
  }
  
  byte zzzb()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaOZ);
  }
  
  byte zzzc()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaPa);
  }
  
  byte zzzd()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaPb);
  }
  
  byte zzze()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaPc);
  }
  
  byte zzzf()
  {
    return com.google.android.gms.maps.internal.zza.zze(this.zzaPd);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */