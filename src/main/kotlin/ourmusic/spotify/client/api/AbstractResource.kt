package ourmusic.spotify.client.api

import ourmusic.spotify.client.vo.SpotifyAccessCredentials
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.SpotifyHttpManager
import ourmusic.spotify.client.vo.SpotifyRefreshCredentials


abstract class AbstractResource {

//    private val clientId = "3bb1371bd1b748269233273ce39229c3"
//    private val clientSecret = "f9e20d71dc45472782976c4fd6c1c8a2"
//    private val redirectUri = SpotifyHttpManager.makeUri("http://localhost:8888/callback")
//    private val code = ""
//    private val refreshToken = "b0KuPuLw77Z0hQhCsK-GTHoEx_kethtn357V7iqwEpCTIsLgqbBC_vQBTGC6M5rINl0FrqHK-D3cbOsMOlfyVKuQPvpyGcLcxAoLOTpYXc28nVwB7iBq2oKj9G9lHkFOUKn"

    private val spotifyApi: SpotifyApi

    constructor(accessCredentials: SpotifyAccessCredentials) {
        spotifyApi = SpotifyApi.Builder()
                .setClientId(accessCredentials.clientId)
                .setClientSecret(accessCredentials.clientSecret)
                .setRedirectUri(SpotifyHttpManager.makeUri(accessCredentials.callbackUrl))
                .build()
    }

    constructor(refreshCredentials: SpotifyRefreshCredentials) {
        spotifyApi = SpotifyApi.Builder()
                .setClientId(refreshCredentials.clientId)
                .setClientSecret(refreshCredentials.clientSecret)
                .setRefreshToken(refreshCredentials.refreshToken)
                .build()
    }

    fun spotifyApi(): SpotifyApi {
        return spotifyApi
    }

}