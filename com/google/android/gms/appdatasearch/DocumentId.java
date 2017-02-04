package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final String zzSp;
  final String zzSq;
  final String zzSr;
  
  DocumentId(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzSp = paramString1;
    this.zzSq = paramString2;
    this.zzSr = paramString3;
  }
  
  public DocumentId(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { this.zzSp, this.zzSq, this.zzSr });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/DocumentId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */