package controllers

import java.util
import javax.inject.Inject

import configs.UserDto
import entity.User
import play.api.cache.CacheApi
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient
import play.api.mvc.{Controller, _}
import service.UserService
import java.util.List
import scala.collection.immutable
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext

class SampleAjax @Inject()(val messagesApi: MessagesApi,
                           val ws: WSClient,
                           val cache: CacheApi)(implicit ec: ExecutionContext) extends Controller with I18nSupport {


  @Inject
  private var userService: UserService = _

  def sampleajax = Action { implicit request =>
    Ok(views.html.sampleajax())
  }

  def resultajax = Action { implicit request =>
      Ok(Json.parse("{\"name2\": \"Toto\", \"age2\": 32}"))
  }

  def resultlistobject = Action { implicit request =>
    val user: User = userService.findUserByEmail("ptdung0312@gmail.com")
    Ok(Json.toJson(UserDto(user.email,user.name, user.fullName)))
  }

  def resultlist = Action { implicit request =>
    val user: List[User] = userService.findUserAll

    val userdto= new ListBuffer[UserDto]()
    for (i <- 0 to user.size()-1) {
      var u:User = user.get(i)
      var u1:UserDto = new UserDto(u.email,u.name, u.fullName)
      userdto +=u1
    }
    Ok(Json.toJson(userdto))
}

  def resultParam = Action { implicit request =>
    var a = request.getQueryString("name")
    Ok(Json.toJson(a))
  }

  def resultObject = Action { implicit request =>
    Ok(Json.toJson("a"))
  }

}