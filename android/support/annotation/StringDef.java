package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface StringDef
{
  String[] value() default {};
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/android/support/annotation/StringDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */