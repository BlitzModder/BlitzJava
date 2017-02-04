package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final int mVersionCode;
  private final List<LatLng> zzaQL;
  private final List<List<LatLng>> zzaQM;
  private boolean zzaQN = false;
  private float zzaQg = 10.0F;
  private int zzaQh = -16777216;
  private int zzaQi = 0;
  private float zzaQj = 0.0F;
  private boolean zzaQk = true;
  
  public PolygonOptions()
  {
    this.mVersionCode = 1;
    this.zzaQL = new ArrayList();
    this.zzaQM = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaQL = paramList;
    this.zzaQM = paramList1;
    this.zzaQg = paramFloat1;
    this.zzaQh = paramInt2;
    this.zzaQi = paramInt3;
    this.zzaQj = paramFloat2;
    this.zzaQk = paramBoolean1;
    this.zzaQN = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.zzaQL.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.zzaQL.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.zzaQL.add(localLatLng);
    }
    return this;
  }
  
  public PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((LatLng)paramIterable.next());
    }
    this.zzaQM.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.zzaQi = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.zzaQN = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.zzaQi;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.zzaQM;
  }
  
  public List<LatLng> getPoints()
  {
    return this.zzaQL;
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
  
  public boolean isGeodesic()
  {
    return this.zzaQN;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.zzaQh = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.zzaQg = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.zzaQj = paramFloat;
    return this;
  }
  
  List zzzw()
  {
    return this.zzaQM;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */