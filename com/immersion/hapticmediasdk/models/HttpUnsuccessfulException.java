package com.immersion.hapticmediasdk.models;

public class HttpUnsuccessfulException
  extends Exception
{
  private static final long serialVersionUID = -251711421440827767L;
  private int a;
  
  public HttpUnsuccessfulException(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public int getHttpStatusCode()
  {
    return this.a;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/models/HttpUnsuccessfulException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */