package com.chartboost.sdk.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.g.a;

public class ar
  extends aq
{
  private av a;
  private Button b;
  private bf c;
  private e.a d;
  
  public ar(av paramav, Context paramContext)
  {
    super(paramav, paramContext);
    this.a = paramav;
    this.b = new Button(paramContext);
    this.b.setTextColor(-14571545);
    this.b.setText("Preview");
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ar.a(ar.this);
      }
    });
    addView(this.b, 2);
  }
  
  private void c()
  {
    CBLogging.c(this, "play the video");
    if (this.c == null)
    {
      this.c = new bf(getContext());
      this.a.e().addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.c.setVisibility(8);
    }
    this.c.a().a(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        bg.a(false, ar.b(ar.this));
      }
    });
    bg.a(true, this.c);
    this.c.a().a();
  }
  
  public void a(e.a parama, int paramInt)
  {
    super.a(parama, paramInt);
    this.d = parama;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */