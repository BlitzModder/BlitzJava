package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Executor;

public abstract class GcmListenerService
  extends Service
{
  private static boolean zzaIK = false;
  private int zzaII;
  private int zzaIJ = 0;
  private final Object zzpK = new Object();
  
  private void zzm(Intent paramIntent)
  {
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
    if (localPendingIntent != null) {}
    try
    {
      localPendingIntent.send();
      zza.zzf(this, paramIntent);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;)
      {
        Log.e("GcmListenerService", "Notification pending intent canceled");
      }
    }
  }
  
  private void zzn(final Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable()
      {
        public void run()
        {
          GcmListenerService.zza(GcmListenerService.this, paramIntent);
        }
      });
      return;
    }
    new AsyncTask()
    {
      protected Void zzb(Void... paramAnonymousVarArgs)
      {
        GcmListenerService.zza(GcmListenerService.this, paramIntent);
        return null;
      }
    }.execute(new Void[0]);
  }
  
  private void zzo(Intent paramIntent)
  {
    for (;;)
    {
      int i;
      try
      {
        str = paramIntent.getAction();
        i = -1;
        switch (str.hashCode())
        {
        case 366519424: 
          Log.d("GcmListenerService", "Unknown intent action: " + paramIntent.getAction());
          zzxv();
          return;
        }
      }
      finally
      {
        String str;
        GcmReceiver.completeWakefulIntent(paramIntent);
      }
      if (str.equals("com.google.android.c2dm.intent.RECEIVE"))
      {
        i = 0;
        break label126;
        if (str.equals("com.google.android.gms.gcm.NOTIFICATION_DISMISS"))
        {
          i = 1;
          break label126;
          zzp(paramIntent);
          continue;
          zza.zzg(this, paramIntent);
          continue;
        }
      }
      label126:
      switch (i)
      {
      }
    }
  }
  
  private void zzp(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("message_type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "gcm";
    }
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.w("GcmListenerService", "Received message with unknown type: " + str1);
        return;
        if (str1.equals("gcm"))
        {
          i = 0;
          continue;
          if (str1.equals("deleted_messages"))
          {
            i = 1;
            continue;
            if (str1.equals("send_event"))
            {
              i = 2;
              continue;
              if (str1.equals("send_error")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (zzr(paramIntent)) {
      zza.zze(this, paramIntent);
    }
    zzq(paramIntent);
    return;
    onDeletedMessages();
    return;
    onMessageSent(paramIntent.getStringExtra("google.message_id"));
    return;
    onSendError(paramIntent.getStringExtra("google.message_id"), paramIntent.getStringExtra("error"));
  }
  
  private void zzq(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    localBundle.remove("message_type");
    localBundle.remove("android.support.content.wakelockid");
    if (zzb.zzx(localBundle))
    {
      if (!zzb.zzaH(this))
      {
        zzb.zzc(this, getClass()).zzz(localBundle);
        return;
      }
      zzb.zzy(localBundle);
      if (zzr(paramIntent)) {
        zza.zzh(this, paramIntent);
      }
    }
    paramIntent = localBundle.getString("from");
    localBundle.remove("from");
    onMessageReceived(paramIntent, localBundle);
  }
  
  static boolean zzr(Intent paramIntent)
  {
    return (zzaIK) && (!TextUtils.isEmpty(paramIntent.getStringExtra("gcm.a.campaign")));
  }
  
  static boolean zzw(Bundle paramBundle)
  {
    return (zzaIK) && (!TextUtils.isEmpty(paramBundle.getString("gcm.a.campaign")));
  }
  
  private void zzxv()
  {
    synchronized (this.zzpK)
    {
      this.zzaIJ -= 1;
      if (this.zzaIJ == 0) {
        zzgU(this.zzaII);
      }
      return;
    }
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(String paramString, Bundle paramBundle) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onSendError(String paramString1, String paramString2) {}
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        this.zzaII = paramInt2;
        this.zzaIJ += 1;
        if ("com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
        {
          zzm(paramIntent);
          zzxv();
          GcmReceiver.completeWakefulIntent(paramIntent);
          return 3;
        }
      }
      zzn(paramIntent);
    }
  }
  
  boolean zzgU(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/GcmListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */