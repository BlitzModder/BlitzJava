package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgd.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zziq;

@zzha
public class zze
  extends zzgd.zza
  implements ServiceConnection
{
  private final Activity mActivity;
  private zzb zzEB;
  zzh zzEC;
  private zzk zzEE;
  private Context zzEJ;
  private zzgb zzEK;
  private zzf zzEL;
  private zzj zzEM;
  private String zzEN = null;
  
  public zze(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.zzEC = zzh.zzy(this.mActivity.getApplicationContext());
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 1001
    //   4: if_icmpne +85 -> 89
    //   7: iconst_0
    //   8: istore 4
    //   10: invokestatic 59	com/google/android/gms/ads/internal/zzp:zzbH	()Lcom/google/android/gms/ads/internal/purchase/zzi;
    //   13: aload_3
    //   14: invokevirtual 65	com/google/android/gms/ads/internal/purchase/zzi:zzd	(Landroid/content/Intent;)I
    //   17: istore_1
    //   18: iload_2
    //   19: iconst_m1
    //   20: if_icmpne +70 -> 90
    //   23: invokestatic 59	com/google/android/gms/ads/internal/zzp:zzbH	()Lcom/google/android/gms/ads/internal/purchase/zzi;
    //   26: pop
    //   27: iload_1
    //   28: ifne +62 -> 90
    //   31: aload_0
    //   32: getfield 67	com/google/android/gms/ads/internal/purchase/zze:zzEE	Lcom/google/android/gms/ads/internal/purchase/zzk;
    //   35: aload_0
    //   36: getfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   39: iload_2
    //   40: aload_3
    //   41: invokevirtual 73	com/google/android/gms/ads/internal/purchase/zzk:zza	(Ljava/lang/String;ILandroid/content/Intent;)Z
    //   44: ifeq +6 -> 50
    //   47: iconst_1
    //   48: istore 4
    //   50: aload_0
    //   51: getfield 75	com/google/android/gms/ads/internal/purchase/zze:zzEK	Lcom/google/android/gms/internal/zzgb;
    //   54: iload_1
    //   55: invokeinterface 81 2 0
    //   60: aload_0
    //   61: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   64: invokevirtual 84	android/app/Activity:finish	()V
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 75	com/google/android/gms/ads/internal/purchase/zze:zzEK	Lcom/google/android/gms/internal/zzgb;
    //   72: invokeinterface 88 1 0
    //   77: iload 4
    //   79: iload_2
    //   80: aload_3
    //   81: invokevirtual 91	com/google/android/gms/ads/internal/purchase/zze:zza	(Ljava/lang/String;ZILandroid/content/Intent;)V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   89: return
    //   90: aload_0
    //   91: getfield 48	com/google/android/gms/ads/internal/purchase/zze:zzEC	Lcom/google/android/gms/ads/internal/purchase/zzh;
    //   94: aload_0
    //   95: getfield 93	com/google/android/gms/ads/internal/purchase/zze:zzEL	Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   98: invokevirtual 96	com/google/android/gms/ads/internal/purchase/zzh:zza	(Lcom/google/android/gms/ads/internal/purchase/zzf;)V
    //   101: goto -51 -> 50
    //   104: astore_3
    //   105: ldc 98
    //   107: invokestatic 104	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   114: invokevirtual 84	android/app/Activity:finish	()V
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   122: return
    //   123: astore_3
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzEN	Ljava/lang/String;
    //   129: aload_3
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	zze
    //   0	131	1	paramInt1	int
    //   0	131	2	paramInt2	int
    //   0	131	3	paramIntent	Intent
    //   8	70	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	18	104	android/os/RemoteException
    //   23	27	104	android/os/RemoteException
    //   31	47	104	android/os/RemoteException
    //   50	84	104	android/os/RemoteException
    //   90	101	104	android/os/RemoteException
    //   10	18	123	finally
    //   23	27	123	finally
    //   31	47	123	finally
    //   50	84	123	finally
    //   90	101	123	finally
    //   105	117	123	finally
  }
  
  public void onCreate()
  {
    Object localObject = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
    this.zzEM = ((GInAppPurchaseManagerInfoParcel)localObject).zzEx;
    this.zzEE = ((GInAppPurchaseManagerInfoParcel)localObject).zzrm;
    this.zzEK = ((GInAppPurchaseManagerInfoParcel)localObject).zzEv;
    this.zzEB = new zzb(this.mActivity.getApplicationContext());
    this.zzEJ = ((GInAppPurchaseManagerInfoParcel)localObject).zzEw;
    if (this.mActivity.getResources().getConfiguration().orientation == 2) {
      this.mActivity.setRequestedOrientation(zzp.zzbz().zzhd());
    }
    for (;;)
    {
      localObject = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      ((Intent)localObject).setPackage("com.android.vending");
      this.mActivity.bindService((Intent)localObject, this, 1);
      return;
      this.mActivity.setRequestedOrientation(zzp.zzbz().zzhe());
    }
  }
  
  public void onDestroy()
  {
    this.mActivity.unbindService(this);
    this.zzEB.destroy();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzEB.zzN(paramIBinder);
    try
    {
      this.zzEN = this.zzEE.zzfN();
      paramComponentName = this.zzEB.zzb(this.mActivity.getPackageName(), this.zzEK.getProductId(), this.zzEN);
      paramIBinder = (PendingIntent)paramComponentName.getParcelable("BUY_INTENT");
      if (paramIBinder == null)
      {
        int i = zzp.zzbH().zzd(paramComponentName);
        this.zzEK.recordPlayBillingResolution(i);
        zza(this.zzEK.getProductId(), false, i, null);
        this.mActivity.finish();
        return;
      }
      this.zzEL = new zzf(this.zzEK.getProductId(), this.zzEN);
      this.zzEC.zzb(this.zzEL);
      this.mActivity.startIntentSenderForResult(paramIBinder.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException paramComponentName)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Error when connecting in-app billing service", paramComponentName);
      this.mActivity.finish();
      return;
    }
    catch (IntentSender.SendIntentException paramComponentName)
    {
      for (;;) {}
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    this.zzEB.destroy();
  }
  
  protected void zza(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (this.zzEM != null) {
      this.zzEM.zza(paramString, paramBoolean, paramInt, paramIntent, this.zzEL);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/purchase/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */