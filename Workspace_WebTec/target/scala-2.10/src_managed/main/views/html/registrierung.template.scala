
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
object registrierung extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""
"""),_display_(Seq[Any](/*2.2*/main("Registrieren bei MFG")/*2.30*/ {_display_(Seq[Any](format.raw/*2.32*/("""

<div class="well">
    <div class="row">
        """),_display_(Seq[Any](/*6.10*/helper/*6.16*/.form(routes.accessController.actionRegistrierung)/*6.66*/ {_display_(Seq[Any](format.raw/*6.68*/("""
        <div class="col-md-8">
                    <h3>Registriere dich jetzt bei MFG</h3>
            <hr>
            <form>
                <fieldset>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Vorname</span>
                            <input name="vorname" type="text" class="form-control" placeholder="Vorname">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Name</span>
                            <input name="nachname" type="text" class="form-control" placeholder="Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">E-Mail</span>
                            <input name="email" type="email" type="text" class="form-control" placeholder="E-Mail">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Username</span>
                            <input name="username" type="text" type="text" class="form-control" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Passwort</span>
                            <input name="password" type="password" type="text" class="form-control" placeholder="Passwort">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Passwort wiederholen</span>
                            <input name="repassword" type="password" type="text" class="form-control" placeholder="Passwort wiederholen">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="dd-MM-yyyy">
                            <input class="form-control" name="geburtsdatum" size="16" type="text" value="" readonly placeholder="Geburtsdatum">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" /><br/>
                    </div>


                    <button name="submit" type="submit" class="btn btn-default">Registrieren</button>
                </fieldset>
            </form>
        </div>
        """)))})),format.raw/*62.10*/("""
        <div class="col-md-4">
            <div class="panel-body">
                <div class="alert alert-info">
                """),_display_(Seq[Any](/*66.18*/content)),format.raw/*66.25*/("""
                </div>
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
                    DATE: Thu Jan 23 19:50:43 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/registrierung.scala.html
                    HASH: 6ec0cafaa187c3e825f739bc6b48b45e290f4130
                    MATRIX: 782->1|893->18|929->20|965->48|1004->50|1091->102|1105->108|1163->158|1202->160|4378->3304|4547->3437|4576->3444
                    LINES: 26->1|29->1|30->2|30->2|30->2|34->6|34->6|34->6|34->6|90->62|94->66|94->66
                    -- GENERATED --
                */
            