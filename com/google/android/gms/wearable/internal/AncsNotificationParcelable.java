package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzd;

public class AncsNotificationParcelable
  implements SafeParcelable, zzd
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zzh();
  private int mId;
  final int mVersionCode;
  private String zzVu;
  private final String zzZa;
  private final String zzaBc;
  private final String zzaRd;
  private final String zzank;
  private final String zzbmC;
  private byte zzbmD;
  private byte zzbmE;
  private byte zzbmF;
  private byte zzbmG;
  
  AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.mId = paramInt2;
    this.mVersionCode = paramInt1;
    this.zzaRd = paramString1;
    this.zzbmC = paramString2;
    this.zzZa = paramString3;
    this.zzank = paramString4;
    this.zzaBc = paramString5;
    this.zzVu = paramString6;
    this.zzbmD = paramByte1;
    this.zzbmE = paramByte2;
    this.zzbmF = paramByte3;
    this.zzbmG = paramByte4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AncsNotificationParcelable)paramObject;
      if (this.zzbmG != ((AncsNotificationParcelable)paramObject).zzbmG) {
        return false;
      }
      if (this.zzbmF != ((AncsNotificationParcelable)paramObject).zzbmF) {
        return false;
      }
      if (this.zzbmE != ((AncsNotificationParcelable)paramObject).zzbmE) {
        return false;
      }
      if (this.zzbmD != ((AncsNotificationParcelable)paramObject).zzbmD) {
        return false;
      }
      if (this.mId != ((AncsNotificationParcelable)paramObject).mId) {
        return false;
      }
      if (this.mVersionCode != ((AncsNotificationParcelable)paramObject).mVersionCode) {
        return false;
      }
      if (!this.zzaRd.equals(((AncsNotificationParcelable)paramObject).zzaRd)) {
        return false;
      }
      if (this.zzbmC != null)
      {
        if (this.zzbmC.equals(((AncsNotificationParcelable)paramObject).zzbmC)) {}
      }
      else {
        while (((AncsNotificationParcelable)paramObject).zzbmC != null) {
          return false;
        }
      }
      if (!this.zzVu.equals(((AncsNotificationParcelable)paramObject).zzVu)) {
        return false;
      }
      if (!this.zzZa.equals(((AncsNotificationParcelable)paramObject).zzZa)) {
        return false;
      }
      if (!this.zzaBc.equals(((AncsNotificationParcelable)paramObject).zzaBc)) {
        return false;
      }
    } while (this.zzank.equals(((AncsNotificationParcelable)paramObject).zzank));
    return false;
  }
  
  public String getDisplayName()
  {
    if (this.zzVu == null) {
      return this.zzaRd;
    }
    return this.zzVu;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public int hashCode()
  {
    int j = this.mVersionCode;
    int k = this.mId;
    int m = this.zzaRd.hashCode();
    if (this.zzbmC != null) {}
    for (int i = this.zzbmC.hashCode();; i = 0) {
      return ((((((((i + ((j * 31 + k) * 31 + m) * 31) * 31 + this.zzZa.hashCode()) * 31 + this.zzank.hashCode()) * 31 + this.zzaBc.hashCode()) * 31 + this.zzVu.hashCode()) * 31 + this.zzbmD) * 31 + this.zzbmE) * 31 + this.zzbmF) * 31 + this.zzbmG;
    }
  }
  
  public String toString()
  {
    return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaRd + '\'' + ", mDateTime='" + this.zzbmC + '\'' + ", mNotificationText='" + this.zzZa + '\'' + ", mTitle='" + this.zzank + '\'' + ", mSubtitle='" + this.zzaBc + '\'' + ", mDisplayName='" + this.zzVu + '\'' + ", mEventId=" + this.zzbmD + ", mEventFlags=" + this.zzbmE + ", mCategoryId=" + this.zzbmF + ", mCategoryCount=" + this.zzbmG + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzGE()
  {
    return this.zzbmC;
  }
  
  public String zzGF()
  {
    return this.zzZa;
  }
  
  public byte zzGG()
  {
    return this.zzbmD;
  }
  
  public byte zzGH()
  {
    return this.zzbmE;
  }
  
  public byte zzGI()
  {
    return this.zzbmF;
  }
  
  public byte zzGJ()
  {
    return this.zzbmG;
  }
  
  public String zzvw()
  {
    return this.zzaBc;
  }
  
  public String zzwg()
  {
    return this.zzaRd;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/AncsNotificationParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */