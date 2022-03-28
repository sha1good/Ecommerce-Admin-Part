/**
 * BootBox is for alert  to confirm or  cancel whether action taken by the user if they want to delete a book.
 */


$(document).ready(function(){
	$('.delete-book').on('click',function(){
		/*<![CDATA[*/
	    var path = /*[[@{/}]]*/'remove';
	    /*]]>*/
	    
		 var id=$(this).attr('id');
		 
		 bootbox.confirm({
			 message:"Are  you sure you want to remove this book? it can't be undone",
			 buttons:{
				  cancel: {
					   label: '<i class="fa fa-times"></i> Cancel'
				  },
				  confirm:{
					  label: '<i class="fa fa-check"></i> Confirm'
				  }
			 },
			  callback: function(confirmed){
				  if(confirmed){
					  $.post(path,{'id': id}, 
							  function(res){
						   location.reload();
					  });
				  }
			  }
		 });
	});

/* var bookIdList= [];
	   
	   #('.checkboxBooks').click(function(){
		    var id =$(this).attr('id');
		    if(this.checked){
		    	bookIdList.push(id);
		    }else{
		    	bookIdList.splice(bookIdList.indexof(id),1);
		    }
	   })*/
	   
	   $('#deleteSelected').click(function(){
		   
		   var idList= $('.checkboxBooks');
		   var bookIdList =[];
		   for(var i=0; i<idList.length; i++){
			   bookIdList.push(idList[i]['id']); 
		   }
		   
		   console.log(bookIdList);
		   
		   /*<![CDATA[*/
		    var path = /*[[@{/}]]*/'removeList';
		    /*]]>*/
		    
			 var id=$(this).attr('id');
			 
			 bootbox.confirm({
				 message:"Are  you sure you want to remove all  selected books? it can't be undone",
				 buttons:{
					  cancel: {
						   label: '<i class="fa fa-times"></i> Cancel'
					  },
					  confirm:{
						  label: '<i class="fa fa-check"></i> Confirm'
					  }
				 },
				  callback: function(confirmed){
					  if(confirmed){
						  $.ajax({
							  type:'POST',
							  url:path,
							  data: JSON.stringify(bookIdList),
							  contentType:"application/json",
							  success: function(res){
							  console.log(res); 
							  location.reload()
							  },
							  error: function(res){
							console.log(res); 
							location.reload();
							  }
						  });
					  }
				  }
			 });
	   });
	   
	   
	   $("#selectAllBooks").click(function(){
		   if($(this).prop("checked")==true){
			  $(".checkboxBooks").prop("checked",true);
		   } else if($(this).prop("checked")==false){
			   $(".checkboxBooks").prop("checked",false);
		   }
	   });
});


  




