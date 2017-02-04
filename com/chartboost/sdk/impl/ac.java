package com.chartboost.sdk.impl;

import java.io.UnsupportedEncodingException;

public class ac
  extends l<String>
{
  private final n.b<String> a;
  
  public ac(int paramInt, String paramString, n.b<String> paramb, n.a parama)
  {
    super(paramInt, paramString, parama);
    this.a = paramb;
  }
  
  protected n<String> a(i parami)
  {
    try
    {
      String str1 = new String(parami.b, w.a(parami.c));
      return n.a(str1, w.a(parami));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(parami.b);
      }
    }
  }
  
  protected void c(String paramString)
  {
    this.a.a(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */