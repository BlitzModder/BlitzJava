package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqd.zza;
import com.google.android.gms.internal.zzqd.zza.zza;
import com.google.android.gms.internal.zztk;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final DocumentId zzSY;
  final long zzSZ;
  int zzTa;
  final DocumentContents zzTb;
  final boolean zzTc;
  int zzTd;
  int zzTe;
  public final String zzuU;
  
  UsageInfo(int paramInt1, DocumentId paramDocumentId, long paramLong, int paramInt2, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzSY = paramDocumentId;
    this.zzSZ = paramLong;
    this.zzTa = paramInt2;
    this.zzuU = paramString;
    this.zzTb = paramDocumentContents;
    this.zzTc = paramBoolean;
    this.zzTd = paramInt3;
    this.zzTe = paramInt4;
  }
  
  private UsageInfo(DocumentId paramDocumentId, long paramLong, int paramInt1, String paramString, DocumentContents paramDocumentContents, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this(1, paramDocumentId, paramLong, paramInt1, paramString, paramDocumentContents, paramBoolean, paramInt2, paramInt3);
  }
  
  public UsageInfo(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList, int paramInt)
  {
    this(1, zza(paramString1, paramIntent), System.currentTimeMillis(), 0, null, zza(paramIntent, paramString2, paramUri, paramString3, paramList).zzlN(), false, -1, paramInt);
  }
  
  public static DocumentContents.zza zza(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    DocumentContents.zza localzza = new DocumentContents.zza();
    localzza.zza(zzbA(paramString1));
    if (paramUri != null) {
      localzza.zza(zzi(paramUri));
    }
    if (paramList != null) {
      localzza.zza(zzq(paramList));
    }
    paramString1 = paramIntent.getAction();
    if (paramString1 != null) {
      localzza.zza(zzp("intent_action", paramString1));
    }
    paramString1 = paramIntent.getDataString();
    if (paramString1 != null) {
      localzza.zza(zzp("intent_data", paramString1));
    }
    paramString1 = paramIntent.getComponent();
    if (paramString1 != null) {
      localzza.zza(zzp("intent_activity", paramString1.getClassName()));
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getString("intent_extra_data_key");
      if (paramIntent != null) {
        localzza.zza(zzp("intent_extra_data", paramIntent));
      }
    }
    return localzza.zzbw(paramString2).zzL(true);
  }
  
  public static DocumentId zza(String paramString, Intent paramIntent)
  {
    return zzo(paramString, zzg(paramIntent));
  }
  
  private static DocumentSection zzbA(String paramString)
  {
    return new DocumentSection(paramString, new RegisterSectionInfo.zza("title").zzap(1).zzN(true).zzbz("name").zzlQ(), "text1");
  }
  
  private static String zzg(Intent paramIntent)
  {
    paramIntent = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(paramIntent.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      throw new IllegalStateException(paramIntent);
    }
  }
  
  private static DocumentSection zzi(Uri paramUri)
  {
    return new DocumentSection(paramUri.toString(), new RegisterSectionInfo.zza("web_url").zzap(4).zzM(true).zzbz("url").zzlQ());
  }
  
  private static DocumentId zzo(String paramString1, String paramString2)
  {
    return new DocumentId(paramString1, "", paramString2);
  }
  
  private static DocumentSection zzp(String paramString1, String paramString2)
  {
    return new DocumentSection(paramString2, new RegisterSectionInfo.zza(paramString1).zzM(true).zzlQ(), paramString1);
  }
  
  private static DocumentSection zzq(List<AppIndexApi.AppIndexingLink> paramList)
  {
    zzqd.zza localzza = new zzqd.zza();
    zzqd.zza.zza[] arrayOfzza = new zzqd.zza.zza[paramList.size()];
    int i = 0;
    while (i < arrayOfzza.length)
    {
      arrayOfzza[i] = new zzqd.zza.zza();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfzza[i].zzaJC = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfzza[i].viewId = localAppIndexingLink.viewId;
      if (localAppIndexingLink.webUrl != null) {
        arrayOfzza[i].zzaJD = localAppIndexingLink.webUrl.toString();
      }
      i += 1;
    }
    localzza.zzaJA = arrayOfzza;
    return new DocumentSection(zztk.toByteArray(localzza), new RegisterSectionInfo.zza("outlinks").zzM(true).zzbz(".private:outLinks").zzby("blob").zzlQ());
  }
  
  public int describeContents()
  {
    zzj localzzj = CREATOR;
    return 0;
  }
  
  public String toString()
  {
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] { this.zzSY, Long.valueOf(this.zzSZ), Integer.valueOf(this.zzTa), Integer.valueOf(this.zzTe) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj localzzj = CREATOR;
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public static final class zza
  {
    private String zzNp;
    private DocumentId zzSY;
    private long zzSZ = -1L;
    private int zzTa = -1;
    private DocumentContents zzTb;
    private boolean zzTc = false;
    private int zzTd = -1;
    private int zzTe = 0;
    
    public zza zzO(boolean paramBoolean)
    {
      this.zzTc = paramBoolean;
      return this;
    }
    
    public zza zza(DocumentContents paramDocumentContents)
    {
      this.zzTb = paramDocumentContents;
      return this;
    }
    
    public zza zza(DocumentId paramDocumentId)
    {
      this.zzSY = paramDocumentId;
      return this;
    }
    
    public zza zzar(int paramInt)
    {
      this.zzTa = paramInt;
      return this;
    }
    
    public zza zzas(int paramInt)
    {
      this.zzTe = paramInt;
      return this;
    }
    
    public UsageInfo zzlR()
    {
      return new UsageInfo(this.zzSY, this.zzSZ, this.zzTa, this.zzNp, this.zzTb, this.zzTc, this.zzTd, this.zzTe, null);
    }
    
    public zza zzw(long paramLong)
    {
      this.zzSZ = paramLong;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/UsageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */