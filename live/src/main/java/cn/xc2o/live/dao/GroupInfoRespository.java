package cn.xc2o.live.dao;

import cn.xc2o.live.entity.GroupInfo;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

/**
 * Created by cc on 2017/7/4.
 */
@RepositoryConfig(cacheName = "GroupInfoCache")
public interface GroupInfoRespository extends IgniteRepository<GroupInfo, Long> {
}
