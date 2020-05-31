package ourmusic.spotify.client;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import javafx.scene.control.Toggle
import ourmusic.spotify.client.api.authorization.AuthorizationCodeRefresh
import ourmusic.spotify.client.api.authorization.AuthorizationCodeRequest
import ourmusic.spotify.client.api.authorization.AuthorizationCodeUri
import ourmusic.spotify.client.api.player.AddTrackToQueue
import ourmusic.spotify.client.api.player.CurrentPlaybackInfo
import ourmusic.spotify.client.api.player.SkipTrack
import ourmusic.spotify.client.api.player.TogglePlay
import ourmusic.spotify.client.api.search.SearchItem
import ourmusic.spotify.client.api.user.CurrentUserDetails
import ourmusic.spotify.client.vo.SpotifyCredentials

class SpotifyClient(accessCredentials: SpotifyCredentials) {

    private val authorizationCodeRefresh: AuthorizationCodeRefresh  = AuthorizationCodeRefresh(accessCredentials)
    private val authorizationCodeRequest: AuthorizationCodeRequest  = AuthorizationCodeRequest(accessCredentials)
    private val authorizationCodeUri: AuthorizationCodeUri          = AuthorizationCodeUri(accessCredentials)

    private val addTrackToQueue: AddTrackToQueue            = AddTrackToQueue()
    private val currentPlaybackInfo: CurrentPlaybackInfo    = CurrentPlaybackInfo()
    private val skipTrack: SkipTrack                        = SkipTrack()
    private val togglePlay: TogglePlay                      = TogglePlay()

    private val searchItem: SearchItem  = SearchItem()

    private val currentUserDetails: CurrentUserDetails  = CurrentUserDetails()


    fun authCodeRefresh() = authorizationCodeRefresh
    fun authCodeRequest() = authorizationCodeRequest
    fun authCodeUri()     = authorizationCodeUri

    fun addTrackToQueue()       = addTrackToQueue
    fun currentPlaybackInfo()   = currentPlaybackInfo
    fun skipTrack()             = skipTrack
    fun togglePlay()            = togglePlay

    fun searchItem() = searchItem

    fun currentUserDetails()    = currentUserDetails
}