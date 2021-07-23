$(() => {
    let krwMarkets = [];

    $.ajax({
        url: "https://api.upbit.com/v1/market/all?isDetails=false",
        type: "get",
        async: false,
        success: (data) => {
            krwMarkets = data.filter((n) => {
                return (n.market).split("-")[0] == "KRW";
            });
        }
    });

    krwMarkets.forEach((v, k) => {
        markets.push(v.market);
        $("#markets_tb").find("tbody").append(`
            <tr id="${v.market}">
                <td class="coin_name text-left">${v.korean_name}<br><span style="font-size:0.7em;">${v.market}</span></td>
                <td class="trade_price text-right"></td>
                <td class="prev_price text-right"></td>
                <td class="trade_vol text-right"></td>
            </tr>
        `);
    });

    console.log(markets);

});