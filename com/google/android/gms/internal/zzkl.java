package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

public class zzkl
  implements AppInviteInvitationResult
{
  private final Status zzTA;
  private final Intent zzTB;
  
  public zzkl(Status paramStatus, Intent paramIntent)
  {
    this.zzTA = paramStatus;
    this.zzTB = paramIntent;
  }
  
  public Intent getInvitationIntent()
  {
    return this.zzTB;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */