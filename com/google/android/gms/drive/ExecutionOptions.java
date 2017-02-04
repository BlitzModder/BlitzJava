package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

public final class ExecutionOptions
{
  public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
  public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
  public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
  private final String zzanc;
  private final boolean zzand;
  private final int zzane;
  
  public ExecutionOptions(String paramString, boolean paramBoolean, int paramInt)
  {
    this.zzanc = paramString;
    this.zzand = paramBoolean;
    this.zzane = paramInt;
  }
  
  public static void zza(GoogleApiClient paramGoogleApiClient, ExecutionOptions paramExecutionOptions)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzTo);
    if ((paramExecutionOptions.zzsm()) && (!paramGoogleApiClient.zzsJ())) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
    }
  }
  
  public static boolean zzcR(String paramString)
  {
    return (paramString != null) && (!paramString.isEmpty()) && (paramString.length() <= 65536);
  }
  
  public static boolean zzcy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzcz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ExecutionOptions)paramObject;
      if ((!zzw.equal(this.zzanc, ((ExecutionOptions)paramObject).zzanc)) || (this.zzane != ((ExecutionOptions)paramObject).zzane)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzand == ((ExecutionOptions)paramObject).zzand);
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzanc, Integer.valueOf(this.zzane), Boolean.valueOf(this.zzand) });
  }
  
  public String zzsl()
  {
    return this.zzanc;
  }
  
  public boolean zzsm()
  {
    return this.zzand;
  }
  
  public int zzsn()
  {
    return this.zzane;
  }
  
  public static final class Builder
  {
    private String zzanc;
    private boolean zzand;
    private int zzane = 0;
    
    public ExecutionOptions build()
    {
      if ((this.zzane == 1) && (!this.zzand)) {
        throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
      }
      return new ExecutionOptions(this.zzanc, this.zzand, this.zzane);
    }
    
    public Builder setConflictStrategy(int paramInt)
    {
      if (!ExecutionOptions.zzcz(paramInt)) {
        throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + paramInt);
      }
      this.zzane = paramInt;
      return this;
    }
    
    public Builder setNotifyOnCompletion(boolean paramBoolean)
    {
      this.zzand = paramBoolean;
      return this;
    }
    
    public Builder setTrackingTag(String paramString)
    {
      if (!ExecutionOptions.zzcR(paramString)) {
        throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[] { Integer.valueOf(65536) }));
      }
      this.zzanc = paramString;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/ExecutionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */