package com.tune.crosspromo;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.net.Uri.Builder;
import com.mobileapptracker.MobileAppTracker;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

public class TuneAdClient
{
  private static final String API_URL_PROD = "api.cp.tune.com/api/v1/ads";
  private static final String API_URL_STAGE = "api.cp.stage.tune.com/api/v1/ads";
  private static final int TIMEOUT = 60000;
  private static String advertiserId;
  private static String apiUrl;
  private static boolean customMode;
  private static TuneAdUtils utils;
  
  private static void checkStatusCode(int paramInt, String paramString)
    throws TuneBadRequestException, TuneServerErrorException
  {
    if ((paramInt >= 400) && (paramInt < 500)) {
      throw new TuneBadRequestException(paramString);
    }
    if (paramInt >= 500) {
      throw new TuneServerErrorException(paramString);
    }
  }
  
  @SuppressLint({"TrulyRandom"})
  private static void disableSSLCertificateChecking()
  {
    X509TrustManager local1 = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    try
    {
      HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
      {
        public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
        {
          return true;
        }
      });
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { local1 }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (KeyManagementException localKeyManagementException)
    {
      localKeyManagementException.printStackTrace();
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
  }
  
  public static void init(String paramString)
  {
    apiUrl = "api.cp.tune.com/api/v1/ads";
    utils = TuneAdUtils.getInstance();
    advertiserId = paramString;
  }
  
  public static void logClick(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/click").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".click." + TuneAdClient.apiUrl + "/click").buildUpon())
          {
            localBuilder.appendQueryParameter("requestId", TuneAdClient.this.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  public static void logClose(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/close").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".event." + TuneAdClient.apiUrl + "/close").buildUpon())
          {
            localBuilder.appendQueryParameter("requestId", TuneAdClient.this.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  private static void logEvent(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setReadTimeout(60000);
      paramString.setConnectTimeout(60000);
      paramString.setDoOutput(true);
      paramString.setRequestProperty("Content-Type", "application/json");
      paramString.setRequestProperty("Accept", "application/json");
      paramString.setRequestMethod("POST");
      OutputStream localOutputStream = paramString.getOutputStream();
      localOutputStream.write(paramJSONObject.toString().getBytes("UTF-8"));
      localOutputStream.close();
      paramString.connect();
      if (0 == 0) {}
    }
    catch (IOException paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (0 == 0);
      try
      {
        throw new NullPointerException();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    finally
    {
      if (0 != 0) {}
      try
      {
        throw new NullPointerException();
        throw paramString;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    try
    {
      throw new NullPointerException();
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return;
  }
  
  public static void logView(TuneAdView paramTuneAdView, final JSONObject paramJSONObject)
  {
    if (MobileAppTracker.isOnline(utils.getContext())) {
      utils.getLogThread().execute(new Runnable()
      {
        public void run()
        {
          if (TuneAdClient.customMode) {}
          for (Uri.Builder localBuilder = Uri.parse("http://" + TuneAdClient.apiUrl + "/api/v1/ads/view").buildUpon();; localBuilder = Uri.parse("https://" + TuneAdClient.advertiserId + ".event." + TuneAdClient.apiUrl + "/view").buildUpon())
          {
            localBuilder.appendQueryParameter("requestId", TuneAdClient.this.requestId);
            TuneAdClient.logEvent(localBuilder.build().toString(), paramJSONObject);
            return;
          }
        }
      });
    }
  }
  
  /* Error */
  public static String requestAd(String paramString, JSONObject paramJSONObject)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore 4
    //   13: aload 7
    //   15: astore_3
    //   16: aload 8
    //   18: astore 5
    //   20: new 145	java/net/URL
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 146	java/net/URL:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 150	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   31: checkcast 152	java/net/HttpURLConnection
    //   34: astore 9
    //   36: aload 6
    //   38: astore 4
    //   40: aload 7
    //   42: astore_3
    //   43: aload 8
    //   45: astore 5
    //   47: aload 9
    //   49: ldc 24
    //   51: invokevirtual 156	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   54: aload 6
    //   56: astore 4
    //   58: aload 7
    //   60: astore_3
    //   61: aload 8
    //   63: astore 5
    //   65: aload 9
    //   67: ldc 24
    //   69: invokevirtual 159	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   72: aload 6
    //   74: astore 4
    //   76: aload 7
    //   78: astore_3
    //   79: aload 8
    //   81: astore 5
    //   83: aload 9
    //   85: iconst_1
    //   86: invokevirtual 220	java/net/HttpURLConnection:setDoInput	(Z)V
    //   89: aload 6
    //   91: astore 4
    //   93: aload 7
    //   95: astore_3
    //   96: aload 8
    //   98: astore 5
    //   100: aload 9
    //   102: iconst_1
    //   103: invokevirtual 163	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   106: aload 6
    //   108: astore 4
    //   110: aload 7
    //   112: astore_3
    //   113: aload 8
    //   115: astore 5
    //   117: aload 9
    //   119: ldc -91
    //   121: ldc -89
    //   123: invokevirtual 171	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 4
    //   130: aload 7
    //   132: astore_3
    //   133: aload 8
    //   135: astore 5
    //   137: aload 9
    //   139: ldc -83
    //   141: ldc -89
    //   143: invokevirtual 171	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 6
    //   148: astore 4
    //   150: aload 7
    //   152: astore_3
    //   153: aload 8
    //   155: astore 5
    //   157: aload 9
    //   159: ldc -81
    //   161: invokevirtual 178	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   164: aload 6
    //   166: astore 4
    //   168: aload 7
    //   170: astore_3
    //   171: aload 8
    //   173: astore 5
    //   175: aload 9
    //   177: invokevirtual 182	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   180: astore_0
    //   181: aload 6
    //   183: astore 4
    //   185: aload 7
    //   187: astore_3
    //   188: aload 8
    //   190: astore 5
    //   192: aload_0
    //   193: aload_1
    //   194: invokevirtual 187	org/json/JSONObject:toString	()Ljava/lang/String;
    //   197: ldc -67
    //   199: invokevirtual 195	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   202: invokevirtual 201	java/io/OutputStream:write	([B)V
    //   205: aload 6
    //   207: astore 4
    //   209: aload 7
    //   211: astore_3
    //   212: aload 8
    //   214: astore 5
    //   216: aload_0
    //   217: invokevirtual 204	java/io/OutputStream:close	()V
    //   220: aload 6
    //   222: astore 4
    //   224: aload 7
    //   226: astore_3
    //   227: aload 8
    //   229: astore 5
    //   231: aload 9
    //   233: invokevirtual 207	java/net/HttpURLConnection:connect	()V
    //   236: aload 6
    //   238: astore 4
    //   240: aload 7
    //   242: astore_3
    //   243: aload 8
    //   245: astore 5
    //   247: aload 9
    //   249: invokevirtual 224	java/net/HttpURLConnection:getResponseCode	()I
    //   252: istore_2
    //   253: iload_2
    //   254: sipush 200
    //   257: if_icmpne +54 -> 311
    //   260: aload 6
    //   262: astore 4
    //   264: aload 7
    //   266: astore_3
    //   267: aload 8
    //   269: astore 5
    //   271: aload 9
    //   273: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   276: astore_0
    //   277: aload_0
    //   278: astore 4
    //   280: aload_0
    //   281: astore_3
    //   282: aload_0
    //   283: astore 5
    //   285: aload 9
    //   287: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   290: invokestatic 234	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   293: astore_1
    //   294: aload_0
    //   295: ifnull +7 -> 302
    //   298: aload_0
    //   299: invokevirtual 237	java/io/InputStream:close	()V
    //   302: aload_1
    //   303: areturn
    //   304: astore_0
    //   305: aload_0
    //   306: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   309: aload_1
    //   310: areturn
    //   311: aload 6
    //   313: astore 4
    //   315: aload 7
    //   317: astore_3
    //   318: aload 8
    //   320: astore 5
    //   322: aload 9
    //   324: invokevirtual 240	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   327: astore_0
    //   328: aload_0
    //   329: astore 4
    //   331: aload_0
    //   332: astore_3
    //   333: aload_0
    //   334: astore 5
    //   336: iload_2
    //   337: aload_0
    //   338: invokestatic 234	com/mobileapptracker/MATUtils:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   341: invokestatic 242	com/tune/crosspromo/TuneAdClient:checkStatusCode	(ILjava/lang/String;)V
    //   344: aload_0
    //   345: ifnull +7 -> 352
    //   348: aload_0
    //   349: invokevirtual 237	java/io/InputStream:close	()V
    //   352: aconst_null
    //   353: areturn
    //   354: astore_0
    //   355: aload 4
    //   357: astore_3
    //   358: aload_0
    //   359: invokevirtual 243	java/net/ConnectException:printStackTrace	()V
    //   362: aload 4
    //   364: astore_3
    //   365: new 217	java/net/ConnectException
    //   368: dup
    //   369: invokespecial 244	java/net/ConnectException:<init>	()V
    //   372: athrow
    //   373: astore_0
    //   374: aload_3
    //   375: ifnull +7 -> 382
    //   378: aload_3
    //   379: invokevirtual 237	java/io/InputStream:close	()V
    //   382: aload_0
    //   383: athrow
    //   384: astore_0
    //   385: aload 5
    //   387: astore_3
    //   388: aload_0
    //   389: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   392: aload 5
    //   394: ifnull -42 -> 352
    //   397: aload 5
    //   399: invokevirtual 237	java/io/InputStream:close	()V
    //   402: goto -50 -> 352
    //   405: astore_0
    //   406: aload_0
    //   407: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   410: goto -58 -> 352
    //   413: astore_1
    //   414: aload_1
    //   415: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   418: goto -36 -> 382
    //   421: astore_0
    //   422: aload_0
    //   423: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   426: goto -74 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString	String
    //   0	429	1	paramJSONObject	JSONObject
    //   252	85	2	i	int
    //   15	373	3	localObject1	Object
    //   11	352	4	localObject2	Object
    //   18	380	5	localObject3	Object
    //   7	305	6	localObject4	Object
    //   1	315	7	localObject5	Object
    //   4	315	8	localObject6	Object
    //   34	289	9	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   298	302	304	java/io/IOException
    //   20	36	354	java/net/ConnectException
    //   47	54	354	java/net/ConnectException
    //   65	72	354	java/net/ConnectException
    //   83	89	354	java/net/ConnectException
    //   100	106	354	java/net/ConnectException
    //   117	126	354	java/net/ConnectException
    //   137	146	354	java/net/ConnectException
    //   157	164	354	java/net/ConnectException
    //   175	181	354	java/net/ConnectException
    //   192	205	354	java/net/ConnectException
    //   216	220	354	java/net/ConnectException
    //   231	236	354	java/net/ConnectException
    //   247	253	354	java/net/ConnectException
    //   271	277	354	java/net/ConnectException
    //   285	294	354	java/net/ConnectException
    //   322	328	354	java/net/ConnectException
    //   336	344	354	java/net/ConnectException
    //   20	36	373	finally
    //   47	54	373	finally
    //   65	72	373	finally
    //   83	89	373	finally
    //   100	106	373	finally
    //   117	126	373	finally
    //   137	146	373	finally
    //   157	164	373	finally
    //   175	181	373	finally
    //   192	205	373	finally
    //   216	220	373	finally
    //   231	236	373	finally
    //   247	253	373	finally
    //   271	277	373	finally
    //   285	294	373	finally
    //   322	328	373	finally
    //   336	344	373	finally
    //   358	362	373	finally
    //   365	373	373	finally
    //   388	392	373	finally
    //   20	36	384	java/io/IOException
    //   47	54	384	java/io/IOException
    //   65	72	384	java/io/IOException
    //   83	89	384	java/io/IOException
    //   100	106	384	java/io/IOException
    //   117	126	384	java/io/IOException
    //   137	146	384	java/io/IOException
    //   157	164	384	java/io/IOException
    //   175	181	384	java/io/IOException
    //   192	205	384	java/io/IOException
    //   216	220	384	java/io/IOException
    //   231	236	384	java/io/IOException
    //   247	253	384	java/io/IOException
    //   271	277	384	java/io/IOException
    //   285	294	384	java/io/IOException
    //   322	328	384	java/io/IOException
    //   336	344	384	java/io/IOException
    //   397	402	405	java/io/IOException
    //   378	382	413	java/io/IOException
    //   348	352	421	java/io/IOException
  }
  
  public static String requestAdOfType(String paramString, TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    Object localObject = null;
    if (MobileAppTracker.isOnline(utils.getContext())) {
      if (!customMode) {
        break label77;
      }
    }
    label77:
    for (localObject = Uri.parse("http://" + apiUrl + "/api/v1/ads/request").buildUpon();; localObject = Uri.parse("https://" + advertiserId + ".request." + apiUrl + "/request").buildUpon())
    {
      ((Uri.Builder)localObject).appendQueryParameter("context[type]", paramString);
      localObject = requestAd(((Uri.Builder)localObject).build().toString(), paramTuneAdParams.toJSON());
      return (String)localObject;
    }
  }
  
  public static String requestBannerAd(TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    return requestAdOfType("banner", paramTuneAdParams);
  }
  
  public static String requestInterstitialAd(TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    return requestAdOfType("interstitial", paramTuneAdParams);
  }
  
  public static String requestNativeAd(TuneAdParams paramTuneAdParams)
    throws TuneBadRequestException, TuneServerErrorException, ConnectException
  {
    return requestAdOfType("native", paramTuneAdParams);
  }
  
  public static void setAddress(String paramString)
  {
    customMode = true;
    apiUrl = paramString;
  }
  
  public static void setStaging(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      apiUrl = "api.cp.stage.tune.com/api/v1/ads";
      disableSSLCertificateChecking();
      return;
    }
    apiUrl = "api.cp.tune.com/api/v1/ads";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */