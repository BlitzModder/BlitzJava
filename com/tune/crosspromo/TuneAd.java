package com.tune.crosspromo;

public abstract interface TuneAd
{
  public abstract void destroy();
  
  public abstract void setListener(TuneAdListener paramTuneAdListener);
  
  public abstract void show(String paramString);
  
  public abstract void show(String paramString, TuneAdMetadata paramTuneAdMetadata);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */