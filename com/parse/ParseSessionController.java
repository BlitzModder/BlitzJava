package com.parse;

import bolts.Task;

abstract interface ParseSessionController
{
  public abstract Task<ParseObject.State> getSessionAsync(String paramString);
  
  public abstract Task<Void> revokeAsync(String paramString);
  
  public abstract Task<ParseObject.State> upgradeToRevocable(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/parse/ParseSessionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */