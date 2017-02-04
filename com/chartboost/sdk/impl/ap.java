package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;

public class ap
  extends ao
{
  private ImageView a;
  
  public ap(av paramav, Context paramContext)
  {
    super(paramContext);
    this.a = new ImageView(paramContext);
    addView(this.a, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public int a()
  {
    return CBUtility.a(110, getContext());
  }
  
  public void a(e.a parama, int paramInt)
  {
    boolean bool = CBUtility.c().a();
    Object localObject = parama.a("assets");
    if (bool) {}
    for (parama = "portrait";; parama = "landscape")
    {
      e.a locala = ((e.a)localObject).a(parama);
      if (locala.c())
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", paramInt);
        localObject = "";
        parama = (e.a)localObject;
        if (locala.e("checksum") != null)
        {
          parama = (e.a)localObject;
          if (!locala.e("checksum").isEmpty()) {
            parama = locala.e("checksum");
          }
        }
        bb.a().a(locala.e("url"), parama, null, this.a, localBundle);
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */