
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
object mfgDetailindex extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,List[ValideMFG],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String, user : String)(mfgDetails:List[ValideMFG]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.78*/("""
"""),_display_(Seq[Any](/*2.2*/main("MFG Details")/*2.21*/ {_display_(Seq[Any](format.raw/*2.23*/("""

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
        """)))})),format.raw/*24.10*/("""

        """),_display_(Seq[Any](/*26.10*/if(mfgDetails.isEmpty)/*26.32*/{_display_(Seq[Any](format.raw/*26.33*/("""
        <p>Fehler! Versuch es nochmal</p>
        """)))}/*28.10*/else/*28.14*/{_display_(Seq[Any](format.raw/*28.15*/("""

        <table class="table table-striped">
            <tbody>
            """),_display_(Seq[Any](/*32.14*/for(i <- mfgDetails) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
            <tr>
                <td>Startort</td>
                <td>"""),_display_(Seq[Any](/*35.22*/i/*35.23*/.startort)),format.raw/*35.32*/("""</td>
            </tr>
            <tr>
                <td>Zielort</td>
                <td>"""),_display_(Seq[Any](/*39.22*/i/*39.23*/.zielort)),format.raw/*39.31*/("""</td>
            </tr>
            <tr>
                <td>Mitfahrer</td>
                <td>"""),_display_(Seq[Any](/*43.22*/i/*43.23*/.mitfahrer)),format.raw/*43.33*/("""</td>
            </tr>
            <tr>
                <td>Datum</td>
                <td>"""),_display_(Seq[Any](/*47.22*/i/*47.23*/.datum)),format.raw/*47.29*/("""</td>
            </tr>
            <tr>
                <td>Uhrzeit</td>
                <td>"""),_display_(Seq[Any](/*51.22*/i/*51.23*/.uhrzeit)),format.raw/*51.31*/("""</td>
            </tr>
            <tr>
                <td>Eingestellt von</td>
                <td>"""),_display_(Seq[Any](/*55.22*/i/*55.23*/.fahrer)),format.raw/*55.30*/("""</td>
            </tr>


            </tbody>
        </table>
        <a href="" onclick="fbshare();"><button name="submit" type="submit" class="btn btn-default">Diese MFG teilen</button></a>
        """)))})),format.raw/*62.10*/("""
        """)))})),format.raw/*63.10*/("""

    </div>
    <div class="well center" onload="getLocation()">
        <div id="result"></div>
        <div id="map"></div>
    </div>
</div>


<script type="text/javascript"src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type='text/javascript' src='"""),_display_(Seq[Any](/*74.38*/routes/*74.44*/.Assets.at("js/googleMaps.js"))),format.raw/*74.74*/("""'></script>


        """),_display_(Seq[Any](/*77.10*/for(i <- mfgDetails) yield /*77.30*/ {_display_(Seq[Any](format.raw/*77.32*/("""
        <script>
                 StartMapDetailSeiteZiel(""""),_display_(Seq[Any](/*79.44*/i/*79.45*/.zielort)),format.raw/*79.53*/("""");
                 StartMapDetailSeiteStart(""""),_display_(Seq[Any](/*80.45*/i/*80.46*/.startort)),format.raw/*80.55*/("""");
                 getLocation();


         </script>
         <script type="text/javascript">
             function fbshare()"""),format.raw/*86.32*/("""{"""),format.raw/*86.33*/("""
             var sharer = "https://www.facebook.com/sharer/sharer.php?u="; window.open(sharer + location.href,'sharer', 'width=626,height=436');
             """),format.raw/*88.14*/("""}"""),format.raw/*88.15*/("""
         </script>
        """)))})),format.raw/*90.10*/("""

""")))})))}
    }
    
    def render(message:String,email:String,user:String,mfgDetails:List[ValideMFG]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user)(mfgDetails)
    
    def f:((String,String,String) => (List[ValideMFG]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user) => (mfgDetails) => apply(message,email,user)(mfgDetails)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 23:20:05 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/mfgDetailindex.scala.html
                    HASH: 7e6790023f290f3c64984a4cc7ff9f29d4e98d6d
                    MATRIX: 813->1|983->77|1019->79|1046->98|1085->100|1479->458|1506->463|1546->467|1572->471|1696->559|1716->570|1755->571|1847->627|1876->634|1933->659|1980->670|2011->692|2050->693|2121->745|2134->749|2173->750|2288->829|2324->849|2364->851|2473->924|2483->925|2514->934|2645->1029|2655->1030|2685->1038|2818->1135|2828->1136|2860->1146|2989->1239|2999->1240|3027->1246|3158->1341|3168->1342|3198->1350|3337->1453|3347->1454|3376->1461|3611->1664|3653->1674|3972->1957|3987->1963|4039->1993|4098->2016|4134->2036|4174->2038|4271->2099|4281->2100|4311->2108|4395->2156|4405->2157|4436->2166|4593->2295|4622->2296|4809->2455|4838->2456|4899->2485
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|52->24|54->26|54->26|54->26|56->28|56->28|56->28|60->32|60->32|60->32|63->35|63->35|63->35|67->39|67->39|67->39|71->43|71->43|71->43|75->47|75->47|75->47|79->51|79->51|79->51|83->55|83->55|83->55|90->62|91->63|102->74|102->74|102->74|105->77|105->77|105->77|107->79|107->79|107->79|108->80|108->80|108->80|114->86|114->86|116->88|116->88|118->90
                    -- GENERATED --
                */
            