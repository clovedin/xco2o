package cn.xc2o.live.controller;

import cn.xc2o.live.common.LiveConstant;
import cn.xc2o.live.common.ResultConstant;
import cn.xc2o.live.dto.PostsCreateReq;
import cn.xc2o.live.dto.PostsCreateRsp;
import cn.xc2o.live.service.PostsService;
import cn.xc2o.live.common.Result;
import cn.xc2o.live.vo.PostsDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by cc on 2017/7/3.
 */
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @RequestMapping(value = "/{group}", method = RequestMethod.GET)
    public void list(@PathVariable Long group, Pageable pageable){

    }

    @RequestMapping(value = "/{group}", method = RequestMethod.POST)
    public Result<PostsCreateRsp> posts(HttpSession session, @PathVariable Long group, PostsCreateReq req){
        Result<PostsCreateRsp> result = new Result<>();
        Object seessionAttr = session.getAttribute(LiveConstant.LoginUserId);
        if (null == seessionAttr){
            Long userId = (Long)seessionAttr;
            result = postsService.posts(userId, group, req);
        }else {
            result.setError(ResultConstant.NotLogin);
        }
        return result;
    }

    @RequestMapping(value = "/{group}/{id}", method = RequestMethod.GET)
    public Result<PostsDetailVo> detail(@PathVariable Long group, @PathVariable Long id, Pageable pageable){
        return postsService.detail(group, id, pageable);
    }

    @RequestMapping(value = "/{group}/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long group, @PathVariable Long id){
        return;
    }

}
