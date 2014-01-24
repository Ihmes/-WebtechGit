
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
object mfgAnbieten extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,List[ValideMFG],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, email : String, user : String)(mfg:List[ValideMFG]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.71*/("""
"""),_display_(Seq[Any](/*2.2*/main("MFG Anbieten")/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""


<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked">

        <li><a href="/memberIndex">Meine MFG</a></li>
        <li><a href="/mfgSuche">MFG Suchen</a></li>
        <li class="active"><a href="/mfgAnbieten">MFG Anbieten</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
    <hr>
    <span class="label label-default">Konto: """),_display_(Seq[Any](/*14.47*/email)),format.raw/*14.52*/(""" / """),_display_(Seq[Any](/*14.56*/user)),format.raw/*14.60*/("""</span>
    <hr>
</div>

<div class="col-md-9">
        """),_display_(Seq[Any](/*19.10*/if(mfg == null)/*19.25*/{_display_(Seq[Any](format.raw/*19.26*/("""
        """)))}/*20.10*/else/*20.14*/{_display_(Seq[Any](format.raw/*20.15*/("""
        <div class="well center">
            <button id="listeZeigen" class="btn btn-default">Meine angebotenen MFGs</button>
            <div id="PanelAnzeigen">
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

                    <div class="alert alert-info">
                    </div>

                    """),_display_(Seq[Any](/*38.22*/for(i <- mfg) yield /*38.35*/ {_display_(Seq[Any](format.raw/*38.37*/("""
                    <tr>
                        <td>"""),_display_(Seq[Any](/*40.30*/i/*40.31*/.startort)),format.raw/*40.40*/("""</td>
                        <td>"""),_display_(Seq[Any](/*41.30*/i/*41.31*/.zielort)),format.raw/*41.39*/("""</td>
                        <td class="rwdTabel">"""),_display_(Seq[Any](/*42.47*/i/*42.48*/.datum)),format.raw/*42.54*/("""</td>
                        <td class="rwdTabel">"""),_display_(Seq[Any](/*43.47*/i/*43.48*/.uhrzeit)),format.raw/*43.56*/("""</td>
                        <td><a href="/mfgDetailAnzeigen/"""),_display_(Seq[Any](/*44.58*/i/*44.59*/.id)),format.raw/*44.62*/("""">Details</a></td>

                    </tr>
                    """)))})),format.raw/*47.22*/("""

                    </tbody>
                </table>
            </div>
        </div>
        """)))})),format.raw/*53.10*/("""
        <div class="well center">
        """),_display_(Seq[Any](/*55.10*/if(message)/*55.21*/{_display_(Seq[Any](format.raw/*55.22*/("""
        <div class="alert alert-warning">
            """),_display_(Seq[Any](/*57.14*/message)),format.raw/*57.21*/("""

        </div>
        """)))}/*60.10*/else/*60.14*/{_display_(Seq[Any](format.raw/*60.15*/("""
        <!---- ---->
        """),_display_(Seq[Any](/*62.10*/helper/*62.16*/.form(routes.memberController.actionAnbieterMaske)/*62.66*/ {_display_(Seq[Any](format.raw/*62.68*/("""
        <form>
                <fieldset>
                    <div class="form-group" name="Formular">
                        <div class="input-group">
                            <span id="start" class="input-group-addon">Start</span>
                            <input id="startort" name="startort" type="text"  onchange="getLocationStart()" class="form-control" placeholder="Startort">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Ziel</span>
                            <input id="zielort" name="zielort" type="text" onchange="getLocationZiel()"  class="form-control" placeholder="Zielort">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Mitfahrer</span>
                            <input name="mitfahrer"  type="text" class="form-control" placeholder="Mitfahrer z.B.: 2">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="dd-MM-yyyy">
                            <input class="form-control" name="datum" size="16" type="text" value="" readonly placeholder="Datum">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" /><br/>
                    </div>
                    <div class="form-group">
                        <div class="input-group date form_time" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
                            <input class="form-control" name="uhrzeit" size="16" type="text" value="" readonly placeholder="uhrzeit">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input3" value="" /><br/>
                    </div>
                    <button name="submit" type="submit" class="btn btn-default">MFG veröffentlichen</button>

                </fieldset>
        </form>
                """)))})),format.raw/*103.18*/("""
        """)))})),format.raw/*104.10*/("""

        </div>
    <div class="well center" onload="getLocation()">
        <div id="result"></div>
        <div id="map"></div>
    </div>
</div>


<script type="text/javascript"src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type='text/javascript' src='"""),_display_(Seq[Any](/*115.38*/routes/*115.44*/.Assets.at("js/googleMaps.js"))),format.raw/*115.74*/("""'></script>

""")))})))}
    }
    
    def render(message:String,email:String,user:String,mfg:List[ValideMFG]): play.api.templates.HtmlFormat.Appendable = apply(message,email,user)(mfg)
    
    def f:((String,String,String) => (List[ValideMFG]) => play.api.templates.HtmlFormat.Appendable) = (message,email,user) => (mfg) => apply(message,email,user)(mfg)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 20:06:35 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/mfgAnbieten.scala.html
                    HASH: 77e17f842306c3aab8b49c0451c78d9567273551
                    MATRIX: 810->1|973->70|1009->72|1037->92|1076->94|1471->453|1498->458|1538->462|1564->466|1657->523|1681->538|1720->539|1749->549|1762->553|1801->554|2477->1194|2506->1207|2546->1209|2637->1264|2647->1265|2678->1274|2749->1309|2759->1310|2789->1318|2877->1370|2887->1371|2915->1377|3003->1429|3013->1430|3043->1438|3142->1501|3152->1502|3177->1505|3276->1572|3407->1671|3487->1715|3507->1726|3546->1727|3638->1783|3667->1790|3712->1816|3725->1820|3764->1821|3831->1852|3846->1858|3905->1908|3945->1910|6735->4667|6778->4677|7102->4964|7118->4970|7171->5000
                    LINES: 26->1|29->1|30->2|30->2|30->2|42->14|42->14|42->14|42->14|47->19|47->19|47->19|48->20|48->20|48->20|66->38|66->38|66->38|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|75->47|81->53|83->55|83->55|83->55|85->57|85->57|88->60|88->60|88->60|90->62|90->62|90->62|90->62|131->103|132->104|143->115|143->115|143->115
                    -- GENERATED --
                */
            