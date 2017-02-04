package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzcu
  extends zzct
{
  private static final Object zzbfI = new Object();
  private static zzcu zzbfT;
  private boolean connected = true;
  private Handler handler;
  private Context zzbfJ;
  private zzau zzbfK;
  private volatile zzas zzbfL;
  private int zzbfM = 1800000;
  private boolean zzbfN = true;
  private boolean zzbfO = false;
  private boolean zzbfP = true;
  private zzav zzbfQ = new zzav()
  {
    public void zzav(boolean paramAnonymousBoolean)
    {
      zzcu.this.zzd(paramAnonymousBoolean, zzcu.zza(zzcu.this));
    }
  };
  private zzbl zzbfR;
  private boolean zzbfS = false;
  
  public static zzcu zzFs()
  {
    if (zzbfT == null) {
      zzbfT = new zzcu();
    }
    return zzbfT;
  }
  
  private void zzFt()
  {
    this.zzbfR = new zzbl(this);
    this.zzbfR.zzba(this.zzbfJ);
  }
  
  private void zzFu()
  {
    this.handler = new Handler(this.zzbfJ.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (zzcu.zzFw().equals(paramAnonymousMessage.obj)))
        {
          zzcu.this.dispatch();
          if ((zzcu.zzb(zzcu.this) > 0) && (!zzcu.zzc(zzcu.this))) {
            zzcu.zzd(zzcu.this).sendMessageDelayed(zzcu.zzd(zzcu.this).obtainMessage(1, zzcu.zzFw()), zzcu.zzb(zzcu.this));
          }
        }
        return true;
      }
    });
    if (this.zzbfM > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbfI), this.zzbfM);
    }
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gms/tagmanager/zzcu:zzbfO	Z
    //   6: ifne +16 -> 22
    //   9: ldc 121
    //   11: invokestatic 127	com/google/android/gms/tagmanager/zzbg:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 50	com/google/android/gms/tagmanager/zzcu:zzbfN	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 129	com/google/android/gms/tagmanager/zzcu:zzbfL	Lcom/google/android/gms/tagmanager/zzas;
    //   26: new 10	com/google/android/gms/tagmanager/zzcu$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 130	com/google/android/gms/tagmanager/zzcu$3:<init>	(Lcom/google/android/gms/tagmanager/zzcu;)V
    //   34: invokeinterface 136 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	zzcu
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  zzau zzFv()
  {
    try
    {
      if (this.zzbfK != null) {
        break label50;
      }
      if (this.zzbfJ == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.zzbfK = new zzby(this.zzbfQ, this.zzbfJ);
    label50:
    if (this.handler == null) {
      zzFu();
    }
    this.zzbfO = true;
    if (this.zzbfN)
    {
      dispatch();
      this.zzbfN = false;
    }
    if ((this.zzbfR == null) && (this.zzbfP)) {
      zzFt();
    }
    zzau localzzau = this.zzbfK;
    return localzzau;
  }
  
  /* Error */
  void zza(Context paramContext, zzas paramzzas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/android/gms/tagmanager/zzcu:zzbfJ	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 160	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 78	com/google/android/gms/tagmanager/zzcu:zzbfJ	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 129	com/google/android/gms/tagmanager/zzcu:zzbfL	Lcom/google/android/gms/tagmanager/zzas;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 129	com/google/android/gms/tagmanager/zzcu:zzbfL	Lcom/google/android/gms/tagmanager/zzas;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzcu
    //   0	42	1	paramContext	Context
    //   0	42	2	paramzzas	zzas
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  public void zzaw(boolean paramBoolean)
  {
    try
    {
      zzd(this.zzbfS, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void zzd(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.zzbfS == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.zzbfM > 0)) {
          this.handler.removeMessages(1, zzbfI);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.zzbfM > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzbfI), this.zzbfM);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label153;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      zzbg.v(str1);
      this.zzbfS = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label146:
      String str2 = "terminated.";
      continue;
      label153:
      str2 = "initiated.";
    }
  }
  
  public void zziO()
  {
    try
    {
      if ((!this.zzbfS) && (this.connected) && (this.zzbfM > 0))
      {
        this.handler.removeMessages(1, zzbfI);
        this.handler.sendMessage(this.handler.obtainMessage(1, zzbfI));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */