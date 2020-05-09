package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.SpotifyHttpManager
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import ourmusic.spotify.client.vo.SpotifyCredentials
import java.io.IOException


class AuthorizationCodeRequest(accessCredentials: SpotifyCredentials) {

    private val code = ""

    private val spotifyApi: SpotifyApi =  SpotifyApi.Builder()
                                                    .setClientId(accessCredentials.clientId)
                                                    .setClientSecret(accessCredentials.clientSecret)
                                                    .setRedirectUri(SpotifyHttpManager.makeUri(accessCredentials.callbackUrl))
                                                    .build()

    private

    fun authorizationCode_Sync(accessCode: String) {

        val authorizationCodeRequest = spotifyApi.authorizationCode(accessCode).build()

        try {
            val authorizationCodeCredentials = authorizationCodeRequest.execute()

            // Set access and refresh token for further "spotifyApi" object usage
//            spotifyApi().accessToken = authorizationCodeCredentials.accessToken
//            spotifyApi().refreshToken = authorizationCodeCredentials.refreshToken

            println("Expires in: " + authorizationCodeCredentials.expiresIn!!)
        } catch (e: IOException ) {
            println("Error: " + e.message)
        } catch (e: SpotifyWebApiException) {
            println("Error: " + e.message)
        }

    }

}