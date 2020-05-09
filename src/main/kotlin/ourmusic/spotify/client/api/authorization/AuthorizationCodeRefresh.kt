package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import ourmusic.spotify.client.vo.SpotifyCredentials
import java.io.IOException


class AuthorizationCodeRefresh(private val refreshCredentials: SpotifyCredentials) {

    fun authorizationCodeRefresh_Sync(refreshToken: String) {
        val spotifyApi: SpotifyApi = SpotifyApi.Builder()
                .setClientId(refreshCredentials.clientId)
                .setClientSecret(refreshCredentials.clientSecret)
                .setRefreshToken(refreshToken)
                .build()

        val authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh().build()

        try {
            val authorizationCodeCredentials = authorizationCodeRefreshRequest.execute()

            // Set access and refresh token for further "spotifyApi" object usage
//            spotifyApi.accessToken = authorizationCodeCredentials.accessToken
//            spotifyApi.refreshToken = authorizationCodeCredentials.refreshToken

            println("Expires in: " + authorizationCodeCredentials.expiresIn!!)
        } catch (e: IOException) {
            println("Error: " + e.message)
        } catch (e: SpotifyWebApiException) {
            println("Error: " + e.message)
        }

    }

}