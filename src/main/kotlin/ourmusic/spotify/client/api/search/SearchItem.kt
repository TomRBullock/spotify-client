package ourmusic.spotify.client.api.search

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.exceptions.SpotifyWebApiException
import com.wrapper.spotify.model_objects.special.SearchResult
import ourmusic.spotify.client.api.BaseService
import java.io.IOException


class SearchItem: BaseService() {

    fun searchItem_Sync(accessToken: String, queryText: String, type: String): SearchResult? {
        val spotifyApi = SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build()
        val searchItemRequest = spotifyApi.searchItem(queryText, type)
//                .market(CountryCode.SE)
//                .limit(10)
//                .offset(0)
//                .includeExternal("audio")
                .build()

        return executeRequest(searchItemRequest)
    }


}