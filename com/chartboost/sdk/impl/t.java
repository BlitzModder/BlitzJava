package com.chartboost.sdk.impl;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class t
{
  public static String a = "Volley";
  public static boolean b = Log.isLoggable(a, 2);
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (b) {
      Log.v(a, d(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(a, d(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Log.d(a, d(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Log.e(a, d(paramString, paramVarArgs));
  }
  
  private static String d(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label154;
      }
      if (paramVarArgs[i].getClass().equals(t.class)) {
        break label147;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label147:
    label154:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label20;
    }
  }
  
  static class a
  {
    public static final boolean a = t.b;
    private final List<a> b = new ArrayList();
    private boolean c = false;
    
    private long a()
    {
      if (this.b.size() == 0) {
        return 0L;
      }
      long l = ((a)this.b.get(0)).c;
      return ((a)this.b.get(this.b.size() - 1)).c - l;
    }
    
    /* Error */
    public void a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield 31	com/chartboost/sdk/impl/t$a:c	Z
      //   7: aload_0
      //   8: invokespecial 48	com/chartboost/sdk/impl/t$a:a	()J
      //   11: lstore 4
      //   13: lload 4
      //   15: lconst_0
      //   16: lcmp
      //   17: ifgt +6 -> 23
      //   20: aload_0
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: getfield 29	com/chartboost/sdk/impl/t$a:b	Ljava/util/List;
      //   27: iconst_0
      //   28: invokeinterface 42 2 0
      //   33: checkcast 9	com/chartboost/sdk/impl/t$a$a
      //   36: getfield 45	com/chartboost/sdk/impl/t$a$a:c	J
      //   39: lstore_2
      //   40: ldc 50
      //   42: iconst_2
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: lload 4
      //   50: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   53: aastore
      //   54: dup
      //   55: iconst_1
      //   56: aload_1
      //   57: aastore
      //   58: invokestatic 59	com/chartboost/sdk/impl/t:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   61: aload_0
      //   62: getfield 29	com/chartboost/sdk/impl/t$a:b	Ljava/util/List;
      //   65: invokeinterface 63 1 0
      //   70: astore_1
      //   71: aload_1
      //   72: invokeinterface 69 1 0
      //   77: ifeq -57 -> 20
      //   80: aload_1
      //   81: invokeinterface 73 1 0
      //   86: checkcast 9	com/chartboost/sdk/impl/t$a$a
      //   89: astore 6
      //   91: aload 6
      //   93: getfield 45	com/chartboost/sdk/impl/t$a$a:c	J
      //   96: lstore 4
      //   98: ldc 75
      //   100: iconst_3
      //   101: anewarray 4	java/lang/Object
      //   104: dup
      //   105: iconst_0
      //   106: lload 4
      //   108: lload_2
      //   109: lsub
      //   110: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   113: aastore
      //   114: dup
      //   115: iconst_1
      //   116: aload 6
      //   118: getfield 77	com/chartboost/sdk/impl/t$a$a:b	J
      //   121: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   124: aastore
      //   125: dup
      //   126: iconst_2
      //   127: aload 6
      //   129: getfield 80	com/chartboost/sdk/impl/t$a$a:a	Ljava/lang/String;
      //   132: aastore
      //   133: invokestatic 59	com/chartboost/sdk/impl/t:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   136: lload 4
      //   138: lstore_2
      //   139: goto -68 -> 71
      //   142: astore_1
      //   143: aload_0
      //   144: monitorexit
      //   145: aload_1
      //   146: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	147	0	this	a
      //   0	147	1	paramString	String
      //   39	100	2	l1	long
      //   11	126	4	l2	long
      //   89	39	6	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	13	142	finally
      //   23	71	142	finally
      //   71	136	142	finally
    }
    
    public void a(String paramString, long paramLong)
    {
      try
      {
        if (this.c) {
          throw new IllegalStateException("Marker added to finished log");
        }
      }
      finally {}
      this.b.add(new a(paramString, paramLong, SystemClock.elapsedRealtime()));
    }
    
    protected void finalize()
      throws Throwable
    {
      if (!this.c)
      {
        a("Request on the loose");
        t.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    private static class a
    {
      public final String a;
      public final long b;
      public final long c;
      
      public a(String paramString, long paramLong1, long paramLong2)
      {
        this.a = paramString;
        this.b = paramLong1;
        this.c = paramLong2;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */