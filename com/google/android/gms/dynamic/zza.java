package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T zzatr;
  private Bundle zzats;
  private LinkedList<zza> zzatt;
  private final zzf<T> zzatu = new zzf()
  {
    public void zza(T paramAnonymousT)
    {
      zza.zza(zza.this, paramAnonymousT);
      paramAnonymousT = zza.zza(zza.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((zza.zza)paramAnonymousT.next()).zzb(zza.zzb(zza.this));
      }
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };
  
  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.zzatr != null)
    {
      paramzza.zzb(this.zzatr);
      return;
    }
    if (this.zzatt == null) {
      this.zzatt = new LinkedList();
    }
    this.zzatt.add(paramzza);
    if (paramBundle != null)
    {
      if (this.zzats != null) {
        break label76;
      }
      this.zzats = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(this.zzatu);
      return;
      label76:
      this.zzats.putAll(paramBundle);
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    final int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(localContext);
    String str2 = zzg.zzc(localContext, i, GooglePlayServicesUtil.zzam(localContext));
    String str1 = zzg.zzh(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    if (str1 != null)
    {
      paramFrameLayout = new Button(localContext);
      paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramFrameLayout.setText(str1);
      localLinearLayout.addView(paramFrameLayout);
      paramFrameLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.zzsm.startActivity(GooglePlayServicesUtil.zzbv(i));
        }
      });
    }
  }
  
  private void zzeF(int paramInt)
  {
    while ((!this.zzatt.isEmpty()) && (((zza)this.zzatt.getLast()).getState() >= paramInt)) {
      this.zzatt.removeLast();
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 1;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 2;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(zza.zzb(zza.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (this.zzatr == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.zzatr != null)
    {
      this.zzatr.onDestroy();
      return;
    }
    zzeF(1);
  }
  
  public void onDestroyView()
  {
    if (this.zzatr != null)
    {
      this.zzatr.onDestroyView();
      return;
    }
    zzeF(2);
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    zza(paramBundle2, new zza()
    {
      public int getState()
      {
        return 0;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (this.zzatr != null) {
      this.zzatr.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.zzatr != null)
    {
      this.zzatr.onPause();
      return;
    }
    zzeF(5);
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.zzatr != null) {
      this.zzatr.onSaveInstanceState(paramBundle);
    }
    while (this.zzats == null) {
      return;
    }
    paramBundle.putAll(this.zzats);
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (this.zzatr != null)
    {
      this.zzatr.onStop();
      return;
    }
    zzeF(4);
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zzf<T> paramzzf);
  
  public T zzts()
  {
    return this.zzatr;
  }
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/dynamic/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */