package cn.xc2o.live.dao;

import cn.xc2o.live.entity.PostsReply;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by cc on 2017/7/4.
 */
@RepositoryConfig(cacheName = "PostsReplyCache")
public interface PostsReplyRepository extends IgniteRepository<PostsReply, Long> {

    List<PostsReply> findByPostsId(Long postsId, Pageable pageable);

    Long countByPostsId(Long id);
}
