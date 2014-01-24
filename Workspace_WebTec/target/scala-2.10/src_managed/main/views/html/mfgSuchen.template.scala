
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
object mfgSuchen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,List[ValideMFG],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String, user : String)(mfg:List[ValideMFG]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.71*/("""
"""),_display_(Seq[Any](/*2.2*/main("MFG Suchen")/*2.20*/ {_display_(Seq[Any](format.raw/*2.22*/("""

<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked">

        <li><a href="/memberIndex">Meine MFG</a></li>
        <li class="active"><a href="/mfgSuche">MFG Suchen</a></li>
        <li><a href="/mfgAnbieten">MFG Anbieten</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
    <hr>
    <span class="label label-default">Konto: """),_display_(Seq[Any](/*13.47*/email)),format.raw/*13.52*/(""" / """),_display_(Seq[Any](/*13.56*/user)),format.raw/*13.60*/("""</span>
    <hr>
</div>
<div class="col-md-9">

    <div class="well center">

        """),_display_(Seq[Any](/*20.10*/if(message)/*20.21*/{_display_(Seq[Any](format.raw/*20.22*/("""
        <div class="alert alert-warning">
            """),_display_(Seq[Any](/*22.14*/message)),format.raw/*22.21*/("""
        </div>
        """)))}/*24.10*/else/*24.14*/{_display_(Seq[Any](format.raw/*24.15*/("""
            """),_display_(Seq[Any](/*25.14*/helper/*25.20*/.form(routes.memberController.actionSuche)/*25.62*/ {_display_(Seq[Any](format.raw/*25.64*/("""
                <form class="navbar-form navbar-left" role="search">
                    <div class="col-md-5">
                        <div class="form-group">
                            <input type="text" name="startort" class="form-control" placeholder="Startort">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="form-group">
                            <input type="text" name="zielort"  class="form-control" placeholder="Zielort">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default">Suchen</button>
                    </div>
                </form>
            <hr>
            """)))})),format.raw/*42.14*/("""
        """)))})),format.raw/*43.10*/("""

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Von</th>
                <th>Nach</th>
                <th class="rwdTabel">Datum</th>
                <th class="rwdTabel">Zeit</th>
            </tr>
            </thead>
            <tbody>
            """),_display_(Seq[Any](/*55.14*/if(mfg.isEmpty)/*55.29*/{_display_(Seq[Any](format.raw/*55.30*/("""
                <p>Es wurden keine Einträge gefunden</p>
            """)))}/*57.14*/else/*57.18*/{_display_(Seq[Any](format.raw/*57.19*/("""
                """),_display_(Seq[Any](/*58.18*/for(i <- mfg) yield /*58.31*/ {_display_(Seq[Any](format.raw/*58.33*/("""
                <tr>
                    <td>"""),_display_(Seq[Any](/*60.26*/i/*60.27*/.startort)),format.raw/*60.36*/("""</td>
                    <td>"""),_display_(Seq[Any](/*61.26*/i/*61.27*/.zielort)),format.raw/*61.35*/("""</td>
                    <td class="rwdTabel">"""),_display_(Seq[Any](/*62.43*/i/*62.44*/.datum)),format.raw/*62.50*/("""</td>
                    <td class="rwdTabel">"""),_display_(Seq[Any](/*63.43*/i/*63.44*/.uhrzeit)),format.raw/*63.52*/("""</td>
                    <td><a href="/mfgDetailAnzeigen/"""),_display_(Seq[Any](/*64.54*/i/*64.55*/.id)),format.raw/*64.58*/("""">Details</a></td>

                </tr>
                """)))})),format.raw/*67.18*/("""
            """)))})),format.raw/*68.14*/("""
            </tbody>
        </table>


    </div>
</div>
""")))})))}
    }
    
    def render(message:String,email:String,user:String,mfg:List[ValideMFG]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user)(mfg)
    
    def f:((String,String,String) => (List[ValideMFG]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user) => (mfg) => apply(message,email,user)(mfg)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 14:06:33 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/mfgSuchen.scala.html
                    HASH: f3b6118b076a888337396305b4c876d1a27cf9a7
                    MATRIX: 808->1|971->70|1007->72|1033->90|1072->92|1466->450|1493->455|1533->459|1559->463|1683->551|1703->562|1742->563|1834->619|1863->626|1907->651|1920->655|1959->656|2009->670|2024->676|2075->718|2115->720|2942->1515|2984->1525|3329->1834|3353->1849|3392->1850|3482->1921|3495->1925|3534->1926|3588->1944|3617->1957|3657->1959|3740->2006|3750->2007|3781->2016|3848->2047|3858->2048|3888->2056|3972->2104|3982->2105|4010->2111|4094->2159|4104->2160|4134->2168|4229->2227|4239->2228|4264->2231|4355->2290|4401->2304
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|53->25|70->42|71->43|83->55|83->55|83->55|85->57|85->57|85->57|86->58|86->58|86->58|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|95->67|96->68
                    -- GENERATED --
                */
            