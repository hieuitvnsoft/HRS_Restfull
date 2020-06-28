

<%-- 
    Document   : home
    Created on : Jul 18, 2019, 3:09:30 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>HRS Admin | Dashboard</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="/HRS/Views/Admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="/HRS/Views/Admin/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="/HRS/Views/Admin/bower_components/Ionicons/css/ionicons.min.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="/HRS/Views/Admin/bower_components/jvectormap/jquery-jvectormap.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/HRS/Views/Admin/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="/HRS/Views/Admin/dist/css/skins/_all-skins.min.css">

        <script src="/HRS/Views/Admin/ckeditor/ckeditor.js" charset="utf-8" type="text/javascript"></script>
        <script src="/HRS/Views/Admin/ckeditor/adapters/jquery.js" type="text/javascript"></script>
        <script src="/HRS/Views/Admin/ckfinder/ckfinder.js" type="text/javascript"></script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="header_menu.jsp" flush="true"/>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <!--Bodyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy-->
                <section class="content-header">
                    <h1>
                        Dashboard
                        <small>Version 2.0</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Product</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Info boxes -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-header">
                                Thêm mới chi tiết sản phẩm
                            </div>
                            <div>   
                                <spring:form action="${pageContext.request.contextPath}/Admin/InsertProductDetails.htm" method="post" modelAttribute="productDetail" enctype="multipart/form-data">
                                    <table id="product" class="table table-striped table-bordered" cellspacing="0" width="100%">

                                        <tbody>

                                            <tr>
                                                <td>Ảnh chi tiết</td>
                                                <td>
                                                    <spring:input type="file"  path="imgProduct"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Màu sắc</td>
                                                <td>
                                                    <spring:select path="colorId.id">
                                                        <spring:option value="-1">Chọn màu</spring:option>
                                                        <c:forEach items="${listColor}" var="cl">
                                            <option label="${cl.colorName}" value="${cl.id}" style="background: ${cl.colorCode}"/>
                                                        </c:forEach>
                                                      <!--  <spring:options items="${listColor}" itemLabel="colorName" itemValue="id"  cssStyle="background: ${listColor[1].colorCode}"
                                                                        
                                                                        />                                                       -->
                                                    </spring:select>
                                                          
                                                        
                                                       
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Danh mục</td>
                                                <td>
                                                    <spring:select path="sizeId.id">
                                                        <spring:option value="-1">Chọn size</spring:option>
                                                        <spring:options items="${listSize}" itemLabel="size" itemValue="id"/>                                                       
                                                    </spring:select>

                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Giá nhập</td>
                                                <td>
                                                    <spring:input type="number" min="0" path="priceNew"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Số lượng</td>
                                                <td>
                                                 <spring:input type="number" min="0" path="quantity"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Mã sản phẩm</td>
                                                <td>
                                                    <spring:input type="number" path="productId.productId" readonly="true" />
                                                </td>
                                            </tr>
                                           

                                            <tr>
                                                <td class="text-center" colspan="2">
                                                    <button type="submit">Thêm mới</button>

                                                </td>
                                            </tr>

                                        </tbody>
                                    </table>  
                                </spring:form>
                                <div>
                                    <a  href="${pageContext.request.contextPath}/Admin/ListProductDetail.htm" value="">Về trang danh sách</a>
                                </div>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->


                        <!-- /.row -->

                        <!-- Main row -->

                        <!-- /.row -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->



            <!-- Control Sidebar -->

            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <jsp:include page="footer.jsp" flush="true"/>

        </div>
        <!-- ./wrapper -->

        <!-- jQuery 3 -->
        <script src="/HRS/Views/Admin/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="/HRS/Views/Admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="/HRS/Views/Admin/bower_components/fastclick/lib/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="/HRS/Views/Admin/dist/js/adminlte.min.js"></script>
        <!-- Sparkline -->
        <script src="/HRS/Views/Admin/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
        <!-- jvectormap  -->
        <script src="/HRS/Views/Admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="/HRS/Views/Admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- SlimScroll -->
        <script src="/HRS/Views/Admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <!-- ChartJS -->
        <script src="/HRS/Views/Admin/bower_components/chart.js/Chart.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="/HRS/Views/Admin/dist/js/pages/dashboard2.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="/HRS/Views/Admin/dist/js/demo.js"></script>
        <script type="text/javascript">

            var editor = CKEDITOR.replace('description');

            CKFinder.setupCKEditor(editor, 'Admin/ckfinder/');



        </script>    
    </body>
</html>

