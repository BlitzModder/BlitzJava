package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznm;
import java.util.Set;

public final class UserDataType
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public static final UserDataType zzaNe = zzy("test_type", 1);
  public static final UserDataType zzaNf = zzy("labeled_place", 6);
  public static final UserDataType zzaNg = zzy("here_content", 7);
  public static final Set<UserDataType> zzaNh = zznm.zza(zzaNe, zzaNf, zzaNg);
  final int mVersionCode;
  final String zzIx;
  final int zzaNi;
  
  UserDataType(int paramInt1, String paramString, int paramInt2)
  {
    zzx.zzcG(paramString);
    this.mVersionCode = paramInt1;
    this.zzIx = paramString;
    this.zzaNi = paramInt2;
  }
  
  private static UserDataType zzy(String paramString, int paramInt)
  {
    return new UserDataType(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    zzm localzzm = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UserDataType)) {
        return false;
      }
      paramObject = (UserDataType)paramObject;
    } while ((this.zzIx.equals(((UserDataType)paramObject).zzIx)) && (this.zzaNi == ((UserDataType)paramObject).zzaNi));
    return false;
  }
  
  public int hashCode()
  {
    return this.zzIx.hashCode();
  }
  
  public String toString()
  {
    return this.zzIx;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm localzzm = CREATOR;
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/UserDataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */