
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
object mfgDetailAnzeigen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,List[ValideMFG],play.api.templates.HtmlFormat.Appendable] {

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
        <a href="/mfgDetailAnfragen/"""),_display_(Seq[Any](/*61.38*/i/*61.39*/.id)),format.raw/*61.42*/(""""><button name="submit" type="submit" class="btn btn-default">MFG buchen</button></a>
        <a href="" onclick="fbshare();"><button name="submit" type="submit" class="btn btn-default">Diese MFG teilen</button></a>
        """)))})),format.raw/*63.10*/("""
        """)))})),format.raw/*64.10*/("""

    </div>
    <div class="well center" onload="getLocation()">
        <div id="result"></div>
        <div id="map"></div>
    </div>
</div>


<script type="text/javascript"src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type='text/javascript' src='"""),_display_(Seq[Any](/*75.38*/routes/*75.44*/.Assets.at("js/googleMaps.js"))),format.raw/*75.74*/("""'></script>


        """),_display_(Seq[Any](/*78.10*/for(i <- mfgDetails) yield /*78.30*/ {_display_(Seq[Any](format.raw/*78.32*/("""
        <script>
                 StartMapDetailSeiteZiel(""""),_display_(Seq[Any](/*80.44*/i/*80.45*/.zielort)),format.raw/*80.53*/("""");
                 StartMapDetailSeiteStart(""""),_display_(Seq[Any](/*81.45*/i/*81.46*/.startort)),format.raw/*81.55*/("""");
                 getLocation();


         </script>
         <script type="text/javascript">
             function fbshare()"""),format.raw/*87.32*/("""{"""),format.raw/*87.33*/("""
             var sharer = "https://www.facebook.com/sharer/sharer.php?u="; window.open(sharer + location.href,'sharer', 'width=626,height=436');
             """),format.raw/*89.14*/("""}"""),format.raw/*89.15*/("""
         </script>
        """)))})),format.raw/*91.10*/("""

""")))})))}
    }
    
    def render(message:String,email:String,user:String,mfgDetails:List[ValideMFG]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user)(mfgDetails)
    
    def f:((String,String,String) => (List[ValideMFG]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user) => (mfgDetails) => apply(message,email,user)(mfgDetails)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 15:38:42 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/mfgDetailAnzeigen.scala.html
                    HASH: ebaa72da18ca44dad22b730cd808217e79268eb4
                    MATRIX: 816->1|986->77|1022->79|1049->98|1088->100|1482->458|1509->463|1549->467|1575->471|1699->559|1719->570|1758->571|1850->627|1879->634|1936->659|1983->670|2014->692|2053->693|2124->745|2137->749|2176->750|2291->829|2327->849|2367->851|2476->924|2486->925|2517->934|2648->1029|2658->1030|2688->1038|2821->1135|2831->1136|2863->1146|2992->1239|3002->1240|3030->1246|3161->1341|3171->1342|3201->1350|3340->1453|3350->1454|3379->1461|3516->1562|3526->1563|3551->1566|3808->1791|3850->1801|4169->2084|4184->2090|4236->2120|4295->2143|4331->2163|4371->2165|4468->2226|4478->2227|4508->2235|4592->2283|4602->2284|4633->2293|4790->2422|4819->2423|5006->2582|5035->2583|5096->2612
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|52->24|54->26|54->26|54->26|56->28|56->28|56->28|60->32|60->32|60->32|63->35|63->35|63->35|67->39|67->39|67->39|71->43|71->43|71->43|75->47|75->47|75->47|79->51|79->51|79->51|83->55|83->55|83->55|89->61|89->61|89->61|91->63|92->64|103->75|103->75|103->75|106->78|106->78|106->78|108->80|108->80|108->80|109->81|109->81|109->81|115->87|115->87|117->89|117->89|119->91
                    -- GENERATED --
                */
            