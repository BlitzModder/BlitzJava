package com.facebook;

import android.content.Context;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Response
{
  private static final String BODY_KEY = "body";
  private static final String CODE_KEY = "code";
  private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
  public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
  private static final String RESPONSE_CACHE_TAG = "ResponseCache";
  private static final String RESPONSE_LOG_TAG = "Response";
  public static final String SUCCESS_KEY = "success";
  private static FileLruCache responseCache;
  private final HttpURLConnection connection;
  private final FacebookRequestError error;
  private final GraphObject graphObject;
  private final GraphObjectList<GraphObject> graphObjectList;
  private final boolean isFromCache;
  private final String rawResponse;
  private final Request request;
  
  static
  {
    if (!Response.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError)
  {
    this(paramRequest, paramHttpURLConnection, null, null, null, false, paramFacebookRequestError);
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean, FacebookRequestError paramFacebookRequestError)
  {
    this.request = paramRequest;
    this.connection = paramHttpURLConnection;
    this.rawResponse = paramString;
    this.graphObject = paramGraphObject;
    this.graphObjectList = paramGraphObjectList;
    this.isFromCache = paramBoolean;
    this.error = paramFacebookRequestError;
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObject paramGraphObject, boolean paramBoolean)
  {
    this(paramRequest, paramHttpURLConnection, paramString, paramGraphObject, null, paramBoolean, null);
  }
  
  Response(Request paramRequest, HttpURLConnection paramHttpURLConnection, String paramString, GraphObjectList<GraphObject> paramGraphObjectList, boolean paramBoolean)
  {
    this(paramRequest, paramHttpURLConnection, paramString, null, paramGraphObjectList, paramBoolean, null);
  }
  
  static List<Response> constructErrorResponses(List<Request> paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new Response((Request)paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static Response createResponseFromObject(Request paramRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, boolean paramBoolean, Object paramObject2)
    throws JSONException
  {
    Object localObject = paramObject1;
    if ((paramObject1 instanceof JSONObject))
    {
      paramObject1 = (JSONObject)paramObject1;
      paramObject2 = FacebookRequestError.checkResponseAndCreateError((JSONObject)paramObject1, paramObject2, paramHttpURLConnection);
      if (paramObject2 != null)
      {
        if (((FacebookRequestError)paramObject2).getErrorCode() == 190)
        {
          paramObject1 = paramRequest.getSession();
          if (paramObject1 != null) {
            ((Session)paramObject1).closeAndClearTokenInformation();
          }
        }
        return new Response(paramRequest, paramHttpURLConnection, (FacebookRequestError)paramObject2);
      }
      paramObject1 = Utility.getStringPropertyAsJSON((JSONObject)paramObject1, "body", "FACEBOOK_NON_JSON_RESULT");
      if ((paramObject1 instanceof JSONObject))
      {
        paramObject2 = GraphObject.Factory.create((JSONObject)paramObject1);
        return new Response(paramRequest, paramHttpURLConnection, paramObject1.toString(), (GraphObject)paramObject2, paramBoolean);
      }
      if ((paramObject1 instanceof JSONArray))
      {
        paramObject2 = GraphObject.Factory.createList((JSONArray)paramObject1, GraphObject.class);
        return new Response(paramRequest, paramHttpURLConnection, paramObject1.toString(), (GraphObjectList)paramObject2, paramBoolean);
      }
      localObject = JSONObject.NULL;
    }
    if (localObject == JSONObject.NULL) {
      return new Response(paramRequest, paramHttpURLConnection, localObject.toString(), (GraphObject)null, paramBoolean);
    }
    throw new FacebookException("Got unexpected object type in response, class: " + localObject.getClass().getSimpleName());
  }
  
  private static List<Response> createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List<Request> paramList, Object paramObject, boolean paramBoolean)
    throws FacebookException, JSONException
  {
    assert ((paramHttpURLConnection != null) || (paramBoolean));
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    Object localObject1 = paramObject;
    Request localRequest;
    if (j == 1) {
      localRequest = (Request)paramList.get(0);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("body", paramObject);
        if (paramHttpURLConnection == null) {
          continue;
        }
        i = paramHttpURLConnection.getResponseCode();
        localJSONObject.put("code", i);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException1)));
        Object localObject2 = paramObject;
        continue;
      }
      catch (IOException localIOException)
      {
        localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localIOException)));
        Object localObject3 = paramObject;
        continue;
        localObject3 = (JSONArray)localObject3;
        int i = 0;
        if (i >= ((JSONArray)localObject3).length()) {
          break label359;
        }
        localRequest = (Request)paramList.get(i);
        try
        {
          localArrayList.add(createResponseFromObject(localRequest, paramHttpURLConnection, ((JSONArray)localObject3).get(i), paramBoolean, paramObject));
          i += 1;
        }
        catch (JSONException localJSONException2)
        {
          localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localJSONException2)));
          continue;
        }
        catch (FacebookException localFacebookException)
        {
          localArrayList.add(new Response(localRequest, paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, localFacebookException)));
          continue;
        }
      }
      if (((localObject1 instanceof JSONArray)) && (((JSONArray)localObject1).length() == j)) {
        continue;
      }
      throw new FacebookException("Unexpected number of results");
      i = 200;
    }
    label359:
    return localArrayList;
  }
  
  static List<Response> createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
    throws FacebookException, JSONException, IOException
  {
    paramInputStream = Utility.readStreamToString(paramInputStream);
    Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] { Integer.valueOf(paramInputStream.length()), paramInputStream });
    return createResponsesFromString(paramInputStream, paramHttpURLConnection, paramRequestBatch, paramBoolean);
  }
  
  static List<Response> createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch, boolean paramBoolean)
    throws FacebookException, JSONException, IOException
  {
    paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramRequestBatch, new JSONTokener(paramString).nextValue(), paramBoolean);
    Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] { paramRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection });
    return paramHttpURLConnection;
  }
  
  /* Error */
  static List<Response> fromHttpConnection(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 10
    //   21: aload 4
    //   23: astore_2
    //   24: aload_1
    //   25: instanceof 290
    //   28: ifeq +166 -> 194
    //   31: aload_1
    //   32: checkcast 290	com/facebook/internal/CacheableRequestBatch
    //   35: astore 12
    //   37: invokestatic 294	com/facebook/Response:getResponseCache	()Lcom/facebook/internal/FileLruCache;
    //   40: astore 8
    //   42: aload 12
    //   44: invokevirtual 297	com/facebook/internal/CacheableRequestBatch:getCacheKeyOverride	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: astore_3
    //   50: aload_2
    //   51: invokestatic 301	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   54: ifeq +20 -> 74
    //   57: aload_1
    //   58: invokevirtual 302	com/facebook/RequestBatch:size	()I
    //   61: iconst_1
    //   62: if_icmpne +105 -> 167
    //   65: aload_1
    //   66: iconst_0
    //   67: invokevirtual 305	com/facebook/RequestBatch:get	(I)Lcom/facebook/Request;
    //   70: invokevirtual 308	com/facebook/Request:getUrlForSingleRequest	()Ljava/lang/String;
    //   73: astore_3
    //   74: aload 8
    //   76: astore 9
    //   78: aload_3
    //   79: astore 10
    //   81: aload 4
    //   83: astore_2
    //   84: aload 12
    //   86: invokevirtual 311	com/facebook/internal/CacheableRequestBatch:getForceRoundTrip	()Z
    //   89: ifne +105 -> 194
    //   92: aload 8
    //   94: astore 9
    //   96: aload_3
    //   97: astore 10
    //   99: aload 4
    //   101: astore_2
    //   102: aload 8
    //   104: ifnull +90 -> 194
    //   107: aload 8
    //   109: astore 9
    //   111: aload_3
    //   112: astore 10
    //   114: aload 4
    //   116: astore_2
    //   117: aload_3
    //   118: invokestatic 301	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   121: ifne +73 -> 194
    //   124: aload 11
    //   126: astore 4
    //   128: aload 8
    //   130: aload_3
    //   131: invokevirtual 316	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +47 -> 183
    //   139: aload_2
    //   140: astore 4
    //   142: aload_2
    //   143: astore 5
    //   145: aload_2
    //   146: astore 6
    //   148: aload_2
    //   149: astore 7
    //   151: aload_2
    //   152: aconst_null
    //   153: aload_1
    //   154: iconst_1
    //   155: invokestatic 318	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
    //   158: astore 9
    //   160: aload_2
    //   161: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   164: aload 9
    //   166: areturn
    //   167: getstatic 276	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   170: ldc 31
    //   172: ldc_w 324
    //   175: invokestatic 327	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_2
    //   179: astore_3
    //   180: goto -106 -> 74
    //   183: aload_2
    //   184: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   187: aload_3
    //   188: astore 10
    //   190: aload 8
    //   192: astore 9
    //   194: aload_2
    //   195: astore 5
    //   197: aload_2
    //   198: astore 6
    //   200: aload_2
    //   201: astore 7
    //   203: aload_2
    //   204: astore 8
    //   206: aload_2
    //   207: astore_3
    //   208: aload_0
    //   209: invokevirtual 214	java/net/HttpURLConnection:getResponseCode	()I
    //   212: sipush 400
    //   215: if_icmplt +117 -> 332
    //   218: aload_2
    //   219: astore 5
    //   221: aload_2
    //   222: astore 6
    //   224: aload_2
    //   225: astore 7
    //   227: aload_2
    //   228: astore 8
    //   230: aload_2
    //   231: astore_3
    //   232: aload_0
    //   233: invokevirtual 331	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   236: astore_2
    //   237: aload_2
    //   238: astore 5
    //   240: aload_2
    //   241: astore 6
    //   243: aload_2
    //   244: astore 7
    //   246: aload_2
    //   247: astore 8
    //   249: aload_2
    //   250: astore_3
    //   251: aload_2
    //   252: aload_0
    //   253: aload_1
    //   254: iconst_0
    //   255: invokestatic 318	com/facebook/Response:createResponsesFromStream	(Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/RequestBatch;Z)Ljava/util/List;
    //   258: astore 4
    //   260: aload_2
    //   261: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   264: aload 4
    //   266: areturn
    //   267: astore_2
    //   268: aload 4
    //   270: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   273: aload 8
    //   275: astore 9
    //   277: aload_3
    //   278: astore 10
    //   280: aload 4
    //   282: astore_2
    //   283: goto -89 -> 194
    //   286: astore_2
    //   287: aload 5
    //   289: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   292: aload 8
    //   294: astore 9
    //   296: aload_3
    //   297: astore 10
    //   299: aload 5
    //   301: astore_2
    //   302: goto -108 -> 194
    //   305: astore_2
    //   306: aload 6
    //   308: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   311: aload 8
    //   313: astore 9
    //   315: aload_3
    //   316: astore 10
    //   318: aload 6
    //   320: astore_2
    //   321: goto -127 -> 194
    //   324: astore_0
    //   325: aload 7
    //   327: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   330: aload_0
    //   331: athrow
    //   332: aload_2
    //   333: astore 5
    //   335: aload_2
    //   336: astore 6
    //   338: aload_2
    //   339: astore 7
    //   341: aload_2
    //   342: astore 8
    //   344: aload_2
    //   345: astore_3
    //   346: aload_0
    //   347: invokevirtual 334	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   350: astore 4
    //   352: aload 4
    //   354: astore_2
    //   355: aload 9
    //   357: ifnull -120 -> 237
    //   360: aload 4
    //   362: astore_2
    //   363: aload 10
    //   365: ifnull -128 -> 237
    //   368: aload 4
    //   370: astore_2
    //   371: aload 4
    //   373: ifnull -136 -> 237
    //   376: aload 4
    //   378: astore 5
    //   380: aload 4
    //   382: astore 6
    //   384: aload 4
    //   386: astore 7
    //   388: aload 4
    //   390: astore 8
    //   392: aload 4
    //   394: astore_3
    //   395: aload 9
    //   397: aload 10
    //   399: aload 4
    //   401: invokevirtual 338	com/facebook/internal/FileLruCache:interceptAndPut	(Ljava/lang/String;Ljava/io/InputStream;)Ljava/io/InputStream;
    //   404: astore 9
    //   406: aload 4
    //   408: astore_2
    //   409: aload 9
    //   411: ifnull -174 -> 237
    //   414: aload 9
    //   416: astore_2
    //   417: goto -180 -> 237
    //   420: astore_2
    //   421: aload 5
    //   423: astore_3
    //   424: getstatic 276	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   427: ldc 34
    //   429: ldc_w 340
    //   432: iconst_1
    //   433: anewarray 4	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: aload_2
    //   439: aastore
    //   440: invokestatic 259	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: aload 5
    //   445: astore_3
    //   446: aload_1
    //   447: aload_0
    //   448: aload_2
    //   449: invokestatic 342	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   452: astore_0
    //   453: aload 5
    //   455: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   458: aload_0
    //   459: areturn
    //   460: astore_2
    //   461: aload 6
    //   463: astore_3
    //   464: getstatic 276	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   467: ldc 34
    //   469: ldc_w 340
    //   472: iconst_1
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload_2
    //   479: aastore
    //   480: invokestatic 259	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: aload 6
    //   485: astore_3
    //   486: aload_1
    //   487: aload_0
    //   488: new 176	com/facebook/FacebookException
    //   491: dup
    //   492: aload_2
    //   493: invokespecial 345	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   496: invokestatic 342	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   499: astore_0
    //   500: aload 6
    //   502: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   505: aload_0
    //   506: areturn
    //   507: astore_2
    //   508: aload 7
    //   510: astore_3
    //   511: getstatic 276	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   514: ldc 34
    //   516: ldc_w 340
    //   519: iconst_1
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: aload_2
    //   526: aastore
    //   527: invokestatic 259	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload 7
    //   532: astore_3
    //   533: aload_1
    //   534: aload_0
    //   535: new 176	com/facebook/FacebookException
    //   538: dup
    //   539: aload_2
    //   540: invokespecial 345	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   543: invokestatic 342	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   546: astore_0
    //   547: aload 7
    //   549: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   552: aload_0
    //   553: areturn
    //   554: astore_2
    //   555: aload 8
    //   557: astore_3
    //   558: getstatic 276	com/facebook/LoggingBehavior:REQUESTS	Lcom/facebook/LoggingBehavior;
    //   561: ldc 34
    //   563: ldc_w 340
    //   566: iconst_1
    //   567: anewarray 4	java/lang/Object
    //   570: dup
    //   571: iconst_0
    //   572: aload_2
    //   573: aastore
    //   574: invokestatic 259	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: aload 8
    //   579: astore_3
    //   580: aload_1
    //   581: aload_0
    //   582: new 176	com/facebook/FacebookException
    //   585: dup
    //   586: aload_2
    //   587: invokespecial 345	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   590: invokestatic 342	com/facebook/Response:constructErrorResponses	(Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
    //   593: astore_0
    //   594: aload 8
    //   596: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   599: aload_0
    //   600: areturn
    //   601: astore_0
    //   602: aload_3
    //   603: invokestatic 322	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   606: aload_0
    //   607: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramHttpURLConnection	HttpURLConnection
    //   0	608	1	paramRequestBatch	RequestBatch
    //   23	238	2	localObject1	Object
    //   267	1	2	localFacebookException1	FacebookException
    //   282	1	2	localObject2	Object
    //   286	1	2	localJSONException1	JSONException
    //   301	1	2	localObject3	Object
    //   305	1	2	localIOException1	IOException
    //   320	97	2	localObject4	Object
    //   420	29	2	localFacebookException2	FacebookException
    //   460	33	2	localJSONException2	JSONException
    //   507	33	2	localIOException2	IOException
    //   554	33	2	localSecurityException	SecurityException
    //   49	554	3	localObject5	Object
    //   13	394	4	localObject6	Object
    //   4	450	5	localObject7	Object
    //   7	494	6	localObject8	Object
    //   10	538	7	localObject9	Object
    //   40	555	8	localObject10	Object
    //   16	399	9	localObject11	Object
    //   19	379	10	localObject12	Object
    //   1	124	11	localObject13	Object
    //   35	50	12	localCacheableRequestBatch	com.facebook.internal.CacheableRequestBatch
    // Exception table:
    //   from	to	target	type
    //   128	135	267	com/facebook/FacebookException
    //   151	160	267	com/facebook/FacebookException
    //   128	135	286	org/json/JSONException
    //   151	160	286	org/json/JSONException
    //   128	135	305	java/io/IOException
    //   151	160	305	java/io/IOException
    //   128	135	324	finally
    //   151	160	324	finally
    //   208	218	420	com/facebook/FacebookException
    //   232	237	420	com/facebook/FacebookException
    //   251	260	420	com/facebook/FacebookException
    //   346	352	420	com/facebook/FacebookException
    //   395	406	420	com/facebook/FacebookException
    //   208	218	460	org/json/JSONException
    //   232	237	460	org/json/JSONException
    //   251	260	460	org/json/JSONException
    //   346	352	460	org/json/JSONException
    //   395	406	460	org/json/JSONException
    //   208	218	507	java/io/IOException
    //   232	237	507	java/io/IOException
    //   251	260	507	java/io/IOException
    //   346	352	507	java/io/IOException
    //   395	406	507	java/io/IOException
    //   208	218	554	java/lang/SecurityException
    //   232	237	554	java/lang/SecurityException
    //   251	260	554	java/lang/SecurityException
    //   346	352	554	java/lang/SecurityException
    //   395	406	554	java/lang/SecurityException
    //   208	218	601	finally
    //   232	237	601	finally
    //   251	260	601	finally
    //   346	352	601	finally
    //   395	406	601	finally
    //   424	443	601	finally
    //   446	453	601	finally
    //   464	483	601	finally
    //   486	500	601	finally
    //   511	530	601	finally
    //   533	547	601	finally
    //   558	577	601	finally
    //   580	594	601	finally
  }
  
  static FileLruCache getResponseCache()
  {
    if (responseCache == null)
    {
      Context localContext = Session.getStaticContext();
      if (localContext != null) {
        responseCache = new FileLruCache(localContext, "ResponseCache", new FileLruCache.Limits());
      }
    }
    return responseCache;
  }
  
  public final HttpURLConnection getConnection()
  {
    return this.connection;
  }
  
  public final FacebookRequestError getError()
  {
    return this.error;
  }
  
  public final GraphObject getGraphObject()
  {
    return this.graphObject;
  }
  
  public final <T extends GraphObject> T getGraphObjectAs(Class<T> paramClass)
  {
    if (this.graphObject == null) {
      return null;
    }
    if (paramClass == null) {
      throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
    }
    return this.graphObject.cast(paramClass);
  }
  
  public final GraphObjectList<GraphObject> getGraphObjectList()
  {
    return this.graphObjectList;
  }
  
  public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(Class<T> paramClass)
  {
    if (this.graphObjectList == null) {
      return null;
    }
    return this.graphObjectList.castToListOf(paramClass);
  }
  
  public final boolean getIsFromCache()
  {
    return this.isFromCache;
  }
  
  public String getRawResponse()
  {
    return this.rawResponse;
  }
  
  public Request getRequest()
  {
    return this.request;
  }
  
  public Request getRequestForPagedResults(PagingDirection paramPagingDirection)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    PagingInfo localPagingInfo;
    if (this.graphObject != null)
    {
      localPagingInfo = ((PagedResults)this.graphObject.cast(PagedResults.class)).getPaging();
      localObject1 = localObject2;
      if (localPagingInfo != null) {
        if (paramPagingDirection != PagingDirection.NEXT) {
          break label63;
        }
      }
    }
    label63:
    for (localObject1 = localPagingInfo.getNext(); Utility.isNullOrEmpty((String)localObject1); localObject1 = localPagingInfo.getPrevious()) {
      return null;
    }
    if ((localObject1 != null) && (((String)localObject1).equals(this.request.getUrlForSingleRequest()))) {
      return null;
    }
    try
    {
      paramPagingDirection = new Request(this.request.getSession(), new URL((String)localObject1));
      return paramPagingDirection;
    }
    catch (MalformedURLException paramPagingDirection) {}
    return null;
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        if (this.connection == null) {
          continue;
        }
        i = this.connection.getResponseCode();
        str1 = String.format("%d", new Object[] { Integer.valueOf(i) });
      }
      catch (IOException localIOException)
      {
        int i;
        String str1;
        String str2 = "unknown";
        continue;
      }
      return "{Response: " + " responseCode: " + str1 + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
      i = 200;
    }
  }
  
  static abstract interface PagedResults
    extends GraphObject
  {
    public abstract GraphObjectList<GraphObject> getData();
    
    public abstract Response.PagingInfo getPaging();
  }
  
  public static enum PagingDirection
  {
    NEXT,  PREVIOUS;
    
    private PagingDirection() {}
  }
  
  static abstract interface PagingInfo
    extends GraphObject
  {
    public abstract String getNext();
    
    public abstract String getPrevious();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */