package kaoru

import java.net.URI
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.{HttpClient, HttpRequest}
import java.net.http.HttpResponse.BodyHandlers
import org.apache.logging.log4j.{LogManager, Logger}
import org.json.JSONObject

class Uta(webhookURL: String) {
  private val logger = LogManager.getLogger("Uta")
  val client: HttpClient = HttpClient.newHttpClient
  var webhookID: String = null
  var webhookChannelID: String = null
  splitWebhookURL

  def splitWebhookURL: Unit = {
    val splitURL = webhookURL.split("/")
    webhookID = splitURL(5)
    webhookChannelID = splitURL(6)
  }

  def send(content: String, username: String = null, avatar_url: String = null, tts: Boolean = false): Unit = {
    val body = new JSONObject().put("content", s"$content").put("tts", s"$tts")
    if(!(username == null)) body.put("username", s"$username")
    if(!(avatar_url == null)) body.put("avatar_url", s"$avatar_url")
    val request: HttpRequest = HttpRequest.newBuilder.uri(URI.create(s"https://discordapp.com/api/v7/webhooks/$webhookID/$webhookChannelID"))
      .setHeader("Content-Type", "application/json")
      .setHeader("User-Agent", "DiscordBot (Uta, 1.0.0)")
      .POST(BodyPublishers.ofString(body.toString()))
      .build
    val response = client.send(request, BodyHandlers.ofString())
    response.statusCode match {
      case 200 => logger.info("Excuted webhook!")
      case 204 => logger.info("Excuted webhook!")
      case 401 => logger.error("Unauthorized")
      case 403 => logger.error("Forbidden")
      case 404 => logger.error("Not found")
      case 429 => logger.error("Ratelimited!")
    }
  }
}
