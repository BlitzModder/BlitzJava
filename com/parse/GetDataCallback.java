package com.parse;

public abstract interface GetDataCallback
  extends ParseCallback2<byte[], ParseException>
{
  public abstract void done(byte[] paramArrayOfByte, ParseException paramParseException);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/parse/GetDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */