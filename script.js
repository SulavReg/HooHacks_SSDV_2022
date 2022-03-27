function initMap() {
  var userPos = new google.maps.LatLng(50.4501, 30.5234);
  
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function (position) { userPos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    map.setCenter(userPos);
    });
  }
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: userPos
  });

  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function (position) { userPos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    map.setCenter(userPos);
    });
  }
  map.setZoom(16);

  /*
  var marker = new google.maps.Marker({
    position: userPos,
    map: map
  });
  */
  
  map.addListener('click', function(event) {
    // 3 seconds after the center of the map has changed, pan back to the
    // marker.
    var latitude = event.latLng.lat();
    var longitude = event.latLng.lng();

    myLatlng = {lat: latitude, lng: longitude};
    if (getDistanceFromLatLonInKm(userPos.lat(),userPos.lng(),latitude,longitude) <= 5) {
      new google.maps.Marker({
      position: myLatlng,
      map: map
	  })
    }
  });
}

function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
  //https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km
  return d;
}

function deg2rad(deg) {
  return deg * (Math.PI/180)
}