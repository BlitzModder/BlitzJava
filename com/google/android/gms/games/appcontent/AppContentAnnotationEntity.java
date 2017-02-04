package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class AppContentAnnotationEntity
  implements SafeParcelable, AppContentAnnotation
{
  public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
  private final int mVersionCode;
  private final Uri zzaAU;
  private final String zzaAV;
  private final String zzaAW;
  private final int zzaAX;
  private final int zzaAY;
  private final Bundle zzaAZ;
  private final String zzank;
  private final String zzavc;
  private final String zzxX;
  
  AppContentAnnotationEntity(int paramInt1, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.zzavc = paramString1;
    this.zzxX = paramString3;
    this.zzaAW = paramString5;
    this.zzaAX = paramInt2;
    this.zzaAU = paramUri;
    this.zzaAY = paramInt3;
    this.zzaAV = paramString4;
    this.zzaAZ = paramBundle;
    this.zzank = paramString2;
  }
  
  public AppContentAnnotationEntity(AppContentAnnotation paramAppContentAnnotation)
  {
    this.mVersionCode = 4;
    this.zzavc = paramAppContentAnnotation.getDescription();
    this.zzxX = paramAppContentAnnotation.getId();
    this.zzaAW = paramAppContentAnnotation.zzvn();
    this.zzaAX = paramAppContentAnnotation.zzvo();
    this.zzaAU = paramAppContentAnnotation.zzvp();
    this.zzaAY = paramAppContentAnnotation.zzvr();
    this.zzaAV = paramAppContentAnnotation.zzvs();
    this.zzaAZ = paramAppContentAnnotation.zzvq();
    this.zzank = paramAppContentAnnotation.getTitle();
  }
  
  static int zza(AppContentAnnotation paramAppContentAnnotation)
  {
    return zzw.hashCode(new Object[] { paramAppContentAnnotation.getDescription(), paramAppContentAnnotation.getId(), paramAppContentAnnotation.zzvn(), Integer.valueOf(paramAppContentAnnotation.zzvo()), paramAppContentAnnotation.zzvp(), Integer.valueOf(paramAppContentAnnotation.zzvr()), paramAppContentAnnotation.zzvs(), paramAppContentAnnotation.zzvq(), paramAppContentAnnotation.getTitle() });
  }
  
  static boolean zza(AppContentAnnotation paramAppContentAnnotation, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppContentAnnotation)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppContentAnnotation == paramObject);
      paramObject = (AppContentAnnotation)paramObject;
      if ((!zzw.equal(((AppContentAnnotation)paramObject).getDescription(), paramAppContentAnnotation.getDescription())) || (!zzw.equal(((AppContentAnnotation)paramObject).getId(), paramAppContentAnnotation.getId())) || (!zzw.equal(((AppContentAnnotation)paramObject).zzvn(), paramAppContentAnnotation.zzvn())) || (!zzw.equal(Integer.valueOf(((AppContentAnnotation)paramObject).zzvo()), Integer.valueOf(paramAppContentAnnotation.zzvo()))) || (!zzw.equal(((AppContentAnnotation)paramObject).zzvp(), paramAppContentAnnotation.zzvp())) || (!zzw.equal(Integer.valueOf(((AppContentAnnotation)paramObject).zzvr()), Integer.valueOf(paramAppContentAnnotation.zzvr()))) || (!zzw.equal(((AppContentAnnotation)paramObject).zzvs(), paramAppContentAnnotation.zzvs())) || (!zzw.equal(((AppContentAnnotation)paramObject).zzvq(), paramAppContentAnnotation.zzvq()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((AppContentAnnotation)paramObject).getTitle(), paramAppContentAnnotation.getTitle()));
    return false;
  }
  
  static String zzb(AppContentAnnotation paramAppContentAnnotation)
  {
    return zzw.zzx(paramAppContentAnnotation).zzg("Description", paramAppContentAnnotation.getDescription()).zzg("Id", paramAppContentAnnotation.getId()).zzg("ImageDefaultId", paramAppContentAnnotation.zzvn()).zzg("ImageHeight", Integer.valueOf(paramAppContentAnnotation.zzvo())).zzg("ImageUri", paramAppContentAnnotation.zzvp()).zzg("ImageWidth", Integer.valueOf(paramAppContentAnnotation.zzvr())).zzg("LayoutSlot", paramAppContentAnnotation.zzvs()).zzg("Modifiers", paramAppContentAnnotation.zzvq()).zzg("Title", paramAppContentAnnotation.getTitle()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getTitle()
  {
    return this.zzank;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentAnnotationEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzvn()
  {
    return this.zzaAW;
  }
  
  public int zzvo()
  {
    return this.zzaAX;
  }
  
  public Uri zzvp()
  {
    return this.zzaAU;
  }
  
  public Bundle zzvq()
  {
    return this.zzaAZ;
  }
  
  public int zzvr()
  {
    return this.zzaAY;
  }
  
  public String zzvs()
  {
    return this.zzaAV;
  }
  
  public AppContentAnnotation zzvt()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentAnnotationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */