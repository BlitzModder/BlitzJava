package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzfp
{
  private final boolean zzCu;
  private final boolean zzCv;
  private final boolean zzCw;
  private final boolean zzCx;
  private final boolean zzCy;
  
  private zzfp(zza paramzza)
  {
    this.zzCu = zza.zza(paramzza);
    this.zzCv = zza.zzb(paramzza);
    this.zzCw = zza.zzc(paramzza);
    this.zzCx = zza.zzd(paramzza);
    this.zzCy = zza.zze(paramzza);
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", this.zzCu).put("tel", this.zzCv).put("calendar", this.zzCw).put("storePicture", this.zzCx).put("inlineVideo", this.zzCy);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
  
  public static final class zza
  {
    private boolean zzCu;
    private boolean zzCv;
    private boolean zzCw;
    private boolean zzCx;
    private boolean zzCy;
    
    public zzfp zzeE()
    {
      return new zzfp(this, null);
    }
    
    public zza zzq(boolean paramBoolean)
    {
      this.zzCu = paramBoolean;
      return this;
    }
    
    public zza zzr(boolean paramBoolean)
    {
      this.zzCv = paramBoolean;
      return this;
    }
    
    public zza zzs(boolean paramBoolean)
    {
      this.zzCw = paramBoolean;
      return this;
    }
    
    public zza zzt(boolean paramBoolean)
    {
      this.zzCx = paramBoolean;
      return this;
    }
    
    public zza zzu(boolean paramBoolean)
    {
      this.zzCy = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */