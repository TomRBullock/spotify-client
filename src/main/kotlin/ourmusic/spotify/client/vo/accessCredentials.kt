package ourmusic.spotify.client.vo

data class SpotifyAccessCredentials(val clientId: String, val clientSecret: String, val callbackUrl: String)
data class SpotifyRefreshCredentials(val clientId: String, val clientSecret: String, val refreshToken: String)