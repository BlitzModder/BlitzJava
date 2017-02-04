package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzha
public final class zzfc
  implements MediationAdRequest
{
  private final int zzBH;
  private final Date zzaW;
  private final Set<String> zzaY;
  private final boolean zzaZ;
  private final Location zzba;
  private final int zztH;
  private final boolean zztT;
  
  public zzfc(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    this.zzaW = paramDate;
    this.zztH = paramInt1;
    this.zzaY = paramSet;
    this.zzba = paramLocation;
    this.zzaZ = paramBoolean1;
    this.zzBH = paramInt2;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */