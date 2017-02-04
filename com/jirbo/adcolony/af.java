package com.jirbo.adcolony;

import java.io.Serializable;

class af
  implements Serializable
{
  String a = "";
  int b;
  int c;
  int d;
  
  af() {}
  
  af(String paramString)
  {
    this.a = paramString;
  }
  
  ADCData.g a()
  {
    ADCData.g localg = new ADCData.g();
    localg.b("uuid", this.a);
    localg.b("skipped_plays", this.b);
    localg.b("play_order_index", this.c);
    return localg;
  }
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {
      return false;
    }
    this.a = paramg.a("uuid", "error");
    this.b = paramg.g("skipped_plays");
    this.c = paramg.g("play_order_index");
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */