package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<FacebookSignInOptions>
{
  static void zza(FacebookSignInOptions paramFacebookSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramFacebookSignInOptions.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramFacebookSignInOptions.zzmt(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, 3, paramFacebookSignInOptions.zzmu(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FacebookSignInOptions zzQ(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Intent localIntent = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localIntent = (Intent)zza.zza(paramParcel, k, Intent.CREATOR);
        continue;
        localArrayList = zza.zzD(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FacebookSignInOptions(i, localIntent, localArrayList);
  }
  
  public FacebookSignInOptions[] zzaL(int paramInt)
  {
    return new FacebookSignInOptions[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */