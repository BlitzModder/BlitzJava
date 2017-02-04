package com.parse.http;

import java.io.IOException;

public abstract interface ParseNetworkInterceptor
{
  public abstract ParseHttpResponse intercept(Chain paramChain)
    throws IOException;
  
  public static abstract interface Chain
  {
    public abstract ParseHttpRequest getRequest();
    
    public abstract ParseHttpResponse proceed(ParseHttpRequest paramParseHttpRequest)
      throws IOException;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/parse/http/ParseNetworkInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */