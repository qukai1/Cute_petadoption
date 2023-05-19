$(function(){
				// 设置切换按钮的响应事件
				$(".ite1").click(function(){
					$(this).css({
                      "background-color": "#aa0000",
                       "opacity": "0.9"
					   });
					$(".ite2").css({
                      "background-color": "#ff0000",
                       "opacity": "1"
					   });
					$(".ite3").css({
                      "background-color": "#ff0000",
                       "opacity": "1"
					   });
					$(".body_top").css("display","block");
					$(".body_center").css("display","none");
					$(".body_buttom").css("display","none");
				})
				$(".ite2").click(function(){
					$(this).css({
					  "background-color": "#aa0000",
					   "opacity": "0.9"
					   });
					$(".ite1").css({
					  "background-color": "#ff0000",
					   "opacity": "1"
					   });
					$(".ite3").css({
					  "background-color": "#ff0000",
					   "opacity": "1"
					   });
					$(".body_center").css("display","block");
					$(".body_top").css("display","none");
					$(".body_buttom").css("display","none");
				})
				$(".ite3").click(function(){
					$(this).css({
					  "background-color": "#aa0000",
					   "opacity": "0.9"
					   });
					$(".ite2").css({
					  "background-color": "#ff0000",
					   "opacity": "1"
					   });
					$(".ite1").css({
					  "background-color": "#ff0000",
					   "opacity": "1"
					   });
					$(".body_buttom").css("display","block");
					$(".body_center").css("display","none");
					$(".body_top").css("display","none");
				})
				
				});