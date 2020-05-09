package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.SpotifyHttpManager
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest
import ourmusic.spotify.client.vo.SpotifyCredentials


class AuthorizationCodeUri(private val accessCredentials: SpotifyCredentials){

    private val spotifyApi: SpotifyApi =  SpotifyApi.Builder()
                                                    .setClientId(accessCredentials.clientId)
                                                    .setClientSecret(accessCredentials.clientSecret)
                                                    .setRedirectUri(SpotifyHttpManager.makeUri(accessCredentials.callbackUrl))
                                                    .build()

    private val authorizationCodeUriRequest: AuthorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            //          .state("x4xkmn9pu3j6ukrs8n")
            //          .scope("user-read-birthdate,user-read-email")
            //          .show_dialog(true)
            .build()

    public fun authorizationCodeUri_Sync() {
        val uri = authorizationCodeUriRequest.execute()
        println("URI: $uri")
    }

}