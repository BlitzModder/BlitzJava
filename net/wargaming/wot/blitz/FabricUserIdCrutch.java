package net.wargaming.wot.blitz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.crashlytics.android.Crashlytics;
import com.dava.framework.JNIActivity;

public class FabricUserIdCrutch
{
  private static final String NOT_SET = "notset";
  private static final String PREFERENCES_NAME = "fabric_crutch_user_store";
  private static final String USER_EMAIL_KEY = "fabric_crutch_user_email_nobackup";
  private static final String USER_IDENTIFIER_KEY = "fabric_crutch_user_identifier_nobackup";
  private static final String USER_NAME_KEY = "fabric_crutch_user_name_nobackup";
  
  public static void Crutch()
  {
    try
    {
      Crashlytics.setUserName(GetStoredData("fabric_crutch_user_name_nobackup"));
      Crashlytics.setUserIdentifier(GetStoredData("fabric_crutch_user_identifier_nobackup"));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private static String GetStoredData(String paramString)
  {
    try
    {
      paramString = JNIActivity.GetActivity().getSharedPreferences("fabric_crutch_user_store", 0).getString(paramString, "notset");
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "notset";
  }
  
  private static void SaveData(String paramString1, String paramString2)
  {
    try
    {
      if (paramString2.equalsIgnoreCase("unknown")) {
        return;
      }
      JNIActivity.GetActivity().getSharedPreferences("fabric_crutch_user_store", 0).edit().putString(paramString1, paramString2).commit();
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void setUserEmail(String paramString)
  {
    SaveData("fabric_crutch_user_email_nobackup", paramString);
  }
  
  public static void setUserIdentifier(String paramString)
  {
    SaveData("fabric_crutch_user_identifier_nobackup", paramString);
  }
  
  public static void setUserName(String paramString)
  {
    SaveData("fabric_crutch_user_name_nobackup", paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/blitz/FabricUserIdCrutch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */