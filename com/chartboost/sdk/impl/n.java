package com.chartboost.sdk.impl;

public class n<T>
{
  public final T a;
  public final b.a b;
  public final s c;
  public boolean d = false;
  
  private n(s params)
  {
    this.a = null;
    this.b = null;
    this.c = params;
  }
  
  private n(T paramT, b.a parama)
  {
    this.a = paramT;
    this.b = parama;
    this.c = null;
  }
  
  public static <T> n<T> a(s params)
  {
    return new n(params);
  }
  
  public static <T> n<T> a(T paramT, b.a parama)
  {
    return new n(paramT, parama);
  }
  
  public boolean a()
  {
    return this.c == null;
  }
  
  public static abstract interface a
  {
    public abstract void a(s params);
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */