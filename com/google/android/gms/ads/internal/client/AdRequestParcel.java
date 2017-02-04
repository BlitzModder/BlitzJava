package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public final class AdRequestParcel
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final Bundle zztA;
  public final Bundle zztB;
  public final List<String> zztC;
  public final String zztD;
  public final String zztE;
  public final boolean zztF;
  public final long zztq;
  public final int zztr;
  public final List<String> zzts;
  public final boolean zztt;
  public final int zztu;
  public final boolean zztv;
  public final String zztw;
  public final SearchAdRequestParcel zztx;
  public final Location zzty;
  public final String zztz;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    this.versionCode = paramInt1;
    this.zztq = paramLong;
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    this.extras = localBundle;
    this.zztr = paramInt2;
    this.zzts = paramList1;
    this.zztt = paramBoolean1;
    this.zztu = paramInt3;
    this.zztv = paramBoolean2;
    this.zztw = paramString1;
    this.zztx = paramSearchAdRequestParcel;
    this.zzty = paramLocation;
    this.zztz = paramString2;
    this.zztA = paramBundle2;
    this.zztB = paramBundle3;
    this.zztC = paramList2;
    this.zztD = paramString3;
    this.zztE = paramString4;
    this.zztF = paramBoolean3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    do
    {
      return false;
      paramObject = (AdRequestParcel)paramObject;
    } while ((this.versionCode != ((AdRequestParcel)paramObject).versionCode) || (this.zztq != ((AdRequestParcel)paramObject).zztq) || (!zzw.equal(this.extras, ((AdRequestParcel)paramObject).extras)) || (this.zztr != ((AdRequestParcel)paramObject).zztr) || (!zzw.equal(this.zzts, ((AdRequestParcel)paramObject).zzts)) || (this.zztt != ((AdRequestParcel)paramObject).zztt) || (this.zztu != ((AdRequestParcel)paramObject).zztu) || (this.zztv != ((AdRequestParcel)paramObject).zztv) || (!zzw.equal(this.zztw, ((AdRequestParcel)paramObject).zztw)) || (!zzw.equal(this.zztx, ((AdRequestParcel)paramObject).zztx)) || (!zzw.equal(this.zzty, ((AdRequestParcel)paramObject).zzty)) || (!zzw.equal(this.zztz, ((AdRequestParcel)paramObject).zztz)) || (!zzw.equal(this.zztA, ((AdRequestParcel)paramObject).zztA)) || (!zzw.equal(this.zztB, ((AdRequestParcel)paramObject).zztB)) || (!zzw.equal(this.zztC, ((AdRequestParcel)paramObject).zztC)) || (!zzw.equal(this.zztD, ((AdRequestParcel)paramObject).zztD)) || (!zzw.equal(this.zztE, ((AdRequestParcel)paramObject).zztE)) || (this.zztF != ((AdRequestParcel)paramObject).zztF));
    return true;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.versionCode), Long.valueOf(this.zztq), this.extras, Integer.valueOf(this.zztr), this.zzts, Boolean.valueOf(this.zztt), Integer.valueOf(this.zztu), Boolean.valueOf(this.zztv), this.zztw, this.zztx, this.zzty, this.zztz, this.zztA, this.zztB, this.zztC, this.zztD, this.zztE, Boolean.valueOf(this.zztF) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/AdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */