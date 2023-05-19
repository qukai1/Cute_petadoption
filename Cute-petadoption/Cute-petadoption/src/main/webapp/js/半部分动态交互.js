			//返回首页
			red =function (){
				document.location="ShowAll_index";
			}
			Li = function (id) {
				 if(id!=""){
					 document.location="UserAddPute_pet.jsp?id="+id;
				 }else{
		        	  alert("请先登录");
		        	  document.location="loginandregistration.jsp";
		          }
			}
			//用户的点击全网查询调用百度搜索
			baidu = function () {
				alert(document.getElementsByName("suosi")[0].value);
				document.location="https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=15007414_13_dg&wd="+document.getElementsByName("suosi")[0].value+"&fenlei=256&rsv_pq=0xe660c919000659ad&rsv_t=7d26fGcpbK2NGyEg%2FtuZRt5uFBcrHsp7qUXoTywSYkWi%2F9q76woR8dx92eMF&rqlang=en&rsv_dl=ih_0&rsv_enter=1&rsv_sug3=2&rsv_sug1=2&rsv_sug7=001&rsv_sug2=1&rsv_btype=i&rsp=0&rsv_sug9=es_2_1&rsv_sug4=1858&rsv_sug=9"
			}
			//用户点击个人信息查看页面
			elname = function (name) {
	          if(name!=""){
	        	  document.location="User_detailed_information?name="+name;
	          }else{
	        	  alert("请先登录");
	        	  document.location="loginandregistration.jsp";
	          }
	    	}	
			//用户推出登录
			tui = function () {
				 if(confirm("你确定退出登录嘛！")){
		        	  document.location="tuichu";
		          }
		    	}	
			//用户点击宠物查看详细
			pute_detalis = function (id){
				if(id!=""){
		        document.location="Pet_detalis?id="+id+":"+"pute";
		         }
			}
			team_detalis = function (id){
				if(id!=""){
			        document.location="Pet_detalis?id="+id+":"+"team";
			         }
			}
			admin_detalis = function (id){
				if(id!=""){
			        document.location="Pet_detalis?id="+id+":"+"admin";
			         }
			}