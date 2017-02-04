package com.facebook.model;

import java.util.List;
import org.json.JSONArray;

public abstract interface GraphObjectList<T>
  extends List<T>
{
  public abstract <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass);
  
  public abstract JSONArray getInnerJSONArray();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/model/GraphObjectList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */