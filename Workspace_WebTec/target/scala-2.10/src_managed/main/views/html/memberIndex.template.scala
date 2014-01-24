
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
object memberIndex extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[String,String,String,String,List[ValideMFG],List[ValideMFG],List[ValideMFG],List[ValideMFG],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String, user : String, userDataTrue: String)(mfgAngeboten:List[ValideMFG])(mfgAnfragen:List[ValideMFG])(mfgBestaetigung:List[ValideMFG])(mfgAbgelehnt:List[ValideMFG]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.194*/("""
"""),_display_(Seq[Any](/*2.2*/main("Memberbereich")/*2.23*/ {_display_(Seq[Any](format.raw/*2.25*/("""

<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked">

        <li class="active"><a href="/memberIndex">Meine MFG</a></li>
        <li><a href="/mfgSuche">MFG Suchen</a></li>
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
        <div class="alert alert-info">
            """),_display_(Seq[Any](/*22.14*/message)),format.raw/*22.21*/("""
        </div>
            """),_display_(Seq[Any](/*24.14*/if(userDataTrue == null)/*24.38*/{_display_(Seq[Any](format.raw/*24.39*/("""
            <ul class="pager">
                <li><a href="/memberIndex">Zur Übersicht <span class="glyphicon glyphicon-list"></span></a></li>
            </ul>
            """)))})),format.raw/*28.14*/("""
        """)))})),format.raw/*29.10*/("""
        """),_display_(Seq[Any](/*30.10*/if(userDataTrue)/*30.26*/{_display_(Seq[Any](format.raw/*30.27*/("""
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Von</th>
                <th class="rwdTabel">Nach</th>
                <th class="rwdTabel">Datum</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>

            """),_display_(Seq[Any](/*42.14*/for(l <- mfgAngeboten) yield /*42.36*/ {_display_(Seq[Any](format.raw/*42.38*/("""
            <tr>
                <td>"""),_display_(Seq[Any](/*44.22*/l/*44.23*/.startort)),format.raw/*44.32*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*45.39*/l/*45.40*/.zielort)),format.raw/*45.48*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*46.39*/l/*46.40*/.datum)),format.raw/*46.46*/("""</td>
                <td><span class="label label-danger">zu bestätigen</span></td>
                <td><a href="/mfgBestaetigen/"""),_display_(Seq[Any](/*48.47*/l/*48.48*/.id)),format.raw/*48.51*/("""">Jetzt bestätigen</a></td>
            </tr>
            """)))})),format.raw/*50.14*/("""

            """),_display_(Seq[Any](/*52.14*/for(l <- mfgAnfragen) yield /*52.35*/ {_display_(Seq[Any](format.raw/*52.37*/("""
            <tr>
                <td>"""),_display_(Seq[Any](/*54.22*/l/*54.23*/.startort)),format.raw/*54.32*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*55.39*/l/*55.40*/.zielort)),format.raw/*55.48*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*56.39*/l/*56.40*/.datum)),format.raw/*56.46*/("""</td>
                <td><span class="label label-warning">angefragt</span></td>
                <td><a href="/mfgDetailindex/"""),_display_(Seq[Any](/*58.47*/l/*58.48*/.id)),format.raw/*58.51*/("""">Details</a></td>

            </tr>
            """)))})),format.raw/*61.14*/("""


            """),_display_(Seq[Any](/*64.14*/for(l <- mfgBestaetigung) yield /*64.39*/ {_display_(Seq[Any](format.raw/*64.41*/("""
            <tr>
                <td>"""),_display_(Seq[Any](/*66.22*/l/*66.23*/.startort)),format.raw/*66.32*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*67.39*/l/*67.40*/.zielort)),format.raw/*67.48*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*68.39*/l/*68.40*/.datum)),format.raw/*68.46*/("""</td>
                <td><span class="label label-success">bestätigt</span></td>
                <td><a href="/mfgDetailindex/"""),_display_(Seq[Any](/*70.47*/l/*70.48*/.id)),format.raw/*70.51*/("""">Details</a></td>

            </tr>
            """)))})),format.raw/*73.14*/("""

            """),_display_(Seq[Any](/*75.14*/for(l <- mfgAbgelehnt) yield /*75.36*/ {_display_(Seq[Any](format.raw/*75.38*/("""
            <tr>
                <td>"""),_display_(Seq[Any](/*77.22*/l/*77.23*/.startort)),format.raw/*77.32*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*78.39*/l/*78.40*/.zielort)),format.raw/*78.48*/("""</td>
                <td class="rwdTabel">"""),_display_(Seq[Any](/*79.39*/l/*79.40*/.datum)),format.raw/*79.46*/("""</td>
                <td><span class="label label-default">abgelehnt</span></td>
                <td><a href="/mfgDetailindex/"""),_display_(Seq[Any](/*81.47*/l/*81.48*/.id)),format.raw/*81.51*/("""">Details</a></td>

            </tr>
            """)))})),format.raw/*84.14*/("""

            </tbody>
        </table>


        <ul class="pager">
            <li><a href="/Profileinstellungen">Kontodaten bearbeiten <span class="glyphicon glyphicon-cog"></span></a></li>
        </ul>
        """)))})),format.raw/*93.10*/("""
    </div>
</div>
""")))})))}
    }
    
    def render(message:String,email:String,user:String,userDataTrue:String,mfgAngeboten:List[ValideMFG],mfgAnfragen:List[ValideMFG],mfgBestaetigung:List[ValideMFG],mfgAbgelehnt:List[ValideMFG]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user,userDataTrue)(mfgAngeboten)(mfgAnfragen)(mfgBestaetigung)(mfgAbgelehnt)
    
    def f:((String,String,String,String) => (List[ValideMFG]) => (List[ValideMFG]) => (List[ValideMFG]) => (List[ValideMFG]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user,userDataTrue) => (mfgAngeboten) => (mfgAnfragen) => (mfgBestaetigung) => (mfgAbgelehnt) => apply(message,email,user,userDataTrue)(mfgAngeboten)(mfgAnfragen)(mfgBestaetigung)(mfgAbgelehnt)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 23:20:05 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/memberIndex.scala.html
                    HASH: 25c74c92a2a40c3b7de3198118b7989ab3280488
                    MATRIX: 865->1|1152->193|1188->195|1217->216|1256->218|1650->576|1677->581|1717->585|1743->589|1867->677|1887->688|1926->689|2015->742|2044->749|2109->778|2142->802|2181->803|2389->979|2431->989|2477->999|2502->1015|2541->1016|2888->1327|2926->1349|2966->1351|3041->1390|3051->1391|3082->1400|3162->1444|3172->1445|3202->1453|3282->1497|3292->1498|3320->1504|3487->1635|3497->1636|3522->1639|3613->1698|3664->1713|3701->1734|3741->1736|3816->1775|3826->1776|3857->1785|3937->1829|3947->1830|3977->1838|4057->1882|4067->1883|4095->1889|4259->2017|4269->2018|4294->2021|4377->2072|4429->2088|4470->2113|4510->2115|4585->2154|4595->2155|4626->2164|4706->2208|4716->2209|4746->2217|4826->2261|4836->2262|4864->2268|5028->2396|5038->2397|5063->2400|5146->2451|5197->2466|5235->2488|5275->2490|5350->2529|5360->2530|5391->2539|5471->2583|5481->2584|5511->2592|5591->2636|5601->2637|5629->2643|5793->2771|5803->2772|5828->2775|5911->2826|6159->3042
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|52->24|52->24|52->24|56->28|57->29|58->30|58->30|58->30|70->42|70->42|70->42|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|76->48|76->48|76->48|78->50|80->52|80->52|80->52|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|86->58|86->58|86->58|89->61|92->64|92->64|92->64|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|98->70|98->70|98->70|101->73|103->75|103->75|103->75|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|109->81|109->81|109->81|112->84|121->93
                    -- GENERATED --
                */
            