package com.immersion.hapticmediasdk.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import com.immersion.hapticmediasdk.utils.Profiler;
import com.immersion.hapticmediasdk.utils.RuntimeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import rrrrrr.ccrcrr;
import rrrrrr.crcrrr;
import rrrrrr.rccrrr;
import rrrrrr.rrcrrr;

public class HapticPlaybackThread
  extends Thread
{
  private static final long D = 100L;
  private static final int E = 5;
  public static final int HAPTIC_BYTES_AVAILABLE_TO_DOWNLOAD = 3;
  public static final int HAPTIC_DOWNLOAD_ERROR = 8;
  public static final String HAPTIC_DOWNLOAD_EXCEPTION_KEY = "haptic_download_exception";
  public static final int HAPTIC_PAUSE_PLAYBACK = 5;
  public static final int HAPTIC_PLAYBACK_FOR_TIME_CODE = 2;
  public static final int HAPTIC_PLAYBACK_IS_READY = 6;
  public static final int HAPTIC_QUIT_PLAYBACK = 9;
  public static final int HAPTIC_SET_BUFFERING_POSITION = 1;
  public static final int HAPTIC_STOP_PLAYBACK = 4;
  public static final int PAUSE_AV_FOR_HAPTIC_BUFFERING = 7;
  private static final String a = "HapticPlaybackThread";
  private static final int b = Integer.MIN_VALUE;
  private static final String c = "playback_timecode";
  private static final String d = "playback_uptime";
  private RuntimeInfo A;
  private boolean B = false;
  private FileManager C;
  private final Runnable F = new rrcrrr(this);
  private final Runnable G = new crcrrr(this);
  public volatile boolean b0415ЕЕ0415Е0415 = false;
  public volatile boolean bЕ0415Е0415Е0415 = false;
  public Context bЕЕЕ0415Е0415;
  private int e = 0;
  private final String f;
  private Handler g;
  private final Handler h;
  private HapticDownloadThread i;
  private Looper j;
  private IHapticFileReader k;
  private EndpointWarp l;
  private final Profiler m = new Profiler();
  private Object n = new Object();
  private Object o = new Object();
  private int p;
  private int q;
  private int r;
  private long s;
  private int t;
  private int u;
  private int v;
  private long w;
  private boolean x = false;
  private boolean y = false;
  private ArrayList z;
  
  public HapticPlaybackThread(Context paramContext, String paramString, Handler paramHandler, boolean paramBoolean, RuntimeInfo paramRuntimeInfo)
  {
    super("HapticPlaybackThread");
    this.f = paramString;
    this.h = paramHandler;
    this.bЕЕЕ0415Е0415 = paramContext;
    this.B = paramBoolean;
    this.C = new FileManager(paramContext);
    this.A = paramRuntimeInfo;
    this.z = new ArrayList();
  }
  
  private void a()
  {
    while (this.i.isAlive())
    {
      this.i.terminate();
      this.i.interrupt();
      Thread.currentThread();
      Thread.yield();
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (!this.y)
    {
      try
      {
        if (this.k == null) {
          return;
        }
        if (this.l != null) {
          break label94;
        }
        byte[] arrayOfByte = this.k.getEncryptedHapticHeader();
        if (arrayOfByte == null)
        {
          Log.e("HapticPlaybackThread", "corrupted hapt file or unsupported format");
          return;
        }
      }
      catch (Error localError)
      {
        Log.e("HapticPlaybackThread", localError.getMessage());
        return;
      }
      this.l = new EndpointWarp(this.bЕЕЕ0415Е0415, localError, localError.length);
      if (this.l == null)
      {
        Log.d("HapticPlaybackThread", "Error creating endpointwarp");
        return;
      }
      label94:
      this.l.start();
    }
    this.bЕ0415Е0415Е0415 = false;
    this.y = true;
    this.v = 0;
    synchronized (this.n)
    {
      this.u = paramInt;
      this.t = this.u;
      if (this.w != 0L) {
        this.w = SystemClock.uptimeMillis();
      }
      this.s = paramLong;
      h();
      return;
    }
  }
  
  private void a(Message paramMessage)
  {
    this.x = true;
    Message localMessage = this.h.obtainMessage(8);
    localMessage.setData(paramMessage.getData());
    this.h.sendMessage(localMessage);
  }
  
  private void b()
  {
    if (this.i != null)
    {
      a();
      this.i = null;
    }
    synchronized (this.o)
    {
      this.g.removeCallbacksAndMessages(null);
      if (this.j != null)
      {
        this.j.quit();
        this.j = null;
      }
      if (this.k != null)
      {
        this.k.close();
        this.k = null;
      }
      if (this.l != null)
      {
        this.l.stop();
        this.l.dispose();
        this.l = null;
      }
      this.C.deleteHapticStorage();
      return;
    }
  }
  
  private void c()
  {
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  private void d()
  {
    if (!this.x)
    {
      int i1 = this.r;
      this.r = (i1 + 1);
      if (i1 != 5) {
        break label62;
      }
      this.h.sendMessage(this.h.obtainMessage(7, this.p, 0));
      this.g.postDelayed(this.F, 100L);
    }
    label62:
    do
    {
      return;
      if ((this.k == null) || (!this.k.bufferAtPlaybackPosition(this.p))) {
        break;
      }
    } while (this.q == Integer.MIN_VALUE);
    this.h.sendMessage(this.h.obtainMessage(6, this.p, this.q));
    return;
    this.g.postDelayed(this.F, 100L);
  }
  
  private void e()
  {
    try
    {
      b();
      return;
    }
    catch (Exception localException)
    {
      Log.e("HapticPlaybackThread", "quit() : " + localException.getMessage());
      return;
    }
    finally
    {
      this.b0415ЕЕ0415Е0415 = false;
      c();
    }
  }
  
  private void f()
  {
    this.y = false;
    if (this.l != null) {
      this.l.stop();
    }
    this.g.removeCallbacks(this.F);
    removePlaybackCallbacks();
    synchronized (this.n)
    {
      this.u = 0;
      this.t = 0;
      this.w = 0L;
      this.v = 0;
      this.s = 0L;
      this.bЕ0415Е0415Е0415 = true;
      return;
    }
  }
  
  private void g()
  {
    this.y = false;
    removePlaybackCallbacks();
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:y	Z
    //   4: ifeq +162 -> 166
    //   7: aload_0
    //   8: getfield 117	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:n	Ljava/lang/Object;
    //   11: astore 10
    //   13: aload 10
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 219	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:u	I
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 221	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:t	I
    //   25: istore_2
    //   26: aload 10
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 184	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:k	Lcom/immersion/hapticmediasdk/controllers/IHapticFileReader;
    //   33: iload_1
    //   34: invokeinterface 390 2 0
    //   39: astore 10
    //   41: aload_0
    //   42: getfield 184	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:k	Lcom/immersion/hapticmediasdk/controllers/IHapticFileReader;
    //   45: iload_1
    //   46: i2l
    //   47: invokeinterface 394 3 0
    //   52: istore_3
    //   53: aload_0
    //   54: getfield 184	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:k	Lcom/immersion/hapticmediasdk/controllers/IHapticFileReader;
    //   57: iload_1
    //   58: i2l
    //   59: invokeinterface 398 3 0
    //   64: lstore 4
    //   66: aload 10
    //   68: ifnull +142 -> 210
    //   71: aload_0
    //   72: getfield 231	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:s	J
    //   75: lstore 6
    //   77: aload_0
    //   78: getfield 217	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:v	I
    //   81: i2l
    //   82: lstore 8
    //   84: new 6	rrrrrr/ccrcrr
    //   87: dup
    //   88: aload_0
    //   89: iload_1
    //   90: i2l
    //   91: iload_2
    //   92: i2l
    //   93: aload 10
    //   95: iload_3
    //   96: lload 4
    //   98: invokespecial 401	rrrrrr/ccrcrr:<init>	(Lcom/immersion/hapticmediasdk/controllers/HapticPlaybackThread;JJ[BIJ)V
    //   101: astore 11
    //   103: aload_0
    //   104: getfield 119	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:o	Ljava/lang/Object;
    //   107: astore 10
    //   109: aload 10
    //   111: monitorenter
    //   112: aload_0
    //   113: getfield 157	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:z	Ljava/util/ArrayList;
    //   116: aload 11
    //   118: invokevirtual 405	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload 10
    //   124: monitorexit
    //   125: aload_0
    //   126: getfield 258	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:g	Landroid/os/Handler;
    //   129: aload 11
    //   131: aload_0
    //   132: getfield 105	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:e	I
    //   135: i2l
    //   136: lload 8
    //   138: lload 6
    //   140: ladd
    //   141: ladd
    //   142: invokevirtual 408	android/os/Handler:postAtTime	(Ljava/lang/Runnable;J)Z
    //   145: pop
    //   146: aload_0
    //   147: aload_0
    //   148: getfield 217	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:v	I
    //   151: aload_0
    //   152: getfield 105	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:e	I
    //   155: iadd
    //   156: putfield 217	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:v	I
    //   159: aload_0
    //   160: getfield 112	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:m	Lcom/immersion/hapticmediasdk/utils/Profiler;
    //   163: invokevirtual 411	com/immersion/hapticmediasdk/utils/Profiler:startTimingII	()V
    //   166: return
    //   167: astore 11
    //   169: aload 10
    //   171: monitorexit
    //   172: aload 11
    //   174: athrow
    //   175: astore 10
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 123	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:y	Z
    //   182: aload_0
    //   183: getfield 141	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:h	Landroid/os/Handler;
    //   186: aload_0
    //   187: getfield 141	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:h	Landroid/os/Handler;
    //   190: bipush 7
    //   192: iload_1
    //   193: iconst_0
    //   194: invokevirtual 350	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   197: invokevirtual 254	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   200: pop
    //   201: return
    //   202: astore 11
    //   204: aload 10
    //   206: monitorexit
    //   207: aload 11
    //   209: athrow
    //   210: aload_0
    //   211: getfield 117	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:n	Ljava/lang/Object;
    //   214: astore 10
    //   216: aload 10
    //   218: monitorenter
    //   219: aload_0
    //   220: iconst_0
    //   221: putfield 219	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:u	I
    //   224: aload_0
    //   225: iconst_0
    //   226: putfield 221	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:t	I
    //   229: aload 10
    //   231: monitorexit
    //   232: aload_0
    //   233: iconst_0
    //   234: putfield 217	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:v	I
    //   237: aload_0
    //   238: lconst_0
    //   239: putfield 231	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:s	J
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 123	com/immersion/hapticmediasdk/controllers/HapticPlaybackThread:y	Z
    //   247: return
    //   248: astore 11
    //   250: aload 10
    //   252: monitorexit
    //   253: aload 11
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	HapticPlaybackThread
    //   20	173	1	i1	int
    //   25	67	2	i2	int
    //   52	44	3	i3	int
    //   64	33	4	l1	long
    //   75	64	6	l2	long
    //   82	55	8	l3	long
    //   175	30	10	localNotEnoughHapticBytesAvailableException	com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException
    //   101	29	11	localccrcrr	ccrcrr
    //   167	6	11	localObject3	Object
    //   202	6	11	localObject4	Object
    //   248	6	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	167	finally
    //   169	172	167	finally
    //   29	66	175	com/immersion/hapticmediasdk/models/NotEnoughHapticBytesAvailableException
    //   112	125	202	finally
    //   204	207	202	finally
    //   219	232	248	finally
    //   250	253	248	finally
  }
  
  public Handler getHandler()
  {
    return this.g;
  }
  
  public boolean isStarted()
  {
    return this.b0415ЕЕ0415Е0415;
  }
  
  public boolean isStopped()
  {
    return this.bЕ0415Е0415Е0415;
  }
  
  public void pauseHapticPlayback()
  {
    this.g.sendEmptyMessage(5);
  }
  
  public void playHapticForPlaybackPosition(int paramInt, long paramLong)
  {
    removePlaybackCallbacks();
    this.g.removeMessages(2);
    Bundle localBundle = new Bundle();
    localBundle.putInt("playback_timecode", paramInt);
    localBundle.putLong("playback_uptime", paramLong);
    Message localMessage = this.g.obtainMessage(2);
    localMessage.setData(localBundle);
    this.g.sendMessage(localMessage);
  }
  
  public void prepareHapticPlayback(int paramInt1, int paramInt2)
  {
    this.g.removeMessages(1);
    this.g.sendMessage(this.g.obtainMessage(1, paramInt1, paramInt2));
  }
  
  public void quitHapticPlayback()
  {
    if (!this.g.sendEmptyMessage(9))
    {
      this.b0415ЕЕ0415Е0415 = false;
      c();
    }
  }
  
  public void removePlaybackCallbacks()
  {
    synchronized (this.o)
    {
      Iterator localIterator = this.z.iterator();
      if (localIterator.hasNext())
      {
        ccrcrr localccrcrr = (ccrcrr)localIterator.next();
        this.g.removeCallbacks(localccrcrr);
      }
    }
    this.z.clear();
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    Looper.prepare();
    this.j = Looper.myLooper();
    this.g = new rccrrr(this, null);
    this.i = new HapticDownloadThread(this.f, this.g, this.B, this.C);
    this.i.start();
    this.b0415ЕЕ0415Е0415 = true;
    c();
    Looper.loop();
  }
  
  public void stopHapticPlayback()
  {
    this.g.sendEmptyMessage(4);
  }
  
  public void syncUpdate(int paramInt, long paramLong)
  {
    synchronized (this.n)
    {
      long l1 = SystemClock.uptimeMillis();
      paramInt = (int)(paramInt + (l1 - paramLong));
      int i1 = this.u;
      i1 = paramInt - ((int)(l1 - this.w) + i1);
      if (50 < Math.abs(i1))
      {
        this.u = (i1 + this.u);
        this.t = this.u;
        this.g.sendMessage(this.g.obtainMessage(1, paramInt, Integer.MIN_VALUE));
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/HapticPlaybackThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */