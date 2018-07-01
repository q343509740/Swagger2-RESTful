package com.ray.chapter315.controller;

import com.ray.chapter315.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Ray
 * @date 2018/7/1 0001
 * 我们通过@ApiOperation注解来给API增加说明
 * 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明
 */
@Api(value = "UserController", description = "user控制器")
@RestController
@RequestMapping(value = "/users") // 通过这里配置使下面的映射都在/users下，可去
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 处理"/users/" 的GET请求,用来获取用户列表
     * 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
     */
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> list = new ArrayList<>(users.values());
        return list;
    }

    /**
     * 处理"/users/" 的POST请求,用来创建User
     * 除了@ModelAttribute绑定参数之外,还可以通过@RequestParam从页面中传递参数
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号(必填)", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户年龄", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户实体User(不填: 默认值)", dataType = "User", defaultValue = "User"),
    })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 处理"/users/{id}" 的GET请求,用来获取url中id值得User信息
     * url中的id可通过@PathVariable绑定到函数的参数中
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户编号(必填)", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    /**
     * 处理"/users/{id}" 的PUT请求, 用来更新User信息
     */
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新的对象,并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号(必填)", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "用户年龄", dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户实体User(不填: 默认值)", dataType = "User", defaultValue = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    /**
     * 处理"/users/{id}" 的DELETE请求,用来删除User
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除的对象")
    @ApiImplicitParam(name = "id", value = "用户编号(必填)", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
