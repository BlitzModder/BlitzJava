package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznx;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle
{
  public static final int COLOR_UNSPECIFIED = 0;
  public static final float DEFAULT_FONT_SCALE = 1.0F;
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int EDGE_TYPE_UNSPECIFIED = -1;
  public static final int FONT_FAMILY_CASUAL = 4;
  public static final int FONT_FAMILY_CURSIVE = 5;
  public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
  public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
  public static final int FONT_FAMILY_SANS_SERIF = 0;
  public static final int FONT_FAMILY_SERIF = 2;
  public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
  public static final int FONT_FAMILY_UNSPECIFIED = -1;
  public static final int FONT_STYLE_BOLD = 1;
  public static final int FONT_STYLE_BOLD_ITALIC = 3;
  public static final int FONT_STYLE_ITALIC = 2;
  public static final int FONT_STYLE_NORMAL = 0;
  public static final int FONT_STYLE_UNSPECIFIED = -1;
  public static final int WINDOW_TYPE_NONE = 0;
  public static final int WINDOW_TYPE_NORMAL = 1;
  public static final int WINDOW_TYPE_ROUNDED = 2;
  public static final int WINDOW_TYPE_UNSPECIFIED = -1;
  private JSONObject zzZn;
  private float zzaaH;
  private int zzaaI;
  private int zzaaJ;
  private int zzaaK;
  private int zzaaL;
  private int zzaaM;
  private int zzaaN;
  private String zzaaO;
  private int zzaaP;
  private int zzaaQ;
  private int zzxq;
  
  public TextTrackStyle()
  {
    clear();
  }
  
  private void clear()
  {
    this.zzaaH = 1.0F;
    this.zzaaI = 0;
    this.zzxq = 0;
    this.zzaaJ = -1;
    this.zzaaK = 0;
    this.zzaaL = -1;
    this.zzaaM = 0;
    this.zzaaN = 0;
    this.zzaaO = null;
    this.zzaaP = -1;
    this.zzaaQ = -1;
    this.zzZn = null;
  }
  
  public static TextTrackStyle fromSystemSettings(Context paramContext)
  {
    TextTrackStyle localTextTrackStyle = new TextTrackStyle();
    if (!zznx.zzrU()) {
      return localTextTrackStyle;
    }
    paramContext = (CaptioningManager)paramContext.getSystemService("captioning");
    localTextTrackStyle.setFontScale(paramContext.getFontScale());
    paramContext = paramContext.getUserStyle();
    localTextTrackStyle.setBackgroundColor(paramContext.backgroundColor);
    localTextTrackStyle.setForegroundColor(paramContext.foregroundColor);
    label117:
    boolean bool1;
    boolean bool2;
    switch (paramContext.edgeType)
    {
    default: 
      localTextTrackStyle.setEdgeType(0);
      localTextTrackStyle.setEdgeColor(paramContext.edgeColor);
      paramContext = paramContext.getTypeface();
      if (paramContext != null)
      {
        if (!Typeface.MONOSPACE.equals(paramContext)) {
          break label158;
        }
        localTextTrackStyle.setFontGenericFamily(1);
        bool1 = paramContext.isBold();
        bool2 = paramContext.isItalic();
        if ((!bool1) || (!bool2)) {
          break label202;
        }
        localTextTrackStyle.setFontStyle(3);
      }
      break;
    }
    for (;;)
    {
      return localTextTrackStyle;
      localTextTrackStyle.setEdgeType(1);
      break;
      localTextTrackStyle.setEdgeType(2);
      break;
      label158:
      if (Typeface.SANS_SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(0);
        break label117;
      }
      if (Typeface.SERIF.equals(paramContext))
      {
        localTextTrackStyle.setFontGenericFamily(2);
        break label117;
      }
      localTextTrackStyle.setFontGenericFamily(0);
      break label117;
      label202:
      if (bool1) {
        localTextTrackStyle.setFontStyle(1);
      } else if (bool2) {
        localTextTrackStyle.setFontStyle(2);
      } else {
        localTextTrackStyle.setFontStyle(0);
      }
    }
  }
  
  private String zzL(int paramInt)
  {
    return String.format("#%02X%02X%02X%02X", new Object[] { Integer.valueOf(Color.red(paramInt)), Integer.valueOf(Color.green(paramInt)), Integer.valueOf(Color.blue(paramInt)), Integer.valueOf(Color.alpha(paramInt)) });
  }
  
  private int zzbX(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() == 9)
      {
        i = j;
        if (paramString.charAt(0) != '#') {}
      }
    }
    try
    {
      i = Integer.parseInt(paramString.substring(1, 3), 16);
      j = Integer.parseInt(paramString.substring(3, 5), 16);
      int k = Integer.parseInt(paramString.substring(5, 7), 16);
      i = Color.argb(Integer.parseInt(paramString.substring(7, 9), 16), i, j, k);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
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
        } while (!(paramObject instanceof TextTrackStyle));
        paramObject = (TextTrackStyle)paramObject;
        if (this.zzZn != null) {
          break;
        }
        i = 1;
        if (((TextTrackStyle)paramObject).zzZn != null) {
          break label218;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzZn == null) || (((TextTrackStyle)paramObject).zzZn == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zznu.zze(this.zzZn, ((TextTrackStyle)paramObject).zzZn));
    if ((this.zzaaH == ((TextTrackStyle)paramObject).zzaaH) && (this.zzaaI == ((TextTrackStyle)paramObject).zzaaI) && (this.zzxq == ((TextTrackStyle)paramObject).zzxq) && (this.zzaaJ == ((TextTrackStyle)paramObject).zzaaJ) && (this.zzaaK == ((TextTrackStyle)paramObject).zzaaK) && (this.zzaaL == ((TextTrackStyle)paramObject).zzaaL) && (this.zzaaN == ((TextTrackStyle)paramObject).zzaaN) && (zzf.zza(this.zzaaO, ((TextTrackStyle)paramObject).zzaaO)) && (this.zzaaP == ((TextTrackStyle)paramObject).zzaaP) && (this.zzaaQ == ((TextTrackStyle)paramObject).zzaaQ)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label218:
      j = 0;
      break label51;
    }
  }
  
  public int getBackgroundColor()
  {
    return this.zzxq;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzZn;
  }
  
  public int getEdgeColor()
  {
    return this.zzaaK;
  }
  
  public int getEdgeType()
  {
    return this.zzaaJ;
  }
  
  public String getFontFamily()
  {
    return this.zzaaO;
  }
  
  public int getFontGenericFamily()
  {
    return this.zzaaP;
  }
  
  public float getFontScale()
  {
    return this.zzaaH;
  }
  
  public int getFontStyle()
  {
    return this.zzaaQ;
  }
  
  public int getForegroundColor()
  {
    return this.zzaaI;
  }
  
  public int getWindowColor()
  {
    return this.zzaaM;
  }
  
  public int getWindowCornerRadius()
  {
    return this.zzaaN;
  }
  
  public int getWindowType()
  {
    return this.zzaaL;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Float.valueOf(this.zzaaH), Integer.valueOf(this.zzaaI), Integer.valueOf(this.zzxq), Integer.valueOf(this.zzaaJ), Integer.valueOf(this.zzaaK), Integer.valueOf(this.zzaaL), Integer.valueOf(this.zzaaM), Integer.valueOf(this.zzaaN), this.zzaaO, Integer.valueOf(this.zzaaP), Integer.valueOf(this.zzaaQ), this.zzZn });
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.zzxq = paramInt;
  }
  
  public void setCustomData(JSONObject paramJSONObject)
  {
    this.zzZn = paramJSONObject;
  }
  
  public void setEdgeColor(int paramInt)
  {
    this.zzaaK = paramInt;
  }
  
  public void setEdgeType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      throw new IllegalArgumentException("invalid edgeType");
    }
    this.zzaaJ = paramInt;
  }
  
  public void setFontFamily(String paramString)
  {
    this.zzaaO = paramString;
  }
  
  public void setFontGenericFamily(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid fontGenericFamily");
    }
    this.zzaaP = paramInt;
  }
  
  public void setFontScale(float paramFloat)
  {
    this.zzaaH = paramFloat;
  }
  
  public void setFontStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid fontStyle");
    }
    this.zzaaQ = paramInt;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.zzaaI = paramInt;
  }
  
  public void setWindowColor(int paramInt)
  {
    this.zzaaM = paramInt;
  }
  
  public void setWindowCornerRadius(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invalid windowCornerRadius");
    }
    this.zzaaN = paramInt;
  }
  
  public void setWindowType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid windowType");
    }
    this.zzaaL = paramInt;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fontScale", this.zzaaH);
      if (this.zzaaI != 0) {
        localJSONObject.put("foregroundColor", zzL(this.zzaaI));
      }
      if (this.zzxq != 0) {
        localJSONObject.put("backgroundColor", zzL(this.zzxq));
      }
      switch (this.zzaaJ)
      {
      case 0: 
        if (this.zzaaK != 0) {
          localJSONObject.put("edgeColor", zzL(this.zzaaK));
        }
        switch (this.zzaaL)
        {
        case 0: 
          label156:
          if (this.zzaaM != 0) {
            localJSONObject.put("windowColor", zzL(this.zzaaM));
          }
          if (this.zzaaL == 2) {
            localJSONObject.put("windowRoundedCornerRadius", this.zzaaN);
          }
          if (this.zzaaO != null) {
            localJSONObject.put("fontFamily", this.zzaaO);
          }
          switch (this.zzaaP)
          {
          case 0: 
            label264:
            switch (this.zzaaQ)
            {
            }
            break;
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (this.zzZn == null) {
          break label599;
        }
        localJSONObject.put("customData", this.zzZn);
        return localJSONObject;
        localJSONObject.put("edgeType", "NONE");
        break;
        localJSONObject.put("edgeType", "OUTLINE");
        break;
        localJSONObject.put("edgeType", "DROP_SHADOW");
        break;
        localJSONObject.put("edgeType", "RAISED");
        break;
        localJSONObject.put("edgeType", "DEPRESSED");
        break;
        localJSONObject.put("windowType", "NONE");
        break label156;
        localJSONObject.put("windowType", "NORMAL");
        break label156;
        localJSONObject.put("windowType", "ROUNDED_CORNERS");
        break label156;
        localJSONObject.put("fontGenericFamily", "SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
        break label264;
        localJSONObject.put("fontGenericFamily", "CASUAL");
        break label264;
        localJSONObject.put("fontGenericFamily", "CURSIVE");
        break label264;
        localJSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
        break label264;
        localJSONObject.put("fontStyle", "NORMAL");
        continue;
        localJSONObject.put("fontStyle", "BOLD");
        continue;
        localJSONObject.put("fontStyle", "ITALIC");
        continue;
        localJSONObject.put("fontStyle", "BOLD_ITALIC");
        continue;
        break;
        break label156;
        break label264;
      }
      label599:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public void zzf(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.zzaaH = ((float)paramJSONObject.optDouble("fontScale", 1.0D));
    this.zzaaI = zzbX(paramJSONObject.optString("foregroundColor"));
    this.zzxq = zzbX(paramJSONObject.optString("backgroundColor"));
    String str;
    if (paramJSONObject.has("edgeType"))
    {
      str = paramJSONObject.getString("edgeType");
      if ("NONE".equals(str)) {
        this.zzaaJ = 0;
      }
    }
    else
    {
      this.zzaaK = zzbX(paramJSONObject.optString("edgeColor"));
      if (paramJSONObject.has("windowType"))
      {
        str = paramJSONObject.getString("windowType");
        if (!"NONE".equals(str)) {
          break label325;
        }
        this.zzaaL = 0;
      }
      label128:
      this.zzaaM = zzbX(paramJSONObject.optString("windowColor"));
      if (this.zzaaL == 2) {
        this.zzaaN = paramJSONObject.optInt("windowRoundedCornerRadius", 0);
      }
      this.zzaaO = paramJSONObject.optString("fontFamily", null);
      if (paramJSONObject.has("fontGenericFamily"))
      {
        str = paramJSONObject.getString("fontGenericFamily");
        if (!"SANS_SERIF".equals(str)) {
          break label361;
        }
        this.zzaaP = 0;
      }
      label208:
      if (paramJSONObject.has("fontStyle"))
      {
        str = paramJSONObject.getString("fontStyle");
        if (!"NORMAL".equals(str)) {
          break label470;
        }
        this.zzaaQ = 0;
      }
    }
    for (;;)
    {
      this.zzZn = paramJSONObject.optJSONObject("customData");
      return;
      if ("OUTLINE".equals(str))
      {
        this.zzaaJ = 1;
        break;
      }
      if ("DROP_SHADOW".equals(str))
      {
        this.zzaaJ = 2;
        break;
      }
      if ("RAISED".equals(str))
      {
        this.zzaaJ = 3;
        break;
      }
      if (!"DEPRESSED".equals(str)) {
        break;
      }
      this.zzaaJ = 4;
      break;
      label325:
      if ("NORMAL".equals(str))
      {
        this.zzaaL = 1;
        break label128;
      }
      if (!"ROUNDED_CORNERS".equals(str)) {
        break label128;
      }
      this.zzaaL = 2;
      break label128;
      label361:
      if ("MONOSPACED_SANS_SERIF".equals(str))
      {
        this.zzaaP = 1;
        break label208;
      }
      if ("SERIF".equals(str))
      {
        this.zzaaP = 2;
        break label208;
      }
      if ("MONOSPACED_SERIF".equals(str))
      {
        this.zzaaP = 3;
        break label208;
      }
      if ("CASUAL".equals(str))
      {
        this.zzaaP = 4;
        break label208;
      }
      if ("CURSIVE".equals(str))
      {
        this.zzaaP = 5;
        break label208;
      }
      if (!"SMALL_CAPITALS".equals(str)) {
        break label208;
      }
      this.zzaaP = 6;
      break label208;
      label470:
      if ("BOLD".equals(str)) {
        this.zzaaQ = 1;
      } else if ("ITALIC".equals(str)) {
        this.zzaaQ = 2;
      } else if ("BOLD_ITALIC".equals(str)) {
        this.zzaaQ = 3;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/TextTrackStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */