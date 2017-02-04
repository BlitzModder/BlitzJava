package com.mobileapptracker;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MATUrlRequester
{
  private static void logResponse(JSONObject paramJSONObject)
  {
    if (paramJSONObject.length() > 0)
    {
      try
      {
        if ((paramJSONObject.has("errors")) && (paramJSONObject.getJSONArray("errors").length() != 0))
        {
          paramJSONObject = paramJSONObject.getJSONArray("errors").getString(0);
          Log.d("MobileAppTracker", "Event was rejected by server with error: " + paramJSONObject);
          return;
        }
        if ((!paramJSONObject.has("log_action")) || (paramJSONObject.getString("log_action").equals("null")) || (paramJSONObject.getString("log_action").equals("false")) || (paramJSONObject.getString("log_action").equals("true"))) {
          break label212;
        }
        paramJSONObject = paramJSONObject.getJSONObject("log_action");
        if (!paramJSONObject.has("conversion")) {
          return;
        }
        paramJSONObject = paramJSONObject.getJSONObject("conversion");
        if (!paramJSONObject.has("status")) {
          return;
        }
        if (paramJSONObject.getString("status").equals("rejected"))
        {
          paramJSONObject = paramJSONObject.getString("status_code");
          Log.d("MobileAppTracker", "Event was rejected by server: status code " + paramJSONObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.d("MobileAppTracker", "Server response status could not be parsed");
        paramJSONObject.printStackTrace();
        return;
      }
      Log.d("MobileAppTracker", "Event was accepted by server");
      return;
      label212:
      if (paramJSONObject.has("options"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("options");
        if (paramJSONObject.has("conversion_status"))
        {
          paramJSONObject = paramJSONObject.getString("conversion_status");
          Log.d("MobileAppTracker", "Event was " + paramJSONObject + " by server");
        }
      }
    }
  }
  
  /* Error */
  protected static JSONObject requestUrl(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 7
    //   12: astore 4
    //   14: new 113	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 114	java/net/URL:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 118	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 120	java/net/HttpURLConnection
    //   28: astore 8
    //   30: aload 6
    //   32: astore 5
    //   34: aload 7
    //   36: astore 4
    //   38: aload 8
    //   40: ldc 121
    //   42: invokevirtual 125	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   45: aload 6
    //   47: astore 5
    //   49: aload 7
    //   51: astore 4
    //   53: aload 8
    //   55: ldc 121
    //   57: invokevirtual 128	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   60: aload 6
    //   62: astore 5
    //   64: aload 7
    //   66: astore 4
    //   68: aload 8
    //   70: iconst_1
    //   71: invokevirtual 132	java/net/HttpURLConnection:setDoInput	(Z)V
    //   74: aload_1
    //   75: ifnull +18 -> 93
    //   78: aload 6
    //   80: astore 5
    //   82: aload 7
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 19	org/json/JSONObject:length	()I
    //   90: ifne +237 -> 327
    //   93: aload 6
    //   95: astore 5
    //   97: aload 7
    //   99: astore 4
    //   101: aload 8
    //   103: ldc -122
    //   105: invokevirtual 137	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 6
    //   110: astore 5
    //   112: aload 7
    //   114: astore 4
    //   116: aload 8
    //   118: invokevirtual 140	java/net/HttpURLConnection:connect	()V
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: astore 4
    //   129: aload 8
    //   131: invokevirtual 143	java/net/HttpURLConnection:getResponseCode	()I
    //   134: istore_3
    //   135: iload_2
    //   136: ifeq +33 -> 169
    //   139: aload 6
    //   141: astore 5
    //   143: aload 7
    //   145: astore 4
    //   147: ldc 38
    //   149: new 40	java/lang/StringBuilder
    //   152: dup
    //   153: ldc -111
    //   155: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: iload_3
    //   159: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 59	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   168: pop
    //   169: iload_3
    //   170: sipush 200
    //   173: if_icmpne +327 -> 500
    //   176: aload 6
    //   178: astore 5
    //   180: aload 7
    //   182: astore 4
    //   184: aload 8
    //   186: invokevirtual 152	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   189: astore_1
    //   190: aload_1
    //   191: astore 5
    //   193: aload_1
    //   194: astore 4
    //   196: aload_1
    //   197: invokestatic 158	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   200: astore 7
    //   202: iload_2
    //   203: ifeq +32 -> 235
    //   206: aload_1
    //   207: astore 5
    //   209: aload_1
    //   210: astore 4
    //   212: ldc 38
    //   214: new 40	java/lang/StringBuilder
    //   217: dup
    //   218: ldc -96
    //   220: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload 7
    //   225: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 59	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   234: pop
    //   235: aload_1
    //   236: astore 5
    //   238: aload_1
    //   239: astore 4
    //   241: new 15	org/json/JSONObject
    //   244: dup
    //   245: invokespecial 161	org/json/JSONObject:<init>	()V
    //   248: astore 6
    //   250: aload_1
    //   251: astore 4
    //   253: new 15	org/json/JSONObject
    //   256: dup
    //   257: new 163	org/json/JSONTokener
    //   260: dup
    //   261: aload 7
    //   263: invokespecial 164	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   266: invokespecial 167	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   269: astore 5
    //   271: iload_2
    //   272: ifeq +372 -> 644
    //   275: aload_1
    //   276: astore 4
    //   278: aload 5
    //   280: invokestatic 169	com/mobileapptracker/MATUrlRequester:logResponse	(Lorg/json/JSONObject;)V
    //   283: aload 5
    //   285: astore 6
    //   287: aload_1
    //   288: astore 5
    //   290: aload_1
    //   291: astore 4
    //   293: aload 8
    //   295: ldc -85
    //   297: invokevirtual 174	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 7
    //   302: iload_3
    //   303: sipush 200
    //   306: if_icmplt +246 -> 552
    //   309: iload_3
    //   310: sipush 300
    //   313: if_icmpge +239 -> 552
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 179	java/io/InputStream:close	()V
    //   324: aload 6
    //   326: areturn
    //   327: aload 6
    //   329: astore 5
    //   331: aload 7
    //   333: astore 4
    //   335: aload 8
    //   337: iconst_1
    //   338: invokevirtual 182	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   341: aload 6
    //   343: astore 5
    //   345: aload 7
    //   347: astore 4
    //   349: aload 8
    //   351: ldc -72
    //   353: ldc -70
    //   355: invokevirtual 190	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 6
    //   360: astore 5
    //   362: aload 7
    //   364: astore 4
    //   366: aload 8
    //   368: ldc -64
    //   370: ldc -70
    //   372: invokevirtual 190	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 6
    //   377: astore 5
    //   379: aload 7
    //   381: astore 4
    //   383: aload 8
    //   385: ldc -62
    //   387: invokevirtual 137	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   390: aload 6
    //   392: astore 5
    //   394: aload 7
    //   396: astore 4
    //   398: aload 8
    //   400: invokevirtual 198	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   403: astore 9
    //   405: aload 6
    //   407: astore 5
    //   409: aload 7
    //   411: astore 4
    //   413: aload 9
    //   415: aload_1
    //   416: invokevirtual 199	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: ldc -55
    //   421: invokevirtual 205	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   424: invokevirtual 211	java/io/OutputStream:write	([B)V
    //   427: aload 6
    //   429: astore 5
    //   431: aload 7
    //   433: astore 4
    //   435: aload 9
    //   437: invokevirtual 212	java/io/OutputStream:close	()V
    //   440: goto -332 -> 108
    //   443: astore_1
    //   444: iload_2
    //   445: ifeq +29 -> 474
    //   448: aload 5
    //   450: astore 4
    //   452: ldc 38
    //   454: new 40	java/lang/StringBuilder
    //   457: dup
    //   458: ldc -42
    //   460: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   463: aload_0
    //   464: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 59	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   473: pop
    //   474: aload 5
    //   476: astore 4
    //   478: aload_1
    //   479: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   482: aload 5
    //   484: ifnull +8 -> 492
    //   487: aload 5
    //   489: invokevirtual 179	java/io/InputStream:close	()V
    //   492: new 15	org/json/JSONObject
    //   495: dup
    //   496: invokespecial 161	org/json/JSONObject:<init>	()V
    //   499: areturn
    //   500: aload 6
    //   502: astore 5
    //   504: aload 7
    //   506: astore 4
    //   508: aload 8
    //   510: invokevirtual 218	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   513: astore_1
    //   514: goto -324 -> 190
    //   517: aload_1
    //   518: astore 5
    //   520: aload_1
    //   521: astore 4
    //   523: aload 7
    //   525: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   528: goto -241 -> 287
    //   531: astore_0
    //   532: aload 4
    //   534: ifnull +8 -> 542
    //   537: aload 4
    //   539: invokevirtual 179	java/io/InputStream:close	()V
    //   542: aload_0
    //   543: athrow
    //   544: astore_0
    //   545: aload_0
    //   546: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   549: aload 6
    //   551: areturn
    //   552: iload_3
    //   553: sipush 400
    //   556: if_icmpne +60 -> 616
    //   559: aload 7
    //   561: ifnull +55 -> 616
    //   564: iload_2
    //   565: ifeq +17 -> 582
    //   568: aload_1
    //   569: astore 5
    //   571: aload_1
    //   572: astore 4
    //   574: ldc 38
    //   576: ldc -35
    //   578: invokestatic 59	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   581: pop
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 179	java/io/InputStream:close	()V
    //   590: aconst_null
    //   591: areturn
    //   592: astore_0
    //   593: aload_0
    //   594: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   597: goto -7 -> 590
    //   600: astore_0
    //   601: aload_0
    //   602: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   605: goto -113 -> 492
    //   608: astore_1
    //   609: aload_1
    //   610: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   613: goto -71 -> 542
    //   616: aload_1
    //   617: ifnull -125 -> 492
    //   620: aload_1
    //   621: invokevirtual 179	java/io/InputStream:close	()V
    //   624: goto -132 -> 492
    //   627: astore_0
    //   628: aload_0
    //   629: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   632: goto -140 -> 492
    //   635: astore 7
    //   637: aload 5
    //   639: astore 6
    //   641: goto -124 -> 517
    //   644: aload 5
    //   646: astore 6
    //   648: goto -361 -> 287
    //   651: astore 7
    //   653: goto -136 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	paramString	String
    //   0	656	1	paramJSONObject	JSONObject
    //   0	656	2	paramBoolean	boolean
    //   134	423	3	i	int
    //   12	561	4	localObject1	Object
    //   8	637	5	localObject2	Object
    //   4	643	6	localObject3	Object
    //   1	559	7	str	String
    //   635	1	7	localException1	Exception
    //   651	1	7	localException2	Exception
    //   28	481	8	localHttpURLConnection	HttpURLConnection
    //   403	33	9	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   14	30	443	java/lang/Exception
    //   38	45	443	java/lang/Exception
    //   53	60	443	java/lang/Exception
    //   68	74	443	java/lang/Exception
    //   86	93	443	java/lang/Exception
    //   101	108	443	java/lang/Exception
    //   116	121	443	java/lang/Exception
    //   129	135	443	java/lang/Exception
    //   147	169	443	java/lang/Exception
    //   184	190	443	java/lang/Exception
    //   196	202	443	java/lang/Exception
    //   212	235	443	java/lang/Exception
    //   241	250	443	java/lang/Exception
    //   293	302	443	java/lang/Exception
    //   335	341	443	java/lang/Exception
    //   349	358	443	java/lang/Exception
    //   366	375	443	java/lang/Exception
    //   383	390	443	java/lang/Exception
    //   398	405	443	java/lang/Exception
    //   413	427	443	java/lang/Exception
    //   435	440	443	java/lang/Exception
    //   508	514	443	java/lang/Exception
    //   523	528	443	java/lang/Exception
    //   574	582	443	java/lang/Exception
    //   14	30	531	finally
    //   38	45	531	finally
    //   53	60	531	finally
    //   68	74	531	finally
    //   86	93	531	finally
    //   101	108	531	finally
    //   116	121	531	finally
    //   129	135	531	finally
    //   147	169	531	finally
    //   184	190	531	finally
    //   196	202	531	finally
    //   212	235	531	finally
    //   241	250	531	finally
    //   253	271	531	finally
    //   278	283	531	finally
    //   293	302	531	finally
    //   335	341	531	finally
    //   349	358	531	finally
    //   366	375	531	finally
    //   383	390	531	finally
    //   398	405	531	finally
    //   413	427	531	finally
    //   435	440	531	finally
    //   452	474	531	finally
    //   478	482	531	finally
    //   508	514	531	finally
    //   523	528	531	finally
    //   574	582	531	finally
    //   320	324	544	java/io/IOException
    //   586	590	592	java/io/IOException
    //   487	492	600	java/io/IOException
    //   537	542	608	java/io/IOException
    //   620	624	627	java/io/IOException
    //   278	283	635	java/lang/Exception
    //   253	271	651	java/lang/Exception
  }
  
  public void requestDeeplink(MATDeferredDplinkr paramMATDeferredDplinkr)
  {
    Object localObject4 = null;
    String str = null;
    Uri.Builder localBuilder = new Uri.Builder();
    Object localObject2 = localBuilder.scheme("https").authority(paramMATDeferredDplinkr.getAdvertiserId() + "." + "deeplink.mobileapptracking.com").appendPath("v1").appendPath("link.txt").appendQueryParameter("platform", "android").appendQueryParameter("advertiser_id", paramMATDeferredDplinkr.getAdvertiserId()).appendQueryParameter("ver", "3.11.0").appendQueryParameter("package_name", paramMATDeferredDplinkr.getPackageName());
    Object localObject1;
    Object localObject3;
    if (paramMATDeferredDplinkr.getGoogleAdvertisingId() != null)
    {
      localObject1 = paramMATDeferredDplinkr.getGoogleAdvertisingId();
      ((Uri.Builder)localObject2).appendQueryParameter("ad_id", (String)localObject1).appendQueryParameter("user_agent", paramMATDeferredDplinkr.getUserAgent());
      if (paramMATDeferredDplinkr.getGoogleAdvertisingId() != null) {
        localBuilder.appendQueryParameter("google_ad_tracking_disabled", Integer.toString(paramMATDeferredDplinkr.getGoogleAdTrackingLimited()));
      }
      localObject3 = str;
      localObject2 = localObject4;
    }
    for (;;)
    {
      try
      {
        localObject1 = (HttpURLConnection)new URL(localBuilder.build().toString()).openConnection();
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setRequestProperty("X-MAT-Key", paramMATDeferredDplinkr.getConversionKey());
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = str;
        localObject2 = localObject4;
        ((HttpURLConnection)localObject1).connect();
        i = 0;
        localObject3 = str;
        localObject2 = localObject4;
        if (((HttpURLConnection)localObject1).getResponseCode() == 200)
        {
          localObject3 = str;
          localObject2 = localObject4;
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          localObject3 = localObject1;
          localObject2 = localObject1;
          str = MATUtils.readStream((InputStream)localObject1);
          localObject3 = localObject1;
          localObject2 = localObject1;
          paramMATDeferredDplinkr = paramMATDeferredDplinkr.getListener();
          if (paramMATDeferredDplinkr != null)
          {
            if (i == 0) {
              continue;
            }
            localObject3 = localObject1;
            localObject2 = localObject1;
            paramMATDeferredDplinkr.didFailDeeplink(str);
          }
        }
      }
      catch (Exception paramMATDeferredDplinkr)
      {
        int i;
        localObject2 = localObject3;
        paramMATDeferredDplinkr.printStackTrace();
        try
        {
          ((InputStream)localObject3).close();
          return;
        }
        catch (Exception paramMATDeferredDplinkr)
        {
          paramMATDeferredDplinkr.printStackTrace();
          return;
        }
      }
      finally
      {
        try
        {
          ((InputStream)localObject2).close();
          throw paramMATDeferredDplinkr;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
      }
      try
      {
        ((InputStream)localObject1).close();
        return;
      }
      catch (Exception paramMATDeferredDplinkr)
      {
        paramMATDeferredDplinkr.printStackTrace();
      }
      localObject1 = paramMATDeferredDplinkr.getAndroidId();
      break;
      i = 1;
      localObject3 = str;
      localObject2 = localObject4;
      localObject1 = ((HttpURLConnection)localObject1).getErrorStream();
      continue;
      localObject3 = localObject1;
      localObject2 = localObject1;
      paramMATDeferredDplinkr.didReceiveDeeplink(str);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATUrlRequester.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */