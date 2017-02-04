package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.j;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.c;
import com.chartboost.sdk.g;
import com.chartboost.sdk.g.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class av
  extends g
{
  private String A;
  protected j l = new j(this);
  protected j m = new j(this);
  private List<e.a> n = new ArrayList();
  private j o = new j(this);
  private j p = new j(this);
  private j q = new j(this);
  private j r = new j(this);
  private j s = new j(this);
  private j t = new j(this);
  private j u = new j(this);
  private Set<j> v;
  private int w;
  private e.a x;
  private int y;
  private int z;
  
  public av(a parama)
  {
    super(parama);
  }
  
  private void a(e.a parama, String paramString)
  {
    if (parama.b(paramString)) {
      return;
    }
    j localj = new j(this);
    this.v.add(localj);
    localj.a(parama, paramString, new Bundle());
  }
  
  public boolean a(e.a parama)
  {
    int i = 0;
    if (!super.a(parama)) {
      return false;
    }
    parama = parama.a("cells");
    if (parama.b())
    {
      a(CBError.CBImpressionError.INVALID_RESPONSE);
      return false;
    }
    this.v = new HashSet();
    if (i < parama.p())
    {
      e.a locala1 = parama.c(i);
      this.n.add(locala1);
      e.a locala2 = locala1.a("type");
      if (locala2.equals("regular"))
      {
        locala1 = locala1.a("assets");
        if (locala1.c()) {
          a(locala1, "icon");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (locala2.equals("featured"))
        {
          locala1 = locala1.a("assets");
          if (locala1.c())
          {
            a(locala1, "portrait");
            a(locala1, "landscape");
          }
        }
        else if (!locala2.equals("webview")) {}
      }
    }
    this.o.a("close");
    this.q.a("close-landscape");
    this.p.a("close-portrait");
    this.u.a("header-center");
    this.r.a("header-portrait");
    this.s.a("header-landscape");
    this.t.a("header-tile");
    this.m.a("play-button");
    this.l.a("install-button");
    this.x = this.f.a("header-height");
    if (this.x.c())
    {
      this.w = this.x.l();
      if (!this.f.c("background-color")) {
        break label401;
      }
      i = a(this.f.e("background-color"));
      label311:
      this.y = i;
      if (!this.f.c("header-text")) {
        break label407;
      }
      parama = this.f.e("header-text");
      label338:
      this.A = parama;
      if (!this.f.c("text-color")) {
        break label413;
      }
    }
    label401:
    label407:
    label413:
    for (i = a(this.f.e("text-color"));; i = -1)
    {
      this.z = i;
      return true;
      if (a(c.y())) {}
      for (i = 80;; i = 40)
      {
        this.w = i;
        break;
      }
      i = -14571545;
      break label311;
      parama = "More Free Games";
      break label338;
    }
  }
  
  protected g.a b(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void d()
  {
    super.d();
    this.n = null;
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).d();
    }
    this.v.clear();
    this.o.d();
    this.q.d();
    this.p.d();
    this.u.d();
    this.t.d();
    this.r.d();
    this.s.d();
    this.m.d();
    this.l.d();
  }
  
  public class a
    extends g.a
  {
    private bj c;
    private bi d;
    private TextView e;
    private RelativeLayout f;
    private ListView g;
    private a h;
    
    private a(Context paramContext)
    {
      super(paramContext);
      setBackgroundColor(-1);
      this.d = new bi(paramContext);
      this.c = new bj(paramContext)
      {
        protected void a(MotionEvent paramAnonymousMotionEvent)
        {
          av.a(av.this);
        }
      };
      this.e = new TextView(paramContext);
      this.e.setBackgroundColor(av.b(av.this));
      this.e.setText(av.c(av.this));
      this.e.setTextColor(av.d(av.this));
      this$1 = this.e;
      if (c()) {}
      for (float f1 = 30.0F;; f1 = 18.0F)
      {
        av.this.setTextSize(2, f1);
        this.e.setGravity(17);
        this.g = new ListView(paramContext);
        this.g.setBackgroundColor(-1);
        this.g.setDividerHeight(0);
        a(this.g);
        addView(this.g);
        this.d.setFocusable(false);
        this.c.setFocusable(false);
        this.c.setClickable(true);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.a(ImageView.ScaleType.FIT_CENTER);
        this.f = new RelativeLayout(paramContext);
        this.f.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        this.f.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        a(this.f);
        this.h = new a(paramContext);
        return;
      }
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      Context localContext = getContext();
      f localf = CBUtility.c();
      Object localObject;
      if ((localf.a()) && (av.e(av.this).e())) {
        localObject = av.e(av.this);
      }
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        RelativeLayout.LayoutParams localLayoutParams3;
        if (localObject != null)
        {
          av.a(av.this, ((j)localObject).i());
          if (((j)localObject).h() < paramInt1) {
            av.a(av.this, Math.round(av.h(av.this) * (paramInt1 / ((j)localObject).h())));
          }
          this.e.setVisibility(8);
          this.d.a((j)localObject);
          if (av.i(av.this).c()) {
            av.a(av.this, CBUtility.a(av.i(av.this).l(), localContext));
          }
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams3 = new RelativeLayout.LayoutParams(-1, av.h(av.this));
          if ((!av.j(av.this).e()) || (!localf.a())) {
            break label463;
          }
          localObject = av.j(av.this);
        }
        for (;;)
        {
          label224:
          if (localObject != null)
          {
            this.c.a((j)localObject, localLayoutParams2);
            if (c()) {}
            for (paramInt1 = 14;; paramInt1 = 7)
            {
              paramInt1 = CBUtility.a(paramInt1, localContext);
              paramInt2 = Math.round((av.h(av.this) - localLayoutParams2.height) / 2.0F);
              localLayoutParams2.rightMargin = paramInt1;
              localLayoutParams2.topMargin = paramInt2;
              localLayoutParams2.addRule(11);
              localLayoutParams1.width = -1;
              localLayoutParams1.height = -1;
              localLayoutParams1.addRule(3, this.f.getId());
              this.g.setAdapter(this.h);
              this.g.setLayoutParams(localLayoutParams1);
              this.c.setLayoutParams(localLayoutParams2);
              this.f.setLayoutParams(localLayoutParams3);
              return;
              if ((localf.b()) && (av.f(av.this).e()))
              {
                localObject = av.f(av.this);
                break;
              }
              if (!av.g(av.this).e()) {
                break label661;
              }
              localObject = av.g(av.this);
              break;
              localObject = av.this;
              if (c()) {}
              for (paramInt1 = 80;; paramInt1 = 40)
              {
                av.a((av)localObject, CBUtility.a(paramInt1, localContext));
                this.e.setVisibility(0);
                break;
              }
              label463:
              if ((av.k(av.this).e()) && (localf.b()))
              {
                localObject = av.k(av.this);
                break label224;
              }
              if (!av.l(av.this).e()) {
                break label655;
              }
              localObject = av.l(av.this);
              break label224;
            }
          }
          this.c.a("X");
          localObject = this.c.a();
          float f1;
          if (c())
          {
            f1 = 26.0F;
            label556:
            ((TextView)localObject).setTextSize(2, f1);
            this.c.a().setTextColor(av.d(av.this));
            this.c.a().setTypeface(Typeface.SANS_SERIF, 1);
            localLayoutParams2.width = (av.h(av.this) / 2);
            localLayoutParams2.height = (av.h(av.this) / 3);
            if (!c()) {
              break label649;
            }
          }
          label649:
          for (paramInt1 = 30;; paramInt1 = 20)
          {
            paramInt1 = CBUtility.a(paramInt1, localContext);
            break;
            f1 = 16.0F;
            break label556;
          }
          label655:
          localObject = null;
        }
        label661:
        localObject = null;
      }
    }
    
    public void b()
    {
      super.b();
      this.c = null;
      this.d = null;
      this.g = null;
    }
    
    public class a
      extends ArrayAdapter<e.a>
    {
      private Context b;
      
      public a(Context paramContext)
      {
        super(0, av.m(av.this));
        this.b = paramContext;
      }
      
      public e.a a(int paramInt)
      {
        return (e.a)av.m(av.this).get(paramInt);
      }
      
      public int getCount()
      {
        return av.m(av.this).size();
      }
      
      public int getItemViewType(int paramInt)
      {
        e.a locala = a(paramInt).a("type");
        av.b[] arrayOfb = av.b.values();
        paramInt = 0;
        while (paramInt < arrayOfb.length)
        {
          if (locala.equals(av.b.a(arrayOfb[paramInt]))) {
            return paramInt;
          }
          paramInt += 1;
        }
        return 0;
      }
      
      public View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
      {
        int i = 0;
        final e.a locala = a(paramInt);
        paramViewGroup = locala.a("type");
        if (paramView == null)
        {
          paramView = av.b.values();
          if (i >= paramView.length) {
            break label235;
          }
          if (!paramViewGroup.equals(av.b.a(paramView[i]))) {}
        }
        for (;;)
        {
          try
          {
            paramView = (ao)av.b.b(paramView[i]).getConstructor(new Class[] { av.class, Context.class }).newInstance(new Object[] { av.this, this.b });
            if (paramView != null) {
              break label156;
            }
            paramViewGroup = new View(getContext());
            return paramViewGroup;
          }
          catch (Exception paramView)
          {
            CBLogging.b(this, "error in more apps list", paramView);
            paramView = null;
            continue;
          }
          i += 1;
          break;
          paramViewGroup = paramView;
          if ((paramView instanceof ao))
          {
            paramView = (ao)paramView;
            continue;
            label156:
            paramView.a(locala, paramInt);
            paramViewGroup = paramView.getLayoutParams();
            if ((paramViewGroup != null) && ((paramViewGroup instanceof AbsListView.LayoutParams)))
            {
              paramViewGroup = (AbsListView.LayoutParams)paramViewGroup;
              paramViewGroup.width = -1;
              paramViewGroup.height = paramView.a();
            }
            for (;;)
            {
              paramView.setLayoutParams(paramViewGroup);
              paramView.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  String str = locala.e("deep-link");
                  if (!TextUtils.isEmpty(str))
                  {
                    paramAnonymousView = str;
                    if (ba.a(str)) {}
                  }
                  else
                  {
                    paramAnonymousView = locala.e("link");
                  }
                  if (Build.VERSION.SDK_INT >= 11)
                  {
                    locala.a("x", Float.valueOf(av.a.this.getX()));
                    locala.a("y", Float.valueOf(av.a.this.getY()));
                    locala.a("width", Integer.valueOf(paramView.getHeight()));
                    locala.a("height", Integer.valueOf(paramView.getWidth()));
                  }
                  av.this.a(paramAnonymousView, locala);
                }
              });
              return paramView;
              paramViewGroup = new AbsListView.LayoutParams(-1, paramView.a());
            }
            label235:
            paramView = null;
          }
        }
      }
      
      public int getViewTypeCount()
      {
        return av.b.values().length;
      }
    }
  }
  
  private static enum b
  {
    private String e;
    private Class<? extends ao> f;
    
    private b(String paramString, Class<? extends ao> paramClass)
    {
      this.e = paramString;
      this.f = paramClass;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */