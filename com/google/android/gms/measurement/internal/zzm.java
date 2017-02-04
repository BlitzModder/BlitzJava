package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zza;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class zzm
  extends zzw
{
  private static final X500Principal zzaTf = new X500Principal("CN=Android Debug,O=Android,C=US");
  private String zzRk;
  private String zzRl;
  private String zzaRd;
  private String zzaSf;
  private String zzaSj;
  private long zzaTg;
  
  zzm(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  static long zzp(byte[] paramArrayOfByte)
  {
    int j = 0;
    zzx.zzy(paramArrayOfByte);
    if (paramArrayOfByte.length > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      l = 0L;
      int i = paramArrayOfByte.length - 1;
      while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
      {
        l += ((paramArrayOfByte[i] & 0xFF) << j);
        j += 8;
        i -= 1;
      }
    }
    return l;
  }
  
  String zzBi()
  {
    zzje();
    if (zzAX().zzka()) {
      return "";
    }
    Object localObject1;
    if (this.zzaSf == null)
    {
      localObject1 = zza.zzaS(getContext());
      if ((localObject1 == null) || (!((Status)localObject1).isSuccess())) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          if (!zza.zzzC()) {
            continue;
          }
          localObject2 = zza.zzzA();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "";
          }
          this.zzaSf = ((String)localObject1);
        }
        catch (IllegalStateException localIllegalStateException)
        {
          this.zzaSf = "";
          zzzz().zzBl().zzj("getGoogleAppId or isMeasurementEnabled failed with exception", localIllegalStateException);
          continue;
        }
        return this.zzaSf;
        this.zzaSf = "";
      }
    }
    this.zzaSf = "";
    Object localObject2 = zzzz().zzBl();
    if (localIllegalStateException == null) {}
    for (int i = 0;; i = localIllegalStateException.getStatusCode())
    {
      ((zzo.zza)localObject2).zzj("getGoogleAppId failed with status", Integer.valueOf(i));
      if ((localIllegalStateException == null) || (localIllegalStateException.getStatusMessage() == null)) {
        break;
      }
      zzzz().zzBq().zzez(localIllegalStateException.getStatusMessage());
      break;
    }
  }
  
  long zzBj()
  {
    zzje();
    return this.zzaTg;
  }
  
  boolean zzBk()
  {
    try
    {
      Object localObject = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
      if ((localObject != null) && (((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0))
      {
        localObject = localObject.signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((Signature)localObject).toByteArray()))).getSubjectX500Principal().equals(zzaTf);
        return bool;
      }
    }
    catch (CertificateException localCertificateException)
    {
      zzzz().zzBl().zzj("Error obtaining certificate", localCertificateException);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzzz().zzBl().zzj("Package name not found", localNameNotFoundException);
      }
    }
  }
  
  AppMetadata zzex(String paramString)
  {
    return new AppMetadata(this.zzaRd, zzBi(), this.zzRl, this.zzaSj, zzAX().zzAE(), zzBj(), paramString, zzAW().zzzC());
  }
  
  protected void zzir()
  {
    str2 = "Unknown";
    String str1 = "Unknown";
    PackageManager localPackageManager = getContext().getPackageManager();
    String str3 = getContext().getPackageName();
    Object localObject1 = localPackageManager.getInstallerPackageName(str3);
    Object localObject3;
    if (localObject1 == null) {
      localObject3 = "manual_install";
    }
    for (;;)
    {
      localObject4 = str1;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(getContext().getPackageName(), 0);
        localObject1 = str1;
        localObject4 = str2;
        if (localPackageInfo != null)
        {
          localObject4 = str1;
          CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
          localObject1 = str1;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject4 = str1;
            localObject1 = localCharSequence.toString();
          }
          localObject4 = localObject1;
          str1 = localPackageInfo.versionName;
          localObject4 = str1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        for (;;)
        {
          zzzz().zzBl().zzj("Error retrieving package info: appName", localObject4);
          localObject2 = localObject4;
          localObject4 = str2;
        }
      }
      this.zzaRd = str3;
      this.zzaSj = ((String)localObject3);
      this.zzRl = ((String)localObject4);
      this.zzRk = ((String)localObject1);
      l2 = 0L;
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        l1 = l2;
        if (!zzBk())
        {
          localObject3 = localPackageManager.getPackageInfo(getContext().getPackageName(), 64);
          l1 = l2;
          if (localObject1 != null)
          {
            l1 = l2;
            if (((PackageInfo)localObject3).signatures != null)
            {
              l1 = l2;
              if (((PackageInfo)localObject3).signatures.length > 0) {
                l1 = zzp(((MessageDigest)localObject1).digest(localObject3.signatures[0].toByteArray()));
              }
            }
          }
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          Object localObject2;
          zzzz().zzBl().zzj("Could not get MD5 instance", localNoSuchAlgorithmException);
          l1 = l2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        for (;;)
        {
          zzzz().zzBl().zzj("Package name not found", localNameNotFoundException2);
          long l1 = l2;
        }
      }
      this.zzaTg = l1;
      return;
      localObject3 = localObject1;
      if ("com.android.vending".equals(localObject1)) {
        localObject3 = "";
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */