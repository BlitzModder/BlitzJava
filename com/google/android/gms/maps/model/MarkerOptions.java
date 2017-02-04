package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private float mAlpha = 1.0F;
  private final int mVersionCode;
  private LatLng zzaPH;
  private String zzaQB;
  private BitmapDescriptor zzaQC;
  private boolean zzaQD;
  private boolean zzaQE = false;
  private float zzaQF = 0.0F;
  private float zzaQG = 0.5F;
  private float zzaQH = 0.0F;
  private boolean zzaQk = true;
  private float zzaQs = 0.5F;
  private float zzaQt = 1.0F;
  private String zzank;
  
  public MarkerOptions()
  {
    this.mVersionCode = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.mVersionCode = paramInt;
    this.zzaPH = paramLatLng;
    this.zzank = paramString1;
    this.zzaQB = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(zzd.zza.zzbs(paramIBinder)))
    {
      this.zzaQC = paramLatLng;
      this.zzaQs = paramFloat1;
      this.zzaQt = paramFloat2;
      this.zzaQD = paramBoolean1;
      this.zzaQk = paramBoolean2;
      this.zzaQE = paramBoolean3;
      this.zzaQF = paramFloat3;
      this.zzaQG = paramFloat4;
      this.zzaQH = paramFloat5;
      this.mAlpha = paramFloat6;
      return;
    }
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzaQs = paramFloat1;
    this.zzaQt = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.zzaQD = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.zzaQE = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.zzaQs;
  }
  
  public float getAnchorV()
  {
    return this.zzaQt;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.zzaQC;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.zzaQG;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.zzaQH;
  }
  
  public LatLng getPosition()
  {
    return this.zzaPH;
  }
  
  public float getRotation()
  {
    return this.zzaQF;
  }
  
  public String getSnippet()
  {
    return this.zzaQB;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.zzaQC = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.zzaQG = paramFloat1;
    this.zzaQH = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.zzaQD;
  }
  
  public boolean isFlat()
  {
    return this.zzaQE;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.zzaPH = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.zzaQF = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.zzaQB = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.zzank = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzzv()
  {
    if (this.zzaQC == null) {
      return null;
    }
    return this.zzaQC.zzyS().asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */