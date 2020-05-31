package ourmusic.spotify.client.api.player

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.miscellaneous.CurrentlyPlayingContext
import ourmusic.spotify.client.api.BaseService


class CurrentPlaybackInfo: BaseService() {



    fun getInformationAboutUsersCurrentPlayback_Sync(accessToken: String): CurrentlyPlayingContext? {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()
        val getInformationAboutUsersCurrentPlaybackRequest = spotifyApi.informationAboutUsersCurrentPlayback //                  .market(CountryCode.SE)
                //                  .additionalTypes("track,episode")
                .build()

        return executeRequest(getInformationAboutUsersCurrentPlaybackRequest)
    }


}