package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzha
public class zzie
{
  public final int errorCode;
  public final int orientation;
  public final List<String> zzAQ;
  public final List<String> zzAR;
  public final long zzAU;
  public final zzem zzBp;
  public final zzex zzBq;
  public final String zzBr;
  public final zzep zzBs;
  public final zzjn zzDC;
  public final long zzGM;
  public final boolean zzGN;
  public final long zzGO;
  public final List<String> zzGP;
  public final String zzGS;
  public final AdRequestParcel zzGq;
  public final String zzGt;
  public final JSONObject zzJE;
  public final zzen zzJF;
  public final AdSizeParcel zzJG;
  public final long zzJH;
  public final long zzJI;
  public final zzh.zza zzJJ;
  
  public zzie(AdRequestParcel paramAdRequestParcel, zzjn paramzzjn, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, zzem paramzzem, zzex paramzzex, String paramString2, zzen paramzzen, zzep paramzzep, long paramLong2, AdSizeParcel paramAdSizeParcel, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, zzh.zza paramzza)
  {
    this.zzGq = paramAdRequestParcel;
    this.zzDC = paramzzjn;
    if (paramList1 != null)
    {
      paramAdRequestParcel = Collections.unmodifiableList(paramList1);
      this.zzAQ = paramAdRequestParcel;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label174;
      }
      paramAdRequestParcel = Collections.unmodifiableList(paramList2);
      label45:
      this.zzAR = paramAdRequestParcel;
      if (paramList3 == null) {
        break label179;
      }
    }
    label174:
    label179:
    for (paramAdRequestParcel = Collections.unmodifiableList(paramList3);; paramAdRequestParcel = null)
    {
      this.zzGP = paramAdRequestParcel;
      this.orientation = paramInt2;
      this.zzAU = paramLong1;
      this.zzGt = paramString1;
      this.zzGN = paramBoolean;
      this.zzBp = paramzzem;
      this.zzBq = paramzzex;
      this.zzBr = paramString2;
      this.zzJF = paramzzen;
      this.zzBs = paramzzep;
      this.zzGO = paramLong2;
      this.zzJG = paramAdSizeParcel;
      this.zzGM = paramLong3;
      this.zzJH = paramLong4;
      this.zzJI = paramLong5;
      this.zzGS = paramString3;
      this.zzJE = paramJSONObject;
      this.zzJJ = paramzza;
      return;
      paramAdRequestParcel = null;
      break;
      paramAdRequestParcel = null;
      break label45;
    }
  }
  
  public zzie(zza paramzza, zzjn paramzzjn, zzem paramzzem, zzex paramzzex, String paramString, zzep paramzzep, zzh.zza paramzza1)
  {
    this(paramzza.zzJK.zzGq, paramzzjn, paramzza.zzJL.zzAQ, paramzza.errorCode, paramzza.zzJL.zzAR, paramzza.zzJL.zzGP, paramzza.zzJL.orientation, paramzza.zzJL.zzAU, paramzza.zzJK.zzGt, paramzza.zzJL.zzGN, paramzzem, paramzzex, paramString, paramzza.zzJF, paramzzep, paramzza.zzJL.zzGO, paramzza.zzqV, paramzza.zzJL.zzGM, paramzza.zzJH, paramzza.zzJI, paramzza.zzJL.zzGS, paramzza.zzJE, paramzza1);
  }
  
  public boolean zzcb()
  {
    if ((this.zzDC == null) || (this.zzDC.zzhC() == null)) {
      return false;
    }
    return this.zzDC.zzhC().zzcb();
  }
  
  @zzha
  public static final class zza
  {
    public final int errorCode;
    public final JSONObject zzJE;
    public final zzen zzJF;
    public final long zzJH;
    public final long zzJI;
    public final AdRequestInfoParcel zzJK;
    public final AdResponseParcel zzJL;
    public final AdSizeParcel zzqV;
    
    public zza(AdRequestInfoParcel paramAdRequestInfoParcel, AdResponseParcel paramAdResponseParcel, zzen paramzzen, AdSizeParcel paramAdSizeParcel, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
    {
      this.zzJK = paramAdRequestInfoParcel;
      this.zzJL = paramAdResponseParcel;
      this.zzJF = paramzzen;
      this.zzqV = paramAdSizeParcel;
      this.errorCode = paramInt;
      this.zzJH = paramLong1;
      this.zzJI = paramLong2;
      this.zzJE = paramJSONObject;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */