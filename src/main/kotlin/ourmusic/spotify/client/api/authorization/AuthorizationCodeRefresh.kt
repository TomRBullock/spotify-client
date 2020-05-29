package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials
import ourmusic.spotify.client.vo.SpotifyCredentials
import java.io.IOException


class AuthorizationCodeRefresh(private val refreshCredentials: SpotifyCredentials) {

    private val spotifyApi: SpotifyApi = SpotifyApi.Builder()
            .setClientId(refreshCredentials.clientId)
            .setClientSecret(refreshCredentials.clientSecret)
            .build()

    fun authorizationCodeRefresh_Sync(refreshToken: String): AuthorizationCodeCredentials? {
        spotifyApi.refreshToken = refreshToken

        val authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh().build()

        try {
            val authorizationCodeCredentials = authorizationCodeRefreshRequest.execute()
            println("Expires in: " + authorizationCodeCredentials.expiresIn!!)
            return authorizationCodeCredentials;
        } catch (e: IOException) {
            println("Error: " + e.message)
        } catch (e: SpotifyWebApiException) {
            println("Error: " + e.message)
        }
        return null
    }

}