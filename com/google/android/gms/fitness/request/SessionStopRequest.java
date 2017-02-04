package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpo.zza;

public class SessionStopRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionStopRequest> CREATOR = new zzy();
  private final String mName;
  private final int mVersionCode;
  private final String zzavb;
  private final zzpo zzazf;
  
  SessionStopRequest(int paramInt, String paramString1, String paramString2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString1;
    this.zzavb = paramString2;
    this.zzazf = zzpo.zza.zzbQ(paramIBinder);
  }
  
  public SessionStopRequest(String paramString1, String paramString2, zzpo paramzzpo)
  {
    this.mVersionCode = 3;
    this.mName = paramString1;
    this.zzavb = paramString2;
    this.zzazf = paramzzpo;
  }
  
  private boolean zzb(SessionStopRequest paramSessionStopRequest)
  {
    return (zzw.equal(this.mName, paramSessionStopRequest.mName)) && (zzw.equal(this.zzavb, paramSessionStopRequest.zzavb));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionStopRequest)) && (zzb((SessionStopRequest)paramObject)));
  }
  
  public String getIdentifier()
  {
    return this.zzavb;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName, this.zzavb });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.mName).zzg("identifier", this.zzavb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzazf == null) {
      return null;
    }
    return this.zzazf.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SessionStopRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */