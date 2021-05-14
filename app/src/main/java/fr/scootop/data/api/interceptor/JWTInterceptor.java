package fr.scootop.data.api.interceptor;

import android.content.Context;

import java.io.IOException;

import fr.scootop.data.storage.TokenStorage;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ludovicriviere on 13/02/2018.
 */
public class JWTInterceptor implements Interceptor
{
    private final Context mContext;

    public JWTInterceptor(Context context)
    {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request originalRequest = chain.request();
        Request newRequest;

        final String jwt = TokenStorage.get(mContext).getJWT();
        if (jwt != null) {
            /* Append JWT in headers */
            newRequest = originalRequest.newBuilder()
                    .header("Authorization", "Bearer " + jwt)
                    .build();
        } else {
            newRequest = originalRequest.newBuilder().build();
        }

        return chain.proceed(newRequest);
    }
}
