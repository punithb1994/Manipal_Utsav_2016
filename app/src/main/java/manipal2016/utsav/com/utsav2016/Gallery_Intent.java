package manipal2016.utsav.com.utsav2016;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
/*
 *********Created by Akshath K, Punith B, Ajay J [March 2016]*********
*/
public class Gallery_Intent extends Activity
{
    WebView jwebresult;
    ProgressDialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        setTitle("Gallery");
        FrameLayout f=(FrameLayout) findViewById(R.id.ffffm);

        if(isNetworkStatusAvialable (getApplicationContext()))
        {
         f.setVisibility(View.GONE);
          //  dialog = new ProgressDialog(Gallery_Intent.this);
           // dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
          //  dialog.setMessage("Loading. Please wait...");
          //  dialog.setIndeterminate(true);
          //  dialog.setCanceledOnTouchOutside(false);
          //  dialog.show();

        jwebresult=(WebView)findViewById(R.id.webViewResult);
        jwebresult.setWebViewClient(new MyBrowser());
        String url = "http://www.fazilamir.me/api/gallery.php";
        jwebresult.getSettings().setLoadsImagesAutomatically(true);
        jwebresult.getSettings().setJavaScriptEnabled(true);
        jwebresult.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        jwebresult.loadUrl(url);
        }
        else
        {
            f.setVisibility(View.VISIBLE);
        }

    }
    private class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url)
        {
            super.onPageFinished(view, url);
            //dialog.dismiss();
        }
    }
    public static boolean isNetworkStatusAvialable (Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }

}

