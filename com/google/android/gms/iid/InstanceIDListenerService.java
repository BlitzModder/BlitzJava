package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String zzaIT = "gcm.googleapis.com/refresh";
  private static String zzaKl = "google.com/iid";
  private static String zzaKm = "CMD";
  MessengerCompat zzaKj = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      InstanceIDListenerService.zza(InstanceIDListenerService.this, paramAnonymousMessage, MessengerCompat.zzc(paramAnonymousMessage));
    }
  });
  BroadcastReceiver zzaKk = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramAnonymousIntent.getStringExtra("registration_id");
        Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + paramAnonymousIntent.getExtras());
      }
      InstanceIDListenerService.this.zzp(paramAnonymousIntent);
      InstanceIDListenerService.this.stop();
    }
  };
  int zzaKn;
  int zzaKo;
  
  static void zza(Context paramContext, zzd paramzzd)
  {
    paramzzd.zzxU();
    paramzzd = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzd.putExtra(zzaKm, "RST");
    paramzzd.setPackage(paramContext.getPackageName());
    paramContext.startService(paramzzd);
  }
  
  private void zza(Message paramMessage, int paramInt)
  {
    zzc.zzaM(this);
    getPackageManager();
    if ((paramInt != zzc.zzaKv) && (paramInt != zzc.zzaKu))
    {
      Log.w("InstanceID", "Message from unexpected caller " + paramInt + " mine=" + zzc.zzaKu + " appid=" + zzc.zzaKv);
      return;
    }
    zzp((Intent)paramMessage.obj);
  }
  
  static void zzaL(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(zzaKm, "SYNC");
    paramContext.startService(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return this.zzaKj.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(this.zzaKk, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.zzaKk);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzhc(paramInt2);
    if (paramIntent == null)
    {
      stop();
      return 2;
    }
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        zzp(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        GcmReceiver.completeWakefulIntent(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  public void onTokenRefresh() {}
  
  void stop()
  {
    try
    {
      this.zzaKn -= 1;
      if (this.zzaKn == 0) {
        stopSelf(this.zzaKo);
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Stop " + this.zzaKn + " " + this.zzaKo);
      }
      return;
    }
    finally {}
  }
  
  public void zzah(boolean paramBoolean)
  {
    onTokenRefresh();
  }
  
  void zzhc(int paramInt)
  {
    try
    {
      this.zzaKn += 1;
      if (paramInt > this.zzaKo) {
        this.zzaKo = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void zzp(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("subtype");
    Object localObject;
    String str1;
    if (str2 == null)
    {
      localObject = InstanceID.getInstance(this);
      str1 = paramIntent.getStringExtra(zzaKm);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label116;
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Register result in service " + str2);
      }
      ((InstanceID)localObject).zzxQ().zzx(paramIntent);
    }
    label116:
    label298:
    do
    {
      do
      {
        return;
        localObject = new Bundle();
        ((Bundle)localObject).putString("subtype", str2);
        localObject = InstanceID.zza(this, (Bundle)localObject);
        break;
        if (Log.isLoggable("InstanceID", 3)) {
          Log.d("InstanceID", "Service command " + str2 + " " + str1 + " " + paramIntent.getExtras());
        }
        if (paramIntent.getStringExtra("unregistered") != null)
        {
          zzd localzzd = ((InstanceID)localObject).zzxP();
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          localzzd.zzdP(str1);
          ((InstanceID)localObject).zzxQ().zzx(paramIntent);
          return;
        }
        if (zzaIT.equals(paramIntent.getStringExtra("from")))
        {
          ((InstanceID)localObject).zzxP().zzdP(str2);
          zzah(false);
          return;
        }
        if ("RST".equals(str1))
        {
          ((InstanceID)localObject).zzxO();
          zzah(true);
          return;
        }
        if (!"RST_FULL".equals(str1)) {
          break label298;
        }
      } while (((InstanceID)localObject).zzxP().isEmpty());
      ((InstanceID)localObject).zzxP().zzxU();
      zzah(true);
      return;
      if ("SYNC".equals(str1))
      {
        ((InstanceID)localObject).zzxP().zzdP(str2);
        zzah(false);
        return;
      }
    } while (!"PING".equals(str1));
    try
    {
      GoogleCloudMessaging.getInstance(this).send(zzaKl, zzc.zzxT(), 0L, paramIntent.getExtras());
      return;
    }
    catch (IOException paramIntent)
    {
      Log.w("InstanceID", "Failed to send ping response");
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/iid/InstanceIDListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */