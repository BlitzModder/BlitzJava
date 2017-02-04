package com.dava.framework;

public class JNISendMail
{
  static final String TAG = "JNISendMail";
  static boolean res;
  
  /* Error */
  public static boolean SendEMail(String paramString1, final String paramString2, final String paramString3)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   9: aload_0
    //   10: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_1
    //   14: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_2
    //   18: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 38	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   27: pop
    //   28: iconst_0
    //   29: putstatic 40	com/dava/framework/JNISendMail:res	Z
    //   32: new 4	java/lang/Object
    //   35: dup
    //   36: invokespecial 16	java/lang/Object:<init>	()V
    //   39: astore_3
    //   40: invokestatic 46	com/dava/framework/JNIActivity:GetActivity	()Lcom/dava/framework/JNIActivity;
    //   43: new 6	com/dava/framework/JNISendMail$1
    //   46: dup
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: aload_3
    //   51: invokespecial 49	com/dava/framework/JNISendMail$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   54: invokevirtual 53	com/dava/framework/JNIActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   57: aload_3
    //   58: monitorenter
    //   59: aload_3
    //   60: invokevirtual 56	java/lang/Object:wait	()V
    //   63: aload_3
    //   64: monitorexit
    //   65: getstatic 40	com/dava/framework/JNISendMail:res	Z
    //   68: ireturn
    //   69: astore_0
    //   70: aload_3
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -12 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString1	String
    //   0	78	1	paramString2	String
    //   0	78	2	paramString3	String
    //   39	32	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	63	69	finally
    //   63	65	69	finally
    //   70	72	69	finally
    //   59	63	74	java/lang/InterruptedException
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNISendMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */