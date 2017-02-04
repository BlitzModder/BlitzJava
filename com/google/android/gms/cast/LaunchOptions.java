package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzd();
  private final int mVersionCode;
  private boolean zzZd;
  private String zzZe;
  
  public LaunchOptions()
  {
    this(1, false, zzf.zzb(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzZd = paramBoolean;
    this.zzZe = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof LaunchOptions)) {
        return false;
      }
      paramObject = (LaunchOptions)paramObject;
    } while ((this.zzZd == ((LaunchOptions)paramObject).zzZd) && (zzf.zza(this.zzZe, ((LaunchOptions)paramObject).zzZe)));
    return false;
  }
  
  public String getLanguage()
  {
    return this.zzZe;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.zzZd;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(this.zzZd), this.zzZe });
  }
  
  public void setLanguage(String paramString)
  {
    this.zzZe = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.zzZd = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] { Boolean.valueOf(this.zzZd), this.zzZe });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LaunchOptions zzZf = new LaunchOptions();
    
    public LaunchOptions build()
    {
      return this.zzZf;
    }
    
    public Builder setLocale(Locale paramLocale)
    {
      this.zzZf.setLanguage(zzf.zzb(paramLocale));
      return this;
    }
    
    public Builder setRelaunchIfRunning(boolean paramBoolean)
    {
      this.zzZf.setRelaunchIfRunning(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/LaunchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */