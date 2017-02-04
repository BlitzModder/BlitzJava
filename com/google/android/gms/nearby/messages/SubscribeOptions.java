package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class SubscribeOptions
{
  public static final SubscribeOptions DEFAULT = new Builder().build();
  private final Strategy zzaWL;
  private final MessageFilter zzaWY;
  private final SubscribeCallback zzaWZ;
  
  private SubscribeOptions(Strategy paramStrategy, MessageFilter paramMessageFilter, SubscribeCallback paramSubscribeCallback)
  {
    this.zzaWL = paramStrategy;
    this.zzaWY = paramMessageFilter;
    this.zzaWZ = paramSubscribeCallback;
  }
  
  public SubscribeCallback getCallback()
  {
    return this.zzaWZ;
  }
  
  public MessageFilter getFilter()
  {
    return this.zzaWY;
  }
  
  public Strategy getStrategy()
  {
    return this.zzaWL;
  }
  
  public static class Builder
  {
    private Strategy zzaWL = Strategy.DEFAULT;
    private MessageFilter zzaWY = MessageFilter.INCLUDE_ALL_MY_TYPES;
    private SubscribeCallback zzaWZ;
    
    public SubscribeOptions build()
    {
      return new SubscribeOptions(this.zzaWL, this.zzaWY, this.zzaWZ, null);
    }
    
    public Builder setCallback(SubscribeCallback paramSubscribeCallback)
    {
      this.zzaWZ = ((SubscribeCallback)zzx.zzy(paramSubscribeCallback));
      return this;
    }
    
    public Builder setFilter(MessageFilter paramMessageFilter)
    {
      this.zzaWY = paramMessageFilter;
      return this;
    }
    
    public Builder setStrategy(Strategy paramStrategy)
    {
      this.zzaWL = paramStrategy;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/SubscribeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */