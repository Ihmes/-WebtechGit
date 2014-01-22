    $(document).ready(

       $('#navRWD').click(function(){
           if($('#bs-example-navbar-collapse-9').hasClass( "navActiv" ))
               {
                    $('#bs-example-navbar-collapse-9').css('display', 'none');
                    $('#bs-example-navbar-collapse-9').removeClass('navActiv');
               }else{
                    $('#bs-example-navbar-collapse-9').css('display', 'block');
                    $('#bs-example-navbar-collapse-9').addClass('navActiv');
               }
           })
    );

   $(function(){
       $("#myCarousel").carousel();
   });

   $(document).ready(

          $('#editProfil').click(function(){
              if($('.profil').hasClass( "navActiv" ))
                  {
                       $('.profil').css('display', 'none');
                       $('.profil').removeClass('navActiv');

                       $('.profilform').css('display', 'block');
                       $('.profilform').addClass('navActiv');


                  }else{
                       $('.profil').css('display', 'block');
                       $('.profil').addClass('navActiv');

                       $('.profilform').css('display', 'none');
                       $('.profilform').removeClass('navActiv');
                  }
              })
       );




   $(function(){
        $('.form_date').datetimepicker({
            format: 'dd-MM-yyyy',
            language:  'de',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    });

    $(function(){
    	$('.form_time').datetimepicker({
            language:  'de',
            weekStart: 1,
            todayBtn:  1,
    		autoclose: 1,
    		todayHighlight: 1,
    		startView: 1,
    		minView: 0,
    		maxView: 1,
    		forceParse: 0
        });
    });