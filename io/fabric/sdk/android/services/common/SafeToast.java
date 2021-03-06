package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import io.fabric.sdk.android.services.concurrency.PriorityRunnable;

public class SafeToast
  extends Toast
{
  public SafeToast(Context paramContext)
  {
    super(paramContext);
  }
  
  public static Toast makeText(Context paramContext, int paramInt1, int paramInt2)
    throws Resources.NotFoundException
  {
    return makeText(paramContext, paramContext.getResources().getText(paramInt1), paramInt2);
  }
  
  public static Toast makeText(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = Toast.makeText(paramContext, paramCharSequence, paramInt);
    paramContext = new SafeToast(paramContext);
    paramContext.setView(paramCharSequence.getView());
    paramContext.setDuration(paramCharSequence.getDuration());
    return paramContext;
  }
  
  public void show()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.show();
      return;
    }
    new Handler(Looper.getMainLooper()).post(new PriorityRunnable()
    {
      public void run()
      {
        SafeToast.this.show();
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/io/fabric/sdk/android/services/common/SafeToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */