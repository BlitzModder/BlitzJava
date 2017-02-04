package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents.zza;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.zza;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzkh
{
  private static DocumentSection zza(String paramString, zzqd.zzc paramzzc)
  {
    paramString = new RegisterSectionInfo.zza(paramString).zzM(true).zzbz(paramString).zzby("blob").zzlQ();
    return new DocumentSection(zztk.toByteArray(paramzzc), paramString);
  }
  
  public static UsageInfo zza(Action paramAction, long paramLong, String paramString, int paramInt)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramAction.zzlT());
    Object localObject = localBundle.getBundle("object");
    int i;
    if (((Bundle)localObject).containsKey("id"))
    {
      paramAction = Uri.parse(((Bundle)localObject).getString("id"));
      String str1 = ((Bundle)localObject).getString("name");
      String str2 = ((Bundle)localObject).getString("type");
      localObject = zzki.zza(paramString, Uri.parse(((Bundle)localObject).getString("url")));
      paramAction = UsageInfo.zza((Intent)localObject, str1, paramAction, str2, null);
      if (localBundle.containsKey(".private:ssbContext"))
      {
        paramAction.zza(DocumentSection.zzh(localBundle.getByteArray(".private:ssbContext")));
        localBundle.remove(".private:ssbContext");
      }
      if (localBundle.containsKey(".private:accountName"))
      {
        paramAction.zzb(new Account(localBundle.getString(".private:accountName"), "com.google"));
        localBundle.remove(".private:accountName");
      }
      if ((!localBundle.containsKey(".private:isContextOnly")) || (!localBundle.getBoolean(".private:isContextOnly"))) {
        break label290;
      }
      i = 4;
      localBundle.remove(".private:isContextOnly");
    }
    for (;;)
    {
      if (localBundle.containsKey(".private:isDeviceOnly"))
      {
        bool = localBundle.getBoolean(".private:isDeviceOnly", false);
        localBundle.remove(".private:isDeviceOnly");
      }
      paramAction.zza(zza(".private:action", zzg(localBundle)));
      return new UsageInfo.zza().zza(UsageInfo.zza(paramString, (Intent)localObject)).zzw(paramLong).zzar(i).zza(paramAction.zzlN()).zzO(bool).zzas(paramInt).zzlR();
      paramAction = null;
      break;
      label290:
      i = 0;
    }
  }
  
  private static zzqd.zzb zzb(String paramString, Bundle paramBundle)
  {
    zzqd.zzb localzzb = new zzqd.zzb();
    localzzb.name = paramString;
    localzzb.zzaJF = new zzqd.zzd();
    localzzb.zzaJF.zzaJK = zzg(paramBundle);
    return localzzb;
  }
  
  static zzqd.zzc zzg(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramBundle.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str1 = (String)((Iterator)localObject1).next();
      Object localObject2 = paramBundle.get(str1);
      if ((localObject2 instanceof String))
      {
        localArrayList.add(zzq(str1, (String)localObject2));
      }
      else if ((localObject2 instanceof Bundle))
      {
        localArrayList.add(zzb(str1, (Bundle)localObject2));
      }
      else
      {
        int j;
        int i;
        label129:
        String str2;
        if ((localObject2 instanceof String[]))
        {
          localObject2 = (String[])localObject2;
          j = localObject2.length;
          i = 0;
          if (i < j)
          {
            str2 = localObject2[i];
            if (str2 != null) {
              break label152;
            }
          }
          for (;;)
          {
            i += 1;
            break label129;
            break;
            label152:
            localArrayList.add(zzq(str1, str2));
          }
        }
        if ((localObject2 instanceof Bundle[]))
        {
          localObject2 = (Bundle[])localObject2;
          j = localObject2.length;
          i = 0;
          label193:
          if (i < j)
          {
            str2 = localObject2[i];
            if (str2 != null) {
              break label216;
            }
          }
          for (;;)
          {
            i += 1;
            break label193;
            break;
            label216:
            localArrayList.add(zzb(str1, str2));
          }
        }
        Log.e("SearchIndex", "Unsupported value: " + localObject2);
      }
    }
    localObject1 = new zzqd.zzc();
    if (paramBundle.containsKey("type")) {
      ((zzqd.zzc)localObject1).type = paramBundle.getString("type");
    }
    ((zzqd.zzc)localObject1).zzaJG = ((zzqd.zzb[])localArrayList.toArray(new zzqd.zzb[localArrayList.size()]));
    return (zzqd.zzc)localObject1;
  }
  
  private static zzqd.zzb zzq(String paramString1, String paramString2)
  {
    zzqd.zzb localzzb = new zzqd.zzb();
    localzzb.name = paramString1;
    localzzb.zzaJF = new zzqd.zzd();
    localzzb.zzaJF.zzakS = paramString2;
    return localzzb;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */