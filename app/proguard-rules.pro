# Keep all activities
-keep class edu.uon.comradeshub.ac.ke.BaadActivity { *; }
-keep class edu.uon.comradeshub.ac.ke.MainActivity { *; }
-keep class edu.uon.comradeshub.ac.ke.SplashActivity { *; }
-keep class edu.uon.comradeshub.ac.ke.WebViewActivity { *; }

# Keep the adapter
-keep class edu.uon.comradeshub.ac.ke.CardAdapter { *; }

# Keep Retrofit client and its members
-keep class edu.uon.comradeshub.ac.ke.RetrofitClient { *; }
-keepclassmembers class edu.uon.comradeshub.ac.ke.RetrofitClient { *; }

# Keep OpenAI service classes
-keep class edu.uon.comradeshub.ac.ke.OpenAIService { *; }
-keep class edu.uon.comradeshub.ac.ke.ChatGPTRequest { *; }
-keep class edu.uon.comradeshub.ac.ke.ChatGPTResponse { *; }

# Protect against reflection-based access
-keepclassmembers class edu.uon.comradeshub.ac.ke.** {
    public <init>(...);
}

# Repackage classes
-repackageclasses ''

# Remove debug information
-dontobfuscate
-dontpreverify
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-assumenosideeffects class android.util.Log {
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

# Suppress warnings
-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE

# Add the missing rules from the file here
# For example:

