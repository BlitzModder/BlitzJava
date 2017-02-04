package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import java.util.HashMap;

@zzha
public class zzk
  extends FrameLayout
  implements zzh
{
  private final FrameLayout zzDM;
  private final zzq zzDN;
  private zzi zzDO;
  private boolean zzDP;
  private boolean zzDQ;
  private TextView zzDR;
  private long zzDS;
  private long zzDT;
  private String zzDU;
  private final zzjn zzps;
  private String zzzk;
  
  public zzk(Context paramContext, zzjn paramzzjn, int paramInt, zzch paramzzch, zzcf paramzzcf)
  {
    super(paramContext);
    this.zzps = paramzzjn;
    this.zzDM = new FrameLayout(paramContext);
    addView(this.zzDM, new FrameLayout.LayoutParams(-1, -1));
    zzb.zzu(paramzzjn.zzhz());
    this.zzDO = paramzzjn.zzhz().zzpn.zza(paramContext, paramzzjn, paramInt, paramzzch, paramzzcf);
    if (this.zzDO != null) {
      this.zzDM.addView(this.zzDO, new FrameLayout.LayoutParams(-1, -1, 17));
    }
    this.zzDR = new TextView(paramContext);
    this.zzDR.setBackgroundColor(-16777216);
    zzfv();
    this.zzDN = new zzq(this);
    this.zzDN.zzfD();
    if (this.zzDO != null) {
      this.zzDO.zza(this);
    }
    if (this.zzDO == null) {
      zzg("AdVideoUnderlay Error", "Allocating player failed.");
    }
  }
  
  private void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    this.zzps.zzb("onVideoEvent", localHashMap);
  }
  
  public static void zzd(zzjn paramzzjn)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzzjn.zzb("onVideoEvent", localHashMap);
  }
  
  private void zzfv()
  {
    if (!zzfx())
    {
      this.zzDM.addView(this.zzDR, new FrameLayout.LayoutParams(-1, -1));
      this.zzDM.bringChildToFront(this.zzDR);
    }
  }
  
  private void zzfw()
  {
    if (zzfx()) {
      this.zzDM.removeView(this.zzDR);
    }
  }
  
  private boolean zzfx()
  {
    return this.zzDR.getParent() != null;
  }
  
  private void zzfy()
  {
    if (this.zzps.zzhx() == null) {
      break label12;
    }
    label12:
    while (this.zzDP) {
      return;
    }
    if ((this.zzps.zzhx().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzDQ = bool;
      if (this.zzDQ) {
        break;
      }
      this.zzps.zzhx().getWindow().addFlags(128);
      this.zzDP = true;
      return;
    }
  }
  
  private void zzfz()
  {
    if (this.zzps.zzhx() == null) {}
    while ((!this.zzDP) || (this.zzDQ)) {
      return;
    }
    this.zzps.zzhx().getWindow().clearFlags(128);
    this.zzDP = false;
  }
  
  public void destroy()
  {
    this.zzDN.cancel();
    if (this.zzDO != null) {
      this.zzDO.stop();
    }
    zzfz();
  }
  
  public void onPaused()
  {
    zza("pause", new String[0]);
    zzfz();
  }
  
  public void pause()
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.pause();
  }
  
  public void play()
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.play();
  }
  
  public void seekTo(int paramInt)
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.seekTo(paramInt);
  }
  
  public void setMimeType(String paramString)
  {
    this.zzDU = paramString;
  }
  
  public void zza(float paramFloat)
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.zza(paramFloat);
  }
  
  public void zzao(String paramString)
  {
    this.zzzk = paramString;
  }
  
  public void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    this.zzDM.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void zzd(MotionEvent paramMotionEvent)
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void zzeU()
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.zzeU();
  }
  
  public void zzeV()
  {
    if (this.zzDO == null) {
      return;
    }
    this.zzDO.zzeV();
  }
  
  public void zzfn() {}
  
  public void zzfo()
  {
    if (this.zzDO == null) {}
    while (this.zzDT != 0L) {
      return;
    }
    zza("canplaythrough", new String[] { "duration", String.valueOf(this.zzDO.getDuration() / 1000.0F), "videoWidth", String.valueOf(this.zzDO.getVideoWidth()), "videoHeight", String.valueOf(this.zzDO.getVideoHeight()) });
  }
  
  public void zzfp()
  {
    zzfy();
  }
  
  public void zzfq()
  {
    zza("ended", new String[0]);
    zzfz();
  }
  
  public void zzfr()
  {
    zzfv();
    this.zzDT = this.zzDS;
  }
  
  public void zzfs()
  {
    if (this.zzDO == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.zzzk))
    {
      this.zzDO.setMimeType(this.zzDU);
      this.zzDO.setVideoPath(this.zzzk);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public void zzft()
  {
    if (this.zzDO == null) {
      return;
    }
    TextView localTextView = new TextView(this.zzDO.getContext());
    localTextView.setText("AdMob - " + this.zzDO.zzeO());
    localTextView.setTextColor(-65536);
    localTextView.setBackgroundColor(65280);
    this.zzDM.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.zzDM.bringChildToFront(localTextView);
  }
  
  void zzfu()
  {
    if (this.zzDO == null) {}
    long l;
    do
    {
      return;
      l = this.zzDO.getCurrentPosition();
    } while ((this.zzDS == l) || (l <= 0L));
    zzfw();
    zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
    this.zzDS = l;
  }
  
  public void zzg(String paramString1, String paramString2)
  {
    zza("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */