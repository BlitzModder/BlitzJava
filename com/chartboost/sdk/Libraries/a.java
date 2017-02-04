package com.chartboost.sdk.Libraries;

public abstract interface a
{
  public static final g.a a = g.b(new g.a[] { g.b(), new g.e()
  {
    public String a()
    {
      return "Must be a valid status code (>=200 && <300)";
    }
    
    public boolean a(Object paramAnonymousObject)
    {
      int i = ((Number)paramAnonymousObject).intValue();
      return (i >= 200) && (i < 300);
    }
  } });
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */