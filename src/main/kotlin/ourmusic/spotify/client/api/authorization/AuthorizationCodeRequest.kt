package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.SpotifyHttpManager
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials
import ourmusic.spotify.client.api.BaseService
import ourmusic.spotify.client.vo.SpotifyCredentials
import java.io.IOException


class AuthorizationCodeRequest(accessCredentials: SpotifyCredentials):  BaseService() {

    private val spotifyApi: SpotifyApi =  SpotifyApi.Builder()
                                                    .setClientId(accessCredentials.clientId)
                                                    .setClientSecret(accessCredentials.clientSecret)
                                                    .setRedirectUri(SpotifyHttpManager.makeUri(accessCredentials.callbackUrl))
                                                    .build()

    fun authorizationCode_Sync(accessCode: String): AuthorizationCodeCredentials? {
        val authorizationCodeRequest = spotifyApi.authorizationCode(accessCode).build()
        return executeRequest(authorizationCodeRequest)
    }

}