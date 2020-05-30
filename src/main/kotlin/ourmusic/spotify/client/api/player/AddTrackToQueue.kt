package ourmusic.spotify.client.api.player

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import ourmusic.spotify.client.api.BaseService
import java.io.IOException


class AddTrackToQueue: BaseService() {


    fun addItemToUsersPlaybackQueue_Sync(accessToken: String, trackUri: String) {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val addItemToUsersPlaybackQueueRequest = spotifyApi
                .addItemToUsersPlaybackQueue(trackUri) //    .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
                .build()

        executeRequest(addItemToUsersPlaybackQueueRequest)
    }
}