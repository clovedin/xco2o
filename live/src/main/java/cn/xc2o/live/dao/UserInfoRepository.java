package cn.xc2o.live.dao;

import cn.xc2o.live.entity.UserInfo;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

/**
 * Created by cc on 2017/7/4.
 */
@RepositoryConfig(cacheName = "UserInfoCache")
public interface UserInfoRepository extends IgniteRepository<UserInfo, Long> {
}
