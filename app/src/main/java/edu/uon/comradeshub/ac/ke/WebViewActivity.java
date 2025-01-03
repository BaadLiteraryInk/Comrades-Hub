package edu.uon.comradeshub.ac.ke;


import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


/* loaded from: classes3.dex */
public class WebViewActivity extends AppCompatActivity {
    String url;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // Enable WebView debugging
        WebView.setWebContentsDebuggingEnabled(true);
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.manzi.uonfed.WebViewActivity.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                WebViewActivity.this.webView.reload();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        // Remove the old WebView instance and create a new one
        if (webView != null) {
            webView.destroy();
        }

        WebView webView = (WebView) findViewById(R.id.web_View);
        this.webView = webView;

        webView.getSettings().setBuiltInZoomControls(true);

        CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        this.webView.getSettings().setMixedContentMode(0);
        this.webView.getSettings().setLoadsImagesAutomatically(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebViewClient(new WebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        this.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().getJavaScriptCanOpenWindowsAutomatically();
        WebSettings webSettings = this.webView.getSettings();


        webSettings.setBuiltInZoomControls(true);
        //webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setLoadsImagesAutomatically(true); // Load images automatically
        webSettings.setDomStorageEnabled(true); // Enable DOM storage
        webSettings.setUseWideViewPort(true); // Enable wide viewport for responsive sites
        webSettings.setLoadWithOverviewMode(true); // Adjust WebView to fit content
        webSettings.setSaveFormData(true); // Save form data
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // Use cached content if available
        webSettings.setSavePassword(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webSettings.setUseWideViewPort(true);
        webSettings.setSaveFormData(true);

        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW); // Allow mixed content

        // Set WebViewClient to open links within the WebView itself
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }
        });


        // Set CookieManager to handle cookies across WebView
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);

        // Set up WebView client and Chrome client
        webView.setWebViewClient(new WebViewClient()); // Links open within the WebView
        webView.setWebChromeClient(new WebChromeClient()); // Handle Chrome features like loading progress


        // Get the URL from the Intent and load it
        String url = getIntent().getStringExtra("url");
        if (url != null) {
            this.webView.loadUrl(url);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack(); // Go back in WebView history
        } else {
            super.onBackPressed(); // Exit activity if no history
        }
    }
}
