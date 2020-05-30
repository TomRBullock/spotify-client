package ourmusic.spotify.client.api.player

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import ourmusic.spotify.client.api.BaseService
import java.io.IOException

class TogglePlay(): BaseService() {

    fun pauseUsersPlayback_Sync(accessToken: String) {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val pauseUsersPlaybackRequest = spotifyApi.pauseUsersPlayback()
//                .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
                .build()

        executeRequest(pauseUsersPlaybackRequest)
    }


    fun startResumeUsersPlayback_Sync(accessToken: String) {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val startResumeUsersPlaybackRequest = spotifyApi
                .startResumeUsersPlayback()
//                .context_uri("spotify:album:5zT1JLIj9E57p3e1rFm9Uq")
//                .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
//                .offset(JsonParser.parseString("{\"uri\":\"spotify:track:01iyCAUm8EvOFqVWYJ3dVX\"}").getAsJsonObject())
//                .uris(JsonParser.parseString("[\"spotify:track:01iyCAUm8EvOFqVWYJ3dVX\"]").getAsJsonArray())
//                .position_ms(10000)
                .build()

        executeRequest(startResumeUsersPlaybackRequest)
    }


}