package com.parse;

public abstract interface ConfigCallback
  extends ParseCallback2<ParseConfig, ParseException>
{
  public abstract void done(ParseConfig paramParseConfig, ParseException paramParseException);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/parse/ConfigCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */