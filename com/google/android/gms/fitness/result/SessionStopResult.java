package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

public class SessionStopResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzk();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<Session> zzaym;
  
  SessionStopResult(int paramInt, Status paramStatus, List<Session> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzTA = paramStatus;
    this.zzaym = Collections.unmodifiableList(paramList);
  }
  
  public SessionStopResult(Status paramStatus, List<Session> paramList)
  {
    this.mVersionCode = 3;
    this.zzTA = paramStatus;
    this.zzaym = Collections.unmodifiableList(paramList);
  }
  
  public static SessionStopResult zzW(Status paramStatus)
  {
    return new SessionStopResult(paramStatus, Collections.emptyList());
  }
  
  private boolean zzb(SessionStopResult paramSessionStopResult)
  {
    return (this.zzTA.equals(paramSessionStopResult.zzTA)) && (zzw.equal(this.zzaym, paramSessionStopResult.zzaym));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionStopResult)) && (zzb((SessionStopResult)paramObject)));
  }
  
  public List<Session> getSessions()
  {
    return this.zzaym;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzaym });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("sessions", this.zzaym).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/SessionStopResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */