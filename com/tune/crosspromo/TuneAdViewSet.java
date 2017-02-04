package com.tune.crosspromo;

class TuneAdViewSet
{
  public String placement;
  public boolean showView1;
  public TuneAdView view1;
  public TuneAdView view2;
  
  public TuneAdViewSet(String paramString, TuneAdView paramTuneAdView1, TuneAdView paramTuneAdView2)
  {
    this.placement = paramString;
    this.view1 = paramTuneAdView1;
    this.view2 = paramTuneAdView2;
    this.showView1 = true;
  }
  
  protected void changeView()
  {
    if (this.showView1) {}
    for (boolean bool = false;; bool = true)
    {
      this.showView1 = bool;
      return;
    }
  }
  
  protected void destroy()
  {
    this.view1.destroy();
    this.view2.destroy();
  }
  
  protected TuneAdView getCurrentView()
  {
    if (this.showView1) {
      return this.view1;
    }
    return this.view2;
  }
  
  protected TuneAdView getPreviousView()
  {
    if (this.showView1) {
      return this.view2;
    }
    return this.view1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAdViewSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */