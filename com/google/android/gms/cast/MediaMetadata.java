package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata
{
  public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
  public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
  public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
  public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
  public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
  public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
  public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
  public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
  public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
  public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
  public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
  public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
  public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
  public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
  public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
  public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
  public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
  public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
  public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
  public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
  public static final int MEDIA_TYPE_GENERIC = 0;
  public static final int MEDIA_TYPE_MOVIE = 1;
  public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
  public static final int MEDIA_TYPE_PHOTO = 4;
  public static final int MEDIA_TYPE_TV_SHOW = 2;
  public static final int MEDIA_TYPE_USER = 100;
  private static final String[] zzZp = { null, "String", "int", "double", "ISO-8601 date String" };
  private static final zza zzZq = new zza().zzc("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).zzc("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).zzc("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).zzc("com.google.android.gms.cast.metadata.TITLE", "title", 1).zzc("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).zzc("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).zzc("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).zzc("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).zzc("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).zzc("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).zzc("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).zzc("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).zzc("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).zzc("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).zzc("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).zzc("com.google.android.gms.cast.metadata.WIDTH", "width", 2).zzc("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).zzc("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).zzc("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).zzc("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
  private final Bundle zzZr = new Bundle();
  private int zzZs;
  private final List<WebImage> zzxz = new ArrayList();
  
  public MediaMetadata()
  {
    this(0);
  }
  
  public MediaMetadata(int paramInt)
  {
    this.zzZs = paramInt;
  }
  
  private void zza(JSONObject paramJSONObject, String... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      String str;
      if (i < j)
      {
        str = paramVarArgs[i];
        if (!this.zzZr.containsKey(str)) {}
      }
      else
      {
        switch (zzZq.zzbW(str))
        {
        case 1: 
        case 4: 
          paramJSONObject.put(zzZq.zzbU(str), this.zzZr.getString(str));
          break;
        case 2: 
          paramJSONObject.put(zzZq.zzbU(str), this.zzZr.getInt(str));
          break;
        case 3: 
          paramJSONObject.put(zzZq.zzbU(str), this.zzZr.getDouble(str));
          break;
          paramVarArgs = this.zzZr.keySet().iterator();
          while (paramVarArgs.hasNext())
          {
            str = (String)paramVarArgs.next();
            if (!str.startsWith("com.google."))
            {
              Object localObject = this.zzZr.get(str);
              if ((localObject instanceof String)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Integer)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Double)) {
                paramJSONObject.put(str, localObject);
              }
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  private void zzb(JSONObject paramJSONObject, String... paramVarArgs)
  {
    paramVarArgs = new HashSet(Arrays.asList(paramVarArgs));
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        if (!"metadataType".equals(localObject1))
        {
          Object localObject2 = zzZq.zzbV((String)localObject1);
          if (localObject2 != null)
          {
            boolean bool = paramVarArgs.contains(localObject2);
            if (!bool) {}
          }
          else
          {
            try
            {
              localObject1 = paramJSONObject.get((String)localObject1);
              if (localObject1 != null) {
                switch (zzZq.zzbW((String)localObject2))
                {
                case 1: 
                  if ((localObject1 instanceof String)) {
                    this.zzZr.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 4: 
                  if (((localObject1 instanceof String)) && (zzln.zzci((String)localObject1) != null)) {
                    this.zzZr.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 2: 
                  if ((localObject1 instanceof Integer)) {
                    this.zzZr.putInt((String)localObject2, ((Integer)localObject1).intValue());
                  }
                  break;
                case 3: 
                  if ((localObject1 instanceof Double))
                  {
                    this.zzZr.putDouble((String)localObject2, ((Double)localObject1).doubleValue());
                    continue;
                    localObject2 = paramJSONObject.get((String)localObject1);
                    if ((localObject2 instanceof String)) {
                      this.zzZr.putString((String)localObject1, (String)localObject2);
                    } else if ((localObject2 instanceof Integer)) {
                      this.zzZr.putInt((String)localObject1, ((Integer)localObject2).intValue());
                    } else if ((localObject2 instanceof Double)) {
                      this.zzZr.putDouble((String)localObject1, ((Double)localObject2).doubleValue());
                    }
                  }
                  break;
                }
              }
            }
            catch (JSONException localJSONException) {}
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  private boolean zzb(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramBundle1.get(str);
      Object localObject2 = paramBundle2.get(str);
      if (((localObject1 instanceof Bundle)) && ((localObject2 instanceof Bundle)) && (!zzb((Bundle)localObject1, (Bundle)localObject2))) {
        return false;
      }
      if (localObject1 == null)
      {
        if ((localObject2 != null) || (!paramBundle2.containsKey(str))) {
          return false;
        }
      }
      else if (!localObject1.equals(localObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private void zzf(String paramString, int paramInt)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("null and empty keys are not allowed");
    }
    int i = zzZq.zzbW(paramString);
    if ((i != paramInt) && (i != 0)) {
      throw new IllegalArgumentException("Value for " + paramString + " must be a " + zzZp[paramInt]);
    }
  }
  
  public void addImage(WebImage paramWebImage)
  {
    this.zzxz.add(paramWebImage);
  }
  
  public void clear()
  {
    this.zzZr.clear();
    this.zzxz.clear();
  }
  
  public void clearImages()
  {
    this.zzxz.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.zzZr.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MediaMetadata)) {
        return false;
      }
      paramObject = (MediaMetadata)paramObject;
    } while ((zzb(this.zzZr, ((MediaMetadata)paramObject).zzZr)) && (this.zzxz.equals(((MediaMetadata)paramObject).zzxz)));
    return false;
  }
  
  public Calendar getDate(String paramString)
  {
    zzf(paramString, 4);
    paramString = this.zzZr.getString(paramString);
    if (paramString != null) {
      return zzln.zzci(paramString);
    }
    return null;
  }
  
  public String getDateAsString(String paramString)
  {
    zzf(paramString, 4);
    return this.zzZr.getString(paramString);
  }
  
  public double getDouble(String paramString)
  {
    zzf(paramString, 3);
    return this.zzZr.getDouble(paramString);
  }
  
  public List<WebImage> getImages()
  {
    return this.zzxz;
  }
  
  public int getInt(String paramString)
  {
    zzf(paramString, 2);
    return this.zzZr.getInt(paramString);
  }
  
  public int getMediaType()
  {
    return this.zzZs;
  }
  
  public String getString(String paramString)
  {
    zzf(paramString, 1);
    return this.zzZr.getString(paramString);
  }
  
  public boolean hasImages()
  {
    return (this.zzxz != null) && (!this.zzxz.isEmpty());
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.zzZr.keySet().iterator();
    String str;
    for (int i = 17; localIterator.hasNext(); i = this.zzZr.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i * 31 + this.zzxz.hashCode();
  }
  
  public Set<String> keySet()
  {
    return this.zzZr.keySet();
  }
  
  public void putDate(String paramString, Calendar paramCalendar)
  {
    zzf(paramString, 4);
    this.zzZr.putString(paramString, zzln.zza(paramCalendar));
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    zzf(paramString, 3);
    this.zzZr.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    zzf(paramString, 2);
    this.zzZr.putInt(paramString, paramInt);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    zzf(paramString1, 1);
    this.zzZr.putString(paramString1, paramString2);
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("metadataType", this.zzZs);
      zzln.zza(localJSONObject, this.zzxz);
      switch (this.zzZs)
      {
      default: 
        zza(localJSONObject, new String[0]);
        return localJSONObject;
      case 0: 
        zza(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 1: 
        zza(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 2: 
        zza(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return localJSONObject;
      case 3: 
        zza(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      }
      zza(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void zzf(JSONObject paramJSONObject)
  {
    clear();
    this.zzZs = 0;
    try
    {
      this.zzZs = paramJSONObject.getInt("metadataType");
      zzln.zza(this.zzxz, paramJSONObject);
      switch (this.zzZs)
      {
      default: 
        zzb(paramJSONObject, new String[0]);
        return;
      case 0: 
        zzb(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 1: 
        zzb(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 2: 
        zzb(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return;
      case 3: 
        zzb(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      }
      zzb(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  private static class zza
  {
    private final Map<String, String> zzZt = new HashMap();
    private final Map<String, String> zzZu = new HashMap();
    private final Map<String, Integer> zzZv = new HashMap();
    
    public String zzbU(String paramString)
    {
      return (String)this.zzZt.get(paramString);
    }
    
    public String zzbV(String paramString)
    {
      return (String)this.zzZu.get(paramString);
    }
    
    public int zzbW(String paramString)
    {
      paramString = (Integer)this.zzZv.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
      return 0;
    }
    
    public zza zzc(String paramString1, String paramString2, int paramInt)
    {
      this.zzZt.put(paramString1, paramString2);
      this.zzZu.put(paramString2, paramString1);
      this.zzZv.put(paramString1, Integer.valueOf(paramInt));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/MediaMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */