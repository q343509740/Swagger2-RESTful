# SpringBoot中使用Swagger2构建RESTful API


<a name="overview"></a>
## Overview
更多资料, 请查看: https://blog.csdn.net/q343509740


### Version information
*Version* : 1.0


### Contact information
*Contact* : Ray


### URI scheme
*Host* : localhost:8080  
*BasePath* : /


### Tags

* user-controller : user控制器




<a name="paths"></a>
## Paths

<a name="postuserusingpost"></a>
### 创建用户
```
POST /users/
```


#### Description
根据User对象创建用户


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Query**|**age**  <br>*optional*|用户年龄|ref|
|**Query**|**id**  <br>*required*|用户编号(必填)|integer (int64)|
|**Query**|**name**  <br>*optional*|用户名称|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* user-controller


<a name="getuserlistusingget"></a>
### 获取用户列表
```
GET /users/
```


#### Description
获取所有用户列表


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [User](#user) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* user-controller


<a name="getuserusingget"></a>
### 获取用户详细信息
```
GET /users/{id}
```


#### Description
根据url的id来获取用户详细信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|用户编号(必填)|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[User](#user)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `*/*`


#### Tags

* user-controller


<a name="putuserusingput"></a>
### 更新用户详细信息
```
PUT /users/{id}
```


#### Description
根据url的id来指定更新的对象,并根据传过来的user信息来更新用户详细信息


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|用户编号(必填)|integer (int64)|
|**Query**|**age**  <br>*optional*|用户年龄|ref|
|**Query**|**name**  <br>*optional*|用户名称|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* user-controller


<a name="deleteuserusingdelete"></a>
### 删除用户
```
DELETE /users/{id}
```


#### Description
根据url的id来指定删除的对象


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|用户编号(必填)|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `*/*`


#### Tags

* user-controller




<a name="definitions"></a>
## Definitions

<a name="user"></a>
### User

|Name|Schema|
|---|---|
|**age**  <br>*optional*|integer (int32)|
|**id**  <br>*optional*|integer (int64)|
|**name**  <br>*optional*|string|





