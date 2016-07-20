package configs

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class UserDto(email: String, name: String, fullName: String)
object UserDto {
  implicit val userReads: Reads[UserDto] = (
    (__ \ "email").read[String] and
      (__ \ "name").read[String] and
      (__ \ "fullName").read[String]
    ) (UserDto.apply _)

  implicit val userWrites: Writes[UserDto] = (
    (JsPath \ "email").write[String] and
      (JsPath \ "name").write[String] and
      (JsPath \ "fullName").write[String]
    ) (unlift(UserDto.unapply))
}

