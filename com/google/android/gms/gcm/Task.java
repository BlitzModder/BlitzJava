package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public abstract class Task
  implements Parcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle mExtras;
  private final String mTag;
  private final String zzaJt;
  private final boolean zzaJu;
  private final boolean zzaJv;
  private final int zzaJw;
  private final boolean zzaJx;
  private final zzd zzaJy;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    Log.e("Task", "Constructing a Task object using a parcel.");
    this.zzaJt = paramParcel.readString();
    this.mTag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.zzaJu = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzaJv = bool1;
      this.zzaJw = 2;
      this.zzaJx = false;
      this.zzaJy = zzd.zzaJo;
      this.mExtras = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Builder paramBuilder)
  {
    this.zzaJt = paramBuilder.gcmTaskService;
    this.mTag = paramBuilder.tag;
    this.zzaJu = paramBuilder.updateCurrent;
    this.zzaJv = paramBuilder.isPersisted;
    this.zzaJw = paramBuilder.requiredNetworkState;
    this.zzaJx = paramBuilder.requiresCharging;
    this.zzaJy = paramBuilder.zzaJz;
    this.mExtras = paramBuilder.extras;
  }
  
  private static boolean zzC(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean));
  }
  
  public static void zzF(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject, 0);
      int i = ((Parcel)localObject).dataSize();
      if (i > 10240)
      {
        ((Parcel)localObject).recycle();
        throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + i);
      }
      ((Parcel)localObject).recycle();
      localObject = paramBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!zzC(paramBundle.get((String)((Iterator)localObject).next()))) {
          throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
        }
      }
    }
  }
  
  public static void zza(zzd paramzzd)
  {
    if (paramzzd != null)
    {
      int i = paramzzd.zzxA();
      if ((i != 1) && (i != 0)) {
        throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + i);
      }
      int j = paramzzd.zzxB();
      int k = paramzzd.zzxC();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j) {
        throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + paramzzd.zzxC());
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public int getRequiredNetwork()
  {
    return this.zzaJw;
  }
  
  public boolean getRequiresCharging()
  {
    return this.zzaJx;
  }
  
  public String getServiceName()
  {
    return this.zzaJt;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public boolean isPersisted()
  {
    return this.zzaJv;
  }
  
  public boolean isUpdateCurrent()
  {
    return this.zzaJu;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", this.mTag);
    paramBundle.putBoolean("update_current", this.zzaJu);
    paramBundle.putBoolean("persisted", this.zzaJv);
    paramBundle.putString("service", this.zzaJt);
    paramBundle.putInt("requiredNetwork", this.zzaJw);
    paramBundle.putBoolean("requiresCharging", this.zzaJx);
    paramBundle.putBundle("retryStrategy", this.zzaJy.zzE(new Bundle()));
    paramBundle.putBundle("extras", this.mExtras);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.zzaJt);
    paramParcel.writeString(this.mTag);
    if (this.zzaJu)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.zzaJv) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract class Builder
  {
    protected Bundle extras;
    protected String gcmTaskService;
    protected boolean isPersisted;
    protected int requiredNetworkState;
    protected boolean requiresCharging;
    protected String tag;
    protected boolean updateCurrent;
    protected zzd zzaJz = zzd.zzaJo;
    
    public abstract Task build();
    
    protected void checkConditions()
    {
      if (this.gcmTaskService != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
        GcmNetworkManager.zzdE(this.tag);
        Task.zza(this.zzaJz);
        if (this.isPersisted) {
          Task.zzF(this.extras);
        }
        return;
      }
    }
    
    public abstract Builder setExtras(Bundle paramBundle);
    
    public abstract Builder setPersisted(boolean paramBoolean);
    
    public abstract Builder setRequiredNetwork(int paramInt);
    
    public abstract Builder setRequiresCharging(boolean paramBoolean);
    
    public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
    
    public abstract Builder setTag(String paramString);
    
    public abstract Builder setUpdateCurrent(boolean paramBoolean);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */