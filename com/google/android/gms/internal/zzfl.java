package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfl
  extends zzfr
{
  private final Context mContext;
  private String zzBU;
  private long zzBV;
  private long zzBW;
  private String zzBX;
  private String zzBY;
  private final Map<String, String> zzxc;
  
  public zzfl(zzjn paramzzjn, Map<String, String> paramMap)
  {
    super(paramzzjn, "createCalendarEvent");
    this.zzxc = paramMap;
    this.mContext = paramzzjn.zzhx();
    zzez();
  }
  
  private String zzai(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)this.zzxc.get(paramString))) {
      return "";
    }
    return (String)this.zzxc.get(paramString);
  }
  
  private long zzaj(String paramString)
  {
    paramString = (String)this.zzxc.get(paramString);
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  private void zzez()
  {
    this.zzBU = zzai("description");
    this.zzBX = zzai("summary");
    this.zzBV = zzaj("start_ticks");
    this.zzBW = zzaj("end_ticks");
    this.zzBY = zzai("location");
  }
  
  Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", this.zzBU);
    localIntent.putExtra("eventLocation", this.zzBY);
    localIntent.putExtra("description", this.zzBX);
    if (this.zzBV > -1L) {
      localIntent.putExtra("beginTime", this.zzBV);
    }
    if (this.zzBW > -1L) {
      localIntent.putExtra("endTime", this.zzBW);
    }
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public void execute()
  {
    if (this.mContext == null)
    {
      zzal("Activity context is not available.");
      return;
    }
    if (!zzp.zzbx().zzN(this.mContext).zzdi())
    {
      zzal("This feature is not available on the device.");
      return;
    }
    AlertDialog.Builder localBuilder = zzp.zzbx().zzM(this.mContext);
    localBuilder.setTitle(zzp.zzbA().zzf(R.string.create_calendar_title, "Create calendar event"));
    localBuilder.setMessage(zzp.zzbA().zzf(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
    localBuilder.setPositiveButton(zzp.zzbA().zzf(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = zzfl.this.createIntent();
        zzp.zzbx().zzb(zzfl.zza(zzfl.this), paramAnonymousDialogInterface);
      }
    });
    localBuilder.setNegativeButton(zzp.zzbA().zzf(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzfl.this.zzal("Operation denied by user.");
      }
    });
    localBuilder.create().show();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */