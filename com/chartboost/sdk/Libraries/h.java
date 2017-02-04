package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.chartboost.sdk.c;
import com.chartboost.sdk.impl.bt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class h
{
  private static File a;
  private static File b;
  private static File c;
  private static File d;
  private static File e;
  private static File f;
  private static File g;
  private static File h;
  private static File i;
  private static File j;
  private static File k;
  private static File l;
  private static File m;
  private static File n;
  private static File o;
  private static File p;
  private static File q;
  private static File r;
  private static File s;
  private static Context t;
  private static File u;
  private static File v;
  private static File w;
  private static String[] x;
  private boolean y = false;
  
  public h(boolean paramBoolean)
  {
    t = c.y();
    if (t == null)
    {
      CBLogging.b("CBFileCache", "RunTime error: Cannot find context object");
      return;
    }
    this.y = paramBoolean;
    a(paramBoolean);
  }
  
  public static File a()
  {
    if (e()) {
      return r;
    }
    return s;
  }
  
  private File a(boolean paramBoolean)
  {
    if (m() != null) {
      return a;
    }
    File localFile = new File(t.getCacheDir(), ".chartboost");
    s = localFile;
    c = localFile;
    localFile = new File(Environment.getExternalStorageDirectory(), ".chartboost");
    r = localFile;
    b = localFile;
    if (!c.exists()) {
      c.mkdirs();
    }
    if (!b.exists()) {
      b.mkdirs();
    }
    if (c.a()) {}
    for (a = c;; a = b)
    {
      if (!paramBoolean) {
        a = c;
      }
      k = new File(c, a.a.toString());
      if (!k.exists()) {
        k.mkdir();
      }
      j = new File(b, a.a.toString());
      if (!j.exists()) {
        j.mkdir();
      }
      e = new File(c, a.b.toString());
      if (!e.exists()) {
        e.mkdir();
      }
      d = new File(b, a.b.toString());
      if (!d.exists()) {
        d.mkdir();
      }
      g = new File(c, a.d.toString());
      if (!g.exists()) {
        g.mkdir();
      }
      f = new File(b, a.d.toString());
      if (!f.exists()) {
        f.mkdir();
      }
      i = new File(c, a.e.toString());
      if (!i.exists()) {
        i.mkdir();
      }
      h = new File(b, a.e.toString());
      if (!h.exists()) {
        h.mkdir();
      }
      m = new File(c, a.f.toString());
      if (!m.exists()) {
        m.mkdir();
      }
      l = new File(b, a.f.toString());
      if (!l.exists()) {
        l.mkdir();
      }
      q = new File(c, a.c.toString());
      if (!q.exists()) {
        q.mkdir();
      }
      p = new File(b, a.c.toString());
      if (!p.exists()) {
        p.mkdir();
      }
      n = new File(b, ".adId");
      o = new File(c, ".adId");
      u = new File(s, a.j.toString());
      w = new File(s, a.i.toString());
      v = new File(s, a.h.toString());
      return a;
    }
  }
  
  public static String a(String paramString)
  {
    if (a == null) {
      return null;
    }
    if (e()) {}
    for (File localFile = d;; localFile = e)
    {
      paramString = new File(localFile, paramString);
      if (!paramString.exists()) {
        break;
      }
      return paramString.getPath();
    }
    return null;
  }
  
  public static void a(ArrayList<String> paramArrayList, File paramFile, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((paramFile == null) || (paramArrayList == null)) {}
    for (;;)
    {
      return;
      localObject1 = paramArrayList;
      if (paramBoolean) {
        try
        {
          ArrayList localArrayList = d(paramFile);
          localObject1 = paramArrayList;
          if (localArrayList.size() > 0)
          {
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext())
            {
              localObject1 = (String)paramArrayList.next();
              if (!localArrayList.contains(localObject1)) {
                localArrayList.add(localObject1);
              }
            }
            localObject1 = localArrayList;
          }
        }
        finally {}
      }
      try
      {
        paramArrayList = new FileOutputStream(paramFile);
      }
      catch (IOException paramArrayList)
      {
        for (;;)
        {
          label133:
          paramFile = null;
          localObject1 = localIOException1;
        }
      }
      try
      {
        paramFile = new ObjectOutputStream(paramArrayList);
        try
        {
          paramFile.writeObject(localObject1);
          paramFile.close();
          paramArrayList.close();
        }
        catch (IOException localIOException1)
        {
          localObject1 = paramArrayList;
          paramArrayList = localIOException1;
        }
      }
      catch (IOException localIOException2)
      {
        paramFile = null;
        localObject1 = paramArrayList;
        paramArrayList = localIOException2;
        break label133;
      }
      if (paramFile != null) {}
      try
      {
        paramFile.close();
        if (localObject1 != null) {
          ((FileOutputStream)localObject1).close();
        }
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          paramFile.printStackTrace();
        }
      }
      paramArrayList.printStackTrace();
    }
  }
  
  public static boolean a(File paramFile, int paramInt)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    Calendar localCalendar;
    do
    {
      return false;
      localCalendar = Calendar.getInstance();
      localCalendar.add(6, -paramInt);
      paramFile = new Date(paramFile.lastModified());
      CBLogging.a("CBFileCache", "### File last modified" + paramFile.toString());
    } while (!paramFile.before(localCalendar.getTime()));
    CBLogging.a("CBFileCache", "### File is expired and is past " + paramInt + " days");
    return true;
  }
  
  public static HashMap<String, File> b()
  {
    label264:
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        File localFile = a;
        if (localFile == null) {
          return localHashMap;
        }
        int i1;
        if (e())
        {
          localFile = r;
          String[] arrayOfString1 = localFile.list();
          if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
            continue;
          }
          int i3 = arrayOfString1.length;
          i1 = 0;
          if (i1 >= i3) {
            continue;
          }
          localObject2 = arrayOfString1[i1];
          if ((((String)localObject2).equalsIgnoreCase(a.a.toString())) || (((String)localObject2).equalsIgnoreCase(a.j.toString())) || (((String)localObject2).equalsIgnoreCase(a.i.toString())) || (((String)localObject2).equalsIgnoreCase(a.h.toString())) || (((String)localObject2).equalsIgnoreCase(a.g.toString()))) {
            break label264;
          }
          if (((String)localObject2).contains(".")) {
            break label264;
          }
        }
        else
        {
          localFile = s;
          continue;
        }
        Object localObject2 = new File(localFile, (String)localObject2);
        if (localObject2 != null)
        {
          String[] arrayOfString2 = ((File)localObject2).list();
          if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
          {
            int i4 = arrayOfString2.length;
            int i2 = 0;
            if (i2 < i4)
            {
              String str = arrayOfString2[i2];
              if (!str.equals(".nomedia")) {
                localHashMap.put(str, new File((File)localObject2, str));
              }
              i2 += 1;
              continue;
            }
          }
        }
        i1 += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public static String[] c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 74	com/chartboost/sdk/Libraries/h:a	Ljava/io/File;
    //   8: astore_0
    //   9: aload_0
    //   10: ifnonnull +10 -> 20
    //   13: aload_1
    //   14: astore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload_0
    //   19: areturn
    //   20: invokestatic 66	com/chartboost/sdk/Libraries/h:e	()Z
    //   23: ifeq +42 -> 65
    //   26: getstatic 123	com/chartboost/sdk/Libraries/h:d	Ljava/io/File;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: invokevirtual 281	java/io/File:list	()[Ljava/lang/String;
    //   38: putstatic 304	com/chartboost/sdk/Libraries/h:x	[Ljava/lang/String;
    //   41: aload_1
    //   42: astore_0
    //   43: getstatic 304	com/chartboost/sdk/Libraries/h:x	[Ljava/lang/String;
    //   46: ifnull -31 -> 15
    //   49: aload_1
    //   50: astore_0
    //   51: getstatic 304	com/chartboost/sdk/Libraries/h:x	[Ljava/lang/String;
    //   54: arraylength
    //   55: ifeq -40 -> 15
    //   58: getstatic 304	com/chartboost/sdk/Libraries/h:x	[Ljava/lang/String;
    //   61: astore_0
    //   62: goto -47 -> 15
    //   65: getstatic 121	com/chartboost/sdk/Libraries/h:e	Ljava/io/File;
    //   68: astore_0
    //   69: goto -39 -> 30
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	61	0	localObject1	Object
    //   72	5	0	localObject2	Object
    //   1	49	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	72	finally
    //   20	30	72	finally
    //   34	41	72	finally
    //   43	49	72	finally
    //   51	62	72	finally
    //   65	69	72	finally
  }
  
  /* Error */
  public static ArrayList<String> d(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: new 177	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 307	java/util/ArrayList:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: ifnull +12 -> 27
    //   18: aload_0
    //   19: invokevirtual 98	java/io/File:exists	()Z
    //   22: istore_1
    //   23: iload_1
    //   24: ifne +10 -> 34
    //   27: aload_2
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: new 309	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore_3
    //   43: new 312	java/io/ObjectInputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 315	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 318	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   58: checkcast 177	java/util/ArrayList
    //   61: astore_0
    //   62: aload 4
    //   64: invokevirtual 319	java/io/ObjectInputStream:close	()V
    //   67: aload_3
    //   68: invokevirtual 320	java/io/FileInputStream:close	()V
    //   71: goto -42 -> 29
    //   74: astore_2
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 319	java/io/ObjectInputStream:close	()V
    //   85: aload_3
    //   86: ifnull +7 -> 93
    //   89: aload_3
    //   90: invokevirtual 320	java/io/FileInputStream:close	()V
    //   93: aload_2
    //   94: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   97: goto -68 -> 29
    //   100: astore_0
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: athrow
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   111: goto -18 -> 93
    //   114: aload_2
    //   115: invokevirtual 321	java/lang/ClassNotFoundException:printStackTrace	()V
    //   118: goto -89 -> 29
    //   121: astore_2
    //   122: goto -8 -> 114
    //   125: astore_3
    //   126: aconst_null
    //   127: astore 4
    //   129: aload_2
    //   130: astore_0
    //   131: aload_3
    //   132: astore_2
    //   133: aload 5
    //   135: astore_3
    //   136: goto -61 -> 75
    //   139: astore 5
    //   141: aconst_null
    //   142: astore 4
    //   144: aload_2
    //   145: astore_0
    //   146: aload 5
    //   148: astore_2
    //   149: goto -74 -> 75
    //   152: astore 5
    //   154: aload_2
    //   155: astore_0
    //   156: aload 5
    //   158: astore_2
    //   159: goto -84 -> 75
    //   162: astore_3
    //   163: aload_2
    //   164: astore_0
    //   165: aload_3
    //   166: astore_2
    //   167: goto -53 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramFile	File
    //   22	2	1	bool	boolean
    //   13	15	2	localArrayList	ArrayList
    //   74	41	2	localIOException1	IOException
    //   121	9	2	localClassNotFoundException1	ClassNotFoundException
    //   132	35	2	localObject1	Object
    //   42	48	3	localFileInputStream	FileInputStream
    //   106	2	3	localIOException2	IOException
    //   125	7	3	localIOException3	IOException
    //   135	1	3	localObject2	Object
    //   162	4	3	localClassNotFoundException2	ClassNotFoundException
    //   51	92	4	localObjectInputStream	java.io.ObjectInputStream
    //   1	133	5	localObject3	Object
    //   139	8	5	localIOException4	IOException
    //   152	5	5	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   62	71	74	java/io/IOException
    //   6	14	100	finally
    //   18	23	100	finally
    //   34	43	100	finally
    //   43	53	100	finally
    //   53	62	100	finally
    //   62	71	100	finally
    //   80	85	100	finally
    //   89	93	100	finally
    //   93	97	100	finally
    //   107	111	100	finally
    //   114	118	100	finally
    //   80	85	106	java/io/IOException
    //   89	93	106	java/io/IOException
    //   62	71	121	java/lang/ClassNotFoundException
    //   34	43	125	java/io/IOException
    //   43	53	139	java/io/IOException
    //   53	62	152	java/io/IOException
    //   34	43	162	java/lang/ClassNotFoundException
    //   43	53	162	java/lang/ClassNotFoundException
    //   53	62	162	java/lang/ClassNotFoundException
  }
  
  public static boolean e()
  {
    if ((Environment.getExternalStorageState().equals("mounted")) && (!c.a())) {
      return true;
    }
    CBLogging.e("CBFileCache", "External Storage unavailable");
    return false;
  }
  
  public static long f(File paramFile)
  {
    long l1 = 0L;
    long l2;
    if (paramFile != null) {
      l2 = l1;
    }
    try
    {
      if (paramFile.isDirectory())
      {
        l2 = l1;
        paramFile = paramFile.listFiles();
        l2 = l1;
        if (paramFile != null)
        {
          l2 = l1;
          int i2 = paramFile.length;
          int i1 = 0;
          for (;;)
          {
            l2 = l1;
            if (i1 >= i2) {
              break;
            }
            l2 = l1;
            long l3 = f(paramFile[i1]);
            i1 += 1;
            l1 = l3 + l1;
          }
        }
      }
      else
      {
        l2 = l1;
        l1 = paramFile.length();
        l2 = l1;
      }
      return l2;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return l2;
  }
  
  public static e.a n()
  {
    e.a locala1 = e.a.a();
    locala1.a(".chartboost-external-folder-size", Long.valueOf(f(r)));
    locala1.a(".chartboost-internal-folder-size", Long.valueOf(f(s)));
    if (e()) {}
    for (File localFile1 = r;; localFile1 = s)
    {
      String[] arrayOfString1 = localFile1.list();
      if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
        break;
      }
      int i2 = arrayOfString1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        File localFile2 = new File(localFile1, arrayOfString1[i1]);
        if (localFile2 != null)
        {
          e.a locala2 = e.a.a();
          locala2.a(localFile2.getName() + "-size", Long.valueOf(f(localFile2)));
          String[] arrayOfString2 = localFile2.list();
          if (arrayOfString2 != null) {
            locala2.a("count", Integer.valueOf(arrayOfString2.length));
          }
          locala1.a(localFile2.getName(), locala2);
        }
        i1 += 1;
      }
    }
    return locala1;
  }
  
  /* Error */
  public e.a a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 72	com/chartboost/sdk/Libraries/h:m	()Ljava/io/File;
    //   6: ifnonnull +11 -> 17
    //   9: getstatic 381	com/chartboost/sdk/Libraries/e$a:a	Lcom/chartboost/sdk/Libraries/e$a;
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: new 196	java/lang/String
    //   20: dup
    //   21: aload_1
    //   22: invokestatic 386	com/chartboost/sdk/impl/bt:b	(Ljava/io/File;)[B
    //   25: invokespecial 389	java/lang/String:<init>	([B)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 392	com/chartboost/sdk/Libraries/e$a:k	(Ljava/lang/String;)Lcom/chartboost/sdk/Libraries/e$a;
    //   33: astore_1
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: ldc 51
    //   40: ldc_w 394
    //   43: aload_1
    //   44: invokestatic 397	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: aconst_null
    //   48: astore_1
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	h
    //   0	57	1	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   17	29	37	java/lang/Exception
    //   2	13	52	finally
    //   17	29	52	finally
    //   29	34	52	finally
    //   38	47	52	finally
  }
  
  /* Error */
  public e.a a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 72	com/chartboost/sdk/Libraries/h:m	()Ljava/io/File;
    //   6: ifnull +7 -> 13
    //   9: aload_2
    //   10: ifnonnull +11 -> 21
    //   13: getstatic 381	com/chartboost/sdk/Libraries/e$a:a	Lcom/chartboost/sdk/Libraries/e$a;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: new 76	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 98	java/io/File:exists	()Z
    //   35: ifne +10 -> 45
    //   38: getstatic 381	com/chartboost/sdk/Libraries/e$a:a	Lcom/chartboost/sdk/Libraries/e$a;
    //   41: astore_1
    //   42: goto -25 -> 17
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 400	com/chartboost/sdk/Libraries/h:a	(Ljava/io/File;)Lcom/chartboost/sdk/Libraries/e$a;
    //   50: astore_1
    //   51: goto -34 -> 17
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	h
    //   0	59	1	paramFile	File
    //   0	59	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	9	54	finally
    //   13	17	54	finally
    //   21	42	54	finally
    //   45	51	54	finally
  }
  
  public File a(File paramFile1, File paramFile2, e.a parama)
  {
    if (paramFile1 == null)
    {
      paramFile1 = null;
      return paramFile1;
    }
    if (paramFile2 == null) {}
    for (;;)
    {
      try
      {
        paramFile1 = new File(paramFile1.getPath(), Long.toString(System.nanoTime()));
        try
        {
          bt.a(paramFile1, parama.toString().getBytes());
        }
        catch (IOException paramFile2)
        {
          CBLogging.b("CBFileCache", "IOException attempting to write cache to disk", paramFile2);
        }
        break;
      }
      finally {}
      paramFile1 = paramFile2;
    }
  }
  
  public File a(File paramFile, String paramString, e.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramFile != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = new File(paramFile.getPath(), paramString);
      }
      localObject1 = a(paramFile, (File)localObject1, parama);
      return (File)localObject1;
    }
    finally {}
  }
  
  public void a(File paramFile1, File paramFile2)
    throws IOException
  {
    int i1 = 0;
    if (paramFile1.isDirectory())
    {
      if ((!paramFile2.exists()) && (!paramFile2.mkdirs())) {
        throw new IOException("Cannot create dir " + paramFile2.getAbsolutePath());
      }
      localObject = paramFile1.list();
      while (i1 < localObject.length)
      {
        a(new File(paramFile1, localObject[i1]), new File(paramFile2, localObject[i1]));
        i1 += 1;
      }
    }
    Object localObject = paramFile2.getParentFile();
    if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      throw new IOException("Cannot create dir " + ((File)localObject).getAbsolutePath());
    }
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    localObject = new byte['Ѐ'];
    for (;;)
    {
      i1 = paramFile1.read((byte[])localObject);
      if (i1 <= 0) {
        break;
      }
      paramFile2.write((byte[])localObject, 0, i1);
    }
    paramFile1.close();
    paramFile2.close();
  }
  
  public void a(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    if ((paramFile1 == null) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      File localFile = paramFile2;
      if (paramFile2 == null) {}
      try
      {
        localFile = new File(paramFile1.getPath(), Long.toString(System.nanoTime()));
        try
        {
          bt.a(localFile, paramArrayOfByte);
        }
        catch (IOException paramFile1)
        {
          CBLogging.b("CBFileCache", "IOException attempting to write cache to disk", paramFile1);
        }
      }
      finally {}
    }
  }
  
  public void a(File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    File localFile;
    if (paramFile != null) {
      localFile = null;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localFile = new File(paramFile.getPath(), paramString);
      }
      a(paramFile, localFile, paramArrayOfByte);
      return;
    }
    finally {}
  }
  
  public void b(File paramFile, String paramString)
  {
    if (paramFile != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        e(c(paramFile, paramString));
      }
      return;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((i() == null) || (paramString == null)) {
      return false;
    }
    return new File(i(), paramString).exists();
  }
  
  public byte[] b(File paramFile)
  {
    Object localObject = null;
    if (paramFile == null) {
      paramFile = (File)localObject;
    }
    for (;;)
    {
      return paramFile;
      try
      {
        paramFile = bt.b(paramFile);
      }
      catch (Exception paramFile)
      {
        CBLogging.b("CBFileCache", "Error loading cache from disk", paramFile);
        paramFile = (File)localObject;
      }
      finally {}
    }
  }
  
  public File c(File paramFile, String paramString)
  {
    if (paramFile == null) {
      return null;
    }
    return new File(paramFile.getPath(), paramString);
  }
  
  public boolean c(String paramString)
  {
    if ((f() == null) || (paramString == null)) {
      return false;
    }
    return new File(f(), paramString).exists();
  }
  
  public String[] c(File paramFile)
  {
    if (paramFile == null) {
      paramFile = null;
    }
    for (;;)
    {
      return paramFile;
      try
      {
        paramFile = paramFile.list();
      }
      finally {}
    }
  }
  
  public File d(String paramString)
  {
    if ((this.y) && (e())) {
      return new File(r, paramString);
    }
    return new File(s, paramString);
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 74	com/chartboost/sdk/Libraries/h:a	Ljava/io/File;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: getstatic 95	com/chartboost/sdk/Libraries/h:b	Ljava/io/File;
    //   20: ifnull +42 -> 62
    //   23: getstatic 95	com/chartboost/sdk/Libraries/h:b	Ljava/io/File;
    //   26: invokevirtual 341	java/io/File:listFiles	()[Ljava/io/File;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +29 -> 62
    //   36: aload 4
    //   38: arraylength
    //   39: istore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: iload_3
    //   44: if_icmpge +18 -> 62
    //   47: aload 4
    //   49: iload_1
    //   50: aaload
    //   51: invokevirtual 477	java/io/File:delete	()Z
    //   54: pop
    //   55: iload_1
    //   56: iconst_1
    //   57: iadd
    //   58: istore_1
    //   59: goto -17 -> 42
    //   62: getstatic 88	com/chartboost/sdk/Libraries/h:c	Ljava/io/File;
    //   65: ifnull -51 -> 14
    //   68: getstatic 88	com/chartboost/sdk/Libraries/h:c	Ljava/io/File;
    //   71: invokevirtual 341	java/io/File:listFiles	()[Ljava/io/File;
    //   74: astore 4
    //   76: aload 4
    //   78: ifnull -64 -> 14
    //   81: aload 4
    //   83: arraylength
    //   84: istore_3
    //   85: iload_2
    //   86: istore_1
    //   87: iload_1
    //   88: iload_3
    //   89: if_icmpge -75 -> 14
    //   92: aload 4
    //   94: iload_1
    //   95: aaload
    //   96: invokevirtual 477	java/io/File:delete	()Z
    //   99: pop
    //   100: iload_1
    //   101: iconst_1
    //   102: iadd
    //   103: istore_1
    //   104: goto -17 -> 87
    //   107: astore 4
    //   109: ldc 51
    //   111: ldc_w 479
    //   114: invokestatic 58	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   117: goto -103 -> 14
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	h
    //   41	63	1	i1	int
    //   1	85	2	i2	int
    //   39	51	3	i3	int
    //   7	86	4	localObject1	Object
    //   107	1	4	localException	Exception
    //   120	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	31	107	java/lang/Exception
    //   36	40	107	java/lang/Exception
    //   47	55	107	java/lang/Exception
    //   62	76	107	java/lang/Exception
    //   81	85	107	java/lang/Exception
    //   92	100	107	java/lang/Exception
    //   4	9	120	finally
    //   17	31	120	finally
    //   36	40	120	finally
    //   47	55	120	finally
    //   62	76	120	finally
    //   81	85	120	finally
    //   92	100	120	finally
    //   109	117	120	finally
  }
  
  public void e(File paramFile)
  {
    if (paramFile != null) {}
    try
    {
      if (paramFile.exists()) {
        paramFile.delete();
      }
      return;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public boolean e(String paramString)
  {
    if ((this.y) && (e())) {}
    for (File localFile = r; localFile != null; localFile = s)
    {
      paramString = new File(localFile, paramString);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return true;
    }
    return false;
  }
  
  public File f()
  {
    if ((this.y) && (e())) {
      return d;
    }
    return e;
  }
  
  public File g()
  {
    return u;
  }
  
  public File h()
  {
    return v;
  }
  
  public File i()
  {
    if ((this.y) && (e())) {
      return p;
    }
    return q;
  }
  
  public File j()
  {
    if ((this.y) && (e())) {
      return j;
    }
    return k;
  }
  
  public File k()
  {
    return o;
  }
  
  public File l()
  {
    return n;
  }
  
  public File m()
  {
    if (a == null) {
      return null;
    }
    if ((this.y) && (e())) {}
    for (a = b;; a = c) {
      return a;
    }
  }
  
  public void o()
  {
    Object localObject = new File(c, "asset_log");
    File localFile = new File(b, "asset_log");
    if ((this.y) && (e())) {
      localObject = localFile;
    }
    for (;;)
    {
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = ((File)localObject).listFiles();
        if ((localObject != null) && (localObject.length > 0))
        {
          int i2 = localObject.length;
          int i1 = 0;
          label75:
          if (i1 < i2)
          {
            localFile = localObject[i1];
            try
            {
              CBLogging.a("CBFileCache", "Copying the template meta data files from asset_log folder to template folder");
              a(localFile, j());
              i1 += 1;
              break label75;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public static enum a
  {
    private final String k;
    
    private a(String paramString)
    {
      this.k = paramString;
    }
    
    public String toString()
    {
      return this.k;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */