namespace java com.nathan.thrift

enum RequestType {
   SAY_HELLO,   //问好
   QUERY_TIME,  //询问时间
}

struct Request {
   1: required RequestType type;  // 请求的类型，必选
   2: required string name;       // 发起请求的人的名字，必选
   3: optional i32 age;           // 发起请求的人的年龄，可选
}

exception RequestException {
   1: required i32 code;
   2: optional string reason;
}

// 服务名
service HelloWordService {
   string doAction(1: Request request) throws (1:RequestException qe); // 可能抛出异常。
}