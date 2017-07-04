package cn.xc2o.live.service;

import cn.xc2o.live.dto.PostsCreateReq;
import cn.xc2o.live.dto.PostsCreateRsp;
import cn.xc2o.live.common.Result;
import cn.xc2o.live.vo.PostsDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by cc on 2017/7/4.
 */
public interface PostsService {

    /**
     * 发帖
     * @param groupId
     * @param req
     * @return
     */
    Result<PostsCreateRsp> posts(Long userId, Long groupId, PostsCreateReq req);

    /**
     * 看帖
     * @param group
     * @param id
     * @return
     */
    Result<PostsDetailVo> detail(Long group, Long id, Pageable pageable);
}
