package com.jirbo.adcolony;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ADCData
{
  static i a = new h();
  static i b = new a();
  static i c = new d();
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("==== ADCData Test ====");
    paramArrayOfString = new g();
    paramArrayOfString.b("one", 1);
    paramArrayOfString.b("pi", 3.14D);
    paramArrayOfString.b("name", "\"Abe Pralle\"");
    paramArrayOfString.a("list", new c());
    paramArrayOfString.a("subtable", new g());
    paramArrayOfString.b("subtable").b("five", 5);
    System.out.println("LIST:" + paramArrayOfString.c("list"));
    paramArrayOfString.c("list").a(3);
    System.out.println(paramArrayOfString);
    System.out.println(paramArrayOfString.g("one"));
    System.out.println(paramArrayOfString.f("one"));
    System.out.println(paramArrayOfString.g("pi"));
    System.out.println(paramArrayOfString.f("pi"));
    System.out.println(paramArrayOfString.e("name"));
    System.out.println(paramArrayOfString.f("name"));
    System.out.println(paramArrayOfString.g("name"));
    System.out.println(paramArrayOfString.c("list"));
    System.out.println(paramArrayOfString.c("list2"));
    System.out.println(paramArrayOfString.c("subtable"));
    System.out.println(paramArrayOfString.b("subtable"));
    System.out.println(paramArrayOfString.b("subtable2"));
    System.out.println(paramArrayOfString.b("list"));
  }
  
  static class a
    extends ADCData.i
  {
    void a(ae paramae)
    {
      paramae.a("false");
    }
    
    boolean a()
    {
      return true;
    }
    
    String b()
    {
      return "false";
    }
  }
  
  static class b
    extends ADCData.i
  {
    int a;
    
    b(int paramInt)
    {
      this.a = paramInt;
    }
    
    void a(ae paramae)
    {
      paramae.a(this.a);
    }
    
    boolean c()
    {
      return true;
    }
    
    double d()
    {
      return this.a;
    }
    
    int e()
    {
      return this.a;
    }
  }
  
  static class c
    extends ADCData.i
  {
    ArrayList<ADCData.i> a = new ArrayList();
    
    double a(int paramInt, double paramDouble)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt);
      double d = paramDouble;
      if (locali != null)
      {
        d = paramDouble;
        if (locali.p()) {
          d = locali.d();
        }
      }
      return d;
    }
    
    int a(int paramInt1, int paramInt2)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt1);
      paramInt1 = paramInt2;
      if (locali != null)
      {
        paramInt1 = paramInt2;
        if (locali.p()) {
          paramInt1 = locali.e();
        }
      }
      return paramInt1;
    }
    
    c a(double paramDouble)
    {
      a(new ADCData.e(paramDouble));
      return this;
    }
    
    c a(int paramInt)
    {
      a(new ADCData.b(paramInt));
      return this;
    }
    
    c a(int paramInt, c paramc)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt);
      c localc = paramc;
      if (locali != null)
      {
        localc = paramc;
        if (locali.f()) {
          localc = locali.h();
        }
      }
      return localc;
    }
    
    c a(c paramc)
    {
      int i = 0;
      while (i < paramc.i())
      {
        a((ADCData.i)paramc.a.get(i));
        i += 1;
      }
      return this;
    }
    
    c a(ADCData.i parami)
    {
      this.a.add(parami);
      return this;
    }
    
    c a(String paramString)
    {
      a(new ADCData.f(paramString));
      return this;
    }
    
    c a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (ADCData.i locali = ADCData.a;; locali = ADCData.b)
      {
        a(locali);
        return this;
      }
    }
    
    ADCData.g a(int paramInt, ADCData.g paramg)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt);
      ADCData.g localg = paramg;
      if (locali != null)
      {
        localg = paramg;
        if (locali.m()) {
          localg = locali.n();
        }
      }
      return localg;
    }
    
    String a(int paramInt, String paramString)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt);
      String str = paramString;
      if (locali != null)
      {
        str = paramString;
        if (locali.k()) {
          str = locali.b();
        }
      }
      return str;
    }
    
    void a(ae paramae)
    {
      int k = this.a.size();
      if (k == 0)
      {
        paramae.a("[]");
        return;
      }
      if ((k == 1) && (((ADCData.i)this.a.get(0)).g()))
      {
        paramae.a("[");
        ((ADCData.i)this.a.get(0)).a(paramae);
        paramae.a("]");
        return;
      }
      paramae.b("[");
      paramae.i += 2;
      int j = 0;
      int i = 1;
      if (j < k)
      {
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          ((ADCData.i)this.a.get(j)).a(paramae);
          j += 1;
          break;
          paramae.c(',');
        }
      }
      paramae.d();
      paramae.i -= 2;
      paramae.a("]");
    }
    
    boolean a(int paramInt, boolean paramBoolean)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramInt);
      boolean bool = paramBoolean;
      if (locali != null) {
        if (!locali.a())
        {
          bool = paramBoolean;
          if (!locali.k()) {}
        }
        else
        {
          bool = locali.l();
        }
      }
      return bool;
    }
    
    ADCData.i a_()
    {
      return (ADCData.i)this.a.remove(this.a.size() - 1);
    }
    
    ADCData.g b(int paramInt)
    {
      ADCData.g localg = a(paramInt, null);
      if (localg != null) {
        return localg;
      }
      return new ADCData.g();
    }
    
    c c(int paramInt)
    {
      c localc = a(paramInt, null);
      if (localc != null) {
        return localc;
      }
      return new c();
    }
    
    String d(int paramInt)
    {
      return a(paramInt, "");
    }
    
    double e(int paramInt)
    {
      return a(paramInt, 0.0D);
    }
    
    int f(int paramInt)
    {
      return a(paramInt, 0);
    }
    
    boolean f()
    {
      return true;
    }
    
    boolean g()
    {
      return (this.a.size() == 0) || ((this.a.size() == 1) && (((ADCData.i)this.a.get(0)).g()));
    }
    
    boolean g(int paramInt)
    {
      return a(paramInt, false);
    }
    
    c h()
    {
      return this;
    }
    
    int i()
    {
      return this.a.size();
    }
    
    void j()
    {
      this.a.clear();
    }
  }
  
  static class d
    extends ADCData.i
  {
    void a(ae paramae)
    {
      paramae.a("null");
    }
    
    String b()
    {
      return "null";
    }
    
    boolean c_()
    {
      return true;
    }
  }
  
  static class e
    extends ADCData.i
  {
    double a;
    
    e(double paramDouble)
    {
      this.a = paramDouble;
    }
    
    void a(ae paramae)
    {
      paramae.a(this.a);
    }
    
    boolean b_()
    {
      return true;
    }
    
    double d()
    {
      return this.a;
    }
    
    int e()
    {
      return (int)this.a;
    }
  }
  
  static class f
    extends ADCData.i
    implements Serializable
  {
    String a;
    
    f(String paramString)
    {
      this.a = paramString;
    }
    
    void a(ae paramae)
    {
      a(paramae, this.a);
    }
    
    String b()
    {
      return this.a;
    }
    
    double d()
    {
      try
      {
        double d = Double.parseDouble(this.a);
        return d;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return 0.0D;
    }
    
    int e()
    {
      return (int)d();
    }
    
    boolean k()
    {
      return true;
    }
    
    boolean l()
    {
      String str = this.a.toLowerCase();
      return (str.equals("true")) || (str.equals("yes"));
    }
  }
  
  static class g
    extends ADCData.i
    implements Serializable
  {
    HashMap<String, ADCData.i> a = new HashMap();
    ArrayList<String> b = new ArrayList();
    
    double a(String paramString, double paramDouble)
    {
      paramString = (ADCData.i)this.a.get(paramString);
      double d = paramDouble;
      if (paramString != null)
      {
        d = paramDouble;
        if (paramString.p()) {
          d = paramString.d();
        }
      }
      return d;
    }
    
    int a(String paramString, int paramInt)
    {
      paramString = (ADCData.i)this.a.get(paramString);
      int i = paramInt;
      if (paramString != null)
      {
        i = paramInt;
        if (paramString.p()) {
          i = paramString.e();
        }
      }
      return i;
    }
    
    ADCData.c a(String paramString, ADCData.c paramc)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramString);
      paramString = paramc;
      if (locali != null)
      {
        paramString = paramc;
        if (locali.f()) {
          paramString = locali.h();
        }
      }
      return paramString;
    }
    
    g a(String paramString, g paramg)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramString);
      paramString = paramg;
      if (locali != null)
      {
        paramString = paramg;
        if (locali.m()) {
          paramString = locali.n();
        }
      }
      return paramString;
    }
    
    String a(int paramInt)
    {
      return (String)this.b.get(paramInt);
    }
    
    String a(String paramString1, String paramString2)
    {
      ADCData.i locali = (ADCData.i)this.a.get(paramString1);
      paramString1 = paramString2;
      if (locali != null)
      {
        paramString1 = paramString2;
        if (locali.k()) {
          paramString1 = locali.b();
        }
      }
      return paramString1;
    }
    
    ArrayList<String> a(String paramString, ArrayList<String> paramArrayList)
    {
      ADCData.c localc = c(paramString);
      if (localc == null) {
        return paramArrayList;
      }
      paramString = new ArrayList();
      int i = 0;
      for (;;)
      {
        paramArrayList = paramString;
        if (i >= localc.i()) {
          break;
        }
        paramArrayList = localc.d(i);
        if (paramArrayList != null) {
          paramString.add(paramArrayList);
        }
        i += 1;
      }
    }
    
    void a(ae paramae)
    {
      int k = this.b.size();
      if (k == 0)
      {
        paramae.a("{}");
        return;
      }
      String str;
      ADCData.i locali;
      if ((k == 1) && (((ADCData.i)this.a.get(this.b.get(0))).g()))
      {
        paramae.a("{");
        str = (String)this.b.get(0);
        locali = (ADCData.i)this.a.get(str);
        a(paramae, str);
        paramae.b(':');
        locali.a(paramae);
        paramae.a("}");
        return;
      }
      paramae.b("{");
      paramae.i += 2;
      int j = 0;
      int i = 1;
      if (j < k)
      {
        if (i != 0) {
          i = 0;
        }
        for (;;)
        {
          str = (String)this.b.get(j);
          locali = (ADCData.i)this.a.get(str);
          a(paramae, str);
          paramae.b(':');
          if (!locali.g()) {
            paramae.d();
          }
          locali.a(paramae);
          j += 1;
          break;
          paramae.c(',');
        }
      }
      paramae.d();
      paramae.i -= 2;
      paramae.a("}");
    }
    
    void a(String paramString, ADCData.i parami)
    {
      if (!this.a.containsKey(paramString)) {
        this.b.add(paramString);
      }
      this.a.put(paramString, parami);
    }
    
    boolean a(String paramString)
    {
      return this.a.containsKey(paramString);
    }
    
    boolean a(String paramString, boolean paramBoolean)
    {
      paramString = (ADCData.i)this.a.get(paramString);
      boolean bool = paramBoolean;
      if (paramString != null) {
        if (!paramString.a())
        {
          bool = paramBoolean;
          if (!paramString.k()) {}
        }
        else
        {
          bool = paramString.l();
        }
      }
      return bool;
    }
    
    g b(String paramString)
    {
      paramString = a(paramString, null);
      if (paramString != null) {
        return paramString;
      }
      return new g();
    }
    
    void b(String paramString, double paramDouble)
    {
      a(paramString, new ADCData.e(paramDouble));
    }
    
    void b(String paramString, int paramInt)
    {
      a(paramString, new ADCData.b(paramInt));
    }
    
    void b(String paramString1, String paramString2)
    {
      a(paramString1, new ADCData.f(paramString2));
    }
    
    void b(String paramString, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (ADCData.i locali = ADCData.a;; locali = ADCData.b)
      {
        a(paramString, locali);
        return;
      }
    }
    
    ADCData.c c(String paramString)
    {
      paramString = a(paramString, null);
      if (paramString != null) {
        return paramString;
      }
      return new ADCData.c();
    }
    
    ArrayList<String> d(String paramString)
    {
      ArrayList localArrayList = a(paramString, null);
      paramString = localArrayList;
      if (localArrayList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
    
    String e(String paramString)
    {
      return a(paramString, "");
    }
    
    double f(String paramString)
    {
      return a(paramString, 0.0D);
    }
    
    int g(String paramString)
    {
      return a(paramString, 0);
    }
    
    boolean g()
    {
      return (this.a.size() < 0) || ((this.a.size() == 1) && (((ADCData.i)this.a.get(this.b.get(0))).g()));
    }
    
    boolean h(String paramString)
    {
      return a(paramString, false);
    }
    
    boolean m()
    {
      return true;
    }
    
    g n()
    {
      return this;
    }
    
    int o()
    {
      return this.b.size();
    }
  }
  
  static class h
    extends ADCData.i
  {
    void a(ae paramae)
    {
      paramae.a("true");
    }
    
    boolean a()
    {
      return true;
    }
    
    String b()
    {
      return "true";
    }
    
    double d()
    {
      return 1.0D;
    }
    
    int e()
    {
      return 1;
    }
    
    boolean l()
    {
      return true;
    }
  }
  
  static class i
  {
    void a(ae paramae) {}
    
    void a(ae paramae, String paramString)
    {
      if (paramString == null) {
        return;
      }
      paramae.b('"');
      int m = paramString.length();
      int i = 0;
      if (i < m)
      {
        char c1 = paramString.charAt(i);
        switch (c1)
        {
        default: 
          if ((c1 >= ' ') && (c1 <= '~')) {
            paramae.b(c1);
          }
          break;
        case '"': 
        case '\\': 
        case '/': 
        case '\b': 
        case '\f': 
        case '\n': 
        case '\r': 
        case '\t': 
          for (;;)
          {
            i += 1;
            break;
            paramae.a("\\\"");
            continue;
            paramae.a("\\\\");
            continue;
            paramae.a("\\/");
            continue;
            paramae.a("\\b");
            continue;
            paramae.a("\\f");
            continue;
            paramae.a("\\n");
            continue;
            paramae.a("\\r");
            continue;
            paramae.a("\\t");
          }
        }
        paramae.a("\\u");
        char c2 = c1;
        int j = 0;
        label218:
        int n;
        if (j < 4)
        {
          n = c2 >> '\f' & 0xF;
          int k;
          c2 <<= '\004';
          if (n > 9) {
            break label263;
          }
          paramae.a(n);
        }
        for (;;)
        {
          j += 1;
          break label218;
          break;
          label263:
          paramae.b((char)(n - 10 + 97));
        }
      }
      paramae.b('"');
    }
    
    boolean a()
    {
      return false;
    }
    
    String b()
    {
      return q();
    }
    
    boolean b_()
    {
      return false;
    }
    
    boolean c()
    {
      return false;
    }
    
    boolean c_()
    {
      return false;
    }
    
    double d()
    {
      return 0.0D;
    }
    
    int e()
    {
      return 0;
    }
    
    boolean f()
    {
      return false;
    }
    
    boolean g()
    {
      return true;
    }
    
    ADCData.c h()
    {
      return null;
    }
    
    boolean k()
    {
      return false;
    }
    
    boolean l()
    {
      return false;
    }
    
    boolean m()
    {
      return false;
    }
    
    ADCData.g n()
    {
      return null;
    }
    
    boolean p()
    {
      return (b_()) || (c());
    }
    
    String q()
    {
      y localy = new y();
      a(localy);
      return localy.toString();
    }
    
    public String toString()
    {
      return q();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ADCData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */