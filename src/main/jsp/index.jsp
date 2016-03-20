<link rel="stylesheet" type="text/css" href="css/smo_slider.css">
<main id="main-content" role="main">
    <form id="app-search" action="/search" method="get" role="search">
        <input type="search" placeholder="ゲームを検索" name="q" autocomplete="off">
    </form>
    <div class="main-panel smo-slider">
        <ul>
            <li>
                <a href="./app/gametitle">
                    <img src="http://placehold.it/640x360" alt="gametitle">
                    <div class="gametitle">
                        gametitle
                    </div>
                    <div class="price">
                        \price
                    </div>
                </a>
            </li>
            <li>
                <a href="./app/gametitle">
                    <img src="http://placehold.it/640x360" alt="gametitle">
                    <div class="gametitle">
                        gametitle
                    </div>
                    <div class="price">
                        \price
                    </div>
                </a>
            </li>
            <li>
                <a href="./app/gametitle">
                    <img src="http://placehold.it/640x360" alt="gametitle">
                    <div class="gametitle">
                        gametitle
                    </div>
                    <div class="price">
                        \price
                    </div>
                </a>
            </li>
        </ul>
    </div>

    <div class="under-panel">
        <div class="under-column">
            人気のゲーム
            <ul>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="under-column">
            新規ゲーム
            <ul>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="under-column">
            もうすぐ発売
            <ul>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
                <li>
                    <a href="./app/gametitle">
                        <img src="http://placehold.it/96x54" alt="gametitle">
                        <div class="gametitle">
                            gametitle
                        </div>
                        <div class="price">
                            \price
                        </div>
                    </a>
                </li>
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