


# 定义根URL
```Java
public static final String PIXIU_API_URL = "http://127.0.0.1:3770";
 Retrofit retrofit = new Retrofit.Builder().baseUrl(PIXIU_API_URL)......;
 
 ```
 
# 定义接口
可以在里面定义各种动作，包括带参数或不带参数的，支持GET，PUT，DELETE等请求
```Java
public interface PixiuService {

    @GET("/whitelist_policies")
    Call<Pixiu> getWhitelistPolicies();

}
```
则最后访问的完整URL为 http://127.0.0.1:3770/whitelist_policies,
Call后面跟的是对象还是对象的List,具体看url返回值确定，http://127.0.0.1:3770/whitelist_policies返回的是一个对象，而不是链表。
参看 ExampleHandle
```Java
 public String handle(Map<String, String> paramataersAndValues) {
        return Body.whitelistPolicies;
    }
 ```
 Body接口定义如下：
 ```Java
 public interface Body {
    public String whitelistPolicies = "{\"whitelist_policies\":[{\"created_at\":\"2016-07-12 11:52:03\",\"description\":\"\",\"id\":1,"
            + "\"keywords\":[\"white\"],\"match_mode\":\"EXACT\",\"name\":\"关键字白名单\",\"updated_at\":\"2016-07-12 11:52:03\"}],\"meta\":{\"total\":1}}";

}
 ```

# 创建WebService
具体参考 teclan-spark 项目
```Java

private static Handle handle = new ExampleHandle();
private static RestApiService restApiService = new Webservice();


restApiService.createGetRequestService("/whitelist_policies", handle);

...

# 添加转换适配器
```Java

 GsonBuilder builder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

Retrofit retrofit = new Retrofit.Builder().baseUrl(PIXIU_API_URL)
                // 增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create(builder.create()))
                .build();
```
# 创建实例
```Java
  PixiuService pixiuService = retrofit.create(PixiuService.class);
 ```
 
# 指定动作（方法）
```Java
 Call<Pixiu> call = pixiuService.getWhitelistPolicies();
 ```
# 获取返回结果
```Java
Pixiu pixiu  = call.execute().body()；
```

# 处理数据
如果转换没有出错，返回的数据都存在pixiu这个对象中，等待后续处理...





 