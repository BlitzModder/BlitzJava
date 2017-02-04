package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzqk
  extends zze<zzqk>
{
  private ProductAction zzNT;
  private final Map<String, List<Product>> zzNU = new HashMap();
  private final List<Promotion> zzNV = new ArrayList();
  private final List<Product> zzNW = new ArrayList();
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!this.zzNW.isEmpty()) {
      localHashMap.put("products", this.zzNW);
    }
    if (!this.zzNV.isEmpty()) {
      localHashMap.put("promotions", this.zzNV);
    }
    if (!this.zzNU.isEmpty()) {
      localHashMap.put("impressions", this.zzNU);
    }
    localHashMap.put("productAction", this.zzNT);
    return zzE(localHashMap);
  }
  
  public ProductAction zzAf()
  {
    return this.zzNT;
  }
  
  public List<Product> zzAg()
  {
    return Collections.unmodifiableList(this.zzNW);
  }
  
  public Map<String, List<Product>> zzAh()
  {
    return this.zzNU;
  }
  
  public List<Promotion> zzAi()
  {
    return Collections.unmodifiableList(this.zzNV);
  }
  
  public void zza(Product paramProduct, String paramString)
  {
    if (paramProduct == null) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.zzNU.containsKey(str)) {
      this.zzNU.put(str, new ArrayList());
    }
    ((List)this.zzNU.get(str)).add(paramProduct);
  }
  
  public void zza(zzqk paramzzqk)
  {
    paramzzqk.zzNW.addAll(this.zzNW);
    paramzzqk.zzNV.addAll(this.zzNV);
    Iterator localIterator = this.zzNU.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramzzqk.zza((Product)((Iterator)localObject).next(), str);
      }
    }
    if (this.zzNT != null) {
      paramzzqk.zzNT = this.zzNT;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */