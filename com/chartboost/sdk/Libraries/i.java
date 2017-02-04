package com.chartboost.sdk.Libraries;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  private static final String a = i.class.getSimpleName();
  
  private static BigDecimal a(Number paramNumber)
  {
    if ((paramNumber instanceof BigDecimal)) {
      return (BigDecimal)paramNumber;
    }
    if ((paramNumber instanceof BigInteger)) {
      return new BigDecimal((BigInteger)paramNumber);
    }
    if (((paramNumber instanceof Byte)) || ((paramNumber instanceof Short)) || ((paramNumber instanceof Integer)) || ((paramNumber instanceof Long))) {
      return new BigDecimal(paramNumber.longValue());
    }
    if (((paramNumber instanceof Float)) || ((paramNumber instanceof Double))) {
      return new BigDecimal(paramNumber.doubleValue());
    }
    try
    {
      BigDecimal localBigDecimal = new BigDecimal(paramNumber.toString());
      return localBigDecimal;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      CBLogging.b(a, "The given number (\"" + paramNumber + "\" of class " + paramNumber.getClass().getName() + ") does not have a parsable string representation", localNumberFormatException);
    }
    return null;
  }
  
  private static boolean a(Object paramObject)
  {
    return (paramObject != null) && (paramObject != JSONObject.NULL);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return paramObject1 == paramObject2;
  }
  
  public static boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1.length() != paramJSONArray2.length()) && (!b(paramJSONArray1.toString(), paramJSONArray2.toString()))) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return false;
        i = 0;
        if (i >= paramJSONArray1.length()) {
          break;
        }
        localObject1 = paramJSONArray1.opt(i);
        localObject2 = paramJSONArray2.opt(i);
      } while ((!a(localObject1.getClass(), localObject2.getClass())) && ((!Number.class.isInstance(localObject1)) || (!Number.class.isInstance(localObject2))));
      if (!(localObject1 instanceof JSONObject)) {
        break;
      }
    } while (!a((JSONObject)localObject1, (JSONObject)localObject2));
    label137:
    do
    {
      do
      {
        i += 1;
        break;
        if (!(localObject1 instanceof JSONArray)) {
          break label137;
        }
      } while (a((JSONArray)localObject1, (JSONArray)localObject2));
      return false;
    } while (b(localObject1, localObject2));
    return false;
    return true;
  }
  
  public static boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1.length() != paramJSONObject2.length()) {}
    try
    {
      boolean bool = b(paramJSONObject1.toString(2), paramJSONObject2.toString(2));
      if (!bool) {}
      int i;
      Object localObject2;
      Object localObject1;
      do
      {
        do
        {
          return false;
          JSONArray localJSONArray = paramJSONObject1.names();
          if ((localJSONArray == null) && (paramJSONObject2.names() == null)) {
            return true;
          }
          i = 0;
          if (i >= localJSONArray.length()) {
            break;
          }
          localObject2 = localJSONArray.optString(i);
          localObject1 = paramJSONObject1.opt((String)localObject2);
          localObject2 = paramJSONObject2.opt((String)localObject2);
        } while (((a(localObject1)) && (!a(localObject2))) || ((!a(localObject1.getClass(), localObject2.getClass())) && ((!Number.class.isInstance(localObject1)) || (!Number.class.isInstance(localObject2)))));
        if (!(localObject1 instanceof JSONObject)) {
          break;
        }
      } while (!a((JSONObject)localObject1, (JSONObject)localObject2));
      label195:
      do
      {
        do
        {
          i += 1;
          break;
          if (!(localObject1 instanceof JSONArray)) {
            break label195;
          }
        } while (a((JSONArray)localObject1, (JSONArray)localObject2));
        return false;
      } while (b(localObject1, localObject2));
      return false;
      return true;
    }
    catch (JSONException paramJSONObject1) {}
    return false;
  }
  
  public static boolean b(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    if ((paramObject1 == null) || (paramObject1 == JSONObject.NULL)) {
      if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if ((Number.class.isInstance(paramObject1)) && (Number.class.isInstance(paramObject2))) {
        try
        {
          int i = a((Number)paramObject1).compareTo(a((Number)paramObject2));
          if (i != 0) {
            return false;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          CBLogging.b(a, "Error comparing big decimal values");
        }
      }
    }
    return paramObject1.equals(paramObject2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */