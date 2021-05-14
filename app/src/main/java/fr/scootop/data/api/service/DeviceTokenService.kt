package fr.scootop.data.api.service

import fr.scootop.data.model.DeviceToken
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface DeviceTokenService {

    @POST("api/device_tokens.json")
    fun postDeviceToken(@Body deviceToken: DeviceToken): Observable<DeviceToken>
}
