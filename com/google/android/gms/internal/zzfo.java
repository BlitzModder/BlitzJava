package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfo
  extends zzfr
{
  private final Context mContext;
  private final Map<String, String> zzxc;
  
  public zzfo(zzjn paramzzjn, Map<String, String> paramMap)
  {
    super(paramzzjn, "storePicture");
    this.zzxc = paramMap;
    this.mContext = paramzzjn.zzhx();
  }
  
  public void execute()
  {
    if (this.mContext == null)
    {
      zzal("Activity context is not available");
      return;
    }
    if (!zzp.zzbx().zzN(this.mContext).zzdf())
    {
      zzal("Feature is not supported by the device.");
      return;
    }
    final String str1 = (String)this.zzxc.get("iurl");
    if (TextUtils.isEmpty(str1))
    {
      zzal("Image url cannot be empty.");
      return;
    }
    if (!URLUtil.isValidUrl(str1))
    {
      zzal("Invalid image url: " + str1);
      return;
    }
    final String str2 = zzak(str1);
    if (!zzp.zzbx().zzaB(str2))
    {
      zzal("Image type not recognized: " + str2);
      return;
    }
    AlertDialog.Builder localBuilder = zzp.zzbx().zzM(this.mContext);
    localBuilder.setTitle(zzp.zzbA().zzf(R.string.store_picture_title, "Save image"));
    localBuilder.setMessage(zzp.zzbA().zzf(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
    localBuilder.setPositiveButton(zzp.zzbA().zzf(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = (DownloadManager)zzfo.zza(zzfo.this).getSystemService("download");
        try
        {
          paramAnonymousDialogInterface.enqueue(zzfo.this.zzf(str1, str2));
          return;
        }
        catch (IllegalStateException paramAnonymousDialogInterface)
        {
          zzfo.this.zzal("Could not store picture.");
        }
      }
    });
    localBuilder.setNegativeButton(zzp.zzbA().zzf(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzfo.this.zzal("User canceled the download.");
      }
    });
    localBuilder.create().show();
  }
  
  String zzak(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  DownloadManager.Request zzf(String paramString1, String paramString2)
  {
    paramString1 = new DownloadManager.Request(Uri.parse(paramString1));
    paramString1.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, paramString2);
    zzp.zzbz().zza(paramString1);
    return paramString1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */