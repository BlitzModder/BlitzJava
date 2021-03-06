package com.facebook.model;

public abstract interface GraphPlace
  extends GraphObject
{
  public abstract String getCategory();
  
  public abstract String getId();
  
  public abstract GraphLocation getLocation();
  
  public abstract String getName();
  
  public abstract void setCategory(String paramString);
  
  public abstract void setId(String paramString);
  
  public abstract void setLocation(GraphLocation paramGraphLocation);
  
  public abstract void setName(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/model/GraphPlace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */