# MultiTheme
[![Uplabs](https://img.shields.io/badge/Uplabs-multitheme-orange.svg)](https://www.uplabs.com/posts/multitheme)

**Sample Project** to demonstrate that how to use multi theme in Android application without using any Libraries.

It's very easy to implement multiple themes in your Application, with any customization that you wants, you can refer this project to implement/learn multiple theme in your Android Application.

 <img src="https://github.com/UttamPanchasara/MultiTheme/blob/master/app/src/main/assets/gif/multitheme.gif" height="400" alt="Screenshot"/> 

### Basic Steps to Implement Multiple Themes

**Steps to implement multiple themes as Followed in this Sample Project :**

### Step 1:
Create custom attributes :

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="themes">
        <attr name="myWindowBackground" format="reference"/>
        <attr name="myTabBackgroundColor" format="reference"/>
        <attr name="myTabTextColor" format="reference"/>
        <attr name="myTabTextSelectedColor" format="reference"/>
        <attr name="myTabIndicatorColor" format="reference"/>
        <attr name="myPrimaryTextColor" format="reference"/>
        <attr name="mySecondaryTextColor" format="reference"/>
    </declare-styleable>
</resources>
```

### Step 2:
Create custom theme style Based on your defined attributes :

```xml
<style xmlns:android="http://schemas.android.com/apk/res/android" name="Green">
        <item name="colorPrimary">@color/greenColorPrimary</item>
        <item name="colorPrimaryDark">@color/greenColorPrimaryDark</item>
        <item name="colorAccent">@color/greenColorAccent</item>

        <item name="myWindowBackground">@color/greenBackgroundColor</item>
        <item name="myTabBackgroundColor">@color/greenTabBackgroundColor</item>
        <item name="myTabTextColor">@color/greenTabTextColor</item>
        <item name="myTabTextSelectedColor">@color/greenTabTextSelectedColor</item>
        <item name="myTabIndicatorColor">@color/greenTabIndicatorColor</item>
        <item name="myPrimaryTextColor">@color/greenPrimaryText</item>
        <item name="mySecondaryTextColor">@color/greenSecondaryText</item>
 </style>
```

### Step 3:
Set values with custom attributes :

```xml
 <android.support.design.widget.TabLayout
            app:layout_constraintTop_toBottomOf="@+id/toolbar"
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            app:tabBackground="?myTabBackgroundColor"
            app:tabTextColor="?myTabTextColor"
            app:tabIndicator="?myTabIndicatorColor"
            app:tabSelectedTextColor="?myTabTextSelectedColor"
            android:layout_height="wrap_content"/>
```

### Apply Theme :
To Apply any theme use `setTheme()` just before `super.onCreate` :
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Green)
        super.onCreate(savedInstanceState)
    }
```

**Above steps help in setup multi theme styles and attributes**

### That's it!, To Switch theme at runtime refer this project.

## Questions?
 
 **Ping-Me on :**  [![Twitter](https://img.shields.io/badge/Twitter-%40UTM__Panchasara-blue.svg)](https://twitter.com/UTM_Panchasara)
[![Facebook](https://img.shields.io/badge/Facebook-Uttam%20Panchasara-blue.svg)](https://www.facebook.com/UttamPanchasara94)

 
 <a href="https://stackoverflow.com/users/5719935/uttam-panchasara">
<img src="https://stackoverflow.com/users/flair/5719935.png" width="208" height="58" alt="profile for Uttam Panchasara at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for Uttam Panchasara at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
</a>


 # Donate
> If you found this project helpful or you learned something from the source code and want to thank me, consider buying me a cup of :coffee:
- Google Pay **(panchasarauttam@okaxis)**
