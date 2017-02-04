package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final Account account;
  final int mVersionCode;
  final DocumentSection[] zzSi;
  public final String zzSj;
  public final boolean zzSk;
  
  DocumentContents(int paramInt, DocumentSection[] paramArrayOfDocumentSection, String paramString, boolean paramBoolean, Account paramAccount)
  {
    this.mVersionCode = paramInt;
    this.zzSi = paramArrayOfDocumentSection;
    this.zzSj = paramString;
    this.zzSk = paramBoolean;
    this.account = paramAccount;
  }
  
  DocumentContents(String paramString, boolean paramBoolean, Account paramAccount, DocumentSection... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean, paramAccount);
    paramString = new BitSet(zzh.zzlP());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = paramVarArgs[i].zzSw;
      if (j != -1)
      {
        if (paramString.get(j)) {
          throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzao(j));
        }
        paramString.set(j);
      }
      i += 1;
    }
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class zza
  {
    private List<DocumentSection> zzSl;
    private String zzSm;
    private boolean zzSn;
    private Account zzSo;
    
    public zza zzL(boolean paramBoolean)
    {
      this.zzSn = paramBoolean;
      return this;
    }
    
    public zza zza(DocumentSection paramDocumentSection)
    {
      if (this.zzSl == null) {
        this.zzSl = new ArrayList();
      }
      this.zzSl.add(paramDocumentSection);
      return this;
    }
    
    public zza zzb(Account paramAccount)
    {
      this.zzSo = paramAccount;
      return this;
    }
    
    public zza zzbw(String paramString)
    {
      this.zzSm = paramString;
      return this;
    }
    
    public DocumentContents zzlN()
    {
      String str = this.zzSm;
      boolean bool = this.zzSn;
      Account localAccount = this.zzSo;
      if (this.zzSl != null) {}
      for (DocumentSection[] arrayOfDocumentSection = (DocumentSection[])this.zzSl.toArray(new DocumentSection[this.zzSl.size()]);; arrayOfDocumentSection = null) {
        return new DocumentContents(str, bool, localAccount, arrayOfDocumentSection);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/DocumentContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */