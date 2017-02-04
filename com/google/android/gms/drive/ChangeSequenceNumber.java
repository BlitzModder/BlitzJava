package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zztk;

public class ChangeSequenceNumber
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
  final int mVersionCode;
  final long zzamA;
  final long zzamB;
  private volatile String zzamC = null;
  final long zzamz;
  
  ChangeSequenceNumber(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != -1L)
    {
      bool1 = true;
      zzx.zzab(bool1);
      if (paramLong2 == -1L) {
        break label92;
      }
      bool1 = true;
      label40:
      zzx.zzab(bool1);
      if (paramLong3 == -1L) {
        break label98;
      }
    }
    label92:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzab(bool1);
      this.mVersionCode = paramInt;
      this.zzamz = paramLong1;
      this.zzamA = paramLong2;
      this.zzamB = paramLong3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.zzamC == null)
    {
      String str = Base64.encodeToString(zzse(), 10);
      this.zzamC = ("ChangeSequenceNumber:" + str);
    }
    return this.zzamC;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChangeSequenceNumber)) {}
    do
    {
      return false;
      paramObject = (ChangeSequenceNumber)paramObject;
    } while ((((ChangeSequenceNumber)paramObject).zzamA != this.zzamA) || (((ChangeSequenceNumber)paramObject).zzamB != this.zzamB) || (((ChangeSequenceNumber)paramObject).zzamz != this.zzamz));
    return true;
  }
  
  public int hashCode()
  {
    return (String.valueOf(this.zzamz) + String.valueOf(this.zzamA) + String.valueOf(this.zzamB)).hashCode();
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  final byte[] zzse()
  {
    zzas localzzas = new zzas();
    localzzas.versionCode = this.mVersionCode;
    localzzas.zzapS = this.zzamz;
    localzzas.zzapT = this.zzamA;
    localzzas.zzapU = this.zzamB;
    return zztk.toByteArray(localzzas);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/ChangeSequenceNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */