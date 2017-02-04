package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzhd
{
  private static final SimpleDateFormat zzHU = new SimpleDateFormat("yyyyMMdd", Locale.US);
  
  private static String zzL(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  public static AdResponseParcel zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    JSONObject localJSONObject;
    String str1;
    String str2;
    String str3;
    boolean bool1;
    long l2;
    String str4;
    long l1;
    label107:
    Object localObject1;
    int i;
    label247:
    Object localObject2;
    label285:
    int j;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str1 = localJSONObject.optString("ad_base_url", null);
        str2 = localJSONObject.optString("ad_url", null);
        str3 = localJSONObject.optString("ad_size", null);
        if ((paramAdRequestInfoParcel == null) || (paramAdRequestInfoParcel.zzGw == 0)) {
          break label858;
        }
        bool1 = true;
        if (bool1)
        {
          paramString = localJSONObject.optString("ad_json", null);
          l2 = -1L;
          str4 = localJSONObject.optString("debug_dialog", null);
          if (!localJSONObject.has("interstitial_timeout")) {
            break label864;
          }
          l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
          localObject1 = localJSONObject.optString("orientation", null);
          i = -1;
          if ("portrait".equals(localObject1))
          {
            i = zzp.zzbz().zzhe();
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            if (!TextUtils.isEmpty(str1)) {
              break label849;
            }
            zzb.zzaH("Could not parse the mediation config: Missing required ad_base_url field");
            return new AdResponseParcel(0);
          }
        }
        else
        {
          paramString = localJSONObject.optString("ad_html", null);
          continue;
        }
        if (!"landscape".equals(localObject1)) {
          continue;
        }
        i = zzp.zzbz().zzhd();
        continue;
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = zzhc.zza(paramAdRequestInfoParcel, paramContext, paramAdRequestInfoParcel.zzqR.afmaVersion, str2, null, null, null, null, null);
          str1 = ((AdResponseParcel)localObject1).zzDE;
          str2 = ((AdResponseParcel)localObject1).body;
          l2 = ((AdResponseParcel)localObject1).zzGR;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 != null) {
            break label417;
          }
          paramContext = null;
          if (localObject2 == null) {
            break;
          }
          paramString = paramContext;
          if (paramContext != null) {
            break label872;
          }
          paramString = new LinkedList();
          break label872;
          if (j >= ((JSONArray)localObject2).length()) {
            break label878;
          }
          paramString.add(((JSONArray)localObject2).getString(j));
          j += 1;
          continue;
        }
        paramAdRequestInfoParcel = new StringBuilder().append("Could not parse the mediation config: Missing required ");
        if (bool1)
        {
          paramContext = "ad_json";
          zzb.zzaH(paramContext + " or " + "ad_url" + " field.");
          paramContext = new AdResponseParcel(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        zzb.zzaH("Could not parse the mediation config: " + paramContext.getMessage());
        return new AdResponseParcel(0);
      }
      paramContext = "ad_html";
      continue;
      label417:
      paramContext = ((AdResponseParcel)localObject1).zzAQ;
    }
    label426:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    label464:
    label506:
    Object localObject4;
    while (localObject3 != null)
    {
      paramString = paramContext;
      if (paramContext != null) {
        break label884;
      }
      paramString = new LinkedList();
      break label884;
      while (j < ((JSONArray)localObject3).length())
      {
        paramString.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((AdResponseParcel)localObject1).zzAR;
      continue;
      localObject4 = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localObject4 != null; paramContext = ((AdResponseParcel)localObject1).zzGP)
      {
        paramString = paramContext;
        if (paramContext != null) {
          break label896;
        }
        paramString = new LinkedList();
        break label896;
        label544:
        while (j < ((JSONArray)localObject4).length())
        {
          paramString.add(((JSONArray)localObject4).getString(j));
          j += 1;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (localObject1 != null)
      {
        if (((AdResponseParcel)localObject1).orientation != -1) {
          i = ((AdResponseParcel)localObject1).orientation;
        }
        j = i;
        if (((AdResponseParcel)localObject1).zzGM > 0L) {
          l1 = ((AdResponseParcel)localObject1).zzGM;
        }
      }
      for (;;)
      {
        localObject1 = localJSONObject.optString("active_view");
        paramString = null;
        boolean bool2 = localJSONObject.optBoolean("ad_is_javascript", false);
        if (bool2) {
          paramString = localJSONObject.optString("ad_passback_url", null);
        }
        boolean bool3 = localJSONObject.optBoolean("mediation", false);
        boolean bool4 = localJSONObject.optBoolean("custom_render_allowed", false);
        boolean bool5 = localJSONObject.optBoolean("content_url_opted_out", true);
        boolean bool6 = localJSONObject.optBoolean("prefetch", false);
        j = localJSONObject.optInt("oauth2_token_status", 0);
        long l3 = localJSONObject.optLong("refresh_interval_milliseconds", -1L);
        long l4 = localJSONObject.optLong("mediation_config_cache_time_milliseconds", -1L);
        localObject4 = localJSONObject.optString("gws_query_id", "");
        boolean bool7 = "height".equals(localJSONObject.optString("fluid", ""));
        paramContext = new AdResponseParcel(paramAdRequestInfoParcel, str1, str2, (List)localObject2, (List)localObject3, l1, bool3, l4, paramContext, l3, i, str3, l2, str4, bool2, paramString, (String)localObject1, bool4, bool1, paramAdRequestInfoParcel.zzGy, bool5, bool6, j, (String)localObject4, bool7);
        return paramContext;
        i = j;
      }
      continue;
      localObject3 = paramContext;
      break label506;
      localObject2 = paramContext;
      break label426;
      label849:
      localObject1 = null;
      str2 = paramString;
      break label247;
      label858:
      bool1 = false;
      break;
      label864:
      l1 = -1L;
      break label107;
      label872:
      j = 0;
      break label285;
      label878:
      localObject2 = paramString;
      break label426;
      label884:
      j = 0;
      break label464;
      localObject3 = paramString;
      break label506;
      label896:
      j = 0;
      break label544;
      paramContext = paramString;
    }
  }
  
  /* Error */
  public static JSONObject zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzhi paramzzhi, zzhm.zza paramzza, Location paramLocation, zzbs paramzzbs, String paramString1, String paramString2, List<String> paramList, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 273	java/util/HashMap
    //   3: dup
    //   4: invokespecial 274	java/util/HashMap:<init>	()V
    //   7: astore_0
    //   8: aload 8
    //   10: invokeinterface 277 1 0
    //   15: ifle +19 -> 34
    //   18: aload_0
    //   19: ldc_w 279
    //   22: ldc_w 281
    //   25: aload 8
    //   27: invokestatic 285	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   30: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload_1
    //   35: getfield 293	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGp	Landroid/os/Bundle;
    //   38: ifnull +15 -> 53
    //   41: aload_0
    //   42: ldc_w 295
    //   45: aload_1
    //   46: getfield 293	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGp	Landroid/os/Bundle;
    //   49: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_0
    //   54: aload_1
    //   55: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   58: invokestatic 302	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Lcom/google/android/gms/ads/internal/client/AdRequestParcel;)V
    //   61: aload_0
    //   62: ldc_w 303
    //   65: aload_1
    //   66: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   69: getfield 312	com/google/android/gms/ads/internal/client/AdSizeParcel:zztV	Ljava/lang/String;
    //   72: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: aload_1
    //   77: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   80: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   83: iconst_m1
    //   84: if_icmpne +14 -> 98
    //   87: aload_0
    //   88: ldc_w 317
    //   91: ldc_w 319
    //   94: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_1
    //   99: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   102: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   105: bipush -2
    //   107: if_icmpne +14 -> 121
    //   110: aload_0
    //   111: ldc_w 323
    //   114: ldc_w 325
    //   117: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_1
    //   122: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   125: getfield 328	com/google/android/gms/ads/internal/client/AdSizeParcel:zztZ	Z
    //   128: ifeq +14 -> 142
    //   131: aload_0
    //   132: ldc_w 263
    //   135: ldc_w 261
    //   138: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: aload_1
    //   143: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   146: getfield 332	com/google/android/gms/ads/internal/client/AdSizeParcel:zztX	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   149: ifnull +171 -> 320
    //   152: new 181	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   159: astore 4
    //   161: aload_1
    //   162: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   165: getfield 332	com/google/android/gms/ads/internal/client/AdSizeParcel:zztX	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   168: astore 5
    //   170: aload 5
    //   172: arraylength
    //   173: istore 12
    //   175: iconst_0
    //   176: istore 10
    //   178: iload 10
    //   180: iload 12
    //   182: if_icmpge +128 -> 310
    //   185: aload 5
    //   187: iload 10
    //   189: aaload
    //   190: astore 8
    //   192: aload 4
    //   194: invokevirtual 333	java/lang/StringBuilder:length	()I
    //   197: ifeq +12 -> 209
    //   200: aload 4
    //   202: ldc_w 335
    //   205: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 8
    //   211: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   214: iconst_m1
    //   215: if_icmpne +75 -> 290
    //   218: aload 8
    //   220: getfield 338	com/google/android/gms/ads/internal/client/AdSizeParcel:widthPixels	I
    //   223: i2f
    //   224: aload_2
    //   225: getfield 344	com/google/android/gms/internal/zzhi:zzGC	F
    //   228: fdiv
    //   229: f2i
    //   230: istore 11
    //   232: aload 4
    //   234: iload 11
    //   236: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: ldc_w 349
    //   245: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 8
    //   251: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   254: bipush -2
    //   256: if_icmpne +44 -> 300
    //   259: aload 8
    //   261: getfield 352	com/google/android/gms/ads/internal/client/AdSizeParcel:heightPixels	I
    //   264: i2f
    //   265: aload_2
    //   266: getfield 344	com/google/android/gms/internal/zzhi:zzGC	F
    //   269: fdiv
    //   270: f2i
    //   271: istore 11
    //   273: aload 4
    //   275: iload 11
    //   277: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: iload 10
    //   283: iconst_1
    //   284: iadd
    //   285: istore 10
    //   287: goto -109 -> 178
    //   290: aload 8
    //   292: getfield 315	com/google/android/gms/ads/internal/client/AdSizeParcel:width	I
    //   295: istore 11
    //   297: goto -65 -> 232
    //   300: aload 8
    //   302: getfield 321	com/google/android/gms/ads/internal/client/AdSizeParcel:height	I
    //   305: istore 11
    //   307: goto -34 -> 273
    //   310: aload_0
    //   311: ldc_w 354
    //   314: aload 4
    //   316: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: aload_1
    //   321: getfield 68	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGw	I
    //   324: ifeq +79 -> 403
    //   327: aload_0
    //   328: ldc_w 356
    //   331: aload_1
    //   332: getfield 68	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGw	I
    //   335: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload_1
    //   343: getfield 307	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqV	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   346: getfield 359	com/google/android/gms/ads/internal/client/AdSizeParcel:zzua	Z
    //   349: ifne +54 -> 403
    //   352: aload_0
    //   353: ldc_w 361
    //   356: aload_1
    //   357: getfield 364	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzrl	Ljava/util/List;
    //   360: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_0
    //   365: ldc_w 366
    //   368: aload_1
    //   369: getfield 370	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzrj	Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;
    //   372: invokestatic 374	com/google/android/gms/internal/zzhd:zzc	(Lcom/google/android/gms/ads/internal/formats/NativeAdOptionsParcel;)Ljava/lang/String;
    //   375: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload_1
    //   380: getfield 377	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGH	Ljava/util/List;
    //   383: invokeinterface 380 1 0
    //   388: ifne +15 -> 403
    //   391: aload_0
    //   392: ldc_w 382
    //   395: aload_1
    //   396: getfield 377	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGH	Ljava/util/List;
    //   399: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload_0
    //   404: ldc_w 384
    //   407: aload_1
    //   408: getfield 387	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqP	Ljava/lang/String;
    //   411: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   414: pop
    //   415: aload_0
    //   416: ldc_w 389
    //   419: aload_1
    //   420: getfield 393	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   423: getfield 398	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   426: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   429: pop
    //   430: aload_1
    //   431: getfield 402	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   434: ifnull +21 -> 455
    //   437: aload_0
    //   438: ldc_w 404
    //   441: aload_1
    //   442: getfield 402	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGr	Landroid/content/pm/PackageInfo;
    //   445: getfield 409	android/content/pm/PackageInfo:versionCode	I
    //   448: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: pop
    //   455: aload_0
    //   456: ldc_w 411
    //   459: aload 7
    //   461: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   464: pop
    //   465: aload_0
    //   466: ldc_w 413
    //   469: aload_1
    //   470: getfield 416	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGt	Ljava/lang/String;
    //   473: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: aload_0
    //   478: ldc_w 418
    //   481: aload_1
    //   482: getfield 421	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGu	Ljava/lang/String;
    //   485: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: pop
    //   489: aload_0
    //   490: ldc_w 423
    //   493: aload_1
    //   494: getfield 135	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzqR	Lcom/google/android/gms/ads/internal/util/client/VersionInfoParcel;
    //   497: getfield 141	com/google/android/gms/ads/internal/util/client/VersionInfoParcel:afmaVersion	Ljava/lang/String;
    //   500: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   503: pop
    //   504: aload_0
    //   505: aload_2
    //   506: aload_3
    //   507: invokestatic 426	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Lcom/google/android/gms/internal/zzhi;Lcom/google/android/gms/internal/zzhm$zza;)V
    //   510: aload_0
    //   511: ldc_w 428
    //   514: getstatic 433	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   517: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: aload_0
    //   522: ldc_w 435
    //   525: getstatic 438	android/os/Build:MODEL	Ljava/lang/String;
    //   528: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   531: pop
    //   532: aload_1
    //   533: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   536: getfield 441	com/google/android/gms/ads/internal/client/AdRequestParcel:versionCode	I
    //   539: iconst_2
    //   540: if_icmplt +24 -> 564
    //   543: aload_1
    //   544: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   547: getfield 445	com/google/android/gms/ads/internal/client/AdRequestParcel:zzty	Landroid/location/Location;
    //   550: ifnull +14 -> 564
    //   553: aload_0
    //   554: aload_1
    //   555: getfield 299	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGq	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   558: getfield 445	com/google/android/gms/ads/internal/client/AdRequestParcel:zzty	Landroid/location/Location;
    //   561: invokestatic 448	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Landroid/location/Location;)V
    //   564: aload_1
    //   565: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   568: iconst_2
    //   569: if_icmplt +15 -> 584
    //   572: aload_0
    //   573: ldc_w 451
    //   576: aload_1
    //   577: getfield 454	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGv	Landroid/os/Bundle;
    //   580: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   583: pop
    //   584: aload_1
    //   585: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   588: iconst_4
    //   589: if_icmplt +25 -> 614
    //   592: aload_1
    //   593: getfield 267	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGy	Z
    //   596: ifeq +18 -> 614
    //   599: aload_0
    //   600: ldc_w 456
    //   603: aload_1
    //   604: getfield 267	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGy	Z
    //   607: invokestatic 461	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   610: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   613: pop
    //   614: aload 9
    //   616: ifnull +13 -> 629
    //   619: aload_0
    //   620: ldc_w 463
    //   623: aload 9
    //   625: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   628: pop
    //   629: aload_1
    //   630: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   633: iconst_5
    //   634: if_icmplt +244 -> 878
    //   637: aload_0
    //   638: ldc_w 465
    //   641: aload_1
    //   642: getfield 466	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGC	F
    //   645: invokestatic 471	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   648: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   651: pop
    //   652: aload_0
    //   653: ldc_w 473
    //   656: aload_1
    //   657: getfield 476	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGB	I
    //   660: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   663: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload_0
    //   668: ldc_w 478
    //   671: aload_1
    //   672: getfield 481	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGA	I
    //   675: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   678: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   681: pop
    //   682: aload_1
    //   683: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   686: bipush 6
    //   688: if_icmplt +51 -> 739
    //   691: aload_1
    //   692: getfield 484	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGD	Ljava/lang/String;
    //   695: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: istore 13
    //   700: iload 13
    //   702: ifne +22 -> 724
    //   705: aload_0
    //   706: ldc_w 486
    //   709: new 49	org/json/JSONObject
    //   712: dup
    //   713: aload_1
    //   714: getfield 484	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGD	Ljava/lang/String;
    //   717: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   720: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   723: pop
    //   724: aload_0
    //   725: ldc_w 488
    //   728: aload_1
    //   729: getfield 491	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGE	J
    //   732: invokestatic 496	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   735: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   738: pop
    //   739: aload_1
    //   740: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   743: bipush 7
    //   745: if_icmplt +15 -> 760
    //   748: aload_0
    //   749: ldc_w 498
    //   752: aload_1
    //   753: getfield 501	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGF	Ljava/lang/String;
    //   756: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   759: pop
    //   760: aload_1
    //   761: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   764: bipush 11
    //   766: if_icmplt +25 -> 791
    //   769: aload_1
    //   770: getfield 505	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGJ	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   773: ifnull +18 -> 791
    //   776: aload_0
    //   777: ldc_w 507
    //   780: aload_1
    //   781: getfield 505	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGJ	Lcom/google/android/gms/ads/internal/request/CapabilityParcel;
    //   784: invokevirtual 513	com/google/android/gms/ads/internal/request/CapabilityParcel:toBundle	()Landroid/os/Bundle;
    //   787: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   790: pop
    //   791: aload_0
    //   792: aload 6
    //   794: invokestatic 516	com/google/android/gms/internal/zzhd:zza	(Ljava/util/HashMap;Ljava/lang/String;)V
    //   797: aload_1
    //   798: getfield 449	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:versionCode	I
    //   801: bipush 12
    //   803: if_icmplt +25 -> 828
    //   806: aload_1
    //   807: getfield 519	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGK	Ljava/lang/String;
    //   810: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   813: ifne +15 -> 828
    //   816: aload_0
    //   817: ldc_w 521
    //   820: aload_1
    //   821: getfield 519	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:zzGK	Ljava/lang/String;
    //   824: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   827: pop
    //   828: iconst_2
    //   829: invokestatic 525	com/google/android/gms/ads/internal/util/client/zzb:zzQ	(I)Z
    //   832: ifeq +38 -> 870
    //   835: invokestatic 529	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   838: aload_0
    //   839: invokevirtual 535	com/google/android/gms/internal/zzip:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   842: iconst_2
    //   843: invokevirtual 537	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   846: astore_1
    //   847: new 181	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 539
    //   857: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload_1
    //   861: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 542	com/google/android/gms/ads/internal/util/client/zzb:v	(Ljava/lang/String;)V
    //   870: invokestatic 529	com/google/android/gms/ads/internal/zzp:zzbx	()Lcom/google/android/gms/internal/zzip;
    //   873: aload_0
    //   874: invokevirtual 535	com/google/android/gms/internal/zzip:zzz	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   877: areturn
    //   878: aload_0
    //   879: ldc_w 465
    //   882: aload_2
    //   883: getfield 344	com/google/android/gms/internal/zzhi:zzGC	F
    //   886: invokestatic 471	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   889: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   892: pop
    //   893: aload_0
    //   894: ldc_w 473
    //   897: aload_2
    //   898: getfield 543	com/google/android/gms/internal/zzhi:zzGB	I
    //   901: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   904: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   907: pop
    //   908: aload_0
    //   909: ldc_w 478
    //   912: aload_2
    //   913: getfield 544	com/google/android/gms/internal/zzhi:zzGA	I
    //   916: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   919: invokevirtual 289	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   922: pop
    //   923: goto -241 -> 682
    //   926: astore_0
    //   927: new 181	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 546
    //   937: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload_0
    //   941: invokevirtual 201	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   944: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 119	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   953: aconst_null
    //   954: areturn
    //   955: astore_2
    //   956: ldc_w 548
    //   959: aload_2
    //   960: invokestatic 552	com/google/android/gms/ads/internal/util/client/zzb:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   963: goto -239 -> 724
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	966	0	paramContext	Context
    //   0	966	1	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	966	2	paramzzhi	zzhi
    //   0	966	3	paramzza	zzhm.zza
    //   0	966	4	paramLocation	Location
    //   0	966	5	paramzzbs	zzbs
    //   0	966	6	paramString1	String
    //   0	966	7	paramString2	String
    //   0	966	8	paramList	List<String>
    //   0	966	9	paramBundle	Bundle
    //   176	110	10	i	int
    //   230	76	11	j	int
    //   173	10	12	k	int
    //   698	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	34	926	org/json/JSONException
    //   34	53	926	org/json/JSONException
    //   53	98	926	org/json/JSONException
    //   98	121	926	org/json/JSONException
    //   121	142	926	org/json/JSONException
    //   142	175	926	org/json/JSONException
    //   192	209	926	org/json/JSONException
    //   209	232	926	org/json/JSONException
    //   232	273	926	org/json/JSONException
    //   273	281	926	org/json/JSONException
    //   290	297	926	org/json/JSONException
    //   300	307	926	org/json/JSONException
    //   310	320	926	org/json/JSONException
    //   320	403	926	org/json/JSONException
    //   403	455	926	org/json/JSONException
    //   455	564	926	org/json/JSONException
    //   564	584	926	org/json/JSONException
    //   584	614	926	org/json/JSONException
    //   619	629	926	org/json/JSONException
    //   629	682	926	org/json/JSONException
    //   682	700	926	org/json/JSONException
    //   724	739	926	org/json/JSONException
    //   739	760	926	org/json/JSONException
    //   760	791	926	org/json/JSONException
    //   791	828	926	org/json/JSONException
    //   828	870	926	org/json/JSONException
    //   870	878	926	org/json/JSONException
    //   878	923	926	org/json/JSONException
    //   956	963	926	org/json/JSONException
    //   705	724	955	org/json/JSONException
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    float f = paramLocation.getAccuracy();
    long l1 = paramLocation.getTime();
    long l2 = (paramLocation.getLatitude() * 1.0E7D);
    long l3 = (paramLocation.getLongitude() * 1.0E7D);
    localHashMap.put("radius", Float.valueOf(f * 1000.0F));
    localHashMap.put("lat", Long.valueOf(l2));
    localHashMap.put("long", Long.valueOf(l3));
    localHashMap.put("time", Long.valueOf(l1 * 1000L));
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, AdRequestParcel paramAdRequestParcel)
  {
    String str = zzik.zzgW();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramAdRequestParcel.zztq != -1L) {
      paramHashMap.put("cust_age", zzHU.format(new Date(paramAdRequestParcel.zztq)));
    }
    if (paramAdRequestParcel.extras != null) {
      paramHashMap.put("extras", paramAdRequestParcel.extras);
    }
    if (paramAdRequestParcel.zztr != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramAdRequestParcel.zztr));
    }
    if (paramAdRequestParcel.zzts != null) {
      paramHashMap.put("kw", paramAdRequestParcel.zzts);
    }
    if (paramAdRequestParcel.zztu != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramAdRequestParcel.zztu));
    }
    if (paramAdRequestParcel.zztt) {
      paramHashMap.put("adtest", "on");
    }
    if (paramAdRequestParcel.versionCode >= 2)
    {
      if (paramAdRequestParcel.zztv) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramAdRequestParcel.zztw)) {
        paramHashMap.put("ppid", paramAdRequestParcel.zztw);
      }
      if (paramAdRequestParcel.zztx != null) {
        zza(paramHashMap, paramAdRequestParcel.zztx);
      }
    }
    if ((paramAdRequestParcel.versionCode >= 3) && (paramAdRequestParcel.zztz != null)) {
      paramHashMap.put("url", paramAdRequestParcel.zztz);
    }
    if (paramAdRequestParcel.versionCode >= 5)
    {
      if (paramAdRequestParcel.zztB != null) {
        paramHashMap.put("custom_targeting", paramAdRequestParcel.zztB);
      }
      if (paramAdRequestParcel.zztC != null) {
        paramHashMap.put("category_exclusions", paramAdRequestParcel.zztC);
      }
      if (paramAdRequestParcel.zztD != null) {
        paramHashMap.put("request_agent", paramAdRequestParcel.zztD);
      }
    }
    if ((paramAdRequestParcel.versionCode >= 6) && (paramAdRequestParcel.zztE != null)) {
      paramHashMap.put("request_pkg", paramAdRequestParcel.zztE);
    }
    if (paramAdRequestParcel.versionCode >= 7) {
      paramHashMap.put("is_designed_for_families", Boolean.valueOf(paramAdRequestParcel.zztF));
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, SearchAdRequestParcel paramSearchAdRequestParcel)
  {
    Object localObject2 = null;
    if (Color.alpha(paramSearchAdRequestParcel.zzuI) != 0) {
      paramHashMap.put("acolor", zzL(paramSearchAdRequestParcel.zzuI));
    }
    if (Color.alpha(paramSearchAdRequestParcel.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", zzL(paramSearchAdRequestParcel.backgroundColor));
    }
    if ((Color.alpha(paramSearchAdRequestParcel.zzuJ) != 0) && (Color.alpha(paramSearchAdRequestParcel.zzuK) != 0))
    {
      paramHashMap.put("gradientto", zzL(paramSearchAdRequestParcel.zzuJ));
      paramHashMap.put("gradientfrom", zzL(paramSearchAdRequestParcel.zzuK));
    }
    if (Color.alpha(paramSearchAdRequestParcel.zzuL) != 0) {
      paramHashMap.put("bcolor", zzL(paramSearchAdRequestParcel.zzuL));
    }
    paramHashMap.put("bthick", Integer.toString(paramSearchAdRequestParcel.zzuM));
    Object localObject1;
    switch (paramSearchAdRequestParcel.zzuN)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramSearchAdRequestParcel.zzuO)
      {
      default: 
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramHashMap.put("callbuttoncolor", localObject1);
      }
      if (paramSearchAdRequestParcel.zzuP != null) {
        paramHashMap.put("channel", paramSearchAdRequestParcel.zzuP);
      }
      if (Color.alpha(paramSearchAdRequestParcel.zzuQ) != 0) {
        paramHashMap.put("dcolor", zzL(paramSearchAdRequestParcel.zzuQ));
      }
      if (paramSearchAdRequestParcel.zzuR != null) {
        paramHashMap.put("font", paramSearchAdRequestParcel.zzuR);
      }
      if (Color.alpha(paramSearchAdRequestParcel.zzuS) != 0) {
        paramHashMap.put("hcolor", zzL(paramSearchAdRequestParcel.zzuS));
      }
      paramHashMap.put("headersize", Integer.toString(paramSearchAdRequestParcel.zzuT));
      if (paramSearchAdRequestParcel.zzuU != null) {
        paramHashMap.put("q", paramSearchAdRequestParcel.zzuU);
      }
      return;
      localObject1 = "none";
      break;
      localObject1 = "dashed";
      break;
      localObject1 = "dotted";
      break;
      localObject1 = "solid";
      break;
      localObject1 = "dark";
      continue;
      localObject1 = "light";
      continue;
      localObject1 = "medium";
    }
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, zzhi paramzzhi, zzhm.zza paramzza)
  {
    paramHashMap.put("am", Integer.valueOf(paramzzhi.zzIA));
    paramHashMap.put("cog", zzy(paramzzhi.zzIB));
    paramHashMap.put("coh", zzy(paramzzhi.zzIC));
    if (!TextUtils.isEmpty(paramzzhi.zzID)) {
      paramHashMap.put("carrier", paramzzhi.zzID);
    }
    paramHashMap.put("gl", paramzzhi.zzIE);
    if (paramzzhi.zzIF) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    if (paramzzhi.zzIG) {
      paramHashMap.put("is_sidewinder", Integer.valueOf(1));
    }
    paramHashMap.put("ma", zzy(paramzzhi.zzIH));
    paramHashMap.put("sp", zzy(paramzzhi.zzII));
    paramHashMap.put("hl", paramzzhi.zzIJ);
    if (!TextUtils.isEmpty(paramzzhi.zzIK)) {
      paramHashMap.put("mv", paramzzhi.zzIK);
    }
    paramHashMap.put("muv", Integer.valueOf(paramzzhi.zzIL));
    if (paramzzhi.zzIM != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramzzhi.zzIM));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramzzhi.zzIN));
    paramHashMap.put("pt", Integer.valueOf(paramzzhi.zzIO));
    paramHashMap.put("rm", Integer.valueOf(paramzzhi.zzIP));
    paramHashMap.put("riv", Integer.valueOf(paramzzhi.zzIQ));
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("build", paramzzhi.zzIV);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", paramzzhi.zzIS);
    localBundle2.putDouble("battery_level", paramzzhi.zzIR);
    localBundle1.putBundle("battery", localBundle2);
    localBundle2 = new Bundle();
    localBundle2.putInt("active_network_state", paramzzhi.zzIU);
    localBundle2.putBoolean("active_network_metered", paramzzhi.zzIT);
    if (paramzza != null)
    {
      paramzzhi = new Bundle();
      paramzzhi.putInt("predicted_latency_micros", paramzza.zzJa);
      paramzzhi.putLong("predicted_down_throughput_bps", paramzza.zzJb);
      paramzzhi.putLong("predicted_up_throughput_bps", paramzza.zzJc);
      localBundle2.putBundle("predictions", paramzzhi);
    }
    localBundle1.putBundle("network", localBundle2);
    paramHashMap.put("device", localBundle1);
  }
  
  private static void zza(HashMap<String, Object> paramHashMap, String paramString)
  {
    if (paramString != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", paramString);
      paramHashMap.put("pan", localHashMap);
    }
  }
  
  private static String zzc(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    if (paramNativeAdOptionsParcel != null) {}
    for (int i = paramNativeAdOptionsParcel.zzyd;; i = 0) {
      switch (i)
      {
      default: 
        return "any";
      }
    }
    return "portrait";
    return "landscape";
  }
  
  private static Integer zzy(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */