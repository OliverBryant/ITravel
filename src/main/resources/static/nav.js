var contar = document.getElementById("contar");
var Nav1 = document.getElementById("nav1");
var Nav2 = document.getElementById("nav2");
var Nav3 = document.getElementById("nav3");

var html1 = `<div class="attrection" >
            <table>
                <thead>
                    <tr>
                        <th>名称</th>
                        <th>地址</th>
                        <th>开放时间</th>
                        <th>结束时间</th>
                        <th>介绍</th>
                    </tr>
                </thead>
                <tbody>
                    <tr th:each="command:#{'tourist'}">
                        <td th:utext="#{'command.tourist.touristAttractionname'}">名称</td>
                        <td th:utext="#{'command.tourist.adderss'}">地址</td>
                        <td th:utext="#{'command.tourist.openingTime'}">开始时间</td>
                        <td th:utext="#{'command.tourist.closeTime'}">结束时间</td>
                        <td th:utext="#{'command.tourist.introduction'}">介绍</td>
                    </tr>
                </tbody>
                
            </table>
        </div>`;
var html2 = `<div class="attrection">
        <table>
            <thead>
                <tr>
                    <th>景点</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>种类</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="tic:${'ticket'}">
                    <td th:text="${'tic.name'}">名称</td>
                    <td th:text="${'tic.price'}">价格</td>
                    <td th:text="${'tic.number'}">数量</td>
                    <td th:text="${'tic.kind'}">种类</td>
                </tr>
            </tbody>
            
        </table>
    </div>`;

var html3 = `<div class="attrection">
    <table>
        <thead>
            <tr>
                <th>地区</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="adds:${'address'}">
                <td th:text="${'adds.name'}">名称</td>
            </tr>
        </tbody>
        
    </table>
</div>`;
Nav1.onclick = function() {
    contar.innerHTML = html1;
    console.log("点击1");
}
Nav2.onclick = function() {
    contar.innerHTML = html2;
    console.log("点击2");
}
Nav3.onclick = function() {
    contar.innerHTML = html3;
    console.log("点击3");
}