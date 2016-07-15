package configs

import play.api.mvc.Results._
import play.api.mvc._

import scala.concurrent.Future

object Authenticated extends ActionBuilder[Request] {
  def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    if (request.session.get("email").isDefined)
      block(request)
    else
      Future.successful(Redirect("/loginHome"))

  }
}