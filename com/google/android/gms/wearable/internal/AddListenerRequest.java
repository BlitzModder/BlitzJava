package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzc();
  final int mVersionCode;
  public final zzba zzbmw;
  public final IntentFilter[] zzbmx;
  public final String zzbmy;
  public final String zzbmz;
  
  AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null) {}
    for (this.zzbmw = zzba.zza.zzeq(paramIBinder);; this.zzbmw = null)
    {
      this.zzbmx = paramArrayOfIntentFilter;
      this.zzbmy = paramString1;
      this.zzbmz = paramString2;
      return;
    }
  }
  
  public AddListenerRequest(zzcf paramzzcf)
  {
    this.mVersionCode = 1;
    this.zzbmw = paramzzcf;
    this.zzbmx = paramzzcf.zzGZ();
    this.zzbmy = paramzzcf.zzHa();
    this.zzbmz = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzGB()
  {
    if (this.zzbmw == null) {
      return null;
    }
    return this.zzbmw.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/AddListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */