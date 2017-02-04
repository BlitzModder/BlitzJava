package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

public final class NativeAppCallAttachmentStore
  implements NativeAppCallContentProvider.AttachmentDataSource
{
  static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
  private static final String TAG = NativeAppCallAttachmentStore.class.getName();
  private static File attachmentsDirectory;
  
  /* Error */
  private <T> void addAttachments(Context paramContext, UUID paramUUID, Map<String, T> paramMap, ProcessAttachment<T> paramProcessAttachment)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 46 1 0
    //   6: ifne +4 -> 10
    //   9: return
    //   10: getstatic 48	com/facebook/NativeAppCallAttachmentStore:attachmentsDirectory	Ljava/io/File;
    //   13: ifnonnull +8 -> 21
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 52	com/facebook/NativeAppCallAttachmentStore:cleanupAllAttachments	(Landroid/content/Context;)V
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 56	com/facebook/NativeAppCallAttachmentStore:ensureAttachmentsDirectoryExists	(Landroid/content/Context;)Ljava/io/File;
    //   26: pop
    //   27: new 58	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 59	java/util/ArrayList:<init>	()V
    //   34: astore_1
    //   35: aload_3
    //   36: invokeinterface 63 1 0
    //   41: invokeinterface 69 1 0
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 75 1 0
    //   53: ifeq -44 -> 9
    //   56: aload_3
    //   57: invokeinterface 79 1 0
    //   62: checkcast 81	java/util/Map$Entry
    //   65: astore 6
    //   67: aload 6
    //   69: invokeinterface 84 1 0
    //   74: checkcast 86	java/lang/String
    //   77: astore 5
    //   79: aload 6
    //   81: invokeinterface 89 1 0
    //   86: astore 6
    //   88: aload_0
    //   89: aload_2
    //   90: aload 5
    //   92: iconst_1
    //   93: invokevirtual 93	com/facebook/NativeAppCallAttachmentStore:getAttachmentFile	(Ljava/util/UUID;Ljava/lang/String;Z)Ljava/io/File;
    //   96: astore 5
    //   98: aload_1
    //   99: aload 5
    //   101: invokeinterface 99 2 0
    //   106: pop
    //   107: aload 4
    //   109: aload 6
    //   111: aload 5
    //   113: invokeinterface 103 3 0
    //   118: goto -71 -> 47
    //   121: astore_2
    //   122: getstatic 30	com/facebook/NativeAppCallAttachmentStore:TAG	Ljava/lang/String;
    //   125: new 105	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   132: ldc 108
    //   134: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload_1
    //   149: invokeinterface 125 1 0
    //   154: astore_1
    //   155: aload_1
    //   156: invokeinterface 75 1 0
    //   161: ifeq +25 -> 186
    //   164: aload_1
    //   165: invokeinterface 79 1 0
    //   170: checkcast 127	java/io/File
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 130	java/io/File:delete	()Z
    //   178: pop
    //   179: goto -24 -> 155
    //   182: astore_3
    //   183: goto -28 -> 155
    //   186: new 132	com/facebook/FacebookException
    //   189: dup
    //   190: aload_2
    //   191: invokespecial 135	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	NativeAppCallAttachmentStore
    //   0	195	1	paramContext	Context
    //   0	195	2	paramUUID	UUID
    //   0	195	3	paramMap	Map<String, T>
    //   0	195	4	paramProcessAttachment	ProcessAttachment<T>
    //   77	35	5	localObject1	Object
    //   65	45	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	47	121	java/io/IOException
    //   47	118	121	java/io/IOException
    //   174	179	182	java/lang/Exception
  }
  
  static File getAttachmentsDirectory(Context paramContext)
  {
    try
    {
      if (attachmentsDirectory == null) {
        attachmentsDirectory = new File(paramContext.getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      }
      paramContext = attachmentsDirectory;
      return paramContext;
    }
    finally {}
  }
  
  public void addAttachmentFilesForCall(Context paramContext, UUID paramUUID, Map<String, File> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "mediaAttachmentFiles");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "mediaAttachmentFiles");
    addAttachments(paramContext, paramUUID, paramMap, new ProcessAttachment()
    {
      public void processAttachment(File paramAnonymousFile1, File paramAnonymousFile2)
        throws IOException
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramAnonymousFile2);
        paramAnonymousFile2 = null;
        try
        {
          paramAnonymousFile1 = new FileInputStream(paramAnonymousFile1);
          try
          {
            paramAnonymousFile2 = new byte['Ѐ'];
            for (;;)
            {
              int i = paramAnonymousFile1.read(paramAnonymousFile2);
              if (i <= 0) {
                break;
              }
              localFileOutputStream.write(paramAnonymousFile2, 0, i);
            }
            Utility.closeQuietly(localFileOutputStream);
          }
          finally {}
        }
        finally
        {
          for (;;)
          {
            paramAnonymousFile1 = paramAnonymousFile2;
            paramAnonymousFile2 = (File)localObject;
          }
        }
        Utility.closeQuietly(paramAnonymousFile1);
        throw paramAnonymousFile2;
        Utility.closeQuietly(localFileOutputStream);
        Utility.closeQuietly(paramAnonymousFile1);
      }
    });
  }
  
  public void addAttachmentsForCall(Context paramContext, UUID paramUUID, Map<String, Bitmap> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "imageAttachments");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "imageAttachments");
    addAttachments(paramContext, paramUUID, paramMap, new ProcessAttachment()
    {
      public void processAttachment(Bitmap paramAnonymousBitmap, File paramAnonymousFile)
        throws IOException
      {
        paramAnonymousFile = new FileOutputStream(paramAnonymousFile);
        try
        {
          paramAnonymousBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramAnonymousFile);
          return;
        }
        finally
        {
          Utility.closeQuietly(paramAnonymousFile);
        }
      }
    });
  }
  
  void cleanupAllAttachments(Context paramContext)
  {
    Utility.deleteDirectory(getAttachmentsDirectory(paramContext));
  }
  
  public void cleanupAttachmentsForCall(Context paramContext, UUID paramUUID)
  {
    Utility.deleteDirectory(getAttachmentsDirectoryForCall(paramUUID, false));
  }
  
  File ensureAttachmentsDirectoryExists(Context paramContext)
  {
    paramContext = getAttachmentsDirectory(paramContext);
    paramContext.mkdirs();
    return paramContext;
  }
  
  File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
    throws IOException
  {
    paramUUID = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (paramUUID == null) {
      return null;
    }
    try
    {
      paramUUID = new File(paramUUID, URLEncoder.encode(paramString, "UTF-8"));
      return paramUUID;
    }
    catch (UnsupportedEncodingException paramUUID) {}
    return null;
  }
  
  File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    if (attachmentsDirectory == null) {
      paramUUID = null;
    }
    File localFile;
    do
    {
      do
      {
        return paramUUID;
        localFile = new File(attachmentsDirectory, paramUUID.toString());
        paramUUID = localFile;
      } while (!paramBoolean);
      paramUUID = localFile;
    } while (localFile.exists());
    localFile.mkdirs();
    return localFile;
  }
  
  public File openAttachment(UUID paramUUID, String paramString)
    throws FileNotFoundException
  {
    if ((Utility.isNullOrEmpty(paramString)) || (paramUUID == null)) {
      throw new FileNotFoundException();
    }
    try
    {
      paramUUID = getAttachmentFile(paramUUID, paramString, false);
      return paramUUID;
    }
    catch (IOException paramUUID)
    {
      throw new FileNotFoundException();
    }
  }
  
  static abstract interface ProcessAttachment<T>
  {
    public abstract void processAttachment(T paramT, File paramFile)
      throws IOException;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/NativeAppCallAttachmentStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */