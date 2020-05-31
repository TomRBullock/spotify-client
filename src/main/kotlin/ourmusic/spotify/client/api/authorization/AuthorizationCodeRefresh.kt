package ourmusic.spotify.client.api.authorization

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials
import ourmusic.spotify.client.api.BaseService
import ourmusic.spotify.client.vo.SpotifyCredentials


class AuthorizationCodeRefresh(private val refreshCredentials: SpotifyCredentials): BaseService() {

    private val spotifyApi: SpotifyApi = SpotifyApi.Builder()
            .setClientId(refreshCredentials.clientId)
            .setClientSecret(refreshCredentials.clientSecret)
            .build()

    fun authorizationCodeRefresh_Sync(refreshToken: String): AuthorizationCodeCredentials? {
        spotifyApi.refreshToken = refreshToken
        val authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh().build()
        return executeRequest(authorizationCodeRefreshRequest)
    }

}