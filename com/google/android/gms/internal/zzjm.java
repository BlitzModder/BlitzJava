package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

@zzha
public class zzjm
{
  private final Context mContext;
  private zzk zzEn;
  private final ViewGroup zzMd;
  private final zzjn zzps;
  
  public zzjm(Context paramContext, ViewGroup paramViewGroup, zzjn paramzzjn)
  {
    this(paramContext, paramViewGroup, paramzzjn, null);
  }
  
  zzjm(Context paramContext, ViewGroup paramViewGroup, zzjn paramzzjn, zzk paramzzk)
  {
    this.mContext = paramContext;
    this.zzMd = paramViewGroup;
    this.zzps = paramzzjn;
    this.zzEn = paramzzk;
  }
  
  public void onDestroy()
  {
    zzx.zzcx("onDestroy must be called from the UI thread.");
    if (this.zzEn != null) {
      this.zzEn.destroy();
    }
  }
  
  public void onPause()
  {
    zzx.zzcx("onPause must be called from the UI thread.");
    if (this.zzEn != null) {
      this.zzEn.pause();
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.zzEn != null) {
      return;
    }
    zzcd.zza(this.zzps.zzhL().zzdt(), this.zzps.zzhK(), new String[] { "vpr" });
    zzcf localzzcf = zzcd.zzb(this.zzps.zzhL().zzdt());
    this.zzEn = new zzk(this.mContext, this.zzps, paramInt5, this.zzps.zzhL().zzdt(), localzzcf);
    this.zzMd.addView(this.zzEn, 0, new ViewGroup.LayoutParams(-1, -1));
    this.zzEn.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    this.zzps.zzhC().zzG(false);
  }
  
  public void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzx.zzcx("The underlay may only be modified from the UI thread.");
    if (this.zzEn != null) {
      this.zzEn.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public zzk zzhv()
  {
    zzx.zzcx("getAdVideoUnderlay must be called from the UI thread.");
    return this.zzEn;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */