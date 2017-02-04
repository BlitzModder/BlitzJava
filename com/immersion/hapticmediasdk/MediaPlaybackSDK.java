package com.immersion.hapticmediasdk;

import android.content.Context;
import android.webkit.URLUtil;
import com.immersion.hapticmediasdk.utils.Log;
import java.io.File;

public class MediaPlaybackSDK
  extends HapticContentSDK
{
  private static final String a = "HapticContentSDK";
  private int b = 400;
  
  public MediaPlaybackSDK(Context paramContext)
  {
    super(0, paramContext);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ldc 28
    //   6: ldc 30
    //   8: invokevirtual 36	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: new 6	rrrrrr/rrccrr
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 39	rrrrrr/rrccrr:<init>	(Lcom/immersion/hapticmediasdk/MediaPlaybackSDK;Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 41	java/lang/Thread
    //   25: dup
    //   26: aload_1
    //   27: ldc 43
    //   29: invokespecial 46	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   32: invokevirtual 50	java/lang/Thread:start	()V
    //   35: aload_1
    //   36: monitorenter
    //   37: aload_0
    //   38: bipush -100
    //   40: putfield 20	com/immersion/hapticmediasdk/MediaPlaybackSDK:b	I
    //   43: aload_0
    //   44: getfield 20	com/immersion/hapticmediasdk/MediaPlaybackSDK:b	I
    //   47: istore_2
    //   48: iload_2
    //   49: ifge +30 -> 79
    //   52: aload_1
    //   53: ldc2_w 51
    //   56: invokevirtual 58	java/lang/Object:wait	(J)V
    //   59: goto -16 -> 43
    //   62: astore 5
    //   64: goto -21 -> 43
    //   67: astore_1
    //   68: ldc 11
    //   70: aload_1
    //   71: invokevirtual 62	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   74: invokestatic 68	com/immersion/hapticmediasdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: iconst_0
    //   78: ireturn
    //   79: iload 4
    //   81: istore_3
    //   82: sipush 200
    //   85: aload_0
    //   86: getfield 20	com/immersion/hapticmediasdk/MediaPlaybackSDK:b	I
    //   89: if_icmpgt +18 -> 107
    //   92: iload 4
    //   94: istore_3
    //   95: aload_0
    //   96: getfield 20	com/immersion/hapticmediasdk/MediaPlaybackSDK:b	I
    //   99: sipush 399
    //   102: if_icmpgt +5 -> 107
    //   105: iconst_1
    //   106: istore_3
    //   107: aload_1
    //   108: monitorexit
    //   109: iload_3
    //   110: ireturn
    //   111: astore 5
    //   113: aload_1
    //   114: monitorexit
    //   115: aload 5
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	MediaPlaybackSDK
    //   0	118	1	paramString	String
    //   47	2	2	i	int
    //   81	29	3	bool1	boolean
    //   1	92	4	bool2	boolean
    //   62	1	5	localInterruptedException	InterruptedException
    //   111	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	62	java/lang/InterruptedException
    //   12	22	67	java/net/MalformedURLException
    //   37	43	111	finally
    //   43	48	111	finally
    //   52	59	111	finally
    //   82	92	111	finally
    //   95	105	111	finally
    //   107	109	111	finally
    //   113	115	111	finally
  }
  
  private int b(String paramString)
  {
    if (paramString == null)
    {
      Log.e("HapticContentSDK", "invalid local hapt file url: null");
      return -4;
    }
    File localFile = new File(paramString);
    if (localFile.isFile())
    {
      if (localFile.canRead())
      {
        this.mMediaTaskManager.setHapticsUrl("file:" + paramString, false);
        return this.mMediaTaskManager.transitToState(HapticContentSDK.SDKStatus.INITIALIZED);
      }
      Log.e("HapticContentSDK", "could not access local hapt file: permission denied");
      return -3;
    }
    Log.e("HapticContentSDK", "invalid local hapt file url: directory");
    return -4;
  }
  
  public int openHaptics(String paramString)
  {
    HapticContentSDK.SDKStatus localSDKStatus = getSDKStatus();
    if ((localSDKStatus == HapticContentSDK.SDKStatus.STOPPED) || (localSDKStatus == HapticContentSDK.SDKStatus.NOT_INITIALIZED) || (localSDKStatus == HapticContentSDK.SDKStatus.INITIALIZED) || (localSDKStatus == HapticContentSDK.SDKStatus.STOPPED_DUE_TO_ERROR))
    {
      int i = this.mMediaTaskManager.transitToState(HapticContentSDK.SDKStatus.NOT_INITIALIZED);
      if (i != 0) {
        return i;
      }
      if (!URLUtil.isValidUrl(paramString)) {
        return b(paramString);
      }
      if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)))
      {
        if (a(paramString))
        {
          this.mMediaTaskManager.setHapticsUrl(paramString, true);
          return this.mMediaTaskManager.transitToState(HapticContentSDK.SDKStatus.INITIALIZED);
        }
        Log.e("HapticContentSDK", "could not access hapt file url: Inaccessible URL");
        return -2;
      }
      if (URLUtil.isFileUrl(paramString)) {
        return b(paramString);
      }
      Log.e("HapticContentSDK", "could not access hapt file url: unsupposted protocol");
      return -5;
    }
    return -1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/MediaPlaybackSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */