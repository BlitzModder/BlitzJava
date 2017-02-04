package com.dava.framework;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public class JNIAssert
{
  private static boolean alreadyShowingNonModalDialog = false;
  private static boolean breakExecution;
  public static volatile boolean waitUserInputOnAssertDialog = false;
  
  static
  {
    breakExecution = false;
  }
  
  /* Error */
  public static boolean Assert(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_0
    //   6: ifne +18 -> 24
    //   9: getstatic 28	com/dava/framework/JNIAssert:alreadyShowingNonModalDialog	Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +10 -> 24
    //   17: iload_3
    //   18: istore_2
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: invokestatic 40	com/dava/framework/JNIActivity:GetActivity	()Lcom/dava/framework/JNIActivity;
    //   27: astore 4
    //   29: iload_3
    //   30: istore_2
    //   31: aload 4
    //   33: ifnull -14 -> 19
    //   36: iload_3
    //   37: istore_2
    //   38: aload 4
    //   40: invokevirtual 46	android/app/Activity:isFinishing	()Z
    //   43: ifne -24 -> 19
    //   46: new 48	android/app/AlertDialog$Builder
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 51	android/app/AlertDialog$Builder:<init>	(Landroid/content/Context;)V
    //   55: astore 5
    //   57: aload 5
    //   59: aload_1
    //   60: invokevirtual 55	android/app/AlertDialog$Builder:setMessage	(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;
    //   63: pop
    //   64: iload_0
    //   65: ifeq +37 -> 102
    //   68: getstatic 58	com/dava/framework/JNIActivity:isPaused	Z
    //   71: ifne +31 -> 102
    //   74: getstatic 61	com/dava/framework/JNIActivity:isFocused	Z
    //   77: ifeq +25 -> 102
    //   80: iconst_1
    //   81: putstatic 24	com/dava/framework/JNIAssert:waitUserInputOnAssertDialog	Z
    //   84: aload 4
    //   86: aload 5
    //   88: invokestatic 65	com/dava/framework/JNIAssert:waitUserInput	(Landroid/app/Activity;Landroid/app/AlertDialog$Builder;)V
    //   91: iconst_0
    //   92: putstatic 24	com/dava/framework/JNIAssert:waitUserInputOnAssertDialog	Z
    //   95: getstatic 26	com/dava/framework/JNIAssert:breakExecution	Z
    //   98: istore_2
    //   99: goto -80 -> 19
    //   102: aload 4
    //   104: aload 5
    //   106: invokestatic 68	com/dava/framework/JNIAssert:showDialogAndContinue	(Landroid/app/Activity;Landroid/app/AlertDialog$Builder;)V
    //   109: iload_3
    //   110: istore_2
    //   111: goto -92 -> 19
    //   114: astore_1
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramBoolean	boolean
    //   0	120	1	paramString	String
    //   12	99	2	bool1	boolean
    //   1	109	3	bool2	boolean
    //   27	76	4	localJNIActivity	JNIActivity
    //   55	50	5	localBuilder	AlertDialog.Builder
    // Exception table:
    //   from	to	target	type
    //   9	13	114	finally
    //   24	29	114	finally
    //   38	64	114	finally
    //   68	99	114	finally
    //   102	109	114	finally
  }
  
  private static void showDialogAndContinue(Activity paramActivity, AlertDialog.Builder paramBuilder)
  {
    alreadyShowingNonModalDialog = true;
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        this.val$alertDialog.setCancelable(true);
        this.val$alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            JNIAssert.access$002(false);
          }
        });
        this.val$alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            JNIAssert.access$002(false);
          }
        });
        this.val$alertDialog.show();
      }
    });
  }
  
  private static void waitUserInput(Activity paramActivity, AlertDialog.Builder paramBuilder)
  {
    final Object localObject = new Object();
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        this.val$alertDialog.setCancelable(false);
        this.val$alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface arg1, int paramAnonymous2Int)
          {
            synchronized (JNIAssert.2.this.val$mutex)
            {
              JNIAssert.access$102(false);
              JNIAssert.2.this.val$mutex.notify();
              return;
            }
          }
        });
        this.val$alertDialog.setNegativeButton("Break", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface arg1, int paramAnonymous2Int)
          {
            synchronized (JNIAssert.2.this.val$mutex)
            {
              JNIAssert.access$102(true);
              JNIAssert.2.this.val$mutex.notify();
              return;
            }
          }
        });
        this.val$alertDialog.show();
      }
    });
    try
    {
      localObject.wait();
      return;
    }
    catch (InterruptedException paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIAssert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */