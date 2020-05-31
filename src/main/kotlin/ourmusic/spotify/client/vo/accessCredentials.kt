package ourmusic.spotify.client.vo

data class SpotifyCredentials(val clientId: String, val clientSecret: String, val callbackUrl: String, val scope: String)
