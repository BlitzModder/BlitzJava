package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class u
  implements f
{
  protected static final boolean a = t.b;
  private static int d = 3000;
  private static int e = 4096;
  protected final x b;
  protected final v c;
  
  public u(x paramx)
  {
    this(paramx, new v(e));
  }
  
  public u(x paramx, v paramv)
  {
    this.b = paramx;
    this.c = paramv;
  }
  
  protected static Map<String, String> a(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private void a(long paramLong, l<?> paraml, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((a) || (paramLong > d)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      t.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paraml, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paraml.u().b()) });
      return;
    }
  }
  
  private static void a(String paramString, l<?> paraml, s params)
    throws s
  {
    p localp = paraml.u();
    int i = paraml.t();
    try
    {
      localp.a(params);
      paraml.a(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (s params)
    {
      paraml.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw params;
    }
  }
  
  private void a(Map<String, String> paramMap, b.a parama)
  {
    if (parama == null) {}
    do
    {
      return;
      if (parama.b != null) {
        paramMap.put("If-None-Match", parama.b);
      }
    } while (parama.d <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(parama.d)));
  }
  
  private byte[] a(HttpEntity paramHttpEntity)
    throws IOException, q
  {
    ab localab = new ab(this.c, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new q();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a((byte[])localObject1);
      localab.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.c.a(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localab.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localab.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.c.a(arrayOfByte);
        localab.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          t.a("IOException error occured when calling consumingContent", new Object[0]);
        }
      }
      catch (OutOfMemoryError paramHttpEntity)
      {
        for (;;)
        {
          System.gc();
          t.a("Volley Out of Memory error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        t.a("IOException error occured when calling consumingContent", new Object[0]);
      }
    }
    catch (OutOfMemoryError paramHttpEntity)
    {
      for (;;)
      {
        System.gc();
        t.a("Volley Out of Memory error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public i a(l<?> paraml)
    throws s
  {
    // Byte code:
    //   0: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: invokestatic 234	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 7
    //   12: new 236	java/util/HashMap
    //   15: dup
    //   16: invokespecial 237	java/util/HashMap:<init>	()V
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 241	com/chartboost/sdk/impl/l:f	()Lcom/chartboost/sdk/impl/b$a;
    //   28: invokespecial 243	com/chartboost/sdk/impl/u:a	(Ljava/util/Map;Lcom/chartboost/sdk/impl/b$a;)V
    //   31: aload_0
    //   32: getfield 42	com/chartboost/sdk/impl/u:b	Lcom/chartboost/sdk/impl/x;
    //   35: aload_1
    //   36: aload 5
    //   38: invokeinterface 248 3 0
    //   43: astore 6
    //   45: aload 7
    //   47: astore 5
    //   49: aload 6
    //   51: invokeinterface 254 1 0
    //   56: astore 8
    //   58: aload 7
    //   60: astore 5
    //   62: aload 8
    //   64: invokeinterface 93 1 0
    //   69: istore_2
    //   70: aload 7
    //   72: astore 5
    //   74: aload 6
    //   76: invokeinterface 258 1 0
    //   81: invokestatic 260	com/chartboost/sdk/impl/u:a	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   84: astore 9
    //   86: iload_2
    //   87: sipush 304
    //   90: if_icmpne +89 -> 179
    //   93: aload 9
    //   95: astore 5
    //   97: aload_1
    //   98: invokevirtual 241	com/chartboost/sdk/impl/l:f	()Lcom/chartboost/sdk/impl/b$a;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnonnull +27 -> 132
    //   108: aload 9
    //   110: astore 5
    //   112: new 262	com/chartboost/sdk/impl/i
    //   115: dup
    //   116: sipush 304
    //   119: aconst_null
    //   120: aload 9
    //   122: iconst_1
    //   123: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   126: lload_3
    //   127: lsub
    //   128: invokespecial 265	com/chartboost/sdk/impl/i:<init>	(I[BLjava/util/Map;ZJ)V
    //   131: areturn
    //   132: aload 9
    //   134: astore 5
    //   136: aload 7
    //   138: getfield 269	com/chartboost/sdk/impl/b$a:g	Ljava/util/Map;
    //   141: aload 9
    //   143: invokeinterface 273 2 0
    //   148: aload 9
    //   150: astore 5
    //   152: new 262	com/chartboost/sdk/impl/i
    //   155: dup
    //   156: sipush 304
    //   159: aload 7
    //   161: getfield 276	com/chartboost/sdk/impl/b$a:a	[B
    //   164: aload 7
    //   166: getfield 269	com/chartboost/sdk/impl/b$a:g	Ljava/util/Map;
    //   169: iconst_1
    //   170: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   173: lload_3
    //   174: lsub
    //   175: invokespecial 265	com/chartboost/sdk/impl/i:<init>	(I[BLjava/util/Map;ZJ)V
    //   178: areturn
    //   179: aload 9
    //   181: astore 5
    //   183: aload 6
    //   185: invokeinterface 280 1 0
    //   190: astore 7
    //   192: aload 7
    //   194: ifnull +125 -> 319
    //   197: aload_0
    //   198: aload 6
    //   200: invokeinterface 280 1 0
    //   205: invokespecial 282	com/chartboost/sdk/impl/u:a	(Lorg/apache/http/HttpEntity;)[B
    //   208: astore 5
    //   210: aload_0
    //   211: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   214: lload_3
    //   215: lsub
    //   216: aload_1
    //   217: aload 5
    //   219: aload 8
    //   221: invokespecial 284	com/chartboost/sdk/impl/u:a	(JLcom/chartboost/sdk/impl/l;[BLorg/apache/http/StatusLine;)V
    //   224: iload_2
    //   225: sipush 200
    //   228: if_icmplt +10 -> 238
    //   231: iload_2
    //   232: sipush 299
    //   235: if_icmple +100 -> 335
    //   238: new 159	java/io/IOException
    //   241: dup
    //   242: invokespecial 285	java/io/IOException:<init>	()V
    //   245: athrow
    //   246: astore 5
    //   248: ldc_w 287
    //   251: aload_1
    //   252: new 289	com/chartboost/sdk/impl/r
    //   255: dup
    //   256: invokespecial 290	com/chartboost/sdk/impl/r:<init>	()V
    //   259: invokestatic 292	com/chartboost/sdk/impl/u:a	(Ljava/lang/String;Lcom/chartboost/sdk/impl/l;Lcom/chartboost/sdk/impl/s;)V
    //   262: goto -258 -> 4
    //   265: astore 7
    //   267: aload 9
    //   269: astore 5
    //   271: aload 7
    //   273: invokevirtual 295	java/lang/OutOfMemoryError:printStackTrace	()V
    //   276: aload 9
    //   278: astore 5
    //   280: iconst_0
    //   281: newarray <illegal type>
    //   283: astore 7
    //   285: aload 7
    //   287: astore 5
    //   289: goto -79 -> 210
    //   292: astore 7
    //   294: aload 9
    //   296: astore 5
    //   298: aload 7
    //   300: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   303: aload 9
    //   305: astore 5
    //   307: iconst_0
    //   308: newarray <illegal type>
    //   310: astore 7
    //   312: aload 7
    //   314: astore 5
    //   316: goto -106 -> 210
    //   319: aload 9
    //   321: astore 5
    //   323: iconst_0
    //   324: newarray <illegal type>
    //   326: astore 7
    //   328: aload 7
    //   330: astore 5
    //   332: goto -122 -> 210
    //   335: new 262	com/chartboost/sdk/impl/i
    //   338: dup
    //   339: iload_2
    //   340: aload 5
    //   342: aload 9
    //   344: iconst_0
    //   345: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   348: lload_3
    //   349: lsub
    //   350: invokespecial 265	com/chartboost/sdk/impl/i:<init>	(I[BLjava/util/Map;ZJ)V
    //   353: astore 7
    //   355: aload 7
    //   357: areturn
    //   358: astore 5
    //   360: ldc_w 298
    //   363: aload_1
    //   364: new 289	com/chartboost/sdk/impl/r
    //   367: dup
    //   368: invokespecial 290	com/chartboost/sdk/impl/r:<init>	()V
    //   371: invokestatic 292	com/chartboost/sdk/impl/u:a	(Ljava/lang/String;Lcom/chartboost/sdk/impl/l;Lcom/chartboost/sdk/impl/s;)V
    //   374: goto -370 -> 4
    //   377: astore 5
    //   379: new 300	java/lang/RuntimeException
    //   382: dup
    //   383: new 302	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 303	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 305
    //   393: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_1
    //   397: invokevirtual 311	com/chartboost/sdk/impl/l:d	()Ljava/lang/String;
    //   400: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: aload 5
    //   408: invokespecial 317	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: athrow
    //   412: astore 6
    //   414: aconst_null
    //   415: astore 8
    //   417: aload 7
    //   419: astore 5
    //   421: aload 9
    //   423: astore 7
    //   425: aload 7
    //   427: ifnull +98 -> 525
    //   430: aload 7
    //   432: invokeinterface 254 1 0
    //   437: invokeinterface 93 1 0
    //   442: istore_2
    //   443: ldc_w 319
    //   446: iconst_2
    //   447: anewarray 4	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: iload_2
    //   453: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aastore
    //   457: dup
    //   458: iconst_1
    //   459: aload_1
    //   460: invokevirtual 311	com/chartboost/sdk/impl/l:d	()Ljava/lang/String;
    //   463: aastore
    //   464: invokestatic 321	com/chartboost/sdk/impl/t:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: aload 8
    //   469: ifnull +76 -> 545
    //   472: new 262	com/chartboost/sdk/impl/i
    //   475: dup
    //   476: iload_2
    //   477: aload 8
    //   479: aload 5
    //   481: iconst_0
    //   482: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   485: lload_3
    //   486: lsub
    //   487: invokespecial 265	com/chartboost/sdk/impl/i:<init>	(I[BLjava/util/Map;ZJ)V
    //   490: astore 5
    //   492: iload_2
    //   493: sipush 401
    //   496: if_icmpeq +10 -> 506
    //   499: iload_2
    //   500: sipush 403
    //   503: if_icmpne +32 -> 535
    //   506: ldc_w 323
    //   509: aload_1
    //   510: new 325	com/chartboost/sdk/impl/a
    //   513: dup
    //   514: aload 5
    //   516: invokespecial 328	com/chartboost/sdk/impl/a:<init>	(Lcom/chartboost/sdk/impl/i;)V
    //   519: invokestatic 292	com/chartboost/sdk/impl/u:a	(Ljava/lang/String;Lcom/chartboost/sdk/impl/l;Lcom/chartboost/sdk/impl/s;)V
    //   522: goto -518 -> 4
    //   525: new 330	com/chartboost/sdk/impl/j
    //   528: dup
    //   529: aload 6
    //   531: invokespecial 333	com/chartboost/sdk/impl/j:<init>	(Ljava/lang/Throwable;)V
    //   534: athrow
    //   535: new 161	com/chartboost/sdk/impl/q
    //   538: dup
    //   539: aload 5
    //   541: invokespecial 334	com/chartboost/sdk/impl/q:<init>	(Lcom/chartboost/sdk/impl/i;)V
    //   544: athrow
    //   545: new 336	com/chartboost/sdk/impl/h
    //   548: dup
    //   549: aconst_null
    //   550: invokespecial 337	com/chartboost/sdk/impl/h:<init>	(Lcom/chartboost/sdk/impl/i;)V
    //   553: athrow
    //   554: astore 9
    //   556: aconst_null
    //   557: astore 8
    //   559: aload 6
    //   561: astore 7
    //   563: aload 9
    //   565: astore 6
    //   567: goto -142 -> 425
    //   570: astore 8
    //   572: aload 6
    //   574: astore 7
    //   576: aload 8
    //   578: astore 6
    //   580: aload 5
    //   582: astore 8
    //   584: aload 9
    //   586: astore 5
    //   588: goto -163 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	591	0	this	u
    //   0	591	1	paraml	l<?>
    //   69	435	2	i	int
    //   3	483	3	l	long
    //   19	199	5	localObject1	Object
    //   246	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   269	72	5	localObject2	Object
    //   358	1	5	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   377	30	5	localMalformedURLException	java.net.MalformedURLException
    //   419	168	5	localObject3	Object
    //   43	156	6	localHttpResponse	org.apache.http.HttpResponse
    //   412	148	6	localIOException1	IOException
    //   565	14	6	localObject4	Object
    //   10	183	7	localObject5	Object
    //   265	7	7	localOutOfMemoryError	OutOfMemoryError
    //   283	3	7	arrayOfByte	byte[]
    //   292	7	7	localIOException2	IOException
    //   310	265	7	localObject6	Object
    //   56	502	8	localStatusLine	StatusLine
    //   570	7	8	localIOException3	IOException
    //   582	1	8	localObject7	Object
    //   5	417	9	localMap	Map
    //   554	31	9	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   12	45	246	java/net/SocketTimeoutException
    //   49	58	246	java/net/SocketTimeoutException
    //   62	70	246	java/net/SocketTimeoutException
    //   74	86	246	java/net/SocketTimeoutException
    //   97	103	246	java/net/SocketTimeoutException
    //   112	132	246	java/net/SocketTimeoutException
    //   136	148	246	java/net/SocketTimeoutException
    //   152	179	246	java/net/SocketTimeoutException
    //   183	192	246	java/net/SocketTimeoutException
    //   197	210	246	java/net/SocketTimeoutException
    //   210	224	246	java/net/SocketTimeoutException
    //   238	246	246	java/net/SocketTimeoutException
    //   271	276	246	java/net/SocketTimeoutException
    //   280	285	246	java/net/SocketTimeoutException
    //   298	303	246	java/net/SocketTimeoutException
    //   307	312	246	java/net/SocketTimeoutException
    //   323	328	246	java/net/SocketTimeoutException
    //   335	355	246	java/net/SocketTimeoutException
    //   197	210	265	java/lang/OutOfMemoryError
    //   197	210	292	java/io/IOException
    //   12	45	358	org/apache/http/conn/ConnectTimeoutException
    //   49	58	358	org/apache/http/conn/ConnectTimeoutException
    //   62	70	358	org/apache/http/conn/ConnectTimeoutException
    //   74	86	358	org/apache/http/conn/ConnectTimeoutException
    //   97	103	358	org/apache/http/conn/ConnectTimeoutException
    //   112	132	358	org/apache/http/conn/ConnectTimeoutException
    //   136	148	358	org/apache/http/conn/ConnectTimeoutException
    //   152	179	358	org/apache/http/conn/ConnectTimeoutException
    //   183	192	358	org/apache/http/conn/ConnectTimeoutException
    //   197	210	358	org/apache/http/conn/ConnectTimeoutException
    //   210	224	358	org/apache/http/conn/ConnectTimeoutException
    //   238	246	358	org/apache/http/conn/ConnectTimeoutException
    //   271	276	358	org/apache/http/conn/ConnectTimeoutException
    //   280	285	358	org/apache/http/conn/ConnectTimeoutException
    //   298	303	358	org/apache/http/conn/ConnectTimeoutException
    //   307	312	358	org/apache/http/conn/ConnectTimeoutException
    //   323	328	358	org/apache/http/conn/ConnectTimeoutException
    //   335	355	358	org/apache/http/conn/ConnectTimeoutException
    //   12	45	377	java/net/MalformedURLException
    //   49	58	377	java/net/MalformedURLException
    //   62	70	377	java/net/MalformedURLException
    //   74	86	377	java/net/MalformedURLException
    //   97	103	377	java/net/MalformedURLException
    //   112	132	377	java/net/MalformedURLException
    //   136	148	377	java/net/MalformedURLException
    //   152	179	377	java/net/MalformedURLException
    //   183	192	377	java/net/MalformedURLException
    //   197	210	377	java/net/MalformedURLException
    //   210	224	377	java/net/MalformedURLException
    //   238	246	377	java/net/MalformedURLException
    //   271	276	377	java/net/MalformedURLException
    //   280	285	377	java/net/MalformedURLException
    //   298	303	377	java/net/MalformedURLException
    //   307	312	377	java/net/MalformedURLException
    //   323	328	377	java/net/MalformedURLException
    //   335	355	377	java/net/MalformedURLException
    //   12	45	412	java/io/IOException
    //   49	58	554	java/io/IOException
    //   62	70	554	java/io/IOException
    //   74	86	554	java/io/IOException
    //   97	103	554	java/io/IOException
    //   112	132	554	java/io/IOException
    //   136	148	554	java/io/IOException
    //   152	179	554	java/io/IOException
    //   183	192	554	java/io/IOException
    //   271	276	554	java/io/IOException
    //   280	285	554	java/io/IOException
    //   298	303	554	java/io/IOException
    //   307	312	554	java/io/IOException
    //   323	328	554	java/io/IOException
    //   210	224	570	java/io/IOException
    //   238	246	570	java/io/IOException
    //   335	355	570	java/io/IOException
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */