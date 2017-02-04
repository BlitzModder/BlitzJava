package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class SessionDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionDataSet> CREATOR = new zzq();
  final int mVersionCode;
  private final Session zzatS;
  private final DataSet zzave;
  
  SessionDataSet(int paramInt, Session paramSession, DataSet paramDataSet)
  {
    this.mVersionCode = paramInt;
    this.zzatS = paramSession;
    this.zzave = paramDataSet;
  }
  
  private boolean zza(SessionDataSet paramSessionDataSet)
  {
    return (zzw.equal(this.zzatS, paramSessionDataSet.zzatS)) && (zzw.equal(this.zzave, paramSessionDataSet.zzave));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionDataSet)) && (zza((SessionDataSet)paramObject)));
  }
  
  public Session getSession()
  {
    return this.zzatS;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatS, this.zzave });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("session", this.zzatS).zzg("dataSet", this.zzave).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  public DataSet zztT()
  {
    return this.zzave;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/SessionDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */