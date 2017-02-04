package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;

public final class PublishOptions
{
  public static final PublishOptions DEFAULT = new Builder().build();
  private final Strategy zzaWL;
  private final PublishCallback zzaWM;
  
  private PublishOptions(Strategy paramStrategy, PublishCallback paramPublishCallback)
  {
    this.zzaWL = paramStrategy;
    this.zzaWM = paramPublishCallback;
  }
  
  public PublishCallback getCallback()
  {
    return this.zzaWM;
  }
  
  public Strategy getStrategy()
  {
    return this.zzaWL;
  }
  
  public static class Builder
  {
    private Strategy zzaWL = Strategy.DEFAULT;
    private PublishCallback zzaWM;
    
    public PublishOptions build()
    {
      return new PublishOptions(this.zzaWL, this.zzaWM, null);
    }
    
    public Builder setCallback(PublishCallback paramPublishCallback)
    {
      this.zzaWM = ((PublishCallback)zzx.zzy(paramPublishCallback));
      return this;
    }
    
    public Builder setStrategy(Strategy paramStrategy)
    {
      this.zzaWL = ((Strategy)zzx.zzy(paramStrategy));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/PublishOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */