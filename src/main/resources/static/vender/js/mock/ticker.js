$(() => {

    let tickerSocket = new WebSocket("wss://api.upbit.com/websocket/v1");
    tickerSocket.binaryType = 'arraybuffer';

    let ioData = JSON.stringify([{"ticket": "testasdasd"}, {"type": "ticker", "codes": markets}]);

    tickerSocket.onopen = ((e) => {
        tickerSocket.send(ioData);
    });

    tickerSocket.onclose = (() => {
    });

    tickerSocket.onmessage = ((data) => {
        let enc = new TextDecoder("utf-8");
        let arr = new Uint8Array(data.data);
        let arrToJson = JSON.parse(enc.decode(arr));

        let datas = {
            "markets": arrToJson.code, // 마켓
            "trade": numberWithComma(arrToJson.trade_price), // 현재가
            "signed_change_price": numberWithComma(parseFloat(arrToJson.signed_change_price).toFixed(2)), // 전일대비
            "change_price": arrToJson.change_price, // 부호없는 전일 대비
            "signed_change_rate": (arrToJson.signed_change_rate).toFixed(2), // 등락률
            "acc_trade_price": numberWithComma((arrToJson.acc_trade_price / 1000000).toFixed(0)), // 거래량
            "ask_bid": arrToJson.ask_bid
        }

        let scp = (Number(datas.change_price) < 100 && Number(datas.change_price) >= 1) ? datas.signed_change_price : (datas.signed_change_price).toString().slice(0, -3);

        $("#" + arrToJson.code).find(".trade_price").text(datas.trade);
        $("#" + arrToJson.code).find(".prev_price").html(datas.signed_change_rate + "%<br>" + scp);
        $("#" + arrToJson.code).find(".trade_vol").text(datas.acc_trade_price + "백만");

        if (scp > 0) {
            $("#" + arrToJson.code).find(".trade_price").animate({"color": "#eca7bb"}, 500);
            $("#" + arrToJson.code).find(".prev_price").animate({"color": "#eca7bb"}, 500);
            $("#" + arrToJson.code).find(".trade_vol").animate({"color": "#eca7bb"}, 500);
        } else if (scp == 0) {
            $("#" + arrToJson.code).find(".trade_price").animate({"color": "#fff"}, 500);
            $("#" + arrToJson.code).find(".prev_price").animate({"color": "#fff"}, 500);
            $("#" + arrToJson.code).find(".trade_vol").animate({"color": "#fff"}, 500);
        } else {
            $("#" + arrToJson.code).find(".trade_price").animate({"color": "#8ab3e5"}, 500);
            $("#" + arrToJson.code).find(".prev_price").animate({"color": "#8ab3e5"}, 500);
            $("#" + arrToJson.code).find(".trade_vol").animate({"color": "#8ab3e5"}, 500);
        }
    });

    tickerSocket.onerror = ((e) => {
        console.log(e);
    });

});

let numberWithComma = (n) => {
    var parts = n.toString().split(".");

    return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}

let numberToKorean = (number) => {
    var inputNumber  = number < 0 ? false : number;
    var unitWords    = ['', '만', '억', '조', '경'];
    var splitUnit    = 10000;
    var splitCount   = unitWords.length;
    var resultArray  = [];
    var resultString = '';

    for (var i = 0; i < splitCount; i++){
        var unitResult = (inputNumber % Math.pow(splitUnit, i + 1)) / Math.pow(splitUnit, i);
        unitResult = Math.floor(unitResult);
        if (unitResult > 0){
            resultArray[i] = unitResult;
        }
    }

    for (var i = 0; i < resultArray.length; i++){
        if(!resultArray[i]) continue;
        resultString = String(resultArray[i]) + unitWords[i] + resultString;
    }

    return resultString;
}
