package io.fabric.sdk.android.services.concurrency.internal;

public abstract interface Backoff
{
  public abstract long getDelayMillis(int paramInt);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/concurrency/internal/Backoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */