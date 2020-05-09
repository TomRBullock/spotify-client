package ourmusic.spotify.client;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import ourmusic.spotify.client.api.authorization.AuthorizationCodeRefresh
import ourmusic.spotify.client.api.authorization.AuthorizationCodeRequest
import ourmusic.spotify.client.api.authorization.AuthorizationCodeUri
import ourmusic.spotify.client.vo.SpotifyCredentials

class SpotifyClient(accessCredentials: SpotifyCredentials) {

    private val authorizationCodeRefresh: AuthorizationCodeRefresh  = AuthorizationCodeRefresh(accessCredentials)
    private val authorizationCodeRequest: AuthorizationCodeRequest  = AuthorizationCodeRequest(accessCredentials)
    private val authorizationCodeUri: AuthorizationCodeUri          = AuthorizationCodeUri(accessCredentials)

    fun authCodeRefresh() = authorizationCodeRefresh
    fun authCodeRequest() = authorizationCodeRequest
    fun authCodeUri()     = authorizationCodeUri

}