/**
 * 
 */
package fm.last.android.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import fm.last.android.BaseActivity;
import fm.last.android.R;

public class Help extends BaseActivity {
	WebView mWebView;
	String mLastUrl;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.help);

	    mWebView = (WebView) findViewById(R.id.webview);
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    if(savedInstanceState != null)
	    	mLastUrl = savedInstanceState.getString("url");
	    
	    if(mLastUrl != null && mLastUrl.length() > 0)
	    	mWebView.loadUrl(mLastUrl);
	    else
	    	mWebView.loadUrl("file:///android_asset/index.html");
	    mWebView.setWebViewClient(new WebViewClient() {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        view.loadUrl(url);
		        mLastUrl = url;
		        return true;
		    }
	    });
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putString("url", mLastUrl);
		super.onSaveInstanceState(outState);
	}
}
