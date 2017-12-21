<%--
  Created by IntelliJ IDEA.
  User: HouTianxiang
  Date: 2017/12/19
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/qrcode/qrcode.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            // 二维码对象
            var qrcode;
            // 默认设置
            var content;
            var size;
            // 设置点击事件
            document.getElementById("send").onclick =function(){
                // 获取内容
                content = document.getElementById("content").value;
                content = content.replace(/(^\s*)|(\s*$)/g, "");
                // 获取尺寸
                size = document.getElementById("size").value;
                // 检查内容
                if(content==''){
                    alert('请输入内容！');
                    return false;
                }
                // 检查尺寸
                if(!/^[0-9]*[1-9][0-9]*$/.test(size)){
                    alert('请输入正整数');
                    return false;
                }
                if(size<100 || size>500){
                    alert('尺寸范围在100～500');
                    return false;
                }
                // 清除上一次的二维码
                if(qrcode){
                    qrcode.clear();
                }
                // 创建二维码
                qrcode = new QRCode(document.getElementById("qrcode"), {
                    width : size,//设置宽高
                    height : size
                });
                qrcode.makeCode(document.getElementById("content").value);
            }
        }
    </script>
</head>

<body>
<p>内容：<input type="text" id="content" value="" /></p>
<p>尺寸：<input type="text" id="size" value="150"></p>
<p><button id="send">${title}</button></p>
<div id="qrcode"></div>
<img src="${pageContext.request.contextPath}/img/test.jpg" style="width: 50px;height: 100px">
</body>
</html>
