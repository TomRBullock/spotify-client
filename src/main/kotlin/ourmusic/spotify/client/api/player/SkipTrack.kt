package ourmusic.spotify.client.api.player

import com.wrapper.spotify.SpotifyApi
import ourmusic.spotify.client.api.BaseService


class SkipTrack: BaseService() {

    fun skipUsersPlaybackToNextTrack_Sync(accessToken: String) {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val skipUsersPlaybackToNextTrackRequest = spotifyApi
                .skipUsersPlaybackToNextTrack()
//                .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
                .build()

        executeRequest(skipUsersPlaybackToNextTrackRequest)
    }

}