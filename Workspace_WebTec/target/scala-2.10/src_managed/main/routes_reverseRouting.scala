// @SOURCE:D:/Workspace_WebTec/conf/routes
// @HASH:90eb6064836865cfe5e632be942a89459ccb861f
// @DATE:Thu Jan 23 23:36:25 CET 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:28
// @LINE:27
class ReverseProfileinstellungenController {
    

// @LINE:28
def actionProfil(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "Profileinstellungen")
}
                                                

// @LINE:27
def showProfil(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "Profileinstellungen")
}
                                                
    
}
                          

// @LINE:11
class ReverseWebJarAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
class ReverseaccessController {
    

// @LINE:13
def showAnmelden(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "anmelden")
}
                                                

// @LINE:14
def actionAnmelden(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "anmelden")
}
                                                

// @LINE:16
def showRegistrierung(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "registrierung")
}
                                                

// @LINE:17
def actionRegistrierung(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "registrierung")
}
                                                
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
class ReversememberController {
    

// @LINE:24
def showAnbieterMaske(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgAnbieten")
}
                                                

// @LINE:21
def showSuche(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgSuche")
}
                                                

// @LINE:19
def showMemberIndex(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "memberIndex")
}
                                                

// @LINE:25
def actionAnbieterMaske(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "mfgAnbieten")
}
                                                

// @LINE:22
def actionSuche(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "mfgSuche")
}
                                                
    
}
                          

// @LINE:5
class ReverseMainController {
    

// @LINE:5
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:30
class ReverseLogoutController {
    

// @LINE:30
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                
    
}
                          

// @LINE:7
// @LINE:6
class ReverseMessageController {
    

// @LINE:6
def getMessage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "message")
}
                                                

// @LINE:7
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
}
                                                
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
class ReversemfgController {
    

// @LINE:34
def showDetailIndex(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgDetailindex/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:38
def actionMfgAbgelehnt(mfgID:String, userID:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgBesteatigen/" + implicitly[PathBindable[String]].unbind("mfgID", dynamicString(mfgID)) + "/" + implicitly[PathBindable[String]].unbind("userID", dynamicString(userID)) + "/abgelehnt")
}
                                                

// @LINE:32
def showDetailAnzeigen(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgDetailAnzeigen/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:33
def actionBuchungAnfrage(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgDetailAnfragen/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:36
def showMfgBesteatigen(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgBestaetigen/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:39
def actionMfgBesteatigen(mfgID:String, userID:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mfgBesteatigen/" + implicitly[PathBindable[String]].unbind("mfgID", dynamicString(mfgID)) + "/" + implicitly[PathBindable[String]].unbind("userID", dynamicString(userID)) + "/mitnehmen")
}
                                                
    
}
                          
}
                  


// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.javascript {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:28
// @LINE:27
class ReverseProfileinstellungenController {
    

// @LINE:28
def actionProfil : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProfileinstellungenController.actionProfil",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "Profileinstellungen"})
      }
   """
)
                        

// @LINE:27
def showProfil : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProfileinstellungenController.showProfil",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "Profileinstellungen"})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseWebJarAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebJarAssets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
class ReverseaccessController {
    

// @LINE:13
def showAnmelden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.accessController.showAnmelden",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "anmelden"})
      }
   """
)
                        

// @LINE:14
def actionAnmelden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.accessController.actionAnmelden",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "anmelden"})
      }
   """
)
                        

// @LINE:16
def showRegistrierung : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.accessController.showRegistrierung",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registrierung"})
      }
   """
)
                        

// @LINE:17
def actionRegistrierung : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.accessController.actionRegistrierung",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registrierung"})
      }
   """
)
                        
    
}
              

// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
class ReversememberController {
    

// @LINE:24
def showAnbieterMaske : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.memberController.showAnbieterMaske",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgAnbieten"})
      }
   """
)
                        

// @LINE:21
def showSuche : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.memberController.showSuche",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgSuche"})
      }
   """
)
                        

// @LINE:19
def showMemberIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.memberController.showMemberIndex",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memberIndex"})
      }
   """
)
                        

// @LINE:25
def actionAnbieterMaske : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.memberController.actionAnbieterMaske",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgAnbieten"})
      }
   """
)
                        

// @LINE:22
def actionSuche : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.memberController.actionSuche",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgSuche"})
      }
   """
)
                        
    
}
              

// @LINE:5
class ReverseMainController {
    

// @LINE:5
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MainController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:30
class ReverseLogoutController {
    

// @LINE:30
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LogoutController.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        
    
}
              

// @LINE:7
// @LINE:6
class ReverseMessageController {
    

// @LINE:6
def getMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessageController.getMessage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
      }
   """
)
                        

// @LINE:7
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessageController.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
      }
   """
)
                        
    
}
              

// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
class ReversemfgController {
    

// @LINE:34
def showDetailIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.showDetailIndex",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgDetailindex/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:38
def actionMfgAbgelehnt : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.actionMfgAbgelehnt",
   """
      function(mfgID,userID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgBesteatigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("mfgID", encodeURIComponent(mfgID)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userID", encodeURIComponent(userID)) + "/abgelehnt"})
      }
   """
)
                        

