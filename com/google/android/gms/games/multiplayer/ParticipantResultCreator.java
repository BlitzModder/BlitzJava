package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ParticipantResultCreator
  implements Parcelable.Creator<ParticipantResult>
{
  static void zza(ParticipantResult paramParticipantResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramParticipantResult.getParticipantId(), false);
    zzb.zzc(paramParcel, 1000, paramParticipantResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramParticipantResult.getResult());
    zzb.zzc(paramParcel, 3, paramParticipantResult.getPlacing());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParticipantResult zzel(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzau(paramParcel);
    String str = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        str = zza.zzp(paramParcel, n);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ParticipantResult(i, str, j, k);
  }
  
  public ParticipantResult[] zzgB(int paramInt)
  {
    return new ParticipantResult[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantResultCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */