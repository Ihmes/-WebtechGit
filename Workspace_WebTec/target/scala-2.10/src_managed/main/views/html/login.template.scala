
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""
"""),_display_(Seq[Any](/*2.2*/main("Anmelden bei MFG")/*2.26*/ {_display_(Seq[Any](format.raw/*2.28*/("""

<div class="well">

    <h3>Bitte Anmelden</h3>
    <hr>

    <div class="row">
        """),_display_(Seq[Any](/*10.10*/helper/*10.16*/.form(routes.accessController.actionAnmelden)/*10.61*/ {_display_(Seq[Any](format.raw/*10.63*/("""
        <div class="col-md-8">
            <form class="form-horizontal" role="form" method="POST" >
                <div class="form-group">
                    <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                        <input name="email" type="email" class="form-control" id="inputEmail1" placeholder="Email">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                        <input name="password" type="password" class="form-control" id="inputPassword1" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>
        """)))})),format.raw/*43.10*/("""
        <div class="col-md-4">

            <div class="bs-callout bs-callout-warning">
                """),_display_(Seq[Any](/*47.18*/if(content)/*47.29*/{_display_(Seq[Any](format.raw/*47.30*/("""
                <div class="alert alert-danger">
                    """),_display_(Seq[Any](/*49.22*/content)),format.raw/*49.29*/("""
                </div>
                """)))})),format.raw/*51.18*/("""
                <p>
                    <span class="glyphicon glyphicon-info-sign"></span> Neu hier? Jetzt kostenlos registrieren!
                </p>
                <a href="/registrierung"><button type="button" class="btn btn-primary btn-lg">Registrieren</button></a>

            </div>
        </div>
    </div>

</div>
""")))})))}
    }
    
    def render(content:String): play.api.templates.HtmlFormat.Appendable = apply(content)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jan 22 21:39:10 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/login.scala.html
                    HASH: e13822f3f1866a4bee696fb31abe136201716de1
                    MATRIX: 774->1|885->18|921->20|953->44|992->46|1119->137|1134->143|1188->188|1228->190|2732->1662|2874->1768|2894->1779|2933->1780|3040->1851|3069->1858|3142->1899
                    LINES: 26->1|29->1|30->2|30->2|30->2|38->10|38->10|38->10|38->10|71->43|75->47|75->47|75->47|77->49|77->49|79->51
                    -- GENERATED --
                */
            