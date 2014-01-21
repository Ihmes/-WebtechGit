         var latstart;
	     var lngstart;
	     var latziel;
	     var lngziel;




        function getLocationStart(){

            var startort = document.getElementById('startort').value;
            startort = startort+', de';
            var geocoder =  new google.maps.Geocoder();
            geocoder.geocode( { 'address': startort}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                latstart = results[0].geometry.location.lat();
                lngstart = results[0].geometry.location.lng();
                myRouter.init('map');
              } else {
                alert("Something got wrong " + status);
              }
            });
        }

         function getLocationZiel(){

            var zielort = document.getElementById('zielort').value;
            zielort = zielort+', de';
            var geocoder =  new google.maps.Geocoder();
            geocoder.geocode( { 'address': zielort}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                latziel = results[0].geometry.location.lat();
                lngziel = results[0].geometry.location.lng();
                myRouter.init('map');
              } else {
                alert("Something got wrong " + status);
              }
            });
        }

        var myRouter = {
            map_: null,
            directionsHelper_: null,

            stores: [
                   // Später für zwischen Stops!
                   // {name: "store1", location: new google.maps.LatLng(50.82788, 3.76499)},
                   // {name: "store2", location: new google.maps.LatLng(51.02788, 3.9)}
                ],

            calcRoute: function() {

                var waypts = [];

                for (var i in this.stores) {
                    waypts.push({
                        location: this.stores[i].location,
                        stopover:true
                    });
                }
                var request = {
                    origin: new google.maps.LatLng(latstart, lngstart),
                    destination: new google.maps.LatLng(latziel, lngziel),
                    waypoints: waypts,
                    optimizeWaypoints: true,
                    travelMode: google.maps.DirectionsTravelMode.DRIVING
                };

                var _SELF = this;
                this.directionsHelper_.route(request, function(response, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        _SELF.directionsDisplay_.setDirections(response);
                        return;
                    }
                    console.log('Directions Status: ' + status);
                });
            },

            init: function(mapid) {

                this.directionsHelper_ = new google.maps.DirectionsService();
                this.directionsDisplay_ = new google.maps.DirectionsRenderer();

                var center = new google.maps.LatLng(latstart, lngstart);
                var myOptions = {
                    zoom:7,
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    center: center
                }
                this.map_ = new google.maps.Map(document.getElementById(mapid), myOptions);
                this.directionsDisplay_.setMap(this.map_);

                this.calcRoute();
            }
        };



                /***
                *       Aktuelle Position bestimmen
                *
                **/

                function getLocation() {

                    if (navigator.geolocation) {
                        // Funktion showPosition aufrufen, wenn Geolocation verfügbar
                     navigator.geolocation.getCurrentPosition(showPosition);

                    } else {
                       myRouter.init('map');
                       document.getElementById('result').innerHTML = "Ihr Browser unterstützt leider die Geolocation-Funktion nicht!";
                    }
                }

                function showPosition(position) {
                    latstart = position.coords.latitude;
                    lngstart = position.coords.longitude;
                    myRouter.init('map');
               }

