package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  private int mColor = -16777216;
  private final int mVersionCode;
  private final List<LatLng> zzaQL;
  private boolean zzaQN = false;
  private float zzaQj = 0.0F;
  private boolean zzaQk = true;
  private float zzaQo = 10.0F;
  
  public PolylineOptions()
  {
    this.mVersionCode = 1;
    this.zzaQL = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaQL = paramList;
    this.zzaQo = paramFloat1;
    this.mColor = paramInt2;
    this.zzaQj = paramFloat2;
    this.zzaQk = paramBoolean1;
    this.zzaQN = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.zzaQL.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.zzaQL.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.zzaQL.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.zzaQN = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public List<LatLng> getPoints()
  {
    return this.zzaQL;
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
  
  public boolean isGeodesic()
  {
    return this.zzaQN;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.zzaQo = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.zzaQj = paramFloat;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */