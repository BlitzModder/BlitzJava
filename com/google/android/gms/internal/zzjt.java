package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzjt
  extends WebChromeClient
{
  private final zzjn zzps;
  
  public zzjt(zzjn paramzzjn)
  {
    this.zzps = paramzzjn;
  }
  
  private final Context zza(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzjn)) {
      paramWebView = paramWebView.getContext();
    }
    zzjn localzzjn;
    Activity localActivity;
    do
    {
      return paramWebView;
      localzzjn = (zzjn)paramWebView;
      localActivity = localzzjn.zzhx();
      paramWebView = localActivity;
    } while (localActivity != null);
    return localzzjn.getContext();
  }
  
  private static void zza(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.zzMN.confirm();
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.zzMN.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        this.zzMN.cancel();
      }
    }).create().show();
  }
  
  private static void zza(final Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    paramContext = new EditText(paramContext);
    paramContext.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(paramContext);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.zzMO.confirm(paramContext.getText().toString());
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.zzMO.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        this.zzMO.cancel();
      }
    }).create().show();
  }
  
  private final boolean zzid()
  {
    return (zzp.zzbx().zza(this.zzps.getContext().getPackageManager(), this.zzps.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) || (zzp.zzbx().zza(this.zzps.getContext().getPackageManager(), this.zzps.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION"));
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzjn))
    {
      zzb.zzaH("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    paramWebView = ((zzjn)paramWebView).zzhA();
    if (paramWebView == null)
    {
      zzb.zzaH("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    paramWebView.close();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    if (str.contains("Application Cache")) {
      return super.onConsoleMessage(paramConsoleMessage);
    }
    switch (7.zzMQ[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      zzb.zzaG(str);
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      zzb.e(str);
      continue;
      zzb.zzaH(str);
      continue;
      zzb.zzaG(str);
      continue;
      zzb.zzaF(str);
    }
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(this.zzps.zzhC());
    localWebViewTransport.setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L) {
      if ((paramLong2 > l) || (paramLong2 > 1048576L)) {}
    }
    for (;;)
    {
      paramQuotaUpdater.updateQuota(paramLong2);
      return;
      paramLong2 = 0L;
      continue;
      if (paramLong2 == 0L)
      {
        paramLong2 = Math.min(Math.min(131072L, l) + paramLong1, 1048576L);
      }
      else
      {
        paramLong3 = paramLong1;
        if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
          paramLong3 = paramLong1 + paramLong2;
        }
        paramLong2 = paramLong3;
      }
    }
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (paramCallback != null) {
      paramCallback.invoke(paramString, zzid(), true);
    }
  }
  
  public final void onHideCustomView()
  {
    zzd localzzd = this.zzps.zzhA();
    if (localzzd == null)
    {
      zzb.zzaH("Could not get ad overlay when hiding custom view.");
      return;
    }
    localzzd.zzfa();
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong1 = 131072L + paramLong1;
    if (5242880L - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zza(paramView, -1, paramCustomViewCallback);
  }
  
  protected final void zza(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzd localzzd = this.zzps.zzhA();
    if (localzzd == null)
    {
      zzb.zzaH("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localzzd.zza(paramView, paramCustomViewCallback);
    localzzd.setRequestedOrientation(paramInt);
  }
  
  protected boolean zza(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString1);
      if (paramBoolean) {
        zza(paramContext, localBuilder, paramString2, paramString3, paramJsPromptResult);
      } else {
        zza(localBuilder, paramString2, paramJsResult);
      }
    }
    catch (WindowManager.BadTokenException paramContext)
    {
      zzb.zzd("Fail to display Dialog.", paramContext);
    }
    return true;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */