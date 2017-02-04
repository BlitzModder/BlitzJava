package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<SignInConfiguration>
{
  static void zza(SignInConfiguration paramSignInConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramSignInConfiguration.versionCode);
    zzb.zza(paramParcel, 2, paramSignInConfiguration.zzmP(), false);
    zzb.zza(paramParcel, 3, paramSignInConfiguration.zzmB(), false);
    zzb.zza(paramParcel, 4, paramSignInConfiguration.zzmQ(), paramInt, false);
    zzb.zza(paramParcel, 5, paramSignInConfiguration.zzmR(), paramInt, false);
    zzb.zza(paramParcel, 6, paramSignInConfiguration.zzmS(), paramInt, false);
    zzb.zza(paramParcel, 7, paramSignInConfiguration.zzmT(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SignInConfiguration zzV(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    FacebookSignInOptions localFacebookSignInOptions = null;
    GoogleSignInOptions localGoogleSignInOptions = null;
    EmailSignInOptions localEmailSignInOptions = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localEmailSignInOptions = (EmailSignInOptions)zza.zza(paramParcel, k, EmailSignInOptions.CREATOR);
        break;
      case 5: 
        localGoogleSignInOptions = (GoogleSignInOptions)zza.zza(paramParcel, k, GoogleSignInOptions.CREATOR);
        break;
      case 6: 
        localFacebookSignInOptions = (FacebookSignInOptions)zza.zza(paramParcel, k, FacebookSignInOptions.CREATOR);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SignInConfiguration(i, str3, str2, localEmailSignInOptions, localGoogleSignInOptions, localFacebookSignInOptions, str1);
  }
  
  public SignInConfiguration[] zzaQ(int paramInt)
  {
    return new SignInConfiguration[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */