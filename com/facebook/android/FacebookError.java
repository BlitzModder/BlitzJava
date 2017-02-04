package com.facebook.android;

public class FacebookError
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private int mErrorCode = 0;
  private String mErrorType;
  
  @Deprecated
  public FacebookError(String paramString)
  {
    super(paramString);
  }
  
  @Deprecated
  public FacebookError(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    this.mErrorType = paramString2;
    this.mErrorCode = paramInt;
  }
  
  @Deprecated
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  @Deprecated
  public String getErrorType()
  {
    return this.mErrorType;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/android/FacebookError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */