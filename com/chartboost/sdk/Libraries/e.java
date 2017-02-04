package com.chartboost.sdk.Libraries;

import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<**>;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static Map<Integer, a> a = Collections.synchronizedMap(new HashMap());
  private static Runnable b = new Runnable()
  {
    public void run()
    {
      e.a().clear();
    }
  };
  
  public static a a(b... paramVarArgs)
  {
    a locala = a.a();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locala.a(b.a(paramVarArgs[i]), b.b(paramVarArgs[i]));
      i += 1;
    }
    return locala;
  }
  
  public static b a(String paramString, Object paramObject)
  {
    return new b(paramString, paramObject);
  }
  
  public static List<?> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          Object localObject = paramJSONArray.get(i);
          if ((localObject instanceof JSONObject)) {
            localObject = a((JSONObject)localObject);
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if ((localObject instanceof JSONArray))
            {
              localObject = a((JSONArray)localObject);
            }
            else
            {
              boolean bool = localObject.equals(JSONObject.NULL);
              if (bool) {
                localObject = null;
              }
            }
          }
          return localArrayList;
        }
        catch (Exception localException)
        {
          CBLogging.b("CBJSON", "error converting json", localException);
        }
      }
      i += 1;
    }
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator.hasNext()) {
      for (;;)
      {
        try
        {
          String str = (String)localIterator.next();
          Object localObject = paramJSONObject.get(str);
          if (!(localObject instanceof JSONObject)) {
            break label89;
          }
          localObject = a((JSONObject)localObject);
          localHashMap.put(str, localObject);
        }
        catch (Exception localException)
        {
          CBLogging.b("CBJSON", "error converting json", localException);
        }
        break;
        label89:
        List localList;
        if ((localException instanceof JSONArray))
        {
          localList = a((JSONArray)localException);
        }
        else
        {
          boolean bool = localList.equals(JSONObject.NULL);
          if (bool) {
            localList = null;
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static JSONArray a(List<?> paramList)
  {
    if (paramList == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {
        try
        {
          Object localObject2 = paramList.get(i);
          Object localObject1;
          if ((localObject2 instanceof Map)) {
            localObject1 = a((Map)localObject2);
          }
          for (;;)
          {
            localJSONArray.put(localObject1);
            break;
            if ((localObject2 instanceof List))
            {
              localObject1 = a((List)localObject2);
            }
            else
            {
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = JSONObject.NULL;
              }
            }
          }
          return localJSONArray;
        }
        catch (Exception localException)
        {
          CBLogging.b("CBJSON", "error converting json", localException);
        }
      }
      i += 1;
    }
  }
  
  public static JSONObject a(Map<?, ?> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      String str = paramMap.getKey().toString();
      Object localObject = paramMap.getValue();
      for (;;)
      {
        try
        {
          if (!(localObject instanceof Map)) {
            break label101;
          }
          paramMap = a((Map)localObject);
          localJSONObject.put(str, paramMap);
        }
        catch (Exception paramMap)
        {
          CBLogging.b("CBJSON", "error converting json", paramMap);
        }
        break;
        label101:
        if ((localObject instanceof List))
        {
          paramMap = a((List)localObject);
        }
        else
        {
          paramMap = (Map<?, ?>)localObject;
          if (localObject == null) {
            paramMap = JSONObject.NULL;
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public static class a
  {
    public static a a = new a(null);
    private static JSONObject c = null;
    private static Map<String, Object> d = null;
    private static JSONArray e = null;
    private static List<?> f = null;
    private Object b;
    
    private a(Object paramObject)
    {
      this.b = paramObject;
    }
    
    public static a a()
    {
      return a(new JSONObject());
    }
    
    public static a a(Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return (a)paramObject;
      }
      if ((paramObject == null) || (paramObject == JSONObject.NULL)) {
        return a;
      }
      a locala = (a)e.a().get(Integer.valueOf(paramObject.hashCode()));
      if (locala != null) {
        return locala;
      }
      CBUtility.e().removeCallbacks(e.b());
      CBUtility.e().postDelayed(e.b(), 1000L);
      locala = new a(paramObject);
      e.a().put(Integer.valueOf(paramObject.hashCode()), locala);
      return locala;
    }
    
    public static JSONObject a(Map paramMap)
      throws JSONException
    {
      if (!r()) {
        return new JSONObject(paramMap);
      }
      return b(paramMap);
    }
    
    private static Object b(Object paramObject)
    {
      Object localObject;
      if (paramObject == null) {
        localObject = JSONObject.NULL;
      }
      for (;;)
      {
        return localObject;
        localObject = paramObject;
        if (!(paramObject instanceof JSONArray))
        {
          localObject = paramObject;
          if (!(paramObject instanceof JSONObject))
          {
            localObject = paramObject;
            if (!paramObject.equals(JSONObject.NULL)) {
              try
              {
                if ((paramObject instanceof Collection)) {
                  return new JSONArray((Collection)paramObject);
                }
                if (paramObject.getClass().isArray()) {
                  return new JSONArray(paramObject);
                }
                if ((paramObject instanceof Map)) {
                  return new JSONObject((Map)paramObject);
                }
                localObject = paramObject;
                if (!(paramObject instanceof Boolean))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Byte))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Character))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Double))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Float))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Integer))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof Long))
                            {
                              localObject = paramObject;
                              if (!(paramObject instanceof Short))
                              {
                                localObject = paramObject;
                                if (!(paramObject instanceof String)) {
                                  if (paramObject.getClass().getPackage().getName().startsWith("java."))
                                  {
                                    paramObject = paramObject.toString();
                                    return paramObject;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              catch (Exception paramObject) {}
            }
          }
        }
      }
      return null;
    }
    
    private static JSONObject b(Map paramMap)
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        String str = (String)localEntry.getKey();
        if (str == null) {
          throw new NullPointerException("key == null");
        }
        localJSONObject.put(str, b(localEntry.getValue()));
      }
      return localJSONObject;
    }
    
    public static a k(String paramString)
    {
      if (paramString == null)
      {
        CBLogging.d("CBJSON", "null passed when creating new JSON object");
        return a;
      }
      if (paramString != null) {}
      try
      {
        if (paramString.trim().startsWith("[")) {
          return a(new JSONArray(paramString));
        }
        paramString = a(new JSONObject(paramString));
        return paramString;
      }
      catch (JSONException paramString)
      {
        CBLogging.b("CBJSON", "error creating new json object", paramString);
      }
      return a;
    }
    
    private static boolean r()
    {
      return Build.VERSION.SDK_INT < 19;
    }
    
    public double a(double paramDouble)
    {
      if ((this.b instanceof String)) {}
      for (;;)
      {
        try
        {
          double d1 = Double.parseDouble((String)this.b);
          paramDouble = d1;
          return paramDouble;
        }
        catch (NumberFormatException localNumberFormatException) {}
        if ((this.b instanceof Number)) {
          return ((Number)this.b).doubleValue();
        }
      }
      return paramDouble;
    }
    
    public float a(float paramFloat)
    {
      if ((this.b instanceof String)) {}
      for (;;)
      {
        try
        {
          float f1 = Float.parseFloat((String)this.b);
          paramFloat = f1;
          return paramFloat;
        }
        catch (NumberFormatException localNumberFormatException) {}
        if ((this.b instanceof Number)) {
          return ((Number)this.b).floatValue();
        }
      }
      return paramFloat;
    }
    
    public int a(int paramInt)
    {
      if ((this.b instanceof String)) {}
      for (;;)
      {
        try
        {
          int i = Integer.parseInt((String)this.b);
          paramInt = i;
          return paramInt;
        }
        catch (NumberFormatException localNumberFormatException) {}
        if ((this.b instanceof Number)) {
          return ((Number)this.b).intValue();
        }
      }
      return paramInt;
    }
    
    public a a(String paramString)
    {
      if ((this.b instanceof JSONObject)) {
        return a(((JSONObject)this.b).opt(paramString));
      }
      if ((this.b instanceof Map)) {
        return a(((Map)this.b).get(paramString));
      }
      return a;
    }
    
    public void a(String paramString, Object paramObject)
    {
      c = null;
      e = null;
      d = null;
      f = null;
      Object localObject = paramObject;
      if ((paramObject instanceof a)) {
        localObject = ((a)paramObject).o();
      }
      if ((this.b instanceof JSONObject)) {}
      while (!(this.b instanceof Map)) {
        try
        {
          ((JSONObject)this.b).put(paramString, localObject);
          return;
        }
        catch (JSONException paramString)
        {
          CBLogging.b(this, "Error updating balances dictionary.", paramString);
          return;
        }
      }
      try
      {
        ((Map)this.b).put(paramString, localObject);
        return;
      }
      catch (Exception paramString)
      {
        CBLogging.b(this, "Error updating balances dictionary.", paramString);
      }
    }
    
    public boolean a(boolean paramBoolean)
    {
      if ((this.b instanceof Boolean)) {
        paramBoolean = ((Boolean)this.b).booleanValue();
      }
      return paramBoolean;
    }
    
    public long b(int paramInt)
    {
      if ((this.b instanceof String)) {
        try
        {
          long l = Long.parseLong((String)this.b);
          return l;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          return paramInt;
        }
      }
      if ((this.b instanceof Number)) {
        return ((Number)this.b).longValue();
      }
      return paramInt;
    }
    
    public boolean b()
    {
      return (this.b == null) || (this.b == JSONObject.NULL);
    }
    
    public boolean b(String paramString)
    {
      return a(paramString).b();
    }
    
    public a c(int paramInt)
    {
      a locala1;
      if ((this.b instanceof JSONArray)) {
        locala1 = a(((JSONArray)this.b).opt(paramInt));
      }
      do
      {
        return locala1;
        if ((this.b instanceof List)) {
          try
          {
            locala1 = a(((List)this.b).get(paramInt));
            return locala1;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            return a;
          }
        }
        a locala2 = this;
      } while (paramInt == 0);
      return a;
    }
    
    public boolean c()
    {
      return !b();
    }
    
    public boolean c(String paramString)
    {
      return a(paramString).c();
    }
    
    public String d(String paramString)
    {
      if ((this.b instanceof String)) {
        return (String)this.b;
      }
      return paramString;
    }
    
    public boolean d()
    {
      return !TextUtils.isEmpty(i());
    }
    
    public String e(String paramString)
    {
      return a(paramString).i();
    }
    
    public JSONObject e()
    {
      if ((this.b instanceof JSONObject)) {
        return (JSONObject)this.b;
      }
      if ((this.b instanceof Map))
      {
        if (c == null) {
          c = e.a((Map)this.b);
        }
        return c;
      }
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      paramObject = a(paramObject);
      if (b()) {
        return ((a)paramObject).b();
      }
      if ((e() != null) && (((a)paramObject).e() != null)) {
        return i.a(e(), ((a)paramObject).e());
      }
      if ((g() != null) && (((a)paramObject).g() != null)) {
        return i.a(g(), ((a)paramObject).g());
      }
      if ((this.b instanceof String)) {
        return this.b.equals(((a)paramObject).i());
      }
      if ((((a)paramObject).b instanceof String)) {
        return ((a)paramObject).b.equals(i());
      }
      return o().equals(((a)paramObject).o());
    }
    
    public int f(String paramString)
    {
      return a(paramString).l();
    }
    
    public Map<String, Object> f()
    {
      if ((this.b instanceof JSONObject))
      {
        if (d == null) {
          d = e.a((JSONObject)this.b);
        }
        return d;
      }
      if ((this.b instanceof Map)) {
        return (Map)this.b;
      }
      return null;
    }
    
    public float g(String paramString)
    {
      return a(paramString).k();
    }
    
    public JSONArray g()
    {
      if ((this.b instanceof JSONArray)) {
        return (JSONArray)this.b;
      }
      if ((this.b instanceof List))
      {
        if (e == null) {
          e = e.a((List)this.b);
        }
        return e;
      }
      return null;
    }
    
    public double h(String paramString)
    {
      return a(paramString).j();
    }
    
    public List<?> h()
    {
      if ((this.b instanceof JSONArray))
      {
        if (f == null) {
          f = e.a((JSONArray)this.b);
        }
        return f;
      }
      if ((this.b instanceof List)) {
        return (List)this.b;
      }
      return null;
    }
    
    public long i(String paramString)
    {
      return a(paramString).m();
    }
    
    public String i()
    {
      if (b()) {
        return null;
      }
      if ((this.b instanceof String)) {
        return (String)this.b;
      }
      return this.b.toString();
    }
    
    public double j()
    {
      return a(0.0D);
    }
    
    public boolean j(String paramString)
    {
      return a(paramString).n();
    }
    
    public float k()
    {
      return a(0.0F);
    }
    
    public int l()
    {
      return a(0);
    }
    
    public long m()
    {
      return b(0);
    }
    
    public boolean n()
    {
      return a(false);
    }
    
    public Object o()
    {
      return this.b;
    }
    
    public int p()
    {
      if ((this.b instanceof JSONArray)) {
        return ((JSONArray)this.b).length();
      }
      if ((this.b instanceof List)) {
        return ((List)this.b).size();
      }
      return 1;
    }
    
    public List<String> q()
    {
      if ((this.b instanceof JSONObject)) {
        return e.a(((JSONObject)this.b).names());
      }
      if ((this.b instanceof Map))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((Map)this.b).keySet());
        return localArrayList;
      }
      return null;
    }
    
    public String toString()
    {
      if (e() != null) {
        return e().toString();
      }
      if (g() != null) {
        return g().toString();
      }
      if (this.b != null) {
        return this.b.toString();
      }
      return "null";
    }
  }
  
  public static class b
  {
    private String a;
    private Object b;
    
    public b(String paramString, Object paramObject)
    {
      this.a = paramString;
      if ((paramObject instanceof e.a))
      {
        this.b = ((e.a)paramObject).o();
        return;
      }
      this.b = paramObject;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */