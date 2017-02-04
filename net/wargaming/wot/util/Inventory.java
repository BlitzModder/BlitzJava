package net.wargaming.wot.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory
{
  Map<String, Purchase> mPurchaseMap = new HashMap();
  Map<String, SkuDetails> mSkuMap = new HashMap();
  
  public void addPurchase(Purchase paramPurchase)
  {
    this.mPurchaseMap.put(paramPurchase.getSku(), paramPurchase);
  }
  
  public void addSkuDetails(SkuDetails paramSkuDetails)
  {
    this.mSkuMap.put(paramSkuDetails.getSku(), paramSkuDetails);
  }
  
  public List<String> getAllOwnedSkus(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPurchaseMap.values().iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      if (localPurchase.getItemType().equals(paramString)) {
        localArrayList.add(localPurchase.getSku());
      }
    }
    return localArrayList;
  }
  
  public List<Purchase> getAllPurchases()
  {
    return new ArrayList(this.mPurchaseMap.values());
  }
  
  public List<SkuDetails> getAllSkus()
  {
    return new ArrayList(this.mSkuMap.values());
  }
  
  public SkuDetails getSkuDetails(String paramString)
  {
    return (SkuDetails)this.mSkuMap.get(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/Inventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */