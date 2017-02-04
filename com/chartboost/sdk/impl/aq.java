package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.g;

public class aq
  extends ao
{
  private av a;
  private TextView b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private at f;
  private bj g;
  private int h;
  private Point i;
  private j j;
  private View.OnClickListener k;
  
  public aq(av paramav, Context paramContext)
  {
    super(paramContext);
    this.a = paramav;
    this.e = new LinearLayout(paramContext);
    this.e.setOrientation(1);
    setGravity(16);
    boolean bool = g.a(paramContext);
    this.b = new TextView(paramContext);
    this.b.setTypeface(null, 1);
    paramav = this.b;
    if (bool)
    {
      f1 = 21.0F;
      paramav.setTextSize(2, f1);
      this.b.setTextColor(-16777216);
      this.b.setSingleLine();
      this.b.setEllipsize(TextUtils.TruncateAt.END);
      this.c = new TextView(paramContext);
      paramav = this.c;
      if (!bool) {
        break label378;
      }
      f1 = 16.0F;
      label133:
      paramav.setTextSize(2, f1);
      this.c.setTextColor(-16777216);
      this.c.setSingleLine();
      this.c.setEllipsize(TextUtils.TruncateAt.END);
      this.d = new TextView(paramContext);
      paramav = this.d;
      if (!bool) {
        break label384;
      }
    }
    label378:
    label384:
    for (float f1 = 18.0F;; f1 = 11.0F)
    {
      paramav.setTextSize(2, f1);
      this.d.setTextColor(-16777216);
      this.d.setMaxLines(2);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      this.g = new bj(paramContext)
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          aq.b(aq.this).onClick(aq.a(aq.this));
        }
      };
      this.g.a(ImageView.ScaleType.FIT_CENTER);
      this.f = new at(paramContext);
      setFocusable(false);
      setGravity(16);
      addView(this.f);
      addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0F));
      addView(this.g);
      setBackgroundColor(0);
      this.e.addView(this.b, new LinearLayout.LayoutParams(-1, -2));
      this.e.addView(this.c, new LinearLayout.LayoutParams(-1, -2));
      this.e.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
      return;
      f1 = 16.0F;
      break;
      f1 = 10.0F;
      break label133;
    }
  }
  
  private void a(bi parambi, int paramInt, e.a parama)
  {
    if (parama.b()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    String str2 = "";
    String str1 = str2;
    if (parama.e("checksum") != null)
    {
      str1 = str2;
      if (!parama.e("checksum").isEmpty()) {
        str1 = parama.e("checksum");
      }
    }
    bb.a().a(parama.e("url"), str1, null, parambi, localBundle);
  }
  
  private int c()
  {
    int m = 74;
    if (CBUtility.c().b()) {
      if (!g.a(getContext())) {}
    }
    for (;;)
    {
      return CBUtility.a(m, getContext());
      m = 41;
      continue;
      if (!g.a(getContext())) {
        m = 41;
      }
    }
  }
  
  public int a()
  {
    int m = 134;
    if (CBUtility.c().b()) {
      if (!g.a(getContext())) {}
    }
    for (;;)
    {
      return CBUtility.a(m, getContext());
      m = 75;
      continue;
      if (!g.a(getContext())) {
        m = 77;
      }
    }
  }
  
  public void a(e.a parama, int paramInt)
  {
    this.b.setText(parama.a("name").d("Unknown App"));
    if (TextUtils.isEmpty(parama.e("publisher")))
    {
      this.c.setVisibility(8);
      if (!TextUtils.isEmpty(parama.e("description"))) {
        break label359;
      }
      this.d.setVisibility(8);
      label60:
      if (!parama.b("border-color")) {
        break label375;
      }
      m = -4802890;
      label72:
      this.h = m;
      if (!parama.c("offset")) {
        break label388;
      }
      this.i = new Point(parama.a("offset").f("x"), parama.a("offset").f("y"));
      label119:
      this.j = null;
      if ((!parama.c("deep-link")) || (!ba.a(parama.e("deep-link")))) {
        break label417;
      }
      if (!this.a.m.e()) {
        break label404;
      }
      this.j = this.a.m;
      label169:
      if (!g.a(getContext())) {
        break label457;
      }
      m = 14;
      label182:
      m = CBUtility.a(m, getContext());
      if (this.j == null) {
        break label463;
      }
      this.g.a(this.j);
    }
    for (int m = m * 2 + Math.round(this.j.b() * c() / this.j.c());; m = CBUtility.a(100, getContext()))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, c());
      this.g.setLayoutParams(localLayoutParams);
      removeView(this.f);
      this.f = new at(getContext());
      addView(this.f, 0);
      a(this.f, paramInt, parama.a("assets").a("icon"));
      this.f.a(this.h);
      this.f.a(0.16666667F);
      b();
      return;
      this.c.setText(parama.e("publisher"));
      break;
      label359:
      this.d.setText(parama.e("description"));
      break label60;
      label375:
      m = g.a(parama.e("border-color"));
      break label72;
      label388:
      this.i = new Point(0, 0);
      break label119;
      label404:
      this.g.a("Play");
      break label169;
      label417:
      if (this.a.l.e())
      {
        this.j = this.a.l;
        break label169;
      }
      this.g.a("Install");
      break label169;
      label457:
      m = 7;
      break label182;
      label463:
      this.g.a().setTextColor(-14571545);
      m = CBUtility.a(8, getContext());
      this.g.a().setPadding(m, m, m, m);
    }
  }
  
  protected void b()
  {
    if (g.a(getContext())) {}
    for (int m = 14;; m = 7)
    {
      m = CBUtility.a(m, getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a() - m * 2, a() - m * 2);
      localLayoutParams.setMargins(m, m, m, m);
      this.e.setPadding(0, m, 0, m);
      this.g.setPadding(this.i.x * 2 + m, this.i.y * 2, m, 0);
      this.f.setLayoutParams(localLayoutParams);
      this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.k = paramOnClickListener;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */