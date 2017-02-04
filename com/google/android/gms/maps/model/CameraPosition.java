package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public final class CameraPosition
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final float bearing;
  private final int mVersionCode;
  public final LatLng target;
  public final float tilt;
  public final float zoom;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    zzx.zzb(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[] { Float.valueOf(paramFloat2) });
      this.mVersionCode = paramInt;
      this.target = paramLatLng;
      this.zoom = paramFloat1;
      this.tilt = (paramFloat2 + 0.0F);
      paramFloat1 = paramFloat3;
      if (paramFloat3 <= 0.0D) {
        paramFloat1 = paramFloat3 % 360.0F + 360.0F;
      }
      this.bearing = (paramFloat1 % 360.0F);
      return;
    }
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static CameraPosition createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    if (paramContext.hasValue(R.styleable.MapAttrs_cameraTargetLat)) {}
    for (float f1 = paramContext.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0F);; f1 = 0.0F)
    {
      if (paramContext.hasValue(R.styleable.MapAttrs_cameraTargetLng)) {}
      for (float f2 = paramContext.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0F);; f2 = 0.0F)
      {
        paramAttributeSet = new LatLng(f1, f2);
        Builder localBuilder = builder();
        localBuilder.target(paramAttributeSet);
        if (paramContext.hasValue(R.styleable.MapAttrs_cameraZoom)) {
          localBuilder.zoom(paramContext.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0F));
        }
        if (paramContext.hasValue(R.styleable.MapAttrs_cameraBearing)) {
          localBuilder.bearing(paramContext.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0F));
        }
        if (paramContext.hasValue(R.styleable.MapAttrs_cameraTilt)) {
          localBuilder.tilt(paramContext.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0F));
        }
        return localBuilder.build();
      }
    }
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((this.target.equals(((CameraPosition)paramObject).target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(((CameraPosition)paramObject).zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(((CameraPosition)paramObject).tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((CameraPosition)paramObject).bearing)));
    return false;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing) });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("target", this.target).zzg("zoom", Float.valueOf(this.zoom)).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LatLng zzaPZ;
    private float zzaQa;
    private float zzaQb;
    private float zzaQc;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.zzaPZ = paramCameraPosition.target;
      this.zzaQa = paramCameraPosition.zoom;
      this.zzaQb = paramCameraPosition.tilt;
      this.zzaQc = paramCameraPosition.bearing;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.zzaQc = paramFloat;
      return this;
    }
    
    public CameraPosition build()
    {
      return new CameraPosition(this.zzaPZ, this.zzaQa, this.zzaQb, this.zzaQc);
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.zzaPZ = paramLatLng;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.zzaQb = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.zzaQa = paramFloat;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */