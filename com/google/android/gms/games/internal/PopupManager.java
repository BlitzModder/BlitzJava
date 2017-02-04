package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.zznx;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl zzaDb;
  protected PopupLocationInfo zzaDc;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.zzaDb = paramGamesClientImpl;
    zzgn(paramInt);
  }
  
  public static PopupManager zza(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (zznx.zzrO()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  public void setGravity(int paramInt)
  {
    this.zzaDc.gravity = paramInt;
  }
  
  protected void zzgn(int paramInt)
  {
    this.zzaDc = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void zzp(View paramView) {}
  
  public void zzwA()
  {
    this.zzaDb.zza(this.zzaDc.zzaDd, this.zzaDc.zzwz());
  }
  
  public Bundle zzwB()
  {
    return this.zzaDc.zzwz();
  }
  
  public IBinder zzwC()
  {
    return this.zzaDc.zzaDd;
  }
  
  public PopupLocationInfo zzwD()
  {
    return this.zzaDc;
  }
  
  public static final class PopupLocationInfo
  {
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    public IBinder zzaDd;
    public int zzaDe = -1;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.zzaDd = paramIBinder;
    }
    
    public Bundle zzwz()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.zzaDe);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class PopupManagerHCMR1
    extends PopupManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean zzaBA = false;
    private WeakReference<View> zzaDf;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void zzq(View paramView)
    {
      int j = -1;
      int i = j;
      if (zznx.zzrS())
      {
        localObject = paramView.getDisplay();
        i = j;
        if (localObject != null) {
          i = ((Display)localObject).getDisplayId();
        }
      }
      Object localObject = paramView.getWindowToken();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      j = paramView.getWidth();
      int k = paramView.getHeight();
      this.zzaDc.zzaDe = i;
      this.zzaDc.zzaDd = ((IBinder)localObject);
      this.zzaDc.left = arrayOfInt[0];
      this.zzaDc.top = arrayOfInt[1];
      this.zzaDc.right = (arrayOfInt[0] + j);
      this.zzaDc.bottom = (arrayOfInt[1] + k);
      if (this.zzaBA)
      {
        zzwA();
        this.zzaBA = false;
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.zzaDf == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.zzaDf.get();
      } while (localView == null);
      zzq(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      zzq(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.zzaDb.zzwn();
      paramView.removeOnAttachStateChangeListener(this);
    }
    
    protected void zzgn(int paramInt)
    {
      this.zzaDc = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void zzp(View paramView)
    {
      this.zzaDb.zzwn();
      Object localObject2;
      Object localObject1;
      if (this.zzaDf != null)
      {
        localObject2 = (View)this.zzaDf.get();
        Context localContext = this.zzaDb.getContext();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if ((localContext instanceof Activity)) {
            localObject1 = ((Activity)localContext).getWindow().getDecorView();
          }
        }
        if (localObject1 != null)
        {
          ((View)localObject1).removeOnAttachStateChangeListener(this);
          localObject1 = ((View)localObject1).getViewTreeObserver();
          if (!zznx.zzrR()) {
            break label186;
          }
          ((ViewTreeObserver)localObject1).removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.zzaDf = null;
        localObject2 = this.zzaDb.getContext();
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((localObject2 instanceof Activity))
          {
            localObject1 = ((Activity)localObject2).findViewById(16908290);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = ((Activity)localObject2).getWindow().getDecorView();
            }
            GamesLog.zzA("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
            localObject1 = paramView;
          }
        }
        if (localObject1 == null) {
          break;
        }
        zzq((View)localObject1);
        this.zzaDf = new WeakReference(localObject1);
        ((View)localObject1).addOnAttachStateChangeListener(this);
        ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label186:
        ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      }
      GamesLog.zzB("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void zzwA()
    {
      if (this.zzaDc.zzaDd != null)
      {
        super.zzwA();
        return;
      }
      if (this.zzaDf != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.zzaBA = bool;
        return;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */