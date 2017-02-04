package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<EmailSignInOptions>
{
  static void zza(EmailSignInOptions paramEmailSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramEmailSignInOptions.versionCode);
    zzb.zza(paramParcel, 2, paramEmailSignInOptions.zzmo(), paramInt, false);
    zzb.zza(paramParcel, 3, paramEmailSignInOptions.zzmq(), false);
    zzb.zza(paramParcel, 4, paramEmailSignInOptions.zzmp(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public EmailSignInOptions zzP(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new EmailSignInOptions(i, (Uri)localObject1, (String)localObject2, localUri);
  }
  
  public EmailSignInOptions[] zzaK(int paramInt)
  {
    return new EmailSignInOptions[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */