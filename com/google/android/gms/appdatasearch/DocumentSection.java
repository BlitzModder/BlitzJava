package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  public static final int zzSs = Integer.parseInt("-1");
  private static final RegisterSectionInfo zzSt = new RegisterSectionInfo.zza("SsbContext").zzM(true).zzby("blob").zzlQ();
  final int mVersionCode;
  public final String zzSu;
  final RegisterSectionInfo zzSv;
  public final int zzSw;
  public final byte[] zzSx;
  
  DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == zzSs) || (zzh.zzao(paramInt2) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Invalid section type " + paramInt2);
      this.mVersionCode = paramInt1;
      this.zzSu = paramString;
      this.zzSv = paramRegisterSectionInfo;
      this.zzSw = paramInt2;
      this.zzSx = paramArrayOfByte;
      paramString = zzlO();
      if (paramString == null) {
        break;
      }
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public DocumentSection(String paramString, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, paramString, paramRegisterSectionInfo, zzSs, null);
  }
  
  public DocumentSection(String paramString1, RegisterSectionInfo paramRegisterSectionInfo, String paramString2)
  {
    this(1, paramString1, paramRegisterSectionInfo, zzh.zzbx(paramString2), null);
  }
  
  public DocumentSection(byte[] paramArrayOfByte, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, null, paramRegisterSectionInfo, zzSs, paramArrayOfByte);
  }
  
  public static DocumentSection zzh(byte[] paramArrayOfByte)
  {
    return new DocumentSection(paramArrayOfByte, zzSt);
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public String zzlO()
  {
    if ((this.zzSw != zzSs) && (zzh.zzao(this.zzSw) == null)) {
      return "Invalid section type " + this.zzSw;
    }
    if ((this.zzSu != null) && (this.zzSx != null)) {
      return "Both content and blobContent set";
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/DocumentSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */