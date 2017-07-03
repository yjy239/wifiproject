package yidu.cooking.network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import yidu.cooking.utils.LoginUtils;

/**
 * Created by Administrator on 2016/6/28.
 */
public class OkHttpClientManager {

    private static OkHttpClientManager mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    private static final String TAG = "OkHttpClientManager";

    private OkHttpClientManager() {
        mOkHttpClient = new OkHttpClient();
        mDelivery = new Handler(Looper.getMainLooper());
    }

    public static OkHttpClientManager getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpClientManager.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpClientManager();
                }
            }
        }
        return mInstance;
    }

    private void asyncGet(final String url, final BaseCallBack responseCallback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        mOkHttpClient.newCall(request).enqueue(getCallback(responseCallback));
    }

    private void asyncPost(final String url, final RequestBody requestBody, final BaseCallBack responseCallback) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(getCallback(responseCallback));
    }

    private Callback getCallback(final BaseCallBack responseCallback) {
        return new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e(TAG, "failed: requestNewsList" + e.getMessage() );
                        e.printStackTrace();
                        responseCallback.failed(call.hashCode(), e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseStr = response.body().string();

                try {
                    JSONObject jsonObject = new JSONObject(responseStr);

                    final int code = jsonObject.getInt("code");
                    final String message = jsonObject.getString("message");
                    String content = "";

                    if (code == 0) {
                        if (!jsonObject.isNull("content")) {
                            content = jsonObject.getString("content");
                            if (!content.startsWith("[")) {
                                JSONObject o = new JSONObject(content);
                                if (o.has("match") && o.has("team") && o.has("note") && o.has("notice")) {

                                } else {
                                    Log.e(TAG, "response:" + response.toString());
                                    Log.e(TAG, "response:" + response.body().toString());
                                    Log.e(TAG, "response:" + responseStr);
                                }
                            }else {
                                Log.e(TAG, "response:" + response.toString());
                                Log.e(TAG, "response:" + response.body().toString());
                                Log.e(TAG, "response:" + responseStr);
                            }
                            final String finalContent = content;
                            mDelivery.post(new Runnable() {
                                @Override
                                public void run() {
                                    responseCallback.success(finalContent);
                                }
                            });
                        } else {
                            mDelivery.post(new Runnable() {
                                @Override
                                public void run() {
                                    responseCallback.success("");
                                }
                            });
                            Log.e(TAG, "response:" + response.toString());
                            Log.e(TAG, "response:" + response.body().toString());
                            Log.e(TAG, "response:" + responseStr);
                        }
                    } else {
                        mDelivery.post(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(SystemUtil.getContext(),message+" 返回错误code："+code,Toast.LENGTH_SHORT).show();
                                responseCallback.failed(code, message);
                            }
                        });
                        Log.e(TAG, "response:" + response.toString());
                        Log.e(TAG, "response:" + response.body().toString());
                        Log.e(TAG, "response:" + responseStr);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void doOkHttpGet(final String url, final BaseCallBack responseCallback) {
        getInstance().asyncGet(url, responseCallback);
    }

    public static void doOkHttpPost(final String url, final RequestBody requestBody, final BaseCallBack responseCallback) {
        getInstance().asyncPost(url, requestBody, responseCallback);
    }

    public static HttpBuilder doOkHttpPost(final String router){
        HttpBuilder builder = new HttpBuilder(router);

        return builder;
    }

    public static HttpBuilder doOkHttpPostWithToken(final String router){
       return doOkHttpPostWithToken(router, true);
    }

    public static HttpBuilder doOkHttpPostWithToken(final String router, final boolean forceNeedToken){
        HttpBuilder builder = new HttpBuilder(router);
        if(forceNeedToken){//强制需要token
            builder.addCode("token", LoginUtils.getToken());
            builder.addCode("user_id", LoginUtils.getUserId());
            builder.setHasToken(true);
        }else{
            boolean tokenIsEmpty = (LoginUtils.getToken().isEmpty() || LoginUtils.getToken().equals(""));
            if(!tokenIsEmpty){//可传可不传token
                builder.addCode("token", LoginUtils.getToken());
                builder.addCode("user_id", LoginUtils.getUserId());
                builder.setHasToken(true);
            }
        }

        return builder;
    }

}
