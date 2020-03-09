package ourmusic.spotify.client.api

import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest
import ourmusic.spotify.client.vo.SpotifyAccessCredentials


class AuthorizationCodeUri(private val accessCredentials: SpotifyAccessCredentials): AbstractResource(accessCredentials){

    private val authorizationCodeUriRequest: AuthorizationCodeUriRequest = spotifyApi().authorizationCodeUri()
            //          .state("x4xkmn9pu3j6ukrs8n")
            //          .scope("user-read-birthdate,user-read-email")
            //          .show_dialog(true)
            .build()

    public fun authorizationCodeUri_Sync() {
        val uri = authorizationCodeUriRequest.execute()
        println("URI: $uri")
    }

}