
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
object Profileinstellungen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,List[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String)(userdata:List[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.56*/("""
"""),_display_(Seq[Any](/*2.2*/main("Memberbereich")/*2.23*/ {_display_(Seq[Any](format.raw/*2.25*/("""

<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked">

        <li class="active"><a href="/memberIndex">Meine MFG</a></li>
        <li><a href="/mfgSuche">MFG Suchen</a></li>
        <li><a href="/mfgAnbieten">MFG Anbieten</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
    <hr>
    <span class="label label-default">Konto: """),_display_(Seq[Any](/*13.47*/email)),format.raw/*13.52*/("""</span>
    <hr>
</div>
<div class="col-md-9">

    <div class="well center">

        <a href="#" id="editProfil">Einträge bearbeiten <span class="glyphicon glyphicon-cog"></span></a>

        """),_display_(Seq[Any](/*22.10*/if(message)/*22.21*/{_display_(Seq[Any](format.raw/*22.22*/("""
        <div class="alert alert-success">
            """),_display_(Seq[Any](/*24.14*/message)),format.raw/*24.21*/("""
        </div>
        """)))})),format.raw/*26.10*/("""

        """),_display_(Seq[Any](/*28.10*/for(i <- userdata) yield /*28.28*/ {_display_(Seq[Any](format.raw/*28.30*/("""
        <div class="profil navActiv">
        <p><span class="label label-primary">Vorname </span> """),_display_(Seq[Any](/*30.63*/i/*30.64*/.vorname)),format.raw/*30.72*/("""</p><hr>
        <p><span class="label label-primary">Nachname </span> """),_display_(Seq[Any](/*31.64*/i/*31.65*/.nachname)),format.raw/*31.74*/("""</p><hr>
        <p><span class="label label-primary">Email </span> """),_display_(Seq[Any](/*32.61*/i/*32.62*/.email)),format.raw/*32.68*/("""</p><hr>
        <p><span class="label label-primary">Geburtsdatum </span> """),_display_(Seq[Any](/*33.68*/i/*33.69*/.geburtsdatum)),format.raw/*33.82*/("""</p><hr>
        <p><span class="label label-primary">Username </span> """),_display_(Seq[Any](/*34.64*/i/*34.65*/.username)),format.raw/*34.74*/("""</p><hr>
        <p><span class="label label-primary">Password </span> """),_display_(Seq[Any](/*35.64*/i/*35.65*/.password)),format.raw/*35.74*/("""</p><hr>
        </div>
        """),_display_(Seq[Any](/*37.10*/helper/*37.16*/.form(routes.ProfileinstellungenController.actionProfil)/*37.72*/ {_display_(Seq[Any](format.raw/*37.74*/("""
        <div class="profilform">
            <fieldset>
            <form>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">Vorname</span>
                    <input name="vorname" value=""""),_display_(Seq[Any](/*44.51*/i/*44.52*/.vorname)),format.raw/*44.60*/("""" type="text" class="form-control" placeholder="Vorname">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">Nachname</span>
                    <input name="nachname"  value=""""),_display_(Seq[Any](/*50.53*/i/*50.54*/.nachname)),format.raw/*50.63*/(""""  type="text" class="form-control" placeholder="Name">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">E-Mail</span>
                    <input name="email" value=""""),_display_(Seq[Any](/*56.49*/i/*56.50*/.email)),format.raw/*56.56*/(""""  type="email" type="text" class="form-control" placeholder="E-Mail" id="disabledInput" disabled>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="dd-MM-yyyy">
                    <input class="form-control" name="geburtsdatum" size="16" type="text" value=""""),_display_(Seq[Any](/*61.99*/i/*61.100*/.geburtsdatum)),format.raw/*61.113*/("""" readonly placeholder="Geburtsdatum">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">Username</span>
                    <input value=""""),_display_(Seq[Any](/*69.36*/i/*69.37*/.username)),format.raw/*69.46*/(""""  type="text"  class="form-control" id="disabledInput" disabled>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">Passwort</span>
                    <input name="password" value=""""),_display_(Seq[Any](/*75.52*/i/*75.53*/.password)),format.raw/*75.62*/(""""  type="password" type="text" class="form-control" placeholder="Passwort">
                </div>
            </div>
            <input type="hidden" name="username" value=""""),_display_(Seq[Any](/*78.58*/i/*78.59*/.username)),format.raw/*78.68*/("""">

            <button name="submit" type="submit" class="btn btn-default">Absenden</button>
            </form>
            </fieldset>
            """)))})),format.raw/*83.14*/("""

        </div>
        """)))})),format.raw/*86.10*/("""


    </div>
</div>
""")))})))}
    }
    
    def render(message:String,email:String,userdata:List[User]): play.api.templates.HtmlFormat.Appendable = apply(message,email)(userdata)
    
    def f:((String,String) => (List[User]) => play.api.templates.HtmlFormat.Appendable) = (message,email) => (userdata) => apply(message,email)(userdata)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 00:28:50 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/Profileinstellungen.scala.html
                    HASH: e1ce40e6d6d89b2ea54c86e89676b877b4fe3294
                    MATRIX: 806->1|954->55|990->57|1019->78|1058->80|1452->438|1479->443|1710->638|1730->649|1769->650|1861->706|1890->713|1947->738|1994->749|2028->767|2068->769|2205->870|2215->871|2245->879|2353->951|2363->952|2394->961|2499->1030|2509->1031|2537->1037|2649->1113|2659->1114|2694->1127|2802->1199|2812->1200|2843->1209|2951->1281|2961->1282|2992->1291|3061->1324|3076->1330|3141->1386|3181->1388|3489->1660|3499->1661|3529->1669|3864->1968|3874->1969|3905->1978|4232->2269|4242->2270|4270->2276|4741->2711|4752->2712|4788->2725|5305->3206|5315->3207|5346->3216|5688->3522|5698->3523|5729->3532|5940->3707|5950->3708|5981->3717|6164->3868|6222->3894
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|50->22|50->22|50->22|52->24|52->24|54->26|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|65->37|65->37|65->37|65->37|72->44|72->44|72->44|78->50|78->50|78->50|84->56|84->56|84->56|89->61|89->61|89->61|97->69|97->69|97->69|103->75|103->75|103->75|106->78|106->78|106->78|111->83|114->86
                    -- GENERATED --
                */
            