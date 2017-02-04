package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzao.zza;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService
  extends Service
  implements ChangeListener, CompletionListener, zzc
{
  public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
  private final String mName;
  int zzaiR = -1;
  private CountDownLatch zzanP;
  zza zzanQ;
  boolean zzanR = false;
  
  protected DriveEventService()
  {
    this("DriveEventService");
  }
  
  protected DriveEventService(String paramString)
  {
    this.mName = paramString;
  }
  
  private void zza(OnEventResponse paramOnEventResponse)
  {
    paramOnEventResponse = paramOnEventResponse.zzsT();
    zzz.zzz("DriveEventService", "handleEventMessage: " + paramOnEventResponse);
    for (;;)
    {
      try
      {
        switch (paramOnEventResponse.getType())
        {
        case 3: 
          zzz.zzA(this.mName, "Unhandled event: " + paramOnEventResponse);
          return;
        }
      }
      catch (Exception localException)
      {
        zzz.zza(this.mName, localException, "Error handling event: " + paramOnEventResponse);
        return;
      }
      onChange((ChangeEvent)paramOnEventResponse);
      return;
      onCompletion((CompletionEvent)paramOnEventResponse);
      return;
      zza((ChangesAvailableEvent)paramOnEventResponse);
      return;
    }
  }
  
  private void zzsy()
    throws SecurityException
  {
    int i = getCallingUid();
    if (i == this.zzaiR) {
      return;
    }
    if (GooglePlayServicesUtil.zze(this, i))
    {
      this.zzaiR = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  protected int getCallingUid()
  {
    return Binder.getCallingUid();
  }
  
  public final IBinder onBind(final Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        if ("com.google.android.gms.drive.events.HANDLE_EVENT".equals(paramIntent.getAction()))
        {
          if ((this.zzanQ == null) && (!this.zzanR))
          {
            this.zzanR = true;
            paramIntent = new CountDownLatch(1);
            this.zzanP = new CountDownLatch(1);
            new Thread()
            {
              public void run()
              {
                try
                {
                  Looper.prepare();
                  DriveEventService.this.zzanQ = new DriveEventService.zza(DriveEventService.this);
                  DriveEventService.this.zzanR = false;
                  paramIntent.countDown();
                  zzz.zzz("DriveEventService", "Bound and starting loop");
                  Looper.loop();
                  zzz.zzz("DriveEventService", "Finished loop");
                  return;
                }
                finally
                {
                  if (DriveEventService.zzb(DriveEventService.this) != null) {
                    DriveEventService.zzb(DriveEventService.this).countDown();
                  }
                }
              }
            }.start();
          }
          try
          {
            if (!paramIntent.await(5000L, TimeUnit.MILLISECONDS)) {
              zzz.zzB("DriveEventService", "Failed to synchronously initialize event handler.");
            }
            paramIntent = new zzb().asBinder();
            return paramIntent;
          }
          catch (InterruptedException paramIntent)
          {
            throw new RuntimeException("Unable to start event handler", paramIntent);
          }
        }
        paramIntent = null;
      }
      finally {}
    }
  }
  
  public void onChange(ChangeEvent paramChangeEvent)
  {
    zzz.zzA(this.mName, "Unhandled change event: " + paramChangeEvent);
  }
  
  public void onCompletion(CompletionEvent paramCompletionEvent)
  {
    zzz.zzA(this.mName, "Unhandled completion event: " + paramCompletionEvent);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: ldc -53
    //   6: invokestatic 88	com/google/android/gms/drive/internal/zzz:zzz	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 156	com/google/android/gms/drive/events/DriveEventService:zzanQ	Lcom/google/android/gms/drive/events/DriveEventService$zza;
    //   13: ifnull +53 -> 66
    //   16: aload_0
    //   17: getfield 156	com/google/android/gms/drive/events/DriveEventService:zzanQ	Lcom/google/android/gms/drive/events/DriveEventService$zza;
    //   20: invokestatic 206	com/google/android/gms/drive/events/DriveEventService$zza:zza	(Lcom/google/android/gms/drive/events/DriveEventService$zza;)Landroid/os/Message;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 156	com/google/android/gms/drive/events/DriveEventService:zzanQ	Lcom/google/android/gms/drive/events/DriveEventService$zza;
    //   28: aload_1
    //   29: invokevirtual 210	com/google/android/gms/drive/events/DriveEventService$zza:sendMessage	(Landroid/os/Message;)Z
    //   32: pop
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 156	com/google/android/gms/drive/events/DriveEventService:zzanQ	Lcom/google/android/gms/drive/events/DriveEventService$zza;
    //   38: aload_0
    //   39: getfield 124	com/google/android/gms/drive/events/DriveEventService:zzanP	Ljava/util/concurrent/CountDownLatch;
    //   42: ldc2_w 168
    //   45: getstatic 175	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   48: invokevirtual 179	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   51: ifne +10 -> 61
    //   54: ldc 35
    //   56: ldc -44
    //   58: invokestatic 99	com/google/android/gms/drive/internal/zzz:zzA	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 124	com/google/android/gms/drive/events/DriveEventService:zzanP	Ljava/util/concurrent/CountDownLatch;
    //   66: aload_0
    //   67: invokespecial 214	android/app/Service:onDestroy	()V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: goto -18 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	DriveEventService
    //   23	6	1	localMessage	Message
    //   73	4	1	localObject	Object
    //   78	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	38	73	finally
    //   38	61	73	finally
    //   61	66	73	finally
    //   66	70	73	finally
    //   38	61	78	java/lang/InterruptedException
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return true;
  }
  
  public void zza(ChangesAvailableEvent paramChangesAvailableEvent)
  {
    zzz.zzA(this.mName, "Unhandled changes available event: " + paramChangesAvailableEvent);
  }
  
  final class zza
    extends Handler
  {
    zza() {}
    
    private Message zzb(OnEventResponse paramOnEventResponse)
    {
      return obtainMessage(1, paramOnEventResponse);
    }
    
    private Message zzsz()
    {
      return obtainMessage(2);
    }
    
    public void handleMessage(Message paramMessage)
    {
      zzz.zzz("DriveEventService", "handleMessage message type:" + paramMessage.what);
      switch (paramMessage.what)
      {
      default: 
        zzz.zzA("DriveEventService", "Unexpected message type:" + paramMessage.what);
        return;
      case 1: 
        DriveEventService.zza(DriveEventService.this, (OnEventResponse)paramMessage.obj);
        return;
      }
      getLooper().quit();
    }
  }
  
  final class zzb
    extends zzao.zza
  {
    zzb() {}
    
    public void zzc(OnEventResponse paramOnEventResponse)
      throws RemoteException
    {
      synchronized (DriveEventService.this)
      {
        zzz.zzz("DriveEventService", "onEvent: " + paramOnEventResponse);
        DriveEventService.zza(DriveEventService.this);
        if (DriveEventService.this.zzanQ != null)
        {
          paramOnEventResponse = DriveEventService.zza.zza(DriveEventService.this.zzanQ, paramOnEventResponse);
          DriveEventService.this.zzanQ.sendMessage(paramOnEventResponse);
          return;
        }
        zzz.zzB("DriveEventService", "Receiving event before initialize is completed.");
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/DriveEventService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */