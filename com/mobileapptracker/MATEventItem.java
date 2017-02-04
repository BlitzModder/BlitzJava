package com.mobileapptracker;

import java.util.HashMap;
import org.json.JSONObject;

public class MATEventItem
{
  public String attribute_sub1;
  public String attribute_sub2;
  public String attribute_sub3;
  public String attribute_sub4;
  public String attribute_sub5;
  public String itemname;
  public int quantity;
  public double revenue;
  public double unitPrice;
  
  public MATEventItem(String paramString)
  {
    this.itemname = paramString;
  }
  
  public String getAttrStringByName(String paramString)
  {
    if (paramString.equals("itemname")) {
      return this.itemname;
    }
    if (paramString.equals("quantity")) {
      return Integer.toString(this.quantity);
    }
    if (paramString.equals("unitPrice")) {
      return Double.toString(this.unitPrice);
    }
    if (paramString.equals("revenue")) {
      return Double.toString(this.revenue);
    }
    if (paramString.equals("attribute_sub1")) {
      return this.attribute_sub1;
    }
    if (paramString.equals("attribute_sub2")) {
      return this.attribute_sub2;
    }
    if (paramString.equals("attribute_sub3")) {
      return this.attribute_sub3;
    }
    if (paramString.equals("attribute_sub4")) {
      return this.attribute_sub4;
    }
    if (paramString.equals("attribute_sub5")) {
      return this.attribute_sub5;
    }
    return null;
  }
  
  public JSONObject toJSON()
  {
    HashMap localHashMap = new HashMap();
    if (this.itemname != null) {
      localHashMap.put("item", this.itemname);
    }
    localHashMap.put("quantity", Integer.toString(this.quantity));
    localHashMap.put("unit_price", Double.toString(this.unitPrice));
    if (this.revenue != 0.0D) {
      localHashMap.put("revenue", Double.toString(this.revenue));
    }
    if (this.attribute_sub1 != null) {
      localHashMap.put("attribute_sub1", this.attribute_sub1);
    }
    if (this.attribute_sub2 != null) {
      localHashMap.put("attribute_sub2", this.attribute_sub2);
    }
    if (this.attribute_sub3 != null) {
      localHashMap.put("attribute_sub3", this.attribute_sub3);
    }
    if (this.attribute_sub4 != null) {
      localHashMap.put("attribute_sub4", this.attribute_sub4);
    }
    if (this.attribute_sub5 != null) {
      localHashMap.put("attribute_sub5", this.attribute_sub5);
    }
    return new JSONObject(localHashMap);
  }
  
  public MATEventItem withAttribute1(String paramString)
  {
    this.attribute_sub1 = paramString;
    return this;
  }
  
  public MATEventItem withAttribute2(String paramString)
  {
    this.attribute_sub2 = paramString;
    return this;
  }
  
  public MATEventItem withAttribute3(String paramString)
  {
    this.attribute_sub3 = paramString;
    return this;
  }
  
  public MATEventItem withAttribute4(String paramString)
  {
    this.attribute_sub4 = paramString;
    return this;
  }
  
  public MATEventItem withAttribute5(String paramString)
  {
    this.attribute_sub5 = paramString;
    return this;
  }
  
  public MATEventItem withQuantity(int paramInt)
  {
    this.quantity = paramInt;
    return this;
  }
  
  public MATEventItem withRevenue(double paramDouble)
  {
    this.revenue = paramDouble;
    return this;
  }
  
  public MATEventItem withUnitPrice(double paramDouble)
  {
    this.unitPrice = paramDouble;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATEventItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */