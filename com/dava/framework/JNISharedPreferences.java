package com.dava.framework;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class JNISharedPreferences
{
  static String name = "DavaPreferences";
  SharedPreferences.Editor editor = null;
  SharedPreferences preferences = null;
  
  public static String GetName()
  {
    return name;
  }
  
  public static Object GetSharedPreferences()
  {
    return new JNISharedPreferences();
  }
  
  public void Clear()
  {
    this.editor.clear();
    this.editor.apply();
  }
  
  public long GetLong(String paramString, long paramLong)
  {
    return this.preferences.getLong(paramString, paramLong);
  }
  
  public String GetString(String paramString1, String paramString2)
  {
    return this.preferences.getString(paramString1, paramString2);
  }
  
  public void Push()
  {
    this.editor.apply();
  }
  
  public void PutLong(String paramString, long paramLong)
  {
    this.editor.putLong(paramString, paramLong);
  }
  
  public void PutString(String paramString1, String paramString2)
  {
    this.editor.putString(paramString1, paramString2);
  }
  
  public void Remove(String paramString)
  {
    this.editor.remove(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNISharedPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */