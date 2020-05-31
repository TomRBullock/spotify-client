package ourmusic.spotify.client.api

import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.requests.AbstractRequest
import java.io.IOException

open class BaseService() {

    fun <T, S: AbstractRequest<T>> executeRequest(spotifyApi: S): T? {
        try {
            return spotifyApi.execute()
        } catch (e: IOException) {
            println("Error IO: " + e.message)
        } catch (e: SpotifyWebApiException) {
            println("Error api: " + e.message)
        } catch (e: Exception) {
            println("Error: " + e.message)
        }
        return null
    }

}