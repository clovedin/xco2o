package cn.xc2o.live.controller;

import cn.xc2o.live.dto.PostsCreateDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 2017/7/3.
 */
@RestController
@RequestMapping("/posts")
public class PostsController {

    @RequestMapping(value = "/{group}", method = RequestMethod.GET)
    public void list(@PathVariable Long group, Pageable pageable){

    }

    @RequestMapping(value = "/{group}", method = RequestMethod.POST)
    public void create(@PathVariable Long group, PostsCreateDto dto){

    }

    @RequestMapping(value = "/{group}/{id}", method = RequestMethod.GET)
    public void detail(@PathVariable Long group, @PathVariable Long id){

    }

    @RequestMapping(value = "/{group}/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long group, @PathVariable Long id){

    }

}
