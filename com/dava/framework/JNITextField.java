package com.dava.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JNITextField
{
  private static final int CLOSE_KEYBOARD_DELAY = 30;
  private static final int NO_ACTIVE_TEXTFIELD = -1;
  private static final int STABLE_IME_OPTIONS = 33554432;
  private static final String TAG = "JNITextField";
  private static final int TEXT_CHANGE_DELAY_REFRESH = 100;
  private static final int TEXT_FIELD_HIDE_FROM_SCREEN_STEP = 20000;
  private static volatile int activeTextField = -1;
  private static Handler handler;
  private static SoftKeyboardStateHelper keyboardHelper;
  private static AttachedFrameLayout keyboardLayout;
  private static volatile int lastClosedTextField = -1;
  private static int lastSelectedImeMode;
  private static int lastSelectedInputType;
  static ArrayList<Long> last_four_calls = new ArrayList();
  private static volatile boolean readyToClose = false;
  static Map<Integer, TextField> textFields;
  
  static
  {
    keyboardHelper = null;
    keyboardLayout = null;
    handler = new Handler();
    lastSelectedImeMode = 0;
    lastSelectedInputType = 0;
    textFields = new HashMap();
  }
  
  public static void CloseKeyboard(int paramInt)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if (localTextField.hasFocus()) {
          localTextField.clearFocus();
        }
      }
    });
  }
  
  public static void Create(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    new RunOnUIThreadAndWaitUntilDone(new Runnable()
    {
      public void run()
      {
        Object localObject1 = JNIActivity.GetActivity();
        if (localObject1 == null)
        {
          Log.e("JNITextField", "can't create text field id:" + this.val$id + " activity is pausing");
          throw new RuntimeException("can't create text field id:" + this.val$id + " activity is pausing");
        }
        if (JNITextField.textFields.containsKey(Integer.valueOf(this.val$id)))
        {
          Log.e("JNITextField", String.format("Control with id:%d already created", new Object[] { Integer.valueOf(this.val$id) }));
          return;
        }
        int i = Math.round(paramFloat3);
        int j = Math.round(paramFloat4);
        final JNITextField.TextField localTextField = new JNITextField.TextField(this.val$id, (Context)localObject1, i, j);
        Object localObject2 = new FrameLayout.LayoutParams(i, j);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = Math.round(paramFloat1);
        ((FrameLayout.LayoutParams)localObject2).topMargin = Math.round(paramFloat2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 51;
        localTextField.setPadding(0, 0, 0, 0);
        localTextField.setSingleLine(true);
        localTextField.setBackgroundColor(0);
        localTextField.setTextColor(-1);
        localTextField.setVisibility(8);
        localTextField.setImeOptions(33554432);
        localTextField.setDrawingCacheEnabled(true);
        ((JNIActivity)localObject1).addContentView(localTextField, (ViewGroup.LayoutParams)localObject2);
        localTextField.setFilters(new InputFilter[] { new InputFilter()
        {
          public CharSequence filter(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, Spanned paramAnonymous2Spanned, final int paramAnonymous2Int3, final int paramAnonymous2Int4)
          {
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0) && (paramAnonymous2Int3 == paramAnonymous2Int4)) {
              paramAnonymous2Spanned = null;
            }
            Object localObject1;
            String str2;
            String str1;
            JNITextField.TextField localTextField;
            do
            {
              return paramAnonymous2Spanned;
              localObject1 = paramAnonymous2CharSequence;
              if ((localTextField.getInputType() & 0x60000) == 0)
              {
                localObject1 = new SpannableStringBuilder(paramAnonymous2CharSequence);
                if (((paramAnonymous2CharSequence instanceof Spanned)) || ((paramAnonymous2CharSequence instanceof Spannable))) {
                  TextUtils.copySpansFrom((Spanned)paramAnonymous2CharSequence, paramAnonymous2Int1, paramAnonymous2Int2, null, (Spannable)localObject1, 0);
                }
                i = 0;
                while (i < ((SpannableStringBuilder)localObject1).length())
                {
                  if ('\n' == ((SpannableStringBuilder)localObject1).charAt(i)) {
                    ((SpannableStringBuilder)localObject1).replace(i, i + 1, " ");
                  }
                  i += 1;
                }
              }
              str2 = ((CharSequence)localObject1).toString();
              str1 = "";
              localTextField = localTextField;
              int i = localTextField.getText().length();
              localObject2 = localObject1;
              if (i - (paramAnonymous2Int4 - paramAnonymous2Int3) + (paramAnonymous2Int2 - paramAnonymous2Int1) < i) {
                break label237;
              }
              localObject2 = localObject1;
              if (JNITextField.TextField.access$500(localTextField) == null) {
                break label237;
              }
              paramAnonymous2CharSequence = JNITextField.TextField.access$500(localTextField).filter((CharSequence)localObject1, paramAnonymous2Int1, paramAnonymous2Int2, paramAnonymous2Spanned, paramAnonymous2Int3, paramAnonymous2Int4);
              if (paramAnonymous2CharSequence == null) {
                break;
              }
              paramAnonymous2Spanned = paramAnonymous2CharSequence;
            } while (paramAnonymous2CharSequence.toString().isEmpty());
            final Object localObject2 = localObject1;
            if (paramAnonymous2CharSequence != null) {
              localObject2 = paramAnonymous2CharSequence;
            }
            label237:
            paramAnonymous2CharSequence = new FutureTask(new Callable()
            {
              public String call()
                throws Exception
              {
                byte[] arrayOfByte = localObject2.toString().getBytes("UTF-8");
                int i = 0;
                int k;
                for (int j = paramAnonymous2Int3; i < paramAnonymous2Int3; j = k)
                {
                  int m = i;
                  k = j;
                  if (this.val$text.codePointAt(i) > 65535)
                  {
                    m = i + 1;
                    k = j - 1;
                  }
                  i = m + 1;
                }
                return new String(JNITextField.TextFieldKeyPressed(JNITextField.4.this.val$id, j, paramAnonymous2Int4 - paramAnonymous2Int3, arrayOfByte), "UTF-8");
              }
            });
            try
            {
              JNITextField.TextField.access$602(true);
              JNIActivity.GetActivity().RunOnMainLoopThread(paramAnonymous2CharSequence);
              paramAnonymous2Spanned = (String)paramAnonymous2CharSequence.get();
              JNITextField.TextField.access$602(false);
              if (paramAnonymous2Spanned.equals(str2))
              {
                paramAnonymous2CharSequence = null;
              }
              else
              {
                paramAnonymous2Int1 = paramAnonymous2Spanned.length();
                paramAnonymous2CharSequence = str1;
                if (paramAnonymous2Int1 > 0) {
                  paramAnonymous2CharSequence = paramAnonymous2Spanned;
                }
              }
            }
            catch (InterruptedException paramAnonymous2CharSequence)
            {
              paramAnonymous2CharSequence.printStackTrace();
              paramAnonymous2CharSequence = str1;
            }
            catch (ExecutionException paramAnonymous2CharSequence)
            {
              paramAnonymous2CharSequence.printStackTrace();
              paramAnonymous2CharSequence = str1;
            }
            return paramAnonymous2CharSequence;
          }
        } });
        localTextField.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public boolean onEditorAction(TextView paramAnonymous2TextView, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
          {
            if (JNITextField.TextField.access$700(localTextField))
            {
              JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
              {
                public void run()
                {
                  JNITextField.TextFieldShouldReturn(JNITextField.4.this.val$id);
                }
              });
              localTextField.updateStaticTexture();
              return true;
            }
            return false;
          }
        });
        localTextField.setOnLongClickListener(new View.OnLongClickListener()
        {
          public boolean onLongClick(View paramAnonymous2View)
          {
            return !paramAnonymous2View.hasFocus();
          }
        });
        localTextField.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(View paramAnonymous2View, final boolean paramAnonymous2Boolean)
          {
            JNIActivity.GetActivity().RunOnMainLoopThread(new JNITextField.SafeRunnable()
            {
              public void safeRun()
              {
                JNITextField.TextFieldFocusChanged(JNITextField.4.this.val$id, paramAnonymous2Boolean);
              }
            });
            if (paramAnonymous2Boolean)
            {
              JNITextField.access$802(localTextField.getImeOptions());
              JNITextField.access$902(localTextField.getInputType());
              JNITextField.access$302(JNITextField.4.this.val$id);
              if (JNITextField.readyToClose)
              {
                if ((JNITextField.keyboardHelper != null) && (JNITextField.keyboardHelper.isSoftKeyboardOpened())) {
                  JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
                  {
                    final int localActiveId = JNITextField.activeTextField;
                    final int localLastCloseId = JNITextField.lastClosedTextField;
                    final Rect localRect = JNITextField.keyboardHelper.getLastSoftKeyboardBounds();
                    
                    public void run()
                    {
                      JNITextField.KeyboardClosed(this.localLastCloseId);
                      JNITextField.KeyboardOpened(this.localActiveId, this.localRect);
                    }
                  });
                }
                JNITextField.access$1002(false);
              }
            }
            for (;;)
            {
              JNITextField.GetTextField(JNITextField.4.this.val$id).updateStaticTexture();
              return;
              JNITextField.access$402(-1);
              ((InputMethodManager)JNIActivity.GetActivity().getSystemService("input_method")).showSoftInput(localTextField, 1);
              continue;
              JNITextField.access$402(JNITextField.4.this.val$id);
              JNITextField.access$1002(true);
              JNITextField.handler.postDelayed(new Runnable()
              {
                private final IBinder windowToken = JNITextField.4.4.this.val$text.getWindowToken();
                
                public void run()
                {
                  if (JNITextField.readyToClose)
                  {
                    ((InputMethodManager)JNIActivity.GetActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.windowToken, 0);
                    JNITextField.access$302(-1);
                    JNITextField.access$1002(false);
                  }
                }
              }, 30L);
            }
          }
        });
        localObject1 = new TextWatcher()
        {
          private byte[] emptyArray = new byte[0];
          private String oldText = "";
          
          public void afterTextChanged(final Editable paramAnonymous2Editable)
          {
            paramAnonymous2Editable = new Runnable()
            {
              public void run()
              {
                try
                {
                  byte[] arrayOfByte1 = paramAnonymous2Editable.toString().getBytes("UTF-8");
                  byte[] arrayOfByte2 = JNITextField.4.5.this.oldText.getBytes("UTF-8");
                  JNITextField.TextFieldOnTextChanged(JNITextField.4.this.val$id, arrayOfByte1, arrayOfByte2);
                  return;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  Log.e("JNITextField", localUnsupportedEncodingException.getMessage());
                  JNITextField.TextFieldOnTextChanged(JNITextField.4.this.val$id, JNITextField.4.5.this.emptyArray, JNITextField.4.5.this.emptyArray);
                }
              }
            };
            JNIActivity.GetActivity().RunOnMainLoopThread(paramAnonymous2Editable);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            if (paramAnonymous2CharSequence == null) {}
            for (paramAnonymous2CharSequence = "";; paramAnonymous2CharSequence = paramAnonymous2CharSequence.toString())
            {
              this.oldText = paramAnonymous2CharSequence;
              return;
            }
          }
          
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        };
        localObject2 = new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymous2Editable)
          {
            localTextField.updateStaticTexture();
          }
          
          public void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
          
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        };
        localTextField.addTextChangedListener((TextWatcher)localObject1);
        localTextField.addTextChangedListener((TextWatcher)localObject2);
        JNITextField.textFields.put(Integer.valueOf(this.val$id), localTextField);
      }
    }).RunAndWait();
  }
  
  static void Destroy(int paramInt)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        JNITextField.textFields.remove(Integer.valueOf(this.val$id));
        localTextField.clearFocus();
        ViewGroup localViewGroup = (ViewGroup)localTextField.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localTextField);
        }
      }
    });
  }
  
  public static void DestroyKeyboardLayout(WindowManager paramWindowManager)
  {
    if ((paramWindowManager != null) && (keyboardLayout != null)) {}
    try
    {
      if (keyboardLayout.isAttached()) {
        paramWindowManager.removeView(keyboardLayout);
      }
      keyboardLayout = null;
      if (keyboardHelper != null)
      {
        keyboardHelper.unsubscribe();
        keyboardHelper = null;
      }
      if (activeTextField != -1)
      {
        JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
        {
          final int localId = JNITextField.activeTextField;
          
          public void run()
          {
            JNITextField.KeyboardClosed(this.localId);
          }
        });
        paramWindowManager = GetTextField(activeTextField);
        if (paramWindowManager != null) {
          paramWindowManager.clearFocus();
        }
        activeTextField = -1;
        return;
      }
    }
    catch (IllegalArgumentException paramWindowManager)
    {
      do
      {
        for (;;)
        {
          Log.w(JNIConst.LOG_TAG, "DestroyKeyboardLayout: " + paramWindowManager.getMessage());
        }
      } while (lastClosedTextField == -1);
      JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
      {
        final int localId = JNITextField.lastClosedTextField;
        
        public void run()
        {
          JNITextField.KeyboardClosed(this.localId);
        }
      });
      lastClosedTextField = -1;
    }
  }
  
  public static int GetCursorPos(int paramInt)
  {
    return GetTextField(paramInt).getSelectionStart();
  }
  
  public static int GetLastKeyboardIMEOptions()
  {
    return lastSelectedImeMode;
  }
  
  public static int GetLastKeyboardInputType()
  {
    return lastSelectedInputType;
  }
  
  private static TextField GetTextField(int paramInt)
  {
    TextField localTextField = (TextField)textFields.get(Integer.valueOf(paramInt));
    if (localTextField == null)
    {
      Log.e("JNITextField", String.format("Unknown control id:%d", new Object[] { Integer.valueOf(paramInt) }));
      throw new ControlNotFoundException("can't find JNITextField by id:" + paramInt);
    }
    return localTextField;
  }
  
  public static void HideAllTextFields()
  {
    Iterator localIterator = textFields.values().iterator();
    while (localIterator.hasNext()) {
      ((TextField)localIterator.next()).setVisibility(8);
    }
  }
  
  public static void InitializeKeyboardLayout(WindowManager paramWindowManager, IBinder paramIBinder)
  {
    if (keyboardLayout == null) {
      if (paramWindowManager == null) {
        Log.e("JNITextField", "[InitializeKeyboardLayout] WindowManager must be specified");
      }
    }
    while ((keyboardHelper != null) || (keyboardLayout == null))
    {
      return;
      if (paramIBinder == null)
      {
        Log.e("JNITextField", "[InitializeKeyboardLayout] Window token must be specified");
        return;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(0, -1, 1000, 1304, -2);
      localLayoutParams.softInputMode = 16;
      localLayoutParams.packageName = JNIApplication.GetApplication().getPackageName();
      localLayoutParams.gravity = 51;
      localLayoutParams.token = paramIBinder;
      keyboardLayout = new AttachedFrameLayout(JNIActivity.GetActivity());
      paramWindowManager.addView(keyboardLayout, localLayoutParams);
      JNIActivity.HideNavigationBar(keyboardLayout);
    }
    keyboardHelper = new SoftKeyboardStateHelper(keyboardLayout);
    keyboardHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener()
    {
      public void onSoftKeyboardClosed()
      {
        JNITextField.TextField localTextField;
        if (JNITextField.activeTextField != -1)
        {
          localTextField = JNITextField.GetTextField(JNITextField.activeTextField);
          if (localTextField != null)
          {
            if (JNITextField.lastClosedTextField != -1) {
              break label54;
            }
            JNITextField.access$302(-1);
            localTextField.clearFocus();
          }
        }
        for (;;)
        {
          JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
          {
            final int localId = JNITextField.lastClosedTextField;
            
            public void run()
            {
              JNITextField.KeyboardClosed(this.localId);
            }
          });
          JNITextField.access$402(-1);
          return;
          label54:
          localTextField.requestFocus();
        }
      }
      
      public void onSoftKeyboardOpened(final Rect paramAnonymousRect)
      {
        JNIActivity.GetActivity().RunOnMainLoopThread(new Runnable()
        {
          final int localId = JNITextField.activeTextField;
          
          public void run()
          {
            JNITextField.KeyboardOpened(this.localId, paramAnonymousRect);
          }
        });
      }
    });
  }
  
  public static boolean IsRenderToTexture(int paramInt)
  {
    return GetTextField(paramInt).isRenderToTexture();
  }
  
  public static void KeyboardClosed(int paramInt)
  {
    if (paramInt != -1)
    {
      JNIActivity.GetActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          JNIActivity.HideNavigationBar(JNIActivity.GetActivity().getWindow().getDecorView());
        }
      });
      TextFieldKeyboardHidden(paramInt);
    }
  }
  
  public static void KeyboardOpened(int paramInt, Rect paramRect)
  {
    if (paramInt != -1) {
      TextFieldKeyboardShown(paramInt, paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
  }
  
  public static void OpenKeyboard(int paramInt)
  {
    long l = new Date().getTime();
    last_four_calls.add(Long.valueOf(l));
    if (last_four_calls.size() > 4)
    {
      last_four_calls.remove(0);
      if (l - ((Long)last_four_calls.get(0)).longValue() < 240L)
      {
        Log.e("JNITextField", "multiple simultanious tap on textfield detected");
        return;
      }
    }
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if ((!localTextField.hasFocus()) && (!localTextField.requestFocus())) {
          Log.e("JNITextField", "OpenKeyboard can't took focus");
        }
      }
    });
  }
  
  protected static void RelinkNativeControls()
  {
    Iterator localIterator = textFields.values().iterator();
    while (localIterator.hasNext())
    {
      TextField localTextField = (TextField)localIterator.next();
      ((ViewGroup)localTextField.getParent()).removeView(localTextField);
      JNIActivity.GetActivity().addContentView(localTextField, localTextField.getLayoutParams());
    }
  }
  
  public static void SetAutoCapitalizationType(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        int i = this.text.getInputType() & 0x8FFF;
        switch (paramInt2)
        {
        }
        for (;;)
        {
          this.text.setInputType(i);
          return;
          i |= 0x2000;
          continue;
          i |= 0x4000;
          continue;
          i |= 0x1000;
        }
      }
    });
  }
  
  public static void SetAutoCorrectionType(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        int i = this.text.getInputType();
        switch (paramInt2)
        {
        case 1: 
        default: 
          i &= 0xFFFF7FFF;
        }
        for (;;)
        {
          this.text.setInputType(i);
          return;
          i |= 0x8000;
        }
      }
    });
  }
  
  public static void SetCursorPos(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.GetTextField(this.val$id).setSelection(paramInt2);
      }
    });
  }
  
  public static void SetEnableReturnKeyAutomatically(int paramInt, boolean paramBoolean)
  {
    Log.e("JNITextField", "SetEnableReturnKeyAutomatically not supported on android");
  }
  
  public static void SetFontSize(int paramInt, final float paramFloat)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        this.text.setTextSize(0, (int)paramFloat);
      }
    });
  }
  
  public static void SetInputEnabled(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        this.text.setEnabled(paramBoolean);
      }
    });
  }
  
  public static void SetIsPassword(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        if (paramBoolean)
        {
          this.text.setInputType(129);
          return;
        }
        this.text.setInputType(this.text.getInputType() & 0xFF7F);
      }
    });
  }
  
  public static void SetKeyboardAppearanceType(int paramInt1, int paramInt2)
  {
    Log.e("JNITextField", "SetKeyboardAppearanceType not supported on android");
  }
  
  public static void SetKeyboardType(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        int i = this.text.getInputType() & 0xFFFFFFCC;
        switch (paramInt2)
        {
        default: 
          i |= 0x1;
        }
        for (;;)
        {
          this.text.setInputType(i);
          return;
          i |= 0x2;
          continue;
          i |= 0x11;
          continue;
          i |= 0x21;
        }
      }
    });
  }
  
  public static void SetMaxLength(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if (paramInt2 > 0)
        {
          JNITextField.TextField.access$502(localTextField, new InputFilter.LengthFilter(paramInt2));
          return;
        }
        JNITextField.TextField.access$502(localTextField, null);
      }
    });
  }
  
  public static void SetMultiline(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if (paramBoolean)
        {
          localTextField.setSingleLine(false);
          localTextField.setRenderToTexture(false);
          return;
        }
        localTextField.setSingleLine(true);
      }
    });
  }
  
  public static void SetRenderToTexture(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if (JNITextField.TextField.access$700(localTextField))
        {
          localTextField.setRenderToTexture(paramBoolean);
          return;
        }
        localTextField.setRenderToTexture(false);
      }
    });
  }
  
  public static void SetReturnKeyType(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        int i;
        switch (paramInt2)
        {
        case 3: 
        case 5: 
        default: 
          i = 6;
        }
        for (;;)
        {
          this.text.setImeOptions(0x2000000 | i);
          return;
          i = 2;
          continue;
          i = 3;
          continue;
          i = 5;
          continue;
          i = 4;
        }
      }
    });
  }
  
  public static void SetSpellCheckingType(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        int i = this.text.getInputType();
        switch (paramInt2)
        {
        case 1: 
        default: 
          i &= 0xFFFEFFFF;
        }
        for (;;)
        {
          this.text.setInputType(i);
          return;
          i |= 0x10000;
        }
      }
    });
  }
  
  public static void SetText(int paramInt, final String paramString)
  {
    paramString = new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        this.text.setText(paramString);
        this.text.setSelection(this.text.getText().length());
      }
    };
    if (TextField.isFilteringOnText)
    {
      JNIActivity.GetActivity().runOnUiThread(paramString);
      return;
    }
    new RunOnUIThreadAndWaitUntilDone(paramString).RunAndWait();
  }
  
  public static void SetTextAlign(int paramInt1, final int paramInt2)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt1)
    {
      public void safeRun()
      {
        if ((this.text.getGravity() & 0x800007) > 0) {}
        for (int k = 1;; k = 0)
        {
          int j = 16;
          if ((paramInt2 & 0x1) > 0) {}
          int i = 3;
          if ((paramInt2 & 0x2) > 0) {
            i = 1;
          }
          if ((paramInt2 & 0x4) > 0) {
            i = 5;
          }
          if ((paramInt2 & 0x8) > 0) {
            j = 48;
          }
          if ((paramInt2 & 0x10) > 0) {
            j = 16;
          }
          if ((paramInt2 & 0x20) > 0) {
            j = 80;
          }
          int m = i;
          if (k != 0) {
            m = i | 0x800000;
          }
          this.text.setGravity(m | j);
          return;
        }
      }
    });
  }
  
  public static void SetTextColor(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        int i = Color.argb((int)(paramFloat4 * 255.0F), (int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F));
        this.text.setTextColor(i);
      }
    });
  }
  
  public static void SetTextUseRtlAlign(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnableNoFilters(paramInt)
    {
      public void safeRun()
      {
        int i = this.text.getGravity();
        if (paramBoolean)
        {
          this.text.setGravity(0x800000 | i);
          return;
        }
        this.text.setGravity(0xFF7FFFFF & i);
      }
    });
  }
  
  public static void SetVisible(int paramInt, final boolean paramBoolean)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        if ((!paramBoolean) && (localTextField.hasFocus())) {
          localTextField.clearFocus();
        }
        localTextField.setVisible(paramBoolean);
      }
    });
  }
  
  public static void ShowVisibleTextFields()
  {
    JNIActivity.GetActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = JNITextField.textFields.values().iterator();
        while (localIterator.hasNext())
        {
          JNITextField.TextField localTextField = (JNITextField.TextField)localIterator.next();
          localTextField.restoreVisibility();
          localTextField.updateStaticTexture();
        }
      }
    });
  }
  
  public static native void TextFieldFocusChanged(int paramInt, boolean paramBoolean);
  
  public static native byte[] TextFieldKeyPressed(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public static native void TextFieldKeyboardHidden(int paramInt);
  
  public static native void TextFieldKeyboardShown(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void TextFieldOnTextChanged(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native void TextFieldShouldReturn(int paramInt);
  
  public static native void TextFieldUpdateTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  public static void UpdateRect(int paramInt, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    JNIActivity.GetActivity().runOnUiThread(new SafeRunnable()
    {
      public void safeRun()
      {
        JNITextField.TextField localTextField = JNITextField.GetTextField(this.val$id);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localTextField.getLayoutParams();
        localLayoutParams.leftMargin = Math.round(paramFloat1);
        int i = (int)(paramFloat1 + 0.5F);
        if (localTextField.isRenderToTexture()) {}
        for (localLayoutParams.leftMargin = (i + 20000);; localLayoutParams.leftMargin = i)
        {
          localLayoutParams.topMargin = Math.round(paramFloat2);
          localLayoutParams.width = Math.round(paramFloat3);
          localLayoutParams.height = Math.round(paramFloat4);
          if ((JNITextField.TextField.access$1500(localTextField) != localLayoutParams.width) || (JNITextField.TextField.access$1600(localTextField) != localLayoutParams.height))
          {
            JNITextField.TextField.access$1502(localTextField, localLayoutParams.width);
            JNITextField.TextField.access$1602(localTextField, localLayoutParams.height);
            localTextField.updateStaticTexture();
          }
          localTextField.setLayoutParams(localLayoutParams);
          return;
        }
      }
    });
  }
  
  static class AttachedFrameLayout
    extends FrameLayout
    implements View.OnAttachStateChangeListener
  {
    private boolean isAttached = false;
    
    public AttachedFrameLayout(Context paramContext)
    {
      super();
      addOnAttachStateChangeListener(this);
    }
    
    public AttachedFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      addOnAttachStateChangeListener(this);
    }
    
    public AttachedFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      addOnAttachStateChangeListener(this);
    }
    
    public boolean isAttached()
    {
      return this.isAttached;
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      if (paramView == this) {
        this.isAttached = true;
      }
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      if (paramView == this) {
        this.isAttached = false;
      }
    }
  }
  
  static class ControlNotFoundException
    extends RuntimeException
  {
    private static final long serialVersionUID = 5293533328872853457L;
    
    public ControlNotFoundException(String paramString)
    {
      super();
    }
  }
  
  private static class RunOnUIThreadAndWaitUntilDone
  {
    Runnable task = null;
    
    public RunOnUIThreadAndWaitUntilDone(Runnable paramRunnable)
    {
      this.task = paramRunnable;
    }
    
    public void RunAndWait()
    {
      FutureTask localFutureTask = new FutureTask(this.task, null);
      JNIActivity.GetActivity().runOnUiThread(localFutureTask);
      try
      {
        if (JNIActivity.GetActivity().GetIsPausing())
        {
          Log.e("JNITextField", "can't do task - activity is pausing");
          return;
        }
        localFutureTask.get();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.printStackTrace();
      }
    }
  }
  
  static abstract class SafeRunnable
    implements Runnable
  {
    public void run()
    {
      try
      {
        safeRun();
        return;
      }
      catch (JNITextField.ControlNotFoundException localControlNotFoundException)
      {
        Log.e("JNITextField", "can't found TextField:\n" + localControlNotFoundException.getMessage());
      }
    }
    
    public abstract void safeRun();
  }
  
  static abstract class SafeRunnableNoFilters
    implements Runnable
  {
    private int id;
    protected JNITextField.TextField text = null;
    
    SafeRunnableNoFilters(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void run()
    {
      try
      {
        this.text = JNITextField.GetTextField(this.id);
        InputFilter[] arrayOfInputFilter = this.text.getFilters();
        this.text.setFilters(new InputFilter[0]);
        safeRun();
        this.text.setFilters(arrayOfInputFilter);
        this.text.updateStaticTexture();
        return;
      }
      catch (JNITextField.ControlNotFoundException localControlNotFoundException)
      {
        Log.e("JNITextField", localControlNotFoundException.getMessage());
      }
    }
    
    public abstract void safeRun();
  }
  
  static class TextField
    extends EditText
  {
    private static volatile boolean isFilteringOnText = false;
    private int height = 0;
    private final int id;
    private volatile boolean isRenderToTexture = false;
    private boolean isSingleLine = true;
    private boolean logicVisible = false;
    private InputFilter maxTextFilter = null;
    private int[] pixels = null;
    private int viewHeight;
    private int viewWidth;
    private int width = 0;
    
    TextField(int paramInt1, Context paramContext, int paramInt2, int paramInt3)
    {
      super();
      this.id = paramInt1;
      this.viewWidth = paramInt2;
      this.viewHeight = paramInt3;
    }
    
    private void clearStaticTexture()
    {
      JNIActivity localJNIActivity = JNIActivity.GetActivity();
      JNITextField.UpdateTexture localUpdateTexture = new JNITextField.UpdateTexture(this.id, null, 0, 0);
      if (localJNIActivity.GetMainLoopThreadID() == Thread.currentThread().getId())
      {
        localUpdateTexture.run();
        return;
      }
      localJNIActivity.RunOnMainLoopThread(localUpdateTexture);
    }
    
    private void renderToTexture()
    {
      int i = 0;
      setDrawingCacheEnabled(true);
      buildDrawingCache();
      Object localObject2 = getDrawingCache();
      Object localObject1 = localObject2;
      int j;
      if (localObject2 == null)
      {
        if ((this.viewHeight <= 0) || (this.viewHeight <= 0)) {
          return;
        }
        measure(View.MeasureSpec.makeMeasureSpec(this.viewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.viewHeight, 1073741824));
        i = getMeasuredWidth();
        j = getMeasuredHeight();
        if ((j <= 0) || (i <= 0))
        {
          Log.e("JNITextField", "can't measure layout for TextField with id:" + this.id + " w = " + this.viewWidth + " h = " + this.viewHeight);
          return;
        }
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas((Bitmap)localObject1);
        layout(0, 0, i, j);
        draw((Canvas)localObject2);
        i = 1;
      }
      if ((this.pixels == null) || (this.width != ((Bitmap)localObject1).getWidth()) || (this.height != ((Bitmap)localObject1).getHeight()))
      {
        this.width = ((Bitmap)localObject1).getWidth();
        this.height = ((Bitmap)localObject1).getHeight();
        this.pixels = new int[this.width * this.height];
      }
      ((Bitmap)localObject1).getPixels(this.pixels, 0, this.width, 0, 0, this.width, this.height);
      setDrawingCacheEnabled(false);
      if (i != 0) {
        ((Bitmap)localObject1).recycle();
      }
      int k = 1;
      localObject1 = this.pixels;
      int m = localObject1.length;
      i = 0;
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (localObject1[i] != 0) {
            j = 0;
          }
        }
        else
        {
          if ((j == 0) || (getText().length() <= 0)) {
            break;
          }
          Log.e("JNITextField", "ERROR render one more time to texture");
          postDelayed(new Runnable()
          {
            public void run()
            {
              JNITextField.TextField.this.renderToTexture();
            }
          }, 1L);
          return;
        }
        i += 1;
      }
      JNIActivity.GetActivity().RunOnMainLoopThread(new JNITextField.UpdateTexture(this.id, this.pixels, this.width, this.height));
    }
    
    public boolean isRenderToTexture()
    {
      return this.isRenderToTexture;
    }
    
    public boolean isVisible()
    {
      return this.logicVisible;
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        if (paramKeyEvent.getAction() == 0) {}
        for (;;)
        {
          return true;
          clearFocus();
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (this.isSingleLine)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setLocation(getLeft() + paramMotionEvent.getX(), getTop() + paramMotionEvent.getY());
        JNIActivity.GetActivity().GetSurfaceView().dispatchTouchEvent(localMotionEvent);
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    
    public void restoreVisibility()
    {
      setVisible(this.logicVisible);
    }
    
    public void setRenderToTexture(boolean paramBoolean)
    {
      this.isRenderToTexture = paramBoolean;
      updateStaticTexture();
    }
    
    public void setSingleLine(boolean paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      this.isSingleLine = paramBoolean;
    }
    
    public void setVisible(boolean paramBoolean)
    {
      this.logicVisible = paramBoolean;
      if (this.logicVisible)
      {
        setVisibility(0);
        return;
      }
      setVisibility(8);
    }
    
    public void updateStaticTexture()
    {
      JNIActivity localJNIActivity = JNIActivity.GetActivity();
      if (!localJNIActivity.GetIsPausing())
      {
        if (getText().length() == 0) {
          clearStaticTexture();
        }
      }
      else {
        return;
      }
      if (this.isRenderToTexture)
      {
        Runnable local2 = new Runnable()
        {
          public void run()
          {
            JNITextField.TextField.this.renderToTexture();
          }
        };
        if (localJNIActivity.GetMainLoopThreadID() == Thread.currentThread().getId())
        {
          localJNIActivity.runOnUiThread(local2);
          return;
        }
        local2.run();
        return;
      }
      clearStaticTexture();
    }
  }
  
  static class UpdateTexture
    implements Runnable
  {
    int height;
    int id;
    int[] pixels;
    int width;
    
    UpdateTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
    {
      this.id = paramInt1;
      this.pixels = paramArrayOfInt;
      this.width = paramInt2;
      this.height = paramInt3;
    }
    
    public void run()
    {
      if (!JNIActivity.GetActivity().GetIsPausing())
      {
        JNITextField.TextFieldUpdateTexture(this.id, this.pixels, this.width, this.height);
        JNITextField.SafeRunnable local1 = new JNITextField.SafeRunnable()
        {
          public void safeRun()
          {
            JNITextField.TextField localTextField = JNITextField.GetTextField(JNITextField.UpdateTexture.this.id);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localTextField.getLayoutParams();
            if (localTextField.isRenderToTexture) {
              if (localLayoutParams.leftMargin < 20000) {
                localLayoutParams.leftMargin += 20000;
              }
            }
            for (;;)
            {
              localTextField.setLayoutParams(localLayoutParams);
              return;
              if (localLayoutParams.leftMargin >= 20000) {
                localLayoutParams.leftMargin -= 20000;
              }
            }
          }
        };
        JNIActivity.GetActivity().runOnUiThread(local1);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNITextField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */