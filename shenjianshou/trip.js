/*
  ��ȡЯ��ĳЩ���ڻ�Ʊ�۸����Ϣ��
  ��Ϊ��Ʊ��Ϣ��js�첽���صģ����Ը�����ʹ������ֵ��Զ�JS��Ⱦ���ܣ�
  ֻ��Ҫ����һ��������enableJS���Ϳ����������Զ�����ҳ������js��Ȼ��ͳ�ȡ��ҳԴ���������һ���򵥵س�ȡ�첽���ص����ݡ�
*/
var fromCity="���� �ɶ� �Ϻ� ���� ���� ���� ���� ���� �Ͼ� �人 ��ɳ ���,";//@input(fromCity,���ڳ�������,���磺����)
var formCityCode=["bjs","CTU","SHA","KMG","XIY","CKG","HGH","XMN","NKG","WUH","CSX","TSN"]
var toCity="���� ����";//@input(toCity,���ڵ������,���磺�Ϻ�)
var toCityCode=["CAN","szx"]

var date="";//@input(date,��������,��ʽ��ο���2016-06-01���粻��д��ʾ����)
var dnum=90;//@input(dnum,��ȡ���������� 2������ �ӿ�ʼ������ȡ2��Ľ��)

// ���������������ڣ�����Ϊ����
if(date===""){
  var currentDate = new Date();
  var year = currentDate.getFullYear();    //��ȡ���������(4λ,1970-????)
  var month = currentDate.getMonth()+1;    //��ȡ��ǰ�·�(0-11,0����1��)
  if(month<10){
      month="0"+month;
  }
  var day = currentDate.getDate();       //��ȡ��ǰ��(1-31)
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
    contentHelperRegexes: [""], // ���ô���������������ҳ�������б�ҳ
    enableJS: false, // ����enableJSΪtrue����ô�����������������ҳ�����Զ�����JS��Ⱦ
    fields: [  // fields������ݶ���js���ɵģ�����js��Ⱦ���ȡ��������ȡ��ҳԴ���������һ����
        {
            name: "flights", // ���fields��ֻ��һ��field���������飩����ʾ��ҳ��ȡ�������ݡ�
            selectorType: SelectorType.JsonPath,
            selector: "$.fis[?(@.axp)]", 
            repeated: true,
            children: [   
                {
                    name: "flight_number",
                    alias: "�����",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.fn",
                    primaryKey: true // primaryKey����Ϊtrue��field��һ����Ϊ������������ȫ��ͬ�����ݻ��Զ�ȥ�ء�ȱʡ��һ��field������
                },
                {
                    name: "dcity",
                    alias: "��������",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dcn"
                },
                {
                    name: "dairport",
                    alias: "��������",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dpbn"
                },{
                    name: "aairport",
                    alias: "�������",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.apbn"
                },
                {
                    name: "acity",
                    alias: "�������",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.acn"
                },
                {
                    name: "dtime",
                    alias: "����ʱ��",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.dt",
                    primaryKey: true // primaryKey����Ϊtrue��field��һ����Ϊ������������ȫ��ͬ�����ݻ��Զ�ȥ�ء�ȱʡ��һ��field������
                },{
                    name: "atime",
                    alias: "����ʱ��",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.at",
                    primaryKey: true // primaryKey����Ϊtrue��field��һ����Ϊ������������ȫ��ͬ�����ݻ��Զ�ȥ�ء�ȱʡ��һ��field������
                },{
                    name: "lowprice",
                    alias: "��ͼ�",
                    selectorType: SelectorType.JsonPath,
                    selector:"$.lp",
                    primaryKey: true // primaryKey����Ϊtrue��field��һ����Ϊ������������ȫ��ͬ�����ݻ��Զ�ȥ�ء�ȱʡ��һ��field������
                },{name:"addDate",alias: "ץȡ����",primaryKey: true}
            ]
        }
    ]
};

configs.beforeCrawl = function(site){
    // ��ȡǰ���Ȼ�ȡ������;ţ�ϵĳ�����
    
    
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
    return false;// ���ٴ�����ҳ�����µ�����
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
  �õ�date��һ���ʱ��
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
