package com.test.fakenews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewShow extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView) findViewById(R.id.webview);

        String htmlContent = getIntent().getStringExtra("htmlContent");

        webView.loadData(htmlContent, "text/html; charset=UTF-8", null);

    }
}
