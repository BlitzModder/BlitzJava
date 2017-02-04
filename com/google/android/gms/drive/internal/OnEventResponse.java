package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new zzbb();
  final int mVersionCode;
  final int zzalo;
  final ChangeEvent zzaqj;
  final CompletionEvent zzaqk;
  final QueryResultEventParcelable zzaql;
  final ChangesAvailableEvent zzaqm;
  final ProgressEvent zzaqn;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent, QueryResultEventParcelable paramQueryResultEventParcelable, ChangesAvailableEvent paramChangesAvailableEvent, ProgressEvent paramProgressEvent)
  {
    this.mVersionCode = paramInt1;
    this.zzalo = paramInt2;
    this.zzaqj = paramChangeEvent;
    this.zzaqk = paramCompletionEvent;
    this.zzaql = paramQueryResultEventParcelable;
    this.zzaqm = paramChangesAvailableEvent;
    this.zzaqn = paramProgressEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbb.zza(this, paramParcel, paramInt);
  }
  
  public DriveEvent zzsT()
  {
    switch (this.zzalo)
    {
    default: 
      throw new IllegalStateException("Unexpected event type " + this.zzalo);
    case 1: 
      return this.zzaqj;
    case 2: 
      return this.zzaqk;
    case 3: 
      return this.zzaql;
    case 4: 
      return this.zzaqm;
    }
    return this.zzaqn;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */