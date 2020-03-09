package ourmusic.spotify.client.api

import com.wrapper.spotify.exceptions.SpotifyWebApiException
import java.io.IOException
import ourmusic.spotify.client.vo.SpotifyRefreshCredentials


class AuthorizationCodeRefresh(refreshCredentials: SpotifyRefreshCredentials): AbstractResource(refreshCredentials) {

    private val authorizationCodeRefreshRequest = spotifyApi().authorizationCodeRefresh()
            .build()

    fun authorizationCodeRefresh_Sync() {
        try {
            val authorizationCodeCredentials = authorizationCodeRefreshRequest.execute()

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi().accessToken = authorizationCodeCredentials.accessToken
            spotifyApi().refreshToken = authorizationCodeCredentials.refreshToken

            println("Expires in: " + authorizationCodeCredentials.expiresIn!!)
        } catch (e: IOException) {
            println("Error: " + e.message)
        } catch (e: SpotifyWebApiException) {
            println("Error: " + e.message)
        }

    }

}