// @LINE:32
def showDetailAnzeigen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.showDetailAnzeigen",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgDetailAnzeigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:33
def actionBuchungAnfrage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.actionBuchungAnfrage",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgDetailAnfragen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:36
def showMfgBesteatigen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.showMfgBesteatigen",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgBestaetigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:39
def actionMfgBesteatigen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.mfgController.actionMfgBesteatigen",
   """
      function(mfgID,userID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mfgBesteatigen/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("mfgID", encodeURIComponent(mfgID)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userID", encodeURIComponent(userID)) + "/mitnehmen"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
// @LINE:5
package controllers.ref {


// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:28
// @LINE:27
class ReverseProfileinstellungenController {
    

// @LINE:28
def actionProfil(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProfileinstellungenController.actionProfil(), HandlerDef(this, "controllers.ProfileinstellungenController", "actionProfil", Seq(), "POST", """""", _prefix + """Profileinstellungen""")
)
                      

// @LINE:27
def showProfil(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProfileinstellungenController.showProfil(), HandlerDef(this, "controllers.ProfileinstellungenController", "showProfil", Seq(), "GET", """""", _prefix + """Profileinstellungen""")
)
                      
    
}
                          

// @LINE:11
class ReverseWebJarAssets {
    

// @LINE:11
def at(file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebJarAssets.at(file), HandlerDef(this, "controllers.WebJarAssets", "at", Seq(classOf[String]), "GET", """""", _prefix + """webjars/$file<.+>""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:14
// @LINE:13
class ReverseaccessController {
    

// @LINE:13
def showAnmelden(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.accessController.showAnmelden(), HandlerDef(this, "controllers.accessController", "showAnmelden", Seq(), "GET", """""", _prefix + """anmelden""")
)
                      

// @LINE:14
def actionAnmelden(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.accessController.actionAnmelden(), HandlerDef(this, "controllers.accessController", "actionAnmelden", Seq(), "POST", """""", _prefix + """anmelden""")
)
                      

// @LINE:16
def showRegistrierung(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.accessController.showRegistrierung(), HandlerDef(this, "controllers.accessController", "showRegistrierung", Seq(), "GET", """""", _prefix + """registrierung""")
)
                      

// @LINE:17
def actionRegistrierung(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.accessController.actionRegistrierung(), HandlerDef(this, "controllers.accessController", "actionRegistrierung", Seq(), "POST", """""", _prefix + """registrierung""")
)
                      
    
}
                          

// @LINE:25
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
class ReversememberController {
    

// @LINE:24
def showAnbieterMaske(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.memberController.showAnbieterMaske(), HandlerDef(this, "controllers.memberController", "showAnbieterMaske", Seq(), "GET", """""", _prefix + """mfgAnbieten""")
)
                      

// @LINE:21
def showSuche(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.memberController.showSuche(), HandlerDef(this, "controllers.memberController", "showSuche", Seq(), "GET", """""", _prefix + """mfgSuche""")
)
                      

// @LINE:19
def showMemberIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.memberController.showMemberIndex(), HandlerDef(this, "controllers.memberController", "showMemberIndex", Seq(), "GET", """""", _prefix + """memberIndex""")
)
                      

// @LINE:25
def actionAnbieterMaske(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.memberController.actionAnbieterMaske(), HandlerDef(this, "controllers.memberController", "actionAnbieterMaske", Seq(), "POST", """""", _prefix + """mfgAnbieten""")
)
                      

// @LINE:22
def actionSuche(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.memberController.actionSuche(), HandlerDef(this, "controllers.memberController", "actionSuche", Seq(), "POST", """""", _prefix + """mfgSuche""")
)
                      
    
}
                          

// @LINE:5
class ReverseMainController {
    

// @LINE:5
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MainController.index(), HandlerDef(this, "controllers.MainController", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:30
class ReverseLogoutController {
    

// @LINE:30
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LogoutController.logout(), HandlerDef(this, "controllers.LogoutController", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      
    
}
                          

// @LINE:7
// @LINE:6
class ReverseMessageController {
    

// @LINE:6
def getMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessageController.getMessage(), HandlerDef(this, "controllers.MessageController", "getMessage", Seq(), "GET", """""", _prefix + """message""")
)
                      

// @LINE:7
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessageController.javascriptRoutes(), HandlerDef(this, "controllers.MessageController", "javascriptRoutes", Seq(), "GET", """""", _prefix + """assets/javascripts/routes""")
)
                      
    
}
                          

// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:33
// @LINE:32
class ReversemfgController {
    

// @LINE:34
def showDetailIndex(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.showDetailIndex(id), HandlerDef(this, "controllers.mfgController", "showDetailIndex", Seq(classOf[String]), "GET", """""", _prefix + """mfgDetailindex/$id<[^/]+>""")
)
                      

// @LINE:38
def actionMfgAbgelehnt(mfgID:String, userID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.actionMfgAbgelehnt(mfgID, userID), HandlerDef(this, "controllers.mfgController", "actionMfgAbgelehnt", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/abgelehnt""")
)
                      

// @LINE:32
def showDetailAnzeigen(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.showDetailAnzeigen(id), HandlerDef(this, "controllers.mfgController", "showDetailAnzeigen", Seq(classOf[String]), "GET", """""", _prefix + """mfgDetailAnzeigen/$id<[^/]+>""")
)
                      

// @LINE:33
def actionBuchungAnfrage(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.actionBuchungAnfrage(id), HandlerDef(this, "controllers.mfgController", "actionBuchungAnfrage", Seq(classOf[String]), "GET", """""", _prefix + """mfgDetailAnfragen/$id<[^/]+>""")
)
                      

// @LINE:36
def showMfgBesteatigen(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.showMfgBesteatigen(id), HandlerDef(this, "controllers.mfgController", "showMfgBesteatigen", Seq(classOf[String]), "GET", """""", _prefix + """mfgBestaetigen/$id<[^/]+>""")
)
                      

// @LINE:39
def actionMfgBesteatigen(mfgID:String, userID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.mfgController.actionMfgBesteatigen(mfgID, userID), HandlerDef(this, "controllers.mfgController", "actionMfgBesteatigen", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """mfgBesteatigen/$mfgID<[^/]+>/$userID<[^/]+>/mitnehmen""")
)
                      
    
}
                          
}
        
    