package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<CompletionEvent>
{
  static void zza(CompletionEvent paramCompletionEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCompletionEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramCompletionEvent.zzamF, paramInt, false);
    zzb.zza(paramParcel, 3, paramCompletionEvent.zzTD, false);
    zzb.zza(paramParcel, 4, paramCompletionEvent.zzanH, paramInt, false);
    zzb.zza(paramParcel, 5, paramCompletionEvent.zzanI, paramInt, false);
    zzb.zza(paramParcel, 6, paramCompletionEvent.zzanJ, paramInt, false);
    zzb.zzb(paramParcel, 7, paramCompletionEvent.zzanK, false);
    zzb.zzc(paramParcel, 8, paramCompletionEvent.zzAk);
    zzb.zza(paramParcel, 9, paramCompletionEvent.zzanL, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CompletionEvent zzaT(Parcel paramParcel)
  {
    int i = 0;
    IBinder localIBinder = null;
    int k = zza.zzau(paramParcel);
    ArrayList localArrayList = null;
    MetadataBundle localMetadataBundle = null;
    ParcelFileDescriptor localParcelFileDescriptor1 = null;
    ParcelFileDescriptor localParcelFileDescriptor2 = null;
    String str = null;
    DriveId localDriveId = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        break;
      case 3: 
        str = zza.zzp(paramParcel, m);
        break;
      case 4: 
        localParcelFileDescriptor2 = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localParcelFileDescriptor1 = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 6: 
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 7: 
        localArrayList = zza.zzD(paramParcel, m);
        break;
      case 8: 
        i = zza.zzg(paramParcel, m);
        break;
      case 9: 
        localIBinder = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CompletionEvent(j, localDriveId, str, localParcelFileDescriptor2, localParcelFileDescriptor1, localMetadataBundle, localArrayList, i, localIBinder);
  }
  
  public CompletionEvent[] zzcI(int paramInt)
  {
    return new CompletionEvent[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */