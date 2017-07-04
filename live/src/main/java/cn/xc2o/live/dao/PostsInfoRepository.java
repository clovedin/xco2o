package cn.xc2o.live.dao;

import cn.xc2o.live.entity.PostsInfo;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

/**
 * Created by cc on 2017/7/4.
 */
@RepositoryConfig(cacheName = "PostsInfoCache")
public interface PostsInfoRepository extends IgniteRepository<PostsInfo, Long> {
}
