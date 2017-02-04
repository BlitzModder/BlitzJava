package com.jirbo.adcolony;

public class AdColonyVideoAd
  extends AdColonyInterstitialAd
{
  public AdColonyVideoAd() {}
  
  public AdColonyVideoAd(String paramString)
  {
    super(paramString);
  }
  
  public AdColonyVideoAd withListener(AdColonyAdListener paramAdColonyAdListener)
  {
    this.z = paramAdColonyAdListener;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/AdColonyVideoAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */