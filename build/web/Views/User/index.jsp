<%-- 
    Document   : index
    Created on : Jul 18, 2019, 11:45:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html class="no-js" lang="en">
    
<!-- Mirrored from demo.devitems.com/bege-v4/bege/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 17 Jul 2019 15:49:18 GMT -->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>HieuRinShop || Home</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Favicon -->
        <jsp:include page="css.jsp" flush="true"/>
    </head>
    <body>
        <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

        <!-- Add your site or application content here -->

        <!-- Body main wrapper start -->
        <div class="wrapper home-one">
            <!-- HEADER AREA START -->
            <jsp:include page="header.jsp" flush="true"/>
            <!-- HRADER AREA END -->
            <!-- Slider area -->
            <jsp:include page="sidebar.jsp" flush="true"/>
            <!-- Slider area end -->
            <!-- Policy area -->
            <div class="policy-area">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="policy-area-inner">
                                <div class="single-policy-area">
                                    <div class="single-policy">
                                        <div class="icon"><i class="icon ion-android-sync"></i></div>
                                        <h3>Free Return</h3>
                                        <p>30 days money back guarantee!</p>
                                    </div>
                                </div>
                                <div class="single-policy-area">
                                    <div class="single-policy">
                                        <div class="icon"><i class="icon ion-paper-airplane"></i></div>
                                        <h3>Free Shipping</h3>
                                        <p>Free shipping on all order</p>
                                    </div>
                                </div>
                                <div class="single-policy-area">
                                    <div class="single-policy">
                                        <div class="icon"><i class="icon ion-help-buoy"></i></div>
                                        <h3>Support 24/7</h3>
                                        <p>We support online 24 hrs a day</p>
                                    </div>
                                </div>
                                <div class="single-policy-area">
                                    <div class="single-policy">
                                        <div class="icon"><i class="icon ion-card"></i></div>
                                        <h3>Receive Gift Card</h3>
                                        <p>Recieve gift all over oder $50</p>
                                    </div>
                                </div>
                                <div class="single-policy-area">
                                    <div class="single-policy">
                                        <div class="icon"><i class="icon ion-ios-locked"></i></div>
                                        <h3>Secure Payment</h3>
                                        <p>We Value Your Security</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>   
            <!-- Policy area end -->
            <!-- Deals Of The Day -->
            
            <!-- Brand logo area end -->
            
            <!-- QUICKVIEW PRODUCT START -->
            <jsp:include page="footer.jsp" flush="true"/>
            <!-- QUICKVIEW PRODUCT END -->
        </div>
        <!-- Body main wrapper end -->


       
    </body>
 <jsp:include page="js.jsp" flush="true" />

</html>
