package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.j;

public final class af
  extends al
{
  private LinearLayout b;
  private LinearLayout c;
  private bi d;
  private bj e;
  private TextView f;
  private TextView g;
  
  public af(Context paramContext, ah paramah)
  {
    super(paramContext, paramah);
  }
  
  protected View a()
  {
    Context localContext = getContext();
    int i = Math.round(getContext().getResources().getDisplayMetrics().density * 6.0F);
    this.b = new LinearLayout(localContext);
    this.b.setOrientation(0);
    this.b.setGravity(17);
    this.c = new LinearLayout(localContext);
    this.c.setOrientation(1);
    this.c.setGravity(19);
    this.d = new bi(localContext);
    this.d.setPadding(i, i, i, i);
    if (this.a.H.e()) {
      this.d.a(this.a.H);
    }
    this.e = new bj(localContext)
    {
      protected void a(MotionEvent paramAnonymousMotionEvent)
      {
        af.this.a.r().b(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY(), super.getWidth(), super.getHeight());
      }
    };
    this.e.setPadding(i, i, i, i);
    if (this.a.I.e()) {
      this.e.a(this.a.I);
    }
    this.f = new TextView(getContext());
    this.f.setTextColor(-15264491);
    this.f.setTypeface(null, 1);
    this.f.setGravity(3);
    this.f.setPadding(i, i, i, i / 2);
    this.g = new TextView(getContext());
    this.g.setTextColor(-15264491);
    this.g.setTypeface(null, 1);
    this.g.setGravity(3);
    this.g.setPadding(i, 0, i, i);
    this.f.setTextSize(2, 14.0F);
    this.g.setTextSize(2, 11.0F);
    this.c.addView(this.f);
    this.c.addView(this.g);
    this.b.addView(this.d);
    this.b.addView(this.c, new LinearLayout.LayoutParams(0, -2, 1.0F));
    this.b.addView(this.e);
    return this.b;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.f.setText(paramString1);
    this.g.setText(paramString2);
  }
  
  protected int b()
  {
    return 72;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */