package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionRegistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionRegistrationRequest> CREATOR = new zzw();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final zzpp zzayj;
  private final int zzaze;
  
  SessionRegistrationRequest(int paramInt1, PendingIntent paramPendingIntent, IBinder paramIBinder, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.mPendingIntent = paramPendingIntent;
    if (paramIBinder == null) {}
    for (paramPendingIntent = null;; paramPendingIntent = zzpp.zza.zzbR(paramIBinder))
    {
      this.zzayj = paramPendingIntent;
      this.zzaze = paramInt2;
      return;
    }
  }
  
  public SessionRegistrationRequest(PendingIntent paramPendingIntent, zzpp paramzzpp, int paramInt)
  {
    this.mVersionCode = 6;
    this.mPendingIntent = paramPendingIntent;
    this.zzayj = paramzzpp;
    this.zzaze = paramInt;
  }
  
  private boolean zzb(SessionRegistrationRequest paramSessionRegistrationRequest)
  {
    return (this.zzaze == paramSessionRegistrationRequest.zzaze) && (com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, paramSessionRegistrationRequest.mPendingIntent));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionRegistrationRequest)) && (zzb((SessionRegistrationRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return com.google.android.gms.common.internal.zzw.hashCode(new Object[] { this.mPendingIntent, Integer.valueOf(this.zzaze) });
  }
  
  public String toString()
  {
    return com.google.android.gms.common.internal.zzw.zzx(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaze)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzw.zza(this, paramParcel, paramInt);
  }
  
  public int zzuD()
  {
    return this.zzaze;
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public PendingIntent zzuu()
  {
    return this.mPendingIntent;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionRegistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */