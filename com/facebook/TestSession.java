package com.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphUser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestSession
  extends Session
{
  private static final String LOG_TAG = "FacebookSDK.TestSession";
  private static Map<String, TestAccount> appTestAccounts;
  private static final long serialVersionUID = 1L;
  private static String testApplicationId;
  private static String testApplicationSecret;
  private final Mode mode;
  private final List<String> requestedPermissions;
  private final String sessionUniqueUserTag;
  private String testAccountId;
  private String testAccountUserName;
  private boolean wasAskedToExtendAccessToken;
  
  static
  {
    if (!TestSession.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  TestSession(Activity paramActivity, List<String> paramList, TokenCachingStrategy paramTokenCachingStrategy, String paramString, Mode paramMode)
  {
    super(paramActivity, testApplicationId, paramTokenCachingStrategy);
    Validate.notNull(paramList, "permissions");
    Validate.notNullOrEmpty(testApplicationId, "testApplicationId");
    Validate.notNullOrEmpty(testApplicationSecret, "testApplicationSecret");
    this.sessionUniqueUserTag = paramString;
    this.mode = paramMode;
    this.requestedPermissions = paramList;
  }
  
  public static TestSession createSessionWithPrivateUser(Activity paramActivity, List<String> paramList)
  {
    return createTestSession(paramActivity, paramList, Mode.PRIVATE, null);
  }
  
  public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList)
  {
    return createSessionWithSharedUser(paramActivity, paramList, null);
  }
  
  public static TestSession createSessionWithSharedUser(Activity paramActivity, List<String> paramList, String paramString)
  {
    return createTestSession(paramActivity, paramList, Mode.SHARED, paramString);
  }
  
  private TestAccount createTestAccountAndFinishAuth()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("installed", "true");
    localBundle.putString("permissions", getPermissionsString());
    localBundle.putString("access_token", getAppAccessToken());
    if (this.mode == Mode.SHARED) {
      localBundle.putString("name", String.format("Shared %s Testuser", new Object[] { getSharedTestAccountIdentifier() }));
    }
    Object localObject = new Request(null, String.format("%s/accounts/test-users", new Object[] { testApplicationId }), localBundle, HttpMethod.POST).executeAndWait();
    FacebookRequestError localFacebookRequestError = ((Response)localObject).getError();
    localObject = (TestAccount)((Response)localObject).getGraphObjectAs(TestAccount.class);
    if (localFacebookRequestError != null)
    {
      finishAuthOrReauth(null, localFacebookRequestError.getException());
      return null;
    }
    assert (localObject != null);
    if (this.mode == Mode.SHARED)
    {
      ((TestAccount)localObject).setName(localBundle.getString("name"));
      storeTestAccount((TestAccount)localObject);
    }
    finishAuthWithTestAccount((TestAccount)localObject);
    return (TestAccount)localObject;
  }
  
  private static TestSession createTestSession(Activity paramActivity, List<String> paramList, Mode paramMode, String paramString)
  {
    Object localObject;
    try
    {
      if ((Utility.isNullOrEmpty(testApplicationId)) || (Utility.isNullOrEmpty(testApplicationSecret))) {
        throw new FacebookException("Must provide app ID and secret");
      }
    }
    finally
    {
      throw paramActivity;
      localObject = paramList;
      if (Utility.isNullOrEmpty(paramList)) {
        localObject = Arrays.asList(new String[] { "email", "publish_actions" });
      }
    }
    return paramActivity;
  }
  
  private void deleteTestAccount(String paramString1, String paramString2)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("access_token", paramString2);
    localObject = new Request(null, paramString1, (Bundle)localObject, HttpMethod.DELETE).executeAndWait();
    paramString2 = ((Response)localObject).getError();
    localObject = ((Response)localObject).getGraphObject();
    if (paramString2 != null) {
      Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: %s", new Object[] { paramString1, paramString2.getException().toString() }));
    }
    while ((((GraphObject)localObject).getProperty("FACEBOOK_NON_JSON_RESULT") != Boolean.valueOf(false)) && (((GraphObject)localObject).getProperty("success") != Boolean.valueOf(false))) {
      return;
    }
    Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: unknown reason", new Object[] { paramString1 }));
  }
  
  private void findOrCreateSharedTestAccount()
  {
    TestAccount localTestAccount = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier());
    if (localTestAccount != null)
    {
      finishAuthWithTestAccount(localTestAccount);
      return;
    }
    createTestAccountAndFinishAuth();
  }
  
  /* Error */
  private static TestAccount findTestAccountMatchingIdentifier(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 272	com/facebook/TestSession:retrieveTestAccountsForAppIfNeeded	()V
    //   6: getstatic 274	com/facebook/TestSession:appTestAccounts	Ljava/util/Map;
    //   9: invokeinterface 280 1 0
    //   14: invokeinterface 286 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 291 1 0
    //   26: ifeq +35 -> 61
    //   29: aload_3
    //   30: invokeinterface 295 1 0
    //   35: checkcast 11	com/facebook/TestSession$TestAccount
    //   38: astore_2
    //   39: aload_2
    //   40: invokeinterface 298 1 0
    //   45: aload_0
    //   46: invokevirtual 302	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   49: istore_1
    //   50: iload_1
    //   51: ifeq -31 -> 20
    //   54: aload_2
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: areturn
    //   61: aconst_null
    //   62: astore_0
    //   63: goto -7 -> 56
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString	String
    //   49	2	1	bool	boolean
    //   38	17	2	localTestAccount	TestAccount
    //   19	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   3	20	66	finally
    //   20	50	66	finally
  }
  
  private void finishAuthWithTestAccount(TestAccount paramTestAccount)
  {
    this.testAccountId = paramTestAccount.getId();
    this.testAccountUserName = paramTestAccount.getName();
    finishAuthOrReauth(AccessToken.createFromString(paramTestAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
  }
  
  static final String getAppAccessToken()
  {
    return testApplicationId + "|" + testApplicationSecret;
  }
  
  private String getPermissionsString()
  {
    return TextUtils.join(",", this.requestedPermissions);
  }
  
  private String getSharedTestAccountIdentifier()
  {
    long l2 = getPermissionsString().hashCode();
    if (this.sessionUniqueUserTag != null) {}
    for (long l1 = this.sessionUniqueUserTag.hashCode() & 0xFFFFFFFF;; l1 = 0L) {
      return validNameStringFromInteger(l2 & 0xFFFFFFFF ^ l1);
    }
  }
  
  public static String getTestApplicationId()
  {
    try
    {
      String str = testApplicationId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String getTestApplicationSecret()
  {
    try
    {
      String str = testApplicationSecret;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void populateTestAccounts(Collection<TestAccount> paramCollection, GraphObject paramGraphObject)
  {
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        TestAccount localTestAccount = (TestAccount)paramCollection.next();
        localTestAccount.setName(((GraphUser)paramGraphObject.getPropertyAs(localTestAccount.getId(), GraphUser.class)).getName());
        storeTestAccount(localTestAccount);
      }
    }
    finally {}
  }
  
  private static void retrieveTestAccountsForAppIfNeeded()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = appTestAccounts;
        if (localObject1 != null) {
          return;
        }
        appTestAccounts = new HashMap();
        Request.setDefaultBatchApplicationId(testApplicationId);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("access_token", getAppAccessToken());
        localObject1 = new Request(null, "app/accounts/test-users", (Bundle)localObject1, null);
        ((Request)localObject1).setBatchEntryName("testUsers");
        ((Request)localObject1).setBatchEntryOmitResultOnSuccess(false);
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("access_token", getAppAccessToken());
        ((Bundle)localObject3).putString("ids", "{result=testUsers:$.data.*.id}");
        ((Bundle)localObject3).putString("fields", "name");
        localObject3 = new Request(null, "", (Bundle)localObject3, null);
        ((Request)localObject3).setBatchEntryDependsOn("testUsers");
        localObject1 = Request.executeBatchAndWait(new Request[] { localObject1, localObject3 });
        if ((localObject1 == null) || (((List)localObject1).size() != 2)) {
          throw new FacebookException("Unexpected number of results from TestUsers batch query");
        }
      }
      finally {}
      populateTestAccounts(((TestAccountsResponse)((Response)((List)localObject2).get(0)).getGraphObjectAs(TestAccountsResponse.class)).getData(), ((Response)((List)localObject2).get(1)).getGraphObject());
    }
  }
  
  public static void setTestApplicationId(String paramString)
  {
    try
    {
      if ((testApplicationId != null) && (!testApplicationId.equals(paramString))) {
        throw new FacebookException("Can't have more than one test application ID");
      }
    }
    finally {}
    testApplicationId = paramString;
  }
  
  public static void setTestApplicationSecret(String paramString)
  {
    try
    {
      if ((testApplicationSecret != null) && (!testApplicationSecret.equals(paramString))) {
        throw new FacebookException("Can't have more than one test application secret");
      }
    }
    finally {}
    testApplicationSecret = paramString;
  }
  
  private static void storeTestAccount(TestAccount paramTestAccount)
  {
    try
    {
      appTestAccounts.put(paramTestAccount.getId(), paramTestAccount);
      return;
    }
    finally
    {
      paramTestAccount = finally;
      throw paramTestAccount;
    }
  }
  
  private String validNameStringFromInteger(long paramLong)
  {
    Object localObject = Long.toString(paramLong);
    StringBuilder localStringBuilder = new StringBuilder("Perm");
    int k = 0;
    localObject = ((String)localObject).toCharArray();
    int n = localObject.length;
    int j = 0;
    while (j < n)
    {
      int m = localObject[j];
      int i = m;
      if (m == k) {
        i = (char)(m + 10);
      }
      localStringBuilder.append((char)(i + 97 - 48));
      j += 1;
      k = i;
    }
    return localStringBuilder.toString();
  }
  
  void authorize(Session.AuthorizationRequest paramAuthorizationRequest)
  {
    if (this.mode == Mode.PRIVATE)
    {
      createTestAccountAndFinishAuth();
      return;
    }
    findOrCreateSharedTestAccount();
  }
  
  void extendAccessToken()
  {
    this.wasAskedToExtendAccessToken = true;
    super.extendAccessToken();
  }
  
  void fakeTokenRefreshAttempt()
  {
    setCurrentTokenRefreshRequest(new Session.TokenRefreshRequest(this));
  }
  
  void forceExtendAccessToken(boolean paramBoolean)
  {
    AccessToken localAccessToken = getTokenInfo();
    setTokenInfo(new AccessToken(localAccessToken.getToken(), new Date(), localAccessToken.getPermissions(), localAccessToken.getDeclinedPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
    setLastAttemptedTokenExtendDate(new Date(0L));
  }
  
  public final String getTestUserId()
  {
    return this.testAccountId;
  }
  
  public final String getTestUserName()
  {
    return this.testAccountUserName;
  }
  
  boolean getWasAskedToExtendAccessToken()
  {
    return this.wasAskedToExtendAccessToken;
  }
  
  void postStateChange(SessionState paramSessionState1, SessionState paramSessionState2, Exception paramException)
  {
    String str = this.testAccountId;
    super.postStateChange(paramSessionState1, paramSessionState2, paramException);
    if ((paramSessionState2.isClosed()) && (str != null) && (this.mode == Mode.PRIVATE)) {
      deleteTestAccount(str, getAppAccessToken());
    }
  }
  
  boolean shouldExtendAccessToken()
  {
    boolean bool = super.shouldExtendAccessToken();
    this.wasAskedToExtendAccessToken = false;
    return bool;
  }
  
  public final String toString()
  {
    String str = super.toString();
    return "{TestSession" + " testUserId:" + this.testAccountId + " " + str + "}";
  }
  
  private static enum Mode
  {
    PRIVATE,  SHARED;
    
    private Mode() {}
  }
  
  private static abstract interface TestAccount
    extends GraphObject
  {
    public abstract String getAccessToken();
    
    public abstract String getId();
    
    public abstract String getName();
    
    public abstract void setName(String paramString);
  }
  
  private static abstract interface TestAccountsResponse
    extends GraphObject
  {
    public abstract GraphObjectList<TestSession.TestAccount> getData();
  }
  
  private static final class TestTokenCachingStrategy
    extends TokenCachingStrategy
  {
    private Bundle bundle;
    
    public void clear()
    {
      this.bundle = null;
    }
    
    public Bundle load()
    {
      return this.bundle;
    }
    
    public void save(Bundle paramBundle)
    {
      this.bundle = paramBundle;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/TestSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */