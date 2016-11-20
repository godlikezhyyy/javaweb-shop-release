<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<script type="text/javascript">
   		var start=10;
   		var speed=10;
   		window.onload=function(){
   			setInterval("move()", 300);
   		};
   		function move(){
   			document.getElementById("rtn").style.left=start+speed;
   			start=start+speed;
   			if(start > 900){
   				start=10;
   			}
   		}
   	</script>
  </head>
  
  <body>
   <h1>对不起，出了点故障</h1>
   <a id="rtn" href="/" style="margin-top:10px;left:10px;position:absolute;text-decoration: none;font-size:1.5em">点我返回哦！！！</a>
  </body>
</html>
