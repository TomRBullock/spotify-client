package ourmusic.spotify.client.api

import com.wrapper.spotify.exceptions.SpotifyWebApiException
import java.io.IOException
import ourmusic.spotify.client.vo.SpotifyAccessCredentials


class AuthorizationCodeRequest(accessCredentials: SpotifyAccessCredentials) : AbstractResource(accessCredentials){

    private val code = ""

    private val authorizationCodeRequest = spotifyApi().authorizationCode(code)
            .build()

    fun authorizationCode_Sync() {
        try {
            val authorizationCodeCredentials = authorizationCodeRequest.execute()

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