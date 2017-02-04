package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgv
  implements Callable<zzie>
{
  private static final long zzFC = TimeUnit.SECONDS.toMillis(60L);
  private final Context mContext;
  private final zziu zzFD;
  private final zzn zzFE;
  private final zzbc zzFF;
  private boolean zzFG;
  private List<String> zzFH;
  private JSONObject zzFI;
  private final zzie.zza zzFc;
  private int zzFt;
  private final Object zzpK = new Object();
  private final zzan zzxV;
  
  public zzgv(Context paramContext, zzn paramzzn, zzbc paramzzbc, zziu paramzziu, zzan paramzzan, zzie.zza paramzza)
  {
    this.mContext = paramContext;
    this.zzFE = paramzzn;
    this.zzFD = paramzziu;
    this.zzFF = paramzzbc;
    this.zzFc = paramzza;
    this.zzxV = paramzzan;
    this.zzFG = false;
    this.zzFt = -2;
    this.zzFH = null;
  }
  
  private zzh.zza zza(zzbb paramzzbb, zza paramzza, JSONObject paramJSONObject)
    throws ExecutionException, InterruptedException, JSONException
  {
    if (zzga()) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.getJSONObject("tracking_urls_and_actions");
    Object localObject = zzc(localJSONObject, "impression_tracking_urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
    {
      this.zzFH = ((List)localObject);
      this.zzFI = localJSONObject.optJSONObject("active_view");
      paramzza = paramzza.zza(this, paramJSONObject);
      if (paramzza != null) {
        break;
      }
      zzb.e("Failed to retrieve ad assets.");
      return null;
    }
    paramzza.zzb(new zzh(this.mContext, this.zzFE, paramzzbb, this.zzxV, paramJSONObject, paramzza, this.zzFc.zzJK.zzqR));
    return paramzza;
  }
  
  private zzie zza(zzh.zza paramzza)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        int j = this.zzFt;
        int i = j;
        if (paramzza == null)
        {
          i = j;
          if (this.zzFt == -2) {
            i = 0;
          }
        }
        if (i != -2)
        {
          paramzza = null;
          return new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, i, this.zzFc.zzJL.zzAR, this.zzFH, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, false, null, null, null, null, null, 0L, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJI, this.zzFc.zzJL.zzGS, this.zzFI, paramzza);
        }
      }
    }
  }
  
  private zzje<zzc> zza(JSONObject paramJSONObject, final boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    final double d;
    for (String str = paramJSONObject.getString("url");; str = paramJSONObject.optString("url"))
    {
      d = paramJSONObject.optDouble("scale", 1.0D);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      zza(0, paramBoolean1);
      return new zzjc(null);
    }
    if (paramBoolean2) {
      return new zzjc(new zzc(null, Uri.parse(str), d));
    }
    this.zzFD.zza(str, new zziu.zza()
    {
      public zzc zzg(InputStream paramAnonymousInputStream)
      {
        try
        {
          paramAnonymousInputStream = zznt.zzk(paramAnonymousInputStream);
          if (paramAnonymousInputStream == null)
          {
            zzgv.this.zza(2, paramBoolean1);
            return null;
          }
        }
        catch (IOException paramAnonymousInputStream)
        {
          for (;;)
          {
            paramAnonymousInputStream = null;
          }
          paramAnonymousInputStream = BitmapFactory.decodeByteArray(paramAnonymousInputStream, 0, paramAnonymousInputStream.length);
          if (paramAnonymousInputStream == null)
          {
            zzgv.this.zza(2, paramBoolean1);
            return null;
          }
          paramAnonymousInputStream.setDensity((int)(160.0D * d));
        }
        return new zzc(new BitmapDrawable(Resources.getSystem(), paramAnonymousInputStream), Uri.parse(this.zzCr), d);
      }
      
      public zzc zzgb()
      {
        zzgv.this.zza(2, paramBoolean1);
        return null;
      }
    });
  }
  
  private void zza(zzh.zza paramzza, zzbb paramzzbb)
  {
    if (!(paramzza instanceof zzf)) {
      return;
    }
    final Object localObject = (zzf)paramzza;
    paramzza = new zzb();
    localObject = new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        paramAnonymouszzjn = (String)paramAnonymousMap.get("asset");
        zzgv.zza(zzgv.this, localObject, paramAnonymouszzjn);
      }
    };
    paramzza.zzFY = ((zzdl)localObject);
    paramzzbb.zza("/nativeAdCustomClick", (zzdl)localObject);
  }
  
  private Integer zzb(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      int i = Color.rgb(paramJSONObject.getInt("r"), paramJSONObject.getInt("g"), paramJSONObject.getInt("b"));
      return Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private JSONObject zzb(final zzbb paramzzbb)
    throws TimeoutException, JSONException
  {
    if (zzga()) {
      return null;
    }
    final zzjb localzzjb = new zzjb();
    final zzb localzzb = new zzb();
    zzdl local1 = new zzdl()
    {
      public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
      {
        paramzzbb.zzb("/nativeAdPreProcess", localzzb.zzFY);
        try
        {
          paramAnonymouszzjn = (String)paramAnonymousMap.get("success");
          if (!TextUtils.isEmpty(paramAnonymouszzjn))
          {
            localzzjb.zzf(new JSONObject(paramAnonymouszzjn).getJSONArray("ads").getJSONObject(0));
            return;
          }
        }
        catch (JSONException paramAnonymouszzjn)
        {
          zzb.zzb("Malformed native JSON response.", paramAnonymouszzjn);
          zzgv.this.zzF(0);
          zzx.zza(zzgv.this.zzga(), "Unable to set the ad state error!");
          localzzjb.zzf(null);
        }
      }
    };
    localzzb.zzFY = local1;
    paramzzbb.zza("/nativeAdPreProcess", local1);
    paramzzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzFc.zzJL.body));
    return (JSONObject)localzzjb.get(zzFC, TimeUnit.MILLISECONDS);
  }
  
  private void zzb(zzcv paramzzcv, String paramString)
  {
    try
    {
      zzcz localzzcz = this.zzFE.zzr(paramzzcv.getCustomTemplateId());
      if (localzzcz != null) {
        localzzcz.zza(paramzzcv, paramString);
      }
      return;
    }
    catch (RemoteException paramzzcv)
    {
      zzb.zzd("Failed to call onCustomClick for asset " + paramString + ".", paramzzcv);
    }
  }
  
  private String[] zzc(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    paramString = new String[paramJSONObject.length()];
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString[i] = paramJSONObject.getString(i);
      i += 1;
    }
    return paramString;
  }
  
  private static List<Drawable> zzf(List<zzc> paramList)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((Drawable)zze.zzp(((zzc)paramList.next()).zzdC()));
    }
    return localArrayList;
  }
  
  private zzbb zzfZ()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (zzga()) {
      return null;
    }
    String str = (String)zzbz.zzwh.get();
    if (this.zzFc.zzJL.zzDE.indexOf("https") == 0) {}
    for (Object localObject = "https:";; localObject = "http:")
    {
      localObject = (String)localObject + str;
      localObject = (zzbb)this.zzFF.zza(this.mContext, this.zzFc.zzJK.zzqR, (String)localObject, this.zzxV).get(zzFC, TimeUnit.MILLISECONDS);
      ((zzbb)localObject).zza(this.zzFE, this.zzFE, this.zzFE, this.zzFE, false, null, null, null, null);
      return (zzbb)localObject;
    }
  }
  
  public void zzF(int paramInt)
  {
    synchronized (this.zzpK)
    {
      this.zzFG = true;
      this.zzFt = paramInt;
      return;
    }
  }
  
  public zzje<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    if (paramBoolean1) {}
    for (paramJSONObject = paramJSONObject.getJSONObject(paramString);; paramJSONObject = paramJSONObject.optJSONObject(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return zza(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public List<zzje<zzc>> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws JSONException
  {
    if (paramBoolean1) {}
    ArrayList localArrayList;
    for (paramJSONObject = paramJSONObject.getJSONArray(paramString);; paramJSONObject = paramJSONObject.optJSONArray(paramString))
    {
      localArrayList = new ArrayList();
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
        break;
      }
      zza(0, paramBoolean1);
      return localArrayList;
    }
    if (paramBoolean3) {}
    for (int i = paramJSONObject.length();; i = 1)
    {
      int j = 0;
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(j);
        paramString = localJSONObject;
        if (localJSONObject == null) {
          paramString = new JSONObject();
        }
        localArrayList.add(zza(paramString, paramBoolean1, paramBoolean2));
        j += 1;
      }
    }
    return localArrayList;
  }
  
  public Future<zzc> zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
    throws JSONException
  {
    paramString = paramJSONObject.getJSONObject(paramString);
    boolean bool = paramString.optBoolean("require", true);
    paramJSONObject = paramString;
    if (paramString == null) {
      paramJSONObject = new JSONObject();
    }
    return zza(paramJSONObject, bool, paramBoolean);
  }
  
  public void zza(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      zzF(paramInt);
    }
  }
  
  protected zza zzd(JSONObject paramJSONObject)
    throws JSONException, TimeoutException
  {
    if (zzga()) {
      return null;
    }
    final String str = paramJSONObject.getString("template_id");
    boolean bool1;
    if (this.zzFc.zzJK.zzrj != null)
    {
      bool1 = this.zzFc.zzJK.zzrj.zzyc;
      if (this.zzFc.zzJK.zzrj == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool2 = this.zzFc.zzJK.zzrj.zzye;; bool2 = false)
    {
      if (!"2".equals(str)) {
        break label103;
      }
      return new zzgw(bool1, bool2);
      bool1 = false;
      break;
    }
    label103:
    if ("1".equals(str)) {
      return new zzgx(bool1, bool2);
    }
    if ("3".equals(str))
    {
      str = paramJSONObject.getString("custom_template_id");
      final zzjb localzzjb = new zzjb();
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          localzzjb.zzf(zzgv.zza(zzgv.this).zzbq().get(str));
        }
      });
      if (localzzjb.get(zzFC, TimeUnit.MILLISECONDS) != null) {
        return new zzgy(bool1);
      }
      zzb.e("No handler for custom template: " + paramJSONObject.getString("custom_template_id"));
    }
    for (;;)
    {
      return null;
      zzF(0);
    }
  }
  
  public zzje<zza> zze(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attribution");
    if (localJSONObject == null) {
      return new zzjc(null);
    }
    final String str = localJSONObject.optString("text");
    final int i = localJSONObject.optInt("text_size", -1);
    final Integer localInteger1 = zzb(localJSONObject, "text_color");
    final Integer localInteger2 = zzb(localJSONObject, "bg_color");
    final int j = localJSONObject.optInt("animation_ms", 1000);
    final int k = localJSONObject.optInt("presentation_ms", 4000);
    paramJSONObject = new ArrayList();
    if (localJSONObject.optJSONArray("images") != null) {
      paramJSONObject = zza(localJSONObject, "images", false, false, true);
    }
    for (;;)
    {
      zzjd.zza(zzjd.zzj(paramJSONObject), new zzjd.zza()
      {
        public zza zzh(List<zzc> paramAnonymousList)
        {
          if (paramAnonymousList != null) {
            for (;;)
            {
              try
              {
                if (paramAnonymousList.isEmpty()) {
                  break;
                }
                String str = str;
                List localList = zzgv.zzg(paramAnonymousList);
                Integer localInteger1 = localInteger2;
                Integer localInteger2 = localInteger1;
                if (i > 0)
                {
                  paramAnonymousList = Integer.valueOf(i);
                  paramAnonymousList = new zza(str, localList, localInteger1, localInteger2, paramAnonymousList, k + j);
                }
              }
              catch (RemoteException paramAnonymousList)
              {
                zzb.zzb("Could not get attribution icon", paramAnonymousList);
                return null;
              }
              paramAnonymousList = null;
            }
          }
          paramAnonymousList = null;
          return paramAnonymousList;
        }
      });
      paramJSONObject.add(zza(localJSONObject, "image", false, false));
    }
  }
  
  public zzie zzfY()
  {
    try
    {
      Object localObject1 = zzfZ();
      Object localObject2 = zzb((zzbb)localObject1);
      localObject2 = zza((zzbb)localObject1, zzd((JSONObject)localObject2), (JSONObject)localObject2);
      zza((zzh.zza)localObject2, (zzbb)localObject1);
      localObject1 = zza((zzh.zza)localObject2);
      return (zzie)localObject1;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzd("Malformed native JSON response.", localJSONException);
      if (!this.zzFG) {
        zzF(0);
      }
      return zza(null);
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzb.zzd("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
  
  public boolean zzga()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzFG;
      return bool;
    }
  }
  
  public static abstract interface zza<T extends zzh.zza>
  {
    public abstract T zza(zzgv paramzzgv, JSONObject paramJSONObject)
      throws JSONException, InterruptedException, ExecutionException;
  }
  
  class zzb
  {
    public zzdl zzFY;
    
    zzb() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */