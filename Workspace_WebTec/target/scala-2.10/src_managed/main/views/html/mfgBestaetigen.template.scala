
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
object mfgBestaetigen extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,String,String,List[ValideMFG],List[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String, user : String)(mfgDetails:List[ValideMFG])(userdata:List[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.99*/("""
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


            """),_display_(Seq[Any](/*27.14*/for(l <- userdata) yield /*27.32*/ {_display_(Seq[Any](format.raw/*27.34*/("""
                """),_display_(Seq[Any](/*28.18*/for(i <- mfgDetails) yield /*28.38*/ {_display_(Seq[Any](format.raw/*28.40*/("""
                <div class="profil">
                    <h4>Mitfahrer</h4>
                    <p><span class="label label-primary">Vorname </span> """),_display_(Seq[Any](/*31.75*/l/*31.76*/.vorname)),format.raw/*31.84*/("""</p><hr>
                    <p><span class="label label-primary">Nachname </span> """),_display_(Seq[Any](/*32.76*/l/*32.77*/.nachname)),format.raw/*32.86*/("""</p><hr>
                    <p><span class="label label-primary">Email </span> """),_display_(Seq[Any](/*33.73*/l/*33.74*/.email)),format.raw/*33.80*/("""</p><hr>
                    <p><span class="label label-primary">Geburtsdatum </span> """),_display_(Seq[Any](/*34.80*/l/*34.81*/.geburtsdatum)),format.raw/*34.94*/("""</p><hr>

                </div>
                <a href="/mfgBesteatigen/"""),_display_(Seq[Any](/*37.43*/i/*37.44*/.id)),format.raw/*37.47*/("""/"""),_display_(Seq[Any](/*37.49*/l/*37.50*/.id)),format.raw/*37.53*/("""/abgelehnt"><button name="submit" type="submit" class="btn btn-warning">Mitfahrer ablehnen </button></a>
                <a href="/mfgBesteatigen/"""),_display_(Seq[Any](/*38.43*/i/*38.44*/.id)),format.raw/*38.47*/("""/"""),_display_(Seq[Any](/*38.49*/l/*38.50*/.id)),format.raw/*38.53*/("""/mitnehmen"><button name="submit" type="submit" class="btn btn-success">Mitfahrer mitnehmen </button></a>

                <a href="/mfgDetailAnzeigen/"""),_display_(Seq[Any](/*40.46*/i/*40.47*/.id)),format.raw/*40.50*/(""""><button name="submit" type="submit" class="btn btn-default">MFG Details</button></a>
                """)))})),format.raw/*41.18*/("""
            """)))})),format.raw/*42.14*/("""

    </div>
    <div class="well center" onload="getLocation()">
        <div id="result"></div>
        <div id="map"></div>
    </div>
</div>


<script type="text/javascript"src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type='text/javascript' src='"""),_display_(Seq[Any](/*53.38*/routes/*53.44*/.Assets.at("js/googleMaps.js"))),format.raw/*53.74*/("""'></script>


"""),_display_(Seq[Any](/*56.2*/for(i <- mfgDetails) yield /*56.22*/ {_display_(Seq[Any](format.raw/*56.24*/("""
<script>
                 StartMapDetailSeiteZiel(""""),_display_(Seq[Any](/*58.44*/i/*58.45*/.zielort)),format.raw/*58.53*/("""");
                 StartMapDetailSeiteStart(""""),_display_(Seq[Any](/*59.45*/i/*59.46*/.startort)),format.raw/*59.55*/("""");
                 getLocation();
         </script>
""")))})),format.raw/*62.2*/("""

""")))})))}
    }
    
    def render(message:String,email:String,user:String,mfgDetails:List[ValideMFG],userdata:List[User]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user)(mfgDetails)(userdata)
    
    def f:((String,String,String) => (List[ValideMFG]) => (List[User]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user) => (mfgDetails) => (userdata) => apply(message,email,user)(mfgDetails)(userdata)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jan 22 06:12:22 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/mfgBestaetigen.scala.html
                    HASH: 04cc78c71e2da0c4c4051a928a5116b6f101d9bb
                    MATRIX: 824->1|1015->98|1051->100|1078->119|1117->121|1511->479|1538->484|1578->488|1604->492|1728->580|1748->591|1787->592|1879->648|1908->655|1965->680|2017->696|2051->714|2091->716|2145->734|2181->754|2221->756|2408->907|2418->908|2448->916|2568->1000|2578->1001|2609->1010|2726->1091|2736->1092|2764->1098|2888->1186|2898->1187|2933->1200|3044->1275|3054->1276|3079->1279|3117->1281|3127->1282|3152->1285|3335->1432|3345->1433|3370->1436|3408->1438|3418->1439|3443->1442|3631->1594|3641->1595|3666->1598|3802->1702|3848->1716|4167->1999|4182->2005|4234->2035|4284->2050|4320->2070|4360->2072|4449->2125|4459->2126|4489->2134|4573->2182|4583->2183|4614->2192|4701->2248
                    LINES: 26->1|29->1|30->2|30->2|30->2|41->13|41->13|41->13|41->13|48->20|48->20|48->20|50->22|50->22|52->24|55->27|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|68->40|68->40|68->40|69->41|70->42|81->53|81->53|81->53|84->56|84->56|84->56|86->58|86->58|86->58|87->59|87->59|87->59|90->62
                    -- GENERATED --
                */
            