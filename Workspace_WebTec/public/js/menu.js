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