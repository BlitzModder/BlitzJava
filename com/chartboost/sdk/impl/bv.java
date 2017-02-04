package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.io.Writer;

public class bv
  extends Writer
  implements Serializable
{
  private final StringBuilder a;
  
  public bv()
  {
    this.a = new StringBuilder();
  }
  
  public bv(int paramInt)
  {
    this.a = new StringBuilder(paramInt);
  }
  
  public Writer append(char paramChar)
  {
    this.a.append(paramChar);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
  {
    this.a.append(paramCharSequence);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.a.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public void write(String paramString)
  {
    if (paramString != null) {
      this.a.append(paramString);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar != null) {
      this.a.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */