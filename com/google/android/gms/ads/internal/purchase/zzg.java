package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgf.zza;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzg
  extends zzgf.zza
  implements ServiceConnection
{
  private Context mContext;
  zzb zzEB;
  private String zzEH;
  private zzf zzEL;
  private boolean zzER = false;
  private int zzES;
  private Intent zzET;
  
  public zzg(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, zzf paramzzf)
  {
    this.zzEH = paramString;
    this.zzES = paramInt;
    this.zzET = paramIntent;
    this.zzER = paramBoolean;
    this.mContext = paramContext;
    this.zzEL = paramzzf;
  }
  
  public void finishPurchase()
  {
    int i = zzp.zzbH().zzd(this.zzET);
    if ((this.zzES != -1) || (i != 0)) {
      return;
    }
    this.zzEB = new zzb(this.mContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return this.zzEH;
  }
  
  public Intent getPurchaseData()
  {
    return this.zzET;
  }
  
  public int getResultCode()
  {
    return this.zzES;
  }
  
  public boolean isVerified()
  {
    return this.zzER;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service connected.");
    this.zzEB.zzN(paramIBinder);
    paramComponentName = zzp.zzbH().zze(this.zzET);
    paramComponentName = zzp.zzbH().zzaq(paramComponentName);
    if (paramComponentName == null) {
      return;
    }
    if (this.zzEB.zzh(this.mContext.getPackageName(), paramComponentName) == 0) {
      zzh.zzy(this.mContext).zza(this.zzEL);
    }
    com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, this);
    this.zzEB.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    this.zzEB.destroy();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/purchase/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */