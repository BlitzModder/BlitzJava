package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzle
  implements zzld
{
  protected final Activity mActivity;
  protected final Set<String> zzVH;
  private String zzVt;
  private String zzWq;
  private zzld.zza zzWz;
  
  protected zzle(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    this.mActivity = ((Activity)zzx.zzy(paramActivity));
    paramActivity = new HashSet((Collection)zzx.zzy(paramList1));
    paramActivity.addAll((Collection)zzx.zzy(paramList2));
    this.zzVH = Collections.unmodifiableSet(paramActivity);
  }
  
  protected Intent zza(IdpTokenType paramIdpTokenType, String paramString1, String paramString2)
  {
    zzx.zzy(paramIdpTokenType);
    zzx.zzcG(paramString1);
    Intent localIntent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
    localIntent.putExtra("idpTokenType", paramIdpTokenType);
    localIntent.putExtra("idpToken", paramString1);
    localIntent.putExtra("pendingToken", paramString2);
    paramIdpTokenType = zzna();
    if (paramIdpTokenType != null) {
      localIntent.putExtra("idProvider", paramIdpTokenType.zzmC());
    }
    return localIntent;
  }
  
  protected void zzb(zzld.zza paramzza)
  {
    this.zzWz = ((zzld.zza)zzx.zzy(paramzza));
  }
  
  protected void zzb(String paramString1, String paramString2, zzld.zza paramzza)
  {
    zzbR(paramString1);
    zzbS(paramString2);
    zzb(paramzza);
  }
  
  protected void zzbR(String paramString)
  {
    this.zzVt = paramString;
  }
  
  protected void zzbS(String paramString)
  {
    this.zzWq = paramString;
  }
  
  protected Set<String> zznb()
  {
    return this.zzVH;
  }
  
  protected zzld.zza zznc()
  {
    return this.zzWz;
  }
  
  protected String zznd()
  {
    return this.zzWq;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */