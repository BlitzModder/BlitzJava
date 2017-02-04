package com.facebook;

public class FacebookAuthorizationException
  extends FacebookException
{
  static final long serialVersionUID = 1L;
  
  public FacebookAuthorizationException() {}
  
  public FacebookAuthorizationException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookAuthorizationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookAuthorizationException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/FacebookAuthorizationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */