package net.wargaming.wot.util;

import net.wargaming.wot.blitz.ShopAndroidJavaImpl;

public class IabResult
{
  String mMessage;
  int mResponse;
  
  public IabResult(int paramInt, String paramString)
  {
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = ShopAndroidJavaImpl.getResponseDesc(paramInt);
      return;
    }
    this.mMessage = (paramString + " (response: " + ShopAndroidJavaImpl.getResponseDesc(paramInt) + ")");
  }
  
  public String getMessage()
  {
    return this.mMessage;
  }
  
  public int getResponse()
  {
    return this.mResponse;
  }
  
  public boolean isFailure()
  {
    return !isSuccess();
  }
  
  public boolean isSuccess()
  {
    return this.mResponse == 0;
  }
  
  public String toString()
  {
    return "IabResult: " + getMessage();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */