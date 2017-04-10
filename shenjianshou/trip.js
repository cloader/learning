/*
  爬取携程某些国内机票价格等信息；
  因为机票信息是js异步加载的，所以该爬虫使用神箭手的自动JS渲染功能；
  只需要设置一个参数‘enableJS’就可以让爬虫自动加载页面所有js，然后和抽取网页源码里的数据一样简单地抽取异步加载的数据。
*/
var fromCity="北京 成都 上海 昆明 西安 重庆 杭州 厦门 南京 武汉 长沙 天津,";//@input(fromCity,国内出发城市,比如：北京)
var formCityCode=["bjs","CTU","SHA","KMG","XIY","CKG","HGH","XMN","NKG","WUH","CSX","TSN"]
var toCity="广州 深圳";//@input(toCity,国内到达城市,比如：上海)
var toCityCode=["CAN","szx"]

var date="";//@input(date,出发日期,格式请参考：2016-06-01，如不填写表示当天)
var dnum=90;//@input(dnum,爬取天数，比如 2，代表 从开始日期爬取2天的结果)

// 如果不输入出发日期，设置为当天
if(date===""){
  var currentDate = new Date();
  var year = currentDate.getFullYear();    //获取完整的年份(4位,1970-????)
  var month = currentDate.getMonth()+1;    //获取当前月份(0-11,0代表1月)
  if(month<10){
      month="0"+month;
  }
  var day = currentDate.getDate();       //获取当前日(1-31)
  if(day<10){
      day="0"+day;
  }
  date=year+"-"+month+"-"+day;
}

var addDate=date;
var configs = {
    domains: ["tuniu.com"],
    scanUrls: [],
    interval : 2000,
    contentHelperRegexes: [""], // 设置待爬队列中所有网页都不是列表页
    enableJS: false, // 设置enableJS为true，那么待爬队列里的所有网页都会自动进行JS渲染
    fields: [  // fields里的数据都是js生成的，开启js渲染后抽取和正常抽取网页源码里的数据一样简单
        {
            name: "flights", // 如果fields里只有一个field（对象数组），表示单页提取多条数据。
            selectorType: SelectorType.JsonPath,
            selector: "$.fis[?(@.axp)]", 
            repeated: true,
            children: [   
                {
                    name: "flight_number",
                    alias: "航班号",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.fn",
                    primaryKey: true // primaryKey设置为true的field会一起作为主键，主键完全相同的数据会自动去重。缺省第一个field是主键
                },
                {
                    name: "dcity",
                    alias: "出发城市",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dcn"
                },
                {
                    name: "dairport",
                    alias: "出发机场",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dpbn"
                },{
                    name: "aairport",
                    alias: "到达机场",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.apbn"
                },
                {
                    name: "acity",
                    alias: "到达城市",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.acn"
                },
                {
                    name: "dtime",
                    alias: "出发时间",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dt",
                    primaryKey: true // primaryKey设置为true的field会一起作为主键，主键完全相同的数据会自动去重。缺省第一个field是主键
                },{
                    name: "atime",
                    alias: "到达时间",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.at",
                    primaryKey: true // primaryKey设置为true的field会一起作为主键，主键完全相同的数据会自动去重。缺省第一个field是主键
                },{
                    name: "lowprice",
                    alias: "最低价",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.lp",
                    primaryKey: true // primaryKey设置为true的field会一起作为主键，主键完全相同的数据会自动去重。缺省第一个field是主键
                },{name:"addDate",alias: "抓取日期",primaryKey: true}
            ]
        }
    ]
};

configs.beforeCrawl = function(site){
    // 爬取前，先获取城市在途牛上的城市码
    
    
     var contentUrl = "";
    for(var i=0;i<formCityCode.length;i++){
        for(var k=0;k<toCityCode.length;k++){
            date=addDate;
           for(var j=0;j<dnum;j++){
             contentUrl="http://flights.ctrip.com/domesticsearch/search/SearchFirstRouteFlights?DCity1="+formCityCode[i]+"&ACity1="+toCityCode[k]+"&SearchType=S&DDate1="+date+"&IsNearAirportRecommond=0";
        		site.addScanUrl(contentUrl,{contextData:date});
        		date=getNextDay(date);
  			  }
       }
    }
    
    /*
    site.addScanUrl("http://flights.ctrip.com/domesticsearch/search/SearchFirstRouteFlights?DCity1=CTU&ACity1=SZX&SearchType=S&DDate1=2017-04-10&IsNearAirportRecommond=0");
    */
    
};
configs.isAntiSpider = function (url, content, page) {
    var data=JSON.parse(content);
    	if(data.fis.length==0)
            return true;
    return false;
};

configs.onProcessContentPage = function(page, content, site){
    return false;// 不再从内容页发现新的链接
};
configs.onProcessScanPage = function (page, content, site) {
    
    return false;
};
configs.onProcessHelperPage = function (page, content, site) {
    
    return false;
};

configs.afterExtractField = function(fieldName, data, page){
    if(fieldName=="flights.addDate")
        return addDate;
    return data;
};

/*
  得到date后一天的时间
*/
function getNextDay(date){
    var timestamp = Date.parse(date);
    timestamp = timestamp + 1000*60*60*24;
    date = new Date(timestamp);
    var month=date.getMonth()+1;
    if(month<9){
        month="0"+month;
    }
    var day=date.getDate();
    if(day<10)
        day="0"+day;
    return date.getFullYear()+"-"+month+"-"+day;
}

var crawler = new Crawler(configs);
crawler.start();
