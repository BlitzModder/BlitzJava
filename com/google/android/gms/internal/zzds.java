package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzha
public final class zzds
  implements zzdl
{
  private final zze zzzb;
  private final zzfm zzzc;
  private final zzdn zzze;
  
  public zzds(zzdn paramzzdn, zze paramzze, zzfm paramzzfm)
  {
    this.zzze = paramzzdn;
    this.zzzb = paramzze;
    this.zzzc = paramzzfm;
  }
  
  private static void zza(Context paramContext, Map<String, String> paramMap)
  {
    if (TextUtils.isEmpty((String)paramMap.get("u")))
    {
      zzb.zzaH("Destination url cannot be empty.");
      return;
    }
    paramMap = new zzb().zzb(paramContext, paramMap);
    try
    {
      zzp.zzbx().zzb(paramContext, paramMap);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      zzb.zzaH(paramContext.getMessage());
    }
  }
  
  private static boolean zzc(Map<String, String> paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int zzd(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null)
    {
      if ("p".equalsIgnoreCase(paramMap)) {
        return zzp.zzbz().zzhe();
      }
      if ("l".equalsIgnoreCase(paramMap)) {
        return zzp.zzbz().zzhd();
      }
      if ("c".equalsIgnoreCase(paramMap)) {
        return zzp.zzbz().zzhf();
      }
    }
    return -1;
  }
  
  private static void zze(zzjn paramzzjn, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("u");
    if (TextUtils.isEmpty(paramMap))
    {
      zzb.zzaH("Destination url cannot be empty.");
      return;
    }
    new zza(paramzzjn, paramMap).zzgX();
  }
  
  private void zzo(boolean paramBoolean)
  {
    if (this.zzzc != null) {
      this.zzzc.zzp(paramBoolean);
    }
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("a");
    if (str == null) {
      zzb.zzaH("Action missing from an open GMSG.");
    }
    zzjo localzzjo;
    do
    {
      return;
      if ((this.zzzb != null) && (!this.zzzb.zzbg()))
      {
        this.zzzb.zzp((String)paramMap.get("u"));
        return;
      }
      localzzjo = paramzzjn.zzhC();
      if ("expand".equalsIgnoreCase(str))
      {
        if (paramzzjn.zzhG())
        {
          zzb.zzaH("Cannot expand WebView that is already expanded.");
          return;
        }
        zzo(false);
        localzzjo.zza(zzc(paramMap), zzd(paramMap));
        return;
      }
      if ("webapp".equalsIgnoreCase(str))
      {
        paramzzjn = (String)paramMap.get("u");
        zzo(false);
        if (paramzzjn != null)
        {
          localzzjo.zza(zzc(paramMap), zzd(paramMap), paramzzjn);
          return;
        }
        localzzjo.zza(zzc(paramMap), zzd(paramMap), (String)paramMap.get("html"), (String)paramMap.get("baseurl"));
        return;
      }
      if (!"in_app_purchase".equalsIgnoreCase(str)) {
        break;
      }
      paramzzjn = (String)paramMap.get("product_id");
      paramMap = (String)paramMap.get("report_urls");
    } while (this.zzze == null);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.split(" ");
      this.zzze.zza(paramzzjn, new ArrayList(Arrays.asList(paramMap)));
      return;
    }
    this.zzze.zza(paramzzjn, new ArrayList());
    return;
    if (("app".equalsIgnoreCase(str)) && ("true".equalsIgnoreCase((String)paramMap.get("play_store"))))
    {
      zze(paramzzjn, paramMap);
      return;
    }
    if (("app".equalsIgnoreCase(str)) && ("true".equalsIgnoreCase((String)paramMap.get("system_browser"))))
    {
      zza(paramzzjn.getContext(), paramMap);
      return;
    }
    zzo(true);
    paramzzjn.zzhE();
    str = (String)paramMap.get("u");
    if (!TextUtils.isEmpty(str)) {}
    for (paramzzjn = zzp.zzbx().zza(paramzzjn, str);; paramzzjn = str)
    {
      localzzjo.zza(new AdLauncherIntentInfoParcel((String)paramMap.get("i"), paramzzjn, (String)paramMap.get("m"), (String)paramMap.get("p"), (String)paramMap.get("c"), (String)paramMap.get("f"), (String)paramMap.get("e")));
      return;
    }
  }
  
  public static class zza
    extends zzil
  {
    private final String zzF;
    private final zzjn zzps;
    private final String zzzf = "play.google.com";
    private final String zzzg = "market";
    private final int zzzh = 10;
    
    public zza(zzjn paramzzjn, String paramString)
    {
      this.zzps = paramzzjn;
      this.zzF = paramString;
    }
    
    public void onStop() {}
    
    public Intent zzY(String paramString)
    {
      paramString = Uri.parse(paramString);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramString);
      return localIntent;
    }
    
    public void zzbp()
    {
      int i = 0;
      Object localObject1 = this.zzF;
      if (i < 10) {}
      for (;;)
      {
        try
        {
          localObject2 = new URL((String)localObject1);
          boolean bool = "play.google.com".equalsIgnoreCase(((URL)localObject2).getHost());
          if (!bool) {
            continue;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
        {
          Object localObject2;
          HttpURLConnection localHttpURLConnection;
          zzb.zzd("Error while parsing ping URL: " + (String)localObject1, localIndexOutOfBoundsException1);
          continue;
        }
        catch (IOException localIOException1)
        {
          zzb.zzd("Error while pinging URL: " + (String)localObject1, localIOException1);
          continue;
        }
        catch (RuntimeException localRuntimeException1)
        {
          zzb.zzd("Error while pinging URL: " + (String)localObject1, localRuntimeException1);
          continue;
          Object localObject4 = "";
          continue;
        }
        localObject1 = zzY((String)localObject1);
        zzp.zzbx().zzb(this.zzps.getContext(), (Intent)localObject1);
        return;
        if (!"market".equalsIgnoreCase(((URL)localObject2).getProtocol()))
        {
          localHttpURLConnection = (HttpURLConnection)((URL)localObject2).openConnection();
          try
          {
            zzp.zzbx().zza(this.zzps.getContext(), this.zzps.zzhF().afmaVersion, false, localHttpURLConnection);
            int j = localHttpURLConnection.getResponseCode();
            Map localMap = localHttpURLConnection.getHeaderFields();
            if ((j >= 300) && (j <= 399))
            {
              localObject2 = null;
              if (localMap.containsKey("Location"))
              {
                localObject2 = (List)localMap.get("Location");
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
                  continue;
                }
                localObject2 = (String)((List)localObject2).get(0);
                if (TextUtils.isEmpty((CharSequence)localObject2))
                {
                  zzb.zzaH("Arrived at landing page, this ideally should not happen. Will open it in browser.");
                  localHttpURLConnection.disconnect();
                }
              }
              else
              {
                if (!localMap.containsKey("location")) {
                  continue;
                }
                localObject2 = (List)localMap.get("location");
                continue;
              }
            }
          }
          finally
          {
            try
            {
              localHttpURLConnection.disconnect();
              i += 1;
              localObject1 = localObject2;
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject1 = localRuntimeException1;
              localObject4 = localRuntimeException2;
              continue;
            }
            catch (IOException localIOException2)
            {
              localObject1 = localObject4;
              localObject4 = localIOException2;
              continue;
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
            {
              localObject1 = localObject4;
              localObject4 = localIndexOutOfBoundsException2;
              continue;
            }
            localObject3 = finally;
            localHttpURLConnection.disconnect();
          }
        }
      }
    }
  }
  
  public static class zzb
  {
    public Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
      return paramIntent;
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent)
    {
      return zza(paramContext, paramIntent, new ArrayList());
    }
    
    public ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        return null;
      }
      List localList = paramContext.queryIntentActivities(paramIntent, 65536);
      paramContext = paramContext.resolveActivity(paramIntent, 65536);
      int i;
      if ((localList != null) && (paramContext != null))
      {
        i = 0;
        if (i < localList.size())
        {
          paramIntent = (ResolveInfo)localList.get(i);
          if ((paramContext == null) || (!paramContext.activityInfo.name.equals(paramIntent.activityInfo.name))) {}
        }
      }
      for (;;)
      {
        paramArrayList.addAll(localList);
        return paramContext;
        i += 1;
        break;
        paramContext = null;
      }
    }
    
    public Intent zzb(Context paramContext, Map<String, String> paramMap)
    {
      Object localObject1 = null;
      Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
      Object localObject3 = (String)paramMap.get("u");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramMap = (Map<String, String>)localObject1;
        return paramMap;
      }
      localObject1 = Uri.parse((String)localObject3);
      boolean bool1 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
      boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
      if ("http".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
        paramMap = ((Uri)localObject1).buildUpon().scheme("https").build();
      }
      for (;;)
      {
        localObject3 = new ArrayList();
        Intent localIntent = zzd((Uri)localObject1);
        paramMap = zzd(paramMap);
        localObject1 = zza(paramContext, localIntent, (ArrayList)localObject3);
        if (localObject1 != null)
        {
          return zza(localIntent, (ResolveInfo)localObject1);
          if ("https".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
            paramMap = ((Uri)localObject1).buildUpon().scheme("http").build();
          }
        }
        else
        {
          if (paramMap != null)
          {
            paramMap = zza(paramContext, paramMap);
            if (paramMap != null)
            {
              localObject1 = zza(localIntent, paramMap);
              paramMap = (Map<String, String>)localObject1;
              if (zza(paramContext, (Intent)localObject1) != null) {
                break;
              }
            }
          }
          if (((ArrayList)localObject3).size() == 0) {
            return localIntent;
          }
          if ((bool2) && (localObject2 != null))
          {
            paramContext = ((ActivityManager)localObject2).getRunningAppProcesses();
            if (paramContext != null)
            {
              do
              {
                paramMap = ((ArrayList)localObject3).iterator();
                while (!((Iterator)localObject2).hasNext())
                {
                  if (!paramMap.hasNext()) {
                    break;
                  }
                  localObject1 = (ResolveInfo)paramMap.next();
                  localObject2 = paramContext.iterator();
                }
              } while (!((ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next()).processName.equals(((ResolveInfo)localObject1).activityInfo.packageName));
              return zza(localIntent, (ResolveInfo)localObject1);
            }
          }
          if (bool1) {
            return zza(localIntent, (ResolveInfo)((ArrayList)localObject3).get(0));
          }
          return localIntent;
        }
        paramMap = null;
      }
    }
    
    public Intent zzd(Uri paramUri)
    {
      if (paramUri == null) {
        return null;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      localIntent.setData(paramUri);
      localIntent.setAction("android.intent.action.VIEW");
      return localIntent;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */