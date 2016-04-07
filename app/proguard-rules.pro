# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class io.realm.exceptions.* { *; }
-keep class io.realm.internal.async.BadVersionException { *; }
-keep class io.realm.internal.OutOfMemoryError { *; }
-keep class io.realm.internal.TableSpec { *; }
-keep class io.realm.internal.Mixed { *; }
-keep class io.realm.internal.ColumnType { *; }

-keep class * extends io.realm.RealmObject {
    void set*(***);
    *** get*();
}

-keep class **RealmProxy extends io.realm.RealmObject {
    public static <methods>;
}