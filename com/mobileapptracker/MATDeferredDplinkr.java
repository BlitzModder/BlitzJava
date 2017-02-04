package com.mobileapptracker;

import android.content.Context;

class MATDeferredDplinkr
{
  private static volatile MATDeferredDplinkr dplinkr;
  private String advertiserId = null;
  private String androidId = null;
  private String conversionKey = null;
  private boolean enabled;
  private String googleAdvertisingId = null;
  private int isLATEnabled = 0;
  private MATDeeplinkListener listener = null;
  private String packageName = null;
  private String userAgent = null;
  
  public static MATDeferredDplinkr getInstance()
  {
    try
    {
      MATDeferredDplinkr localMATDeferredDplinkr = dplinkr;
      return localMATDeferredDplinkr;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static MATDeferredDplinkr initialize(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      dplinkr = new MATDeferredDplinkr();
      dplinkr.advertiserId = paramString1;
      dplinkr.conversionKey = paramString2;
      dplinkr.packageName = paramString3;
      paramString1 = dplinkr;
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void checkForDeferredDeeplink(Context paramContext, final MATUrlRequester paramMATUrlRequester)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if (((MATDeferredDplinkr.dplinkr.advertiserId == null) || (MATDeferredDplinkr.dplinkr.conversionKey == null) || (MATDeferredDplinkr.dplinkr.packageName == null)) && (MATDeferredDplinkr.this.listener != null)) {
          MATDeferredDplinkr.this.listener.didFailDeeplink("Advertiser ID, conversion key, or package name not set");
        }
        if ((MATDeferredDplinkr.dplinkr.googleAdvertisingId == null) && (MATDeferredDplinkr.dplinkr.androidId == null) && (MATDeferredDplinkr.this.listener != null)) {
          MATDeferredDplinkr.this.listener.didFailDeeplink("No device identifiers collected");
        }
        paramMATUrlRequester.requestDeeplink(MATDeferredDplinkr.dplinkr);
      }
    }).start();
  }
  
  public void enable(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public String getAdvertiserId()
  {
    return dplinkr.advertiserId;
  }
  
  public String getAndroidId()
  {
    return dplinkr.androidId;
  }
  
  public String getConversionKey()
  {
    return dplinkr.conversionKey;
  }
  
  public int getGoogleAdTrackingLimited()
  {
    return dplinkr.isLATEnabled;
  }
  
  public String getGoogleAdvertisingId()
  {
    return dplinkr.googleAdvertisingId;
  }
  
  public MATDeeplinkListener getListener()
  {
    return dplinkr.listener;
  }
  
  public String getPackageName()
  {
    return dplinkr.packageName;
  }
  
  public String getUserAgent()
  {
    return dplinkr.userAgent;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public void setAdvertiserId(String paramString)
  {
    dplinkr.advertiserId = paramString;
  }
  
  public void setAndroidId(String paramString)
  {
    dplinkr.androidId = paramString;
  }
  
  public void setConversionKey(String paramString)
  {
    dplinkr.conversionKey = paramString;
  }
  
  public void setGoogleAdvertisingId(String paramString, int paramInt)
  {
    dplinkr.googleAdvertisingId = paramString;
    dplinkr.isLATEnabled = paramInt;
  }
  
  public void setListener(MATDeeplinkListener paramMATDeeplinkListener)
  {
    dplinkr.listener = paramMATDeeplinkListener;
  }
  
  public void setPackageName(String paramString)
  {
    dplinkr.packageName = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    dplinkr.userAgent = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATDeferredDplinkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */