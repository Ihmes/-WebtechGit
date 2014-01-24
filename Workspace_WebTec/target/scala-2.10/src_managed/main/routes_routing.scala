// @SOURCE:D:/Workspace_WebTec/conf/routes
// @HASH:90eb6064836865cfe5e632be942a89459ccb861f
// @DATE:Thu Jan 23 23:36:25 CET 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:5
private[this] lazy val controllers_MainController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:6
private[this] lazy val controllers_MessageController_getMessage1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message"))))
        

// @LINE:7
private[this] lazy val controllers_MessageController_javascriptRoutes2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
        

// @LINE:10
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:11
private[this] lazy val controllers_WebJarAssets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webjars/"),DynamicPart("file", """.+""",false))))
        

// @LINE:13
private[this] lazy val controllers_accessController_showAnmelden5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anmelden"))))
        

// @LINE:14
private[this] lazy val controllers_accessController_actionAnmelden6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("anmelden"))))
        

// @LINE:16
private[this] lazy val controllers_accessController_showRegistrierung7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registrierung"))))
        

// @LINE:17
private[this] lazy val controllers_accessController_actionRegistrierung8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registrierung"))))
        

// @LINE:19
private[this] lazy val controllers_memberController_showMemberIndex9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("memberIndex"))))
        

// @LINE:21
private[this] lazy val controllers_memberController_showSuche10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgSuche"))))
        

// @LINE:22
private[this] lazy val controllers_memberController_actionSuche11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgSuche"))))
        

// @LINE:24
private[this] lazy val controllers_memberController_showAnbieterMaske12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgAnbieten"))))
        

// @LINE:25
private[this] lazy val controllers_memberController_actionAnbieterMaske13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgAnbieten"))))
        

// @LINE:27
private[this] lazy val controllers_ProfileinstellungenController_showProfil14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Profileinstellungen"))))
        

// @LINE:28
private[this] lazy val controllers_ProfileinstellungenController_actionProfil15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("Profileinstellungen"))))
        

// @LINE:30
private[this] lazy val controllers_LogoutController_logout16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:32
private[this] lazy val controllers_mfgController_showDetailAnzeigen17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgDetailAnzeigen/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:33
private[this] lazy val controllers_mfgController_actionBuchungAnfrage18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgDetailAnfragen/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:34
private[this] lazy val controllers_mfgController_showDetailIndex19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgDetailindex/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:36
private[this] lazy val controllers_mfgController_showMfgBesteatigen20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgBestaetigen/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:38
private[this] lazy val controllers_mfgController_actionMfgAbgelehnt21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgBesteatigen/"),DynamicPart("mfgID", """[^/]+""",true),StaticPart("/"),DynamicPart("userID", """[^/]+""",true),StaticPart("/abgelehnt"))))
        

// @LINE:39
private[this] lazy val controllers_mfgController_actionMfgBesteatigen22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mfgBesteatigen/"),DynamicPart("mfgID", """[^/]+""",true),StaticPart("/"),DynamicPart("userID", """[^/]+""",true),StaticPart("/mitnehmen"))))
        
def documentation = List(("""GET""", prefix,"""controllers.MainController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message""","""controllers.MessageController.getMessage()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.MessageController.javascriptRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""","""controllers.WebJarAssets.at(file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anmelden""","""controllers.accessController.showAnmelden()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """anmelden""","""controllers.accessController.actionAnmelden()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registrierung""","""controllers.accessController.showRegistrierung()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registrierung""","""controllers.accessController.actionRegistrierung()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """memberIndex""","""controllers.memberController.showMemberIndex()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgSuche""","""controllers.memberController.showSuche()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgSuche""","""controllers.memberController.actionSuche()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgAnbieten""","""controllers.memberController.showAnbieterMaske()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgAnbieten""","""controllers.memberController.actionAnbieterMaske()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Profileinstellungen""","""controllers.ProfileinstellungenController.showProfil()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """Profileinstellungen""","""controllers.ProfileinstellungenController.actionProfil()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.LogoutController.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgDetailAnzeigen/$id<[^/]+>""","""controllers.mfgController.showDetailAnzeigen(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgDetailAnfragen/$id<[^/]+>""","""controllers.mfgController.actionBuchungAnfrage(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgDetailindex/$id<[^/]+>""","""controllers.mfgController.showDetailIndex(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgBestaetigen/$id<[^/]+>""","""controllers.mfgController.showMfgBesteatigen(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/abgelehnt""","""controllers.mfgController.actionMfgAbgelehnt(mfgID:String, userID:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/mitnehmen""","""controllers.mfgController.actionMfgBesteatigen(mfgID:String, userID:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:5
case controllers_MainController_index0(params) => {
   call { 
        invokeHandler(controllers.MainController.index(), HandlerDef(this, "controllers.MainController", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:6
case controllers_MessageController_getMessage1(params) => {
   call { 
        invokeHandler(controllers.MessageController.getMessage(), HandlerDef(this, "controllers.MessageController", "getMessage", Nil,"GET", """""", Routes.prefix + """message"""))
   }
}
        

// @LINE:7
case controllers_MessageController_javascriptRoutes2(params) => {
   call { 
        invokeHandler(controllers.MessageController.javascriptRoutes(), HandlerDef(this, "controllers.MessageController", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """assets/javascripts/routes"""))
   }
}
        

// @LINE:10
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:11
case controllers_WebJarAssets_at4(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        invokeHandler(controllers.WebJarAssets.at(file), HandlerDef(this, "controllers.WebJarAssets", "at", Seq(classOf[String]),"GET", """""", Routes.prefix + """webjars/$file<.+>"""))
   }
}
        

// @LINE:13
case controllers_accessController_showAnmelden5(params) => {
   call { 
        invokeHandler(controllers.accessController.showAnmelden(), HandlerDef(this, "controllers.accessController", "showAnmelden", Nil,"GET", """""", Routes.prefix + """anmelden"""))
   }
}
        

// @LINE:14
case controllers_accessController_actionAnmelden6(params) => {
   call { 
        invokeHandler(controllers.accessController.actionAnmelden(), HandlerDef(this, "controllers.accessController", "actionAnmelden", Nil,"POST", """""", Routes.prefix + """anmelden"""))
   }
}
        

// @LINE:16
case controllers_accessController_showRegistrierung7(params) => {
   call { 
        invokeHandler(controllers.accessController.showRegistrierung(), HandlerDef(this, "controllers.accessController", "showRegistrierung", Nil,"GET", """""", Routes.prefix + """registrierung"""))
   }
}
        

// @LINE:17
case controllers_accessController_actionRegistrierung8(params) => {
   call { 
        invokeHandler(controllers.accessController.actionRegistrierung(), HandlerDef(this, "controllers.accessController", "actionRegistrierung", Nil,"POST", """""", Routes.prefix + """registrierung"""))
   }
}
        

// @LINE:19
case controllers_memberController_showMemberIndex9(params) => {
   call { 
        invokeHandler(controllers.memberController.showMemberIndex(), HandlerDef(this, "controllers.memberController", "showMemberIndex", Nil,"GET", """""", Routes.prefix + """memberIndex"""))
   }
}
        

// @LINE:21
case controllers_memberController_showSuche10(params) => {
   call { 
        invokeHandler(controllers.memberController.showSuche(), HandlerDef(this, "controllers.memberController", "showSuche", Nil,"GET", """""", Routes.prefix + """mfgSuche"""))
   }
}
        

// @LINE:22
case controllers_memberController_actionSuche11(params) => {
   call { 
        invokeHandler(controllers.memberController.actionSuche(), HandlerDef(this, "controllers.memberController", "actionSuche", Nil,"POST", """""", Routes.prefix + """mfgSuche"""))
   }
}
        

// @LINE:24
case controllers_memberController_showAnbieterMaske12(params) => {
   call { 
        invokeHandler(controllers.memberController.showAnbieterMaske(), HandlerDef(this, "controllers.memberController", "showAnbieterMaske", Nil,"GET", """""", Routes.prefix + """mfgAnbieten"""))
   }
}
        

// @LINE:25
case controllers_memberController_actionAnbieterMaske13(params) => {
   call { 
        invokeHandler(controllers.memberController.actionAnbieterMaske(), HandlerDef(this, "controllers.memberController", "actionAnbieterMaske", Nil,"POST", """""", Routes.prefix + """mfgAnbieten"""))
   }
}
        

// @LINE:27
case controllers_ProfileinstellungenController_showProfil14(params) => {
   call { 
        invokeHandler(controllers.ProfileinstellungenController.showProfil(), HandlerDef(this, "controllers.ProfileinstellungenController", "showProfil", Nil,"GET", """""", Routes.prefix + """Profileinstellungen"""))
   }
}
        

// @LINE:28
case controllers_ProfileinstellungenController_actionProfil15(params) => {
   call { 
        invokeHandler(controllers.ProfileinstellungenController.actionProfil(), HandlerDef(this, "controllers.ProfileinstellungenController", "actionProfil", Nil,"POST", """""", Routes.prefix + """Profileinstellungen"""))
   }
}
        

// @LINE:30
case controllers_LogoutController_logout16(params) => {
   call { 
        invokeHandler(controllers.LogoutController.logout(), HandlerDef(this, "controllers.LogoutController", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:32
case controllers_mfgController_showDetailAnzeigen17(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.mfgController.showDetailAnzeigen(id), HandlerDef(this, "controllers.mfgController", "showDetailAnzeigen", Seq(classOf[String]),"GET", """""", Routes.prefix + """mfgDetailAnzeigen/$id<[^/]+>"""))
   }
}
        

// @LINE:33
case controllers_mfgController_actionBuchungAnfrage18(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.mfgController.actionBuchungAnfrage(id), HandlerDef(this, "controllers.mfgController", "actionBuchungAnfrage", Seq(classOf[String]),"GET", """""", Routes.prefix + """mfgDetailAnfragen/$id<[^/]+>"""))
   }
}
        

// @LINE:34
case controllers_mfgController_showDetailIndex19(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.mfgController.showDetailIndex(id), HandlerDef(this, "controllers.mfgController", "showDetailIndex", Seq(classOf[String]),"GET", """""", Routes.prefix + """mfgDetailindex/$id<[^/]+>"""))
   }
}
        

// @LINE:36
case controllers_mfgController_showMfgBesteatigen20(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.mfgController.showMfgBesteatigen(id), HandlerDef(this, "controllers.mfgController", "showMfgBesteatigen", Seq(classOf[String]),"GET", """""", Routes.prefix + """mfgBestaetigen/$id<[^/]+>"""))
   }
}
        

// @LINE:38
case controllers_mfgController_actionMfgAbgelehnt21(params) => {
   call(params.fromPath[String]("mfgID", None), params.fromPath[String]("userID", None)) { (mfgID, userID) =>
        invokeHandler(controllers.mfgController.actionMfgAbgelehnt(mfgID, userID), HandlerDef(this, "controllers.mfgController", "actionMfgAbgelehnt", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/abgelehnt"""))
   }
}
        

// @LINE:39
case controllers_mfgController_actionMfgBesteatigen22(params) => {
   call(params.fromPath[String]("mfgID", None), params.fromPath[String]("userID", None)) { (mfgID, userID) =>
        invokeHandler(controllers.mfgController.actionMfgBesteatigen(mfgID, userID), HandlerDef(this, "controllers.mfgController", "actionMfgBesteatigen", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/mitnehmen"""))
   }
}
        
}

}
     