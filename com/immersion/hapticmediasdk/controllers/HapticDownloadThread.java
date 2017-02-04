package com.immersion.hapticmediasdk.controllers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.immersion.hapticmediasdk.utils.FileManager;
import com.immersion.hapticmediasdk.utils.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HapticDownloadThread
  extends Thread
{
  private static final String a = "HapticDownloadThread";
  private static final int b = 4096;
  private static final int c = 60000;
  private String d;
  private Handler e;
  private boolean f;
  private Thread g;
  private FileManager h;
  private volatile boolean i = false;
  private volatile boolean j = false;
  
  static
  {
    if (!HapticDownloadThread.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      bЕЕ04150415ЕЕ = bool;
      return;
    }
  }
  
  public HapticDownloadThread(String paramString, Handler paramHandler, boolean paramBoolean, FileManager paramFileManager)
  {
    super("HapticDownloadThread");
    this.d = paramString;
    this.e = paramHandler;
    this.f = paramBoolean;
    this.h = paramFileManager;
    this.g = this.e.getLooper().getThread();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 80	android/os/Process:setThreadPriority	(I)V
    //   5: new 82	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 47	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:d	Ljava/lang/String;
    //   13: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: getstatic 35	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:bЕЕ04150415ЕЕ	Z
    //   20: ifne +48 -> 68
    //   23: aload_2
    //   24: ifnonnull +44 -> 68
    //   27: new 85	java/lang/AssertionError
    //   30: dup
    //   31: invokespecial 87	java/lang/AssertionError:<init>	()V
    //   34: athrow
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 90	java/net/MalformedURLException:printStackTrace	()V
    //   40: ldc 8
    //   42: new 92	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   49: ldc 95
    //   51: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 47	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:d	Ljava/lang/String;
    //   58: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 108	com/immersion/hapticmediasdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: return
    //   68: aload_2
    //   69: invokevirtual 112	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   72: astore_2
    //   73: aload_2
    //   74: ldc 15
    //   76: invokevirtual 117	java/net/URLConnection:setConnectTimeout	(I)V
    //   79: aload_2
    //   80: invokevirtual 121	java/net/URLConnection:getContentLength	()I
    //   83: istore_1
    //   84: aload_0
    //   85: aload_2
    //   86: invokevirtual 125	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   89: iload_1
    //   90: invokevirtual 129	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:writeToFile	(Ljava/io/InputStream;I)Z
    //   93: pop
    //   94: aload_2
    //   95: instanceof 131
    //   98: ifeq -31 -> 67
    //   101: aload_2
    //   102: checkcast 131	java/net/HttpURLConnection
    //   105: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   108: return
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   114: ldc 8
    //   116: ldc -119
    //   118: invokestatic 108	com/immersion/hapticmediasdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: return
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: getfield 49	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:e	Landroid/os/Handler;
    //   131: bipush 8
    //   133: invokevirtual 142	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   136: astore 4
    //   138: new 144	android/os/Bundle
    //   141: dup
    //   142: invokespecial 145	android/os/Bundle:<init>	()V
    //   145: astore 5
    //   147: aload 5
    //   149: ldc -109
    //   151: aload_3
    //   152: invokevirtual 151	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   155: aload 4
    //   157: aload 5
    //   159: invokevirtual 157	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   162: aload_0
    //   163: getfield 67	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:g	Ljava/lang/Thread;
    //   166: invokevirtual 160	java/lang/Thread:isAlive	()Z
    //   169: ifeq +20 -> 189
    //   172: aload_0
    //   173: getfield 45	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:j	Z
    //   176: ifne +13 -> 189
    //   179: aload_0
    //   180: getfield 49	com/immersion/hapticmediasdk/controllers/HapticDownloadThread:e	Landroid/os/Handler;
    //   183: aload 4
    //   185: invokevirtual 164	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   188: pop
    //   189: ldc 8
    //   191: ldc -90
    //   193: invokestatic 108	com/immersion/hapticmediasdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_2
    //   197: instanceof 131
    //   200: ifeq -133 -> 67
    //   203: aload_2
    //   204: checkcast 131	java/net/HttpURLConnection
    //   207: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   210: return
    //   211: astore_3
    //   212: aload_2
    //   213: instanceof 131
    //   216: ifeq +10 -> 226
    //   219: aload_2
    //   220: checkcast 131	java/net/HttpURLConnection
    //   223: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   226: aload_3
    //   227: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	HapticDownloadThread
    //   83	7	1	k	int
    //   16	8	2	localURL	java.net.URL
    //   35	34	2	localMalformedURLException	java.net.MalformedURLException
    //   72	30	2	localURLConnection	java.net.URLConnection
    //   109	111	2	localIOException	IOException
    //   122	30	3	localException	Exception
    //   211	16	3	localObject	Object
    //   136	48	4	localMessage	Message
    //   145	13	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   5	17	35	java/net/MalformedURLException
    //   68	73	109	java/io/IOException
    //   84	94	122	java/lang/Exception
    //   84	94	211	finally
    //   123	189	211	finally
    //   189	196	211	finally
  }
  
  public void terminate()
  {
    this.j = true;
  }
  
  public boolean writeToFile(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int k = 0;
    localObject2 = new byte['က'];
    if ((paramInputStream != null) && (paramInt > 0)) {}
    for (;;)
    {
      Object localObject1;
      Message localMessage;
      try
      {
        localObject1 = new BufferedInputStream(paramInputStream);
      }
      finally
      {
        Object localObject3;
        Bundle localBundle;
        localObject1 = null;
        localObject2 = null;
        continue;
      }
      try
      {
        paramInputStream = this.h.getUniqueFileName(this.d) + "dat.hapt";
        if (this.f)
        {
          paramInputStream = this.h.makeOutputStreamForStreaming(paramInputStream);
          if (paramInputStream == null)
          {
            if (!this.i)
            {
              localObject2 = this.e.obtainMessage(8);
              localObject3 = new Bundle();
              ((Bundle)localObject3).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
              ((Message)localObject2).setData((Bundle)localObject3);
              if ((this.g.isAlive()) && (!this.j)) {
                this.e.sendMessage((Message)localObject2);
              }
              Log.e("HapticDownloadThread", "downloaded an empty file");
            }
            this.h.closeCloseable((Closeable)localObject1);
            this.h.closeCloseable(paramInputStream);
            return false;
          }
        }
        else
        {
          paramInputStream = this.h.makeOutputStream(paramInputStream, (BufferedInputStream)localObject1);
          continue;
        }
        try
        {
          if (!this.f)
          {
            this.i = true;
            boolean bool = this.j;
            if (bool)
            {
              if (!this.i)
              {
                localObject2 = this.e.obtainMessage(8);
                localObject3 = new Bundle();
                ((Bundle)localObject3).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
                ((Message)localObject2).setData((Bundle)localObject3);
                if ((this.g.isAlive()) && (!this.j)) {
                  this.e.sendMessage((Message)localObject2);
                }
                Log.e("HapticDownloadThread", "downloaded an empty file");
              }
              this.h.closeCloseable((Closeable)localObject1);
              this.h.closeCloseable(paramInputStream);
              return true;
            }
            this.e.sendMessage(this.e.obtainMessage(3, paramInt, 0));
            Log.i("HapticDownloadThread", "file download completed");
            if (!this.i)
            {
              localObject2 = this.e.obtainMessage(8);
              localObject3 = new Bundle();
              ((Bundle)localObject3).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
              ((Message)localObject2).setData((Bundle)localObject3);
              if ((this.g.isAlive()) && (!this.j)) {
                this.e.sendMessage((Message)localObject2);
              }
              Log.e("HapticDownloadThread", "downloaded an empty file");
            }
            this.h.closeCloseable((Closeable)localObject1);
            this.h.closeCloseable(paramInputStream);
            return true;
          }
          if ((!isInterrupted()) && (!this.j))
          {
            paramInt = ((BufferedInputStream)localObject1).read((byte[])localObject2, 0, 4096);
            if (paramInt >= 0)
            {
              paramInputStream.write((byte[])localObject2, 0, paramInt);
              paramInt = k + paramInt;
              k = paramInt;
              if (this.g.isAlive())
              {
                if (!this.i) {
                  this.i = true;
                }
                paramInputStream.flush();
                localObject3 = this.e.obtainMessage(3, paramInt, 0);
                this.e.sendMessage((Message)localObject3);
                k = paramInt;
              }
            }
          }
          else
          {
            continue;
            if (this.i) {
              continue;
            }
          }
        }
        finally
        {
          localObject2 = localObject1;
          localObject1 = paramInputStream;
          paramInputStream = (InputStream)localObject4;
        }
      }
      finally
      {
        localMessage = null;
        localObject2 = localObject1;
        localObject1 = localMessage;
      }
    }
    localMessage = this.e.obtainMessage(8);
    localBundle = new Bundle();
    localBundle.putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
    localMessage.setData(localBundle);
    if ((this.g.isAlive()) && (!this.j)) {
      this.e.sendMessage(localMessage);
    }
    Log.e("HapticDownloadThread", "downloaded an empty file");
    this.h.closeCloseable((Closeable)localObject2);
    this.h.closeCloseable((Closeable)localObject1);
    throw paramInputStream;
    if (!this.i)
    {
      paramInputStream = this.e.obtainMessage(8);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
      paramInputStream.setData((Bundle)localObject1);
      if ((this.g.isAlive()) && (!this.j)) {
        this.e.sendMessage(paramInputStream);
      }
      Log.e("HapticDownloadThread", "downloaded an empty file");
    }
    this.h.closeCloseable(null);
    this.h.closeCloseable(null);
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/HapticDownloadThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */