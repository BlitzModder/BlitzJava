package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzd
{
  Context context;
  SharedPreferences zzaKG;
  
  public zzd(Context paramContext)
  {
    this(paramContext, "com.google.android.gms.appid");
  }
  
  public zzd(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.zzaKG = paramContext.getSharedPreferences(paramString, 4);
    zzdL(paramString + "-no-backup");
  }
  
  private void zzdL(String paramString)
  {
    paramString = new File(new ContextCompat().getNoBackupFilesDir(this.context), paramString);
    if (paramString.exists()) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((paramString.createNewFile()) && (!isEmpty()))
          {
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.zza(this.context, this);
            return;
          }
        }
        catch (IOException paramString) {}
      }
    } while (!Log.isLoggable("InstanceID/Store", 3));
    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + paramString.getMessage());
  }
  
  private String zzf(String paramString1, String paramString2, String paramString3)
  {
    return paramString1 + "|T|" + paramString2 + "|" + paramString3;
  }
  
  String get(String paramString)
  {
    try
    {
      paramString = this.zzaKG.getString(paramString, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String get(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.zzaKG.getString(paramString1 + "|S|" + paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  boolean isEmpty()
  {
    return this.zzaKG.getAll().isEmpty();
  }
  
  void zza(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramEditor.putString(paramString1 + "|S|" + paramString2, paramString3);
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  public void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = this.zzaKG.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  KeyPair zzd(String paramString, long paramLong)
  {
    try
    {
      KeyPair localKeyPair = zza.zzxM();
      SharedPreferences.Editor localEditor = this.zzaKG.edit();
      zza(localEditor, paramString, "|P|", InstanceID.zzn(localKeyPair.getPublic().getEncoded()));
      zza(localEditor, paramString, "|K|", InstanceID.zzn(localKeyPair.getPrivate().getEncoded()));
      zza(localEditor, paramString, "cre", Long.toString(paramLong));
      localEditor.commit();
      return localKeyPair;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zzdM(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.zzaKG.edit();
      Iterator localIterator = this.zzaKG.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
  }
  
  public KeyPair zzdN(String paramString)
  {
    return zzdQ(paramString);
  }
  
  void zzdO(String paramString)
  {
    zzdM(paramString + "|");
  }
  
  public void zzdP(String paramString)
  {
    zzdM(paramString + "|T|");
  }
  
  KeyPair zzdQ(String paramString)
  {
    Object localObject1 = get(paramString, "|P|");
    Object localObject2 = get(paramString, "|K|");
    if (localObject2 == null) {
      return null;
    }
    try
    {
      paramString = Base64.decode((String)localObject1, 8);
      localObject1 = Base64.decode((String)localObject2, 8);
      localObject2 = KeyFactory.getInstance("RSA");
      paramString = new KeyPair(((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec(paramString)), ((KeyFactory)localObject2).generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1)));
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      Log.w("InstanceID/Store", "Invalid key stored " + paramString);
      InstanceIDListenerService.zza(this.context, this);
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  public String zzg(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString1 = this.zzaKG.getString(paramString1, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzh(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = this.zzaKG.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzxU()
  {
    try
    {
      this.zzaKG.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/iid/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */