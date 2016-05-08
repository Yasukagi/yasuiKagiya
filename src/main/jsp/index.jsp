<link rel="stylesheet" type="text/css" href="css/smo_slider.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<main id="main-content" role="main">
    <div class="main-panel smo-slider">
        <ul>
            <%--出力形式サンプル - メインパネル--%>
            <%--<li>--%>
                <%--<a href="./app/gametitle">--%>
                    <%--<img src="http://placehold.it/640x360" alt="gametitle">--%>
                    <%--<div class="gametitle">--%>
                        <%--gametitle--%>
                    <%--</div>--%>
                    <%--<div class="price">--%>
                        <%--\price--%>
                    <%--</div>--%>
                <%--</a>--%>
            <%--</li>--%>
                <jsp:include page="/mainpanel" flush="true"/>
        </ul>
    </div>

    <div class="under-panel">
        <div class="under-column">
            人気のゲーム
            <ul>
                <%--出力形式サンプル - アンダーパネル--%>
                <%--<li>--%>
                    <%--<a href="./app/gametitle">--%>
                        <%--<img src="http://placehold.it/96x54" alt="gametitle">--%>
                        <%--<div>--%>
                            <%--<div class="gametitle">--%>
                                <%--gametitle--%>
                            <%--</div>--%>
                            <%--<div class="price">--%>
                                <%--\price--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                    <%--<%--%>
                        <%--request.getRequestDispatcher("popular-panel").include(request, response);--%>
                    <%--%>--%>
            </ul>
        </div>
        <div class="under-column">
            新規ゲーム
            <ul>
                <%--出力形式サンプル - アンダーパネル--%>
                <%--<li>--%>
                    <%--<a href="./app/gametitle">--%>
                        <%--<img src="http://placehold.it/96x54" alt="gametitle">--%>
                        <%--<div>--%>
                            <%--<div class="gametitle">--%>
                                <%--gametitle--%>
                            <%--</div>--%>
                            <%--<div class="price">--%>
                                <%--\price--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                    <%--<%--%>
                        <%--request.getRequestDispatcher("new-panel").include(request, response);--%>
                    <%--%>--%>
            </ul>
        </div>
        <div class="under-column">
            もうすぐ発売
            <ul>
                <%--出力形式サンプル - アンダーパネル--%>
                <%--<li>--%>
                    <%--<a href="./app/gametitle">--%>
                        <%--<img src="http://placehold.it/96x54" alt="gametitle">--%>
                        <%--<div>--%>
                            <%--<div class="gametitle">--%>
                                <%--gametitle--%>
                            <%--</div>--%>
                            <%--<div class="price">--%>
                                <%--\price--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                    <%--<%--%>
                        <%--request.getRequestDispatcher("onsale-panel").include(request, response);--%>
                    <%--%>--%>
            </ul>
        </div>
    </div>
</main>
<script type="text/javascript" src="./js/modernizr-custom.js"></script>
<script type="text/javascript" src="./js/jquery.smo_slider.js"></script>
<script>
    $(function() {
        $(".smo-slider").smoSlider();
    });
</script>
