package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompatBase
{
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setCompatTint(paramInt);
    }
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setCompatTintList(paramColorStateList);
    }
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setCompatTintMode(paramMode);
    }
  }
  
  public static Drawable wrapForTinting(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof DrawableWrapperDonut)) {
      localObject = new DrawableWrapperDonut(paramDrawable);
    }
    return (Drawable)localObject;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/android/support/v4/graphics/drawable/DrawableCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */