package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzha
public final class zzfh
  implements NativeMediationAdRequest
{
  private final int zzBH;
  private final Date zzaW;
  private final Set<String> zzaY;
  private final boolean zzaZ;
  private final Location zzba;
  private final NativeAdOptionsParcel zzpE;
  private final List<String> zzpF;
  private final int zztH;
  private final boolean zztT;
  
  public zzfh(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList, boolean paramBoolean2)
  {
    this.zzaW = paramDate;
    this.zztH = paramInt1;
    this.zzaY = paramSet;
    this.zzba = paramLocation;
    this.zzaZ = paramBoolean1;
    this.zzBH = paramInt2;
    this.zzpE = paramNativeAdOptionsParcel;
    this.zzpF = paramList;
    this.zztT = paramBoolean2;
  }
  
  public Date getBirthday()
  {
    return this.zzaW;
  }
  
  public int getGender()
  {
    return this.zztH;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaY;
  }
  
  public Location getLocation()
  {
    return this.zzba;
  }
  
  public NativeAdOptions getNativeAdOptions()
  {
    if (this.zzpE == null) {
      return null;
    }
    return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzpE.zzyc).setImageOrientation(this.zzpE.zzyd).setRequestMultipleImages(this.zzpE.zzye).build();
  }
  
  public boolean isAppInstallAdRequested()
  {
    return (this.zzpF != null) && (this.zzpF.contains("2"));
  }
  
  public boolean isContentAdRequested()
  {
    return (this.zzpF != null) && (this.zzpF.contains("1"));
  }
  
  public boolean isDesignedForFamilies()
  {
    return this.zztT;
  }
  
  public boolean isTesting()
  {
    return this.zzaZ;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return this.zzBH;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */