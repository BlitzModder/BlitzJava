package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProductAction
{
  public static final String ACTION_ADD = "add";
  public static final String ACTION_CHECKOUT = "checkout";
  public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
  @Deprecated
  public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
  public static final String ACTION_CLICK = "click";
  public static final String ACTION_DETAIL = "detail";
  public static final String ACTION_PURCHASE = "purchase";
  public static final String ACTION_REFUND = "refund";
  public static final String ACTION_REMOVE = "remove";
  Map<String, String> zzOA = new HashMap();
  
  public ProductAction(String paramString)
  {
    put("&pa", paramString);
  }
  
  public Map<String, String> build()
  {
    return new HashMap(this.zzOA);
  }
  
  void put(String paramString1, String paramString2)
  {
    zzx.zzb(paramString1, "Name should be non-null");
    this.zzOA.put(paramString1, paramString2);
  }
  
  public ProductAction setCheckoutOptions(String paramString)
  {
    put("&col", paramString);
    return this;
  }
  
  public ProductAction setCheckoutStep(int paramInt)
  {
    put("&cos", Integer.toString(paramInt));
    return this;
  }
  
  public ProductAction setProductActionList(String paramString)
  {
    put("&pal", paramString);
    return this;
  }
  
  public ProductAction setProductListSource(String paramString)
  {
    put("&pls", paramString);
    return this;
  }
  
  public ProductAction setTransactionAffiliation(String paramString)
  {
    put("&ta", paramString);
    return this;
  }
  
  public ProductAction setTransactionCouponCode(String paramString)
  {
    put("&tcc", paramString);
    return this;
  }
  
  public ProductAction setTransactionId(String paramString)
  {
    put("&ti", paramString);
    return this;
  }
  
  public ProductAction setTransactionRevenue(double paramDouble)
  {
    put("&tr", Double.toString(paramDouble));
    return this;
  }
  
  public ProductAction setTransactionShipping(double paramDouble)
  {
    put("&ts", Double.toString(paramDouble));
    return this;
  }
  
  public ProductAction setTransactionTax(double paramDouble)
  {
    put("&tt", Double.toString(paramDouble));
    return this;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzOA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).startsWith("&")) {
        localHashMap.put(((String)localEntry.getKey()).substring(1), localEntry.getValue());
      } else {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return zze.zzH(localHashMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/ecommerce/ProductAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */