package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.concurrent.TimeUnit;

public class Session
  implements SafeParcelable
{
  public static final Parcelable.Creator<Session> CREATOR = new zzp();
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
  private final String mName;
  private final int mVersionCode;
  private final long zzQj;
  private final long zzatQ;
  private final int zzaua;
  private final Application zzaun;
  private final String zzavb;
  private final String zzavc;
  private final Long zzavd;
  
  Session(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, Application paramApplication, Long paramLong)
  {
    this.mVersionCode = paramInt1;
    this.zzQj = paramLong1;
    this.zzatQ = paramLong2;
    this.mName = paramString1;
    this.zzavb = paramString2;
    this.zzavc = paramString3;
    this.zzaua = paramInt2;
    this.zzaun = paramApplication;
    this.zzavd = paramLong;
  }
  
  public Session(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, Application paramApplication, Long paramLong)
  {
    this(3, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramInt, paramApplication, paramLong);
  }
  
  private Session(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder));
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)zzc.zza(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public static String getMimeType(String paramString)
  {
    return "vnd.google.fitness.session/" + paramString;
  }
  
  private boolean zza(Session paramSession)
  {
    return (this.zzQj == paramSession.zzQj) && (this.zzatQ == paramSession.zzatQ) && (zzw.equal(this.mName, paramSession.mName)) && (zzw.equal(this.zzavb, paramSession.zzavb)) && (zzw.equal(this.zzavc, paramSession.zzavc)) && (zzw.equal(this.zzaun, paramSession.zzaun)) && (this.zzaua == paramSession.zzaua);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Session)) && (zza((Session)paramObject)));
  }
  
  public long getActiveTime(TimeUnit paramTimeUnit)
  {
    if (this.zzavd != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Active time is not set");
      return paramTimeUnit.convert(this.zzavd.longValue(), TimeUnit.MILLISECONDS);
    }
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.zzaua);
  }
  
  public String getAppPackageName()
  {
    if (this.zzaun == null) {
      return null;
    }
    return this.zzaun.getPackageName();
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
  }
  
  public String getIdentifier()
  {
    return this.zzavb;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasActiveTime()
  {
    return this.zzavd != null;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), this.zzavb });
  }
  
  public boolean isOngoing()
  {
    return this.zzatQ == 0L;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("name", this.mName).zzg("identifier", this.zzavb).zzg("description", this.zzavc).zzg("activity", Integer.valueOf(this.zzaua)).zzg("application", this.zzaun).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  public long zzlx()
  {
    return this.zzQj;
  }
  
  public long zztB()
  {
    return this.zzatQ;
  }
  
  public Application zztK()
  {
    return this.zzaun;
  }
  
  public Long zztS()
  {
    return this.zzavd;
  }
  
  public int zztz()
  {
    return this.zzaua;
  }
  
  public static class Builder
  {
    private String mName = null;
    private long zzQj = 0L;
    private long zzatQ = 0L;
    private int zzaua = 4;
    private Application zzaun;
    private String zzavb;
    private String zzavc;
    private Long zzavd;
    
    public Session build()
    {
      boolean bool2 = false;
      boolean bool1;
      StringBuilder localStringBuilder;
      if (this.zzQj > 0L)
      {
        bool1 = true;
        zzx.zza(bool1, "Start time should be specified.");
        if (this.zzatQ != 0L)
        {
          bool1 = bool2;
          if (this.zzatQ <= this.zzQj) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "End time should be later than start time.");
        if (this.zzavb == null)
        {
          localStringBuilder = new StringBuilder();
          if (this.mName != null) {
            break label111;
          }
        }
      }
      label111:
      for (String str = "";; str = this.mName)
      {
        this.zzavb = (str + this.zzQj);
        return new Session(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setActiveTime(long paramLong, TimeUnit paramTimeUnit)
    {
      this.zzavd = Long.valueOf(paramTimeUnit.toMillis(paramLong));
      return this;
    }
    
    public Builder setActivity(String paramString)
    {
      return zzeV(FitnessActivities.zzdd(paramString));
    }
    
    public Builder setDescription(String paramString)
    {
      if (paramString.length() <= 1000) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Session description cannot exceed %d characters", new Object[] { Integer.valueOf(1000) });
        this.zzavc = paramString;
        return this;
      }
    }
    
    public Builder setEndTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "End time should be positive.");
        this.zzatQ = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
    
    public Builder setIdentifier(String paramString)
    {
      if ((paramString != null) && (TextUtils.getTrimmedLength(paramString) > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzab(bool);
        this.zzavb = paramString;
        return this;
      }
    }
    
    public Builder setName(String paramString)
    {
      if (paramString.length() <= 100) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Session name cannot exceed %d characters", new Object[] { Integer.valueOf(100) });
        this.mName = paramString;
        return this;
      }
    }
    
    public Builder setStartTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Start time should be positive.");
        this.zzQj = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
    
    public Builder zzeV(int paramInt)
    {
      this.zzaua = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */