package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjh;
import com.google.android.gms.internal.zznl;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzb
  extends zzil
  implements zzc.zza
{
  private final Context mContext;
  zzen zzBf;
  private AdRequestInfoParcel zzBu;
  AdResponseParcel zzFd;
  private Runnable zzFe;
  private final Object zzFf = new Object();
  private final zza.zza zzGd;
  private final AdRequestInfoParcel.zza zzGe;
  zzir zzGf;
  private final zzan zzxV;
  
  public zzb(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza.zza paramzza1)
  {
    this.zzGd = paramzza1;
    this.mContext = paramContext;
    this.zzGe = paramzza;
    this.zzxV = paramzzan;
  }
  
  private void zze(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaG(paramString);
      if (this.zzFd != null) {
        break label93;
      }
      this.zzFd = new AdResponseParcel(paramInt);
      label33:
      if (this.zzBu == null) {
        break label115;
      }
    }
    label93:
    label115:
    for (paramString = this.zzBu;; paramString = new AdRequestInfoParcel(this.zzGe, null, -1L))
    {
      paramString = new zzie.zza(paramString, this.zzFd, this.zzBf, null, paramInt, -1L, this.zzFd.zzGR, null);
      this.zzGd.zza(paramString);
      return;
      com.google.android.gms.ads.internal.util.client.zzb.zzaH(paramString);
      break;
      this.zzFd = new AdResponseParcel(paramInt, this.zzFd.zzAU);
      break label33;
    }
  }
  
  public void onStop()
  {
    synchronized (this.zzFf)
    {
      if (this.zzGf != null) {
        this.zzGf.cancel();
      }
      return;
    }
  }
  
  zzir zza(VersionInfoParcel paramVersionInfoParcel, zzjg<AdRequestInfoParcel> paramzzjg)
  {
    return zzc.zza(this.mContext, paramVersionInfoParcel, paramzzjg, this);
  }
  
  protected AdSizeParcel zzb(AdRequestInfoParcel paramAdRequestInfoParcel)
    throws zzb.zza
  {
    if (this.zzFd.zzGQ == null) {
      throw new zza("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.zzFd.zzGQ.split("x");
    if (localObject.length != 2) {
      throw new zza("Invalid ad size format from the ad response: " + this.zzFd.zzGQ, 0);
    }
    for (;;)
    {
      int i;
      AdSizeParcel localAdSizeParcel;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = paramAdRequestInfoParcel.zzqV.zztX;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localAdSizeParcel = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localAdSizeParcel.width == -1)
        {
          j = (int)(localAdSizeParcel.widthPixels / f);
          if (localAdSizeParcel.height != -2) {
            break label253;
          }
          k = (int)(localAdSizeParcel.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label263;
          }
          return new AdSizeParcel(localAdSizeParcel, paramAdRequestInfoParcel.zzqV.zztX);
        }
      }
      catch (NumberFormatException paramAdRequestInfoParcel)
      {
        throw new zza("Invalid ad size number from the ad response: " + this.zzFd.zzGQ, 0);
      }
      int j = localAdSizeParcel.width;
      continue;
      label253:
      int k = localAdSizeParcel.height;
      continue;
      label263:
      i += 1;
    }
    throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzFd.zzGQ, 0);
  }
  
  public void zzb(AdResponseParcel arg1)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received ad response.");
    this.zzFd = ???;
    long l = zzp.zzbB().elapsedRealtime();
    synchronized (this.zzFf)
    {
      this.zzGf = null;
      try
      {
        if ((this.zzFd.errorCode != -2) && (this.zzFd.errorCode != -3)) {
          throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzFd.errorCode, this.zzFd.errorCode);
        }
      }
      catch (zza ???)
      {
        zze(???.getErrorCode(), ???.getMessage());
        zzip.zzKO.removeCallbacks(this.zzFe);
        return;
      }
    }
    zzgd();
    if (this.zzBu.zzqV.zztX != null) {}
    for (??? = zzb(this.zzBu);; ??? = null)
    {
      zzp.zzbA().zzB(this.zzFd.zzGX);
      if (!TextUtils.isEmpty(this.zzFd.zzGV)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(this.zzFd.zzGV);
          ??? = new zzie.zza(this.zzBu, this.zzFd, this.zzBf, ???, -2, l, this.zzFd.zzGR, localJSONObject);
          this.zzGd.zza(???);
          zzip.zzKO.removeCallbacks(this.zzFe);
          return;
        }
        catch (Exception localException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void zzbp()
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdLoaderBackgroundTask started.");
    this.zzFe = new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          if (zzb.this.zzGf == null) {
            return;
          }
          zzb.this.onStop();
          zzb.zza(zzb.this, 2, "Timed out waiting for ad response.");
          return;
        }
      }
    };
    zzip.zzKO.postDelayed(this.zzFe, ((Long)zzbz.zzwB.get()).longValue());
    final zzjh localzzjh = new zzjh();
    long l = zzp.zzbB().elapsedRealtime();
    zzio.zza(new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          zzb.this.zzGf = zzb.this.zza(zzb.zzb(zzb.this).zzqR, localzzjh);
          if (zzb.this.zzGf == null)
          {
            zzb.zza(zzb.this, 0, "Could not start the ad request service.");
            zzip.zzKO.removeCallbacks(zzb.zzc(zzb.this));
          }
          return;
        }
      }
    });
    String str = this.zzxV.zzac().zzb(this.mContext);
    this.zzBu = new AdRequestInfoParcel(this.zzGe, str, l);
    localzzjh.zzg(this.zzBu);
  }
  
  protected void zzgd()
    throws zzb.zza
  {
    if (this.zzFd.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.zzFd.body)) {
        throw new zza("No fill from ad server.", 3);
      }
      zzp.zzbA().zza(this.mContext, this.zzFd.zzGy);
    } while (!this.zzFd.zzGN);
    try
    {
      this.zzBf = new zzen(this.zzFd.body);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new zza("Could not parse mediation config: " + this.zzFd.body, 0);
    }
  }
  
  @zzha
  static final class zza
    extends Exception
  {
    private final int zzFt;
    
    public zza(String paramString, int paramInt)
    {
      super();
      this.zzFt = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.zzFt;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */