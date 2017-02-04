package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.Set;

@zzha
public class zzfm
  extends zzfr
{
  static final Set<String> zzCa = zznm.zzc(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
  private AdSizeParcel zzBh;
  private String zzCb = "top-right";
  private boolean zzCc = true;
  private int zzCd = 0;
  private int zzCe = 0;
  private int zzCf = 0;
  private int zzCg = 0;
  private final Activity zzCh;
  private ImageView zzCi;
  private LinearLayout zzCj;
  private zzfs zzCk;
  private PopupWindow zzCl;
  private RelativeLayout zzCm;
  private ViewGroup zzCn;
  private int zzov = -1;
  private int zzow = -1;
  private final Object zzpK = new Object();
  private final zzjn zzps;
  
  public zzfm(zzjn paramzzjn, zzfs paramzzfs)
  {
    super(paramzzjn, "resize");
    this.zzps = paramzzjn;
    this.zzCh = paramzzjn.zzhx();
    this.zzCk = paramzzfs;
  }
  
  private int[] zzeB()
  {
    if (!zzeD()) {
      return null;
    }
    if (this.zzCc) {
      return new int[] { this.zzCd + this.zzCf, this.zzCe + this.zzCg };
    }
    int[] arrayOfInt1 = zzp.zzbx().zzh(this.zzCh);
    int[] arrayOfInt2 = zzp.zzbx().zzj(this.zzCh);
    int m = arrayOfInt1[0];
    int j = this.zzCd + this.zzCf;
    int k = this.zzCe + this.zzCg;
    int i;
    if (j < 0)
    {
      i = 0;
      if (k >= arrayOfInt2[0]) {
        break label149;
      }
      j = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { i, j };
      i = j;
      if (this.zzov + j <= m) {
        break;
      }
      i = m - this.zzov;
      break;
      label149:
      j = k;
      if (this.zzow + k > arrayOfInt2[1]) {
        j = arrayOfInt2[1] - this.zzow;
      }
    }
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      this.zzov = zzp.zzbx().zzaA((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      this.zzow = zzp.zzbx().zzaA((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      this.zzCf = zzp.zzbx().zzaA((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      this.zzCg = zzp.zzbx().zzaA((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      this.zzCc = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    paramMap = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(paramMap)) {
      this.zzCb = paramMap;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzCd = paramInt1;
      this.zzCe = paramInt2;
      if ((this.zzCl != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzeB();
        if (arrayOfInt != null)
        {
          this.zzCl.update(zzl.zzcN().zzb(this.zzCh, arrayOfInt[0]), zzl.zzcN().zzb(this.zzCh, arrayOfInt[1]), this.zzCl.getWidth(), this.zzCl.getHeight());
          zzd(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzp(true);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    if (this.zzCk != null) {
      this.zzCk.zza(paramInt1, paramInt2, this.zzov, this.zzow);
    }
  }
  
  void zzd(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzp.zzbx().zzj(this.zzCh)[0], this.zzov, this.zzow);
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    this.zzCd = paramInt1;
    this.zzCe = paramInt2;
  }
  
  boolean zzeA()
  {
    return (this.zzov > -1) && (this.zzow > -1);
  }
  
  public boolean zzeC()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzCl != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzeD()
  {
    Object localObject = zzp.zzbx().zzh(this.zzCh);
    int[] arrayOfInt = zzp.zzbx().zzj(this.zzCh);
    int k = localObject[0];
    int i = localObject[1];
    if ((this.zzov < 50) || (this.zzov > k))
    {
      zzb.zzaH("Width is too small or too large.");
      return false;
    }
    if ((this.zzow < 50) || (this.zzow > i))
    {
      zzb.zzaH("Height is too small or too large.");
      return false;
    }
    if ((this.zzow == i) && (this.zzov == k))
    {
      zzb.zzaH("Cannot resize to a full-screen ad.");
      return false;
    }
    label184:
    int j;
    if (this.zzCc)
    {
      localObject = this.zzCb;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = this.zzCd + this.zzCf + this.zzov - 50;
          i = this.zzCe + this.zzCg;
        }
        break;
      }
    }
    while ((j >= 0) && (j + 50 <= k) && (i >= arrayOfInt[0]) && (i + 50 <= arrayOfInt[1]))
    {
      return true;
      if (!((String)localObject).equals("top-left")) {
        break label184;
      }
      i = 0;
      break label184;
      if (!((String)localObject).equals("top-center")) {
        break label184;
      }
      i = 1;
      break label184;
      if (!((String)localObject).equals("center")) {
        break label184;
      }
      i = 2;
      break label184;
      if (!((String)localObject).equals("bottom-left")) {
        break label184;
      }
      i = 3;
      break label184;
      if (!((String)localObject).equals("bottom-center")) {
        break label184;
      }
      i = 4;
      break label184;
      if (!((String)localObject).equals("bottom-right")) {
        break label184;
      }
      i = 5;
      break label184;
      i = this.zzCd;
      j = this.zzCf + i;
      i = this.zzCe + this.zzCg;
      continue;
      j = this.zzCd + this.zzCf + this.zzov / 2 - 25;
      i = this.zzCe + this.zzCg;
      continue;
      j = this.zzCd + this.zzCf + this.zzov / 2 - 25;
      i = this.zzCe + this.zzCg + this.zzow / 2 - 25;
      continue;
      i = this.zzCd;
      j = this.zzCf + i;
      i = this.zzCe + this.zzCg + this.zzow - 50;
      continue;
      j = this.zzCd + this.zzCf + this.zzov / 2 - 25;
      i = this.zzCe + this.zzCg + this.zzow - 50;
      continue;
      j = this.zzCd + this.zzCf + this.zzov - 50;
      i = this.zzCe + this.zzCg + this.zzow - 50;
    }
  }
  
  public void zzg(Map<String, String> paramMap)
  {
    synchronized (this.zzpK)
    {
      if (this.zzCh == null)
      {
        zzal("Not an activity context. Cannot resize.");
        return;
      }
      if (this.zzps.zzaP() == null)
      {
        zzal("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (this.zzps.zzaP().zztW)
    {
      zzal("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.zzps.zzhG())
    {
      zzal("Cannot resize an expanded banner.");
      return;
    }
    zzf(paramMap);
    if (!zzeA())
    {
      zzal("Invalid width and height options. Cannot resize.");
      return;
    }
    paramMap = this.zzCh.getWindow();
    if ((paramMap == null) || (paramMap.getDecorView() == null))
    {
      zzal("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzeB();
    if (arrayOfInt == null)
    {
      zzal("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzl.zzcN().zzb(this.zzCh, this.zzov);
    int j = zzl.zzcN().zzb(this.zzCh, this.zzow);
    Object localObject2 = this.zzps.getView().getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
    {
      ((ViewGroup)localObject2).removeView(this.zzps.getView());
      if (this.zzCl == null)
      {
        this.zzCn = ((ViewGroup)localObject2);
        localObject2 = zzp.zzbx().zzl(this.zzps.getView());
        this.zzCi = new ImageView(this.zzCh);
        this.zzCi.setImageBitmap((Bitmap)localObject2);
        this.zzBh = this.zzps.zzaP();
        this.zzCn.addView(this.zzCi);
        this.zzCm = new RelativeLayout(this.zzCh);
        this.zzCm.setBackgroundColor(0);
        this.zzCm.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        this.zzCl = zzp.zzbx().zza(this.zzCm, i, j, false);
        this.zzCl.setOutsideTouchable(true);
        this.zzCl.setTouchable(true);
        localObject2 = this.zzCl;
        if (this.zzCc) {
          break label1071;
        }
      }
    }
    label1023:
    label1027:
    label1029:
    label1071:
    for (boolean bool = true;; bool = false)
    {
      ((PopupWindow)localObject2).setClippingEnabled(bool);
      this.zzCm.addView(this.zzps.getView(), -1, -1);
      this.zzCj = new LinearLayout(this.zzCh);
      localObject2 = new RelativeLayout.LayoutParams(zzl.zzcN().zzb(this.zzCh, 50), zzl.zzcN().zzb(this.zzCh, 50));
      String str = this.zzCb;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        for (;;)
        {
          this.zzCj.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzfm.this.zzp(true);
            }
          });
          this.zzCj.setContentDescription("Close button");
          this.zzCm.addView(this.zzCj, (ViewGroup.LayoutParams)localObject2);
          try
          {
            this.zzCl.showAtLocation(paramMap.getDecorView(), 0, zzl.zzcN().zzb(this.zzCh, arrayOfInt[0]), zzl.zzcN().zzb(this.zzCh, arrayOfInt[1]));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            this.zzps.zza(new AdSizeParcel(this.zzCh, new AdSize(this.zzov, this.zzow)));
            zzd(arrayOfInt[0], arrayOfInt[1]);
            zzan("resized");
            return;
          }
          catch (RuntimeException paramMap)
          {
            zzal("Cannot show popup window: " + paramMap.getMessage());
            this.zzCm.removeView(this.zzps.getView());
            if (this.zzCn == null) {
              break label1023;
            }
            this.zzCn.removeView(this.zzCi);
            this.zzCn.addView(this.zzps.getView());
            this.zzps.zza(this.zzBh);
            return;
          }
          this.zzCl.dismiss();
          break;
          zzal("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1027;
          }
          i = 0;
          break label1029;
          if (!str.equals("top-center")) {
            break label1027;
          }
          i = 1;
          break label1029;
          if (!str.equals("center")) {
            break label1027;
          }
          i = 2;
          break label1029;
          if (!str.equals("bottom-left")) {
            break label1027;
          }
          i = 3;
          break label1029;
          if (!str.equals("bottom-center")) {
            break label1027;
          }
          i = 4;
          break label1029;
          if (!str.equals("bottom-right")) {
            break label1027;
          }
          i = 5;
          break label1029;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        }
        i = -1;
        switch (i)
        {
        }
      }
    }
  }
  
  public void zzp(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzCl != null)
      {
        this.zzCl.dismiss();
        this.zzCm.removeView(this.zzps.getView());
        if (this.zzCn != null)
        {
          this.zzCn.removeView(this.zzCi);
          this.zzCn.addView(this.zzps.getView());
          this.zzps.zza(this.zzBh);
        }
        if (paramBoolean)
        {
          zzan("default");
          if (this.zzCk != null) {
            this.zzCk.zzbe();
          }
        }
        this.zzCl = null;
        this.zzCm = null;
        this.zzCn = null;
        this.zzCj = null;
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */