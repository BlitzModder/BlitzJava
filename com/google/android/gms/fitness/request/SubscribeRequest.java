package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzac();
  private final int mVersionCode;
  private final zzpp zzayj;
  private Subscription zzazi;
  private final boolean zzazj;
  
  SubscribeRequest(int paramInt, Subscription paramSubscription, boolean paramBoolean, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzazi = paramSubscription;
    this.zzazj = paramBoolean;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public SubscribeRequest(Subscription paramSubscription, boolean paramBoolean, zzpp paramzzpp)
  {
    this.mVersionCode = 3;
    this.zzazi = paramSubscription;
    this.zzazj = paramBoolean;
    this.zzayj = paramzzpp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("subscription", this.zzazi).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac.zza(this, paramParcel, paramInt);
  }
  
  public Subscription zzuF()
  {
    return this.zzazi;
  }
  
  public boolean zzuG()
  {
    return this.zzazj;
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/SubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */