
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""
<head>


    <title>"""),_display_(Seq[Any](/*5.13*/title)),format.raw/*5.18*/("""</title>
    <link rel='shortcut icon' type='image/png' href='"""),_display_(Seq[Any](/*6.55*/routes/*6.61*/.Assets.at("images/favicon.png"))),format.raw/*6.93*/("""'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel='stylesheet' media='screen' href='"""),_display_(Seq[Any](/*9.50*/routes/*9.56*/.Assets.at("css/bootstrap.css"))),format.raw/*9.87*/("""'>
    <link rel='stylesheet' media='screen' href='"""),_display_(Seq[Any](/*10.50*/routes/*10.56*/.Assets.at("css/main.css"))),format.raw/*10.82*/("""'>
    <link rel='stylesheet' media='screen' href='"""),_display_(Seq[Any](/*11.50*/routes/*11.56*/.Assets.at("css/main_rwd.css"))),format.raw/*11.86*/("""'>

    <script type='text/javascript' src='"""),_display_(Seq[Any](/*13.42*/routes/*13.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js")))),format.raw/*13.102*/("""'></script>

    <script type="text/javascript" src=""""),_display_(Seq[Any](/*15.42*/routes/*15.48*/.MessageController.javascriptRoutes)),format.raw/*15.83*/(""""></script>
</head>
<body>

    <div id="wrapper">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="/"><img src='"""),_display_(Seq[Any](/*22.61*/routes/*22.67*/.Assets.at("images/Logo_klein.png"))),format.raw/*22.102*/("""' /></a>
                <button id="navRWD" type="button" class="btn btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="#">Über Uns</a></li>
                    <li><a href="#">Impressum</a></li>
                </ul>
                <div class="loginPanel">
                   <a href="/anmelden"> <span class="btn btn-large btn-success">Anmelden</span></a>
                </div>

            </div>
        </nav>

        <div class="container rwdContainer">
            """),_display_(Seq[Any](/*44.14*/content)),format.raw/*44.21*/("""
        </div>

        <div id="footerSection">
            <div class="container rwdContainer">
                <div class="pull-left">
                    <div class="span3">
                        <h5>Rechtliches</h5>
                        <ul>
                            <li><a href="#">Impressum</a></li>
                            <li><a href="#">Kontakt</a></li>
                            <li><a href="#">AGB's</a></li>
                        </ul>
                    </div>
                </div>
                <div id="logoMFG" class="span3 pull-right">
                    Copyright © 2001-2014
                    <img src='"""),_display_(Seq[Any](/*61.32*/routes/*61.38*/.Assets.at("images/Logo_grau.png"))),format.raw/*61.72*/("""' />
                </div>
            </div>
    
        </div>
    </div>

    <script type='text/javascript' src='"""),_display_(Seq[Any](/*68.42*/routes/*68.48*/.Assets.at("js/bootstrap.min.js"))),format.raw/*68.81*/("""'></script>
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*69.42*/routes/*69.48*/.Assets.at("js/menu.js"))),format.raw/*69.72*/("""'></script>
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*70.42*/routes/*70.48*/.Assets.at("js/bootstrap-datetimepicker.min.js"))),format.raw/*70.96*/("""'></script>
    <script type='text/javascript' src='"""),_display_(Seq[Any](/*71.42*/routes/*71.48*/.Assets.at("js/locales/bootstrap-datetimepicker.de.js"))),format.raw/*71.103*/("""'></script>

</body>
</html>"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jan 22 20:32:21 CET 2014
                    SOURCE: D:/Workspace_WebTec/app/views/main.scala.html
                    HASH: f035c507c4009a535c5391025250e73e5d2ec8d3
                    MATRIX: 778->1|902->31|959->53|985->58|1083->121|1097->127|1150->159|1313->287|1327->293|1379->324|1467->376|1482->382|1530->408|1618->460|1633->466|1685->496|1766->541|1781->547|1858->601|1948->655|1963->661|2020->696|2269->909|2284->915|2342->950|3289->1861|3318->1868|4003->2517|4018->2523|4074->2557|4230->2677|4245->2683|4300->2716|4389->2769|4404->2775|4450->2799|4539->2852|4554->2858|4624->2906|4713->2959|4728->2965|4806->3020
                    LINES: 26->1|29->1|33->5|33->5|34->6|34->6|34->6|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|41->13|41->13|41->13|43->15|43->15|43->15|50->22|50->22|50->22|72->44|72->44|89->61|89->61|89->61|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71
                    -- GENERATED --
                */
            