package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;
import java.util.Collections;
import java.util.List;

@zzha
public final class AdRequestInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final ApplicationInfo applicationInfo;
  public final int versionCode;
  public final int zzGA;
  public final int zzGB;
  public final float zzGC;
  public final String zzGD;
  public final long zzGE;
  public final String zzGF;
  public final List<String> zzGG;
  public final List<String> zzGH;
  public final long zzGI;
  public final CapabilityParcel zzGJ;
  public final String zzGK;
  public final Bundle zzGp;
  public final AdRequestParcel zzGq;
  public final PackageInfo zzGr;
  public final String zzGs;
  public final String zzGt;
  public final String zzGu;
  public final Bundle zzGv;
  public final int zzGw;
  public final Bundle zzGx;
  public final boolean zzGy;
  public final Messenger zzGz;
  public final String zzqO;
  public final String zzqP;
  public final VersionInfoParcel zzqR;
  public final AdSizeParcel zzqV;
  public final NativeAdOptionsParcel zzrj;
  public final List<String> zzrl;
  
  AdRequestInfoParcel(int paramInt1, Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt2, List<String> paramList1, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt3, int paramInt4, float paramFloat, String paramString5, long paramLong1, String paramString6, List<String> paramList2, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList3, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8)
  {
    this.versionCode = paramInt1;
    this.zzGp = paramBundle1;
    this.zzGq = paramAdRequestParcel;
    this.zzqV = paramAdSizeParcel;
    this.zzqP = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.zzGr = paramPackageInfo;
    this.zzGs = paramString2;
    this.zzGt = paramString3;
    this.zzGu = paramString4;
    this.zzqR = paramVersionInfoParcel;
    this.zzGv = paramBundle2;
    this.zzGw = paramInt2;
    this.zzrl = paramList1;
    if (paramList3 == null)
    {
      paramBundle1 = Collections.emptyList();
      this.zzGH = paramBundle1;
      this.zzGx = paramBundle3;
      this.zzGy = paramBoolean;
      this.zzGz = paramMessenger;
      this.zzGA = paramInt3;
      this.zzGB = paramInt4;
      this.zzGC = paramFloat;
      this.zzGD = paramString5;
      this.zzGE = paramLong1;
      this.zzGF = paramString6;
      if (paramList2 != null) {
        break label207;
      }
    }
    label207:
    for (paramBundle1 = Collections.emptyList();; paramBundle1 = Collections.unmodifiableList(paramList2))
    {
      this.zzGG = paramBundle1;
      this.zzqO = paramString7;
      this.zzrj = paramNativeAdOptionsParcel;
      this.zzGI = paramLong2;
      this.zzGJ = paramCapabilityParcel;
      this.zzGK = paramString8;
      return;
      paramBundle1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }
  
  public AdRequestInfoParcel(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt1, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt2, int paramInt3, float paramFloat, String paramString5, long paramLong1, String paramString6, List<String> paramList3, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8)
  {
    this(12, paramBundle1, paramAdRequestParcel, paramAdSizeParcel, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramVersionInfoParcel, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean, paramMessenger, paramInt2, paramInt3, paramFloat, paramString5, paramLong1, paramString6, paramList3, paramString7, paramNativeAdOptionsParcel, paramList2, paramLong2, paramCapabilityParcel, paramString8);
  }
  
  public AdRequestInfoParcel(zza paramzza, String paramString, long paramLong)
  {
    this(paramzza.zzGp, paramzza.zzGq, paramzza.zzqV, paramzza.zzqP, paramzza.applicationInfo, paramzza.zzGr, paramString, paramzza.zzGt, paramzza.zzGu, paramzza.zzqR, paramzza.zzGv, paramzza.zzGw, paramzza.zzrl, paramzza.zzGH, paramzza.zzGx, paramzza.zzGy, paramzza.zzGz, paramzza.zzGA, paramzza.zzGB, paramzza.zzGC, paramzza.zzGD, paramzza.zzGE, paramzza.zzGF, paramzza.zzGG, paramzza.zzqO, paramzza.zzrj, paramLong, paramzza.zzGJ, paramzza.zzGK);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  @zzha
  public static final class zza
  {
    public final ApplicationInfo applicationInfo;
    public final int zzGA;
    public final int zzGB;
    public final float zzGC;
    public final String zzGD;
    public final long zzGE;
    public final String zzGF;
    public final List<String> zzGG;
    public final List<String> zzGH;
    public final CapabilityParcel zzGJ;
    public final String zzGK;
    public final Bundle zzGp;
    public final AdRequestParcel zzGq;
    public final PackageInfo zzGr;
    public final String zzGt;
    public final String zzGu;
    public final Bundle zzGv;
    public final int zzGw;
    public final Bundle zzGx;
    public final boolean zzGy;
    public final Messenger zzGz;
    public final String zzqO;
    public final String zzqP;
    public final VersionInfoParcel zzqR;
    public final AdSizeParcel zzqV;
    public final NativeAdOptionsParcel zzrj;
    public final List<String> zzrl;
    
    public zza(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat, String paramString4, long paramLong, String paramString5, List<String> paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7)
    {
      this.zzGp = paramBundle1;
      this.zzGq = paramAdRequestParcel;
      this.zzqV = paramAdSizeParcel;
      this.zzqP = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.zzGr = paramPackageInfo;
      this.zzGt = paramString2;
      this.zzGu = paramString3;
      this.zzqR = paramVersionInfoParcel;
      this.zzGv = paramBundle2;
      this.zzGy = paramBoolean;
      this.zzGz = paramMessenger;
      this.zzGA = paramInt1;
      this.zzGB = paramInt2;
      this.zzGC = paramFloat;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        this.zzGw = 3;
        this.zzrl = paramList1;
        this.zzGH = paramList2;
        this.zzGx = paramBundle3;
        this.zzGD = paramString4;
        this.zzGE = paramLong;
        this.zzGF = paramString5;
        this.zzGG = paramList3;
        this.zzqO = paramString6;
        this.zzrj = paramNativeAdOptionsParcel;
        this.zzGJ = paramCapabilityParcel;
        this.zzGK = paramString7;
        return;
      }
      if (paramAdSizeParcel.zzua) {}
      for (this.zzGw = 4;; this.zzGw = 0)
      {
        this.zzrl = null;
        this.zzGH = null;
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/AdRequestInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */