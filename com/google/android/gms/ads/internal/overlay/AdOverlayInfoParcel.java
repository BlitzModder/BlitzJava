package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;

@zzha
public final class AdOverlayInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final zza zzDA;
  public final zzg zzDB;
  public final zzjn zzDC;
  public final zzdh zzDD;
  public final String zzDE;
  public final boolean zzDF;
  public final String zzDG;
  public final zzn zzDH;
  public final int zzDI;
  public final zzdn zzDJ;
  public final String zzDK;
  public final InterstitialAdParameterParcel zzDL;
  public final AdLauncherIntentInfoParcel zzDz;
  public final VersionInfoParcel zzqR;
  
  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.versionCode = paramInt1;
    this.zzDz = paramAdLauncherIntentInfoParcel;
    this.zzDA = ((zza)zze.zzp(zzd.zza.zzbs(paramIBinder1)));
    this.zzDB = ((zzg)zze.zzp(zzd.zza.zzbs(paramIBinder2)));
    this.zzDC = ((zzjn)zze.zzp(zzd.zza.zzbs(paramIBinder3)));
    this.zzDD = ((zzdh)zze.zzp(zzd.zza.zzbs(paramIBinder4)));
    this.zzDE = paramString1;
    this.zzDF = paramBoolean;
    this.zzDG = paramString2;
    this.zzDH = ((zzn)zze.zzp(zzd.zza.zzbs(paramIBinder5)));
    this.orientation = paramInt2;
    this.zzDI = paramInt3;
    this.url = paramString3;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = ((zzdn)zze.zzp(zzd.zza.zzbs(paramIBinder6)));
    this.zzDK = paramString4;
    this.zzDL = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zzjn paramzzjn, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.versionCode = 4;
    this.zzDz = null;
    this.zzDA = paramzza;
    this.zzDB = paramzzg;
    this.zzDC = paramzzjn;
    this.zzDD = null;
    this.zzDE = null;
    this.zzDF = false;
    this.zzDG = null;
    this.zzDH = paramzzn;
    this.orientation = paramInt;
    this.zzDI = 1;
    this.url = null;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = null;
    this.zzDK = paramString;
    this.zzDL = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zzjn paramzzjn, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    this.versionCode = 4;
    this.zzDz = null;
    this.zzDA = paramzza;
    this.zzDB = paramzzg;
    this.zzDC = paramzzjn;
    this.zzDD = null;
    this.zzDE = null;
    this.zzDF = paramBoolean;
    this.zzDG = null;
    this.zzDH = paramzzn;
    this.orientation = paramInt;
    this.zzDI = 2;
    this.url = null;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = null;
    this.zzDK = null;
    this.zzDL = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdh paramzzdh, zzn paramzzn, zzjn paramzzjn, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, zzdn paramzzdn)
  {
    this.versionCode = 4;
    this.zzDz = null;
    this.zzDA = paramzza;
    this.zzDB = paramzzg;
    this.zzDC = paramzzjn;
    this.zzDD = paramzzdh;
    this.zzDE = null;
    this.zzDF = paramBoolean;
    this.zzDG = null;
    this.zzDH = paramzzn;
    this.orientation = paramInt;
    this.zzDI = 3;
    this.url = paramString;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = paramzzdn;
    this.zzDK = null;
    this.zzDL = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdh paramzzdh, zzn paramzzn, zzjn paramzzjn, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, zzdn paramzzdn)
  {
    this.versionCode = 4;
    this.zzDz = null;
    this.zzDA = paramzza;
    this.zzDB = paramzzg;
    this.zzDC = paramzzjn;
    this.zzDD = paramzzdh;
    this.zzDE = paramString2;
    this.zzDF = paramBoolean;
    this.zzDG = paramString1;
    this.zzDH = paramzzn;
    this.orientation = paramInt;
    this.zzDI = 3;
    this.url = null;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = paramzzdn;
    this.zzDK = null;
    this.zzDL = null;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zza paramzza, zzg paramzzg, zzn paramzzn, VersionInfoParcel paramVersionInfoParcel)
  {
    this.versionCode = 4;
    this.zzDz = paramAdLauncherIntentInfoParcel;
    this.zzDA = paramzza;
    this.zzDB = paramzzg;
    this.zzDC = null;
    this.zzDD = null;
    this.zzDE = null;
    this.zzDF = false;
    this.zzDG = null;
    this.zzDH = paramzzn;
    this.orientation = -1;
    this.zzDI = 4;
    this.url = null;
    this.zzqR = paramVersionInfoParcel;
    this.zzDJ = null;
    this.zzDK = null;
    this.zzDL = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzfh()
  {
    return zze.zzB(this.zzDA).asBinder();
  }
  
  IBinder zzfi()
  {
    return zze.zzB(this.zzDB).asBinder();
  }
  
  IBinder zzfj()
  {
    return zze.zzB(this.zzDC).asBinder();
  }
  
  IBinder zzfk()
  {
    return zze.zzB(this.zzDD).asBinder();
  }
  
  IBinder zzfl()
  {
    return zze.zzB(this.zzDJ).asBinder();
  }
  
  IBinder zzfm()
  {
    return zze.zzB(this.zzDH).asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/AdOverlayInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */