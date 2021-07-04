package fr.scootop.data.api

import android.util.Log
import com.google.gson.GsonBuilder
import fr.scootop.BuildConfig
import fr.scootop.app.services.*
import fr.scootop.data.api.service.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager private constructor() {

    val userService: ApiUserService
    val configurationService: ApiConfigurationService
    val externalService: ApiExternalService
    val serviceInteractionService: ApiServiceInteractionService
    val serviceToolsService: ApiServiceToolsService
    val toolsService: ApiToolsService
    val userDomainService: ApiUserDomainService
    val userProviderService: ApiUserProviderService
    val statisticsService: ApiStatisticsService

    val loginService: LoginService
    val deviceTokenService: DeviceTokenService
    val registerService: RegisterService
    val searchService: SearchService
    val shortlistItemService: ShortlistItemService
    val boardService: BoardService
    val clubService: ClubService
    val categoryService: CategoryService
    val divisionService: DivisionService
    val positionService: PositionService

    val videoService: VideoService
    val youtubeServce: YoutubeService
    val postService: PostService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            // temp code
            // .addInterceptor(JWTInterceptor(ScootopApplication.getContext()))
            // temp code
            .addInterceptor { chain ->
                Log.d("Scootop-API", chain.request().url().toString())
                chain.proceed(chain.request())
            }
            // temp code
            // .authenticator(JWTAuthenticator())
            // temp code
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        val gsonConf = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.SC_BASE_API)
            .client(httpClient)
            .build()

        loginService = retrofit.create(LoginService::class.java)
        registerService = retrofit.create(RegisterService::class.java)
        searchService = retrofit.create(SearchService::class.java)
        shortlistItemService = retrofit.create(ShortlistItemService::class.java)

        boardService = retrofit.create(BoardService::class.java)
        clubService = retrofit.create(ClubService::class.java)
        categoryService = retrofit.create(CategoryService::class.java)
        divisionService = retrofit.create(DivisionService::class.java)
        positionService = retrofit.create(PositionService::class.java)
        videoService = retrofit.create(VideoService::class.java)


        deviceTokenService = retrofit.create(DeviceTokenService::class.java)
        userService = retrofit.create(ApiUserService::class.java)
        configurationService =  retrofit.create(ApiConfigurationService::class.java)
        externalService =  retrofit.create(ApiExternalService::class.java)
        serviceInteractionService =  retrofit.create(ApiServiceInteractionService::class.java)
        serviceToolsService =  retrofit.create(ApiServiceToolsService::class.java)
        toolsService =  retrofit.create(ApiToolsService::class.java)
        userDomainService =  retrofit.create(ApiUserDomainService::class.java)
        userProviderService =  retrofit.create(ApiUserProviderService::class.java)
        statisticsService = retrofit.create(ApiStatisticsService::class.java)

        //??
        postService = retrofit.create(PostService::class.java)



        val ytHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        val ytRetrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonConf))
            .baseUrl(BuildConfig.YT_BASE_API)
            .client(ytHttpClient)
            .build()

        youtubeServce = ytRetrofit.create(YoutubeService::class.java)
    }

    companion object {
        private var instance: ApiManager? = null

        fun get(): ApiManager {
            if (null == instance) {
                instance = ApiManager()
            }
            return instance as ApiManager
        }
    }
}
