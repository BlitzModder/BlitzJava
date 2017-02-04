package com.dava.framework;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoftKeyboardStateHelper
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View activityRootView;
  private boolean isSoftKeyboardOpened;
  private Rect lastSoftKeyboardBounds;
  private final List<SoftKeyboardStateListener> listeners = new LinkedList();
  
  public SoftKeyboardStateHelper(View paramView)
  {
    this(paramView, false);
  }
  
  public SoftKeyboardStateHelper(View paramView, boolean paramBoolean)
  {
    this.activityRootView = paramView;
    this.isSoftKeyboardOpened = paramBoolean;
    subscribe();
  }
  
  private void notifyOnSoftKeyboardClosed()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardClosed();
      }
    }
  }
  
  private void notifyOnSoftKeyboardOpened(Rect paramRect)
  {
    this.lastSoftKeyboardBounds = paramRect;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateListener)localIterator.next();
      if (localSoftKeyboardStateListener != null) {
        localSoftKeyboardStateListener.onSoftKeyboardOpened(paramRect);
      }
    }
  }
  
  public void addSoftKeyboardStateListener(SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.listeners.add(paramSoftKeyboardStateListener);
  }
  
  public Rect getLastSoftKeyboardBounds()
  {
    return this.lastSoftKeyboardBounds;
  }
  
  public boolean isSoftKeyboardOpened()
  {
    return this.isSoftKeyboardOpened;
  }
  
  public void onGlobalLayout()
  {
    int i = this.activityRootView.getRootView().getHeight() / 4;
    Rect localRect = new Rect();
    this.activityRootView.getWindowVisibleDisplayFrame(localRect);
    int j = this.activityRootView.getRootView().getHeight() - (localRect.bottom - localRect.top);
    if ((!this.isSoftKeyboardOpened) && (j > i))
    {
      this.isSoftKeyboardOpened = true;
      notifyOnSoftKeyboardOpened(new Rect(localRect.left, localRect.bottom, localRect.right, localRect.bottom + j));
    }
    while ((!this.isSoftKeyboardOpened) || (j >= i)) {
      return;
    }
    this.isSoftKeyboardOpened = false;
    notifyOnSoftKeyboardClosed();
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    this.listeners.remove(paramSoftKeyboardStateListener);
  }
  
  public void setIsSoftKeyboardOpened(boolean paramBoolean)
  {
    this.isSoftKeyboardOpened = paramBoolean;
  }
  
  public void subscribe()
  {
    if (this.activityRootView != null) {
      this.activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }
  
  public void unsubscribe()
  {
    ViewTreeObserver localViewTreeObserver;
    if (this.activityRootView != null)
    {
      localViewTreeObserver = this.activityRootView.getViewTreeObserver();
      if (Build.VERSION.SDK_INT < 16) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
    }
    else
    {
      return;
    }
    localViewTreeObserver.removeOnGlobalLayoutListener(this);
  }
  
  public static abstract interface SoftKeyboardStateListener
  {
    public abstract void onSoftKeyboardClosed();
    
    public abstract void onSoftKeyboardOpened(Rect paramRect);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/SoftKeyboardStateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */