package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zznx;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@zzha
public class zza
{
  public static final Handler zzLE = new Handler(Looper.getMainLooper());
  
  private void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup.getChildCount() != 0) {
      return;
    }
    Context localContext = paramViewGroup.getContext();
    TextView localTextView = new TextView(localContext);
    localTextView.setGravity(17);
    localTextView.setText(paramString);
    localTextView.setTextColor(paramInt1);
    localTextView.setBackgroundColor(paramInt2);
    paramString = new FrameLayout(localContext);
    paramString.setBackgroundColor(paramInt1);
    paramInt1 = zzb(localContext, 3);
    paramString.addView(localTextView, new FrameLayout.LayoutParams(paramAdSizeParcel.widthPixels - paramInt1, paramAdSizeParcel.heightPixels - paramInt1, 17));
    paramViewGroup.addView(paramString, paramAdSizeParcel.widthPixels, paramAdSizeParcel.heightPixels);
  }
  
  public String zzS(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = Settings.Secure.getString(paramContext, "android_id"))
    {
      if ((paramContext == null) || (zzhq())) {
        paramContext = "emulator";
      }
      return zzaE(paramContext);
    }
  }
  
  public boolean zzT(Context paramContext)
  {
    return GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0;
  }
  
  public boolean zzU(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation != 2) {}
    do
    {
      return false;
      paramContext = paramContext.getResources().getDisplayMetrics();
    } while ((int)(paramContext.heightPixels / paramContext.density) >= 600);
    return true;
  }
  
  public boolean zzV(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    int i;
    if (zznx.zzrS())
    {
      paramContext.getRealMetrics(localDisplayMetrics);
      j = localDisplayMetrics.heightPixels;
      i = localDisplayMetrics.widthPixels;
      paramContext.getMetrics(localDisplayMetrics);
      int k = localDisplayMetrics.heightPixels;
      int m = localDisplayMetrics.widthPixels;
      if ((k != j) || (m != i)) {
        break label141;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      label141:
      try
      {
        j = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        i = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public int zzW(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public int zza(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString)
  {
    zza(paramViewGroup, paramAdSizeParcel, paramString, -16777216, -1);
  }
  
  public void zza(ViewGroup paramViewGroup, AdSizeParcel paramAdSizeParcel, String paramString1, String paramString2)
  {
    zzb.zzaH(paramString2);
    zza(paramViewGroup, paramAdSizeParcel, paramString1, -65536, -16777216);
  }
  
  public String zzaE(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
        return (String)localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  public int zzb(Context paramContext, int paramInt)
  {
    return zza(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public int zzb(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return Math.round(paramInt / paramDisplayMetrics.density);
  }
  
  public int zzc(Context paramContext, int paramInt)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getMetrics(localDisplayMetrics);
    return zzb(localDisplayMetrics, paramInt);
  }
  
  public boolean zzhq()
  {
    return Build.DEVICE.startsWith("generic");
  }
  
  public boolean zzhr()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/util/client/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */