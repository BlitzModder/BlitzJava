package com.mobileapptracker;

import android.util.Log;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MATUrlBuilder
{
  private static MATParameters params;
  
  public static JSONObject buildBody(JSONArray paramJSONArray1, String paramString1, String paramString2, JSONArray paramJSONArray2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramJSONArray1 != null) {}
      try
      {
        localJSONObject.put("data", paramJSONArray1);
        if (paramString1 != null) {
          localJSONObject.put("store_iap_data", paramString1);
        }
        if (paramString2 != null) {
          localJSONObject.put("store_iap_signature", paramString2);
        }
        if (paramJSONArray2 != null) {
          localJSONObject.put("user_emails", paramJSONArray2);
        }
      }
      catch (JSONException paramJSONArray1)
      {
        for (;;)
        {
          Log.d("MobileAppTracker", "Could not build JSON body of request");
          paramJSONArray1.printStackTrace();
        }
      }
      return localJSONObject;
    }
    finally {}
  }
  
  /* Error */
  public static String buildDataUnencrypted(MATEvent paramMATEvent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 51	com/mobileapptracker/MATParameters:getInstance	()Lcom/mobileapptracker/MATParameters;
    //   6: putstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   9: new 55	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: new 55	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 58
    //   24: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   30: invokevirtual 65	com/mobileapptracker/MATParameters:getConnectionType	()Ljava/lang/String;
    //   33: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: ldc 74
    //   46: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   49: invokevirtual 77	com/mobileapptracker/MATParameters:getAltitude	()Ljava/lang/String;
    //   52: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc 83
    //   58: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   61: invokevirtual 86	com/mobileapptracker/MATParameters:getAndroidId	()Ljava/lang/String;
    //   64: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_1
    //   68: ldc 88
    //   70: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   73: invokevirtual 91	com/mobileapptracker/MATParameters:getAndroidIdMd5	()Ljava/lang/String;
    //   76: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: ldc 93
    //   82: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   85: invokevirtual 96	com/mobileapptracker/MATParameters:getAndroidIdSha1	()Ljava/lang/String;
    //   88: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ldc 98
    //   94: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   97: invokevirtual 101	com/mobileapptracker/MATParameters:getAndroidIdSha256	()Ljava/lang/String;
    //   100: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: ldc 103
    //   106: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   109: invokevirtual 106	com/mobileapptracker/MATParameters:getAppAdTrackingEnabled	()Ljava/lang/String;
    //   112: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc 108
    //   118: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   121: invokevirtual 111	com/mobileapptracker/MATParameters:getAppName	()Ljava/lang/String;
    //   124: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: ldc 113
    //   130: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   133: invokevirtual 116	com/mobileapptracker/MATParameters:getAppVersion	()Ljava/lang/String;
    //   136: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: ldc 118
    //   142: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   145: invokevirtual 121	com/mobileapptracker/MATParameters:getAppVersionName	()Ljava/lang/String;
    //   148: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: ldc 123
    //   154: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   157: invokevirtual 126	com/mobileapptracker/MATParameters:getCountryCode	()Ljava/lang/String;
    //   160: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_1
    //   164: ldc -128
    //   166: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   169: invokevirtual 131	com/mobileapptracker/MATParameters:getDeviceBrand	()Ljava/lang/String;
    //   172: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_1
    //   176: ldc -123
    //   178: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   181: invokevirtual 136	com/mobileapptracker/MATParameters:getDeviceCarrier	()Ljava/lang/String;
    //   184: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc -118
    //   190: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   193: invokevirtual 141	com/mobileapptracker/MATParameters:getDeviceCpuType	()Ljava/lang/String;
    //   196: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc -113
    //   202: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   205: invokevirtual 146	com/mobileapptracker/MATParameters:getDeviceCpuSubtype	()Ljava/lang/String;
    //   208: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_1
    //   212: ldc -108
    //   214: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   217: invokevirtual 151	com/mobileapptracker/MATParameters:getDeviceModel	()Ljava/lang/String;
    //   220: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc -103
    //   226: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   229: invokevirtual 156	com/mobileapptracker/MATParameters:getDeviceId	()Ljava/lang/String;
    //   232: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_1
    //   236: ldc -98
    //   238: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   241: invokevirtual 161	com/mobileapptracker/MATParameters:getGoogleAdvertisingId	()Ljava/lang/String;
    //   244: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_1
    //   248: ldc -93
    //   250: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   253: invokevirtual 166	com/mobileapptracker/MATParameters:getGoogleAdTrackingLimited	()Ljava/lang/String;
    //   256: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_1
    //   260: ldc -88
    //   262: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   265: invokevirtual 171	com/mobileapptracker/MATParameters:getInstallDate	()Ljava/lang/String;
    //   268: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_1
    //   272: ldc -83
    //   274: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   277: invokevirtual 176	com/mobileapptracker/MATParameters:getInstaller	()Ljava/lang/String;
    //   280: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_1
    //   284: ldc -78
    //   286: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   289: invokevirtual 181	com/mobileapptracker/MATParameters:getInstallReferrer	()Ljava/lang/String;
    //   292: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_1
    //   296: ldc -73
    //   298: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   301: invokevirtual 186	com/mobileapptracker/MATParameters:getLanguage	()Ljava/lang/String;
    //   304: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_1
    //   308: ldc -68
    //   310: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   313: invokevirtual 191	com/mobileapptracker/MATParameters:getLastOpenLogId	()Ljava/lang/String;
    //   316: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_1
    //   320: ldc -63
    //   322: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   325: invokevirtual 196	com/mobileapptracker/MATParameters:getLatitude	()Ljava/lang/String;
    //   328: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_1
    //   332: ldc -58
    //   334: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   337: invokevirtual 201	com/mobileapptracker/MATParameters:getLongitude	()Ljava/lang/String;
    //   340: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_1
    //   344: ldc -53
    //   346: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   349: invokevirtual 206	com/mobileapptracker/MATParameters:getMacAddress	()Ljava/lang/String;
    //   352: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_1
    //   356: ldc -48
    //   358: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   361: invokevirtual 211	com/mobileapptracker/MATParameters:getMatId	()Ljava/lang/String;
    //   364: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload_1
    //   368: ldc -43
    //   370: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   373: invokevirtual 216	com/mobileapptracker/MATParameters:getMCC	()Ljava/lang/String;
    //   376: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_1
    //   380: ldc -38
    //   382: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   385: invokevirtual 221	com/mobileapptracker/MATParameters:getMNC	()Ljava/lang/String;
    //   388: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_1
    //   392: ldc -33
    //   394: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   397: invokevirtual 226	com/mobileapptracker/MATParameters:getOpenLogId	()Ljava/lang/String;
    //   400: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_1
    //   404: ldc -28
    //   406: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   409: invokevirtual 231	com/mobileapptracker/MATParameters:getOsVersion	()Ljava/lang/String;
    //   412: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   415: aload_1
    //   416: ldc -23
    //   418: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   421: invokevirtual 236	com/mobileapptracker/MATParameters:getPluginName	()Ljava/lang/String;
    //   424: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_1
    //   428: ldc -18
    //   430: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   433: invokevirtual 241	com/mobileapptracker/MATParameters:getPurchaseStatus	()Ljava/lang/String;
    //   436: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload_1
    //   440: ldc -13
    //   442: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   445: invokevirtual 246	com/mobileapptracker/MATParameters:getReferrerDelay	()Ljava/lang/String;
    //   448: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_1
    //   452: ldc -8
    //   454: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   457: invokevirtual 251	com/mobileapptracker/MATParameters:getScreenDensity	()Ljava/lang/String;
    //   460: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload_1
    //   464: ldc -3
    //   466: new 55	java/lang/StringBuilder
    //   469: dup
    //   470: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   473: invokevirtual 256	com/mobileapptracker/MATParameters:getScreenWidth	()Ljava/lang/String;
    //   476: invokestatic 262	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   479: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: ldc_w 264
    //   485: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   491: invokevirtual 267	com/mobileapptracker/MATParameters:getScreenHeight	()Ljava/lang/String;
    //   494: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload_1
    //   504: ldc_w 269
    //   507: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   510: invokevirtual 272	com/mobileapptracker/MATParameters:getSdkVersion	()Ljava/lang/String;
    //   513: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   516: aload_1
    //   517: ldc_w 274
    //   520: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   523: invokevirtual 277	com/mobileapptracker/MATParameters:getTRUSTeId	()Ljava/lang/String;
    //   526: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload_1
    //   530: ldc_w 279
    //   533: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   536: invokevirtual 282	com/mobileapptracker/MATParameters:getUserAgent	()Ljava/lang/String;
    //   539: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload_1
    //   543: ldc_w 284
    //   546: aload_0
    //   547: invokevirtual 289	com/mobileapptracker/MATEvent:getAttribute1	()Ljava/lang/String;
    //   550: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload_1
    //   554: ldc_w 291
    //   557: aload_0
    //   558: invokevirtual 294	com/mobileapptracker/MATEvent:getAttribute2	()Ljava/lang/String;
    //   561: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload_1
    //   565: ldc_w 296
    //   568: aload_0
    //   569: invokevirtual 299	com/mobileapptracker/MATEvent:getAttribute3	()Ljava/lang/String;
    //   572: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   575: aload_1
    //   576: ldc_w 301
    //   579: aload_0
    //   580: invokevirtual 304	com/mobileapptracker/MATEvent:getAttribute4	()Ljava/lang/String;
    //   583: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload_1
    //   587: ldc_w 306
    //   590: aload_0
    //   591: invokevirtual 309	com/mobileapptracker/MATEvent:getAttribute5	()Ljava/lang/String;
    //   594: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   597: aload_1
    //   598: ldc_w 311
    //   601: aload_0
    //   602: invokevirtual 314	com/mobileapptracker/MATEvent:getContentId	()Ljava/lang/String;
    //   605: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload_1
    //   609: ldc_w 316
    //   612: aload_0
    //   613: invokevirtual 319	com/mobileapptracker/MATEvent:getContentType	()Ljava/lang/String;
    //   616: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload_0
    //   620: invokevirtual 322	com/mobileapptracker/MATEvent:getCurrencyCode	()Ljava/lang/String;
    //   623: ifnull +420 -> 1043
    //   626: aload_1
    //   627: ldc_w 324
    //   630: aload_0
    //   631: invokevirtual 322	com/mobileapptracker/MATEvent:getCurrencyCode	()Ljava/lang/String;
    //   634: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload_0
    //   638: invokevirtual 328	com/mobileapptracker/MATEvent:getDate1	()Ljava/util/Date;
    //   641: ifnull +24 -> 665
    //   644: aload_1
    //   645: ldc_w 330
    //   648: aload_0
    //   649: invokevirtual 328	com/mobileapptracker/MATEvent:getDate1	()Ljava/util/Date;
    //   652: invokevirtual 336	java/util/Date:getTime	()J
    //   655: ldc2_w 337
    //   658: ldiv
    //   659: invokestatic 343	java/lang/Long:toString	(J)Ljava/lang/String;
    //   662: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   665: aload_0
    //   666: invokevirtual 346	com/mobileapptracker/MATEvent:getDate2	()Ljava/util/Date;
    //   669: ifnull +24 -> 693
    //   672: aload_1
    //   673: ldc_w 348
    //   676: aload_0
    //   677: invokevirtual 346	com/mobileapptracker/MATEvent:getDate2	()Ljava/util/Date;
    //   680: invokevirtual 336	java/util/Date:getTime	()J
    //   683: ldc2_w 337
    //   686: ldiv
    //   687: invokestatic 343	java/lang/Long:toString	(J)Ljava/lang/String;
    //   690: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   693: aload_0
    //   694: invokevirtual 352	com/mobileapptracker/MATEvent:getLevel	()I
    //   697: ifeq +17 -> 714
    //   700: aload_1
    //   701: ldc_w 354
    //   704: aload_0
    //   705: invokevirtual 352	com/mobileapptracker/MATEvent:getLevel	()I
    //   708: invokestatic 359	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   711: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_0
    //   715: invokevirtual 362	com/mobileapptracker/MATEvent:getQuantity	()I
    //   718: ifeq +17 -> 735
    //   721: aload_1
    //   722: ldc_w 364
    //   725: aload_0
    //   726: invokevirtual 362	com/mobileapptracker/MATEvent:getQuantity	()I
    //   729: invokestatic 359	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   732: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   735: aload_0
    //   736: invokevirtual 368	com/mobileapptracker/MATEvent:getRating	()D
    //   739: dconst_0
    //   740: dcmpl
    //   741: ifeq +17 -> 758
    //   744: aload_1
    //   745: ldc_w 370
    //   748: aload_0
    //   749: invokevirtual 368	com/mobileapptracker/MATEvent:getRating	()D
    //   752: invokestatic 375	java/lang/Double:toString	(D)Ljava/lang/String;
    //   755: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   758: aload_1
    //   759: ldc_w 377
    //   762: aload_0
    //   763: invokevirtual 380	com/mobileapptracker/MATEvent:getSearchString	()Ljava/lang/String;
    //   766: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_1
    //   770: ldc_w 382
    //   773: aload_0
    //   774: invokevirtual 385	com/mobileapptracker/MATEvent:getRefId	()Ljava/lang/String;
    //   777: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload_1
    //   781: ldc_w 387
    //   784: aload_0
    //   785: invokevirtual 390	com/mobileapptracker/MATEvent:getRevenue	()D
    //   788: invokestatic 375	java/lang/Double:toString	(D)Ljava/lang/String;
    //   791: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload_0
    //   795: invokevirtual 393	com/mobileapptracker/MATEvent:getDeviceForm	()Ljava/lang/String;
    //   798: ifnull +14 -> 812
    //   801: aload_1
    //   802: ldc_w 395
    //   805: aload_0
    //   806: invokevirtual 393	com/mobileapptracker/MATEvent:getDeviceForm	()Ljava/lang/String;
    //   809: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   812: aload_1
    //   813: ldc_w 397
    //   816: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   819: invokevirtual 400	com/mobileapptracker/MATParameters:getAge	()Ljava/lang/String;
    //   822: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload_1
    //   826: ldc_w 402
    //   829: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   832: invokevirtual 405	com/mobileapptracker/MATParameters:getExistingUser	()Ljava/lang/String;
    //   835: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload_1
    //   839: ldc_w 407
    //   842: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   845: invokevirtual 410	com/mobileapptracker/MATParameters:getFacebookUserId	()Ljava/lang/String;
    //   848: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   851: aload_1
    //   852: ldc_w 412
    //   855: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   858: invokevirtual 415	com/mobileapptracker/MATParameters:getGender	()Ljava/lang/String;
    //   861: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload_1
    //   865: ldc_w 417
    //   868: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   871: invokevirtual 420	com/mobileapptracker/MATParameters:getGoogleUserId	()Ljava/lang/String;
    //   874: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_1
    //   878: ldc_w 422
    //   881: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   884: invokevirtual 425	com/mobileapptracker/MATParameters:getIsPayingUser	()Ljava/lang/String;
    //   887: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   890: aload_1
    //   891: ldc_w 427
    //   894: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   897: invokevirtual 430	com/mobileapptracker/MATParameters:getTwitterUserId	()Ljava/lang/String;
    //   900: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload_1
    //   904: ldc_w 432
    //   907: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   910: invokevirtual 435	com/mobileapptracker/MATParameters:getUserEmailMd5	()Ljava/lang/String;
    //   913: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   916: aload_1
    //   917: ldc_w 437
    //   920: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   923: invokevirtual 440	com/mobileapptracker/MATParameters:getUserEmailSha1	()Ljava/lang/String;
    //   926: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload_1
    //   930: ldc_w 442
    //   933: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   936: invokevirtual 445	com/mobileapptracker/MATParameters:getUserEmailSha256	()Ljava/lang/String;
    //   939: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   942: aload_1
    //   943: ldc_w 447
    //   946: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   949: invokevirtual 450	com/mobileapptracker/MATParameters:getUserId	()Ljava/lang/String;
    //   952: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   955: aload_1
    //   956: ldc_w 452
    //   959: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   962: invokevirtual 455	com/mobileapptracker/MATParameters:getUserNameMd5	()Ljava/lang/String;
    //   965: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   968: aload_1
    //   969: ldc_w 457
    //   972: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   975: invokevirtual 460	com/mobileapptracker/MATParameters:getUserNameSha1	()Ljava/lang/String;
    //   978: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload_1
    //   982: ldc_w 462
    //   985: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   988: invokevirtual 465	com/mobileapptracker/MATParameters:getUserNameSha256	()Ljava/lang/String;
    //   991: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload_1
    //   995: ldc_w 467
    //   998: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1001: invokevirtual 470	com/mobileapptracker/MATParameters:getPhoneNumberMd5	()Ljava/lang/String;
    //   1004: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_1
    //   1008: ldc_w 472
    //   1011: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1014: invokevirtual 475	com/mobileapptracker/MATParameters:getPhoneNumberSha1	()Ljava/lang/String;
    //   1017: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload_1
    //   1021: ldc_w 477
    //   1024: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1027: invokevirtual 480	com/mobileapptracker/MATParameters:getPhoneNumberSha256	()Ljava/lang/String;
    //   1030: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload_1
    //   1034: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: astore_0
    //   1038: ldc 2
    //   1040: monitorexit
    //   1041: aload_0
    //   1042: areturn
    //   1043: aload_1
    //   1044: ldc_w 324
    //   1047: getstatic 53	com/mobileapptracker/MATUrlBuilder:params	Lcom/mobileapptracker/MATParameters;
    //   1050: invokevirtual 481	com/mobileapptracker/MATParameters:getCurrencyCode	()Ljava/lang/String;
    //   1053: invokestatic 81	com/mobileapptracker/MATUrlBuilder:safeAppend	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    //   1056: goto -419 -> 637
    //   1059: astore_0
    //   1060: ldc 2
    //   1062: monitorexit
    //   1063: aload_0
    //   1064: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1065	0	paramMATEvent	MATEvent
    //   16	1028	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	637	1059	finally
    //   637	665	1059	finally
    //   665	693	1059	finally
    //   693	714	1059	finally
    //   714	735	1059	finally
    //   735	758	1059	finally
    //   758	812	1059	finally
    //   812	1038	1059	finally
    //   1043	1056	1059	finally
  }
  
  public static String buildLink(MATEvent paramMATEvent, MATPreloadData paramMATPreloadData, boolean paramBoolean)
  {
    params = MATParameters.getInstance();
    StringBuilder localStringBuilder = new StringBuilder("https://").append(params.getAdvertiserId()).append(".");
    if (paramBoolean) {
      localStringBuilder.append("debug.engine.mobileapptracking.com");
    }
    for (;;)
    {
      localStringBuilder.append("/serve?ver=").append(params.getSdkVersion());
      localStringBuilder.append("&transaction_id=").append(UUID.randomUUID().toString());
      safeAppend(localStringBuilder, "sdk", "android");
      safeAppend(localStringBuilder, "action", params.getAction());
      safeAppend(localStringBuilder, "advertiser_id", params.getAdvertiserId());
      safeAppend(localStringBuilder, "package_name", params.getPackageName());
      safeAppend(localStringBuilder, "referral_source", params.getReferralSource());
      safeAppend(localStringBuilder, "referral_url", params.getReferralUrl());
      safeAppend(localStringBuilder, "site_id", params.getSiteId());
      safeAppend(localStringBuilder, "tracking_id", params.getTrackingId());
      if (paramMATEvent.getEventId() != 0) {
        safeAppend(localStringBuilder, "site_event_id", Integer.toString(paramMATEvent.getEventId()));
      }
      if (!params.getAction().equals("session")) {
        safeAppend(localStringBuilder, "site_event_name", paramMATEvent.getEventName());
      }
      if (paramMATPreloadData != null)
      {
        localStringBuilder.append("&attr_set=1");
        safeAppend(localStringBuilder, "publisher_id", paramMATPreloadData.publisherId);
        safeAppend(localStringBuilder, "offer_id", paramMATPreloadData.offerId);
        safeAppend(localStringBuilder, "agency_id", paramMATPreloadData.agencyId);
        safeAppend(localStringBuilder, "publisher_ref_id", paramMATPreloadData.publisherReferenceId);
        safeAppend(localStringBuilder, "publisher_sub_publisher", paramMATPreloadData.publisherSubPublisher);
        safeAppend(localStringBuilder, "publisher_sub_site", paramMATPreloadData.publisherSubSite);
        safeAppend(localStringBuilder, "publisher_sub_campaign", paramMATPreloadData.publisherSubCampaign);
        safeAppend(localStringBuilder, "publisher_sub_adgroup", paramMATPreloadData.publisherSubAdgroup);
        safeAppend(localStringBuilder, "publisher_sub_ad", paramMATPreloadData.publisherSubAd);
        safeAppend(localStringBuilder, "publisher_sub_keyword", paramMATPreloadData.publisherSubKeyword);
        safeAppend(localStringBuilder, "advertiser_sub_publisher", paramMATPreloadData.advertiserSubPublisher);
        safeAppend(localStringBuilder, "advertiser_sub_site", paramMATPreloadData.advertiserSubSite);
        safeAppend(localStringBuilder, "advertiser_sub_campaign", paramMATPreloadData.advertiserSubCampaign);
        safeAppend(localStringBuilder, "advertiser_sub_adgroup", paramMATPreloadData.advertiserSubAdgroup);
        safeAppend(localStringBuilder, "advertiser_sub_ad", paramMATPreloadData.advertiserSubAd);
        safeAppend(localStringBuilder, "advertiser_sub_keyword", paramMATPreloadData.advertiserSubKeyword);
        safeAppend(localStringBuilder, "publisher_sub1", paramMATPreloadData.publisherSub1);
        safeAppend(localStringBuilder, "publisher_sub2", paramMATPreloadData.publisherSub2);
        safeAppend(localStringBuilder, "publisher_sub3", paramMATPreloadData.publisherSub3);
        safeAppend(localStringBuilder, "publisher_sub4", paramMATPreloadData.publisherSub4);
        safeAppend(localStringBuilder, "publisher_sub5", paramMATPreloadData.publisherSub5);
      }
      paramMATEvent = params.getAllowDuplicates();
      if ((paramMATEvent != null) && (Integer.parseInt(paramMATEvent) == 1)) {
        localStringBuilder.append("&skip_dup=1");
      }
      if (paramBoolean) {
        localStringBuilder.append("&debug=1");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("engine.mobileapptracking.com");
    }
  }
  
  /* Error */
  private static void safeAppend(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +53 -> 57
    //   7: aload_2
    //   8: ldc_w 682
    //   11: invokevirtual 550	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +41 -> 57
    //   19: aload_0
    //   20: new 55	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 684
    //   27: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 686
    //   37: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_2
    //   41: ldc_w 688
    //   44: invokestatic 694	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: astore_0
    //   62: ldc 32
    //   64: new 55	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 696
    //   71: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 698
    //   81: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 701	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_0
    //   96: invokevirtual 702	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   99: goto -42 -> 57
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramStringBuilder	StringBuilder
    //   0	108	1	paramString1	String
    //   0	108	2	paramString2	String
    //   14	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	57	61	java/io/UnsupportedEncodingException
    //   7	15	102	finally
    //   19	57	102	finally
    //   62	99	102	finally
  }
  
  public static String updateAndEncryptData(String paramString, MATEncryption paramMATEncryption)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      params = MATParameters.getInstance();
      if (params != null)
      {
        String str = params.getGoogleAdvertisingId();
        if ((str != null) && (!paramString.contains("&google_aid=")))
        {
          safeAppend(localStringBuilder, "google_aid", str);
          safeAppend(localStringBuilder, "google_ad_tracking_disabled", params.getGoogleAdTrackingLimited());
        }
        str = params.getAndroidId();
        if ((str != null) && (!paramString.contains("&android_id="))) {
          safeAppend(localStringBuilder, "android_id", str);
        }
        str = params.getInstallReferrer();
        if ((str != null) && (!paramString.contains("&install_referrer="))) {
          safeAppend(localStringBuilder, "install_referrer", str);
        }
        str = params.getReferralSource();
        if ((str != null) && (!paramString.contains("&referral_source="))) {
          safeAppend(localStringBuilder, "referral_source", str);
        }
        str = params.getReferralUrl();
        if ((str != null) && (!paramString.contains("&referral_url="))) {
          safeAppend(localStringBuilder, "referral_url", str);
        }
        str = params.getUserAgent();
        if ((str != null) && (!paramString.contains("&conversion_user_agent="))) {
          safeAppend(localStringBuilder, "conversion_user_agent", str);
        }
        str = params.getFacebookUserId();
        if ((str != null) && (!paramString.contains("&facebook_user_id="))) {
          safeAppend(localStringBuilder, "facebook_user_id", str);
        }
      }
      if (!paramString.contains("&system_date=")) {
        safeAppend(localStringBuilder, "system_date", Long.toString(new Date().getTime() / 1000L));
      }
      paramString = localStringBuilder.toString();
      try
      {
        paramMATEncryption = MATUtils.bytesToHex(paramMATEncryption.encrypt(paramString));
        paramString = paramMATEncryption;
      }
      catch (Exception paramMATEncryption)
      {
        for (;;)
        {
          paramMATEncryption.printStackTrace();
        }
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATUrlBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */