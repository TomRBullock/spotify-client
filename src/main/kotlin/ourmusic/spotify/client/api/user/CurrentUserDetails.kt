package ourmusic.spotify.client.api.user

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.model_objects.specification.User
import java.io.IOException


class CurrentUserDetails {



    fun getCurrentUsersProfile_Sync(accessToken: String): User? {

        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()

        val getCurrentUsersProfileRequest = spotifyApi.currentUsersProfile
                .build()

        try {
            val user = getCurrentUsersProfileRequest.execute()
            return user
        } catch (e: IOException) {
            System.out.println("Error: " + e.message)
        } catch (e: SpotifyWebApiException) {
            System.out.println("Error: " + e.message)
        } catch (e: Exception) {
            System.out.println("Error: " + e.message)
        }
        return null
    }


}