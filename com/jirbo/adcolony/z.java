package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

class z
{
  static String a = new String("mutex");
  static ArrayList<a> b = new ArrayList();
  static ArrayList<a> c = new ArrayList();
  static ArrayList<Runnable> d = new ArrayList();
  static ArrayList<Runnable> e = new ArrayList();
  static volatile boolean f;
  
  static void a()
  {
    
    synchronized (a)
    {
      d.clear();
      b();
      return;
    }
  }
  
  static void a(Runnable paramRunnable)
  {
    synchronized (a)
    {
      if (f)
      {
        d.add(paramRunnable);
        return;
      }
      if (0 == 0)
      {
        paramRunnable = new Thread(paramRunnable);
        try
        {
          paramRunnable.start();
          return;
        }
        catch (OutOfMemoryError paramRunnable)
        {
          l.d.b("Out of memory. Disabling AdColony.");
          AdColony.disable();
          return;
        }
      }
    }
  }
  
  static void b()
  {
    synchronized (a)
    {
      f = false;
      e.clear();
      e.addAll(d);
      d.clear();
      c.clear();
      ??? = e.iterator();
      if (((Iterator)???).hasNext()) {
        a((Runnable)((Iterator)???).next());
      }
    }
  }
  
  static void c()
  {
    synchronized (a)
    {
      f = true;
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        synchronized ((a)localIterator.next())
        {
          ???.notify();
        }
      }
    }
    synchronized (a)
    {
      b.clear();
      return;
    }
  }
  
  static class a
    extends Thread
  {
    Runnable a;
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	com/jirbo/adcolony/z$a:a	Ljava/lang/Runnable;
      //   4: ifnull +17 -> 21
      //   7: aload_0
      //   8: getfield 20	com/jirbo/adcolony/z$a:a	Ljava/lang/Runnable;
      //   11: invokeinterface 24 1 0
      //   16: aload_0
      //   17: aconst_null
      //   18: putfield 20	com/jirbo/adcolony/z$a:a	Ljava/lang/Runnable;
      //   21: getstatic 28	com/jirbo/adcolony/z:f	Z
      //   24: ifeq +39 -> 63
      //   27: return
      //   28: astore_1
      //   29: ldc 30
      //   31: invokestatic 36	com/jirbo/adcolony/a:e	(Ljava/lang/String;)V
      //   34: new 38	java/lang/StringBuilder
      //   37: dup
      //   38: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   41: aload_1
      //   42: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   45: ldc 45
      //   47: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   53: invokestatic 36	com/jirbo/adcolony/a:e	(Ljava/lang/String;)V
      //   56: aload_1
      //   57: invokevirtual 55	java/lang/RuntimeException:printStackTrace	()V
      //   60: goto -44 -> 16
      //   63: aload_0
      //   64: monitorenter
      //   65: getstatic 58	com/jirbo/adcolony/z:a	Ljava/lang/String;
      //   68: astore_1
      //   69: aload_1
      //   70: monitorenter
      //   71: getstatic 62	com/jirbo/adcolony/z:b	Ljava/util/ArrayList;
      //   74: aload_0
      //   75: invokevirtual 68	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   78: pop
      //   79: aload_1
      //   80: monitorexit
      //   81: aload_0
      //   82: invokevirtual 73	java/lang/Object:wait	()V
      //   85: aload_0
      //   86: monitorexit
      //   87: goto -87 -> 0
      //   90: astore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      //   95: astore_2
      //   96: aload_1
      //   97: monitorexit
      //   98: aload_2
      //   99: athrow
      //   100: astore_1
      //   101: goto -16 -> 85
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	a
      //   28	29	1	localRuntimeException	RuntimeException
      //   90	7	1	localObject1	Object
      //   100	1	1	localInterruptedException	InterruptedException
      //   95	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   7	16	28	java/lang/RuntimeException
      //   65	71	90	finally
      //   81	85	90	finally
      //   85	87	90	finally
      //   91	93	90	finally
      //   98	100	90	finally
      //   71	81	95	finally
      //   96	98	95	finally
      //   81	85	100	java/lang/InterruptedException
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */