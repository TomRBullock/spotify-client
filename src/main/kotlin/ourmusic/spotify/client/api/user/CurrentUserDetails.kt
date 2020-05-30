package ourmusic.spotify.client.api.user

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.model_objects.specification.User
import ourmusic.spotify.client.api.BaseService
import java.io.IOException


class CurrentUserDetails: BaseService() {

    fun getCurrentUsersProfile_Sync(accessToken: String): User? {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val getCurrentUsersProfileRequest = spotifyApi.currentUsersProfile
                .build()

        return executeRequest(getCurrentUsersProfileRequest)
    }

}