package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
  public static final int SUBTYPE_CAPTIONS = 2;
  public static final int SUBTYPE_CHAPTERS = 4;
  public static final int SUBTYPE_DESCRIPTIONS = 3;
  public static final int SUBTYPE_METADATA = 5;
  public static final int SUBTYPE_NONE = 0;
  public static final int SUBTYPE_SUBTITLES = 1;
  public static final int SUBTYPE_UNKNOWN = -1;
  public static final int TYPE_AUDIO = 2;
  public static final int TYPE_TEXT = 1;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_VIDEO = 3;
  private String mName;
  private long zzTC;
  private int zzZU;
  private int zzZV;
  private String zzZe;
  private String zzZg;
  private String zzZi;
  private JSONObject zzZn;
  
  MediaTrack(long paramLong, int paramInt)
    throws IllegalArgumentException
  {
    clear();
    this.zzTC = paramLong;
    if ((paramInt <= 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid type " + paramInt);
    }
    this.zzZU = paramInt;
  }
  
  MediaTrack(JSONObject paramJSONObject)
    throws JSONException
  {
    zzf(paramJSONObject);
  }
  
  private void clear()
  {
    this.zzTC = 0L;
    this.zzZU = 0;
    this.zzZg = null;
    this.mName = null;
    this.zzZe = null;
    this.zzZV = -1;
    this.zzZn = null;
  }
  
  private void zzf(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.zzTC = paramJSONObject.getLong("trackId");
    String str = paramJSONObject.getString("type");
    if ("TEXT".equals(str))
    {
      this.zzZU = 1;
      this.zzZg = paramJSONObject.optString("trackContentId", null);
      this.zzZi = paramJSONObject.optString("trackContentType", null);
      this.mName = paramJSONObject.optString("name", null);
      this.zzZe = paramJSONObject.optString("language", null);
      if (!paramJSONObject.has("subtype")) {
        break label276;
      }
      str = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str)) {
        break label181;
      }
      this.zzZV = 1;
    }
    for (;;)
    {
      this.zzZn = paramJSONObject.optJSONObject("customData");
      return;
      if ("AUDIO".equals(str))
      {
        this.zzZU = 2;
        break;
      }
      if ("VIDEO".equals(str))
      {
        this.zzZU = 3;
        break;
      }
      throw new JSONException("invalid type: " + str);
      label181:
      if ("CAPTIONS".equals(str))
      {
        this.zzZV = 2;
      }
      else if ("DESCRIPTIONS".equals(str))
      {
        this.zzZV = 3;
      }
      else if ("CHAPTERS".equals(str))
      {
        this.zzZV = 4;
      }
      else if ("METADATA".equals(str))
      {
        this.zzZV = 5;
      }
      else
      {
        throw new JSONException("invalid subtype: " + str);
        label276:
        this.zzZV = 0;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof MediaTrack));
        paramObject = (MediaTrack)paramObject;
        if (this.zzZn != null) {
          break;
        }
        i = 1;
        if (((MediaTrack)paramObject).zzZn != null) {
          break label194;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzZn == null) || (((MediaTrack)paramObject).zzZn == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zznu.zze(this.zzZn, ((MediaTrack)paramObject).zzZn));
    if ((this.zzTC == ((MediaTrack)paramObject).zzTC) && (this.zzZU == ((MediaTrack)paramObject).zzZU) && (zzf.zza(this.zzZg, ((MediaTrack)paramObject).zzZg)) && (zzf.zza(this.zzZi, ((MediaTrack)paramObject).zzZi)) && (zzf.zza(this.mName, ((MediaTrack)paramObject).mName)) && (zzf.zza(this.zzZe, ((MediaTrack)paramObject).zzZe)) && (this.zzZV == ((MediaTrack)paramObject).zzZV)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label194:
      j = 0;
      break label51;
    }
  }
  
  public String getContentId()
  {
    return this.zzZg;
  }
  
  public String getContentType()
  {
    return this.zzZi;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzZn;
  }
  
  public long getId()
  {
    return this.zzTC;
  }
  
  public String getLanguage()
  {
    return this.zzZe;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.zzZV;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzTC), Integer.valueOf(this.zzZU), this.zzZg, this.zzZi, this.mName, this.zzZe, Integer.valueOf(this.zzZV), this.zzZn });
  }
  
  public void setContentId(String paramString)
  {
    this.zzZg = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.zzZi = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzZn = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.zzZe = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.zzTC);
      switch (this.zzZU)
      {
      case 1: 
        if (this.zzZg != null) {
          localJSONObject.put("trackContentId", this.zzZg);
        }
        if (this.zzZi != null) {
          localJSONObject.put("trackContentType", this.zzZi);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.zzZe)) {
          localJSONObject.put("language", this.zzZe);
        }
        switch (this.zzZV)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.zzZn == null) {
          break label282;
        }
        localJSONObject.put("customData", this.zzZn);
        return localJSONObject;
        localJSONObject.put("type", "TEXT");
        break;
        localJSONObject.put("type", "AUDIO");
        break;
        localJSONObject.put("type", "VIDEO");
        break;
        localJSONObject.put("subtype", "SUBTITLES");
        continue;
        localJSONObject.put("subtype", "CAPTIONS");
        continue;
        localJSONObject.put("subtype", "DESCRIPTIONS");
        continue;
        localJSONObject.put("subtype", "CHAPTERS");
        continue;
        localJSONObject.put("subtype", "METADATA");
        continue;
        break;
      }
      label282:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  void zzbe(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt <= -1) || (paramInt > 5)) {
      throw new IllegalArgumentException("invalid subtype " + paramInt);
    }
    if ((paramInt != 0) && (this.zzZU != 1)) {
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    this.zzZV = paramInt;
  }
  
  public static class Builder
  {
    private final MediaTrack zzZW;
    
    public Builder(long paramLong, int paramInt)
      throws IllegalArgumentException
    {
      this.zzZW = new MediaTrack(paramLong, paramInt);
    }
    
    public MediaTrack build()
    {
      return this.zzZW;
    }
    
    public Builder setContentId(String paramString)
    {
      this.zzZW.setContentId(paramString);
      return this;
    }
    
    public Builder setContentType(String paramString)
    {
      this.zzZW.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzZW.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setLanguage(String paramString)
    {
      this.zzZW.setLanguage(paramString);
      return this;
    }
    
    public Builder setLanguage(Locale paramLocale)
    {
      this.zzZW.setLanguage(zzf.zzb(paramLocale));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.zzZW.setName(paramString);
      return this;
    }
    
    public Builder setSubtype(int paramInt)
      throws IllegalArgumentException
    {
      this.zzZW.zzbe(paramInt);
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/MediaTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */