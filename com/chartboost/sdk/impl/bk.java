package com.chartboost.sdk.impl;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

public class bk
{
  private static final String[] a = { "arg:left", "arg:center", "arg:right" };
  private b b;
  
  public bk(final Context paramContext, Bundle paramBundle, final b paramb)
  {
    this.b = paramb;
    String str1 = paramBundle.getString("arg:title");
    String str2 = paramBundle.getString("arg:message");
    final int j = paramBundle.getInt("arg:default", -1);
    paramb = new ArrayList();
    final int i = 0;
    while (i < 3)
    {
      String str3 = paramBundle.getString(a[i]);
      if (!TextUtils.isEmpty(str3)) {
        paramb.add(str3);
      }
      i += 1;
    }
    paramContext = new AlertDialog.Builder(paramContext).setTitle(str1).setMessage(str2);
    i = paramb.size();
    switch (i)
    {
    }
    for (;;)
    {
      paramContext = paramContext.create();
      paramContext.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          paramAnonymousDialogInterface = bk.a(paramContext);
          final int i = 0;
          while (i < i)
          {
            CharSequence localCharSequence = (CharSequence)paramb.get(i);
            Object localObject = paramAnonymousDialogInterface[i];
            if (j == i) {
              ((Button)localObject).setTypeface(null, 1);
            }
            ((Button)localObject).setText(localCharSequence);
            ((Button)localObject).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                if (bk.a(bk.this) != null) {
                  bk.a(bk.this).a(bk.this, i);
                }
                bk.1.this.a.dismiss();
              }
            });
            i += 1;
          }
        }
      });
      paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          bk.a(bk.this).a(bk.this);
        }
      });
      paramContext.show();
      return;
      paramContext.setNegativeButton((CharSequence)paramb.get(2), null);
      paramContext.setNeutralButton((CharSequence)paramb.get(1), null);
      paramContext.setPositiveButton((CharSequence)paramb.get(0), null);
    }
  }
  
  private static final Button[] b(AlertDialog paramAlertDialog)
  {
    Object localObject = (ViewGroup)paramAlertDialog.getButton(-1).getParent();
    int j = ((ViewGroup)localObject).getChildCount();
    paramAlertDialog = new ArrayList();
    int i = 0;
    if (i < j)
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if (localView.getVisibility() != 0) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof Button)) {
          paramAlertDialog.add((Button)localView);
        }
      }
    }
    localObject = new Button[paramAlertDialog.size()];
    paramAlertDialog.toArray((Object[])localObject);
    return (Button[])localObject;
  }
  
  public static class a
  {
    private final Bundle a = new Bundle();
    
    public a a(String paramString)
    {
      this.a.putString("arg:title", paramString);
      return this;
    }
    
    public bk a(Context paramContext, bk.b paramb)
    {
      return new bk(paramContext, this.a, paramb);
    }
    
    public a b(String paramString)
    {
      this.a.putString("arg:message", paramString);
      return this;
    }
    
    public a c(String paramString)
    {
      this.a.putString("arg:left", paramString);
      return this;
    }
    
    public a d(String paramString)
    {
      this.a.putString("arg:right", paramString);
      return this;
    }
  }
  
  public static abstract class b
  {
    public void a(bk parambk) {}
    
    public abstract void a(bk parambk, int paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */