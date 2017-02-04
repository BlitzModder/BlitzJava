package com.chartboost.sdk.impl;

public class s
  extends Exception
{
  public final i a;
  private long b;
  
  public s()
  {
    this.a = null;
  }
  
  public s(i parami)
  {
    this.a = parami;
  }
  
  public s(String paramString)
  {
    super(paramString);
    this.a = null;
  }
  
  public s(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = null;
  }
  
  void a(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */