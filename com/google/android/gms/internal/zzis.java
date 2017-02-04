package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzha
public class zzis
{
  private final Context mContext;
  private int mState = 0;
  private final float zzCB;
  private String zzKT;
  private float zzKU;
  private float zzKV;
  private float zzKW;
  
  public zzis(Context paramContext)
  {
    this.mContext = paramContext;
    this.zzCB = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public zzis(Context paramContext, String paramString)
  {
    this(paramContext);
    this.zzKT = paramString;
  }
  
  private void showDialog()
  {
    if (!(this.mContext instanceof Activity))
    {
      zzb.zzaG("Can not create dialog without Activity Context");
      return;
    }
    final String str = zzaD(this.zzKT);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setMessage(str);
    localBuilder.setTitle("Ad Information");
    localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzp.zzbx().zzb(zzis.zza(zzis.this), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
      }
    });
    localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  static String zzaD(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "No debug information";
    }
    Object localObject;
    do
    {
      return paramString;
      paramString = paramString.replaceAll("\\+", "%20");
      localObject = new Uri.Builder().encodedQuery(paramString).build();
      paramString = new StringBuilder();
      localObject = zzp.zzbx().zze((Uri)localObject);
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.append(str).append(" = ").append((String)((Map)localObject).get(str)).append("\n\n");
      }
      localObject = paramString.toString().trim();
      paramString = (String)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return "No debug information";
  }
  
  void zza(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.mState = 0;
      this.zzKU = paramFloat1;
      this.zzKV = paramFloat2;
      this.zzKW = paramFloat2;
    }
    label24:
    label224:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (this.mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > this.zzKV) {
          this.zzKV = paramFloat2;
        }
        while (this.zzKV - this.zzKW > 30.0F * this.zzCB)
        {
          this.mState = -1;
          return;
          if (paramFloat2 < this.zzKW) {
            this.zzKW = paramFloat2;
          }
        }
        if ((this.mState == 0) || (this.mState == 2)) {
          if (paramFloat1 - this.zzKU >= 50.0F * this.zzCB) {
            this.zzKU = paramFloat1;
          }
        }
        for (this.mState += 1;; this.mState += 1)
        {
          do
          {
            if ((this.mState != 1) && (this.mState != 3)) {
              break label224;
            }
            if (paramFloat1 <= this.zzKU) {
              break;
            }
            this.zzKU = paramFloat1;
            return;
          } while (((this.mState != 1) && (this.mState != 3)) || (paramFloat1 - this.zzKU > -50.0F * this.zzCB));
          this.zzKU = paramFloat1;
        }
      } while ((this.mState != 2) || (paramFloat1 >= this.zzKU));
      this.zzKU = paramFloat1;
      return;
    } while ((paramInt != 1) || (this.mState != 4));
    showDialog();
  }
  
  public void zzaC(String paramString)
  {
    this.zzKT = paramString;
  }
  
  public void zze(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = 0;
    while (i < j)
    {
      zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
      i += 1;
    }
    zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */