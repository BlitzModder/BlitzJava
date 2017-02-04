package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new Parcelable.Creator()
  {
    public OneoffTask zzez(Parcel paramAnonymousParcel)
    {
      return new OneoffTask(paramAnonymousParcel, null);
    }
    
    public OneoffTask[] zzgW(int paramAnonymousInt)
    {
      return new OneoffTask[paramAnonymousInt];
    }
  };
  private final long zzaJi;
  private final long zzaJj;
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.zzaJi = paramParcel.readLong();
    this.zzaJj = paramParcel.readLong();
  }
  
  private OneoffTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.zzaJi = Builder.zza(paramBuilder);
    this.zzaJj = Builder.zzb(paramBuilder);
  }
  
  public long getWindowEnd()
  {
    return this.zzaJj;
  }
  
  public long getWindowStart()
  {
    return this.zzaJi;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzaJi);
    paramBundle.putLong("window_end", this.zzaJj);
  }
  
  public String toString()
  {
    return super.toString() + " " + "windowStart=" + getWindowStart() + " " + "windowEnd=" + getWindowEnd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzaJi);
    paramParcel.writeLong(this.zzaJj);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaJk = -1L;
    private long zzaJl = -1L;
    
    public Builder()
    {
      this.isPersisted = false;
    }
    
    public OneoffTask build()
    {
      checkConditions();
      return new OneoffTask(this, null);
    }
    
    protected void checkConditions()
    {
      super.checkConditions();
      if ((this.zzaJk == -1L) || (this.zzaJl == -1L)) {
        throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
      }
      if (this.zzaJk >= this.zzaJl) {
        throw new IllegalArgumentException("Window start must be shorter than window end.");
      }
    }
    
    public Builder setExecutionWindow(long paramLong1, long paramLong2)
    {
      this.zzaJk = paramLong1;
      this.zzaJl = paramLong2;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setPersisted(boolean paramBoolean)
    {
      this.isPersisted = paramBoolean;
      return this;
    }
    
    public Builder setRequiredNetwork(int paramInt)
    {
      this.requiredNetworkState = paramInt;
      return this;
    }
    
    public Builder setRequiresCharging(boolean paramBoolean)
    {
      this.requiresCharging = paramBoolean;
      return this;
    }
    
    public Builder setService(Class<? extends GcmTaskService> paramClass)
    {
      this.gcmTaskService = paramClass.getName();
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      this.tag = paramString;
      return this;
    }
    
    public Builder setUpdateCurrent(boolean paramBoolean)
    {
      this.updateCurrent = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/OneoffTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */