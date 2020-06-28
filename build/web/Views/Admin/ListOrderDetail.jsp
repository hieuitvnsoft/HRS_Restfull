

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <li class="active">OrderDetail</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Info boxes -->
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-header">
                                Chi tiết đơn hàng
                            </div>
                            <div>
                                <!--Tìm kiếm mã đơn hàng: <input type="text" width="300dp"/>--> 
                                <span style="color:#FFF001">${mesage}</span>
                            </div>
                            <div> 
                                <table id="product" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>

                                            <th>STT</th>
                                            <th>Mã sản phẩm</th>
                                            <th>Tên sản phẩm</th> 
                                            <th>Số lượng</th>
                                            <th>Giá sản phẩm lúc đặt</th>
                                            <th>Tổng tiền</th>
                                            <th>Trạng thái</th>
                                            <th></th>
                                        </tr>
                                    </thead>

                                    <tbody>


                                        <c:forEach items="${listOrderDetail}" var="orderdetail" varStatus="loop">
                                            <tr>

                                                <td>${loop.index + 1}</td>
                                                <td>${orderdetail.productId.id}  </td>

                                                <td>
                                                    <img width="100px" src="/${orderdetail.productId.imgProduct}"/>

                                                    ${orderdetail.productName}</td>

                                                <td>${orderdetail.quantity}</td>
                                                <td>
                                                    <fmt:setLocale value = "vi_VN"></fmt:setLocale>

                                                    <fmt:formatNumber currencyCode="vi_VN" value = "${orderdetail.priceProductOrder}"></fmt:formatNumber> vnđ
                                                    </td>
                                                    <td>
                                                    <fmt:setLocale value = "vi_VN"></fmt:setLocale>

                                                    <fmt:formatNumber currencyCode="vi_VN" value = "${orderdetail.amount}" ></fmt:formatNumber> vnđ

                                                    </td>

                                                <c:if test="${orderdetail.status == 0}">
                                                    <td>
                                                        Hủy
                                                    </td>
                                                </c:if>
                                                <c:if test="${orderdetail.status == 1}">
                                                    <td>
                                                        Đặt
                                                    </td>
                                                </c:if>


                                                <td>
                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                        <a class="blue" href="viewProductDetail.htm?Id=${orderdetail.productId.id}">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                        </a>
                                                    </div>


                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <spring:form action="${pageContext.request.contextPath}/Admin/updateOrder.htm" commandName="order" method="post" modelAttribute="order" enctype="multipart/form-data">
                                            <tr class="hidden">
                                                <td class="hidden" colspan="8">Id <spring:input path="orderId"/></td>
                                            </tr>
                                            <tr><td colspan="2">Tổng tiền thanh toán: </td>
                                                <td colspan="6">
                                                    <fmt:formatNumber currencyCode="vi_VN" value="${order.totalAmountOrder}"></fmt:formatNumber> vnđ
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="8">
                                                        Trạng thái:  <spring:select path="status" name="status">
                                                        <spring:option value="0">Hủy đơn hàng</spring:option>
                                                        <spring:option value="1">Chờ xử lý</spring:option>
                                                        <spring:option value="2">Chấp nhận đơn hàng</spring:option>
                                                        <spring:option value="3">Đã thanh toán - giao hàng</spring:option>
                                                        <spring:option value="4">Đổi trả</spring:option>
                                                    </spring:select>
                                                </td>
                                            </tr> 
                                            <tr><td colspan="8"><button type="submit" class="btn btn-primary">Cập nhật</button></td></tr>
                                        </spring:form>
                                    </tbody>
                                </table>  



                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                        <!-- Main row -->

                        <!-- /.row -->
                    </div>
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
    </body>
</html>
