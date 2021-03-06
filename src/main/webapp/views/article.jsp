<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://7oxg65.com1.z0.glb.clouddn.com/static/img/favicon.png">

    <title>${article.title} —— 还撸么 宅生活</title>

    <!-- Bootstrap core CSS -->
    <link href="http://7oxg65.com1.z0.glb.clouddn.com/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://7oxg65.com1.z0.glb.clouddn.com/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://7oxg65.com1.z0.glb.clouddn.com/static/css/style.css" rel="stylesheet">
    <link href="http://7oxg65.com1.z0.glb.clouddn.com/static/css/responsive.css" rel="stylesheet">
    <link href="http://7oxg65.com1.z0.glb.clouddn.com/static/app/css/article.css" rel="stylesheet">
</head>
<body>
<c:import url="header.jsp"></c:import>

<!-- begin:content -->
<section id="content">
<div class="container">
<div class="row">
<!-- begin:article -->
<div class="col-md-8 col-sm-8">
    <div class="row">
        <div class="col-md-12 post-single">
            <div class="heading-title">
                <h2><a href="javascript:;">${article.title}</a></h2>
            </div>
            <div class="post-meta">
                <span><em><a href="javascript:;">${article.authorName}</a> 发表</em></span>
                <span><em>编辑于 <s:formatDate value="${article.addTime}" type="date" /></em></span>
            </div>
            <div>
                ${article.content}
            </div>
        </div>
    </div>

    <hr>

</div>
<!-- end:article -->

</div>
</div>
</section>
<!-- end:content -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="/static/js/html5shiv.js"></script>
<script src="/static/js/respond.min.js"></script>
<![endif]-->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/jquery.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/bootstrap.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/masonry.pkgd.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/imagesloaded.pkgd.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/gmap3.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/jquery.isotope.min.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/jquery.easing.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/js/script.js"></script>
<script src="http://7oxg65.com1.z0.glb.clouddn.com/static/app/js/header.js"></script>

<script>
    <c:if test="${article.image.url != null}">
    var image = "${article.image.url}";
    document.getElementById("header").style.backgroundImage = "url("+image+")";
    </c:if>
</script>
</body>
</html>