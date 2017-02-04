package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;

class m
{
  WebView a;
  Activity b;
  ADCVideo c;
  Handler d;
  Runnable e;
  AdColonyAd f;
  String g;
  
  public m(ADCVideo paramADCVideo, WebView paramWebView, Activity paramActivity)
  {
    this.a = paramWebView;
    this.b = paramActivity;
    this.c = paramADCVideo;
    this.d = new Handler();
    this.e = new Runnable()
    {
      public void run()
      {
        a.J = false;
      }
    };
  }
  
  void a()
  {
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    a.a("html5_interaction", this.g, this.c.I);
    String str = Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots/" + "AdColony_Screenshot_" + System.currentTimeMillis() + ".jpg";
    Object localObject2 = this.a.getRootView();
    ((View)localObject2).setDrawingCacheEnabled(true);
    Object localObject1 = Bitmap.createBitmap(((View)localObject2).getDrawingCache());
    ((View)localObject2).setDrawingCacheEnabled(false);
    localObject2 = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures");
    File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots");
    try
    {
      ((File)localObject2).mkdir();
      localFile.mkdir();
      localObject2 = new File(str);
      try
      {
        localObject2 = new FileOutputStream((File)localObject2);
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
        ((OutputStream)localObject2).flush();
        ((OutputStream)localObject2).close();
        localObject1 = this.b;
        localObject2 = new MediaScannerConnection.OnScanCompletedListener()
        {
          public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
          {
            if (Looper.myLooper() == null) {
              Looper.prepare();
            }
            Toast.makeText(m.this.b, "Screenshot saved to Gallery!", 0).show();
          }
        };
        MediaScannerConnection.scanFile((Context)localObject1, new String[] { str }, null, (MediaScannerConnection.OnScanCompletedListener)localObject2);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Toast.makeText(this.b, "Error saving screenshot.", 0).show();
        l.a.a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
        return;
      }
      catch (IOException localIOException)
      {
        Toast.makeText(this.b, "Error saving screenshot.", 0).show();
        l.a.a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void a(String paramString)
  {
    paramString = paramString.replace("mraid://", "");
    if (paramString.contains("?"))
    {
      arrayOfString = paramString.split("\\?");
      paramString = arrayOfString[0];
      if (arrayOfString == null) {
        break label110;
      }
    }
    HashMap localHashMap;
    label110:
    for (String[] arrayOfString = arrayOfString[1].split("&");; arrayOfString = new String[0])
    {
      localHashMap = new HashMap();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localHashMap.put(str.split("=")[0], str.split("=")[1]);
        i += 1;
      }
      arrayOfString = null;
      break;
    }
    this.f = a.T;
    this.g = ("{\"ad_slot\":" + a.l.e.j + "}");
    if (paramString.equals("send_adc_event")) {
      b((String)localHashMap.get("type"));
    }
    for (;;)
    {
      f("adc_bridge.nativeCallComplete()");
      return;
      if (paramString.equals("close")) {
        b();
      } else if ((paramString.equals("open_store")) && (!a.J)) {
        c((String)localHashMap.get("item"));
      } else if ((paramString.equals("open")) && (!a.J)) {
        d((String)localHashMap.get("url"));
      } else if (paramString.equals("expand")) {
        e((String)localHashMap.get("url"));
      } else if ((paramString.equals("create_calendar_event")) && (!a.J)) {
        c(localHashMap);
      } else if ((paramString.equals("mail")) && (!a.J)) {
        d(localHashMap);
      } else if ((paramString.equals("sms")) && (!a.J)) {
        e(localHashMap);
      } else if ((paramString.equals("tel")) && (!a.J)) {
        f(localHashMap);
      } else if (paramString.equals("custom_event")) {
        g(localHashMap);
      } else if ((paramString.equals("launch_app")) && (!a.J)) {
        h(localHashMap);
      } else if (paramString.equals("check_app_presence")) {
        i(localHashMap);
      } else if (paramString.equals("auto_play")) {
        j(localHashMap);
      } else if (paramString.equals("save_screenshot")) {
        a();
      } else if ((paramString.equals("social_post")) && (!a.J)) {
        b(localHashMap);
      } else if ((paramString.equals("make_in_app_purchase")) && (!a.J)) {
        a(localHashMap);
      }
    }
  }
  
  void a(HashMap paramHashMap)
  {
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    a.a("html5_interaction", this.g, this.c.I);
    String str = g((String)paramHashMap.get("product"));
    Integer.parseInt(g((String)paramHashMap.get("quantity")));
    this.b.finish();
    this.c.I.n = str;
    this.c.I.A = AdColonyIAPEngagement.END_CARD;
    a.W.a(this.c.I);
  }
  
  void b()
  {
    l.a.b("ADC [info] MRAIDCommandClose called");
    this.b.finish();
    a.W.a(this.c.I);
  }
  
  void b(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandSendADCEvent called with type: ").b(paramString);
    a.a(paramString, this.c.I);
  }
  
  void b(HashMap paramHashMap)
  {
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    String str = g((String)paramHashMap.get("text"));
    paramHashMap = g((String)paramHashMap.get("url"));
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", str + " " + paramHashMap);
    this.b.startActivity(Intent.createChooser(localIntent, "Share this post using..."));
  }
  
  void c(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandOpenStore called with item: ").b(paramString);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    a.a("html5_interaction", this.g, this.c.I);
    paramString = g(paramString);
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      this.b.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(this.b, "Unable to open store.", 0).show();
    }
  }
  
  /* Error */
  void c(HashMap paramHashMap)
  {
    // Byte code:
    //   0: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   3: ldc_w 437
    //   6: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   9: aload_1
    //   10: invokevirtual 384	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   13: pop
    //   14: iconst_1
    //   15: putstatic 56	com/jirbo/adcolony/a:J	Z
    //   18: aload_0
    //   19: getfield 38	com/jirbo/adcolony/m:d	Landroid/os/Handler;
    //   22: aload_0
    //   23: getfield 43	com/jirbo/adcolony/m:e	Ljava/lang/Runnable;
    //   26: ldc2_w 57
    //   29: invokevirtual 62	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   32: pop
    //   33: ldc 64
    //   35: aload_0
    //   36: getfield 66	com/jirbo/adcolony/m:g	Ljava/lang/String;
    //   39: aload_0
    //   40: getfield 33	com/jirbo/adcolony/m:c	Lcom/jirbo/adcolony/ADCVideo;
    //   43: getfield 71	com/jirbo/adcolony/ADCVideo:I	Lcom/jirbo/adcolony/AdColonyAd;
    //   46: invokestatic 74	com/jirbo/adcolony/a:a	(Ljava/lang/String;Ljava/lang/String;Lcom/jirbo/adcolony/AdColonyAd;)V
    //   49: new 439	java/text/SimpleDateFormat
    //   52: dup
    //   53: ldc_w 441
    //   56: invokespecial 442	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   59: astore 19
    //   61: new 439	java/text/SimpleDateFormat
    //   64: dup
    //   65: ldc_w 444
    //   68: invokespecial 442	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   71: astore 15
    //   73: new 439	java/text/SimpleDateFormat
    //   76: dup
    //   77: ldc_w 446
    //   80: invokespecial 442	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   83: astore 18
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 448
    //   90: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 168	java/lang/String
    //   96: checkcast 168	java/lang/String
    //   99: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 16
    //   104: aload_0
    //   105: aload_1
    //   106: ldc_w 450
    //   109: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 168	java/lang/String
    //   115: checkcast 168	java/lang/String
    //   118: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   121: pop
    //   122: aload_0
    //   123: aload_1
    //   124: ldc_w 452
    //   127: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 168	java/lang/String
    //   133: checkcast 168	java/lang/String
    //   136: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 14
    //   141: aload_0
    //   142: aload_1
    //   143: ldc_w 454
    //   146: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 168	java/lang/String
    //   152: checkcast 168	java/lang/String
    //   155: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 20
    //   160: aload_0
    //   161: aload_1
    //   162: ldc_w 456
    //   165: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 168	java/lang/String
    //   171: checkcast 168	java/lang/String
    //   174: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 10
    //   179: aload_0
    //   180: aload_1
    //   181: ldc_w 458
    //   184: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 168	java/lang/String
    //   190: checkcast 168	java/lang/String
    //   193: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 17
    //   198: ldc -55
    //   200: astore 12
    //   202: ldc -55
    //   204: astore 11
    //   206: new 221	java/util/HashMap
    //   209: dup
    //   210: invokespecial 222	java/util/HashMap:<init>	()V
    //   213: astore 13
    //   215: aload 17
    //   217: ldc_w 460
    //   220: ldc -55
    //   222: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   225: ldc_w 462
    //   228: ldc -55
    //   230: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   233: ldc -2
    //   235: ldc -55
    //   237: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   240: astore 17
    //   242: aload 17
    //   244: ldc -55
    //   246: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifne +165 -> 414
    //   252: aload 17
    //   254: ldc_w 464
    //   257: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   260: astore 11
    //   262: aload 11
    //   264: arraylength
    //   265: istore_3
    //   266: iconst_0
    //   267: istore_2
    //   268: iload_2
    //   269: iload_3
    //   270: if_icmpge +56 -> 326
    //   273: aload 11
    //   275: iload_2
    //   276: aaload
    //   277: astore 12
    //   279: aload 13
    //   281: aload 12
    //   283: iconst_0
    //   284: aload 12
    //   286: ldc_w 466
    //   289: invokevirtual 469	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   292: invokevirtual 473	java/lang/String:substring	(II)Ljava/lang/String;
    //   295: aload 12
    //   297: aload 12
    //   299: ldc_w 466
    //   302: invokevirtual 469	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   305: iconst_1
    //   306: iadd
    //   307: aload 12
    //   309: invokevirtual 477	java/lang/String:length	()I
    //   312: invokevirtual 473	java/lang/String:substring	(II)Ljava/lang/String;
    //   315: invokevirtual 228	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   318: pop
    //   319: iload_2
    //   320: iconst_1
    //   321: iadd
    //   322: istore_2
    //   323: goto -55 -> 268
    //   326: aload_0
    //   327: aload 13
    //   329: ldc_w 479
    //   332: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   335: checkcast 168	java/lang/String
    //   338: checkcast 168	java/lang/String
    //   341: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   344: astore 12
    //   346: aload_0
    //   347: aload 13
    //   349: ldc_w 481
    //   352: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 168	java/lang/String
    //   358: checkcast 168	java/lang/String
    //   361: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   364: invokevirtual 484	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   367: astore 11
    //   369: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   372: ldc_w 486
    //   375: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   378: aload 17
    //   380: invokevirtual 384	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   383: pop
    //   384: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   387: ldc_w 488
    //   390: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   393: aload 11
    //   395: invokevirtual 384	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   398: pop
    //   399: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   402: ldc_w 490
    //   405: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   408: aload 12
    //   410: invokevirtual 384	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   413: pop
    //   414: aload 10
    //   416: astore 13
    //   418: aload 10
    //   420: ldc -55
    //   422: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   425: ifeq +22 -> 447
    //   428: aload_0
    //   429: aload_1
    //   430: ldc_w 448
    //   433: invokevirtual 266	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: checkcast 168	java/lang/String
    //   439: checkcast 168	java/lang/String
    //   442: invokevirtual 343	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 13
    //   447: aload 19
    //   449: aload 14
    //   451: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   454: astore_1
    //   455: aload 19
    //   457: aload 20
    //   459: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   462: astore 10
    //   464: aload_1
    //   465: ifnonnull +453 -> 918
    //   468: aload 15
    //   470: aload 14
    //   472: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   475: astore 14
    //   477: aload 14
    //   479: astore_1
    //   480: aload 15
    //   482: aload 20
    //   484: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   487: astore 15
    //   489: aload 15
    //   491: astore 10
    //   493: aload 14
    //   495: astore_1
    //   496: aload 10
    //   498: astore 14
    //   500: aload 19
    //   502: aload 12
    //   504: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   507: astore 10
    //   509: aload 10
    //   511: astore 15
    //   513: aload 10
    //   515: ifnonnull +12 -> 527
    //   518: aload 18
    //   520: aload 12
    //   522: invokevirtual 495	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   525: astore 15
    //   527: aload_1
    //   528: ifnonnull +44 -> 572
    //   531: aload_0
    //   532: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   535: ldc_w 497
    //   538: iconst_0
    //   539: invokestatic 182	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   542: invokevirtual 185	android/widget/Toast:show	()V
    //   545: return
    //   546: astore_1
    //   547: aconst_null
    //   548: astore_1
    //   549: aconst_null
    //   550: astore 10
    //   552: goto -88 -> 464
    //   555: astore 14
    //   557: aload 10
    //   559: astore 14
    //   561: goto -61 -> 500
    //   564: astore 10
    //   566: aconst_null
    //   567: astore 10
    //   569: goto -60 -> 509
    //   572: aload_1
    //   573: invokevirtual 502	java/util/Date:getTime	()J
    //   576: lstore 6
    //   578: aload 14
    //   580: invokevirtual 502	java/util/Date:getTime	()J
    //   583: lstore 8
    //   585: lconst_0
    //   586: lstore 4
    //   588: aload 15
    //   590: ifnull +19 -> 609
    //   593: aload 15
    //   595: invokevirtual 502	java/util/Date:getTime	()J
    //   598: aload_1
    //   599: invokevirtual 502	java/util/Date:getTime	()J
    //   602: lsub
    //   603: ldc2_w 57
    //   606: ldiv
    //   607: lstore 4
    //   609: aload 11
    //   611: ldc_w 504
    //   614: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   617: ifeq +157 -> 774
    //   620: lload 4
    //   622: ldc2_w 505
    //   625: ldiv
    //   626: lconst_1
    //   627: ladd
    //   628: lstore 4
    //   630: aload 17
    //   632: ldc -55
    //   634: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   637: ifne +209 -> 846
    //   640: new 393	android/content/Intent
    //   643: dup
    //   644: ldc_w 508
    //   647: invokespecial 396	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   650: ldc_w 510
    //   653: invokevirtual 402	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   656: ldc_w 512
    //   659: aload 13
    //   661: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   664: ldc_w 448
    //   667: aload 16
    //   669: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   672: ldc_w 514
    //   675: lload 6
    //   677: invokevirtual 517	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   680: ldc_w 519
    //   683: lload 8
    //   685: invokevirtual 517	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   688: ldc_w 521
    //   691: new 76	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 523
    //   701: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 11
    //   706: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 525
    //   712: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc_w 527
    //   718: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: lload 4
    //   723: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   726: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   732: astore_1
    //   733: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   736: ldc_w 529
    //   739: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   742: lload 4
    //   744: l2d
    //   745: invokevirtual 532	com/jirbo/adcolony/l:b	(D)Lcom/jirbo/adcolony/l;
    //   748: pop
    //   749: aload_0
    //   750: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   753: aload_1
    //   754: invokevirtual 420	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   757: return
    //   758: astore_1
    //   759: aload_0
    //   760: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   763: ldc_w 497
    //   766: iconst_0
    //   767: invokestatic 182	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   770: invokevirtual 185	android/widget/Toast:show	()V
    //   773: return
    //   774: aload 11
    //   776: ldc_w 534
    //   779: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   782: ifeq +16 -> 798
    //   785: lload 4
    //   787: ldc2_w 535
    //   790: ldiv
    //   791: lconst_1
    //   792: ladd
    //   793: lstore 4
    //   795: goto -165 -> 630
    //   798: aload 11
    //   800: ldc_w 538
    //   803: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifeq +16 -> 822
    //   809: lload 4
    //   811: ldc2_w 539
    //   814: ldiv
    //   815: lconst_1
    //   816: ladd
    //   817: lstore 4
    //   819: goto -189 -> 630
    //   822: aload 11
    //   824: ldc_w 542
    //   827: invokevirtual 260	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   830: ifeq +82 -> 912
    //   833: lload 4
    //   835: ldc2_w 543
    //   838: ldiv
    //   839: lconst_1
    //   840: ladd
    //   841: lstore 4
    //   843: goto -213 -> 630
    //   846: new 393	android/content/Intent
    //   849: dup
    //   850: ldc_w 508
    //   853: invokespecial 396	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   856: ldc_w 510
    //   859: invokevirtual 402	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   862: ldc_w 512
    //   865: aload 13
    //   867: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   870: ldc_w 448
    //   873: aload 16
    //   875: invokevirtual 410	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   878: ldc_w 514
    //   881: lload 6
    //   883: invokevirtual 517	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   886: ldc_w 519
    //   889: lload 8
    //   891: invokevirtual 517	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   894: astore_1
    //   895: goto -146 -> 749
    //   898: astore 12
    //   900: aload 10
    //   902: astore 15
    //   904: goto -377 -> 527
    //   907: astore 10
    //   909: goto -360 -> 549
    //   912: lconst_0
    //   913: lstore 4
    //   915: goto -285 -> 630
    //   918: aload 10
    //   920: astore 14
    //   922: goto -422 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	925	0	this	m
    //   0	925	1	paramHashMap	HashMap
    //   267	56	2	i	int
    //   265	6	3	j	int
    //   586	328	4	l1	long
    //   576	306	6	l2	long
    //   583	307	8	l3	long
    //   177	381	10	localObject1	Object
    //   564	1	10	localException1	Exception
    //   567	334	10	localObject2	Object
    //   907	12	10	localException2	Exception
    //   204	619	11	localObject3	Object
    //   200	321	12	str1	String
    //   898	1	12	localException3	Exception
    //   213	653	13	localObject4	Object
    //   139	360	14	localObject5	Object
    //   555	1	14	localException4	Exception
    //   559	362	14	localObject6	Object
    //   71	832	15	localObject7	Object
    //   102	772	16	str2	String
    //   196	435	17	str3	String
    //   83	436	18	localSimpleDateFormat1	java.text.SimpleDateFormat
    //   59	442	19	localSimpleDateFormat2	java.text.SimpleDateFormat
    //   158	325	20	str4	String
    // Exception table:
    //   from	to	target	type
    //   447	455	546	java/lang/Exception
    //   468	477	555	java/lang/Exception
    //   480	489	555	java/lang/Exception
    //   500	509	564	java/lang/Exception
    //   749	757	758	java/lang/Exception
    //   518	527	898	java/lang/Exception
    //   455	464	907	java/lang/Exception
  }
  
  void d(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandOpen called with url: ").b(paramString);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    Object localObject = g(paramString);
    if (((String)localObject).startsWith("adcvideo"))
    {
      paramString = ((String)localObject).replace("adcvideo", "http");
      this.c.a(paramString);
      return;
    }
    String str;
    if (paramString.contains("youtube")) {
      try
      {
        localObject = ((String)localObject).substring(((String)localObject).indexOf('v') + 2);
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + (String)localObject));
        this.b.startActivity((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        str = g(paramString);
        paramString = str;
        if (str.contains("safari")) {
          paramString = str.replace("safari", "http");
        }
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.b.startActivity(paramString);
        return;
      }
    }
    if (str.startsWith("browser"))
    {
      a.a("html5_interaction", this.c.I);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("browser", "http")));
      this.b.startActivity(paramString);
      return;
    }
    a.a("html5_interaction", this.g, this.c.I);
    AdColonyBrowser.url = str;
    paramString = new Intent(this.b, AdColonyBrowser.class);
    this.b.startActivity(paramString);
  }
  
  void d(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandMail called with parameters: ").b(paramHashMap);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    String str1 = g((String)paramHashMap.get("subject"));
    String str2 = g((String)paramHashMap.get("body"));
    paramHashMap = g((String)paramHashMap.get("to"));
    a.a("html5_interaction", this.g, this.c.I);
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.SUBJECT", str1).putExtra("android.intent.extra.TEXT", str2).putExtra("android.intent.extra.EMAIL", new String[] { paramHashMap });
      this.b.startActivity(localIntent);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.b, "Unable to launch email client.", 0).show();
    }
  }
  
  void e(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandExpand called with url: ").b(paramString);
    f("adc_bridge.fireChangeEvent({state:'expanded'});");
  }
  
  void e(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandSMS called with parameters: ").b(paramHashMap);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    String str = g((String)paramHashMap.get("to"));
    paramHashMap = g((String)paramHashMap.get("body"));
    a.a("html5_interaction", this.g, this.c.I);
    try
    {
      paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str)).putExtra("sms_body", paramHashMap);
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.b, "Failed to create sms.", 0).show();
    }
  }
  
  void f(String paramString)
  {
    this.a.loadUrl("javascript:" + paramString);
  }
  
  void f(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandTel called with parameters: ").b(paramHashMap);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    paramHashMap = g((String)paramHashMap.get("number"));
    a.a("html5_interaction", this.g, this.c.I);
    try
    {
      paramHashMap = new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + paramHashMap));
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.b, "Failed to dial number.", 0).show();
    }
  }
  
  String g(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return URLDecoder.decode(paramString);
  }
  
  void g(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").b(paramHashMap);
    paramHashMap = g((String)paramHashMap.get("event_type"));
    a.a("custom_event", "{\"event_type\":\"" + paramHashMap + "\",\"ad_slot\":" + a.l.e.j + "}", this.c.I);
  }
  
  void h(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").b(paramHashMap);
    a.J = true;
    this.d.postDelayed(this.e, 1000L);
    paramHashMap = g((String)paramHashMap.get("handle"));
    a.a("html5_interaction", this.g, this.c.I);
    try
    {
      paramHashMap = this.b.getPackageManager().getLaunchIntentForPackage(paramHashMap);
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.b, "Failed to launch external application.", 0).show();
    }
  }
  
  void i(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").b(paramHashMap);
    paramHashMap = g((String)paramHashMap.get("handle"));
    boolean bool = aa.a(paramHashMap);
    f("adc_bridge.fireAppPresenceEvent('" + paramHashMap + "'," + bool + ")");
  }
  
  void j(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").b(paramHashMap);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */