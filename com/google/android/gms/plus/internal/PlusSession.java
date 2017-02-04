package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Arrays;

public class PlusSession
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final int mVersionCode;
  private final String zzTD;
  private final String[] zzaZe;
  private final String[] zzaZf;
  private final String[] zzaZg;
  private final String zzaZh;
  private final String zzaZi;
  private final String zzaZj;
  private final PlusCommonExtras zzaZk;
  private final String zzabt;
  
  PlusSession(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.mVersionCode = paramInt;
    this.zzTD = paramString1;
    this.zzaZe = paramArrayOfString1;
    this.zzaZf = paramArrayOfString2;
    this.zzaZg = paramArrayOfString3;
    this.zzaZh = paramString2;
    this.zzaZi = paramString3;
    this.zzabt = paramString4;
    this.zzaZj = paramString5;
    this.zzaZk = paramPlusCommonExtras;
  }
  
  public PlusSession(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.mVersionCode = 1;
    this.zzTD = paramString1;
    this.zzaZe = paramArrayOfString1;
    this.zzaZf = paramArrayOfString2;
    this.zzaZg = paramArrayOfString3;
    this.zzaZh = paramString2;
    this.zzaZi = paramString3;
    this.zzabt = paramString4;
    this.zzaZj = null;
    this.zzaZk = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusSession)) {}
    do
    {
      return false;
      paramObject = (PlusSession)paramObject;
    } while ((this.mVersionCode != ((PlusSession)paramObject).mVersionCode) || (!zzw.equal(this.zzTD, ((PlusSession)paramObject).zzTD)) || (!Arrays.equals(this.zzaZe, ((PlusSession)paramObject).zzaZe)) || (!Arrays.equals(this.zzaZf, ((PlusSession)paramObject).zzaZf)) || (!Arrays.equals(this.zzaZg, ((PlusSession)paramObject).zzaZg)) || (!zzw.equal(this.zzaZh, ((PlusSession)paramObject).zzaZh)) || (!zzw.equal(this.zzaZi, ((PlusSession)paramObject).zzaZi)) || (!zzw.equal(this.zzabt, ((PlusSession)paramObject).zzabt)) || (!zzw.equal(this.zzaZj, ((PlusSession)paramObject).zzaZj)) || (!zzw.equal(this.zzaZk, ((PlusSession)paramObject).zzaZk)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.zzTD;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.zzTD, this.zzaZe, this.zzaZf, this.zzaZg, this.zzaZh, this.zzaZi, this.zzabt, this.zzaZj, this.zzaZk });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzTD).zzg("requestedScopes", this.zzaZe).zzg("visibleActivities", this.zzaZf).zzg("requiredFeatures", this.zzaZg).zzg("packageNameForAuth", this.zzaZh).zzg("callingPackageName", this.zzaZi).zzg("applicationName", this.zzabt).zzg("extra", this.zzaZk.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String[] zzDi()
  {
    return this.zzaZe;
  }
  
  public String[] zzDj()
  {
    return this.zzaZf;
  }
  
  public String[] zzDk()
  {
    return this.zzaZg;
  }
  
  public String zzDl()
  {
    return this.zzaZh;
  }
  
  public String zzDm()
  {
    return this.zzaZi;
  }
  
  public String zzDn()
  {
    return this.zzaZj;
  }
  
  public PlusCommonExtras zzDo()
  {
    return this.zzaZk;
  }
  
  public Bundle zzDp()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.zzaZk.zzG(localBundle);
    return localBundle;
  }
  
  public String zznF()
  {
    return this.zzabt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/PlusSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */