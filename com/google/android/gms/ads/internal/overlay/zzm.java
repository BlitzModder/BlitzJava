package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzha;

@zzha
public class zzm
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzDV;
  private final zzo zzDW;
  
  public zzm(Context paramContext, int paramInt, zzo paramzzo)
  {
    super(paramContext);
    this.zzDW = paramzzo;
    setOnClickListener(this);
    this.zzDV = new ImageButton(paramContext);
    this.zzDV.setImageResource(17301527);
    this.zzDV.setBackgroundColor(0);
    this.zzDV.setOnClickListener(this);
    this.zzDV.setPadding(0, 0, 0, 0);
    this.zzDV.setContentDescription("Interstitial close button");
    paramInt = zzl.zzcN().zzb(paramContext, paramInt);
    addView(this.zzDV, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void onClick(View paramView)
  {
    if (this.zzDW != null) {
      this.zzDW.zzfb();
    }
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        this.zzDV.setVisibility(4);
        return;
      }
      this.zzDV.setVisibility(8);
      return;
    }
    this.zzDV.setVisibility(0);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */