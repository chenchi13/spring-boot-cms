$(document).ready(function () {	
			// Post functions:
			$('.addNewPostButton').on('click', function() {
				var pageId = $(this).attr('data-page-id');
				window.location = '/addNewPost/' + pageId;
			});	
	
	        $('.editPostButton').on('click', function () {
	        	 var postId = $(this).attr('data-post-id');
	             window.location = '/editPost/' + postId;
	        });	    
	        
	        $('.deletePostButton').on('click', function () {
	        	 var postId = $(this).attr('data-post-id');	
	        	 var pageId = $('.addNewPostButton').attr('data-page-id');	 

	             $.ajax({
	            	    type : "DELETE",
	            	    url : "/deletePost/" + postId,
	            	    success: function (result) {   
	            	    	console.log(result);  
	            	    	if(pageId === undefined)
	            	    	{
	            	    		window.location = '/allPosts'; 
	            	    	}
	            	    	else{
	            	    		window.location = '/index/' + pageId; 
	            	    	}            
	            	    },
	            	    error: function (e) {
	            	        console.log(e);
	            	    }
	            	});
	        });	 
	        
	        // Menu functions:
	        $('.menuItemLink').on('click', function () {
	        	 var pageId =$(this).attr('data-page-id');
	             window.location = '/index/' + pageId;
	        });	 
	        
	        $('.editItemButton').on('click', function () {
	        	 var itemId = $(this).attr('data-item-id');
	             window.location = '/editItem/' + itemId;
	        });	 
	        
	        $('.deleteItemButton').on('click', function () {
	        	 var itemId = $(this).attr('data-item-id');	

	             $.ajax({
	            	    type : "DELETE",
	            	    url : "/deleteItem/" + itemId,
	            	    success: function (result) {   
	            	    	console.log(result);  
	            	    	window.location = '/allMenuItems';           
	            	    },
	            	    error: function (e) {
	            	        console.log(e);
	            	    }
	            	});
	        });	
	        
	        // Submenu functions:
	        
	        $('.editSubItemButton').on('click', function () {
	        	 var itemId = $(this).attr('data-item-id');
	             window.location = '/editSubItem/' + itemId;
	        });	 
	        
	        $('.deleteSubItemButton').on('click', function () {
	        	 var itemId = $(this).attr('data-item-id');	

	             $.ajax({
	            	    type : "DELETE",
	            	    url : "/deleteSubItem/" + itemId,
	            	    success: function (result) {   
	            	    	console.log(result);  
	            	    	window.location = '/allSubmenuItems';           
	            	    },
	            	    error: function (e) {
	            	        console.log(e);
	            	    }
	            	});
	        });	
	        
	        // Page functions:
	        $('.editPageButton').on('click', function () {
	        	 var pageId = $(this).attr('data-page-id');
	             window.location = '/editPage/' + pageId;
	        });	  
	        
	        $('.deletePageButton').on('click', function () {
	        	 var pageId = $(this).attr('data-page-id');	

	             $.ajax({
	            	    type : "DELETE",
	            	    url : "/deletePage/" + pageId,
	            	    success: function (result) {   
	            	    	console.log(result);  
	            	    	window.location = '/allPages';           
	            	    },
	            	    error: function (e) {
	            	        console.log(e);
	            	    }
	            	});
	        });	
		});