package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.j;

public final class ai
  extends al
{
  private LinearLayout b;
  private bi c;
  private TextView d;
  
  public ai(Context paramContext, ah paramah)
  {
    super(paramContext, paramah);
  }
  
  protected View a()
  {
    Context localContext = getContext();
    int i = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0F);
    this.b = new LinearLayout(localContext);
    this.b.setOrientation(0);
    this.b.setGravity(17);
    int j = CBUtility.a(36, localContext);
    this.c = new bi(localContext);
    this.c.setPadding(i, i, i, i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.d = new TextView(localContext);
    this.d.setPadding(i / 2, i, i, i);
    this.d.setTextColor(-15264491);
    this.d.setTextSize(2, 16.0F);
    this.d.setTypeface(null, 1);
    this.d.setGravity(17);
    this.b.addView(this.c, localLayoutParams);
    this.b.addView(this.d, new LinearLayout.LayoutParams(-2, -1));
    return this.b;
  }
  
  public void a(j paramj)
  {
    this.c.a(paramj);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  protected int b()
  {
    return 48;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */