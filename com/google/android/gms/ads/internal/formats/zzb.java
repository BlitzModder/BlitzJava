package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zziq;
import java.util.Iterator;
import java.util.List;

@zzha
class zzb
  extends RelativeLayout
{
  private static final float[] zzxt = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private final RelativeLayout zzxu;
  private AnimationDrawable zzxv;
  
  public zzb(Context paramContext, zza paramzza)
  {
    super(paramContext);
    zzx.zzy(paramzza);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    Object localObject2 = new ShapeDrawable(new RoundRectShape(zzxt, null, null));
    ((ShapeDrawable)localObject2).getPaint().setColor(paramzza.getBackgroundColor());
    this.zzxu = new RelativeLayout(paramContext);
    this.zzxu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    zzp.zzbz().zza(this.zzxu, (Drawable)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    if (!TextUtils.isEmpty(paramzza.getText()))
    {
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      TextView localTextView = new TextView(paramContext);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localTextView.setId(1195835393);
      localTextView.setTypeface(Typeface.DEFAULT);
      localTextView.setText(paramzza.getText());
      localTextView.setTextColor(paramzza.getTextColor());
      localTextView.setTextSize(paramzza.getTextSize());
      localTextView.setPadding(zzl.zzcN().zzb(paramContext, 4), 0, zzl.zzcN().zzb(paramContext, 4), 0);
      this.zzxu.addView(localTextView);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, localTextView.getId());
    }
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setId(1195835394);
    localObject1 = paramzza.zzdz();
    if (((List)localObject1).size() > 1)
    {
      this.zzxv = new AnimationDrawable();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Drawable)((Iterator)localObject1).next();
        this.zzxv.addFrame((Drawable)localObject2, paramzza.zzdA());
      }
      zzp.zzbz().zza(paramContext, this.zzxv);
    }
    for (;;)
    {
      this.zzxu.addView(paramContext);
      addView(this.zzxu);
      return;
      if (((List)localObject1).size() == 1) {
        paramContext.setImageDrawable((Drawable)((List)localObject1).get(0));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    if (this.zzxv != null) {
      this.zzxv.start();
    }
    super.onAttachedToWindow();
  }
  
  public ViewGroup zzdB()
  {
    return this.zzxu;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */