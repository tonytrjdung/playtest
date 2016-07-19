package controllers

import play.api.mvc._
import play.api.i18n.I18nSupport
import play.api.libs.ws.WSClient
import play.api.cache.CacheApi
import play.api.i18n.MessagesApi
import javax.inject.Inject
import play.api.mvc.Controller
import scala.concurrent.ExecutionContext

class ErrorController @Inject() (val messagesApi: MessagesApi,
    val ws: WSClient,
    val cache: CacheApi)(implicit ec: ExecutionContext) extends Controller with I18nSupport {

  def error_first = Action { implicit request =>
    Ok(views.html.error_first())
  }
  
  def error_after() = Authenticated { implicit request =>
    Ok(views.html.error_after(request.session.get("email").get,request.session.get("roleId").get))
  }

}