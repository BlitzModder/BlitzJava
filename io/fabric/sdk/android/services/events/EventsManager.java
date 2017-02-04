package io.fabric.sdk.android.services.events;

public abstract interface EventsManager<T>
{
  public abstract void deleteAllEvents();
  
  public abstract void recordEvent(T paramT);
  
  public abstract void sendEvents();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/events/EventsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */