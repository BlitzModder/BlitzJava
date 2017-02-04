package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfq
  extends zzfr
  implements zzdl
{
  private final Context mContext;
  DisplayMetrics zzCA;
  private float zzCB;
  int zzCC = -1;
  int zzCD = -1;
  private int zzCE;
  int zzCF = -1;
  int zzCG = -1;
  int zzCH = -1;
  int zzCI = -1;
  private final zzbr zzCz;
  private final zzjn zzps;
  private final WindowManager zzrR;
  
  public zzfq(zzjn paramzzjn, Context paramContext, zzbr paramzzbr)
  {
    super(paramzzjn);
    this.zzps = paramzzjn;
    this.mContext = paramContext;
    this.zzCz = paramzzbr;
    this.zzrR = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void zzeF()
  {
    this.zzCA = new DisplayMetrics();
    Display localDisplay = this.zzrR.getDefaultDisplay();
    localDisplay.getMetrics(this.zzCA);
    this.zzCB = this.zzCA.density;
    this.zzCE = localDisplay.getRotation();
  }
  
  private void zzeK()
  {
    int[] arrayOfInt = new int[2];
    this.zzps.getLocationOnScreen(arrayOfInt);
    zzf(zzl.zzcN().zzc(this.mContext, arrayOfInt[0]), zzl.zzcN().zzc(this.mContext, arrayOfInt[1]));
  }
  
  private zzfp zzeN()
  {
    return new zzfp.zza().zzr(this.zzCz.zzdd()).zzq(this.zzCz.zzde()).zzs(this.zzCz.zzdi()).zzt(this.zzCz.zzdf()).zzu(this.zzCz.zzdg()).zzeE();
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    zzeI();
  }
  
  void zzeG()
  {
    this.zzCC = zzl.zzcN().zzb(this.zzCA, this.zzCA.widthPixels);
    this.zzCD = zzl.zzcN().zzb(this.zzCA, this.zzCA.heightPixels);
    Object localObject = this.zzps.zzhx();
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      this.zzCF = this.zzCC;
      this.zzCG = this.zzCD;
      return;
    }
    localObject = zzp.zzbx().zzg((Activity)localObject);
    this.zzCF = zzl.zzcN().zzb(this.zzCA, localObject[0]);
    this.zzCG = zzl.zzcN().zzb(this.zzCA, localObject[1]);
  }
  
  void zzeH()
  {
    if (this.zzps.zzaP().zztW)
    {
      this.zzCH = this.zzCC;
      this.zzCI = this.zzCD;
      return;
    }
    this.zzps.measure(0, 0);
    this.zzCH = zzl.zzcN().zzc(this.mContext, this.zzps.getMeasuredWidth());
    this.zzCI = zzl.zzcN().zzc(this.mContext, this.zzps.getMeasuredHeight());
  }
  
  public void zzeI()
  {
    zzeF();
    zzeG();
    zzeH();
    zzeL();
    zzeM();
    zzeK();
    zzeJ();
  }
  
  void zzeJ()
  {
    if (zzb.zzQ(2)) {
      zzb.zzaG("Dispatching Ready Event.");
    }
    zzam(this.zzps.zzhF().afmaVersion);
  }
  
  void zzeL()
  {
    zza(this.zzCC, this.zzCD, this.zzCF, this.zzCG, this.zzCB, this.zzCE);
  }
  
  void zzeM()
  {
    zzfp localzzfp = zzeN();
    this.zzps.zzb("onDeviceFeaturesReceived", localzzfp.toJson());
  }
  
  public void zzf(int paramInt1, int paramInt2)
  {
    if ((this.mContext instanceof Activity)) {}
    for (int i = zzp.zzbx().zzj((Activity)this.mContext)[0];; i = 0)
    {
      zzc(paramInt1, paramInt2 - i, this.zzCH, this.zzCI);
      this.zzps.zzhC().zze(paramInt1, paramInt2);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */