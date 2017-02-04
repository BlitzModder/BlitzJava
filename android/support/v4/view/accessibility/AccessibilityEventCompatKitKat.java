package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompatKitKat
{
  public static int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getContentChangeTypes();
  }
  
  public static void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    paramAccessibilityEvent.setContentChangeTypes(paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityEventCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */