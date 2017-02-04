package com.chartboost.sdk.impl;

import android.content.Intent;

public class a
  extends s
{
  private Intent b;
  
  public a() {}
  
  public a(i parami)
  {
    super(parami);
  }
  
  public String getMessage()
  {
    if (this.b != null) {
      return "User needs to (re)enter credentials.";
    }
    return super.getMessage();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */