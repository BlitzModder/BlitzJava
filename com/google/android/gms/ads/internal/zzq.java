package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzha
public final class zzq
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final Context context;
  final String zzqO;
  public String zzqP;
  final zzan zzqQ;
  public final VersionInfoParcel zzqR;
  zza zzqS;
  public zzil zzqT;
  public zzir zzqU;
  public AdSizeParcel zzqV;
  public zzie zzqW;
  public zzie.zza zzqX;
  public zzif zzqY;
  zzn zzqZ;
  boolean zzqa = false;
  zzo zzra;
  zzu zzrb;
  zzv zzrc;
  zzgc zzrd;
  zzgg zzre;
  zzcx zzrf;
  zzcy zzrg;
  SimpleArrayMap<String, zzcz> zzrh;
  SimpleArrayMap<String, zzda> zzri;
  NativeAdOptionsParcel zzrj;
  zzcl zzrk;
  List<String> zzrl;
  zzk zzrm;
  public zzij zzrn = null;
  View zzro = null;
  public int zzrp = 0;
  boolean zzrq = false;
  private HashSet<zzif> zzrr = null;
  private int zzrs = -1;
  private int zzrt = -1;
  private zzix zzru;
  private boolean zzrv = true;
  private boolean zzrw = true;
  private boolean zzrx = false;
  
  public zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel, null);
  }
  
  zzq(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel, zzan paramzzan)
  {
    zzbz.initialize(paramContext);
    if (zzp.zzbA().zzgM() != null)
    {
      List localList = zzbz.zzdl();
      if (paramVersionInfoParcel.zzLF != 0) {
        localList.add(Integer.toString(paramVersionInfoParcel.zzLF));
      }
      zzp.zzbA().zzgM().zzb(localList);
    }
    this.zzqO = UUID.randomUUID().toString();
    if ((paramAdSizeParcel.zztW) || (paramAdSizeParcel.zztY))
    {
      this.zzqS = null;
      this.zzqV = paramAdSizeParcel;
      this.zzqP = paramString;
      this.context = paramContext;
      this.zzqR = paramVersionInfoParcel;
      if (paramzzan == null) {
        break label246;
      }
    }
    for (;;)
    {
      this.zzqQ = paramzzan;
      this.zzru = new zzix(200L);
      this.zzri = new SimpleArrayMap();
      return;
      this.zzqS = new zza(paramContext, this, this);
      this.zzqS.setMinimumWidth(paramAdSizeParcel.widthPixels);
      this.zzqS.setMinimumHeight(paramAdSizeParcel.heightPixels);
      this.zzqS.setVisibility(4);
      break;
      label246:
      paramzzan = new zzan(new zzh(this));
    }
  }
  
  private void zzbT()
  {
    View localView = this.zzqS.getRootView().findViewById(16908290);
    if (localView == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      return;
      localRect1 = new Rect();
      localRect2 = new Rect();
      this.zzqS.getGlobalVisibleRect(localRect1);
      localView.getGlobalVisibleRect(localRect2);
      if (localRect1.top != localRect2.top) {
        this.zzrv = false;
      }
    } while (localRect1.bottom == localRect2.bottom);
    this.zzrw = false;
  }
  
  private void zze(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.zzqS == null) || (this.zzqW == null) || (this.zzqW.zzDC == null)) {}
    while ((paramBoolean) && (!this.zzru.tryAcquire())) {
      return;
    }
    Object localObject;
    int i;
    int j;
    if (this.zzqW.zzDC.zzhC().zzcb())
    {
      localObject = new int[2];
      this.zzqS.getLocationOnScreen((int[])localObject);
      i = zzl.zzcN().zzc(this.context, localObject[0]);
      j = zzl.zzcN().zzc(this.context, localObject[1]);
      if ((i != this.zzrs) || (j != this.zzrt))
      {
        this.zzrs = i;
        this.zzrt = j;
        localObject = this.zzqW.zzDC.zzhC();
        i = this.zzrs;
        j = this.zzrt;
        if (paramBoolean) {
          break label174;
        }
      }
    }
    label174:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((zzjo)localObject).zza(i, j, paramBoolean);
      zzbT();
      return;
    }
  }
  
  public void destroy()
  {
    zzbS();
    this.zzra = null;
    this.zzrb = null;
    this.zzre = null;
    this.zzrd = null;
    this.zzrk = null;
    this.zzrc = null;
    zzf(false);
    if (this.zzqS != null) {
      this.zzqS.removeAllViews();
    }
    zzbN();
    zzbP();
    this.zzqW = null;
  }
  
  public void onGlobalLayout()
  {
    zze(false);
  }
  
  public void onScrollChanged()
  {
    zze(true);
    this.zzrx = true;
  }
  
  public void zza(HashSet<zzif> paramHashSet)
  {
    this.zzrr = paramHashSet;
  }
  
  public HashSet<zzif> zzbM()
  {
    return this.zzrr;
  }
  
  public void zzbN()
  {
    if ((this.zzqW != null) && (this.zzqW.zzDC != null)) {
      this.zzqW.zzDC.destroy();
    }
  }
  
  public void zzbO()
  {
    if ((this.zzqW != null) && (this.zzqW.zzDC != null)) {
      this.zzqW.zzDC.stopLoading();
    }
  }
  
  public void zzbP()
  {
    if ((this.zzqW != null) && (this.zzqW.zzBq != null)) {}
    try
    {
      this.zzqW.zzBq.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Could not destroy mediation adapter.");
    }
  }
  
  public boolean zzbQ()
  {
    return this.zzrp == 0;
  }
  
  public boolean zzbR()
  {
    return this.zzrp == 1;
  }
  
  public void zzbS()
  {
    if (this.zzqS != null) {
      this.zzqS.zzbS();
    }
  }
  
  public String zzbU()
  {
    if ((this.zzrv) && (this.zzrw)) {
      return "";
    }
    if (this.zzrv)
    {
      if (this.zzrx) {
        return "top-scrollable";
      }
      return "top-locked";
    }
    if (this.zzrw)
    {
      if (this.zzrx) {
        return "bottom-scrollable";
      }
      return "bottom-locked";
    }
    return "";
  }
  
  public void zzbV()
  {
    this.zzqY.zzl(this.zzqW.zzJH);
    this.zzqY.zzm(this.zzqW.zzJI);
    this.zzqY.zzz(this.zzqV.zztW);
    this.zzqY.zzA(this.zzqW.zzGN);
  }
  
  public void zzf(boolean paramBoolean)
  {
    if (this.zzrp == 0) {
      zzbO();
    }
    if (this.zzqT != null) {
      this.zzqT.cancel();
    }
    if (this.zzqU != null) {
      this.zzqU.cancel();
    }
    if (paramBoolean) {
      this.zzqW = null;
    }
  }
  
  public static class zza
    extends ViewSwitcher
  {
    private final zzis zzry;
    private final zzja zzrz;
    
    public zza(Context paramContext, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
    {
      super();
      this.zzry = new zzis(paramContext);
      if ((paramContext instanceof Activity))
      {
        this.zzrz = new zzja((Activity)paramContext, paramOnGlobalLayoutListener, paramOnScrollChangedListener);
        this.zzrz.zzhm();
        return;
      }
      this.zzrz = null;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (this.zzrz != null) {
        this.zzrz.onAttachedToWindow();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (this.zzrz != null) {
        this.zzrz.onDetachedFromWindow();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.zzry.zze(paramMotionEvent);
      return false;
    }
    
    public void removeAllViews()
    {
      Object localObject = new ArrayList();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && ((localView instanceof zzjn))) {
          ((List)localObject).add((zzjn)localView);
        }
        i += 1;
      }
      super.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zzjn)((Iterator)localObject).next()).destroy();
      }
    }
    
    public void zzbS()
    {
      zzb.v("Disable position monitoring on adFrame.");
      if (this.zzrz != null) {
        this.zzrz.zzhn();
      }
    }
    
    public zzis zzbW()
    {
      return this.zzry;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */