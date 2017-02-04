package io.fabric.sdk.android.services.events;

import java.io.IOException;

public abstract interface FileRollOverManager
{
  public abstract void cancelTimeBasedFileRollOver();
  
  public abstract boolean rollFileOver()
    throws IOException;
  
  public abstract void scheduleTimeBasedRollOverIfNeeded();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/events/FileRollOverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */