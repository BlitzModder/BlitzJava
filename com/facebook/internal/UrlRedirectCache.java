package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

class UrlRedirectCache
{
  private static final String REDIRECT_CONTENT_TAG = TAG + "_Redirect";
  static final String TAG = UrlRedirectCache.class.getSimpleName();
  private static volatile FileLruCache urlRedirectCache;
  
  static void cacheUriRedirect(Context paramContext, URI paramURI1, URI paramURI2)
  {
    if ((paramURI1 == null) || (paramURI2 == null)) {
      return;
    }
    Context localContext2 = null;
    Context localContext1 = null;
    try
    {
      paramContext = getCache(paramContext).openPutStream(paramURI1.toString(), REDIRECT_CONTENT_TAG);
      localContext1 = paramContext;
      localContext2 = paramContext;
      paramContext.write(paramURI2.toString().getBytes());
      return;
    }
    catch (IOException paramContext) {}finally
    {
      Utility.closeQuietly(localContext2);
    }
  }
  
  static void clearCache(Context paramContext)
  {
    try
    {
      getCache(paramContext).clearCache();
      return;
    }
    catch (IOException paramContext)
    {
      Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + paramContext.getMessage());
    }
  }
  
  static FileLruCache getCache(Context paramContext)
    throws IOException
  {
    try
    {
      if (urlRedirectCache == null) {
        urlRedirectCache = new FileLruCache(paramContext.getApplicationContext(), TAG, new FileLruCache.Limits());
      }
      paramContext = urlRedirectCache;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  static URI getRedirectedUri(Context paramContext, URI paramURI)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual 48	java/net/URI:toString	()Ljava/lang/String;
    //   10: astore_1
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokestatic 45	com/facebook/internal/UrlRedirectCache:getCache	(Landroid/content/Context;)Lcom/facebook/internal/FileLruCache;
    //   24: astore 7
    //   26: iconst_0
    //   27: istore_2
    //   28: aconst_null
    //   29: astore_0
    //   30: aload 7
    //   32: aload_1
    //   33: getstatic 35	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   36: invokevirtual 116	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +138 -> 181
    //   46: iconst_1
    //   47: istore_2
    //   48: new 118	java/io/InputStreamReader
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 121	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: astore_1
    //   58: aload_1
    //   59: astore 4
    //   61: aload_1
    //   62: astore 5
    //   64: aload_1
    //   65: astore 6
    //   67: sipush 128
    //   70: newarray <illegal type>
    //   72: astore_0
    //   73: aload_1
    //   74: astore 4
    //   76: aload_1
    //   77: astore 5
    //   79: aload_1
    //   80: astore 6
    //   82: new 21	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   89: astore 8
    //   91: aload_1
    //   92: astore 4
    //   94: aload_1
    //   95: astore 5
    //   97: aload_1
    //   98: astore 6
    //   100: aload_1
    //   101: aload_0
    //   102: iconst_0
    //   103: aload_0
    //   104: arraylength
    //   105: invokevirtual 125	java/io/InputStreamReader:read	([CII)I
    //   108: istore_3
    //   109: iload_3
    //   110: ifle +32 -> 142
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: astore 5
    //   119: aload_1
    //   120: astore 6
    //   122: aload 8
    //   124: aload_0
    //   125: iconst_0
    //   126: iload_3
    //   127: invokevirtual 128	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: goto -40 -> 91
    //   134: astore_0
    //   135: aload 4
    //   137: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: aload_1
    //   143: astore 4
    //   145: aload_1
    //   146: astore 5
    //   148: aload_1
    //   149: astore 6
    //   151: aload_1
    //   152: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   155: aload_1
    //   156: astore 4
    //   158: aload_1
    //   159: astore 5
    //   161: aload_1
    //   162: astore 6
    //   164: aload 8
    //   166: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore_0
    //   170: aload_0
    //   171: astore 4
    //   173: aload_1
    //   174: astore_0
    //   175: aload 4
    //   177: astore_1
    //   178: goto -148 -> 30
    //   181: iload_2
    //   182: ifeq +18 -> 200
    //   185: new 47	java/net/URI
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 131	java/net/URI:<init>	(Ljava/lang/String;)V
    //   193: astore_1
    //   194: aload_0
    //   195: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   198: aload_1
    //   199: areturn
    //   200: aload_0
    //   201: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: aload 5
    //   209: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   212: aconst_null
    //   213: areturn
    //   214: astore_0
    //   215: aload 6
    //   217: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: aload_0
    //   224: astore 6
    //   226: aload_1
    //   227: astore_0
    //   228: goto -13 -> 215
    //   231: astore_1
    //   232: aload_0
    //   233: astore 5
    //   235: goto -28 -> 207
    //   238: astore_1
    //   239: aload_0
    //   240: astore 4
    //   242: goto -107 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramURI	URI
    //   27	155	2	i	int
    //   108	19	3	j	int
    //   18	223	4	localObject1	Object
    //   12	222	5	localObject2	Object
    //   15	210	6	localObject3	Object
    //   24	7	7	localFileLruCache	FileLruCache
    //   89	76	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	26	134	java/net/URISyntaxException
    //   67	73	134	java/net/URISyntaxException
    //   82	91	134	java/net/URISyntaxException
    //   100	109	134	java/net/URISyntaxException
    //   122	131	134	java/net/URISyntaxException
    //   151	155	134	java/net/URISyntaxException
    //   164	170	134	java/net/URISyntaxException
    //   20	26	206	java/io/IOException
    //   67	73	206	java/io/IOException
    //   82	91	206	java/io/IOException
    //   100	109	206	java/io/IOException
    //   122	131	206	java/io/IOException
    //   151	155	206	java/io/IOException
    //   164	170	206	java/io/IOException
    //   20	26	214	finally
    //   67	73	214	finally
    //   82	91	214	finally
    //   100	109	214	finally
    //   122	131	214	finally
    //   151	155	214	finally
    //   164	170	214	finally
    //   30	41	222	finally
    //   48	58	222	finally
    //   185	194	222	finally
    //   30	41	231	java/io/IOException
    //   48	58	231	java/io/IOException
    //   185	194	231	java/io/IOException
    //   30	41	238	java/net/URISyntaxException
    //   48	58	238	java/net/URISyntaxException
    //   185	194	238	java/net/URISyntaxException
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/internal/UrlRedirectCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */