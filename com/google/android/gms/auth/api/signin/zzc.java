package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void zza(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramGoogleSignInAccount.versionCode);
    zzb.zza(paramParcel, 2, paramGoogleSignInAccount.getId(), false);
    zzb.zza(paramParcel, 3, paramGoogleSignInAccount.getIdToken(), false);
    zzb.zza(paramParcel, 4, paramGoogleSignInAccount.getEmail(), false);
    zzb.zza(paramParcel, 5, paramGoogleSignInAccount.getDisplayName(), false);
    zzb.zza(paramParcel, 6, paramGoogleSignInAccount.getPhotoUrl(), paramInt, false);
    zzb.zza(paramParcel, 7, paramGoogleSignInAccount.getServerAuthCode(), false);
    zzb.zza(paramParcel, 8, paramGoogleSignInAccount.zzmv());
    zzb.zza(paramParcel, 9, paramGoogleSignInAccount.zzmw(), false);
    zzb.zzc(paramParcel, 10, paramGoogleSignInAccount.zzTV, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GoogleSignInAccount zzR(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    long l = 0L;
    String str1 = null;
    String str2 = null;
    Uri localUri = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
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
        str6 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        l = zza.zzi(paramParcel, k);
        break;
      case 9: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 10: 
        localArrayList = zza.zzc(paramParcel, k, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInAccount(i, str6, str5, str4, str3, localUri, str2, l, str1, localArrayList);
  }
  
  public GoogleSignInAccount[] zzaM(int paramInt)
  {
    return new GoogleSignInAccount[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */