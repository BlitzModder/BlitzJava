package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionUnregistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionUnregistrationRequest> CREATOR = new zzz();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final zzpp zzayj;
  
  SessionUnregistrationRequest(int paramInt, PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mPendingIntent = paramPendingIntent;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public SessionUnregistrationRequest(PendingIntent paramPendingIntent, zzpp paramzzpp)
  {
    this.mVersionCode = 5;
    this.mPendingIntent = paramPendingIntent;
    this.zzayj = paramzzpp;
  }
  
  private boolean zzb(SessionUnregistrationRequest paramSessionUnregistrationRequest)
  {
    return zzw.equal(this.mPendingIntent, paramSessionUnregistrationRequest.mPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionUnregistrationRequest)) && (zzb((SessionUnregistrationRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mPendingIntent });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("pendingIntent", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzz.zza(this, paramParcel, paramInt);
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


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionUnregistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */