package com.chartboost.sdk.Libraries;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private static final String a = g.class.getSimpleName();
  private static p b = new p();
  private static n c = new n(null);
  private static j d = new j(null);
  private static d e = new d(null);
  private static l f = new l(null);
  
  public static a a()
  {
    return b;
  }
  
  public static a a(a parama)
  {
    return new m(parama);
  }
  
  public static a a(Class<?> paramClass)
  {
    return new i(paramClass);
  }
  
  public static a a(a... paramVarArgs)
  {
    return new o(paramVarArgs);
  }
  
  public static a a(k... paramVarArgs)
  {
    return new f(paramVarArgs);
  }
  
  public static a a(Object... paramVarArgs)
  {
    return new h(paramVarArgs);
  }
  
  public static k a(String paramString, a parama)
  {
    return new k(paramString, parama);
  }
  
  public static a b()
  {
    return c;
  }
  
  public static a b(a parama)
  {
    return new c(parama);
  }
  
  public static a b(a... paramVarArgs)
  {
    return new q(paramVarArgs);
  }
  
  public static a b(k... paramVarArgs)
  {
    return new g(new f(paramVarArgs));
  }
  
  public static a c()
  {
    return e;
  }
  
  public static boolean c(a parama)
  {
    return ((parama instanceof f)) || ((parama instanceof g)) || ((parama instanceof o));
  }
  
  public static abstract class a
  {
    private String a = null;
    
    public abstract String a();
    
    public abstract boolean a(Object paramObject);
    
    public boolean a(Object paramObject, StringBuilder paramStringBuilder)
    {
      Object localObject = paramObject;
      if ((paramObject instanceof e.a)) {
        localObject = ((e.a)paramObject).o();
      }
      boolean bool = a(localObject);
      if (!bool) {
        if (this.a == null) {
          break label50;
        }
      }
      label50:
      for (paramObject = this.a;; paramObject = a())
      {
        paramStringBuilder.append((String)paramObject);
        return bool;
      }
    }
  }
  
  private static class b
    extends g.a
  {
    public String a()
    {
      return "object must be an array.";
    }
    
    public boolean a(Object paramObject)
    {
      return ((paramObject instanceof List)) || ((paramObject instanceof JSONArray));
    }
  }
  
  private static class c
    extends g.b
  {
    private g.a a;
    
    public c(g.a parama)
    {
      super();
      this.a = parama;
    }
    
    public String a()
    {
      return "object must be an array of objects matching: <" + this.a.a() + ">";
    }
    
    public boolean a(Object paramObject)
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        i = 0;
        if (i < ((List)paramObject).size()) {
          if (this.a.a(((List)paramObject).get(i))) {}
        }
      }
      while (!(paramObject instanceof JSONArray))
      {
        for (;;)
        {
          return false;
          i += 1;
        }
        return true;
      }
      paramObject = (JSONArray)paramObject;
      int i = 0;
      for (;;)
      {
        if (i >= ((JSONArray)paramObject).length()) {
          break label96;
        }
        if (!this.a.a(((JSONArray)paramObject).opt(i))) {
          break;
        }
        i += 1;
      }
      label96:
      return true;
    }
  }
  
  private static class d
    extends g.a
  {
    public String a()
    {
      return "object must be a boolean.";
    }
    
    public boolean a(Object paramObject)
    {
      return (Boolean.class.isInstance(paramObject)) || (Boolean.TYPE.isInstance(paramObject));
    }
  }
  
  public static abstract class e
    extends g.a
  {}
  
  private static class f
    extends g.a
  {
    protected g.k[] a;
    protected String b = null;
    
    public f(g.k[] paramArrayOfk)
    {
      this.a = paramArrayOfk;
    }
    
    public String a()
    {
      if (this.b != null) {
        return this.b;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must contain the following key-value schema: {\n");
      int i = 0;
      while (i < this.a.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(g.k.a(this.a[i]));
        localStringBuilder.append(": [");
        localStringBuilder.append(g.k.b(this.a[i]).a());
        localStringBuilder.append("]>");
        if (i < this.a.length - 1) {
          localStringBuilder.append(",\n");
        }
        i += 1;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      Object localObject1;
      Object localObject2;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        localObject1 = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (!(((Map.Entry)localObject2).getKey() instanceof String)) {
            this.b = ("key '" + ((Map.Entry)localObject2).getKey().toString() + "' is not a string");
          }
        }
      }
      int i;
      while (!(paramObject instanceof JSONObject))
      {
        return false;
        if ((this.a != null) && (this.a.length >= 1))
        {
          i = 0;
          while (i < this.a.length)
          {
            localObject1 = g.k.a(this.a[i]);
            localObject2 = g.k.b(this.a[i]);
            if (!((Map)paramObject).containsKey(localObject1))
            {
              if (!((g.a)localObject2).a(null))
              {
                this.b = ("no key for required mapping '" + (String)localObject1 + "' : <" + ((g.a)localObject2).a() + ">");
                return false;
              }
            }
            else if (!((g.a)localObject2).a(((Map)paramObject).get(localObject1)))
            {
              this.b = ("key '" + (String)localObject1 + "' fails to match: <" + ((g.a)localObject2).a() + ">");
              return false;
            }
            i += 1;
          }
        }
        return true;
      }
      paramObject = (JSONObject)paramObject;
      if ((this.a != null) && (this.a.length >= 1))
      {
        i = 0;
        while (i < this.a.length)
        {
          localObject1 = g.k.a(this.a[i]);
          localObject2 = g.k.b(this.a[i]);
          try
          {
            if (!((g.a)localObject2).a(((JSONObject)paramObject).get((String)localObject1)))
            {
              this.b = ("key '" + (String)localObject1 + "' fails to match: <" + ((g.a)localObject2).a() + ">");
              return false;
            }
          }
          catch (JSONException localJSONException)
          {
            if (!((g.a)localObject2).a(null))
            {
              this.b = ("no key for required mapping '" + (String)localObject1 + "' : <" + ((g.a)localObject2).a() + ">");
              return false;
            }
            i += 1;
          }
        }
      }
      return true;
    }
  }
  
  private static class g
    extends g.a
  {
    private Set<String> a;
    private g.f b;
    private String c = null;
    
    public g(g.f paramf)
    {
      this.b = paramf;
      this.a = new HashSet();
      int i = 0;
      while (i < this.b.a.length)
      {
        paramf = g.k.a(this.b.a[i]);
        this.a.add(paramf);
        i += 1;
      }
    }
    
    public String a()
    {
      if (this.c != null) {
        return this.c;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must EXACTLY MATCH the following key-value schema: {\n");
      int i = 0;
      while (i < this.b.a.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(g.k.a(this.b.a[i]));
        localStringBuilder.append(": [");
        localStringBuilder.append(g.k.b(this.b.a[i]).a());
        localStringBuilder.append("]>");
        if (i < this.b.a.length - 1) {
          localStringBuilder.append(",\n");
        }
        i += 1;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      if (!this.b.a(paramObject))
      {
        this.c = this.b.b;
        return false;
      }
      Object localObject;
      if ((paramObject instanceof Map))
      {
        paramObject = ((Map)paramObject).keySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = ((Iterator)paramObject).next();
          if (!this.a.contains(localObject))
          {
            this.c = ("key '" + localObject + "' is not allowed in this dictionary");
            return false;
          }
        }
        return true;
      }
      if ((paramObject instanceof JSONObject))
      {
        paramObject = ((JSONObject)paramObject).keys();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = (String)((Iterator)paramObject).next();
          if (!this.a.contains(localObject))
          {
            this.c = ("key '" + (String)localObject + "' is not allowed in this dictionary");
            return false;
          }
        }
        return true;
      }
      this.c = "object must be a dictionary";
      return false;
    }
  }
  
  private static class h
    extends g.a
  {
    private Object[] a;
    
    public h(Object[] paramArrayOfObject)
    {
      this.a = paramArrayOfObject;
    }
    
    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must equal one of the following: ");
      int i = 0;
      while (i < this.a.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(this.a[i].toString());
        localStringBuilder.append(">");
        if (i < this.a.length - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        Object localObject;
        if (i < this.a.length)
        {
          localObject = this.a[i];
          if (paramObject == null)
          {
            if (localObject != null) {
              break label49;
            }
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        if (paramObject.equals(localObject)) {
          return true;
        }
        label49:
        i += 1;
      }
    }
  }
  
  private static class i
    extends g.a
  {
    private Class<?> a;
    
    public i(Class<?> paramClass)
    {
      this.a = paramClass;
    }
    
    public String a()
    {
      return "object must be an instance of " + this.a.getName() + ".";
    }
    
    public boolean a(Object paramObject)
    {
      return this.a.isInstance(paramObject);
    }
  }
  
  private static class j
    extends g.a
  {
    public String a()
    {
      return "object must be a number w/o decimals (int, long, short, or byte).";
    }
    
    public boolean a(Object paramObject)
    {
      return (Integer.class.isInstance(paramObject)) || (Long.class.isInstance(paramObject)) || (Short.class.isInstance(paramObject)) || (Byte.class.isInstance(paramObject)) || (BigInteger.class.isInstance(paramObject)) || (Integer.TYPE.isInstance(paramObject)) || (Long.TYPE.isInstance(paramObject)) || (Short.TYPE.isInstance(paramObject)) || (Byte.TYPE.isInstance(paramObject));
    }
  }
  
  public static class k
  {
    private String a;
    private g.a b;
    
    public k(String paramString, g.a parama)
    {
      this.a = paramString;
      this.b = parama;
    }
  }
  
  private static class l
    extends g.a
  {
    public String a()
    {
      return "object must be null.";
    }
    
    public boolean a(Object paramObject)
    {
      return (paramObject == null) || (paramObject == JSONObject.NULL);
    }
  }
  
  private static class m
    extends g.l
  {
    private g.a a;
    
    public m(g.a parama)
    {
      super();
      this.a = parama;
    }
    
    public String a()
    {
      return "object must be either null or " + this.a.a();
    }
    
    public boolean a(Object paramObject)
    {
      if (super.a(paramObject)) {
        return true;
      }
      return this.a.a(paramObject);
    }
  }
  
  private static class n
    extends g.a
  {
    public String a()
    {
      return "object must be a number (primitive type or derived from Number).";
    }
    
    public boolean a(Object paramObject)
    {
      return ((paramObject instanceof Number)) || (Integer.TYPE.isInstance(paramObject)) || (Long.TYPE.isInstance(paramObject)) || (Short.TYPE.isInstance(paramObject)) || (Float.TYPE.isInstance(paramObject)) || (Double.TYPE.isInstance(paramObject)) || (Byte.TYPE.isInstance(paramObject));
    }
  }
  
  private static class o
    extends g.a
  {
    private g.a[] a;
    
    public o(g.a[] paramArrayOfa)
    {
      this.a = paramArrayOfa;
    }
    
    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must match one of the following: ");
      int i = 0;
      while (i < this.a.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(this.a[i].a());
        localStringBuilder.append(">");
        if (i < this.a.length - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.a.length)
        {
          if (this.a[i].a(paramObject)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
  }
  
  private static class p
    extends g.i
  {
    public p()
    {
      super();
    }
  }
  
  private static class q
    extends g.a
  {
    protected String a = null;
    private g.a[] b;
    
    public q(g.a[] paramArrayOfa)
    {
      this.b = paramArrayOfa;
    }
    
    public String a()
    {
      if (this.a != null) {
        return this.a;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("object must match ALL of the following: ");
      int i = 0;
      while (i < this.b.length)
      {
        localStringBuilder.append("<");
        localStringBuilder.append(this.b[i].a());
        localStringBuilder.append(">");
        if (i < this.b.length - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public boolean a(Object paramObject)
    {
      int i = 0;
      while (i < this.b.length)
      {
        if (!this.b[i].a(paramObject))
        {
          this.a = ("object failed to match: <" + this.b[i].a() + ">");
          return false;
        }
        i += 1;
      }
      return true;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */