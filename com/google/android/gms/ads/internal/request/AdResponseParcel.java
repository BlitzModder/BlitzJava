package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;
import java.util.Collections;
import java.util.List;

@zzha
public final class AdResponseParcel
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public String body;
  public final int errorCode;
  public final int orientation;
  public final int versionCode;
  public final List<String> zzAQ;
  public final List<String> zzAR;
  public final long zzAU;
  private AdRequestInfoParcel zzBu;
  public final String zzDE;
  public final long zzGM;
  public final boolean zzGN;
  public final long zzGO;
  public final List<String> zzGP;
  public final String zzGQ;
  public final long zzGR;
  public final String zzGS;
  public final boolean zzGT;
  public final String zzGU;
  public final String zzGV;
  public final boolean zzGW;
  public final boolean zzGX;
  public final boolean zzGY;
  public final int zzGZ;
  public final boolean zzGy;
  public LargeParcelTeleporter zzHa;
  public String zzHb;
  public String zzHc;
  public final boolean zztY;
  public boolean zztZ;
  
  public AdResponseParcel(int paramInt)
  {
    this(14, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false);
  }
  
  public AdResponseParcel(int paramInt, long paramLong)
  {
    this(14, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null, null, null, false);
  }
  
  AdResponseParcel(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt4, LargeParcelTeleporter paramLargeParcelTeleporter, String paramString7, String paramString8, boolean paramBoolean8)
  {
    this.versionCode = paramInt1;
    this.zzDE = paramString1;
    this.body = paramString2;
    if (paramList1 != null)
    {
      paramString1 = Collections.unmodifiableList(paramList1);
      this.zzAQ = paramString1;
      this.errorCode = paramInt2;
      if (paramList2 == null) {
        break label255;
      }
      paramString1 = Collections.unmodifiableList(paramList2);
      label52:
      this.zzAR = paramString1;
      this.zzGM = paramLong1;
      this.zzGN = paramBoolean1;
      this.zzGO = paramLong2;
      if (paramList3 == null) {
        break label260;
      }
    }
    label255:
    label260:
    for (paramString1 = Collections.unmodifiableList(paramList3);; paramString1 = null)
    {
      this.zzGP = paramString1;
      this.zzAU = paramLong3;
      this.orientation = paramInt3;
      this.zzGQ = paramString3;
      this.zzGR = paramLong4;
      this.zzGS = paramString4;
      this.zzGT = paramBoolean2;
      this.zzGU = paramString5;
      this.zzGV = paramString6;
      this.zzGW = paramBoolean3;
      this.zztY = paramBoolean4;
      this.zzGy = paramBoolean5;
      this.zzGX = paramBoolean6;
      this.zzGY = paramBoolean7;
      this.zzGZ = paramInt4;
      this.zzHa = paramLargeParcelTeleporter;
      this.zzHb = paramString7;
      this.zzHc = paramString8;
      if ((this.body == null) && (this.zzHa != null))
      {
        paramString1 = (StringParcel)this.zzHa.zza(StringParcel.CREATOR);
        if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.zzgm()))) {
          this.body = paramString1.zzgm();
        }
      }
      this.zztZ = paramBoolean8;
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label52;
    }
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, int paramInt2, String paramString6, boolean paramBoolean7)
  {
    this(14, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramInt2, null, null, paramString6, paramBoolean7);
    this.zzBu = paramAdRequestInfoParcel;
  }
  
  public AdResponseParcel(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt1, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt2, String paramString7, boolean paramBoolean8)
  {
    this(14, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt1, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7, paramInt2, null, null, paramString7, paramBoolean8);
    this.zzBu = paramAdRequestInfoParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if ((this.zzBu != null) && (this.zzBu.versionCode >= 9) && (!TextUtils.isEmpty(this.body)))
    {
      this.zzHa = new LargeParcelTeleporter(new StringParcel(this.body));
      this.body = null;
    }
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/AdResponseParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */