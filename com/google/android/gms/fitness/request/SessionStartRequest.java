package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionStartRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzx();
  private final int mVersionCode;
  private final Session zzatS;
  private final zzpp zzayj;
  
  SessionStartRequest(int paramInt, Session paramSession, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzatS = paramSession;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public SessionStartRequest(Session paramSession, zzpp paramzzpp)
  {
    com.google.android.gms.common.internal.zzx.zzb(paramSession.isOngoing(), "Cannot start a session which has already ended");
    this.mVersionCode = 3;
    this.zzatS = paramSession;
    this.zzayj = paramzzpp;
  }
  
  private boolean zzb(SessionStartRequest paramSessionStartRequest)
  {
    return zzw.equal(this.zzatS, paramSessionStartRequest.zzatS);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionStartRequest)) && (zzb((SessionStartRequest)paramObject)));
  }
  
  public Session getSession()
  {
    return this.zzatS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatS });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("session", this.zzatS).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzx.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionStartRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */