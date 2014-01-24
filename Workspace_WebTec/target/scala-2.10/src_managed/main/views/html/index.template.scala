
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Willkommen auf MFG")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""


        <div id="myCarousel" class="carousel slide">
            <!-- Carousel indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- Carousel items -->
            <div class="carousel-inner">
                <div class="active item"><img src='"""),_display_(Seq[Any](/*15.53*/routes/*15.59*/.Assets.at("images/Silder1.jpeg"))),format.raw/*15.92*/("""' /></div>
                <div class="item"><img src='"""),_display_(Seq[Any](/*16.46*/routes/*16.52*/.Assets.at("images/Silder2.jpg"))),format.raw/*16.84*/("""' /></div>
                <div class="item"><img src='"""),_display_(Seq[Any](/*17.46*/routes/*17.52*/.Assets.at("images/Silder3.jpg"))),format.raw/*17.84*/("""' /></div>
            </div>
            <!-- Carousel nav -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
        </div>

        <script type="text/javascript">
        $(function()"""),format.raw/*25.21*/("""{"""),format.raw/*25.22*/("""
             $("#myCarousel").carousel();
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/(""");
        </script>


    <div class="well center">

        <h1>Willkommen auf MFG </h1>
        <hr>
        <p>
        """),_display_(Seq[Any](/*36.10*/if(message)/*36.21*/{_display_(Seq[Any](format.raw/*36.22*/("""
        <div class="alert alert-success">
            """),_display_(Seq[Any](/*38.14*/message)),format.raw/*38.21*/("""
        </div>
        """)))})),format.raw/*40.10*/("""

        </p>
        <a href="/registrierung"><button type="button" class="btn btn-primary btn-lg">Jetzt registrieren!</button>
    </div>

""")))})),format.raw/*46.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jan 22 21:40:54 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/index.scala.html
                    HASH: eebab8e7e83386043a95f7821856c9d38715b4d2
                    MATRIX: 774->1|885->18|922->21|956->47|995->49|1545->563|1560->569|1615->602|1707->658|1722->664|1776->696|1868->752|1883->758|1937->790|2296->1121|2325->1122|2403->1173|2432->1174|2593->1299|2613->1310|2652->1311|2744->1367|2773->1374|2830->1399|3004->1542
                    LINES: 26->1|29->1|31->3|31->3|31->3|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|53->25|53->25|55->27|55->27|64->36|64->36|64->36|66->38|66->38|68->40|74->46
                    -- GENERATED --
                */
            