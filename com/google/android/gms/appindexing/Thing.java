package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

public class Thing
{
  final Bundle zzTm;
  
  Thing(Bundle paramBundle)
  {
    this.zzTm = paramBundle;
  }
  
  public Bundle zzlT()
  {
    return this.zzTm;
  }
  
  public static class Builder
  {
    final Bundle zzTn = new Bundle();
    
    public Thing build()
    {
      return new Thing(this.zzTn);
    }
    
    public Builder put(String paramString, Thing paramThing)
    {
      zzx.zzy(paramString);
      if (paramThing != null) {
        this.zzTn.putParcelable(paramString, paramThing.zzTm);
      }
      return this;
    }
    
    public Builder put(String paramString1, String paramString2)
    {
      zzx.zzy(paramString1);
      if (paramString2 != null) {
        this.zzTn.putString(paramString1, paramString2);
      }
      return this;
    }
    
    public Builder put(String paramString, Thing[] paramArrayOfThing)
    {
      zzx.zzy(paramString);
      if (paramArrayOfThing != null)
      {
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayOfThing.length;
        int i = 0;
        while (i < j)
        {
          Thing localThing = paramArrayOfThing[i];
          if (localThing != null) {
            localArrayList.add(localThing.zzTm);
          }
          i += 1;
        }
        this.zzTn.putParcelableArray(paramString, (Parcelable[])localArrayList.toArray(new Bundle[localArrayList.size()]));
      }
      return this;
    }
    
    public Builder put(String paramString, String[] paramArrayOfString)
    {
      zzx.zzy(paramString);
      if (paramArrayOfString != null) {
        this.zzTn.putStringArray(paramString, paramArrayOfString);
      }
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      put("description", paramString);
      return this;
    }
    
    public Builder setId(String paramString)
    {
      if (paramString != null) {
        put("id", paramString);
      }
      return this;
    }
    
    public Builder setName(String paramString)
    {
      zzx.zzy(paramString);
      put("name", paramString);
      return this;
    }
    
    public Builder setType(String paramString)
    {
      put("type", paramString);
      return this;
    }
    
    public Builder setUrl(Uri paramUri)
    {
      zzx.zzy(paramUri);
      put("url", paramUri.toString());
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appindexing/Thing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */