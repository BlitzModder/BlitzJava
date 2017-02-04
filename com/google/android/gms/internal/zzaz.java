package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzaz
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final Object zzpK = new Object();
  private boolean zzqq = false;
  private final Context zzrI;
  private final WeakReference<zzie> zzrK;
  private WeakReference<ViewTreeObserver> zzrL;
  private final zzbh zzrM;
  private final zzax zzrN;
  private final zzei zzrO;
  private final zzei.zzd zzrP;
  private boolean zzrQ;
  private final WindowManager zzrR;
  private final PowerManager zzrS;
  private final KeyguardManager zzrT;
  private zzba zzrU;
  private boolean zzrV;
  private boolean zzrW = false;
  private boolean zzrX;
  private boolean zzrY;
  BroadcastReceiver zzrZ;
  private zzix zzru;
  private final HashSet<zzaw> zzsa = new HashSet();
  private final zzdl zzsb = new zzdl()
  {
    public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
    {
      if (!zzaz.this.zzb(paramAnonymousMap)) {
        return;
      }
      zzaz.this.zza(paramAnonymouszzjn.getView(), paramAnonymousMap);
    }
  };
  private final zzdl zzsc = new zzdl()
  {
    public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
    {
      if (!zzaz.this.zzb(paramAnonymousMap)) {
        return;
      }
      zzb.zzaF("Received request to untrack: " + zzaz.zzb(zzaz.this).zzca());
      zzaz.this.destroy();
    }
  };
  private final zzdl zzsd = new zzdl()
  {
    public void zza(zzjn paramAnonymouszzjn, Map<String, String> paramAnonymousMap)
    {
      if (!zzaz.this.zzb(paramAnonymousMap)) {}
      while (!paramAnonymousMap.containsKey("isVisible")) {
        return;
      }
      if (("1".equals(paramAnonymousMap.get("isVisible"))) || ("true".equals(paramAnonymousMap.get("isVisible")))) {}
      for (boolean bool = true;; bool = false)
      {
        zzaz.this.zzg(Boolean.valueOf(bool).booleanValue());
        return;
      }
    }
  };
  
  public zzaz(final Context paramContext, AdSizeParcel paramAdSizeParcel, zzie paramzzie, VersionInfoParcel paramVersionInfoParcel, zzbh paramzzbh, zzei paramzzei)
  {
    zzbh localzzbh = paramzzbh.zzcp();
    this.zzrO = paramzzei;
    this.zzrK = new WeakReference(paramzzie);
    this.zzrM = paramzzbh;
    this.zzrL = new WeakReference(null);
    this.zzrX = true;
    this.zzru = new zzix(200L);
    this.zzrN = new zzax(UUID.randomUUID().toString(), paramVersionInfoParcel, paramAdSizeParcel.zztV, paramzzie.zzJE, paramzzie.zzcb(), paramAdSizeParcel.zztY);
    this.zzrP = this.zzrO.zzei();
    this.zzrR = ((WindowManager)paramContext.getSystemService("window"));
    this.zzrS = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    this.zzrT = ((KeyguardManager)paramContext.getSystemService("keyguard"));
    this.zzrI = paramContext;
    try
    {
      paramContext = zzd(localzzbh.zzcn());
      this.zzrP.zza(new zzjg.zzc()new zzjg.zza
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zzaz.this.zza(paramContext);
        }
      }, new zzjg.zza()
      {
        public void run() {}
      });
      this.zzrP.zza(new zzjg.zzc()new zzjg.zza
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zzaz.zzb(zzaz.this, true);
          zzaz.this.zza(paramAnonymouszzbe);
          zzaz.this.zzcd();
          zzaz.this.zzh(false);
        }
      }, new zzjg.zza()
      {
        public void run()
        {
          zzaz.this.destroy();
        }
      });
      zzb.zzaF("Tracking ad unit: " + this.zzrN.zzca());
      return;
    }
    catch (RuntimeException paramContext)
    {
      for (;;)
      {
        zzb.zzb("Failure while processing active view data.", paramContext);
      }
    }
    catch (JSONException paramContext)
    {
      for (;;) {}
    }
  }
  
  protected void destroy()
  {
    synchronized (this.zzpK)
    {
      zzcj();
      zzce();
      this.zzrX = false;
      zzcg();
      this.zzrP.release();
      return;
    }
  }
  
  boolean isScreenOn()
  {
    return this.zzrS.isScreenOn();
  }
  
  public void onGlobalLayout()
  {
    zzh(false);
  }
  
  public void onScrollChanged()
  {
    zzh(true);
  }
  
  public void pause()
  {
    synchronized (this.zzpK)
    {
      this.zzqq = true;
      zzh(false);
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.zzpK)
    {
      this.zzqq = false;
      zzh(false);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.zzpK)
    {
      this.zzrW = true;
      zzh(false);
      return;
    }
  }
  
  protected int zza(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = paramDisplayMetrics.density;
    return (int)(paramInt / f);
  }
  
  protected void zza(View paramView, Map<String, String> paramMap)
  {
    zzh(false);
  }
  
  public void zza(zzaw paramzzaw)
  {
    this.zzsa.add(paramzzaw);
  }
  
  public void zza(zzba paramzzba)
  {
    synchronized (this.zzpK)
    {
      this.zzrU = paramzzba;
      return;
    }
  }
  
  protected void zza(zzbe paramzzbe)
  {
    paramzzbe.zza("/updateActiveView", this.zzsb);
    paramzzbe.zza("/untrackActiveViewUnit", this.zzsc);
    paramzzbe.zza("/visibilityChanged", this.zzsd);
  }
  
  protected void zza(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      final JSONObject localJSONObject = new JSONObject();
      localJSONArray.put(paramJSONObject);
      localJSONObject.put("units", localJSONArray);
      this.zzrP.zza(new zzjg.zzc()new zzjg.zzb
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          paramAnonymouszzbe.zza("AFMA_updateActiveView", localJSONObject);
        }
      }, new zzjg.zzb());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      zzb.zzb("Skipping active view message.", paramJSONObject);
    }
  }
  
  protected boolean zzb(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    paramMap = (String)paramMap.get("hashCode");
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(this.zzrN.zzca()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void zzcd()
  {
    synchronized (this.zzpK)
    {
      if (this.zzrZ != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      this.zzrZ = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          zzaz.this.zzh(false);
        }
      };
      this.zzrI.registerReceiver(this.zzrZ, localIntentFilter);
      return;
    }
  }
  
  protected void zzce()
  {
    synchronized (this.zzpK)
    {
      BroadcastReceiver localBroadcastReceiver = this.zzrZ;
      if (localBroadcastReceiver == null) {}
    }
    try
    {
      this.zzrI.unregisterReceiver(this.zzrZ);
      this.zzrZ = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzb.zzb("Failed trying to unregister the receiver", localIllegalStateException);
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzp.zzbA().zzb(localException, true);
      }
    }
  }
  
  public void zzcf()
  {
    synchronized (this.zzpK)
    {
      if (this.zzrX) {
        this.zzrY = true;
      }
    }
    try
    {
      zza(zzcm());
      zzb.zzaF("Untracking ad unit: " + this.zzrN.zzca());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzb.zzb("JSON failure while processing active view data.", localJSONException);
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        zzb.zzb("Failure while processing active view data.", localRuntimeException);
      }
    }
  }
  
  protected void zzcg()
  {
    if (this.zzrU != null) {
      this.zzrU.zza(this);
    }
  }
  
  public boolean zzch()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzrX;
      return bool;
    }
  }
  
  protected void zzci()
  {
    Object localObject = this.zzrM.zzcp().zzcn();
    if (localObject == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = (ViewTreeObserver)this.zzrL.get();
      localObject = ((View)localObject).getViewTreeObserver();
    } while (localObject == localViewTreeObserver);
    zzcj();
    if ((!this.zzrV) || ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())))
    {
      this.zzrV = true;
      ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
    }
    this.zzrL = new WeakReference(localObject);
  }
  
  protected void zzcj()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)this.zzrL.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject zzck()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", this.zzrN.zzbY()).put("activeViewJSON", this.zzrN.zzbZ()).put("timestamp", zzp.zzbB().elapsedRealtime()).put("adFormat", this.zzrN.zzbX()).put("hashCode", this.zzrN.zzca()).put("isMraid", this.zzrN.zzcb()).put("isStopped", this.zzrW).put("isPaused", this.zzqq).put("isScreenOn", isScreenOn()).put("isNative", this.zzrN.zzcc());
    return localJSONObject;
  }
  
  protected JSONObject zzcl()
    throws JSONException
  {
    return zzck().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
  }
  
  protected JSONObject zzcm()
    throws JSONException
  {
    JSONObject localJSONObject = zzck();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected JSONObject zzd(View paramView)
    throws JSONException
  {
    if (paramView == null) {
      return zzcl();
    }
    boolean bool1 = zzp.zzbz().isAttachedToWindow(paramView);
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    try
    {
      paramView.getLocationOnScreen((int[])localObject2);
      paramView.getLocationInWindow((int[])localObject1);
      localObject1 = paramView.getContext().getResources().getDisplayMetrics();
      Rect localRect1 = new Rect();
      localRect1.left = localObject2[0];
      localRect1.top = localObject2[1];
      localRect1.right = (localRect1.left + paramView.getWidth());
      localRect1.bottom = (localRect1.top + paramView.getHeight());
      localObject2 = new Rect();
      ((Rect)localObject2).right = this.zzrR.getDefaultDisplay().getWidth();
      ((Rect)localObject2).bottom = this.zzrR.getDefaultDisplay().getHeight();
      Rect localRect2 = new Rect();
      boolean bool2 = paramView.getGlobalVisibleRect(localRect2, null);
      Rect localRect3 = new Rect();
      boolean bool3 = paramView.getLocalVisibleRect(localRect3);
      Rect localRect4 = new Rect();
      paramView.getHitRect(localRect4);
      JSONObject localJSONObject = zzck();
      localJSONObject.put("windowVisibility", paramView.getWindowVisibility()).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", zza(((Rect)localObject2).top, (DisplayMetrics)localObject1)).put("bottom", zza(((Rect)localObject2).bottom, (DisplayMetrics)localObject1)).put("left", zza(((Rect)localObject2).left, (DisplayMetrics)localObject1)).put("right", zza(((Rect)localObject2).right, (DisplayMetrics)localObject1))).put("adBox", new JSONObject().put("top", zza(localRect1.top, (DisplayMetrics)localObject1)).put("bottom", zza(localRect1.bottom, (DisplayMetrics)localObject1)).put("left", zza(localRect1.left, (DisplayMetrics)localObject1)).put("right", zza(localRect1.right, (DisplayMetrics)localObject1))).put("globalVisibleBox", new JSONObject().put("top", zza(localRect2.top, (DisplayMetrics)localObject1)).put("bottom", zza(localRect2.bottom, (DisplayMetrics)localObject1)).put("left", zza(localRect2.left, (DisplayMetrics)localObject1)).put("right", zza(localRect2.right, (DisplayMetrics)localObject1))).put("globalVisibleBoxVisible", bool2).put("localVisibleBox", new JSONObject().put("top", zza(localRect3.top, (DisplayMetrics)localObject1)).put("bottom", zza(localRect3.bottom, (DisplayMetrics)localObject1)).put("left", zza(localRect3.left, (DisplayMetrics)localObject1)).put("right", zza(localRect3.right, (DisplayMetrics)localObject1))).put("localVisibleBoxVisible", bool3).put("hitBox", new JSONObject().put("top", zza(localRect4.top, (DisplayMetrics)localObject1)).put("bottom", zza(localRect4.bottom, (DisplayMetrics)localObject1)).put("left", zza(localRect4.left, (DisplayMetrics)localObject1)).put("right", zza(localRect4.right, (DisplayMetrics)localObject1))).put("screenDensity", ((DisplayMetrics)localObject1).density).put("isVisible", zze(paramView));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzb.zzb("Failure getting view location.", localException);
      }
    }
  }
  
  protected boolean zze(View paramView)
  {
    return (paramView.getVisibility() == 0) && (paramView.isShown()) && (isScreenOn()) && ((!this.zzrT.inKeyguardRestrictedInputMode()) || (zzp.zzbx().zzgY()));
  }
  
  protected void zzg(boolean paramBoolean)
  {
    Iterator localIterator = this.zzsa.iterator();
    while (localIterator.hasNext()) {
      ((zzaw)localIterator.next()).zza(this, paramBoolean);
    }
  }
  
  protected void zzh(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if ((!this.zzrQ) || (!this.zzrX)) {
        return;
      }
      if ((paramBoolean) && (!this.zzru.tryAcquire())) {
        return;
      }
    }
    if (this.zzrM.zzco())
    {
      zzcf();
      return;
    }
    for (;;)
    {
      try
      {
        zza(zzd(this.zzrM.zzcn()));
        zzci();
        zzcg();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      zzb.zza("Active view update failed.", localThrowable);
    }
  }
  
  public static class zza
    implements zzbh
  {
    private WeakReference<zzh> zzsh;
    
    public zza(zzh paramzzh)
    {
      this.zzsh = new WeakReference(paramzzh);
    }
    
    public View zzcn()
    {
      zzh localzzh = (zzh)this.zzsh.get();
      if (localzzh != null) {
        return localzzh.zzdL();
      }
      return null;
    }
    
    public boolean zzco()
    {
      return this.zzsh.get() == null;
    }
    
    public zzbh zzcp()
    {
      return new zzaz.zzb((zzh)this.zzsh.get());
    }
  }
  
  public static class zzb
    implements zzbh
  {
    private zzh zzsi;
    
    public zzb(zzh paramzzh)
    {
      this.zzsi = paramzzh;
    }
    
    public View zzcn()
    {
      return this.zzsi.zzdL();
    }
    
    public boolean zzco()
    {
      return this.zzsi == null;
    }
    
    public zzbh zzcp()
    {
      return this;
    }
  }
  
  public static class zzc
    implements zzbh
  {
    private final View mView;
    private final zzie zzsj;
    
    public zzc(View paramView, zzie paramzzie)
    {
      this.mView = paramView;
      this.zzsj = paramzzie;
    }
    
    public View zzcn()
    {
      return this.mView;
    }
    
    public boolean zzco()
    {
      return (this.zzsj == null) || (this.mView == null);
    }
    
    public zzbh zzcp()
    {
      return this;
    }
  }
  
  public static class zzd
    implements zzbh
  {
    private final WeakReference<View> zzsk;
    private final WeakReference<zzie> zzsl;
    
    public zzd(View paramView, zzie paramzzie)
    {
      this.zzsk = new WeakReference(paramView);
      this.zzsl = new WeakReference(paramzzie);
    }
    
    public View zzcn()
    {
      return (View)this.zzsk.get();
    }
    
    public boolean zzco()
    {
      return (this.zzsk.get() == null) || (this.zzsl.get() == null);
    }
    
    public zzbh zzcp()
    {
      return new zzaz.zzc((View)this.zzsk.get(), (zzie)this.zzsl.get());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */