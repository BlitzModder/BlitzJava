package com.google.android.gms.nearby.messages;

public abstract class MessageListener
{
  public abstract void onFound(Message paramMessage);
  
  public void onLost(Message paramMessage) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/MessageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */