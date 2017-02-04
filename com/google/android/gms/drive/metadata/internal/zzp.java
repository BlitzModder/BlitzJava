package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp
  extends zzj<UserMetadata>
{
  public zzp(String paramString, int paramInt)
  {
    super(paramString, zzcX(paramString), Collections.emptyList(), paramInt);
  }
  
  private static String zzC(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }
  
  private String zzcW(String paramString)
  {
    return zzC(getName(), paramString);
  }
  
  private static Collection<String> zzcX(String paramString)
  {
    return Arrays.asList(new String[] { zzC(paramString, "permissionId"), zzC(paramString, "displayName"), zzC(paramString, "picture"), zzC(paramString, "isAuthenticatedUser"), zzC(paramString, "emailAddress") });
  }
  
  protected boolean zzb(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return (paramDataHolder.zzct(zzcW("permissionId"))) && (!paramDataHolder.zzi(zzcW("permissionId"), paramInt1, paramInt2));
  }
  
  protected UserMetadata zzj(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    String str1 = paramDataHolder.zzd(zzcW("permissionId"), paramInt1, paramInt2);
    if (str1 != null)
    {
      String str2 = paramDataHolder.zzd(zzcW("displayName"), paramInt1, paramInt2);
      String str3 = paramDataHolder.zzd(zzcW("picture"), paramInt1, paramInt2);
      boolean bool = paramDataHolder.zze(zzcW("isAuthenticatedUser"), paramInt1, paramInt2);
      paramDataHolder = paramDataHolder.zzd(zzcW("emailAddress"), paramInt1, paramInt2);
      return new UserMetadata(str1, str2, str3, Boolean.valueOf(bool).booleanValue(), paramDataHolder);
    }
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */