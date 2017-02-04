package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzj
  extends zzcp.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private FrameLayout zzoF;
  private final Object zzpK = new Object();
  private zzh zzxH;
  private final FrameLayout zzyf;
  private Map<String, WeakReference<View>> zzyg = new HashMap();
  private zzb zzyh;
  boolean zzyi = false;
  int zzyj;
  int zzyk;
  
  public zzj(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    this.zzyf = paramFrameLayout1;
    this.zzoF = paramFrameLayout2;
    zzji.zza(this.zzyf, this);
    zzji.zza(this.zzyf, this);
    this.zzyf.setOnTouchListener(this);
  }
  
  public void destroy()
  {
    this.zzoF.removeAllViews();
    this.zzoF = null;
    this.zzyg = null;
    this.zzyh = null;
    this.zzxH = null;
  }
  
  int getMeasuredHeight()
  {
    return this.zzyf.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return this.zzyf.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject1;
    Object localObject3;
    synchronized (this.zzpK)
    {
      if (this.zzxH == null) {
        return;
      }
      localJSONObject1 = new JSONObject();
      localObject2 = this.zzyg.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          View localView = (View)((WeakReference)((Map.Entry)localObject3).getValue()).get();
          Point localPoint = zzk(localView);
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("width", zzq(localView.getWidth()));
            localJSONObject2.put("height", zzq(localView.getHeight()));
            localJSONObject2.put("x", zzq(localPoint.x));
            localJSONObject2.put("y", zzq(localPoint.y));
            localJSONObject1.put((String)((Map.Entry)localObject3).getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException2)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get view rectangle for view " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("x", zzq(this.zzyj));
      ((JSONObject)localObject2).put("y", zzq(this.zzyk));
      localObject3 = new JSONObject();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        ((JSONObject)localObject3).put("width", zzq(getMeasuredWidth()));
        ((JSONObject)localObject3).put("height", zzq(getMeasuredHeight()));
        if ((this.zzyh != null) && (this.zzyh.zzdB().equals(paramView)))
        {
          this.zzxH.zza("1007", localJSONObject1, (JSONObject)localObject2, (JSONObject)localObject3);
          return;
          localJSONException1 = localJSONException1;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get click location");
        }
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get native ad view bounding box");
          continue;
          this.zzxH.zza(paramView, this.zzyg, localJSONObject1, (JSONObject)localObject2, localJSONException1);
        }
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (this.zzpK)
    {
      if (this.zzyi)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0))
        {
          this.zzoF.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          this.zzyi = false;
        }
      }
      if (this.zzxH != null) {
        this.zzxH.zzi(this.zzyf);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH != null) {
        this.zzxH.zzi(this.zzyf);
      }
      return;
    }
  }
  
  public boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (this.zzpK)
    {
      if (this.zzxH == null) {
        return false;
      }
      Point localPoint = zzc(paramMotionEvent);
      this.zzyj = localPoint.x;
      this.zzyk = localPoint.y;
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(localPoint.x, localPoint.y);
      this.zzxH.zzb(paramMotionEvent);
      paramMotionEvent.recycle();
      return false;
    }
  }
  
  public zzd zzU(String paramString)
  {
    synchronized (this.zzpK)
    {
      paramString = (WeakReference)this.zzyg.get(paramString);
      if (paramString == null)
      {
        paramString = null;
        paramString = zze.zzB(paramString);
        return paramString;
      }
      paramString = (View)paramString.get();
    }
  }
  
  public void zza(String paramString, zzd paramzzd)
  {
    View localView = (View)zze.zzp(paramzzd);
    paramzzd = this.zzpK;
    if (localView == null) {}
    for (;;)
    {
      try
      {
        this.zzyg.remove(paramString);
        return;
      }
      finally {}
      this.zzyg.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setOnClickListener(this);
    }
  }
  
  public void zzb(final zzd paramzzd)
  {
    synchronized (this.zzpK)
    {
      this.zzyi = true;
      zzj(null);
      paramzzd = (zzh)zze.zzp(paramzzd);
      if (((this.zzxH instanceof zzg)) && (((zzg)this.zzxH).zzdI())) {
        ((zzg)this.zzxH).zzc(paramzzd);
      }
      do
      {
        this.zzoF.removeAllViews();
        this.zzyh = zzg(paramzzd);
        if (this.zzyh != null)
        {
          this.zzyg.put("1007", new WeakReference(this.zzyh.zzdB()));
          this.zzoF.addView(this.zzyh);
        }
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzjn localzzjn = paramzzd.zzdK();
            if (localzzjn != null) {
              zzj.zza(zzj.this).addView(localzzjn.getView());
            }
          }
        });
        paramzzd.zzh(this.zzyf);
        zzj(this.zzyf);
        return;
        this.zzxH = paramzzd;
      } while (!(this.zzxH instanceof zzg));
      ((zzg)this.zzxH).zzc(null);
    }
  }
  
  Point zzc(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.zzyf.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX();
    float f2 = arrayOfInt[0];
    float f3 = paramMotionEvent.getRawY();
    float f4 = arrayOfInt[1];
    return new Point((int)(f1 - f2), (int)(f3 - f4));
  }
  
  zzb zzg(zzh paramzzh)
  {
    return paramzzh.zza(this);
  }
  
  void zzj(View paramView)
  {
    if (this.zzxH != null) {
      if (!(this.zzxH instanceof zzg)) {
        break label38;
      }
    }
    label38:
    for (zzh localzzh = ((zzg)this.zzxH).zzdJ();; localzzh = this.zzxH)
    {
      if (localzzh != null) {
        localzzh.zzj(paramView);
      }
      return;
    }
  }
  
  Point zzk(View paramView)
  {
    if ((this.zzyh != null) && (this.zzyh.zzdB().equals(paramView)))
    {
      localPoint1 = new Point();
      this.zzyf.getGlobalVisibleRect(new Rect(), localPoint1);
      Point localPoint2 = new Point();
      paramView.getGlobalVisibleRect(new Rect(), localPoint2);
      return new Point(localPoint2.x - localPoint1.x, localPoint2.y - localPoint1.y);
    }
    Point localPoint1 = new Point();
    paramView.getGlobalVisibleRect(new Rect(), localPoint1);
    return localPoint1;
  }
  
  int zzq(int paramInt)
  {
    return zzl.zzcN().zzc(this.zzxH.getContext(), paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */