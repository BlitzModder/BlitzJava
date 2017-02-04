package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest
{
  public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  private final zzy zzot;
  
  private PublisherAdRequest(Builder paramBuilder)
  {
    this.zzot = new zzy(Builder.zza(paramBuilder));
  }
  
  public static void updateCorrelator() {}
  
  public Date getBirthday()
  {
    return this.zzot.getBirthday();
  }
  
  public String getContentUrl()
  {
    return this.zzot.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zzot.getCustomEventExtrasBundle(paramClass);
  }
  
  public Bundle getCustomTargeting()
  {
    return this.zzot.getCustomTargeting();
  }
  
  public int getGender()
  {
    return this.zzot.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return this.zzot.getKeywords();
  }
  
  public Location getLocation()
  {
    return this.zzot.getLocation();
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.zzot.getManualImpressionsEnabled();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.zzot.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.zzot.getNetworkExtrasBundle(paramClass);
  }
  
  public String getPublisherProvidedId()
  {
    return this.zzot.getPublisherProvidedId();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.zzot.isTestDevice(paramContext);
  }
  
  public zzy zzaG()
  {
    return this.zzot;
  }
  
  public static final class Builder
  {
    private final zzy.zza zzou = new zzy.zza();
    
    public Builder addCategoryExclusion(String paramString)
    {
      this.zzou.zzL(paramString);
      return this;
    }
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zzou.zzb(paramClass, paramBundle);
      return this;
    }
    
    public Builder addCustomTargeting(String paramString1, String paramString2)
    {
      this.zzou.zzb(paramString1, paramString2);
      return this;
    }
    
    public Builder addCustomTargeting(String paramString, List<String> paramList)
    {
      if (paramList != null) {
        this.zzou.zzb(paramString, zzv.zzcF(",").zza(paramList));
      }
      return this;
    }
    
    public Builder addKeyword(String paramString)
    {
      this.zzou.zzF(paramString);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.zzou.zza(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zzou.zza(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.zzou.zzG(paramString);
      return this;
    }
    
    public PublisherAdRequest build()
    {
      return new PublisherAdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      this.zzou.zza(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      zzx.zzb(paramString, "Content URL must be non-null.");
      zzx.zzh(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] { Integer.valueOf(512), Integer.valueOf(paramString.length()) });
        this.zzou.zzI(paramString);
        return this;
      }
    }
    
    public Builder setGender(int paramInt)
    {
      this.zzou.zzn(paramInt);
      return this;
    }
    
    public Builder setIsDesignedForFamilies(boolean paramBoolean)
    {
      this.zzou.zzl(paramBoolean);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.zzou.zzb(paramLocation);
      return this;
    }
    
    @Deprecated
    public Builder setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.zzou.setManualImpressionsEnabled(paramBoolean);
      return this;
    }
    
    public Builder setPublisherProvidedId(String paramString)
    {
      this.zzou.zzJ(paramString);
      return this;
    }
    
    public Builder setRequestAgent(String paramString)
    {
      this.zzou.zzK(paramString);
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.zzou.zzk(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */