package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class bn
  extends LinearLayout
{
  private TextView a;
  private bp b;
  
  public bn(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setGravity(17);
    this.a = new TextView(getContext());
    this.a.setTextColor(-1);
    this.a.setTextSize(2, 16.0F);
    this.a.setTypeface(null, 1);
    this.a.setText("Loading...");
    this.a.setGravity(17);
    this.b = new bp(getContext());
    addView(this.a);
    addView(this.b);
    a();
  }
  
  public void a()
  {
    removeView(this.a);
    removeView(this.b);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = Math.round(20.0F * f);
    setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(i, i, i, 0);
    addView(this.a, localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, Math.round(f * 32.0F));
    localLayoutParams.setMargins(i, i, i, i);
    addView(this.b, localLayoutParams);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */