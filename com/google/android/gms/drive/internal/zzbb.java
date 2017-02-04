package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzbb
  implements Parcelable.Creator<OnEventResponse>
{
  static void zza(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnEventResponse.mVersionCode);
    zzb.zzc(paramParcel, 2, paramOnEventResponse.zzalo);
    zzb.zza(paramParcel, 3, paramOnEventResponse.zzaqj, paramInt, false);
    zzb.zza(paramParcel, 5, paramOnEventResponse.zzaqk, paramInt, false);
    zzb.zza(paramParcel, 6, paramOnEventResponse.zzaql, paramInt, false);
    zzb.zza(paramParcel, 7, paramOnEventResponse.zzaqm, paramInt, false);
    zzb.zza(paramParcel, 8, paramOnEventResponse.zzaqn, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnEventResponse zzbB(Parcel paramParcel)
  {
    int i = 0;
    ProgressEvent localProgressEvent = null;
    int k = zza.zzau(paramParcel);
    ChangesAvailableEvent localChangesAvailableEvent = null;
    QueryResultEventParcelable localQueryResultEventParcelable = null;
    CompletionEvent localCompletionEvent = null;
    ChangeEvent localChangeEvent = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      case 4: 
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localChangeEvent = (ChangeEvent)zza.zza(paramParcel, m, ChangeEvent.CREATOR);
        break;
      case 5: 
        localCompletionEvent = (CompletionEvent)zza.zza(paramParcel, m, CompletionEvent.CREATOR);
        break;
      case 6: 
        localQueryResultEventParcelable = (QueryResultEventParcelable)zza.zza(paramParcel, m, QueryResultEventParcelable.CREATOR);
        break;
      case 7: 
        localChangesAvailableEvent = (ChangesAvailableEvent)zza.zza(paramParcel, m, ChangesAvailableEvent.CREATOR);
        break;
      case 8: 
        localProgressEvent = (ProgressEvent)zza.zza(paramParcel, m, ProgressEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new OnEventResponse(j, i, localChangeEvent, localCompletionEvent, localQueryResultEventParcelable, localChangesAvailableEvent, localProgressEvent);
  }
  
  public OnEventResponse[] zzdw(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */