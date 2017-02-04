package com.jirbo.adcolony;

import java.util.ArrayList;

class ag
{
  d a;
  boolean b = false;
  ArrayList<af> c = new ArrayList();
  
  ag(d paramd)
  {
    this.a = paramd;
  }
  
  af a(int paramInt)
  {
    return (af)this.c.get(paramInt);
  }
  
  af a(String paramString)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      af localaf = (af)this.c.get(i);
      if (localaf.a.equals(paramString)) {
        return localaf;
      }
      i += 1;
    }
    this.b = true;
    paramString = new af(paramString);
    this.c.add(paramString);
    return paramString;
  }
  
  void a()
  {
    int j = 0;
    Object localObject = k.c(new f("zone_state.txt"));
    if (localObject != null)
    {
      this.c.clear();
      i = 0;
      while (i < ((ADCData.c)localObject).i())
      {
        ADCData.g localg = ((ADCData.c)localObject).b(i);
        af localaf = new af();
        if (localaf.a(localg)) {
          this.c.add(localaf);
        }
        i += 1;
      }
    }
    localObject = this.a.a.l;
    int k = localObject.length;
    int i = j;
    while (i < k)
    {
      a(localObject[i]);
      i += 1;
    }
  }
  
  void b()
  {
    int i = 0;
    l.a.b("Saving zone state...");
    this.b = false;
    ADCData.c localc = new ADCData.c();
    String[] arrayOfString = this.a.a.l;
    int j = arrayOfString.length;
    while (i < j)
    {
      localc.a(a(arrayOfString[i]).a());
      i += 1;
    }
    k.a(new f("zone_state.txt"), localc);
    l.a.b("Saved zone state");
  }
  
  int c()
  {
    return this.c.size();
  }
  
  void d()
  {
    if (this.b) {
      b();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */