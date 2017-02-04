package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private LatLng zzaQe = null;
  private double zzaQf = 0.0D;
  private float zzaQg = 10.0F;
  private int zzaQh = -16777216;
  private int zzaQi = 0;
  private float zzaQj = 0.0F;
  private boolean zzaQk = true;
  
  public CircleOptions()
  {
    this.mVersionCode = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzaQe = paramLatLng;
    this.zzaQf = paramDouble;
    this.zzaQg = paramFloat1;
    this.zzaQh = paramInt2;
    this.zzaQi = paramInt3;
    this.zzaQj = paramFloat2;
    this.zzaQk = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.zzaQe = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.zzaQi = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.zzaQe;
  }
  
  public int getFillColor()
  {
    return this.zzaQi;
  }
  
  public double getRadius()
  {
    return this.zzaQf;
  }
  
  public int getStrokeColor()
  {
    return this.zzaQh;
  }
  
  public float getStrokeWidth()
  {
    return this.zzaQg;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getZIndex()
  {
    return this.zzaQj;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.zzaQf = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.zzaQh = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.zzaQg = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.zzaQj = paramFloat;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */