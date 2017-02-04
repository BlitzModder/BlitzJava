package com.tune.crosspromo;

import android.location.Location;
import com.mobileapptracker.MATGender;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class TuneAdMetadata
{
  private Date mBirthDate = null;
  private Map<String, String> mCustomTargets = null;
  private boolean mDebugMode = false;
  private MATGender mGender = MATGender.UNKNOWN;
  private Set<String> mKeywords = null;
  private double mLatitude;
  private Location mLocation = null;
  private double mLongitude;
  
  public boolean addKeyword(String paramString)
  {
    if (this.mKeywords == null) {
      this.mKeywords = new HashSet();
    }
    return this.mKeywords.add(paramString);
  }
  
  public Date getBirthDate()
  {
    return this.mBirthDate;
  }
  
  public Map<String, String> getCustomTargets()
  {
    return this.mCustomTargets;
  }
  
  public MATGender getGender()
  {
    return this.mGender;
  }
  
  public Set<String> getKeywords()
  {
    return this.mKeywords;
  }
  
  public double getLatitude()
  {
    return this.mLatitude;
  }
  
  public Location getLocation()
  {
    return this.mLocation;
  }
  
  public double getLongitude()
  {
    return this.mLongitude;
  }
  
  public boolean isInDebugMode()
  {
    return this.mDebugMode;
  }
  
  public boolean removeKeyword(String paramString)
  {
    if (this.mKeywords == null)
    {
      this.mKeywords = new HashSet();
      return false;
    }
    return this.mKeywords.remove(paramString);
  }
  
  public TuneAdMetadata withBirthDate(int paramInt1, int paramInt2, int paramInt3)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    localGregorianCalendar.clear();
    localGregorianCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    this.mBirthDate = localGregorianCalendar.getTime();
    return this;
  }
  
  public TuneAdMetadata withBirthDate(Date paramDate)
  {
    this.mBirthDate = paramDate;
    return this;
  }
  
  public TuneAdMetadata withCustomTargets(Map<String, String> paramMap)
  {
    this.mCustomTargets = paramMap;
    return this;
  }
  
  public TuneAdMetadata withDebugMode(boolean paramBoolean)
  {
    this.mDebugMode = paramBoolean;
    return this;
  }
  
  public TuneAdMetadata withGender(MATGender paramMATGender)
  {
    this.mGender = paramMATGender;
    return this;
  }
  
  public TuneAdMetadata withKeywords(Set<String> paramSet)
  {
    this.mKeywords = paramSet;
    return this;
  }
  
  public TuneAdMetadata withLocation(double paramDouble1, double paramDouble2)
  {
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
    return this;
  }
  
  public TuneAdMetadata withLocation(Location paramLocation)
  {
    this.mLocation = paramLocation;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAdMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */