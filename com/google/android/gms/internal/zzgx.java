package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgx
  implements zzgv.zza<zze>
{
  private final boolean zzFZ;
  private final boolean zzGa;
  
  public zzgx(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzFZ = paramBoolean1;
    this.zzGa = paramBoolean2;
  }
  
  public zze zzc(zzgv paramzzgv, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject = paramzzgv.zza(paramJSONObject, "images", true, this.zzFZ, this.zzGa);
    zzje localzzje = paramzzgv.zza(paramJSONObject, "secondary_image", false, this.zzFZ);
    paramzzgv = paramzzgv.zze(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((zzje)((Iterator)localObject).next()).get());
    }
    return new zze(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzcn)localzzje.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.getString("advertiser"), (zza)paramzzgv.get(), new Bundle());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */