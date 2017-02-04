package io.fabric.sdk.android.services.concurrency;

public abstract interface DelegateProvider
{
  public abstract <T extends Dependency<Task>,  extends PriorityProvider,  extends Task> T getDelegate();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/concurrency/DelegateProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */