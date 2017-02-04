package com.chartboost.sdk.Model;

public final class CBError
{
  private a a;
  private String b;
  private boolean c;
  
  public CBError(a parama, String paramString)
  {
    this.a = parama;
    this.b = paramString;
    this.c = true;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public CBImpressionError c()
  {
    switch (1.a[this.a.ordinal()])
    {
    default: 
      return CBImpressionError.NETWORK_FAILURE;
    case 1: 
    case 2: 
    case 3: 
      return CBImpressionError.INTERNAL;
    case 4: 
      return CBImpressionError.INTERNET_UNAVAILABLE;
    }
    return CBImpressionError.NO_AD_FOUND;
  }
  
  public static enum CBClickError
  {
    static
    {
      AGE_GATE_FAILURE = new CBClickError("AGE_GATE_FAILURE", 2);
      NO_HOST_ACTIVITY = new CBClickError("NO_HOST_ACTIVITY", 3);
    }
    
    private CBClickError() {}
  }
  
  public static enum CBImpressionError
  {
    static
    {
      FIRST_SESSION_INTERSTITIALS_DISABLED = new CBImpressionError("FIRST_SESSION_INTERSTITIALS_DISABLED", 4);
      NETWORK_FAILURE = new CBImpressionError("NETWORK_FAILURE", 5);
      NO_AD_FOUND = new CBImpressionError("NO_AD_FOUND", 6);
      SESSION_NOT_STARTED = new CBImpressionError("SESSION_NOT_STARTED", 7);
      IMPRESSION_ALREADY_VISIBLE = new CBImpressionError("IMPRESSION_ALREADY_VISIBLE", 8);
      NO_HOST_ACTIVITY = new CBImpressionError("NO_HOST_ACTIVITY", 9);
      USER_CANCELLATION = new CBImpressionError("USER_CANCELLATION", 10);
      INVALID_LOCATION = new CBImpressionError("INVALID_LOCATION", 11);
      VIDEO_UNAVAILABLE = new CBImpressionError("VIDEO_UNAVAILABLE", 12);
      VIDEO_ID_MISSING = new CBImpressionError("VIDEO_ID_MISSING", 13);
      ERROR_PLAYING_VIDEO = new CBImpressionError("ERROR_PLAYING_VIDEO", 14);
      INVALID_RESPONSE = new CBImpressionError("INVALID_RESPONSE", 15);
      ASSETS_DOWNLOAD_FAILURE = new CBImpressionError("ASSETS_DOWNLOAD_FAILURE", 16);
      ERROR_CREATING_VIEW = new CBImpressionError("ERROR_CREATING_VIEW", 17);
      ERROR_DISPLAYING_VIEW = new CBImpressionError("ERROR_DISPLAYING_VIEW", 18);
      INCOMPATIBLE_API_VERSION = new CBImpressionError("INCOMPATIBLE_API_VERSION", 19);
      ERROR_LOADING_WEB_VIEW = new CBImpressionError("ERROR_LOADING_WEB_VIEW", 20);
      ASSET_PREFETCH_IN_PROGRESS = new CBImpressionError("ASSET_PREFETCH_IN_PROGRESS", 21);
      EMPTY_LOCAL_AD_LIST = new CBImpressionError("EMPTY_LOCAL_AD_LIST", 22);
    }
    
    private CBImpressionError() {}
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Model/CBError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */