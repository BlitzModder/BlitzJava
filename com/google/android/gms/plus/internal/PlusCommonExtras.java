package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final int mVersionCode;
  private String zzaZb;
  private String zzaZc;
  
  public PlusCommonExtras()
  {
    this.mVersionCode = 1;
    this.zzaZb = "";
    this.zzaZc = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaZb = paramString1;
    this.zzaZc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras)) {}
    do
    {
      return false;
      paramObject = (PlusCommonExtras)paramObject;
    } while ((this.mVersionCode != ((PlusCommonExtras)paramObject).mVersionCode) || (!zzw.equal(this.zzaZb, ((PlusCommonExtras)paramObject).zzaZb)) || (!zzw.equal(this.zzaZc, ((PlusCommonExtras)paramObject).zzaZc)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzaZb, this.zzaZc });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzaZb).zzg("ClientCallingPackage", this.zzaZc).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public String zzDg()
  {
    return this.zzaZb;
  }
  
  public String zzDh()
  {
    return this.zzaZc;
  }
  
  public void zzG(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */