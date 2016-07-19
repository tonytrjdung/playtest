package controllers

import play.api.mvc._
import play.api.i18n.I18nSupport
import play.api.libs.ws.WSClient
import play.api.cache.CacheApi
import play.api.i18n.MessagesApi
import javax.inject.Inject
import play.api.mvc.Controller
import scala.concurrent.ExecutionContext

class LogoutController @Inject() (val messagesApi: MessagesApi,
    val ws: WSClient,
    val cache: CacheApi)(implicit ec: ExecutionContext) extends Controller with I18nSupport {

  def logout = Action { implicit request =>
    Ok(views.html.home()).withSession(request.session - ("email")-("roleId"))
  }

}