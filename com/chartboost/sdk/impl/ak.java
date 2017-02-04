package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.g;

public final class ak
  extends LinearLayout
{
  private ah a;
  private LinearLayout b;
  private bi c;
  private TextView d;
  private bj e;
  private int f = Integer.MIN_VALUE;
  
  public ak(Context paramContext, ah paramah)
  {
    super(paramContext);
    this.a = paramah;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = getContext();
    int i = Math.round(getContext().getResources().getDisplayMetrics().density * 8.0F);
    setOrientation(1);
    setGravity(17);
    this.b = new LinearLayout((Context)localObject);
    this.b.setGravity(17);
    this.b.setOrientation(0);
    this.b.setPadding(i, i, i, i);
    this.c = new bi((Context)localObject);
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.c.setPadding(0, 0, i, 0);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.a.a((ViewGroup.LayoutParams)localObject, this.a.F, 1.0F);
    this.d = new TextView(getContext());
    this.d.setTextColor(-1);
    this.d.setTypeface(null, 1);
    this.d.setGravity(17);
    TextView localTextView = this.d;
    if (g.a(paramContext)) {}
    for (float f1 = 26.0F;; f1 = 16.0F)
    {
      localTextView.setTextSize(2, f1);
      this.b.addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.b.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
      this.e = new bj(getContext())
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          ak.a(ak.this).setEnabled(false);
          ak.b(ak.this).r().h();
        }
      };
      this.e.setPadding(0, 0, 0, i);
      this.e.a(ImageView.ScaleType.FIT_CENTER);
      this.e.setPadding(i, i, i, i);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      this.a.a(paramContext, this.a.E, 1.0F);
      if (this.a.F.e()) {
        this.c.a(this.a.F);
      }
      if (this.a.E.e()) {
        this.e.a(this.a.E);
      }
      addView(this.b, new LinearLayout.LayoutParams(-2, -2));
      addView(this.e, paramContext);
      a();
      return;
    }
  }
  
  public void a()
  {
    a(this.a.t());
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d.setText(paramString);
    this.f = paramInt;
    a(this.a.t());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -16777216;; i = this.f)
    {
      setBackgroundColor(i);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */