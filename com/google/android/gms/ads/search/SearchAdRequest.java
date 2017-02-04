package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final int zzNd;
  private final int zzNe;
  private final int zzNf;
  private final int zzNg;
  private final int zzNh;
  private final int zzNi;
  private final int zzNj;
  private final String zzNk;
  private final int zzNl;
  private final String zzNm;
  private final int zzNn;
  private final int zzNo;
  private final String zzNp;
  private final zzy zzot;
  private final int zzxq;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.zzNd = Builder.zza(paramBuilder);
    this.zzxq = Builder.zzb(paramBuilder);
    this.zzNe = Builder.zzc(paramBuilder);
    this.zzNf = Builder.zzd(paramBuilder);
    this.zzNg = Builder.zze(paramBuilder);
    this.zzNh = Builder.zzf(paramBuilder);
    this.zzNi = Builder.zzg(paramBuilder);
    this.zzNj = Builder.zzh(paramBuilder);
    this.zzNk = Builder.zzi(paramBuilder);
    this.zzNl = Builder.zzj(paramBuilder);
    this.zzNm = Builder.zzk(paramBuilder);
    this.zzNn = Builder.zzl(paramBuilder);
    this.zzNo = Builder.zzm(paramBuilder);
    this.zzNp = Builder.zzn(paramBuilder);
    this.zzot = new zzy(Builder.zzo(paramBuilder), this);
  }
  
  public int getAnchorTextColor()
  {
    return this.zzNd;
  }
  
  public int getBackgroundColor()
  {
    return this.zzxq;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.zzNe;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.zzNf;
  }
  
  public int getBorderColor()
  {
    return this.zzNg;
  }
  
  public int getBorderThickness()
  {
    return this.zzNh;
  }
  
  public int getBorderType()
  {
    return this.zzNi;
  }
  
  public int getCallButtonColor()
  {
    return this.zzNj;
  }
  
  public String getCustomChannels()
  {
    return this.zzNk;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.zzot.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return this.zzNl;
  }
  
  public String getFontFace()
  {
    return this.zzNm;
  }
  
  public int getHeaderTextColor()
  {
    return this.zzNn;
  }
  
  public int getHeaderTextSize()
  {
    return this.zzNo;
  }
  
  public Location getLocation()
  {
    return this.zzot.getLocation();
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
  
  public String getQuery()
  {
    return this.zzNp;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.zzot.isTestDevice(paramContext);
  }
  
  zzy zzaG()
  {
    return this.zzot;
  }
  
  public static final class Builder
  {
    private int zzNd;
    private int zzNe;
    private int zzNf;
    private int zzNg;
    private int zzNh;
    private int zzNi = 0;
    private int zzNj;
    private String zzNk;
    private int zzNl;
    private String zzNm;
    private int zzNn;
    private int zzNo;
    private String zzNp;
    private final zzy.zza zzou = new zzy.zza();
    private int zzxq;
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.zzou.zzb(paramClass, paramBundle);
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
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.zzNd = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.zzxq = paramInt;
      this.zzNe = Color.argb(0, 0, 0, 0);
      this.zzNf = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.zzxq = Color.argb(0, 0, 0, 0);
      this.zzNe = paramInt2;
      this.zzNf = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.zzNg = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.zzNh = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.zzNi = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.zzNj = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.zzNk = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.zzNl = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.zzNm = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.zzNn = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.zzNo = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.zzou.zzb(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.zzNp = paramString;
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */