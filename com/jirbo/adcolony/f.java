package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;

class f
{
  static byte[] a = new byte['Ѐ'];
  String b;
  
  f(String paramString)
  {
    this.b = (a.l.f.d + paramString);
  }
  
  x a()
  {
    return new x(this.b);
  }
  
  void a(String paramString)
  {
    x localx = a();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localx.a(paramString.charAt(i));
      i += 1;
    }
    localx.b();
  }
  
  s b()
  {
    try
    {
      s locals = new s(new w(this.b));
      return locals;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  void c()
  {
    new File(this.b).delete();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */